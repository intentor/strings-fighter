using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Drawing.Imaging;
using System.Drawing.Drawing2D;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using HitboxCreator.Core;
using System.IO;

namespace HitboxCreator
{
    /// <summary>
    /// Formulário para gerenciamento de criação de hitboxes.
    /// </summary>
    public partial class frmManager : Form
    {
        #region Campos

        /// <summary>
        /// Caminho do sprite carregado.
        /// </summary>
        private string _spritePath;

        /// <summary>
        /// Sprite carregado.
        /// </summary>
        private Bitmap _sprite;
      
        /// <summary>
        /// Largura dos frames.
        /// </summary>
        private int _frameWidth;

        /// <summary>
        /// Altura dos frames.
        /// </summary>
        private int _frameHeight;

        /// <summary>
        /// Frame atual.
        /// </summary>
        private int _currentFrame;

        /// <summary>
        /// Retângulo atual em desenho.
        /// </summary>
        private Rectangle _currentRectangle;

        /// <summary>
        /// Tipo atual da hitbox.
        /// </summary>
        private HitboxType _currentType = HitboxType.HitX1;

        /// <summary>
        /// Índice atual a ser selecionado.
        /// </summary>
        private int? _currentIndex;

        /// <summary>
        /// Frames do sprite.
        /// </summary>
        private List<SpriteFrame> _frames;

        #endregion

        #region Construtor

        public frmManager()
        {
            InitializeComponent();
        }

        #endregion

        #region Manipulação de eventos

        private void frmManager_Load(object sender, EventArgs e)
        {
            this.AskForLuaScript();
            this.AskForSprite();
        }

        private void btnLoadSprite_Click(object sender, EventArgs e)
        {
            this.AskForSprite();
        }

        private void btnGetLuaScriptPath_Click(object sender, EventArgs e)
        {
            this.AskForLuaScript();
        }

        private void btnLoadHitboxes_Click(object sender, EventArgs e)
        {
            if (String.IsNullOrEmpty(this.txtLuaScript.Text) ||
                !File.Exists(this.txtLuaScript.Text))
            {
                MessageBox.Show("The Lua script file was not defined or doesn't exist.");
                return;
            }

            this.LoadHitboxes();
        }

        private void btnSaveHitboxes_Click(object sender, EventArgs e)
        {
            if (String.IsNullOrEmpty(this.txtLuaScript.Text) ||
                !File.Exists(this.txtLuaScript.Text))
            {
                MessageBox.Show("The Lua script file was not defined or doesn't exist.");
                return;
            }

            LuaConverter converter = new LuaConverter();
            string spriteFileName = Path.GetFileName(_spritePath);
            converter.SaveCollisionData(_frames, spriteFileName, this.txtLuaScript.Text);

            this.lblInfo.Text = "Hitboxes successfully saved to Lua script.";
        }

        private void btnSaveCurrentHitBox_Click(object sender, EventArgs e)
        {
            if (_currentRectangle != Rectangle.Empty)
            {
                _frames[_currentFrame - 1].HitBoxes.Add(new Hitbox(_currentRectangle, _currentType));
                _currentRectangle = Rectangle.Empty;
                this.SetCurrentFrame();
                this.LoadHitboxesList();

                this.lblInfo.Text = "Hitbox saved.";
            }
        }

        private void lstHitboxes_SelectedIndexChanged(object sender, EventArgs e)
        {
            _currentIndex = ((ListBoxItem)this.lstHitboxes.SelectedItem).Index;
            this.SetCurrentFrame();
        }

        #region Frames buttons

        private void btnFirstFrame_Click(object sender, EventArgs e)
        {
            _currentFrame = 1;
            _currentIndex = null;
            this.SetCurrentFrame();
            this.LoadHitboxesList();
        }

        private void btnPreviousFrame_Click(object sender, EventArgs e)
        {
            if (_currentFrame > 1)
            {
                _currentFrame--;
                _currentIndex = null;
                this.SetCurrentFrame();
                this.LoadHitboxesList();
            }
        }

