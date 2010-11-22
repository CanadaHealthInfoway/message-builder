package ca.infoway.messagebuilder.generator.dotnet;

import static org.junit.Assert.assertTrue;

import java.io.StringWriter;
import java.io.Writer;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.infoway.messagebuilder.datatype.ANY;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.generator.TypeConverter;
import ca.infoway.messagebuilder.generator.java.Association;
import ca.infoway.messagebuilder.generator.java.Attribute;
import ca.infoway.messagebuilder.generator.java.InteractionType;
import ca.infoway.messagebuilder.generator.java.LanguageSpecificName;
import ca.infoway.messagebuilder.generator.java.NameTranslator;
import ca.infoway.messagebuilder.generator.java.Type;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.TypeName;


@RunWith(JMock.class)
public class Hl7DotNetMessageTypeWriterTest {
	
	private Mockery jmock = new Mockery();
	private Hl7DotNetMessageTypeWriter writer;
	private NameTranslator translator;
	private TypeName typeName;
	private StringWriter stringWriter;
	private Type type;
	private DependencyManager manager;
	
	@Before
	public void setUp() throws Exception {
		this.typeName = new TypeName("ABCD_MT123456CA.BatteryRequest");
		this.type = new Type(this.typeName);
		this.type.setLanguageSpecificName(new LanguageSpecificName("Ca.Infoway.Messagebuilder.Fred", "BatteryRequest"));
		final String associationTypeName = "ABCD_MT123456CA.Component3";
		this.type.getRelationships().add(new Attribute(new Relationship("id", "II.BUS", Cardinality.create("1")), new TypeConverter().convertToType("II.BUS", null)));
		this.type.getRelationships().add(new Attribute(new Relationship("details", "ANY", Cardinality.create("1")), new TypeConverter().convertToType("ANY", null)));
		this.type.getRelationships().add(Association.createStandardAssociation(new Relationship("component", associationTypeName, Cardinality.create("1")), new Type(new TypeName(associationTypeName))));
		Relationship myChoice = new Relationship("myChoice", "ABCD_MT123456CA.MyChoice", Cardinality.create("1"));
		myChoice.getChoices().add(new Relationship("option1", "ABCD_MT123456CA.Option1", Cardinality.create("1")));
		myChoice.getChoices().add(new Relationship("option1", "ABCD_MT123456CA.Option2", Cardinality.create("1")));
		this.type.getRelationships().add(Association.createStandardAssociation(myChoice, new Type(new TypeName("ABCD_MT123456CA.MyChoice"))));
		this.translator = this.jmock.mock(NameTranslator.class);
		this.manager = this.jmock.mock(DependencyManager.class);

		this.jmock.checking(new Expectations() {{
			allowing(manager).generate(with(any(Writer.class)), with(any(Integer.class))); 
			allowing(translator).getPackageName(typeName); will(returnValue("Ca.Infoway.Messagebuilder.Fred"));
			allowing(translator).getClassNameWithoutPackage(typeName); will(returnValue("BatteryRequest"));
			allowing(manager).getRepresentationOfClassName(Identifier.class.getName()); will(returnValue("Identifier"));
			allowing(manager).getRepresentationOfClassName(ANY.class.getName()); will(returnValue("ANY"));
			allowing(manager).getRepresentationOfClassName("System.object"); will(returnValue("object"));
			allowing(manager).getRepresentationOfClassName(".IMyChoice"); will(returnValue("IMyChoice"));
			allowing(manager).getRepresentationOfClassName(".IMyOtherChoice"); will(returnValue("IMyOtherChoice"));
			allowing(manager).getRepresentationOfTypeName(new TypeName("ABCD_MT123456CA.MyChoice")); will(returnValue("IMyChoice"));
			allowing(manager).getRepresentationOfTypeName(new TypeName("ABCD_MT123456CA.Option1")); will(returnValue("Ca.Infoway.Messagebuilder.Model.Abcd_mt123456ca.Option1"));
			allowing(manager).getRepresentationOfTypeName(new TypeName("ABCD_MT123456CA.Option2")); will(returnValue("Option2"));
			allowing(manager).getRepresentationOfTypeName(new TypeName("ABCD_MT123456CA.MyOtherChoice")); will(returnValue("IMyOtherChoice"));
			allowing(manager).getRepresentationOfTypeName(new TypeName(associationTypeName)); will(returnValue("Requestor"));
		}});
		this.writer = new Hl7DotNetMessageTypeWriter(this.type, translator, this.manager);
		this.stringWriter = new StringWriter();
	}

