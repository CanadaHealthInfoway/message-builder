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
package ca.infoway.messagebuilder.datatype.mif;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root(strict=false)
@Namespace(prefix="mif",reference="urn:hl7-org:v3/mif2")
public class MifText {
	private static final String PARAGRAPH_CLOSE_TAG = "</p>";

	private static final String PARAGRAPH_OPEN_TAG = "<p>";

	@ElementList(entry="p",data=true,inline=true,required=false,name="p")
	private List<MifHttpParagraph> paragraphs = new ArrayList<MifHttpParagraph>();

	private String value;
	
	public MifText(){}
	
	public MifText(String text) {
		if (text.indexOf(PARAGRAPH_OPEN_TAG) < 0) {
			this.value = text;
		} else {
			String[] textParts = text.split(PARAGRAPH_OPEN_TAG);
			if (textParts.length > 1) {
				for (String textPart : textParts) {
					if (StringUtils.isBlank(textPart)) { continue; }
					int endIndex = textPart.indexOf(PARAGRAPH_CLOSE_TAG);
					if (endIndex > 0) {
						textPart = textPart.substring(0, endIndex);
						this.paragraphs.add(new MifHttpParagraph(textPart));
					}
				}
			} else {
				this.paragraphs.add(new MifHttpParagraph(textParts[0]));
			}
		}
	}

	public List<MifHttpParagraph> getParagraphs() {
		return paragraphs;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String text) {
		this.value = text;
	}	
}
