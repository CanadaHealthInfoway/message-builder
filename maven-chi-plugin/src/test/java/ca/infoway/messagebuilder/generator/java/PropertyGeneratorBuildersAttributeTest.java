package ca.infoway.messagebuilder.generator.java;

import static ca.infoway.messagebuilder.generator.java.TypeAndRelationshipBuilder.createAssociation;
import static ca.infoway.messagebuilder.generator.java.TypeAndRelationshipBuilder.createAttribute;
import static ca.infoway.messagebuilder.generator.java.TypeAndRelationshipBuilder.createInlinedAttribute;
import static ca.infoway.messagebuilder.generator.java.TypeAndRelationshipBuilder.createType;
import static ca.infoway.messagebuilder.generator.lang.ProgrammingLanguage.JAVA;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.StringWriter;

import org.jmock.Expectations;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.junit.JMockMockeryRule;
import ca.infoway.messagebuilder.xml.Cardinality;

public class PropertyGeneratorBuildersAttributeTest {
	
	@Rule
	public final JMockMockeryRule jmock = new JMockMockeryRule();
	
	private ClassNameManager manager;
	private BaseRelationshipNameResolver nameResolver;
	
	@Before
	public void setUp() throws Exception {
		this.manager = this.jmock.mock(ClassNameManager.class);
		this.nameResolver = this.jmock.mock(BaseRelationshipNameResolver.class);
		this.jmock.checking(new Expectations() {{
			allowing(nameResolver).getName(with(any(BaseRelationship.class))); will(returnValue("relationshipName"));
		}});
	}

	@Test
	public void shouldGenerateMultipleCardinalityInlinedType() throws Exception {
		this.jmock.checking(new Expectations() {{
			allowing(manager).getRepresentationOfClassName(with(equal(Identifier.class.getName()))); will(returnValue("Identifier"));
		}});
		
		Attribute idRelationship = createAttribute("id", new Cardinality(1, 1), "II");
		InlinedAttribute inlinedAttribute = createInlinedAttribute(
				idRelationship, createAssociation("asIdentifiedEntity", new Cardinality(1, 10), createType(null, "IdentifiedEntity", idRelationship)));
		
		StringWriter writer = new StringWriter();
		
		generate(inlinedAttribute, writer);
		
		String output = writer.toString();
		System.out.println(output);
		
		assertTrue("field declaration", output.contains("private List<II>"));
		assertTrue("list", output.contains("List<Identifier>"));
		assertTrue("annotation", output.contains("@Hl7XmlMapping({\"asIdentifiedEntity/id\"})"));
		assertTrue("getter body", output.contains("return new RawListWrapper<II, Identifier>(relationshipName, IIImpl.class)"));
		assertFalse("setter", output.contains("setAsIdentifiedEntity("));
	}

	@Test
	public void shouldGenerateSimpleType() throws Exception {
		this.jmock.checking(new Expectations() {{
			allowing(manager).getRepresentationOfClassName(with(equal(Identifier.class.getName()))); will(returnValue("Identifier"));
		}});
		
		Attribute idRelationship = createAttribute("id", new Cardinality(1, 1), "II");
		
		StringWriter writer = new StringWriter();
		generate(idRelationship, writer);
		
		String output = writer.toString();  
		System.out.println(output);
		
		assertTrue("field", output.contains("private II relationshipName = new IIImpl()"));
		assertTrue("annotation", output.contains("@Hl7XmlMapping({\"id\"})"));
		assertTrue("getter", output.contains("Identifier getRelationshipName("));
		assertTrue("getter body", output.contains("return this.relationshipName.getValue()"));
		assertTrue("setter", output.contains("setRelationshipName(Identifier"));
		assertTrue("setter body", output.contains("this.relationshipName.setValue(relationshipName)"));
	}

