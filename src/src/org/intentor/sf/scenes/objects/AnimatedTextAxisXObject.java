package org.intentor.sf.scenes.objects;

import java.awt.Point;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.UnicodeFont;

/**
 * Representa um texto animado no eixo X passível de renderização.
 */
public class AnimatedTextAxisXObject extends TextObject {
		
	/**
	 * Posição para onde a animação deve ir.
	 */
	private Point to;
	
	/**
	 * Velocidade da animação.
	 */
	private int speed;
	
	/**
	 * Fator de incremento da velocidade.
	 */
	private float increment;
	
	/**
	 * Cria um novo texto animado.
	 * @param startRendering		Quadro a iniciar a renderização, a partir de count.
	 * @param duration				Duração da renderização.
	 * @param font					Fonte do texto.
	 * @param from					Posição de onde a animação deve começar.
	 * @param to					Posição para onde a animação deve ir.
	 * @param text					Texto a ser renderizado.
	 * @param speed					Velocidade da animação.
	 * @param increment				Fator de incremento da velocidade.
	 */
	public AnimatedTextAxisXObject(int startRendering
			, int duration
			, UnicodeFont font
			, String text
			, Point from
			, Point to
			, int speed
			, float increment) {
		this(startRendering, duration, font, text, from, to, speed, increment, null, null);
	}
	
	/**
	 * Cria um novo texto animado.
	 * @param startRendering		Quadro a iniciar a renderização, a partir de count.
	 * @param duration				Duração da renderização.
	 * @param font					Fonte do texto.
	 * @param from					Posição de onde a animação deve começar.
	 * @param to					Posição para onde a animação deve ir.
	 * @param text					Texto a ser renderizado.
	 * @param speed					Velocidade da animação.
	 * @param increment				Fator de incremento da velocidade.
	 * @param fade					Efeito de fade a ser aplicado ao texto.
	 * @param soundToPlayOnStart  	Som a ser tocado ao iniciar a renderização do texto.
	 */
	public AnimatedTextAxisXObject(int startRendering
			, int duration
			, UnicodeFont font
			, String text
			, Point from
			, Point to
			, int speed
			, float increment
			, FadeEffect fade
			, Sound soundToPlayOnStart) {
		super(startRendering, duration, font, from, text, fade, soundToPlayOnStart);
		
		this.position = from;
		this.to = to;
		this.speed = speed;
		this.increment = increment;
	}

	public void update(GameContainer gc, int delta) throws SlickException {
		this.count++;
		if (this.count == this.startRendering && this.soundToPlayOnStart != null) this.soundToPlayOnStart.play();
		
		if (this.count >= this.startRendering) {
			
			//Não sendo a posição final, incrementa a posição X.
			if (this.position.x != this.to.x) {
				if (this.count % 10 == 0)this.speed += this.increment;
				if (this.speed <= 0) this.speed = 1;
				this.position.x += this.speed;
				
				if (this.position.x > this.to.x) this.position.x = this.to.x;
			} else {
				//Sendo a posição final, inicia contagem da duração.
				this.duration--;
			}
		}
	}
	
	public void render(GameContainer gc, Graphics g) throws SlickException {
		if (this.count >= this.startRendering) this.font.drawString(this.position.x, this.position.y, this.text);
	}
}
