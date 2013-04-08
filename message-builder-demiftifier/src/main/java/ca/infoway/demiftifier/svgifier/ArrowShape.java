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

class ArrowShape {

	private final Position startPosition;
	private final Position endPosition;
	private final Orientation arrowDirection;

	public ArrowShape(Position startPosition, Position endPosition,
			Orientation arrowDirection) {
		this.startPosition = startPosition;
		this.endPosition = endPosition;
		this.arrowDirection = arrowDirection;
	}
	
	public void write(Writer writer) throws IOException {
		List<Position> positions = new ArrayList<Position>();
		if (this.arrowDirection.isHorizontal()) {
			double width = Math.abs(this.startPosition.getX() - this.endPosition.getX());
			double headSize = width < 25.0 ? (width / 2.0) : 20.0;
			if (this.arrowDirection == Orientation.LEFT) {
				headSize = -headSize;
			}
			
			double x1 = this.startPosition.getX();
			double x2 = this.endPosition.getX();
			double y = this.startPosition.getY();
			positions.add(this.startPosition);
			positions.add(new PositionImpl(x1, y - 2.0));
			positions.add(new PositionImpl(x2 - headSize, y - 2.0));
			positions.add(new PositionImpl(x2 - headSize, y - 6.0));
			positions.add(new PositionImpl(x2, y));
			positions.add(new PositionImpl(x2 - headSize, y + 6.0));
			positions.add(new PositionImpl(x2 - headSize, y + 2.0));
			positions.add(new PositionImpl(x1, y + 2.0));
			positions.add(this.startPosition);
		} else {
			double height = Math.abs(this.startPosition.getY() - this.endPosition.getY());
			double headSize = height < 25.0 ? (height / 2.0) : 20.0;
			if (this.arrowDirection == Orientation.UP) {
				headSize = -headSize;
			}
			
			double x = this.startPosition.getX();
			double y1 = this.startPosition.getY();
			double y2 = this.endPosition.getY();
			positions.add(this.startPosition);
			positions.add(new PositionImpl(x - 2.0, y1));
			positions.add(new PositionImpl(x - 2.0, y2 - headSize));
			positions.add(new PositionImpl(x - 6.0, y2 - headSize));
			positions.add(new PositionImpl(x, y2));
			positions.add(new PositionImpl(x + 6.0, y2 - headSize));
			positions.add(new PositionImpl(x + 2.0, y2 - headSize));
			positions.add(new PositionImpl(x + 2.0, y1));
			positions.add(this.startPosition);
		}
		new Path(positions).write(writer);
	}
}
