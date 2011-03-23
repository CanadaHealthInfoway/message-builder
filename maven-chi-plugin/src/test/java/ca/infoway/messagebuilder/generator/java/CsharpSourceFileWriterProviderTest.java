package ca.infoway.messagebuilder.generator.java;

import static ca.infoway.messagebuilder.generator.lang.ProgrammingLanguage.C_SHARP;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.apache.commons.lang.SystemUtils;
import org.junit.Test;

import ca.infoway.messagebuilder.xml.TypeName;


public class CsharpSourceFileWriterProviderTest {
	
	@Test
	public void shouldCreateWriter() throws Exception {
		JavaSourceFileWriterProvider provider = new JavaSourceFileWriterProvider(
				SystemUtils.getJavaIoTmpDir(), new SimpleNameTranslator(C_SHARP, "ca.infoway.test", new TypeNameHelperImpl()));
		File file = provider.createFile(new TypeName("ABCD_MT123456CA.Subject23"));
		
		assertTrue("file name: " + file.getAbsolutePath(), 
				file.getAbsolutePath().endsWith("ca/infoway/test/abcd_mt123456ca/Subject23.java"));
	}
}
