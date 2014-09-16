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
 * Last modified: $LastChangedDate: 2013-01-02 17:05:34 -0500 (Wed, 02 Jan 2013) $
 * Revision:      $LastChangedRevision: 6471 $
 */

package ca.infoway.messagebuilder.generator.template;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.CharUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;

import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.CodedTypeEvaluator;
import ca.infoway.messagebuilder.xml.ConformanceLevel;
import ca.infoway.messagebuilder.xml.DomainSource;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.RimClass;
import ca.infoway.messagebuilder.xml.TypeName;
import ca.infoway.messagebuilder.xml.delta.AddChoiceConstraint;
import ca.infoway.messagebuilder.xml.delta.AddConstraint;
import ca.infoway.messagebuilder.xml.delta.AssociationDelta;
import ca.infoway.messagebuilder.xml.delta.AssociationTypeConstraint;
import ca.infoway.messagebuilder.xml.delta.AttributeDelta;
import ca.infoway.messagebuilder.xml.delta.CardinalityConstraint;
import ca.infoway.messagebuilder.xml.delta.ClassDelta;
import ca.infoway.messagebuilder.xml.delta.CloneConstraint;
import ca.infoway.messagebuilder.xml.delta.ConformanceConstraint;
import ca.infoway.messagebuilder.xml.delta.ConstraintChangeType;
import ca.infoway.messagebuilder.xml.delta.DatatypeConstraint;
import ca.infoway.messagebuilder.xml.delta.Delta;
import ca.infoway.messagebuilder.xml.delta.DeltaChangeType;
import ca.infoway.messagebuilder.xml.delta.FixedConstraint;
import ca.infoway.messagebuilder.xml.delta.RemoveChoiceConstraint;
import ca.infoway.messagebuilder.xml.delta.RemoveConstraint;
import ca.infoway.messagebuilder.xml.delta.SchematronConstraint;
import ca.infoway.messagebuilder.xml.delta.VocabularyBindingConstraint;
import ca.infoway.messagebuilder.xml.template.Template;
import ca.infoway.messagebuilder.xml.template.TemplateSet;


public class CdaTemplateProcessor {
	
	private Map<String, String> valueSetMap = new HashMap<String, String>();
	private Map<String, String> codeSystemMap = new HashMap<String, String>();
	
	private TemplateSet templateSet;
	
	public CdaTemplateProcessor(ValueSetDefinition valueSets) {
		for (ValueSetDefinitionSystem system : valueSets.getSystems()) {
			valueSetMap.put(system.getValueSetOid(), normalizeValueSetName(system.getValueSetName()));
		}
		
		// TODO: externalize these
		codeSystemMap.put("1.2.840.10008.2.16.4", "DCM");
		codeSystemMap.put("2.16.840.1.113883.5.4", "ActCode");
		codeSystemMap.put("2.16.840.1.113883.5.6", "HL7ActClass");
		codeSystemMap.put("2.16.840.1.113883.5.88", "participationFunction");
		codeSystemMap.put("2.16.840.1.113883.5.90", "HL7ParticipationType");
		codeSystemMap.put("2.16.840.1.113883.6.1", "LOINC");
		codeSystemMap.put("2.16.840.1.113883.6.96", "snomedCt");
		codeSystemMap.put("2.16.840.1.113883.6.101", "NUCCProviderTaxonomy");
	}

	private String normalize(String rawName) {
		
		String capitalized = WordUtils.capitalize(rawName);
		
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < capitalized.length(); i++) {
			char ch = capitalized.charAt(i);
			if (CharUtils.isAsciiAlphanumeric(ch)) {
				buf.append(ch);
			}
		}
		
