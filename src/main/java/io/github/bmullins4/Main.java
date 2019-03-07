
package io.github.bmullins4;

import io.github.bmullins4.rig.Language;
import io.github.bmullins4.rig.RandomIdentifierGenerator;

public class Main {

	public static void main(String[] args) {
		
		RandomIdentifierGenerator rig = new RandomIdentifierGenerator(Language.JAVA, "num1", 15);
		System.out.println(rig.generate());
		rig.setIdent("something");
		System.out.println(rig.generate());
		rig.setIdent("str");
		System.out.println(rig.generate());
		rig.setIdent("analProbeTest34");
		System.out.println(rig.generate());
		
		System.out.println(rig.getChanges());
	}
}
