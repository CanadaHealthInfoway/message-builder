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

import static ca.infoway.messagebuilder.xml.ChoiceSupport.choiceOptionTypePredicate;
import static ca.infoway.messagebuilder.xml.util.ConformanceLevelUtil.ASSOCIATION_IS_IGNORED_AND_CAN_NOT_BE_USED;
import static ca.infoway.messagebuilder.xml.util.ConformanceLevelUtil.ASSOCIATION_IS_NOT_ALLOWED;
import static ca.infoway.messagebuilder.xml.util.ConformanceLevelUtil.ATTRIBUTE_IS_IGNORED_AND_CAN_NOT_BE_USED;
import static ca.infoway.messagebuilder.xml.util.ConformanceLevelUtil.ATTRIBUTE_IS_NOT_ALLOWED;
import static ca.infoway.messagebuilder.xml.util.ConformanceLevelUtil.isIgnoredNotAllowed;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.ClassUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ca.infoway.messagebuilder.MarshallingException;
import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.j5goodies.BeanProperty;
import ca.infoway.messagebuilder.marshalling.hl7.MessageTypeKey;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.platform.ListElementUtil;
import ca.infoway.messagebuilder.xml.Argument;
import ca.infoway.messagebuilder.xml.ChoiceSupport;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.Predicate;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.TypeName;
import ca.infoway.messagebuilder.xml.service.MessageDefinitionService;
import ca.infoway.messagebuilder.xml.util.ConformanceLevelUtil;

class BridgeFactoryImpl implements BridgeFactory {
	
	private final Log log = LogFactory.getLog(BridgeContext.class);
	private final VersionNumber version;
	private final MessageDefinitionService service;

	public BridgeFactoryImpl(MessageDefinitionService service, VersionNumber version) {
		this.service = service;
		this.version = version;
	}
	
	public PartBridge createInteractionBridge(InteractionBean tealBean) {
		Interaction interaction = getInteraction(tealBean);
		return new TopLevelBeanBridgeWrapper(
				createPartBridgeFromBean(tealBean.getClass().getSimpleName(), tealBean, interaction, getMessagePart(interaction)),
				interaction.getName(), 
				this.version);
	}

	PartBridge createPartBridgeFromBean(String propertyPath, Object tealBean, Interaction interaction, MessagePartHolder currentMessagePart) {
		RelationshipSorter sorter = RelationshipSorter.create(propertyPath, tealBean);
		return createPartBridge(sorter, interaction, currentMessagePart, new BridgeContext(), false);
	}

	private PartBridge createPartBridge(RelationshipSorter sorter,
			Interaction interaction, MessagePartHolder currentMessagePart, BridgeContext context, boolean nullPart) {
		List<BaseRelationshipBridge> relationships = new ArrayList<BaseRelationshipBridge>();
		for (Relationship relationship : currentMessagePart.getRelationships()) {
			Object o = sorter.get(relationship);
			if (relationship.isAttribute() && relationship.hasFixedValue() && ConformanceLevelUtil.isMandatory(relationship)) {
				relationships.add(new FixedValueAttributeBeanBridge(relationship, (BareANY) null));
			} else if (relationship.isAttribute()) {
				if (o == null) {
					createWarningIfPropertyIsNotMapped(sorter, currentMessagePart, relationship);
					relationships.add(new AttributeBridgeImpl(relationship, null));
				} else if (context.isIndexed()) {
					createWarningIfConformanceLevelIsNotAllowed(relationship);
					Object field = sorter.getField(relationship);
					if (ListElementUtil.isCollection(field)) {
						relationships.add(new CollapsedAttributeBridge(
								((BeanProperty) o).getName(), relationship, 
								ListElementUtil.getElement(field, context.getIndex())));
					} else {
						throw new MarshallingException("Expected relationship " 
								+ relationship.getName() + " on " + sorter 
								+ " to resolve to a List because we think it's a collapsed " 
								+ " attribute");
					}
				} else {
					createWarningIfConformanceLevelIsNotAllowed(relationship);
					relationships.add(createAttributeBridge(relationship,
							(BeanProperty) o, sorter, currentMessagePart));
				}
			} else if (isIndicator(relationship)) {
				createWarningIfConformanceLevelIsNotAllowed(relationship);
				relationships.add(createIndicatorAssociationBridge(
						relationship, sorter, interaction, context, (BeanProperty) o));
			} else { 
				if (o == null) {
					createWarningIfPropertyIsNotMapped(sorter, currentMessagePart, relationship);
					if (ConformanceLevelUtil.isMandatory(relationship) || ConformanceLevelUtil.isPopulated(relationship)) {
						relationships.add(
								new AssociationBridgeImpl(relationship, createNullPartBridge(relationship, interaction)));
					}
				} else {
					createWarningIfConformanceLevelIsNotAllowed(relationship);
					relationships.add(createAssociationBridge(
							relationship, sorter, interaction, currentMessagePart, context));
				}
			}
		}
		
//		if (sorter.getPropertyName() == null || sorter.getPropertyName().equals("null")) {
//			System.out.println("not correct");
//		}
		
		return new PartBridgeImpl(sorter.getPropertyName(), sorter.getBean(), currentMessagePart.getName(), relationships, context.isCollapsed(), nullPart);
	}

