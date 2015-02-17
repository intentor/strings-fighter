package org.intentor.sf.core;

import java.awt.Point;

import org.intentor.sf.core.scripts.CharacterConfiguration;
import org.intentor.sf.scenes.Loader;
import org.keplerproject.luajava.LuaException;
import org.keplerproject.luajava.LuaObject;
import org.keplerproject.luajava.LuaState;
import org.keplerproject.luajava.LuaStateFactory;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;



/***
 * Representa um personagem de jogo.
 */
public class FightingCharacter implements RenderableObject {
	
	/**
	 * Posição inicial do personagem.
	 */
	public Point startupPosition;
	
	/**
	 * Posição atual do personagem.
	 */
	public Point currentPosition;
	
	/**
	 * ID do clã do personagem.
	 */
	private int clanID;
	
	/**
	 * Indica se é o primeiro jogador (à esquerda).
	 */
	private boolean isHostPlayer;
	
	/**
	 * Indica se o sprite do personagem deve
	 * ser invertido na horizontal.
	 */
	private boolean flipHorizontal;

	/**
	 * Cor do jogador.
	 */
	private Color playerColor;
	
	/**
	 * Informações sobre o pulo do personagem.
	 */
	private JumpInfo jump;
	
	/**
	 * Diferença de posicionamento do sprite de início de partida em relação
	 * aos de luta.
	 */
	private Point startingSpriteDifference;
	
	/**
	 * Diferença de posicionamento do sprite de término de partida (derrota) em relação
	 * aos de luta.
	 */
	private Point dyingSpriteDifference;	
	
	/**
	 * Indica se o personagem já foi inicializado
	 */
	public boolean isStarted = false;
	
	/**
	 * Indica se o personagem foi derrotado
	 */
	private boolean isDead = false;
		
	/**
	 * Indica se o personagem não está andando.
	 */
	private boolean isWalking = false;
	
	/** 
	 * Indica se o personagem está pulando.
	 */
	private boolean isJumping = false;
	
	/**
	 * Indica se o personagem está tomando um golpe.
	 */
	private boolean isDamage = false;
	
	/** 
	 * Indica se o personagem está defendendo.
	 */
	private boolean isDefending = false;
	
	/** 
	 * Indica se o personagem estava se defendendo.
	 */
	private boolean wasDefending = false;
	
	/**
	 * Indica se o personagem está realizando alguma ação,
	 * como soco ou chute.
	 */
	private boolean isInAction = false;
	
	/**
	 * Velocidade do jogador.
	 */
	private int playerSpeed;
	
	/**
	 * Logo do personagem.
	 */
	private Image logo;

	/**
	 * Animação de caminhada.
	 */
	private Animation starting;
	
	/**
	 * Animação de morte do personagem.
	 */
	private Animation dying;
	
	/**
	 * Animação de personagem parado.
	 */
	private Animation stopped;

	/**
	 * Animação de personagem andando.
	 */
	private Animation walking;
	
	/**
	 * Animação de personagem pulando.
	 */
	private Animation jumping;

	/**
	 * Animação de personagem defendendo.
	 */
	private Animation defending;
	
	/**
	 * Animação de personagem recebendo dano.
	 */
	private Animation damage;
	
	/**
	 * Animação de soco fraco.
	 */
	private Animation lowPunch;
	
	/**
	 * Animação de soco forte.
	 */
	private Animation highPunch;
	
	/**
	 * Animação de chute fraco.
	 */
	private Animation lowKick;
	
	/**
	 * Animação de chute forte.
	 */
	private Animation highKick;
	
	/**
	 * Animação atual do personagem.
	 */
	private Animation currentAnimation;
	
	/**
	 * Som de pulo.
	 */
    Sound soundJump = new Sound("assets/soundfx/jump.ogg");
    
    /**
     * Som de ação sendo executada.
     */
    Sound soundAction = new Sound("assets/soundfx/action.ogg");
    	
    /**
     * Inicializa um personagem de um jogador.
     * @param script		Script Lua de configuração do personagem.
     * @param isHostPlayer	Indica se o personagem é do jogador principal (à esquerda).
     * @param playerColor	Cor do jogador.
     * @throws SlickException
     */
	public FightingCharacter(String script, boolean isHostPlayer) throws SlickException {
		this.isHostPlayer = isHostPlayer;
		this.flipHorizontal = !isHostPlayer;
		this.loadData(script);
		
		//Configura animação de início de partida.
		this.currentPosition.x -= this.startingSpriteDifference.x;
		this.currentPosition.y -= this.startingSpriteDifference.y;
		this.starting.setLooping(false);
		this.starting.restart();
		this.currentAnimation = this.starting;
	}
    
