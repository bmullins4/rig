
package io.github.bmullins4.rig;

public enum Language {
	
	C {

		@Override
		public String[] keywords() {
			
			String[] kw = {
				"auto", "break", "case", "char", "const", "continue", "default",
				"do", "double", "else", "enum", "extern", "float", "for", "goto",
				"if", "int", "long", "register", "return", "short", "signed",
				"sizeof", "static", "struct", "switch", "typedef", "union",
				"unsigned", "void", "volatile", "while"
			};
			
			return kw;
		}

		@Override
		public String rule() { return "\\b[a-zA-Z_][a-zA-Z0-9_]*\\b"; }
		@Override
		public String template() { return DEF_TEMPLATE + "_"; }
		@Override
		public String lang() { return "C"; }
	},
	
	CPP {

		@Override
		public String[] keywords() {
			
			String[] kw = {
				"alignas", "alignof", "and", "and_eq", "asm", "atomic_cancel", "atomic_commit",
				"atomic_noexcept", "auto", "bitand", "bitor", "bool", "break", "case", "catch",
				"char", "chat8_t", "char16_t", "char32_t", "class", "compl", "concept", "const",
				"consteval", "constexpr", "const_cast", "continue", "co_await", "co_return",
				"co_yield", "decltype", "default", "delete", "do", "double", "dynamic_cast",
				"else", "enum", "explicit", "export", "extern", "false", "float", "for", "friend",
				"goto", "if", "import", "inline", "int", "long", "module", "mutable", "namespace",
				"new", "noexcept", "not", "not_eq", "nullptr", "operator", "or", "or_eq", "private",
				"protected", "public", "reflexpr", "register", "reinterpret_cast", "requires",
				"return", "short", "signed", "sizeof", "static", "static_assert", "static_cast",
				"struct", "switch", "synchronized", "template", "this", "thread_local", "throw",
				"true", "try", "typedef", "typeid", "typename", "union", "unsigned", "using",
				"virtual", "void", "volatile", "wchar_t", "while", "xor", "xor_eq"
			};
			
			return kw;
		}

		@Override
		public String rule() { return "\\b[a-zA-Z_][a-zA-Z0-9_]*\\b"; }
		@Override
		public String template() { return DEF_TEMPLATE + "_"; }
		@Override
		public String lang() { return "C++"; }
	},
	
	CSHARP {

		@Override
		public String[] keywords() {
			
			String[] kw = {
				//reserved
				"abstract", "as", "base", "bool", "break", "byte", "case",
				"catch", "char", "checked", "class", "const", "continue",
				"decimal", "default", "delegate", "do", "double", "else",
				"enum", "event", "explicit", "extern", "false", "finally",
				"fixed", "float", "for", "foreach", "goto", "if", "implicit",
				"in", "int", "interface", "internal", "is", "lock", "long",
				"namespace", "new", "null", "object", "operator", "out",
				"override", "params", "private", "protected", "public",
				"readonly", "ref", "return", "sbyte", "sealed", "short",
				"sizeof", "stackalloc", "static", "string", "struct", "swtich",
				"this", "throw", "true", "try", "typeof", "unit", "ulong",
				"unchecked", "unsafe", "ushort", "using", "virtual", "void",
				"volatile", "while",
				//contextual
				"add", "alias", "ascending", "async", "await", "by",
				"descending", "dynamic", "equals", "from", "get", "global",
				"group", "into", "join", "let", "nameof", "on", "orderby",
				"partial", "remove", "select", "set", "value", "var", "when",
				"where", "yield"
			};
			
			return kw;
		}

		@Override
		public String rule() { return "\\b[a-zA-Z_][a-zA-Z0-9_]*\\b"; }
		@Override
		public String template() {return DEF_TEMPLATE + "_";}
		@Override
		public String lang() { return "C#"; }
	},

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
		public String template() { return DEF_TEMPLATE + "_$"; }
		@Override
		public String lang() { return "Java"; }
	},
	
	PYTHON2 {

		@Override
		public String[] keywords() {
			
			String[] kw = {
				"and", "as", "assert", "break", "class", "continue",
				"def", "del", "elif", "else", "except", "exec", "finally",
				"for", "from", "global", "if", "import", "in", "is",
				"lambda", "not", "or", "pass", "print", "raise", "return",
				"try", "while", "with", "yield"
			};
			
			return kw;
		}

		@Override
		public String rule() { return "\\b[a-zA-Z_][a-zA-Z0-9_]*\\b"; }
		@Override
		public String template() { return DEF_TEMPLATE + "_"; }
		@Override
		public String lang() { return "Python 2"; }
	},
	
	PYTHON3 {

		@Override
		public String[] keywords() {
			
			String[] kw = {
				"and", "as", "assert", "break", "class", "continue", "def",
				"del", "elif", "else", "except", "finally", "False", "for",
				"from", "global", "if", "import", "in", "is", "lambda",
				"nonlocal", "None", "not", "or", "pass", "raise", "return",
				"True", "try", "with", "while", "yield"
			};
			
			return kw;
		}

		@Override
		public String rule() { return "\\b[a-zA-Z_][a-zA-Z0-9_]*\\b"; }
		@Override
		public String template() { return DEF_TEMPLATE + "_"; }
		@Override
		public String lang() { return "Python 3"; }
	};
	
	public abstract String[] keywords();
	public abstract String rule();
	public abstract String template();
	public abstract String lang();
	
	private final static String DEF_TEMPLATE = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
}
