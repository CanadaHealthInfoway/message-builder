package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public interface FormatContext {
	public String getElementName();
	public String getType();
	public boolean isSpecializationType();
	public ConformanceLevel getConformanceLevel();
	public VersionNumber getVersion();
}
