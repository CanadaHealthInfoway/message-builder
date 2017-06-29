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
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.lang.EntityName;
import ca.infoway.messagebuilder.domainvalue.PostalAddressUse;
import ca.infoway.messagebuilder.domainvalue.basic.EntityNameUse;
import ca.infoway.messagebuilder.error.Hl7Error;
import ca.infoway.messagebuilder.error.Hl7ErrorCode;
import ca.infoway.messagebuilder.error.Hl7Errors;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;

abstract class AbstractEntityNameElementParser extends AbstractSingleElementParser<EntityName> implements NameParser {

	@Override
	protected EntityName parseNonNullNode(ParseContext context, Node node, BareANY parseResult, Type expectedReturnType, XmlToModelResult xmlToModelResult) throws XmlToModelTransformationException {
		EntityName result = parseNode(node, xmlToModelResult);
        result.getUses().addAll((getNameUses(getAttributeValue(node, "use"), (Element) node, xmlToModelResult)));
        validateName(result, context, (Element) node, xmlToModelResult);
		return result;
	}
    
    protected void validateName(EntityName result, ParseContext context, Element element, Hl7Errors errors) {
    	// leave this up to subclasses to decide if they want to do any validations
	}

	protected Set<EntityNameUse> getNameUses(String nameUseAttribute, Element element, XmlToModelResult xmlToModelResult) {
        Set<EntityNameUse> uses = Collections.synchronizedSet(new LinkedHashSet<EntityNameUse>());
        if (nameUseAttribute != null) {
            StringTokenizer tokenizer = new StringTokenizer(nameUseAttribute);
            while (tokenizer.hasMoreElements()) {
                String token = tokenizer.nextToken();
                EntityNameUse nameUse = CodeResolverRegistry.lookup(EntityNameUse.class, token);
                if (nameUse != null) {
                    uses.add(nameUse);
                } else {
                	xmlToModelResult.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, "Name use '" + token + "' not recognized.", element));
                }
            }
        }
        return uses;
    }
	
    protected abstract EntityName parseNode(Node node, XmlToModelResult xmlToModelResult) throws XmlToModelTransformationException;
   
    public boolean isParseable(Node node, ParseContext parseContext) {
        boolean result = false;
        try {
            parse(parseContext, node, new XmlToModelResult());
            result = true;
        } catch (XmlToModelTransformationException e) {
            // expected, sort of
        }
        return result;
    }
}
