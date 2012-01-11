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

package ca.infoway.messagebuilder.marshalling.hl7.parser;

import java.lang.reflect.Type;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.RTOImpl;
import ca.infoway.messagebuilder.datatype.lang.Ratio;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.util.xml.NodeUtil;

public abstract class AbstractRtoElementParser<N, D> extends AbstractSingleElementParser<Ratio<N, D>> {

    @Override
	protected Ratio<N, D> parseNonNullNode(ParseContext context, Node node, BareANY parseResult, Type expectedReturnType, XmlToModelResult xmlToModelResult) throws XmlToModelTransformationException {

        Ratio<N, D> result = new Ratio<N, D>();
        
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node childNode = childNodes.item(i);
            if (childNode instanceof Element) {
                Element element = (Element) childNode;
                String name = NodeUtil.getLocalOrTagName(element);
                if ("numerator".equals(name)) {
                    result.setNumerator(getNumeratorValue(element));
                } else if ("denominator".equals(name)) {
                    result.setDenominator(getDenominatorValue(element));
                }
            }
        }
        return result;
    }

    protected abstract N getNumeratorValue(Element element) throws XmlToModelTransformationException;
    protected abstract D getDenominatorValue(Element element) throws XmlToModelTransformationException;

	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
		return new RTOImpl<N, D>();
	}

}
