package org.intentor.sf.core.service;

public class Player  {
    private int idplayer;

    private java.lang.Integer score;

    private java.lang.String username;

    private java.lang.String password;

    private java.lang.Short active;

    public Player() {
    }

    public Player(
           int idplayer,
           java.lang.Integer score,
           java.lang.String username,
           java.lang.String password,
           java.lang.Short active) {
        this.idplayer = idplayer;
        this.score = score;
        this.username = username;
        this.password = password;
        this.active = active;
    }


    /**
     * Gets the idplayer value for this Player.
     * 
     * @return idplayer
     */
    public int getIdplayer() {
        return idplayer;
    }


    /**
     * Sets the idplayer value for this Player.
     * 
     * @param idplayer
     */
    public void setIdplayer(int idplayer) {
        this.idplayer = idplayer;
    }


    /**
     * Gets the score value for this Player.
     * 
     * @return score
     */
    public java.lang.Integer getScore() {
        return score;
    }


    /**
     * Sets the score value for this Player.
     * 
     * @param score
     */
    public void setScore(java.lang.Integer score) {
        this.score = score;
    }


    /**
     * Gets the username value for this Player.
     * 
     * @return username
     */
    public java.lang.String getUsername() {
        return username;
    }


    /**
     * Sets the username value for this Player.
     * 
     * @param username
     */
    public void setUsername(java.lang.String username) {
        this.username = username;
    }


    /**
     * Gets the password value for this Player.
     * 
     * @return password
     */
    public java.lang.String getPassword() {
        return password;
    }


    /**
     * Sets the password value for this Player.
     * 
     * @param password
     */
    public void setPassword(java.lang.String password) {
        this.password = password;
    }


    /**
     * Gets the active value for this Player.
     * 
     * @return active
     */
    public java.lang.Short getActive() {
        return active;
    }


    /**
     * Sets the active value for this Player.
     * 
     * @param active
     */
    public void setActive(java.lang.Short active) {
        this.active = active;
    }
}
