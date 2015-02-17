package org.intentor.sf.scenes;

import org.intentor.sf.core.events.SceneEndedEvent;
import org.intentor.sf.core.GameScene;
import org.intentor.sf.core.LocalizationData;
import org.intentor.sf.core.PlayerInfo;
import org.intentor.sf.core.SupportedLanguages;
import org.intentor.sf.core.Util;
import org.intentor.sf.core.listeners.SceneEventsListener;
import org.intentor.sf.core.processors.ServerSocketProcessor;
import org.intentor.sf.core.processors.SocketProcessor;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Loader extends BasicGame implements SceneEventsListener {
	
	public Loader() {
		super("Strings Fighter");
	}

	/**
	 * Altura da tela de jogo.
	 */
	public final static int SCREEN_WIDTH = 800;
	
	/**
	 * Altura da tela de jogo.
	 */
	public final static int SCREEN_HEIGHT = 600;
	
	/**
	 * Idioma do jogo.
	 */
	public static SupportedLanguages CurrentLanguage = SupportedLanguages.English;
	
	/**
	 * Dados de localização do idioma atual.
	 */
	public static LocalizationData Localization;
	
	/**
	 * Container do jogo.
	 */
	public static GameContainer Container;
	
	/**
	 * Container da aplicação.
	 */
	public static AppGameContainer App;
	
	/**
	 * Nome do usuário logado.
	 */
	public static String Username;
	
	/**
	 * Senha do usuário.
	 */
	public static String Password;
	
	/**
	 * ID do usuário logado.
	 */
	public static int IdUser;
	
	/**
	 * Cena atual em exibição.
	 */
	private GameScene currentScene;
	
	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new Loader());
		app.setIcon("assets/sprites/icon-large.png");
		app.setDisplayMode(SCREEN_WIDTH, SCREEN_HEIGHT, false);
		app.setAlwaysRender(true);
		app.setVSync(true);
		app.setSmoothDeltas(false);
		app.setShowFPS(false);
		app.setFullscreen(false);
		app.start();
	}
	
	/**
	 * Verifica se há algum usuário logado no jogo.
	 * return Valor booleano indicando se há um usuário logado.
	 */
	public static boolean isUserLogged() {
		return (Loader.Username != null && Loader.Password != null);
	}

	/**
	 * Carrega uma cena de jogo.
	 * @param scene Cena a ser carregada.
	 */
	private void loadScene(GameScene scene) {
		this.currentScene = scene;
		this.currentScene.addListener(this);
		try {
			this.currentScene.init(Loader.Container);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void init(GameContainer gc) throws SlickException {
		//Inicializa cores.
		Util.LineColor = Color.decode("#DCDCDC");
		Util.BoxBgColor = Color.decode("#808080");
		Util.BoxBgColor.a = 0.5f;
		
		Loader.App = (AppGameContainer) gc;
		Loader.App.setIcon("assets/sprites/icon-mini.png");
		Loader.Container = gc;
		
		this.loadScene(new LanguageSelectionScene());
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		//Verifica se é para exibir FULL SCREEN.
		if (gc.getInput().isKeyPressed(Input.KEY_F3)) {
			gc.setFullscreen(!gc.isFullscreen());
		}
		
		this.currentScene.update(gc, delta);
	}

	@Override
	public void render(GameContainer gc, Graphics delta) throws SlickException {
		this.currentScene.render(gc, delta);
	}

	@Override
	public void sceneEndedReceived(SceneEndedEvent e) {
		try {
			this.currentScene.dispose();
		} catch (SlickException e1) {
			e1.printStackTrace();
		}
		this.currentScene = null;
		
		String scene = e.getSceneName();
		if (scene.equals("scenes.LanguageSelectionScene") || scene.equals("scenes.FightingScene")) {
			this.loadScene(new MenuScene());
		} else if (scene.equals("scenes.MenuScene")) {
			if ((Boolean)e.getParams()[2]) {
				FightingScene fs = new FightingScene((PlayerInfo)e.getParams()[0]
				                   				      , (PlayerInfo)e.getParams()[1]
				                   				      , ((Number)e.getParams()[3]).intValue());

				//Cria o socket de conexão com o servidor.
				SocketProcessor socket = new ServerSocketProcessor(4444);
				socket.addConnectionListener(fs);
				socket.start();
				fs.socket = socket;
				
				this.loadScene(fs);
			} else {
				this.loadScene(new FightingScene((PlayerInfo)e.getParams()[0]
				                              , (PlayerInfo)e.getParams()[1]
				                              , ((Number)e.getParams()[3]).intValue()
				                              , (String)e.getParams()[4]));
			}
		}
	}
}
