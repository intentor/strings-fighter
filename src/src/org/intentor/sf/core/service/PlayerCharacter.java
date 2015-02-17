package org.intentor.sf.core.service;

public class PlayerCharacter {
    private int idplayercharacter;

    private java.lang.Integer idplayer;

    private java.lang.Integer idcharactertype;

    private java.lang.Integer level;

    private java.lang.Integer xp;

    private java.util.Calendar createdAt;

    public PlayerCharacter() {
    }

    public PlayerCharacter(
           int idplayercharacter,
           java.lang.Integer idplayer,
           java.lang.Integer idcharactertype,
           java.lang.Integer level,
           java.lang.Integer xp,
           java.util.Calendar createdAt) {
        this.idplayercharacter = idplayercharacter;
        this.idplayer = idplayer;
        this.idcharactertype = idcharactertype;
        this.level = level;
        this.xp = xp;
        this.createdAt = createdAt;
    }


    /**
     * Gets the idplayercharacter value for this Playercharacter.
     * 
     * @return idplayercharacter
     */
    public int getIdplayercharacter() {
        return idplayercharacter;
    }


    /**
     * Sets the idplayercharacter value for this Playercharacter.
     * 
     * @param idplayercharacter
     */
    public void setIdplayercharacter(int idplayercharacter) {
        this.idplayercharacter = idplayercharacter;
    }


    /**
     * Gets the idplayer value for this Playercharacter.
     * 
     * @return idplayer
     */
    public java.lang.Integer getIdplayer() {
        return idplayer;
    }


    /**
     * Sets the idplayer value for this Playercharacter.
     * 
     * @param idplayer
     */
    public void setIdplayer(java.lang.Integer idplayer) {
        this.idplayer = idplayer;
    }


    /**
     * Gets the idcharactertype value for this Playercharacter.
     * 
     * @return idcharactertype
     */
    public java.lang.Integer getIdcharactertype() {
        return idcharactertype;
    }


    /**
     * Sets the idcharactertype value for this Playercharacter.
     * 
     * @param idcharactertype
     */
    public void setIdcharactertype(java.lang.Integer idcharactertype) {
        this.idcharactertype = idcharactertype;
    }


    /**
     * Gets the level value for this Playercharacter.
     * 
     * @return level
     */
    public java.lang.Integer getLevel() {
        return level;
    }


    /**
     * Sets the level value for this Playercharacter.
     * 
     * @param level
     */
    public void setLevel(java.lang.Integer level) {
        this.level = level;
    }


    /**
     * Gets the xp value for this Playercharacter.
     * 
     * @return xp
     */
    public java.lang.Integer getXp() {
        return xp;
    }


    /**
     * Sets the xp value for this Playercharacter.
     * 
     * @param xp
     */
    public void setXp(java.lang.Integer xp) {
        this.xp = xp;
    }


    /**
     * Gets the createdAt value for this Playercharacter.
     * 
     * @return createdAt
     */
    public java.util.Calendar getCreatedAt() {
        return createdAt;
    }
}
