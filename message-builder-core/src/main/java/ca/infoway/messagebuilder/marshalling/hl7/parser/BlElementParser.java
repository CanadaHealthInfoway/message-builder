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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.marshalling.hl7.parser;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.error.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;

/**
 * Parses an BL element into a Boolean. The element looks like this:
 * 
 * &lt;element-name value="true" /&gt;	&lt;!-- or value="false" --&gt;
 * 
 * If a BL is null, value is replaced by a null flavor. So the element would look
 * like this:
 * 
 * &lt;element-name nullFlavor="something" /&gt;
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-BL
 */
@DataTypeHandler("BL")
public class BlElementParser extends AbstractSingleElementParser<Boolean> {

	private static List<String> VALID_BOOLEAN_STRINGS = new ArrayList<String>();
	
	static {
		VALID_BOOLEAN_STRINGS.add("true");
		VALID_BOOLEAN_STRINGS.add("false");
	}

	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
		return new BLImpl();
	}
	
	@Override
	protected Boolean parseNonNullNode(ParseContext context, Node node, BareANY result, Type expectedReturnType, XmlToModelResult xmlToModelResult) throws XmlToModelTransformationException {
		Element element = (Element) node;
		return parseBooleanValue(xmlToModelResult, getAttributeValue(element, "value"), element, null);
	}

	// public as a result of needing to call this method from ValidatingVistor
	public Boolean parseBooleanValue(XmlToModelResult result, String unparsedBoolean, Element element, Attr attr) {
		Boolean booleanResult = null;
		if (StringUtils.isBlank(unparsedBoolean)) {
			result.addHl7Error(Hl7Error.createMandatoryBooleanValueError(element, attr));
		} else if (VALID_BOOLEAN_STRINGS.contains(unparsedBoolean)) {
			booleanResult = Boolean.valueOf(unparsedBoolean);
		} else if (VALID_BOOLEAN_STRINGS.contains(unparsedBoolean.toLowerCase())) {
			result.addHl7Error(Hl7Error.createIncorrectCapitalizationBooleanValueError(unparsedBoolean, element, attr));
			booleanResult = Boolean.valueOf(unparsedBoolean);
		} else {
			result.addHl7Error(Hl7Error.createInvalidBooleanValueError(element, attr));
		}
		return booleanResult;
	}

}