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
import java.awt.Font;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

import ca.infoway.demiftifier.LayoutItem;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.RimClass;

class StyleProvider {
	
	private static final String FONT_FAMILY_HELVETICA = "Helvetica";

	private static final TextFont TEXT_FONT_NON_PROPORTIONAL = new TextFont(new Font("Courier New", Font.PLAIN, 10));
	private static final TextFont TEXT_FONT_ITEM_LABEL = new TextFont(new Font(FONT_FAMILY_HELVETICA, Font.BOLD, 16));
	private static final TextFont TEXT_FONT_ATTRIBUTE_NAME_MANDATORY = new TextFont(new Font(FONT_FAMILY_HELVETICA, Font.BOLD, 12));
	private static final TextFont TEXT_FONT_ATTRIBUTE_DEFAULT = new TextFont(new Font(FONT_FAMILY_HELVETICA, Font.PLAIN, 12));
	private static final TextFont TEXT_FONT_ATTRIBUTE_FIXED_VALUE = new TextFont(new Font(FONT_FAMILY_HELVETICA, Font.ITALIC, 12));
	private static final TextFont TEXT_FONT_CARDINALITY = new TextFont(new Font(FONT_FAMILY_HELVETICA, Font.PLAIN, 10));
	
	private final FontRenderContext fontRenderContext = new FontRenderContext(new AffineTransform(), true, true);
	
	public Fill getFillColor(LayoutItem layoutItem) {
		if (layoutItem == null) {
			return new ColorFill(Color.WHITE);
		} else {
			Color color = Color.WHITE;
			
			if (layoutItem.getRimClass() == RimClass.ENTITY) { 
				color = new Color(0x66, 0xff, 0x66);
			} else if (layoutItem.getRimClass() == RimClass.ROLE) {
				color = new Color(0xff, 0xff, 0x80);
			} else if (layoutItem.getRimClass() == RimClass.ROLE_LINK) {
				color = new Color(0xff, 0xff, 0xbb);
			} else if (layoutItem.getRimClass() == RimClass.PARTICIPATION) {
				color = new Color(0x80, 0xfe, 0xff);
			} else if (layoutItem.getRimClass() == RimClass.ACT) {
				color = new Color(0xff, 0x80, 0x80);
			} else if (layoutItem.getRimClass() == RimClass.ACT_RELATIONSHIP) {
				color = new Color(0xfc, 0xbb, 0xbd);
			} else if (layoutItem.getRimClass() == RimClass.OTHER_CLASS) {
				color = new Color(0x80, 0x7F, 0xfe);
			// CHOICE
			//	return new ColorFill(new Color(1.0F, 1.0F, 1.0F, 0.0F));
			} else {
				color = Color.CYAN;
			}
			return new ColorFill(color);
		}
	}

	public Color getStrokeColor(LayoutItem layoutItem) {
		return Color.BLACK;
	}

	public int getStrokeWeight(LayoutItem layoutItem) {
		return 1;
	}

	public TextFont getItemLabelTextFont() {
		return TEXT_FONT_ITEM_LABEL;
	}
	
	public TextFont getAttributeNameTextFont(Relationship attribute){
		return attribute.isMandatory() ? TEXT_FONT_ATTRIBUTE_NAME_MANDATORY : TEXT_FONT_ATTRIBUTE_DEFAULT;
	}

	public TextFont getDefaultAttributeTextFont() {
		return TEXT_FONT_ATTRIBUTE_DEFAULT;
	}
	
	public int getTextWidth(String text, TextFont textFont){
		Rectangle2D bounds = getBounds(text, textFont);
		return (int) Math.ceil(bounds.getWidth());
	}

	public int getTextHeight(String text, TextFont textFont){
		Rectangle2D bounds = getBounds(text, textFont);
		return toInt(bounds.getHeight());
	}

	private int toInt(double height) {
		return (int) Math.ceil(height);
	}

	private Rectangle2D getBounds(String text, TextFont textFont) {
		return textFont.getFont().getStringBounds(text, this.fontRenderContext);
	}

	public int getItemLabelTextHeight(String text) {
		return getTextHeight(text, getItemLabelTextFont());
	}
	
	BoundingBox assignTextBounds(FormattedString text) {
		return assignTextBounds(text, null);
	}
	BoundingBox assignTextBounds(FormattedString text, Padding padding) {
		return assignTextBounds(text, Integer.MAX_VALUE, padding, 10);
	}

	public TextFont getDefaultItalicAttributeTextFont() {
		return TEXT_FONT_ATTRIBUTE_FIXED_VALUE;
	}

	public TextFont getDefaultBoldTextFont() {
		return TEXT_FONT_ATTRIBUTE_NAME_MANDATORY;
	}
	
	public TextFont getDefaultNonProportionalTextFont() {
		return TEXT_FONT_NON_PROPORTIONAL;
	}

	public TextFont getCardinalityTextFont() {
		return TEXT_FONT_CARDINALITY;
	}

	public BoundingBox assignTextBounds(FormattedString text,
			int maxWidth, Padding padding, int indent) {
		BoundingBox box = new BoundingBox(0, 0, 0, 0);
		int y = 0;
		int x = 0;
		int lineWidth = 0;
		for (FormattedString.Segment segment : text.getSegments()) {
			if (segment.isLineBreak()) {
				y = box.getHeight();
				x = indent;
				lineWidth = indent;
			} else {
				Rectangle2D temp = getBounds(segment.getText(), segment.getFont());
				if (lineWidth + temp.getWidth() > maxWidth) {
					y = box.getHeight();
					x = indent;
					lineWidth = indent;
				}
				segment.setBox(new BoundingBox(x, y, toInt(temp.getHeight()), toInt(temp.getWidth())));
				lineWidth += segment.getBox().getWidth();
				box = new BoundingBox(0, 0, Math.max(toInt(temp.getHeight()) + y, box.getHeight()), 
						Math.max(lineWidth, box.getWidth()));
				x = segment.getBox().getX() + segment.getBox().getWidth();
			}
		}
		if (padding != null) {
			box = box.withPadding(padding);
		}
		text.setBox(box);
		return box;
	}
}
