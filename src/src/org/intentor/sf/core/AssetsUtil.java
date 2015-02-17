package org.intentor.sf.core;

import java.awt.Color;

import org.intentor.sf.core.scripts.lua.LuaPackedSpriteInfo;
import org.newdawn.slick.Image;
import org.newdawn.slick.PackedSpriteSheet;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.font.effects.OutlineEffect;


/**
 * Procedimentos de apoio na manipulação de assets.
 */
public final class AssetsUtil {
	
    /**
     * Realiza carregamento de sprites de um pack.
     * @param name	Nome-base das imagens no sprite a serem carregadas.
     * @param pack	Pacote de sprites. 
     * @param flip	Indica se se deve inverter o sprite horizontalmente.
     * @return Array contendo as imagens carregadas.
     */
    public static Image[] loadSprites(String name, PackedSpriteSheet pack) {
    	Image[] img = new Image[20];
    	for (int i = 1; i <= 20; i++) 
			img[i - 1] = pack.getSprite(name + "_" + String.valueOf(i));      
    	
    	return img;
    }
    
    /**
	 * Carrega uma fonte TrueType.
	 * A fonte deverá estar opbrigatoriamente na pasta assets/fonts.
	 * @param fontName		Nome da fonte a ser carregada.
	 * @param size			Tamanho da fonte.
	 * @param bold			Indica se deve ser renderizada como negrito.
	 * @param italic		Indica se deve ser renderizada como itálico.
	 * @param fontColor		Cor da fonte.
	 * @param outlineColor	Cor da borda da fonte.
	 * @throws SlickException
	 */
	public static UnicodeFont loadFont(String fontName, int size, boolean bold, boolean italic, Color fontColor) throws SlickException {
		return loadFont(fontName, size, bold, italic, fontColor, null, 0);
	}
    
	/**
	 * Carrega uma fonte TrueType com borda.
	 * A fonte deverá estar opbrigatoriamente na pasta assets/fonts.
	 * @param fontName		Nome da fonte a ser carregada.
	 * @param size			Tamanho da fonte.
	 * @param bold			Indica se deve ser renderizada como negrito.
	 * @param italic		Indica se deve ser renderizada como itálico.
	 * @param fontColor		Cor da fonte.
	 * @param outlineColor	Cor da borda da fonte.
	 * @param outlineWidth	Tamanho da borda da fonte.
	 * @return Objeto UnicodeFont representando a fonte.
	 * @throws SlickException
	 */
	@SuppressWarnings("unchecked")
	public static UnicodeFont loadFont(String fontName, int size, boolean bold, boolean italic, Color fontColor, Color outlineColor, int outlineWidth) throws SlickException {
		UnicodeFont f = new UnicodeFont("assets/fonts/" + fontName, size, bold, italic);
		f.getEffects().add(new ColorEffect(fontColor));
		if (outlineColor != null) f.getEffects().add(new OutlineEffect(outlineWidth, outlineColor));
		
	    f.addAsciiGlyphs();
	    f.loadGlyphs(); 
	    
	    return f;
	}
	
	/**
	 * Realiza carregamento de uma animação a partir das informações do pacote de sprites.
	 * @param info Informações sobre o pacote de sprites.
	 * @return Objeto representando a animação solicitada.
	 * @throws SlickException
	 */
	public static Animation loadAnimation(LuaPackedSpriteInfo info) throws SlickException {
    	Animation anim;
    	PackedSpriteSheet pack = new PackedSpriteSheet(info.getSpriteDefPath(), Image.FILTER_NEAREST);
    	
    	if (info.getDuration().length == 1)
    		anim = new Animation(AssetsUtil.loadSprites(info.getSpriteItemsName(), pack), info.getDuration()[0], info.getHitboxes());
    	else
    		anim = new Animation(AssetsUtil.loadSprites(info.getSpriteItemsName(), pack), info.getDuration(), info.getHitboxes());
    	
    	return anim;
    }
}
