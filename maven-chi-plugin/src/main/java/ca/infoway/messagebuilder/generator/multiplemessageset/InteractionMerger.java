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
	private final OutputUI outputUI;

	InteractionMerger(OutputUI outputUI) {
		this(outputUI, new DocumentationMerger(outputUI));
	}

	InteractionMerger(OutputUI outputUI, DocumentationMerger documentationMerger) {
		this.outputUI = outputUI;
		this.documentationMerger = documentationMerger;
	}

	public Interaction merge(Interaction primaryInteraction, Interaction secondaryInteraction) {
		primaryInteraction = (Interaction) ObjectUtils.defaultIfNull(primaryInteraction, new Interaction());
		secondaryInteraction = (Interaction) ObjectUtils.defaultIfNull(secondaryInteraction, new Interaction());
		
		Interaction resultInteraction = new Interaction();
		
		mergeName(resultInteraction, primaryInteraction.getName(), secondaryInteraction.getName());
		mergeBusinessName(resultInteraction, primaryInteraction.getBusinessName(), secondaryInteraction.getBusinessName());
		mergeSuperTypeName(resultInteraction, primaryInteraction.getSuperTypeName(), secondaryInteraction.getSuperTypeName());
		mergeArguments(resultInteraction, primaryInteraction.getArguments(), secondaryInteraction.getArguments());
		mergeDocumentation(resultInteraction, primaryInteraction.getDocumentation(), secondaryInteraction.getDocumentation());
		mergeCategory(resultInteraction, primaryInteraction.getCategory(), secondaryInteraction.getCategory());
		
		return resultInteraction;
	}

	private void mergeCategory(Interaction resultInteraction, String category, String category2) {
		String mergedCategory = this.mergeHelper.standardMerge(category, category2);
		resultInteraction.setCategory(mergedCategory);
	}

	private void mergeDocumentation(Interaction resultInteraction, Documentation documentation, Documentation documentation2) {
		Documentation mergedDoc = this.documentationMerger.merge(documentation, documentation2);
		resultInteraction.setDocumentation(mergedDoc);
	}

	private void mergeArguments(Interaction resultInteraction, List<Argument> arguments, List<Argument> arguments2) {
		// FIXME TM - handle arguments in a later story
		resultInteraction.setArguments(arguments);
	}

	private void mergeSuperTypeName(Interaction resultInteraction, String superTypeName, String superTypeName2) {
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
			this.outputUI.log(LogLevel.ERROR, "Different supertypes for interaction: " + resultInteraction.getName() + " - " + superTypeName + " vs " + superTypeName2);
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
