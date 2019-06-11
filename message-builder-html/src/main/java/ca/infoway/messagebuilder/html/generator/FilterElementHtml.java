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
package ca.infoway.messagebuilder.html.generator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.hp.gagawa.java.Node;
import com.hp.gagawa.java.elements.Li;
import com.hp.gagawa.java.elements.Ul;

import ca.infoway.messagebuilder.html.generator.util.UrlLinkifier;
import ca.infoway.messagebuilder.xml.AnnotationType;
import ca.infoway.messagebuilder.xml.CodeSystem;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.ValueSet;
import ca.infoway.messagebuilder.xml.ValueSetFilter;
import ca.infoway.messagebuilder.xml.ValueSetFilterCode;
import ca.infoway.messagebuilder.xml.ValueSetFilterReference;

public class FilterElementHtml extends BaseHtmlGenerator {

	private MessageSet messageSet;
	private ValueSet valueSet;
	
	public FilterElementHtml(ValueSet valueSet, MessageSet messageSet) {
		this.valueSet = valueSet;
		this.messageSet = messageSet;
	}
	
	public Node getFilterElement() {
		Ul filterList = new Ul();
		if (getValueSet().getFilters()!=null && getValueSet().getFilters().size() > 0) {
			
			Map<String, List<ValueSetFilter>> filtersByCodeSystem = getFilterMapByCodeSystemName();
			
			for (String codeSystemName : filtersByCodeSystem.keySet()) {
				List<ValueSetFilter> conditionalFilter = new ArrayList<ValueSetFilter>();
				Li filterListItem = new Li();
				CodeSystem codeSystem = getCodeSystemByName(codeSystemName, getMessageSet().getVocabulary());
				String codeSystemDesc = codeSystemName;
				if (codeSystem != null) {
					codeSystemDesc+=" (" + codeSystem.getOid() + ")";
				}
				List<ValueSetFilter> filterListByCodeSystem = filtersByCodeSystem.get(codeSystemName);
				Ul codeSystemFilterList = new Ul();
				
				if (StringUtils.isNotBlank(codeSystemDesc) && filterListByCodeSystem != null 
						&& (filterListHasIncludesOrParameters(filterListByCodeSystem))) {
					filterListItem.appendText("From Code System: " + codeSystemDesc);
					filterListItem.appendChild(codeSystemFilterList);
					filterList.appendChild(filterListItem);
				} 
				
				for (ValueSetFilter valueSetFilter : filterListByCodeSystem) {
					if (StringUtils.isBlank(valueSetFilter.getCodeSystemName()) 
							&& (valueSetFilter.getOtherValueSets() == null 
							|| valueSetFilter.getOtherValueSets().size() == 0)) {
						continue;
					}
					
					if (StringUtils.isBlank(valueSetFilter.getPropertyName()) 
							&& (valueSetFilter.getOtherValueSets() == null || valueSetFilter.getOtherValueSets().size() == 0)
							&& (valueSetFilter.getIncludedCodes() == null || valueSetFilter.getIncludedCodes().size() == 0)) {
						populateFilterForDefault(filterList, valueSetFilter, codeSystem);
					} else if (valueSetFilter.getIncludedCodes() != null) {
						populateFilterListForIncludes(codeSystemFilterList, valueSetFilter, codeSystem);
					} else if (valueSetFilter.getOtherValueSets() != null && valueSetFilter.getOtherValueSets().size() > 0) {
						populateFilterForValueSets(filterList, valueSetFilter);
					} else if (StringUtils.isNotBlank(valueSetFilter.getPropertyName())) {
						conditionalFilter.add(valueSetFilter);
					}
				}
				
				populateConditionalFilter(conditionalFilter, codeSystemFilterList);
			}
		}
		
		return filterList;
	}

	private boolean filterListHasIncludesOrParameters(List<ValueSetFilter> filterListByCodeSystem) {
		for (ValueSetFilter valueSetFilter : filterListByCodeSystem) {
			if ((valueSetFilter.getIncludedCodes() != null && valueSetFilter.getIncludedCodes().size() > 0)
					|| StringUtils.isNotBlank(valueSetFilter.getPropertyName())) {
				return true;
			}
		}
		return false;
	}

	private void populateConditionalFilter(List<ValueSetFilter> conditionalFilter,
			Ul codeSystemFilterList) {
		if (conditionalFilter.size() > 0) {
			Li conditionalFilterListItem = new Li();
			conditionalFilterListItem.appendText("Under condition that code has:");
			int filterCount = 0;
			Set<String> propertyNameSet = new HashSet<String>();
			
			Ul conditionSublist = new Ul();
			conditionalFilterListItem.appendChild(conditionSublist);
			Li conditionSublistItem = new Li();
			conditionSublist.appendChild(conditionSublistItem);
			for (ValueSetFilter valueSetFilter : conditionalFilter) {
				if (filterCount > 0) {
					if (propertyNameSet.contains(valueSetFilter.getPropertyName())) {
						conditionSublistItem.appendText(" OR ");				
					} else {
						Li conditionSublistConjunctionItem = new Li();
						conditionSublistConjunctionItem.appendText("AND");
						conditionSublistConjunctionItem.setCSSClass("no-bullet");
						conditionSublist.appendChild(conditionSublistConjunctionItem);
						
						conditionSublistItem = new Li();
						conditionSublist.appendChild(conditionSublistItem);
					}
				}
				addPropertyToCondition(conditionSublistItem, valueSetFilter);
				propertyNameSet.add(valueSetFilter.getPropertyName());
				filterCount++;
			}
			codeSystemFilterList.appendChild(conditionalFilterListItem);
		}
	}

