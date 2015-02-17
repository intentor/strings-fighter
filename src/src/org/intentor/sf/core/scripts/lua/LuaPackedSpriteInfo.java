package org.intentor.sf.core.scripts.lua;

import java.util.LinkedList;
import java.util.List;

import org.intentor.sf.core.Hitbox;


/**
 * Representa informa��es de um pacote de sprites.
 */
public class LuaPackedSpriteInfo {
	private String spriteItemsName;
	private String spriteDefPath;	
	private List<Integer> duration = new LinkedList<Integer>();
	LuaHitboxData hitboxes;
	
	/**
	 * Define nome do pacote de sprites.
	 * @param val Nome do pacote.
	 */
	public void setSpriteItemsName(String val) {
		this.spriteItemsName = val;
	}
	
	/**
	 * Obt�m nome do pacote de sprites.
	 * @return Nome do pacote.
	 */
	public String getSpriteItemsName() {
		return this.spriteItemsName;
	}
	
	/**
	 * Define o caminho do arquivo de defini��o do pacote de sprites.
	 * @param val Caminho do arquivo .def.
	 */
	public void setSpriteDefPath(String val) {
		this.spriteDefPath = val;
	}
	
	/**
	 * Obt�m o caminho do arquivo de defini��o do pacote de sprites.
	 * @return Caminho do arquivo .def.
	 */
	public String getSpriteDefPath() {
		return this.spriteDefPath;
	}
	
	/**
	 * Adiciona uma dura��o de frame. 
	 * As dura��es s�o inseridas em um vetor que posteriormente representar� a dura��o de cada quadro.
	 * @param val Dura��o de um frame.
	 */
	public void addDuration(int val)
	{
		this.duration.add(val);
	}
	
	/**
	 * Obt�m a dura��o de cada frame da anima��o.
	 * @return Vetor de dura��es dos frames.
	 */
	public int[] getDuration()
	{
		int[] array = new int[this.duration.size()];
		for (int i = 0; i < this.duration.size(); i++) array[i] = this.duration.get(i);
		return array;
	}
	
	/**
	 * Define as informa��es de hitboxes.
	 * @param hitboxes Informa��es sobre as hitboxes.
	 */
	public void setHitboxesData(LuaHitboxData hitboxes) {
		this.hitboxes = hitboxes;
	}
	
	/**
	 * Obt�m as hitboxes da anima��o.
	 * @return Matriz contendo as hitboxes da anima��o.
	 */
	public Hitbox[][] getHitboxes() {
		if (this.hitboxes == null) return null;
		else return this.hitboxes.getHitboxes();
	}
}
