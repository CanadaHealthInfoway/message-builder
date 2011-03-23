package ca.infoway.messagebuilder.generator.regen;

import static ca.infoway.messagebuilder.generator.java.TypeAndRelationshipBuilder.createAttribute;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.jmock.Expectations;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Rule;
import org.junit.Test;

import ca.infoway.messagebuilder.generator.java.Attribute;
import ca.infoway.messagebuilder.generator.java.BaseRelationship;
import ca.infoway.messagebuilder.generator.java.Type;
import ca.infoway.messagebuilder.generator.java.TypeAndRelationshipBuilder;
import ca.infoway.messagebuilder.junit.JMockMockeryRule;
import ca.infoway.messagebuilder.xml.Cardinality;

import com.google.common.collect.Sets;


public class TypeRelationshipsMergerTest {
	
	@Rule
	public JMockMockeryRule jmock = new JMockMockeryRule() {{
		setImposteriser(ClassImposteriser.INSTANCE);
	}};
	
	private final DeltaCalculator conformanceDeltaCalculator = this.jmock.mock(DeltaCalculator.class, "conformanceDeltaCalculator"); 
	private final DeltaCalculator nameDeltaCalculator = this.jmock.mock(DeltaCalculator.class, "nameDeltaCalculator");
	
	@Test
	public void shouldMergeCorrectly() throws Exception {
		final Type oldType = TypeAndRelationshipBuilder.createType(null, "TestType", createAttribute("id", new Cardinality(0,1), "II"));
		final Type newType = TypeAndRelationshipBuilder.createType(null, "TestType", createAttribute("id", new Cardinality(0,5), "I"));
		
		final Type mergedType = TypeAndRelationshipBuilder.createType(null, "TestType");
		
		final Delta conformanceDelta = this.jmock.mock(Delta.class, "conformanceDelta1");
		final Delta nameDelta = this.jmock.mock(Delta.class, "nameDelta1");
		
		this.jmock.checking(new Expectations(){{
			one(conformanceDeltaCalculator).calculate(
					with(any(RelationshipsMergerContext.class)), with(equal(oldType)), with(equal(newType)));
				will(returnValue(Sets.newHashSet(conformanceDelta)));
			
			one(nameDeltaCalculator).calculate(
					with(any(RelationshipsMergerContext.class)), with(equal(oldType)), with(equal(newType)));
				will(returnValue(Sets.newHashSet(nameDelta)));
				
//			one(conformanceDeltaCalculator).calculate(
//					with(any(RelationshipsMergerContext.class)), with(equal(oldType)), with(equal(newType)));
//				will(returnValue(Sets.newHashSet(conformanceDelta)));
			
			one(conformanceDelta).apply(with(any(RelationshipsMergerContext.class)));
			one(nameDelta).apply(with(any(RelationshipsMergerContext.class)));
		}});
		
		new TypeRelationshipsMerger(
				oldType, newType, Arrays.asList(this.conformanceDeltaCalculator), this.nameDeltaCalculator)
			.mergeInto(mergedType);
		
	}

	@Test
	public void shouldDoSecondPassOnlyOfNameDeltaCalculatorReturnsSomeDelta() throws Exception {
		final Type oldType = TypeAndRelationshipBuilder.createType(null, "TestType", createAttribute("id", new Cardinality(0,1), "II"));
		final Type newType = TypeAndRelationshipBuilder.createType(null, "TestType", createAttribute("id", new Cardinality(0,5), "II"));
		
		final Type mergedType = TypeAndRelationshipBuilder.createType(null, "TestType");
		
		final Delta conformanceDelta = this.jmock.mock(Delta.class, "conformanceDelta1");
		
		this.jmock.checking(new Expectations(){{
			one(conformanceDeltaCalculator).calculate(
					with(any(RelationshipsMergerContext.class)), with(equal(oldType)), with(equal(newType)));
				will(returnValue(Sets.newHashSet(conformanceDelta)));
			
			one(nameDeltaCalculator).calculate(
					with(any(RelationshipsMergerContext.class)), with(equal(oldType)), with(equal(newType)));
				will(returnValue(Sets.newHashSet()));
				
			one(conformanceDelta).apply(with(any(RelationshipsMergerContext.class)));
		}});
		
		new TypeRelationshipsMerger(
				oldType, newType, Arrays.asList(this.conformanceDeltaCalculator), this.nameDeltaCalculator)
			.mergeInto(mergedType);
		
	}
	
	@Test
	public void shouldAddOldTypeRelationshipsToMergedType() throws Exception {
		final BaseRelationship type1Relationship1 = createAttribute("id", new Cardinality(0,1), "II");
		final Type oldType = TypeAndRelationshipBuilder.createType(null, "TestType", type1Relationship1);
		
		this.jmock.checking(new Expectations(){{
			allowing(conformanceDeltaCalculator).calculate(
					with(any(RelationshipsMergerContext.class)), with(equal(oldType)), with(any(Type.class)));
				will(returnValue(Sets.newHashSet()));
			
			allowing(nameDeltaCalculator).calculate(
					with(any(RelationshipsMergerContext.class)), with(equal(oldType)), with(any(Type.class)));
				will(returnValue(Sets.newHashSet()));
		}});

		final Type mergedType = TypeAndRelationshipBuilder.createType(null, "TestType");
		
		new TypeRelationshipsMerger(
				oldType, 
				new Type(null), 
				Arrays.asList(this.conformanceDeltaCalculator), this.nameDeltaCalculator)
			.mergeInto(mergedType);
		
		assertThat(mergedType.getRelationships(), hasItem(type1Relationship1));
		
	}

	@Test
	public void shouldAddUnMergedNewTypeRelationshipsToMergedType() throws Exception {
		final Attribute oldTypeAttribute = createAttribute("id1", new Cardinality(0,1), "II");
		final Type oldType = TypeAndRelationshipBuilder.createType(null, "TestType", oldTypeAttribute);
		
		Attribute newTypeAttribute = createAttribute("id2", new Cardinality(0,1), "II");
		final Type newType = TypeAndRelationshipBuilder.createType(null, "TestType", newTypeAttribute);
		
		this.jmock.checking(new Expectations(){{
			allowing(conformanceDeltaCalculator).calculate(
					with(any(RelationshipsMergerContext.class)), with(equal(oldType)), with(any(Type.class)));
				will(returnValue(Sets.newHashSet()));
			
			allowing(nameDeltaCalculator).calculate(
					with(any(RelationshipsMergerContext.class)), with(equal(oldType)), with(any(Type.class)));
				will(returnValue(Sets.newHashSet()));
		}});

		final Type mergedType = TypeAndRelationshipBuilder.createType(null, "TestType");
		
		new TypeRelationshipsMerger(
				oldType, 
				newType, 
				Arrays.asList(this.conformanceDeltaCalculator), this.nameDeltaCalculator)
			.mergeInto(mergedType);
		
		assertThat(mergedType.getRelationships(), hasItem((BaseRelationship) newTypeAttribute));
	}
	
}
