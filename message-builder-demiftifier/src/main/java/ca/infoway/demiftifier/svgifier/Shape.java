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

import org.apache.commons.lang.StringUtils;

import ca.infoway.demiftifier.LayoutItem;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.Relationship;

public abstract class Shape extends BasicShape {

	protected static final int COLUMN_WIDTH_MINIMUM = 50;
	protected static final int ROW_HEIGHT_MINIMUM = 120;

	public static final int MARGIN_TOP = 10;
	public static final int MARGIN_BOTTOM = 10;
	public static final int PADDING_BETWEEN_LABEL_AND_ATTRIBUTES = 5;

	protected final LayoutItem item;
	protected final FormatterUtil formatterUtil = new FormatterUtil();
	protected InboundArrowShape inboundArrowShape = null;

	public Shape(LayoutItem item, StyleProvider styleProvider) {
		super(styleProvider);
		this.item = item;
	}
	void renderGroup(CoordinateSpace mapper, Writer writer) throws IOException {
		writer.write("<g>");
		render(mapper, writer);
		writer.write("</g>");
	}
	void render(CoordinateSpace mapper, Writer writer) throws IOException {
		render(mapper.getCoordinates(this.item), writer);
	}

	public void render(BoundingBox box, Writer writer) throws IOException {
		box = box.extractPadding(getMargins());
		if (hasInboundArrowShape()){
			this.inboundArrowShape.render(box, writer);
			box = adjustShapeBoundsToAccountForInboundArrow(box);
		}

		super.render(box, writer);
	}
	
	public boolean hasInboundArrowShape() {
		return this.inboundArrowShape != null;
	}
	
	private BoundingBox adjustShapeBoundsToAccountForInboundArrow(BoundingBox box) {
		return new BoundingBox(box.getX() + this.inboundArrowShape.getDisplacementRight(),
				box.getY() + this.inboundArrowShape.getDisplacementDown(),
				box.getHeight() - this.inboundArrowShape.getDisplacementDown(),
				box.getWidth()- this.inboundArrowShape.getDisplacementRight());
	}
	
	int getRightDisplacementToAccountForIncomingArrowShape(){
		return hasInboundArrowShape() ? this.inboundArrowShape.getDisplacementRight() : 0;
	}

	protected int getStrokeWeight() {
		return this.styleProvider.getStrokeWeight(this.item);
	}

	protected Fill getFillColor() {
		return this.styleProvider.getFillColor(this.item);
	}
	
	protected int calculateContentHeight() {
		initializeLabels();
		int contentsHeight = 0;
		for (FormattedString formattedString : this.labels) {
			contentsHeight += formattedString.getBox().getHeight();
		}
		
		if (hasInboundArrowShape()){
			contentsHeight += this.inboundArrowShape.getDisplacementDown();
		}
		return Shape.TEXT_AREA_PADDING_BOTTOM + contentsHeight;
	}

	protected FormattedString getFormattedAttributeText(Relationship attribute) {
		FormattedString result = new FormattedString();
		result.addSegment(attribute.getName() + ": ", this.styleProvider.getAttributeNameTextFont(attribute));
		if (!attribute.isStructural()) {
			if (!isCodedSimple(attribute)) {
				result.addSegment(attribute.getType(), this.styleProvider.getDefaultAttributeTextFont());
			}
			if (attribute.isCodedType() && !isCodedSimple(attribute) && attribute.getCodingStrength() != null) {
				result.addSegment(" " + attribute.getCodingStrength().getName(), this.styleProvider.getDefaultAttributeTextFont());
			}
			result.addSegment(" " + renderCardinality(attribute.getCardinality()), this.styleProvider.getDefaultAttributeTextFont());
			if (attribute.isCodedType() && StringUtils.isNotBlank(attribute.getDomainType())) {
				result.addSegment(" <= " + attribute.getDomainType(), this.styleProvider.getDefaultItalicAttributeTextFont());
			}
			if (attribute.getDocumentation() != null && StringUtils.isNotEmpty(attribute.getDocumentation().getBusinessName())) {
				result.addSegment(" (" + attribute.getDocumentation().getBusinessName() + ")", this.styleProvider.getDefaultAttributeTextFont());
			}
		}
		if (attribute.isFixed()) {
			result.addSegment("= \"" + attribute.getFixedValue() + "\"", this.styleProvider.getDefaultItalicAttributeTextFont());
		}
		return result;
	}

	private boolean isCodedSimple(Relationship attribute) {
		return StringUtils.equals(attribute.getType(), "CS");
	}
	
	private String renderCardinality(Cardinality cardinality) {
		return cardinality == null ? "" : ("[" + this.formatterUtil.format(cardinality) + "]");
	}

	int calculateMinimumWidth() {
		initializeLabels();
		int contentsWidth = 0;
		for (FormattedString formattedString : this.labels) {
			contentsWidth = Math.max(formattedString.getBox().getWidth(), contentsWidth);
		}
		contentsWidth += (Shape.TEXT_AREA_PADDING_LEFT + Shape.TEXT_AREA_PADDING_RIGHT);
		contentsWidth = contentsWidth < COLUMN_WIDTH_MINIMUM ? COLUMN_WIDTH_MINIMUM : contentsWidth;
		return hasInboundArrowShape() ? contentsWidth + this.inboundArrowShape.getDisplacementRight() : contentsWidth ;
	}

	protected void initializeLabels() {
		if (this.labels.isEmpty()) {
			FormattedString header = new FormattedString();
			header.addSegment(this.item.getLabel(), this.styleProvider.getItemLabelTextFont());
			this.styleProvider.assignTextBounds(header, 
					new Padding(0, 0, PADDING_BETWEEN_LABEL_AND_ATTRIBUTES, 0));
			this.labels.add(header);
			
			int alphabetWidth = this.styleProvider.getTextWidth("abcdefghijklmnopqrstuvwxyz", this.styleProvider.getDefaultAttributeTextFont());

			for (Relationship attribute : this.item.getAttributes()) {
				FormattedString formattedAttribute = getFormattedAttributeText(attribute);
				this.styleProvider.assignTextBounds(formattedAttribute, alphabetWidth * 2, null, 10);
				this.labels.add(formattedAttribute);
			}
		}
	}

	LayoutItem getItem() {
		return this.item;
	}
	
	public int getMinimalHeightForRow(CoordinateSpace mapper, int rowNumber) {
		return 0;
	}
	public BoundingBox getBounds() {
		BoundingBox contentBounds = new BoundingBox(0, 0, 
				calculateContentHeight(), calculateMinimumWidth());
		
		return contentBounds.withPadding(getMargins());
	}

	protected Padding getMargins() {
		int topMargin = this.inboundArrowShape == null ? MARGIN_TOP : 0; 
		return new Padding(topMargin, 0, MARGIN_BOTTOM, 0);
	}

	public void setInboundArrowShape(InboundArrowShape inboundArrowShape) {
		this.inboundArrowShape = inboundArrowShape;
	}
}
