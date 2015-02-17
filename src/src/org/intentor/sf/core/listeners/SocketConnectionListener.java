package org.intentor.sf.core.listeners;

import org.intentor.sf.core.events.*;

/***
 * Listener de eventos de conex�o do socket.
 */
public interface SocketConnectionListener {
		
	/**
	 * Listener de evento de jogador conectado do jogo.
	 * @param e Dados do evento ocorrido.
	 */
	void playerConnectedReceived(PlayerConnectedEvent e);
	
	/**
	 * Listener de evento de jogador desconectado do jogo.
	 * @param e Dados do evento ocorrido.
	 */
	void playerDisconnectedReceived(PlayerDisconnectedEvent e);
	
	/**
	 * Listener de evento de erro de conex�o.
	 * @param e Dados do evento ocorrido.
	 */
	void connectionErrorReceived(ConnectionErrorEvent e);
}
