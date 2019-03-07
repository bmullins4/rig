
package io.github.bmullins4.rig;

public enum Language {

	JAVA {
		@Override
		public String[] keywords() {
			
			String[] kw = {
				"abstract", "assert", "boolean", "break", "byte", "case",
				"catch", "char", "class", "const", "continue", "default",
				"double", "do", "else", "enum", "extends", "false",
				"final", "finally", "float", "for", "goto", "if",
				"implements", "import", "instanceof", "int", "interface",
				"long", "native", "new", "null", "package", "private",
				"protected", "public", "return", "short", "static", 
				"strictfp", "super", "switch", "synchronized", "this",
				"throw", "throws", "transient", "true", "try", "void",
				"volatile", "while"
			};
			
			return kw;
		}
		
		@Override
		public String rule() { return "\\b[a-zA-Z_$][a-zA-Z0-9_$]*\\b"; }
		@Override
		public String template() {
			return "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_$";
		}
		@Override
		public String lang() { return "Java"; }
	};
	
	public abstract String[] keywords();
	public abstract String rule();
	public abstract String template();
	public abstract String lang();
}
