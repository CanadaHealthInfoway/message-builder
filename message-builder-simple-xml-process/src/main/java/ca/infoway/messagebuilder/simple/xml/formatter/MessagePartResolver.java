package ca.infoway.messagebuilder.simple.xml.formatter;

import ca.infoway.messagebuilder.VersionNumber;



public interface MessagePartResolver {
	public MessagePartWrapper resolve(VersionNumber versionNumber, String partType, Object fieldValue);
}
