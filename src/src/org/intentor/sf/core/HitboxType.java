package org.intentor.sf.core;

/**
 * Representa os tipos de hitboxes do jogo.
 */
public enum HitboxType {
	/**
	 * Hit x0.
	 */
    HitX0(0, 1),
	/**
	 * Hit x1.
	 */
    HitX1(1, 1),
    /**
     * Hit x1.5.
     */
    HitX1_5(2, 1.5f),
    /**
     * Hit x2.
     */
    HitX2(3, 2),
    /**
     * Soco fraco.
     */
    LowPunch(4, 0.5f),
    /**
     * Soco forte.
     */
    HighPunch(5, 1),
    /**
     * Chute fraco.
     */
    LowKick(6, 1.5f),
    /**
     * Chute forte.
     */
    HighKick(7, 2),
    /**
     * Defesa (absorção de ataque).
     */
    Defense(8, 0);
    
    /**
     * ID do tipo de hitbox.
     */
    private int id;
    
    /**
     * Fator de multiplicação de ataque.
     */
    private float atk;
    
    /**
     * Cria uma nova hitbox.
     * @param id 	ID do tipo de hitbox.
     * @param atk	Fator de multiplicação de ataque.
     */
    HitboxType(int id, float atk) {
    	this.id = id;
    	this.atk = atk;
    }
    
    /**
     * Obtém o ID do tipo de hitbox atual.
     * @return
     */
    public int getTypeID() {
    	return this.id;
    }
    
    /**
     * Obtém o fator de multiplicação de ataque.
     * @return
     */
    public float getATK() {
    	return this.atk;
    }
}
