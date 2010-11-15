package ca.infoway.messagebuilder.xml.service;

import java.util.Arrays;
import java.util.List;

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
		return Arrays.asList("/messageSet_mock_r02_04_02.xml", "/messageSet_NEWFOUNDLAND.xml");
	}
}
