package ca.infoway.messagebuilder.generator.multiplemessageset;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.generator.util.DomainRegistry;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.CodingStrength;
import ca.infoway.messagebuilder.xml.ConformanceLevel;
import ca.infoway.messagebuilder.xml.Documentation;
import ca.infoway.messagebuilder.xml.Relationship;

class RelationshipMerger implements Merger<Relationship> {

	private final MergeContext context;
	private final DocumentationMerger documentationMerger;
	private final MessageSetMergeHelper mergeHelper;
	private Relationship result;

	RelationshipMerger(MergeContext context) {
		this(context, new DocumentationMerger(context));
	}

	RelationshipMerger(MergeContext context, DocumentationMerger documentationMerger) {
		this.context = context;
		this.documentationMerger = documentationMerger;
		this.mergeHelper = new MessageSetMergeHelper();
	}

	public Relationship merge(Relationship primary, Relationship secondary) {
		
		if (primary == null || secondary == null) {
			this.result = (primary == null ? secondary : primary);
		} else {
			this.result = new Relationship();
			mergeCardinality(primary.getCardinality(), secondary.getCardinality());
			mergeChoices(primary.getChoices(), secondary.getChoices());
			mergeCodingStrength(primary.getCodingStrength(), secondary.getCodingStrength());
			mergeConformance(primary.getConformance(), secondary.getConformance());
			mergeDefaultValue(primary.getDefaultValue(), secondary.getDefaultValue());
			mergeDocumentation(primary.getDocumentation(), secondary.getDocumentation());
			mergeDomainType(primary.getDomainType(), secondary.getDomainType());
			mergeFixedValue(primary.getFixedValue(), secondary.getFixedValue());
			mergeLength(primary.getLength(), secondary.getLength());
			mergeName(primary.getName(), secondary.getName());
			mergeSortOrder(primary.getSortOrder(), secondary.getSortOrder());
			mergeTemplateParameterName(primary.getTemplateParameterName(), secondary.getTemplateParameterName());
			mergeType(primary.getType(), secondary.getType());
		}
		
		return result;
	}

	private void mergeCardinality(Cardinality cardinality, Cardinality cardinality2) {
		if (cardinality.isMultiple()) {
			this.result.setCardinality(cardinality);
		} else if (cardinality2.isMultiple()) {
			this.result.setCardinality(cardinality2);
		}
	}

	private void mergeChoices(List<Relationship> choices, List<Relationship> choices2) {
		// FIXME - TM - implement in a later story
		this.result.getChoices().addAll(choices);
	}

	private void mergeCodingStrength(CodingStrength codingStrength, CodingStrength codingStrength2) {
		CodingStrength mergedCodingStrength = (CodingStrength) this.mergeHelper.standardMerge(codingStrength, codingStrength2);
		this.result.setCodingStrength(mergedCodingStrength);
	}

	private void mergeConformance(ConformanceLevel conformance,	ConformanceLevel conformance2) {
		if (conformance.isMorePermissive(conformance2)) {
			this.result.setConformance(conformance);
		} else {
			this.result.setConformance(conformance2);
		}
	}

	private void mergeDefaultValue(String defaultValue, String defaultValue2) {
		String mergedDefaultValue = this.mergeHelper.standardMerge(defaultValue, defaultValue2);
		this.result.setDefaultValue(mergedDefaultValue);
	}

	private void mergeDocumentation(Documentation documentation, Documentation documentation2) {
		Documentation mergedDoc = this.documentationMerger.merge(documentation, documentation2);
		this.result.setDocumentation(mergedDoc);
	}

	private void mergeDomainType(String domainType, String domainType2) {
		String resultDomainType = domainType;
		if (domainType == null || domainType2 == null) {
			resultDomainType = this.mergeHelper.standardMerge(domainType, domainType2);
			if (resultDomainType != null) {
				this.mergeHelper.addDifference(this.context, this.result, "rel domainType only on one", domainType, domainType2);
			}
		} else if (!StringUtils.equals(domainType, domainType2)) {
			resultDomainType = findCompatibleDomainType(domainType, domainType2);
			if (resultDomainType == null) {
				resultDomainType = domainType;
			}
		}
		this.result.setDomainType(resultDomainType);
	}

