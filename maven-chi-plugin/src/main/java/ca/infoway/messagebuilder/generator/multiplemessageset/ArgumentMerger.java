package ca.infoway.messagebuilder.generator.multiplemessageset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.xml.Argument;
import ca.infoway.messagebuilder.xml.Relationship;

class ArgumentMerger implements Merger<List<Argument>> {

	private final MergeContext context;
	private MessageSetMergeHelper mergeHelper;

	ArgumentMerger(MergeContext context) {
		this.context = context;
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
			this.mergeHelper.addDifference(this.context, result, "missingArgument", 
					primaryArgument == null ? null : primaryArgument.getName(), 
					secondaryArgument == null ? null : secondaryArgument.getName());
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
			this.mergeHelper.addDifference(this.context, result, "argument name", name, name2);
		}
	}
	
	private void mergeTemplateParameterName(Argument result, String templateParameterName, String templateParameterName2) {
		result.setTemplateParameterName(templateParameterName);
		if (!StringUtils.equals(templateParameterName, templateParameterName2)) {
			this.mergeHelper.addDifference(this.context, result, "arg templateParameterName", templateParameterName, templateParameterName2);
		}
	}

	private void mergeTraversalName(Argument result, String traversalName, String traversalName2) {
		result.setTraversalName(traversalName);
		if (!StringUtils.equals(traversalName, traversalName2)) {
			this.mergeHelper.addDifference(this.context, result, "arg traversalName", traversalName, traversalName2);
		}
	}

	private void mergeChoices(Argument result, List<Relationship> choices, List<Relationship> choices2) {
//		FIXME - TM - handle choices in a later story
		result.getChoices().addAll(choices);
	}

}
