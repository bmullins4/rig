
package io.github.bmullins4.rig;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;

public class RandomIdentifierGenerator {
	
	private final Language lang;
	private String oldIdentifier;
	private final int maxLength;
	
				 //old, new
	private Map<String, String> changedIdentifiers;
	
	public RandomIdentifierGenerator(final Language lang, final String oldIdentifier, final int maxLength) {
		
		this.lang = Objects.requireNonNull(lang);
		this.oldIdentifier = Objects.requireNonNull(oldIdentifier);
		if(maxLength < 2)
			throw new IllegalArgumentException("Length must be > 1");
		this.maxLength = maxLength;
		
		changedIdentifiers = new HashMap<String, String>();
	}
	
	public String generate() {
	
		StringBuffer identifier = new StringBuffer("");
		int length = (int) (Math.random() * maxLength + 1);
		
		out : while(true) {
			//create identifier
			for(int i = 0; i < length; i++) {
				char c = lang.template().charAt((int)(Math.random() * lang.template().length()));
				identifier.append(c);
			}
			//check regex rules
			if(Pattern.matches(lang.rule(), identifier)) {
				//check keywords
				for(int i = 0; i < lang.keywords().length; i++) {
					if(identifier.toString().equals(lang.keywords()[i]))
						break;
					if(!identifier.toString().equals(lang.keywords()[i]) && i == lang.keywords().length - 1) {
						changedIdentifiers.put(oldIdentifier, identifier.toString());
						break out;
					}
				}
			} else break;
		}
		
		return identifier.toString();
	}
	
	public void setIdent(final String ident) {
		
		oldIdentifier = ident;
	}
	
	public String getLanguage() {
		
		return lang.lang();
	}
	
	public Map<String, String> getChanges() {
		
		return changedIdentifiers;
	}
}
