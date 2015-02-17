package org.intentor.sf.core.service;

public class GameRoomInfo {
    private int idGameRoom;

    private java.lang.String userName;

    private int idCharacterType;

    private java.lang.String characterName;

    private int characterLevel;

    private java.lang.String hostOwner;

    private java.util.Calendar creationDate;

    public GameRoomInfo() {
    }

    public GameRoomInfo(
           int idGameRoom,
           java.lang.String userName,
           int idCharacterType,
           java.lang.String characterName,
           int characterLevel,
           java.lang.String hostOwner,
           java.util.Calendar creationDate) {
           this.idGameRoom = idGameRoom;
           this.userName = userName;
           this.idCharacterType = idCharacterType;
           this.characterName = characterName;
           this.characterLevel = characterLevel;
           this.hostOwner = hostOwner;
           this.creationDate = creationDate;
    }


    /**
     * Gets the idGameRoom value for this GameRoomInfo.
     * 
     * @return idGameRoom
     */
    public int getIdGameRoom() {
        return idGameRoom;
    }


    /**
     * Sets the idGameRoom value for this GameRoomInfo.
     * 
     * @param idGameRoom
     */
    public void setIdGameRoom(int idGameRoom) {
        this.idGameRoom = idGameRoom;
    }


    /**
     * Gets the userName value for this GameRoomInfo.
     * 
     * @return userName
     */
    public java.lang.String getUserName() {
        return userName;
    }


    /**
     * Sets the userName value for this GameRoomInfo.
     * 
     * @param userName
     */
    public void setUserName(java.lang.String userName) {
        this.userName = userName;
    }


    /**
     * Gets the idCharacterType value for this GameRoomInfo.
     * 
     * @return idCharacterType
     */
    public int getIdCharacterType() {
        return idCharacterType;
    }


    /**
     * Sets the idCharacterType value for this GameRoomInfo.
     * 
     * @param idCharacterType
     */
    public void setIdCharacterType(int idCharacterType) {
        this.idCharacterType = idCharacterType;
    }


    /**
     * Gets the characterName value for this GameRoomInfo.
     * 
     * @return characterName
     */
    public java.lang.String getCharacterName() {
        return characterName;
    }


    /**
     * Sets the characterName value for this GameRoomInfo.
     * 
     * @param characterName
     */
    public void setCharacterName(java.lang.String characterName) {
        this.characterName = characterName;
    }


    /**
     * Gets the characterLevel value for this GameRoomInfo.
     * 
     * @return characterLevel
     */
    public int getCharacterLevel() {
        return characterLevel;
    }


    /**
     * Sets the characterLevel value for this GameRoomInfo.
     * 
     * @param characterLevel
     */
    public void setCharacterLevel(int characterLevel) {
        this.characterLevel = characterLevel;
    }


    /**
     * Gets the hostOwner value for this GameRoomInfo.
     * 
     * @return hostOwner
     */
    public java.lang.String getHostOwner() {
        return hostOwner;
    }


    /**
     * Sets the hostOwner value for this GameRoomInfo.
     * 
     * @param hostOwner
     */
    public void setHostOwner(java.lang.String hostOwner) {
        this.hostOwner = hostOwner;
    }


    /**
     * Gets the creationDate value for this GameRoomInfo.
     * 
     * @return creationDate
     */
    public java.util.Calendar getCreationDate() {
        return creationDate;
    }


    /**
     * Sets the creationDate value for this GameRoomInfo.
     * 
     * @param creationDate
     */
    public void setCreationDate(java.util.Calendar creationDate) {
        this.creationDate = creationDate;
    }
}
