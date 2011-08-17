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

package ca.infoway.messagebuilder.marshalling;

import static ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode.SYNTAX_ERROR;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ElementParser;
import ca.infoway.messagebuilder.marshalling.hl7.parser.NullFlavorHelper;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParserRegistry;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.util.xml.NodeUtil;
import ca.infoway.messagebuilder.util.xml.XmlDescriber;
import ca.infoway.messagebuilder.xml.ConformanceLevel;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.util.NamespaceUtil;

class Hl7SourceMapper {

	private final Log log = LogFactory.getLog(Hl7SourceMapper.class);
	
	public XmlToModelResult mapToTeal(Hl7MessageSource hl7MessageSource) {
	
		if (hl7MessageSource.getInteraction() != null) {
			Class<? extends InteractionBean> messsageBeanType = MessageBeanRegistry.getInstance().getInteractionBeanType(hl7MessageSource.getMessageTypeKey());
			Object messageBean = BeanUtil.<Object>instantiate(messsageBeanType);
			BeanWrapper wrapper = new BeanWrapper(messageBean);
			mapToTeal(hl7MessageSource, wrapper, null);
			hl7MessageSource.getResult().setMessageObject(messageBean);
			createBeanPathOnErrorMessages(hl7MessageSource.getResult(), messageBean);
		} 
		
        return hl7MessageSource.getResult();
	}

	private void createBeanPathOnErrorMessages(XmlToModelResult result, Object messageBean) {
		// would be nice to push this entire method into XmlToJavaResult, but BeanUtil not visible from XmlToJavaResult
		// (and moving classes or adding a dependency causes all sorts of problems)
		for (Hl7Error hl7Error : result.getHl7Errors()) {
			String beanPath = BeanUtil.describeBeanPath(messageBean, hl7Error.getPath());
			hl7Error.setBeanPath(beanPath);
		}
	}

	Object mapPartSourceToTeal(Hl7PartSource source, Relationship relationship) {
		Object bean = Instantiator.getInstance().instantiateMessagePartBean(source.getVersion(), source.getType(), source.getInteraction());
		BeanWrapper wrapper = new BeanWrapper(bean);
		mapToTeal(source, wrapper, relationship);
		return bean;
	}
	
	private void mapToTeal(Hl7Source source, BeanWrapper wrapper, Relationship relationship) {
		mapNodeAttributesToTeal(source, wrapper, relationship);
		
		List<Element> elements = NodeUtil.toElementList(source.getCurrentElement());
		
		int length = elements.size();
        for (int j = 0; j < length; j++) {
            Element element = elements.get(j);
            String nodeName = NodeUtil.getLocalOrTagName(element);
                
            List<Node> nodes = new ArrayList<Node>();
            nodes.add(element);
            while (j+1 < length && isSameElementName(element, elements.get(j+1))) {
                nodes.add(elements.get(++j));
            }
            if (NamespaceUtil.isHl7Node(element)) {
            	process(wrapper, source, nodes, nodeName);
            }
        }
	}
	
	private boolean isSameElementName(Element element, Element nextElement) {
		return StringUtils.equals(element.getNamespaceURI(), nextElement.getNamespaceURI())
			&& StringUtils.equals(NodeUtil.getLocalOrTagName(element), NodeUtil.getLocalOrTagName(nextElement));
	}

	private void process(BeanWrapper bean, Hl7Source source, List<Node> nodes, String traversalName) {
    	Relationship relationship = source.getRelationship(traversalName);
    	try {
	    	if (relationship == null) {
	    		String message = "Can't find a relationship named : " + traversalName + " on messagePart named " + source.getMessagePartName();
	    		if (mappingNotYetSupported(traversalName)){
	    			this.log.info(message);
	    		} else {
	    			throw new MarshallingException(message);
	    		}
	    	} else if (relationship.isAttribute()) {
	    		writeAttribute(bean, source, nodes, relationship, traversalName);
	    	} else if (isIndicator(source, relationship)) {
	    		writeIndicator(bean, source, nodes, relationship, traversalName);
	    	} else {
	    		writeAssociation(bean, source, nodes, relationship, traversalName);
	    	}
    	} catch (XmlToModelTransformationException e) {
    		throw new MarshallingException(e);
    	}
	}

	private boolean isIndicator(Hl7Source source, Relationship relationship) {
		if (relationship.isTemplateRelationship() || relationship.isChoice() || relationship.isStructural()) {
			return false;
		}
		return isFullyFixedType(relationship, source) && isNotMandatory(relationship.getConformance());
	}

	private boolean isNotMandatory(ConformanceLevel conformance) {
		return conformance != null && conformance != ConformanceLevel.MANDATORY;
	}

