package org.intentor.sf.scenes;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Locale;

import org.intentor.sf.core.AssetsUtil;
import org.intentor.sf.core.GameScene;
import org.intentor.sf.core.PlayerInfo;
import org.intentor.sf.core.Util;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.gui.TextField;

public class MenuScene extends GameScene implements ComponentListener {
	private static final int MODE_LOADING = 0;
	private static final int MODE_START = 1;
	private static final int MODE_LOGIN = 2;
	private static final int MODE_MAIN_MENU = 3;
	private static final int MODE_CREDITS = 4;
	private static final int MODE_ROOM_SELECTION = 5;
	private static final int MODE_CHARACTER_SELECTION = 6;
	private static final int MODE_AWAITING_PLAYER = 7;

	private static final int TOTAL_LOADING_RESOURCES = 29;	
	
	/**
	 * Modo atual da tela.
	 */
	private int currentMode = MODE_LOADING;
	
	/**
	 * Índice de carregamento de assets.
	 */
	private int loadingIndex = 0;
	
	/**
	 * Imagem de fundo da cena.
	 */
	private Image background;
	
	/**
	 * Imagem de fundo da cena com áreas para os itens do menu.
	 */
	private Image backgroundOptions;
	
	/**
	 * Imagem de fundo de personagens.
	 */
	private Image backgroundCharacters;
	
	/**
	 * Imagem de fundo da seleção de salas.
	 */
	private Image backgroundRoomSelection;
	
	/**
	 * Imagem de fundo dos créditos.
	 */
	private Image backgroundCredits;
	
	/**
	 * Logo do jogo.
	 */
	private Image logo;
	
	/**
	 * Imagem da divisão de seleção de salas.
	 */
	private Image divisionRoomSelection;
	
	/**
	 * Logo do personagem Ankh.
	 */
	private Image icoAnkh;
	
	/**
	 * Logo do personagem Dôbot.
	 */
	private Image icoDobot;	
	
	/**
	 * Fonte do texto de loading.
	 */
	private UnicodeFont fontLoading; 
	
	/**
	 * Fonte do texto de copyright.
	 */
	private UnicodeFont fontCopyright; 
	
	/**
	 * Fonte das caixas de texto de login.
	 */
	private UnicodeFont fontLogin; 
	
	/**
	 * Fonte do texto de abertura do menu.
	 */
	private UnicodeFont fontStart; 
	
	/**
	 * Fonte de textos de informação do menu.
	 */
	private UnicodeFont fontMenuInfo;
	
	/**
	 * Fonte de textos de seleção de sala.
	 */
	private UnicodeFont fontRoomSelection;	
	
	/**
	 * Fonte de textos de seleção de sala para a janela do programa.
	 */
	private UnicodeFont fontRoomSelectionWindow;	
	
	/**
	 * Fonte de textos de descrição de personagens.
	 */
	private UnicodeFont fontDescription;
	
	/**
	 * Fonte de textos de créditos.
	 */
	private UnicodeFont fontCredits;	
	
	/**
	 * Caixa de texto do nome do usuário.
	 */
	private TextField txtUserName;
	
	/**
	 * Caixa de texto da senha.
	 */
	private TextField txtPassword;
	
	/**
	 * Caixa de texto de descrição do personagem Dôbot.
	 */
	private TextField txtDobotDescription;
	
	/**
	 * Caixa de texto de descrição do personagem Ankh.
	 */
	private TextField txtAnkhDescription;
	
	/**
	 * Som de mouseover em opções.
	 */
	private Sound sndOption;
	
	/**
	 * Música de fundo do menu.
	 */
	private Music musBackground;
	
	/**
	 * Mensagem da opção selecionada do menu.
	 */
	private String optionMessage;
	
	/**
	 * Áreas de mouse do menu.
	 */
	private MouseOverArea[] areasLogin = new MouseOverArea[2];
	
	/**
	 * Áreas de mouse do menu.
	 */
	private MouseOverArea[] areasMenu = new MouseOverArea[3];
	
