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

import ca.infoway.demiftifier.EntryPointLayoutItem;
import ca.infoway.demiftifier.InboundAssociation;
import ca.infoway.demiftifier.Layout;
import ca.infoway.demiftifier.LayoutItem;
import ca.infoway.demiftifier.MessagePartLayoutItem;
import ca.infoway.messagebuilder.xml.RimClass;

class Diagram implements ShapeFactory {

	private List<Shape> shapes = new ArrayList<Shape>();
	private StyleProvider styleProvider;

	public Diagram(Layout layout, StyleProvider styleProvider) {
		this.styleProvider = styleProvider;
		for (LayoutItem layoutItem : layout.getItems()) {
			this.shapes.add(getShape(layoutItem));
		}
	}

	public Shape getShape(LayoutItem item) {
		Shape result;
		if (item instanceof EntryPointLayoutItem) {
			result = new EntryPointShape((EntryPointLayoutItem) item, this.styleProvider);
		} else if (mapsToConnectorTypeShape(item)) {
			result = new ConnectorTypeShape((MessagePartLayoutItem) item, this.styleProvider);
		} else if (item.isCmet()) {
			result = new CmetShape((MessagePartLayoutItem) item, this.styleProvider);
		} else if ((item instanceof MessagePartLayoutItem) && item.isAbstract()) {
			result = new ChoiceShape((MessagePartLayoutItem) item, this.styleProvider, this);
		} else {
			result = new BoxShape((MessagePartLayoutItem) item, this.styleProvider);
		}
		addInboundArrowShapeAsRequired(item, result);
		return result;
	}

	private boolean mapsToConnectorTypeShape(LayoutItem item) {
		return item.getRimClass() == RimClass.ACT_RELATIONSHIP || item.getRimClass() == RimClass.PARTICIPATION || item.getRimClass() == RimClass.ROLE_LINK;
	}

	public List<Shape> getShapes() {
		return this.shapes;
	}
	
	private void addInboundArrowShapeAsRequired(LayoutItem layoutItem, Shape shape){
		if (layoutItem instanceof MessagePartLayoutItem ) {
			MessagePartLayoutItem messagePartLayoutItem = (MessagePartLayoutItem) layoutItem;
			InboundAssociation inboundAssociation = messagePartLayoutItem.getInboundAssociation();
			if (inboundAssociation != null && inboundAssociation.isWithArrow()) {
				shape.setInboundArrowShape(new InboundArrowShape(messagePartLayoutItem, styleProvider));
			}
		}

	}
}
