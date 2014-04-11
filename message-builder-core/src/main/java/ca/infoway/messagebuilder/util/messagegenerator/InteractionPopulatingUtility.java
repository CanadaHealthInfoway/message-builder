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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
package ca.infoway.messagebuilder.util.messagegenerator;

import static ca.infoway.messagebuilder.util.messagegenerator.InteractionPopulatingUtility.ConformanceOption.ALL;
import static ca.infoway.messagebuilder.util.messagegenerator.InteractionPopulatingUtility.ConformanceOption.MANDATORY_INCLUDING_PAYLOAD;
import static ca.infoway.messagebuilder.util.messagegenerator.InteractionPopulatingUtility.MultipleCardinalityOption.MAXIMUM_WITH_LIMIT_10;
import static ca.infoway.messagebuilder.util.messagegenerator.InteractionPopulatingUtility.MultipleCardinalityOption.MAXIMUM_WITH_LIMIT_25;
import static ca.infoway.messagebuilder.util.messagegenerator.InteractionPopulatingUtility.MultipleCardinalityOption.MINIMUM_WITH_AT_LEAST_1;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.PredicateUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ca.infoway.messagebuilder.NamedAndTyped;
import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.datatype.ANYMetaData;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.j5goodies.BeanProperty;
import ca.infoway.messagebuilder.j5goodies.ClassFinder;
import ca.infoway.messagebuilder.j5goodies.ClassPredicate;
import ca.infoway.messagebuilder.j5goodies.Predicates;
import ca.infoway.messagebuilder.marshalling.Instantiator;
import ca.infoway.messagebuilder.marshalling.Mapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.platform.ClassUtil;
import ca.infoway.messagebuilder.platform.GenericClassUtil;
import ca.infoway.messagebuilder.xml.Argument;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.ChoiceSupport;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.service.MessageDefinitionService;
import ca.infoway.messagebuilder.xml.service.MessageDefinitionServiceFactory;

/**
 * @sharpen.ignore sample message generator is for MB Java only
 */
public class InteractionPopulatingUtility  {
	
	private final Log log = LogFactory.getLog(InteractionPopulatingUtility.class);

	public enum ConformanceOption {
		MANDATORY_ONLY, MANDATORY_INCLUDING_PAYLOAD, ALL
	}
	
	public enum MultipleCardinalityOption {
		MINIMUM_WITH_AT_LEAST_1, MAXIMUM_WITH_LIMIT_5, MAXIMUM_WITH_LIMIT_10, MAXIMUM_WITH_LIMIT_25
	}
	
	public enum ChoiceOption {
		ALWAYS_FIRST, ALWAYS_SECOND, ALWAYS_THIRD, ALWAYS_LAST, RANDOM
	}

	private class BeanPopulatingContext {
		private final InteractionBean interactionBean;
		private final Interaction interaction;
		private final VersionNumber version;
		private final ConformanceOption conformanceOption;
		private final MultipleCardinalityOption cardinalityOption;
		private final ChoiceOption choiceOption;
		private final Deque<String> messagePartStack;
		
		public BeanPopulatingContext(InteractionBean interactionBean, Interaction interaction, VersionNumber version, ConformanceOption conformanceOption, MultipleCardinalityOption cardinalityOption, ChoiceOption choiceOption) {
			this.interactionBean = interactionBean;
			this.interaction = interaction;
			this.version = version;
			this.conformanceOption = conformanceOption;
			this.cardinalityOption = cardinalityOption;
			this.choiceOption = choiceOption;
			this.messagePartStack = new ArrayDeque<String>();
		}
		
		public InteractionBean getInteractionBean() {return interactionBean;}
		public Interaction getInteraction() {return interaction;}
		public VersionNumber getVersion() {return version;}
		public ConformanceOption getConformanceOption() {return conformanceOption;}
		public MultipleCardinalityOption getCardinalityOption() {return cardinalityOption;}
		public ChoiceOption getChoiceOption() {return choiceOption;}
		public Deque<String> getMessagePartStack() {return messagePartStack;}
	}
	
