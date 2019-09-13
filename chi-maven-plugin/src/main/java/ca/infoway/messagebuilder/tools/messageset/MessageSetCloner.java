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
package ca.infoway.messagebuilder.tools.messageset;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import ca.infoway.messagebuilder.xml.Annotation;
import ca.infoway.messagebuilder.xml.Argument;
import ca.infoway.messagebuilder.xml.CmetBinding;
import ca.infoway.messagebuilder.xml.Code;
import ca.infoway.messagebuilder.xml.CodeSystem;
import ca.infoway.messagebuilder.xml.CodeSystemMaintenanceOrganization;
import ca.infoway.messagebuilder.xml.Concept;
import ca.infoway.messagebuilder.xml.ConceptDomain;
import ca.infoway.messagebuilder.xml.ConstrainedDatatype;
import ca.infoway.messagebuilder.xml.ContextBinding;
import ca.infoway.messagebuilder.xml.Documentation;
import ca.infoway.messagebuilder.xml.ImportedPackage;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.MessageSetHistory;
import ca.infoway.messagebuilder.xml.PackageLocation;
import ca.infoway.messagebuilder.xml.ReceiverResponsibility;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.SchemaMetadata;
import ca.infoway.messagebuilder.xml.SpecializationChild;
import ca.infoway.messagebuilder.xml.ValueSet;
import ca.infoway.messagebuilder.xml.ValueSetFilter;
import ca.infoway.messagebuilder.xml.ValueSetFilterCode;
import ca.infoway.messagebuilder.xml.ValueSetFilterReference;
import ca.infoway.messagebuilder.xml.Vocabulary;
import ca.infoway.messagebuilder.xml.delta.RealmCode;

public class MessageSetCloner {

	public MessageSet clone(MessageSet original, RealmCode realmCode) {
		MessageSet result = new MessageSet();
		result.setVersion(original.getVersion());
		result.setComponent(original.getComponent());
		result.setGeneratedBy(original.getGeneratedBy());
		result.setGeneratedAsR2(original.isGeneratedAsR2());
		result.setCda(original.isCda());
		
		for (MessageSetHistory historyEntry : original.getRemixHistory()) {
			result.getRemixHistory().add(historyEntry);
		}
		for (PackageLocation packageLocation : original.getPackageLocations().values()) {
			PackageLocation clone = clone(packageLocation, realmCode);
			result.getPackageLocations().put(clone.getName(), clone);
		}
		for (Interaction interaction : original.getInteractions().values()) {
			Interaction clone = clone(interaction, realmCode);
			result.getInteractions().put(clone.getName(), clone);
		}
		for (ConstrainedDatatype constrainedDatatype : original.getAllConstrainedDatatypes()) {
			ConstrainedDatatype clone = clone(constrainedDatatype, realmCode);
			result.addConstrainedDatatype(clone);
		}
		
		if (original.getVocabulary() != null) {
			result.setVocabulary(clone(original.getVocabulary()));
		}
		
		if (original.getSchemaMetadata() != null) {
			result.setSchemaMetadata(clone(original.getSchemaMetadata()));
		}
		return result;
	}

	private Vocabulary clone(Vocabulary vocabulary) {
		Vocabulary result = new Vocabulary();
		for (ConceptDomain conceptDomain : vocabulary.getConceptDomains()) {
			result.getConceptDomains().add(clone(conceptDomain));
		}
		
		for (ValueSet valueSet : vocabulary.getValueSets()) {
			result.getValueSets().add(clone(valueSet));
		}
		
		for (CodeSystem codeSystem : vocabulary.getCodeSystems()) {
			result.getCodeSystems().add(clone(codeSystem));
		}
		
		return result;
	}

