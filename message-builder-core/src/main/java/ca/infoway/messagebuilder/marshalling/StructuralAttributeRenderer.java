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

package ca.infoway.messagebuilder.marshalling;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.MarshallingException;
import ca.infoway.messagebuilder.datatype.lang.CodedTypeR2;
import ca.infoway.messagebuilder.error.Hl7Error;
import ca.infoway.messagebuilder.error.Hl7ErrorCode;
import ca.infoway.messagebuilder.error.Hl7Errors;
import ca.infoway.messagebuilder.lang.XmlStringEscape;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.util.ConformanceLevelUtil;

abstract class StructuralAttributeRenderer {
	
	protected final Relationship relationship;

	public StructuralAttributeRenderer(Relationship relationship) {
		this.relationship = relationship;
	}

	public void render(StringBuilder builder, String propertyPath, Hl7Errors errors) {
		Relationship r = this.relationship;
		if (r.hasFixedValue()) {
			formatFixedValue(builder, r);
		} else {
			Object value = getValue();
			// structural attributes should never have a conformance of populated, and should never have a nullFlavor (no need to check these cases)
			if (value == null && ConformanceLevelUtil.isMandatory(r) && r.hasDefaultValue()) {
				formatDefaultValue(builder, r);
			} else if (value != null) {
				formatValue(builder,r, value);
			} else if (ConformanceLevelUtil.isMandatory(this.relationship)) {
				String errorMessage = "Relationship " + r.getName()	+ " is mandatory (and not a fixed or default value), but no value is specified";
				Hl7Error error = new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, errorMessage, propertyPath);
				errors.addHl7Error(error);
			}
		}
	}

	protected abstract Object getValue();

	private void formatValue(StringBuilder builder, Relationship relationship, Object value) {
		builder.append(" ")
				.append(relationship.getName())
				.append("=\"")
				.append(XmlStringEscape.escape(valueAsString(value, relationship)))
				.append("\"");
	}

    private String valueAsString(Object value, Relationship relationship) {
        String type = relationship.getType();
        if (type == null) {
            throw new MarshallingException("Relationship " 
                    + relationship.getName()
                    + " has no type information");
        } else if ("CS".equals(type)) {
        	if (value instanceof CodedTypeR2) {
        		return ((CodedTypeR2<?>)value).getCodeValue(); 
        	} else if (value instanceof Code) {
        		return ((Code)value).getCodeValue();
        	} else {
        		throw new MarshallingException("Encountered value \"" + value + "\" of type " 
        				+ value.getClass().getName() + " when Code was expected (" 
        				+ relationship.getName() + ")");
        	}
        } else if ("BL".equals(type)) {
            return Boolean.TRUE.equals(value) ? "true" : "false";
        } else if ("ST".equals(type)) {
            return (String) value;
        } else {
            throw new MarshallingException("Cannot handle structural attribute string of type " 
            		+ type + " (" + relationship.getName() + ")");
        }
    }

	private void formatFixedValue(StringBuilder builder, Relationship relationship) {
		// suppress rendering of required or optional fixed values
		if (ConformanceLevelUtil.isMandatory(relationship) || ConformanceLevelUtil.isPopulated(relationship)) {
			builder.append(" ")
					.append(relationship.getName())
					.append("=\"")
					.append(XmlStringEscape.escape(relationship.getFixedValue()))
					.append("\"");
		}
	}
	
	private void formatDefaultValue(StringBuilder builder, Relationship relationship) {
		// suppress rendering of required or optional fixed values
		if (ConformanceLevelUtil.isMandatory(relationship) || ConformanceLevelUtil.isPopulated(relationship)) {
			builder.append(" ")
			.append(relationship.getName())
			.append("=\"")
			.append(XmlStringEscape.escape(relationship.getDefaultValue()))
			.append("\"");
		}
	}
}
