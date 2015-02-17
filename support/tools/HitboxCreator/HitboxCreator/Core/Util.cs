using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Drawing;

namespace HitboxCreator.Core
{
    /// <summary>
    /// Procedimentos de apoio.
    /// </summary>
    public static class Util
    {
        /// <summary>
        /// Obtém a cor de um determinado tipo de hitbox.
        /// </summary>
        /// <param name="type">Tipo da hitbox.</param>
        /// <returns>Cor da hitbox.</returns>
        public static Color GetColor(HitboxType type)
        {
            Color c = default(Color);

            switch (type)
            {
                case HitboxType.HitX0:
                    c = Color.FromArgb(99, ColorTranslator.FromHtml("#CDC673"));
                    break;

                case HitboxType.HitX1:
                    c = Color.FromArgb(30, ColorTranslator.FromHtml("#0000FF"));
                    break;

                case HitboxType.HitX1_5:
                    c = Color.FromArgb(60, ColorTranslator.FromHtml("#0000FF"));
                    break;

                case HitboxType.HitX2:
                    c = Color.FromArgb(90, ColorTranslator.FromHtml("#0000FF"));
                    break;

                case HitboxType.LowPunch:
                    c = Color.FromArgb(60, ColorTranslator.FromHtml("#FF0000"));
                    break;

                case HitboxType.HighPunch:
                    c = Color.FromArgb(95, ColorTranslator.FromHtml("#FF0000"));
                    break;

                case HitboxType.LowKick:
                    c = Color.FromArgb(60, ColorTranslator.FromHtml("#8B1A1A"));
                    break;

                case HitboxType.HighKick:
                    c = Color.FromArgb(95, ColorTranslator.FromHtml("#8B1A1A"));
                    break;

                case HitboxType.Defense:
                    c = Color.FromArgb(80, ColorTranslator.FromHtml("#00FF00"));
                    break;
            }

            return c;
        }
    }
}
