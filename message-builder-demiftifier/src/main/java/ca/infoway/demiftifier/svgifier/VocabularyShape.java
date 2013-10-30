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

import ca.infoway.demiftifier.ConceptDomainLayoutItem;
import ca.infoway.demiftifier.VocabularyLayoutItem;
import ca.infoway.messagebuilder.xml.DomainSource;

abstract class VocabularyShape extends Shape {
	
	public VocabularyShape(VocabularyLayoutItem item, StyleProvider styleProvider) {
		super(item, styleProvider);
	}
	public VocabularyShape(ConceptDomainLayoutItem item, StyleProvider styleProvider) {
		super(item, styleProvider);
	}
	
	void renderGroup(CoordinateSpace mapper, Writer writer) throws IOException {
		writer.write("<g");
		if (!getItem().isDuplicate()) {
			writer.write(" id=\"");
			writer.write(this.item.getName().replace('.', '-'));
			writer.write("\"");
			writer.write(" chi:name=\"");
			writer.write(this.item.getName());
			writer.write("\" class=\"demiftifier-vocab-part ");

			// TM - RM 17477 - further define css class by vocab type (when applicable) 
			if (getItem() instanceof VocabularyLayoutItem) {			
				VocabularyLayoutItem vocabLayoutItem = (VocabularyLayoutItem) getItem();
				DomainSource vocabType = vocabLayoutItem.getVocabType();
				if (DomainSource.CODE_SYSTEM.equals(vocabType)) {
					writer.write(" demiftifier-vocab-type-code-system ");
				} else if (DomainSource.VALUE_SET.equals(vocabType)) {
					writer.write(" demiftifier-vocab-type-value-set ");
				} else if (DomainSource.CONCEPT_DOMAIN.equals(vocabType)) {
					writer.write(" demiftifier-vocab-type-concept-domain ");
				}
			}
			
			writer.write("\" ");
		}
		writer.write(">");
		render(mapper, writer);
		writer.write("</g>");
	}

	@Override
	public void render(CoordinateSpace mapper, Writer writer) throws IOException {
		super.render(mapper, writer);
		BoundingBox box = mapper.getCoordinates(this.item);
		renderAnnotations(box, writer);
	}
	
	protected void renderAnnotations(BoundingBox box, Writer writer) throws IOException {
		if (!getItem().isDuplicate()) {
			box = box.translateBy(getRightDisplacementToAccountForIncomingArrowShape(), 0);
		}
	}
	
	public BoundingBox getBounds() {
		BoundingBox basicBox = super.getBounds().getUnpaddedBounds();
		
		int height = basicBox.getHeight();
		int width = basicBox.getWidth();
		
		if (!getItem().isDuplicate()) {
			height += TEXT_AREA_PADDING_BOTTOM;
		}
		
		return new BoundingBox(0, 0, height, width).withPadding(getMargins());
	};
}
