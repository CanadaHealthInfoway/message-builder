package ca.infoway.messagebuilder.xml.service;

import java.util.Arrays;
import java.util.List;

import ca.infoway.messagebuilder.xml.MessagePart;

/**
 * @sharpen.ignore
 */
public class MockTestCaseMessageDefinitionService extends BaseMessageDefinitionService {
	
	private static boolean initialized = false;

	public static void register() {
		if (!initialized) {
			MessageDefinitionService service = new MessageDefinitionServiceFactory().create();
			if (service != null && service instanceof CompositeMessageDefinitionService) {
				MockTestCaseMessageDefinitionService mockService = new MockTestCaseMessageDefinitionService();
				((CompositeMessageDefinitionService) service).services.add(mockService);
				initialized = true;
			}
		}
	}

	/**
	 * @sharpen.protected.internal 
	 */
	@Override
	protected List<String> getNames() {
		return Arrays.asList("/messageSet_mock_r02_04_02.xml", "/messageSet_mock_NEWFOUNDLAND.xml");
	}

	public List<MessagePart> getUnusedMessageParts(String version,
			String messagePartName) {
		// TODO Auto-generated method stub
		return null;
	}
}
