package ca.infoway.messagebuilder.marshalling.hl7.parser;

import java.lang.reflect.Type;

import ca.infoway.messagebuilder.xml.CodingStrength;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

class ParserContextImpl implements ParseContext {

	private final Type expectedReturnType;
	private final String type;
	private final String version;
	private final ConformanceLevel conformance;
	private final CodingStrength strength;
	private final Integer length;

	private ParserContextImpl(String type, Type returnType, String version, 
			ConformanceLevel conformance, CodingStrength strength, Integer length) {
		this.type = type;
		this.expectedReturnType = returnType;
		this.version = version;
		this.conformance = conformance;
		this.strength = strength;
		this.length = length;
	}

	public String getType() {
		return this.type;
	}
	
	public Type getExpectedReturnType() {
		return this.expectedReturnType;
	}

	public String getVersion() {
		return this.version;
	}

	public ConformanceLevel getConformance() {
		return this.conformance;
	}

	static ParseContext create(String type, Type returnType, String version, ConformanceLevel conformance) {
		return new ParserContextImpl(type, returnType, version, conformance, null, null);
	}

	public CodingStrength getCodingStrength() {
		return this.strength;
	}

	public Integer getLength() {
		return this.length;
	}

	public static ParseContext create(String type, Type returnType, String version,
			ConformanceLevel conformance, CodingStrength strength, Integer length) {
		return new ParserContextImpl(type, returnType, version, conformance, strength, length);
	}
}
