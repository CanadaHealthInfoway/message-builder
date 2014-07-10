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

import ca.infoway.demiftifier.AnnotationItem;

class NoteAnnotationShape extends AnnotationShape {

	NoteAnnotationShape(AnnotationItem annotation, StyleProvider styleProvider) {
		super(annotation, styleProvider);
	}

	@Override
	protected void renderFullOutline(BoundingBox box, Writer writer)
			throws IOException {
		List<Position> positions = new ArrayList<Position>();
		positions.add(new PositionImpl(box.getX(), box.getY()));
		positions.add(new PositionImpl(box.getX() + box.getWidth() - 10, box.getY()));
		positions.add(new PositionImpl(box.getX() + box.getWidth(), box.getY() + 10));
		positions.add(new PositionImpl(box.getX() + box.getWidth(), box.getY() + box.getHeight()));
		positions.add(new PositionImpl(box.getX(), box.getY() + box.getHeight()));
		positions.add(new PositionImpl(box.getX(), box.getY()));
		
		new Path(positions) {
			void writePathStyle(Writer writer) throws IOException {
				NoteAnnotationShape.this.writeStyle(writer);
			};
		}.write(writer);
		
		positions.clear();
		positions.add(new PositionImpl(box.getX() + box.getWidth() - 10, box.getY()));
		positions.add(new PositionImpl(box.getX() + box.getWidth() - 10, box.getY() + 10));
		positions.add(new PositionImpl(box.getX() + box.getWidth(), box.getY() + 10));
		
		new Path(positions) {
			void writePathStyle(Writer writer) throws IOException {
				writer.write(" style=\"fill:none;stroke:#000000;stroke-width:" +
						NoteAnnotationShape.this.getStrokeWeight() +
						"px;stroke-linecap:butt;stroke-linejoin:miter;stroke-opacity:1;\" ");
			};
		}.write(writer);
	}
}