	// limit recursive object creation - increase at your own risk!
	private static final int MAX_SELF_REFERENCES = 2;
	
	private MessageDefinitionService service;
	private Instantiator instantiator;
	private ClassFinder classFinder;
	private DataTypeValueStore userDataTypeStore;
	private DataTypeValueStore defaultDataTypeStore;
	private Random random;
	
	public InteractionPopulatingUtility() {
		this(null);
	}

	public InteractionPopulatingUtility(DataTypeValueStore dataStore) {
		this.service = new MessageDefinitionServiceFactory().create();
		this.instantiator = Instantiator.getInstance();
		this.classFinder = new ClassFinder();
		this.userDataTypeStore = dataStore;
		this.defaultDataTypeStore = new DefaultDataTypeValueStore();
		this.random = new Random();
	}

	/**
	 * Create and populate an interaction using standard option defaults.
	 * 
	 * @param interactionId
	 * @param version
	 * @return
	 */
	public InteractionBean createAndPopulateInteraction(String interactionId, VersionNumber version) {
		return createAndPopulateInteraction(interactionId, version, ConformanceOption.ALL, MultipleCardinalityOption.MAXIMUM_WITH_LIMIT_5, ChoiceOption.ALWAYS_FIRST);
	}

	/**
	 * 
	 * Create and populate an interaction supplying settings for all options.
	 * 
	 * @param interactionId
	 * @param version
	 * @param conformanceOption
	 * @param cardinalityOption
	 * @param choiceOption
	 * @return
	 */
	public InteractionBean createAndPopulateInteraction(String interactionId, VersionNumber version, ConformanceOption conformanceOption, MultipleCardinalityOption cardinalityOption, ChoiceOption choiceOption) {
		
		Interaction interaction = this.service.getInteraction(version, interactionId);
		InteractionBean interactionBean = (InteractionBean) this.instantiator.instantiateMessagePartBean(version, interactionId, interaction);

		// create a context containing all the static information for this run
		BeanPopulatingContext context = new BeanPopulatingContext(interactionBean, interaction, version, conformanceOption, cardinalityOption, choiceOption);		
		
		Map<String, BeanProperty> properties = BeanProperty.getProperties(context.getInteractionBean());
		MessagePart superType = this.service.getMessagePart(context.getVersion(), context.getInteraction().getSuperTypeName());
		
		populateProperties(properties, context, superType);
		
		return interactionBean;
	}

	/**
	 * Iterate over a collection of properties, populating each one in turn.
	 * 
	 * @param properties
	 * @param context
	 * @param messageContext
	 */
	private void populateProperties(Map<String, BeanProperty> properties, BeanPopulatingContext context, MessagePart messageContext) {
		// store current message part in a stack to detect infinite loops
		context.getMessagePartStack().push(messageContext.getName());
		this.log.debug("Stack is now: " + context.getMessagePartStack());
		for (BeanProperty beanProperty : properties.values()) {
			try {
				populatePropertyAndSubProperties(beanProperty, context, messageContext);
			} catch (Exception e) {
				this.log.error("Exception encountered trying to populate a property: " + messageContext.getName() + "." + beanProperty.getName(), e);
			}
		}
		context.getMessagePartStack().pop();
	}

	private boolean isSelfReferencingLoop(BeanPopulatingContext context, MessagePart messageContext) {
		// check to see if we are recursing into a message part we are already in, i.e. a reference loop
		Predicate predicate = PredicateUtils.equalPredicate(messageContext.getName());
		if (CollectionUtils.countMatches(context.getMessagePartStack(), predicate) >= MAX_SELF_REFERENCES) {;
			// there is almost certainly a self-referential loop going on here; it has been allowed to happen a reasonable amount of times (twice, currently), but cut it off now
			this.log.debug("Detected a self-referential loop: " + messageContext.getName());
			return true;
		}
		return false;
	}