	private void createWarningIfConformanceLevelIsNotAllowed(Relationship relationship) {
		// FIXME - TM (see RM19206) - IGNORED/NOT_ALLOWED - these should log a warning in the Hl7Errors bean, not just as a log message
		if(isIgnoredNotAllowed() && ConformanceLevelUtil.isIgnored(relationship)) {
			this.log.debug(MessageFormat.format(
					relationship.isAssociation()?
							ASSOCIATION_IS_IGNORED_AND_CAN_NOT_BE_USED:
							ATTRIBUTE_IS_IGNORED_AND_CAN_NOT_BE_USED, 
					relationship.getName()));							
		} else if (ConformanceLevelUtil.isNotAllowed(relationship)){
			this.log.debug(MessageFormat.format(
					relationship.isAssociation()?
							ASSOCIATION_IS_NOT_ALLOWED:
							ATTRIBUTE_IS_NOT_ALLOWED, 
					relationship.getName()));
		}
	}
	
	private IndicatorAssociationBridgeImpl createIndicatorAssociationBridge(Relationship relationship, RelationshipSorter sorter,
			Interaction interaction, BridgeContext context,	BeanProperty beanProperty) {
		PartBridge partBridge = null;
		if (beanProperty == null || beanProperty.get() == null) {
			partBridge = createNullPartBridge(relationship, interaction);
		} else {
			partBridge = createPartBridge(sorter, interaction, getMessagePart(interaction, relationship, null), new BridgeContext(), false);
		}
		return new IndicatorAssociationBridgeImpl(relationship, partBridge, beanProperty);
	}

	private boolean isIndicator(Relationship relationship) {
		boolean result = (!ConformanceLevelUtil.isMandatory(relationship) && !relationship.isChoice() && relationship.getType() != null && !relationship.isStructural()); 
		if (result) {
			String type = relationship.getType();
			MessagePart messagePart = this.service.getMessagePart(this.version, type);
			for (Relationship innerRelationship : messagePart.getRelationships()) {
				if (!(innerRelationship.hasFixedValue() && ConformanceLevelUtil.isMandatory(innerRelationship))) {
					result = false;
					break;
				}
			}
		}
		return result;
	}

	private void createWarningIfPropertyIsNotMapped(RelationshipSorter sorter,
			MessagePartHolder currentMessagePart, Relationship relationship) {
		if (sorter.getBeanType() != null) {
			this.log.debug("Relationship " + Describer.describe(currentMessagePart, relationship) 
					+ " does not appear to be mapped to any property of " + ClassUtils.getShortClassName(sorter.getBeanType()));
		}
	}

	private PartBridge createNullPartBridge(Relationship relationship, Interaction interaction) {
		RelationshipSorter sorter = RelationshipSorter.create(relationship.getName(), null);
		MessagePartHolder currentMessagePart = getMessagePart(interaction, relationship, null);
		if (currentMessagePart != null) {
			return createPartBridge(sorter, interaction, currentMessagePart, new BridgeContext(), true);
		} else {
			return new PartBridgeImpl(relationship.getName(), 
							null, 
							relationship.getType(), Collections.<BaseRelationshipBridge>emptyList(), false, true);
		}
	}

