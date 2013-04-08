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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ca.infoway.demiftifier.LogicalDimensions;
import ca.infoway.demiftifier.MessagePartLayoutItem;

public class ChoiceShape extends MessagePartShape {
	
	public class ComparatorImpl implements Comparator<Shape> {

		@Override
		public int compare(Shape s1, Shape s2) {
			if (s1.getItem().getHeight() != s2.getItem().getHeight()) {
				return s1.getItem().getHeight() - s2.getItem().getHeight();
			} else {
				return s1.getItem().getLabel().compareTo(s2.getItem().getLabel());
			}
		}

	}
	private final class LogicalDimensionsImpl implements
			LogicalDimensions {
		
		private final int x;
		private final int y;
		private final int height;
		private final int width;

		public LogicalDimensionsImpl(int x, int y, int height, int width) {
			this.x = x;
			this.y = y;
			this.height = height;
			this.width = width;
		}

		@Override
		public int getWidth() {
			return this.width;
		}

		@Override
		public int getLogicalY() {
			return this.y;
		}

		@Override
		public int getLogicalX() {
			return this.x;
		}

		@Override
		public int getHeight() {
			return this.height;
		}
	}
	class PaddingCoordinateSpace implements CoordinateSpace {

		private final CoordinateSpace coordinateSpace;
		private final int specializationOffset;
		private final int rightOffsetToAccountForChoiceShapeHavingInboundArrowShape;
		private final BoundingBox minimalBounds;

		PaddingCoordinateSpace(CoordinateSpace mapper, int specializationOffset, int rightOffsetToAccountForChoiceShapeHavingInboundArrowShape,
				BoundingBox minimalBounds) {
			this.coordinateSpace = mapper;
			this.specializationOffset = specializationOffset;
			this.rightOffsetToAccountForChoiceShapeHavingInboundArrowShape = rightOffsetToAccountForChoiceShapeHavingInboundArrowShape;
			this.minimalBounds = minimalBounds;
		}
		public BoundingBox getCoordinates(LogicalDimensions logicalDimensions) {
			BoundingBox box = this.coordinateSpace.getCoordinates(logicalDimensions);
			int height = Math.max(box.getHeight(), minimalBounds.getHeight());
			return new BoundingBox(box.getX() + SPECIALIZATION_PADDING + rightOffsetToAccountForChoiceShapeHavingInboundArrowShape,
					box.getY() + minimalBounds.getY() - this.specializationOffset, 
					height + this.specializationOffset,
					box.getWidth() - (SPECIALIZATION_PADDING * 2) - rightOffsetToAccountForChoiceShapeHavingInboundArrowShape);
		}
	}
	
	public static final int PADDING = 10;
	public static final int SPECIALIZATION_PADDING = 15;

	private static ColorFill FILL = new ColorFill(Color.WHITE);
	
	private List<Shape> containedChoiceShapes = new ArrayList<Shape>();

	public ChoiceShape(MessagePartLayoutItem item, StyleProvider styleProvider, ShapeFactory shapeFactory) {
		super(item, styleProvider);
		if (!getItem().isDuplicate()) {
			for (MessagePartLayoutItem choice : item.getSpecializationChilds()) {
				this.containedChoiceShapes.add(shapeFactory.getShape(choice));
			}
		}
		Collections.sort(this.containedChoiceShapes, new ComparatorImpl());
	}
	protected String getSvgClassForRimClass() {
		return "demiftifier-rim-type-choice";
	}
	@Override
	protected StrokeType getStrokeType() {
		return StrokeType.LONG_DASH;
	}
	@Override
	protected Fill getFillColor() {
		return getItem().isDuplicate() ? FILL.makeGrey() : FILL;
	}
	@Override
	protected Alignment getAlignment() {
		return Alignment.CENTER;
	}
	
	@Override
	public void render(CoordinateSpace mapper, Writer writer) throws IOException {
		BoundingBox box = mapper.getCoordinates(this.item);
		render(box, writer);

		int height = calculateContentHeight() + getMargins().getTop();
		BoundingBox firstRow = mapper.getCoordinates(
				new LogicalDimensionsImpl(this.item.getLogicalX(), this.item.getLogicalY(), 1, 1)); 

		int offset = firstRow.getHeight() - height - getMargins().getTop();
		if (offset < 0) {
			offset = 0;
		}

		int heightOffset = height;
		for (Shape shape : this.containedChoiceShapes) {
			BoundingBox bounds = shape.getBounds();
			if (shape.getItem().getHeight() == 0) {
				if (heightOffset >= 0) {
					bounds = bounds.translateTo(bounds.getX(), bounds.getY() + heightOffset);
				}
				offset = 0;
			}
			
			PaddingCoordinateSpace subMapper = new PaddingCoordinateSpace(
					mapper, shape instanceof CmetShape ? 0 : offset, 
					getRightDisplacementToAccountForIncomingArrowShape(), bounds);
			shape.renderGroup(subMapper, writer);
			offset = 0;
			heightOffset += subMapper.getCoordinates(shape.getItem()).getHeight();
		}
	}
	
