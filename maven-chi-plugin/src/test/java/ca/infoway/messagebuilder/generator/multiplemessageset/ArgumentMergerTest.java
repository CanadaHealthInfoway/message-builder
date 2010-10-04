package ca.infoway.messagebuilder.generator.multiplemessageset;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.infoway.messagebuilder.xml.Argument;

@RunWith(JMock.class)
public class ArgumentMergerTest {

	private final Mockery jmock = new JUnit4Mockery() {{
		setImposteriser(ClassImposteriser.INSTANCE);
	}};
	
	private MergeContext mergeContext;
	private ArgumentMerger merger;

	@Before
	public void setup() {
		this.mergeContext = this.jmock.mock(MergeContext.class);
		this.jmock.checking(new Expectations() {{
			allowing(mergeContext).getPrimaryVersion(); will(returnValue("1"));
			allowing(mergeContext).getSecondaryVersion(); will(returnValue("2"));
			allowing(mergeContext).logError(with(any(String.class)));
			allowing(mergeContext).getCurrentInteraction(); will(returnValue(""));
			allowing(mergeContext).getCurrentMessagePart(); will(returnValue("aCurrentMessagePart"));
			allowing(mergeContext).getCurrentPackageLocation(); will(returnValue("aPackageLocation"));
		}});
		
		this.merger = new ArgumentMerger(this.mergeContext);
	}
	
	@Test
	public void shoudlHandleNullArguments() {
		List<Argument> result = this.merger.merge(null, null);
		Assert.assertTrue(result.isEmpty());
	}
	
	@Test
	public void shoudlHandleEmptyArguments() {
		List<Argument> result = this.merger.merge(Collections.<Argument>emptyList(), Collections.<Argument>emptyList());
		Assert.assertTrue(result.isEmpty());
	}
	
	@Test
	public void shoudlHandleSingleArgumentMergingWithSame() {
		Argument arg1 = new Argument();
		arg1.setName("name");
		arg1.setTemplateParameterName("templateParameterName");
		arg1.setTraversalName("traversalName");
		
		Argument arg2 = new Argument();
		arg2.setName("name");
		arg2.setTemplateParameterName("templateParameterName");
		arg2.setTraversalName("traversalName");
		
		List<Argument> result = this.merger.merge(Arrays.asList(arg1), Arrays.asList(arg2));
		Assert.assertEquals(1, result.size());
		Assert.assertNotSame(arg1, result.get(0));
		Assert.assertNotSame(arg2, result.get(0));
		Assert.assertTrue(result.get(0).getDifferences().isEmpty());
		Assert.assertTrue(result.get(0).getArguments().isEmpty());
		Assert.assertTrue(result.get(0).getChoices().isEmpty());
		Assert.assertEquals("name", result.get(0).getName());
		Assert.assertEquals("templateParameterName", result.get(0).getTemplateParameterName());
		Assert.assertEquals("traversalName", result.get(0).getTraversalName());
	}
	
	@Test
	public void shoudlHandleSingleArgumentMergingWithArgumentHavingDifferentName() {
		Argument arg1 = new Argument();
		arg1.setName("name1");
		arg1.setTemplateParameterName("templateParameterName");
		arg1.setTraversalName("traversalName");
		
		Argument arg2 = new Argument();
		arg2.setName("name2");
		arg2.setTemplateParameterName("templateParameterName");
		arg2.setTraversalName("traversalName");
		
		List<Argument> result = this.merger.merge(Arrays.asList(arg1), Arrays.asList(arg2));
		Assert.assertEquals(1, result.size());
		Assert.assertNotSame(arg1, result.get(0));
		Assert.assertNotSame(arg2, result.get(0));
		Assert.assertTrue(result.get(0).getArguments().isEmpty());
		Assert.assertTrue(result.get(0).getChoices().isEmpty());
		Assert.assertEquals("name1", result.get(0).getName());
		Assert.assertEquals("templateParameterName", result.get(0).getTemplateParameterName());
		Assert.assertEquals("traversalName", result.get(0).getTraversalName());
		Assert.assertEquals(1, result.get(0).getDifferences().size());
		Assert.assertEquals("argument name", result.get(0).getDifferences().get(0).getType());
	}
	
	@Test
	public void shoudlHandleSingleArgumentMergingWithArgumentHavingDifferentTraversalName() {
		Argument arg1 = new Argument();
		arg1.setName("name");
		arg1.setTemplateParameterName("templateParameterName");
		arg1.setTraversalName("traversalName1");
		
		Argument arg2 = new Argument();
		arg2.setName("name");
		arg2.setTemplateParameterName("templateParameterName");
		arg2.setTraversalName("traversalName2");
		
		List<Argument> result = this.merger.merge(Arrays.asList(arg1), Arrays.asList(arg2));
		Assert.assertEquals(1, result.size());
		Assert.assertNotSame(arg1, result.get(0));
		Assert.assertNotSame(arg2, result.get(0));
		Assert.assertTrue(result.get(0).getArguments().isEmpty());
		Assert.assertTrue(result.get(0).getChoices().isEmpty());
		Assert.assertEquals("name", result.get(0).getName());
		Assert.assertEquals("templateParameterName", result.get(0).getTemplateParameterName());
		Assert.assertEquals("traversalName1", result.get(0).getTraversalName());
		Assert.assertEquals(1, result.get(0).getDifferences().size());
		Assert.assertEquals("arg traversalName", result.get(0).getDifferences().get(0).getType());
	}
	
