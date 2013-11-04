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
 * Author:        $LastChangedBy: jroberts $
 * Last modified: $LastChangedDate: 2013-05-06 12:01:14 -0400 (Mon, 06 May 2013) $
 * Revision:      $LastChangedRevision: 6818 $
 */

package ca.infoway.messagebuilder.generator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import ca.infoway.messagebuilder.generator.mif2.vocabulary.MifAnnotations;
import ca.infoway.messagebuilder.generator.mif2.vocabulary.MifBasicAnnotation;
import ca.infoway.messagebuilder.generator.mif2.vocabulary.MifCode;
import ca.infoway.messagebuilder.generator.mif2.vocabulary.MifCodeSystem;
import ca.infoway.messagebuilder.generator.mif2.vocabulary.MifCodeSystemConcept;
import ca.infoway.messagebuilder.generator.mif2.vocabulary.MifCodeSystemConceptSupplement;
import ca.infoway.messagebuilder.generator.mif2.vocabulary.MifCodeSystemSupplement;
import ca.infoway.messagebuilder.generator.mif2.vocabulary.MifConceptDomain;
import ca.infoway.messagebuilder.generator.mif2.vocabulary.MifConceptPrintName;
import ca.infoway.messagebuilder.generator.mif2.vocabulary.MifConceptRelationship;
import ca.infoway.messagebuilder.generator.mif2.vocabulary.MifContextBinding;
import ca.infoway.messagebuilder.generator.mif2.vocabulary.MifHttpParagraph;
import ca.infoway.messagebuilder.generator.mif2.vocabulary.MifSpecializedByDomain;
import ca.infoway.messagebuilder.generator.mif2.vocabulary.MifSupplementArtifact;
import ca.infoway.messagebuilder.generator.mif2.vocabulary.MifText;
import ca.infoway.messagebuilder.generator.mif2.vocabulary.MifValueSet;
import ca.infoway.messagebuilder.generator.mif2.vocabulary.MifValueSetCodeBasedContent;
import ca.infoway.messagebuilder.generator.mif2.vocabulary.MifValueSetCombinedContent;
import ca.infoway.messagebuilder.generator.mif2.vocabulary.MifValueSetContent;
import ca.infoway.messagebuilder.generator.mif2.vocabulary.MifValueSetPropertyBasedContent;
import ca.infoway.messagebuilder.generator.mif2.vocabulary.MifValueSetReference;
import ca.infoway.messagebuilder.generator.mif2.vocabulary.MifVocabularyModel;
import ca.infoway.messagebuilder.xml.Annotation;
import ca.infoway.messagebuilder.xml.AnnotationType;
import ca.infoway.messagebuilder.xml.Code;
import ca.infoway.messagebuilder.xml.CodeSystem;
import ca.infoway.messagebuilder.xml.Concept;
import ca.infoway.messagebuilder.xml.ConceptDomain;
import ca.infoway.messagebuilder.xml.ContextBinding;
import ca.infoway.messagebuilder.xml.Documentation;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.ValueSet;
import ca.infoway.messagebuilder.xml.ValueSetFilter;
import ca.infoway.messagebuilder.xml.ValueSetFilterCode;
import ca.infoway.messagebuilder.xml.ValueSetFilterReference;

public class Mif2VocabularyProcessor {

	private Map<String, String> conceptDomainToStrength = new HashMap<String, String>(); 
	
	public String getCodingStrengthForDomain(String conceptDomainName) {
		return this.conceptDomainToStrength.get(conceptDomainName);
	}
	
