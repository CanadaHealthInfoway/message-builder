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

import java.util.HashSet;
import java.util.Set;

import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.ConformanceLevel;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.TypeName;
import ca.infoway.messagebuilder.xml.delta.AssociationDelta;
import ca.infoway.messagebuilder.xml.delta.AttributeDelta;
import ca.infoway.messagebuilder.xml.delta.CardinalityConstraint;
import ca.infoway.messagebuilder.xml.delta.ConformanceConstraint;
import ca.infoway.messagebuilder.xml.delta.ConstraintChangeType;
import ca.infoway.messagebuilder.xml.delta.DatatypeConstraint;
import ca.infoway.messagebuilder.xml.delta.Delta;
import ca.infoway.messagebuilder.xml.delta.DeltaChangeType;
import ca.infoway.messagebuilder.xml.delta.FixedConstraint;
import ca.infoway.messagebuilder.xml.delta.RemoveChoiceConstraint;
import ca.infoway.messagebuilder.xml.delta.RemoveConstraint;
import ca.infoway.messagebuilder.xml.template.Template;
import ca.infoway.messagebuilder.xml.template.TemplateSet;


public class CdaTemplateProcessor {

	public void parseTemplate(TemplateExport templateExport, MessageSet baseModel, TemplateSet templateSet) {
		
		for (CdaTemplate cdaTemplate : templateExport.getTemplates()) {
			Template template = createTemplate(cdaTemplate);
			
			MessagePart entryPart = null;
			for (MessagePart part : baseModel.getAllMessageParts()) {
				TypeName typeName = new TypeName(part.getName());
				if (typeName.getUnqualifiedName().equals(template.getContextType())) {
					entryPart = part;
				}
			}
			
			if (entryPart == null) {
//				System.out.println("could not find part named " + template.getContextType());
			} else {
			
				for (CdaConstraint cdaConstraint : cdaTemplate.getConstraints()) {
					parseConstraint(cdaConstraint, entryPart, template, baseModel, null, null);
				}
				
				if (!cdaTemplate.isOpen()) {
					Set<String> includedRelationships = new HashSet<String>();
					
					for (CdaConstraint cdaConstraint : cdaTemplate.getConstraints()) {
						includedRelationships.add(parseContext(cdaConstraint));
					}
					
					for (Relationship relationship : entryPart.getRelationships()) {
						if (!includedRelationships.contains(relationship.getName())) {
							Delta delta;
							if (relationship.isAttribute()) {
								delta = new AttributeDelta();
							} else {
								delta = new AssociationDelta();
							}
							delta.setClassName(entryPart.getName());
							delta.setRelationshipName(relationship.getName());
							delta.setDeltaChangeType(DeltaChangeType.REMOVE);
							delta.addConstraint(new RemoveConstraint(entryPart.getName(), relationship.getName()));
							template.addDelta(delta);
						}
					}
				}
			}
			
			
			templateSet.addTemplate(template);
		}
	}

	private void parseConstraint(CdaConstraint cdaConstraint,
			MessagePart entryPart, Template template, MessageSet baseModel, Cardinality parentCardinality, Cardinality branchCardinality) {
		if (cdaConstraint.getContext() != null) {
			Relationship relationship = findRelationship(entryPart,
					cdaConstraint);
			if (relationship != null) {
				if (relationship.isAttribute()) {
					parseConstraintAsAttribute(cdaConstraint, relationship, entryPart, template);
				} else if (relationship.isAssociation()) {
					parseConstraintAsAssociation(cdaConstraint, relationship, entryPart, template, baseModel, parentCardinality, branchCardinality);
				} else {
//								System.out.println("Unhandled constraint " + cdaConstraint.getNumber());
				}
			}
		}
	}

	private void parseConstraintAsAttribute(CdaConstraint cdaConstraint,
			Relationship relationship, MessagePart entryPart, Template template) {
		String messagePartName = entryPart.getName();
		String rootName = relationship.getName();
		
		Delta delta = new AttributeDelta();
		delta.setClassName(messagePartName);
		delta.setRelationshipName(rootName);
		delta.setDeltaChangeType(DeltaChangeType.DEFINITION);

		Cardinality constrainedCardinality = Cardinality.create(cdaConstraint.getCardinality());
		if (!constrainedCardinality.equals(relationship.getCardinality())) {
			delta.addConstraint(new CardinalityConstraint(relationship.getCardinality(), constrainedCardinality));
		}
		if (relationship.getConformance().equals(ConformanceLevel.OPTIONAL) && constrainedCardinality.isMandatory()) {
			delta.addConstraint(new ConformanceConstraint(relationship.getConformance(), ConformanceLevel.MANDATORY));
		}
		if (relationship.getType().equals("CS") && cdaConstraint.getSingleValueCode() != null) {
			delta.addConstraint(new FixedConstraint(relationship.getFixedValue(), cdaConstraint.getSingleValueCode().getCode()));
		}
		if (cdaConstraint.getDataType() != null && !cdaConstraint.getDataType().equals(relationship.getType())) {
			delta.addConstraint(new DatatypeConstraint(relationship.getType(), cdaConstraint.getDataType()));
		}
		
		if (delta.hasConstraints()) {
			template.addDelta(delta);
		}
		
		for (CdaConstraint subconstraint : cdaConstraint.getConstraints()) {
			parseNestedAttributeConstraint(template, subconstraint, messagePartName, rootName);
		}
	}

