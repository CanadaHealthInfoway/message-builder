package ca.infoway.messagebuilder.generator.multiplemessageset;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.infoway.messagebuilder.generator.OutputUI;
import ca.infoway.messagebuilder.xml.Documentation;
import ca.infoway.messagebuilder.xml.Interaction;

@RunWith(JMock.class)
public class InteractionMergerTest {

	private OutputUI outputUI;
	private DocumentationMerger documentationMerger;
	private ArgumentMerger argumentMerger;
	private InteractionMerger merger;
	
	private final Mockery jmock = new JUnit4Mockery() {{
		setImposteriser(ClassImposteriser.INSTANCE);
	}};


	@Before
	public void setup() {
		this.outputUI = this.jmock.mock(OutputUI.class);
		this.documentationMerger = this.jmock.mock(DocumentationMerger.class);
		this.argumentMerger = this.jmock.mock(ArgumentMerger.class);
		this.merger = new InteractionMerger(this.outputUI, this.documentationMerger, this.argumentMerger);
	}

	@Test
	public void shouldHandleEmptyInteractions() {
		this.jmock.checking(new Expectations() {{
			one(documentationMerger).merge(null, null, null, null); will(returnValue(null));
		}});

		Interaction result = this.merger.merge(null, null, null, null);
		Assert.assertNull(result.getName());
		
		Interaction primaryInteraction = new Interaction();
		Interaction secondaryInteraction = new Interaction();
		
		this.jmock.checking(new Expectations() {{
			one(documentationMerger).merge(null, "1", null, "2"); will(returnValue(null));
		}});

		result = this.merger.merge(primaryInteraction, "1", secondaryInteraction, "2");
		Assert.assertNull(result.getName());
		Assert.assertNotSame(result, primaryInteraction);
		Assert.assertNotSame(result, secondaryInteraction);
	}
	
	@Test
	public void shouldHandleSingleNullInteraction() {
		final Interaction interaction = new Interaction();
		interaction.setName("myName");
		interaction.setBusinessName("myBusinessName");
		interaction.setCategory("myCategory");
		interaction.setSuperTypeName("mySuperTypeName");
		interaction.setDocumentation(new Documentation());
		
		this.jmock.checking(new Expectations() {{
			one(documentationMerger).merge(interaction.getDocumentation(), "1", null, null); will(returnValue(interaction.getDocumentation()));
		}});

		Interaction result = this.merger.merge(interaction, "1", null, null);
		Assert.assertNotSame(interaction, result);
		Assert.assertEquals(interaction.getName(), result.getName());
		Assert.assertEquals(interaction.getBusinessName(), result.getBusinessName());
		Assert.assertEquals(interaction.getCategory(), result.getCategory());
		Assert.assertEquals(interaction.getSuperTypeName(), result.getSuperTypeName());
		Assert.assertEquals(interaction.getDocumentation(), result.getDocumentation());
		
		this.jmock.checking(new Expectations() {{
			one(documentationMerger).merge(null, null, interaction.getDocumentation(), "2"); will(returnValue(interaction.getDocumentation()));
		}});

		result = this.merger.merge(null, null, interaction, "2");
		Assert.assertNotSame(interaction, result);
		Assert.assertEquals(interaction.getName(), result.getName());
		Assert.assertEquals(interaction.getBusinessName(), result.getBusinessName());
		Assert.assertEquals(interaction.getCategory(), result.getCategory());
		Assert.assertEquals(interaction.getSuperTypeName(), result.getSuperTypeName());
		Assert.assertEquals(interaction.getDocumentation(), result.getDocumentation());
	}
	
	@Test
	public void shouldMergeInteractions() {
		final Interaction interaction1 = new Interaction();
		interaction1.setName("myName1");
		interaction1.setBusinessName("myBusinessName1");
		interaction1.setCategory("myCategory1");
		interaction1.setSuperTypeName("mySuperTypeNameSAME");
		interaction1.setDocumentation(new Documentation());
		
		final Interaction interaction2 = new Interaction();
		interaction2.setName("myName2");
		interaction2.setBusinessName("myBusinessName2");
		interaction2.setCategory("myCategory2");
		interaction2.setSuperTypeName("mySuperTypeNameSAME");
		interaction2.setDocumentation(new Documentation());
		
		this.jmock.checking(new Expectations() {{
			one(documentationMerger).merge(interaction1.getDocumentation(), "1", interaction2.getDocumentation(), "2"); will(returnValue(interaction1.getDocumentation()));
		}});

		Interaction result = this.merger.merge(interaction1, "1", interaction2, "2");
		Assert.assertNotSame(interaction1, result);
		Assert.assertNotSame(interaction2, result);
		Assert.assertEquals(interaction1.getName(), result.getName());
		Assert.assertEquals(interaction1.getBusinessName(), result.getBusinessName());
		Assert.assertEquals(interaction1.getCategory(), result.getCategory());
		Assert.assertEquals(interaction1.getSuperTypeName(), result.getSuperTypeName());
		Assert.assertEquals(interaction1.getDocumentation(), result.getDocumentation());
		
		this.jmock.checking(new Expectations() {{
			one(documentationMerger).merge(interaction2.getDocumentation(), "2", interaction1.getDocumentation(), "1"); will(returnValue(interaction2.getDocumentation()));
		}});

		result = this.merger.merge(interaction2, "2", interaction1, "1");
		Assert.assertNotSame(interaction2, result);
		Assert.assertNotSame(interaction1, result);
		Assert.assertEquals(interaction2.getName(), result.getName());
		Assert.assertEquals(interaction2.getBusinessName(), result.getBusinessName());
		Assert.assertEquals(interaction2.getCategory(), result.getCategory());
		Assert.assertEquals(interaction2.getSuperTypeName(), result.getSuperTypeName());
		Assert.assertEquals(interaction2.getDocumentation(), result.getDocumentation());
		
	}
}