	private void writeIndicator(BeanWrapper bean, Hl7Source source, List<Node> nodes, Relationship relationship, String traversalName)
			throws XmlToModelTransformationException {
		try {
			// if "false", as in the indicator element is absent, we will never actually get here :)
			// can't really parse a boolean here, but we need to check for null flavor
			NullFlavorHelper nullFlavorHelper = new NullFlavorHelper(relationship.getConformance(), nodes.isEmpty() ? null : nodes.get(0), new XmlToModelResult(), true);
			NullFlavor nullFlavor = nullFlavorHelper.parseNullNode();
			Object value = (nullFlavor == null ? new BLImpl(!nodes.isEmpty()): 
												 new BLImpl((ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor) nullFlavor));
			bean.write(relationship, value);
		} catch (ClassCastException e){
			this.log.info("Can't parse relationship name=" + relationship.getName() + ", traversalName=" + traversalName + 
					" [" +  e.getMessage() + "]");
		}
	}

	@Deprecated
	private boolean mappingNotYetSupported(String traversalName) {
		if (traversalName == null) {
			return false;
		} else {
			return traversalName.endsWith("realmCode");
		}
	}

	/*
	 * There are 4 scenarios for mapping relationships:
	 *  1. collapsed relationship, e.g. Device is collapsed into the SenderBean
	 *  1b. trivial collapsed relationship with cardinality change (e.g. "RecordId" collapsed into "Location criteria"
	 *  2. initialized read-only association, e.g. ControlActEvent with respect to MessageBean 
	 *  3. non-collapsed relationships, including the following variations:
	 *  	a) choice/specializationChild
	 *  	b) template type
	 *  	c) "standard"
	 *  4. HL7 relationships that we don't currently support
	 */ 
	private void writeAssociation(BeanWrapper beanWrapper, Hl7Source source,
			List<Node> nodes, Relationship relationship, String traversalName) {
			this.log.debug("Writing association: traversalName=" + traversalName + ", relationshipType=" + relationship.getType());		
		// 1. collapsed relationship
		if (relationship.getCardinality().isSingle() && beanWrapper.isAssociationMappedToSameBean(relationship)) {

			this.log.debug("COLLAPSE RECURSE : " + traversalName + " as collapsed relationship to " + beanWrapper.getWrappedType());
			BeanWrapper childBeanWrapper = beanWrapper.createSubWrapper(relationship);
			writeSpecialAssociation(childBeanWrapper, source, nodes, relationship);

		//1b. trivial collapsed relationship with cardinality change (e.g. "RecordId" collapsed into "Location criteria"
		} else if (relationship.getCardinality().isMultiple() && beanWrapper.isAssociationMappedToSameBean(relationship)
				&& isTypeWithSingleNonFixedRelationship(relationship, source)) {
			
			BeanWrapper childBeanWrapper = beanWrapper.createSubWrapper(relationship);
			for (Node node : nodes) {
				writeAssociation(childBeanWrapper, source, (Element) node, relationship);
			}
			
		// 2. initialized read-only association
		} else if (relationship.getCardinality().isSingle() && beanWrapper.isPreInitializedDelegate(relationship)){

			this.log.debug("READ-ONLY ASSOCIATION: " + traversalName + " as collapsed relationship to " + beanWrapper.getWrappedType());
			BeanWrapper childBeanWrapper = new BeanWrapper(beanWrapper.getInitializedReadOnlyAssociation(relationship));
			writeSpecialAssociation(childBeanWrapper, source, nodes, relationship);
			
 		// 3. non-collapsed (including choice, specializationChild, and template type, handling for which is encapsulated in
		//			Source.createChildSource())
 		} else if (relationship.isTemplateRelationship() || relationship.isChoice() ||
 				MessageBeanRegistry.getInstance().isMessagePartDefined(source.getVersion(), relationship.getType())) {
 			List<Object> convertedBeans = new ArrayList<Object>();
 			for (Node node : nodes) {
 				Element childNode = (Element) node;
 				Hl7PartSource childSource = source.createPartSource(relationship, childNode);
 				this.log.debug("RECURSE for node=" + source.getCurrentElement().getNodeName() + " - relationship=" + relationship.getName() + ", tarversalName=" + traversalName + ", of type: " + childSource.getType());
				Object tealChild = mapPartSourceToTeal(childSource, relationship);
 				convertedBeans.add(tealChild);
			}
 			
 			if (relationship.getCardinality().isMultiple()) {
 				this.log.debug("WRITING MULTIPLE: " + beanWrapper.getWrappedType() + " property with annotation=" + traversalName + " - values=" + convertedBeans);
 				beanWrapper.write(relationship, convertedBeans);
 			} else if (relationship.getCardinality().isSingle() && convertedBeans.isEmpty()) {
 	 			throw new MarshallingException("Why is this empty? : " + relationship.getName() + " on " + source.getType());
 			} else if (relationship.getCardinality().isSingle() && convertedBeans.size() == 1) {
 				this.log.debug("WRITING SINGLE: " + beanWrapper.getWrappedType() + " property with annotation=" + traversalName + " - value=" + convertedBeans.get(0));
 				beanWrapper.write(relationship, convertedBeans.get(0));
 			} else {
 	 			throw new MarshallingException("Unexpected cardinality on : " + relationship.getName() + " on " + source.getType());
 			}
 		} else if (isNotOptional(relationship.getConformance()) && !isFullyFixedType(relationship, source)) {
 			this.log.info("IGNORING: HL7 type " + relationship.getType() + " with traversalName=" + traversalName + "(" 
 					+ Describer.describe(source.getMessagePartName(), relationship) 
 					+ ") cannot be mapped to any teal bean");
 		}
	}