	private CodeSystem clone(CodeSystem codeSystem) {
		CodeSystem newCodeSystem = new CodeSystem();
		newCodeSystem.setName(codeSystem.getName());
		newCodeSystem.setBusinessName(codeSystem.getBusinessName());
		newCodeSystem.setOid(codeSystem.getOid());
		newCodeSystem.setVersionId(codeSystem.getVersionId());
		newCodeSystem.setReleaseDate(codeSystem.getReleaseDate());
		newCodeSystem.setComplete(codeSystem.isComplete());
		newCodeSystem.setMaintenanceOrganization(clone(codeSystem.getMaintenanceOrganization()));
		newCodeSystem.setDocumentation(clone(codeSystem.getDocumentation()));
		for (Concept concept : codeSystem.getConcepts()) {
			newCodeSystem.getConcepts().add(clone(concept));
		}
		return newCodeSystem;
	}

	private Concept clone(Concept concept) {
		Concept newConcept = new Concept();
		newConcept.setCode(concept.getCode());
		newConcept.setStatus(concept.getStatus());
		newConcept.setDisplayName(concept.getDisplayName());
		newConcept.setSelectable(concept.isSelectable());
		newConcept.setDocumentation(clone(concept.getDocumentation()));
		if (concept.getParentConcepts() != null) {
			for (String parentConcept : concept.getParentConcepts()) {
				newConcept.addParentConcept(parentConcept);
			}
		}
		return newConcept;
	}

	private CodeSystemMaintenanceOrganization clone(CodeSystemMaintenanceOrganization maintenanceOrganization) {
		CodeSystemMaintenanceOrganization newMaintenanceOrganization = new CodeSystemMaintenanceOrganization();
		newMaintenanceOrganization.setName(maintenanceOrganization.getName());
		newMaintenanceOrganization.setRepositoryUrl(maintenanceOrganization.getRepositoryUrl());
		return newMaintenanceOrganization;
	}

	public ValueSet clone(ValueSet valueSet) {
		ValueSet newValueSet = new ValueSet();
		newValueSet.setName(valueSet.getName());
		newValueSet.setId(valueSet.getId());
		newValueSet.setDate(valueSet.getDate());
		newValueSet.setOwningSCWG(valueSet.getOwningSCWG());
		newValueSet.setCodeSystem(valueSet.getCodeSystem());
		newValueSet.setComplete(valueSet.isComplete());
		newValueSet.setDocumentation(clone(valueSet.getDocumentation()));
		for (ContextBinding contextBinding : valueSet.getContextBindings()) {
			newValueSet.getContextBindings().add(clone(contextBinding));
		}
		newValueSet.getSourceCodeSystems().addAll(valueSet.getSourceCodeSystems());
		if (valueSet.getCodes() != null) {
			for (Code code : valueSet.getCodes()) {
				newValueSet.addCode(clone(code));
			}
		}
		if (valueSet.getFilters() != null) {
			for (ValueSetFilter filter : valueSet.getFilters()) {
				newValueSet.addFilter(clone(filter));
			}
		}
		return newValueSet;
	}

	private ContextBinding clone(ContextBinding contextBinding) {
		ContextBinding newContextBinding = new ContextBinding(contextBinding.getConceptDomain(), contextBinding.getRealm(), contextBinding.getCodingStrength());
		return newContextBinding;
	}

	private Code clone(Code code) {
		Code newCode = new Code();
		newCode.setCodeSystem(code.getCodeSystem());
		newCode.setCodeValue(code.getCodeValue());
		newCode.setStatus(code.getStatus());
		newCode.setPrintName(code.getPrintName());
		return newCode;
	}

	private ValueSetFilter clone(ValueSetFilter filter) {
		ValueSetFilter newFilter = new ValueSetFilter();
		newFilter.setCodeSystemName(filter.getCodeSystemName());
		newFilter.setPropertyName(filter.getPropertyName());
		newFilter.setPropertyValue(filter.getPropertyValue());
		newFilter.setPropertyIncluded(filter.isPropertyIncluded());
		newFilter.setNonComputableContent(filter.getNonComputableContent());
		if (filter.getIncludedCodes() != null) {
			for (ValueSetFilterCode includedCode : filter.getIncludedCodes()) {
				newFilter.addIncludedCode(clone(includedCode));
			}
		}
		if (filter.getExcludedCodes() != null) {
			for (ValueSetFilterCode excludedCode : filter.getExcludedCodes()) {
				newFilter.addExcludedCode(clone(excludedCode));
			}
		}
		if (filter.getOtherValueSets() != null) {
			for (ValueSetFilterReference reference : filter.getOtherValueSets()) {
				newFilter.addOtherValueSet(clone(reference));
			}
		}
		return newFilter;
	}

