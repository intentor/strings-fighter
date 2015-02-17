package org.intentor.sf.core;

import org.newdawn.slick.geom.Rectangle;

/**
 * Representa uma hitbox.
 */
public class Hitbox {

	/**
	 * Ret�nglo da hitbox.
	 */
	private Rectangle bounds;

	/**
	 * Tipo da hitbox.
	 */
	private HitboxType type;
	
	/**
	 *  Cria uma nova hitbox.
	 * @param bounds	Ret�nglo da hitbox.
	 * @param type		Tipo da hitbox.
	 */
	public Hitbox(Rectangle bounds, HitboxType type)
    {
        this.bounds = bounds;
        this.type = type;
    }
	
	/**
	 * Ret�nglo da hitbox.
	 * @return Objeto Rectangle.
	 */
	public Rectangle getBounds() {
		return bounds;
	}

	/**
	 * Tipo da hitbox.
	 * @return Objeto HitboxType.
	 */
	public HitboxType getType() {
		return type;
	}
}
