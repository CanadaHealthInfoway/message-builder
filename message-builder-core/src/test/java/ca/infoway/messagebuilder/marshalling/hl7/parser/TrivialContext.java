package ca.infoway.messagebuilder.marshalling.hl7.parser;

import java.lang.reflect.Type;

import ca.infoway.messagebuilder.xml.CodingStrength;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

class TrivialContext implements ParseContext {

	private final String type;

	public TrivialContext(String type) {
		this.type = type;
	}
	
	public CodingStrength getCodingStrength() {
		return null;
	}

	public ConformanceLevel getConformance() {
		return null;
	}

	public Type getExpectedReturnType() {
		return null;
	}

	public Integer getLength() {
		return null;
	}

	public String getVersion() {
		return null;
	}

	public String getType() {
		return this.type;
	}

}
