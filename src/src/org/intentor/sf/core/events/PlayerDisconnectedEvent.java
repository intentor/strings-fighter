package org.intentor.sf.core.events;

import java.util.EventObject;

/**
 * Representa evento de jogador desconectado do jogo.
 */
@SuppressWarnings("serial")
public class PlayerDisconnectedEvent extends EventObject {
	
	/***
	 * Cria um novo evento.
	 * @param source Fonte do evento.
	 */
	public PlayerDisconnectedEvent(Object source) {
        super(source);
    }
}
