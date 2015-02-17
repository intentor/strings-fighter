package org.intentor.sf.core;

/**
 * Representa informa��es de inicializa��o de um jogador.
 */
public final class PlayerInfo {
	
	/**
	 * Nome do jogador.
	 */
	public String name;
	
	/**
	 * ID do personagem do jogador.
	 */
	public int idCharacter;
	
	/**
	 * Script do personagem do jogador.
	 */
	public String characterScript;
	
	/**
	 * Indica se o jogador � host ou client.
	 */
	public boolean isHost;
	
	/**
	 * N�vel do jogador.
	 */
	public int level;
	
	/**
	 * Pontua��o do jogador.
	 */
	public int score;
	
	/**
	 * Pontos de experi�ncia do jogador.
	 */
	public int experiencePoints;
	
	/**
	 * Cria um novo conjunto de informa��es de um jogador.
	 * @param name				Nome do jogador.
	 * @param idCharacter		ID do personagem do jogador.
	 * @param characterScript	Script do personagem do jogador.
	 * @param isHost			Indica se o jogador � host ou client.
	 * @param level				N�vel do jogador.
	 * @param score				Pontua��o do jogador.
	 * @param experiencePoints	Pontos de experi�ncia do jogador.
	 */
	public PlayerInfo(String name, int idCharacter, String characterScript, boolean isHost, int level, int score, int experiencePoints) {
		this.name = name;
		this.idCharacter = idCharacter;
		this.characterScript = characterScript;
		this.isHost = isHost;
		this.level = level;
		this.score = score;
		this.experiencePoints = experiencePoints;
	}
}
