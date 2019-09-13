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
 * Author:        $LastChangedBy: jroberts $
 * Last modified: $LastChangedDate: 2014-07-10 12:26:14 -0400 (Thu, 10 Jul 2014) $
 * Revision:      $LastChangedRevision: 8803 $
 */

package ca.infoway.messagebuilder.generator.cda;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.xml.ConstrainedDatatype;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.Relationship;

public class R1DatatypeHelper {

	public static void convertBaseDatatypesToPolymorphic(MessageSet messageSet) {
		for (MessagePart part : messageSet.getAllMessageParts()) {
			for (Relationship relationship : part.getRelationships()) {
				if (StringUtils.contains(relationship.getType(), "EIVL<TS>")) {
					// no transformation for this case, we just need to ensure it doesn't fall through to the TS case below
				} else if (StringUtils.contains(relationship.getType(), "PIVL<TS>")) {
					relationship.setType(StringUtils.replace(relationship.getType(), "PIVL<TS>", "PIVLTSCDAR1"));
				} else if (StringUtils.contains(relationship.getType(), "IVL<TS>")) {
					relationship.setType(StringUtils.replace(relationship.getType(), "IVL<TS>", "IVLTSCDAR1"));
				} else if (StringUtils.contains(relationship.getType(), "SXCM<TS>")) {
					relationship.setType(StringUtils.replace(relationship.getType(), "SXCM<TS>", "SXCMTSCDAR1"));
				} else if (StringUtils.equals(relationship.getType(), "TS") || StringUtils.contains(relationship.getType(), "<TS>")) {
					relationship.setType(StringUtils.replace(relationship.getType(), "TS", "TSCDAR1"));
				}

			}
		}
		
		for (ConstrainedDatatype constrainedType : messageSet.getAllConstrainedDatatypes()) {
			if (StringUtils.contains(constrainedType.getBaseType(), "EIVL<TS>")) {
				// no transformation for this case, we just need to ensure it doesn't fall through to the TS case below
			} else if (StringUtils.contains(constrainedType.getBaseType(), "PIVL<TS>")) {
				constrainedType.setBaseType(StringUtils.replace(constrainedType.getBaseType(), "PIVL<TS>", "PIVLTSCDAR1"));
			} else if (StringUtils.contains(constrainedType.getBaseType(), "IVL<TS>")) {
				constrainedType.setBaseType(StringUtils.replace(constrainedType.getBaseType(), "IVL<TS>", "IVLTSCDAR1"));
			} else if (StringUtils.contains(constrainedType.getBaseType(), "SXCM<TS>")) {
				constrainedType.setBaseType(StringUtils.replace(constrainedType.getBaseType(), "SXCM<TS>", "SXCMTSCDAR1"));
			} else if (StringUtils.equals(constrainedType.getBaseType(), "TS") || StringUtils.contains(constrainedType.getBaseType(), "<TS>")) {
				constrainedType.setBaseType(StringUtils.replace(constrainedType.getBaseType(), "TS", "TSCDAR1"));
			}
			
		}
	}
	
	public static void convertPolymorphicDatatypesToBaseTypes(MessageSet messageSet) {
		for (MessagePart part : messageSet.getAllMessageParts()) {
			for (Relationship relationship : part.getRelationships()) {
				if (StringUtils.contains(relationship.getType(), "PIVLTSCDAR1")) {
					relationship.setType(StringUtils.replace(relationship.getType(), "PIVLTSCDAR1", "PIVL<TS>"));
				} else if (StringUtils.contains(relationship.getType(), "IVLTSCDAR1")) {
					relationship.setType(StringUtils.replace(relationship.getType(), "IVLTSCDAR1", "IVL<TS>"));
				} else if (StringUtils.contains(relationship.getType(), "SXCMTSCDAR1")) {
					relationship.setType(StringUtils.replace(relationship.getType(), "SXCMTSCDAR1", "SXCM<TS>"));
				} else if (StringUtils.contains(relationship.getType(), "TSCDAR1")) {
					relationship.setType(StringUtils.replace(relationship.getType(), "TSCDAR1", "TS"));
				}

			}
		}
		
		for (ConstrainedDatatype constrainedType : messageSet.getAllConstrainedDatatypes()) {
			if (StringUtils.contains(constrainedType.getBaseType(), "PIVLTSCDAR1")) {
				constrainedType.setBaseType(StringUtils.replace(constrainedType.getBaseType(), "PIVLTSCDAR1", "PIVL<TS>"));
			} else if (StringUtils.contains(constrainedType.getBaseType(), "IVLTSCDAR1")) {
				constrainedType.setBaseType(StringUtils.replace(constrainedType.getBaseType(), "IVLTSCDAR1", "IVL<TS>"));
			} else if (StringUtils.contains(constrainedType.getBaseType(), "SXCMTSCDAR1")) {
				constrainedType.setBaseType(StringUtils.replace(constrainedType.getBaseType(), "SXCMTSCDAR1", "SXCM<TS>"));
			} else if (StringUtils.contains(constrainedType.getBaseType(), "TSCDAR1")) {
				constrainedType.setBaseType(StringUtils.replace(constrainedType.getBaseType(), "TSCDAR1", "TS"));
			}
			
		}
	}
	
	public static void convertSpecializedDatatypesToBaseTypes(MessageSet messageSet) {
		// TODO: This implementation covers all the actual cases that occur in the only pan-Canadian template that currently exists.
		//		since it is an open question whether specialized datatypes will ever be supported in other templates, it does not make
		//		sense at this time to extend the implementation to cover hypothetical cases.
		for (MessagePart part : messageSet.getAllMessageParts()) {
			for (Relationship relationship : part.getRelationships()) {
				if (relationship.isAttribute() && StringUtils.contains(relationship.getType(), ".")) {
					if (StringUtils.contains(relationship.getType(), ">")) {
						relationship.setType(StringUtils.substringBefore(relationship.getType(), ".") + ">");
					} else {
						relationship.setType(StringUtils.substringBefore(relationship.getType(), "."));
					}
				}
			}
		}
	}
}
