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

package ca.infoway.messagebuilder.marshalling.hl7;

import static ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode.DATA_TYPE_ERROR;
import static ca.infoway.messagebuilder.util.xml.XmlDescriber.describeSingleElement;

import java.text.MessageFormat;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.util.xml.NodeUtil;
import ca.infoway.messagebuilder.util.xml.XmlDescriber;
import ca.infoway.messagebuilder.xml.Cardinality;

public class Hl7Error {
	private final Hl7ErrorCode hl7ErrorCode;
	private final String message;
	private final String path;
	private String beanPath; // must be set explicitly - later - when passing in an xpath
	
	public Hl7Error(Hl7ErrorCode hl7ErrorCode, String message) {
		this(hl7ErrorCode, message, (String) null);
	}
	public Hl7Error(Hl7ErrorCode hl7ErrorCode, String message, String beanPath) {
		this.hl7ErrorCode = hl7ErrorCode;
		this.message = message;
		this.path = null;
		this.beanPath = beanPath;
	}
	public Hl7Error(Hl7ErrorCode hl7ErrorCode, String message, Element element) {
		this(hl7ErrorCode, message, (Node) element);
	}
	public Hl7Error(Hl7ErrorCode hl7ErrorCode, String message, Attr attr) {
		this(hl7ErrorCode, message, (Node) attr);
	}
	private Hl7Error(Hl7ErrorCode hl7ErrorCode, String message, Node node) {
		this.hl7ErrorCode = hl7ErrorCode;
		this.message = message;
		this.path = XmlDescriber.describePath(node);
	}
	
	public Hl7ErrorCode getHl7ErrorCode() {
		return hl7ErrorCode;
	}
	public String getMessage() {
		return message;
	}
	
	public String getPath() {
		return this.path;
	}