        private void btnNextFrame_Click(object sender, EventArgs e)
        {
            if (_currentFrame < this.GetTotalFramesCount())
            {
                _currentFrame++;
                _currentIndex = null;
                this.SetCurrentFrame();
                this.LoadHitboxesList();
            }
        }

        private void btnLastFrame_Click(object sender, EventArgs e)
        {
            _currentFrame = this.GetTotalFramesCount();
            _currentIndex = null;
            this.SetCurrentFrame();
        }

        #endregion

        #region Radio buttons

        private void rdbHit0_CheckedChanged(object sender, EventArgs e)
        {
            if (((RadioButton)sender).Checked) _currentType = HitboxType.HitX0;
        }

        private void rdbHit1_CheckedChanged(object sender, EventArgs e)
        {
            if (((RadioButton)sender).Checked) _currentType = HitboxType.HitX1;
        }

        private void rdbHit15_CheckedChanged(object sender, EventArgs e)
        {
            if (((RadioButton)sender).Checked) _currentType = HitboxType.HitX1_5;
        }

        private void rdpHit2_CheckedChanged(object sender, EventArgs e)
        {
            if (((RadioButton)sender).Checked) _currentType = HitboxType.HitX2;
        }

        private void rdbLowPunch_CheckedChanged(object sender, EventArgs e)
        {
            if (((RadioButton)sender).Checked) _currentType = HitboxType.LowPunch;
        }

        private void rdbHighPunch_CheckedChanged(object sender, EventArgs e)
        {
            if (((RadioButton)sender).Checked) _currentType = HitboxType.HighPunch;
        }

        private void rdbLowKick_CheckedChanged(object sender, EventArgs e)
        {
            if (((RadioButton)sender).Checked) _currentType = HitboxType.LowKick;
        }

        private void rdbHighKick_CheckedChanged(object sender, EventArgs e)
        {
            if (((RadioButton)sender).Checked) _currentType = HitboxType.HighKick;
        }

        private void rdbDefense_CheckedChanged(object sender, EventArgs e)
        {
            if (((RadioButton)sender).Checked) _currentType = HitboxType.Defense;
        }

        #endregion

        #region Listbox buttons

        private void btnRemoveHitbox_Click(object sender, EventArgs e)
        {
            if (this.lstHitboxes.SelectedItem != null)
            {
                _frames[_currentFrame - 1].HitBoxes.RemoveAt(((ListBoxItem)this.lstHitboxes.SelectedItem).Index);
                this.LoadHitboxesList();
                this.SetCurrentFrame();

                this.lblInfo.Text = "Hitbox removed.";
            }
        }

        #endregion

        #region Picture

        private void picCurrentSprite_MouseMove(object sender, MouseEventArgs e)
        {
            this.lblMousePosition.Text = String.Format("Mouse ({0},{1})", e.X, e.Y);

            if (e.Button == MouseButtons.Left)
            {
                _currentRectangle.Width = e.X - _currentRectangle.X;
                _currentRectangle.Height = e.Y - _currentRectangle.Y;

                this.SetCurrentFrame();
            }
        }

        private void picCurrentSprite_MouseDown(object sender, MouseEventArgs e)
        {
            _currentRectangle = new Rectangle(e.X, e.Y, 0, 0);
        }

        #endregion

        #endregion

        #region Métodos

        /// <summary>
        /// Solicita localização de script Lua.
        /// </summary>
        private void AskForLuaScript()
        {
            this.opfLuaScript.ShowDialog(this);
            this.txtLuaScript.Text = this.opfLuaScript.FileName;
        }

        /// <summary>
        /// Solicita carregamento de um sprite.
        /// </summary>
        private void AskForSprite()
        {
            this.opfSprite.ShowDialog(this);
            this._spritePath = this.opfSprite.FileName;
            _frameWidth = Convert.ToInt32(this.txtWidth.Text);
            _frameHeight = Convert.ToInt32(this.txtHeight.Text);

            this.LoadSprite();
            this.LoadHitboxes();
        }