	public void createVocabularyInformation(MessageSet messageSet,
			List<MifVocabularyModel> vocabularyModels) {

		Map<String,ConceptDomain> conceptDomains = new TreeMap<String,ConceptDomain>();
		Map<String,ValueSet> valueSets = new TreeMap<String,ValueSet>();
		Map<String,List<ContextBinding>> bindings = new HashMap<String,List<ContextBinding>>();
		Map<String,CodeSystem> codeSystems = new TreeMap<String,CodeSystem>();
		Map<String,CodeSystem> codeSystemsByOid = new HashMap<String,CodeSystem>();
		
		// first pass - populate all code systems
		for (MifVocabularyModel mifVocabularyModel : vocabularyModels) {
			processVocabularyCodeSystems(mifVocabularyModel, codeSystems, codeSystemsByOid);
		}

		// Second pass - everything else
		for (MifVocabularyModel mifVocabularyModel : vocabularyModels) {
			
			for (MifCodeSystemSupplement mifCodeSystemSupplement : mifVocabularyModel.getCodeSystemSupplements()) {
				if (mifCodeSystemSupplement.getCodeSystemVersionSupplement() == null || mifCodeSystemSupplement.getCodeSystemVersionSupplement().getConcepts() == null) {
					continue;
				}
				
				CodeSystem targetCodeSystem = codeSystemsByOid.get(mifCodeSystemSupplement.getCodeSystemId());
				if (targetCodeSystem != null && targetCodeSystem.getConcepts() != null && !targetCodeSystem.getConcepts().isEmpty()) {
					for (MifCodeSystemConceptSupplement mifConceptSupplement : mifCodeSystemSupplement.getCodeSystemVersionSupplement().getConcepts()) {
						Concept targetConcept = null;
						for (Concept concept : targetCodeSystem.getConcepts()) {
							if (concept.getCode().equals(mifConceptSupplement.getCode())) {
								targetConcept = concept;
							}
						}
						if (targetConcept != null) {
							populateDocumentation(mifConceptSupplement.getAnnotations(), targetConcept.getDocumentation());
						}
					}
				}
			}
			
			for (MifValueSet mifValueSet : mifVocabularyModel.getValueSets()) {
				ValueSet valueSet = valueSets.get(mifValueSet.getId());
				if (valueSet == null) {
					valueSet = new ValueSet(mifValueSet.getName(), mifValueSet.getId());
					valueSets.put(mifValueSet.getId(), valueSet);
				}
				valueSet.setDate(mifValueSet.getVersion().getDate());
				MifAnnotations annotations = mifValueSet.getAnnotations();
				populateDocumentation(annotations, valueSet.getDocumentation());
				
				if (annotations != null && annotations.getDocumentation() != null) {
					if (annotations.getDocumentation().getOtherAnnotation("owningSCWG") != null) {
						valueSet.setOwningSCWG(annotations.getDocumentation().getOtherAnnotation("owningSCWG"));
					}
				}
				
				determineSourceCodeSystems(mifValueSet.getVersion().getContent(), valueSet, codeSystemsByOid);

				Set<Code> targetCodes = null;
				
				if (mifValueSet.getVersion().hasEnumeratedCodes()) {
					targetCodes = populateValueSetByEnumeration(mifValueSet.getVersion().getEnumeratedCodes(), codeSystemsByOid);
				} else {
					targetCodes = populateValueSetByRule(mifValueSet, codeSystemsByOid);
				}
				
				if (targetCodes != null && !targetCodes.isEmpty()) {
					for (Code code : targetCodes) {
						valueSet.addCode(code);
					}
					valueSet.setComplete(true);
				} else {
					populateExampleCodes(valueSet, mifValueSet.getVersion().getExampleCodes());
					valueSet.setComplete(false);
				}
				populateFilters(valueSet, mifValueSet.getVersion().getContent(), codeSystemsByOid, new HashMap<String,ValueSetFilter>(), null);
				
			}

			for (MifConceptDomain conceptDomain : mifVocabularyModel.getConceptDomains()) {
				if (!conceptDomains.containsKey(conceptDomain.getName())) {
					conceptDomains.put(conceptDomain.getName(), new ConceptDomain(conceptDomain.getName()));
				}
				for (MifSpecializedByDomain specializedByDomain : conceptDomain.getSpecializedByDomains()) {
					if (!conceptDomains.containsKey(specializedByDomain.getName())) {
						conceptDomains.put(specializedByDomain.getName(), new ConceptDomain(specializedByDomain.getName()));
					}
					conceptDomains.get(specializedByDomain.getName()).addParent(conceptDomain.getName());
				}
				populateDocumentation(conceptDomain.getAnnotations(), conceptDomains.get(conceptDomain.getName()).getDocumentation());
			}
			
			for (MifContextBinding binding : mifVocabularyModel.getContextBindings()) {
				if (!bindings.containsKey(binding.getValueSet())) {
					bindings.put(binding.getValueSet(), new ArrayList<ContextBinding>());
				}
				bindings.get(binding.getValueSet()).add(
						new ContextBinding(binding.getConceptDomain(), binding.getBindingRealmName(), binding.getCodingStrength()));
				conceptDomainToStrength.put(binding.getConceptDomain(), binding.getCodingStrength());
			}
			if (mifVocabularyModel.getDependsOnVocabModel() != null) {
				for (MifSupplementArtifact supplementArtifact : mifVocabularyModel.getDependsOnVocabModel().getSupplementArtifacts()) {
					if (supplementArtifact.getSupplementedObject() != null && "conceptDomainRef".equals(supplementArtifact.getSupplementedObject().getName())) {
						if ("VS".equals(supplementArtifact.getSupplementedObject().getParam("subArtifact"))) {
							continue;	// why are there duplicates? what do the subArtifacts mean?
						}
						String conceptDomainName = supplementArtifact.getSupplementedObject().getParam("artifactName");
						ConceptDomain conceptDomain = conceptDomains.get(conceptDomainName);
						if (conceptDomain == null) {
							conceptDomain = new ConceptDomain(conceptDomainName);
							conceptDomains.put(conceptDomainName, conceptDomain);
						}
						
						populateDocumentation(supplementArtifact.getAnnotations(), conceptDomain.getDocumentation());
						if (supplementArtifact.getAnnotations() != null && supplementArtifact.getAnnotations().getDocumentation() != null) {
							if (supplementArtifact.getAnnotations().getDocumentation().getOtherAnnotation("owningSCWG") != null) {
								conceptDomain.setOwningSCWG(supplementArtifact.getAnnotations().getDocumentation().getOtherAnnotation("owningSCWG"));
							}
						}
						
					}
				}
			}
		}
		
		for (ConceptDomain conceptDomain : conceptDomains.values()) {
			messageSet.getVocabulary().getConceptDomains().add(conceptDomain);
		}
		for (Map.Entry<String, List<ContextBinding>> entry : bindings.entrySet()) {
			ValueSet valueSet = valueSets.get(entry.getKey());
			if (valueSet != null) {
				valueSet.getContextBindings().addAll(entry.getValue());
			}
		}
		
		
		messageSet.getVocabulary().getValueSets().addAll(valueSets.values());
		messageSet.getVocabulary().getCodeSystems().addAll(codeSystems.values());
	}

