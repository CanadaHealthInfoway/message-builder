package ca.infoway.messagebuilder.generator.multiplemessageset;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.xml.Argument;

class ArgumentMerger implements Merger<List<Argument>> {

	private final MergeContext context;

	ArgumentMerger(MergeContext context) {
		this.context = context;
	}

	public List<Argument> merge(List<Argument> primaryArgs, List<Argument> secondaryArgs) {
		List<Argument> results = new ArrayList<Argument>();

		if (primaryArgs.size() != secondaryArgs.size()) {
			this.context.logError("Mismatching number of arguments");
			results = primaryArgs;
		} else {
			for (int i = 0; i < primaryArgs.size(); i++) {
				Argument arg1 = primaryArgs.get(i);
				Argument arg2 = secondaryArgs.get(i);
				Argument mergedArgument = mergeArgument(arg1, arg2);
				results.add(mergedArgument);
			}
		}
		
		return results;
	}
	
	private Argument mergeArgument(Argument primaryArgument, Argument secondaryArgument) {
		
		Argument result = new Argument();

		if (!StringUtils.equals(primaryArgument.getName(), secondaryArgument.getName())) {
			this.context.logError("Mismatching argument name: " + primaryArgument.getName() + ", " + secondaryArgument.getName());
		}
		
		if (!StringUtils.equals(primaryArgument.getTemplateParameterName(), secondaryArgument.getTemplateParameterName())) {
			this.context.logError("Mismatching template parameter name: " + primaryArgument.getTemplateParameterName() + ", " + secondaryArgument.getTemplateParameterName());
		}
		
		if (!StringUtils.equals(primaryArgument.getTraversalName(), secondaryArgument.getTraversalName())) {
			this.context.logError("Mismatching traversal name: " + primaryArgument.getTraversalName() + ", " + secondaryArgument.getTraversalName());
		}

		merge(primaryArgument.getArguments(), secondaryArgument.getArguments());
		
//		FIXME - TM - handle choices in a later story
//		private List<Relationship> choices = new ArrayList<Relationship>();
		
		return primaryArgument;
	}
	

//if (!StringUtils.equals(argument.getName(), argument2.getName())) {
//	this.outputUI.log(LogLevel.ERROR, "Mismatching argument name (" + argument.getName() +" vs " + argument2.getName() + ") for " + resultInteraction.getName());
//}
//if (!StringUtils.equals(argument.getTraversalName(), argument2.getTraversalName())) {
//	this.outputUI.log(LogLevel.ERROR, "Mismatching argument traversal name (" + argument.getTraversalName() +" vs " + argument2.getTraversalName() + ") for " + resultInteraction.getName());
//}
//if (!StringUtils.equals(argument.getTemplateParameterName(), argument2.getTemplateParameterName())) {
//	this.outputUI.log(LogLevel.ERROR, "Mismatching argument template parameter name (" + argument.getTemplateParameterName() +" vs " + argument2.getTemplateParameterName() + ") for " + resultInteraction.getName());
//}
}