	/**
	 * Áreas de seleção de personagem.
	 */
	private MouseOverArea[] areasCharacterSelecion = new MouseOverArea[2];
	
	/**
	 * Áreas de seleção de salas.
	 */
	private MouseOverArea[] areasRoomSelection;
	
	/**
	 * Áreas de apoio na seleção de salas.
	 */
	private MouseOverArea[] areasRoomSelectionSupport;
	
	/**
	 * Posições da seleção de salas.
	 */
	private int[] roomSelectionPositionsX = new int[5];
	
	/**
	 * Posição inicial no eixo Y da seleção de salas.
	 */
	private int roomSelectionStartY;
	
	/**
	 * Diferença da posição de salas no eixo Y.
	 * É usado para separar as linhas da tabela.
	 */
	private int roomSelectionDiffY;
	
	/**
	 * Indica sobre quem o mouse está acima no menu 
	 * para execução de som.
	 */
	private boolean[] overMenu = new boolean[3];
	
	/**
	 * Indica se o jogo é host.
	 */
	private Boolean isHost;
	
	/**
	 * Sala de jogo atual.
	 */
	private GameRoomInfo[] availableGameRooms;
	
	/**
	 * Jogador atual selecionado.
	 */
	private PlayerInfo currentSelectedCharacter;
	
	/**
	 * Sala de jogo atual.
	 */
	private Gameroom currentGameRoom;
	
	/**
	 * Delay para análise de salas de jogos.
	 */
	private int analysisGameRoomDelay = 470;
	
	/**
	 * Delay para análise de salas.
	 */
	private int analysisDelay = 50;
	
	public MenuScene() {
		super();
	}	

	public void init(GameContainer gc) throws SlickException {
		Loader.Container.setMouseCursor("assets/sprites/cursor-empty.png", 0, 0);

		this.background = new Image("assets/sprites/scenes/menu/background.jpg");
		this.fontLoading = AssetsUtil.loadFont("BRLNSDB.TTF", 25, true, false, Color.white, Color.red, 1);
	}
	
	public void dispose() throws SlickException {
		this.background.destroy();
		this.backgroundOptions.destroy();
		this.backgroundCharacters.destroy();
		this.backgroundRoomSelection.destroy();
		this.logo.destroy();
		this.icoAnkh.destroy();
		this.icoDobot.destroy();
		this.fontCopyright.destroy();
		this.fontLogin.destroy();
		this.fontStart.destroy();
		this.fontMenuInfo.destroy();
		this.fontRoomSelection.destroy();
		this.fontRoomSelectionWindow.destroy();
		this.fontDescription.destroy();
		this.fontCredits.destroy();
		this.sndOption.stop();
		this.sndOption = null;
		this.musBackground.stop();
		this.musBackground = null;
	}

	public void update(GameContainer gc, int delta) throws SlickException {
		switch (this.currentMode) {
			case MODE_LOADING:
				this.updateLoading(gc, delta);
			break;
			case MODE_START:
				this.updateStart(gc, delta);
			break;
			case MODE_LOGIN:
				this.updateLogin(gc, delta);
			break;	
			case MODE_MAIN_MENU:
				this.updateMainMenu(gc, delta);
			break;	
			case MODE_CREDITS:
				this.updateCredits(gc, delta);
			break;
			case MODE_ROOM_SELECTION:
				this.updateRoomSelection(gc, delta);
			break;
			case MODE_CHARACTER_SELECTION:
				this.updateCharacterSelection(gc, delta);
			break;
			case MODE_AWAITING_PLAYER:
				this.updateAwaitingPlayer(gc, delta);
			break;
		}
	}

