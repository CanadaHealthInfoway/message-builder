package ca.infoway.messagebuilder.resolver;

import ca.infoway.messagebuilder.domainvalue.NullFlavor;
import ca.infoway.messagebuilder.lang.EnumPattern;

public class MockStarTrek extends EnumPattern implements MockCharacters {

	private static final long serialVersionUID = -5314443670242023450L;
	
	public static final MockStarTrek KIRK = new MockStarTrek("KIRK"); 
	public static final MockStarTrek SPOCK = new MockStarTrek("SPOCK"); 
	public static final MockStarTrek MCCOY = new MockStarTrek("MCCOY"); 
	public static final MockStarTrek PICARD = new MockStarTrek("PICARD"); 
	public static final MockStarTrek DATA = new MockStarTrek("DATA"); 
	public static final MockStarTrek OTHER = new MockStarTrek("OTHER");

	private MockStarTrek(String name) {
		super(name);
	}
	
	public String getCodeSystem() {
		return "to.boldly.go";
	}

	public String getCodeValue() {
		return this != OTHER ? toString() : null;
	}

	public NullFlavor getNullFlavor() {
		return this != OTHER ? null : ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor.OTHER;
	}

	public boolean hasNullFlavor() {
		return this == OTHER;
	}

}
