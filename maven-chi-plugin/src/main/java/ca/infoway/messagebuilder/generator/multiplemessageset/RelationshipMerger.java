package ca.infoway.messagebuilder.generator.multiplemessageset;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.generator.util.DomainRegistry;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7DataTypeName;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ElementParser;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParserRegistry;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.CodingStrength;
import ca.infoway.messagebuilder.xml.ConformanceLevel;
import ca.infoway.messagebuilder.xml.DifferenceType;
import ca.infoway.messagebuilder.xml.Documentation;
import ca.infoway.messagebuilder.xml.DomainSource;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.UpdateMode;

class RelationshipMerger implements Merger<Relationship> {

	private final MergeContext context;
	private final DocumentationMerger documentationMerger;
	private final RelationshipsMerger choicesMerger;
	private final MessageSetMergeHelper mergeHelper;
	private Relationship result;

	RelationshipMerger(MergeContext context) {
		this(context, new RelationshipsMerger(context, true), new DocumentationMerger(context));
	}

	RelationshipMerger(MergeContext context, RelationshipsMerger relationshipsMerger, DocumentationMerger documentationMerger) {
		this.context = context;
		this.choicesMerger = relationshipsMerger;
		this.documentationMerger = documentationMerger;
		this.mergeHelper = new MessageSetMergeHelper();
	}

	public Relationship merge(Relationship primary, Relationship secondary) {
		
		if (primary == null || secondary == null) {
			this.result = (primary == null ? secondary : primary);
			if (this.result != null) {
				this.mergeHelper.addMissingDifference(this.context, this.result, secondary == null);
			}
		} else {
			this.result = new Relationship();
			mergeCardinality(primary.getCardinality(), secondary.getCardinality());
			mergeChoices(primary.getChoices(), secondary.getChoices());
			mergeCodingStrength(primary.getCodingStrength(), secondary.getCodingStrength());
			mergeDomainSource(primary.getDomainSource(), secondary.getDomainSource());
			mergeMnemonic(primary.getMnemonic(), secondary.getMnemonic());
			mergeConformance(primary.getConformance(), secondary.getConformance());
			mergeUpdateMode(primary.getUpdateMode(), secondary.getUpdateMode());
			mergeDefaultValue(primary.getDefaultValue(), secondary.getDefaultValue());
			mergeDocumentation(primary.getDocumentation(), secondary.getDocumentation());
			mergeDomainType(primary.getDomainType(), secondary.getDomainType());
			mergeFixedValue(primary.getFixedValue(), secondary.getFixedValue());
			mergeLength(primary.getLength(), secondary.getLength());
			mergeName(primary.getName(), secondary.getName());
			mergeSortOrder(primary.getSortOrder(), secondary.getSortOrder());
			mergeTemplateParameterName(primary.getTemplateParameterName(), secondary.getTemplateParameterName());
			mergeType(primary, secondary);
		}
		
		return result;
	}

	private void mergeUpdateMode(UpdateMode updateMode, UpdateMode updateMode2) {
		UpdateMode mergedDefaultValue = (UpdateMode) this.mergeHelper.standardMerge(updateMode, updateMode2);
		this.result.setUpdateMode(mergedDefaultValue);
	}

	private void mergeDomainSource(DomainSource domainSource, DomainSource domainSource2) {
		DomainSource mergedDefaultValue = (DomainSource) this.mergeHelper.standardMerge(domainSource, domainSource);
		this.result.setDomainSource(mergedDefaultValue);
	}
	
	private void mergeMnemonic(String mnemonic, String mnemonic2) {
		String mergedDefaultValue = (String) this.mergeHelper.standardMerge(mnemonic, mnemonic);
		this.result.setMnemonic(mergedDefaultValue);
	}

	private void mergeCardinality(Cardinality cardinality, Cardinality cardinality2) {
		if (cardinality2.isMultiple() && !cardinality.isMultiple()) {
			this.result.setCardinality(cardinality2);
		} else {
			this.result.setCardinality(cardinality);
		}
	}

	// TODO - TM - perhaps log some differences here when appropriate? 
	private void mergeChoices(List<Relationship> choices, List<Relationship> choices2) {
		List<Relationship> mergedChoices = this.choicesMerger.merge(choices, choices2);
		
		if (mergedChoices.size() != choices.size() || mergedChoices.size() != choices2.size()) {
			this.context.logInfo(this.context.getCurrentMessagePart() + "has mismatching choices");
		}
		
		this.result.getChoices().addAll(mergedChoices);
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
				this.mergeHelper.addDifference(this.context, this.result, DifferenceType.RELATIONSHIP_ONLY_ONE_HAS_DOMAIN_TYPE, domainType, domainType2);
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
			this.mergeHelper.addDifference(this.context, this.result, DifferenceType.RELATIONSHIP_ONE_OR_BOTH_DOMAIN_TYPES_NOT_IN_SYSTEM, domainType, domainType2);
			return Code.class.getSimpleName();
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
			// register the difference, but go with the generic Code type
			this.mergeHelper.addDifference(this.context, this.result, DifferenceType.RELATIONSHIP_DOMAIN_TYPES_INCOMPATIBLE, domainType, domainType2);
			return Code.class.getSimpleName();
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
		// should never be different at this point UNLESS we matched relationships based on identical association types
		if (!StringUtils.equals(name, name2)) {
			this.mergeHelper.addDifference(this.context, this.result, DifferenceType.RELATIONSHIP_RENAMED, name, name2);
		}
		this.result.setName(name);
	}

