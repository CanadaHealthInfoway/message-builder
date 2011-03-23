package ca.infoway.messagebuilder.messageset.v02_r02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.service.BaseMessageDefinitionService;

public class MessageDefinitionServiceImpl extends BaseMessageDefinitionService {
	
	private final String[] NAMES = {"/messageSet_v02_r02_hotfix5.xml"};

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
