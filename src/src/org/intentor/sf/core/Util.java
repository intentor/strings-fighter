package org.intentor.sf.core;

import java.awt.Point;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Calendar;
import java.util.Random;

import org.intentor.sf.scenes.Loader;
import org.newdawn.slick.Color;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.geom.Rectangle;


/**
 * Procedimentos de apoio.
 */
public final class Util {	
	
	/**
	 * Cor de linhas diversas utilizadas na jogo.
	 */
	public static Color LineColor;
	
	/**
	 * Cor de fundo de boxes.
	 */
	public static Color BoxBgColor;

	/**
	 * Objeto para geração de valores aleatórios.
	 */
	private static Random rnd;
	
	/**
     * Obtém o objeto >Random.
     * @return Objeto Random.
     * @see Random
     */
	public static Random getRandomObject()
    {        
		if (rnd == null)
        {
            Calendar cal = Calendar.getInstance();
            int seed = cal.get(Calendar.SECOND) + cal.get(Calendar.MINUTE) + cal.get(Calendar.HOUR);
            rnd = new Random(seed);
        }

        return rnd;
    }
	
	/**
	 * Obtém um ponto aleatório para exibição de dano.
	 * @param centerX	Posição central do sprite do jogador no eixo X.
	 * @param topY		Posição do topo do sprite do jogador no eixo Y.
	 * @return Ponto gerado.
	 */
	public static Point getRandomPositionForDamage(int centerX, int topY) {

        Random r = getRandomObject();

        int x, y;

        x = r.nextInt(5) * 12;
        if (r.nextInt(1) == 0) x = -x;
        
        y = r.nextInt(4) * 10;

        return new Point(centerX + x, topY - y);
	}
	
	/**
	 * Inverte um retângulo no eixo X.
	 * @param r		Retângulo a ser invertido.
	 * @param width	Largura do quadrante no qual o retângulo está inserido.
	 * @return Retângulo invertido.
	 */
	public static Rectangle invertRectangle(Rectangle r, int width) {
		float x = width - r.getX() - r.getWidth();
		Rectangle ri = new Rectangle(x, r.getY(), r.getWidth(), r.getHeight());
		
		return ri;
	}
	
	/**
	 * Escreve uma string centralizada.
	 * @param font	Fonte a ser utilizada para escrita.
	 * @param s		Texto a ser escrito.
	 * @param y		Posição no eixo Y a ser utilizada para escrita.
	 */
	public static void drawStringCenter(UnicodeFont font, String s, int y) {
		int size = font.getWidth(s);
		font.drawString((Loader.SCREEN_WIDTH - size) / 2, y, s);
	}
	
	/**
	 * Obtém o endereço IP atual do jogador.
	 * @return Endereço IP atual do jogador.
	 */
	public static String getCurrentIPAddress() {
		String ip = "";
		
		try { 
			InetAddress addr = InetAddress.getLocalHost(); 
			byte[] ipAddr = addr.getAddress();
			
			//Converte para a representação por ponto.
			for (int i = 0; i < ipAddr.length; i++) { 
				if (i > 0) ip += ".";
				ip += ipAddr[i]&0xFF; 
			} 
		} catch (UnknownHostException e) { } 
	
		return ip;
	}
}
