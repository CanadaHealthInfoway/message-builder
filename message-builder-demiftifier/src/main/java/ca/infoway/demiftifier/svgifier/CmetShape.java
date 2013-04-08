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

import org.apache.commons.lang.StringUtils;

import ca.infoway.demiftifier.MessagePartLayoutItem;
import ca.infoway.messagebuilder.xml.CmetBinding;

public class CmetShape extends MessagePartShape {
	
	public CmetShape(MessagePartLayoutItem item, StyleProvider styleProvider) {
		super(item, styleProvider);
	}
	protected StrokeType getStrokeType() {
		return StrokeType.SHORT_DASH;
	}

// BCH: Jason wants his CMETs to be canary-coloured and the khaki alarms him and makes him cry
//	@Override
//	protected Fill getFillColor() {
//		Fill fillColor = super.getFillColor();
//		return (fillColor instanceof ColorFill) && this.item.isDuplicate() ? ((ColorFill) fillColor).makeGrey() : fillColor;
//	}
//	
	@Override
	protected Alignment getAlignment() {
		return Alignment.CENTER;
	}

	protected void initializeLabels() {
		if (this.labels.isEmpty()) {
			
			FormattedString cmetString = new FormattedString();
			cmetString.addSegment("CMET: ", this.styleProvider.getDefaultBoldTextFont());
			cmetString.addSegment(getBindingCode(), this.styleProvider.getDefaultAttributeTextFont());
			this.styleProvider.assignTextBounds(cmetString, null);
			this.labels.add(cmetString);
			

			FormattedString alias = new FormattedString();
			alias.addSegment(getBindingAlias(), this.styleProvider.getDefaultBoldTextFont());
			this.styleProvider.assignTextBounds(alias, null);
			this.labels.add(alias);
			
			FormattedString attribution = new FormattedString();
			attribution.addSegment(getBindingAttribution(), this.styleProvider.getDefaultBoldTextFont());
			this.styleProvider.assignTextBounds(attribution, null);
			this.labels.add(attribution);
			
			FormattedString packageLocationName = new FormattedString();
			packageLocationName.addSegment("(" + this.item.getPackageLocation().getName() + ")", this.styleProvider.getDefaultNonProportionalTextFont());
			this.styleProvider.assignTextBounds(packageLocationName, null);
			this.labels.add(packageLocationName);
		}
	}

	private String getBindingCode() {
		CmetBinding cmetBinding = getCmetBinding();
		if (cmetBinding != null) {
			return "(" + cmetBinding.getCode() + ")";
		} else {
			return "";
		}
	}

	private String getBindingAlias() {
		CmetBinding cmetBinding = getCmetBinding();
		if (cmetBinding != null) {
			String cmetName = cmetBinding.getCmetName();
			String attribution = cmetBinding.getAttributionLevel();
			if (StringUtils.endsWithIgnoreCase(cmetName, attribution)) {
				cmetName = cmetName.substring(0, cmetName.length() - attribution.length());
			}
			return cmetName;
		} else {
			return "";
		}
	}
	private String getBindingAttribution() {
		CmetBinding cmetBinding = getCmetBinding();
		if (cmetBinding != null) {
			return "[" + cmetBinding.getAttributionLevel() + "]";
		} else {
			return "";
		}
	}
	private CmetBinding getCmetBinding() {
		if (this.item != null) {
			return this.item.getCmetBinding();
		} else {
			return null;
		}
	}
}
