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

import static ca.infoway.messagebuilder.error.Hl7ErrorCode.SYNTAX_ERROR;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;


import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.MarshallingException;
import ca.infoway.messagebuilder.codeRegistry.CodeTypeRegistry;
import ca.infoway.messagebuilder.datatype.ANY;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.lang.CodedTypeR2;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;
import ca.infoway.messagebuilder.error.ErrorLogger;
import ca.infoway.messagebuilder.error.Hl7Error;
import ca.infoway.messagebuilder.error.Hl7ErrorCode;
import ca.infoway.messagebuilder.error.Hl7ErrorLevel;
import ca.infoway.messagebuilder.error.Hl7Errors;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ElementParser;
import ca.infoway.messagebuilder.marshalling.hl7.parser.NullFlavorHelper;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParserRegistry;
import ca.infoway.messagebuilder.marshalling.hl7.parser.r2.ParserR2Registry;
import ca.infoway.messagebuilder.marshalling.polymorphism.PolymorphismHandler;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.schema.XmlSchemas;
import ca.infoway.messagebuilder.util.xml.NodeUtil;
import ca.infoway.messagebuilder.util.xml.XmlDescriber;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.ConformanceLevel;
import ca.infoway.messagebuilder.xml.ConstrainedDatatype;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.util.ConformanceLevelUtil;
import ca.infoway.messagebuilder.xml.util.NamespaceUtil;

class Hl7SourceMapper {

	private final Log log = LogFactory.getLog(Hl7SourceMapper.class);
	
	private PolymorphismHandler polymorphismHandler = new PolymorphismHandler();
	
	public XmlToModelResult mapToTeal(Hl7MessageSource hl7MessageSource) {
	
		if (hl7MessageSource.getInteraction() != null) {
			Class<? extends InteractionBean> messageBeanType = MessageBeanRegistry.getInstance().getInteractionBeanType(hl7MessageSource.getMessageTypeKey());
			Object messageBean = BeanUtil.<Object>instantiate(messageBeanType);
			BeanWrapper wrapper = new BeanWrapper(messageBean);
			mapToTeal(hl7MessageSource, wrapper, null);
			hl7MessageSource.getResult().setMessageObject(messageBean);
			createBeanPathOnErrorMessages(hl7MessageSource.getResult(), messageBean);
		} 
		
        return hl7MessageSource.getResult();
	}

