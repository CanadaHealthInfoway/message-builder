package ca.infoway.messagebuilder.generator.multiplemessageset;

import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.generator.LogLevel;
import ca.infoway.messagebuilder.generator.OutputUI;
import ca.infoway.messagebuilder.xml.Argument;
import ca.infoway.messagebuilder.xml.Documentation;
import ca.infoway.messagebuilder.xml.Interaction;

class InteractionMerger implements Merger<Interaction> {

	private MessageSetMergeHelper mergeHelper = new MessageSetMergeHelper();
	private DocumentationMerger documentationMerger;
	private ArgumentMerger argumentMerger;
	private final OutputUI outputUI;

	InteractionMerger(OutputUI outputUI) {
		this(outputUI, new DocumentationMerger(outputUI), new ArgumentMerger(outputUI));
	}

	InteractionMerger(OutputUI outputUI, DocumentationMerger documentationMerger, ArgumentMerger argumentMerger) {
		this.outputUI = outputUI;
		this.documentationMerger = documentationMerger;
		this.argumentMerger = argumentMerger;
	}

	public Interaction merge(Interaction primaryInteraction, String primaryVersion, Interaction secondaryInteraction, String secondaryVersion) {
		boolean primaryInteractionNull = (primaryInteraction == null);
		boolean secondaryInteractionNull = (secondaryInteraction == null);
		
		primaryInteraction = (Interaction) ObjectUtils.defaultIfNull(primaryInteraction, new Interaction());
		secondaryInteraction = (Interaction) ObjectUtils.defaultIfNull(secondaryInteraction, new Interaction());
		
		Interaction resultInteraction = new Interaction();
		
		mergeName(resultInteraction, primaryInteraction.getName(), secondaryInteraction.getName());
		mergeBusinessName(resultInteraction, primaryInteraction.getBusinessName(), secondaryInteraction.getBusinessName());
		mergeSuperTypeName(resultInteraction, primaryInteraction.getSuperTypeName(), primaryVersion, secondaryInteraction.getSuperTypeName(), secondaryVersion);
		mergeArguments(resultInteraction, primaryInteraction.getArguments(), primaryVersion, primaryInteractionNull, secondaryInteraction.getArguments(), secondaryVersion, secondaryInteractionNull);
		mergeDocumentation(resultInteraction, primaryInteraction.getDocumentation(), primaryVersion, secondaryInteraction.getDocumentation(), secondaryVersion);
		mergeCategory(resultInteraction, primaryInteraction.getCategory(), secondaryInteraction.getCategory());
		
		return resultInteraction;
	}

	private void mergeCategory(Interaction resultInteraction, String category, String category2) {
		String mergedCategory = this.mergeHelper.standardMerge(category, category2);
		resultInteraction.setCategory(mergedCategory);
	}

	private void mergeDocumentation(Interaction resultInteraction, Documentation documentation, String primaryVersion, Documentation documentation2, String secondaryVersion) {
		Documentation mergedDoc = this.documentationMerger.merge(documentation, primaryVersion, documentation2, secondaryVersion);
		resultInteraction.setDocumentation(mergedDoc);
	}

	private void mergeArguments(Interaction resultInteraction, 
			List<Argument> arguments, String primaryVersion, boolean primaryInteractionNull, 
			List<Argument> arguments2, String secondaryVersion, boolean secondaryInteractionNull) {
		if (primaryInteractionNull) {
			resultInteraction.setArguments(arguments2);
		} else if (secondaryInteractionNull){
			resultInteraction.setArguments(arguments);
		} else if (arguments.size() == arguments2.size()) {
			for (int i = 0; i < arguments.size(); i++) {
				Argument argument = arguments.get(i);
				Argument argument2 = arguments2.get(i);
				Argument mergedArgument = this.argumentMerger.merge(argument, primaryVersion, argument2, secondaryVersion);
				resultInteraction.getArguments().add(mergedArgument);
			}
		} else {
			this.outputUI.log(LogLevel.ERROR, "Mismatching argument count (" + arguments.size() +" vs " + arguments2.size() + ") for " + resultInteraction.getName());
			resultInteraction.setArguments(arguments);
		}
	}

	private void mergeSuperTypeName(Interaction resultInteraction, String superTypeName, String version, String superTypeName2, String version2) {
		if (StringUtils.equals(superTypeName, superTypeName2) || superTypeName2 == null) {
			resultInteraction.setSuperTypeName(superTypeName);
		} else if (superTypeName == null) {
			resultInteraction.setSuperTypeName(superTypeName2);
		} else {
			// FIXME TM - what do we do when we have different supertypes???
//			Here is the breakdown of how supertypename changes between currently supported versions:
//				v01r04.2  / v01r04.3  : MCCI 0300 changes to 0100 (3 occurrences)
//				v01r04.2  / v02r02    : MCCI 0100,0200,0300 change to 2100,2200,2300 (numerous)
//				v01r04.2  / r02.04.00 : MCCI 0100,0200,0300 change to 2100,2200,2300 (numerous)
//				v01r04.2  / r02.04.02 : MCCI 0100,0200,0300 change to 2100,2200,2300 (numerous)
//				v01r04.3  / v02r02    : MCCI 0100,0200,0300 change to 2100,2200,2300 (numerous)
//				v01r04.3  / r02.04.00 : MCCI 0100,0200,0300 change to 2100,2200,2300 (numerous)
//				v01r04.3  / r02.04.02 : MCCI 0100,0200,0300 change to 2100,2200,2300 (numerous)
//				v02r02    / r02.04.00 : MCCI 2100 changes to 2300 (3 occurrences)
//				v02r02    / r02.04.02 : MCCI 2100 changes to 2300 (2 occurrences)
//				r02.04.00 / r02.04.02 : MCCI 2300 changes to 2100 (1 occurrence)
			
			
//       <interaction name="COMT_IN100000CA" superTypeName="MCCI_MT002100CA.Message">
//           <regen:difference type="superType" isOk="true">
//             <regen:value version="V02R02" value="MCCI_MT002100CA.Message" />
//             <regen:value version="R02.04.00" value="MCCI_MT002300CA.Message" />
//           </regen:difference>
//	         <businessName>Clinical summary/profile query</businessName>
//	         <argument name="QUQI_MT020000CA.ControlActEvent" templateParameterName="ControlActEvent" traversalName="controlActEvent">
//	            <argument name="REPC_MT000008CA.ParameterList" templateParameterName="ParameterList" traversalName="parameterList"/>
//	         </argument>
//	      </interaction>
			
			this.outputUI.log(LogLevel.ERROR, "Different supertypes for interaction: " + resultInteraction.getName() + " - " + superTypeName + " vs " + superTypeName2);
			this.mergeHelper.addDifference(resultInteraction, "superTypeName", superTypeName, version, superTypeName2, version2);
			
			resultInteraction.setSuperTypeName(superTypeName);
		}
	}

	private void mergeBusinessName(Interaction resultInteraction, String businessName, String businessName2) {
		String mergedBusinessName = this.mergeHelper.standardMerge(businessName, businessName2);
		resultInteraction.setBusinessName(mergedBusinessName);
	}

	private void mergeName(Interaction resultInteraction, String name, String name2) {
		String mergedName = this.mergeHelper.standardMerge(name, name2);
		resultInteraction.setName(mergedName);
	}

}
