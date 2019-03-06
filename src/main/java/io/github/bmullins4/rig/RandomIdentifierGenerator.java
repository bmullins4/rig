
package io.github.bmullins4.rig;

import java.util.Objects;

public class RandomIdentifierGenerator {

	private final String language;
	
	public RandomIdentifierGenerator(final String language) {
		
		this.language = Objects.requireNonNull(language);
	}
	
	public String generate() {
	
		return "";
	}
	
	public String getLanguage() {
		
		return language;
	}
}
