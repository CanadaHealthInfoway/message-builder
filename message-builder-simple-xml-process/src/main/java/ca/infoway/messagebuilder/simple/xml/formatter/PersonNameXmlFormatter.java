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

package ca.infoway.messagebuilder.simple.xml.formatter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.lang.EntityNamePart;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.util.NamePartType;
import ca.infoway.messagebuilder.datatype.lang.util.PersonNamePartType;
import ca.infoway.messagebuilder.domainvalue.EntityNamePartQualifier;
import ca.infoway.messagebuilder.domainvalue.basic.EntityNameUse;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.simple.xml.FormatContext;
import ca.infoway.messagebuilder.simple.xml.FormatterConfiguration;
import ca.infoway.messagebuilder.simple.xml.FormatterException;

public class PersonNameXmlFormatter extends AbstractSimpleXmlFormatter {

	private Map<String, PersonNamePartType> partTypeMap = new HashMap<String, PersonNamePartType>();
	{
		this.partTypeMap.put("PFX", PersonNamePartType.PREFIX);
		this.partTypeMap.put("SFX", PersonNamePartType.SUFFIX);
		this.partTypeMap.put("FAM", PersonNamePartType.FAMILY);
		this.partTypeMap.put("GIV", PersonNamePartType.GIVEN);
	}
	
	protected PersonNameXmlFormatter(FormatterConfiguration configuration) {
		super(configuration);
	}

	public PN format(FormatContext formatContext, Element value) throws FormatterException {
		PN result = null;
		
		Set<EntityNameUse> nameUses = getNameUses(value.getAttribute("use"));
		if (!formatContext.matchesType(StandardDataType.PN_SEARCH) && nameUses.isEmpty()) {
			processError(formatContext, "Must provide at least one use for name", value);
		} else {
			PersonName personName = null;
			NodeList namePartNodes = value.getElementsByTagName("namePart");
			if (formatContext.matchesType(StandardDataType.PN_SIMPLE)) {
				personName = buildPersonNameSimple(value);
			} else if (namePartNodes.getLength() == 0) {
				personName = buildPersonNameFromSimplifiedElements(value);
			} else {
				personName = buildPersonNameFromNameParts(namePartNodes);
			}
			
			if (personName != null) {
				personName.getUses().addAll(nameUses);
				result = new PNImpl(personName);
			}
		}
		
		return result;
	}

	private PersonName buildPersonNameSimple(Element value) {
		// *could* parse the string to try to pull out various parts, but decided to keep things straighforward and keep full name under a single part
		String name = value.getTextContent();
		PersonName personName = new PersonName();
		personName.addNamePart(new EntityNamePart(name));
		return personName;
	}

	private PersonName buildPersonNameFromNameParts(NodeList namePartNodes) {
		PersonName personName = new PersonName();
		for (int i = 0, length = namePartNodes.getLength(); i < length; i++) {
			Element item = (Element) namePartNodes.item(i);
			
			String qualifierString = item.getAttribute("qualifier");
			String partTypeString = item.getAttribute("partType");
			NamePartType partType = this.partTypeMap.get(partTypeString);
			
			String textContent = item.getTextContent();
			
			EntityNamePartQualifier qualifier = CodeResolverRegistry.lookup(EntityNamePartQualifier.class, qualifierString);
			
			// TM - should handle empty content/unknown parttype (and qualifier)
			
			personName.getParts().add(new EntityNamePart(textContent, partType, qualifier));
		}
		return personName;
	}

	private PersonName buildPersonNameFromSimplifiedElements(Element value) {
		NodeList titleNodes = value.getElementsByTagName("title");
		NodeList firstNameNodes = value.getElementsByTagName("firstName");
		NodeList middleNameNodes = value.getElementsByTagName("middleName");
		NodeList lastNameNodes = value.getElementsByTagName("lastName");
		NodeList suffixNodes = value.getElementsByTagName("suffix");
		
		PersonName personName = new PersonName();
		addNameParts(titleNodes, personName, PersonNamePartType.PREFIX);
		addNameParts(firstNameNodes, personName, PersonNamePartType.GIVEN);
		addNameParts(middleNameNodes, personName, PersonNamePartType.GIVEN);
		addNameParts(lastNameNodes, personName, PersonNamePartType.FAMILY);
		addNameParts(suffixNodes, personName, PersonNamePartType.SUFFIX);
		
		return personName;
	}

	private void addNameParts(NodeList nodeList, PersonName personName, PersonNamePartType partType) {
		for (int i = 0, length = nodeList.getLength(); i < length; i++) {
			String partValue = nodeList.item(i).getTextContent();
			personName.getParts().add(new EntityNamePart(partValue, partType));
		}
	}

	// taken from AbstractEntityNameElementParser
   protected Set<EntityNameUse> getNameUses(String nameUseAttribute) {
        Set<EntityNameUse> uses = new HashSet<EntityNameUse>();
        if (nameUseAttribute != null) {
            StringTokenizer tokenizer = new StringTokenizer(nameUseAttribute);
            while (tokenizer.hasMoreElements()) {
                String token = tokenizer.nextToken();
                EntityNameUse nameUse = CodeResolverRegistry.lookup(EntityNameUse.class, token);
                // TM - should null be handled here at all? (throw exception?)
                if (nameUse != null) {
                    uses.add(nameUse);
                }
            }
        }
        return uses;
    }
}
