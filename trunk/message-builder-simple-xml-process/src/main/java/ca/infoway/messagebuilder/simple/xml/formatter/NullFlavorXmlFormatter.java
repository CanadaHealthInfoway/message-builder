/**
 * Copyright 2012 Canada Health Infoway, Inc.
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

import org.w3c.dom.Element;

import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.simple.xml.FormatContext;
import ca.infoway.messagebuilder.simple.xml.FormatterConfiguration;
import ca.infoway.messagebuilder.simple.xml.FormatterException;

public class NullFlavorXmlFormatter extends AbstractSimpleXmlFormatter {
	
	protected NullFlavorXmlFormatter(FormatterConfiguration configuration) {
		super(configuration);
	}

	public NullFlavor format(FormatContext formatContext, Element value) throws FormatterException {
		String valueAttribute = value.getAttribute("value");
		NullFlavor nullFlavor = CodeResolverRegistry.lookup(NullFlavor.class, valueAttribute);
		if (nullFlavor == null) {
			processError(formatContext, "Null flavor \"" + valueAttribute + "\" does not appear to be valid", value);
			return NullFlavor.NO_INFORMATION;
		} else {
			return nullFlavor;
		}
	}
}
