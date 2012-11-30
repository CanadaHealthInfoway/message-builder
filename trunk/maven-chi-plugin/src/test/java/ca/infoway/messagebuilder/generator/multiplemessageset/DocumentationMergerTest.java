/**
 * Copyright 2012 Canada Health Infoway, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

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

import ca.infoway.messagebuilder.xml.Annotation;
import ca.infoway.messagebuilder.xml.Documentation;

@RunWith(JMock.class)
public class DocumentationMergerTest {

	private MergeContext mergeContext;
	private DocumentationMerger merger;
	
	private final Mockery jmock = new JUnit4Mockery() {{
		setImposteriser(ClassImposteriser.INSTANCE);
	}};


	@Before
	public void setup() {
		this.mergeContext = this.jmock.mock(MergeContext.class);
		this.jmock.checking(new Expectations() {{
			allowing(mergeContext).getPrimaryVersion(); will(returnValue("1"));
			allowing(mergeContext).getSecondaryVersion(); will(returnValue("2"));
		}});
		
		this.merger = new DocumentationMerger(this.mergeContext);
	}
	
	@Test
	public void shouldMergeTwoEmptyDocumentations() {
		Documentation result = this.merger.merge(null, null);
		Assert.assertNull(result);
		
		result = this.merger.merge(null, new Documentation());
		Assert.assertNotNull(result);
		Assert.assertTrue(result.getAnnotations().isEmpty());
		Assert.assertNull(result.getBusinessName());
		Assert.assertNull(result.getTitle());
		
		result = this.merger.merge(new Documentation(), null);
		Assert.assertNotNull(result);
		Assert.assertTrue(result.getAnnotations().isEmpty());
		Assert.assertNull(result.getBusinessName());
		Assert.assertNull(result.getTitle());
		
		result = this.merger.merge(new Documentation(), new Documentation());
		Assert.assertNotNull(result);
		Assert.assertTrue(result.getAnnotations().isEmpty());
		Assert.assertNull(result.getBusinessName());
		Assert.assertNull(result.getTitle());
	}
	
	@Test
	public void shouldMergeDocumentationWithEmpty() {
		Documentation doc = new Documentation(new Annotation("para1"), new Annotation("para2"));
		doc.setBusinessName("business name");
		doc.setTitle("title");
		
		Documentation result = this.merger.merge(doc, null);
		Assert.assertNotNull(result);
		Assert.assertEquals(2, result.getAnnotations().size());
		Assert.assertEquals("para1", result.getAnnotations().get(0).getText());
		Assert.assertEquals("para2", result.getAnnotations().get(1).getText());
		Assert.assertEquals("business name", result.getBusinessName());
		Assert.assertEquals("title", result.getTitle());
		
		result = this.merger.merge(null, doc);
		Assert.assertNotNull(result);
		Assert.assertEquals(2, result.getAnnotations().size());
		Assert.assertEquals("para1", result.getAnnotations().get(0).getText());
		Assert.assertEquals("para2", result.getAnnotations().get(1).getText());
		Assert.assertEquals("business name", result.getBusinessName());
		Assert.assertEquals("title", result.getTitle());
		
	}
	
	@Test
	public void shouldMergeDocumentations() {
		Documentation doc1 = new Documentation(new Annotation("para11"), new Annotation("para12"));
		doc1.setBusinessName("business name1");
		doc1.setTitle("title1");
		
		Documentation doc2 = new Documentation(new Annotation("para21"), new Annotation("para22"), new Annotation("para23"));
		doc2.setBusinessName("business name2");
		doc2.setTitle("title2");
		
		Documentation result = this.merger.merge(doc1, doc2);
		Assert.assertNotNull(result);
		Assert.assertEquals(2, result.getAnnotations().size());
		Assert.assertEquals("para11", result.getAnnotations().get(0).getText());
		Assert.assertEquals("para12", result.getAnnotations().get(1).getText());
		Assert.assertEquals("business name1", result.getBusinessName());
		Assert.assertEquals("title1", result.getTitle());
		
		result = this.merger.merge(doc2, doc1);
		Assert.assertNotNull(result);
		Assert.assertEquals(3, result.getAnnotations().size());
		Assert.assertEquals("para21", result.getAnnotations().get(0).getText());
		Assert.assertEquals("para22", result.getAnnotations().get(1).getText());
		Assert.assertEquals("para23", result.getAnnotations().get(2).getText());
		Assert.assertEquals("business name2", result.getBusinessName());
		Assert.assertEquals("title2", result.getTitle());
		
		
	}
}
