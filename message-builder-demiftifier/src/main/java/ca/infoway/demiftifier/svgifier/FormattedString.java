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
import java.util.List;

class FormattedString {

	class Segment {
		public Segment(String text, TextFont textFont) {
			this.text = text;
			this.font = textFont;
		}
		
		private String text;
		private TextFont font;
		private BoundingBox box;
		
		String getText() {
			return text;
		}

		TextFont getFont() {
			return font;
		}

		BoundingBox getBox() {
			return box;
		}
		void setBox(BoundingBox boundingBox) {
			this.box = boundingBox;
		}

		public boolean isLineBreak() {
			return "\n".equals(getText());
		}
	}
	
	private List<Segment> segments = new ArrayList<Segment>();
	private BoundingBox box;
	
	void addSegment(String text, TextFont textFont) {
		this.segments.add(new Segment(text, textFont));
	}

	List<Segment> getSegments() {
		return segments;
	}

	BoundingBox getBox() {
		return box;
	}
	void setBox(BoundingBox boundingBox) {
		this.box = boundingBox;
	}

	public void addLineBreak() {
		this.segments.add(new Segment("\n", null));
	}
}
