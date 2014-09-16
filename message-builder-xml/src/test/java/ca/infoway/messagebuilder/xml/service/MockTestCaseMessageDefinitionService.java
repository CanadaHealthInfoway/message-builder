/**
 * Copyright 2013 Canada Health Infoway, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.xml.service;

import java.util.Arrays;
import java.util.List;

import ca.infoway.messagebuilder.VersionNumber;
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

	public List<MessagePart> getUnusedMessageParts(VersionNumber version, String messagePartName) {
		return null;
	}

}