	public void render(GameContainer gc, Graphics g) throws SlickException {
		switch (this.currentMode) {
			case MODE_LOADING:
				this.renderLoading(gc, g);
			break;
			case MODE_START:
				this.renderStart(gc, g);
			break;
			case MODE_LOGIN:
				this.renderLogin(gc, g);
			break;			
			case MODE_MAIN_MENU:
				this.renderMainMenu(gc, g);
			break;	
			case MODE_CREDITS:
				this.renderCredits(gc, g);
			break;
			case MODE_ROOM_SELECTION:
				this.renderRoomSelection(gc, g);
			break;
			case MODE_CHARACTER_SELECTION:
				this.renderCharacterSelection(gc, g);
			break;
			case MODE_AWAITING_PLAYER:
				this.renderAwaitingPlayer(gc, g);
			break;
		}
	}
	
	public void updateLoading(GameContainer gc, int delta) throws SlickException {
		switch(this.loadingIndex++) {
			case 1:
				this.backgroundOptions = new Image("assets/sprites/scenes/menu/background-options.jpg");
				break;
			case 2:
				this.backgroundCharacters = new Image("assets/sprites/scenes/menu/character-selection.jpg");
				break;
			case 3:
				this.backgroundRoomSelection = new Image("assets/sprites/scenes/menu/room_selection.png");
				break;
			case 4:
				this.backgroundCredits = new Image("assets/sprites/scenes/menu/credits.jpg");
				break;
			case 5:
				this.logo = new Image("assets/sprites/scenes/logo.png");
				break;
			case 6:
				this.divisionRoomSelection = new Image("assets/sprites/scenes/menu/room_selection_division.png");
				break;
			case 7:
				this.icoAnkh = new Image("assets/sprites/characters/ankh/ico.png");
				break;
			case 8:
				this.icoDobot = new Image("assets/sprites/characters/dobot/ico.png");
				break;
			case 9:
				this.fontCopyright = AssetsUtil.loadFont("calibrib.ttf", 18, true, false, java.awt.Color.black);
				break;
			case 10:
				this.fontLogin = AssetsUtil.loadFont("calibrib.ttf", 33, true, false, java.awt.Color.white);
				break;
			case 11:
				this.fontStart = AssetsUtil.loadFont("BRLNSDB.TTF", 50, true, false, java.awt.Color.yellow, java.awt.Color.decode("#EE7600"), 2);
				break;
			case 12:
				this.fontMenuInfo = AssetsUtil.loadFont("BRLNSDB.TTF", 30, true, false, java.awt.Color.white, java.awt.Color.black, 1);
				break;
			case 13:
				this.fontRoomSelection = AssetsUtil.loadFont("calibrib.ttf", 14, false, false, java.awt.Color.black);
				break;
			case 14:
				this.fontRoomSelectionWindow = AssetsUtil.loadFont("calibrib.ttf", 16, false, false, java.awt.Color.decode("#DCDCDC"));
				break;
			case 15:
				this.fontDescription = AssetsUtil.loadFont("calibrib.ttf", 18, true, false, java.awt.Color.decode("#FFFFFF"));
				break;
			case 16:
				this.fontCredits = AssetsUtil.loadFont("calibrib.ttf", 26, true, false, java.awt.Color.white, java.awt.Color.decode("#DCDCDC"), 1);
				break;
			case 17:				
				this.txtUserName = new TextField(gc, this.fontLogin, 390, 268, 180, 38, new ComponentListener() {
					public void componentActivated(AbstractComponent source) {
						Loader.Username = txtUserName.getText();
						txtPassword.setFocus(true);
					}
				});
				this.txtUserName.setMaxLength(8);
				break;
			case 18:
				this.txtPassword = new TextField(gc, this.fontLogin, 390, 338, 180, 38, new ComponentListener() {
					public void componentActivated(AbstractComponent source) {
						Loader.Password = txtPassword.getText();
						txtUserName.setFocus(true);
					}
				});
				this.txtPassword.setMaxLength(8);
				break;
			case 19:				
				this.txtAnkhDescription = new TextField(gc, this.fontDescription, 175, 87, 435, 195, new ComponentListener() {
					public void componentActivated(AbstractComponent source) {
					}
				});
				this.txtAnkhDescription.setText(Loader.Localization.getAnkhDescription().replace("$", "\n"));
				this.txtAnkhDescription.setAcceptingInput(false);
				break;
			case 20:				
				this.txtDobotDescription = new TextField(gc, this.fontDescription, 175, 87, 435, 195, new ComponentListener() {
					public void componentActivated(AbstractComponent source) {
					}
				});
				this.txtDobotDescription.setText(Loader.Localization.getDobotDescription().replace("$", "\n"));
				this.txtDobotDescription.setAcceptingInput(false);		
				break;
			case 21:				
				//Cria as áreas do login.
				this.areasLogin[0] = new MouseOverArea(gc, new Image("assets/sprites/button.png"), 500, 406, 69, 31, this);
				this.areasLogin[1] = new MouseOverArea(gc, new Image("assets/sprites/close.png"), 575, 150, 24, 24, this);
				for (MouseOverArea area : this.areasLogin) {
					area.setNormalColor(new org.newdawn.slick.Color(1,1,1,0.8f));
					area.setMouseOverColor(new org.newdawn.slick.Color(1,1,1,0.9f));
				}
				break;
			case 22:
				//Cria as áreas do menu principal.
				this.areasMenu[0] = new MouseOverArea(gc, new Image("assets/sprites/scenes/menu/border-host-game.png"), 468, 375, 95, 155, this);
				this.areasMenu[1] = new MouseOverArea(gc, new Image("assets/sprites/scenes/menu/border-join-game.png"), 245, 241, 180, 120, this);
				this.areasMenu[2] = new MouseOverArea(gc, new Image("assets/sprites/scenes/menu/border-credits.png"), 415, 311, 140, 70, this);
				for (MouseOverArea area : this.areasMenu) {
					area.setNormalColor(new org.newdawn.slick.Color(1,1,1,0.8f));
					area.setMouseOverColor(new org.newdawn.slick.Color(1,1,0,1.0f));
				}
				break;
			case 23:
				//Cria as áreas de seleção de personagem.
				this.areasCharacterSelecion[0] = new MouseOverArea(gc, new Image("assets/sprites/scenes/menu/border-ankh.png"), 257, 295, 120, 220, this);
				this.areasCharacterSelecion[1] = new MouseOverArea(gc, new Image("assets/sprites/scenes/menu/border-dobot.png"), 387, 297, 150, 220, this);
				for (MouseOverArea area : this.areasCharacterSelecion) {
					area.setNormalColor(new org.newdawn.slick.Color(1,1,1,0.0f));
					area.setMouseOverColor(new org.newdawn.slick.Color(1,1,0,1.0f));
				}
				break;
			case 24:
				this.roomSelectionStartY = 133;
				this.roomSelectionDiffY = 30;

				this.roomSelectionPositionsX[0] = 40; //Logo do personagem.
				this.roomSelectionPositionsX[1] = 94; //Usuário.
				this.roomSelectionPositionsX[2] = 320; //Personagem.
				this.roomSelectionPositionsX[3] = 540; //Nível.
				this.roomSelectionPositionsX[4] = 600; //Data criação.
				
				this.areasRoomSelectionSupport = new MouseOverArea[2];
				this.areasRoomSelectionSupport[0] = new MouseOverArea(gc, new Image("assets/sprites/scenes/menu/room_back.png"), 50, 57, 17, 17, this);
				this.areasRoomSelectionSupport[0].setNormalColor(new org.newdawn.slick.Color(1,0,0,0.4f));
				this.areasRoomSelectionSupport[0].setMouseOverColor(new org.newdawn.slick.Color(1,0,0,0.8f));
				this.areasRoomSelectionSupport[1] = new MouseOverArea(gc, new Image("assets/sprites/scenes/menu/room_refresh.png"), 51, 80, 21, 23, this);
				this.areasRoomSelectionSupport[1].setNormalColor(new org.newdawn.slick.Color(0,0,1,0.4f));
				this.areasRoomSelectionSupport[1].setMouseOverColor(new org.newdawn.slick.Color(0,0,1,0.8f));
				break;
			case 25:
				this.optionMessage = Loader.Localization.getBaseMenuMessage();
				break;
			case 26:
				this.sndOption = new Sound("assets/soundfx/option.ogg");
				break;
			case 27:
				this.musBackground = new Music("assets/soundfx/neighborhood.ogg");
				break;
			case 28:
				this.musBackground.loop();
				break;
			case 29:				
				//Verifica se o usuário está logado.
				if (Loader.isUserLogged())
					this.currentMode = MODE_MAIN_MENU;
				else
					this.currentMode = MODE_START;
				
				Loader.Container.setMouseCursor("assets/sprites/cursor.png", 0, 0);
				break;
		}
	}
	
