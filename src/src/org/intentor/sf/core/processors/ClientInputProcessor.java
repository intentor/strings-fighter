package org.intentor.sf.core.processors;

import java.util.LinkedList;
import java.util.List;

import org.intentor.sf.core.GameCommand;

import org.intentor.sf.core.events.CommandReceivedEvent;

/**
 * Processador de comandos do jogador cliente.
 * Todos os comandos executados localmente são enviados ao servidor,
 * ao são processados e posteriormente remetidos ao cliente para processamento.
 */
public class ClientInputProcessor extends InputProcessor {
	
	/**
	 * Comandos a serem processados.
	 */
	List<GameCommand> commands = new LinkedList<GameCommand>();
	
	/**
	 * Cria um processador de comandos de entrada do jogador cliente.
	 * @param player Número do jogador a executar o comando.
	 * @param socket Processador de socket a ser utilizado.
	 */
	public ClientInputProcessor(int player, SocketProcessor socket) {
		super(player, socket);
	}

	/**
	 * Obtém lista de comandos a serem processadas.
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public synchronized List<GameCommand> getCommandsToProcess() {
		List<GameCommand> commandsToReturn;
		
		synchronized (this.commands) {
			//Cria nova lista de comandos e realiza cópia dos dados da lista original.
			commandsToReturn = (List<GameCommand>) ((LinkedList<GameCommand>)this.commands).clone();
			 
			//Limpa os comandos já executados
			this.commands.clear();
		}
		
		return commandsToReturn;
	}
	
	/**
	 * Recebimento de comandos do servidor.
	 */
	@Override
	public synchronized void commandReceived(CommandReceivedEvent e) {
		synchronized (this.commands) {
			this.commands.add(e.command);
		}
	}
}