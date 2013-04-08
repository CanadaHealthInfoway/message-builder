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

class Polyline {

	private final List<Position> positions = new ArrayList<Position>();

	Polyline(Position startingPoint){
		if (startingPoint == null){
			throw new IllegalArgumentException("Every good polyline has to start somewhere!");
		}
		this.positions.add(startingPoint);
	}
	
	void moveBy(double deltaX, double deltaY){
		positions.add(positions.get(positions.size()-1).move(deltaX, deltaY));
	}

	public void render(Writer writer) throws IOException {
		writer.write("<polyline points=\"" + createPolylineData() + "\" ");
		writeStyle(writer);
		closeElement(writer);
	}	

	private String createPolylineData() {
		StringBuilder builder = new StringBuilder();
		boolean firstPosition = false;
		for (Position position : this.positions) {
			if (!firstPosition) {
				builder.append(" ");
			} 
			builder.append(position.getX());
			builder.append(",");
			builder.append(position.getY());
		}
		return builder.toString();
	}

	void writeStyle(Writer writer) throws IOException {
		writer.write(" style=\"fill:none;stroke:#000000;stroke-width:2px;stroke-opacity:1;\" ");
	}
	
	void closeElement(Writer writer) throws IOException {
		writer.write("/>");
	}

	
}
