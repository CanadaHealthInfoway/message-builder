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

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.xml.ConstrainedDatatype;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessagePart;

/**
 * @sharpen.ignore - xml.service - translated manually
 */
class TrivialService implements MessageDefinitionService {

	public List<Interaction> getAllInteractions(boolean includeDuplicateInteractionsWithChangedBusinessNames) {
		return null;
	}

	public List<Interaction> getAllInteractions(VersionNumber version) {
		return null;
	}

	public Map<String, MessagePart> getAllMessageParts(Interaction interaction,	VersionNumber version) {
		return null;
	}

	public Map<String, MessagePart> getAllRelatedMessageParts(MessagePart messagePart, VersionNumber version) {
		return null;
	}

	public List<MessagePart> getAllRootMessageParts() {
		return null;
	}

	public List<MessagePart> getAllRootMessageParts(VersionNumber version) {
		return null;
	}

	public Interaction getInteraction(VersionNumber version, String type) {
		return null;
	}

	public MessagePart getMessagePart(VersionNumber version, String type) {
		return null;
	}

	public Set<String> getSupportedVersions() {
		return null;
	}

	public Set<String> getSupportedVersionsForInteraction(String type) {
		return null;
	}

	public Collection<MessagePart> getAllMessageParts(VersionNumber version) {
		return null;
	}

	public boolean isR2(VersionNumber version) {
		return false;
	}

	public boolean isCda(VersionNumber version) {
		return false;
	}

	public ConstrainedDatatype getConstraints(VersionNumber version, String constrainedType) {
		return null;
	}

}
