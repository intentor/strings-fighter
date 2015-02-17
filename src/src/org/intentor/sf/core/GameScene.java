package org.intentor.sf.core;

import java.util.LinkedList;
import java.util.List;

import org.intentor.sf.core.listeners.SceneEventsListener;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import org.intentor.sf.core.events.SceneEndedEvent;

/**
 * Classe base para defini��o de cenas.
 */
public abstract class GameScene extends BasicGame {

    /**
     * Listeners de eventos.
     */
    protected List<SceneEventsListener> listeners = new LinkedList<SceneEventsListener>();
	
	public GameScene() {
		super("Strings Fighter");
	}
	
	/**
     * Adiciona listener de eventos.
     *
     * @param l Listener do evento.
     */
    public void addListener(SceneEventsListener l)
    {
        this.listeners.add(l);
    }
    
    /**
     * Remove listener de eventos.
     *
     * @param l Listener do evento.
     */
    public void removeListener(SceneEventsListener l)
    {
        this.listeners.remove(l);
    }
    
    /**
	 * Dispara o evento de t�rmino da cena.
	 */
	protected void fireEndSceneEvent()
	{
		this.fireEndSceneEvent(null);
	}
	
	/**
	 * Dispara o evento de t�rmino da cena.
	 * @param params Par�metros do evento disparado. 
	 */
	protected void fireEndSceneEvent(Object[] params)
	{
		SceneEndedEvent e = new SceneEndedEvent(this, params);
        for (SceneEventsListener l : this.listeners) l.sceneEndedReceived(e);
	}
	
	/**
	 * Descarta objetos criados.
	 */
	public abstract void dispose() throws SlickException;

	@Override
	public abstract void init(GameContainer gc) throws SlickException;

	@Override
	public abstract void update(GameContainer gc, int delta) throws SlickException;

	@Override
	public abstract void render(GameContainer gc, Graphics g) throws SlickException;
}