	private ValueSetFilterCode clone(ValueSetFilterCode code) {
		ValueSetFilterCode newCode = new ValueSetFilterCode();
		newCode.setCode(code.getCode());
		newCode.setIncludeChildren(code.isIncludeChildren());
		return newCode;
	}

	private ValueSetFilterReference clone(ValueSetFilterReference reference) {
		ValueSetFilterReference newReference = new ValueSetFilterReference();
		newReference.setName(reference.getName());
		return newReference;
	}

	public ConceptDomain clone(ConceptDomain conceptDomain) {
		ConceptDomain newConceptDomain = new ConceptDomain();
		newConceptDomain.setName(conceptDomain.getName());
		newConceptDomain.setOwningSCWG(conceptDomain.getOwningSCWG());
		newConceptDomain.setRiskOfChange(conceptDomain.getRiskOfChange());
		newConceptDomain.setDocumentation(clone(conceptDomain.getDocumentation()));
		newConceptDomain.getParentConceptDomains().addAll(conceptDomain.getParentConceptDomains());
		return newConceptDomain;
	}

	private Interaction clone(Interaction interaction, RealmCode realmCode) {
		Interaction result = new Interaction();
		result.setName(realmCode.substituteRealmCode(interaction.getName()));
		result.setTriggerEvent(interaction.getTriggerEvent());
		result.setCategory(interaction.getCategory());
		result.setDocumentation(clone(interaction.getDocumentation()));
		copyFieldValue(interaction, result, "businessName");
		result.setSuperTypeName(realmCode.substituteRealmCode(interaction.getSuperTypeName()));
		
		result.getArguments().addAll(cloneArguments(interaction.getArguments(), realmCode));
		
		result.getReceiverResponsibilities().addAll(cloneResponsibilities(interaction.getReceiverResponsibilities(), realmCode));
		
		return result;
	}

	private List<Argument> cloneArguments(List<Argument> arguments, RealmCode realmCode) {
		List<Argument> result = new ArrayList<Argument>();
		for (Argument argument : arguments) {
			Argument clone = new Argument();
			clone.setName(realmCode.substituteRealmCode(argument.getName()));
			clone.setTemplateParameterName(argument.getTemplateParameterName());
			clone.setTraversalName(argument.getTraversalName());
			clone.getArguments().addAll(cloneArguments(argument.getArguments(), realmCode));
			clone.getChoices().addAll(cloneArgumentChoices(argument.getChoices(), realmCode));
			result.add(clone);
		}
		return result;
	}

	private List<Relationship> cloneArgumentChoices(
			List<Relationship> choices, RealmCode realmCode) {
		List<Relationship> result = new ArrayList<Relationship>();
		for (Relationship relationship : choices) {
			Relationship clone = clone(relationship, true, realmCode);
			result.add(clone);
		}
		return result;
	}

	private ConstrainedDatatype clone(ConstrainedDatatype constrainedDatatype, RealmCode realmCode) {
		ConstrainedDatatype result = new ConstrainedDatatype();
		result.setName(constrainedDatatype.getName());
		result.setBaseType(constrainedDatatype.getBaseType());
		if (constrainedDatatype.isExtension()) {
			result.setExtension();
		}
		
		for (Relationship relationship : constrainedDatatype.getRelationships()) {
			result.getRelationships().add(clone(relationship, false, realmCode));
		}
		
		return result;
	}
	
