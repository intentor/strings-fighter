package org.intentor.sf.core.scripts;

/**
 * Representa os atributos de um cl�.
 */
public interface ClanAttributes {
	
	/**
	 * Quantidade de pontos de energia do jogador durante a luta. 
	 */
	int getHitPoints();
	
	/**
	 * Quantidade de pontos para execu��o de magias durante as lutas.
	 */
	int getMagicPoints();
	
	/**
	 * For�a de ataques f�sicos.
	 */
	int getStrength();
	
	/**
	 * Fator de multiplica��o da for�a f�sica.
	 */
	float getStrengthFactor();
	
	/**
	 * For�a de ataques m�gicos.
	 */
	int getMagicPower(); 
	
	/**
	 * Fator de multiplica��o da for�a m�gica.
	 */
	float getMagicPowerFactor();
	
	/**
	 * Capacidade de defesa do jogador.
	 */
	float getDefense();	
}
