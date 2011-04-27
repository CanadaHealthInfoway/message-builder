/**
 * Copyright 2011 Canada Health Infoway, Inc.
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

package ca.infoway.messagebuilder.simple.xml.process;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.ClassUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;

import ca.infoway.messagebuilder.marshalling.MessageBeanRegistry;
import ca.infoway.messagebuilder.marshalling.hl7.MessageTypeKey;
import ca.infoway.messagebuilder.model.InteractionBean;

public class InteractionNameToIdRegistry {
	
	public static InteractionNameToIdRegistry instance;
	private final Map<String, String> interactions;
	
	public InteractionNameToIdRegistry(Map<String, String> interactions) {
		this.interactions = interactions;
	}

	public static InteractionNameToIdRegistry getInstance() {
		if (instance == null) {
			initializeInstance();
		}
		return instance;
	}
	
	public String getMessageId(String name) {
		return this.interactions.get(name);
	}

	private static void initializeInstance() {
		Map<String,String> interactions = new HashMap<String,String>();
		Set<MessageTypeKey> keys = MessageBeanRegistry.getInstance().getMessageTypeKeys();
		for (MessageTypeKey key : keys) {
			Class<? extends InteractionBean> type = MessageBeanRegistry.getInstance().getInteractionBeanType(key);
			String name = extractName(type);
			interactions.put(name, key.getMessageId());
		}
		instance = new InteractionNameToIdRegistry(interactions);
	}

	private static String extractName(Class<? extends InteractionBean> type) {
		String name = ClassUtils.getShortCanonicalName(type);
		if (name.endsWith("MessageBean")) {
			name = StringUtils.chomp(name, "MessageBean");
		} else if (name.endsWith("Bean")) {
			name = StringUtils.chomp(name, "Bean");
		}
		return WordUtils.uncapitalize(name);
	}
}
