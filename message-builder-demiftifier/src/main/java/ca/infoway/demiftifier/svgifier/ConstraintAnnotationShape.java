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
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import ca.infoway.demiftifier.AnnotationItem;

class ConstraintAnnotationShape extends AnnotationShape {

	ConstraintAnnotationShape(AnnotationItem annotation, StyleProvider styleProvider) {
		super(annotation, styleProvider);
	}
	
	@Override
	protected void createTitle() {
		FormattedString title = new FormattedString();
		title.addSegment(StringUtils.isNotBlank(this.annotation.getRelationshipName()) 
				? "Constraint: " + this.annotation.getRelationshipName() : "Constraint", 
				this.styleProvider.getDefaultBoldTextFont());
		this.styleProvider.assignTextBounds(title);
		this.labels.add(title);
	}

	@Override
	protected void renderOutline(BoundingBox box, Writer writer)
			throws IOException {
		
		FormattedString title = this.labels.isEmpty() ? null : this.labels.get(0);
		if (title == null) {
			super.renderOutline(box, writer);
		} else {
			List<Position> positions = new ArrayList<Position>();
			int y = box.getY() + (int) (title.getBox().getHeight() * .75);
			positions.add(new PositionImpl(box.getX() + TEXT_AREA_PADDING_LEFT / 2, y));
			positions.add(new PositionImpl(box.getX(), y));
			positions.add(new PositionImpl(box.getX(), box.getY() + box.getHeight()));
			positions.add(new PositionImpl(box.getX() + box.getWidth(), box.getY() + box.getHeight()));
			positions.add(new PositionImpl(box.getX() + box.getWidth(), y));
			positions.add(new PositionImpl(box.getX() + title.getBox().getWidth() + TEXT_AREA_PADDING_LEFT * 2, y));
			
			new Path(positions) {
				void writePathStyle(Writer writer) throws IOException {
					ConstraintAnnotationShape.this.writeStyle(writer);
				};
			}.write(writer);
		}
	}
}
