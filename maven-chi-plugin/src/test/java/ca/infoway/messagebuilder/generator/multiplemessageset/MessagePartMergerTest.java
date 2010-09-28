package ca.infoway.messagebuilder.generator.multiplemessageset;

import java.util.Arrays;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.infoway.messagebuilder.generator.LogLevel;
import ca.infoway.messagebuilder.generator.OutputUI;
import ca.infoway.messagebuilder.xml.Documentation;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.Relationship;

@RunWith(JMock.class)
public class MessagePartMergerTest {

	private OutputUI outputUI;
	private DocumentationMerger documentationMerger;
	private RelationshipMerger relationshipMerger;
	private MessagePartMerger merger;
	
	private final Mockery jmock = new JUnit4Mockery() {{
		setImposteriser(ClassImposteriser.INSTANCE);
	}};

	@Before
	public void setup() {
		this.outputUI = this.jmock.mock(OutputUI.class);
		this.documentationMerger = this.jmock.mock(DocumentationMerger.class);
		this.relationshipMerger = this.jmock.mock(RelationshipMerger.class);
		this.merger = new MessagePartMerger(this.outputUI, this.documentationMerger, this.relationshipMerger);
	}

	@Test
	public void shouldHandleEmptyMessageParts() {
		this.jmock.checking(new Expectations() {{
			one(documentationMerger).merge(null, "1", null, "2"); will(returnValue(null));
		}});

		MessagePart result = this.merger.merge(null, "1", null, "2");
		Assert.assertNull(result.getName());
		
		this.jmock.checking(new Expectations() {{
			one(documentationMerger).merge(null, "1", null, "2"); will(returnValue(null));
		}});

		result = this.merger.merge(new MessagePart(), "1", new MessagePart(), "2");
		Assert.assertNull(result.getName());
	}
	
	@Test
	public void shouldHandleSingleMessagePart() {
		final Documentation documentation = new Documentation();
		final Relationship relationship = new Relationship();
		
		MessagePart messagePart = new MessagePart();
		messagePart.setAbstract(true);
		messagePart.setDocumentation(documentation);
		messagePart.setName("myName");
		messagePart.setSpecializationChilds(Arrays.asList("specializationChild1"));
		messagePart.getRelationships().add(relationship);
		
		this.jmock.checking(new Expectations() {{
			one(documentationMerger).merge(documentation, "1", null, "2"); will(returnValue(documentation));
			one(relationshipMerger).merge(relationship, "1",  null, "2"); will(returnValue(relationship));
			one(outputUI).log(LogLevel.ERROR, "Merging abstract messagePart with non-abstract messagePart");
		}});
		
		MessagePart result = this.merger.merge(messagePart, "1", new MessagePart(), "2");
		Assert.assertEquals(messagePart.getName(), result.getName());
		Assert.assertEquals(messagePart.isAbstract(), result.isAbstract());
		Assert.assertEquals(messagePart.getDocumentation(), result.getDocumentation());
		Assert.assertEquals(messagePart.getSpecializationChilds().size(), result.getSpecializationChilds().size());
		Assert.assertEquals(messagePart.getSpecializationChilds().get(0), result.getSpecializationChilds().get(0));
		
		this.jmock.checking(new Expectations() {{
			one(documentationMerger).merge(documentation, "1", null, "2"); will(returnValue(documentation));
			one(relationshipMerger).merge(relationship, "1",  null, "2"); will(returnValue(relationship));
		}});
		
		result = this.merger.merge(messagePart, "1", null, "2");
		Assert.assertEquals(messagePart.getName(), result.getName());
		Assert.assertEquals(messagePart.isAbstract(), result.isAbstract());
		Assert.assertEquals(messagePart.getDocumentation(), result.getDocumentation());
		Assert.assertEquals(messagePart.getSpecializationChilds().size(), result.getSpecializationChilds().size());
		Assert.assertEquals(messagePart.getSpecializationChilds().get(0), result.getSpecializationChilds().get(0));
		
		this.jmock.checking(new Expectations() {{
			one(documentationMerger).merge(null, "1", documentation, "2"); will(returnValue(documentation));
			one(relationshipMerger).merge(null, "1",  relationship, "2"); will(returnValue(relationship));
		}});
		
		result = this.merger.merge(null, "1", messagePart, "2");
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
		
		MessagePart messagePart1 = new MessagePart();
		messagePart1.setAbstract(true);
		messagePart1.setDocumentation(documentation1);
		messagePart1.setName("myName");
		messagePart1.setSpecializationChilds(Arrays.asList("specializationChild1"));
		messagePart1.getRelationships().add(relationship1);
		
		final Documentation documentation2 = new Documentation();
		final Relationship relationship2 = new Relationship();
		relationship2.setName("commonName");
		
		MessagePart messagePart2 = new MessagePart();
		messagePart2.setAbstract(true);
		messagePart2.setDocumentation(documentation2);
		messagePart2.setName("myName");
		messagePart2.setSpecializationChilds(Arrays.asList("specializationChild2"));
		messagePart2.getRelationships().add(relationship2);
		
		this.jmock.checking(new Expectations() {{
			one(documentationMerger).merge(documentation1, "1", documentation2, "2"); will(returnValue(documentation1));
			one(relationshipMerger).merge(relationship1, "1",  relationship2, "2"); will(returnValue(relationship1));
		}});
		
		MessagePart result = this.merger.merge(messagePart1, "1", messagePart2, "2");
		Assert.assertEquals(messagePart1.getName(), result.getName());
		Assert.assertEquals(messagePart1.isAbstract(), result.isAbstract());
		Assert.assertEquals(messagePart1.getDocumentation(), result.getDocumentation());
		Assert.assertEquals(messagePart1.getSpecializationChilds().size() + messagePart2.getSpecializationChilds().size(), result.getSpecializationChilds().size());
		Assert.assertTrue(result.getSpecializationChilds().contains(messagePart1.getSpecializationChilds().get(0)));
		Assert.assertTrue(result.getSpecializationChilds().contains(messagePart2.getSpecializationChilds().get(0)));
		
		this.jmock.checking(new Expectations() {{
			one(documentationMerger).merge(documentation2, "2", documentation1, "1"); will(returnValue(documentation2));
			one(relationshipMerger).merge(relationship2, "2",  relationship1, "1"); will(returnValue(relationship2));
		}});
		
		result = this.merger.merge(messagePart2, "2", messagePart1, "1");
		Assert.assertEquals(messagePart2.getName(), result.getName());
		Assert.assertEquals(messagePart2.isAbstract(), result.isAbstract());
		Assert.assertEquals(messagePart2.getDocumentation(), result.getDocumentation());
		Assert.assertEquals(messagePart1.getSpecializationChilds().size() + messagePart2.getSpecializationChilds().size(), result.getSpecializationChilds().size());
		Assert.assertTrue(result.getSpecializationChilds().contains(messagePart1.getSpecializationChilds().get(0)));
		Assert.assertTrue(result.getSpecializationChilds().contains(messagePart2.getSpecializationChilds().get(0)));
	}
}
