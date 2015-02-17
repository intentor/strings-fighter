package org.intentor.sf.core.scripts.lua;

import java.util.LinkedList;

import org.intentor.sf.core.Hitbox;
import org.intentor.sf.core.HitboxType;
import org.newdawn.slick.geom.Rectangle;


/**
 * Representa dados de hitboxes para manipulação em Lua.
 */
public class LuaHitboxData {

	private LinkedList<LinkedList<Hitbox>> hitboxes = new LinkedList<LinkedList<Hitbox>>();
	
	/**
	 * Cria um novo frame e retorna seu índice.
	 * @return Índice do frame criado.
	 */
	public int createFrame() {
		this.hitboxes.addLast(new LinkedList<Hitbox>());
		return (this.hitboxes.size() - 1);
	}
	
	/**
	 * Adiciona uma hitbox a um frame.
	 * @param index		Índice do frame.
	 * @param x			Ponto no eixo X da hitbox.
	 * @param y			Ponto no eixo Y da hitbox.
	 * @param width		Largura da hitbox.
	 * @param height	Altura da hitbox.
	 * @param type		Tipo da hitbox.
	 */
	public void addHitbox(int index, int x, int y, int width, int height, int type) {
		Rectangle box = new Rectangle(x, y, width, height);
		HitboxType hbt;
		
		switch (type) {
			case 0:
				hbt = HitboxType.HitX0;
			    break;
			case 1:
				hbt = HitboxType.HitX1;
			    break;
			case 2:
				hbt = HitboxType.HitX1_5;
			    break;
			case 3:
				hbt = HitboxType.HitX2;
			    break;
			case 4:
				hbt = HitboxType.LowPunch;
			    break;
			case 5:
				hbt = HitboxType.HighPunch;
			    break;
			case 6:
				hbt = HitboxType.LowKick;
			    break;
			case 7:
				hbt = HitboxType.HighKick;
			    break;
			case 8:
			default:
				hbt = HitboxType.Defense;
			    break;
		}
		
		Hitbox hb = new Hitbox(box, hbt);
		
		this.hitboxes.get(index).addLast(hb);
	}
	
	/**
	 * Obtém matriz de hitboxes.
	 * @return Matriz contendo as hitboxes.
	 */
	public Hitbox[][] getHitboxes() {
		Hitbox[][] hb = new Hitbox[hitboxes.size()][];
		
		for (int i = 0; i < this.hitboxes.size(); i++) {
			LinkedList<Hitbox> list  = this.hitboxes.get(i);
			hb[i] = new Hitbox[list.size()];
			
			for (int j = 0; j < list.size(); j++) {
				hb[i][j] = list.get(j);
			}
		}
		
		return hb;
	}
}
