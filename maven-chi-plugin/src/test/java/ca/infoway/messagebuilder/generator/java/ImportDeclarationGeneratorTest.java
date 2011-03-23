package ca.infoway.messagebuilder.generator.java;

import static ca.infoway.messagebuilder.generator.lang.ProgrammingLanguage.JAVA;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import ca.infoway.messagebuilder.xml.TypeName;


public class ImportDeclarationGeneratorTest {
	
	@Test
	public void shouldHandleSimpleImports() throws Exception {
		Collection<Object> classes = new ArrayList<Object>();
		classes.add("ca.infoway.temp.MyClass");
		classes.add("ca.infoway.temp.MyClass2");
		classes.add("ca.infoway.temp.SomethingElse"); 
		classes.add("ca.infoway.messagebuilder.datatype.Interval"); 
		
		generate(classes, 4);
	}
	
	@Test
	public void shouldNotTryToImportSameClassMoreThanOnce() throws Exception {
		Collection<Object> classes = new ArrayList<Object>();
		classes.add("ca.infoway.temp.MyClass");
		classes.add("ca.infoway.temp2.MyClass");
		classes.add("ca.infoway.temp.SomethingElse"); 
		
		generate(classes, 2);
	}

	@Test
	public void shouldIdentifyWhichItemShouldBeFullyQualified() throws Exception {
		Collection<Object> classes = new ArrayList<Object>();
		classes.add("ca.infoway.temp.MyClass");
		classes.add("ca.infoway.temp2.MyClass");
		classes.add("ca.infoway.temp.SomethingElse"); 

		ImportDeclarationGenerator generator = new ImportDeclarationGenerator(new TypeName("ABCD_MT123456CA.Stephen"), 
				classes, new SimpleNameTranslator(JAVA, "ca.infoway.example", new TypeNameHelperImpl()), null);

		assertEquals("second", "ca.infoway.temp2.MyClass", generator.getRepresentationOfClassName("ca.infoway.temp2.MyClass"));
		assertEquals("first", "MyClass", generator.getRepresentationOfClassName("ca.infoway.temp.MyClass"));
	}

	@Test
	public void shouldOmitPackageNameWhenTypeIsInCurrentPackage() throws Exception {
		Collection<Object> classes = new ArrayList<Object>();
		classes.add("ca.infoway.temp.Fred");
		classes.add("ca.infoway.temp.SomethingElse"); 
		
		ImportDeclarationGenerator generator = new ImportDeclarationGenerator(new TypeName("ABCD_MT123456CA.Stephen"), 
				classes, new SimpleNameTranslator(JAVA, "ca.infoway.example", new TypeNameHelperImpl()), null);
		
		assertEquals("class", "MyClass", generator.getRepresentationOfClassName("ca.infoway.example.abcd_mt123456ca.MyClass"));
	}
	
	@Test
	public void shouldKeepPackageNameWhenTypeIsInCurrentPackageButImportCollisionExists() throws Exception {
		Collection<Object> classes = new ArrayList<Object>();
		classes.add("ca.infoway.temp.Fred");
		classes.add("ca.infoway.temp.MyClass");
		classes.add("ca.infoway.temp.SomethingElse"); 
		
		ImportDeclarationGenerator generator = new ImportDeclarationGenerator(new TypeName("ABCD_MT123456CA.Stephen"), 
				classes, new SimpleNameTranslator(JAVA, "ca.infoway.example", new TypeNameHelperImpl()), null);
		
		assertEquals("class", "ca.infoway.example.abcd_mt123456ca.MyClass", generator.getRepresentationOfClassName("ca.infoway.example.abcd_mt123456ca.MyClass"));
	}
	
	@Test
	public void shouldNotTryToImportExactSameClassMoreThanOnce() throws Exception {
		Collection<Object> classes = new ArrayList<Object>();
		classes.add("ca.infoway.temp.MyClass");
		classes.add("ca.infoway.temp.MyClass");
		classes.add("ca.infoway.temp.SomethingElse"); 
		
		generate(classes, 2);
	}
	
	@Test
	public void shouldNotTryToImportJavaLangClasses() throws Exception {
		Collection<Object> classes = new ArrayList<Object>();
		classes.add("ca.infoway.temp.MyClass");
		classes.add("java.lang.String");
		classes.add("ca.infoway.temp.SomethingElse"); 
		
		generate(classes, 2);
	}
	
	@Test
	public void shouldRememberWhatRemovedTypesMapTo() throws Exception {
		Collection<Object> classes = new ArrayList<Object>();
		classes.add("ca.infoway.temp.MyClass");
		classes.add("java.lang.String");
		classes.add("ca.infoway.temp.SomethingElse"); 
		
		TypeName removedType = new TypeName("PRPA_123456CA.RemovedType");
		TypeName newType = new TypeName("PRPA_654321CA.NewType");
		
		Map<TypeName, TypeName> removedTypesTranslator = new HashMap<TypeName, TypeName>();
		removedTypesTranslator.put(removedType, newType);
		
		ImportDeclarationGenerator generator = new ImportDeclarationGenerator(new TypeName("ABCD_MT123456CA.Stephen"), 
				classes, new SimpleNameTranslator(JAVA, "ca.infoway.example", new TypeNameHelperImpl()), removedTypesTranslator);

		Assert.assertEquals("ca.infoway.example.prpa_654321ca.NewTypeBean", generator.getRepresentationOfTypeName(removedType));
		
	}
	
	private void generate(Collection<Object> classes, int count) throws IOException {
		ImportDeclarationGenerator generator = new ImportDeclarationGenerator(new TypeName("ABCD_MT123456CA.Stephen"), 
				classes, new SimpleNameTranslator(JAVA, "ca.infoway.example", new TypeNameHelperImpl()), null);
		
		StringWriter writer = new StringWriter();
		generator.generate(writer, 0);
		
		String output = writer.toString().trim();
		String[] imports = StringUtils.split(output, ";");
		assertEquals("imports", count, imports.length);
	}
}
