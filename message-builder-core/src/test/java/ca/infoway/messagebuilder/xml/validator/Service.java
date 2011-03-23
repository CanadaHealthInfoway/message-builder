package ca.infoway.messagebuilder.xml.validator;

import java.util.Arrays;
import java.util.List;

import ca.infoway.messagebuilder.xml.service.BaseMessageDefinitionService;

/**
 * @sharpen.ignore
 */
class Service extends BaseMessageDefinitionService {

	/**
	 * @sharpen.protected.internal
	 */
	@Override
	protected List<String> getNames() {
		return Arrays.asList("/ca/infoway/messagebuilder/xml/validator/messageSet_v02r02.xml");
	}
}