	public void populateFilters(ValueSet valueSet, List<MifValueSetContent> contentList, Map<String, CodeSystem> codeSystemsByOid, Map<String, ValueSetFilter> filters, String parentCodeSystem) {
		for (MifValueSetContent content : contentList) {
			String baseCodeSystem = resolveCodeSystemName(content, codeSystemsByOid);
			if (baseCodeSystem == null) {
				baseCodeSystem = parentCodeSystem;
			}
			
			if (content.getCodeBasedContents() != null && !content.getCodeBasedContents().isEmpty()) {
				ValueSetFilter filter = getFilter(filters, baseCodeSystem, valueSet);
				
				filter.setCodeSystemName(baseCodeSystem);
				for (MifValueSetCodeBasedContent codeBasedContent : content.getCodeBasedContents()) {
					filter.addIncludedCode(new ValueSetFilterCode(codeBasedContent.getCode(), codeBasedContent.isIncludeChildren()));
				}
			} else if (content.getPropertyBasedContents() != null && !content.getPropertyBasedContents().isEmpty()) {
				for (MifValueSetPropertyBasedContent propertyContent : content.getPropertyBasedContents()) {
					ValueSetFilter filter = new ValueSetFilter();
					filter.setCodeSystemName(baseCodeSystem);
					filter.setPropertyName(propertyContent.getConceptProperty().getName());
					filter.setPropertyValue(propertyContent.getConceptProperty().getValue());
					filter.setPropertyIncluded(true);
					valueSet.addFilter(filter);
				}
			} else if (content.getValueSetReferences() != null && !content.getValueSetReferences().isEmpty()) {
				ValueSetFilter filter = new ValueSetFilter();
				for (MifValueSetReference reference : content.getValueSetReferences()) {
					filter.addOtherValueSet(new ValueSetFilterReference(reference.getName()));
				}
				valueSet.addFilter(filter);
			} else if (content.getCombinedContents() != null && !content.getCombinedContents().isEmpty()) {
				for (MifValueSetCombinedContent combinedContent : content.getCombinedContents()) {
					if (combinedContent.getIntersections() != null && !combinedContent.getIntersections().isEmpty()) {
						populateFilters(valueSet, combinedContent.getUnions(), codeSystemsByOid, filters, baseCodeSystem);
						populateFilters(valueSet, combinedContent.getIntersections(), codeSystemsByOid, filters, baseCodeSystem); 
					} else if (combinedContent.getExclusions() != null && !combinedContent.getExclusions().isEmpty()) {
						Map<String, ValueSetFilter> tempMap = new HashMap<String, ValueSetFilter>();
						populateFilters(valueSet, combinedContent.getUnions(), codeSystemsByOid, tempMap, baseCodeSystem);
						if (tempMap.size() > 0) {
							populateExclusions(combinedContent.getExclusions(), tempMap.values().iterator().next());	// assume there's only one
						}
					} else {
						populateFilters(valueSet, combinedContent.getUnions(), codeSystemsByOid, filters, baseCodeSystem);
					}
					
				}
			} else {
				ValueSetFilter filter = new ValueSetFilter();
				filter.setCodeSystemName(baseCodeSystem);
				if (content.getNonComputableContent() != null) {
					filter.setNonComputableContent(content.getNonComputableContent().getText());
				}
				valueSet.addFilter(filter);
			}
		}
	}

