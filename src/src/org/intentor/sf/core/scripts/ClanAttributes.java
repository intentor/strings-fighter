package org.intentor.sf.core.scripts;

/**
 * Representa os atributos de um clã.
 */
public interface ClanAttributes {
	
	/**
	 * Quantidade de pontos de energia do jogador durante a luta. 
	 */
	int getHitPoints();
	
	/**
	 * Quantidade de pontos para execução de magias durante as lutas.
	 */
	int getMagicPoints();
	
	/**
	 * Força de ataques físicos.
	 */
	int getStrength();
	
	/**
	 * Fator de multiplicação da força física.
	 */
	float getStrengthFactor();
	
	/**
	 * Força de ataques mágicos.
	 */
	int getMagicPower(); 
	
	/**
	 * Fator de multiplicação da força mágica.
	 */
	float getMagicPowerFactor();
	
	/**
	 * Capacidade de defesa do jogador.
	 */
	float getDefense();	
}