	@SuppressWarnings("rawtypes")
	private AssociationBridge createAssociationBridge(Relationship relationship,
			RelationshipSorter sorter, Interaction interaction,
			MessagePartHolder currentMessagePart, BridgeContext context) {
		
		if (sorter.isCollapsedRelationship(relationship)) {
			if (relationship.getCardinality().isMultiple()) {
				return createCollectionRelationshipBridge(relationship, sorter, interaction);
			} else {
				RelationshipSorter collapsedSorter = sorter.getAsRelationshipSorter(relationship);
				PartBridge bridge = 
						createPartBridge(
							collapsedSorter, 
							interaction, 
							getMessagePart(interaction, relationship, collapsedSorter.getBean()), 
							new BridgeContext(true, context.getOriginalIndex()), 
							false);
				return new AssociationBridgeImpl(relationship, bridge);
			}
		} else {
			Object o = sorter.get(relationship);
			BeanProperty property = (BeanProperty) o;
			Object value = property.get();
			
			MessagePartHolder part = getMessagePart(interaction, relationship, value);
			if (relationship.getCardinality().isMultiple() && value instanceof Iterable) {
				this.log.debug("Association " + Describer.describe(currentMessagePart, relationship) 
						+ " maps to collection property " + Describer.describe(sorter.getBeanType(), property));
				return createCollectionOfCompositeBeanBridges(property.getName(), relationship, (Iterable) value, interaction);
			} else if (context.isIndexed() && property.isCollection()) {
				this.log.debug("Association " + Describer.describe(currentMessagePart, relationship) 
						+ " maps to index " + context.getIndex() +  " of collection property " + Describer.describe(sorter.getBeanType(), property));
				
				Object elementValue = ListElementUtil.getElement(value, context.getIndex()); 
				
				// use the indexed object's part instead
				part = getMessagePart(interaction, relationship, elementValue);
				
				return new AssociationBridgeImpl(relationship, 
						createPartBridgeFromBean(property.getName() + "[" + context.getIndex() + "]", elementValue, interaction, part));
			} else {
				this.log.debug("Association " + Describer.describe(currentMessagePart, relationship) 
						+ " maps to property " + Describer.describe(sorter.getBeanType(), property));
				
				// Bug 13050 - should handle a single cardinality relationship if mapped to a collection
				if (ListElementUtil.isCollection(value)) {
					value = ListElementUtil.isEmpty(value) ? null : ListElementUtil.getElement(value, 0); 
				}
				
				return new AssociationBridgeImpl(relationship, 
						createPartBridgeFromBean(property.getName(), value, interaction, part));
			}
		}
	}

	private AssociationBridge createCollectionRelationshipBridge(
			Relationship relationship, RelationshipSorter sorter, Interaction interaction) {

		RelationshipSorter association = sorter.getAsRelationshipSorter(relationship);
		
		ArrayList<PartBridge> list = new ArrayList<PartBridge>();
		int length = association.getSingleCollapsedPropertySize();
		for (int i = 0; i < length; i++) {
			list.add(createPartBridge(association, interaction, 
					getMessagePart(interaction, relationship, null), new BridgeContext(true, i), false));
		}
		// bug 13240 - if empty collection and pop/mand, add a placeholder bridge - this will output a nullflavor element, and a warning for mandatory
		if (list.isEmpty() && (ConformanceLevelUtil.isPopulated(relationship) || ConformanceLevelUtil.isMandatory(relationship))) {
			list.add(createPartBridgeFromBean("", null, interaction, getMessagePart(interaction, relationship, null)));
		}
		return new AssociationBridgeImpl(relationship, list);
	}
	

	protected BaseRelationshipBridge createAttributeBridge(Relationship relationship,
			BeanProperty property, RelationshipSorter sorter,
			MessagePartHolder currentMessagePart) {
		this.log.debug("Attribute " + Describer.describe(currentMessagePart, relationship) 
				+ " maps to property " + Describer.describe(sorter.getBeanType(), property));
		return new AttributeBridgeImpl(relationship, property);
	}
	
