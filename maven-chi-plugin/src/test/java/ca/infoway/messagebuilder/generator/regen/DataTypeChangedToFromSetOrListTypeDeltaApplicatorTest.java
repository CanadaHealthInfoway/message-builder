package ca.infoway.messagebuilder.generator.regen;

import static ca.infoway.messagebuilder.generator.regen.BaseRelationshipMatchers.matchingName;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Ignore;
import org.junit.Test;

import ca.infoway.messagebuilder.generator.java.Attribute;
import ca.infoway.messagebuilder.generator.java.AttributeBuilder;
import ca.infoway.messagebuilder.generator.java.RegeneratedAttributeImpl;
import ca.infoway.messagebuilder.generator.java.Type;
import ca.infoway.messagebuilder.generator.java.TypeBuilder;

public class DataTypeChangedToFromSetOrListTypeDeltaApplicatorTest {
	
	@Test
	public void shouldApplyWhenDataTypeChangesFromSetToSimpleOrViceversa() throws Exception {
		assertTrue("set to simple", new DataTypeChangedToFromSetOrListTypeDeltaApplicator().canApply(
				new AttributeBuilder().setDataType("SET<TS>").build(), 
				new AttributeBuilder().setDataType("TS").build()));
		assertTrue("simple to set", new DataTypeChangedToFromSetOrListTypeDeltaApplicator().canApply(
				new AttributeBuilder().setDataType("TS").build(), 
				new AttributeBuilder().setDataType("SET<TS>").build()));
	}

	@Test
	public void shouldApplyWhenDataTypeChangesFromListToSimpleOrViceversa() throws Exception {
		assertTrue("list to simple", new DataTypeChangedToFromSetOrListTypeDeltaApplicator().canApply(
				new AttributeBuilder().setDataType("LIST<TS>").build(), 
				new AttributeBuilder().setDataType("TS").build()));
		assertTrue("simple to list", new DataTypeChangedToFromSetOrListTypeDeltaApplicator().canApply(
				new AttributeBuilder().setDataType("TS").build(), 
				new AttributeBuilder().setDataType("LIST<TS>").build()));
	}
	
	@SuppressWarnings("unchecked")
	@Test @Ignore
	public void shouldReplaceAttribute() throws Exception {
		Attribute originalRelationship = new AttributeBuilder().setName("name").setDataType("SET<TS>").build();
		Attribute newRelationship = new AttributeBuilder().setName("name").setDataType("TS.DATE").build();

		Type mergedType = new TypeBuilder().addRelationship(originalRelationship).build();

		new DataTypeChangedToFromSetOrListTypeDeltaApplicator().apply(new RelationshipsMergerContext(mergedType), 
				originalRelationship, newRelationship);
		
		assertThat("replaced", (List) mergedType.getRelationships(), 
				hasItem(matchingNameAndType("name", RegeneratedAttributeImpl.class)));
		assertThat("merged relationship", (List) mergedType.getRelationships(), 
				hasItem(matchingNameAnd("name", mergedFrom(originalRelationship, newRelationship))));
	}

	private Matcher<RegeneratedAttributeImpl> mergedFrom(final Attribute originalRelationship, final Attribute newRelationship) {
		return new TypeSafeMatcher<RegeneratedAttributeImpl>() {
			@Override
			public boolean matchesSafely(RegeneratedAttributeImpl merged) {
				return merged.getOriginalRelationship().equals(originalRelationship)
				    && merged.getNewRelationship().equals(newRelationship);
			}
			public void describeTo(Description description) {
			}
		};
	}

	@SuppressWarnings("unchecked")
	private Matcher matchingNameAndType(String name, Class<?> type) {
		return Matchers.allOf(matchingName(name), instanceOf(type));
	}

	@SuppressWarnings("unchecked")
	private Matcher matchingNameAnd(String name, Matcher<RegeneratedAttributeImpl> matcher) {
		return Matchers.allOf(matchingName(name), matcher);
	}
	
}