	@Override
	public BoundingBox getBounds() {
		int height = calculateContentHeight();
		int width = calculateMinimumWidth();
		
		for (Shape shape : this.containedChoiceShapes) {
			BoundingBox box = shape.getBounds();
			height += box.getHeight() + PADDING;
			width = Math.max(width, box.getWidth() + getRightDisplacementToAccountForIncomingArrowShape()) + SPECIALIZATION_PADDING * 2;
		}
		return new BoundingBox(0, 0, height, width).withPadding(getMargins());
	}

	@Override
	protected Padding getMargins() {
		if (this.item.isRootType()) {
			return Padding.padAllSides(0);
		} else {
			return new Padding(MARGIN_TOP, 0, MARGIN_BOTTOM / 2, 0);
		}
	}
	
	/*
	 * The logic behind this code is a bit thorny. Basically, to get the best use of space, 
	 * we consider two types of specializations -- "trivial" and "non-trivial". Trivial 
	 * specializations have no (visible) associations. Because they have no associations,
	 * they don't need to have their own row (and thus have a height of 0) -- they're 
	 * contained in the same space as the choice type itself.  Non-trivial specializations
	 * need to take one or more rows, based on how many associations they have.
	 * 
	 * The tricky part is determining how much space to allocate for the non-trivial types.
	 * The choice can be considered to have two "halves" -- the space needed for the label 
	 * and trivial specializations, and the space needed for the non-trivial specializations.
	 * 
	 * The first "half" might span multiple rows (if the choice type, itself). If those rows
	 * are already tall enough to fit all of the non-trivial choices, then great, our job is
	 * done.  But if not, we need to add some extra space (to the last row of that half) to
	 * accommodate the trivial shapes.
	 * 
	 * Determining the size of the second half is based on figuring out how big each row 
	 * needs to be.
	 */
	@Override
	public int getMinimalHeightForRow(CoordinateSpace mapper, int rowNumber) {
		
		List<Shape> trivialShapes = getAllTrivialShapes();
		int firstImportantRow = getFirstRowWithNonTrivialSpecializations();
		if (rowNumber == firstImportantRow-1 && !trivialShapes.isEmpty()) {
			int availableHeight = 0;
			for (int i = getItem().getLogicalY(); i < firstImportantRow-1; i++) {
				BoundingBox box = mapper.getCoordinates(new LogicalDimensionsImpl(getItem().getLogicalX(), i, 1, 1));
				availableHeight += box.getHeight();
			}
			int neededHeight = getMinimumHeightForSpecializationShapes(trivialShapes);
			
			if (rowNumber == getItem().getLogicalY()) {
				neededHeight += calculateContentHeight() + getMargins().getTop();
			}
			int result = Math.max(0, neededHeight - availableHeight);
			
			return result;
		} else if (rowNumber == getItem().getLogicalY()) {
			return calculateContentHeight() + getMargins().getTop();
		} else {
			return getMinimumHeightForSpecializationShapes(getShapesInRow(rowNumber));
		}
	}
	
	private List<Shape> getAllTrivialShapes() {
		List<Shape> result = new ArrayList<Shape>();
		for (Shape shape : this.containedChoiceShapes) {
			if (isTrivial(shape)) {
				result.add(shape);
			}
		}
		return result;
	}
	private boolean isTrivial(Shape shape) {
		return ((MessagePartLayoutItem) shape.getItem()).isTrivial();
	}
	private int getMinimumHeightForSpecializationShapes(List<Shape> subShapes) {
		int height = 0;
		for (Shape shape : subShapes) {
			BoundingBox box = shape.getBounds();
			height += box.getHeight() + PADDING;
		}
		return height;
	}
	
	private int getFirstRowWithNonTrivialSpecializations() {
		int result = Integer.MAX_VALUE;
		for (Shape shape : this.containedChoiceShapes) {
			if (!isTrivial(shape)) {
				result = Math.min(result, shape.getItem().getLogicalY());
			}
		}
		return result == Integer.MAX_VALUE ? -1 : result;
	}
	private List<Shape> getShapesInRow(int rowNumber) {
		List<Shape> result = new ArrayList<Shape>();
		for (Shape shape : this.containedChoiceShapes) {
			if (shape.getItem().getLogicalY() == rowNumber) {
				result.add(shape);
			}
		}
		return result;
	}
}