	public void updateStart(GameContainer gc, int delta) throws SlickException {
		if (gc.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON)) this.currentMode = MODE_LOGIN;
	}
	
	public void updateLogin(GameContainer gc, int delta) throws SlickException {
		
	}
	
	public void updateMainMenu(GameContainer gc, int delta) throws SlickException {
		if (this.areasMenu[0].isMouseOver()) {
			this.optionMessage = Loader.Localization.getHostGame();
			if (!this.overMenu[0]) {
				this.sndOption.play();
				this.overMenu[0] = true;
				this.overMenu[1] = this.overMenu[2] = false;
			}
		} else if (this.areasMenu[1].isMouseOver()) {
			this.optionMessage = Loader.Localization.getJoinGame();
			if (!this.overMenu[1]) {
				this.sndOption.play();
				this.overMenu[1] = true;
				this.overMenu[0] = this.overMenu[2] = false;
			}
		} else if (this.areasMenu[2].isMouseOver()) {
			this.optionMessage = Loader.Localization.getCredits();
			if (!this.overMenu[2]) {
				this.sndOption.play();
				this.overMenu[2] = true;
				this.overMenu[0] = this.overMenu[1] = false;
			}
		} else {
			this.optionMessage = Loader.Localization.getBaseMenuMessage();
			this.overMenu[0] = this.overMenu[1] = this.overMenu[2] = false;
		}
	}
	
	public void updateCredits(GameContainer gc, int delta) throws SlickException {
		if (gc.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON)) this.currentMode = MODE_MAIN_MENU;
	}
	
	public void updateRoomSelection(GameContainer gc, int delta) throws SlickException {
		if (++this.analysisGameRoomDelay > 500) {
			this.analysisGameRoomDelay = 0;
			this.availableGameRooms = ServiceFacade.getAllGameRoomInfoAvailable();
			
			this.areasRoomSelection = new MouseOverArea[this.availableGameRooms.length];
			
			for (int i = 0, posY = this.roomSelectionStartY; i < this.areasRoomSelection.length; i++, posY += 30) {
				Image ico = null;
				
				switch (this.availableGameRooms[i].getIdCharacterType()) {
					case 1:
					default:
						ico = this.icoDobot;
						break;
					case 2:
						ico = this.icoAnkh;
						break;
				}
				
				ico.draw(this.roomSelectionPositionsX[0], posY);
				
				this.areasRoomSelection[i] = new MouseOverArea(gc
					, ico
					, this.roomSelectionPositionsX[0]
					, posY
					, 721
					, 30
					, this);
				this.areasRoomSelection[i].setNormalColor(new org.newdawn.slick.Color(1,1,1,0.5f));
				this.areasRoomSelection[i].setMouseOverColor(new org.newdawn.slick.Color(1,1,1,1.0f));
			}
		}
	}
	
	public void updateCharacterSelection(GameContainer gc, int delta) throws SlickException {
		
	}
	
	public void updateAwaitingPlayer(GameContainer gc, int delta) throws SlickException {
		if (++analysisDelay > 50) {
			analysisDelay = 0;
			if (this.isHost) {
				//Verifica se alguém entrou na sala do jogador.
				this.currentGameRoom = ServiceFacade.getGameRoomByHostOwner();
				
				if (this.currentGameRoom.getIdplayercharacterchallenger() > 0) {
					Object[] params = new Object[4];
					params[0] = this.currentSelectedCharacter;
					params[1] = this.getPlayerInfo(this.currentGameRoom.getIdplayercharacterchallenger(), false);
					params[2] = true;
					params[3] = this.currentGameRoom.getIdgameroom();
					this.fireEndSceneEvent(params);
				}
			} else {
				//Não sendo host, cria os dados de ambos os jogadores e dispara fim de cena.
				
				//Registra o jogador na sala.
				if (ServiceFacade.registerGameRoom(this.currentSelectedCharacter.idCharacter, this.currentGameRoom.getIdgameroom())) {
					Object[] params = new Object[5];
					params[0] = this.getPlayerInfo(this.currentGameRoom.getIdplayercharacterowner(), true);
					params[1] = this.currentSelectedCharacter;
					params[2] = false;
					params[3] = this.currentGameRoom.getIdgameroom();
					params[4] = this.currentGameRoom.getHostowner();
					this.fireEndSceneEvent(params);
				} else {
					this.currentMode = MODE_ROOM_SELECTION;
				}
			}
		}
	}
	
	private void renderLoading(GameContainer gc, Graphics g) throws SlickException {
		this.background.draw(0, 0);

	    String textLoading = Loader.Localization.getLoading();
	    int x = 720 - this.fontLoading.getWidth(textLoading);
	    this.fontLoading.drawString(x, 550, textLoading);
	    
	    int percentage = (int) ((this.loadingIndex / (float)TOTAL_LOADING_RESOURCES) * 100);
	    this.fontLoading.drawString(730, 550, String.valueOf(percentage) + "%");
	}
	
	public void renderStart(GameContainer gc, Graphics g) throws SlickException {
		this.background.draw(0, 0);
		this.logo.draw(95, 50);

		Util.drawStringCenter(this.fontCopyright, "© 2010 Astirina Group", 575);
		Util.drawStringCenter(this.fontStart, Loader.Localization.getClickToStart(), 450);
		
		this.fontCopyright.drawString(680, 575, "v10.6.10.2104-2");
	}
	
	public void renderLogin(GameContainer gc, Graphics g) throws SlickException {
		this.background.draw(0, 0);

		g.setAntiAlias(true);
		g.setColor(Util.BoxBgColor);
		g.fillRoundRect(185, 133, 430, 335, 10);
		g.setColor(Util.LineColor);
		g.drawRoundRect(185, 133, 430, 335, 10);
		
		Util.drawStringCenter(this.fontStart, "Login", 170);
		this.fontLogin.drawString(230, 268, Loader.Localization.getUsername() + ":");
		this.fontLogin.drawString(230, 338, Loader.Localization.getPassword() + ":");
		this.txtUserName.render(gc, g);
		this.txtPassword.render(gc, g);

		for (MouseOverArea area : this.areasLogin) area.render(gc, g);
	}
	
	public void renderMainMenu(GameContainer gc, Graphics g) throws SlickException {
		this.backgroundOptions.draw(0, 0);
		for (MouseOverArea area : this.areasMenu) area.render(gc, g);
		
		this.fontMenuInfo.drawString(20, 550, this.optionMessage);
		this.fontCopyright.drawString(10, 10, Loader.Localization.getLoggedAs() + " " + Loader.Username);
	}
	
	public void renderCredits(GameContainer gc, Graphics g) throws SlickException {
		this.backgroundCredits.draw(0, 0);
	}
	
	public void renderRoomSelection(GameContainer gc, Graphics g) throws SlickException {
		this.backgroundRoomSelection.draw(0, 0);
		
		if (this.areasRoomSelection != null) {
			for (MouseOverArea area : this.areasRoomSelection) area.render(gc, g);
		}
		
		for (MouseOverArea area : this.areasRoomSelectionSupport) area.render(gc, g);
		
		this.fontRoomSelectionWindow.drawString(124, 56, Loader.Localization.getRoomSelection());
		this.fontRoomSelectionWindow.drawString(100, 548, Loader.Localization.getRoomSelection());
		
		//Desenha o cabeçalho.
		int posYHeader = 109;		
		int diffSeparator = 18;	
		int diffFont = 3;
		this.divisionRoomSelection.draw(this.roomSelectionPositionsX[1] - diffSeparator, posYHeader);
		this.fontRoomSelection.drawString(this.roomSelectionPositionsX[1], posYHeader + diffFont, Loader.Localization.getUsername());
		this.divisionRoomSelection.draw(this.roomSelectionPositionsX[2] - diffSeparator, posYHeader);
		this.fontRoomSelection.drawString(this.roomSelectionPositionsX[2], posYHeader + diffFont, Loader.Localization.getCharacter());
		this.divisionRoomSelection.draw(this.roomSelectionPositionsX[3] - diffSeparator, posYHeader);
		this.fontRoomSelection.drawString(this.roomSelectionPositionsX[3], posYHeader + diffFont, Loader.Localization.getLevel());
		this.divisionRoomSelection.draw(this.roomSelectionPositionsX[4] - diffSeparator, posYHeader);
		this.fontRoomSelection.drawString(this.roomSelectionPositionsX[4], posYHeader + diffFont, Loader.Localization.getDateCreation());
		
		int posY = this.roomSelectionStartY + 7;
		
		if (this.availableGameRooms != null) {
			for (GameRoomInfo gri : this.availableGameRooms) {
				this.fontRoomSelection.drawString(this.roomSelectionPositionsX[1], posY, gri.getUserName());
				this.fontRoomSelection.drawString(this.roomSelectionPositionsX[2], posY, gri.getCharacterName());
				this.fontRoomSelection.drawString(this.roomSelectionPositionsX[3], posY, String.valueOf(gri.getCharacterLevel()));
				
				Locale local = new Locale("pt", "BR");
			    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm", local);
				this.fontRoomSelection.drawString(this.roomSelectionPositionsX[4], posY, sdf.format(gri.getCreationDate().getTime()));
				
				posY += this.roomSelectionDiffY;
			}
		}
	}
	
	public void renderCharacterSelection(GameContainer gc, Graphics g) throws SlickException {
		this.backgroundCharacters.draw(0, 0);
		for (MouseOverArea area : this.areasCharacterSelecion) area.render(gc, g);

		if (this.areasCharacterSelecion[0].isMouseOver()) { //Ankh.
			this.fontStart.drawString(185, 105, "Ankh");
			this.txtAnkhDescription.render(gc, g);
		} else if (this.areasCharacterSelecion[1].isMouseOver()) { //Dôbot.
			this.fontStart.drawString(185, 105, "Dôbot");
			this.txtDobotDescription.render(gc, g);
		} else {
			this.logo.draw(180, 65, 0.7f);
		}
		
		Util.drawStringCenter(this.fontCopyright, Loader.Localization.getCharacterSelection(), 555);
	}
	
	public void renderAwaitingPlayer(GameContainer gc, Graphics g) throws SlickException {
		this.logo.draw(95, 50);
		Util.drawStringCenter(this.fontLoading, Loader.Localization.getAwaitingPlayer(), 450);
	}
	
	public void componentActivated(AbstractComponent source) {		
		switch (this.currentMode) {
			case MODE_LOGIN:
				if (source == this.areasLogin[0]) { //OK
					Player p = ServiceFacade.authenticate(this.txtUserName.getText(), this.txtPassword.getText());
					
					if (p.getIdplayer() == 0) {
						this.txtUserName.setText("");
						this.txtPassword.setText("");
					} else {
						this.currentMode = MODE_MAIN_MENU;
						Loader.IdUser = p.getIdplayer();
						Loader.Username = p.getUsername();
						Loader.Password = p.getPassword();
					}
				} else if (source == this.areasLogin[1]) { //FECHAR
					this.txtUserName.setText("");
					this.txtPassword.setText("");
					this.currentMode = MODE_START;
				}
			break;			
			case MODE_MAIN_MENU:
				if (source == this.areasMenu[0]) {
					this.isHost = true;
					this.currentMode = MODE_CHARACTER_SELECTION;
				} else if (source == this.areasMenu[1]) {
					this.isHost = false;
					this.currentMode = MODE_ROOM_SELECTION;
				} else if (source == this.areasMenu[2]) {
					this.currentMode = MODE_CREDITS;
				}
			break;		
			case MODE_ROOM_SELECTION:
				for (int i = 0; i < this.areasRoomSelection.length; i++) {
					if (source == this.areasRoomSelection[i]) {
						this.currentGameRoom = ServiceFacade.getGameRoomByHostOwner(this.availableGameRooms[i].getHostOwner());
						this.currentMode = MODE_CHARACTER_SELECTION;
						break;
					}
				}
				
				if (source == this.areasRoomSelectionSupport[0]) //Back.
					this.currentMode = MODE_MAIN_MENU;
				else if (source == this.areasRoomSelectionSupport[1]) //Refresh.
					this.analysisGameRoomDelay = 500;
			break;
			case MODE_CHARACTER_SELECTION:
				if (source == this.areasCharacterSelecion[0]) {
					this.setCurrentPlayerCharacter(2); //Ankh.
				} else if (source == this.areasCharacterSelecion[1]) {
					this.setCurrentPlayerCharacter(1); //Dõbot.
				}
			break;
		}
		
		Loader.Container.getInput().clearControlPressedRecord();
		Loader.Container.getInput().clearMousePressedRecord();
	}
	
	/**
	 * Define um personagem atual para o jogador.
	 * Caso o jogador não possua o personagem, cria-o.
	 * @param idCharacterType ID do tipo do personagem a ser obtido.
	 */
	private void setCurrentPlayerCharacter(int idCharacterType) {
		Playercharacter[] pcs = ServiceFacade.getAllPlayerCharacterForCurrentPlayer();
		Playercharacter current = null;

		//Verifica se o usuário já possui o personagem cadastrado.
		for (Playercharacter pc : pcs) {
			if (pc.getIdcharactertype() == idCharacterType) {
				current = pc;
				break;
			}
		}
		
		//Verifica se o personagem foi encontrado.
		if (current == null) {
			//Não sendo encontrado, cria-o.
			int id = ServiceFacade.createPlayerCharacter(idCharacterType);
			current = ServiceFacade.getPlayerCharacterById(id);
		}
		
		this.currentSelectedCharacter = this.getPlayerInfo(current.getIdplayercharacter(), this.isHost);
		
		//Se o jogador for HOST, cria a sala.
		if (this.isHost) {
			this.currentGameRoom = ServiceFacade.createGameRoom(this.currentSelectedCharacter.idCharacter);
		}
		
		this.currentMode = MODE_AWAITING_PLAYER;
	}
	
	/**
	 * Obtém informações do personagem de um jogador.
	 * @param idCharacter	ID do personagem.
	 * @param isHost		Indica se o personagem é o do jogador host.
	 * @return Informações sobre personagem de um jogador.
	 */
	private PlayerInfo getPlayerInfo(int idCharacter, boolean isHost) {
		Playercharacter pc = ServiceFacade.getPlayerCharacterById(idCharacter);
		Player p = ServiceFacade.getPlayerById(pc.getIdplayer());

		int score = ServiceFacade.getPlayerScore(p.getUsername(), p.getPassword());
		String characterScript;
			switch (pc.getIdcharactertype()) {
			case 1:
			default:
				characterScript = "assets/scripts/character-dobot.lua";
				break;
			case 2:
				characterScript = "assets/scripts/character-ankh.lua";
				break;
		}

		return new PlayerInfo(p.getUsername(), idCharacter, characterScript, isHost, pc.getLevel(), score, pc.getXp());
	}
}