	private boolean isTypeWithSingleNonFixedRelationship(Relationship relationship, Hl7Source source) {
		return isTypeWithSpecificNumberOfNonFixedRelationships(relationship, source, 1);
	}

	private boolean isFullyFixedType(Relationship relationship, Hl7Source source) {
		return isTypeWithSpecificNumberOfNonFixedRelationships(relationship, source, 0);
	}

	private boolean isTypeWithSpecificNumberOfNonFixedRelationships(Relationship relationship, Hl7Source source, int numberOfNonFixedRelationships) {
		MessagePart messagePart = source.getService().getMessagePart(source.getVersion(), relationship.getType());
		if (messagePart == null) {
			throw new MarshallingException("Could not find a message part for " + relationship.getType());
		} else {
			int count = 0;
			for (Relationship r : messagePart.getRelationships()) {
				if (!r.isFixed()) {
					count++;
				}
			}
			return count == numberOfNonFixedRelationships;
		}
	}

	private void writeSpecialAssociation(BeanWrapper childBeanWrapper,
			Hl7Source source, List<Node> nodes, Relationship relationship) {
		if (nodes.size() == 1) {
			Element childNode = (Element) nodes.get(0);
			writeAssociation(childBeanWrapper, source, childNode, relationship);
		} else {
			throw new MarshallingException("Expected a single cardinality element to have only one node: ");
		}
	}

	private void writeAssociation(BeanWrapper childBeanWrapper, Hl7Source source, Element element, Relationship relationship) {
		Hl7PartSource childSource = source.createPartSource(relationship, element);
		mapToTeal(childSource, childBeanWrapper, relationship);
	}



	private boolean isNotOptional(ConformanceLevel conformance) {
		return conformance != null && conformance != ConformanceLevel.OPTIONAL;
	}

	private void writeAttribute(BeanWrapper bean, Hl7Source source, List<Node> nodes, Relationship relationship, String traversalName)
			throws XmlToModelTransformationException {
		
		if (relationship.isStructural()) {
			source.getResult().addHl7Error(
					new Hl7Error(
						Hl7ErrorCode.INTERNAL_ERROR, 
						"Data found for relationship as an element but should have been an attribute. " +
								(nodes.isEmpty() 
										? ("(" + relationship.getName() + ")")
										: XmlDescriber.describePath(nodes.get(0))),
						CollectionUtils.isEmpty(nodes) ? null : (Element) nodes.get(0)
					)
			);
		}
		
		String type = relationship.getType();
		ElementParser parser = ParserRegistry.getInstance().get(type);
		if (parser != null) {
			try {
				BareANY object = parser.parse(ParseContextImpl.create(relationship, source.getVersion(), source.getTimeZone()), nodes, source.getResult());
				if (relationship.hasFixedValue()) {
					validateNonstructuralFixedValue(relationship, object, source, nodes); // fixed means nothing to write to bean
				}
				if (!relationship.isFixed()) {
					bean.write(relationship, object);
				}
			} catch (ClassCastException e){
				this.log.info("Can't parse relationship name=" + relationship.getName() + ", traversalName=" + traversalName + 
						" [" +  e.getMessage() + "]");
			}
		} else {
			source.getResult().addHl7Error(
					new Hl7Error(
						Hl7ErrorCode.INTERNAL_ERROR, 
						"No parser for type \"" + type + "\". " +
							(nodes.isEmpty() 
									? ("(" + relationship.getName() + ")")
									: XmlDescriber.describePath(nodes.get(0))),
						CollectionUtils.isEmpty(nodes) ? null : (Element) nodes.get(0)
					)
			);
		}
	}

