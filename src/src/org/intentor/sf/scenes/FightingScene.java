package org.intentor.sf.scenes;

import java.awt.Color;
import java.awt.Point;

import java.util.LinkedList;
import java.util.List;

import org.intentor.sf.core.*;
import org.intentor.sf.core.events.ConnectionErrorEvent;
import org.intentor.sf.core.events.PlayerConnectedEvent;
import org.intentor.sf.core.events.PlayerDisconnectedEvent;
import org.intentor.sf.core.listeners.SocketConnectionListener;
import org.intentor.sf.core.processors.*;
import org.intentor.sf.scenes.objects.*;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.geom.Rectangle;

/***
 * Cena de jogo.
 */
public class FightingScene extends GameScene implements SocketConnectionListener
{		
	private static final int MODE_LOADING = 0;
	private static final int MODE_AWAITING_CONNECTION = 1;
	private static final int MODE_STARTING_GAME = 2;
	private static final int MODE_GAME = 3;
	private static final int MODE_END_GAME = 4;
	
	private static final int TOTAL_LOADING_RESOURCES = 13;	

	/**
	 * Modo atual de tela.
	 */
	private int currentMode = MODE_LOADING;
	
	/**
	 * Índice de carregamento de assets.
	 */
	private int loadingIndex = 0;
	
	/**
	 * Jogadores presentes no cenário.
	 */
	private Player[] players = new Player[2];
	
	/**
	 * Informações dos jogadores.
	 */
	private PlayerInfo[] playersInfo = new PlayerInfo[2];
	
	/**
	 * Indica se houve colisão.
	 */
	private boolean isCollision = false;
	
	/**
	 * Posição no eixo X atual do cenário.
	 */
	private int currentScenarioX = -240;
	
	/**
	 * Posição mínima do cenário no eixo X.
	 */
	private int currentScenarioMinX = 0;
	
	/**
	 * Posição máxima do cenário no eixo X.
	 */
	private int currentScenarioMaxX = -760;
	
	/**
	 * Velocidade de movimentação do cenário.
	 */
	private int scenarioMoveSpeed = 5;

	/**
	 * Imagem de fundo do cenário.
	 */
	private Image background = null;

	/**
	 * HUD do jogo.
	 */
	private Image hud = null;
	
	/**
	 * Sombra dos personagens.
	 */
	private Image shadow = null;
	
	/**
	 * Logo do jogo.
	 */
	private Image logo = null;	
	
	/**
	 * Efeito sonoro de subida de nível.
	 */
	private Sound sndLevelUp;
	
	/**
	 * Música de fundo do jogo.
	 */
	private Music musBackground;
	
	/**
	 * Processador de socket para comunicação em rede.
	 */
	public SocketProcessor socket; 
	
	/**
	 * Fonte do loading.
	 */
	private UnicodeFont fontLoading;      
	
	/**
	 * Fonte do HUD.
	 */
	private UnicodeFont fontHud;
	
	/**
	 * Fonte de mensagens de jogo.
	 */
	private UnicodeFont fontMessage;
	
	/**
	 * Fonte de exibição de hits.
	 */
	private UnicodeFont fontHits;
	
	/**
	 * Fonte para exibição de estatísticas.
	 */
	private UnicodeFont fontStats;
	
	/**
	 * Objetos a serem renderizados na tela.
	 */
	private List<RenderableObject> objects = new LinkedList<RenderableObject>();
	
	/**
	 * Processador de comandos da cena.
	 */
	private InputProcessor processor;
	
	/**
	 * Indica se este jogo é o host.
	 */
	private boolean isHost = false;
	
	/**
	 * Indica se o jogador está conectado.
	 */
	private boolean isPlayerConnected = false;
	
	/**
	 * Indica se se está em modo de Debug.
	 */
	private boolean isDebug = false;
	
	/**
	 * Indica que a posição dos jogadores está invertida
	 * (jogador 1 à direita e 2 à esquerda.
	 */
	private boolean isPositionInverted = false;
	
	/**
	 * Indica se as estatísticas foram enviadas ao servidor após o término do jogo.
	 */
	private boolean isStatsSendedToServer = false;
	
	/**
	 * ID da sala na qual o jogo está ocorrendo.
	 */
	private int idGameRoom;
	
	/**
	 * ID do personagem do jogador vencedor.
	 */
	private int idCharacterWinner;
	
	/**
	 * IP do jogador servidor do jogo.
	 */
	private String ip;
	
	/**
	 * Inicializa a cena de luta.
	 * @param p1 			Dados do jogador 1.
	 * @param p2 			Dados do jogador 2.
	 * @param idGameRoom	ID da sala de jogo.
	 */
	public FightingScene(PlayerInfo p1, PlayerInfo p2, int idGameRoom) {
		this(p1, p2, idGameRoom, null);
	}
	
	/**
	 * Inicializa a cena de luta.
	 * @param p1 				Dados do jogador 1.
	 * @param p2 			Dados do jogador 2.
	 * @param idGameRoom	ID da sala de jogo.
	 * @param ip 			IP do jogador servidor.
	 */
	public FightingScene(PlayerInfo p1, PlayerInfo p2, int idGameRoom, String ip) {
		super();
		
		playersInfo[0] = p1;
		playersInfo[1] = p2;
		this.idGameRoom = idGameRoom;
		
		this.isHost = (ip == null);
		this.ip = ip;
	}

