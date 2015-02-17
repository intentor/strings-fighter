package org.intentor.sf.core.listeners;

import org.intentor.sf.core.events.SceneEndedEvent;

/**
 * Listener de eventos de cenas.
 */
public interface SceneEventsListener {
	/**
	 * Listener de evento de término de cena.
	 * @param e Dados do evento ocorrido.
	 */
	void sceneEndedReceived(SceneEndedEvent e);
}