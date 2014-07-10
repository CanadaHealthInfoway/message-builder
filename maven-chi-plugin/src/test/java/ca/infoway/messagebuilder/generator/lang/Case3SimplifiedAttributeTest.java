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
 * Last modified: $LastChangedDate: 2013-01-02 17:05:34 -0500 (Wed, 02 Jan 2013) $
 * Revision:      $LastChangedRevision: 6471 $
 */

package ca.infoway.messagebuilder.generator.lang;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;

import ca.infoway.messagebuilder.generator.TypeConverter;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.TypeName;


public class Case3SimplifiedAttributeTest {

	private TypeConverter converter = new TypeConverter();
	
	@Test
	public void shouldReplaceDataType() throws Exception {
		Relationship relationship1 = new Relationship("profileId", "SET<II.OID>", Cardinality.create("0-20"));
		Attribute attribute1 = new Attribute(relationship1, this.converter.convertToType(relationship1));
		
		Relationship relationship2 = new Relationship("profileId", "LIST<II.BUS>", Cardinality.create("0-20"));
		Attribute attribute2 = new Attribute(relationship2, this.converter.convertToType(relationship2));
		
		HashMap<TypeName,BaseRelationship> map = new HashMap<TypeName,BaseRelationship>();
		map.put(new TypeName("MCCI_MT000100CA.Message"), attribute1);
		map.put(new TypeName("MCCI_MT002100CA.Message"), attribute2);
		Case3SimplifiedAttribute attribute = new Case3SimplifiedAttribute(attribute1, map);
		
		assertEquals("data type", 
				this.converter.convertToType("COLLECTION<II>", null).getTypeName(),
				attribute.getDataType().getTypeName());
	}
}
