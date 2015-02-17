package org.intentor.sf.core.scripts.lua;

import java.util.LinkedList;
import java.util.List;

import org.intentor.sf.core.Hitbox;


/**
 * Representa informações de um pacote de sprites.
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
	 * Obtém nome do pacote de sprites.
	 * @return Nome do pacote.
	 */
	public String getSpriteItemsName() {
		return this.spriteItemsName;
	}
	
	/**
	 * Define o caminho do arquivo de definição do pacote de sprites.
	 * @param val Caminho do arquivo .def.
	 */
	public void setSpriteDefPath(String val) {
		this.spriteDefPath = val;
	}
	
	/**
	 * Obtém o caminho do arquivo de definição do pacote de sprites.
	 * @return Caminho do arquivo .def.
	 */
	public String getSpriteDefPath() {
		return this.spriteDefPath;
	}
	
	/**
	 * Adiciona uma duração de frame. 
	 * As durações são inseridas em um vetor que posteriormente representará a duração de cada quadro.
	 * @param val Duração de um frame.
	 */
	public void addDuration(int val)
	{
		this.duration.add(val);
	}
	
	/**
	 * Obtém a duração de cada frame da animação.
	 * @return Vetor de durações dos frames.
	 */
	public int[] getDuration()
	{
		int[] array = new int[this.duration.size()];
		for (int i = 0; i < this.duration.size(); i++) array[i] = this.duration.get(i);
		return array;
	}
	
	/**
	 * Define as informações de hitboxes.
	 * @param hitboxes Informações sobre as hitboxes.
	 */
	public void setHitboxesData(LuaHitboxData hitboxes) {
		this.hitboxes = hitboxes;
	}
	
	/**
	 * Obtém as hitboxes da animação.
	 * @return Matriz contendo as hitboxes da animação.
	 */
	public Hitbox[][] getHitboxes() {
		if (this.hitboxes == null) return null;
		else return this.hitboxes.getHitboxes();
	}
}
