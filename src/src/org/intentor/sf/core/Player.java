package org.intentor.sf.core;

import org.intentor.sf.core.scripts.ClanAttributes;
import org.keplerproject.luajava.LuaException;
import org.keplerproject.luajava.LuaObject;
import org.keplerproject.luajava.LuaState;
import org.keplerproject.luajava.LuaStateFactory;


/**
 * Representa um jogador.
 */
public class Player {

	/**
	 * Nome do jogador.
	 */
	private String playerName;

	/**
	 * Nível do jogador.
	 */
	private int initialLevel;
	
	/**
	 * Nível inicial do jogador.
	 */
	private int level;
	
	/**
	 * Pontuação inicial do jogador.
	 */
	private int initialScore;
	
	/**
	 * Pontuação do jogador.
	 */
	private int score;
	
	/**
	 * Pontos de experiência do jogador.
	 */
	private int experiencePoints;
	
	/**
	 * ID do personagem do jogador.
	 */
	private int idCharacter;
	
	/**
	 * Personagem do jogador no jogo.
	 */
	private FightingCharacter playerCharacter;
	
	/**
	 * Atributos do clã do personagem.
	 */
	private ClanAttributes clanAttributes;
	
	/**
	 * Arquivo Lua de leitura dos dados do clã.
	 */
	private LuaState luaFile;
	
	/**
	 * Atributos do jogador.
	 */
	private PlayerAttributes attributes;
	
	/**
	 * Indica se os atributos do jogador já haviam sido inicializados.
	 */
	private Boolean isStarted = false;
	
	/**
	 * Inicia um novo jogador.
	 * @param playerName		Nome do jogador.	
	 * @param level				Nível atual do jogador.
	 * @param score 			Pontuação atual do jogador.
	 * @param experiencePoints 	Pontos de experiência atuais do jogador.
	 * @param idCharacter		ID do personagem do jogador.
	 * @param playerCharacter	Personagem do jogador no jogo.
	 */
	public Player(String playerName
			, int level
			, int score
			, int experiencePoints
			, int idCharacter
			, FightingCharacter playerCharacter) {
		this.playerName = playerName;
		this.initialLevel = this.level = level;
		this.initialScore = this.score = score;
		this.experiencePoints = experiencePoints;
		this.idCharacter = idCharacter;
		this.playerCharacter = playerCharacter;
		
		this.loadScript();
		
		this.attributes = new PlayerAttributes();
		this.calculatePlayerData();
		this.isStarted = true;
	}
	
	/**
	 * Carrega o script do clã do personagem.
	 */
	private void loadScript() {
		String script = null;

		switch (this.playerCharacter.getClanID()) {
			case 1: //Símbolos
				script = "assets/scripts/clan-symbols.lua";
				break;
			case 2: //Letras
				script = "assets/scripts/clan-letters.lua";
				break;
			case 3: //Guardiões
				script = "assets/scripts/clan-guardians.lua";
				break;
		}
		
		LuaState l = LuaStateFactory.newLuaState();
		l.openLibs();
		l.LdoFile(script);
		LuaObject obj = l.getLuaObject("ClanAttributes");
		try {
			ClanAttributes clan = (ClanAttributes)obj.createProxy("core.scripts.ClanAttributes");
			this.clanAttributes = clan;
			this.luaFile = l;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (LuaException e) {
			e.printStackTrace();
		}	
	}
	
	/**
	 * Descarta o jogador atual.
	 */
	public void dispose() {
		this.luaFile.close();
	}
	
	/**
	 * Calcula os dados do jogador baseado em seu nível.
	 */
	public void calculatePlayerData() {
		//Calcula os atributos do jogador de acordo com as fórmulas.
		
		//HP.
		int diffHP = this.attributes.initialHitPoints;
		this.attributes.initialHitPoints = (int) (this.clanAttributes.getHitPoints() + (this.level - 1) * 99.6); //Máximo de 9999.
		if (this.attributes.initialHitPoints > 9999) this.attributes.initialHitPoints = 9999;	
		diffHP = this.attributes.initialHitPoints - diffHP;
		if (isStarted) this.attributes.hitPoints += diffHP; 
		else this.attributes.hitPoints = this.attributes.initialHitPoints; 

		//MP
		int diffMP = this.attributes.initialMagicPoints;
		this.attributes.initialMagicPoints = this.clanAttributes.getMagicPoints() + (this.level - 1); //Máximo de 102.
		diffMP = this.attributes.initialMagicPoints - diffMP;
		if (isStarted) this.attributes.magicPoints += diffMP;
		else this.attributes.magicPoints = this.attributes.initialMagicPoints;
		
		//Outros atributos.
		this.attributes.strength = (int) (this.clanAttributes.getStrength() + (this.level - 1) * this.clanAttributes.getStrengthFactor()); //Máximo de 104.		
		this.attributes.magicPower = (int) (this.clanAttributes.getMagicPower() + (this.level - 1) * this.clanAttributes.getMagicPowerFactor()); //Máximo de 104.		
		this.attributes.defense = this.clanAttributes.getDefense() + (this.level* 0.0011f); //Máximo de 0.
		if (this.attributes.defense < 0) this.attributes.defense = 0;
		
		if (this.level == 99) this.experiencePoints = this.getMaxExpToNextLevel();
	}
	
	/**
	 * Adiciona pontuação ao jogador.
	 * @param score Pontuação a ser adicionada.
	 */
	public void addScore(int score) {
		this.score += score;
	}
	
	/**
	 * Adiciona pontos de experiência.
	 * @param exp Quantidade de pontos de experiência a serem adicionados.
	 * @return Valor booleano indicando se houve aumento de nível.
	 */
	public Boolean addExperiencePoints(int exp) {
		Boolean levelUp = false;
		
		if (this.level < 99) {
			int expToNextLevel = this.getMaxExpToNextLevel();
			
			if ((this.experiencePoints + exp) >= expToNextLevel) {
				levelUp = true;
				this.level++;
				
				//Verifica se há pontos de experiência para serem guardados para o próximo nível.
				int diff = (this.experiencePoints + exp) - expToNextLevel;
				if (diff > 0) this.experiencePoints = diff;
				else this.experiencePoints = 0;
				
				this.calculatePlayerData();
			} else this.experiencePoints += exp;
		}
		
		return levelUp;
	}
	
	/**
	 * Quantidade de experiência máxima necessária para o próximo nível.
	 * @return
	 */
	public int getMaxExpToNextLevel() {
		return (int) (100 * Math.pow(this.level, 2));
	}
	
	public FightingCharacter character() {
		return playerCharacter;
	}
	
	public String getPlayerName() {
		return playerName;
	}

	public int getInitialLevel() {
		return this.initialLevel;
	}

	public int getLevel() {
		return this.level;
	}

	public int getInitialScore() {
		return this.initialScore;
	}

	public int getScore() {
		return this.score;
	}

	public int getExperiencePoints() {
		return experiencePoints;
	}

	public int getIdCharacter() {
		return idCharacter;
	}

	public PlayerAttributes getAttributes() {
		return attributes;
	}
}
