package ca.infoway.messagebuilder.generator.java;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.Relationship;


public class MatcherTest {

	
	@Test
	public void shouldMatchSimilarAttributes() throws Exception {
		MatchType type = new Matcher().matchesType(new Relationship("id", "II", Cardinality.create("1")), 
				new Relationship("id", "II.BUS", Cardinality.create("1")));
		assertEquals("type", MatchType.MINOR_DIFFERENCE, type);
	}
	
	@Test
	public void shouldMatchSimilarParameterizedAttributes() throws Exception {
		MatchType type = new Matcher().matchesType(new Relationship("creationTime", "IVL.LOW<TS.FULLDATETIME>", Cardinality.create("1")), 
				new Relationship("creationTime", "IVL<TS.DATE>", Cardinality.create("1")));
		assertEquals("type", MatchType.MINOR_DIFFERENCE, type);
	}
	
	@Test
	public void shouldNotMatchDifferentParameterizedAttributes() throws Exception {
		MatchType type = new Matcher().matchesType(new Relationship("creationTime", "IVL.LOW<PQ>", Cardinality.create("1")), 
				new Relationship("creationTime", "IVL.LOW<TS.DATE>", Cardinality.create("1")));
		assertEquals("type", MatchType.MAJOR_DIFFERENCE, type);
	}
	
	@Test
	public void shouldNotMatchDifferentAttributeTypes() throws Exception {
		MatchType type = new Matcher().matchesType(new Relationship("id", "II", Cardinality.create("1")), 
				new Relationship("id", "TS.FULLDATETIME", Cardinality.create("1")));
		assertEquals("type", MatchType.MAJOR_DIFFERENCE, type);
	}
	
	@Test
	public void shouldMatchExactAttributes() throws Exception {
		MatchType type = new Matcher().matchesType(new Relationship("id", "II.BUS", Cardinality.create("1")), 
				new Relationship("id", "II.BUS", Cardinality.create("1")));
		assertEquals("type", MatchType.EXACT, type);
	}
	
}