	@Test
	public void shouldProduceClassDeclaration() throws Exception {
		this.writer.write(this.stringWriter);
		String output = stringWriter.toString();
		assertContains("public class BatteryRequest : MessagePart", output);
	}

	@Test
	public void shouldWriteConstructor() throws Exception {
		this.writer.write(this.stringWriter);
		String output = stringWriter.toString();
		assertContains("public BatteryRequest()", output);
		assertContains("this.id = new IIImpl();", output);
		assertContains("this.details = new ANYImpl<object>();", output);
	}
	
	@Test
	public void shouldWritePartTypeMapping() throws Exception {
		this.writer.write(this.stringWriter);
		String output = stringWriter.toString();
		assertContains("[Hl7PartTypeMappingAttribute(new string[] {\"ABCD_MT123456CA.BatteryRequest\"})]", output);
	}
	
	@Test
	public void shouldWriteNamespace() throws Exception {
		this.writer.write(this.stringWriter);
		String output = stringWriter.toString();
		assertContains("namespace Ca.Infoway.Messagebuilder.Fred", output);
	}
	
	@Test
	public void shouldWriteInteraction() throws Exception {
		final TypeName interactionName = new TypeName("ABCD_IN123456CA.BetterBatterQuery");
		this.jmock.checking(new Expectations() {{
			allowing(translator).getPackageName(interactionName); will(returnValue("Ca.Infoway.Messagebuilder.Interaction"));
			allowing(translator).getClassNameWithoutPackage(interactionName); will(returnValue("BetterBatterQuery"));
		}});
		InteractionType interactionType = new InteractionType(interactionName);
		interactionType.setLanguageSpecificName(new LanguageSpecificName("Ca.Infoway.Messagebuilder.Interaction", "BetterBatterQuery"));
		interactionType.setParentType(new Type(this.typeName));
		interactionType.getParentType().setLanguageSpecificName(new LanguageSpecificName("Ca.Infoway.Messagebuilder.Interaction", "BatteryRequest"));
		
		new Hl7DotNetMessageTypeWriter(interactionType, translator, this.manager).write(this.stringWriter);
		String output = this.stringWriter.toString();
		assertContains("class BetterBatterQuery : BatteryRequest, IInteraction ", output);
	}
	
	@Test
	public void shouldWriteInterfaces() throws Exception {
		Type type1 = new Type(new TypeName("ABCD_MT123456CA.MyChoice"));
		type1.setLanguageSpecificName(new LanguageSpecificName("", "IMyChoice"));
		this.type.getInterfaceTypes().add(type1);
		Type type2 = new Type(new TypeName("ABCD_MT123456CA.MyOtherChoice"));
		type2.setLanguageSpecificName(new LanguageSpecificName("", "IMyOtherChoice"));
		this.type.getInterfaceTypes().add(type2);
		
		this.writer.write(this.stringWriter);
		String output = stringWriter.toString();
		assertContains(", IMyOtherChoice", output);
		assertContains(", IMyChoice", output);
	}
	
	@Test
	public void shouldWriteInterfaceDefinition() throws Exception {
		this.type.setAbstract(true);
		Type type1 = new Type(new TypeName("ABCD_MT123456CA.MyChoice"));
		type1.setLanguageSpecificName(new LanguageSpecificName("", "IMyChoice"));
		this.type.getInterfaceTypes().add(type1);
		
		this.writer.write(this.stringWriter);
		String output = stringWriter.toString();
		assertContains(": IMyChoice", output);
	}
	
	@Test
	public void shouldWriteAssociationDefinition() throws Exception {
		this.writer.write(this.stringWriter);
		String output = stringWriter.toString();
		assertContains("private Requestor component;", output);
	}
	
	@Test
	public void shouldWriteAssociationGetter() throws Exception {
		this.writer.write(this.stringWriter);
		String output = stringWriter.toString();
System.out.println(output);		
		assertContains("return this.component;", output);
	}
	
	@Test
	public void shouldWriteAbstractAssociation() throws Exception {
		this.type.setAbstract(true);
		this.writer.write(this.stringWriter);
		String output = stringWriter.toString();
System.out.println(output);
		assertContains("get;", output);
	}
	
	private static void assertContains(String expectedSubstring, String actual) {
		assertTrue(expectedSubstring, actual.contains(expectedSubstring));
	}
}
