package ca.infoway.messagebuilder.generator;


import static ca.infoway.messagebuilder.generator.NameHelper.qualifiyName;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;

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
			// TODO: BCH/TM: better error message
			throw new MifProcessingException(specializationChild, "Cannot resolve type for specialization child.  Parent = " +
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
