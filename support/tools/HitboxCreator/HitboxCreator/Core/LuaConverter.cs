using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;
using System.Text.RegularExpressions;
using System.Drawing;

namespace HitboxCreator.Core
{
    /// <summary>
    /// Conversor de dados para scripts em Lua.
    /// </summary>
    public class LuaConverter
    {
        #region Métodos

        #region Private

        /// <summary>
        /// Obtém o nome da função Lua utilizada para obtenção das hitboxes
        /// conforme o nome do arquivo de sprites.
        /// </summary>
        /// <param name="fileName">Nome do arquivo de sprites.</param>
        /// <returns></returns>
        private string ResolveLuaMethodName(string fileName)
        {
            string method = String.Empty;

            switch (fileName)
            {
                case "dying.png":
                    method = "getHitboxesForDying";
                    break;

                case "stopped.png":
                    method = "getHitboxesForStopped";
                    break;

                case "walking.png":
                    method = "getHitboxesForWalking";
                    break;

                case "jumping.png":
                    method = "getHitboxesForJumping";
                    break;

                case "defending.png":
                    method = "getHitboxesForDefending";
                    break;

                case "damage.png":
                    method = "getHitboxesForDamage";
                    break;

                case "low-punch.png":
                    method = "getHitboxesForLowPunch";
                    break;

                case "high-punch.png":
                    method = "getHitboxesForHighPunch";
                    break;

                case "low-kick.png":
                    method = "getHitboxesForLowKick";
                    break;

                case "high-kick.png":
                    method = "getHitboxesForHighKick";
                    break;
            }


            return method;
        }

        /// <summary>
        /// Obtém o código Lua de colisão.
        /// </summary>
        /// <param name="frames">Frames do sprite.</param>
        /// <returns>Código Lua gerado.</returns>
        private string GetCollisionCode(List<SpriteFrame> frames)
        {
            StringBuilder sb = new StringBuilder();
            sb.Append("\t\tLuaHitboxData = luajava.bindClass(\"core.scripts.lua.LuaHitboxData\");\n");
            sb.Append("\t\thb = luajava.new(LuaHitboxData)\n");

            foreach (var frame in frames)
            {
                sb.Append("\n\t\ti = hb:createFrame();\n");
                var hbs = frame.HitBoxes.OrderByDescending(obj => obj.Type);

                foreach (var hb in hbs)
                {
                    sb.AppendFormat("\t\thb:addHitbox(i, {0}, {1}, {2}, {3}, {4});\n"
                        , hb.Bounds.X
                        , hb.Bounds.Y
                        , hb.Bounds.Width
                        , hb.Bounds.Height
                        , (int)hb.Type);
                }
            }

            sb.Append("\n\t\treturn hb;\n");

            return sb.ToString();
        }

        /// <summary>
        /// Obtém a expressão regular da função de configuração de hitboxes do sprite atual.
        /// </summary>
        /// <returns>Expressão regular para obtenção da função de configuração de hitboxes do sprite atual.</returns>
        private string GetRegexPatternForCurrentFunction(string fileName)
        {
            string method = this.ResolveLuaMethodName(fileName);
            string pattern = @"(?<function>" + method + @"\s?=\s?function\(\))(?<contents>([\S]|[\s])*?)(?<end>end;)";
            return pattern;
        }

        #endregion

        #region Public

        /// <summary>
        /// Salva informações de colisão.
        /// </summary>
        /// <param name="frames">Frames do sprite.</param>
        /// <param name="fileName">Nome do arquivo de sprites para avaliação do nome do método.</param>
        /// <param name="path">Caminho do arquivo Lua para salvamento dos dados.</param>
        public void SaveCollisionData(List<SpriteFrame> frames, string fileName, string path)
        {
            string pattern = this.GetRegexPatternForCurrentFunction(fileName);
            string contents = String.Empty;

            using (StreamReader sr = new StreamReader(path))
            {
                contents = sr.ReadToEnd();
            }

            using (StreamWriter sw = new StreamWriter(path, false))
            {
                string code = this.GetCollisionCode(frames);
                string replacement = "${function}\n" + code + "\t${end}";
                contents = Regex.Replace(contents, pattern, replacement);

                sw.Write(contents);
            }
        }

        /// <summary>
        /// Carrega dados de colisão.
        /// </summary>
        /// <param name="frames">Frames do sprite.</param>
        /// <param name="fileName">Nome do arquivo de sprites para avaliação do nome do método.</param>
        /// <param name="path">Caminho do arquivo Lua para obtenção dos dados.</param>
        /// <returns>Lista de frames do sprite.</returns>
        public List<SpriteFrame> LoadCollisionData(List<SpriteFrame> frames, string fileName, string path)
        {
            //Inicia contador de frame com 1.
            int i = -1;

            //Limpa as hitboxes do frame atual.
            foreach (var frame in frames) frame.HitBoxes.Clear();

            //Obtém as hitboxes.
            using (StreamReader reader = new StreamReader(path))
            {
                string pattern = this.GetRegexPatternForCurrentFunction(fileName);
                Match mContents = Regex.Match(reader.ReadToEnd(), pattern);

                if (mContents.Success)
                {
                    using (StringReader sr = new StringReader(mContents.Groups["contents"].Value))
                    {
                        string line;
                        while ((line = sr.ReadLine()) != null)
                        {
                            if (line.IndexOf("createFrame()") > 0) i++;
                            else if (line.IndexOf("addHitbox") > 0)
                            {
                                Match m = Regex.Match(line, @"hb:addHitbox\(i, (?<x>\d+), (?<y>\d+), (?<width>\d+), (?<height>\d+), (?<type>\d+)\);");

                                if (m.Success)
                                {
                                    int x = Convert.ToInt32(m.Groups["x"].Value);
                                    int y = Convert.ToInt32(m.Groups["y"].Value);
                                    int width = Convert.ToInt32(m.Groups["width"].Value);
                                    int height = Convert.ToInt32(m.Groups["height"].Value);
                                    HitboxType type = (HitboxType)Convert.ToInt32(m.Groups["type"].Value);
                                    Rectangle bounds = new Rectangle(x, y, width, height);

                                    frames[i].HitBoxes.Add(new Hitbox(bounds, type));
                                }
                            }
                        }
                    }
                }
            }

            return frames;
        }

        #endregion

        #endregion
    }
}
