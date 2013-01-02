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

package ca.infoway.messagebuilder.generator.java;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.Relationship;


public class OrderedSimplifiableTypeProviderTest {
	
	
	@Test
	public void shouldOrderByLayers() throws Exception {
		
		SimplifiableType type1 = new SimplifiableType(new MessagePart("ABCD_MT123456CA.Patient"), false);
		SimplifiableType type2 = new SimplifiableType(new MessagePart("ABCD_MT123456CA.Person"), false);
		SimplifiableType type3 = new SimplifiableType(new MessagePart("ABCD_MT123456CA.PersonalRelationship"), false);
		
		type1.getMessagePart().getRelationships().add(new Relationship("person", type2.getName(), Cardinality.create("1")));
		type1.getMessagePart().getRelationships().add(new Relationship("nextOfKin", type3.getName(), Cardinality.create("0-50")));
		
		type3.getMessagePart().getRelationships().add(new Relationship("person", type2.getName(), Cardinality.create("1")));
		
		SimplifiableDefinitions definitions = new SimplifiableDefinitions();
		definitions.addType(type1);
		definitions.addType(type2);
		definitions.addType(type3);
		
		SimplifiableTypeProvider provider = OrderedSimplifiableTypeProvider.create(definitions);
		
		List<String> types = new ArrayList<String>(Arrays.asList("ABCD_MT123456CA.Person", "ABCD_MT123456CA.PersonalRelationship", "ABCD_MT123456CA.Patient"));
		
		for (SimplifiableType type : provider.getAllTypes()) {
			assertEquals("type", types.remove(0), type.getName());
		}
	}
}