	@Test
	public void shouldGenerateSimpleTypeAdbasic() throws Exception {
		this.jmock.checking(new Expectations() {{
			allowing(manager).getRepresentationOfClassName(
					with(equal(PostalAddress.class.getName()))); will(returnValue("PostalAddress"));
		}});
		
		Attribute idRelationship = createAttribute("address", new Cardinality(1, 1), "AD.BASIC");
		
		StringWriter writer = new StringWriter();
		generate(idRelationship, writer);
		
		String output = writer.toString();  
		System.out.println(output);
		
		assertTrue("field", output.contains("private AD relationshipName = new ADImpl()"));
		assertTrue("annotation", output.contains("@Hl7XmlMapping({\"address\"})"));
		assertTrue("getter", output.contains("PostalAddress getRelationshipName("));
		assertTrue("setter", output.contains("setRelationshipName(PostalAddress"));
	}
	
	@Test
	public void shouldGenerateSimpleTypeCd() throws Exception {
		this.jmock.checking(new Expectations() {{
			allowing(manager).getRepresentationOfClassName(with(equal(ActStatus.class.getName())));
				will(returnValue("ActStatus"));
		}});
		
		Attribute idRelationship = createAttribute("code", new Cardinality(1, 1), "CD", "ActStatus");
		
		StringWriter writer = new StringWriter();
		generate(idRelationship, writer);
		
		String output = writer.toString();
		System.out.println(output);
		
		assertTrue("field", output.contains("private CD relationshipName = new CDImpl()"));
		assertTrue("annotation", output.contains("@Hl7XmlMapping({\"code\"})"));
		assertTrue("getter", output.contains("ActStatus getRelationshipName("));
		assertTrue("getter body", output.contains("return (ActStatus) this.relationshipName.getValue()"));
		assertTrue("setter", output.contains("setRelationshipName(ActStatus"));
	}
	
	@Test
	public void shouldGenerateSimpleTypeList() throws Exception {
		this.jmock.checking(new Expectations() {{
			allowing(manager).getRepresentationOfClassName(
					with(equal("java.util.List"))); will(returnValue("List"));
		}});
		
		Attribute idRelationship = createAttribute("names", new Cardinality(1, 1), "LIST<ST>");
		
		StringWriter writer = new StringWriter();
		generate(idRelationship, writer);
		
		String output = writer.toString();
		System.out.println(output);
		
		assertTrue("field", output.contains("private LIST<ST, String> relationshipName = new LISTImpl<ST, String>(STImpl.class)"));
		assertTrue("annotation", output.contains("@Hl7XmlMapping({\"names\"})"));
		assertTrue("getter", output.contains("List<String> getRelationshipName("));
		assertTrue("getter", output.contains("return this.relationshipName.rawList()"));
		assertFalse("no setter", output.contains("setRelationshipName(List<String>"));
	}

	@Test
	public void shouldGenerateCodedTypeList() throws Exception {
		this.jmock.checking(new Expectations() {{
			allowing(manager).getRepresentationOfClassName(
					with(equal("java.util.List"))); will(returnValue("List"));
		}});
		
		Attribute statusesRelationship = createAttribute("statuses", new Cardinality(1, 1), "LIST<CD>", "ActStatus");
		
		StringWriter writer = new StringWriter();
		generate(statusesRelationship, writer);
		
		String output = writer.toString();
		System.out.println(output);
		
		assertTrue("field", output.contains("private LIST<CD, Code> relationshipName = new LISTImpl<CD, Code>(CDImpl.class)"));
		assertTrue("annotation", output.contains("@Hl7XmlMapping({\"statuses\"})"));
		assertTrue("getter", output.contains("List<ActStatus> getRelationshipName("));
		assertTrue("getter body", output.contains("return this.relationshipName.rawList(ActStatus.class)"));
		assertFalse("no setter", output.contains("setRelationshipName(List<ActStatus>"));
	}

