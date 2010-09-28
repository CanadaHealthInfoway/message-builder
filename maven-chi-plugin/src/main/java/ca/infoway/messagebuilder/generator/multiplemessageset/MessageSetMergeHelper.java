package ca.infoway.messagebuilder.generator.multiplemessageset;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.xml.Difference;
import ca.infoway.messagebuilder.xml.DifferenceValue;
import ca.infoway.messagebuilder.xml.HasDifference;

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
	
	void addDifference(HasDifference hasDifference, String type, String value, String version, String value2, String version2) {
		
		DifferenceValue differenceValue1 = new DifferenceValue();
		differenceValue1.setValue(value);
		differenceValue1.setVersion(version);
		
		DifferenceValue differenceValue2 = new DifferenceValue();
		differenceValue2.setValue(value2);
		differenceValue2.setVersion(version2);
		
		Difference difference = new Difference();
		difference.setType(type);
		difference.getDifferences().add(differenceValue1);
		difference.getDifferences().add(differenceValue2);
		
		hasDifference.setDifference(difference);
	}

}
