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

import java.io.IOException;
import java.io.Writer;

import ca.infoway.demiftifier.VocabularyLayoutItem;
import ca.infoway.messagebuilder.xml.DomainSource;

class VocabularyTextShape extends BasicShape {

	private static final int TEXT_PADDING_RIGHT = 3;
	private static final int TEXT_PADDING_BOTTOM = 3;

	private VocabularyLayoutItem vocabularyItem;
	
	public VocabularyTextShape(VocabularyLayoutItem vocabularyItem, StyleProvider styleProvider){
		super(styleProvider);
		this.vocabularyItem = vocabularyItem;
	}
	
	@Override
	public void render(BoundingBox box, Writer writer) throws IOException {
		super.render(box, writer);
	}
	
	@Override
	protected void renderOutline(BoundingBox box, Writer writer) throws IOException {
		//No opp
	}
	
	@Override
	protected void writeStyle(Writer writer) throws IOException {
		//No opp
	}

	@Override
	protected void initializeLabels() {
		if (this.labels.isEmpty()) {
			FormattedString vocabString = new FormattedString();
			if (this.vocabularyItem.getInboundElement() != null){
				String text = "";
				if (DomainSource.VALUE_SET.equals(this.vocabularyItem.getInboundElement().getVocabType())) {
					text = "bound to...";
				} else if (DomainSource.CODE_SYSTEM.equals(this.vocabularyItem.getInboundElement().getVocabType())) {
					text= "draws from...";
				} else {
					text= "no idea...";
				}
				vocabString.addSegment(text, this.styleProvider.getCardinalityTextFont());
			}
			this.styleProvider.assignTextBounds(vocabString, new Padding(0, TEXT_PADDING_RIGHT, TEXT_PADDING_BOTTOM, 0));
			this.labels.add(vocabString);
		}
	}
}
