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
package ca.infoway.demiftifier;

import ca.infoway.demiftifier.svgifier.BoundingBox;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.Relationship;

public class LayoutItemBuilder {
	
	public static final LayoutItemBuilder basicBuilder(MessagePart messagePart, PackageLocationLayout layout){
		return new LayoutItemBuilder(messagePart, layout);
	}

	public static final LayoutItemBuilder basicBuilder(MessagePartLayoutItem parent, MessagePart messagePart, PackageLocationLayout layout){
		return new LayoutItemBuilder(parent, messagePart, layout);
	}
	
	public static final LayoutItemBuilder basicBuilder(String messagePartName, PackageLocationLayout layout){
		MessagePart messagePart = MessagePartBuilder.basicBuilder(messagePartName).build();
		return new LayoutItemBuilder(messagePart, layout);
	}

	private final MessagePartLayoutItem layoutItem;

	private LayoutItemBuilder() {
		this.layoutItem = new MessagePartLayoutItem(null, null);
	}

	private LayoutItemBuilder(MessagePart messagePart, PackageLocationLayout layout) {
		this.layoutItem = new MessagePartLayoutItem(messagePart, layout);
	}
	
	private LayoutItemBuilder(MessagePartLayoutItem parent, MessagePart messagePart, PackageLocationLayout layout) {
		this.layoutItem = new MessagePartLayoutItem(parent, messagePart, layout);
	}
	
	public MessagePartLayoutItem build() {
		return this.layoutItem;
	}

	public LayoutItemBuilder withRelationshipName(String relationshipName) {
		Relationship relationship = new Relationship();
		relationship.setName(relationshipName);
		this.layoutItem.setInboundAssociation(new InboundAssociation(relationship, 0));
		return this;
	}

	public LayoutItemBuilder withRelationshipName(String relationshipName, String cmetBindingName) {
		Relationship relationship = new Relationship();
		relationship.setName(relationshipName);
		relationship.setCmetBindingName(cmetBindingName);
		this.layoutItem.setInboundAssociation(new InboundAssociation(relationship, 0));
		return this;
	}
	
	public LayoutItemBuilder withLogicalBoundingBox(BoundingBox logicalBoundingBox) {
		this.layoutItem.setLogicalX(logicalBoundingBox.getX());
		this.layoutItem.setLogicalY(logicalBoundingBox.getY());
		this.layoutItem.setHeight(logicalBoundingBox.getHeight());
		this.layoutItem.setWidth(logicalBoundingBox.getWidth());
		return this;
	}
}
