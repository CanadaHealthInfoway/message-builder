package ca.infoway.messagebuilder.generator.regen;

import static ca.infoway.messagebuilder.generator.regen.BaseRelationshipMatchers.matchingName;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;

import ca.infoway.messagebuilder.generator.java.Association;
import ca.infoway.messagebuilder.generator.java.AssociationBuilder;
import ca.infoway.messagebuilder.generator.java.BaseRelationship;
import ca.infoway.messagebuilder.generator.java.RegeneratedAssociationImpl;
import ca.infoway.messagebuilder.generator.java.Type;
import ca.infoway.messagebuilder.generator.java.TypeBuilder;
import ca.infoway.messagebuilder.xml.Cardinality;

public class CardinalityDeltaTest {
	
	@Test
	public void shouldReplaceAssociationIfCardinalityChangedFromSingleToMultiple() throws Exception {
		Association oldRelationship = new AssociationBuilder()
			.setName("name")
			.setCardinality(new Cardinality(0, 1))
			.setType(new TypeBuilder().setName("Patient").build())
			.buildStandard();
		
		CardinalityDelta delta = new CardinalityDelta(
				oldRelationship,
				new AssociationBuilder().setName("name").setCardinality(new Cardinality(0, 5)).buildStandard());
		
		Type mergedType = new TypeBuilder().addRelationship(oldRelationship).build();
		
		delta.apply(new RelationshipsMergerContext(mergedType));
		
		assertThat(toList(mergedType.getRelationships()), hasItem(matchingNameAndType("name", RegeneratedAssociationImpl.class)));
	}

	@Test
	public void shouldReplaceAssociationIfCardinalityChangedFromMultipleToSingle() throws Exception {
		Association oldRelationship = new AssociationBuilder()
			.setName("name")
			.setCardinality(new Cardinality(0, 5))
			.setType(new TypeBuilder().setName("Patient").build())
			.buildStandard();
		
		CardinalityDelta delta = new CardinalityDelta(
				oldRelationship,
				new AssociationBuilder().setName("name").setCardinality(new Cardinality(0, 1)).buildStandard());
		
		Type mergedType = new TypeBuilder().addRelationship(oldRelationship).build();
		
		delta.apply(new RelationshipsMergerContext(mergedType));
		
		assertThat(toList(mergedType.getRelationships()), hasItem(matchingNameAndType("name", RegeneratedAssociationImpl.class)));
	}

	@Test
	public void shouldDoNothingIfCardinalitChangedFromMultipleToMultiple() throws Exception {
		Association oldRelationship = new AssociationBuilder()
			.setName("name")
			.setCardinality(new Cardinality(0, 5))
			.setType(new TypeBuilder().setName("Patient").build())
			.buildStandard();
		
		CardinalityDelta delta = new CardinalityDelta(
				oldRelationship,
				new AssociationBuilder().setName("name").setCardinality(new Cardinality(0, 5)).buildStandard());
		
		Type mergedType = new TypeBuilder().addRelationship(oldRelationship).build();
		
		delta.apply(new RelationshipsMergerContext(mergedType));
		
		assertThat("marged relationship not added", toList(mergedType.getRelationships()), not(hasItem(matchingNameAndType("name", RegeneratedAssociationImpl.class))));
		assertThat("original relationship kept", mergedType.getRelationships(), hasItem((BaseRelationship) oldRelationship));
	}

	@Test
	public void shouldDoNothingIfCardinalitChangedFromSingleToSingle() throws Exception {
		Association oldRelationship = new AssociationBuilder()
			.setName("name")
			.setCardinality(new Cardinality(0, 5))
			.setType(new TypeBuilder().setName("Patient").build())
			.buildStandard();
		
		CardinalityDelta delta = new CardinalityDelta(
				oldRelationship,
				new AssociationBuilder().setName("name").setCardinality(new Cardinality(0, 5)).buildStandard());
		
		Type mergedType = new TypeBuilder().addRelationship(oldRelationship).build();
		
		delta.apply(new RelationshipsMergerContext(mergedType));
		
		assertThat("marged relationship not added", toList(mergedType.getRelationships()), not(hasItem(matchingNameAndType("name", RegeneratedAssociationImpl.class))));
		assertThat("original relationship kept", mergedType.getRelationships(), hasItem((BaseRelationship) oldRelationship));
	}
	
	@SuppressWarnings("unchecked")
	private Matcher<Object> matchingNameAndType(String name, Class<?> type) {
		return Matchers.allOf(matchingName(name), instanceOf(type));
	}

	@SuppressWarnings("unchecked")
	private List<Object> toList(List relationships) {
		return (List<Object>) relationships;
	}
	
}
