package ca.infoway.messagebuilder.generator.multiplemessageset;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;

class MessageSetMergeHelper {

	String standardMerge(String primary, String secondary) {
		String result = primary;
		if (StringUtils.isBlank(primary) && StringUtils.isNotBlank(secondary)) {
			result = secondary;
		}
		return result;
	}
	
	Object standardMerge(Object primary, Object secondary) {
		return ObjectUtils.defaultIfNull(primary, secondary);
	}
	
}
