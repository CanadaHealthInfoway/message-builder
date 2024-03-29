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

package ca.infoway.messagebuilder.marshalling;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.xml.ConstrainedDatatype;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.PackageLocation;
import ca.infoway.messagebuilder.xml.SchematronContext;
import ca.infoway.messagebuilder.xml.service.MessageDefinitionService;

class MockMessageDefinitionService implements MessageDefinitionService {
	
	private Map<String,MessagePart> parts = new HashMap<String,MessagePart>();
	private Map<String,Interaction> interactions = new HashMap<String,Interaction>();
	
	public void initialize() {
	}
	public List<Interaction> getAllInteractions(
			boolean includeDuplicateInteractionsWithChangedBusinessNames) {
		return null;
	}
	public List<Interaction> getAllInteractions(VersionNumber version) {
		return null;
	}
	public Map<String, MessagePart> getAllMessageParts(
			Interaction interaction, VersionNumber version) {
		return null;
	}
	public Collection<MessagePart> getAllMessageParts(VersionNumber version) {
		return null;
	}
	public Interaction getInteraction(VersionNumber version, String type) {
		return this.interactions.get(type);
	}
	public MessagePart getMessagePart(VersionNumber version, String type) {
		return this.parts.get(type);
	}
	public Set<String> getSupportedVersions() {
		return null;
	}
	public Set<String> getSupportedVersionsForInteraction(String type) {
		return null;
	}
	public void addPart(String type, MessagePart part) {
		this.parts.put(type, part);
	}
	public void addInteraction(String type, Interaction interaction) {
		this.interactions.put(type, interaction);
	}
	public Map<String, MessagePart> getAllRelatedMessageParts(
			MessagePart messagePart, VersionNumber version) {
		throw new UnsupportedOperationException();
	}
	public List<MessagePart> getAllRootMessageParts() {
		throw new UnsupportedOperationException();
	}
	public List<MessagePart> getAllRootMessageParts(VersionNumber version) {
		throw new UnsupportedOperationException();
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
	public List<SchematronContext> getAllSchematronContexts(VersionNumber version) {
		return null;
	}
	public List<PackageLocation> getAllPackageLocations(VersionNumber version) {
		return null;
	}
}