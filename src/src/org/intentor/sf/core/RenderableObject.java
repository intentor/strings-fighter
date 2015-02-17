package org.intentor.sf.core;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

/**
 * Representa um objeto que pode ser renderizado.
 */
public interface RenderableObject {
	
	/**
	 * Atualiza o status do objeto.
	 * @param gc	GameContainer
	 * @param delta	Valor inerente a atualização.
	 * @throws SlickException
	 */
	void update(GameContainer gc, int delta) throws SlickException;
	
	/**
	 * Renderização do objeto.
	 * @param gc	GameContainer
	 * @param g		Objeto gráfico.
	 * @throws SlickException
	 */
	void render(GameContainer gc, Graphics g) throws SlickException;
	
	/**
	 * Indica se o objeto pode ser descartado.
	 * @return Valor booleano indicando se o objeto pode ser descartado.
	 */
	boolean isDisposeNow();
}
