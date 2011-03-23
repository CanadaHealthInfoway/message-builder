package ca.infoway.messagebuilder.generator.dotnet;

import static org.junit.Assert.*;

import java.io.File;

import org.apache.commons.lang.SystemUtils;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.infoway.messagebuilder.generator.java.NameTranslator;
import ca.infoway.messagebuilder.xml.TypeName;


@RunWith(JMock.class)
public class CsharpSourceFileWriterProviderTest {
	
	private Mockery jmock = new Mockery();
	private NameTranslator translator;
	private CsharpSourceFileWriterProvider provider;
	private TypeName typeName;
	
	@Before
	public void setUp() throws Exception {
		this.typeName = new TypeName("ABCD_MT123456CA.MedicationAlert");
		this.translator = this.jmock.mock(NameTranslator.class);
		this.provider = new CsharpSourceFileWriterProvider(SystemUtils.getJavaIoTmpDir(), 
				this.translator);
		this.jmock.checking(new Expectations() {{
			allowing(translator).getPackageName(typeName); will(returnValue("Ca.Infoway.Messagebuilder.Part"));
			allowing(translator).getClassNameWithoutPackage(typeName); will(returnValue("MedicationAlert"));
		}});
	}
	
	@Test
	public void shouldCreateCsharpFile() throws Exception {
		File file = this.provider.createFile(this.typeName);
		assertEquals("name", "MedicationAlert.cs", file.getName());
	}
}