        /// <summary>
        /// Carrega um novo sprite.
        /// </summary>
        private void LoadSprite()
        {
            _sprite = new Bitmap(_spritePath);
            this.picCurrentSprite.Width = _frameWidth;
            this.picCurrentSprite.Height = _frameHeight;
            this.txtFrameCount.Text = this.GetTotalFramesCount().ToString();

            this.LoadFrames();
            _currentFrame = 1;
            this.SetCurrentFrame();
            this.LoadHitboxesList();
        }

        /// <summary>
        /// Carrega hitboxes do jogo.
        /// </summary>
        private void LoadHitboxes()
        {
            if (String.IsNullOrEmpty(this.txtLuaScript.Text)) return;

            LuaConverter converter = new LuaConverter();
            string spriteFileName = Path.GetFileName(_spritePath);
            _frames = converter.LoadCollisionData(_frames, spriteFileName, this.txtLuaScript.Text);

            this.SetCurrentFrame();
            this.LoadHitboxesList();

            this.lblInfo.Text = "Hitboxes successfully loaded from Lua script.";
        }

        /// <summary>
        /// Obtém o número total de frames do sprite.
        /// </summary>
        /// <returns>Número total de frames do sprite.</returns>
        private int GetTotalFramesCount()
        {
            int qtX = _sprite.Width / _frameWidth;
            int qtY = _sprite.Height / _frameHeight;

            return qtX * qtY;
        }

        /// <summary>
        /// Carrega todos os frames do sprite.
        /// </summary>
        private void LoadFrames()
        {
            int totalFrames = this.GetTotalFramesCount();
            _frames = new List<SpriteFrame>(totalFrames);
            int x = 0;
            int y = 0;

            for (int i = 0; i < totalFrames; i++)
            {
                var position = new Rectangle(x, y, _frameWidth, _frameHeight);
                var img = _sprite.Clone(position, _sprite.PixelFormat);
                _frames.Add(new SpriteFrame(i + 1, img, position));

                x += _frameWidth;
                if (x >= _sprite.Width)
                {
                    x = 0;
                    y += _frameHeight;
                }
            }
        }

        /// <summary>
        /// Exibe o frame atual, desenhando todos os seus retângulos.
        /// </summary>
        private void SetCurrentFrame()
        {
            this.lstHitboxes.DisplayMember = "HitboxInfo";
            this.lstHitboxes.ValueMember = "Index";

            var frame = _frames[_currentFrame - 1];
            var img = frame.SpriteImage;

            //Desenha os retângulos das hitboxes criadas.
            using (Graphics g = Graphics.FromImage(img)) 
            {
                if (_currentRectangle != Rectangle.Empty)
                {
                    Brush b1 = new SolidBrush(Util.GetColor(_currentType));
                    g.FillRectangle(b1, _currentRectangle);
                }

                for (int i = 0; i < frame.HitBoxes.Count; i++)
                {
                    var box = frame.HitBoxes[i];

                    //Desenha o retângulo.
                    Brush b = new SolidBrush(Util.GetColor(box.Type));
                    g.FillRectangle(b, box.Bounds);
                    
                    //Se o retângulo atual for selecionado, exibe-o.
                    if (_currentIndex.HasValue && _currentIndex.Value == i)
                    {
                        Pen p = new Pen(Color.Red);
                        g.DrawRectangle(p, box.Bounds);
                    }
                }
            }

            this.picCurrentSprite.Image = img;
            this.txtCurrentFrame.Text = _currentFrame.ToString();
        }

        /// <summary>
        /// Preenche a lista de hitboxes.
        /// </summary>
        private void LoadHitboxesList()
        {
            this.lstHitboxes.Items.Clear();
            var frame = _frames[_currentFrame - 1];

            for (int i = 0; i < frame.HitBoxes.Count; i++)
            {
                var box = frame.HitBoxes[i];

                //Preenche os dados das hitboxes na ListBox.
                this.lstHitboxes.Items.Add(new ListBoxItem(box.Type.ToString(), i));

                if (_currentIndex.HasValue && _currentIndex.Value == i) this.lstHitboxes.SelectedIndex = i;
            }

        }

        #endregion
    }
}
