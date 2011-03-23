package ca.infoway.messagebuilder.generator.regen;

import org.jmock.Expectations;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Rule;
import org.junit.Test;

import ca.infoway.messagebuilder.generator.java.Association;
import ca.infoway.messagebuilder.generator.java.AssociationBuilder;
import ca.infoway.messagebuilder.junit.JMockMockeryRule;

public class TypeDeltaTest {
	
	@Rule
	public JMockMockeryRule jmock = new JMockMockeryRule() {{
		setImposteriser(ClassImposteriser.INSTANCE);
	}};
	
	private TypeDeltaApplicatorProvider typeDeltaApplicatorProvider = jmock.mock(TypeDeltaApplicatorProvider.class);
	private TypeDeltaApplicator typeDeltaApplicator = jmock.mock(TypeDeltaApplicator.class);
	
	@Test
	public void shouldDelegateToApplicator() throws Exception {
		final RelationshipsMergerContext context = new RelationshipsMergerContext(null);
		
		final Association originalRelationship = new AssociationBuilder().buildStandard();
		final Association newRelationship = new AssociationBuilder().buildStandard();
		
		TypeDelta delta = new TypeDelta(originalRelationship, newRelationship, typeDeltaApplicatorProvider);
		
		jmock.checking(new Expectations(){{
			one(typeDeltaApplicatorProvider).getApplicator(originalRelationship, newRelationship);
				will(returnValue(typeDeltaApplicator));
			one(typeDeltaApplicator).apply(context, originalRelationship, newRelationship);
		}});
		
		delta.apply(context);
		
		
	}
	

}
