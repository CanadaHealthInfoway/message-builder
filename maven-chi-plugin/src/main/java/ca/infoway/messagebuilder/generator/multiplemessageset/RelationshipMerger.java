package ca.infoway.messagebuilder.generator.multiplemessageset;

import java.util.List;

import org.apache.commons.lang.StringUtils;

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
		if (!StringUtils.equals(domainType, domainType2)) {
			this.mergeHelper.addDifference(this.context, this.result, "domainType", domainType, domainType2);
			this.context.logError(this.context.getCurrentMessagePart() + " - domain types are different: " + domainType + ", " + domainType2);
		}
		String mergedDomainType = this.mergeHelper.standardMerge(domainType, domainType2);
		this.result.setDomainType(mergedDomainType);
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
			this.mergeHelper.addDifference(this.context, this.result, "templateParameterName", templateParameterName, templateParameterName2);
			this.context.logError(this.context.getCurrentMessagePart() + " - templateParameterNames are different: " + templateParameterName + ", " + templateParameterName2);
		}
		String mergedTemplateParameterName = this.mergeHelper.standardMerge(templateParameterName, templateParameterName2);
		this.result.setTemplateParameterName(mergedTemplateParameterName);
	}

	private void mergeType(String type, String type2) {
		if (!StringUtils.equals(type, type2)) {
			this.mergeHelper.addDifference(this.context, this.result, "type", type, type2);
			this.context.logError(this.context.getCurrentMessagePart() + " - types are different: " + type + ", " + type2);
		}
		String mergedType = this.mergeHelper.standardMerge(type, type2);
		this.result.setType(mergedType);
	}

}