	/**
	 * Populate the property. If it is an association, populate its properties as well. 
	 * 
	 * @param beanProperty
	 * @param context
	 * @param messageContext
	 */
	private void populatePropertyAndSubProperties(BeanProperty beanProperty, BeanPopulatingContext context, MessagePart messageContext) {
		// - take a/b/c and get type/relationship at each step
		// - "nextType" context should be message part "c" for mapping "a/b/c", though cardinality may come from one of the other parts of the mapping
		
		// pull out the appropriate relationship mapping for the given property
		String mapping = determineMappingOfInterest(Mapping.from(beanProperty), messageContext, context.getVersion());
		if (mapping == null) {
			// this wasn't a MessageBuilder-annotated property, or the mapping(s) did not apply to our message part context (likely due to being a merged bean)
			return;
		}
		
		// the last relationship of the mapping is the one that directly relates to the bean property we want to populate
		Relationship relationship = getLastRelationshipOfMapping(mapping, messageContext, context.getVersion());
		if (!isConformanceAcceptable(relationship, context.getConformanceOption())) {
			// the conformances of the relationship chain for this mapping were not applicable for the user-supplied conformance option; skip population step
			return;
		}
		
		int numberOfObjectsToCreate = getNumberOfObjectsToCreate(mapping, messageContext, context.getVersion(), context.getCardinalityOption());
		
		if (relationship.isAssociation()) {
			populateAssociation(beanProperty, relationship, numberOfObjectsToCreate, context);
		} else {
			populateAttribute(beanProperty, relationship, numberOfObjectsToCreate);
		}
	}

