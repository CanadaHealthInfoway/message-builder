package ca.infoway.messagebuilder.xml.validator;

import static ca.infoway.messagebuilder.marshalling.hl7.DomainTypeHelper.getReturnType;

import java.lang.reflect.Type;

import ca.infoway.messagebuilder.marshalling.hl7.parser.ParseContext;
import ca.infoway.messagebuilder.xml.CodingStrength;
import ca.infoway.messagebuilder.xml.ConformanceLevel;
import ca.infoway.messagebuilder.xml.Relationship;

class ParseContextImpl implements ParseContext {

	private final Relationship relationship;
	private final String version;

	private ParseContextImpl(Relationship relationship, String version) {
		this.relationship = relationship;
		this.version = version;
	}

	public static ParseContext create(Relationship relationship, String version) {
		return new ParseContextImpl(relationship, version);
	}

	public Type getExpectedReturnType() {
		return getReturnType(this.relationship);
	}

	public String getType() {
		return this.relationship.getType();
	}

	public String getVersion() {
		return this.version;
	}
	public Integer getLength() {
		return this.relationship.getLength();
	}
	public CodingStrength getCodingStrength() {
		return this.relationship.getCodingStrength();
	}
	public ConformanceLevel getConformance() {
		return this.relationship.getConformance();
	}
}
