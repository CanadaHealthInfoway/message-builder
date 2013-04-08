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

import ca.infoway.demiftifier.MessagePartLayoutItem;

public class InboundArrowShape extends BasicShape {
	private static final int DISPLACEMENT_RIGHT_FIXED = 40;
	private static final int DISPLACEMENT_DOWN_UNIT = 50;
	private static final int DOWN_LINE_LENGTH_FIXED = 25;
	private static final int ARROW_SIZE_FIXED = 4;

	private CardinalityTextShape cardinalityTextShape;
	private int inboundArrowDepth;
	private int encroachment;

	InboundArrowShape(MessagePartLayoutItem messagePartLayoutItem, StyleProvider styleProvider) {
		super(styleProvider);
		if (messagePartLayoutItem.getInboundAssociation() == null){
			throw new IllegalArgumentException("MessagePartLayoutItem.inboundRelationship cannot be null for this shape!");
		}
		this.cardinalityTextShape = new CardinalityTextShape(messagePartLayoutItem, styleProvider);
		this.inboundArrowDepth = messagePartLayoutItem.getInboundAssociation().getInboundArrowDepth();
		this.encroachment = messagePartLayoutItem.getEncroachmentLevel() * ChoiceShape.SPECIALIZATION_PADDING;

	}

	@Override
	protected void initializeLabels() {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void render(BoundingBox box, Writer writer) throws IOException {
		Polyline polyline = new Polyline(getLineStartPosition(box));
		polyline.moveBy(calculateLineHorizontalLength(box), 0);
		polyline.moveBy(0, DOWN_LINE_LENGTH_FIXED - ARROW_SIZE_FIXED);
		polyline.moveBy(ARROW_SIZE_FIXED, 0); 
		polyline.moveBy(-ARROW_SIZE_FIXED, ARROW_SIZE_FIXED); //tip of down arrow
		polyline.moveBy(-ARROW_SIZE_FIXED, -ARROW_SIZE_FIXED);
		polyline.moveBy(+ARROW_SIZE_FIXED, 0);
		polyline.render(writer);
		
		int xTranslation = calculateLineHorizontalLength(box) - encroachment - this.cardinalityTextShape.getBounds().getWidth(); 
		int yTranslation = getDisplacementDown() - DOWN_LINE_LENGTH_FIXED;
		this.cardinalityTextShape.render(box.translateBy(xTranslation, yTranslation), writer);
	}

	private Position getLineStartPosition(BoundingBox entityBounds) {
		return new PositionImpl(entityBounds.getX() - encroachment, calculateLineStartY(entityBounds));
	}

	private int calculateLineStartY(BoundingBox bounds) {
		return bounds.getY() + getDisplacementDown() - DOWN_LINE_LENGTH_FIXED;
	}

	private int calculateLineHorizontalLength(BoundingBox bounds) {
		return DISPLACEMENT_RIGHT_FIXED + encroachment + ( (bounds.getWidth() - DISPLACEMENT_RIGHT_FIXED) * 3 / 4 );
	}

	public int getDisplacementRight() {
		return DISPLACEMENT_RIGHT_FIXED;
	}

	public int getDisplacementDown() {
		return DISPLACEMENT_DOWN_UNIT * inboundArrowDepth;
	}

}
