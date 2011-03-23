package ca.infoway.messagebuilder.xml;

import java.util.List;

/**
 * <p>A utility helper used to compare message part type names while ignoring a version
 * suffix.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
public class MessagePartVersionSuffixHelper {

	private static final String MESSAGE_PART_VERSION_SUFFIX_SEPARATOR = "_";

	/*
	 * Necessary to support messageSet like NEWFOUNDLAND which are made up of message parts from multiple
	 * CHI versions.
	 */
	/**
	 * <p>Compare two message part types, while ignoring the suffix.
	 * @param type = the type name
	 * @param messagePartNames - a list of message part names to compare against
	 * @return true if a match is found; false otherwise
	 */
	public static boolean matchesDisregardingVersionSuffix(String type, List<String> messagePartNames) {
		boolean result = false;
		if (type != null) {
			for (String hl7PartType : messagePartNames) {
				if (matchesDisregardingVersionSuffix(type, hl7PartType)) {
					result = true;
					break;
				}
			}
		}
		return result;
	}

	/**
	 * <p>Compare two message part type names, while ignoring the suffix.
	 * @param type = the type name
	 * @param hl7PartType - the type to compare against
	 * @return true if a match is found; false otherwise
	 */
	public static boolean matchesDisregardingVersionSuffix(String type, String hl7PartType) {
		return type.startsWith(hl7PartType + MESSAGE_PART_VERSION_SUFFIX_SEPARATOR);
	}

}