	/**
	 * Realiza carregamento de dados do personagem a partir de um script Lua.
	 * @param script Localização do script Lua.
	 * @throws SlickException
	 */
    public void loadData(String script) throws SlickException{
		LuaState l = LuaStateFactory.newLuaState();
		l.openLibs();
		l.LdoFile(script);
		LuaObject obj = l.getLuaObject("CharacterConfiguration");
		try {
			CharacterConfiguration data = (CharacterConfiguration)obj.createProxy("core.scripts.CharacterConfiguration");

			this.clanID = data.getClanID();
			
			String colorHexCode = (this.isHostPlayer ? data.getMainColor() : data.getSecondaryColor());
			this.playerColor = org.newdawn.slick.Color.decode(colorHexCode);
			
			this.jump = new JumpInfo(data.getJumpSize(), data.getJumpSpeed());
			
			if (this.flipHorizontal) {
				this.startupPosition = data.getPlayer2InitialPosition();
			} else {
				this.startupPosition =  data.getPlayer1InitialPosition();
			}			
			
			this.startingSpriteDifference = data.getStartingSpriteDifference();
			this.dyingSpriteDifference = data.getDyingSpriteDifference();
			
			this.playerSpeed = data.getPlayerSpeed();
			
			this.currentPosition = (Point)this.startupPosition.clone();
			
			this.starting = AssetsUtil.loadAnimation(data.getSpriteInfoForStarting());
			this.dying = AssetsUtil.loadAnimation(data.getSpriteInfoForDying());
			this.stopped = AssetsUtil.loadAnimation(data.getSpriteInfoForStopped());
			this.walking = AssetsUtil.loadAnimation(data.getSpriteInfoForWalking());
			this.jumping = AssetsUtil.loadAnimation(data.getSpriteInfoForJumping());
			this.defending = AssetsUtil.loadAnimation(data.getSpriteInfoForDefending());
			this.damage = AssetsUtil.loadAnimation(data.getSpriteInfoForDamage());
			this.lowPunch = AssetsUtil.loadAnimation(data.getSpriteInfoForLowPunch());
			this.highPunch = AssetsUtil.loadAnimation(data.getSpriteInfoForHighPunch());
			this.lowKick = AssetsUtil.loadAnimation(data.getSpriteInfoForLowKick());
			this.highKick = AssetsUtil.loadAnimation(data.getSpriteInfoForHighKick());
			
			this.logo = new Image(data.getLogoSprite());
			if (!this.isHostPlayer) this.logo = this.logo.getFlippedCopy(true, false);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (LuaException e) {
			e.printStackTrace();
		}
		
		l.close();
    }
    
    /**
     * Obtém o ID do clã.
     * @return ID do clã do personagem.
     */
    public int getClanID() {
    	return this.clanID;
    }
    
    /**
     * Obtém o logo do personagem.
     * @return Imagem representando o logo do personagem.
     */
    public Image getLogo() {
    	return this.logo;
    }

	/**
	 * Move o personagem no eixo X.
	 * @param position 	Posições a serem movidas.
	 * @param move		Indicação de necessidade de movimentação de posição do personagem ou apenas exibição da animação.
	 */
	private void move(int position, boolean move) {
		if (this.isStarted && !this.wasDefending) {
			if (move) this.currentPosition.x += position;
			this.isWalking = true;
			
			//Caso o personagem não esteja em ação ou pulo, exibe animação de andar.
			if (!this.isInAction && !this.isJumping) this.currentAnimation = this.walking;
		}
	}
	
    /**
     * Executa uma ação no personagem.
     * @param anim 	Animação a ser utilizada na ação.
     * @param s		Som a tocar na ação.
     */
	private void doAction(Animation anim, Sound s) {
		//Somente executa a ação se o personagem não estiver em uma ação.		
		if (this.isStarted && !this.isInAction && this.currentAnimation != this.damage && !this.wasDefending) {
			this.currentAnimation = anim;
			this.currentAnimation.setLooping(false);
			this.currentAnimation.restart();
			this.isInAction = true;
			if (s != null) s.play();
		}
	}
	
	/**
	 * Indica se o sprite está invertido.
	 * @return Valor booleano indicando se o sprite está invertido.
	 */
	public boolean isFlipped() {
		return this.flipHorizontal;
	}
	
	/**
	 * Indica se o personagem está executando alguma ação.
	 * @return Valor booleano indicando se o personagem está executando alguma ação.
	 */
	public boolean isInAction() {
		return this.isInAction;
	}
	
	/**
	 * Indica se o personagem está sofrendo um golpe.
	 * @return Valor booleano indicando se o personagem sofreu um golpe.
	 */
	public boolean isDamage() {
		return this.isDamage;
	}
	
	/**
	 * Indica se o personagem está defendendo
	 * @return Valor booleano indicando se o personagem está defendendo.
	 */
	public boolean isDefending() {
		return this.isDefending;
	}
	
	/**
	 * Obtém a largura atual da animação.
	 * @return Largura do sprite da animação.
	 */
    public int getCurrentWidth() {
    	return this.currentAnimation.getWidth();
    }
    
    /**
	 * Obtém a altura atual da animação.
	 * @return Altura do sprite da animação.
	 */
    public int getCurrentHeight() {
    	return this.currentAnimation.getHeight();
    }
    
    /**
     * Obtém a imagem atual da animação.
     * @return Imagem atual da animação.
     */
    public Image getCurrentImage() {
    	return this.currentAnimation.getCurrentFrame();
    }
    
    /**
     * Obtém a cor do jogador atual.
     * @return Cor do jogador atual.
     */
    public Color getPlayerColor() {
    	return this.playerColor;
    }
    
    /**
     * Obtém as hitboxes do frame atual.
     * @return Vetor de hitboxes do frame atual.
     */
    public Hitbox[] getHitboxes() {
    	return this.currentAnimation.currentHitboxes();
    }
    
    /**
     * Indica se o personagem está executando uma ação.
     * @return Valor booleano indicando se o personagem está executando uma ação.
     */
    public boolean isCharacterOnAction() {
    	return this.isInAction;
    }
    
    /**
     * Inverte horizontalmente os sprites da animação.
     */
    public void flipSprites() {
    	this.flipHorizontal = !this.flipHorizontal;
    }
	
    /**
     * Move o personagem para a esquerda.
	 * @param move Indicação de necessidade de movimentação de posição do personagem ou apenas exibição da animação.
     */
	public void moveLeft(boolean move) {
		this.move(-this.playerSpeed, move);
	}
	
	/**
     * Move o personagem para a direita.
	 * @param move Indicação de necessidade de movimentação de posição do personagem ou apenas exibição da animação.
     */
	public void moveRight(boolean move) {
		this.move(this.playerSpeed, move);
	}
	
	/**
	 * Executa pulo.
	 * @throws SlickException
	 */
	public void jump() throws SlickException {
		//Somente executa pulo se o personagem não estiver em um pulo ou defendendo.
		if (!this.isJumping && !this.wasDefending){
			this.isJumping = true;
			this.currentPosition.y = this.startupPosition.y;
			this.jump.resetSpeed();
			this.jumping.setLooping(false);
			this.jumping.restart();
		    this.soundJump.play();
		}
	}
	
	/**
	 * Indica defesa do personagem.
	 */
	public void defend() {
		if (this.currentAnimation != this.defending) {
			this.currentAnimation = this.defending;
			this.currentAnimation.setLooping(false);
			this.currentAnimation.restart();
			this.currentAnimation.stopAt(10);
			this.isInAction = this.isWalking = false;
		}
		this.isDefending = this.wasDefending = true;
	}
	
	/**
	 * Executa chute fraco.
	 */
	public void doLowKick() {
		this.doAction(this.lowKick, this.soundAction);
	}
	
	/**
	 * Executa chute forte.
	 */
	public void doHighKick() {
		this.doAction(this.highKick, this.soundAction);
	}
	
	/**
	 * Executa soco fraco.
	 */
	public void doLowPunch() {
		this.doAction(this.lowPunch, this.soundAction);
	}
	
	/**
	 * Executa soco forte.
	 */
	public void doHighPunch() {
		this.doAction(this.highPunch, this.soundAction);
	}
	
	/**
	 * Indica dano ao personagem.
	 */
	public void damage() {
		this.doAction(this.damage, null);
		this.isDamage = true;

		if (this.flipHorizontal) {
			if (this.currentPosition.x < (Loader.SCREEN_WIDTH - this.getCurrentWidth())) {
				this.move(6 * this.playerSpeed, true); //Move RIGHT.
			}
		} else {
			if (this.currentPosition.x > 0) {
				this.move(6 * -this.playerSpeed, true); //Move LEFT.
			}
		}			
	}
	
	/**
	 * Indica derrota do personagem.
	 */
	public void dye() {
		if (this.isStarted) {
			this.isDead = true;
			this.isStarted = false;
			
			this.currentPosition.x -= this.dyingSpriteDifference.x;
			this.currentPosition.y -= this.dyingSpriteDifference.y;
			this.dying.setLooping(false);
			this.dying.restart();
			this.currentAnimation = this.dying;
		}
	}
	
	public void update(GameContainer gc, int delta) throws SlickException {
		if (this.isStarted) {
			//Verifica se é para indicar término de animação de defesa.			
			if (this.wasDefending && !this.isDefending) {
				this.wasDefending = false;
			}
			
			//Verifica se é animação de dano para reset de variável indicadora de dano.
			if (this.isDamage && this.currentAnimation.isStopped()) {
				this.isDamage = false;
			}
			
			//Verifica se se está em uma ação.
			if (this.isInAction) {
				/* Caso se esteja em ação e a animação for de andar ou não sendo
				 * estiver parada, finaliza a ação.
				 */
				if (this.currentAnimation == this.walking || this.currentAnimation.isStopped()) {
					this.isInAction = false;
					if (this.isJumping)
						this.currentAnimation = this.jumping;
					else if (this.isWalking)
						this.currentAnimation = this.walking;
					else
						this.currentAnimation = this.stopped;
				}
			}
			
			//Verifica se se está em um pulo.
			if (this.isJumping) {
				//Caso o personagem tenha atingido a altura máxiam, inverte a velocidade para descida.
				if (this.currentPosition.y <= (this.startupPosition.y - this.jump.size())) {
					this.jump.invertSpeed();
				}
				
				//Somente decrementa a velocidade caso o personagem não esteja no chão.
				if (this.currentPosition.y <= this.startupPosition.y) {
					this.currentPosition.y -= this.jump.speed();
					this.jump.decrementSpeed();
				} 
				
				//Nivela a posição final do personagem.
				if (this.currentPosition.y >= this.startupPosition.y) {
					this.currentPosition.y = this.startupPosition.y;
				}
				
				//Caso a animação esteja terminada, indica fim do pulo.
				if (this.jumping.isStopped()) {
					this.isJumping = false;	
					this.jumping.stop();
					if (!this.isDefending) {
						if (this.isWalking) this.currentAnimation = this.walking;
						else if (!this.isInAction) this.currentAnimation = this.stopped;
					}
				}
				else if (!this.isInAction && !this.wasDefending){
					this.currentAnimation = this.jumping;
				}
			}
			
			//Caso não haja ação, movimento, pulo ou defesa, exibe animação de parado.
			if (!this.isInAction && !this.isWalking && !this.isJumping && !this.wasDefending) this.currentAnimation = this.stopped;
			
			//Sempre indica que o personagem não mais está andando ou defendendo.
			this.isWalking = false;
			this.isDefending = false;
		} else {
			//Se a animação de início está parada e o personagem não estiver derrotado, indica início de jogo.
			if (this.starting.isStopped() && !this.isDead) {
				this.isStarted = true;
				this.currentPosition.x += this.startingSpriteDifference.x;
				this.currentPosition.y += this.startingSpriteDifference.y;
				this.currentAnimation = this.stopped;
			}
		}
	}

	public void render(GameContainer container, Graphics g) throws SlickException {
		Image img = this.currentAnimation.getCurrentFrame().getFlippedCopy(this.flipHorizontal, false);
		img.draw(this.currentPosition.x, this.currentPosition.y, this.playerColor);
		this.currentAnimation.update(20);
		
		//Sempre atualiza a animação de pulo, caso esta esteja rodando.
		if (this.currentAnimation != this.jumping && !this.jumping.isStopped()) this.jumping.update(20);
	}
	
	public boolean isDisposeNow() {
		return false;
	}
}