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

import java.text.MessageFormat;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.domainvalue.NullFlavor;
import ca.infoway.messagebuilder.error.Hl7Error;
import ca.infoway.messagebuilder.error.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.util.xml.NodeUtil;
import ca.infoway.messagebuilder.util.xml.XmlDescriber;
import ca.infoway.messagebuilder.xml.ConformanceLevel;
import ca.infoway.messagebuilder.xml.util.ConformanceLevelUtil;

public class NullFlavorHelper {
	
	public static final String MB_SUPPRESS_XSI_NIL_ON_NULLFLAVOR = "messagebuilder.suppress.xsi.nil.on.nullflavor";

	public static final String NULL_FLAVOR_ATTRIBUTE_NAME = "nullFlavor";
	private static final String NULL_FLAVOR_XSI_NIL_ATTRIBUTE_NAME = "xsi:nil";

	private final Node node;
	private final XmlToModelResult xmlToModelResult;
	private final ConformanceLevel conformanceLevel;
	private final boolean isAssociation;

	public NullFlavorHelper(ConformanceLevel conformanceLevel, Node node, XmlToModelResult xmlToModelResult, boolean isAssociation) {
		this.conformanceLevel = conformanceLevel;
		this.node = node;
		this.xmlToModelResult = xmlToModelResult;
		this.isAssociation = isAssociation;
	}

	public NullFlavor parseNullNode() {
		String attributeValue = getAttributeValue(node, NULL_FLAVOR_ATTRIBUTE_NAME);
		NullFlavor nullFlavor = CodeResolverRegistry.lookup(NullFlavor.class, attributeValue);
		
		if (ConformanceLevelUtil.isMandatory(this.conformanceLevel, null)) {
			xmlToModelResult.addHl7Error(Hl7Error.createMandatoryAttributeIsNullError(
					NodeUtil.getLocalOrTagName((Element) node), 
					getAttributeValue(node, NULL_FLAVOR_ATTRIBUTE_NAME),
					(Element) node));
//      RM #15431 - strictly speaking, nullFlavors are not allowed for REQUIRED fields. However, jurisdictions often ignore this restriction.
//      FIXME:  TM (see RM18424) - once MB has error levels implemented, this can be reinstated as a warning
//		} else if (this.conformanceLevel != null && this.conformanceLevel == ConformanceLevel.REQUIRED) {
//			xmlToModelResult.addHl7Error(Hl7Error.createRequiredAttributeIsNullError(
//					NodeUtil.getLocalOrTagName((Element) node), 
//					getAttributeValue(node, NULL_FLAVOR_ATTRIBUTE_NAME),
//					(Element) node));
		} else if (this.isAssociation && !StringUtils.equals(getAttributeValue(node, NULL_FLAVOR_XSI_NIL_ATTRIBUTE_NAME), "true")) {
			if (!Boolean.valueOf(System.getProperty(NullFlavorHelper.MB_SUPPRESS_XSI_NIL_ON_NULLFLAVOR))) {
				xmlToModelResult.addHl7Error(Hl7Error.createNullFlavorMissingXsiNilError(
						NodeUtil.getLocalOrTagName((Element) node), 
						(Element) node));
			}
		}
		return nullFlavor;
	}
	
    public boolean hasValidNullFlavorAttribute() {
		String attributeValue = getAttributeValue(node, NULL_FLAVOR_ATTRIBUTE_NAME);
		if (attributeValue==null) {
			return false;
		} else if (StringUtils.isEmpty(attributeValue) || CodeResolverRegistry.lookup(NullFlavor.class, attributeValue) == null) {
			xmlToModelResult.addHl7Error(
					new Hl7Error(Hl7ErrorCode.VALUE_NOT_IN_CODE_SYSTEM,
							MessageFormat.format("The nullFavor attribute value \"{0}\" is not valid ({1})", 
									attributeValue, 
									XmlDescriber.describeSingleElement((Element) node)),
									(Element) node));
			return false;
		}
		return true;
	}

	private String getAttributeValue(Node node, String attributeName) {
		return node != null && node instanceof Element ? getAttributeValue((Element) node, attributeName) : null;
	} 
	
	protected String getAttributeValue(Element node, String attributeName) {
		return node != null && node.hasAttribute(attributeName) ? node.getAttribute(attributeName) : null;
	}
	
}