	private void populateExampleCodes(ValueSet valueSet, List<MifCode> exampleCodes) {
		if (exampleCodes != null) {
			for (MifCode code : exampleCodes) {
				valueSet.addCode(new Code(code.getCodeSystemName(), code.getCode(), code.getCodePrintName()));
			}
		}
	}
	
	private void populateExclusions(List<MifValueSetContent> exclusions, ValueSetFilter filter) {
		if (exclusions != null) { 
			for (MifValueSetContent content : exclusions) {
				if (content.getCodeBasedContents() != null) { 
					for (MifValueSetCodeBasedContent codeBasedContent : content.getCodeBasedContents()) {
						filter.addExcludedCode(new ValueSetFilterCode(codeBasedContent.getCode(), codeBasedContent.isIncludeChildren()));
					}
				} else if (content.getPropertyBasedContents() != null && content.getPropertyBasedContents().size() > 0) {
					MifValueSetPropertyBasedContent propertyBasedContent = content.getPropertyBasedContents().get(0);	// assume there's only one
					filter.setPropertyName(propertyBasedContent.getConceptProperty().getName());
					filter.setPropertyValue(propertyBasedContent.getConceptProperty().getValue());
					filter.setPropertyIncluded(false);
				}
			}
		}
	}

	public ValueSetFilter getFilter(Map<String, ValueSetFilter> filters,
			String codeSystemName, ValueSet valueSet) {
		ValueSetFilter filter;
		
		if (filters.containsKey(codeSystemName)) {
			filter = filters.get(codeSystemName);
		} else {
			filter = new ValueSetFilter();
			filters.put(codeSystemName, filter);
			valueSet.addFilter(filter);
		}
		return filter;
	}

	private Set<Code> populateValueSetByEnumeration(List<MifCode> enumeratedCodes, Map<String, CodeSystem> codeSystemsByOid) {
		Set<Code> result = new HashSet<Code>();
		for (MifCode code : enumeratedCodes) {
			result.add(new Code(code.getCodeSystemName(), code.getCode(), code.getCodePrintName()));
		}
		return result;
	}

