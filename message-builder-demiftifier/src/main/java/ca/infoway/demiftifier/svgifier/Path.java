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
import java.util.List;

class Path {

	protected final FormatterUtil util = new FormatterUtil();
	private final List<Position> positions;

	Path(List<Position> positions) {
		this.positions = positions;
	}
	
	void write(Writer writer) throws IOException {
		writer.write("<path d=\"" + createPathData() + "\" ");
		writePathStyle(writer);
		closeElement(writer);
	}	

	void writePathStyle(Writer writer) throws IOException {
		writer.write(" style=\"fill:#000000;stroke:#000000;stroke-width:1px;stroke-linecap:butt;stroke-linejoin:miter;stroke-opacity:1;\" ");
	}
	
	void closeElement(Writer writer) throws IOException {
		writer.write("/>");
	}

	protected String format(Position position) {
		return this.util.format(position.getX()) + " " + this.util.format(position.getY());
	}
	private String createPathData() {
		StringBuilder builder = new StringBuilder();
		Position first = null;
		for (Position position : this.positions) {
			if (first == null) {
				builder.append("M");
				builder.append(format(position));
				first = position;
			} else if (first.equals(position)) {
				builder.append(" Z");
			} else {
				builder.append(" L");
				builder.append(format(position));
			}
		}
		return builder.toString();
	}

}
