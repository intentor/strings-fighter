package org.intentor.sf.core.service;

public class GameRoom {
    private int idgameroom;

    private java.lang.Integer idplayercharacterowner;

    private java.lang.String hostowner;

    private java.lang.Integer idplayercharacterchallenger;

    private java.lang.String hostchallenger;

    private java.lang.Integer idplayercharacterwinner;

    private java.util.Calendar wonAt;

    private java.util.Calendar createdAt;

    public GameRoom() {
    }

    public GameRoom(
           int idgameroom,
           java.lang.Integer idplayercharacterowner,
           java.lang.String hostowner,
           java.lang.Integer idplayercharacterchallenger,
           java.lang.String hostchallenger,
           java.lang.Integer idplayercharacterwinner,
           java.util.Calendar wonAt,
           java.util.Calendar createdAt) {
        this.idgameroom = idgameroom;
        this.idplayercharacterowner = idplayercharacterowner;
        this.hostowner = hostowner;
        this.idplayercharacterchallenger = idplayercharacterchallenger;
        this.hostchallenger = hostchallenger;
        this.idplayercharacterwinner = idplayercharacterwinner;
        this.wonAt = wonAt;
        this.createdAt = createdAt;
    }


    /**
     * Gets the idgameroom value for this Gameroom.
     * 
     * @return idgameroom
     */
    public int getIdgameroom() {
        return idgameroom;
    }


    /**
     * Sets the idgameroom value for this Gameroom.
     * 
     * @param idgameroom
     */
    public void setIdgameroom(int idgameroom) {
        this.idgameroom = idgameroom;
    }


    /**
     * Gets the idplayercharacterowner value for this Gameroom.
     * 
     * @return idplayercharacterowner
     */
    public java.lang.Integer getIdplayercharacterowner() {
        return idplayercharacterowner;
    }


    /**
     * Sets the idplayercharacterowner value for this Gameroom.
     * 
     * @param idplayercharacterowner
     */
    public void setIdplayercharacterowner(java.lang.Integer idplayercharacterowner) {
        this.idplayercharacterowner = idplayercharacterowner;
    }


    /**
     * Gets the hostowner value for this Gameroom.
     * 
     * @return hostowner
     */
    public java.lang.String getHostowner() {
        return hostowner;
    }


    /**
     * Sets the hostowner value for this Gameroom.
     * 
     * @param hostowner
     */
    public void setHostowner(java.lang.String hostowner) {
        this.hostowner = hostowner;
    }


    /**
     * Gets the idplayercharacterchallenger value for this Gameroom.
     * 
     * @return idplayercharacterchallenger
     */
    public java.lang.Integer getIdplayercharacterchallenger() {
        return idplayercharacterchallenger;
    }


    /**
     * Sets the idplayercharacterchallenger value for this Gameroom.
     * 
     * @param idplayercharacterchallenger
     */
    public void setIdplayercharacterchallenger(java.lang.Integer idplayercharacterchallenger) {
        this.idplayercharacterchallenger = idplayercharacterchallenger;
    }


    /**
     * Gets the hostchallenger value for this Gameroom.
     * 
     * @return hostchallenger
     */
    public java.lang.String getHostchallenger() {
        return hostchallenger;
    }


    /**
     * Sets the hostchallenger value for this Gameroom.
     * 
     * @param hostchallenger
     */
    public void setHostchallenger(java.lang.String hostchallenger) {
        this.hostchallenger = hostchallenger;
    }


    /**
     * Gets the idplayercharacterwinner value for this Gameroom.
     * 
     * @return idplayercharacterwinner
     */
    public java.lang.Integer getIdplayercharacterwinner() {
        return idplayercharacterwinner;
    }


    /**
     * Sets the idplayercharacterwinner value for this Gameroom.
     * 
     * @param idplayercharacterwinner
     */
    public void setIdplayercharacterwinner(java.lang.Integer idplayercharacterwinner) {
        this.idplayercharacterwinner = idplayercharacterwinner;
    }


    /**
     * Gets the wonAt value for this Gameroom.
     * 
     * @return wonAt
     */
    public java.util.Calendar getWonAt() {
        return wonAt;
    }


    /**
     * Sets the wonAt value for this Gameroom.
     * 
     * @param wonAt
     */
    public void setWonAt(java.util.Calendar wonAt) {
        this.wonAt = wonAt;
    }


    /**
     * Gets the createdAt value for this Gameroom.
     * 
     * @return createdAt
     */
    public java.util.Calendar getCreatedAt() {
        return createdAt;
    }


    /**
     * Sets the createdAt value for this Gameroom.
     * 
     * @param createdAt
     */
    public void setCreatedAt(java.util.Calendar createdAt) {
        this.createdAt = createdAt;
    }
}
