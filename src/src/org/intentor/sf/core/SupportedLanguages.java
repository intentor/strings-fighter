package org.intentor.sf.core;

/**
 * Idiomas suportados pela aplicação.
 */
public enum SupportedLanguages {
	Portugues("PT"),
	English("EN");
	
	SupportedLanguages(String culture) {
		this.culture = culture;
	}
	
	private String culture;
	
	/**
	 * Obtém a cultura do idioma.
	 * @return Cultura do idioma.
	 */
	public String getCulture() {
		return this.culture;
	}
}