	/**
	 * Populate an association, and recursively populate its sub-properties.
	 * 
	 * Associations can be tricky. They can be a collection, a template, a choice (and a mixture of the three), or just a standard association.
	 * 
	 * @param beanProperty
	 * @param relationship
	 * @param numberOfObjectsToCreate
	 * @param context
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void populateAssociation(BeanProperty beanProperty, Relationship relationship, int numberOfObjectsToCreate, BeanPopulatingContext context) {
		Class<?> typeToInstantiate = beanProperty.getPropertyType();
		String nextType = relationship.getType();
		ChoiceSupport asChoice = relationship;
		
		if (beanProperty.isCollection()) {
			// determine the collection contents type
			typeToInstantiate = GenericClassUtil.getCollectionContentsType(beanProperty);
		}
		
		// if template, find matching Argument and argument property type
		if (relationship.isTemplateRelationship()) {
			// need to find the Argument for the template, and then find the interaction's parameterized type that matches
			Argument arg = findArgumentForRelationship(relationship, context.getInteraction());
			typeToInstantiate = determineTemplateType(arg, context.getInteractionBean(), context.getInteraction());
			asChoice = arg; 
			nextType = arg.getName();
		}
		
		if (asChoice.isChoice()) {
			// choices can be nested; only "bottom-most" choices in an actual chain are instantiated
			this.log.debug("determining choice option for: " + relationship.getParentType() + "." + relationship.getName());
			String choiceRelationshipType = determineChoiceRelationship(asChoice.getChoices(), context.getChoiceOption()).getType();
			typeToInstantiate = determineChoiceOptionPropertyType(choiceRelationshipType, typeToInstantiate, context.getInteractionBean());
			nextType = choiceRelationshipType;
		}

		// since this is an association, we want to populate the properties of its type as well
		MessagePart newMessageContext = service.getMessagePart(context.getVersion(), nextType);
		
		if (!isSelfReferencingLoop(context, newMessageContext)) {
			if (beanProperty.isCollection()) {
				for (int i = 0; i < numberOfObjectsToCreate; i++) {
					Object newInstance = createInstanceForAssociation(typeToInstantiate);
					((Collection) beanProperty.get()).add(newInstance);
					Map<String, BeanProperty> properties = BeanProperty.getProperties(newInstance);
					populateProperties(properties, context, newMessageContext); 
				}
			} else {
				Object newInstance = createInstanceForAssociation(typeToInstantiate);
				beanProperty.set(newInstance);
				Map<String, BeanProperty> properties = BeanProperty.getProperties(newInstance);
				populateProperties(properties, context, newMessageContext); 
			}
		}
	}
	
	/**
	 * Populate an attribute, possibly in a collection. Obtain sample values from a data store.
	 * 
	 * If the attribute is an abstract data type we also need to ask the data store for the data type of the returned value.
	 * 
	 * In some cases we also want to supply some data type metadata, but this is hack-y and is kept to a minimum.
	 * 
	 * @param beanProperty
	 * @param relationship
	 * @param numberOfObjectsToCreate
	 */
	private void populateAttribute(BeanProperty beanProperty, Relationship relationship, int numberOfObjectsToCreate) {
		if (beanProperty.isCollection()) {
			Class<?> clazz = GenericClassUtil.getCollectionContentsType(beanProperty);
			for (int i = 0; i < numberOfObjectsToCreate; i++) {
				createAndSetValueForAttributeCollection(beanProperty, relationship, clazz);
			}
		} else {
			createAndSetValueForAttribute(beanProperty, relationship);
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void createAndSetValueForAttributeCollection(BeanProperty beanProperty, Relationship relationship, Class<?> clazz) {
		Object value = getValueForAttribute(relationship, clazz);
		if (value != null) {
			((Collection) beanProperty.get()).add(value);
	
			// if the attribute data type is abstract, we need to set the applicable specialization type in the collection of metadata
			StandardDataType typeForAbstract = getTypeForAbstract(relationship);
			if (typeForAbstract != null) {
				MessagePartBean messageBean = (MessagePartBean) beanProperty.getBean();
				messageBean.setSpecializationTypeInList(beanProperty.getName(), ((Collection<?>) beanProperty.get()).size() - 1, typeForAbstract);
			}
		} else {
			this.log.error("No value specified for type " + relationship.getType() + " on " + relationship.getParentType() + "." + relationship.getName());
		}
	}
	
	private void createAndSetValueForAttribute(BeanProperty beanProperty, Relationship relationship) {
		Object value = getValueForAttribute(relationship, beanProperty.getPropertyType());
		if (value != null) {
			beanProperty.set(value);
			
			// if the attribute data type is abstract, we need to set the specialization type
			MessagePartBean messageBean = (MessagePartBean) beanProperty.getBean();
			StandardDataType typeForAbstract = getTypeForAbstract(relationship);
			if (typeForAbstract != null) {
				messageBean.setSpecializationType(beanProperty.getName(), typeForAbstract);
			}
			
			handleMetaData(beanProperty, relationship, messageBean);
		} else {
			this.log.error("No value specified for type " + relationship.getType() + " on " + relationship.getParentType() + "." + relationship.getName());
		}
	}

	/**
	 * A hack of a solution to handle some datatype metadata in order to avoid MB validation errors. Only ST.LANG for now; hopefully no need to expand this.
	 * 
	 * @param beanProperty
	 * @param relationship
	 * @param messageBean
	 */
	private void handleMetaData(BeanProperty beanProperty, Relationship relationship, MessagePartBean messageBean) {
		if (relationship.getType().equals(StandardDataType.ST_LANG.getType())) {
			((ANYMetaData) messageBean.getField(beanProperty.getName())).setLanguage("en-CA");
		}
	}

	/**
	 * Compare the conformance of the supplied relationship with the chosen conformance option to determine if the relationship should be populated.
	 * 
	 * MANDATORY - always allow
	 * POPULATED/REQUIRED/OPTIONAL - only if ALL (or possibly if template)
	 * IGNORED/NOT_ALLOWED - never allow
	 * 
	 * @param relationship
	 * @param context
	 * @return
	 */
	private boolean isConformanceAcceptable(Relationship relationship, ConformanceOption conformanceOption) {
		boolean acceptable = relationship.isMandatory();
		if (relationship.isOptional() || relationship.isRequired() || relationship.isPopulated()) {
			acceptable = (conformanceOption == ALL);
			if (conformanceOption == MANDATORY_INCLUDING_PAYLOAD && relationship.isTemplateRelationship()) {
				acceptable = true;
			}
		}
		return acceptable;
	}

	/**
	 * 
	 * Iterate all parts of each mapping to get to the "final" relationship.
	 * For now, we return any mapping for which all parts map.
	 * 
	 * @param mappings
	 * @param messageContext
	 * @param version
	 * @return
	 */
	private String determineMappingOfInterest(List<Mapping> mappings, MessagePart messageContext, VersionNumber version) {
		String mappingResult = null;
		for (Mapping mapping : mappings) {
			String mappingName = mapping.getName();
			Relationship relationship = getLastRelationshipOfMapping(mappingName, messageContext, version);
			if (relationship != null) {
				// if has part type mappings, check if there is a relationship type match; if yes, we have a match (error if already matched)
				// else if no part type mappings we have a match (error if already matched)
				if (mapping.hasPartTypeMappings()) {
					for (NamedAndTyped namedAndTyped : mapping.getAllTypes()) {
						if (relationship.getType().equals(namedAndTyped.getType())) {
							if (mappingResult == null) {
								mappingResult = mappingName;
								break;
							} else {
								this.log.error("ERROR - found at least two part type mappings that worked: " + messageContext.getName() + " - " + mappingName);
							}
						}
					}
				} else {
					if (mappingResult == null) {
						mappingResult = mappingName;
					} else {
						this.log.error("ERROR - found at least two mappings that worked (b): " + messageContext.getName() + " - " + mappingName);
					}
				}
			}
		}
		
		return mappingResult;
	}

	/**
	 * Given a (possibly compound) mapping and the message part the mapping is from, determine the relationship corresponding to the last part of the mapping. 
	 * 
	 * @param mapping
	 * @param messageContext
	 * @param version
	 * @return
	 */
	private Relationship getLastRelationshipOfMapping(String mapping, MessagePart messageContext, VersionNumber version) {
		// due to merging, may not find last relationship (this is an expected state); on a merged type, not all properties will apply for every context
		Relationship lastRelationship = null;
		for (String relationshipName : mapping.split("/")) {
			// generally, this is ok if not found (which will set relationship back to null, which is what we want)
			lastRelationship = (messageContext == null ? null : messageContext.getRelationship(relationshipName));
			if (lastRelationship == null) {
				// this mapping didn't lead to a relationship for the given context (likely due to being a merged message part)
				// no need to continue down the mapping
				break;
			}
			if (lastRelationship.isAssociation()) {
				// alter the message context for the next mapping segment being checked
				messageContext = service.getMessagePart(version, lastRelationship.getType());
			} else {
				// this shouldn't necessary, as if this isn't an association we should be at the last mapping; this ensures a NPE if not
				messageContext = null;
			}
		}
		
		return lastRelationship;
	}

	/**
	 * Cardinality can change at each step of a mapping, but there will be at most one relationship with multiple cardinality. Need to locate
	 * the "widest" cardinality in the chain in order to determine (along with the user-suppled cardinality option) how many objects to create.
	 * 
	 * @param mapping
	 * @param messageContext
	 * @param version
	 * @param cardinalityOption
	 * @return
	 */
	private int getNumberOfObjectsToCreate(String mapping, MessagePart messageContext, VersionNumber version, MultipleCardinalityOption cardinalityOption) {
		Cardinality cardinalityOfInterest = null;
		String[] relationshipMappings = mapping.split("/");
		for (String relationshipMapping : relationshipMappings) {
			// the mapping was validated at an earlier point; should always find a relationship for each part of the mapping now 
			Relationship relationship = messageContext.getRelationship(relationshipMapping);
			if (cardinalityOfInterest == null || cardinalityOfInterest.getMax() < relationship.getCardinality().getMax()) {
				// this is our first cardinality, or it is "bigger" than any we've seen before it
				cardinalityOfInterest = relationship.getCardinality();
			}
			if (relationship.isAssociation()) {
				messageContext = service.getMessagePart(version, relationship.getType());
			} else {
				// this shouldn't necessary, as if this isn't an association we should be at the last mapping; this ensures a NPE if not
				messageContext = null;
			}
		}

		return determineCardinalityLimit(cardinalityOfInterest, cardinalityOption);
	}

	/**
	 * Takes the user-supplied cardinality option and assess the actual cardinality of a relationship to determine how many objects to create.
	 * 
	 * @param cardinality
	 * @param cardinalityOption
	 * @return
	 */
	private int determineCardinalityLimit(Cardinality cardinality, MultipleCardinalityOption cardinalityOption) {
		// should we watch out for any "rogue" minimum cardinalities??
		if (cardinalityOption == MINIMUM_WITH_AT_LEAST_1) {
			return Math.max(cardinality.getMin(), 1);
		}
		
		int upperLimit = (cardinalityOption == MAXIMUM_WITH_LIMIT_25 ? 25 : (cardinalityOption == MAXIMUM_WITH_LIMIT_10 ? 10 : 5));
		return Math.max(cardinality.getMin(), Math.min(cardinality.getMax(), upperLimit));
	}

	/**
	 * Takes a template relationship and returns the interaction argument that defines it.
	 * 
	 * @param relationship
	 * @param interaction
	 * @return
	 */
	private Argument findArgumentForRelationship(Relationship relationship, Interaction interaction) {
		return interaction.getArgumentByTemplateParameterName(relationship.getTemplateParameterName());
	}

	
	
	// refactor code, handle errors here and above
	
	/**
	 * Given an argument for an interaction, determine the matching class.
	 * 
	 * @param arg
	 * @param interactionBean
	 * @param interaction
	 * @return
	 */
	private Class<?> determineTemplateType(Argument arg, Object interactionBean, Interaction interaction) {
		// pass in args, matched arg, and parameterized types; then iterate in lock step until args match
		ParameterizedType parameterizedType = (ParameterizedType) interactionBean.getClass().getGenericSuperclass();
		// this assumes that there will only ever by one parameterized type for the interaction; might want to change this to be more flexible
		Type type = parameterizedType.getActualTypeArguments()[0];
		String typeName = StringUtils.removeStart(type.toString(), "class ");

		// FIXME complete hack to match up args for now; needs recursive method to be correct
		if (interaction.getArguments().get(0) == arg) {
			if (typeName.contains("<")) {
				typeName = typeName.substring(0, typeName.indexOf("<"));
			}
		} else {
			typeName = typeName.substring(typeName.indexOf("<") + 1);
			if (interaction.getArguments().get(0).getArguments().get(0) == arg) {
				if (typeName.contains(",")) {
					typeName = typeName.substring(0, typeName.indexOf(","));
				} else {
					typeName = typeName.substring(0, typeName.length() - 1);
				}
			} else {
				if (typeName.contains(",")) {
					typeName = typeName.substring(typeName.indexOf(",") + 1, typeName.length() - 1);
				}
			}
		}
		
		try {
			return Class.forName(typeName.trim());
		} catch (ClassNotFoundException e) {
			this.log.error("Unable to determine class for: " + typeName.trim(), e);
		}
		return null;
	}
	

	/**
	 * Given the choice selection option, choose one of the choices in the collection (including nested choice options) 
	 * 
	 * @param choices
	 * @param choiceOption
	 * @return
	 */
	private Relationship determineChoiceRelationship(List<Relationship> choices, ChoiceOption choiceOption) {
		
		int choiceIndex = 0;
		if (choiceOption == ChoiceOption.ALWAYS_LAST) {
			choiceIndex = choices.size() - 1;
		} else if (choiceOption == ChoiceOption.ALWAYS_SECOND) {
			choiceIndex = Math.min(1, choices.size() - 1);
		} else if (choiceOption == ChoiceOption.ALWAYS_THIRD) {
			choiceIndex = Math.min(2, choices.size() - 1);
		} else if (choiceOption == ChoiceOption.RANDOM) {
			choiceIndex = this.random.nextInt(choices.size());
			this.log.debug("choosing random choice index of: " + choiceIndex + " (from 0-" + (choices.size() - 1) + ")");
		}
		
		Relationship choiceRelationship = null;
		if (choiceIndex >= 0 && choices.size() > choiceIndex) {
			choiceRelationship = choices.get(choiceIndex);
			// if choice option is itself a choice we need to recurse into its options
			if (!choiceRelationship.getChoices().isEmpty()) {
				return determineChoiceRelationship(choiceRelationship.getChoices(), choiceOption);
			}
		} else {
			this.log.error("Choice index calculated as " + choiceIndex + " but choices collection of size " + choices.size());
		}
		return choiceRelationship; 
	}

	private Object createInstanceForAssociation(Class<?> typeToInstantiate) {
		// watch for indicator beans, which are associations that have been modified by MB generator to be of type Boolean
		if (typeToInstantiate == Boolean.class) {
			return Boolean.TRUE;
		}
		return ClassUtil.newInstance(typeToInstantiate);
	}


	/**
	 * Given a class representing the overall choice property and the message part id of the desired choice option, this will
	 * obtain the property type class for the choice option.
	 * 
	 * @param choiceOptionRelationshipType
	 * @param choicePropertyType
	 * @param interactionBean
	 * @return
	 */
	private Class<?> determineChoiceOptionPropertyType(String choiceOptionRelationshipType, Class<?> choicePropertyType, Object interactionBean) {
		// find all classes that implement the choice interface
		ClassPredicate instanceofPredicate = Predicates.isInstanceofPredicate(choicePropertyType, false);
		List<Class<?>> choiceImplmentationClasses = classFinder.findClasses(interactionBean.getClass(), instanceofPredicate);
		
		// iterate all implementing classes looking for an Hl7PartTypeMapping that matches the desired choice option's relationship type
		for (Class<?> choiceOptionImplementationClass : choiceImplmentationClasses) {
			if (!choiceOptionImplementationClass.isInterface()) {
				String[] choicePartTypes = choiceOptionImplementationClass.getAnnotation(Hl7PartTypeMapping.class).value();
				for (String choicePartType : choicePartTypes) {
					if (StringUtils.equals(choiceOptionRelationshipType, choicePartType)) {
						return choiceOptionImplementationClass;
					}
				}
			}
		}
		this.log.error("Could not determine the property type for a choice option: " + choiceOptionRelationshipType + " - " + choicePropertyType.getName());
		return null;
	}
	
	/**
	 * Obtains a value from the data store for the given attribute relationship. Null returned if no value found.
	 * 
	 * @param relationship
	 * @param propertyType
	 * @return
	 */
	private Object getValueForAttribute(Relationship relationship, Class<?> propertyType) {
		String dataType = extractDatatype(relationship);
		Object result = (this.userDataTypeStore == null ? null : this.userDataTypeStore.getValueForDatatype(dataType, propertyType));
		return result == null ? this.defaultDataTypeStore.getValueForDatatype(dataType, propertyType) : result;
	}

	/**
	 * For an abstract type, returns the actual type used in the data store. Otherwise, returns null.
	 *  
	 * @param relationship
	 * @return
	 */
	private StandardDataType getTypeForAbstract(Relationship relationship) {
		String dataType = extractDatatype(relationship);
		StandardDataType result = (this.userDataTypeStore == null ? null : this.userDataTypeStore.getDatatypeUsedForAbstract(dataType));
		return result == null ? this.defaultDataTypeStore.getDatatypeUsedForAbstract(dataType) : result;
	}

	/**
	 * Returns a string representing the datatype of the supplied relationship, removing collection wrapper if present.
	 * @param relationship
	 * @return
	 */
	private String extractDatatype(Relationship relationship) {
		String dataType = relationship.getType();
		if (isCollection(dataType)) {
			// remove outer wrapper type (LIST<x>, SET<x>, COLLECTION<x>)
			dataType = dataType.substring(dataType.indexOf("<") + 1, dataType.length() - 1);
		}
		return dataType;
	}
	
	private boolean isCollection(String type) {
		return StandardDataType.isSetOrList(type) || StandardDataType.isCollection(type);
	}

}
