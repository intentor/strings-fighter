package org.intentor.sf.core.processors;

import java.util.LinkedList;
import java.util.List;

import org.intentor.sf.core.GameCommand;
import org.intentor.sf.core.PlayerCommands;

import org.intentor.sf.core.events.CommandReceivedEvent;

/**
 * Processador de comandos do jogador servidor.
 * Todos os comandos são processados no servidor e seus resultados
 * enviados ao cliente.
 */
public class ServerInputProcessor extends InputProcessor {
		
	/**
	 * Comandos do jogo a serem enviados ao cliente.
	 */
	List<GameCommand> clientCommands = new LinkedList<GameCommand>();
	
	/**
	 * Cria um processador de comandos de entrada do jogador servidor.
	 * @param player Número do jogador a executar o comando.
	 * @param socket Processador de socket a ser utilizado.
	 */
	public ServerInputProcessor(int player, SocketProcessor socket) {
		super(player, socket);
	}
	
	/**
	 * Envia todos os comandos do servidor ao cliente.
	 */
	public void sendCommands() {
		synchronized(this.localCommands) {	
			for (int i = 0; i < this.localCommands.size(); i++) {
				GameCommand c = this.localCommands.get(i);
				
				if (c.isProcessed()) {
					this.sendCommand(c.getPlayer(), c.getCommand(), c.getArguments());
					this.localCommands.remove(i--);
				}
			}
		}
		
		synchronized(this.clientCommands) {	
			for (int i = 0; i < this.clientCommands.size(); i++) {
				GameCommand c = this.clientCommands.get(i);
				
				if (c.isProcessed()) {
					this.sendCommand(c.getPlayer(), c.getCommand(), c.getArguments());
					this.clientCommands.remove(i--);
				}
			}
		}
	}
	
	/**
	 * Indica se o game foi iniciado no lado cliente.
	 * @return Valor booleano indicando se o game foi inicializado no lado cliente.
	 */
	public boolean isStartingGame() {
		boolean isStarting = false;
		
		for (GameCommand cmd : this.clientCommands) {
			if (cmd.getCommand() == PlayerCommands.StartGame) {
				isStarting = true;
				break;
			}
		}
		
		return isStarting;
	}
	
	/**
	 * Obtém os comandos do cliente.
	 * @return Lista de comandos do cliente.
	 */
	public List<GameCommand> getClientCommands() {
		return this.clientCommands;
	}

	/**
	 * Recebimento de comandos do cliente.
	 */
	@Override
	public synchronized void commandReceived(CommandReceivedEvent e) {
		synchronized (this.clientCommands) {
			this.clientCommands.add(e.command);
		}
	}	
}
