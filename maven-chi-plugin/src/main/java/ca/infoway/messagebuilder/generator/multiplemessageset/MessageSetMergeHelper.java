package ca.infoway.messagebuilder.generator.multiplemessageset;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.xml.Difference;
import ca.infoway.messagebuilder.xml.DifferenceType;
import ca.infoway.messagebuilder.xml.DifferenceValue;
import ca.infoway.messagebuilder.xml.HasDifferences;

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
	
	void addDifference(MergeContext context, HasDifferences hasDifferences, DifferenceType type, String value, String value2) {
		
		DifferenceValue differenceValue1 = new DifferenceValue();
		differenceValue1.setValue(StringUtils.isBlank(value) ? "[missing]" : value);
		differenceValue1.setVersion(context.getPrimaryVersion());
		
		DifferenceValue differenceValue2 = new DifferenceValue();
		differenceValue2.setValue(StringUtils.isBlank(value2) ? "[missing]" : value2);
		differenceValue2.setVersion(context.getSecondaryVersion());
		
		Difference difference = new Difference();
		difference.setType(type);
		difference.getDifferences().add(differenceValue1);
		difference.getDifferences().add(differenceValue2);
		
		hasDifferences.addDifference(difference);
		
		String differenceError = 
			  StringUtils.trimToEmpty(context.getCurrentInteraction()) + " " 
			+ StringUtils.trimToEmpty(context.getCurrentPackageLocation()) + " " 
			+ StringUtils.trimToEmpty(context.getCurrentMessagePart())
			+ " - " + "difference for " + type + ": " + value + ", " + value2;
		context.logError(differenceError.trim());
		
	}

}