	@Test
	public void shouldGenerateCodedTypeSet() throws Exception {
		this.jmock.checking(new Expectations() {{
			allowing(manager).getRepresentationOfClassName(
					with(equal("java.util.Set"))); will(returnValue("Set"));
		}});
		
		Attribute statusesRelationship = createAttribute("statuses", new Cardinality(1, 1), "SET<CD>", "ActStatus");
		
		StringWriter writer = new StringWriter();
		generate(statusesRelationship, writer);
		
		String output = writer.toString();
		System.out.println(output);
		
		assertTrue("field", output.contains("private SET<CD, Code> relationshipName = new SETImpl<CD, Code>(CDImpl.class)"));
		assertTrue("annotation", output.contains("@Hl7XmlMapping({\"statuses\"})"));
		assertTrue("getter", output.contains("Set<ActStatus> getRelationshipName("));
		assertTrue("getter body", output.contains("return this.relationshipName.rawSet(ActStatus.class)"));
		assertFalse("no setter", output.contains("setRelationshipName(Set<ActStatus>"));
	}
	
	@Test
	public void shouldGenerateSimpleTypeSet() throws Exception {
		this.jmock.checking(new Expectations() {{
			allowing(manager).getRepresentationOfClassName(
					with(equal("java.util.Set"))); will(returnValue("Set"));
		}});
		
		Attribute idRelationship = createAttribute("names", new Cardinality(1, 1), "SET<ST>");
		
		StringWriter writer = new StringWriter();
		generate(idRelationship, writer);
		
		String output = writer.toString();
		System.out.println(output);
		
		assertTrue("field", output.contains("private SET<ST, String> relationshipName = new SETImpl<ST, String>(STImpl.class)"));
		assertTrue("annotation", output.contains("@Hl7XmlMapping({\"names\"})"));
		assertTrue("getter", output.contains("Set<String> getRelationshipName("));
		assertTrue("getter", output.contains("return this.relationshipName.rawSet()"));
		assertFalse("no setter", output.contains("setRelationshipName(Set<String>"));
	}

	@Test
	public void shouldGenerateSimpleTypeSetOfRto() throws Exception {
		this.jmock.checking(new Expectations() {{
			allowing(manager).getRepresentationOfClassName(
					with(equal("java.util.Set"))); will(returnValue("Set"));
		}});
		
		Attribute idRelationship = createAttribute("names", new Cardinality(1, 1), "SET<RTO<PQ.DRUG,PQ.TIME>>");
		
		StringWriter writer = new StringWriter();
		generate(idRelationship, writer);
		
		String output = writer.toString();
		System.out.println(output);
		
		assertTrue("field", output.contains(
				"private SET<RTO<PhysicalQuantity, PhysicalQuantity>, Ratio<PhysicalQuantity, PhysicalQuantity>> relationshipName " +
				"= new SETImpl<RTO<PhysicalQuantity, PhysicalQuantity>, Ratio<PhysicalQuantity, PhysicalQuantity>>(RTOImpl.class)"));
		assertTrue("annotation", output.contains("@Hl7XmlMapping({\"names\"})"));
		assertTrue("getter", output.contains("Set<Ratio<PhysicalQuantity, PhysicalQuantity>> getRelationshipName("));
		assertTrue("getter", output.contains("return this.relationshipName.rawSet()"));
		assertFalse("no setter", output.contains("setRelationshipName(Set<Ratio<PhysicalQuantity, PhysicalQuantity>>"));
	}
	
	
	@Test
	public void shouldGenerateSimpleTypeRto() throws Exception {
		this.jmock.checking(new Expectations() {{
			allowing(manager).getRepresentationOfClassName(
					with(equal("ca.infoway.messagebuilder.datatype.lang.Ratio"))); 
				will(returnValue("Ratio"));
		}});
		
		Attribute idRelationship = createAttribute("ratio", new Cardinality(1, 1), "RTO<PQ,PQ>");
		
		StringWriter writer = new StringWriter();
		generate(idRelationship, writer);
		
		String output = writer.toString();
		System.out.println(output);
		
		assertTrue("field", output.contains("private RTO<PhysicalQuantity, PhysicalQuantity> relationshipName = new RTOImpl<PhysicalQuantity, PhysicalQuantity>()"));
		assertTrue("annotation", output.contains("@Hl7XmlMapping({\"ratio\"})"));
		assertTrue("getter", output.contains("Ratio<PhysicalQuantity, PhysicalQuantity> getRelationshipName("));
		assertTrue("getter", output.contains("return this.relationshipName.getValue()"));
		assertTrue("setter", output.contains("setRelationshipName(Ratio<PhysicalQuantity, PhysicalQuantity>"));
	}
	
