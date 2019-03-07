
package io.github.bmullins4;

import io.github.bmullins4.rig.Language;
import io.github.bmullins4.rig.RandomIdentifierGenerator;

public class Main {

	public static void main(String[] args) {
		
		RandomIdentifierGenerator[] rigs = {
			new RandomIdentifierGenerator(Language.C, "num1"),
			new RandomIdentifierGenerator(Language.CPP, "num1"),
			new RandomIdentifierGenerator(Language.CSHARP, "num1"),
			new RandomIdentifierGenerator(Language.JAVA, "num1"),
			new RandomIdentifierGenerator(Language.PYTHON2, "num1"),
			new RandomIdentifierGenerator(Language.PYTHON3, "num1"),
		};
		
		for(RandomIdentifierGenerator rig : rigs) {
			System.out.println("Language: " + rig.getLanguage());
			System.out.println(rig.generate());
			rig.setIdent("something");
			System.out.println(rig.generate());
			rig.setIdent("str");
			System.out.println(rig.generate());
			rig.setIdent("analProbeTest34");
			System.out.println(rig.generate());
			System.out.println(rig.getChanges());
			System.out.println();
		}
	}
}
