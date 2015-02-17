package org.intentor.sf.core;

import org.newdawn.slick.Image;

/**
 * Objeto de animações do jogo.
 */
public class Animation extends org.newdawn.slick.Animation {
	
	/**
	 * Cria uma nova animação.
	 * @param images	Imagens que compõem a animação.
	 * @param duration	Duração única de cada quadro da animação.
	 * @param hitboxes	Hitboxes de cada quadro da animação.
	 */
	public Animation(Image[] images, int duration, Hitbox[][] hitboxes)
	{
		super(images, duration);
		this.hb = hitboxes;
	}
	
	/**
	 * Cria uma nova animação.
	 * @param images	Imagens que compõem a animação.
	 * @param duration	Duração de cada quadro da animação.
	 * @param hitboxes	Hitboxes de cada quadro da animação.
	 */
	public Animation(Image[] images, int[] duration, Hitbox[][] hitboxes)
	{
		super(images, duration);
		this.hb = hitboxes;
	}
	
	/**
	 * Hitboxes da animação.
	 */
	private Hitbox[][] hb;
	
	/**
	 * Hitboxes da animação.
	 * @return Matriz de hitboxes.
	 */
	public Hitbox[][] hitboxes() {
		return this.hb;
	}
	
	/**
	 * Obtém as hitboxes do frame atual.
	 * @return
	 */
	public Hitbox[] currentHitboxes() {
		return this.hb[this.getFrame()];
	}
}