	public void init(GameContainer gc) throws SlickException {
		Loader.Container.setMouseCursor("assets/sprites/cursor-empty.png", 0, 0);
		
		this.fontLoading = AssetsUtil.loadFont("BRLNSDB.TTF", 25, true, false, Color.white, Color.red, 1);
		this.logo = new Image("assets/sprites/scenes/logo.png");
	}
	
	public void dispose() throws SlickException {
		this.background.destroy();
		this.logo.destroy();
		this.sndLevelUp.stop();
		this.sndLevelUp = null;
		this.musBackground.stop();
		this.musBackground = null;
		this.fontHud.destroy();
		this.fontMessage.destroy();
		this.fontHits.destroy();
		this.fontStats.destroy();
		this.objects.clear();
		
		for (Player p : this.players) p.dispose();
	}
	
	public void update(GameContainer gc, int delta) throws SlickException {
		switch (this.currentMode) {
			case MODE_LOADING: {
				this.updateLoading(gc, delta);
			}
			break;
			case MODE_AWAITING_CONNECTION: {
				this.updateAwaitingConnection(gc, delta);
			}
			break;
			case MODE_STARTING_GAME:
				this.updateStartingGame(gc, delta);
			break;
			case MODE_GAME:
				this.updateGame(gc, delta);
			break;
			case MODE_END_GAME:
				this.updateEndGame(gc, delta);
			break;
		}
		
		this.updateObjects(gc, delta);
	}
	
	public void render(GameContainer gc, Graphics g) throws SlickException {
		switch (this.currentMode) {
			case MODE_LOADING:
				this.renderLoading(gc, g);
			break;
			case MODE_AWAITING_CONNECTION:
				this.renderAwaitingConnection(gc, g);
			break;
			case MODE_STARTING_GAME:
				this.renderStartingGame(gc, g);
			break;
			case MODE_GAME:
				this.renderGame(gc, g);
			break;
			case MODE_END_GAME:
				this.renderEndGame(gc, g);
			break;
		}
		
		for (RenderableObject m : this.objects) m.render(gc, g);
	}

	@Override
	public void playerConnectedReceived(PlayerConnectedEvent e) {
		this.isPlayerConnected = true;
	}

	@Override
	public void playerDisconnectedReceived(PlayerDisconnectedEvent e) {
		if (this.currentMode == MODE_END_GAME) this.fireEndSceneEvent();
		else {
			System.err.println("Player disconnected.");
			this.currentMode = MODE_AWAITING_CONNECTION;
		}
	}

	@Override
	public void connectionErrorReceived(ConnectionErrorEvent e) {
		if (this.currentMode == MODE_END_GAME) this.fireEndSceneEvent();
		else {
			this.fireEndSceneEvent();
			System.err.println(e.message);
		}
	}
	
	/**
	 * Atualização de carregamento de assets.
	 * Cada carregamento é realizado em uma iteração do valor de loadingIndex.
	 * @param gc GameContainer.
	 * @param delta	Valor inerente a atualização.
	 * @throws SlickException
	 */
	private void updateLoading(GameContainer gc, int delta) throws SlickException {
		switch(this.loadingIndex++) {
			case 1:
				if (this.isHost) { //O socket é criado externamente.
					this.processor = new ServerInputProcessor(0, this.socket);
				} else {
					this.socket = new ClientSocketProcessor(this.ip, 4444);
					this.processor = new ClientInputProcessor(1, this.socket);
					
					this.socket.addConnectionListener(this);
					this.socket.start();
				}
			break;
			case 2:
				this.fontHud = AssetsUtil.loadFont("BRLNSDB.TTF", 15, true, false, Color.black);
			break;
			case 3:
				this.fontMessage = AssetsUtil.loadFont("BRLNSDB.TTF", 130, true, false, Color.red, Color.yellow, 5);
			break;
			case 4:
				this.fontHits = AssetsUtil.loadFont("BRLNSDB.TTF", 20, true, false, Color.red, Color.white, 1);
			break;
			case 5:
				this.fontStats = AssetsUtil.loadFont("BRLNSDB.TTF", 45, true, false, Color.yellow, Color.red, 2);
			break;
			case 6:
				this.background = new Image("assets/sprites/scenes/library/background.jpg");
			break;
			case 7:
				this.hud = new Image("assets/sprites/scenes/hud.png");
			break;
			case 8:
				this.shadow = new Image("assets/sprites/scenes/shadow.png");
			break;
			case 9: {
				PlayerInfo p = this.playersInfo[0];

				this.players[0] = new Player(p.name
											, p.level
											, p.score
											, p.experiencePoints
											, p.idCharacter
											, new FightingCharacter(p.characterScript, p.isHost));		
			}
			break;
			case 10: {
				PlayerInfo p = this.playersInfo[1];
				
				this.players[1] = new Player(p.name
											, p.level
											, p.score
											, p.experiencePoints
											, p.idCharacter
											, new FightingCharacter(p.characterScript, p.isHost));
			}
			break;
			case 11:
				this.sndLevelUp = new Sound("assets/soundfx/level_up.ogg");
			case 12:
				this.musBackground = new Music("assets/music/library.ogg", true);
			break;
			case 13:
				this.currentMode = MODE_AWAITING_CONNECTION;
			break;
		}
	}
	