	private void mergeSortOrder(int sortOrder, int sortOrder2) {
		int mergedSortOrder = (Integer) this.mergeHelper.standardMerge(sortOrder, sortOrder2);
		this.result.setSortOrder(mergedSortOrder);
	}

	private void mergeTemplateParameterName(String templateParameterName, String templateParameterName2) {
		if (!StringUtils.equals(templateParameterName, templateParameterName2)) {
			this.mergeHelper.addDifference(this.context, this.result, DifferenceType.RELATIONSHIP_TEMPLATE_PARAMETER_NAME, templateParameterName, templateParameterName2);
		}
		String mergedTemplateParameterName = this.mergeHelper.standardMerge(templateParameterName, templateParameterName2);
		this.result.setTemplateParameterName(mergedTemplateParameterName);
	}

	private void mergeType(Relationship primary, Relationship secondary) {
		String type = primary.getType();
		String type2 = secondary.getType();
		String mergedType = this.mergeHelper.standardMerge(type, type2);
		if (!StringUtils.equals(type, type2)) {
			String compatibleType = getCompatibleType(type, type2);
			if (compatibleType != null) {
				this.context.logInfo("Determined these different types were compatible: " + type + "/" + type2 + " [" + compatibleType + "]");
				mergedType = compatibleType;
			} else {
				boolean isAttribute = primary.isAttribute() || secondary.isAttribute();
				DifferenceType differenceType = (isAttribute ? DifferenceType.ATTRIBUTE_TYPE : DifferenceType.ASSOCIATION_TYPE);
				this.mergeHelper.addDifference(this.context, this.result, differenceType, type, type2);
				
				if (!isAttribute && (primary.isChoice() != secondary.isChoice())) {
					this.mergeHelper.addDifference(this.context, this.result, DifferenceType.MESSAGE_PART_ABSTRACT, type, type2);
				}
			}
		}
		this.result.setType(mergedType);
	}

	private String getCompatibleType(String type, String type2) {
		String result = null;
		ElementParser elementParser1 = ParserRegistry.getInstance().get(type);
		ElementParser elementParser2 = ParserRegistry.getInstance().get(type2);
		if (elementParser1 != null && elementParser2 != null) {
			// first check to see if the types are straight-up compatible 
			if (elementParser1.equals(elementParser2)) {
				result = type;
			} else if (StandardDataType.isSetOrList(type) || StandardDataType.isSetOrList(type2)) {
				// check if one is a list or a set, but otherwise compatible
				result = checkCollectionCompatibility(type, type2);
			} else if (StandardDataType.getByTypeName(type).isCoded() && StandardDataType.getByTypeName(type2).isCoded()) {
				result = StandardDataType.CV.getType();
			} else if (isInterval(type) || isInterval(type2)) {
				result = checkIntervalCompatibility(type, type2);
			}
		}
		return result;
	}

	private String checkCollectionCompatibility(String type, String type2) {
		String parameterizedType1 = Hl7DataTypeName.getParameterizedType(type);
		if (StringUtils.isBlank(parameterizedType1)) {
			parameterizedType1 = type;
		}
		String parameterizedType2 = Hl7DataTypeName.getParameterizedType(type2);
		if (StringUtils.isBlank(parameterizedType2)) {
			parameterizedType2 = type2;
		}
		ElementParser elementParser1 = ParserRegistry.getInstance().get(parameterizedType1);
		ElementParser elementParser2 = ParserRegistry.getInstance().get(parameterizedType2);
		String result = null;
		if (elementParser1 != null && elementParser2 != null && elementParser1.equals(elementParser2)) {
			result = StandardDataType.isSetOrList(type) ? type : type2;
			this.context.logInfo("Determined compatible types when one (or both) was a collection: " + type + "/" + type2 + " [" + result + "]");
		}
		return result;
	}

	private String checkIntervalCompatibility(String type, String type2) {
		String parameterizedType1 = isInterval(type) ? Hl7DataTypeName.getParameterizedType(type) : type;
		if (StringUtils.isBlank(parameterizedType1)) {
			parameterizedType1 = type;
		}
		String parameterizedType2 = isInterval(type2) ? Hl7DataTypeName.getParameterizedType(type2) : type2;
		if (StringUtils.isBlank(parameterizedType2)) {
			parameterizedType2 = type2;
		}
		ElementParser elementParser1 = ParserRegistry.getInstance().get(parameterizedType1);
		ElementParser elementParser2 = ParserRegistry.getInstance().get(parameterizedType2);
		String result = null;
		if (elementParser1 != null && elementParser2 != null && elementParser1.equals(elementParser2)) {
			result = isInterval(type) ? type : type2;
			this.context.logInfo("Determined compatible types when one (or both) was an interval: " + type + "/" + type2 + " [" + result + "]");
		}
		return result;
	}

	private boolean isInterval(String type) {
		return type.startsWith("IVL");
	}

}
