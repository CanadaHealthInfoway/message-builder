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
 * Last modified: $LastChangedDate: 2014-02-14 11:22:06 -0500 (Fri, 14 Feb 2014) $
 * Revision:      $LastChangedRevision: 8399 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.formatter.r2;

import java.text.MessageFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.SystemUtils;

import ca.infoway.messagebuilder.datatype.impl.IVL_TSImpl;
import ca.infoway.messagebuilder.datatype.lang.DateInterval;
import ca.infoway.messagebuilder.datatype.lang.EntityName;
import ca.infoway.messagebuilder.datatype.lang.EntityNamePart;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.util.NamePartType;
import ca.infoway.messagebuilder.datatype.lang.util.OrganizationNamePartType;
import ca.infoway.messagebuilder.domainvalue.EntityNamePartQualifier;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;
import ca.infoway.messagebuilder.domainvalue.basic.EntityNameUse;
import ca.infoway.messagebuilder.error.Hl7Error;
import ca.infoway.messagebuilder.error.Hl7ErrorCode;
import ca.infoway.messagebuilder.lang.EnumPattern;
import ca.infoway.messagebuilder.lang.XmlStringEscape;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.AbstractNullFlavorPropertyFormatter;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContext;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContextImpl;
import ca.infoway.messagebuilder.util.text.Indenter;

/**
 * EN (R2) - EntityName; also handles PN (PersonName), ON (OrganizationName), and TN (TrivialName)
 *
 * Represents an EN/PN/ON/TN object as an element:
 *
 * &lt;element-name&gt;This is a trivial name&lt;/element-name&gt;
 *
 */
@DataTypeHandler({"EN", "PN", "ON", "TN"})
class EnR2PropertyFormatter extends AbstractNullFlavorPropertyFormatter<EntityName> {

	private final IvlTsR2PropertyFormatter validTimeFormatter = new IvlTsR2PropertyFormatter();
	
	@Override
	protected
	String formatNonNullValue(FormatContext context, EntityName entityName, int indentLevel) {
		
		validateName(entityName, context);
		
        StringBuffer buffer = new StringBuffer();
        if (entityName != null) {
            buffer.append(createElement(context, getUseAttributeMap(entityName), indentLevel, false, true));
            List<EntityNamePart> parts = entityName.getParts();
            for (int i = 0; i < parts.size(); i++) {
            	appendNamePart(buffer, parts.get(i), indentLevel + 1);
			}
            appendValidTime(buffer, entityName, context, indentLevel + 1);
            buffer.append(createElementClosure(context, indentLevel, true));
        }
        return buffer.toString();
    }
    
	private void appendNamePart(StringBuffer buffer, EntityNamePart namePart, int indentLevel) {
        String openTag = "";
        String closeTag = "";
        
        boolean valueProvided = namePart.getValue() != null;
        
        if (namePart.getType() != null) {
            openTag = "<" + namePart.getType().getValue() + addQualifier(namePart) + addNullFlavor(namePart) + (valueProvided ? "" : "/") + ">";
            closeTag = "</" + namePart.getType().getValue() + ">";
        }

       	Indenter.indentBuffer(buffer, indentLevel);
        buffer.append(openTag);
		if (valueProvided) {
	        buffer.append(XmlStringEscape.escape(namePart.getValue()));
	        buffer.append(closeTag);
        }
       	buffer.append(SystemUtils.LINE_SEPARATOR);
    }
    
	private void appendValidTime(StringBuffer buffer, EntityName value, FormatContext context, int indentLevel) {
		Interval<Date> validTime = value.getValidTime();
		if (validTime != null) {
			FormatContext ivlTsContext = new FormatContextImpl("IVL<TS>", "validTime", context);
			IVL_TSImpl ivlImpl = new IVL_TSImpl(new DateInterval(validTime));
			String formattedValidTime = this.validTimeFormatter.format(ivlTsContext, ivlImpl, indentLevel);
			buffer.append(formattedValidTime);
		}
	}

    private String addQualifier(EntityNamePart namePart) {
    	EntityNamePartQualifier qualifier = namePart.getQualifier();
		return qualifier == null || StringUtils.isBlank(qualifier.getCodeValue()) ? "" : " qualifier=\"" + qualifier.getCodeValue() + "\"";
	}

    private String addNullFlavor(EntityNamePart namePart) {
    	NullFlavor nullFlavor = namePart.getNullFlavor();
		return nullFlavor == null || StringUtils.isBlank(nullFlavor.getCodeValue()) ? "" : " nullFlavor=\"" + nullFlavor.getCodeValue() + "\"";
	}

	protected Map<String, String> getUseAttributeMap(EntityName value) {
        String uses = "";
        for (EntityNameUse entityNameUse : value.getUses()) {
            uses += uses.length() == 0 ? "" : " ";
            uses += entityNameUse.getCodeValue();
        }
        Map<String, String> result = new HashMap<String, String>();
        
        if (uses.length() > 0) {
            result.put("use", uses);
        }
        return result;
    }
	
	private void validateName(EntityName entityName, FormatContext context) {
		// EN - no validations
		// PN - no validations
		// ON - part types can only be delimiter/prefix/suffix
		// TN - only one part type allowed, with no type or qualifier; no uses
		
		if (StringUtils.equals("ON", context.getType())) {
			for (EntityNamePart entityNamePart : entityName.getParts()) {
				checkPartTypeForOn(entityNamePart.getType(), context);
			}
		}
		if (StringUtils.equals("TN", context.getType())) {
			checkNameForTn(entityName, context);
		}
	}

	private void checkNameForTn(EntityName entityName, FormatContext context) {
		int numParts = entityName.getParts().size();
		if (numParts > 1) {
			// only 1 allowed
			recordError(context, "TN values can only have one name part. Parts found: " + numParts);
		}
		if (numParts >= 1) {
			EntityNamePart tnPart = entityName.getParts().get(0);
			if (tnPart.getType() != null) {
				// no part types allowed
				recordError(context, "TN values can not have a name part type. Part type found: " + tnPart.getType().getValue());
			}
			if (tnPart.getQualifier() != null) {
				// no qualifier allowed
				recordError(context, "TN values can not have any qualifiers. Qualifier found: " + tnPart.getQualifier().getCodeValue());
			}
		}
		if (!entityName.getUses().isEmpty()) {
			// uses not allowed
			recordError(context, "TN values can not have any uses specified. Uses found: " + entityName.getUses().toString());
		}
		
	}

	private void checkPartTypeForOn(NamePartType type, FormatContext context) {
		// valid types are null, delimiter, prefix, suffix
		if (type != null) {
			OrganizationNamePartType onType = EnumPattern.valueOf(OrganizationNamePartType.class, StringUtils.upperCase(type.getValue()));
			if (onType == null) {
				recordError(context, MessageFormat.format("Name parts of type {0} are not valid for ON data types. Only delimiter, prefix, suffix, and free-format text are allowed.", type.getValue()));			
			}
		}
	}

	private void recordError(FormatContext context, String errorMessage) {
		context.getModelToXmlResult().addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, errorMessage, context.getPropertyPath()));
	}

}