	private SchemaMetadata clone(SchemaMetadata schemaMetadata) {
		SchemaMetadata result = new SchemaMetadata();
		result.setTargetNamespace(schemaMetadata.getTargetNamespace());
		result.setElementFormDefault(schemaMetadata.getElementFormDefault());
		for (String schemaLocation : schemaMetadata.getSchemaLocations()) {
			result.getSchemaLocations().add(schemaLocation);
		}
		for (String documentation : schemaMetadata.getDocumentation()) {
			result.addDocumentation(documentation);
		}
		return result;
	}

	private Documentation clone(Documentation documentation) {
		if (documentation == null) {
			return null;
		} else {
			Documentation result = new Documentation();
			result.setBusinessName(documentation.getBusinessName());
			result.setTitle(documentation.getTitle());
			for (Annotation annotation : documentation.getAnnotations()) {
				Annotation clone = new Annotation(annotation.getText());
				copyFieldValue(annotation, clone, "annotationType");
				clone.setOtherAnnotationType(annotation.getOtherAnnotationType());
				clone.setSourceName(annotation.getSourceName());
				result.getAnnotations().add(clone);
			}
			return result;
		}
	}
	
	private List<ReceiverResponsibility> cloneResponsibilities(List<ReceiverResponsibility> responsibilities, RealmCode realmCode) {
		List<ReceiverResponsibility> result = new ArrayList<ReceiverResponsibility>();
		for (ReceiverResponsibility receiverResponsibility : responsibilities) {
			ReceiverResponsibility clone = new ReceiverResponsibility();
			clone.setInvokeInteraction(realmCode.substituteRealmCode(receiverResponsibility.getInvokeInteraction()));
			clone.setIncludeTriggerEvent(receiverResponsibility.isIncludeTriggerEvent());
			clone.setReason(receiverResponsibility.getReason());
			result.add(clone);
		}
		return result;
	}

	private void copyFieldValue(Object original, Object clone, String fieldName) {
		try {
			Field field = original.getClass().getDeclaredField(fieldName);
			field.setAccessible(true);
			Object object = field.get(original);
			field.set(clone, object);
		} catch (SecurityException e) {
		} catch (NoSuchFieldException e) {
		} catch (IllegalArgumentException e) {
		} catch (IllegalAccessException e) {
		}
	}

	private PackageLocation clone(PackageLocation packageLocation, RealmCode realmCode) {
		PackageLocation result = new PackageLocation(realmCode.substituteRealmCode(packageLocation.getName()));
		result.setCategory(packageLocation.getCategory());
		result.setDescriptiveName(packageLocation.getDescriptiveName());
		result.setRootType(realmCode.substituteRealmCode(packageLocation.getRootType()));

		result.setDocumentation(clone(packageLocation.getDocumentation()));
		result.setDerivedFromStaticModel(clone(packageLocation.getDerivedFromStaticModel()));
		result.setDatatypeModel(clone(packageLocation.getDatatypeModel()));
		result.setVocabularyModel(clone(packageLocation.getVocabularyModel()));
		result.setCommonModelElement(clone(packageLocation.getCommonModelElement()));
		
		result.getCmetBindings().addAll(cloneCmetBindings(packageLocation.getCmetBindings()));
		
		result.getMessageParts().putAll(cloneMessageParts(packageLocation.getMessageParts(), realmCode));
		return result;
	}

	private ImportedPackage clone(ImportedPackage importedPackage) {
		ImportedPackage result = null;
		
		if (importedPackage != null) {
			result = new ImportedPackage();
			result.setRoot(importedPackage.getRoot());
			result.setArtifact(importedPackage.getArtifact());
			result.setVersion(importedPackage.getVersion());
			result.setRealm(importedPackage.getRealm());
		}
		return result;
	}
	
	private List<CmetBinding> cloneCmetBindings(List<CmetBinding> cmetBindings) {
		List<CmetBinding> result = new ArrayList<CmetBinding>();
		for (CmetBinding cmetBinding : cmetBindings) {
			result.add(clone(cmetBinding));
		}
		return result;
	}
	
