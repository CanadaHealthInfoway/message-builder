package ca.infoway.messagebuilder.generator.java;

import static org.junit.Assert.*;

import org.junit.Test;

import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.Difference;
import ca.infoway.messagebuilder.xml.DifferenceMatch;
import ca.infoway.messagebuilder.xml.DifferenceType;
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
		
		assertFalse("difference", new PostSimplificationEvaluator(null).containsNoInterestingDifferences(part));
	}

}
