package ca.infoway.messagebuilder.generator.multiplemessageset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.xml.Argument;
import ca.infoway.messagebuilder.xml.Difference;
import ca.infoway.messagebuilder.xml.DifferenceType;
import ca.infoway.messagebuilder.xml.Relationship;

class ArgumentMerger implements Merger<List<Argument>> {

	private final MergeContext context;
	private final RelationshipsMerger choicesMerger;
	private MessageSetMergeHelper mergeHelper;

	ArgumentMerger(MergeContext context) {
		this(context, new RelationshipsMerger(context, true));
	}
	
	ArgumentMerger(MergeContext context, RelationshipsMerger relationshipsMerger) {
		this.context = context;
		this.choicesMerger = relationshipsMerger;
		this.mergeHelper = new MessageSetMergeHelper();
	}

	@SuppressWarnings("unchecked")
	public List<Argument> merge(List<Argument> primaryArgs, List<Argument> secondaryArgs) {
		primaryArgs = (List<Argument>) ObjectUtils.defaultIfNull(primaryArgs, Collections.<Argument>emptyList());
		secondaryArgs = (List<Argument>) ObjectUtils.defaultIfNull(secondaryArgs, Collections.<Argument>emptyList());
		
		List<Argument> results = new ArrayList<Argument>();

		int maxArgs = Math.max(primaryArgs.size(), secondaryArgs.size());
		
		for (int i = 0; i < maxArgs; i++) {
			Argument arg1 = primaryArgs.size() > i ? primaryArgs.get(i) : null;
			Argument arg2 = secondaryArgs.size() > i ? secondaryArgs.get(i) : null;
			Argument mergedArgument = mergeArgument(arg1, arg2);
			results.add(mergedArgument);
		}
		
		return results;
	}
	
	private Argument mergeArgument(Argument primaryArgument, Argument secondaryArgument) {
		
		Argument result = new Argument();
		
		if (primaryArgument == null || secondaryArgument == null) {
			result = primaryArgument == null ? secondaryArgument : primaryArgument;
			Difference addMissingDifference = this.mergeHelper.addMissingDifference(this.context, result, secondaryArgument == null);
			// interactions with different numbers of arguments are not supported
			addMissingDifference.setOk(false);
		} else {
			mergeName(result, primaryArgument.getName(), secondaryArgument.getName());
			mergeTemplateParameterName(result, primaryArgument.getTemplateParameterName(), secondaryArgument.getTemplateParameterName());
			mergeTraversalName(result, primaryArgument.getTraversalName(), secondaryArgument.getTraversalName());
			mergeChoices(result, primaryArgument.getChoices(), secondaryArgument.getChoices());
	
			List<Argument> mergedSubArguments = merge(primaryArgument.getArguments(), secondaryArgument.getArguments());
			result.setArguments(mergedSubArguments);
		}
		
		return result;
	}

	private void mergeName(Argument result, String name, String name2) {
		result.setName(name);
		if (!StringUtils.equals(name, name2)) {
			this.mergeHelper.addDifference(this.context, result, DifferenceType.ASSOCIATION_TYPE, name, name2);
		}
	}
	
	private void mergeTemplateParameterName(Argument result, String templateParameterName, String templateParameterName2) {
		result.setTemplateParameterName(templateParameterName);
		if (!StringUtils.equals(templateParameterName, templateParameterName2)) {
			this.mergeHelper.addDifference(this.context, result, DifferenceType.ARGUMENT_TEMPLATE_PARAMETER_NAME, templateParameterName, templateParameterName2);
		}
	}

	private void mergeTraversalName(Argument result, String traversalName, String traversalName2) {
		
		// TODO - TM - might want to ensure that a traversal name difference does not match a traversal name in the same hierarchy-level of argumrnts
		
		result.setTraversalName(traversalName);
		if (!StringUtils.equals(traversalName, traversalName2)) {
			this.mergeHelper.addDifference(this.context, result, DifferenceType.ARGUMENT_TRAVERSAL_NAME, traversalName, traversalName2);
		}
	}

	private void mergeChoices(Argument result, List<Relationship> choices, List<Relationship> choices2) {
		List<Relationship> mergedChoices = this.choicesMerger.merge(choices, choices2);
		result.getChoices().addAll(mergedChoices);
	}

}
