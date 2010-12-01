package ca.infoway.messagebuilder.generator.regen;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JMock;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.infoway.messagebuilder.generator.java.IntermediateToJavaGenerator;
import ca.infoway.messagebuilder.generator.java.TypeAnalysisResult;
import ca.infoway.messagebuilder.junit.JMockMockeryRule;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.MessageSetMarshaller;

@RunWith(JMock.class)
public class MergeAllTypesUtilTest {

	private static final String VALID_FILE_1 = "./src/test/java/ca/infoway/messagebuilder/generator/maven/MultipleXmlToJavaGeneratorMojoTest.java";
	private static final String VALID_FILE_2 = "./src/main/java/ca/infoway/messagebuilder/generator/maven/MultipleXmlToJavaGeneratorMojo.java";
	private static final List<File> FILES = Arrays.asList(new File(VALID_FILE_1), new File(VALID_FILE_2));

	public JMockMockeryRule jmock = new JMockMockeryRule() {{
        setImposteriser(ClassImposteriser.INSTANCE);
     }};

	private IntermediateToJavaGenerator generator;
	private MessageSetMarshaller marshaller;

	@Before
	public void setUp() {
		generator = this.jmock.mock(IntermediateToJavaGenerator.class);
		marshaller = this.jmock.mock(MessageSetMarshaller.class);
	}
	
	@Test
	public void shouldGenerateSuccessfully() throws Exception {
		final MessageSet messageSet1 = new MessageSet();
		final MessageSet messageSet2 = new MessageSet();
		final TypeAnalysisResult typeAnalysisResult1 = new TypeAnalysisResult();
		final TypeAnalysisResult typeAnalysisResult2 = new TypeAnalysisResult();
		final TypeAnalysisResult typeAnalysisResultMerged = new TypeAnalysisResult();
		
		MergeAllTypesUtil mergeUtil = new MergeAllTypesUtil(marshaller, generator) {
			@Override
			public TypeAnalysisResult merge(TypeAnalysisResult oldTypesResult, TypeAnalysisResult newTypesResult) {
				return typeAnalysisResultMerged;
			}
		};
		
		this.jmock.checking(new Expectations() {{
			one(marshaller).unmarshall(new File(VALID_FILE_1)); will(returnValue(messageSet1));
			one(marshaller).unmarshall(new File(VALID_FILE_2)); will(returnValue(messageSet2));
			one(generator).generate(messageSet1); will(returnValue(typeAnalysisResult1));
			one(generator).generate(messageSet2); will(returnValue(typeAnalysisResult2));
//			one(generator).simplify(typeAnalysisResultMerged);
			one(generator).completeProcessing(typeAnalysisResultMerged);
		}});
		
		mergeUtil.generate(FILES);
	}
	
}
