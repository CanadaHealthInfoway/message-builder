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
package ca.infoway.demiftifier.svgifier;

import ca.infoway.demiftifier.ConceptDomainLayoutItem;
import ca.infoway.demiftifier.VocabularyLayoutItem;

public class VocabBoxShape extends VocabularyShape {

	public VocabBoxShape(VocabularyLayoutItem item, StyleProvider styleProvider) {
		super(item, styleProvider);
	}

	public VocabBoxShape(ConceptDomainLayoutItem item, StyleProvider styleProvider) {
		super(item, styleProvider);
	}

	
	@Override
	protected Padding getMargins() {
		if (this.item.isRootType()) {
			return Padding.padAllSides(1);
		} else {
			return super.getMargins();
		}
	}
	
	@Override
	protected Fill getFillColor() {
		Fill fillColor = super.getFillColor();
		return (fillColor instanceof ColorFill) && this.item.isDuplicate() ? ((ColorFill) fillColor).makeGrey() : fillColor;
	}
	
	@Override
	protected void initializeLabels() {
		if (this.labels.isEmpty()) {
			VocabularyLayoutItem vocabItem = null;
			if(getItem() instanceof VocabularyLayoutItem) {
				vocabItem = (VocabularyLayoutItem)getItem();
			}
			
			FormattedString labelString = new FormattedString();
			labelString.addSegment(getItem().getLabel(), this.styleProvider.getDefaultBoldTextFont());
			this.styleProvider.assignTextBounds(labelString, null);
			this.labels.add(labelString);
		
			if (vocabItem != null) {
				FormattedString codeString = new FormattedString();
				codeString.addSegment(vocabItem.getSubLabel(), this.styleProvider.getDefaultNonProportionalTextFont());
				this.styleProvider.assignTextBounds(codeString, null);
				this.labels.add(codeString);			
			}
		}		
	}
}
