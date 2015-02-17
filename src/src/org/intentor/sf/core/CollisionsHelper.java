package org.intentor.sf.core;

import java.awt.Point;

import org.newdawn.slick.geom.Rectangle;

/**
 * Cont�m procedimentos para detec��o de colis�es.
 */
public final class CollisionsHelper {
	
	/**
	 * Verifica se houve interse��o entre dois ret�ngulos.
	 * @param r1 Ret�ngulo 1.
	 * @param r2 Ret�ngulo 2.
	 * @return Valor booleano indicando se houve interse��o.
	 */
	public static boolean intersect(Rectangle r1, Rectangle r2, Point p1, Point p2) {
		/* Ocorre colis�o se:
		 * !(left > other.right || right < other.left ||
		 *	top > other.bottom || bottom < other.top)
		 */		
		return !((p1.x + r1.getX() > (p2.x + r2.getX() + r2.getWidth()) || (p1.x + r1.getX() + r1.getWidth()) < p2.x + r2.getX()) ||
				(p1.y + r1.getY() > (p2.y + r2.getY() + r2.getHeight()) || (p1.y + r1.getY() + r1.getHeight()) < p2.y + r2.getY()));		
	}
	
	/**
	 * Obt�m a �rea de interse��o de 2 ret�ngulos.
	 * @param r1 Ret�ngulo 1.
	 * @param r2 Ret�ngulo 2.
	 * @return Ret�ngulo representado a �rea de interse��o.
	 */
	public static Rectangle getOverlapArea(Rectangle r1, Rectangle r2) {
		/* O overlap rectangle �:
		 * x = max(left, other.left)
		 * y = max(top, other.top),
		 * w = min(right, other.right) - x
		 * h = min(bottom, other.bottom) - y;
		 */
		int x = (int) Math.max(r1.getX(), r2.getX())
			, y = (int) Math.max(r1.getY(), r2.getY())
			, w = (int) Math.min((r1.getX() + r1.getWidth()), (r2.getX() + r2.getWidth())) - x
			, h = (int) Math.min((r1.getY() + r1.getHeight()), (r2.getY() + r2.getHeight())) - y;
		
		return new Rectangle(x, y, w, h);
	}
}