	private void validateNonstructuralFixedValue(Relationship relationship,	BareANY value, Hl7Source source, List<Node> nodes) {
		if (relationship.hasFixedValue()) {
			boolean valid = (value != null && value.getBareValue() != null);
			if (valid) {
				if ("BL".equals(relationship.getType()) && value instanceof BL) {
					String valueAsString = ((BL) value).getValue().toString();
					valid = relationship.getFixedValue().equalsIgnoreCase(valueAsString);
				} else if ("INT.POS".equals(relationship.getType()) && value instanceof INT) {
					String valueAsString = ((INT) value).getValue().toString();
					valid = relationship.getFixedValue().equalsIgnoreCase(valueAsString);
				} else if (relationship.isCodedType() && value instanceof CD) {
					Code code = ((CD) value).getValue();
					valid = (code.getCodeValue() != null && StringUtils.equals(relationship.getFixedValue(), code.getCodeValue()));
				} else {
					source.getResult().addHl7Error(
						new Hl7Error(
							Hl7ErrorCode.SYNTAX_ERROR, 
							"Non-structural fixed-value attribute '" + relationship.getName() +"' was of unexpected type '" + relationship.getType() + "'",
							CollectionUtils.isEmpty(nodes) ? null : (Element) nodes.get(0)
						)
					);
				}
			}
			if (!valid) {
				source.getResult().addHl7Error(
					new Hl7Error(
						Hl7ErrorCode.MANDATORY_FIELD_NOT_PROVIDED, 
						"Fixed-value attribute '" + relationship.getName() +"' must have value '" + relationship.getFixedValue() + "'",
						CollectionUtils.isEmpty(nodes) ? null : (Element) nodes.get(0)
					)
				);
			}
		}
		
	}

	private void mapNodeAttributesToTeal(Hl7Source source, BeanWrapper wrapper, Relationship relationship) {
		Element currentElement = source.getCurrentElement();
		
    	NullFlavorHelper nullFlavorHelper = new NullFlavorHelper(
    			relationship!=null ? relationship.getConformance() : ConformanceLevel.OPTIONAL, 
    			currentElement,
    			source.getResult(),
    			true);
    	
    	if (nullFlavorHelper.hasValidNullFlavorAttribute()) {
    		wrapper.writeNullFlavor(source, relationship, nullFlavorHelper.parseNullNode());
    	} else {
    		NamedNodeMap map = currentElement.getAttributes();
    		int length = map.getLength();
    		for (int i = 0; i < length; i++) {
    			Node attributeNode = map.item(i);
    			Relationship attributeRelationship = source.getRelationship(NodeUtil.getLocalOrTagName(attributeNode));
    			if (!NamespaceUtil.isHl7Node(attributeNode)) {
    				// quietly ignore it
    			} else if (attributeRelationship == null) {
    				this.log.info("Can't find NodeAttribute relationship named: " + attributeNode.getNodeName());
    			} else {
    				if (attributeRelationship.hasFixedValue()) {
    					validateFixedValue(source, currentElement, (Attr) attributeNode, attributeRelationship);
    				}
    				wrapper.writeNodeAttribute(attributeRelationship, attributeNode.getNodeValue());
    			}
    			validateMandatoryAttributesExist(source, currentElement);	
    		}
    	}		
        
	}

	private void validateMandatoryAttributesExist(Hl7Source source,
			Element element) {
		for (Relationship relationship : getMessagePart(source).getRelationships()) {
			if (relationship.isStructural() && relationship.isMandatory() 
					&& !element.hasAttribute(relationship.getName())) {
				
				source.getResult().addHl7Error(new Hl7Error(SYNTAX_ERROR, 
						MessageFormat.format("Attribute {0} missing ({1})",
								relationship.getName(), 
								XmlDescriber.describeSingleElement(element)),
						element));
			}
		}
	}

	private MessagePart getMessagePart(Hl7Source source) {
		if (source instanceof Hl7MessageSource) {
			return source.getService().getMessagePart(source.getVersion(), source.getType());
		} else {
			return source.getService().getMessagePart(source.getVersion(), source.getMessagePartName());
		}
	}

	private void validateFixedValue(Hl7Source source, Element currentElement,
			Attr attributeNode, Relationship relationship) {
		validateFixedValue(source.getResult(), currentElement, attributeNode, relationship);
	}

	private void validateFixedValue(XmlToModelResult result,
			Element element, Attr attributeNode, Relationship relationship) {
		String value = attributeNode.getNodeValue();
		if (!StringUtils.equals(value, relationship.getFixedValue())) {
			result.addHl7Error(new Hl7Error(SYNTAX_ERROR, 
					MessageFormat.format("Invalid attribute value: expected \"{0}\" but was \"{1}\" ({2})",
							relationship.getFixedValue(), value, 
							XmlDescriber.describeSingleElement(element)),
					attributeNode));
		}
	}
	
}
