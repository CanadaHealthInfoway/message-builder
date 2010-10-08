package ca.infoway.messagebuilder.generator.multiplemessageset.differenceanalyzer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.xml.Difference;
import ca.infoway.messagebuilder.xml.DifferenceValue;

class InteractionSuperTypeNameDifferenceAnalyzer implements DifferenceAnalyzer {

	static final String MESSAGE_2300 = "MCCI_MT002300CA.Message";
	static final String MESSAGE_2200 = "MCCI_MT002200CA.Message";
	static final String MESSAGE_2100 = "MCCI_MT002100CA.Message";
	static final String MESSAGE_0300 = "MCCI_MT000300CA.Message";
	static final String MESSAGE_0200 = "MCCI_MT000200CA.Message";
	static final String MESSAGE_0100 = "MCCI_MT000100CA.Message";
	
	private Map<String, String> acceptableSuperTypeNameChanges;

	public InteractionSuperTypeNameDifferenceAnalyzer() {
		this.acceptableSuperTypeNameChanges = new HashMap<String, String>();
		this.acceptableSuperTypeNameChanges.put(MESSAGE_0100, MESSAGE_2100);
		this.acceptableSuperTypeNameChanges.put(MESSAGE_0200, MESSAGE_2200);
		this.acceptableSuperTypeNameChanges.put(MESSAGE_0300, MESSAGE_2300);
		this.acceptableSuperTypeNameChanges.put(MESSAGE_2100, MESSAGE_0100);
		this.acceptableSuperTypeNameChanges.put(MESSAGE_2200, MESSAGE_0200);
		this.acceptableSuperTypeNameChanges.put(MESSAGE_2300, MESSAGE_0300);
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
		String value = this.acceptableSuperTypeNameChanges.get(superTypeName1);
		return StringUtils.equals(superTypeName1, superTypeName2) || StringUtils.equals(value, superTypeName2);
	}

}
