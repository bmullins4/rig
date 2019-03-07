
package io.github.bmullins4.rig;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RandomIdentifierGenerator {
	
	private final Language lang;
	private final int maxLength;
	
	private List<String> changedIdentifiers;
	
	public RandomIdentifierGenerator(final Language lang, final int maxLength) {
		
		this.lang = Objects.requireNonNull(lang);
		if(maxLength < 2)
			throw new IllegalArgumentException("Length must be > 1");
		this.maxLength = maxLength;
		
		changedIdentifiers = new ArrayList<String>();
	}
	
	public String generate() {
	
		String identifier = "";
		int length = (int) (Math.random() * maxLength + 2);
		//TODO: implement working part
		
		
		return identifier;
	}
	
	public String getLanguage() {
		
		return lang.lang();
	}
}
