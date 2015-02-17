package org.intentor.sf.core;

/**
 * Representa os atributos de um jogador.
 */
public class PlayerAttributes {
	/**
	 * Quantidade máxima de pontos de energia do jogador. 
	 */
	public int initialHitPoints;
	
	/**
	 * Quantidade de pontos de energia do jogador durante a luta. 
	 */
	public int hitPoints;
	
	/**
	 * Quantidade máxima de pontos para execução de magias do jogador. 
	 */
	public int initialMagicPoints;
	
	/**
	 * Quantidade de pontos para execução de magias durante as lutas.
	 */
	public int magicPoints;
	
	/**
	 * Força de ataques físicos.
	 */
	public int strength;
	
	/**
	 * Força de ataques mágicos.
	 */
	public int magicPower; 
	
	/**
	 * Capacidade de defesa do jogador.
	 */
	public float defense;
}
