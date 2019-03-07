
package io.github.bmullins4.rig;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;

public class RandomIdentifierGenerator {
	
	private final Language lang;
	private final int maxLength, defMax = 49;
	private String oldIdentifier;
	private Map<String, String> changedIdentifiers;
	
	public RandomIdentifierGenerator(final Language lang) {
		
		this.lang = Objects.requireNonNull(lang);
		
		maxLength = (int) (Math.random() * defMax + 1);
		changedIdentifiers = new HashMap<String, String>();
	}
	
	public RandomIdentifierGenerator(final Language lang, final int maxLength) {
		
		this.lang = Objects.requireNonNull(lang);
		if(maxLength < 2)
			throw new IllegalArgumentException("Length must be > 1");
		this.maxLength = maxLength;
		
		changedIdentifiers = new HashMap<String, String>();
	}
	
	public RandomIdentifierGenerator(final Language lang, final String oldIdentifier) {
		
		this.lang = Objects.requireNonNull(lang);
		this.oldIdentifier = Objects.requireNonNull(oldIdentifier);
		
		maxLength = (int) (Math.random() * defMax + 1);
		changedIdentifiers = new HashMap<String, String>();
	}
	
	public RandomIdentifierGenerator(final Language lang, final String oldIdentifier, final int maxLength) {
		
		this.lang = Objects.requireNonNull(lang);
		this.oldIdentifier = Objects.requireNonNull(oldIdentifier);
		if(maxLength < 2)
			throw new IllegalArgumentException("Length must be > 1");
		this.maxLength = maxLength;
		
		changedIdentifiers = new HashMap<String, String>();
	}
	
	public String generate() {
	
		StringBuilder identifier = new StringBuilder("");
		
		while(!conditionsMet(identifier)) {
			identifier.delete(0, identifier.length()); //clear string to start over if conditions aren't met
			createIdent(identifier);
			conditionsMet(identifier);
		}
		
		return identifier.toString();
	}
	
	private void createIdent(StringBuilder identifier) {

		int length = (int) (Math.random() * (maxLength - 1) + 1);
		
		for(int i = 0; i < length; i++) {
			char c = lang.template().charAt((int)(Math.random() * lang.template().length()));
			identifier.append(c);
		}
	}
	
	private boolean conditionsMet(StringBuilder identifier) {
		
		if(Pattern.matches(lang.rule(), identifier))
			for(int i = 0; i < lang.keywords().length; i++) {
				if(identifier.toString().equals(lang.keywords()[i]))
					return false;
				if(!identifier.toString().equals(lang.keywords()[i]) && i == lang.keywords().length - 1) {
					changedIdentifiers.put(oldIdentifier, identifier.toString());
					return true;
				}
			}
		
		return false;
	}
	
	public void setIdent(final String ident) { oldIdentifier = ident; }
	public String getLanguage() { return lang.lang(); }
	public Map<String, String> getChanges() { return changedIdentifiers; }
}
