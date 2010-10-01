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

import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.CodingStrength;
import ca.infoway.messagebuilder.xml.ConformanceLevel;
import ca.infoway.messagebuilder.xml.Documentation;
import ca.infoway.messagebuilder.xml.Relationship;

@RunWith(JMock.class)
public class RelationshipMergerTest {

	private MergeContext mergeContext;
	private RelationshipMerger merger;
	private DocumentationMerger documentationMerger;
	
	private final Mockery jmock = new JUnit4Mockery() {{
		setImposteriser(ClassImposteriser.INSTANCE);
	}};

	@Before
	public void setup() {
		this.mergeContext = this.jmock.mock(MergeContext.class);
		this.documentationMerger = this.jmock.mock(DocumentationMerger.class);
		
		this.jmock.checking(new Expectations() {{
			allowing(mergeContext).getPrimaryVersion(); will(returnValue("1"));
			allowing(mergeContext).getSecondaryVersion(); will(returnValue("2"));
			allowing(mergeContext).setCurrentMessagePart(with(any(String.class)));
			allowing(mergeContext).getCurrentMessagePart(); will(returnValue("aCurrentMessagePart"));
		}});
		
		this.merger = new RelationshipMerger(this.mergeContext, this.documentationMerger);
	}

	@Test
	public void shoudlHandleNullRelationships() {
		Relationship result = this.merger.merge(null, null);
		Assert.assertNull(result);
	}
	
	@Test
	public void shoudlHandleOneNullRelationship() {
		Relationship primary = new Relationship();
		Relationship result = this.merger.merge(primary, null);
		Assert.assertSame(primary, result);
		
		Relationship secondary = new Relationship();
		result = this.merger.merge(null, secondary);
		Assert.assertSame(secondary, result);
	}
	
	@Test
	public void shoudlHandleEmptyRelationships() {
		this.jmock.checking(new Expectations() {{
			one(documentationMerger).merge(null, null); will(returnValue(null));
		}});

		Relationship result = this.merger.merge(new Relationship(), new Relationship());
		Assert.assertNotNull(result);
		Assert.assertNull(result.getName());
	}
	
	@Test
	public void shoudlMergeRelationships() {
		final Documentation primaryDoc = new Documentation();
		
		Relationship primary = new Relationship();
		primary.setCardinality(new Cardinality(1,1));
		primary.setCodingStrength(CodingStrength.CNE);
		primary.setConformance(ConformanceLevel.MANDATORY);
		primary.setDefaultValue("aDefault");
		primary.setDocumentation(primaryDoc);
		primary.setDomainType("ActCode");
		primary.setFixedValue("aFixedValue");
		primary.setLength(1);
		primary.setName("aName");
		primary.setSortOrder(1);
		primary.setStructural(false);
		primary.setTemplateParameterName("aParamName");
		primary.setType("aType");
		
		final Documentation secondaryDoc = new Documentation();

		Relationship secondary = new Relationship();
		secondary.setCardinality(new Cardinality(1,10));
		secondary.setCodingStrength(CodingStrength.CWE);
		secondary.setConformance(ConformanceLevel.OPTIONAL);
		secondary.setDefaultValue("bDefault");
		secondary.setDocumentation(secondaryDoc);
		secondary.setDomainType("AdministrativeGender");
		secondary.setFixedValue("bFixedValue");
		secondary.setLength(2);
		secondary.setName("bName");
		secondary.setSortOrder(2);
		secondary.setStructural(true);
		secondary.setTemplateParameterName("bParamName");
		secondary.setType("bType");
		
		this.jmock.checking(new Expectations() {{
			one(documentationMerger).merge(primaryDoc, secondaryDoc); will(returnValue(primaryDoc));
			one(mergeContext).logError("aCurrentMessagePart - domain types are different: ActCode, AdministrativeGender");
			one(mergeContext).logError("aCurrentMessagePart - relationship names should not be different: aName, bName");
			one(mergeContext).logError("aCurrentMessagePart - templateParameterNames are different: aParamName, bParamName");
			one(mergeContext).logError("aCurrentMessagePart - types are different: aType, bType");
		}});

		Relationship result = this.merger.merge(primary, secondary);
		Assert.assertNotNull(result);
		Assert.assertNotSame(primary, result);
		Assert.assertNotSame(secondary, result);
		Assert.assertTrue(result.getCardinality().isMultiple());
		Assert.assertEquals(primary.getChoices().size(), result.getChoices().size());
		Assert.assertEquals(CodingStrength.CNE, result.getCodingStrength());
		Assert.assertEquals(ConformanceLevel.OPTIONAL, result.getConformance());
		Assert.assertEquals("aDefault", result.getDefaultValue());
		Assert.assertEquals(3, result.getDifferences().size()); // name difference is a true error and should not log a difference
		Assert.assertEquals(primaryDoc, result.getDocumentation());
		Assert.assertEquals("ActCode", result.getDomainType());
		Assert.assertEquals("aFixedValue", result.getFixedValue());
		Assert.assertEquals(Integer.valueOf(1), result.getLength());
		Assert.assertEquals("aName", result.getName());
		Assert.assertEquals(1, result.getSortOrder());
		Assert.assertEquals("aParamName", result.getTemplateParameterName());
		Assert.assertEquals("aType", result.getType());
	}
	
}