	private void createBeanPathOnErrorMessages(XmlToModelResult result, Object messageBean) {
		// would be nice to push this entire method into XmlToModelResult, but BeanUtil not visible from XmlToModelResult
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
		
		// 1) "elements" contains the xml-order of the current part's relationships - note that this can have duplicates at this point
		// 2) "source" contains the message part being processed - this is not exposed
		// 3) "source" contains the result bean where errors can be stored - this *is* exposed
		// 4) need to watch choice/template cases (including choices with supertypes)
		
		// relationship.getType() is 
		//		- choice type (if choice)
		//		- null (if template)
		//		- or the actual type
		// source.getMessagePartName() is
		//      - the choice option (if above was a choice)
		//      - the actual template type (if above was null)
		//      - or the actual type (which it is in all cases, really)

		List<String> xmlElementNamesInProvidedOrder = new ArrayList<String>();
		ArrayList<Relationship> sortedRelationshipsMatchingUpToXmlElementNames = new ArrayList<Relationship>();
		Map<String, String> resolvedRelationshipNames = new HashMap<String, String>();
		
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
            	
    	    	Relationship xmlRelationship = source.getRelationship(nodeName);
    	    	if (xmlRelationship != null) {
    	    		validateNamespace(element, xmlRelationship, source);
    	    		// since we have a match we know that the xml name is correct; all we need the xmlRelationship for is sorting purposes
    	    		// however, for choice and template relationships, there will be an apparent mismatch between relationship names 
    	    		xmlElementNamesInProvidedOrder.add(nodeName);
    	    		sortedRelationshipsMatchingUpToXmlElementNames.add(xmlRelationship);
    	    		resolvedRelationshipNames.put(generateRelationshipKey(xmlRelationship), nodeName);
    	    	}
    	    	
            	process(wrapper, source, nodes, nodeName);
            }
        }

        // this sorts the matching relationships according to HL7v3/MIF requirements
		Collections.sort(sortedRelationshipsMatchingUpToXmlElementNames);
		validateElementOrder(source, xmlElementNamesInProvidedOrder, sortedRelationshipsMatchingUpToXmlElementNames, resolvedRelationshipNames);
		validateMissingMandatoryNonStructuralRelationships(source, resolvedRelationshipNames);
	}

	private void validateNamespace(Node node, Relationship xmlRelationship, Hl7Source source) {
		if (!NamespaceUtil.isNamespaceCorrect(node, xmlRelationship)) {
			String message = MessageFormat.format("Expected relationship {0}.{1} to have namespace {2} but was {3}", 
					xmlRelationship.getParentType(), xmlRelationship.getName(), NamespaceUtil.getExpectedNamespace(xmlRelationship), NamespaceUtil.getActualNamespace(node));
			Hl7Error hl7Error = new Hl7Error(Hl7ErrorCode.UNEXPECTED_NAMESPACE, Hl7ErrorLevel.ERROR, message, node);
			source.getResult().addHl7Error(hl7Error);
		}
	}

	private void validateMissingMandatoryNonStructuralRelationships(Hl7Source source, Map<String, String> resolvedRelationshipNames) {
		// compare xml provided elements with all known mandatory relationships (watch for nested)
		List<Relationship> allRelationships = source.getAllRelationships();
		for (Relationship relationship : allRelationships) {
			// ignore structural - this has been checked elsewhere (and isn't contained in the resolved relationships anyway)
			if (!relationship.isStructural() && relationship.getCardinality().getMin() > 0) {
				if (!resolvedRelationshipNames.containsKey(generateRelationshipKey(relationship))) {
					Hl7Error error = new Hl7Error(
							relationship.isAssociation() ? Hl7ErrorCode.MANDATORY_ASSOCIATION_NOT_PROVIDED : Hl7ErrorCode.MANDATORY_FIELD_NOT_PROVIDED, 
							"Relationship '" + relationship.getName() + "' has a minimum cardinality greater than zero, but no value was provided.", 
							source.getCurrentElement());
					source.getResult().addHl7Error(error);

					// check for missing fixed constraints
					ConstrainedDatatype constraints = source.getService().getConstraints(source.getVersion(), relationship.getConstrainedType());
					if (constraints != null) {
						boolean isTemplateId = constraints.getName().endsWith("templateId");
						for (Relationship constraint : constraints.getRelationships()) {
							if (constraint.hasFixedValue()) {
								String msg = MessageFormat.format("{0}.{1} property constrained to {2} but no value was provided.", relationship.getName(), constraint.getName(), constraint.getFixedValue());
								Hl7ErrorCode errorCode = (isTemplateId ? Hl7ErrorCode.CDA_TEMPLATEID_FIXED_CONSTRAINT_MISSING : Hl7ErrorCode.CDA_FIXED_CONSTRAINT_MISSING);
								source.getResult().addHl7Error(new Hl7Error(errorCode, Hl7ErrorLevel.WARNING, msg, source.getCurrentElement()));
							}
						}
					}
					
				}
			}
			
		}
	}

	private String generateRelationshipKey(Relationship xmlRelationship) {
		return xmlRelationship.getParentType() + "." + xmlRelationship.getName();
	}

	private void validateElementOrder(
			Hl7Source source,
			List<String> xmlElementNamesInProvidedOrder,
			List<Relationship> sortedRelationshipsMatchingUpToXmlElementNames,
			Map<String, String> resolvedRelationshipNames) {
		
		for (int i = 0; i < sortedRelationshipsMatchingUpToXmlElementNames.size(); i++) {
			Relationship rel = sortedRelationshipsMatchingUpToXmlElementNames.get(i);
			String name1 = xmlElementNamesInProvidedOrder.get(i);
    		String name2 = resolvedRelationshipNames.get(generateRelationshipKey(rel));
			
			if (!StringUtils.equals(name1, name2)) {
				String message = 
						"Elements appear to be out of expected order starting around '" + name1 + "'" + ". " +
						"Expected order to be: " + listNames(sortedRelationshipsMatchingUpToXmlElementNames, resolvedRelationshipNames);

				// would be nice to merge this error in at the correct place if new errors added by the call to process() within mapToTeal()
				source.getResult().addHl7Error(new Hl7Error(Hl7ErrorCode.SYNTAX_ERROR, message, source.getCurrentElement()));
				break;
			}
		}
		
	}
	
	private String listNames(List<Relationship> sortedRelationshipsMatchingUpToXmlElementNames,	Map<String, String> resolvedRelationshipNames) {
		 Iterator<Relationship> iterator = sortedRelationshipsMatchingUpToXmlElementNames.iterator();
		 if (!iterator.hasNext()) {
			 return "[]";
		 }

		 StringBuilder sb = new StringBuilder();
		 sb.append('[');
		 for (;;) {
		    Relationship relationship = iterator.next();
			sb.append(resolvedRelationshipNames.get(generateRelationshipKey(relationship)));
			 if (!iterator.hasNext()) {
			     return sb.append(']').toString();
			 }
			 sb.append(", ");
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
	    			if (nodes == null || nodes.isEmpty()) { 
	    				throw new MarshallingException(message);
	    			} else {
	    				source.getResult().addHl7Error(new Hl7Error(Hl7ErrorCode.SYNTAX_ERROR, message, (Element) nodes.get(0)));
	    			}
	    		}
	    	} else if (relationship.isAttribute()) {
	    		// attribute cardinality checked at datatype level
	    		writeAttribute(bean, source, nodes, relationship, traversalName);
	    	} else {
	    		// need to check association cardinality here
	    		validateAssociationCardinality(source, nodes, traversalName, relationship);
		    	if (isIndicator(source, relationship)) {
		    		writeIndicator(bean, source, nodes, relationship, traversalName);
		    	} else {
		    		writeAssociation(bean, source, nodes, relationship, traversalName);
		    	}
	    	} 
    	} catch (MarshallingException e) {
    		// RM18422 - log an error rather than throwing an exception up the chain
    		// this is a "known" exception that has been handled to some extent
        	Element element = nodes == null || nodes.isEmpty() ? null : (Element) nodes.get(0);
			source.getResult().addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, e.getMessage(), element));
    	} catch (Exception e) {
    		// RM18422 - unexpected (and thus unhandled) exception; still, likely best to log it rather than kill entire process
        	Element element = nodes == null || nodes.isEmpty() ? null : (Element) nodes.get(0);
			source.getResult().addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, "Unexpected error: " + e.getMessage(), element));
    	}
	}

	private void validateAssociationCardinality(Hl7Source source, List<Node> nodes, String traversalName, Relationship relationship) {
		Cardinality cardinality = relationship.getCardinality();
		int numberOfAssociations = nodes.size();
		if (cardinality != null && !cardinality.contains(numberOfAssociations)) {
			Hl7Error error = Hl7Error.createWrongNumberOfAssociationsError(traversalName, source.getCurrentElement(), numberOfAssociations, cardinality);
			source.getResult().addHl7Error(error);
		}
	}

	private boolean isIndicator(Hl7Source source, Relationship relationship) {
		if (relationship.isTemplateRelationship() || relationship.isChoice() || relationship.isStructural()) {
			return false;
		}
		return isFullyFixedType(relationship, source) && !ConformanceLevelUtil.isMandatory(relationship);
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
			
	 	// 3a. non-collapsed, multiple-cardinality choice or single-cardinality choice with node name same as choice name
 		} else if (isCdaChoice(nodes, relationship, source)) {
 			
 			List<Object> convertedBeans = handleCdaChoice(nodes, traversalName, relationship, source);
 			
 			if (relationship.getCardinality().isMultiple()) {
 				this.log.debug("Special choice handling: WRITING MULTIPLE-CARDINALITY CHOICE: " + beanWrapper.getWrappedType() + " property with annotation=" + traversalName + " - values=" + convertedBeans);
 				beanWrapper.write(relationship, convertedBeans);
 			} else if (relationship.getCardinality().isSingle() && convertedBeans.isEmpty()) {
 	 			throw new MarshallingException("Special choice handling: Why is this empty? : " + relationship.getName() + " on " + source.getType());
 			} else if (relationship.getCardinality().isSingle() && convertedBeans.size() == 1) {
 				this.log.debug("Special choice handling: WRITING SINGLE: " + beanWrapper.getWrappedType() + " property with annotation=" + traversalName + " - value=" + convertedBeans.get(0));
 				beanWrapper.write(relationship, convertedBeans.get(0));
 			} else {
 	 			throw new MarshallingException("Unexpected cardinality on : " + relationship.getName() + " on " + source.getType());
 			}

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
 		} else if (!ConformanceLevelUtil.isOptional(relationship) && !isFullyFixedType(relationship, source)) {
 			this.log.info("IGNORING: HL7 type " + relationship.getType() + " with traversalName=" + traversalName + "(" 
 					+ Describer.describe(source.getMessagePartName(), relationship) 
 					+ ") cannot be mapped to any teal bean");
 		}
	}

	private List<Object> handleCdaChoice(List<Node> nodes, String traversalName, Relationship relationship, Hl7Source source) {
		List<Object> convertedBeans = new ArrayList<Object>();
		for (Node node : nodes) {
			Element childNode = (Element) node;
			
			int currentNodeDepth = XmlDescriber.getDepth(childNode);
			
			int currentErrorCount = source.getResult().getHl7Errors().size();
			List<String> allChoiceTypes = determineAllChoiceTypes(relationship.getChoices());
			Hl7SourceMapperChoiceCandidate choiceCandidate = null;
			boolean foundMultipleChoiceCandidates = false;
			
			for (String choiceType : allChoiceTypes) {
				Hl7PartSource childSource = source.createPartSourceForSpecificType(relationship, childNode, choiceType);
				this.log.debug("RECURSE for node=" + source.getCurrentElement().getNodeName() + " - relationship=" + relationship.getName() + ", tarversalName=" + traversalName + ", of type: " + childSource.getType());
				
				// after creating tealChild for each choiceType
				// - store tealChild
				// - store all new errors, removing them from the main error container

				Object tealChild = mapPartSourceToTeal(childSource, relationship);
				
				Hl7SourceMapperChoiceCandidate newChoiceCandidate = new Hl7SourceMapperChoiceCandidate(tealChild);
				
				int newErrorsCount = (source.getResult().getHl7Errors().size() - currentErrorCount);
				for (int i = 0; i < newErrorsCount; i++) {
					Hl7Error removedError = source.getResult().getHl7Errors().remove(currentErrorCount);
					newChoiceCandidate.addError(removedError);
				}
				
				if (newChoiceCandidate.isAcceptableChoiceCandidate(currentNodeDepth)) {
					if (newChoiceCandidate.hasTemplateIdMatch(currentNodeDepth)) {
						// we'll take the first one that has a template id match
						choiceCandidate = newChoiceCandidate;
						foundMultipleChoiceCandidates = false;
						break;
					} else {
						if (choiceCandidate != null) {
							foundMultipleChoiceCandidates = true;
						}
						choiceCandidate = newChoiceCandidate;
					}
				}
			}
			
			if (choiceCandidate != null && !foundMultipleChoiceCandidates) { 
				convertedBeans.add(choiceCandidate.getParsedBean());
				source.getResult().getHl7Errors().addAll(choiceCandidate.getStoredErrors());
			} else {
				source.getResult().addHl7Error(
						new Hl7Error(
							Hl7ErrorCode.COULD_NOT_DETERMINE_CHOICE_OPTION,
							Hl7ErrorLevel.WARNING,
							"Could not determine an appropriate match for a choice element: " + XmlDescriber.describePath(node),
							childNode
						)
				);
			}
		}
		return convertedBeans;
	}

	private boolean isCdaChoice(List<Node> nodes, Relationship relationship, Hl7Source source) {
		boolean result = relationship.isChoice();
		if (result) {
			// a multiple cardinality choice is automatically considered a "cda choice"
			result = relationship.getCardinality().isMultiple();
			// TM - all multiple-cardinality choices should now be a "CDA choice"
//			if (!result && nodes.size() == 1) {
//				// this is a "cda choice" if the element name matches the choice name *and* does not have a match in the choice options (including nested options)
//				List<String> allOptionNames = relationship.getAllBottomMostOptionNames();
//				String nodeName = nodes.get(0).getNodeName();
//				result = StringUtils.equals(nodeName, relationship.getName()) && !allOptionNames.contains(nodeName);
//			}
		}
		return result;
	}

	private List<String> determineAllChoiceTypes(List<Relationship> choices) {
		ArrayList<String> results = new ArrayList<String>();
		for (Relationship rel : choices) {
			if (rel.getChoices().isEmpty()) {
				results.add(rel.getType());
			} else {
				results.addAll(determineAllChoiceTypes(rel.getChoices()));
			}
		}
		return results;
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
				if (!r.hasFixedValue()) {
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
		
		String type = determineType(nodes, relationship, source, source.getResult());
		
		ElementParser parser = (source.isR2() ? ParserR2Registry.getInstance().get(type): ParserRegistry.getInstance().get(type));
		if (parser != null) {
			try {
				ConstrainedDatatype constraints = source.getService().getConstraints(source.getVersion(), relationship.getConstrainedType());
				ParseContextImpl context = new ParseContextImpl(relationship, constraints, source.getVersion(), source.getDateTimeZone(), source.getDateTimeTimeZone(), CodeTypeRegistry.getInstance(), source.isCda());
				BareANY object = parser.parse(context, nodes, source.getResult());
				
				changeDatatypeIfNecessary(type, relationship, object);
				
				if (relationship.hasFixedValue()) {
					validateNonstructuralFixedValue(relationship, object, source, nodes); // fixed means nothing to write to bean
				} else {
					bean.write(relationship, object);
				}
			} catch (ClassCastException e){
				source.getResult().addHl7Error(
						new Hl7Error(
							Hl7ErrorCode.INTERNAL_ERROR, 
							"Can't parse relationship name=" + relationship.getName() + ", traversalName=" + traversalName + 
							" [" +  e.getMessage() + "]",
							CollectionUtils.isEmpty(nodes) ? null : (Element) nodes.get(0)
						)
				);
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

	private void changeDatatypeIfNecessary(String type,	Relationship relationship, BareANY object) {
		// if the type parsed was different from the relationship type, preserve that info in the parsed object
		if (object != null && !relationship.getType().equals(type)) {
			StandardDataType newDataType = StandardDataType.getByTypeName(type);
			if (newDataType != null) {
				object.setDataType(newDataType);
			}
		}
	}

	private String determineType(List<Node> nodes, Relationship relationship, Hl7Source source, final Hl7Errors errors) {
		String type = relationship.getType();
		if (nodes.size() >= 1) {
			String newType = ((Element) nodes.get(0)).getAttributeNS(XmlSchemas.SCHEMA_INSTANCE, "type");
			type = this.polymorphismHandler.determineActualDataTypeFromXsiType(type, newType, source.isCda(), !source.isR2(), createErrorLogger((Element) nodes.get(0), errors));
		}
		return type;
	}

	private ErrorLogger createErrorLogger(final Element element, final Hl7Errors errors) {
		return new ErrorLogger() {
			public void logError(Hl7ErrorCode errorCode, Hl7ErrorLevel errorLevel, String errorMessage) {
				errors.addHl7Error(new Hl7Error(errorCode, errorLevel, errorMessage, (Node) element));
			}
		};
	}

	private void validateNonstructuralFixedValue(Relationship relationship,	BareANY value, Hl7Source source, List<Node> nodes) {
		if (relationship.hasFixedValue()) {
			boolean valueProvided = (value != null && value.getBareValue() != null);
			boolean valid = valueProvided || (!ConformanceLevelUtil.isMandatory(relationship) && !ConformanceLevelUtil.isPopulated(relationship));
			// optional and required fixed values do not have to provide a value, but if they do they must conform to specified value
			if (valueProvided) {
				if ("BL".equals(relationship.getType()) && value instanceof BL) {
					String valueAsString = ((BL) value).getValue().toString();
					valid = relationship.getFixedValue().equalsIgnoreCase(valueAsString);
				} else if ("ST".equals(relationship.getType()) && value instanceof ST) {
					String valueAsString = ((ST) value).getValue().toString();
					valid = relationship.getFixedValue().equalsIgnoreCase(valueAsString);
				} else if ("INT.POS".equals(relationship.getType()) && value instanceof INT) {
					String valueAsString = ((INT) value).getValue().toString();
					valid = relationship.getFixedValue().equalsIgnoreCase(valueAsString);
				} else if (relationship.isCodedType()) {
					if (source.isR2()) {
						if (value instanceof ANY) {
							Object value2 = ((ANY<?>) value).getValue();
							@SuppressWarnings("unchecked")
							Code code = value2 == null ? null : ((CodedTypeR2<Code>) value2).getCode();
							valid = (code != null && code.getCodeValue() != null && StringUtils.equals(relationship.getFixedValue(), code.getCodeValue()));
						}
					} else {
						if (value instanceof CD) {
							Code code = ((CD) value).getValue();
							valid = (code.getCodeValue() != null && StringUtils.equals(relationship.getFixedValue(), code.getCodeValue()));
						}
					}
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
    			relationship != null ? relationship.getConformance() : ConformanceLevel.OPTIONAL, 
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
    	    		validateNamespace(attributeNode, attributeRelationship, source);
    				if (attributeRelationship.hasFixedValue()) {
    					validateFixedValue(source, currentElement, (Attr) attributeNode, attributeRelationship);
    				}
    				wrapper.writeNodeAttribute(attributeRelationship, attributeNode.getNodeValue(), source.getVersion(), source.isR2());
    			}
    			validateMandatoryAttributesExist(source, currentElement);	
    		}
    	}		
        
	}

	private void validateMandatoryAttributesExist(Hl7Source source,
			Element element) {
		for (Relationship relationship : getMessagePart(source).getRelationships()) {
			if (relationship.isStructural() && ConformanceLevelUtil.isMandatory(relationship) 
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