	private void parseConstraintAsAssociation(CdaConstraint cdaConstraint,
			Relationship relationship, MessagePart entryPart, Template template, MessageSet baseModel, Cardinality parentCardinality, Cardinality branchCardinality) {
		String messagePartName = entryPart.getName();
		String rootName = relationship.getName();
		
		Delta delta = template.getDelta(DeltaChangeType.DEFINITION, messagePartName, rootName);
		if (delta == null) {
			
			delta = new AssociationDelta();
			delta.setClassName(messagePartName);
			delta.setRelationshipName(rootName);
			
			if (relationship.isChoice()) {
				delta.setDeltaChangeType(DeltaChangeType.CHOICE);
				
				if (parentCardinality != null && parentCardinality.isSingle()) {
					for (Relationship choiceRelationship : relationship.getChoices()) {
						if (!choiceRelationship.getName().equals(cdaConstraint.getContext())) {
							delta.addConstraint(new RemoveChoiceConstraint(relationship.getType()));
						}
					}
				}
				
				Integer max = branchCardinality == null ? 1 : branchCardinality.getMax();
				template.addTemplateReference(messagePartName + "." + cdaConstraint.getContext(), cdaConstraint.getContainedTemplateOid(), max);
			} else {
				delta.setDeltaChangeType(DeltaChangeType.DEFINITION);
				
				Cardinality constrainedCardinality = Cardinality.create(cdaConstraint.getCardinality());
				delta.addConstraint(new CardinalityConstraint(relationship.getCardinality(), constrainedCardinality));
				if (relationship.getConformance().equals(ConformanceLevel.OPTIONAL) && constrainedCardinality.isMandatory()) {
					delta.addConstraint(new ConformanceConstraint(relationship.getConformance(), ConformanceLevel.MANDATORY));
				}
				
				resolveChildConstraints(cdaConstraint, relationship, template, baseModel, messagePartName, rootName, constrainedCardinality, constrainedCardinality);
			}
			
			if (delta.hasConstraints()) {
				template.addDelta(delta);
			}
		} else {
			CardinalityConstraint cardinalityConstraint = (CardinalityConstraint) delta.getConstraint(ConstraintChangeType.CHANGE_CARDINALITY);
			Cardinality constrainedCardinality = Cardinality.create(cdaConstraint.getCardinality());
			Cardinality sumCardinality = Cardinality.add(constrainedCardinality, cardinalityConstraint.getNewCardinality());
			cardinalityConstraint.setNewCardinality(sumCardinality);
			
			resolveChildConstraints(cdaConstraint, relationship, template, baseModel, messagePartName, rootName, sumCardinality, constrainedCardinality);
		}
	}

	private void resolveChildConstraints(CdaConstraint cdaConstraint,
			Relationship relationship, Template template, MessageSet baseModel,
			String messagePartName, String rootName,
			Cardinality constrainedCardinality, Cardinality branchCardinality) {
		MessagePart targetPart = baseModel.getMessagePart(relationship.getType());
		if (targetPart == null) {
			System.out.println("association to nothing? " + messagePartName + " " + rootName);
		} else {
			for (CdaConstraint subconstraint : cdaConstraint.getConstraints()) {
				parseConstraint(subconstraint, targetPart, template, baseModel, constrainedCardinality, branchCardinality);
			}
		}
	}
	
	private void parseNestedAttributeConstraint(Template template, CdaConstraint constraint, String messagePartName, String attributeRootName) {
		if (!constraint.isPrimitive()) {
			if (constraint.getSingleValueCode() == null && constraint.getConstraints().isEmpty()) {
//				System.out.println("Unhandled attribute subconstraint " + constraint.getNumber());
			} else {
				String relationshipName = attributeRootName + "." + parseContext(constraint);

				Delta subdelta = new AttributeDelta();
				subdelta.setClassName(messagePartName);
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
				
				if (subdelta.hasConstraints()) {
					template.addDelta(subdelta);
				}
				
				for (CdaConstraint subconstraint : constraint.getConstraints()) {
					parseNestedAttributeConstraint(template, subconstraint, messagePartName, relationshipName);
				}
			}
		}
	}

	private Relationship findRelationship(MessagePart messagePart,
			CdaConstraint cdaConstraint) {
		
		String context = parseContext(cdaConstraint);
		Relationship relationship = messagePart.getRelationship(context);
		return relationship;
	}

	private String parseContext(CdaConstraint cdaConstraint) {
		String context = cdaConstraint.getContext();
		if (context == null) {
			System.out.println("Contextless constraint " + cdaConstraint.getNumber());
		}
		else if (context.startsWith("@")) {
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
		return template;
	}
}
