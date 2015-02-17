package org.intentor.sf.core;

import java.util.LinkedList;
import java.util.List;

/**
 * Representa um comando de jogo.
 */
public final class GameCommand {
	private int player;
	private PlayerCommands command;
	private List<String> args;
	private boolean processed = false;
	
	/**
	 * Cria um novo comando de jogo.
	 * @param player 	Jogador executando a ação.
	 * @param command Comando executado pelo jogador.
	 */
	public GameCommand(int player, PlayerCommands command) {
		this.player = player;
		this.command = command;
		this.args = new LinkedList<String>();
	}
	
	/**
	 * Cria um novo comando de jogo.
	 * @param player 	Jogador executando a ação.
	 * @param command 	Comando executado pelo jogador.
	 * @param args		Parâmetros do comando.
	 */
	public GameCommand(int player, PlayerCommands command, String[] args) {
		this(player, command);
		if (args != null) {
			for (String arg : args) this.args.add(arg);
		}
	}
	
	/**
	 * Obtém o jogador a realizar a ação.
	 * @return Número do jogador a executar a ação (0 ou 1).
	 */
	public int getPlayer() {
		return this.player;
	}
	
	/**
	 * Obtém o comando realizado.
	 * @return Comando realizado.
	 */
	public PlayerCommands getCommand() {
		return this.command;
	}
	
	/**
	 * Adiciona um novo argumento ao comando.
	 * @param arg Argumento a ser adicionado.
	 */
	public void addArgument(String arg) {
		this.args.add(arg);
	}
	
	/**
	 * Obtém os argumentos do comando.
	 * @return Array contendo os argumentos do comando.
	 */
	public String[] getArguments() {
		String[] sArgs = new String[this.args.size()];
		for (int i = 0; i < sArgs.length; i++) sArgs[i] = this.args.get(i);
		return sArgs;
	}
	
	/**
	 * Marca um comando como processado.
	 */
	public void markAsProcessed() {
		this.processed = true;
	}
	
	/**
	 * Indica se um comando foi processado.
	 * @return Valor booleano indicando se o comando foi processado.
	 */
	public boolean isProcessed() {
		return this.processed;
	}
}
