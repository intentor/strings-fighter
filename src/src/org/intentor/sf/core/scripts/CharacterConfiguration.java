package org.intentor.sf.core.scripts;

import java.awt.Point;

import org.intentor.sf.core.scripts.lua.LuaPackedSpriteInfo;


/**
 * Configura��es de um personagem do jogo, a ser
 * obtido atrav�s de script em Lua.
 */
public interface CharacterConfiguration {
	
	/**
	 * Obt�m o ID do cl� do jogador.
	 * @return 1: S�mbolos; 2: Letras; 3: Guardi�es.
	 */
	int getClanID();
	
	/**
	 * Cor principal do jogador.
	 * @return Valor em hexadecimal da cor.
	 */
	String getMainColor();
	
	/**
	 * Cor secund�ria do jogador.
	 * @return Valor em hexadecimal da cor.
	 */
	String getSecondaryColor();
	
	/**
	 * Tamanho do pulo do personagem.
	 * @return Valor de ponto flutuante.
	 */
	float getJumpSize();
	
	/**
	 * Obt�m a velocidade de movimento do personagem no jogo.
	 * @return Velocidade do personagem.
	 */
	int getPlayerSpeed();

	/**
	 * Velocidade do pulo do personagem.
	 * @return Valor de ponto flutuante.
	 */
	float getJumpSpeed();

	/**
	 * Localiza��o do sprite do logo do personagem.
	 * @return Caminho do sprite do logo.
	 */
	String getLogoSprite();
	
	/**
	 * Diferen�a de posicionamento do sprite de in�cio de partida em rela��o
	 * aos de luta. � utilizada para assegurar transi��o suave entre inicializa��o
	 * de personagens e movimentos de luta.
	 * @return Ponto representando as diferen�as nos eixos X e Y.
	 */
	Point getStartingSpriteDifference();
	
	/**
	 * Diferen�a de posicionamento do sprite de t�rmino de partida (derrota) em rela��o
	 * aos de luta. � utilizada para assegurar transi��o suave entre os movimentos de 
	 * luta e a derrota do personagem.
	 * @return Ponto representando as diferen�as nos eixos X e Y.
	 */
	Point getDyingSpriteDifference();	
	
	/**
	 * Posi��o inicial do personagem quando no primeiro jogador.
	 * @return Ponto representando a posi��o.
	 */
	Point getPlayer1InitialPosition();

	/**
	 * Posi��o inicial do personagem quando no segundo jogador.
	 * @return Ponto representando a posi��o.
	 */
	Point getPlayer2InitialPosition();
   
	/**
	 * Informa��es do pacote de sprites do personagem iniciando o jogo.
	 * @return Objeto LuaPackedSpriteInfo com informa��es do pacote de sprites.
	 */
    LuaPackedSpriteInfo getSpriteInfoForStarting();
    
	/**
	 * Informa��es do pacote de sprites do personagem morrendo.
	 * @return Objeto LuaPackedSpriteInfo com informa��es do pacote de sprites.
	 */
    LuaPackedSpriteInfo getSpriteInfoForDying();
	
	/**
	 * Informa��es do pacote de sprites do personagem parado.
	 * @return Objeto LuaPackedSpriteInfo com informa��es do pacote de sprites.
	 */
    LuaPackedSpriteInfo getSpriteInfoForStopped();

	/**
	 * Informa��es do pacote de sprites do personagem andando.
	 * @return Objeto LuaPackedSpriteInfo com informa��es do pacote de sprites.
	 */
    LuaPackedSpriteInfo getSpriteInfoForWalking();

	/**
	 * Informa��es do pacote de sprites do personagem pulando.
	 * @return Objeto LuaPackedSpriteInfo com informa��es do pacote de sprites.
	 */
    LuaPackedSpriteInfo getSpriteInfoForJumping();  

	/**
	 * Informa��es do pacote de sprites do personagem defendendo.
	 * @return Objeto LuaPackedSpriteInfo com informa��es do pacote de sprites.
	 */
    LuaPackedSpriteInfo getSpriteInfoForDefending();
    
	/**
	 * Informa��es do pacote de sprites do personagem recebendo dano.
	 * @return Objeto LuaPackedSpriteInfo com informa��es do pacote de sprites.
	 */
    LuaPackedSpriteInfo getSpriteInfoForDamage();
    /**
	 * Informa��es do pacote de sprites do soco fraco.
	 * @return Objeto LuaPackedSpriteInfo com informa��es do pacote de sprites.
	 */
    LuaPackedSpriteInfo getSpriteInfoForLowPunch();
    
    /**
	 * Informa��es do pacote de sprites do soco forte.
	 * @return Objeto LuaPackedSpriteInfo com informa��es do pacote de sprites.
	 */
    LuaPackedSpriteInfo getSpriteInfoForHighPunch();
    
    /**
	 * Informa��es do pacote de sprites do chute fraco.
	 * @return Objeto LuaPackedSpriteInfo com informa��es do pacote de sprites.
	 */
    LuaPackedSpriteInfo getSpriteInfoForLowKick();
    
    /**
	 * Informa��es do pacote de sprites de chute forte.
	 * @return Objeto LuaPackedSpriteInfo com informa��es do pacote de sprites.
	 */
    LuaPackedSpriteInfo getSpriteInfoForHighKick();
}
