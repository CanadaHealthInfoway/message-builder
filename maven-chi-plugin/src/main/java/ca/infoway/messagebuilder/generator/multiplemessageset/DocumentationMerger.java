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
			mergeTitle(primary.getTitle(), secondary.getTitle());
			mergeBusinessName(primary.getBusinessName(), secondary.getBusinessName());
			mergeParagrahs(primary.getParagraphs(), secondary.getParagraphs());
		}
		
		return this.result;
	}

	private void mergeParagrahs(List<String> paragraphs, List<String> paragraphs2) {
		// take only 1? combine the two sets of paragraphs?
		if (hasContent(paragraphs)) {
			this.result.getParagraphs().addAll(paragraphs);
		} else if (hasContent(paragraphs2)) {
			this.result.getParagraphs().addAll(paragraphs2);
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

	private void mergeBusinessName(String businessName, String businessName2) {
		String mergedResult = this.mergeHelper.standardMerge(businessName, businessName2);
		this.result.setBusinessName(mergedResult);
	}

	private void mergeTitle(String title, String title2) {
		String mergedResult = this.mergeHelper.standardMerge(title, title2);
		this.result.setTitle(mergedResult);
	}

}
