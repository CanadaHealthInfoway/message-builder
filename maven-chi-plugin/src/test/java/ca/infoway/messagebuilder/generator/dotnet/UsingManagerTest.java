package ca.infoway.messagebuilder.generator.dotnet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hamcrest.Matchers;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.infoway.messagebuilder.generator.java.NameTranslator;
import ca.infoway.messagebuilder.xml.TypeName;


@RunWith(JMock.class)
public class UsingManagerTest {
	
	private Mockery jmock = new Mockery();
	private NameTranslator translator;
	private StringWriter writer;
	private TypeName name;
	private NamespaceContents contents;
	
	@Before
	public void setUp() throws Exception {
		this.translator = this.jmock.mock(NameTranslator.class);
		this.contents = this.jmock.mock(NamespaceContents.class);
		this.writer = new StringWriter();
		this.name = new TypeName("ABCD_MT123456CA.MyPart");
		
		this.jmock.checking(new Expectations() {{
			allowing(translator).getClassNameWithoutPackage(name); will(returnValue(name.getUnqualifiedName()));
			allowing(translator).getFullyQualifiedClassName(name); will(returnValue("Ca.Intelliware.Model." + name.getName()));
			allowing(translator).getPackageName(name); will(returnValue("Ca.Intelliware.Model." + name.getParent().getName()));

			allowing(contents).getAllTypes("Ca.Intelliware.Model.ABCD_MT123456CA"); will(returnValue(Arrays.asList("MyPart")));
			allowing(contents).getAllTypes(with(Matchers.startsWith("System"))); will(returnValue(Arrays.asList("Something")));
		}});
	}
	
	@Test
	public void shouldImportSystemTypes() throws Exception {
		
		Set<Object> classes = new HashSet<Object>();
		classes.add(List.class.getName());
		UsingManager manager = new UsingManager(this.name, classes, this.translator, this.contents, new HashMap<TypeName, TypeName>());
		manager.generate(this.writer, 1);
		
		String output = writer.toString();
		System.out.println(output);
	
		assertTrue("using System", output.contains("using System.Collections.Generic;"));
		assertEquals("IList", manager.getRepresentationOfClassName("System.Collections.Generic.IList"));
	}

	@Test
	public void shouldImportAllPackageNames() throws Exception {

		final TypeName fred1 = new TypeName("ABCD_MT111111CA.Fred");
		final TypeName fred2 = new TypeName("ABCD_MT222222CA.Fred");
		final TypeName betty = new TypeName("ABCD_MT222222CA.Betty");
		final TypeName wilma = new TypeName("ABCD_MT222222CA.Wilma");
		
		this.jmock.checking(new Expectations() {{
			allowing(translator).getFullyQualifiedClassName(fred1); will(returnValue("Ca.Intelliware.Model." + fred1.getName()));
			allowing(translator).getFullyQualifiedClassName(fred2); will(returnValue("Ca.Intelliware.Model." + fred2.getName()));
			allowing(translator).getFullyQualifiedClassName(wilma); will(returnValue("Ca.Intelliware.Model." + wilma.getName()));
			allowing(translator).getFullyQualifiedClassName(betty); will(returnValue("Ca.Intelliware.Model." + betty.getName()));

			allowing(contents).getAllTypes("Ca.Intelliware.Model.ABCD_MT111111CA"); will(returnValue(Arrays.asList("Fred")));
			allowing(contents).getAllTypes("Ca.Intelliware.Model.ABCD_MT222222CA"); will(returnValue(Arrays.asList("Fred", "Betty", "Wilma")));
		}});
		
		Set<Object> classes = new HashSet<Object>();
		classes.add(fred1);
		classes.add(fred2);
		classes.add(wilma);
		classes.add(betty);
		UsingManager manager = new UsingManager(this.name, classes, this.translator, this.contents, new HashMap<TypeName, TypeName>());
		manager.generate(this.writer, 1);
		
		String output = writer.toString();
		System.out.println(output);
		
		assertTrue("using package 2", output.contains("using Ca.Intelliware.Model.ABCD_MT222222CA;"));
		assertTrue("using package 1", output.contains("using Ca.Intelliware.Model.ABCD_MT111111CA;"));
		assertEquals("Ca.Intelliware.Model.ABCD_MT111111CA.Fred", manager.getRepresentationOfTypeName(fred1));
		assertEquals("Ca.Intelliware.Model.ABCD_MT222222CA.Fred", manager.getRepresentationOfTypeName(fred2));
	}
	
	@Test
	public void shouldConvertCaseOfPackages() throws Exception {
		
		final TypeName fred1 = new TypeName("ABCD_MT111111CA.Fred");
		final TypeName fred2 = new TypeName("ABCD_MT222222CA.Fred");
		
		this.jmock.checking(new Expectations() {{
			allowing(translator).getFullyQualifiedClassName(fred1); will(returnValue("ca.intelliware.model." + fred1.getName()));
			allowing(translator).getFullyQualifiedClassName(fred2); will(returnValue("ca.intelliware.model." + fred2.getName()));
			
			allowing(contents).getAllTypes("Ca.Intelliware.Model.ABCD_MT111111CA"); will(returnValue(Arrays.asList("Fred")));
			allowing(contents).getAllTypes("Ca.Intelliware.Model.ABCD_MT222222CA"); will(returnValue(Arrays.asList("Fred")));
		}});
		
		Set<Object> classes = new HashSet<Object>();
		classes.add(fred1);
		classes.add(fred2);
		UsingManager manager = new UsingManager(this.name, classes, this.translator, this.contents, new HashMap<TypeName, TypeName>());
		manager.generate(this.writer, 1);
		
		String output = writer.toString();
		System.out.println(output);
		
		assertTrue("using package 2", output.contains("using Ca.Intelliware.Model.ABCD_MT222222CA;"));
		assertTrue("using package 1", output.contains("using Ca.Intelliware.Model.ABCD_MT111111CA;"));
	}
	
	@Test
	public void shouldNotImportMyOwnNamespace() throws Exception {
		
		Set<Object> classes = new HashSet<Object>();
		classes.add(List.class.getName());
		UsingManager manager = new UsingManager(this.name, classes, this.translator, this.contents, new HashMap<TypeName, TypeName>());
		manager.generate(this.writer, 1);
		
		String output = writer.toString();
		System.out.println(output);
		
		assertFalse("using System", output.contains("Ca.Intelliware.Model;"));
	}
}
