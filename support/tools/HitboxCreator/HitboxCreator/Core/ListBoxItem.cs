using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace HitboxCreator.Core
{
    /// <summary>
    /// Representa um item de ListBox.
    /// </summary>
    public class ListBoxItem
    {
        /// <summary>
        /// Cria um novo item de ListBox.
        /// </summary>
        /// <param name="hitboxInfo">Informações da hitbox.</param>
        /// <param name="index">Índice da hitbox na lista de hitboxes.</param>
        public ListBoxItem(string hitboxInfo, int index)
        {
            this.HitboxInfo = hitboxInfo;
            this.Index = index;
        }

        /// <summary>
        /// Informações da hitbox.
        /// </summary>
        public string HitboxInfo
        {
            get;
            set;
        }

        /// <summary>
        /// Índice da hitbox na lista de hitboxes.
        /// </summary>
        public int Index
        {
            get;
            set;
        }
    }
}
