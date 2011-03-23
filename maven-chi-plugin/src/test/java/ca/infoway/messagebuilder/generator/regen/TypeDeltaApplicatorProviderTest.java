package ca.infoway.messagebuilder.generator.regen;

import static org.junit.Assert.assertEquals;

import org.jmock.Expectations;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import ca.infoway.messagebuilder.generator.java.AttributeBuilder;
import ca.infoway.messagebuilder.generator.java.BaseRelationship;
import ca.infoway.messagebuilder.junit.JMockMockeryRule;

import com.google.common.collect.Sets;

public class TypeDeltaApplicatorProviderTest {
	
	@Rule
	public JMockMockeryRule jmock = new JMockMockeryRule();
	
	private TypeDeltaApplicator applicator1 = jmock.mock(TypeDeltaApplicator.class, "applicator1");
	private TypeDeltaApplicator applicator2 = jmock.mock(TypeDeltaApplicator.class, "applicator2");

	private BaseRelationship originalRelationship;

	private BaseRelationship newRelationship;
	
	@Before
	public void setUp() {
		this.originalRelationship = new AttributeBuilder().build();
		this.newRelationship = new AttributeBuilder().build();
	}
	
	@Test
	public void shouldReturnFirstMatchingApplicator() throws Exception {
		TypeDeltaApplicatorProvider provider = new TypeDeltaApplicatorProvider(Sets.newHashSet(this.applicator1, this.applicator2));
		
		this.jmock.checking(new Expectations() {{
			allowing(applicator1).canApply(originalRelationship, newRelationship); will(returnValue(false));
			one(applicator2).canApply(originalRelationship, newRelationship); will(returnValue(true));			
		}});
		
		assertEquals("matching applicator", applicator2, provider.getApplicator(this.originalRelationship, this.newRelationship));
	}

	@Test
	public void shouldReturnNullApplicatorWhenNoMatchIsFound() throws Exception {
		TypeDeltaApplicatorProvider provider = new TypeDeltaApplicatorProvider(Sets.newHashSet(this.applicator1, this.applicator2));
		
		this.jmock.checking(new Expectations() {{
			one(applicator1).canApply(originalRelationship, newRelationship); will(returnValue(false));
			one(applicator2).canApply(originalRelationship, newRelationship); will(returnValue(false));			
		}});
		
		assertEquals("null applicator", TypeDeltaApplicatorProvider.NullApplicator.INSTANCE, provider.getApplicator(this.originalRelationship, this.newRelationship));
	}
	

}