	/**
	 * Atualização de espera de conexão de jogador quando em modo servidor.
	 * Cada carregamento é realizado em uma iteração do valor de loadingIndex.
	 * @param gc GameContainer.
	 * @param delta	Valor inerente a atualização.
	 * @throws SlickException
	 */
	private void updateAwaitingConnection(GameContainer gc, int delta) throws SlickException {
		if (this.processor.isConnected()) {
			if (this.isHost) {
				if (this.isPlayerConnected && ((ServerInputProcessor)this.processor).isStartingGame()) {
					this.currentMode = MODE_STARTING_GAME;
					this.musBackground.loop();
				}
			} else {
				this.processor.sendCommand(1, PlayerCommands.StartGame);
				this.currentMode = MODE_STARTING_GAME;
				this.musBackground.loop();
			}
		}
	}
	
	/**
	 * Atualização de elementos de jogo durante a inicialização.
	 * @param gc 	GameContainer.
	 * @param delta	Valor inerente a atualização.
	 * @return 
	 * @throws SlickException
	 */
	private void updateStartingGame(GameContainer gc, int delta) throws SlickException {
		if (!this.players[0].character().isStarted && !this.players[1].character().isStarted && this.objects.size() == 0) {
			this.objects.add(new AnimatedTextAxisXObject(10, 100, this.fontMessage, "S", new Point(-50, 200), new Point(591, 200), 40, 0));
			this.objects.add(new AnimatedTextAxisXObject(20, 90, this.fontMessage, "G", new Point(-50, 200), new Point(499, 200), 35, 0));
			this.objects.add(new AnimatedTextAxisXObject(30, 80, this.fontMessage, "N", new Point(-50, 200), new Point(405, 200), 30, 0));
			this.objects.add(new AnimatedTextAxisXObject(40, 70, this.fontMessage, "I", new Point(-50, 200), new Point(367, 200), 25, 0));
			this.objects.add(new AnimatedTextAxisXObject(50, 60, this.fontMessage, "R", new Point(-50, 200), new Point(283, 200), 20, 0));
			this.objects.add(new AnimatedTextAxisXObject(60, 50, this.fontMessage, "T", new Point(-50, 200), new Point(214, 200), 15, 0));
			this.objects.add(new AnimatedTextAxisXObject(70, 40, this.fontMessage, "S", new Point(-50, 200), new Point(159, 200), 10, 0));
			
			String fightText = Loader.Localization.getFight();
			int x = (800 - this.fontMessage.getWidth(fightText)) / 2;
			this.objects.add(new StaticTextObject(150, 40, this.fontMessage, new Point(x, 200), fightText, new FadeEffect(20), null));
		}
		
		for (Player p : this.players) p.character().update(gc, delta);
		if (this.objects.size() == 0) this.currentMode = MODE_GAME;
	}
	
	/**
	 * Atualização de elementos de jogo.
	 * @param gc GameContainer.
	 * @param delta	Valor inerente a atualização.
	 * @throws SlickException
	 */
	private void updateGame(GameContainer gc, int delta) throws SlickException {
		Input i = gc.getInput();
		
		//Verifica habilitação de modo de debug.
		if (i.isKeyPressed(Input.KEY_F1)) {
			this.isDebug = !this.isDebug;
			gc.setShowFPS(this.isDebug);
		}
		
		//Verifica se se deve parar a música.
		if (i.isKeyPressed(Input.KEY_F2)) {
			if (this.musBackground.playing()) this.musBackground.stop();
			else this.musBackground.play();
		}

		Player p1 = this.players[0];
		Player p2 = this.players[1];
		
		if (p1.getAttributes().hitPoints == 0 || p2.getAttributes().hitPoints == 0) {
			if (this.isHost) {
				if (p1.getAttributes().hitPoints == 0) {
					p1.character().dye();
					this.processor.sendCommand(0, PlayerCommands.Dye);
					this.idCharacterWinner = p2.getIdCharacter();
				}
				if (p2.getAttributes().hitPoints == 0) {
					p2.character().dye(); 
					this.processor.sendCommand(1, PlayerCommands.Dye);
					this.idCharacterWinner = p1.getIdCharacter();
				}
				
				this.processor.sendCommand(1, PlayerCommands.EndGame);
				this.currentMode = MODE_END_GAME;
			}
		} else {
			/* Verifica se a posição do primeiro jogador é maior que a 
			 * posição do segundo jogador para realização de flip horizontal
			 * do sprite.
			 */
			if (!this.isPositionInverted && p1.character().currentPosition.x > p2.character().currentPosition.x) {
				p1.character().flipSprites();
				p2.character().flipSprites();
				this.isPositionInverted = true;
			} else if (this.isPositionInverted && p1.character().currentPosition.x < p2.character().currentPosition.x) {
				p1.character().flipSprites();
				p2.character().flipSprites();
				this.isPositionInverted = false;
			}
		}
		
		//Somente checa colisão se for servidor.
		if (this.isHost) this.checkColisions();
		
		//Realiza processamento de comandos dos jogadores.
		boolean isNotMaxPlayerDistance = !this.isMaxPlayerDistance(p1, p2);
		this.processCommands(p1, p2, i, isNotMaxPlayerDistance, this.isPositionInverted);
			
		for (Player p : this.players) p.character().update(gc, delta);
	}
	
