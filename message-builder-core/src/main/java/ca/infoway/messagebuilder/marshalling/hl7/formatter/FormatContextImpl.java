package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

class FormatContextImpl implements FormatContext {

	private final ConformanceLevel conformanceLevel;
	private final String elementName;
	private final String type;
	private final boolean isSpecializationType;
	private final VersionNumber version;

	FormatContextImpl(String elementName, String type, ConformanceLevel conformanceLevel) {
		this(elementName, type, conformanceLevel, false, null);
	}
	
	FormatContextImpl(String elementName, String type, ConformanceLevel conformanceLevel, boolean isSpecializationType, VersionNumber version) {
		this.elementName = elementName;
		this.type = type;
		this.conformanceLevel = conformanceLevel;
		this.isSpecializationType = isSpecializationType;
		this.version = version;
	}
	
	public ConformanceLevel getConformanceLevel() {
		return this.conformanceLevel;
	}

	public String getElementName() {
		return this.elementName;
	}

	public String getType() {
		return this.type;
	}

	public boolean isSpecializationType() {
		return this.isSpecializationType;
	}

	public VersionNumber getVersion() {
		return this.version;
	}
}
