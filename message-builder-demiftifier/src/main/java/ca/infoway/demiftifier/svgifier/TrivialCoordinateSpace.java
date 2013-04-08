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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import ca.infoway.demiftifier.LayoutItem;
import ca.infoway.demiftifier.LogicalDimensions;

public class TrivialCoordinateSpace implements CoordinateSpace {
	
	private final Map<Integer,Integer> columnWidths = new TreeMap<Integer, Integer>();
	private final Map<Integer,Integer> rowHeights = new TreeMap<Integer, Integer>();
	
	private final StyleProvider styleProvider;
	private BoundingBox boundingBox = new BoundingBox(0, 0, Integer.MAX_VALUE, Integer.MAX_VALUE);
	
	public TrivialCoordinateSpace() {
		this.styleProvider = new StyleProvider();		
	}
	
	public BoundingBox getCoordinates(LogicalDimensions dimensions) {
		int startColumn = dimensions.getLogicalX();
		int startRow = dimensions.getLogicalY();

		int width = 0;
		int x = this.boundingBox.getUnpaddedBounds().getX();
		int height = 0;
		int y = this.boundingBox.getUnpaddedBounds().getY();
		
		for (int i = 0; i < (startColumn + dimensions.getWidth()); i++) {
			if (!this.columnWidths.containsKey(i)) {
				this.columnWidths.put(i, 0);
			}
			if (i < startColumn) {
				x += this.columnWidths.get(i);
			} else {
				width += this.columnWidths.get(i);
			}
		}
		for (int i = 0; i < (startRow + dimensions.getHeight()); i++) {
			if (!this.rowHeights.containsKey(i)) {
				this.rowHeights.put(i, 0);
			}
			if (i < startRow) {
				y += this.rowHeights.get(i);
			} else {
				height += this.rowHeights.get(i);
			}
		}
		
		return new BoundingBox(x, y, height, width);
	}

	public void initialize(Diagram diagram) {
		for (Shape shape : getShapesInSizeOrder(diagram)) {
			if (!shape.getItem().isSpecialization()) {
				BoundingBox bounds = shape.getBounds();
				LayoutItem item = shape.getItem();
				adjustColumnWidth(bounds, item);
				adjustRowHeight(bounds, shape);
			}
		}
	}

	private void adjustColumnWidth(BoundingBox bounds, LayoutItem item) {
		if (this.columnWidths.containsKey(item.getLogicalX())) {
			int currentWidth = this.columnWidths.get(item.getLogicalX());
			this.columnWidths.put(item.getLogicalX(), Math.max(currentWidth, bounds.getWidth()));
		} else {
			this.columnWidths.put(item.getLogicalX(), bounds.getWidth());
		}
	}

	private void adjustRowHeight(BoundingBox bounds, Shape shape) {
		LayoutItem item = shape.getItem();
		int height = bounds.getHeight();
		int lastRowY = item.getLogicalY();
		if (item.getHeight() > 1) {
			for (int i = lastRowY; i < (lastRowY + item.getHeight() - 1); i++) {
				int rowHeight = this.rowHeights.containsKey(i) ? rowHeights.get(i) : 0;
				rowHeight = Math.max(rowHeight, shape.getMinimalHeightForRow(this, i));
				this.rowHeights.put(i, rowHeight);

				height -= rowHeight;
				if (height < 0) {
					height = 0;
				}
			}
		}
		
		if (this.rowHeights.containsKey(lastRowY)) {
			int currentHeight = this.rowHeights.get(lastRowY);
			this.rowHeights.put(lastRowY, Math.max(currentHeight, height));
		} else {
			this.rowHeights.put(lastRowY, height);
		}
	}
	
	
	private Collection<Shape> getShapesInSizeOrder(Diagram diagram) {
		List<Shape> shapes = new ArrayList<Shape>(diagram.getShapes());
		Collections.sort(shapes, new Comparator<Shape>() {

			public int compare(Shape s1, Shape s2) {
				if (s1.getItem().getHeight() != s2.getItem().getHeight()) {
					return s1.getItem().getHeight() - s2.getItem().getHeight();
				} else {
					return s1.getItem().getLogicalY() - s2.getItem().getLogicalY();
				}
			}
		});
		return shapes;
	}

	public BoundingBox getCoordinateSpaceBounds() {
		int width = 0;
		for (Integer columnWidth : this.columnWidths.values()) {
			width += columnWidth;
		}
		
		int height = 0;
		for (Integer rowHeight : this.rowHeights.values()) {
			height += rowHeight;
		}
		this.boundingBox = new BoundingBox(0, 0, height, width).withPadding(Padding.padAllSides(20));
		return this.boundingBox;
	}
	
	public StyleProvider getStyleProvider() {
		return this.styleProvider;
	}
}
