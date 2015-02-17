package org.intentor.sf.core;

/***
 * Enumera comandos de entrada possíveis de um jogador.
 */
public enum PlayerCommands {
	/**
	 * Início de jogo.
	 */
	StartGame(0),
	/**
	 * Fim de jogo.
	 */
	EndGame(1),
	/**
	 * Indica dano.
	 */
	Damage(2),
	/**
	 * Indica morte de jogador.
	 */
	Dye(3),
	/**
	 * Indica movimento do jogador.
	 */
	Move(4),
	/**
	 * Indica movimentação do cenário.
	 */
	MoveScenario(5),
	/**
	 * Movimentação à direita.
	 */
	MoveLeft(10),
	/**
	 * Movimentação à esquerda.
	 */
	MoveRight(11),
	/**
	 * Defesa.
	 */
	Defense(12),
	/**
	 * Defesa.
	 */
	Jump(13),
	/**
	 * Soco fraco.
	 */
	LowPunch(14),
	/**
	 * Soco forte.
	 */
	HighPunch(15),
	/**
	 * Chute fraco.
	 */
	LowKick(16),
	/**
	 * Chute forte.
	 */
	HighKick(17);
	
	/**
	 * ID do comando.
	 */
	public String commandID;
	
	/**
	 * Inicializa um comando de jogo.
	 * @param id ID do comando.
	 */
	PlayerCommands(int id) {
		this.commandID = String.valueOf(id);
	}
	
	/**
	 * Obtém um comando a partir de seu ID.
	 * @param id ID do comando a ser obtido.
	 * @return Comando representado pelo ID.
	 */
	public static PlayerCommands getCommandByID(String id) {
		PlayerCommands command = null;
		
		for (PlayerCommands pc : PlayerCommands.values()) {
			if (pc.commandID.equals(id)) {
				command = pc;
				break;
			}
		}
		
		return command;
	}
}
