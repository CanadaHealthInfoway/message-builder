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

import java.util.StringTokenizer;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;

class FormattedStringUtil {

	static FormattedString formatHtml(String html, StyleProvider styleProvider) {
		FormattedString result = new FormattedString();
		
		TextFont textFont = styleProvider.getDefaultAttributeTextFont();
		
		boolean markup = false;
		for (StringTokenizer tokenizer = new StringTokenizer(html, "<>", true); tokenizer.hasMoreTokens(); ) {
			String token = tokenizer.nextToken();
			if ("<".equals(token)) {
				markup = true;
			} else if (">".equals(token)) {
				markup = false;
			} else if (markup) {
				// treat as HTML tag
				if ("p".equals(token) && !result.getSegments().isEmpty()) {
					result.addSegment("\n", textFont);
				} else if ("b".equals(token)) {
					textFont = styleProvider.getDefaultBoldTextFont();
				} else if ("/b".equals(token)) {
					textFont = styleProvider.getDefaultAttributeTextFont();
				} else if ("i".equals(token)) {
					textFont = styleProvider.getDefaultItalicAttributeTextFont();
				} else if ("/i".equals(token)) {
					textFont = styleProvider.getDefaultAttributeTextFont();
				}
			} else {
				for (String word : StringUtils.split(StringEscapeUtils.unescapeHtml(token).replace('\n', ' '))) {
					result.addSegment(word + " ", textFont);
				}
			}
		}
		return result;
	}

	static FormattedString formatHtmlAndFitToSpace(String html, StyleProvider styleProvider, int maxWidth, Padding padding, int indent) {
		FormattedString result = formatHtml(html, styleProvider);
		return styleProvider.assignTextBoundsAndMergeSegments(result, maxWidth, padding, indent);
	}
}
