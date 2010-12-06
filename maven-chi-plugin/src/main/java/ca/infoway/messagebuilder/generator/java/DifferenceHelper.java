package ca.infoway.messagebuilder.generator.java;

import ca.infoway.messagebuilder.generator.GeneratorException;
import ca.infoway.messagebuilder.generator.multiplemessageset.MessageSetMergeHelper;
import ca.infoway.messagebuilder.xml.Difference;
import ca.infoway.messagebuilder.xml.DifferenceType;
import ca.infoway.messagebuilder.xml.HasDifferences;

class DifferenceHelper {
	static boolean hasDifferenceOfType(HasDifferences hasDifferences, DifferenceType differenceType) {
		return getDifferenceByType(hasDifferences, differenceType) != null;
	}
	static Difference getDifferenceByType(HasDifferences hasDifferences, DifferenceType differenceType) {
		Difference result = null;
		for (Difference difference : hasDifferences.getDifferences()) {
			if (differenceType == difference.getType()) {
				result = difference;
				break;
			}
		}
		return result;
	}
	static <T extends HasDifferences> T choosePrimary(
			T relationship1, T relationship2) {
		
		Difference difference1 = getDifferenceByType(relationship1, DifferenceType.COMPONENT_ONLY_IN_ONE_VERSION);
		Difference difference2 = getDifferenceByType(relationship2, DifferenceType.COMPONENT_ONLY_IN_ONE_VERSION);
		
		if (difference1 == null || difference2 == null) {
			throw new GeneratorException("Cannot determine primary relationship");
		} else if (isPrimary(difference1)) {
			return relationship1;
		} else if (isPrimary(difference2)) {
			return relationship2;
		} else {
			throw new GeneratorException("Cannot determine primary relationship");
		}
	}
	private static boolean isPrimary(Difference difference1) {
		return MessageSetMergeHelper.EXISTS.equals(difference1.getDifferences().get(0).getValue());
	}
}	
