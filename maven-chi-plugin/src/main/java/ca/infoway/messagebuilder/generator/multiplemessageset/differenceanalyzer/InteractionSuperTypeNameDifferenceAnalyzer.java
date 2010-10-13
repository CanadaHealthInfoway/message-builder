package ca.infoway.messagebuilder.generator.multiplemessageset.differenceanalyzer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ca.infoway.messagebuilder.xml.Difference;
import ca.infoway.messagebuilder.xml.DifferenceValue;

class InteractionSuperTypeNameDifferenceAnalyzer implements DifferenceAnalyzer {

	static final String MESSAGE_2300 = "MCCI_MT002300CA.Message";
	static final String MESSAGE_2200 = "MCCI_MT002200CA.Message";
	static final String MESSAGE_2100 = "MCCI_MT002100CA.Message";
	static final String MESSAGE_0300 = "MCCI_MT000300CA.Message";
	static final String MESSAGE_0200 = "MCCI_MT000200CA.Message";
	static final String MESSAGE_0100 = "MCCI_MT000100CA.Message";
	
	private Map<String, Set<String>> acceptableSuperTypeNameChanges;

	public InteractionSuperTypeNameDifferenceAnalyzer() {
		
		Set<String> compatibleSuperTypes1 = new HashSet<String>();
		compatibleSuperTypes1.add(MESSAGE_0100);
		compatibleSuperTypes1.add(MESSAGE_0300);
		compatibleSuperTypes1.add(MESSAGE_2100);
		compatibleSuperTypes1.add(MESSAGE_2300);
		
		Set<String> compatibleSuperTypes2 = new HashSet<String>();
		compatibleSuperTypes2.add(MESSAGE_0200);
		compatibleSuperTypes2.add(MESSAGE_2200);
		
		// assuming 0100/0300/2100/2200 interchangeable with each other
		this.acceptableSuperTypeNameChanges = new HashMap<String, Set<String>>();
		this.acceptableSuperTypeNameChanges.put(MESSAGE_0100, compatibleSuperTypes1);
		this.acceptableSuperTypeNameChanges.put(MESSAGE_0200, compatibleSuperTypes2);
		this.acceptableSuperTypeNameChanges.put(MESSAGE_0300, compatibleSuperTypes1);
		this.acceptableSuperTypeNameChanges.put(MESSAGE_2100, compatibleSuperTypes1);
		this.acceptableSuperTypeNameChanges.put(MESSAGE_2200, compatibleSuperTypes2);
		this.acceptableSuperTypeNameChanges.put(MESSAGE_2300, compatibleSuperTypes1);
	}
	
	public void analyze(Difference difference) {
		difference.setOk(isAcceptableDifference(difference));
	}

	private boolean isAcceptableDifference(Difference difference) {
		boolean result = false;
		
		List<DifferenceValue> differenceValues = difference.getDifferences();
		if (differenceValues.size() == 2) {
			String superTypeName1 = differenceValues.get(0).getValue();
			String superTypeName2 = differenceValues.get(1).getValue();
			result = isAcceptableSuperTypeNameDifference(superTypeName1, superTypeName2);
		}
		
		return result;
	}

	private boolean isAcceptableSuperTypeNameDifference(String superTypeName1, String superTypeName2) {
		Set<String> compatibleValues = this.acceptableSuperTypeNameChanges.get(superTypeName1);
		return compatibleValues != null && compatibleValues.contains(superTypeName2);
	}

}
