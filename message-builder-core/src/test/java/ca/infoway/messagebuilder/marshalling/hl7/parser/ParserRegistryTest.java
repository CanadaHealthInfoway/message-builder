package ca.infoway.messagebuilder.marshalling.hl7.parser;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.List;

import org.apache.commons.lang.ClassUtils;
import org.junit.Test;

import ca.infoway.messagebuilder.j5goodies.JavaFileUtil;
import ca.infoway.messagebuilder.platform.ClassUtil;
import ca.infoway.messagebuilder.platform.SourceCodeLocationUtil;

public class ParserRegistryTest {
	
	@Test
	public void testShouldFindSimpleCase() throws Exception {
		assertNotNull("II", ParserRegistry.getInstance().get("II"));
	}

	@Test
	public void testShouldDefaultToUnqualifiedTypeIfNoSpecificParserExists() throws Exception {
		assertNotNull("II.TOKEN", ParserRegistry.getInstance().get("II.TOKEN"));
	}
	
	@Test
	public void testShouldFindCeParser() throws Exception {
		assertTrue("CE", ParserRegistry.getInstance().get("CE") instanceof CvElementParser);
	}
	
    @Test
    @SuppressWarnings("unchecked")
    public void testAllParsersAreRegistered() throws Exception {
        List<File> files = getAllClasses();
        
        for (File file : files) {
            String javaClassName = JavaFileUtil.convertFileNameToJavaClassName(SourceCodeLocationUtil.SOURCE_DIRECTORY, file);
            try {
	            Class<?> javaClass = Class.forName(javaClassName);
	            if (isParser(javaClass)) {
	                assertParserIsRegistered((Class<? extends ElementParser>) javaClass);
	            }
            } catch (ClassNotFoundException e) {
            	// this case shouldn't happen in Java, but is useful when the code is 
            	// converted to .Net
            }
        }
    }

	private void assertParserIsRegistered(Class<? extends ElementParser> javaClass) throws Exception {
        List<String> keys = ParserRegistry.getInstance().getRegistrationKey(javaClass);
        for (String string : keys) {
            assertNotNull("register " + javaClass.getName() + " (" + string + ")", 
                    ParserRegistry.getInstance().get(string));
        }
    }

    private boolean isParser(Class<?> javaClass) {
        return ElementParser.class.isAssignableFrom(javaClass) && !ClassUtil.isAbstract(javaClass);
    }

    private List<File> getAllClasses() {
        return SourceCodeLocationUtil.getAllSourceFiles(ClassUtils.getPackageName(getClass()));
    }

    
}
