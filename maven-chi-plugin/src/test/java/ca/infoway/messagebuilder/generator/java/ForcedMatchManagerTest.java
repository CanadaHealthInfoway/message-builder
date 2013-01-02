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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.Difference;
import ca.infoway.messagebuilder.xml.DifferenceType;
import ca.infoway.messagebuilder.xml.DifferenceValue;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.Relationship;


public class ForcedMatchManagerTest {
	
	@Test
	public void shouldFindAllForcedMatches() throws Exception {
		
		MessagePart part = new MessagePart("MCAI_MT700210CA.DataEntryLocation");
		Relationship relationship = new Relationship("serviceDeliveryLocation", "COCT_MT240002CA.ServiceDeliveryLocation", Cardinality.create("1"));
		relationship.addDifference(new Difference(DifferenceType.ASSOCIATION_TYPE, true, 
				new DifferenceValue("R02.04.02", "COCT_MT240002CA.ServiceDeliveryLocation"),
				new DifferenceValue("V01R04.3_HOTFIX3", "COCT_MT240003CA.ServiceDeliveryLocation")));
		part.getRelationships().add(relationship);

		SimplifiableType type1 = new SimplifiableType(new MessagePart("COCT_MT240002CA.ServiceDeliveryLocation"), false);
		SimplifiableType type2 = new SimplifiableType(new MessagePart("COCT_MT240003CA.ServiceDeliveryLocation"), false);
		
		type1.getMessagePart().getRelationships().add(new Relationship("place", "COCT_MT240002CA.Place", Cardinality.create("1")));
		type2.getMessagePart().getRelationships().add(new Relationship("place", "COCT_MT240003CA.Place", Cardinality.create("1")));

		SimplifiableType place1 = new SimplifiableType(new MessagePart("COCT_MT240002CA.Place"), false);
		SimplifiableType place2 = new SimplifiableType(new MessagePart("COCT_MT240003CA.Place"), false);
		
		
		SimplifiableDefinitions definitions = new SimplifiableDefinitions();

		SimplifiableType type = new SimplifiableType(part, false);
		definitions.addType(type);
		definitions.addType(type1);
		definitions.addType(type2);
		definitions.addType(place1);
		definitions.addType(place2);
		
		ForcedMatchManager manager = new ForcedMatchManager(definitions);
		
		assertFalse("matches", manager.parts.isEmpty());
		assertTrue("location 1", manager.parts.contains("COCT_MT240002CA.ServiceDeliveryLocation"));
		assertTrue("location 2", manager.parts.contains("COCT_MT240003CA.ServiceDeliveryLocation"));

		assertTrue("check", manager.isWorthChecking(type1, type2));
		assertFalse("check 2", manager.isWorthChecking(type, type2));

		assertTrue("check dependencies", manager.isWorthChecking(place1, place2));
		assertTrue("irrelevant check", manager.isWorthChecking(type1, place2));
	}
}
