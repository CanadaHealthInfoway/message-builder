package ca.infoway.messagebuilder.generator.multiplemessageset;

import java.util.Arrays;
import java.util.Collections;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.infoway.messagebuilder.xml.Documentation;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.Relationship;

@RunWith(JMock.class)
public class MessagePartMergerTest {

	private MergeContext mergeContext;
	private DocumentationMerger documentationMerger;
	private RelationshipsMerger relationshipsMerger;
	private MessagePartMerger merger;
	
	private final Mockery jmock = new JUnit4Mockery() {{
		setImposteriser(ClassImposteriser.INSTANCE);
	}};

	@Before
	public void setup() {
		this.mergeContext = this.jmock.mock(MergeContext.class);
		this.jmock.checking(new Expectations() {{
			allowing(mergeContext).getPrimaryVersion(); will(returnValue("1"));
			allowing(mergeContext).getSecondaryVersion(); will(returnValue("2"));
			allowing(mergeContext).getCurrentInteraction(); will(returnValue(""));
			allowing(mergeContext).getCurrentMessagePart(); will(returnValue("aCurrentMessagePart"));
			allowing(mergeContext).getCurrentPackageLocation(); will(returnValue("aPackageLocation"));
			allowing(mergeContext).logInfo(with(any(String.class)));
		}});

		this.documentationMerger = this.jmock.mock(DocumentationMerger.class);
		this.relationshipsMerger = this.jmock.mock(RelationshipsMerger.class);
		this.merger = new MessagePartMerger(this.mergeContext, this.documentationMerger, this.relationshipsMerger);
	}

	@Test
	public void shouldHandleEmptyMessageParts() {
		MessagePart result = this.merger.merge(null, null);
		Assert.assertNull(result);
		
		this.jmock.checking(new Expectations() {{
			one(documentationMerger).merge(null, null); will(returnValue(null));
			one(relationshipsMerger).merge(Collections.<Relationship>emptyList(), Collections.<Relationship>emptyList()); will(returnValue(Collections.emptyList()));
		}});

		result = this.merger.merge(new MessagePart(), new MessagePart());
		Assert.assertNull(result.getName());
	}
	
	@Test
	public void shouldHandleSingleMessagePart() {
		final Documentation documentation = new Documentation();
		final Relationship relationship = new Relationship();
		
		final MessagePart messagePart = new MessagePart();
		messagePart.setAbstract(true);
		messagePart.setDocumentation(documentation);
		messagePart.setName("myName");
		messagePart.setSpecializationChilds(Arrays.asList("specializationChild1"));
		messagePart.getRelationships().add(relationship);
		
		this.jmock.checking(new Expectations() {{
			one(documentationMerger).merge(documentation, null); will(returnValue(documentation));
			one(relationshipsMerger).merge(messagePart.getRelationships(), Collections.<Relationship>emptyList()); will(returnValue(Arrays.asList(relationship)));
		}});
		
		MessagePart result = this.merger.merge(messagePart, new MessagePart());
		Assert.assertEquals(messagePart.getName(), result.getName());
		Assert.assertEquals(messagePart.isAbstract(), result.isAbstract());
		Assert.assertEquals(messagePart.getDocumentation(), result.getDocumentation());
		Assert.assertEquals(messagePart.getSpecializationChilds().size(), result.getSpecializationChilds().size());
		Assert.assertEquals(messagePart.getSpecializationChilds().get(0), result.getSpecializationChilds().get(0));
		
		result = this.merger.merge(messagePart, null);
		Assert.assertEquals(messagePart.getName(), result.getName());
		Assert.assertEquals(messagePart.isAbstract(), result.isAbstract());
		Assert.assertEquals(messagePart.getDocumentation(), result.getDocumentation());
		Assert.assertEquals(messagePart.getSpecializationChilds().size(), result.getSpecializationChilds().size());
		Assert.assertEquals(messagePart.getSpecializationChilds().get(0), result.getSpecializationChilds().get(0));
		
		result = this.merger.merge(null, messagePart);
		Assert.assertEquals(messagePart.getName(), result.getName());
		Assert.assertEquals(messagePart.isAbstract(), result.isAbstract());
		Assert.assertEquals(messagePart.getDocumentation(), result.getDocumentation());
		Assert.assertEquals(messagePart.getSpecializationChilds().size(), result.getSpecializationChilds().size());
	}
	
	@Test
	public void shouldMergeMessageParts() {
		final Documentation documentation1 = new Documentation();
		final Relationship relationship1 = new Relationship();
		relationship1.setName("commonName");
		
		final MessagePart messagePart1 = new MessagePart();
		messagePart1.setAbstract(true);
		messagePart1.setDocumentation(documentation1);
		messagePart1.setName("myName");
		messagePart1.setSpecializationChilds(Arrays.asList("specializationChild1"));
		messagePart1.getRelationships().add(relationship1);
		
		final Documentation documentation2 = new Documentation();
		final Relationship relationship2 = new Relationship();
		relationship2.setName("commonName");
		
		final MessagePart messagePart2 = new MessagePart();
		messagePart2.setAbstract(true);
		messagePart2.setDocumentation(documentation2);
		messagePart2.setName("myName");
		messagePart2.setSpecializationChilds(Arrays.asList("specializationChild2"));
		messagePart2.getRelationships().add(relationship2);
		
		this.jmock.checking(new Expectations() {{
			one(documentationMerger).merge(documentation1, documentation2); will(returnValue(documentation1));
			one(relationshipsMerger).merge(messagePart1.getRelationships(),  messagePart2.getRelationships()); will(returnValue(Arrays.asList(relationship1)));
		}});
		
		MessagePart result = this.merger.merge(messagePart1, messagePart2);
		Assert.assertEquals(messagePart1.getName(), result.getName());
		Assert.assertEquals(messagePart1.isAbstract(), result.isAbstract());
		Assert.assertEquals(messagePart1.getDocumentation(), result.getDocumentation());
		Assert.assertEquals(messagePart1.getSpecializationChilds().size() + messagePart2.getSpecializationChilds().size(), result.getSpecializationChilds().size());
		Assert.assertTrue(result.getSpecializationChilds().contains(messagePart1.getSpecializationChilds().get(0)));
		Assert.assertTrue(result.getSpecializationChilds().contains(messagePart2.getSpecializationChilds().get(0)));
		
		this.jmock.checking(new Expectations() {{
			one(documentationMerger).merge(documentation2, documentation1); will(returnValue(documentation2));
			one(relationshipsMerger).merge(messagePart2.getRelationships(),  messagePart1.getRelationships()); will(returnValue(Arrays.asList(relationship2)));
		}});
		
		result = this.merger.merge(messagePart2, messagePart1);
		Assert.assertEquals(messagePart2.getName(), result.getName());
		Assert.assertEquals(messagePart2.isAbstract(), result.isAbstract());
		Assert.assertEquals(messagePart2.getDocumentation(), result.getDocumentation());
		Assert.assertEquals(messagePart1.getSpecializationChilds().size() + messagePart2.getSpecializationChilds().size(), result.getSpecializationChilds().size());
		Assert.assertTrue(result.getSpecializationChilds().contains(messagePart1.getSpecializationChilds().get(0)));
		Assert.assertTrue(result.getSpecializationChilds().contains(messagePart2.getSpecializationChilds().get(0)));
	}
}
