package ca.infoway.messagebuilder.generator.multiplemessageset;

import ca.infoway.messagebuilder.generator.OutputUI;
import ca.infoway.messagebuilder.xml.Argument;

class ArgumentMerger implements Merger<Argument> {

	private final OutputUI outputUI;

	ArgumentMerger(OutputUI outputUI) {
		this.outputUI = outputUI;
	}

	public Argument merge(Argument primary, String primaryVersion, Argument secondary, String secondaryVersion) {
		
//		private String name;
//		private List<Argument> arguments = new ArrayList<Argument>();
//		private String templateParameterName;
//		private String traversalName;
//		private List<Relationship> choices = new ArrayList<Relationship>();

		return primary;
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