	/**
	 * Atualização de elementos do final do jogo.
	 * @param gc GameContainer.
	 * @param delta	Valor inerente a atualização.
	 * @throws SlickException
	 */
	private void updateEndGame(GameContainer gc, int delta) throws SlickException {	
		if (!this.isStatsSendedToServer) {
			this.isStatsSendedToServer = true;
			
			ServiceFacade.registerWinner(this.idCharacterWinner, this.idGameRoom);
			
			Player currentPlayer = (this.isHost ? this.players[0] : this.players[1]);
			ServiceFacade.setPlayerScore(currentPlayer.getScore());
			ServiceFacade.setPlayerCharacterLevel(currentPlayer.getIdCharacter(), currentPlayer.getLevel());
			ServiceFacade.setPlayerCharacterXP(currentPlayer.getIdCharacter(), currentPlayer.getExperiencePoints());
		}
		
		if (gc.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON)) this.fireEndSceneEvent();
		else for (Player p : this.players) p.character().update(gc, delta);
	}
	
	/**
	 * Atualiza informações de objetos em renderização.
	 * @param gc GameContainer.
	 * @param delta	Valor inerente a atualização.
	 * @throws SlickException 
	 */
	private void updateObjects(GameContainer gc, int delta) throws SlickException {
		for (int i = 0; i < this.objects.size(); i++) {
			RenderableObject o = this.objects.get(i);
			o.update(gc, delta);
			
			if (o.isDisposeNow()) {
				this.objects.remove(o);
				i--;
			}
		}
	}
	
	/**
	 * Renderização de cena de loading.
	 * @param gc	GameContainer
	 * @param g		Objeto gráfico.
	 * @throws SlickException
	 */
	private void renderLoading(GameContainer gc, Graphics g) throws SlickException {
		this.logo.draw(95, 50);
	    g.setColor(org.newdawn.slick.Color.white);

	    String textLoading = Loader.Localization.getLoading();
	    int x = 720 - this.fontLoading.getWidth(textLoading);
	    this.fontLoading.drawString(x, 550, textLoading);
	    
	    int percentage = (int) ((this.loadingIndex / (float)TOTAL_LOADING_RESOURCES) * 100);
	    this.fontLoading.drawString(730, 550, String.valueOf(percentage) + "%");
	}
	
	/**
	 * Renderização de cena de espera de conexão.
	 * @param gc	GameContainer
	 * @param g		Objeto gráfico.
	 * @throws SlickException
	 */
	private void renderAwaitingConnection(GameContainer gc, Graphics g) throws SlickException {
		this.logo.draw(95, 50);
		Util.drawStringCenter(this.fontLoading, Loader.Localization.getAwaitingPlayer(), 450);
	}
	
	/**
	 * Renderização de cena de inicialização de jogo.
	 * @param gc	GameContainer
	 * @param g		Objeto gráfico.
	 * @throws SlickException
	 */
	private void renderStartingGame(GameContainer gc, Graphics g) throws SlickException {
		this.background.draw(this.currentScenarioX, 0);
		this.renderPlayers(gc, g);
	}
	
	/**
	 * Renderização de cena de jogo.
	 * @param gc	GameContainer
	 * @param g		Objeto gráfico.
	 * @throws SlickException
	 */
	private void renderGame(GameContainer gc, Graphics g) throws SlickException {
		this.background.draw(this.currentScenarioX, 0);
		this.renderPlayers(gc, g);
		this.renderHUD(gc, g);

		if (isDebug) {
			FightingCharacter p1 = this.players[0].character();
			FightingCharacter p2 = this.players[1].character();
			Debug.drawHitboxes(g, p1.getHitboxes(), p1.currentPosition, this.isPositionInverted, p1.getCurrentWidth());
			Debug.drawHitboxes(g, p2.getHitboxes(), p2.currentPosition, !this.isPositionInverted, p2.getCurrentWidth());
		}
	}
	
	/**
	 * Renderização de cena de fim de jogo.
	 * @param gc	GameContainer
	 * @param g		Objeto gráfico.
	 * @throws SlickException
	 */
	private void renderEndGame(GameContainer gc, Graphics g) throws SlickException {
		org.newdawn.slick.Color c = org.newdawn.slick.Color.white;
		c.a = 0.5f;
		g.setColor(c);
		
		this.background.draw(this.currentScenarioX, 0);
		this.renderPlayers(gc, g);
		
		Player p1 = this.players[0];
		Player p2 = this.players[1];
		
		String message = "";
		
		//Verifica se algum dos jogadres venceu.
		if (p1.getAttributes().hitPoints == 0 && p2.getAttributes().hitPoints == 0) {
			message = Loader.Localization.getDraw();
		} else if (p1.getAttributes().hitPoints == 0) {
			if (this.isHost) {
				message = Loader.Localization.getYouLose();
			} else {
				message = Loader.Localization.getYouWin();
			}
		} else if (p2.getAttributes().hitPoints == 0) {
			if (this.isHost) {
				message = Loader.Localization.getYouWin();
			} else {
				message = Loader.Localization.getYouLose();
			}
		}
		
		c.a = 1.0f;
		g.setColor(c);
		this.fontMessage.drawString(30, 20, message);
		
		Player currentPlayer = (this.isHost ? this.players[0] : this.players[1]);
		
		this.fontStats.drawString(240, 220, String.format("%s: %d >  %d", Loader.Localization.getScore(), currentPlayer.getInitialScore(), currentPlayer.getScore()));
		this.fontStats.drawString(240, 280, String.format("%s:  %d >  %d", Loader.Localization.getLevel(), currentPlayer.getInitialLevel(), currentPlayer.getLevel()));
		this.fontStats.drawString(240, 340, String.format("%s:  %d", Loader.Localization.getEXPNextLevel(), currentPlayer.getMaxExpToNextLevel() - currentPlayer.getExperiencePoints()));
	}
	
	/**
	 * Renderização do HUD dos personagens.
	 * @param gc	GameContainer
	 * @param g		Objeto gráfico.
	 * @throws SlickException 
	 * @throws SlickException
	 */
	private void renderHUD(GameContainer gc, Graphics g) throws SlickException { 
		int maxSizeHP = 213;
		int maxSizeMP = 150;
		int maxSizeEXP = 137;
		int posHPDiff = 129;
		int posMPDiff = 129;
		
		this.hud.draw(0, 0);
		
		PlayerAttributes p1 = this.players[0].getAttributes();
		PlayerAttributes p2 = this.players[1].getAttributes();
		
		float factorHP1 = p1.hitPoints / (float)p1.initialHitPoints;
		float factorHP2 = p2.hitPoints / (float)p2.initialHitPoints;
		float factorMP1 = p1.magicPoints / (float)p1.initialMagicPoints;
		float factorMP2 = p2.magicPoints / (float)p2.initialMagicPoints;
		float factorEXP1 = this.players[0].getExperiencePoints() / (float)this.players[0].getMaxExpToNextLevel();
		float factorEXP2 = this.players[1].getExperiencePoints() / (float)this.players[1].getMaxExpToNextLevel();
		
		int sizeHP1 = (int) (maxSizeHP * factorHP1);
		int sizeHP2 = (int) (maxSizeHP * factorHP2);
		int sizeMP1 = (int) (maxSizeMP * factorMP1);
		int sizeMP2 = (int) (maxSizeMP * factorMP2);
		int sizeEXP1 = (int) (maxSizeEXP * factorEXP1);
		int sizeEXP2 = (int) (maxSizeEXP * factorEXP2);
		
		//=HP=========================
		//Player 1
		org.newdawn.slick.Color colorHP1 = new org.newdawn.slick.Color(1 - factorHP1, factorHP1, 0);
		g.setColor(colorHP1);
		g.fillRect(posHPDiff, 31, sizeHP1, 18);
		
		//Player 2
		org.newdawn.slick.Color colorHP2 = new org.newdawn.slick.Color(1 - factorHP2, factorHP2, 0);	
		g.setColor(colorHP2);
		g.fillRect(Loader.SCREEN_WIDTH - sizeHP2 - posHPDiff, 31, sizeHP2, 18);

		//=MP=========================		
		//Player 1
		org.newdawn.slick.Color colorMP1 = new org.newdawn.slick.Color(1 - factorMP1, 0, factorMP1);
		g.setColor(colorMP1);
		g.fillRect(posMPDiff, 57, sizeMP1, 9);
		
		//Player 2
		org.newdawn.slick.Color colorMP2 = new org.newdawn.slick.Color(1 - factorMP2, 0, factorMP2);
		g.setColor(colorMP2);
		g.fillRect(Loader.SCREEN_WIDTH - sizeMP2 - posMPDiff, 57, sizeMP2, 9);
		
		//=EXP========================
		org.newdawn.slick.Color colorExp = org.newdawn.slick.Color.decode("#DCDCDC");
		g.setColor(colorExp);
		g.fillRect(5, 112, 16, sizeEXP1);
		g.fillRect(Loader.SCREEN_WIDTH - 21, 112, 16, sizeEXP2);
		
		//=TEXT=======================
		int posHPText1 = 126 - this.fontHud.getWidth(String.valueOf(p1.hitPoints));
		int posHPText2 = Loader.SCREEN_WIDTH - 126;
		this.fontHud.drawString(posHPText1, 30, String.valueOf(p1.hitPoints));
		this.fontHud.drawString(posHPText2, 30, String.valueOf(p2.hitPoints));

		int posMPText1 = 126 - this.fontHud.getWidth(String.valueOf(p1.magicPoints));
		int posMPText2 = Loader.SCREEN_WIDTH - 126;
		this.fontHud.drawString(posMPText1, 52, String.valueOf(p1.magicPoints));
		this.fontHud.drawString(posMPText2, 52, String.valueOf(p2.magicPoints));
		
		int posLevel1 = (20 - this.fontHud.getWidth(String.valueOf(this.players[0].getLevel()))) / 2;
		int posLevel2 = (20 - this.fontHud.getWidth(String.valueOf(this.players[1].getLevel()))) / 2;;
		this.fontHud.drawString(3 + posLevel1, 94, String.valueOf(this.players[0].getLevel()));
		this.fontHud.drawString(Loader.SCREEN_WIDTH - 23 + posLevel2, 94, String.valueOf(this.players[1].getLevel()));
		
		int posNamePlayer1 = 120;
		int posNamePlayer2 = Loader.SCREEN_WIDTH - 120 - this.fontHud.getWidth(this.players[1].getPlayerName());
		this.fontHud.drawString(posNamePlayer1, 2, String.valueOf(this.players[0].getPlayerName()));
		this.fontHud.drawString(posNamePlayer2, 2, String.valueOf(this.players[1].getPlayerName()));

		//=LOGO=======================
		FightingCharacter c1 = this.players[0].character();
		FightingCharacter c2 = this.players[1].character();
		c1.getLogo().draw(0, 0, c1.getPlayerColor());
		c2.getLogo().draw(Loader.SCREEN_WIDTH - 95, 0, c2.getPlayerColor());
	}
	
	/**
	 * Renderização dos personagens dos jogadores.
	 * @param gc	GameContainer
	 * @param g		Objeto gráfico.
	 * @throws SlickException 
	 * @throws SlickException
	 */
	private void renderPlayers(GameContainer gc, Graphics g) throws SlickException {
		FightingCharacter p1 = this.players[0].character();
		FightingCharacter p2 = this.players[1].character();
		
		//Organiza exibição em camadas dos jogares de acordo com quem está executando golpes.
		if (!p1.isDefending() && p1.isInAction() && !p1.isDamage() ) {
			this.drawPlayer(p2, gc, g);
			this.drawPlayer(p1, gc, g);
		} else {
			this.drawPlayer(p1, gc, g);
			this.drawPlayer(p2, gc, g);
		}
	}
	
	/**
	 * Desenha um personagem de jogador na tela.
	 * @param p		Personagem de jogador a ser desenhado.
	 * @param gc	GameContainer
	 * @param g		Objeto gráfico.
	 * @throws SlickException 
	 */
	private void drawPlayer(FightingCharacter p, GameContainer gc, Graphics g) throws SlickException {
		Image img = this.shadow;			
		if (p.isFlipped()) img = this.shadow.getFlippedCopy(true, false);
					
		img.draw(p.currentPosition.x + 30, p.startupPosition.y + 170);
		p.render(gc, g);
	}
	
	/**
	 * Processa comandos dos jogadores.
	 * @param p1						Jogador 1.
	 * @param p2						Jogador 2.
	 * @param i							Objeto que representa a entrada de comandos.
	 * @param isNotMaxPlayerDistance	Indicação se os jogadores não estão a máxima distância possível no cenário.
	 * @param isPositionInverted		Indica se o jogador 1 está à direita do cenário.			
	 * @throws SlickException
	 */
	private void processCommands(Player p1, Player p2, Input i, boolean isNotMaxPlayerDistance, boolean isPositionInverted) throws SlickException {
		this.processor.processInput(i);
		
		if (this.isHost) {
			ServerInputProcessor proc = (ServerInputProcessor)this.processor;
			List<GameCommand> server = proc.getLocalCommands();
			List<GameCommand> client = proc.getClientCommands();

			//Processa os comandos do servidor.
			synchronized (server) {
				for (GameCommand cmd : server) {
					switch (cmd.getCommand()) {
						case MoveLeft:
							this.processMoveLeft(p1.character(), p2.character(), isNotMaxPlayerDistance, !this.isPositionInverted);
							break;
							
						case MoveRight:
							this.processMoveRight(p1.character(), p2.character(), isNotMaxPlayerDistance, !this.isPositionInverted);
							break;
							
						case Defense:
							p1.character().defend();
							break;
							
						case Jump:
							p1.character().jump();
							break;
							
						case LowPunch:
							p1.character().doLowPunch();
							break;
							
						case HighPunch:
							p1.character().doHighPunch();
							break;
							 
						case LowKick:
							p1.character().doLowKick();
							break;
							
						case HighKick:
							p1.character().doHighKick();
							break;
					}
					
					cmd.markAsProcessed();
				}
			}
			
			String[] args1 = new String[2];
			args1[0] = String.valueOf(p1.character().currentPosition.x);
			args1[1] = String.valueOf(p1.character().currentPosition.y);
			proc.addCommand(0, PlayerCommands.Move, args1, true);
			
			//Processa os comandos do cliente.
			synchronized (client) {
				for (GameCommand cmd : client) {
					switch (cmd.getCommand()) {
						case MoveLeft:
							this.processMoveLeft(p2.character(), p1.character(), isNotMaxPlayerDistance, this.isPositionInverted);
							break;
							
						case MoveRight:
							this.processMoveRight(p2.character(), p1.character(), isNotMaxPlayerDistance, this.isPositionInverted);
							break;
							
						case Defense:
							p2.character().defend();
							break;
							
						case Jump:
							p2.character().jump();
							break;
							
						case LowPunch:
							p2.character().doLowPunch();
							break;
							
						case HighPunch:
							p2.character().doHighPunch();
							break;
							 
						case LowKick:
							p2.character().doLowKick();
							break;
							
						case HighKick:
							p2.character().doHighKick();
							break;
					}
					
					cmd.markAsProcessed();
				}
			}
			
			String[] args2 = new String[2];
			args2[0] = String.valueOf(p2.character().currentPosition.x);
			args2[1] = String.valueOf(p2.character().currentPosition.y);
			proc.addCommand(1, PlayerCommands.Move, args2, true);
			
			String[] args3 = new String[1];
			args3[0] = String.valueOf(this.currentScenarioX);
			proc.addCommand(1, PlayerCommands.MoveScenario, args3, true);
			
			//Envia os comandos já processados ao cliente.
			proc.sendCommands();
		} else {
			ClientInputProcessor proc = (ClientInputProcessor)this.processor;
			List<GameCommand> commands  = proc.getCommandsToProcess();
			
			//Processa todos os comandos recebidos.
			for (GameCommand cmd : commands) {
				Player pc1 = p1;
				Player pc2 = p2;
				boolean isInverted = !this.isPositionInverted;
				
				if (cmd.getPlayer() == 1) {
					pc1 = p2;
					pc2 = p1;
					isInverted = this.isPositionInverted;
				}
				
				switch (cmd.getCommand()) {
					case Move:
						pc1.character().currentPosition.x = Integer.valueOf(cmd.getArguments()[0]);
						pc1.character().currentPosition.y = Integer.valueOf(cmd.getArguments()[1]);
						break;
						
					case MoveScenario:
						this.currentScenarioX = Integer.valueOf(cmd.getArguments()[0]);
						break;
				
					case MoveLeft:
						this.processMoveLeft(pc1.character(), pc2.character(), isNotMaxPlayerDistance, isInverted);
						break;
						
					case MoveRight:
						this.processMoveRight(pc1.character(), pc2.character(), isNotMaxPlayerDistance, isInverted);
						break;
						
					case Defense:
						pc1.character().defend();
						break;
						
					case Jump:
						pc1.character().jump();
						break;
						
					case LowPunch:
						pc1.character().doLowPunch();
						break;
						
					case HighPunch:
						pc1.character().doHighPunch();
						break;
						 
					case LowKick:
						pc1.character().doLowKick();
						break;
						
					case HighKick:
						pc1.character().doHighKick();
						break;
						
					case Damage:
						int damage = Integer.valueOf(cmd.getArguments()[0]);
						
						int exp = (int) (damage * 0.1);
						if (exp <= 0) exp = 1;
						if (pc1.addExperiencePoints(exp)) this.showLevelUp(pc1.character());
						
						pc1.addScore(damage);
						
						pc2.getAttributes().hitPoints -= damage;
						pc2.character().damage();
						this.showDamage(pc2.character(), damage);

						if (pc2.getAttributes().hitPoints < 0) pc2.getAttributes().hitPoints = 0;
						break;
						
					case Dye:
						pc1.character().dye();
						break;
						
					case EndGame:
						this.currentMode = MODE_END_GAME;
						break;
				}
			}
		}
	}
	
	/**
	 * Processa movimento para a esquerda.
	 * @param p1						Jogador a ter sua posição avaliada.
	 * @param p2						Referência ao outro jogador em luta.
	 * @param isNotMaxPlayerDistance	Indicação se os jogadores não estão a máxima distância possível no cenário.
	 * @param isLeft					Indica se o jogador está à esquerda do cenário.					
	 */
	private void processMoveLeft(FightingCharacter p1, FightingCharacter p2, boolean isNotMaxPlayerDistance, boolean isLeft) {
		if (!this.isCollision || isLeft) {
			/* Para que o cenário possa mover-se para a esquerda:
			 * - os jogadores não podem estar além da máxima distância possível entre personagens;
			 * - a posição atual do cenário na tela tem de ser menor que 0 (totalmente à esquerda);
			 * - a posição atual do jogador tem de ser 0 (o que indica que ele irá empurrar 
			 * 	 o cenário para esquerda).
			 */
			if (this.isHost) {
				if (isNotMaxPlayerDistance && 
						this.currentScenarioX < this.currentScenarioMinX &&
						p1.currentPosition.x <= 0) {
					//Move o cenário.
					this.currentScenarioX += this.scenarioMoveSpeed;
					//Alteração de posição do outro jogador para mantê-lo parado durante a movimentação de cenário.
					p2.currentPosition.x += this.scenarioMoveSpeed;
				}

				//Move o jogador apenas se sua posição não for o máximo possível à esquerda.
			 	p1.moveLeft((p1.currentPosition.x > 0));
			}
			else p1.moveLeft(false);
		}
	}
	
	/**
	 * Processa movimento para a direita.
	 * @param p1						Jogador a ter sua posição avaliada.
	 * @param p2						Referência ao outro jogador em luta.
	 * @param isNotMaxPlayerDistance	Indicação se os jogadores não estão a máxima distância possível no cenário.
	 * @param isLeft					Indica se o jogador está à esquerda do cenário.					
	 */
	private void processMoveRight(FightingCharacter p1, FightingCharacter p2, boolean isNotMaxPlayerDistance, boolean isLeft) {
		if (!this.isCollision || !isLeft) {
			/* Para que o cenário possa mover-se para a direita:
			 * - os jogadores não podem estar além da máxima distância possível entre personagens;
			 * - a posição atual do cenário na tela tem de ser maior que que -480 (totalmente à direita);
			 * - a posição atual do jogador tem de ser maior ou igual à sua máxima posição à direita
			 * 	 (800 - largura do sprite atual da animação).
			 */
			if (this.isHost) {
				if (isNotMaxPlayerDistance && 
						this.currentScenarioX > currentScenarioMaxX && 
						(p1.currentPosition.x >= (Loader.SCREEN_WIDTH - p1.getCurrentWidth()))) {
					//Move o cenário.
					this.currentScenarioX -= this.scenarioMoveSpeed;
					//Alteração de posição do outro jogador para mantê-lo parado durante a movimentação de cenário.
					p2.currentPosition.x -= this.scenarioMoveSpeed;
				}
				
				//Move o jogador apenas se sua posição não for o máximo possível à direita.
				p1.moveRight((p1.currentPosition.x < (Loader.SCREEN_WIDTH - p1.getCurrentWidth())));
			}
			else p1.moveLeft(false);
		}
	}
	
	/**
	 * Verifica se a distância entre os jogadores é igual a máxima
	 * distância possível entre os personagens.
	 * @param p1 Jogador 1.
	 * @param p2 Jogador 2.
	 * @return Valor booleano indicando se a distância entre os jogadores é a máxima.
	 */
	private boolean isMaxPlayerDistance(Player p1, Player p2) {
		int playerMaxDistance = (Loader.SCREEN_WIDTH - p1.character().getCurrentWidth() - p2.character().getCurrentWidth());
		int currentPlayerDistance;
		if (this.isPositionInverted)
			currentPlayerDistance = p1.character().currentPosition.x - (p2.character().currentPosition.x + p2.character().getCurrentWidth());
		else 
			currentPlayerDistance = p2.character().currentPosition.x - (p1.character().currentPosition.x + p1.character().getCurrentWidth());
		
		return (currentPlayerDistance > playerMaxDistance);
	}
	
	/**
	 * Verifica se houve colisão entre os personagens.
	 */
	private void checkColisions() {
		FightingCharacter p1 = this.players[0].character();
		FightingCharacter p2 = this.players[1].character();
		boolean colision = false;
		
		Hitbox[] hb1 = p1.getHitboxes();
		Hitbox[] hb2 = p2.getHitboxes();
		
		for (Hitbox b1 : hb1) {
			for (Hitbox b2 : hb2) {
				//Realiza inversão de retângulos, se necessário.
				Rectangle r1 = (this.isPositionInverted ? Util.invertRectangle(b1.getBounds(), p1.getCurrentWidth()) : b1.getBounds());
				Rectangle r2 = (this.isPositionInverted ? b2.getBounds() : Util.invertRectangle(b2.getBounds(), p2.getCurrentWidth()));
				
				colision = CollisionsHelper.intersect(r1, r2, p1.currentPosition, p2.currentPosition);
					
				if (colision) {
					this.handleDamage(b1, b2, this.players[0], this.players[1], 0);
					this.handleDamage(b2, b1, this.players[1], this.players[0], 1);
					break;
				}
			}	
			
			if (colision) break;
		}

		this.isCollision = colision;
	}
	
	/**
	 * Avalia se houve dano a um jogador durante a colisão, realizando decréscimo de HP.
	 * @param b1 		Box de colisão do primeiro jogador.
	 * @param b2 		Box de colisão do segundo jogador.
	 * @param p1 		Jogador a ser avaliado por colisões.
	 * @param p2 		O outro jogador no ringue.
	 * @param player 	Número do jogador.
	 */
	private void handleDamage(Hitbox b1, Hitbox b2, Player p1, Player p2, int player) {		
		/*
		•	Soco fraco (LP - Low Punch): 0.5 * STR 
		•	Soco forte (HP - High Punch): 1 * STR 
		•	Chute fraco (LK - Low Kick): 1.5 * STR 
		•	Chute forte (HK - High Kick): 2 * STR
		Recarga de magia: WP: 1; SP: 2; WK: 2; SK: 3).
		 DEF: (DEF / ATK) * 100  de dano
		*/
		
		int typeId = b1.getType().getTypeID();
		
		//Primeiramente, verifica se alguma das hitboxes é golpe.
		if (typeId >= 4 && typeId <= 7) {
			//O jogador está executando golpe.
			
			//Obtém os atributos de ambos os jogadores.
			PlayerAttributes p1ATB = p1.getAttributes();
			PlayerAttributes p2ATB = p2.getAttributes();
			
			//Obtém o ATK do golpe.
			float atk = b1.getType().getATK();
			int damage = 0;
			
			//Verifica qual a área de colisão do jogador 2.
			switch (b2.getType()) {
				case HitX0:
					break;
					
				case HitX1:
					damage = (int) (atk * p1ATB.strength);
					if (damage == 0) damage = 1;
					break;

				case HitX1_5:
					damage = (int) (1.5 * (atk * p1ATB.strength));
					if (damage == 0) damage = 1;
					break;

				case HitX2:
					damage = (int) (2 * (atk * p1ATB.strength));
					if (damage == 0) damage = 1;
					break;

				case LowPunch:
					break;

				case HighPunch:
					break;

				case LowKick:
					break;

				case HighKick:
					break;

				case Defense:
					damage = (int) (p2ATB.defense * atk);
					break;
			}
			
			if (!p2.character().isDamage() && (damage > 0 || b2.getType() == HitboxType.Defense)) {
				String[] argDamage = new String[1];
				argDamage[0] = String.valueOf(damage);
				this.processor.sendCommand(player, PlayerCommands.Damage, argDamage);
				
				int exp = (int) (damage * 0.1);
				if (exp <= 0) exp = 1;
				if (p1.addExperiencePoints(exp)) this.showLevelUp(p1.character());
				
				p1.addScore(damage);
				
				p2ATB.hitPoints -= damage;
				p2.character().damage();
				this.showDamage(p2.character(), damage);

				if (p2ATB.hitPoints < 0) p2ATB.hitPoints = 0;
			}
		}
	}
	
	/**
	 * Exibe mensagem de aumento de nível.
	 * @param c			Personagem.
	 */
	private void showLevelUp(FightingCharacter c) {
		int centerX = c.currentPosition.x + ((c.getCurrentWidth() - this.fontHits.getWidth("Level UP!")) / 2);
		int topY = (int) (c.currentPosition.y + (c.getCurrentHeight() * 0.45));
		
		AnimatedTextAxisYObject a = new AnimatedTextAxisYObject(0
				, this.fontHits
				, "Level UP!"
				, new Point(centerX, topY)
				, new Point(centerX, topY - 100)
				, 0
				, -1
				, new FadeEffect(30)
				, null);
		
		this.objects.add(a);
		this.sndLevelUp.play();
	}
	
	/**
	 * Exibe dano de personagem. 
	 * @param c			Personagem.
	 * @param damage	Quantidade de dano.
	 */
	private void showDamage(FightingCharacter c, int damage) {
		int centerX = c.currentPosition.x + (c.getCurrentWidth() / 2);
		int topY = (int) (c.currentPosition.y + (c.getCurrentHeight() * 0.45));
		Point start = Util.getRandomPositionForDamage(centerX, topY);
		
		AnimatedTextAxisYObject a = new AnimatedTextAxisYObject(0
				, this.fontHits
				, "-" + String.valueOf(damage)
				, start
				, new Point(start.x, start.y - 80)
				, 0
				, -1
				, new FadeEffect(30)
				, null);
		
		this.objects.add(a);
	}
}