	@Test
	public void shouldGenerateSimpleTypeIvl() throws Exception {
		this.jmock.checking(new Expectations() {{
			allowing(manager).getRepresentationOfClassName(
					with(equal("ca.infoway.messagebuilder.datatype.lang.Interval"))); 
				will(returnValue("Interval"));
		}});
		
		Attribute idRelationship = createAttribute("ivl", new Cardinality(1, 1), "IVL<TS.FULLDATE>");
		
		StringWriter writer = new StringWriter();
		generate(idRelationship, writer);
		
		String output = writer.toString();
		System.out.println(output);
		
		assertTrue("field", output.contains("private IVL<TS, Interval<Date>> relationshipName = new IVLImpl<TS, Interval<Date>>()"));
		assertTrue("annotation", output.contains("@Hl7XmlMapping({\"ivl\"})"));
		assertTrue("getter", output.contains("Interval<Date> getRelationshipName("));
		assertTrue("getter", output.contains("return this.relationshipName.getValue()"));
		assertTrue("setter", output.contains("setRelationshipName(Interval<Date>"));
	}

	@Test
	public void shouldGenerateSimpleTypePivl() throws Exception {
		this.jmock.checking(new Expectations() {{
			allowing(manager).getRepresentationOfClassName(
					with(equal("ca.infoway.messagebuilder.datatype.lang.PeriodicIntervalTime"))); 
				will(returnValue("PeriodicIntervalTime"));
		}});
		
		Attribute idRelationship = createAttribute("pivl", new Cardinality(1, 1), "PIVL<TS.DATETIME>");
		
		StringWriter writer = new StringWriter();
		generate(idRelationship, writer);
		
		String output = writer.toString();
		System.out.println(output);
		
		assertTrue("field", output.contains("private PIVL relationshipName = new PIVLImpl()"));
		assertTrue("annotation", output.contains("@Hl7XmlMapping({\"pivl\"})"));
		assertTrue("getter", output.contains("PeriodicIntervalTime getRelationshipName("));
		assertTrue("getter", output.contains("return this.relationshipName.getValue()"));
		assertTrue("setter", output.contains("setRelationshipName(PeriodicIntervalTime"));
	}
	
	@Test
	public void shouldGenerateSimpleTypeUrg() throws Exception {
		this.jmock.checking(new Expectations() {{
			allowing(manager).getRepresentationOfClassName(
					with(equal("ca.infoway.messagebuilder.datatype.lang.UncertainRange"))); 
				will(returnValue("UncertainRange"));
		}});
		
		Attribute idRelationship = createAttribute("urg", new Cardinality(1, 1), " URG<PQ.DRUG>");
		
		StringWriter writer = new StringWriter();
		generate(idRelationship, writer);
		
		String output = writer.toString();
		System.out.println(output);
		
		assertTrue("field", output.contains("private URG<PQ, PhysicalQuantity> relationshipName = new URGImpl<PQ, PhysicalQuantity>()"));
		assertTrue("annotation", output.contains("@Hl7XmlMapping({\"urg\"})"));
		assertTrue("getter", output.contains("UncertainRange<PhysicalQuantity> getRelationshipName("));
		assertTrue("getter", output.contains("return this.relationshipName.getValue()"));
		assertTrue("setter", output.contains("setRelationshipName(UncertainRange<PhysicalQuantity>"));
	}

	@Test
	public void shouldGenerateSimpleTypeEdDoc() throws Exception {
		this.jmock.checking(new Expectations() {{
			allowing(manager).getRepresentationOfClassName(
					with(equal("ca.infoway.messagebuilder.datatype.lang.EncapsulatedData"))); 
				will(returnValue("EncapsulatedData"));
		}});
		
		Attribute idRelationship = createAttribute("ed", new Cardinality(1, 1), "ED.DOC");
		
		StringWriter writer = new StringWriter();
		generate(idRelationship, writer);
		
		String output = writer.toString();
		System.out.println(output);
		
		assertTrue("field", output.contains("private ED<EncapsulatedData> relationshipName = new EDImpl<EncapsulatedData>()"));
		assertTrue("annotation", output.contains("@Hl7XmlMapping({\"ed\"})"));
		assertTrue("getter", output.contains("EncapsulatedData getRelationshipName("));
		assertTrue("getter", output.contains("return this.relationshipName.getValue()"));
		assertTrue("setter", output.contains("setRelationshipName(EncapsulatedData"));
	}	

