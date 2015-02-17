package org.intentor.sf.core;

/**
 * Representa os atributos de um jogador.
 */
public class PlayerAttributes {
	/**
	 * Quantidade m�xima de pontos de energia do jogador. 
	 */
	public int initialHitPoints;
	
	/**
	 * Quantidade de pontos de energia do jogador durante a luta. 
	 */
	public int hitPoints;
	
	/**
	 * Quantidade m�xima de pontos para execu��o de magias do jogador. 
	 */
	public int initialMagicPoints;
	
	/**
	 * Quantidade de pontos para execu��o de magias durante as lutas.
	 */
	public int magicPoints;
	
	/**
	 * For�a de ataques f�sicos.
	 */
	public int strength;
	
	/**
	 * For�a de ataques m�gicos.
	 */
	public int magicPower; 
	
	/**
	 * Capacidade de defesa do jogador.
	 */
	public float defense;
}
