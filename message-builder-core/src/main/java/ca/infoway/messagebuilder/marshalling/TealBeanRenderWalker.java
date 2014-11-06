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
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.ConstrainedDatatype;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.service.MessageDefinitionService;
import ca.infoway.messagebuilder.xml.service.MessageDefinitionServiceFactory;
import ca.infoway.messagebuilder.xml.util.ConformanceLevelUtil;

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

	void processAllRelationships(PartBridge bridge, Interaction interaction, Visitor visitor) {
		for (BaseRelationshipBridge relationship : bridge.getRelationshipBridges()) {
			processRelationship(interaction, relationship, visitor);
		}
	}
	void processRelationship(Interaction interaction, BaseRelationshipBridge relationship, Visitor visitor) {
		if (relationship.isAssociation()) {
			processAllRelationshipValues(interaction, (AssociationBridge) relationship, visitor);
		} else {
			ConstrainedDatatype constraints = this.factory.getConstraints(relationship.getRelationship());
			visitor.visitAttribute((AttributeBridge) relationship, relationship.getRelationship(), constraints, this.version, this.dateTimeZone, this.dateTimeTimeZone);
		}
	}

	void processAllRelationshipValues(Interaction interaction, AssociationBridge relationshipBridge, Visitor visitor) {
		Collection<PartBridge> associationValues = relationshipBridge.getAssociationValues();
		validateAssociationCardinality(relationshipBridge, associationValues, visitor);
		for (PartBridge child : associationValues) {
			processAssociation(interaction, relationshipBridge, visitor, child);
		}
	}
	
	// RM16130 - the MB marshaller was not validating association cardinality
	// TODO TM - this should really be in the visitor, but would pollute the interface a bit
	private void validateAssociationCardinality( AssociationBridge relationshipBridge, Collection<PartBridge> associationValues, Visitor visitor) {
		// can't just check the size of associationValues: need to iterate and only count each "not empty" or each with NF
		int size = 0;
		for (PartBridge partBridge : associationValues) {
			if (!partBridge.isEmpty() || partBridge.hasNullFlavor()) {
				size++;
			}
		}
		
		Relationship relationship = relationshipBridge.getRelationship();
		Cardinality cardinality = relationship.getCardinality();
		if (size > cardinality.getMax()) {
			String errorMessage = "Expected no more than " + cardinality.getMax() + " entries for association " + relationship.getParentType() + "." + relationship.getName() + " but found " + size;
			visitor.logError(new Hl7Error(Hl7ErrorCode.NUMBER_OF_ASSOCIATIONS_EXCEEDS_LIMIT, errorMessage, visitor.getCurrentPropertyPath() + "." + relationship.getName()));
		} else if (size != 0 && size < cardinality.getMin()) {
			// cases where at least 1 association is required are handled elsewhere (under mandatory checks)
			String errorMessage = "Expected at least " + cardinality.getMin() + " entries for association " + relationship.getParentType() + "." + relationship.getName() + " but only found " + size;
			visitor.logError(new Hl7Error(Hl7ErrorCode.MANDATORY_ASSOCIATION_NOT_PROVIDED, errorMessage, visitor.getCurrentPropertyPath() + "." + relationship.getName()));
		}
	}
	
	private void processAssociation(Interaction interaction, AssociationBridge relationshipBridge, Visitor visitor, PartBridge child) {
		visitor.visitAssociationStart(child, relationshipBridge.getRelationship());
		processPartValue(child, interaction, relationshipBridge, visitor);
		visitor.visitAssociationEnd(child, relationshipBridge.getRelationship());
	}

	private void processPartValue(PartBridge child,	Interaction interaction, AssociationBridge relationshipBridge, Visitor visitor) {
		if (child.isEmpty() && !ConformanceLevelUtil.isMandatory(relationshipBridge.getRelationship())) {
		} else {
			processAllRelationships(child, interaction, visitor);
		}
	}
}
