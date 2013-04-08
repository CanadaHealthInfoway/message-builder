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

import ca.infoway.demiftifier.MessagePartLayoutItem;

public class ConnectorTypeShape extends MessagePartShape {
	private static final int CYCLE_SHAPE_EXTRA_HEIGHT = 50;

	class PathImpl extends Path {

		PathImpl(List<Position> positions) {
			super(positions);
		}
		@Override
		void writePathStyle(Writer writer) throws IOException {
			writeStyle(writer);
			writer.write(" class=\"outline\" ");
		}
	}

	private final CardinalityTextShape cardinalityText;
	
	public ConnectorTypeShape(MessagePartLayoutItem item, StyleProvider styleProvider) {
		super(item, styleProvider);
		this.cardinalityText = new CardinalityTextShape(item, styleProvider);
	}

	@Override
	public void render(CoordinateSpace mapper, Writer writer) throws IOException {
		int encroachment = getMessagePartLayoutItem().getEncroachmentLevel() * ChoiceShape.SPECIALIZATION_PADDING;
		BoundingBox box = mapper.getCoordinates(this.item);
		box = new BoundingBox(box.getX() - encroachment, box.getY()+MARGIN_TOP, box.getHeight()-MARGIN_TOP-MARGIN_BOTTOM, box.getWidth() + encroachment);
		
		int height = getBounds().getUnpaddedBounds().getHeight();
		int y = ((box.getHeight() - height) / 2) + box.getY();
		
		BoundingBox connectorShapeBoundingBox = new BoundingBox(box.getX(), y, height, box.getWidth());
		List<Position> positions = extractPositions(connectorShapeBoundingBox);
		new PathImpl(positions).write(writer);
		
		int leftOffset = (getOrientation() == Orientation.LEFT) ? calculateOffset() : 0;
		int leftOrRightOffset = (getOrientation() == Orientation.LEFT || getOrientation() == Orientation.RIGHT) ? calculateOffset() : 0;
		BoundingBox textBounds = new BoundingBox(connectorShapeBoundingBox.getX() +leftOffset, connectorShapeBoundingBox.getY(), 
				connectorShapeBoundingBox.getHeight(), connectorShapeBoundingBox.getWidth() - leftOrRightOffset);
		renderText(textBounds, writer);
		renderAnnotations(textBounds.translateTo(textBounds.getX(), textBounds.getY()-MARGIN_TOP), writer);
		renderCardinality(mapper, connectorShapeBoundingBox, writer);
	}

	private void renderCardinality(CoordinateSpace mapper, BoundingBox connectorShapeBoundingBox, Writer writer) throws IOException {
		BoundingBox cardinalityTextBounds = this.cardinalityText.getBounds();
		int xTranslation = connectorShapeBoundingBox.getWidth() - calculateOffset() - cardinalityTextBounds.getWidth();
		int yTranslation = - cardinalityTextBounds.getUnpaddedBounds().getHeight();
		this.cardinalityText.render(connectorShapeBoundingBox.translateBy(xTranslation, yTranslation), writer);
	}

	private List<Position> extractPositions(BoundingBox box) {
		List<Position> result = new ArrayList<Position>();

		Orientation orientation = getOrientation();
		
		if (getMessagePartLayoutItem().isCyclic()) {
			int encroachmentEnd = getMessagePartLayoutItem().getEncroachmentLevelEnd();
			int encroachmentDelta = encroachmentEnd - getMessagePartLayoutItem().getEncroachmentLevel();
			int widthDelta = encroachmentDelta * ChoiceShape.SPECIALIZATION_PADDING;
			
			if (orientation == Orientation.RIGHT) {
				result.add(new PositionImpl(box.getX(), box.getY()));
				result.add(new PositionImpl(box.getX() + box.getWidth(), box.getY()));
				result.add(new PositionImpl(box.getX() + box.getWidth(), box.getY() + box.getHeight()));
				result.add(new PositionImpl(box.getX() + 2 * CYCLE_SHAPE_EXTRA_HEIGHT / 5 - widthDelta, box.getY() + box.getHeight()));
				result.add(new PositionImpl(box.getX() - widthDelta, box.getY() + box.getHeight() - 2 * CYCLE_SHAPE_EXTRA_HEIGHT / 5));
				result.add(new PositionImpl(box.getX() + 2 * CYCLE_SHAPE_EXTRA_HEIGHT / 5 - widthDelta, box.getY() + box.getHeight() - 4 * CYCLE_SHAPE_EXTRA_HEIGHT / 5));
				result.add(new PositionImpl(box.getX() + 3 * box.getWidth() / 4, box.getY() + box.getHeight() - 4 * CYCLE_SHAPE_EXTRA_HEIGHT / 5));
				result.add(new PositionImpl(box.getX() + 3 * box.getWidth() / 4, box.getY() + box.getHeight() - CYCLE_SHAPE_EXTRA_HEIGHT));
				result.add(new PositionImpl(box.getX(), box.getY() + box.getHeight() - CYCLE_SHAPE_EXTRA_HEIGHT));
				result.add(new PositionImpl(box.getX(), box.getY()));
			}
		} else {
			if (orientation == Orientation.LEFT) {
				result.add(new PositionImpl(box.getX() + calculateOffset(), box.getY()));
				result.add(new PositionImpl(box.getX() + box.getWidth(), box.getY()));
				result.add(new PositionImpl(box.getX() + box.getWidth(), box.getY() + box.getHeight()));
				result.add(new PositionImpl(box.getX() + calculateOffset(), box.getY() + box.getHeight()));
				result.add(new PositionImpl(box.getX(), box.getY() + box.getHeight() / 2.0));
				result.add(new PositionImpl(box.getX() + calculateOffset(), box.getY()));
			} else {
				result.add(new PositionImpl(box.getX(), box.getY()));
				result.add(new PositionImpl(box.getX() + box.getWidth() - calculateOffset(), box.getY()));
				result.add(new PositionImpl(box.getX() + box.getWidth(), box.getY() + box.getHeight() / 2.0));
				result.add(new PositionImpl(box.getX() + box.getWidth() - calculateOffset(), box.getY() + box.getHeight()));
				result.add(new PositionImpl(box.getX(), box.getY() + box.getHeight()));
				result.add(new PositionImpl(box.getX(), box.getY()));
			}
		}
		
		return result;
	}

	private Orientation getOrientation() {
		return Orientation.RIGHT;
	}
	
	private int calculateOffset(){
		return super.getBounds().getHeight()/5;
	}

	@Override
	public BoundingBox getBounds() {
		BoundingBox originalBounds = super.getBounds();
		originalBounds = originalBounds.withWidth(Math.max(originalBounds.getWidth(), this.cardinalityText.getBounds().getWidth()));
		
		if (getMessagePartLayoutItem().isCyclic()) {
			BoundingBox result = originalBounds.getUnpaddedBounds().withHeight(originalBounds.getHeight() + CYCLE_SHAPE_EXTRA_HEIGHT).withPadding(originalBounds.getPadding());
			return result;
		} else {
			BoundingBox result = originalBounds.getUnpaddedBounds().withWidth(originalBounds.getWidth() + calculateOffset()).withPadding(originalBounds.getPadding());
			return result;
		}
	}
}
