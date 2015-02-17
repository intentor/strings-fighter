package org.intentor.sf.core;

/**
 * Idiomas suportados pela aplica��o.
 */
public enum SupportedLanguages {
	Portugues("PT"),
	English("EN");
	
	SupportedLanguages(String culture) {
		this.culture = culture;
	}
	
	private String culture;
	
	/**
	 * Obt�m a cultura do idioma.
	 * @return Cultura do idioma.
	 */
	public String getCulture() {
		return this.culture;
	}
}
