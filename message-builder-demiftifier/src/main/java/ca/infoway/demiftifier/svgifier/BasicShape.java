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
import java.util.List;

import org.apache.commons.lang.StringEscapeUtils;

abstract class BasicShape {

	public static final int TEXT_AREA_PADDING_LEFT = 5;
	public static final int TEXT_AREA_PADDING_RIGHT = 10;
	public static final int TEXT_AREA_PADDING_BOTTOM = 10;
	protected StyleProvider styleProvider;
	protected final List<FormattedString> labels = new ArrayList<FormattedString>();

	BasicShape(StyleProvider styleProvider) {
		this.styleProvider = styleProvider;
	}
	public void render(BoundingBox box, Writer writer) throws IOException {
		renderFullOutline(box, writer);
		renderText(box, writer);
	}
	protected void renderFullOutline(BoundingBox box, Writer writer)
			throws IOException {
		renderOutline(box, writer);
		
		writeStyle(writer);
		closeOutline(writer);
	}
	protected void closeOutline(Writer writer) throws IOException {
		writer.write(" />");
	}
	protected void renderOutline(BoundingBox box, Writer writer)
			throws IOException {
		writer.write("<rect x=\"" + box.getX() +
				"\" y=\"" + box.getY() +
				"\" height=\"" + box.getHeight() +
				"\" width=\"" + box.getWidth() +
				"\" class=\"outline\" ");
	}
	
	void writeStrokeStyle(Writer writer) throws IOException {
		getStrokeType().write(writer);
	}

	protected StrokeType getStrokeType() {
		return StrokeType.SOLID;
	}


	protected void writeStyle(Writer writer) throws IOException {
		writer.write("stroke=\"black\" stroke-width=\"" + getStrokeWeight() + 
				"\"  fill=\"" + getFillColor().toSvgString() + "\" ");
		writeStrokeStyle(writer);
	}

	protected int getStrokeWeight() {
		return 1;
	}

	protected Fill getFillColor() {
		return new ColorFill(Color.WHITE);
	}
	
	protected void renderText(BoundingBox box, Writer writer) throws IOException {
		writeLabels(box, getAlignment(), writer);
	}

	protected Alignment getAlignment() {
		return Alignment.LEFT;
	}
	
	protected abstract void initializeLabels();
	protected void writeLabels(BoundingBox box, Alignment alignment, Writer writer)
			throws IOException {
		writeFormattedStrings(this.labels, box, alignment, writer);
	}

	protected void writeFormattedStrings(List<FormattedString> formattedStrings, BoundingBox box, Alignment alignment, Writer writer)
			throws IOException {
		int y = 0;
		for (FormattedString string : formattedStrings) {
			int height = 0;
			int width = string.getBox().getWidth();
			int offset = computeHorizontalAlignmentOffset(box, alignment, width); 
			for (FormattedString.Segment segment : string.getSegments()) {
				height = Math.max(height, string.getBox().getHeight());
				if (!segment.isLineBreak()) {
					BoundingBox textBox = new BoundingBox(segment.getBox().getX() + box.getX() + offset, 
							segment.getBox().getY() + box.getY() + y, 
							segment.getBox().getHeight(), 
							segment.getBox().getWidth());
					writer.write("<text x=\"" + (alignment.getX(textBox)) + "\"" +
							" y=\"" + (textBox.getY() + textBox.getHeight()) + "\"" +
							segment.getFont().toSvgFontAttributes());
					alignment.writeSvg(writer);
					writer.write(">" + StringEscapeUtils.escapeXml(segment.getText()) + "</text>");
				}
			}
			y+= height;
		}
	}
	
	private int computeHorizontalAlignmentOffset(BoundingBox box, Alignment alignment, int width) {
		int result;
		if (alignment == Alignment.CENTER){
			result = (box.getWidth() - width) / 2;
		} else if (alignment == Alignment.RIGHT){
			result = box.getWidth() - width;
		} else {
			result = TEXT_AREA_PADDING_LEFT;
		}
		return result;
	}
	protected int writeLabel(BoundingBox box, String text, Writer writer, TextFont textFont) throws IOException {
		int textHeight = this.styleProvider.getTextHeight(text, textFont);
		writer.write("<text x=\"" + (box.getX() + TEXT_AREA_PADDING_LEFT) + "\"" +
				" y=\"" + (box.getY() + textHeight) + "\"" +
				textFont.toSvgFontAttributes() +
				">" + StringEscapeUtils.escapeXml(text) + "</text>");
		return textHeight;
	}
	
	BoundingBox getBounds() {
		initializeLabels();
		int contentsWidth = 0;
		int contentsHeight = 0;
		
		for (FormattedString formattedString : this.labels) {
			if (formattedString.getBox() == null) {
				this.styleProvider.assignTextBounds(formattedString);
			}
			contentsWidth = Math.max(formattedString.getBox().getWidth(), contentsWidth);
			contentsHeight += formattedString.getBox().getHeight();
		}
		
		return new BoundingBox(0, 0, contentsHeight, contentsWidth).withPadding(new Padding(0, TEXT_AREA_PADDING_LEFT, TEXT_AREA_PADDING_BOTTOM, TEXT_AREA_PADDING_RIGHT));
	}
}
