package ca.infoway.messagebuilder.marshalling;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContext;
import ca.infoway.messagebuilder.xml.ConformanceLevel;
import ca.infoway.messagebuilder.xml.Relationship;

class FormatContextImpl implements FormatContext {

	private final Relationship relationship;
	private final VersionNumber version;

	private FormatContextImpl(Relationship relationship, VersionNumber version) {
		this.relationship = relationship;
		this.version = version;
	}

	public static FormatContext create(Relationship relationship, VersionNumber version) {
		return new FormatContextImpl(relationship, version);
	}

	public ConformanceLevel getConformanceLevel() {
		return this.relationship.getConformance();
	}

	public String getElementName() {
		return this.relationship.getName();
	}

	public String getType() {
		return this.relationship.getType();
	}

	public boolean isSpecializationType() {
		return false;
	}

	public boolean isPassOnSpecializationType() {
		return true;
	}

	public VersionNumber getVersion() {
		return this.version;
	}

}
