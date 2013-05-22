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

import ca.infoway.demiftifier.MessagePartLayoutItem;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.RimClass;

class CardinalityTextShape extends BasicShape {

	private static final int TEXT_PADDING_RIGHT = 3;
	private static final int TEXT_PADDING_BOTTOM = 3;

	private MessagePartLayoutItem messagePartItem;
	private FormatterUtil formatterUtil = new FormatterUtil();
	
	public CardinalityTextShape(MessagePartLayoutItem messagePartItem, StyleProvider styleProvider){
		super(styleProvider);
		this.messagePartItem = messagePartItem;
	}
	
	@Override
	public void render(BoundingBox box, Writer writer) throws IOException {
		super.render(box, writer);
	}
	
	@Override
	protected void renderOutline(BoundingBox box, Writer writer) throws IOException {
		//No opp
	}
	
	@Override
	protected void writeStyle(Writer writer) throws IOException {
		//No opp
	}

	@Override
	protected void initializeLabels() {
		if (this.labels.isEmpty()) {
			FormattedString cardinalityString = new FormattedString();
			if (this.messagePartItem.getInboundElement() != null){
				cardinalityString.addSegment(this.formatterUtil.format(this.messagePartItem.getInboundElement().getCardinality()) + " " +
						getOutgoingAssociationString(), this.styleProvider.getCardinalityTextFont());
			}
			this.styleProvider.assignTextBounds(cardinalityString, new Padding(0, TEXT_PADDING_RIGHT, TEXT_PADDING_BOTTOM, 0));
			this.labels.add(cardinalityString);
		}
	}

	private String getOutgoingAssociationString() {
		String result;
		if (this.messagePartItem.getRimClass() == RimClass.ACT_RELATIONSHIP ||
				this.messagePartItem.getRimClass() == RimClass.PARTICIPATION ||
				this.messagePartItem.getRimClass() == RimClass.ROLE_LINK ){
			Relationship outgoingAssociation = this.messagePartItem.getFirstOutgoingAssociation();
			result = outgoingAssociation == null ? "" : outgoingAssociation.getName();
		} else if (this.messagePartItem.getInboundElement() != null) {
			result = this.messagePartItem.getInboundElement().getName();
		} else {
			result = "";
		}
		return result;
	}


}
