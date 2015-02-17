package org.intentor.sf.core.events;

import java.util.EventObject;


/**
 * Representa evento de jogador conectado.
 */
@SuppressWarnings("serial")
public class PlayerConnectedEvent extends EventObject {
	
	/***
	 * Cria um novo evento.
	 * @param source Fonte do evento.
	 */
	public PlayerConnectedEvent(Object source) {
        super(source);
    }
}
