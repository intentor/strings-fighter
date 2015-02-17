using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;

namespace HitboxCreator.Core
{
    /// <summary>
    /// Representa um frame de sprite.
    /// </summary>
    public class SpriteFrame
    {
        /// <summary>
        /// Cria um novo frame de sprite.
        /// </summary>
        /// <param name="frameNumber">Número do frame.</param>
        /// <param name="spriteImage">Imagem do sprite.</param>
        /// <param name="positionOnSprite">Posição da imagem no sprite.</param>
        public SpriteFrame(int frameNumber, Image spriteImage, Rectangle positionOnSprite)
        {
            this.FrameNumber = frameNumber;
            _spriteImage = spriteImage;
            this.PositionOnSprite = positionOnSprite;
            this.HitBoxes = new List<Hitbox>();
        }

        private Image _spriteImage;

        /// <summary>
        /// Número do frame.
        /// </summary>
        public int FrameNumber
        {
            get;
            set;
        }

        /// <summary>
        /// Imagem do sprite.
        /// </summary>
        public Image SpriteImage
        {
            get { return (Image)_spriteImage.Clone(); }
        }

        /// <summary>
        /// Posição da imagem no sprite.
        /// </summary>
        public Rectangle PositionOnSprite
        {
            get;
            set;
        }

        /// <summary>
        /// Hitboxes do frame.
        /// </summary>
        public List<Hitbox> HitBoxes
        {
            get;
            set;
        }
    }
}