	public Set<Code> populateValueSetByRule(MifValueSet mifValueSet, Map<String, CodeSystem> codeSystemsByOid) {
		Set<Code> result = new HashSet<Code>();
		
		boolean completeCodes = processContent(result, mifValueSet.getVersion().getContent(), codeSystemsByOid);
		
		if (completeCodes) {
			return result;
		} else {
			return null;
		}
	}

	public boolean processContent(Set<Code> result, List<MifValueSetContent> contentList, Map<String, CodeSystem> codeSystemsByOid) {
		return processContent(result, contentList, null, codeSystemsByOid);
	}
	
	public boolean processContent(Set<Code> result, List<MifValueSetContent> contentList, CodeSystem parentCodeSystem, Map<String, CodeSystem> codeSystemsByOid) {
		
		boolean completeCodes = true;
		for (MifValueSetContent content : contentList) {
			CodeSystem targetCodeSystem;
			if (content.getCodeSystem() != null) {
				targetCodeSystem = codeSystemsByOid.get(content.getCodeSystem());
			} else {
				targetCodeSystem = parentCodeSystem;
			}
			
			if (targetCodeSystem != null) {
				if (targetCodeSystem.isComplete() && content.getNonComputableContent() == null) {
					
					Map<String,Concept> conceptMap = new HashMap<String,Concept>();
					Map<String,List<Concept>> conceptDescendantMap = new HashMap<String,List<Concept>>();
					
					populateConceptMaps(targetCodeSystem, conceptMap, conceptDescendantMap);

					if (content.getCodeBasedContents() != null && !content.getCodeBasedContents().isEmpty()) {
						addAllCodeBasedContent(content.getCodeBasedContents(), result, targetCodeSystem, conceptMap, conceptDescendantMap);
					} else if (content.getCombinedContents() != null && !content.getCombinedContents().isEmpty()) {
						addAllCombinedContent(content.getCombinedContents(), result, targetCodeSystem, codeSystemsByOid);
					} else {
						for (Concept concept : conceptMap.values()) {
							grabConcept(result, concept, targetCodeSystem.getName());
						}
					}
				} else {
					completeCodes = false;
				}
			} else if (content.getCombinedContents() != null && !content.getCombinedContents().isEmpty()) {
				addAllCombinedContent(content.getCombinedContents(), result, null, codeSystemsByOid);
			}
		}
		return completeCodes;
	}

	public void addAllCodeBasedContent(List<MifValueSetCodeBasedContent> codeBasedContents, Set<Code> result, CodeSystem targetCodeSystem,
				Map<String, Concept> conceptMap, Map<String, List<Concept>> conceptDescendantMap) {
		for (MifValueSetCodeBasedContent codeBasedContent : codeBasedContents) {
			String targetCode = codeBasedContent.getCode();
			if (!conceptMap.containsKey(targetCode)) {
				continue;
			}
			if (codeBasedContent.isIncludeHeadCode()) {
				grabConcept(result, conceptMap.get(targetCode), targetCodeSystem.getName());
			}
			
			if (codeBasedContent.isIncludeChildren()) {
				boolean recursive = codeBasedContent.getRelatedCode().isRecursive();
				grabChildConcepts(result, targetCode, recursive, targetCodeSystem.getName(), conceptDescendantMap);
			}
		}
	}

	public void addAllCombinedContent(List<MifValueSetCombinedContent> combinedContents, Set<Code> result, CodeSystem targetCodeSystem,
			Map<String, CodeSystem> codeSystemsByOid) {
		for (MifValueSetCombinedContent combinedContent : combinedContents) {
			if (combinedContent.getUnions() != null && !combinedContent.getUnions().isEmpty()) {
				processContent(result, combinedContent.getUnions(), targetCodeSystem, codeSystemsByOid);
			}
		}
	}

	public void populateConceptMaps(CodeSystem codeSystem,
			Map<String, Concept> conceptMap,
			Map<String, List<Concept>> conceptDescendantMap) {
		for (Concept concept : codeSystem.getConcepts()) {
			conceptMap.put(concept.getCode(), concept);
			
			if (concept.getParentConcepts() != null) {
				for (String parentConcept : concept.getParentConcepts()) {
					List<Concept> children = conceptDescendantMap.get(parentConcept);
					if (children == null) {
						children = new ArrayList<Concept>();
						conceptDescendantMap.put(parentConcept, children);
					}
					children.add(concept);
				}
			}
		}
	}

