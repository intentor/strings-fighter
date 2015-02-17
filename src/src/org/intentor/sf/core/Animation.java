package org.intentor.sf.core;

import org.newdawn.slick.Image;

/**
 * Objeto de anima��es do jogo.
 */
public class Animation extends org.newdawn.slick.Animation {
	
	/**
	 * Cria uma nova anima��o.
	 * @param images	Imagens que comp�em a anima��o.
	 * @param duration	Dura��o �nica de cada quadro da anima��o.
	 * @param hitboxes	Hitboxes de cada quadro da anima��o.
	 */
	public Animation(Image[] images, int duration, Hitbox[][] hitboxes)
	{
		super(images, duration);
		this.hb = hitboxes;
	}
	
	/**
	 * Cria uma nova anima��o.
	 * @param images	Imagens que comp�em a anima��o.
	 * @param duration	Dura��o de cada quadro da anima��o.
	 * @param hitboxes	Hitboxes de cada quadro da anima��o.
	 */
	public Animation(Image[] images, int[] duration, Hitbox[][] hitboxes)
	{
		super(images, duration);
		this.hb = hitboxes;
	}
	
	/**
	 * Hitboxes da anima��o.
	 */
	private Hitbox[][] hb;
	
	/**
	 * Hitboxes da anima��o.
	 * @return Matriz de hitboxes.
	 */
	public Hitbox[][] hitboxes() {
		return this.hb;
	}
	
	/**
	 * Obt�m as hitboxes do frame atual.
	 * @return
	 */
	public Hitbox[] currentHitboxes() {
		return this.hb[this.getFrame()];
	}
}
