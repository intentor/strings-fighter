package org.intentor.sf.core.events;

import java.util.EventObject;

/**
 * Evento de t�rmino de cena.
 */
@SuppressWarnings("serial")
public class SceneEndedEvent extends EventObject {
	private String sceneName;
	private Object[] params;
	
	public SceneEndedEvent(Object source) {
        this(source, null);
    }
	
	public SceneEndedEvent(Object source, Object[] params) {
        super(source);
        
        this.sceneName = source.getClass().getName();
        this.params = params;
    }
	
	/**
	 * Obt�m o nome da cena sendo encerrada.
	 */
	public String getSceneName() {
		return this.sceneName;
	}
	
	/**
	 * Obt�m os par�metros do t�rmino de cena.
	 */
	public Object[] getParams() {
		return this.params;
	}
}