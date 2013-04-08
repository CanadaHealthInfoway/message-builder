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
import ca.infoway.demiftifier.MessagePartLayoutItem;
import ca.infoway.messagebuilder.xml.AnnotationType;
import ca.infoway.messagebuilder.xml.RimClass;

abstract class MessagePartShape extends Shape {
	
	public MessagePartShape(MessagePartLayoutItem item, StyleProvider styleProvider) {
		super(item, styleProvider);
	}
	void renderGroup(CoordinateSpace mapper, Writer writer) throws IOException {
		writer.write("<g");
		if (!getItem().isDuplicate()) {
			writer.write(" id=\"");
			writer.write(getMessagePartLayoutItem().getName().replace('.', '-'));
			writer.write("\"");
			writer.write(" chi:name=\"");
			writer.write(getMessagePartLayoutItem().getName());
			writer.write("\" class=\"demiftifier-message-part ");
			writer.write(getSvgClassForRimClass());
			writer.write("\" ");
		}
		writer.write(">");
		render(mapper, writer);
		writer.write("</g>");
	}

	protected String getSvgClassForRimClass() {
		RimClass rimClass = getItem().getRimClass();
		if (rimClass == RimClass.ACT) {
			return "demiftifier-rim-type-act";
		} else if (rimClass == RimClass.ACT_RELATIONSHIP) {
			return "demiftifier-rim-type-act-relationship";
		} else if (rimClass == RimClass.ENTITY) {
			return "demiftifier-rim-type-entity";
		} else if (rimClass == RimClass.ROLE) {
			return "demiftifier-rim-type-role";
		} else if (rimClass == RimClass.ROLE_LINK) {
			return "demiftifier-rim-type-role-link";
		} else if (rimClass == RimClass.PARTICIPATION) {
			return "demiftifier-rim-type-participation";
		} else if (rimClass == RimClass.OTHER_CLASS) {
			return "demiftifier-rim-type-other";
		} else {
			return "";
		}
	}
	@Override
	public void render(CoordinateSpace mapper, Writer writer) throws IOException {
		super.render(mapper, writer);
		BoundingBox box = mapper.getCoordinates(this.item);
		renderAnnotations(box, writer);
	}
	
	protected void renderAnnotations(BoundingBox box, Writer writer) throws IOException {
		if (!getItem().isDuplicate()) {
			int start = calculateContentHeight() + getMargins().getTop();
			box = box.translateBy(getRightDisplacementToAccountForIncomingArrowShape(), 0);
			
			for (AnnotationShape annotationShape : getAnnotationShapes()) {
				BoundingBox actualBounds = annotationShape.getBounds().translateTo(box.getX() + TEXT_AREA_PADDING_LEFT, box.getY() + start);
				annotationShape.render(actualBounds, writer);
				
				start += actualBounds.getHeight() + TEXT_AREA_PADDING_BOTTOM;
			}
		}
	}
	
	public BoundingBox getBounds() {
		BoundingBox basicBox = super.getBounds().getUnpaddedBounds();
		
		int height = basicBox.getHeight();
		int width = basicBox.getWidth();
		
		if (!getItem().isDuplicate()) {
			for (AnnotationShape annotationShape : getAnnotationShapes()) {
				BoundingBox annotationBox = annotationShape.getBounds();
				height += annotationBox.getHeight() + TEXT_AREA_PADDING_BOTTOM;
				int effectiveAnnotationWidth = annotationBox.getWidth()
						+ TEXT_AREA_PADDING_LEFT + TEXT_AREA_PADDING_RIGHT + getRightDisplacementToAccountForIncomingArrowShape();
				width = Math.max(effectiveAnnotationWidth, width);
			}
			height += TEXT_AREA_PADDING_BOTTOM;
		}
		
		return new BoundingBox(0, 0, height, width).withPadding(getMargins());
	};
	
	protected List<AnnotationShape> getAnnotationShapes() {
		List<AnnotationShape> result = new ArrayList<AnnotationShape>();
		for (AnnotationItem annotation : getMessagePartLayoutItem().getRelevantAnnotations()) {
			if (annotation.getAnnotation().getAnnotationTypeAsEnum() == AnnotationType.DEFINITION) {
				result.add(new NoteAnnotationShape(annotation, this.styleProvider));
			} else {
				result.add(new ConstraintAnnotationShape(annotation, this.styleProvider));
			}
		}
		return result;
	}

	
	MessagePartLayoutItem getMessagePartLayoutItem() {
		return (MessagePartLayoutItem) this.item;
	}
}
