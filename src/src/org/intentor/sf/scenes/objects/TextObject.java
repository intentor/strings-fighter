package org.intentor.sf.scenes.objects;

import java.awt.Point;

import org.intentor.sf.core.RenderableObject;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.UnicodeFont;


/**
 * Objeto abstrato para renderização de textos.
 */
public abstract class TextObject implements RenderableObject {
	
	/**
	 * Contador de quadros.
	 */
	protected int count;
	
	/**
	 * Quadro a iniciar a renderização, a partir de count.
	 */
	protected int startRendering;
	
	/**
	 * Duração da renderização.
	 */
	protected int duration;
	
	/**
	 * Fonte do texto.
	 */
	protected UnicodeFont font;
	
	/**
	 * Posição do texto.
	 */
	protected Point position;
	
	/**
	 * Texto a ser renderizado.
	 */
	protected String text;
	
	/**
	 * Som a ser tocado ao iniciar a renderização do texto.
	 */
	protected Sound soundToPlayOnStart;
	
	/**
	 * Efeito de fade.
	 */
	protected FadeEffect fade;
	
	/**
	 * Cria um novo objeto de texto.
	 * @param startRendering		Quadro a iniciar a renderização, a partir de count.
	 * @param duration				Duração da renderização.
	 * @param font					Fonte do texto.
	 * @param position				Posição do texto.
	 * @param text					Texto a ser renderizado.
	 * @param fade					Efeito de fade a ser aplicado ao texto.
	 * @param soundToPlayOnStart  	Som a ser tocado ao iniciar a renderização do texto.
	 */
	public TextObject(int startRendering, int duration, UnicodeFont font, Point position, String text, FadeEffect fade, Sound soundToPlayOnStart) {
		this.startRendering = startRendering;
		this.duration = duration;
		this.font = font;
		this.position = position;
		this.text = text;
		if (fade == null) this.fade = new FadeEffect(); 
		else this.fade = fade;
		this.soundToPlayOnStart = soundToPlayOnStart;
	}
	
	public abstract void update(GameContainer gc, int delta) throws SlickException;

	public abstract void render(GameContainer gc, Graphics g) throws SlickException;

	public boolean isDisposeNow() {
		return (this.duration == 0 && this.fade.isEnded());
	}
}
