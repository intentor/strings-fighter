package org.intentor.sf.core.listeners;

import org.intentor.sf.core.events.*;

/***
 * Listener de eventos de comandos oriundos do socket.
 */
public interface SocketCommandsListener {
	
	/**
	 * Listener de evento de recebimento de comando.
	 * @param e Dados do evento ocorrido.
	 */
	void commandReceived(CommandReceivedEvent e);
}
