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
	 * Posi��o inicial do personagem.
	 */
	public Point startupPosition;
	
	/**
	 * Posi��o atual do personagem.
	 */
	public Point currentPosition;
	
	/**
	 * ID do cl� do personagem.
	 */
	private int clanID;
	
	/**
	 * Indica se � o primeiro jogador (� esquerda).
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
	 * Informa��es sobre o pulo do personagem.
	 */
	private JumpInfo jump;
	
	/**
	 * Diferen�a de posicionamento do sprite de in�cio de partida em rela��o
	 * aos de luta.
	 */
	private Point startingSpriteDifference;
	
	/**
	 * Diferen�a de posicionamento do sprite de t�rmino de partida (derrota) em rela��o
	 * aos de luta.
	 */
	private Point dyingSpriteDifference;	
	
	/**
	 * Indica se o personagem j� foi inicializado
	 */
	public boolean isStarted = false;
	
	/**
	 * Indica se o personagem foi derrotado
	 */
	private boolean isDead = false;
		
	/**
	 * Indica se o personagem n�o est� andando.
	 */
	private boolean isWalking = false;
	
	/** 
	 * Indica se o personagem est� pulando.
	 */
	private boolean isJumping = false;
	
	/**
	 * Indica se o personagem est� tomando um golpe.
	 */
	private boolean isDamage = false;
	
	/** 
	 * Indica se o personagem est� defendendo.
	 */
	private boolean isDefending = false;
	
	/** 
	 * Indica se o personagem estava se defendendo.
	 */
	private boolean wasDefending = false;
	
	/**
	 * Indica se o personagem est� realizando alguma a��o,
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
	 * Anima��o de caminhada.
	 */
	private Animation starting;
	
	/**
	 * Anima��o de morte do personagem.
	 */
	private Animation dying;
	
	/**
	 * Anima��o de personagem parado.
	 */
	private Animation stopped;

	/**
	 * Anima��o de personagem andando.
	 */
	private Animation walking;
	
	/**
	 * Anima��o de personagem pulando.
	 */
	private Animation jumping;

	/**
	 * Anima��o de personagem defendendo.
	 */
	private Animation defending;
	
	/**
	 * Anima��o de personagem recebendo dano.
	 */
	private Animation damage;
	
	/**
	 * Anima��o de soco fraco.
	 */
	private Animation lowPunch;
	
	/**
	 * Anima��o de soco forte.
	 */
	private Animation highPunch;
	
	/**
	 * Anima��o de chute fraco.
	 */
	private Animation lowKick;
	
	/**
	 * Anima��o de chute forte.
	 */
	private Animation highKick;
	
	/**
	 * Anima��o atual do personagem.
	 */
	private Animation currentAnimation;
	
	/**
	 * Som de pulo.
	 */
    Sound soundJump = new Sound("assets/soundfx/jump.ogg");
    
    /**
     * Som de a��o sendo executada.
     */
    Sound soundAction = new Sound("assets/soundfx/action.ogg");
    	
    /**
     * Inicializa um personagem de um jogador.
     * @param script		Script Lua de configura��o do personagem.
     * @param isHostPlayer	Indica se o personagem � do jogador principal (� esquerda).
     * @param playerColor	Cor do jogador.
     * @throws SlickException
     */
	public FightingCharacter(String script, boolean isHostPlayer) throws SlickException {
		this.isHostPlayer = isHostPlayer;
		this.flipHorizontal = !isHostPlayer;
		this.loadData(script);
		
		//Configura anima��o de in�cio de partida.
		this.currentPosition.x -= this.startingSpriteDifference.x;
		this.currentPosition.y -= this.startingSpriteDifference.y;
		this.starting.setLooping(false);
		this.starting.restart();
		this.currentAnimation = this.starting;
	}
    
	/**
	 * Realiza carregamento de dados do personagem a partir de um script Lua.
	 * @param script Localiza��o do script Lua.
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
     * Obt�m o ID do cl�.
     * @return ID do cl� do personagem.
     */
    public int getClanID() {
    	return this.clanID;
    }
    
    /**
     * Obt�m o logo do personagem.
     * @return Imagem representando o logo do personagem.
     */
    public Image getLogo() {
    	return this.logo;
    }

	/**
	 * Move o personagem no eixo X.
	 * @param position 	Posi��es a serem movidas.
	 * @param move		Indica��o de necessidade de movimenta��o de posi��o do personagem ou apenas exibi��o da anima��o.
	 */
	private void move(int position, boolean move) {
		if (this.isStarted && !this.wasDefending) {
			if (move) this.currentPosition.x += position;
			this.isWalking = true;
			
			//Caso o personagem n�o esteja em a��o ou pulo, exibe anima��o de andar.
			if (!this.isInAction && !this.isJumping) this.currentAnimation = this.walking;
		}
	}
	
    /**
     * Executa uma a��o no personagem.
     * @param anim 	Anima��o a ser utilizada na a��o.
     * @param s		Som a tocar na a��o.
     */
	private void doAction(Animation anim, Sound s) {
		//Somente executa a a��o se o personagem n�o estiver em uma a��o.		
		if (this.isStarted && !this.isInAction && this.currentAnimation != this.damage && !this.wasDefending) {
			this.currentAnimation = anim;
			this.currentAnimation.setLooping(false);
			this.currentAnimation.restart();
			this.isInAction = true;
			if (s != null) s.play();
		}
	}
	
	/**
	 * Indica se o sprite est� invertido.
	 * @return Valor booleano indicando se o sprite est� invertido.
	 */
	public boolean isFlipped() {
		return this.flipHorizontal;
	}
	
	/**
	 * Indica se o personagem est� executando alguma a��o.
	 * @return Valor booleano indicando se o personagem est� executando alguma a��o.
	 */
	public boolean isInAction() {
		return this.isInAction;
	}
	
	/**
	 * Indica se o personagem est� sofrendo um golpe.
	 * @return Valor booleano indicando se o personagem sofreu um golpe.
	 */
	public boolean isDamage() {
		return this.isDamage;
	}
	
	/**
	 * Indica se o personagem est� defendendo
	 * @return Valor booleano indicando se o personagem est� defendendo.
	 */
	public boolean isDefending() {
		return this.isDefending;
	}
	
	/**
	 * Obt�m a largura atual da anima��o.
	 * @return Largura do sprite da anima��o.
	 */
    public int getCurrentWidth() {
    	return this.currentAnimation.getWidth();
    }
    
    /**
	 * Obt�m a altura atual da anima��o.
	 * @return Altura do sprite da anima��o.
	 */
    public int getCurrentHeight() {
    	return this.currentAnimation.getHeight();
    }
    
    /**
     * Obt�m a imagem atual da anima��o.
     * @return Imagem atual da anima��o.
     */
    public Image getCurrentImage() {
    	return this.currentAnimation.getCurrentFrame();
    }
    
    /**
     * Obt�m a cor do jogador atual.
     * @return Cor do jogador atual.
     */
    public Color getPlayerColor() {
    	return this.playerColor;
    }
    
    /**
     * Obt�m as hitboxes do frame atual.
     * @return Vetor de hitboxes do frame atual.
     */
    public Hitbox[] getHitboxes() {
    	return this.currentAnimation.currentHitboxes();
    }
    
    /**
     * Indica se o personagem est� executando uma a��o.
     * @return Valor booleano indicando se o personagem est� executando uma a��o.
     */
    public boolean isCharacterOnAction() {
    	return this.isInAction;
    }
    
    /**
     * Inverte horizontalmente os sprites da anima��o.
     */
    public void flipSprites() {
    	this.flipHorizontal = !this.flipHorizontal;
    }
	
    /**
     * Move o personagem para a esquerda.
	 * @param move Indica��o de necessidade de movimenta��o de posi��o do personagem ou apenas exibi��o da anima��o.
     */
	public void moveLeft(boolean move) {
		this.move(-this.playerSpeed, move);
	}
	
	/**
     * Move o personagem para a direita.
	 * @param move Indica��o de necessidade de movimenta��o de posi��o do personagem ou apenas exibi��o da anima��o.
     */
	public void moveRight(boolean move) {
		this.move(this.playerSpeed, move);
	}
	
	/**
	 * Executa pulo.
	 * @throws SlickException
	 */
	public void jump() throws SlickException {
		//Somente executa pulo se o personagem n�o estiver em um pulo ou defendendo.
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
			//Verifica se � para indicar t�rmino de anima��o de defesa.			
			if (this.wasDefending && !this.isDefending) {
				this.wasDefending = false;
			}
			
			//Verifica se � anima��o de dano para reset de vari�vel indicadora de dano.
			if (this.isDamage && this.currentAnimation.isStopped()) {
				this.isDamage = false;
			}
			
			//Verifica se se est� em uma a��o.
			if (this.isInAction) {
				/* Caso se esteja em a��o e a anima��o for de andar ou n�o sendo
				 * estiver parada, finaliza a a��o.
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
			
			//Verifica se se est� em um pulo.
			if (this.isJumping) {
				//Caso o personagem tenha atingido a altura m�xiam, inverte a velocidade para descida.
				if (this.currentPosition.y <= (this.startupPosition.y - this.jump.size())) {
					this.jump.invertSpeed();
				}
				
				//Somente decrementa a velocidade caso o personagem n�o esteja no ch�o.
				if (this.currentPosition.y <= this.startupPosition.y) {
					this.currentPosition.y -= this.jump.speed();
					this.jump.decrementSpeed();
				} 
				
				//Nivela a posi��o final do personagem.
				if (this.currentPosition.y >= this.startupPosition.y) {
					this.currentPosition.y = this.startupPosition.y;
				}
				
				//Caso a anima��o esteja terminada, indica fim do pulo.
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
			
			//Caso n�o haja a��o, movimento, pulo ou defesa, exibe anima��o de parado.
			if (!this.isInAction && !this.isWalking && !this.isJumping && !this.wasDefending) this.currentAnimation = this.stopped;
			
			//Sempre indica que o personagem n�o mais est� andando ou defendendo.
			this.isWalking = false;
			this.isDefending = false;
		} else {
			//Se a anima��o de in�cio est� parada e o personagem n�o estiver derrotado, indica in�cio de jogo.
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
		
		//Sempre atualiza a anima��o de pulo, caso esta esteja rodando.
		if (this.currentAnimation != this.jumping && !this.jumping.isStopped()) this.jumping.update(20);
	}
	
	public boolean isDisposeNow() {
		return false;
	}
}