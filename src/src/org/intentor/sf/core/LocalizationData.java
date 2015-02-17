package org.intentor.sf.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Representa dados de localização.
 */
public final class LocalizationData {
	
	private Map<String, String> data;
	
	/**
	 * Cria um novo conjunto de dados de localização.
	 * @param culture Idioma a ser utilizado.
	 */
	public LocalizationData(SupportedLanguages culture) {
		this.data = new HashMap<String, String>();
		String file;
		
		switch (culture) {
			case English:
			default:
				file = "localization-en";
				break;
				
			case Portugues:
				file = "localization-pt";
				break;
		}
		
		this.loadData(file);
	}
	
	/**
	 * Carrega os dado de idioma do arquivo indicado.
	 * @param file Arquivo do qual os dados serão carregados.
	 */
	private void loadData(String file) {
		File f = new File("assets/scripts/" + file);
		
		try {
			BufferedReader input = new BufferedReader(new FileReader(f));   
	        String line = null;   
			while ((line = input.readLine()) != null){
				String map[] = line.split(":");
				this.data.put(map[0], map[1]);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getClickToStart() {
		return this.data.get("ClickToStart");
	}
	
	public String getUsername() {
		return this.data.get("Username");
	}
	
	public String getPassword() {
		return this.data.get("Password");
	}
	
	public String getCharacter() {
		return this.data.get("Character");
	}
	
	public String getDateCreation() {
		return this.data.get("DateCreation");
	}
	
	public String getScore() {
		return this.data.get("Score");
	}
	
	public String getLevel() {
		return this.data.get("Level");
	}
	
	public String getEXPNextLevel() {
		return this.data.get("EXPNextLevel");
	}
	
	public String getLoading() {
		return this.data.get("Loading");
	}
	
	public String getAwaitingPlayer() {
		return this.data.get("AwaitingPlayer");
	}
	
	public String getLoggedAs() {
		return this.data.get("LoggedAs");
	}
	
	public String getRoomSelection() {
		return this.data.get("RoomSelection");
	}
	
	public String getBaseMenuMessage() {
		return this.data.get("BaseMenuMessage");
	}
	
	public String getHostGame() {
		return this.data.get("HostGame");
	}
	
	public String getJoinGame() {
		return this.data.get("JoinGame");
	}
	
	public String getCredits() {
		return this.data.get("Credits");
	}
	
	public String getCharacterSelection() {
		return this.data.get("CharacterSelection");
	}
	
	public String getDobotDescription() {
		return this.data.get("DobotDescription");
	}
	
	public String getAnkhDescription() {
		return this.data.get("AnkhDescription");
	}
	
	public String getFight() {
		return this.data.get("Fight");
	}
	
	public String getDraw() {
		return this.data.get("Draw");
	}
	
	public String getYouLose() {
		return this.data.get("YouLose");
	}
	
	public String getYouWin() {
		return this.data.get("YouWin");
	}
}
