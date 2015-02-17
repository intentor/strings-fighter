package org.intentor.sf.scenes.objects;

import org.newdawn.slick.Color;

/**
 * Representa um efeito de fade.
 */
public class FadeEffect {
	
	/**
	 * Dura��o do efeito, em quadros.
	 */
	private int duration;
	
	/**
	 * Contagem do efeito. Vai de duration a 0.
	 */
	private int count;
	
	/**
	 * Indica se o efeito est� habilitado.
	 */
	private boolean enable;
	
	/**
	 * Cria um novo efeito de fade desabilitado.
	 */
	public FadeEffect() {
		this.count = this.duration = 1;
		this.enable = false;
	}
	
	/**
	 * Cria um novo efeito de fade.
	 * @param duration Dura��o do efeito, em quadros
	 */
	public FadeEffect(int duration) {
		this.count = this.duration = duration;
		this.enable = true;
	}
	
	/**
	 * Atualiza o efeito de fade.
	 */
	public void update() {
		if (this.enable) this.count--;
	}
	
	/**
	 * Indica se o efeito est� habilitado.
	 */
	public boolean isEnable() {
		return enable;
	}
	
	/**
	 * Verifica se o efeito terminou.
	 * @return Valor booleano indicando o t�rmino do efeito.
	 */
	public boolean isEnded() {
		return (this.count == 0 || this.duration == 1);
	}
	
	/*
	 * Obt�m a cor para realiza��o do efeito de fade.
	 */
	public Color getColorForFade() {
		float factor = (float)this.count / (float)this.duration;
		
		Color c = new Color(1f, 1f, 1f, factor);
		
		return c;
	}
}
