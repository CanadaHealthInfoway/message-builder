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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.generator.multiplemessageset;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.xml.Annotation;
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
			mergeParagrahs(primary.getAnnotations(), secondary.getAnnotations());
		}
		
		return this.result;
	}

	private void mergeParagrahs(List<Annotation> list, List<Annotation> list2) {
		// take only 1? combine the two sets of paragraphs?
		if (hasContent(list)) {
			this.result.getAnnotations().addAll(list);
		} else if (hasContent(list2)) {
			this.result.getAnnotations().addAll(list2);
		}
	}

	private boolean hasContent(List<Annotation> paragraphs) {
		boolean result = false;
		if (!CollectionUtils.isEmpty(paragraphs)) {
			for (Annotation annotation : paragraphs) {
				if (StringUtils.isNotBlank(annotation.getText())) {
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
