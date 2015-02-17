package org.intentor.sf.core;

/**
 * Representa informações de inicialização de um jogador.
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
	 * Indica se o jogador é host ou client.
	 */
	public boolean isHost;
	
	/**
	 * Nível do jogador.
	 */
	public int level;
	
	/**
	 * Pontuação do jogador.
	 */
	public int score;
	
	/**
	 * Pontos de experiência do jogador.
	 */
	public int experiencePoints;
	
	/**
	 * Cria um novo conjunto de informações de um jogador.
	 * @param name				Nome do jogador.
	 * @param idCharacter		ID do personagem do jogador.
	 * @param characterScript	Script do personagem do jogador.
	 * @param isHost			Indica se o jogador é host ou client.
	 * @param level				Nível do jogador.
	 * @param score				Pontuação do jogador.
	 * @param experiencePoints	Pontos de experiência do jogador.
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
