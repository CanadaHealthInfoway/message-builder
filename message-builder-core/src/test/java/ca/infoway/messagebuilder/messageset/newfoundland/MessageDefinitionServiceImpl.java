package ca.infoway.messagebuilder.messageset.newfoundland;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.service.BaseMessageDefinitionService;

/**
 * @sharpen.ignore
 */
public class MessageDefinitionServiceImpl extends BaseMessageDefinitionService {
	
	private final String[] NAMES = {"/messageSet_NEWFOUNDLAND.xml"};

	@Override
	protected List<String> getNames() {
		return Arrays.asList(NAMES);
	}
	
	List<MessageSet> getMessageSets(String specificationVersion){
		List<MessageSet> matchingMessageSets = new ArrayList<MessageSet>();
		for (MessageSet messageSet : getMessageSets()){
			if (messageSet.getVersion() == specificationVersion){
				matchingMessageSets.add(messageSet);
			}
		}
		return matchingMessageSets;
	}
}
