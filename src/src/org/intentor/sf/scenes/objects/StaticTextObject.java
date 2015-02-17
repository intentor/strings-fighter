package org.intentor.sf.scenes.objects;

import java.awt.Point;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.UnicodeFont;

/**
 * Representa um texto estático passível de renderização.
 */
public class StaticTextObject extends TextObject {
	
	/**
	 * Cria um novo texto estático.
	 * @param startRendering	Quadro a iniciar a renderização, a partir de count.
	 * @param duration			Duração da renderização.
	 * @param font				Fonte do texto.
	 * @param position			Posição do texto.
	 * @param text				Texto a ser renderizado.
	 */
	public StaticTextObject(int startRendering, int duration, UnicodeFont font, Point position, String text) {
		super(startRendering, duration, font, position, text, null, null);
	}
	
	/**
	 * Cria um novo texto estático.
	 * @param startRendering		Quadro a iniciar a renderização, a partir de count.
	 * @param duration				Duração da renderização.
	 * @param font					Fonte do texto.
	 * @param position				Posição do texto.
	 * @param text					Texto a ser renderizado.
	 * @param fade					Efeito de fade a ser aplicado ao texto.
	 * @param soundToPlayOnStart  	Som a ser tocado ao iniciar a renderização do texto.
	 */
	public StaticTextObject(int startRendering, int duration, UnicodeFont font, Point position, String text, FadeEffect fade, Sound soundToPlayOnStart) {
		super(startRendering, duration, font, position, text, fade, soundToPlayOnStart);
	}
	
	public void update(GameContainer gc, int delta) throws SlickException {
		this.count++;
		if (this.duration == 0) this.fade.update();
		if (this.count == this.startRendering && this.soundToPlayOnStart != null) this.soundToPlayOnStart.play();
		if (this.count >= this.startRendering && this.duration > 0) this.duration--;
	}
	
	public void render(GameContainer gc, Graphics g) throws SlickException {
		if (this.count >= this.startRendering) this.font.drawString(this.position.x, this.position.y, this.text, this.fade.getColorForFade());
	}
}