	@Test
	public void shouldGenerateSimpleTypeEdDocOrRef() throws Exception {
		this.jmock.checking(new Expectations() {{
			allowing(manager).getRepresentationOfClassName(
					with(equal("ca.infoway.messagebuilder.datatype.lang.EncapsulatedData"))); 
				will(returnValue("EncapsulatedData"));
		}});
		
		Attribute idRelationship = createAttribute("ed", new Cardinality(1, 1), "ED.DOCORREF");
		
		StringWriter writer = new StringWriter();
		generate(idRelationship, writer);
		
		String output = writer.toString();
		System.out.println(output);
		
		assertTrue("field", output.contains("private ED<EncapsulatedData> relationshipName = new EDImpl<EncapsulatedData>()"));
		assertTrue("annotation", output.contains("@Hl7XmlMapping({\"ed\"})"));
		assertTrue("getter", output.contains("EncapsulatedData getRelationshipName("));
		assertTrue("getter", output.contains("return this.relationshipName.getValue()"));
		assertTrue("setter", output.contains("setRelationshipName(EncapsulatedData"));
	}	

	@Test
	public void shouldGenerateSimpleTypeEdDocRef() throws Exception {
		this.jmock.checking(new Expectations() {{
			allowing(manager).getRepresentationOfClassName(
					with(equal("ca.infoway.messagebuilder.datatype.lang.EncapsulatedData"))); 
				will(returnValue("EncapsulatedData"));
		}});
		
		Attribute idRelationship = createAttribute("ed", new Cardinality(1, 1), "ED.DOCREF");
		
		StringWriter writer = new StringWriter();
		generate(idRelationship, writer);
		
		String output = writer.toString();
		System.out.println(output);
		
		assertTrue("field", output.contains("private ED<EncapsulatedData> relationshipName = new EDImpl<EncapsulatedData>()"));
		assertTrue("annotation", output.contains("@Hl7XmlMapping({\"ed\"})"));
		assertTrue("getter", output.contains("EncapsulatedData getRelationshipName("));
		assertTrue("getter", output.contains("return this.relationshipName.getValue()"));
		assertTrue("setter", output.contains("setRelationshipName(EncapsulatedData"));
	}	

	@Test
	public void shouldGenerateSimpleTypeEdSignature() throws Exception {
		this.jmock.checking(new Expectations() {{
			allowing(manager).getRepresentationOfClassName(
					with(equal("ca.infoway.messagebuilder.datatype.lang.EncapsulatedData"))); 
				will(returnValue("EncapsulatedData"));
		}});
		
		Attribute idRelationship = createAttribute("ed", new Cardinality(1, 1), "ED.SIGNATURE");
		
		StringWriter writer = new StringWriter();
		generate(idRelationship, writer);
		
		String output = writer.toString();
		System.out.println(output);
		
		assertTrue("field", output.contains("private ED<String> relationshipName = new EDImpl<String>()"));
		assertTrue("annotation", output.contains("@Hl7XmlMapping({\"ed\"})"));
		assertTrue("getter", output.contains("String getRelationshipName("));
		assertTrue("getter", output.contains("return this.relationshipName.getValue()"));
		assertTrue("setter", output.contains("setRelationshipName(String"));
	}	

	private void generate(Attribute attribute, StringWriter writer) throws IOException {
		PropertyGenerator generator = PropertyGeneratorBuilders.newAttributeBuilder(JAVA, attribute).build(this.manager, this.nameResolver);
		generator.createAttributeDefinition(0, writer);
		generator.createGettersAndSetters(0, writer);
	}

}
