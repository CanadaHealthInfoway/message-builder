package ca.infoway.messagebuilder.marshalling.hl7.parser;

import java.lang.reflect.Type;

import ca.infoway.messagebuilder.Typed;
import ca.infoway.messagebuilder.xml.CodingStrength;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public interface ParseContext extends Typed {
	public Type getExpectedReturnType();
	public String getVersion();
	public Integer getLength();
	public CodingStrength getCodingStrength();
	public ConformanceLevel getConformance();
}
