package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.util.List;

import org.apache.commons.lang.ClassUtils;
import org.junit.Test;

import ca.infoway.messagebuilder.j5goodies.JavaFileUtil;
import ca.infoway.messagebuilder.platform.ClassUtil;
import ca.infoway.messagebuilder.platform.SourceCodeLocationUtil;


public class FormatterRegistryTest {

    @Test
    @SuppressWarnings("unchecked")
    public void testAllFormattersAreRegistered() throws Exception {
        List<File> files = getAllClasses();
        
        for (File file : files) {
            String javaClassName = JavaFileUtil.convertFileNameToJavaClassName(SourceCodeLocationUtil.SOURCE_DIRECTORY, file);
            Class<?> javaClass = Class.forName(javaClassName);
            if (isFormatter(javaClass)) {
                assertFormatterIsRegistered((Class<? extends PropertyFormatter>) javaClass);
            }
        }
    }

    private void assertFormatterIsRegistered(Class<? extends PropertyFormatter> javaClass) throws Exception {
        List<String> keys = FormatterRegistry.getInstance().getRegistrationKey(javaClass);
        for (String string : keys) {
            assertNotNull("register " + javaClass.getName() + " (" + string + ")", 
                    FormatterRegistry.getInstance().get(string));
        }
    }

    private boolean isFormatter(Class<?> javaClass) {
        return PropertyFormatter.class.isAssignableFrom(javaClass) && !ClassUtil.isAbstract(javaClass);
    }

    private List<File> getAllClasses() {
    	return SourceCodeLocationUtil.getAllSourceFiles(ClassUtils.getPackageName(getClass()));
    }

    @Test
    public void testShouldFindListIiOidFormatter() throws Exception {
    	assertNotNull("formatter", FormatterRegistry.getInstance().get("LIST<II.OID>"));
	}
}
