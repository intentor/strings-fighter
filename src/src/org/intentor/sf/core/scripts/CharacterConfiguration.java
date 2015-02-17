package org.intentor.sf.core.scripts;

import java.awt.Point;

import org.intentor.sf.core.scripts.lua.LuaPackedSpriteInfo;


/**
 * Configurações de um personagem do jogo, a ser
 * obtido através de script em Lua.
 */
public interface CharacterConfiguration {
	
	/**
	 * Obtém o ID do clã do jogador.
	 * @return 1: Símbolos; 2: Letras; 3: Guardiões.
	 */
	int getClanID();
	
	/**
	 * Cor principal do jogador.
	 * @return Valor em hexadecimal da cor.
	 */
	String getMainColor();
	
	/**
	 * Cor secundária do jogador.
	 * @return Valor em hexadecimal da cor.
	 */
	String getSecondaryColor();
	
	/**
	 * Tamanho do pulo do personagem.
	 * @return Valor de ponto flutuante.
	 */
	float getJumpSize();
	
	/**
	 * Obtém a velocidade de movimento do personagem no jogo.
	 * @return Velocidade do personagem.
	 */
	int getPlayerSpeed();

	/**
	 * Velocidade do pulo do personagem.
	 * @return Valor de ponto flutuante.
	 */
	float getJumpSpeed();

	/**
	 * Localização do sprite do logo do personagem.
	 * @return Caminho do sprite do logo.
	 */
	String getLogoSprite();
	
	/**
	 * Diferença de posicionamento do sprite de início de partida em relação
	 * aos de luta. É utilizada para assegurar transição suave entre inicialização
	 * de personagens e movimentos de luta.
	 * @return Ponto representando as diferenças nos eixos X e Y.
	 */
	Point getStartingSpriteDifference();
	
	/**
	 * Diferença de posicionamento do sprite de término de partida (derrota) em relação
	 * aos de luta. É utilizada para assegurar transição suave entre os movimentos de 
	 * luta e a derrota do personagem.
	 * @return Ponto representando as diferenças nos eixos X e Y.
	 */
	Point getDyingSpriteDifference();	
	
	/**
	 * Posição inicial do personagem quando no primeiro jogador.
	 * @return Ponto representando a posição.
	 */
	Point getPlayer1InitialPosition();

	/**
	 * Posição inicial do personagem quando no segundo jogador.
	 * @return Ponto representando a posição.
	 */
	Point getPlayer2InitialPosition();
   
	/**
	 * Informações do pacote de sprites do personagem iniciando o jogo.
	 * @return Objeto LuaPackedSpriteInfo com informações do pacote de sprites.
	 */
    LuaPackedSpriteInfo getSpriteInfoForStarting();
    
	/**
	 * Informações do pacote de sprites do personagem morrendo.
	 * @return Objeto LuaPackedSpriteInfo com informações do pacote de sprites.
	 */
    LuaPackedSpriteInfo getSpriteInfoForDying();
	
	/**
	 * Informações do pacote de sprites do personagem parado.
	 * @return Objeto LuaPackedSpriteInfo com informações do pacote de sprites.
	 */
    LuaPackedSpriteInfo getSpriteInfoForStopped();

	/**
	 * Informações do pacote de sprites do personagem andando.
	 * @return Objeto LuaPackedSpriteInfo com informações do pacote de sprites.
	 */
    LuaPackedSpriteInfo getSpriteInfoForWalking();

	/**
	 * Informações do pacote de sprites do personagem pulando.
	 * @return Objeto LuaPackedSpriteInfo com informações do pacote de sprites.
	 */
    LuaPackedSpriteInfo getSpriteInfoForJumping();  

	/**
	 * Informações do pacote de sprites do personagem defendendo.
	 * @return Objeto LuaPackedSpriteInfo com informações do pacote de sprites.
	 */
    LuaPackedSpriteInfo getSpriteInfoForDefending();
    
	/**
	 * Informações do pacote de sprites do personagem recebendo dano.
	 * @return Objeto LuaPackedSpriteInfo com informações do pacote de sprites.
	 */
    LuaPackedSpriteInfo getSpriteInfoForDamage();
    /**
	 * Informações do pacote de sprites do soco fraco.
	 * @return Objeto LuaPackedSpriteInfo com informações do pacote de sprites.
	 */
    LuaPackedSpriteInfo getSpriteInfoForLowPunch();
    
    /**
	 * Informações do pacote de sprites do soco forte.
	 * @return Objeto LuaPackedSpriteInfo com informações do pacote de sprites.
	 */
    LuaPackedSpriteInfo getSpriteInfoForHighPunch();
    
    /**
	 * Informações do pacote de sprites do chute fraco.
	 * @return Objeto LuaPackedSpriteInfo com informações do pacote de sprites.
	 */
    LuaPackedSpriteInfo getSpriteInfoForLowKick();
    
    /**
	 * Informações do pacote de sprites de chute forte.
	 * @return Objeto LuaPackedSpriteInfo com informações do pacote de sprites.
	 */
    LuaPackedSpriteInfo getSpriteInfoForHighKick();
}
