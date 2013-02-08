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
 * Last modified: $LastChangedDate: 2012-07-27 18:36:10 -0400 (Fri, 27 Jul 2012) $
 * Revision:      $LastChangedRevision: 6001 $
 */

package ca.infoway.messagebuilder.marshalling.hl7;

import java.text.MessageFormat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.Hl7BaseVersion;
import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.lang.XmlStringEscape;

public class IiValidationUtils {

	public static final String II = "II";
	public static final String II_TOKEN = "II.TOKEN";
	public static final String II_BUS = "II.BUS";
	public static final String II_PUBLIC = "II.PUBLIC";
	public static final String II_OID = "II.OID";
	public static final String II_VER = "II.VER";
	public static final String II_BUS_AND_VER = "II.BUS_AND_VER";
	public static final String II_BUSVER = "II.BUSVER";
	public static final String II_PUBLICVER = "II.PUBLICVER";
	
	private static final Set<String> _concreteIiTypes = new HashSet<String>();
	public static final Set<String> concreteIiTypes = Collections.unmodifiableSet(_concreteIiTypes);
	static {
		_concreteIiTypes.add(II_TOKEN);
		_concreteIiTypes.add(II_BUS);
		_concreteIiTypes.add(II_PUBLIC);
		_concreteIiTypes.add(II_OID);
		_concreteIiTypes.add(II_VER);
		_concreteIiTypes.add(II_BUSVER);
		_concreteIiTypes.add(II_PUBLICVER);
	}
	
	private static final int EXTENSION_MAX_LENGTH = 20;
	private static final int ROOT_MAX_LENGTH = 200;
	private static final int ROOT_MAX_LENGTH_CERX = 100;

	public boolean isOid(String root) {
		if (StringUtils.isBlank(root) || !root.contains(".")) {
			return false;
		} else {
			boolean oid = true;
			while (root.contains(".")) {
				String prefix = StringUtils.substringBefore(root, ".");
				oid &= (StringUtils.isNotBlank(prefix) && StringUtils.isNumeric(prefix)); 
				root = StringUtils.substringAfter(root, ".");
			}
			
			if (StringUtils.isBlank(root)) {
				oid = false;
			} else {
				oid &= StringUtils.isNumeric(root);
			}
			
			return oid;
		}
	}
	
	public boolean isUuid(String root) {
		try {
			UUID.fromString(root);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public int getMaxRootLength(VersionNumber version) {
		return SpecificationVersion.isVersion(version, Hl7BaseVersion.CERX) ? ROOT_MAX_LENGTH_CERX : ROOT_MAX_LENGTH;
	}
	
	public boolean isRootLengthInvalid(String root, VersionNumber version) {
		return StringUtils.length(root) > getMaxRootLength(version);
	}
	
	public int getMaxExtensionLength() {
		return EXTENSION_MAX_LENGTH;
	}
	
	public boolean isExtensionLengthInvalid(String extension) {
		return StringUtils.length(extension) > getMaxExtensionLength();
	}

	public boolean isCerxOrMr2007(VersionNumber version) {
		return SpecificationVersion.isVersion(version, Hl7BaseVersion.MR2007) ||
			   SpecificationVersion.isVersion(version, Hl7BaseVersion.MR2007_V02R01) || 
			   SpecificationVersion.isVersion(version, Hl7BaseVersion.CERX);
	}

	public boolean isSpecializationTypeRequired(VersionNumber version, String type) {
		// AB does not treat II as abstract; for CeRx, II is concrete; Newfoundland is excepted to allow our legacy tests to pass
		return isIiBusAndVer(type) ||
				(isII(type) && 
						!(SpecificationVersion.isVersion(version, Hl7BaseVersion.CERX) || 
						  "NEWFOUNDLAND".equals(version == null ? null : version.getVersionLiteral()) ||
						  SpecificationVersion.isExactVersion(SpecificationVersion.V02R02_AB, version))
				);
	}

	public boolean isIiBusAndVer(String type) {
		return StandardDataType.II_BUS_AND_VER.getType().equals(type);
	}

	public boolean isIiBusOrIiVer(String type) {
		return StandardDataType.II_BUS.getType().equals(type) || StandardDataType.II_VER.getType().equals(type);
	}

	public boolean isII(String type) {
		return StandardDataType.II.getType().equals(type);
	}

	public String getInvalidOrMissingSpecializationTypeErrorMessage(String type) {
		String invalidOrMissing = StringUtils.isBlank(type) ? "Missing" : "Invalid";
		return invalidOrMissing + " specializationType" + (StringUtils.isBlank(type) ? "" : (" (" + type + ")")) + ". Field being left as II without a specializationType.";
	}

	public String getInvalidSpecializationTypeForBusAndVerErrorMessage(String specializationType, String type) {
		return "Specialization type must be II.BUS or II.VER; " + type + " will be assumed. Invalid specialization type " + specializationType;
	}

	public String getMissingAttributeErrorMessage(String type,	String attributeName, String attributeValue) {
		return MessageFormat.format("Data type " + type + " requires the attribute {0}=\"{1}\"", attributeName, XmlStringEscape.escape(attributeValue));
	}

	public String getIncorrectAttributeValueErrorMessage(String type, String attributeName, String attributeValue) {
		return MessageFormat.format("Data type " + type + " expected the attribute {0}=\"{1}\"", attributeName, XmlStringEscape.escape(attributeValue));
	}

	public String getRootMustBeUuidErrorMessage(String root) {
		return "root '" + root + "' should be a UUID.";
	}

	public String getInvalidRootLengthErrorMessage(String root, VersionNumber version) {
		return "root '" + root + "' exceeds maximum allowed length of " + getMaxRootLength(version) + ".";
	}

	public String getInvalidExtensionLengthErrorMessage(String extension) {
		return "extension '" + extension + "' exceeds maximum allowed length of " + getMaxExtensionLength() + ".";
	}

	public String getRootMustBeAnOidErrorMessage(String root) {
		return "The oid, \"" + root + "\" does not appear to be a valid oid";
	}
	
	public String getShouldNotProvideSpecializationTypeErrorMessage(String typeFromContext) {
		return "A specializationType should not be specified for non-abstract type: " + typeFromContext;
	}

}
