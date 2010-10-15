package ca.infoway.messagebuilder.generator.multiplemessageset;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.xml.DifferenceType;
import ca.infoway.messagebuilder.xml.Relationship;

class ChoiceMerger implements Merger<Relationship> {

	private final MergeContext context;
	private final RelationshipsMerger choicesMerger;
	private final MessageSetMergeHelper mergeHelper;
	private Relationship result;

	ChoiceMerger(MergeContext context) {
		this(context, new RelationshipsMerger(context, true));
	}

	ChoiceMerger(MergeContext context, RelationshipsMerger relationshipsMerger) {
		this.context = context;
		this.choicesMerger = relationshipsMerger;
		this.mergeHelper = new MessageSetMergeHelper();
	}

	public Relationship merge(Relationship primary, Relationship secondary) {
		
		if (primary == null || secondary == null) {
			this.result = (primary == null ? secondary : primary);
		} else {
			this.result = new Relationship();
			mergeName(primary.getName(), secondary.getName());
			mergeType(primary.getType(), secondary.getType());
			mergeChoices(primary.getChoices(), secondary.getChoices());
		}
		
		return result;
	}

	// TODO - TM - perhaps log some differences here when appropriate? 
	private void mergeChoices(List<Relationship> choices, List<Relationship> choices2) {
		List<Relationship> mergedChoices = this.choicesMerger.merge(choices, choices2);
		this.result.getChoices().addAll(mergedChoices);
	}

	private void mergeName(String name, String name2) {
		// should never be different at this point
		if (!StringUtils.equals(name, name2)) {
			this.context.logError(this.context.getCurrentMessagePart() + " - relationship names should not be different: " + name + ", " + name2);
		}
		this.result.setName(name);
	}

	private void mergeType(String type, String type2) {
		String mergedType = this.mergeHelper.standardMerge(type, type2);
		if (!StringUtils.equals(type, type2)) {
			this.mergeHelper.addDifference(this.context, this.result, DifferenceType.CHOICE_RELATIONSHIP_TYPE, type, type2);
		}
		this.result.setType(mergedType);
	}

}
