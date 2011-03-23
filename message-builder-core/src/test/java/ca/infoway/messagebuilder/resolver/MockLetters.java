package ca.infoway.messagebuilder.resolver;

import ca.infoway.messagebuilder.domainvalue.NullFlavor;
import ca.infoway.messagebuilder.lang.EnumPattern;

public class MockLetters extends EnumPattern implements MockCharacters {

	private static final long serialVersionUID = 6400732969093598844L;
	
	public static final MockLetters A = new MockLetters("A"); 
	public static final MockLetters B = new MockLetters("B"); 
	public static final MockLetters C = new MockLetters("C"); 
	public static final MockLetters D = new MockLetters("D"); 
	public static final MockLetters E = new MockLetters("E"); 
	public static final MockLetters LMNO = new MockLetters("LMNO"); 
	public static final MockLetters OTHER = new MockLetters("OTHER");

	private MockLetters(String name) {
		super(name);
	}
	
	public String getCodeSystem() {
		return "a.b.c.e.f.g.h";
	}

	public String getCodeValue() {
		return this != OTHER ? name() : null;
	}

	public NullFlavor getNullFlavor() {
		return this != OTHER ? null : ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor.OTHER;
	}

	public boolean hasNullFlavor() {
		return this == OTHER;
	} 
}
