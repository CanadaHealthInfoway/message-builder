package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

class FormatContextImpl implements FormatContext {

	private final ConformanceLevel conformanceLevel;
	private final String elementName;
	private final String type;
	private final boolean isSpecializationType;
	private final boolean isPassOnSpecializationType;
	private final VersionNumber version;

	FormatContextImpl(String elementName, String type, ConformanceLevel conformanceLevel) {
		this(elementName, type, conformanceLevel, false, null, true);
	}
	
	FormatContextImpl(String elementName, String type, ConformanceLevel conformanceLevel, boolean isSpecializationType, VersionNumber version) {
		this(elementName, type, conformanceLevel, isSpecializationType, version, true);
	}
	
	FormatContextImpl(String elementName, String type, ConformanceLevel conformanceLevel, boolean isSpecializationType, VersionNumber version, boolean isPassOnSpecializationType) {
		this.elementName = elementName;
		this.type = type;
		this.conformanceLevel = conformanceLevel;
		this.isSpecializationType = isSpecializationType;
		this.version = version;
		this.isPassOnSpecializationType = isPassOnSpecializationType;
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
	
	public boolean isPassOnSpecializationType() {
		return this.isPassOnSpecializationType;
	}
}