		return buf.toString();
	}
	
	private String normalizeValueSetName(String rawName) {
		StringBuffer buf = new StringBuffer(normalize(rawName));
		
		int valueSetIndex = buf.indexOf("ValueSet");
		if (valueSetIndex > 0) {
			buf.delete(valueSetIndex, valueSetIndex + 8);
		}
		
		return buf.toString();
	}

	public void parseTemplate(TemplateExport templateExport, MessageSet baseModel, TemplateSet templateSet) {
		
		// Warning: by making the class stateful, we have made it not thread safe
		this.templateSet = templateSet;
		
		for (CdaTemplate cdaTemplate : templateExport.getTemplates()) {
			Template template = createTemplate(cdaTemplate);
			
			MessagePart entryPart = findRootMessagePart(template, baseModel);
			
			if (entryPart != null) {
				TypeName typeName = new TypeName(entryPart.getName());
				template.setEntryClassName(template.getPackageName() + "." + typeName.getUnqualifiedName());
			}
			
			this.templateSet.addTemplate(template);
		}
		
		for (CdaTemplate cdaTemplate : templateExport.getTemplates()) {
			Template template = this.templateSet.getByOid(cdaTemplate.getOid());
			MessagePart entryPart = findRootMessagePart(template, baseModel);
			
			if (entryPart != null) {
				TypeName rootName = new TypeName(template.getEntryClassName());
				TemplateNode rootNode = new TemplateNode(rootName.getParent().getName(), rootName.getUnqualifiedName(), entryPart);
				collectNames(cdaTemplate, entryPart, baseModel, rootNode);
				rootNode.disambiguateTree(templateSet);
				
				createMessageParts(template, entryPart, rootNode, cdaTemplate.getConstraints(), baseModel);
				handleChoices(template, entryPart, rootNode, baseModel);
				handleContextFreeTemplateReferences(template, cdaTemplate, baseModel);
				if (!cdaTemplate.isOpen()) {
					removeUnreferencedRelationships(cdaTemplate, template, entryPart, rootNode.getQualifiedName());
					removeUnreferencedRelationships(template, entryPart, rootNode, baseModel);
				}
				
			}
		}
		
		for (CdaTemplate cdaTemplate : templateExport.getTemplates()) {
			if (cdaTemplate.getImpliedTemplateOid() != null) {
				Template template = this.templateSet.getByOid(cdaTemplate.getOid());
				Template parentTemplate = this.templateSet.getByOid(cdaTemplate.getImpliedTemplateOid());
				
				for (Delta parentDelta : parentTemplate.getDeltas()) {
					String targetClassName = convertName(parentDelta.getClassName(), template.getPackageName());
					Delta delta = template.getDelta(parentDelta.getDeltaChangeType(), targetClassName, parentDelta.getRelationshipName());
					if (delta == null) {
						template.cloneDelta(parentDelta);
					} else {
						
					}
				}
			}
			
		}		
	}

	private void createMessageParts(Template template,
			MessagePart messagePart, TemplateNode node, List<CdaConstraint> cdaConstraints, MessageSet baseModel) {
		
		createCloneDelta(template, messagePart, node.getQualifiedName());

		parseAttributes(messagePart, template, node, cdaConstraints);
		
		parseSimpleAssociations(messagePart, template, node, baseModel, cdaConstraints);
		
		for (String relationshipName : node.getChildren().keySet()) {
			List<TemplateNode> nodeList = node.getChildren().get(relationshipName);
			for (TemplateNode childNode : nodeList) {
				Relationship relationship = messagePart.getRelationship(relationshipName);
				if (relationship.isChoice() && !relationship.getName().equals(relationshipName)) {
					relationship = relationship.findChoiceOption(Relationship.choiceOptionNamePredicate(relationshipName));
				}
				String associationType = relationship.getType();
				MessagePart childPart = baseModel.getMessagePart(associationType);
				createMessageParts(template, childPart, childNode, childNode.getConstraint().getConstraints(), baseModel);
			}
		}
		
		parseDeepContextConstraints(messagePart, template, node, baseModel, cdaConstraints);
		
		for (Delta delta : template.getDeltas()) {
			if (delta.getRelationshipName() != null) {
				Relationship relationship = messagePart.getRelationship(delta.getRelationshipName());
				if (relationship != null) {
					ensureCardinalityConsistency(relationship, delta);
				}
			}
		}

	}
	
	private void handleChoices(Template template, MessagePart messagePart, TemplateNode node, MessageSet baseModel) {
		for (String nodeKey : node.getChildren().keySet()) {
			
			List<TemplateNode> nodeList = node.getChildren().get(nodeKey);
			if (nodeList != null) {
				Relationship relationship = messagePart.getRelationship(nodeKey);
				if (relationship != null) {
					String associationType = relationship.getType();
					MessagePart childPart = baseModel.getMessagePart(associationType);

					if (nodeList.size() > 1) {
						Delta delta = getOrCreateDefinitionDelta(nodeList.get(0).getConstraint(), relationship, node.getQualifiedName(), template);
						TypeName originalPartName = new TypeName(childPart.getName());
						String choiceBlockName = template.getPackageName() + "." + originalPartName.getUnqualifiedName() + "Choice";
						delta.addConstraint(new AssociationTypeConstraint(associationType, choiceBlockName));
						
						Delta choiceBlockDelta = createDelta(choiceBlockName, null, DeltaChangeType.ADD);
						choiceBlockDelta.addConstraint(new AddConstraint(choiceBlockName, childPart.getRimClass(), true));
						
						Cardinality listCardinality = null;
						for (TemplateNode childNode : nodeList) {
							choiceBlockDelta.addConstraint(new AddChoiceConstraint(childNode.getQualifiedName()));

							Cardinality constraintCardinality = Cardinality.create(childNode.getConstraint().getCardinality());
							if (listCardinality == null) {
								listCardinality = constraintCardinality;
							} else {
								listCardinality = Cardinality.add(listCardinality, constraintCardinality, relationship.getCardinality().getMax());
							}
						}
						delta.addConstraint(new CardinalityConstraint(relationship.getCardinality(), listCardinality));
						
						template.addDelta(choiceBlockDelta);
					}
					
					for (TemplateNode childNode : nodeList) {
						parseSimpleChoices(childPart, template, childNode);

						handleChoices(template, childPart, childNode, baseModel);
					}
				}
			}
		}
	}
	
	private void parseAttributes(MessagePart messagePart, Template template, TemplateNode node, List<CdaConstraint> constraints) {
		for (CdaConstraint cdaConstraint : constraints) {
			Relationship relationship = findRelationship(messagePart, cdaConstraint.getContext());
			
			if (relationship != null && relationship.isAttribute()) {
				parseConstraintAsAttribute(cdaConstraint, relationship, node.getQualifiedName(), template);
			}
		}
	}

	private void parseSimpleAssociations(MessagePart messagePart, Template template, TemplateNode node, MessageSet baseModel, List<CdaConstraint> constraints) {
		for (CdaConstraint cdaConstraint : constraints) {
			Relationship relationship = findRelationship(messagePart, cdaConstraint.getContext());
			
			if (relationship != null && relationship.isAssociation() && !relationship.isChoice()) {
				parseConstraintAsAssociation(cdaConstraint, relationship, template, baseModel, node);
			}
		}
	}
	
	private void parseSimpleChoices(MessagePart messagePart, Template template, TemplateNode node) {
		for (CdaConstraint childConstraint : node.getConstraint().getConstraints()) {
			Relationship relationship = findRelationship(messagePart, childConstraint.getContext());
			if (relationship != null && relationship.isAssociation() && relationship.isChoice()) {
				// remove existing choice blocks - we'll be recreating these elsewhere
				createRemoveDelta(relationship, node.getQualifiedName(), template);

				Delta delta = addNewAssociationDelta(childConstraint, new Relationship(), node.getQualifiedName(), template);
				if (childConstraint.getContainedTemplateOid() != null) {
					Template targetTemplate = this.templateSet.getByOid(childConstraint.getContainedTemplateOid());
					delta.addConstraint(new AssociationTypeConstraint(null, targetTemplate.getEntryClassName()));
					template.addTemplateReference(node.getQualifiedName() + "." + childConstraint.getContext(), childConstraint.getContainedTemplateOid(), Cardinality.create(node.getConstraint().getCardinality()));
				} else {
					List<TemplateNode> childNodes = node.getChildren().get(childConstraint.getContext());
					if (childNodes != null && childNodes.size() == 1) {
						TemplateNode childNode = childNodes.get(0);
						delta.addConstraint(new AssociationTypeConstraint(null, childNode.getQualifiedName()));
					}
				}
			}
		}
	}
	
	private void parseDeepContextConstraints(MessagePart messagePart, Template template, TemplateNode node, MessageSet baseModel,
			List<CdaConstraint> cdaConstraints) {
		for (CdaConstraint cdaConstraint : cdaConstraints) {
			String[] context = tokenizeContext(cdaConstraint.getContext());
			MessagePart nextPart = messagePart;
			TemplateNode nextNode = node;
			if (context.length > 1) {
				Relationship relationship = findRelationship(nextPart, context[0]);
				for (int i = 0; i < context.length - 1; i++) {
					if (relationship != null) {
						if (!relationship.isChoice()) {
							nextPart = constrainCardinalityOfAssociation(cdaConstraint, relationship, template, baseModel, nextNode);
						}
						
						if (nextPart != null) {
							List<TemplateNode> nodeList = nextNode.getChildren().get(relationship.getName());
							if (nodeList.size() == 1) {
								nextNode = nodeList.get(0);
								relationship = findRelationship(nextPart, parseContext(context[i + 1]));
							} else {
								// not enough context to resolve ambiguity
								relationship = null;
							}
						} else {
							relationship = null;
						}
					}
				}
				
				if (relationship != null) {
					if (relationship.isAttribute()) {
						parseConstraintAsAttribute(cdaConstraint, relationship, nextNode.getQualifiedName(), template);
					} else if (relationship.isAssociation()) {
						parseConstraintAsAssociation(cdaConstraint, relationship, template, baseModel, nextNode);
					}
				}
			}
		}		
	}

	private void handleContextFreeTemplateReferences(Template template, CdaTemplate cdaTemplate, MessageSet baseModel) {
		List<CdaConstraint> contextFreeConstraints = collectContextFreeConstraints(cdaTemplate);
		if (!contextFreeConstraints.isEmpty()) {
			if (StringUtils.equals(cdaTemplate.getTemplateType(), "document")) {
				constrainSectionChoiceForClinicalDocument(template, contextFreeConstraints);
			} else if (StringUtils.equals(cdaTemplate.getTemplateType(), "section")) {
				constrainSectionChoiceForSection(template, contextFreeConstraints);
			}
		}
	}

	private void constrainSectionChoiceForClinicalDocument(Template template,
			List<CdaConstraint> contextFreeConstraints) {
		String component2ClassName = template.getPackageName() + ".Component2";
		Delta component2Delta = getOrCreatePlainAssociationDelta(template,	component2ClassName, "component2Choice", DeltaChangeType.DEFINITION);
		
		String component2ChoiceClassName = template.getPackageName() + ".Component2Choice";
		component2Delta.addConstraint(new AssociationTypeConstraint("POCD_MT000040.Component2Choice", component2ChoiceClassName));
		
		Delta component2ChoiceCloneDelta = getOrCreatePlainClassDelta(template, component2ChoiceClassName, DeltaChangeType.CLONE);
		component2ChoiceCloneDelta.addConstraint(new CloneConstraint(component2ChoiceClassName, null, "POCD_MT000040.Component2Choice"));

		Delta component2ChoiceDelta = getOrCreatePlainClassDelta(template, component2ChoiceClassName, DeltaChangeType.DEFINITION);
		component2ChoiceDelta.addConstraint(new RemoveChoiceConstraint("POCD_MT000040.StructuredBody"));
		
		String structuredBodyClassName = template.getPackageName() + ".StructuredBody";
		component2ChoiceDelta.addConstraint(new AddChoiceConstraint(structuredBodyClassName));
		
		Delta structuredBodyCloneDelta = getOrCreatePlainClassDelta(template, structuredBodyClassName, DeltaChangeType.CLONE);
		structuredBodyCloneDelta.addConstraint(new CloneConstraint(structuredBodyClassName, null, "POCD_MT000040.StructuredBody"));

		Delta structuredBodyComponentDelta = getOrCreatePlainAssociationDelta(template, structuredBodyClassName, "component", DeltaChangeType.DEFINITION);
		String choiceBlockName = template.getPackageName() + ".Component3Choice";
		structuredBodyComponentDelta.addConstraint(new AssociationTypeConstraint("POCD_MT000040.Component3", choiceBlockName));
		
		Delta choiceBlockDelta = createDelta(choiceBlockName, null, DeltaChangeType.ADD);
		choiceBlockDelta.addConstraint(new AddConstraint(choiceBlockName, RimClass.ACT_RELATIONSHIP, true));
		
		Cardinality listCardinality = null;
		for (CdaConstraint cdaConstraint : contextFreeConstraints) {
			Cardinality constraintCardinality = Cardinality.create(cdaConstraint.getCardinality());
			if (isEncounterParticipantSpecialCase(cdaConstraint)) {
				Template targetTemplate = templateSet.getByOid(cdaConstraint.getContainedTemplateOid());
				String messagePartName = template.getPackageName() + ".EncompassingEncounter";
				Delta delta = getOrCreatePlainAssociationDelta(template, messagePartName, "encounterParticipant", DeltaChangeType.DEFINITION);
				delta.addConstraint(new AssociationTypeConstraint("POCD_MT000040.EncounterParticipant", targetTemplate.getEntryClassName()));
				delta.addConstraint(new CardinalityConstraint(new Cardinality(0, Integer.MAX_VALUE), constraintCardinality));

				template.addTemplateReference(messagePartName + ".encounterParticipant", cdaConstraint.getContainedTemplateOid(), constraintCardinality);
			} else {
				Template targetTemplate = templateSet.getByOid(cdaConstraint.getContainedTemplateOid());
				String choiceOptionName = template.getPackageName() + "." + targetTemplate.getPackageName() + "Component3";
				choiceBlockDelta.addConstraint(new AddChoiceConstraint(choiceOptionName));
	
				Delta choiceOptionDelta = createDelta(choiceOptionName, null, DeltaChangeType.CLONE);
				choiceOptionDelta.addConstraint(new CloneConstraint(choiceOptionName, null, "POCD_MT000040.Component3"));
				template.addDelta(choiceOptionDelta);
				
				Delta sectionDelta = getOrCreatePlainAssociationDelta(template, choiceOptionName, "section", DeltaChangeType.DEFINITION);
				sectionDelta.addConstraint(new AssociationTypeConstraint("POCD_MT000040.Section", targetTemplate.getEntryClassName()));
				
	
				if (constraintCardinality == null) {
					if (StringUtils.equals(cdaConstraint.getConformance(), "SHALL")) {
						constraintCardinality = new Cardinality(1, 1);
					} else {
						constraintCardinality = new Cardinality(0, 1);
					}
				}
				if (listCardinality == null) {
					listCardinality = constraintCardinality;
				} else {
					listCardinality = Cardinality.add(listCardinality, constraintCardinality, Integer.MAX_VALUE);
				}
				
				template.addTemplateReference(choiceOptionName + ".section", cdaConstraint.getContainedTemplateOid(), constraintCardinality);
			}
		}
		if (listCardinality.getMin() < 1) {
			// There must be at least one component, even if all of the individual options are optional
			listCardinality = new Cardinality(1, listCardinality.getMax());
		}
		structuredBodyComponentDelta.addConstraint(new CardinalityConstraint(new Cardinality(1, Integer.MAX_VALUE), listCardinality));
		
		template.addDelta(choiceBlockDelta);
	}

	private boolean isEncounterParticipantSpecialCase(CdaConstraint cdaConstraint) {
		return StringUtils.equals(cdaConstraint.getContainedTemplateOid(), "2.16.840.1.113883.10.20.6.2.2");
	}

	private void constrainSectionChoiceForSection(Template template,
			List<CdaConstraint> contextFreeConstraints) {
		String entryClassName = template.getPackageName() + ".Entry";
		Delta entryChoiceRemovalDelta = getOrCreatePlainAssociationDelta(template, entryClassName, "entryChoice", DeltaChangeType.REMOVE);
		entryChoiceRemovalDelta.addConstraint(new RemoveConstraint(entryClassName, "entryChoice"));
		
		for (CdaConstraint cdaConstraint : contextFreeConstraints) {
			Template targetTemplate = templateSet.getByOid(cdaConstraint.getContainedTemplateOid());
			String externalReferenceName = targetTemplate.getEntryClassName();
			String externalReferenceContext = targetTemplate.getContext();
			
			Delta referenceDelta = getOrCreatePlainAssociationDelta(template, entryClassName, externalReferenceContext, DeltaChangeType.ADD);

			referenceDelta.addConstraint(new AssociationTypeConstraint(null, externalReferenceName));
			
			Cardinality constraintCardinality = Cardinality.create(cdaConstraint.getCardinality());
			if (constraintCardinality == null) {
				if (StringUtils.equals(cdaConstraint.getConformance(), "SHALL")) {
					constraintCardinality = new Cardinality(1, 1);
				} else {
					constraintCardinality = new Cardinality(0, 1);
				}
			}
			referenceDelta.addConstraint(new CardinalityConstraint(Cardinality.create("0-1"), constraintCardinality));
			
			if (constraintCardinality.isMandatory()) {
				referenceDelta.addConstraint(new ConformanceConstraint(ConformanceLevel.OPTIONAL, ConformanceLevel.MANDATORY));
			} else {
				referenceDelta.addConstraint(new ConformanceConstraint(ConformanceLevel.OPTIONAL, ConformanceLevel.OPTIONAL));
			}
			
			template.addTemplateReference(entryClassName + "." + externalReferenceContext, cdaConstraint.getContainedTemplateOid(), constraintCardinality);
		}
	}
	
	private Delta getOrCreatePlainClassDelta(Template template, String className, DeltaChangeType deltaChangeType) {
		Delta delta = template.getDelta(deltaChangeType, className, null);
		if (delta == null) {
			delta = new ClassDelta();
			delta.setClassName(className);
			delta.setDeltaChangeType(deltaChangeType);
			template.addDelta(delta);
		}
		return delta;
	}

	private Delta getOrCreatePlainAssociationDelta(Template template, String className, String relationshipName, DeltaChangeType deltaChangeType) {
		Delta delta = template.getDelta(deltaChangeType, className, relationshipName);
		if (delta == null) {
			delta = new AssociationDelta();
			delta.setClassName(className);
			delta.setRelationshipName(relationshipName);
			delta.setDeltaChangeType(deltaChangeType);
			template.addDelta(delta);
		}
		return delta;
	}
	
	private List<CdaConstraint> collectContextFreeConstraints(CdaTemplate cdaTemplate) {
		List<CdaConstraint> result = new ArrayList<CdaConstraint>();
		collectContextFreeConstraints(cdaTemplate.getConstraints(), result);
		return result;
	}

	private void collectContextFreeConstraints(List<CdaConstraint> sourceConstraints, List<CdaConstraint> result) {
		for (CdaConstraint constraint : sourceConstraints) {
			if (constraint.getContext() == null && constraint.getContainedTemplateOid() != null) {
				result.add(constraint);
			} else {
				collectContextFreeConstraints(constraint.getConstraints(), result);
			}
		}
	}

	private void removeUnreferencedRelationships(CdaTemplate cdaTemplate, Template template, MessagePart messagePart, String className) {
		for (Relationship relationship : messagePart.getRelationships()) {
			if (!allRelationshipContexts(cdaTemplate.getConstraints()).contains(relationship.getName())) {
				Delta delta = createDelta(className, relationship, DeltaChangeType.REMOVE);
				delta.addConstraint(new RemoveConstraint(className, relationship.getName()));
				template.addDelta(delta);
			}
		}
	}

	private void removeUnreferencedRelationships(Template template, MessagePart messagePart, TemplateNode node, MessageSet baseModel) {
		for (String relationshipName : node.getChildren().keySet()) {
			List<TemplateNode> nodeList = node.getChildren().get(relationshipName);
			Relationship relationship = messagePart.getRelationship(relationshipName);
			MessagePart childPart = baseModel.getMessagePart(relationship.getType());
			for (TemplateNode childNode : nodeList) {
				removeUnreferencedRelationships(childNode, template, childPart);
				removeUnreferencedRelationships(template, childPart, childNode, baseModel);
			}
		}
	}

	private void removeUnreferencedRelationships(TemplateNode node, Template template, MessagePart messagePart) {
		for (Relationship relationship : messagePart.getRelationships()) {
			if (!allRelationshipContexts(node.getConstraint().getConstraints()).contains(relationship.getName())) {
				Delta delta = createDelta(node.getQualifiedName(), relationship, DeltaChangeType.REMOVE);
				delta.addConstraint(new RemoveConstraint(node.getQualifiedName(), relationship.getName()));
				template.addDelta(delta);
			}
		}
	}
	
	private Set<String> allRelationshipContexts(List<CdaConstraint> constraints) {
		Set<String> includedRelationships = new HashSet<String>();
		
		for (CdaConstraint cdaConstraint : constraints) {
			includedRelationships.add(parseContext(cdaConstraint));
		}
		return includedRelationships;
	}

	private String convertName(String originalName, String newPackageName) {
		int index = originalName.indexOf(".");
		if (index >= 0) {
			return newPackageName + originalName.substring(index);
		} else {
			return newPackageName + "." + originalName;
		}
	}

	private void collectNames(CdaTemplate cdaTemplate, MessagePart messagePart, MessageSet baseModel, TemplateNode rootNode) {
		List<CdaConstraint> constraints = cdaTemplate.getConstraints();
		collectNames(messagePart, baseModel, rootNode, constraints);
	}

	private void collectNames(MessagePart messagePart, MessageSet baseModel, TemplateNode node, List<CdaConstraint> constraints) {
		for (CdaConstraint constraint : constraints) {
			if (constraint.getContext() != null && !constraint.getContext().startsWith("@") && constraint.getContainedTemplateOid() == null) {
				MessagePart nextPart = messagePart;
				TemplateNode nextNode = node;
				String[] context = tokenizeContext(constraint.getContext());
				if (context.length > 0) {
					Relationship relationship = findRelationship(nextPart, context[0]);
					for (int i = 0; i < context.length - 1; i++) {
						if (relationship != null) {
							String name = relationship.getType();
							nextPart = baseModel.getMessagePart(name);
							if (nextPart != null) {
								TypeName typeName = new TypeName(name);
								TemplateNode childNode = nextNode.addChild(relationship.getName(), typeName.getUnqualifiedName(), constraint, nextPart);
								nextNode = childNode;
								relationship = findRelationship(nextPart, context[i + 1]);
							} else {
								relationship = null;
							}
						}
					}
					if (relationship != null) {
						if (relationship.isChoice()) {
							List<Relationship> choices = relationship.getChoices();
							for (Relationship choice : choices) {
								if (choice.getName().equals(constraint.getContext())) {
									relationship = choice;
								}
							}
						}
						if (relationship != null && relationship.isAssociation()) {
							String name = relationship.getType();
							MessagePart childPart = baseModel.getMessagePart(name);
							if (childPart != null) {
								TypeName typeName = new TypeName(name);
								TemplateNode childNode = nextNode.addChild(relationship.getName(), typeName.getUnqualifiedName(), constraint, childPart);
								collectNames(childPart, baseModel, childNode, constraint.getConstraints());
							}
						}
					}
				}
			}
		}
	}

	private void createCloneDelta(Template template, MessagePart entryPart, String cloneName) {
		Delta delta = new ClassDelta();
		delta.setClassName(cloneName);
		delta.setDeltaChangeType(DeltaChangeType.CLONE);
		delta.addConstraint(new CloneConstraint(cloneName, null, entryPart.getName()));
		template.addDelta(delta);
	}

	private MessagePart findRootMessagePart(Template template, MessageSet baseModel) {
		MessagePart entryPart = null;
		
		for (MessagePart part : baseModel.getAllMessageParts()) {
			TypeName typeName = new TypeName(part.getName());
			if (typeName.getUnqualifiedName().equals(template.getContextType())) {
				entryPart = part;
			}
		}
		
		return entryPart;
	}

	private Delta createDelta(String className, Relationship relationship, DeltaChangeType changeType) {
		Delta delta;
		
		if (relationship == null) {
			delta = new ClassDelta();
		} else if (relationship.isAttribute()) {
			delta = new AttributeDelta();
		} else {
			delta = new AssociationDelta();
		}
		
		delta.setClassName(className);
		if (relationship != null) {
			delta.setRelationshipName(relationship.getName());
		}
		delta.setDeltaChangeType(changeType);
		
		return delta;
	}

	private String[] tokenizeContext(String context) {
		if (context == null) {
			return new String[0];
		}
		return StringUtils.split(context, '/');
	}

	private void parseConstraintAsAttribute(CdaConstraint cdaConstraint, Relationship relationship, String className, Template template) {
		Delta delta = getOrCreateDefinitionDelta(cdaConstraint, relationship, className, template);
		
		Cardinality constrainedCardinality = Cardinality.create(cdaConstraint.getCardinality());
		if (relationship.getConformance().equals(ConformanceLevel.OPTIONAL) && constrainedCardinality.isMandatory()) {
			delta.addConstraint(new ConformanceConstraint(relationship.getConformance(), ConformanceLevel.MANDATORY));
		}
		if (constrainedCardinality.getMax() == 0) {
			delta.addConstraint(new ConformanceConstraint(relationship.getConformance(), ConformanceLevel.NOT_ALLOWED));
		}
		if (cdaConstraint.getSingleValueCode() != null) {
			delta.addConstraint(new FixedConstraint(relationship.getFixedValue(), cdaConstraint.getSingleValueCode().getCode()));
		}
		if (cdaConstraint.getDataType() != null) {
			String dataTypeName = cdaConstraint.getDataType();
			StandardDataType standardType = StandardDataType.valueOf(StandardDataType.class, cdaConstraint.getDataType());
			if (!StandardDataType.isSetOrList(dataTypeName) && standardType != null) {
				dataTypeName = standardType.getType();
			}
			if (constrainedCardinality.isMultiple() && !StandardDataType.isSetOrList(dataTypeName)) {
				dataTypeName = "LIST<" + dataTypeName + ">";
			}
			if (!dataTypeName.equals(relationship.getType())) {
				delta.addConstraint(new DatatypeConstraint(relationship.getType(), dataTypeName));
			}
		}
		if (CodedTypeEvaluator.isCodedType(relationship.getType())) {
			if (cdaConstraint.getValueSet() != null) {
				delta.addConstraint(new VocabularyBindingConstraint(relationship.getDomainSource(), DomainSource.VALUE_SET, relationship.getDomainType(), lookupValueSet(cdaConstraint.getValueSet().getOid())));
			} else if (cdaConstraint.getCodeSystem() != null && cdaConstraint.getSingleValueCode() == null) {
				delta.addConstraint(new VocabularyBindingConstraint(relationship.getDomainSource(), DomainSource.CODE_SYSTEM, relationship.getDomainType(), lookupCodeSystem(cdaConstraint.getCodeSystem().getOid())));
			}
		}
		
		for (CdaConstraint subconstraint : cdaConstraint.getConstraints()) {
			addSchematronConstraint(delta, subconstraint);

			if (CodedTypeEvaluator.isCodedType(relationship.getType()) || CodedTypeEvaluator.isCodedType(cdaConstraint.getDataType())) {
				// assume the nested constraints actually represent a fixed value and/or code system binding
				if ("@code".equals(subconstraint.getContext())) {
					if (subconstraint.getSingleValueCode() != null) {
						delta.addConstraint(new FixedConstraint(relationship.getFixedValue(), subconstraint.getSingleValueCode().getCode()));
					} else if (subconstraint.getCodeSystem() != null) {
						delta.addConstraint(new VocabularyBindingConstraint(relationship.getDomainSource(), DomainSource.CODE_SYSTEM, relationship.getDomainType(), lookupCodeSystem(subconstraint.getCodeSystem().getOid())));
					} else if (subconstraint.getValueSet() != null) {
						delta.addConstraint(new VocabularyBindingConstraint(relationship.getDomainSource(), DomainSource.VALUE_SET, relationship.getDomainType(), lookupValueSet(subconstraint.getValueSet().getOid())));
					}
				} else if ("@codeSystem".equals(subconstraint.getContext()) && subconstraint.getCodeSystem() != null) {
					delta.addConstraint(new VocabularyBindingConstraint(relationship.getDomainSource(), DomainSource.CODE_SYSTEM, relationship.getDomainType(), lookupCodeSystem(subconstraint.getCodeSystem().getOid())));
				} else {
					// we didn't find the pattern we wanted, so go ahead and iterate
					parseNestedAttributeConstraint(template, subconstraint, className, relationship.getName());
				}
			} else {
				parseNestedAttributeConstraint(template, subconstraint, className, relationship.getName());
			}
		}
	}

	private void ensureCardinalityConsistency(Relationship relationship,
			Delta delta) {
		CardinalityConstraint cardinalityConstraint = (CardinalityConstraint) delta.getConstraint(ConstraintChangeType.CHANGE_CARDINALITY);
		if (cardinalityConstraint != null && cardinalityConstraint.getOriginalCardinality().isMultiple() && cardinalityConstraint.getNewCardinality().isSingle()) {
			DatatypeConstraint datatypeConstraint = (DatatypeConstraint) delta.getConstraint(ConstraintChangeType.CHANGE_DATATYPE);
			String outerDatatype;
			if (datatypeConstraint == null) {
				outerDatatype = relationship.getType();
			} else {
				outerDatatype = datatypeConstraint.getNewValue();
			}
			
			if (StandardDataType.isCollection(outerDatatype) || StandardDataType.isSetOrList(outerDatatype)) {
				StandardDataType templateArgument = StandardDataType.getTemplateArgument(outerDatatype);
				if (datatypeConstraint == null) {
					delta.addConstraint(new DatatypeConstraint(relationship.getType(), templateArgument.getType()));
				} else {
					datatypeConstraint.setNewValue(templateArgument.getType());
				}
			}
		}
	}
	
	private Delta getOrCreateDefinitionDelta(CdaConstraint cdaConstraint, Relationship relationship, String className, Template template) {
		String rootName = relationship.getName();
		
		Cardinality constrainedCardinality = Cardinality.create(cdaConstraint.getCardinality());
		if (relationship.getCardinality() != null && relationship.getCardinality().getMin() > constrainedCardinality.getMin()) {
			constrainedCardinality = new Cardinality(relationship.getCardinality().getMin(), constrainedCardinality.getMax());
		}

		Delta delta = template.getDelta(DeltaChangeType.DEFINITION, className, rootName);
		if (delta == null) {
			delta = createDelta(className, relationship, DeltaChangeType.DEFINITION);
	
			delta.addConstraint(new CardinalityConstraint(relationship.getCardinality(), constrainedCardinality));

			if (relationship.getConformance().equals(ConformanceLevel.OPTIONAL) && constrainedCardinality.isMandatory()) {
				delta.addConstraint(new ConformanceConstraint(relationship.getConformance(), ConformanceLevel.MANDATORY));
			} 
			if (constrainedCardinality.getMax() == 0) {
				delta.addConstraint(new ConformanceConstraint(relationship.getConformance(), ConformanceLevel.NOT_ALLOWED));
			}
			
			template.addDelta(delta);
		} else if (relationship.isAttribute()){
			CardinalityConstraint cardinalityConstraint = (CardinalityConstraint) delta.getConstraint(ConstraintChangeType.CHANGE_CARDINALITY);
			constrainedCardinality = Cardinality.add(constrainedCardinality, cardinalityConstraint.getNewCardinality(), relationship.getCardinality().getMax());
			cardinalityConstraint.setNewCardinality(constrainedCardinality);
		}

		return delta;
	}

	private Delta addNewAssociationDelta(CdaConstraint cdaConstraint, Relationship relationship, String className, Template template) {

		Delta delta = new AssociationDelta();
	
		delta.setClassName(className);
		delta.setRelationshipName(cdaConstraint.getContext());
		delta.setDeltaChangeType(DeltaChangeType.ADD);

		Cardinality constrainedCardinality = Cardinality.create(cdaConstraint.getCardinality());
		delta.addConstraint(new CardinalityConstraint(relationship.getCardinality(), constrainedCardinality));
		
		if (constrainedCardinality.isMandatory()) {
			delta.addConstraint(new ConformanceConstraint(relationship.getConformance(), ConformanceLevel.MANDATORY));
		} else if (constrainedCardinality.getMax() == 0) {
			delta.addConstraint(new ConformanceConstraint(relationship.getConformance(), ConformanceLevel.NOT_ALLOWED));
		} else {
			delta.addConstraint(new ConformanceConstraint(relationship.getConformance(), ConformanceLevel.OPTIONAL));
		}
		
		template.addDelta(delta);
		
		return delta;
	}
	
	private void createRemoveDelta(Relationship relationship, String className, Template template) {
		Delta delta = template.getDelta(DeltaChangeType.REMOVE, className, relationship.getName());
		if (delta == null) {
			delta = createDelta(className, relationship, DeltaChangeType.REMOVE);
			
			delta.addConstraint(new RemoveConstraint(className, relationship.getName()));
			
			template.addDelta(delta);
		}
	}
	
	private void parseConstraintAsAssociation(CdaConstraint cdaConstraint,
			Relationship relationship, Template template, MessageSet baseModel, TemplateNode templateNode) {

		Delta delta = getOrCreateDefinitionDelta(cdaConstraint, relationship, templateNode.getQualifiedName(), template);
		
		if (cdaConstraint.getContainedTemplateOid() != null) {
			Template targetTemplate = this.templateSet.getByOid(cdaConstraint.getContainedTemplateOid());
			delta.addConstraint(new AssociationTypeConstraint(relationship.getType(), targetTemplate.getEntryClassName()));
		} else {
			List<TemplateNode> childNodes = templateNode.getChildren().get(relationship.getName());
			if (childNodes != null && childNodes.size() == 1) {
				MessagePart targetPart = baseModel.getMessagePart(relationship.getType());
				if (targetPart != null) {
					TemplateNode childNode = childNodes.get(0);
					delta.addConstraint(new AssociationTypeConstraint(relationship.getType(), childNode.getQualifiedName()));

					for (CdaConstraint subconstraint : cdaConstraint.getConstraints()) {
						addSchematronConstraint(delta, subconstraint);
					}
				}
			}
		}
	}

	private MessagePart constrainCardinalityOfAssociation(CdaConstraint cdaConstraint,
			Relationship relationship, Template template, MessageSet baseModel, TemplateNode templateNode) {
		
		Delta delta = getOrCreateDefinitionDelta(cdaConstraint, relationship, templateNode.getQualifiedName(), template);
		
		MessagePart childMessagePart = baseModel.getMessagePart(relationship.getType());
		if (childMessagePart != null) {
			TemplateNode childNode = templateNode.getChild(relationship.getName());
			createCloneDelta(template, childMessagePart, childNode.getQualifiedName());
			delta.addConstraint(new AssociationTypeConstraint(relationship.getType(), childNode.getQualifiedName()));
		}
		
		return childMessagePart;
	}
	
	private void addSchematronConstraint(Delta delta, CdaConstraint subconstraint) {
		if (subconstraint.getSchematronTest() != null && subconstraint.getSchematronTest().hasValidTest()) {
			SchematronConstraint constraint = new SchematronConstraint(subconstraint.getSchematronTest().getTest());
			constraint.setWarning(subconstraint.isConformanceShould() || subconstraint.isConformanceMay());
			delta.addConstraint(constraint);
		}
	}

	private void parseNestedAttributeConstraint(Template template, CdaConstraint constraint, String className, String attributeRootName) {
		if (!constraint.isPrimitive()) {
			String relationshipName = attributeRootName + "." + parseContext(constraint);

			Delta subdelta = new AttributeDelta();
			subdelta.setClassName(className);
			subdelta.setRelationshipName(relationshipName);
			subdelta.setDeltaChangeType(DeltaChangeType.DEFINITION);

			Cardinality subcardinality = Cardinality.create(constraint.getCardinality());
			subdelta.addConstraint(new CardinalityConstraint(null, subcardinality));
			if (subcardinality.isMandatory()) {
				subdelta.addConstraint(new ConformanceConstraint(null, ConformanceLevel.MANDATORY));
			}
			if (constraint.getSingleValueCode() != null) {
				subdelta.addConstraint(new FixedConstraint(null, constraint.getSingleValueCode().getCode()));
			}
			if (constraint.getValueSet() != null) {
				subdelta.addConstraint(new VocabularyBindingConstraint(null, DomainSource.VALUE_SET, null, lookupValueSet(constraint.getValueSet().getOid())));
			}
			
			template.addDelta(subdelta);
			
			for (CdaConstraint subconstraint : constraint.getConstraints()) {
				parseNestedAttributeConstraint(template, subconstraint, className, relationshipName);
			}
		}
	}

	private Relationship findRelationship(MessagePart messagePart, String context) {
		return messagePart.getRelationship(parseContext(context));
	}
	
	private String parseContext(CdaConstraint cdaConstraint) {
		String context = cdaConstraint.getContext();
		if (context != null && context.startsWith("@")) {
			// the '@' indicating an attribute in XPath should be stripped
			context = context.substring(1);
		}
		return context;
	}

	private String parseContext(String context) {
		if (context != null && context.startsWith("@")) {
			// the '@' indicating an attribute in XPath should be stripped
			context = context.substring(1);
		}
		return context;
	}
	
	private Template createTemplate(CdaTemplate cdaTemplate) {
		Template template = new Template(cdaTemplate.getOid());
		
		template.setOpen(cdaTemplate.isOpen());
		template.setContextType(cdaTemplate.getContextType());
		template.setTemplateType(cdaTemplate.getTemplateType());
		template.setContext(cdaTemplate.getContext());
		template.setImpliedTemplateOid(cdaTemplate.getImpliedTemplateOid());
		template.setDescription(cdaTemplate.getDescription().getText());
		template.setPackageName(normalize(cdaTemplate.getTitle()));

		return template;
	}
	
	private String lookupValueSet(String oid) {
		return this.valueSetMap.get(oid);
	}

	private String lookupCodeSystem(String oid) {
		return this.codeSystemMap.get(oid);
	}
	
}
