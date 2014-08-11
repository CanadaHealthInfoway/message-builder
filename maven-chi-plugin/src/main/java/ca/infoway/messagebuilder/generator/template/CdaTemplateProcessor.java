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
import ca.infoway.messagebuilder.xml.ConformanceLevel;
import ca.infoway.messagebuilder.xml.DomainSource;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.TypeName;
import ca.infoway.messagebuilder.xml.delta.AddChoiceConstraint;
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
import ca.infoway.messagebuilder.xml.template.TemplateReference;
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
		codeSystemMap.put("2.16.840.1.113883.6.96", "SNOMED CT");
		codeSystemMap.put("2.16.840.1.113883.6.101", "NUCCProviderTaxonomy");
	}

	public String normalize(String rawName) {
		
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
	
	public String normalizeValueSetName(String rawName) {
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
				TemplateNode rootNode = new TemplateNode(rootName.getParent().getName(), rootName.getUnqualifiedName());
				collectNames(cdaTemplate, entryPart, baseModel, rootNode);
				rootNode.disambiguateTree();
				
				createCloneDelta(template, entryPart, rootNode.getQualifiedName());
				
				for (CdaConstraint cdaConstraint : cdaTemplate.getConstraints()) {
					parseConstraint(cdaConstraint, entryPart, template, baseModel, null, rootNode);
				}
				
				if (!cdaTemplate.isOpen()) {
					removeUnreferencedRelationships(cdaTemplate, template, entryPart, rootNode.getQualifiedName());
				}
				
				constrainChoiceBlocks(baseModel, template);
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
	
	private String convertName(String originalName, String newPackageName) {
		int index = originalName.indexOf(".");
		if (index >= 0) {
			return newPackageName + originalName.substring(index);
		} else {
			return newPackageName + "." + originalName;
		}
	}

	public void constrainChoiceBlocks(MessageSet baseModel, Template template) {
		if (template.getTemplateReferences() != null && template.getTemplateReferences().size() > 0) {
			Map<String,Map<String,List<TemplateReference>>> choiceOptionsInUse = new HashMap<String,Map<String,List<TemplateReference>>>();
			for (TemplateReference templateReference : template.getTemplateReferences()) {
				int index = templateReference.getContext().lastIndexOf('.');
				String partName = templateReference.getContext().substring(0, index);
				String relationshipName = templateReference.getContext().substring(index + 1);

				Map<String,List<TemplateReference>> choices = choiceOptionsInUse.get(partName);
				if (choices == null) {
					choices = new HashMap<String,List<TemplateReference>>();
					choiceOptionsInUse.put(partName, choices);
				}
				
				List<TemplateReference> references = choices.get(relationshipName);
				if (references == null) {
					references = new ArrayList<TemplateReference>();
					choices.put(relationshipName, references);
				}
				references.add(templateReference);
			}
			
			for (String partName : choiceOptionsInUse.keySet()) {
				Cardinality ancestorCardinality = null;
				for (Delta delta : template.getDeltas()) {
					AssociationTypeConstraint associationConstraint = (AssociationTypeConstraint) delta.getConstraint(ConstraintChangeType.CHANGE_ASSOCIATION_TYPE);
					if (associationConstraint != null && associationConstraint.getNewValue().equals(partName)) {
						CardinalityConstraint cardinalityConstraint = (CardinalityConstraint) delta.getConstraint(ConstraintChangeType.CHANGE_CARDINALITY);
						if (cardinalityConstraint != null) {
							ancestorCardinality = cardinalityConstraint.getNewCardinality();
						}
					}
				}
				
				if (!(template.isOpen() && ancestorCardinality != null && ancestorCardinality.isUnbounded())) {
					Delta cloneDelta = template.getDelta(DeltaChangeType.CLONE, partName, null);
					CloneConstraint cloneConstraint = (CloneConstraint) cloneDelta.getConstraint(ConstraintChangeType.CLONE);
					MessagePart originalPart = baseModel.getMessagePart(cloneConstraint.getOriginalClassName());
					Relationship choiceRelationship = null;
					for (Relationship relationship : originalPart.getRelationships()) {
						if (relationship.isChoice()) {
							choiceRelationship = relationship;
						}
					}

					TypeName choiceBlockName = new TypeName(choiceRelationship.getType());
					String newChoiceBlockName = template.getPackageName() + "." + choiceBlockName.getUnqualifiedName();
					
					MessagePart originalChoiceBlock = baseModel.getMessagePart(choiceRelationship.getType());

					createCloneDelta(template, originalChoiceBlock, newChoiceBlockName);
					
					Delta choiceDelta = createDelta(newChoiceBlockName, null, DeltaChangeType.CHOICE);
					for (Relationship choiceOption : choiceRelationship.getChoices()) {
						Map<String, List<TemplateReference>> optionsMap = choiceOptionsInUse.get(partName);
						List<TemplateReference> references = optionsMap.get(choiceOption.getName());
						if (references == null) {
							// no references to this option, so drop it
							choiceDelta.addConstraint(new RemoveChoiceConstraint(choiceOption.getType()));
						} else if (references.size() == 1 && references.get(0).getOid() != null) {
							// exactly one reference to this option, so narrow it
							choiceDelta.addConstraint(new RemoveChoiceConstraint(choiceOption.getType()));
							
							Template targetTemplate = this.templateSet.getByOid(references.get(0).getOid());
							choiceDelta.addConstraint(new AddChoiceConstraint(targetTemplate.getEntryClassName()));
						}
					}
					template.addDelta(choiceDelta);
					
					Delta associationDelta = createDelta(partName, choiceRelationship, DeltaChangeType.DEFINITION);
					associationDelta.addConstraint(new AssociationTypeConstraint(choiceRelationship.getType(), newChoiceBlockName));
					template.addDelta(associationDelta);
					
				}
				
			}
		}
	}

	private void collectNames(CdaTemplate cdaTemplate, MessagePart messagePart, MessageSet baseModel, TemplateNode rootNode) {
		List<CdaConstraint> constraints = cdaTemplate.getConstraints();
		collectNames(messagePart, baseModel, rootNode, constraints);
	}

	public void collectNames(MessagePart messagePart, MessageSet baseModel, TemplateNode node, List<CdaConstraint> constraints) {
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
								TemplateNode childNode = nextNode.getChild(relationship.getName());
								if (childNode == null) {
									TypeName typeName = new TypeName(name);
									childNode = nextNode.addChild(relationship.getName(), typeName.getUnqualifiedName());
								}
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
								TemplateNode childNode = nextNode.getChild(relationship.getName());
								if (childNode == null) {
									TypeName typeName = new TypeName(name);
									childNode = nextNode.addChild(relationship.getName(), typeName.getUnqualifiedName());
								}
								collectNames(childPart, baseModel, childNode, constraint.getConstraints());
							}
						}
					}
				}
			}
		}
	}

	public void createCloneDelta(Template template, MessagePart entryPart, String cloneName) {
		Delta delta = new ClassDelta();
		delta.setClassName(cloneName);
		delta.setDeltaChangeType(DeltaChangeType.CLONE);
		delta.addConstraint(new CloneConstraint(cloneName, null, entryPart.getName()));
		template.addDelta(delta);
	}

	private void removeUnreferencedRelationships(CdaTemplate cdaTemplate, Template template, MessagePart messagePart, String className) {
		for (Relationship relationship : messagePart.getRelationships()) {
			if (!allRelationshipContexts(cdaTemplate).contains(relationship.getName())) {
				Delta delta = createDelta(className, relationship, DeltaChangeType.REMOVE);
				delta.addConstraint(new RemoveConstraint(className, relationship.getName()));
				template.addDelta(delta);
			}
		}
	}

	private Set<String> allRelationshipContexts(CdaTemplate cdaTemplate) {
		Set<String> includedRelationships = new HashSet<String>();
		
		for (CdaConstraint cdaConstraint : cdaTemplate.getConstraints()) {
			includedRelationships.add(parseContext(cdaConstraint));
		}
		return includedRelationships;
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

	private void parseConstraint(CdaConstraint cdaConstraint,
			MessagePart entryPart, Template template, MessageSet baseModel, Cardinality parentCardinality, TemplateNode templateNode) {
		MessagePart nextPart = entryPart;
		TemplateNode nextNode = templateNode;
		String[] context = tokenizeContext(cdaConstraint.getContext());
		if (context.length > 0) {
			Relationship relationship = findRelationship(nextPart, context[0]);
			for (int i = 0; i < context.length - 1; i++) {
				if (relationship != null) {
					if (relationship.isChoice()) {
						
					} else {
						nextPart = constrainCardinalityOfAssociation(cdaConstraint, relationship, template, baseModel, nextNode);
					}
					if (nextPart != null) {
						nextNode = nextNode.getChild(relationship.getName());
						relationship = findRelationship(nextPart, parseContext(context[i + 1]));
					} else {
						relationship = null;
					}
				}
			}
			
			if (relationship != null) {
				if (relationship.isAttribute()) {
					parseConstraintAsAttribute(cdaConstraint, relationship, nextNode.getQualifiedName(), template);
				} else if (relationship.isAssociation()) {
					parseConstraintAsAssociation(cdaConstraint, relationship, nextPart, template, baseModel, parentCardinality, nextNode);
				}
			} else if (cdaConstraint.getContext() != null) {
//				System.out.println("Unknown relationship: " + cdaConstraint.getContext() + " in constraint " + cdaConstraint.getNumber());
			}
		}
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
		if ((relationship.getType().equals("CS") || relationship.getType().equals("LIST<CS>")) && cdaConstraint.getSingleValueCode() != null) {
			delta.addConstraint(new FixedConstraint(relationship.getFixedValue(), cdaConstraint.getSingleValueCode().getCode()));
		}
		if (cdaConstraint.getDataType() != null && !cdaConstraint.getDataType().equals(relationship.getType())) {
			delta.addConstraint(new DatatypeConstraint(relationship.getType(), cdaConstraint.getDataType()));
		}
		if (StandardDataType.isCoded(relationship.getType()) || StandardDataType.isCodedListOrSet(relationship.getType())) {
			if (cdaConstraint.getValueSet() != null) {
				delta.addConstraint(new VocabularyBindingConstraint(relationship.getDomainSource(), DomainSource.VALUE_SET, relationship.getDomainType(), lookupValueSet(cdaConstraint.getValueSet().getOid())));
			} else if (cdaConstraint.getCodeSystem() != null && cdaConstraint.getSingleValueCode() == null) {
				delta.addConstraint(new VocabularyBindingConstraint(relationship.getDomainSource(), DomainSource.CODE_SYSTEM, relationship.getDomainType(), lookupCodeSystem(cdaConstraint.getCodeSystem().getOid())));
			}
		}
		
		ensureCardinalityConsistency(relationship, delta);
		
		for (CdaConstraint subconstraint : cdaConstraint.getConstraints()) {
			addSchematronConstraint(delta, subconstraint);

			if (StandardDataType.isCoded(relationship.getType()) || StandardDataType.isCoded(cdaConstraint.getDataType())) {
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

	public void ensureCardinalityConsistency(Relationship relationship,
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

		Delta delta = template.getDelta(DeltaChangeType.DEFINITION, className, rootName);
		if (delta == null) {
			delta = createDelta(className, relationship, DeltaChangeType.DEFINITION);
	
			delta.addConstraint(new CardinalityConstraint(relationship.getCardinality(), constrainedCardinality));

			if (relationship.getConformance().equals(ConformanceLevel.OPTIONAL) && constrainedCardinality.isMandatory()) {
				delta.addConstraint(new ConformanceConstraint(relationship.getConformance(), ConformanceLevel.MANDATORY));
			}
			
			template.addDelta(delta);
		} else {
			CardinalityConstraint cardinalityConstraint = (CardinalityConstraint) delta.getConstraint(ConstraintChangeType.CHANGE_CARDINALITY);
			constrainedCardinality = Cardinality.add(constrainedCardinality, cardinalityConstraint.getNewCardinality(), relationship.getCardinality().getMax());
			cardinalityConstraint.setNewCardinality(constrainedCardinality);
		}

		return delta;
	}

	private void parseConstraintAsAssociation(CdaConstraint cdaConstraint,
			Relationship relationship, MessagePart entryPart, Template template, MessageSet baseModel, Cardinality parentCardinality, TemplateNode templateNode) {

		if (relationship.isChoice()) {
			parseConstraintAsChoice(cdaConstraint, relationship, entryPart,
					template, parentCardinality, templateNode.getQualifiedName());
		} else {
			Delta delta = getOrCreateDefinitionDelta(cdaConstraint, relationship, templateNode.getQualifiedName(), template);

			Cardinality constrainedCardinality = Cardinality.create(cdaConstraint.getCardinality());
			
			if (cdaConstraint.getContainedTemplateOid() != null) {
				Template targetTemplate = this.templateSet.getByOid(cdaConstraint.getContainedTemplateOid());
				delta.addConstraint(new AssociationTypeConstraint(relationship.getType(), targetTemplate.getEntryClassName()));
				
			} else {

				MessagePart targetPart = baseModel.getMessagePart(relationship.getType());
				if (targetPart != null) {
					TemplateNode childNode = templateNode.getChild(relationship.getName());
					createCloneDelta(template, targetPart, childNode.getQualifiedName());
					delta.addConstraint(new AssociationTypeConstraint(relationship.getType(), childNode.getQualifiedName()));
					
					for (CdaConstraint subconstraint : cdaConstraint.getConstraints()) {
						addSchematronConstraint(delta, subconstraint);
						
						parseConstraint(subconstraint, targetPart, template, baseModel, constrainedCardinality, childNode);
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
	
	public void addSchematronConstraint(Delta delta, CdaConstraint subconstraint) {
		if (subconstraint.getSchematronTest() != null && subconstraint.getSchematronTest().hasValidTest()) {
			SchematronConstraint constraint = new SchematronConstraint(subconstraint.getSchematronTest().getTest());
			constraint.setWarning(subconstraint.isConformanceShould() || subconstraint.isConformanceMay());
			delta.addConstraint(constraint);
		}
	}

	private void parseConstraintAsChoice(CdaConstraint cdaConstraint,
			Relationship relationship, MessagePart entryPart,
			Template template, Cardinality parentCardinality, String className) {
		String[] context = tokenizeContext(cdaConstraint.getContext());
		Integer max = parentCardinality == null ? 1 : parentCardinality.getMax();
		template.addTemplateReference(className + "." + context[context.length-1], cdaConstraint.getContainedTemplateOid(), max);
	}

	private void parseNestedAttributeConstraint(Template template, CdaConstraint constraint, String className, String attributeRootName) {
		if (!constraint.isPrimitive() && (constraint.getSingleValueCode() != null || !constraint.getConstraints().isEmpty())) {
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
