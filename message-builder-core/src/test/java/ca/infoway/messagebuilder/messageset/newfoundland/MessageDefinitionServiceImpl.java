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
	
	private final String[] NAMES = {"/messageSet_mock_NEWFOUNDLAND.xml"};

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