	public void addPropertyToCondition(Li conditionSublistItem,
			ValueSetFilter valueSetFilter) {
		if (StringUtils.isNotBlank(valueSetFilter.getPropertyValue())) {
			conditionSublistItem.appendText("property: " + valueSetFilter.getPropertyName() + " with value: " + UrlLinkifier.linkify(valueSetFilter.getPropertyValue()));
		} else {
			conditionSublistItem.appendText("property: " + valueSetFilter.getPropertyName());
		}
	}

	private void populateFilterForValueSets(Ul filterList, ValueSetFilter valueSetFilter) {
		for (ValueSetFilterReference valueSetFilterReference : valueSetFilter.getOtherValueSets()) {
			ValueSet filterValueSet = getValueSetByName(valueSetFilterReference.getName(), getMessageSet().getVocabulary());
			String valueSetDesc = "Includes all codes from value set: " + valueSetFilterReference.getName();
			if (filterValueSet != null) {
				valueSetDesc += "(" + filterValueSet.getId() + ")";
			}
			Li filterListItem = new Li();
			filterListItem.appendText(valueSetDesc);
			filterList.appendChild(filterListItem);
		}
	}

	private void populateFilterListForIncludes(Ul filterList, ValueSetFilter valueSetFilter,
			CodeSystem codeSystem) {
		Li filterListItem = null;
		Ul excludeList = null;
		for (ValueSetFilterCode valueSetFilterCode : valueSetFilter.getIncludedCodes()) {
			String codeDesc = "";
			codeDesc = "code of " + valueSetFilterCode.getCode();
			if (valueSetFilterCode.isIncludeChildren()) {
				codeDesc = "code and specializations of " + valueSetFilterCode.getCode();
			}
			filterListItem = new Li();
			filterListItem.appendText("Include " + codeDesc);
			filterList.appendChild(filterListItem);
		}
		if (valueSetFilter.getExcludedCodes() != null
				&& filterListItem != null) {
			excludeList = initializeExcludeList(filterList);
			for (ValueSetFilterCode valueSetFilterCode : valueSetFilter.getExcludedCodes()) {
				String excludeCodeDesc = "code of " + valueSetFilterCode.getCode();
				if (valueSetFilterCode.isIncludeChildren()) {
					excludeCodeDesc = "code and specializations of " + valueSetFilterCode.getCode();
				}
				Li excludeListItem = new Li();
				excludeListItem.appendText(excludeCodeDesc);
				excludeList.appendChild(excludeListItem);							
			}

		}
		if (valueSetFilter.getPropertyName() != null && !valueSetFilter.isPropertyIncluded()) {
			if (excludeList == null) {
				excludeList = initializeExcludeList(filterList);
			}
			Li excludeListItem = new Li();
			if (StringUtils.isNotBlank(valueSetFilter.getPropertyValue())) {
				excludeListItem.appendText("codes having the property: " + valueSetFilter.getPropertyName() + " with value: " + UrlLinkifier.linkify(valueSetFilter.getPropertyValue()));
			} else {
				excludeListItem.appendText("codes having the property: " + valueSetFilter.getPropertyName());
			}
		
			excludeList.appendChild(excludeListItem);							
		}
		if (excludeList != null) {
			Li excludeListWrapperItem = new Li();
			excludeListWrapperItem.appendText("Except:");
			
			excludeListWrapperItem.appendChild(excludeList);
			filterList.appendChild(excludeListWrapperItem);
		}
	}

	public Ul initializeExcludeList(Ul filterList) {
		
		Ul excludeList;
		excludeList = new Ul();
		
		return excludeList;
	}

	private void populateFilterForDefault(Ul filterList, ValueSetFilter valueSetFilter,
			CodeSystem codeSystem) {
		String codeSystemDesc = valueSetFilter.getCodeSystemName();
		if (codeSystemDesc != null) {
			if (codeSystem != null) {
				codeSystemDesc+= " (" + codeSystem.getOid() + ")";
			}
			Li filterListItem = new Li();
			filterListItem.appendText("Include all codes from code system: " + codeSystemDesc);
			filterList.appendChild(filterListItem);
		}
	}

	private Map<String, List<ValueSetFilter>> getFilterMapByCodeSystemName() {
		Map<String, List<ValueSetFilter>> filtersByCodeSystem = new LinkedHashMap<String, List<ValueSetFilter>>();
		for (ValueSetFilter valueSetFilter : getValueSet().getFilters()) {
			String codeSystemName = valueSetFilter.getCodeSystemName();
			if (filtersByCodeSystem.containsKey(codeSystemName)) {
				filtersByCodeSystem.get(valueSetFilter.getCodeSystemName()).add(valueSetFilter);
			} else {
				List<ValueSetFilter> valueSetfilterList = new ArrayList<ValueSetFilter>();
				valueSetfilterList.add(valueSetFilter);
				filtersByCodeSystem.put(valueSetFilter.getCodeSystemName(), valueSetfilterList);
			}
		}
		return filtersByCodeSystem;
	}

	@Override
	public String write() {
		return getFilterElement().write();
	}

	@Override
	public Set<AnnotationType> getExcludeAnnotationFilter() {
		Set<AnnotationType> annotations = new HashSet<AnnotationType>();
		return annotations;
	}

	public MessageSet getMessageSet() {
		return messageSet;
	}

	public void setMessageSet(MessageSet messageSet2) {
		this.messageSet = messageSet2;
	}

	public ValueSet getValueSet() {
		return valueSet;
	}

	public void setValueSet(ValueSet valueSet2) {
		this.valueSet = valueSet2;
	}
	
}
