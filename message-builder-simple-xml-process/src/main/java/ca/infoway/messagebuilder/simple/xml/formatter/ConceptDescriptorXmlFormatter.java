/**
 * Copyright 2011 Canada Health Infoway, Inc.
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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.simple.xml.formatter;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.simple.xml.FormatContext;
import ca.infoway.messagebuilder.simple.xml.FormatterConfiguration;
import ca.infoway.messagebuilder.simple.xml.FormatterException;

public class ConceptDescriptorXmlFormatter extends AbstractCodedTypeXmlFormatter {
	
	protected ConceptDescriptorXmlFormatter(FormatterConfiguration configuration) {
		super(configuration, new TypeSupplier<CD>() {
			public CD get() {
				return new CDImpl();
			}
		});
	}

	@Override
	public CD format(FormatContext formatContext, Element value) throws FormatterException {
		CD cd = (CD) super.format(formatContext, value);
		
		// now look for extra properties only associated with CD or CD.LAB
		addDisplayName(cd, formatContext, value);
		addTranslations(cd, formatContext, value);
		
		return cd;
	}

	private void addTranslations(CD result, FormatContext formatContext, Element value) throws FormatterException {
		NodeList translations = value.getElementsByTagName("translation");
		for (int i = 0, length=translations.getLength(); i < length; i++) {
			Element translationElement = (Element) translations.item(i);
			CD translation = (CD) new ConceptDescriptorXmlFormatter(configuration).format(formatContext, translationElement);
			if (translation != null) {
				result.getTranslations().add(translation);
			}
		}
	}

	private void addDisplayName(CD result, FormatContext formatContext, Element value) {
		if (formatContext.matchesType(StandardDataType.CD_LAB)) {
			String displayName = StringUtils.trimToNull(value.getAttribute("displayName"));
			result.setDisplayName(displayName);
		}
	}
	
	
}