	@SuppressWarnings("rawtypes")
	private AssociationBridge createCollectionOfCompositeBeanBridges(String propertyName, Relationship relationship, Iterable value, Interaction interaction) {
		List<PartBridge> list = new ArrayList<PartBridge>();
		for (Object object : value) {
			list.add(createPartBridgeFromBean(propertyName, object, interaction, getMessagePart(interaction, relationship, value)));
		}
		// bug 13240 - if empty collection and pop/mand, add a placeholder bridge - this will output a nullflavor element, and a warning for mandatory
		if (list.isEmpty() && (ConformanceLevelUtil.isPopulated(relationship) || ConformanceLevelUtil.isMandatory(relationship))) {
			list.add(createPartBridgeFromBean(propertyName, null, interaction, getMessagePart(interaction, relationship, value)));
		}
		return new AssociationBridgeImpl(relationship, list);
	}

	private MessagePartHolder getMessagePart(Interaction interaction, Relationship relationship, Object value) {
		String typeName = relationship.getType();
		if (relationship.isTemplateRelationship()) {
			Argument argument = interaction.getArgumentByTemplateParameterName(relationship.getTemplateParameterName());
			if (argument.isChoice()) {
				Predicate<Relationship> predicate =	choiceOptionTypePredicate(getTypes(value));
				Relationship option = argument.findChoiceOption(predicate);
				if (option != null) {
					typeName = option.getType();
				} else {
					// couldn't find a choice type to use (most likely, value is null)
					// can't leave typeName as null, so just use first choice type from argument
					typeName = argument.getChoices().get(0).getType();
				}
			} else {
				typeName = argument.getName();
			}
		} else if (relationship.isChoice()) {
			Relationship option = relationship.findChoiceOption(ChoiceSupport.choiceOptionTypePredicate(getTypes(value)));
			if (option != null) {
				typeName = option.getType();
			}
		}
		
		return buildMessagePartHolder(relationship, typeName, interaction);
	}

	private MessagePartHolder buildMessagePartHolder(Relationship relationship, String typeName, Interaction interaction) {
		TypeName start = new TypeName(getActualType(interaction, relationship));
		TypeName end = new TypeName(typeName);
		// Sigh. Missing some template info on choices in Location messages within the NFLD messageset.
		if (requiresNewfoundlandHack(relationship)) {
			start = end;
		}
		List<TypeName> typeHierarchy = new PathBuilder(this.service, this.version).findPathTo(start, end);
		return new MessagePartHolder(this.service, this.version, typeName, typeHierarchy);
	}
	
	private String getActualType(Interaction interaction, Relationship relationship) {
		String typeName = relationship.getType();
		if (relationship.isTemplateRelationship()) {
			Argument argument = interaction.getArgumentByTemplateParameterName(relationship.getTemplateParameterName());
			typeName = argument.getName();
		}
		
		return typeName;
	}

	private boolean requiresNewfoundlandHack(Relationship relationship) {
		return isNewfoundland(this.version) && relationship.isChoice() && relationship.getType() == null;
	}
	
	private boolean isNewfoundland(VersionNumber version) {
		// this version is not currently supported by MB and is not in the SpecificationVersion enum
		// TM - NEWFOUNDLAND TEST HACK
		return version != null && StringUtils.equals(version.getVersionLiteral(), "NEWFOUNDLAND");
	}
	
	private String[] getTypes(Object value) {
		Class<?> c = value == null ? null : value.getClass();
		if (c != null && c.isAnnotationPresent(Hl7PartTypeMapping.class)) {
			return c.getAnnotation(Hl7PartTypeMapping.class).value();
		} else {
			return new String[0];
		}
	}

	private MessagePartHolder getMessagePart(Interaction interaction) {
		return new MessagePartHolder(this.service, this.version, interaction.getSuperTypeName());
	}

	public Interaction getInteraction(InteractionBean tealBean) {
		MessageTypeKey type = MessageBeanRegistry.getInstance().getType(this.version, tealBean);
		return this.service.getInteraction(this.version, type.getMessageId());
	}
}
