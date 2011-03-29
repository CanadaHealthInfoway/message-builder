package ca.infoway.messagebuilder.comparator;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.List;

import org.junit.Test;

import ca.infoway.messagebuilder.comparator.BeanAnalyzer.ErrorType;

public class BeanAnalyzerTest {

	@Test
	public void analyze() throws Exception {
		 BeanAnalysisResult result = new BeanAnalyzer(
				 convertPathString("./src/test/java/ca/infoway/messagebuilder/comparator/oldbean/"),
						 convertPathString("./src/test/java/ca/infoway/messagebuilder/comparator/newbean/")
				 ).analyze();
		 System.out.println(result.getBeanAnalysisReport());
		 System.out.println("DONE!");
	}
	
	@Test
	public void shouldFindErrorsForOneBeanInSuiteRun() throws Exception {
		BeanAnalysisResult result = new BeanAnalyzer(
				convertPathString("./src/test/java/ca/infoway/messagebuilder/comparator/oldbean/"),
				convertPathString("./src/test/java/ca/infoway/messagebuilder/comparator/newbean/")
		).analyze();
		List<BeanAnalysisError> errors = result.getBeanAnalysisErrors("./src/test/java/ca/infoway/messagebuilder/comparator/oldbean/SampleBean.java");
		assertEquals(3, errors.size());
		assertEquals(ErrorType.EXTENDS, errors.get(0).getErrorType());
		assertEquals(ErrorType.IMPLEMENTS, errors.get(1).getErrorType());
		assertEquals(ErrorType.METHOD_NOT_FOUND, errors.get(2).getErrorType());
	}
	
	@Test
	public void shouldFindErrorsForOneBean() throws Exception {
		List<BeanAnalysisError> errors = 
			new BeanAnalyzer(
					convertPathString("./src/test/java/ca/infoway/messagebuilder/comparator/oldbean/"),
					convertPathString("./src/test/java/ca/infoway/messagebuilder/comparator/newbean/")
			).analyzeFile(new File("./src/test/java/ca/infoway/messagebuilder/comparator/oldbean/SampleBean.java"));
		assertEquals(3, errors.size());
		assertEquals(ErrorType.EXTENDS, errors.get(0).getErrorType());
		assertEquals(ErrorType.IMPLEMENTS, errors.get(1).getErrorType());
		assertEquals(ErrorType.METHOD_NOT_FOUND, errors.get(2).getErrorType());
	}
	
    private String convertPathString(String path) {
        return path.replace('/', System.getProperty("file.separator").charAt(0));
    }
}
