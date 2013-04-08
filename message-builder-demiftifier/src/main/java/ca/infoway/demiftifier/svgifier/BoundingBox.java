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

import org.apache.commons.lang.builder.ToStringBuilder;

public class BoundingBox {

	private final int x;
	private final int y;
	private final int height;
	private final int width;
	private Padding padding;
	
	Padding getPadding() {
		return padding;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getHeight() {
		return height;
	}
	public int getWidth() {
		return width;
	}
	public BoundingBox(int x, int y, int height, int width) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
	}
	BoundingBox withPadding(Padding padding) {
		BoundingBox result = new BoundingBox(x, y, height + padding.getTop() + padding.getBottom(), width + padding.getRight() + padding.getLeft());
		result.padding = padding;
		return result;
	}
	BoundingBox getUnpaddedBounds() {
		if (padding == null) {
			return this;
		} else {
			return extractPadding(padding);
		}
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	public BoundingBox translateTo(int x2, int y2) {
		BoundingBox boundingBox = new BoundingBox(x2, y2, this.height, this.width);
		boundingBox.padding = this.padding;
		return boundingBox;
	}
	public BoundingBox translateBy(int deltaX, int deltaY) {
		BoundingBox boundingBox = new BoundingBox(this.x + deltaX, this.y + deltaY, this.height, this.width);
		boundingBox.padding = this.padding;
		return boundingBox;
	}
	public BoundingBox withWidth(int width) {
		BoundingBox boundingBox = new BoundingBox(this.x, this.y, this.height, width);
		boundingBox.padding = padding;
		return boundingBox;
	}
	public BoundingBox extractPadding(Padding otherPadding) {
		return new BoundingBox(x+otherPadding.getLeft(), y+otherPadding.getTop(), height-otherPadding.getBottom()-otherPadding.getTop(), width-otherPadding.getLeft()-otherPadding.getRight());
	}
	public BoundingBox withHeight(int height) {
		BoundingBox boundingBox = new BoundingBox(this.x, this.y, height, this.width);
		boundingBox.padding = padding;
		return boundingBox;
	}
}
