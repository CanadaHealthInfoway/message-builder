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

package ca.infoway.messagebuilder.generator;


import static ca.infoway.messagebuilder.generator.NameHelper.qualifiyName;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;

import ca.infoway.messagebuilder.MifProcessingException;
import ca.infoway.messagebuilder.xml.MessagePartResolver;

public class TypeResolver {

	public String resolveSpecializationChildType(MessagePartResolver messageSet, Element specializationChild) {
		if (!"specializationChild".equals(specializationChild.getLocalName())) {
			throw new MifProcessingException("Programming error.  Element should be a <mif:specializationChild> but was " + specializationChild.getTagName());
		} else if (MifXPathHelper.isMifReferenceElementPresent(specializationChild) && !isExternalReference(specializationChild)) {
			String type = MifXPathHelper.getMifReferenceType(specializationChild);
			if (MifXPathHelper.isTypeDefinedInMif(type, specializationChild)) {
				return qualifiyName(specializationChild, type);
			} else {
				throw new MifProcessingException("Cannot resolve internal <mif:reference> to type \"" + type + "\"");
			}
		} else if (MifXPathHelper.isReferenceToOtherModelType(specializationChild)) {
			String generalizationTarget = MifXPathHelper.getGeneralizationTarget(specializationChild);
			return TypeResolver.getExternalType(messageSet, specializationChild,
					generalizationTarget);
		} else if (isSpecializedClass(specializationChild)) {
			String unqualifiedName = MifXPathHelper.getSpecializedClass(specializationChild);
			return NameHelper.qualifiyName(specializationChild, unqualifiedName);
		} else {
			String ownedEntryPoint = new MifXPathHelper().getOwnedEntryPoint(specializationChild.getOwnerDocument());
			throw new MifProcessingException("Error processing " + ownedEntryPoint + ":Cannot resolve type for specialization child.  Parent = " +
					getParentName(specializationChild));
		}
	}

	private boolean isSpecializedClass(Element specializationChild) {
		return StringUtils.isNotBlank(MifXPathHelper.getSpecializedClass(specializationChild));
	}

	private String getParentName(Element specializationChild) {
		return ((Element) specializationChild.getParentNode()).getAttribute("name");
	}

	static String getExternalType(MessagePartResolver messageSet,
			Element targetConnection, String generalizationTarget) {
		String rootType = messageSet.getPackageLocationRootType(generalizationTarget);
		if (StringUtils.isBlank(generalizationTarget)) {
			throw new MifProcessingException("target connection \"" + targetConnection.getAttribute("name") + "\" does not appear to have a generalization target");
		} else if (StringUtils.isBlank(rootType)) {
			throw new MifProcessingException("Package location \"" + generalizationTarget + "\" has no root type");
		} else {
			return rootType;
		}
	}

	private static boolean isExternalReference(Element targetConnection) {
		return StringUtils.isNotBlank(MifXPathHelper.getGeneralizationTarget(targetConnection));
	}
}
