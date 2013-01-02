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
import java.util.TimeZone;

import org.apache.commons.lang.ClassUtils;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.service.MessageDefinitionService;
import ca.infoway.messagebuilder.xml.service.MessageDefinitionServiceFactory;

class TealBeanRenderWalker {
	
	private final InteractionBean tealBean;
	private final BridgeFactory factory;
	private final VersionNumber version;
	private final TimeZone dateTimeZone;
	private final TimeZone dateTimeTimeZone;

	public TealBeanRenderWalker(InteractionBean tealBean, VersionNumber version) {
		this(tealBean, version, null, null, new MessageDefinitionServiceFactory().create());
	}
	TealBeanRenderWalker(InteractionBean tealBean, VersionNumber version, TimeZone dateTimeZone, TimeZone dateTimeTimeZone, MessageDefinitionService service) {
		this(tealBean, version, dateTimeZone, dateTimeTimeZone, new BridgeFactoryImpl(service, version));
	}

	TealBeanRenderWalker(InteractionBean tealBean, VersionNumber version, TimeZone dateTimeZone, TimeZone dateTimeTimeZone, BridgeFactory factory) {
		this.tealBean = tealBean;
		this.dateTimeZone = dateTimeZone;
		this.dateTimeTimeZone = dateTimeTimeZone;
		this.factory = factory;
		this.version = version;
	}

	public void accept(Visitor visitor) {
		Interaction interaction = getInteraction();
		if (interaction != null) {
			walk(interaction, visitor);
		} else {
			throw new RenderingException("Cannot determine the interaction type for : " 
					+ (this.tealBean == null ? "null" : ClassUtils.getShortClassName(this.tealBean.getClass())));
		}
	}

	private Interaction getInteraction() {
		return this.factory.getInteraction(this.tealBean);
	}

	private void walk(Interaction interaction, Visitor visitor) {
		PartBridge bridge = getBridge();
		visitor.visitRootStart(bridge, interaction);
		
		processAllRelationships(bridge, interaction, visitor);
		
		visitor.visitRootEnd(bridge, interaction);
	}

	private PartBridge getBridge() {
		return this.factory.createInteractionBridge(this.tealBean);
	}

	void processAllRelationships(PartBridge bridge, Interaction interaction,
			Visitor visitor) {
		for (BaseRelationshipBridge relationship : bridge.getRelationshipBridges()) {
			processRelationship(interaction, relationship, visitor);
		}
	}
	void processRelationship(Interaction interaction, 
			BaseRelationshipBridge relationship, Visitor visitor) {
		if (relationship.isAssociation()) {
			processAllRelationshipValues(interaction, (AssociationBridge) relationship, visitor);
		} else {
			visitor.visitAttribute((AttributeBridge) relationship, relationship.getRelationship(), this.version, this.dateTimeZone, this.dateTimeTimeZone);
		}
	}

	void processAllRelationshipValues(Interaction interaction, 
			AssociationBridge relationshipBridge, Visitor visitor) {
		Collection<PartBridge> associationValues = relationshipBridge.getAssociationValues();
//		if (associationValues.isEmpty() && relationshipBridge.getRelationship().isPopulated()) {
//			processAssociation(interaction, relationshipBridge, visitor, null);
//		} else {
			for (PartBridge child : associationValues) {
				processAssociation(interaction, relationshipBridge, visitor, child);
			}
//		}
	}
	private void processAssociation(Interaction interaction,
			AssociationBridge relationshipBridge, Visitor visitor, PartBridge child) {
		visitor.visitAssociationStart(child, relationshipBridge.getRelationship());
		processPartValue(child, interaction, relationshipBridge, visitor);
		visitor.visitAssociationEnd(child, relationshipBridge.getRelationship());
	}

	private void processPartValue(PartBridge child,
			Interaction interaction, AssociationBridge relationshipBridge,
			Visitor visitor) {
		if (child.isEmpty() && !relationshipBridge.getRelationship().isMandatory()) {
		} else {
			processAllRelationships(child, interaction, visitor);
		}
	}
}
