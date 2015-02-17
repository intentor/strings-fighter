using System;
using System.Drawing;

namespace HitboxCreator.Core
{
    /// <summary>
    /// Representa uma hitbox.
    /// </summary>
    public sealed class Hitbox
    {
        /// <summary>
        /// Cria uma nova hitbox.
        /// </summary>
        /// <param name="bounds">Retânglo da hitbox.</param>
        /// <param name="type">Tipo da hitbox.</param>
        public Hitbox(Rectangle bounds, HitboxType type)
        {
            this.Bounds = bounds;
            this.Type = type;
        }

        /// <summary>
        /// Retânglo da hitbox.
        /// </summary>
        public Rectangle Bounds
        {
            get;
            set;
        }

        /// <summary>
        /// Tipo da hitbox.
        /// </summary>
        public HitboxType Type
        {
            get;
            set;
        }
    }
}
