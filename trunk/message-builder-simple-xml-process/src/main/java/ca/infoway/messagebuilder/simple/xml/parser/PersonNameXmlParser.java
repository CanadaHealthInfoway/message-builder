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

package ca.infoway.messagebuilder.simple.xml.parser;

import static ca.infoway.messagebuilder.datatype.lang.util.PersonNamePartType.FAMILY;
import static ca.infoway.messagebuilder.datatype.lang.util.PersonNamePartType.GIVEN;
import static ca.infoway.messagebuilder.datatype.lang.util.PersonNamePartType.PREFIX;
import static ca.infoway.messagebuilder.datatype.lang.util.PersonNamePartType.SUFFIX;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.lang.EntityName;
import ca.infoway.messagebuilder.datatype.lang.EntityNamePart;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.util.NamePartType;
import ca.infoway.messagebuilder.datatype.lang.util.PersonNamePartType;
import ca.infoway.messagebuilder.domainvalue.EntityNameUse;
import ca.infoway.messagebuilder.lang.XmlStringEscape;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParseContext;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParser;

public class PersonNameXmlParser extends AbstractSimpleXmlParser<PN, PersonName> implements SimpleXmlParser<PN> {
	
	PersonNameXmlParser() {
		super();
	}

	@Override
	protected void doRenderNonNullValue(StringBuilder builder, SimpleXmlParseContext context, StandardDataType dataType, PersonName value) {
      if (value != null) {
    	  GivenNameDisambiguator disambiguator = new GivenNameDisambiguator();
          for (EntityNamePart namePart : value.getParts()) {
        	  
        	  if (StandardDataType.PN.equals(dataType) ||
	        	  StandardDataType.PN_BASIC.equals(dataType) ||
	        	  StandardDataType.PN_SIMPLE.equals(dataType) ||
	        	  StandardDataType.PN_FULL.equals(dataType)) {
        		  	appendBasicNamePart(builder, namePart, disambiguator);
        	  } else if (StandardDataType.PN_SEARCH.equals(dataType)) {
        		  appendSearchNamePart(builder, namePart);
        	  }
        	  
          }
      }
    }

    private void appendSearchNamePart(StringBuilder builder, EntityNamePart namePart) {
    	String partType = "";
        if (namePart.getType() != null) {
            String mappedNamePartType = mapPnSearchPartType(namePart.getType());
            partType = String.format(" partType=\"%s\"", mappedNamePartType);
        }
        String qualifier = "";
        if (namePart.getQualifier() != null) {
            qualifier = String.format(" qualifier=\"%s\"", namePart.getQualifier());
        }

        builder.append("<namePart");
        builder.append(partType);
        builder.append(qualifier);
        builder.append(">");
        builder.append(XmlStringEscape.escape(namePart.getValue()));
        builder.append("</namePart>");
    }

	private String mapPnSearchPartType(NamePartType namePartType) {
    	String mappedType = namePartType.getValue();
    	PersonNamePartType partType = (PersonNamePartType) namePartType;
    	
    	if (PREFIX.equals(partType)) {
    		mappedType = "PFX"; 
    	} else if (SUFFIX.equals(partType)) {
    		mappedType = "SFX"; 
    	} else if (FAMILY.equals(partType)) {
    		mappedType = "FAM"; 
    	} else if (GIVEN.equals(partType)) {
    		mappedType = "GIV";
    	}
    	
		return mappedType;

	}

	private void appendBasicNamePart(StringBuilder builder, EntityNamePart namePart, GivenNameDisambiguator disambiguator) {
        String openTag = "";
        String closeTag = "";
        
        if (namePart.getType() != null) {
            String mappedNamePartType = mapPnBasicPartTypeToElementName(namePart.getType(), disambiguator);
			openTag = "<" + mappedNamePartType + createQualifier(namePart.getQualifier()) + ">";
            closeTag = "</" + mappedNamePartType + ">";
        }

        builder.append(openTag);
        builder.append(XmlStringEscape.escape(namePart.getValue()));
        builder.append(closeTag);
    }
    
    private String createQualifier(String qualifier) {
		return StringUtils.isBlank(qualifier) ? "" : " qualifier=\"" + qualifier + "\"";
	}

	private String mapPnBasicPartTypeToElementName(NamePartType namePartType, GivenNameDisambiguator disambiguator) {
    	String mappedType = namePartType.getValue();
    	
    	PersonNamePartType partType = (PersonNamePartType) namePartType;
    	
    	if (PREFIX.equals(partType)) {
    		mappedType = "title"; 
    	} else if (SUFFIX.equals(partType)) {
    		mappedType = "suffix"; 
    	} else if (FAMILY.equals(partType)) {
    		mappedType = "lastName"; 
    	} else if (GIVEN.equals(partType)) {
    		if (disambiguator.timesGivenNameHasBeenMapped() == 0) {
    			mappedType = "firstName";
    		} else {
    			mappedType = "middleName";
    		}
    		disambiguator.incrementTimesGivenNameHasBeenMapped();
    	}
		return mappedType;
	}

    @Override
    protected Map<String, String> toNameValuePairs(StandardDataType dataType, PersonName value, SimpleXmlParseContext context) {
    	return getUseAttributeMap(value);
    }
    
	private Map<String, String> getUseAttributeMap(EntityName value) {
        String uses = "";
        for (EntityNameUse entityNameUse : value.getUses()) {
            uses += uses.length() == 0 ? "" : " ";
            uses += entityNameUse.getCodeValue();
        }
        Map<String, String> result = new LinkedHashMap<String, String>();
        
        if (uses.length() > 0) {
            result.put("use", uses);
        }
        return result;
    }

	@Override
	protected boolean closeStartElement(PN dataTypeInstance) {
		return false;
	}
	
}
