package org.intentor.sf.core;

import java.awt.Point;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

/**
 * Contém procedimentos de debug.
 */
public final class Debug {
	/**
	 * Desenha as hitboxes em modo de debug.
	 * @param g			Objeto Graphics usado para desenho.
	 * @param hitboxes	Hitboxes a serem desenhadas.
	 * @param p			Localização do personagem.
	 * @param invert	Indica se os retângulos devem ser invertidos.
	 */
	public static void drawHitboxes(Graphics g, Hitbox[] hitboxes, Point p, boolean invert, int width) {
		for (Hitbox b : hitboxes) {
			Rectangle r = b.getBounds();
			if (invert) r = Util.invertRectangle(r, width);
			
			g.setColor(getHitboxColor(b.getType()));
			g.fillRect(p.x + r.getX(), p.y + r.getY(), r.getWidth(), r.getHeight());
		}
	}
	
	/**
	 * Obtém a cor baseado no tipo da hit
	 * @param type
	 * @return
	 */
	private static Color getHitboxColor(HitboxType type) {
		Color c;

        switch (type)
        {
        	case HitX0:
	            c = Color.decode("#FFFACD");
	            c.a = 0.8f;
            break;
            
            case HitX1:
                c = Color.decode("#0000FF");
                c.a = 0.3f;
                break;

            case HitX1_5:
                c = Color.decode("#0000FF");
                c.a = 0.5f;
                break;

            case HitX2:
                c = Color.decode("#0000FF");
                c.a = 0.8f;
                break;

            case LowPunch:
                c = Color.decode("#FF0000");
                c.a = 0.5f;
                break;

            case HighPunch:
                c = Color.decode("#FF0000");
                c.a = 0.8f;
                break;

            case LowKick:
                c = Color.decode("#8B1A1A");
                c.a = 0.5f;
                break;

            case HighKick:
                c = Color.decode("#8B1A1A");
                c.a = 0.8f;
                break;

            default:
            case Defense:
                c = Color.decode("#00FF00");
                c.a = 0.8f;
                break;
        }

        return c;
	}
}
