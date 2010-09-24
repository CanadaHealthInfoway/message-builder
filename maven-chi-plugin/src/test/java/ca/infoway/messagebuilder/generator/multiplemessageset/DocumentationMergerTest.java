package ca.infoway.messagebuilder.generator.multiplemessageset;

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

@RunWith(JMock.class)
public class DocumentationMergerTest {

	private OutputUI outputUI;
	private DocumentationMerger merger;
	
	private final Mockery jmock = new JUnit4Mockery() {{
		setImposteriser(ClassImposteriser.INSTANCE);
	}};


	@Before
	public void setup() {
		this.outputUI = this.jmock.mock(OutputUI.class);
		this.merger = new DocumentationMerger(this.outputUI);
	}
	
	@Test
	public void shouldMergeTwoEmptyDocumentations() {
		Documentation result = this.merger.merge(null, null);
		Assert.assertNull(result);
		
		result = this.merger.merge(null, new Documentation());
		Assert.assertNotNull(result);
		Assert.assertTrue(result.getParagraphs().isEmpty());
		Assert.assertNull(result.getBusinessName());
		Assert.assertNull(result.getTitle());
		
		result = this.merger.merge(new Documentation(), null);
		Assert.assertNotNull(result);
		Assert.assertTrue(result.getParagraphs().isEmpty());
		Assert.assertNull(result.getBusinessName());
		Assert.assertNull(result.getTitle());
		
		result = this.merger.merge(new Documentation(), new Documentation());
		Assert.assertNotNull(result);
		Assert.assertTrue(result.getParagraphs().isEmpty());
		Assert.assertNull(result.getBusinessName());
		Assert.assertNull(result.getTitle());
	}
	
	@Test
	public void shouldMergeDocumentationWithEmpty() {
		Documentation doc = new Documentation("para1", "para2");
		doc.setBusinessName("business name");
		doc.setTitle("title");
		
		Documentation result = this.merger.merge(doc, null);
		Assert.assertNotNull(result);
		Assert.assertEquals(2, result.getParagraphs().size());
		Assert.assertEquals("para1", result.getParagraphs().get(0));
		Assert.assertEquals("para2", result.getParagraphs().get(1));
		Assert.assertEquals("business name", result.getBusinessName());
		Assert.assertEquals("title", result.getTitle());
		
		result = this.merger.merge(null, doc);
		Assert.assertNotNull(result);
		Assert.assertEquals(2, result.getParagraphs().size());
		Assert.assertEquals("para1", result.getParagraphs().get(0));
		Assert.assertEquals("para2", result.getParagraphs().get(1));
		Assert.assertEquals("business name", result.getBusinessName());
		Assert.assertEquals("title", result.getTitle());
		
	}
	
	@Test
	public void shouldMergeDocumentations() {
		Documentation doc1 = new Documentation("para11", "para12");
		doc1.setBusinessName("business name1");
		doc1.setTitle("title1");
		
		Documentation doc2 = new Documentation("para21", "para22", "para23");
		doc2.setBusinessName("business name2");
		doc2.setTitle("title2");
		
		Documentation result = this.merger.merge(doc1, doc2);
		Assert.assertNotNull(result);
		Assert.assertEquals(2, result.getParagraphs().size());
		Assert.assertEquals("para11", result.getParagraphs().get(0));
		Assert.assertEquals("para12", result.getParagraphs().get(1));
		Assert.assertEquals("business name1", result.getBusinessName());
		Assert.assertEquals("title1", result.getTitle());
		
		result = this.merger.merge(doc2, doc1);
		Assert.assertNotNull(result);
		Assert.assertEquals(3, result.getParagraphs().size());
		Assert.assertEquals("para21", result.getParagraphs().get(0));
		Assert.assertEquals("para22", result.getParagraphs().get(1));
		Assert.assertEquals("para23", result.getParagraphs().get(2));
		Assert.assertEquals("business name2", result.getBusinessName());
		Assert.assertEquals("title2", result.getTitle());
		
		
	}
}
