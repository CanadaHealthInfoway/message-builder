package ca.infoway.messagebuilder.marshalling;

import ca.infoway.messagebuilder.xml.ChoiceSupport;
import ca.infoway.messagebuilder.xml.Relationship;

class BeanBridgeChoiceRelationshipResolver {
	static Relationship resolveChoice(PartBridge tealBean, Relationship relationship) {
		return relationship.findChoiceOption(ChoiceSupport.choiceOptionTypePredicate(
				new String[] { tealBean.getTypeName() } ));
	}
}
