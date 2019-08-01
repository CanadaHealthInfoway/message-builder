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
 * Last modified: $LastChangedDate: 2012-01-10 18:22:14 -0500 (Tue, 10 Jan 2012) $
 * Revision:      $LastChangedRevision: 3229 $
 */
package ca.infoway.messagebuilder.xml;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public class CodedTypeEvaluator {

	private CodedTypeEvaluator() {
	}
	
	/**
	 * This checks if a given type is a coded type. This also works for collection types (e.g. LIST&lt;CD&gt; is a coded type).
	 * 
	 * @param type
	 * @return whether the type is a coded type
	 */
	public static boolean isCodedType(String type) {
		if (StringUtils.isBlank(type)) {
			return false;
		}
		
		Hl7TypeName parsedType = Hl7TypeName.parse(type);
		
		Hl7TypeName typeToCheck = parsedType;
		if (isCollectionType(typeToCheck)) {
			List<Hl7TypeName> parsedTypeParameters = parsedType.getParameters();
			if (parsedTypeParameters.size() == 1) {
				typeToCheck = parsedTypeParameters.get(0);
			}
		}
		
		List<Hl7TypeName> parameters = typeToCheck.getParameters();
		if (parameters.size() == 1) {
			typeToCheck = parameters.get(0);
		}
		
		String rootType = typeToCheck.getRootName();
		
		// FIXME - CDA - TM - SC (for R1) is not a coded type (though it likely should be modified to be one)
		return Arrays.asList("CD", "CV", "CE", "CO", "SC", "CS", "PQR").contains(rootType);
	}
	
	public static String getR2CodedType(String type) {
		String r2Type = type;
		if (isCodedType(type)) {
			if ("CD".equals(type) || "CV".equals(type) || "CE".equals(type) || "SC".equals(type) || "CS".equals(type)) {
				r2Type = type + "_R2";
			}
		}
		return r2Type;
	}

	private static boolean isCollectionType(Hl7TypeName typeToCheck) {
		return Arrays.asList("LIST", "SET", "BAG", "COLLECTION").contains(typeToCheck.getRootName());
	}
	
}
