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

package ca.infoway.messagebuilder.datatype.lang;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.datatype.lang.util.PersonNamePartType;
import ca.infoway.messagebuilder.domainvalue.basic.EntityNameUse;

/**
 * <p>Java datatype used to back the HL7 PN datatype.
 * 
 * <p>Covers:
 * 
 * <p>PN (R2): Used to express person names for general identification and communication purposes
 * 
 * <p>PN.BASIC: Used to express person names for general identification and communication purposes.
 * 
 * <p>PN.SIMPLE: Used to express person names without name parts.
 * 
 * <p>PN.FULL: Used to express person names within a registry where full qualification is needed. 
 * 
 * <p>PN.SEARCH: This type is used to convey name information for searching purposes. All matches are considered to be "starts with" for each specified property. 
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - datatype - translated manually
 */
public class PersonName extends EntityName {

    /**
     * <p>Pulls out the (first) given name from the list of parts.
     * 
     * @return the given name
     */
	public String getGivenName() {
		List<EntityNamePart> parts = getPartsOfType(PersonNamePartType.GIVEN);
		return parts.isEmpty() ? null : parts.get(0).getValue();
	}
	
	/**
	 * <p>Pulls out the (first) family name from the list of parts.
	 * 
	 * @return the family name
	 */
	public String getFamilyName() {
		List<EntityNamePart> parts = getPartsOfType(PersonNamePartType.FAMILY);
		return parts.isEmpty() ? null : parts.get(0).getValue();
	}
	
	public List<EntityNamePart> getPartsOfType(PersonNamePartType type) {
		List<EntityNamePart> result = new ArrayList<EntityNamePart>();
		for (EntityNamePart part : getParts()) {
			if (type == part.getType()) {
				result.add(part);
			}
		}
		return result;
	}

	/**
	 * <p>Builds a PersonName from a supplied first and last name (each may be null).
	 * 
	 * @param firstName first name
	 * @param lastName last name
	 * @return the constructed PersonName
	 */
	public static PersonName createFirstNameLastName(String firstName, String lastName) {
		PersonName name = new PersonName();
		name.addUse(EntityNameUse.LEGAL);
		if (StringUtils.isNotBlank(firstName)) {
			name.addNamePart(new EntityNamePart(firstName, PersonNamePartType.GIVEN));
		}
		if (StringUtils.isNotBlank(lastName)) {
			name.addNamePart(new EntityNamePart(lastName, PersonNamePartType.FAMILY));
		}
		return name;
	}
	
}
