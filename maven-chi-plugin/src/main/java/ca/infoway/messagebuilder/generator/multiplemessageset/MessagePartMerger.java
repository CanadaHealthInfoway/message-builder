package ca.infoway.messagebuilder.generator.multiplemessageset;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.xml.DifferenceType;
import ca.infoway.messagebuilder.xml.Documentation;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.Relationship;

class MessagePartMerger implements Merger<MessagePart> {

	private final DocumentationMerger documentationMerger;
	private final MessageSetMergeHelper mergeHelper;
	private final RelationshipsMerger relationshipsMerger;
	private final MergeContext context;
	private MessagePart result;

	MessagePartMerger(MergeContext context) {
		this(context, new DocumentationMerger(context), new RelationshipsMerger(context, false));
	}
	
	MessagePartMerger(MergeContext context, DocumentationMerger documentationMerger, RelationshipsMerger relationshipsMerger) {
		this.context = context;
		this.documentationMerger = documentationMerger;
		this.relationshipsMerger = relationshipsMerger;
		this.mergeHelper = new MessageSetMergeHelper();
	}

	public MessagePart merge(MessagePart primary, MessagePart secondary) {
		
		if (primary == null || secondary == null) {
			this.result = (secondary == null ? primary : secondary);
		} else {
			this.result = new MessagePart();
			mergeName(primary.getName(), secondary.getName());
			mergeDocumentation(primary.getDocumentation(), secondary.getDocumentation());
			mergeRelationships(primary.getRelationships(), secondary.getRelationships());
			mergeSpecializationChilds(primary.getSpecializationChilds(), secondary.getSpecializationChilds());
			mergeAbstract(primary.isAbstract(), secondary.isAbstract());
		}
		
		return this.result;
	}

	private void mergeRelationships(List<Relationship> relationships, List<Relationship> relationships2) {
		List<Relationship> mergedRelationships = this.relationshipsMerger.merge(relationships, relationships2);
		this.result.setRelationships(mergedRelationships);
	}

	private void mergeAbstract(boolean abstract1, boolean abstract2) {
		if (abstract1 != abstract2) {
			this.mergeHelper.addDifference(this.context, this.result, DifferenceType.MESSAGE_PART_ABSTRACT, ""+abstract1, ""+abstract2);
		}
		this.result.setAbstract(abstract1 || abstract2);
	}

	// TODO - TM - perhaps log some differences here when appropriate? 
	private void mergeSpecializationChilds(List<String> specializationChilds1, List<String> specializationChilds2) {
		// can we really just merge this list? seems like it should be ok
		Set<String> resultSet = new TreeSet<String>(); 
		resultSet.addAll(specializationChilds1);
		resultSet.addAll(specializationChilds2);
		this.result.getSpecializationChilds().addAll(resultSet);
	}

	private void mergeDocumentation(Documentation documentation1, Documentation documentation2) {
		Documentation mergedDocumentation = this.documentationMerger.merge(documentation1, documentation2);
		this.result.setDocumentation(mergedDocumentation);
	}

	private void mergeName(String name1, String name2) {
		// should not normally be merging message parts with different names
		if (name1 != null && name2 != null && !StringUtils.equals(name1, name2)) {
			this.context.logError("Merging two messageParts with different names: " + name1 + " / " + name2);
		}
		String mergedName = this.mergeHelper.standardMerge(name1, name2);
		this.result.setName(mergedName);
	}

}