	@Test
	public void shoudlHandleSingleArgumentMergingWithArgumentHavingDifferentTemplateParameterName() {
		Argument arg1 = new Argument();
		arg1.setName("name");
		arg1.setTemplateParameterName("templateParameterName1");
		arg1.setTraversalName("traversalName");
		
		Argument arg2 = new Argument();
		arg2.setName("name");
		arg2.setTemplateParameterName("templateParameterName2");
		arg2.setTraversalName("traversalName");
		
		List<Argument> result = this.merger.merge(Arrays.asList(arg1), Arrays.asList(arg2));
		Assert.assertEquals(1, result.size());
		Assert.assertNotSame(arg1, result.get(0));
		Assert.assertNotSame(arg2, result.get(0));
		Assert.assertTrue(result.get(0).getArguments().isEmpty());
		Assert.assertTrue(result.get(0).getChoices().isEmpty());
		Assert.assertEquals("name", result.get(0).getName());
		Assert.assertEquals("templateParameterName1", result.get(0).getTemplateParameterName());
		Assert.assertEquals("traversalName", result.get(0).getTraversalName());
		Assert.assertEquals(1, result.get(0).getDifferences().size());
		Assert.assertEquals("arg templateParameterName", result.get(0).getDifferences().get(0).getType());
	}
	
	@Test
	public void shoudlHandleSingleArgumentMergingWithMissingSecondaryArgument() {
		Argument arg1 = new Argument();
		arg1.setName("name");
		arg1.setTemplateParameterName("templateParameterName");
		arg1.setTraversalName("traversalName");
		
		List<Argument> result = this.merger.merge(Arrays.asList(arg1), Collections.<Argument>emptyList());
		Assert.assertEquals(1, result.size());
		Assert.assertSame(arg1, result.get(0));
		Assert.assertTrue(result.get(0).getArguments().isEmpty());
		Assert.assertTrue(result.get(0).getChoices().isEmpty());
		Assert.assertEquals("name", result.get(0).getName());
		Assert.assertEquals("templateParameterName", result.get(0).getTemplateParameterName());
		Assert.assertEquals("traversalName", result.get(0).getTraversalName());
		Assert.assertEquals(1, result.get(0).getDifferences().size());
		Assert.assertEquals("missingArgument", result.get(0).getDifferences().get(0).getType());
		Assert.assertEquals("[missing]", result.get(0).getDifferences().get(0).getDifferences().get(1).getValue());
	}
	
	@Test
	public void shoudlHandleSingleArgumentMergingWithMissingPrimaryArgument() {
		Argument arg2 = new Argument();
		arg2.setName("name");
		arg2.setTemplateParameterName("templateParameterName");
		arg2.setTraversalName("traversalName");
		
		List<Argument> result = this.merger.merge(Collections.<Argument>emptyList(), Arrays.asList(arg2));
		Assert.assertEquals(1, result.size());
		Assert.assertSame(arg2, result.get(0));
		Assert.assertTrue(result.get(0).getArguments().isEmpty());
		Assert.assertTrue(result.get(0).getChoices().isEmpty());
		Assert.assertEquals("name", result.get(0).getName());
		Assert.assertEquals("templateParameterName", result.get(0).getTemplateParameterName());
		Assert.assertEquals("traversalName", result.get(0).getTraversalName());
		Assert.assertEquals(1, result.get(0).getDifferences().size());
		Assert.assertEquals("missingArgument", result.get(0).getDifferences().get(0).getType());
		Assert.assertEquals("[missing]", result.get(0).getDifferences().get(0).getDifferences().get(0).getValue());
	}
	
	@Test
	public void shoudlHandleSingleArgumentMergingWithSecondaryArgumentMissingSubArgument() {
		Argument subargument = new Argument();	
		subargument.setName("subname");
		subargument.setTemplateParameterName("subtemplateParameterName");
		subargument.setTraversalName("subtraversalName");
		
		Argument arg1 = new Argument();
		arg1.setName("name");
		arg1.setTemplateParameterName("templateParameterName");
		arg1.setTraversalName("traversalName");
		arg1.getArguments().add(subargument);
		
		Argument arg2 = new Argument();
		arg2.setName("name");
		arg2.setTemplateParameterName("templateParameterName");
		arg2.setTraversalName("traversalName");
		
		List<Argument> result = this.merger.merge(Arrays.asList(arg1), Arrays.asList(arg2));
		Assert.assertEquals(1, result.size());
		Assert.assertNotSame(arg1, result.get(0));
		Assert.assertTrue(result.get(0).getChoices().isEmpty());
		Assert.assertTrue(result.get(0).getDifferences().isEmpty());
		Assert.assertEquals("name", result.get(0).getName());
		Assert.assertEquals("templateParameterName", result.get(0).getTemplateParameterName());
		Assert.assertEquals("traversalName", result.get(0).getTraversalName());
		
		Assert.assertEquals(1, result.get(0).getArguments().size());

		Argument resultSubargument = result.get(0).getArguments().get(0);
		Assert.assertTrue(resultSubargument.getChoices().isEmpty());
		Assert.assertTrue(resultSubargument.getArguments().isEmpty());
		Assert.assertEquals("subname", resultSubargument.getName());
		Assert.assertEquals("subtemplateParameterName", resultSubargument.getTemplateParameterName());
		Assert.assertEquals("subtraversalName", resultSubargument.getTraversalName());
		
		Assert.assertEquals(1, resultSubargument.getDifferences().size());
		Assert.assertEquals("missingArgument", resultSubargument.getDifferences().get(0).getType());
		Assert.assertEquals("subname", resultSubargument.getDifferences().get(0).getDifferences().get(0).getValue());
		Assert.assertEquals("[missing]", resultSubargument.getDifferences().get(0).getDifferences().get(1).getValue());
	}
	
}