	private String findCompatibleDomainType(String domainType, String domainType2) {
		Class<?> type = DomainRegistry.getInstance().getDomainType(domainType);
		Class<?> type2 = DomainRegistry.getInstance().getDomainType(domainType2);
		if (type == null || type2 == null) {
			this.mergeHelper.addDifference(this.context, this.result, "rel domainType(s) not found in system: " + (type == null ? domainType : "") + (type2 == null ? domainType2 : ""), domainType, domainType2);
			return null;
		} else if (type.isAssignableFrom(type2)) {
			this.context.logInfo("Merged domain type to a compatible type: " + domainType + "/" + domainType2 + " to " + domainType);
			return domainType;
		} else if (type2.isAssignableFrom(type)) {
			this.context.logInfo("Merged domain type to a compatible type: " + domainType + "/" + domainType2 + " to " + domainType2);
			return domainType2;
		} else {
			List<Class<?>> interfaces = getAllInterfaces(type);
			List<Class<?>> interfaces2 = getAllInterfaces(type2);
			for (Class<?> clazz : interfaces) {
				if (interfaces2.contains(clazz)) {
					this.context.logInfo("Found compatible domain type: " + domainType + "/" + domainType2 + " to " + clazz.getSimpleName());
					return clazz.getSimpleName();
				}
			}
			this.mergeHelper.addDifference(this.context, this.result, "rel domainTypes incompatible", domainType, domainType2);
			return null;
		}
	}

	private List<Class<?>> getAllInterfaces(Class<?> type) {
		// simplification - assume each level only has 1 (or 0) extended interfaces
		Class<?>[] interfaces = type.getInterfaces();
		if (interfaces.length > 0) {
			if (interfaces.length > 1) {
				this.context.logError("Domain type has more than one interface: " + type.getName());
			}
			List<Class<?>> result = getAllInterfaces(interfaces[0]);
			if (!Code.class.equals(interfaces[0])) {
				result.add(0, interfaces[0]);
			}
			return result;
		} else {
			return new ArrayList<Class<?>>();
		}
	}

	private void mergeFixedValue(String fixedValue, String fixedValue2) {
		String mergedFixedValue = this.mergeHelper.standardMerge(fixedValue, fixedValue2);
		this.result.setFixedValue(mergedFixedValue);
	}

	private void mergeLength(Integer length, Integer length2) {
		Integer mergedLength = (Integer) this.mergeHelper.standardMerge(length, length2);
		this.result.setLength(mergedLength);
	}

	private void mergeName(String name, String name2) {
		// should never be different at this point
		if (!StringUtils.equals(name, name2)) {
			this.context.logError(this.context.getCurrentMessagePart() + " - relationship names should not be different: " + name + ", " + name2);
		}
		this.result.setName(name);
	}

	private void mergeSortOrder(int sortOrder, int sortOrder2) {
		int mergedSortOrder = (Integer) this.mergeHelper.standardMerge(sortOrder, sortOrder2);
		this.result.setSortOrder(mergedSortOrder);
	}

	private void mergeTemplateParameterName(String templateParameterName, String templateParameterName2) {
		if (!StringUtils.equals(templateParameterName, templateParameterName2)) {
			this.mergeHelper.addDifference(this.context, this.result, "rel templateParameterName", templateParameterName, templateParameterName2);
		}
		String mergedTemplateParameterName = this.mergeHelper.standardMerge(templateParameterName, templateParameterName2);
		this.result.setTemplateParameterName(mergedTemplateParameterName);
	}

	private void mergeType(String type, String type2) {
		if (!StringUtils.equals(type, type2)) {
			this.mergeHelper.addDifference(this.context, this.result, "rel type", type, type2);
		}
		String mergedType = this.mergeHelper.standardMerge(type, type2);
		this.result.setType(mergedType);
	}

}
