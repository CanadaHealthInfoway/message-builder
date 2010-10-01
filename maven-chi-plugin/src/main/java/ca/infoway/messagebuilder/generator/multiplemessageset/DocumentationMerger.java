package ca.infoway.messagebuilder.generator.multiplemessageset;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.xml.Documentation;

class DocumentationMerger implements Merger<Documentation> {

	private final MessageSetMergeHelper mergeHelper;
	private final MergeContext context;
	private Documentation result;

	DocumentationMerger(MergeContext context) {
		this.context = context;
		this.mergeHelper = new MessageSetMergeHelper();
	}

	public Documentation merge(Documentation primary, Documentation secondary) {
		if (primary == null || secondary == null) {
			this.result = (secondary == null ? primary : secondary);
		} else {
			this.result = new Documentation();
			mergeTitle(result, primary.getTitle(), secondary.getTitle());
			mergeBusinessName(result, primary.getBusinessName(), secondary.getBusinessName());
			mergeParagrahs(result, primary.getParagraphs(), secondary.getParagraphs());
		}
		
		return result;
	}

	private void mergeParagrahs(Documentation result, List<String> paragraphs, List<String> paragraphs2) {
		// take only 1? combine the two sets of paragraphs?
		if (hasContent(paragraphs)) {
			result.getParagraphs().addAll(paragraphs);
		} else if (hasContent(paragraphs2)) {
			result.getParagraphs().addAll(paragraphs2);
		}
	}

	private boolean hasContent(List<String> paragraphs) {
		boolean result = false;
		if (!CollectionUtils.isEmpty(paragraphs)) {
			for (String string : paragraphs) {
				if (StringUtils.isNotBlank(string)) {
					result = true;
					break;
				}
			}
		}
		return result;
	}

	private void mergeBusinessName(Documentation result, String businessName, String businessName2) {
		String mergedResult = this.mergeHelper.standardMerge(businessName, businessName2);
		result.setBusinessName(mergedResult);
	}

	private void mergeTitle(Documentation result, String title, String title2) {
		String mergedResult = this.mergeHelper.standardMerge(title, title2);
		result.setTitle(mergedResult);
	}

}
