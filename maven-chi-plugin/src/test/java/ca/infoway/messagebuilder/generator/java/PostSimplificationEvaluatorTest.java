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

import ca.infoway.messagebuilder.generator.SysoutLogUI;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.Difference;
import ca.infoway.messagebuilder.xml.DifferenceMatch;
import ca.infoway.messagebuilder.xml.DifferenceType;
import ca.infoway.messagebuilder.xml.DifferenceValue;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.Relationship;


public class PostSimplificationEvaluatorTest {
	
	@Test
	public void shouldDetectWellBuriedDifference() throws Exception {
		
		MessagePart part = new MessagePart("ABCD_MT123456CA.Patient");
		part.getRelationships().add(new Relationship("name", "PN", Cardinality.create("1")));
		Relationship person = new Relationship("person", "ABCD_MT123456CA.PersonChoice", Cardinality.create("1"));
		person.getChoices().add(new Relationship("funnyPerson", "ABCD_MT123456CA.Person", Cardinality.create("1")));
		person.getChoices().add(new Relationship("standardPerson", "ABCD_MT123456CA.StandardPerson", Cardinality.create("1")));
		Relationship tom = new Relationship("untrainedPerson", "ABCD_MT123456CA.Tom", Cardinality.create("1"));
		tom.getChoices().add(new Relationship("tomOnAGoodDay", "ABCD_MT123456CA.GoodTom", Cardinality.create("1")));
		Relationship badTom = new Relationship("tomOnABadDay", "ABCD_MT123456CA.BadTom", Cardinality.create("1"));
		Difference difference = new Difference(DifferenceType.ASSOCIATION_TYPE, true);
		difference.setMatchConfidence(DifferenceMatch.POSSIBLE_MATCH);
		badTom.addDifference(difference);
		tom.getChoices().add(badTom);
		person.getChoices().add(tom);
		part.getRelationships().add(person);
		
		assertFalse("difference", new PostSimplificationEvaluator(null, new SysoutLogUI()).containsNoInterestingDifferences(part));
	}

	@Test
	public void shouldDetectNonRectifiedDifferences() throws Exception {
		
		MessagePart part = new MessagePart("ABCD_MT123456CA.DataEntryLocation");
		Relationship location = new Relationship("serviceDeliveryLocation", "COCT_MT123456CA.ServiceDeliveryLocation", Cardinality.create("1"));
		Difference difference = new Difference(DifferenceType.ASSOCIATION_TYPE, true,
				new DifferenceValue("R02.04.02", "COCT_MT123456CA.ServiceDeliveryLocation"),
				new DifferenceValue("V01R04.3_HOTFIX3", "COCT_MT987654CA.ServiceDeliveryLocation"));
		difference.setMatchConfidence(DifferenceMatch.POSSIBLE_MATCH);
		location.addDifference(difference);
		part.getRelationships().add(location);
		
		SimplifiableDefinitions definitions = new SimplifiableDefinitions();
		definitions.addType(new SimplifiableType(part, false));
		definitions.addType(new SimplifiableType(new MessagePart("COCT_MT123456CA.ServiceDeliveryLocation"), false));
		definitions.addType(new SimplifiableType(new MessagePart("COCT_MT987654CA.ServiceDeliveryLocation"), false));
		
		assertFalse("has interesting difference", new PostSimplificationEvaluator(definitions, new SysoutLogUI()).containsNoInterestingDifferences(part));
		assertTrue("not resolved", new PostSimplificationEvaluator(definitions, new SysoutLogUI()).containsDifferencesThatHasNotBeenRectified(part));
		
		TemporaryTypeName name = TemporaryTypeName.create("moiged");
		
		SimplifiableType simplifiableType1 = definitions.getType("COCT_MT123456CA.ServiceDeliveryLocation");
		SimplifiableType simplifiableType2 = definitions.getType("COCT_MT987654CA.ServiceDeliveryLocation");
		simplifiableType1.setMergedTypeName(name);
		simplifiableType1.getMergedWithTypes().add(simplifiableType2);
		simplifiableType2.setMergedTypeName(name);
		simplifiableType2.getMergedWithTypes().add(simplifiableType1);
		
		assertFalse("resolved", new PostSimplificationEvaluator(definitions, new SysoutLogUI()).containsDifferencesThatHasNotBeenRectified(part));
	}
}
