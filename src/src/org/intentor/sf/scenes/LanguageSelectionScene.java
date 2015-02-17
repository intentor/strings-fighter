package org.intentor.sf.scenes;

import org.intentor.sf.core.GameScene;
import org.intentor.sf.core.LocalizationData;
import org.intentor.sf.core.SupportedLanguages;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.MouseOverArea;


public class LanguageSelectionScene extends GameScene implements ComponentListener {
	
	/**
	 * Imagem de fundo da cena.
	 */
	private Image background;
		
	/**
	 * Logo do Astirina.
	 */
	private Image logoAstirina;
	
	/**
	 * Logo do Slick.
	 */
	private Image logoSlick;
	
	/**
	 * Borda dos livros.
	 */
	private Image borderBooks;
	
	/**
	 * Som de movimentação do livro.
	 */
	private Sound sndBookMove;
	
	/**
	 * Indica se se deve tocar o som de movimento do livro
	 * quando se passar o mouse sobre o livro de PT.
	 */
	private boolean playSoundPT = true;
	
	/**
	 * Indica se se deve tocar o som de movimento do livro
	 * quando se passar o mouse sobre o livro de EN.
	 */
	private boolean playSoundEN = true;
	
	/**
	 * Quantidade frames já executados.
	 */
	private int frameCount = 0;
	
	/**
	 * Áreas de apoio na seleção de idioma.
	 */
	private MouseOverArea[] areasLanguageSelection = new MouseOverArea[2];

	public LanguageSelectionScene() {
		super();
	}

	public void init(GameContainer gc) throws SlickException {
		Loader.Container.setMouseCursor("assets/sprites/cursor-empty.png", 0, 0);
		
		this.background = new Image("assets/sprites/scenes/lang/background.png");
		this.logoAstirina = new Image("assets/sprites/scenes/lang/astirina_logo.jpg");
		this.logoSlick = new Image("assets/sprites/scenes/lang/slick_logo.png");
		this.borderBooks = new Image("assets/sprites/scenes/lang/language_select_border.png");
		this.sndBookMove = new Sound("assets/soundfx/book_move.ogg");
		
		this.areasLanguageSelection[0] = new MouseOverArea(gc, this.borderBooks, 297, 90, 102, 475, this);
		this.areasLanguageSelection[1] = new MouseOverArea(gc, this.borderBooks, 405, 90, 102, 475, this);
		for (MouseOverArea area : this.areasLanguageSelection) {
			area.setNormalColor(new org.newdawn.slick.Color(1,1,1,0.5f));
			area.setMouseOverColor(new org.newdawn.slick.Color(1,1,0,1.0f));
		}
	}
	
	public void dispose() throws SlickException {
		this.background.destroy();
		this.logoAstirina.destroy();
		this.logoSlick.destroy();
		this.borderBooks.destroy();
		this.sndBookMove.stop();
		this.sndBookMove = null;
	}

	public void update(GameContainer gc, int delta) throws SlickException {
		if (this.frameCount > 210) {
			if (this.areasLanguageSelection[0].isMouseOver()) {
				if (this.playSoundPT) {
					this.sndBookMove.play();
					this.playSoundPT = false;
					this.playSoundEN = true;
				}
			} else if (this.areasLanguageSelection[1].isMouseOver()) {
				if (this.playSoundEN) {
					this.sndBookMove.play();
					this.playSoundPT = true;
					this.playSoundEN = false;
				}
			} else {
				this.playSoundPT = this.playSoundEN = true;
			}
		} if (this.frameCount++ == 210) { 
			Loader.Container.setMouseCursor("assets/sprites/cursor.png", 0, 0);
		} else this.frameCount++;
	}

	public void render(GameContainer gc, Graphics g) throws SlickException {
		if (this.frameCount > 210) {
			this.background.draw(0, 0);
			for (MouseOverArea area : this.areasLanguageSelection) area.render(gc, g);
		} else {
			if (this.frameCount > 10 && this.frameCount < 100) this.logoAstirina.draw(287, 168);
			if (this.frameCount > 110 && this.frameCount < 200) this.logoSlick.draw(300, 267);
		}
	}
	
	public void componentActivated(AbstractComponent source) {		
		if (source == this.areasLanguageSelection[0]) { //PT
			Loader.CurrentLanguage = SupportedLanguages.Portugues;
			Loader.Localization = new LocalizationData(Loader.CurrentLanguage);
			this.fireEndSceneEvent();
		} else if (source == this.areasLanguageSelection[1]) { //EN
			Loader.CurrentLanguage = SupportedLanguages.English;
			Loader.Localization = new LocalizationData(Loader.CurrentLanguage);
			this.fireEndSceneEvent();
		}
	}
}
