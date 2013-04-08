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

import org.apache.commons.lang.builder.EqualsBuilder;

class PositionImpl implements Position {
	private final double x;
	private final double y;
	PositionImpl(double x, double y) {
		this.x = x;
		this.y = y;
	}
	public double getX() {
		return this.x;
	}
	public double getY() {
		return this.y;
	}
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		} else if (obj == this) {
			return true;
		} else if (obj.getClass() != getClass()) {
			return false;
		} else {
			PositionImpl that = (PositionImpl) obj;
			return new EqualsBuilder()
					.append(this.x, that.x)
					.append(this.y, that.y)
					.isEquals();
		}
	}
	public Position move(double deltaX, double deltaY) {
		return new PositionImpl(this.x + deltaX, this.y + deltaY);
	}
}