	public String getBeanPath() {
		return this.beanPath;
	}
	public void setBeanPath(String beanPath) {
		this.beanPath = beanPath;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		} else if (getClass() != obj.getClass()) {
			return false;
		} else {
			Hl7Error that = (Hl7Error) obj;
			return new EqualsBuilder()
					.append(this.hl7ErrorCode, that.hl7ErrorCode)
					.append(this.message, that.message)
					.append(this.path, that.path)
					.isEquals();
		}
	}

    @Override
	public int hashCode() {
		return new HashCodeBuilder()
			.append(this.hl7ErrorCode)
			.append(this.message)
			.append(this.path)
			.toHashCode();
	}
    
    @Override
    public String toString() {
    	return this.hl7ErrorCode + " > " + this.message;
    }

    /**
     * <p>This error message is used when a mandatory attribute is missing from an 
     * XML element.
     * 
     * @param name - the name of the mandatory attribute
     * @param base - the element that should provide the attribute, but does not.
     * @return an HL7 error object
     */
	public static Hl7Error createMissingMandatoryAttributeError(String name, Element base) {
		return new Hl7Error(Hl7ErrorCode.MANDATORY_FIELD_NOT_PROVIDED, 
				MessageFormat.format("Expected mandatory attribute \"{0}\" for element ({1})",
						name, describeSingleElement(base)), base);
	}
	public static Hl7Error createMissingPopulatedAttributeError(String name, Element base) {
		return new Hl7Error(Hl7ErrorCode.MANDATORY_FIELD_NOT_PROVIDED, 
				MessageFormat.format("Expected populated attribute \"{0}\" for element ({1})",
						name, describeSingleElement(base)), base);
	}
	public static Hl7Error createInvalidFixedValueAttributeError(Attr attr,
			String fixedValue) {
		return new Hl7Error(Hl7ErrorCode.SYNTAX_ERROR,
				MessageFormat.format("Fixed attribute \"{0}\" should have a value of \"{1}\" but was \"{2}\"",
						attr.getName(), fixedValue, attr.getValue()), attr);
	}
	public static Hl7Error createInvalidBooleanValueError(Element element, Attr attr) {
		return new Hl7Error(DATA_TYPE_ERROR, 
				MessageFormat.format(
					"Expected BL type to have value of either \"true\" or \"false\" ({0})",
					describeSingleElement(element)), chooseNonNullCase(element, attr));
	}
	private static Node chooseNonNullCase(Element element, Attr attr) {
		return attr == null ? (Node) element : (Node) attr;
	}
	public static Hl7Error createIncorrectCapitalizationBooleanValueError(
			String unparsedBoolean, Element element, Attr attr) {
		return new Hl7Error(DATA_TYPE_ERROR, 
			MessageFormat.format("BL type is case sensitive.  Please use \"{0}\" instead of \"{1}\" ({2})",
				unparsedBoolean.toLowerCase(), 
				unparsedBoolean,
				describeSingleElement(element)),
			chooseNonNullCase(element, attr));
	}
	public static Hl7Error createMandatoryBooleanValueError(Element element, Attr attr) {
		return new Hl7Error(DATA_TYPE_ERROR, 
				MessageFormat.format(
				"BL value is mandatory, and must be either \"true\" or \"false\" ({0})", 
				describeSingleElement(element)), 
			chooseNonNullCase(element, attr));
	}
	public static Hl7Error createUnknownStructuralTypeError(String type, String name,
			Element base, Attr attr) {
		return new Hl7Error(DATA_TYPE_ERROR, 
				MessageFormat.format(
					"Cannot handle structural attribute \"{0}\" of type \"{1}\" ({2})", 
					describeSingleElement(base)), 
				attr);
	}
	public static Hl7Error createInvalidTypeError(String specializationType, String parentType, Element element) {
		return new Hl7Error(DATA_TYPE_ERROR, 
				MessageFormat.format(
					"Cannot support properties of type \"{0}\" for \"{1}\"", 
					specializationType, parentType),
					element);
	}
	public static Hl7Error createEmptyCodeValueError(Element base, Attr attr) {
		return new Hl7Error(DATA_TYPE_ERROR, 
				MessageFormat.format(
						"CS code must be provided ({0})", 
						describeSingleElement(base)), 
					chooseNonNullCase(base, attr));
	}
	public static Hl7Error createUnknownStructuralAttributeError(Element base, Attr attr) {
		return new Hl7Error(DATA_TYPE_ERROR, 
				MessageFormat.format(
						"Unknown structural attribute \"{0}\".  Attribute cannot be mapped to any relationship in the message. ({1})", 
						attr.getName(),
						describeSingleElement(base)), 
					attr);
	}
	public static Hl7Error createMissingMandatoryAssociationError(String xmlName, Element base) {
		return new Hl7Error(Hl7ErrorCode.MANDATORY_FIELD_NOT_PROVIDED, 
				MessageFormat.format("Expected mandatory association \"{0}\" for element ({1})",
						xmlName, describeSingleElement(base)), base);
	}
	public static Hl7Error createMissingPopulatedAssociationError(String xmlName, Element base) {
		return new Hl7Error(Hl7ErrorCode.MANDATORY_FIELD_NOT_PROVIDED, 
				MessageFormat.format("Expected populated association \"{0}\" for element ({1})",
						xmlName, describeSingleElement(base)), base);
	}
	public static Hl7Error createWrongNumberOfAssociationsError(String xmlName,
			Element base, int size, Cardinality cardinality) {
		return new Hl7Error(Hl7ErrorCode.NUMBER_OF_ASSOCIATIONS_EXCEEDS_LIMIT, 
				MessageFormat.format("Association \"{0}\" has a cardinality of \"{1}\", but {2} occurences were found ({3}) ",
						xmlName, cardinality, size, describeSingleElement(base)), base);
	}
	public static Hl7Error createMissingNamespace(String xmlNamespace, Element documentElement) {
		return new Hl7Error(Hl7ErrorCode.SYNTAX_ERROR, 
				MessageFormat.format("Message should define namespace \"\" ({0}) ",
						describeSingleElement(documentElement)), documentElement);
	}
	public static Hl7Error createUnknownChildElementError(Element element) {
		return new Hl7Error(Hl7ErrorCode.SYNTAX_ERROR,
				MessageFormat.format("Unknown child element \"{0}\" will be ignored.", NodeUtil.getLocalOrTagName(element)), 
				element);
	}
	public static Hl7Error createUnknownInteractionError(String interactionId, Element element) {
		return new Hl7Error(Hl7ErrorCode.UNSUPPORTED_INTERACTION,
				MessageFormat.format("Unknown interaction \"{0}\".", interactionId), element);
	}
	public static Hl7Error createMandatoryAttributeIsNullError(String elementName, String nullFlavor, Element element) {
		return new Hl7Error(Hl7ErrorCode.MANDATORY_FIELD_NOT_PROVIDED,
				MessageFormat.format("Attribute \"{0}\" is mandatory, but is specified as nullFlavor=\"{1}\".", elementName, nullFlavor), 
				element);
	}
	public static Hl7Error createRequiredAttributeIsNullError(String elementName, String nullFlavor, Element element) {
		return new Hl7Error(Hl7ErrorCode.MANDATORY_FIELD_NOT_PROVIDED,
				MessageFormat.format("Attribute \"{0}\" is required, but is specified as nullFlavor=\"{1}\".", elementName, nullFlavor), 
				element);
	}
	public static Hl7Error createNullFlavorMissingXsiNilError(String elementName, Element element) {
		return new Hl7Error(Hl7ErrorCode.MANDATORY_FIELD_NOT_PROVIDED,
				MessageFormat.format("Association \"{0}\" has a nullFlavor, but does not specify xsi:nil=\"true\".", elementName), 
				element);
	}
}
