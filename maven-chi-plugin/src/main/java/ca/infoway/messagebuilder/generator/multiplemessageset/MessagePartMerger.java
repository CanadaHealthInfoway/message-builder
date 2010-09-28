package ca.infoway.messagebuilder.generator.multiplemessageset;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.generator.LogLevel;
import ca.infoway.messagebuilder.generator.OutputUI;
import ca.infoway.messagebuilder.xml.Documentation;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.Relationship;

class MessagePartMerger implements Merger<MessagePart> {

	private final OutputUI outputUI;
	private final DocumentationMerger documentationMerger;
	private final MessageSetMergeHelper mergeHelper;
	private final RelationshipMerger relationshipMerger;

	MessagePartMerger(OutputUI outputUI) {
		this(outputUI, new DocumentationMerger(outputUI), new RelationshipMerger(outputUI));
	}
	
	MessagePartMerger(OutputUI outputUI, DocumentationMerger documentationMerger, RelationshipMerger relationshipMerger) {
		this.outputUI = outputUI;
		this.documentationMerger = documentationMerger;
		this.relationshipMerger = relationshipMerger;
		this.mergeHelper = new MessageSetMergeHelper();
	}

	public MessagePart merge(MessagePart primary, String primaryVersion, MessagePart secondary, String secondaryVersion) {
		boolean primaryNull = (primary == null);
		boolean secondaryNull = (secondary == null);
		
		primary = (MessagePart) ObjectUtils.defaultIfNull(primary, new MessagePart());
		secondary = (MessagePart) ObjectUtils.defaultIfNull(secondary, new MessagePart());
		
		MessagePart result = new MessagePart();
		
		mergeName(result, primary.getName(), secondary.getName());
		mergeDocumentation(result, primary.getDocumentation(), primaryVersion, secondary.getDocumentation(), secondaryVersion);
		mergeRelationships(result, primary.getRelationships(), primaryVersion, secondary.getRelationships(), secondaryVersion);
		mergeSpecializationChilds(result, primary.getSpecializationChilds(), secondary.getSpecializationChilds());
		mergeAbstract(result, primary.isAbstract(), primaryNull, secondary.isAbstract(), secondaryNull);
		
		return result;
	}

	private void mergeAbstract(MessagePart result, boolean abstract1, boolean primaryIsNull, boolean abstract2, boolean secondaryIsNull) {
		if (abstract1 != abstract2 && !primaryIsNull && !secondaryIsNull) {
			this.outputUI.log(LogLevel.ERROR, "Merging abstract messagePart with non-abstract messagePart");
		}
		result.setAbstract(abstract1 || abstract2);
	}

	private void mergeSpecializationChilds(MessagePart result, List<String> specializationChilds1, List<String> specializationChilds2) {
		// can we really just merge this list? seems like it should be ok
		Set<String> resultSet = new TreeSet<String>(); 
		resultSet.addAll(specializationChilds1);
		resultSet.addAll(specializationChilds2);
		result.getSpecializationChilds().addAll(resultSet);
	}

	private void mergeRelationships(MessagePart result, List<Relationship> relationships1, String primaryVersion, List<Relationship> relationships2, String secondaryVersion) {
		// hmmm - will order matter? Likely not, as we will only be using this merged messageset for api generation, not to produce a message or for validation 
		Map<String, Relationship> relationships2Map = new LinkedHashMap<String, Relationship>();
		for (Relationship relationship : relationships2) {
			relationships2Map.put(relationship.getName(), relationship);
		}
		
		for (Relationship relationship1 : relationships1) {
			Relationship relationship2 = relationships2Map.remove(relationship1.getName());
			Relationship mergedRelationship = this.relationshipMerger.merge(relationship1, primaryVersion, relationship2, secondaryVersion);
			result.getRelationships().add(mergedRelationship);
		}
		
		for (Relationship relationship : relationships2Map.values()) {
			Relationship mergedRelationship = this.relationshipMerger.merge(null, primaryVersion, relationship, secondaryVersion);
			result.getRelationships().add(mergedRelationship);
		}
		
	}

	private void mergeDocumentation(MessagePart result, Documentation documentation1, String primaryVersion, Documentation documentation2, String secondaryVersion) {
		Documentation mergedDocumentation = this.documentationMerger.merge(documentation1, primaryVersion, documentation2, secondaryVersion);
		result.setDocumentation(mergedDocumentation);
	}

	private void mergeName(MessagePart result, String name1, String name2) {
		// should not normally be merging message parts with different names
		if (name1 != null && name2 != null && !StringUtils.equals(name1, name2)) {
			this.outputUI.log(LogLevel.ERROR, "Merging two messageParts with different names: " + name1 + " / " + name2);
		}
		String mergedName = this.mergeHelper.standardMerge(name1, name2);
		result.setName(mergedName);
	}


}
