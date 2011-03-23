package ca.infoway.messagebuilder.generator.regen;

import static ca.infoway.messagebuilder.generator.regen.BaseRelationshipMatchers.matchingConformanceLevel;
import static ca.infoway.messagebuilder.generator.regen.BaseRelationshipMatchers.matchingName;
import static org.junit.Assert.assertThat;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;

import ca.infoway.messagebuilder.generator.java.Attribute;
import ca.infoway.messagebuilder.generator.java.AttributeBuilder;
import ca.infoway.messagebuilder.generator.java.BaseRelationship;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class ConformanceDeltaTest {

	@Test
	public void shouldSetConformanceToNewOneIfMorePermissive() throws Exception {
		Attribute oldRelationship = new AttributeBuilder().setName("name").setConformance(ConformanceLevel.MANDATORY).build();
		ConformanceDelta delta = new ConformanceDelta(
				oldRelationship,
				new AttributeBuilder().setName("name").setConformance(ConformanceLevel.POPULATED).build());
		
		delta.apply(null);
		
		assertThat("more permissive", oldRelationship, matchingNameAndConformance("name", ConformanceLevel.POPULATED));
	}

	@Test
	public void shouldKeepExistingConformanceIfNewOneIsLessPermissive() throws Exception {
		Attribute oldRelationship = new AttributeBuilder().setName("name").setConformance(ConformanceLevel.POPULATED).build();
		ConformanceDelta delta = new ConformanceDelta(
			oldRelationship,
				new AttributeBuilder().setName("name").setConformance(ConformanceLevel.MANDATORY).build());
		
		delta.apply(null);
		
		assertThat("newest documentation", oldRelationship, matchingNameAndConformance("name", ConformanceLevel.POPULATED));
	}
	
	@SuppressWarnings("unchecked")
	private Matcher<BaseRelationship> matchingNameAndConformance(String name, ConformanceLevel conformanceLevel) {
		return Matchers.allOf(matchingName(name), matchingConformanceLevel(conformanceLevel));
	}
	
}
