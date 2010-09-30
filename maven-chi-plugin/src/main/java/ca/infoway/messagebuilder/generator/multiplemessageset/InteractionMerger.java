package ca.infoway.messagebuilder.generator.multiplemessageset;

import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.xml.Argument;
import ca.infoway.messagebuilder.xml.Documentation;
import ca.infoway.messagebuilder.xml.Interaction;

class InteractionMerger implements Merger<Interaction> {

	private MessageSetMergeHelper mergeHelper = new MessageSetMergeHelper();
	private DocumentationMerger documentationMerger;
	private ArgumentMerger argumentMerger;
	private final MergeContext context;
	private Interaction result;

	InteractionMerger(MergeContext context) {
		this(context, new DocumentationMerger(context), new ArgumentMerger(context));
	}

	InteractionMerger(MergeContext context, DocumentationMerger documentationMerger, ArgumentMerger argumentMerger) {
		this.context = context;
		this.documentationMerger = documentationMerger;
		this.argumentMerger = argumentMerger;
	}

	public Interaction merge(Interaction primaryInteraction, Interaction secondaryInteraction) {
		boolean primaryInteractionNull = (primaryInteraction == null);
		boolean secondaryInteractionNull = (secondaryInteraction == null);
		
		primaryInteraction = (Interaction) ObjectUtils.defaultIfNull(primaryInteraction, new Interaction());
		secondaryInteraction = (Interaction) ObjectUtils.defaultIfNull(secondaryInteraction, new Interaction());
		
		this.result = new Interaction();
		
		mergeName(primaryInteraction.getName(), secondaryInteraction.getName());
		mergeBusinessName(primaryInteraction.getBusinessName(), secondaryInteraction.getBusinessName());
		mergeSuperTypeName(primaryInteraction.getSuperTypeName(), secondaryInteraction.getSuperTypeName());
		mergeArguments(primaryInteraction.getArguments(), primaryInteractionNull, secondaryInteraction.getArguments(), secondaryInteractionNull);
		mergeDocumentation(primaryInteraction.getDocumentation(), secondaryInteraction.getDocumentation());
		mergeCategory(primaryInteraction.getCategory(), secondaryInteraction.getCategory());
		
		return this.result;
	}

	private void mergeCategory(String category, String category2) {
		String mergedCategory = this.mergeHelper.standardMerge(category, category2);
		this.result.setCategory(mergedCategory);
	}

	private void mergeDocumentation(Documentation documentation, Documentation documentation2) {
		Documentation mergedDoc = this.documentationMerger.merge(documentation, documentation2);
		this.result.setDocumentation(mergedDoc);
	}

	private void mergeArguments(List<Argument> arguments, boolean primaryInteractionNull, 
			List<Argument> arguments2, boolean secondaryInteractionNull) {
		if (primaryInteractionNull) {
			this.result.setArguments(arguments2);
		} else if (secondaryInteractionNull) {
			this.result.setArguments(arguments);
		} else {
			List<Argument> mergedArguments = this.argumentMerger.merge(arguments, arguments2);
			this.result.getArguments().addAll(mergedArguments);
		}
	}

	private void mergeSuperTypeName(String superTypeName, String superTypeName2) {
		if (StringUtils.equals(superTypeName, superTypeName2) || superTypeName2 == null) {
			this.result.setSuperTypeName(superTypeName);
		} else if (superTypeName == null) {
			this.result.setSuperTypeName(superTypeName2);
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
			
			this.context.logError("Different supertypes for interaction: " + this.result.getName() + " - " + superTypeName + " vs " + superTypeName2);
			this.mergeHelper.addDifference(this.context, this.result, "superTypeName", superTypeName, superTypeName2);
			
			this.result.setSuperTypeName(superTypeName);
		}
	}

	private void mergeBusinessName(String businessName, String businessName2) {
		String mergedBusinessName = this.mergeHelper.standardMerge(businessName, businessName2);
		this.result.setBusinessName(mergedBusinessName);
	}

	private void mergeName(String name, String name2) {
		String mergedName = this.mergeHelper.standardMerge(name, name2);
		this.result.setName(mergedName);
	}

}