	private CmetBinding clone(CmetBinding cmetBinding) {
		CmetBinding result = null;
		
		if (cmetBinding != null) {
			result = new CmetBinding();
			result.setCmetName(cmetBinding.getCmetName());
			result.setAttributionLevel(cmetBinding.getAttributionLevel());
			result.setCode(cmetBinding.getCode());
			result.setCodeSystemOid(cmetBinding.getCodeSystemOid());
			result.setDocumentation(clone(cmetBinding.getDocumentation()));

		}
		
		return result;
	}

	private Map<String, MessagePart> cloneMessageParts(
			Map<String, MessagePart> messageParts, RealmCode realmCode) {
		Map<String, MessagePart> result = new TreeMap<String, MessagePart>();
		for (Map.Entry<String, MessagePart> entry : messageParts.entrySet()) {
			MessagePart clone = clone(entry.getValue(), realmCode);
			result.put(clone.getName(), clone);
		}
		return result;
	}

	public MessagePart clone(MessagePart value, RealmCode realmCode) {
		MessagePart result = new MessagePart(realmCode.substituteRealmCode(value.getName()));
		result.setRimClass(value.getRimClass());
		result.setDocumentation(clone(value.getDocumentation()));
		for (SpecializationChild specializationChild : value.getSpecializationChilds()) {
			result.addSpecializationChild(clone(specializationChild, realmCode));
		}
		result.setAbstract(value.isAbstract());
		result.setTemplateParameter(value.isTemplateParameter());
		result.setDerivedFromClass(value.getDerivedFromClass());
		for (Relationship relationship : value.getRelationships()) {
			Relationship clone = clone(relationship, false, realmCode);
			result.getRelationships().add(clone);
		}
		return result;
	}

	private Relationship clone(Relationship relationship, boolean isChoice, RealmCode realmCode) {
		Relationship result = new Relationship();
		result.setDocumentation(clone(relationship.getDocumentation()));
		result.setName(relationship.getName());
		result.setNamespace(relationship.getNamespace());
		result.setAttribute(relationship.isAttribute());
		if (relationship.isTemplateRelationship() || relationship.isAttribute()) {
			result.setType(relationship.getType());
		} else {
			result.setType(realmCode.substituteRealmCode(relationship.getType()));
		}
		result.setConstrainedType(relationship.getConstrainedType());
		if (!isChoice) {
			result.setCardinality(relationship.getCardinality());
			result.setConformance(relationship.getConformance());
			result.setSortOrder(relationship.getSortOrder());
		}
		result.setDefaultValue(relationship.getDefaultValue());
		result.setDomainType(relationship.getDomainType());
		result.setFixedValue(relationship.getFixedValue());
		result.setLength(relationship.getLength());
		copyFieldValue(relationship, result, "structural");
		result.setTemplateParameterName(relationship.getTemplateParameterName());
		result.setCodingStrength(relationship.getCodingStrength());
		
		for (Relationship choice : relationship.getChoices()) {
			result.getChoices().add(clone(choice, true, realmCode));
		}
		
		result.setDomainSource(relationship.getDomainSource());
		result.setAssociationSortKey(relationship.getAssociationSortKey());
		result.setTraversableDerivationClassName(relationship.getTraversableDerivationClassName());
		result.setTraversableAssociationName(relationship.getTraversableAssociationName());
		result.setNontraversableDerivationClassName(relationship.getNontraversableDerivationClassName());
		result.setNontraversableAssociationName(relationship.getNontraversableAssociationName());
		result.setCmetBindingName(relationship.getCmetBindingName());
		result.setCmetDerivationClassName(relationship.getCmetDerivationClassName());
		result.setNonFixedVocabularyBinding(relationship.getNonFixedVocabularyBinding());
		
		return result;
	}
	
	private SpecializationChild clone(SpecializationChild child, RealmCode realmCode) {
		return new SpecializationChild(realmCode.substituteRealmCode(child.getName()), child.getCmetBindingName(), child.getCmetDerivationClassName());
	}
}
