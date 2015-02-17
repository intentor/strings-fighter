package org.intentor.sf.core;

/**
 * Represena informações de pulo de um personagem.
 */
public class JumpInfo {
	/**
	 * Tamanho do pulo.
	 */
	private float _size;
	
	/**
	 * Velocidade do pulo.
	 */
	private float _speed;
	
	/**
	 * Tamanho inicial do pulo.
	 */
	private float _initialSpeed;
	
	/**
	 * Cria novas informações sobre um pulo.
	 * @param size	Tamanho do pulo.
	 * @param speed	Velocidade do pulo.
	 */
	public JumpInfo(float size, float speed) {
		this._size = size;
		this._speed = this._initialSpeed = speed;
	}
	
	/**
	 * Volta a velocidade atual à velocidade inicial.
	 */
	public void resetSpeed() {
		this._speed = this._initialSpeed;
	}
	
	/**
	 * Inverte a velocidade (torna-a negativa).
	 */
	public void invertSpeed() {
		this._speed = -this._speed;
	}
	
	/**
	 * Decrementa a velocidade.
	 */
	public void decrementSpeed() {
		this._speed -= 0.2f;	
	}

	/**
	 * Obtém o tamanho do pulo.
	 */
	public float size() {
		return _size;
	}
	
	/**
	 * Define o tamanho do pulo.
	 * @param size Novo tamanho do pulo.
	 */
	public void setSize(float size) {
		this._size = size;
	}
	
	/**
	 * Obtém a velocidade do pulo.
	 * @return Velocidade do pulo.
	 */
	public float speed() {
		return _speed;
	}
	
	/**
	 * Define a velocidade do pulo.
	 * @param speed Nova velocidade do pulo.
	 */
	public void setSpeed(float speed) {
		this._speed = speed;
	}
	
	/**
	 * Obtém a velocidade inicial.
	 * @return Velocidade inicial.
	 */
	public float initialSpeed() {
		return _initialSpeed;
	}
}
