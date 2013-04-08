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
import java.io.IOException;
import java.io.Writer;

import org.apache.commons.lang.StringUtils;

import ca.infoway.demiftifier.EntryPointLayoutItem;
import ca.infoway.messagebuilder.xml.Annotation;
import ca.infoway.messagebuilder.xml.AnnotationType;
import ca.infoway.messagebuilder.xml.Documentation;

public class EntryPointShape extends Shape {
	
	private static int ARROW_HEIGHT = 50;

	public EntryPointShape(EntryPointLayoutItem item, StyleProvider styleProvider) {
		super(item, styleProvider);
	}

	@Override
	protected Fill getFillColor() {
		return new ColorFill(Color.WHITE);
	}
	
	@Override
	protected int getStrokeWeight() {
		return 2;
	}

	void renderGroup(CoordinateSpace mapper, Writer writer) throws IOException {
		writer.write("<g");
		if (!getItem().isDuplicate()) {
			writer.write(" id=\"");
			writer.write(getItem().getPackageLocation().getName());
			writer.write("\"");
		}
		writer.write(">");
		render(mapper, writer);
		writer.write("</g>");
	}

	@Override
	public void render(CoordinateSpace mapper, Writer writer) throws IOException {
		BoundingBox box = mapper.getCoordinates(this.item);
		BoundingBox minimum = getBounds();
		
		int extraSpace = (box.getWidth() - minimum.getWidth()) / 2; 
		BoundingBox revised = new BoundingBox(box.getX() + extraSpace, box.getY(), minimum.getHeight() - ARROW_HEIGHT, minimum.getWidth()); 
		ArrowShape shape = new ArrowShape(new PositionImpl(box.getX() + (box.getWidth() / 2), box.getY() + box.getHeight() - ARROW_HEIGHT), 
				new PositionImpl(box.getX() + (box.getWidth() / 2), box.getY() + box.getHeight()), Orientation.DOWN);
		shape.write(writer);
		render(revised, writer);
	}
	
	@Override
	protected void initializeLabels() {
		if (this.labels.isEmpty()) {
			
			FormattedString nameString = new FormattedString();
			nameString.addSegment(getItem().getPackageLocation().getDescriptiveName(), this.styleProvider.getDefaultBoldTextFont());
			BoundingBox nameBounds = this.styleProvider.assignTextBounds(nameString, null);
			this.labels.add(nameString);
		
			FormattedString codeString = new FormattedString();
			codeString.addSegment("[" + getItem().getPackageLocation().getName() + "]", this.styleProvider.getDefaultNonProportionalTextFont());
			BoundingBox codeBounds = this.styleProvider.assignTextBounds(codeString, null);
			this.labels.add(codeString);
			
			Documentation documentation = getItem().getPackageLocation().getDocumentation();
			if (documentation != null) {
				String description = null;
				for (Annotation annotation : documentation.getAnnotations()) {
					if (annotation.getAnnotationTypeAsEnum() == AnnotationType.DESCRIPTION) {
						description = annotation.getText();
						break;
					}
				}
				
				if (StringUtils.isNotBlank(description)) {
					int alphabetWidth = this.styleProvider.getTextWidth("abcdefghijklmnopqrstuvwxyz", this.styleProvider.getDefaultAttributeTextFont());
					int maxWidth = Math.max(Math.max(nameBounds.getWidth(), codeBounds.getWidth()), 2*alphabetWidth);


					FormattedString descriptionString = FormattedStringUtil.formatHtml(description, this.styleProvider);
					this.styleProvider.assignTextBounds(descriptionString, maxWidth, null, 0);
					this.labels.add(descriptionString);
				}
			}
		}		
	}
	
	@Override
	public BoundingBox getBounds() {
		BoundingBox bounds = super.getBounds();
		return new BoundingBox(bounds.getX(), bounds.getY(), bounds.getHeight() + ARROW_HEIGHT, bounds.getWidth());
	}
	
	@Override
	protected Padding getMargins() {
		return Padding.padAllSides(0);
	}
}
