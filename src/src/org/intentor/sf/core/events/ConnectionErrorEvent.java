package org.intentor.sf.core.events;

import java.util.EventObject;

/**
 * Representa evento de erro de conexão.
 */
@SuppressWarnings("serial")
public class ConnectionErrorEvent extends EventObject {
	
	/***
	 * Mensagem do erro ocorrido.
	 */
	public String message;
	
	/***
	 * Cria um novo evento.
	 * @param source 	Fonte do evento.
	 * @param message 	Mensagem do erro ocorrido.
	 */
	public ConnectionErrorEvent(Object source, String message) {
        super(source);
        this.message = message;
    }
}