	public void grabConcept(Set<Code> targetCodes, Concept concept,
			String codeSystemName) {
		if (concept.isSelectable()) {
			targetCodes.add(new Code(codeSystemName, concept.getCode()));
		}
	}

	public void grabChildConcepts(Set<Code> result, String targetCode, boolean recursive, String codeSystemName, Map<String, List<Concept>> conceptDescendantMap) {
		List<Concept> children = conceptDescendantMap.get(targetCode);
		if (children == null) {
			return;
		}
		
		for (Concept childConcept : children) {
			grabConcept(result, childConcept, codeSystemName);
			if (recursive) {
				grabChildConcepts(result, childConcept.getCode(), recursive, codeSystemName, conceptDescendantMap);
			}
		}
	}

	public void determineSourceCodeSystems(List<MifValueSetContent> content2, ValueSet valueSet, Map<String, CodeSystem> codeSystemsByOid) {
		for (MifValueSetContent content : content2) {
			valueSet.getSourceCodeSystems().add(resolveCodeSystemName(content,	codeSystemsByOid));
			if (content.getCombinedContents() != null) {
				for (MifValueSetCombinedContent combinedContent : content.getCombinedContents()) {
					if (combinedContent.getUnions() != null) {
						determineSourceCodeSystems(combinedContent.getUnions(), valueSet, codeSystemsByOid);
					}
				}
			}
		}
	}

	public String resolveCodeSystemName(MifValueSetContent codeSystemOid,
			Map<String, CodeSystem> codeSystemsByOid) {
		String sourceCodeSystem = null;
		if (codeSystemOid.getCodeSystem() != null) {
			if (codeSystemsByOid.containsKey(codeSystemOid.getCodeSystem())) {
				sourceCodeSystem = codeSystemsByOid.get(codeSystemOid.getCodeSystem()).getName();
			} else {
				sourceCodeSystem = codeSystemOid.getCodeSystem();
			}
		}
		return sourceCodeSystem;
	}

	public void processVocabularyCodeSystems(MifVocabularyModel mifVocabularyModel, Map<String, CodeSystem> codeSystems, Map<String, CodeSystem> codeSystemsByOid) {
		for (MifCodeSystem mifCodeSystem : mifVocabularyModel.getCodeSystems()) {
			CodeSystem codeSystem = codeSystems.get(mifCodeSystem.getName());
			if (codeSystem == null) {
				codeSystem = new CodeSystem(mifCodeSystem.getName());
				codeSystems.put(mifCodeSystem.getName(), codeSystem);
			}
			
			if (codeSystem.getReleaseDate() != null && codeSystem.getReleaseDate().after(mifCodeSystem.getReleasedVersion().getReleaseDate())) {
				// we have already found and processed a newer version, so don't override it with stale data
				continue;
			}
			
			codeSystem.setReleaseDate(mifCodeSystem.getReleasedVersion().getReleaseDate());
			
			codeSystem.setBusinessName(mifCodeSystem.getTitle());
			codeSystem.setOid(mifCodeSystem.getCodeSystemId());
			codeSystemsByOid.put(mifCodeSystem.getCodeSystemId(), codeSystem);

			populateDocumentation(mifCodeSystem.getAnnotations(), codeSystem.getDocumentation());
			
			if (mifCodeSystem.getHeader() != null) {
				if (mifCodeSystem.getHeader().getResponsibleGroup() != null) {
					codeSystem.getMaintenanceOrganization().setName(mifCodeSystem.getHeader().getResponsibleGroup().getOrganizationName());
				}
				codeSystem.getMaintenanceOrganization().setRepositoryUrl(mifCodeSystem.getHeader().getPrimaryRepository());
			}
			
			codeSystem.setVersionId(mifCodeSystem.getReleasedVersion().getPublisherVersionId());
			
			if (mifCodeSystem.getReleasedVersion().isHl7MaintainedIndicator() && mifCodeSystem.getReleasedVersion().isCompleteCodesIndicator()) {
				codeSystem.setComplete(true);
				if (mifCodeSystem.getReleasedVersion().getConcepts() != null) {
					// adding this null check due to failure parsing an Infoway-provided file. This implies that there is at least one code system which is defined complete yet contains no codes. I'm not sure what to make of that.
					for (MifCodeSystemConcept mifConcept : mifCodeSystem.getReleasedVersion().getConcepts()) {
						
						createConcepts(mifConcept, codeSystem.getConcepts());
					}
				}
			} else if (isInfowayMaintained(mifCodeSystem)) {
				codeSystem.setComplete(true);	// a lie
				if (mifCodeSystem.getReleasedVersion() != null && mifCodeSystem.getReleasedVersion().getConcepts() != null) {	// these Infoway maintained ones are tricksy
					for (MifCodeSystemConcept mifConcept : mifCodeSystem.getReleasedVersion().getConcepts()) {
						createConcepts(mifConcept, codeSystem.getConcepts());
					}
				}
			} else {
				codeSystem.setComplete(false);
			}
		}
	}

