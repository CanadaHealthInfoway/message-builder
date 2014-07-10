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

import java.awt.Color;

import ca.infoway.demiftifier.AnnotationItem;
import ca.infoway.messagebuilder.xml.AnnotationType;

class AnnotationShape extends BasicShape {

	protected AnnotationItem annotation;

	AnnotationShape(AnnotationItem annotation, StyleProvider styleProvider) {
		super(styleProvider);
		this.annotation = annotation;
	}
	
	@Override
	protected void initializeLabels() {
		createTitle();

		int alphabetWidth = this.styleProvider.getTextWidth("abcdefghijklmnopqrstuvwxyz", this.styleProvider.getDefaultAttributeTextFont());
		
		FormattedString text = FormattedStringUtil.formatHtmlAndFitToSpace(
				this.annotation.getAnnotation().getText(), this.styleProvider,
				alphabetWidth * 2, null, 0);
		this.labels.add(text);
	}

	protected void createTitle() {
		FormattedString title = new FormattedString();
		if (isNote()) {
			title.addSegment("Note", this.styleProvider.getDefaultBoldTextFont());
		} else {
			title.addSegment("Constraint", this.styleProvider.getDefaultBoldTextFont());
		}
		this.styleProvider.assignTextBounds(title);
		this.labels.add(title);
	}

	private boolean isNote() {
		return this.annotation.getAnnotation().getAnnotationTypeAsEnum() == AnnotationType.DEFINITION;
	}
	
	@Override
	protected Fill getFillColor() {
		if (isNote()) {
			return super.getFillColor();
		} else {
			return new ColorFill(new Color(0xdd, 0xdd, 0xdd));
		}
	}
}
