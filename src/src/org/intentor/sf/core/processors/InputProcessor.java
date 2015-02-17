package org.intentor.sf.core.processors;

import java.util.LinkedList;
import java.util.List;

import org.intentor.sf.core.events.CommandReceivedEvent;
import org.intentor.sf.core.GameCommand;
import org.intentor.sf.core.PlayerCommands;
import org.intentor.sf.core.listeners.SocketCommandsListener;
import org.newdawn.slick.Input;

/***
 * Processamento de comandos de entrada.
 */
public abstract class InputProcessor implements SocketCommandsListener {
	
	/**
	 * Número do jogador atual.
	 */
	protected int currentPlayer;
	
	/**
	 * Socket utilizado para comunicação entre os jogos.
	 */
	protected SocketProcessor socket;
	
	/**
	 * Comandos do jogo a serem enviados ao cliente.
	 */
	protected List<GameCommand> localCommands = new LinkedList<GameCommand>();
	
	/**
	 * Cria um novo processador de comandos.
	 * @param player Número do jogador a executar o comando.
	 * @param socket Socket utilizado para comunicação entre os jogos.
	 */
	public InputProcessor(int player, SocketProcessor socket) {
		this.currentPlayer = player;
		this.socket = socket;
		this.socket.listenersCommands.add(this);
	}
	
	/**
	 * Indica se o processador de comandos está conectado.
	 * @return
	 */
	public boolean isConnected() {
		return this.socket.isConnected();
	}
	
	/**
	 * Obtém os comandos locais.
	 * @return Lista de comandos locais.
	 */
	public List<GameCommand> getLocalCommands() {
		return this.localCommands;
	}
	
	/**
	 * Cria um comando a ser enviado pela rede.
	 * @param player	Número do jogador.
	 * @param command	Comando executado.
	 * @param args		Argumentos do comando.			
	 * @return String contendo os dados do comando.
	 */
	protected String createCommand(int player, PlayerCommands command, String[] args) {
		StringBuilder sb = new StringBuilder();
		sb.append(player);
		sb.append(";");
		sb.append(command.commandID);
		
		for (String arg : args) {
			sb.append(";");
			sb.append(arg);
		}
		
		return sb.toString();
	}
	/**
	 * Adiciona um comando para ser enviado ao cliente.
	 * @param player	Número do jogador a executar o comando.
	 * @param command	Comando executado.
	 * @param args		Argumentos do comando executado.
	 */
	public void addCommand(int player, PlayerCommands command, String[] args) {
		this.addCommand(player, command, args, false);
	}
	
	/**
	 * Adiciona um comando para ser enviado ao cliente.
	 * @param player	Número do jogador a executar o comando.
	 * @param command	Comando executado.
	 * @param args		Argumentos do comando executado.
	 * @param processed	Indica se o comando já deve ser inserido como processado.
	 */
	public void addCommand(int player, PlayerCommands command, String[] args, boolean processed) {
		if (this.currentPlayer == 0) { //Host. 
			//Sendo servidor, adiciona o comando a lista de comandos locais.
			GameCommand cmd = new GameCommand(player, command, args);
			if (processed) cmd.markAsProcessed();
			this.localCommands.add(cmd);
		} else { //Client.
			//Sendo cliente, envia o comando ao servidor.
			this.sendCommand(1, command, args);
		}
	}
	
	/**
	 * Realiza processamento de comandos de entrada.
	 * @param input objeto que representa os dispositivos de entrada locais.
	 */
	public void processInput(Input input) {
		if(input.isKeyDown(Input.KEY_A)) this.addCommand(this.currentPlayer, PlayerCommands.MoveLeft, new String[0]);		
		if(input.isKeyDown(Input.KEY_D)) this.addCommand(this.currentPlayer, PlayerCommands.MoveRight, new String[0]);
		if(input.isKeyDown(Input.KEY_W)) this.addCommand(this.currentPlayer, PlayerCommands.Jump, new String[0]);
		if(input.isKeyDown(Input.KEY_J)) this.addCommand(this.currentPlayer, PlayerCommands.Defense, new String[0]);
		if(input.isKeyDown(Input.KEY_U)) this.addCommand(this.currentPlayer, PlayerCommands.LowPunch, new String[0]);
		if(input.isKeyDown(Input.KEY_I)) this.addCommand(this.currentPlayer, PlayerCommands.HighPunch, new String[0]);
		if(input.isKeyDown(Input.KEY_O)) this.addCommand(this.currentPlayer, PlayerCommands.LowKick, new String[0]);	
		if(input.isKeyDown(Input.KEY_P)) this.addCommand(this.currentPlayer, PlayerCommands.HighKick, new String[0]);
	}
	
	/**
	 * Envia um comando ao processador de entrada.
	 * @param player	Número do jogador com o qual o comando se relaciona.
	 * @param command 	Comando a ser enviado.
	 */
	public void sendCommand(int player, PlayerCommands command) {
		this.sendCommand(player, command, new String[0]);
	}
	
	/**
	 * Envia um comando ao processador de entrada.
	 * @param player	Número do jogador com o qual o comando se relaciona.
	 * @param command 	Comando a ser enviado.
	 * @param args		Parâmetros do comando.
	 */
	public void sendCommand(int player, PlayerCommands command, String[] args) {
		this.socket.sendCommand(this.createCommand(player, command, args));
	}
	
	public abstract void commandReceived(CommandReceivedEvent e);
}