	private void createConcepts(MifCodeSystemConcept mifConcept, List<Concept> concepts) {
		for(MifCode mifCode : mifConcept.getCodes()) {
			Concept concept = new Concept();
			
			concept.setCode(mifCode.getCode());
			concept.setSelectable(mifConcept.isSelectable());
			
			if (mifCode.getPrintNames() != null) {
				for(MifConceptPrintName printName : mifCode.getPrintNames()) {
					concept.setDisplayName(printName.getText());
				}
			} else if (mifConcept.getPrintNames() != null) {
				for(MifConceptPrintName printName : mifConcept.getPrintNames()) {
					if (printName.isPreferedEnglishTerm()) {
						concept.setDisplayName(printName.getText());
					}
				}
			}
		
			
			if (mifConcept.getRelationships() != null) {
				for (MifConceptRelationship relationship : mifConcept.getRelationships()) {
					if ("Specializes".equals(relationship.getRelationshipName())) {
						concept.addParentConcept(relationship.getTargetConcept().getCode());
					}
				}
			}
			
			populateDocumentation(mifConcept.getAnnotations(), concept.getDocumentation());
	
			concepts.add(concept);
		}
	}
	
	private boolean isInfowayMaintained(MifCodeSystem mifCodeSystem) {
		return mifCodeSystem.getHeader() != null && mifCodeSystem.getHeader().getResponsibleGroup() != null && "Infoway Standards Collaborative".equals(mifCodeSystem.getHeader().getResponsibleGroup().getOrganizationName());
	}

	public void populateDocumentation(MifAnnotations annotations, Documentation documentation) {
		if (annotations != null && annotations.getDocumentation() != null) {
			if (annotations.getDocumentation().getDefinition() != null) {
				documentation.getAnnotations().add(createAnnotation(AnnotationType.DEFINITION, annotations.getDocumentation().getDefinition().getText()));
			}
			if (annotations.getDocumentation().getDescription() != null) {
				documentation.getAnnotations().add(createAnnotation(AnnotationType.DESCRIPTION, annotations.getDocumentation().getDescription().getText()));
			}
			if (annotations.getDocumentation().getRationale() != null) {
				documentation.getAnnotations().add(createAnnotation(AnnotationType.RATIONALE, annotations.getDocumentation().getRationale().getText()));
			}
			for (MifBasicAnnotation usageNote : annotations.getDocumentation().getUsageNotes()) {
				documentation.getAnnotations().add(createAnnotation(AnnotationType.USAGE_NOTES, usageNote.getText()));
			}
		}
	}

	public Annotation createAnnotation(AnnotationType type, MifText text) {
		Annotation annotation = new Annotation();
		annotation.setAnnotationTypeAsEnum(type);
		String content = "";
		for (MifHttpParagraph paragraph : text.getParagraphs()) {
			content += "<p>" + paragraph.getValue() + "</p>";
		}
		annotation.setText(content);
		return annotation;
	}

}
