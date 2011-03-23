package ca.infoway.messagebuilder.generator.maven;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.maven.plugin.MojoExecutionException;
import org.jmock.Expectations;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import ca.infoway.messagebuilder.generator.java.IntermediateToJavaGenerator;
import ca.infoway.messagebuilder.generator.regen.MergeAllTypesUtil;
import ca.infoway.messagebuilder.junit.JMockMockeryRule;
import ca.infoway.messagebuilder.xml.MessageSetMarshaller;

@RunWith(Theories.class)
public class MultipleXmlToJavaGeneratorMojoTest {

	@Rule
    public JMockMockeryRule jmock = new JMockMockeryRule() {{
       setImposteriser(ClassImposteriser.INSTANCE);
    }};

	private static final String VALID_FILE_1 = "./src/test/java/ca/infoway/messagebuilder/generator/maven/MultipleXmlToJavaGeneratorMojoTest.java";
	private static final String VALID_FILE_2 = "./src/main/java/ca/infoway/messagebuilder/generator/maven/MultipleXmlToJavaGeneratorMojo.java";
	private static final List<String> VALID_FILES = Arrays.asList(VALID_FILE_1, VALID_FILE_2);
	private static final List<File> FILES = Arrays.asList(new File(VALID_FILE_1), new File(VALID_FILE_2));
	private static final String VALID_DIRECTORY = "./src/";

	@DataPoint public static final List<String> NULL = null;
	@DataPoint public static final List<String> EMPTY = new ArrayList<String>();
	@DataPoint public static final List<String> ONLY_ONE = Arrays.asList(VALID_FILE_1);

	@DataPoint public static final List<String> HAS_DIRECTORY = Arrays.asList(VALID_DIRECTORY, VALID_FILE_1);
	@DataPoint public static final List<String> NOT_EXISTS = Arrays.asList("unicorns", VALID_FILE_1);
	
	private MultipleXmlToJavaGeneratorMojo mojo;

	@Before
	public void setUp() {
		this.mojo = new MultipleXmlToJavaGeneratorMojo();
	}
	
	@Test(expected=MojoExecutionException.class) @Theory(nullsAccepted=true)
	public void shouldThrowExceptionIfInputFileIsInvalid(List<String> files) throws Exception {
		this.mojo.setChronologicalMessageSetsToBeMerged(files);
		this.mojo.execute();
	}

	@Test
	public void shouldGenerateSuccessfully() throws Exception {
		final IntermediateToJavaGenerator generator = this.jmock.mock(IntermediateToJavaGenerator.class);
		final MessageSetMarshaller marshaller = this.jmock.mock(MessageSetMarshaller.class);
		final MergeAllTypesUtil mergeUtil = this.jmock.mock(MergeAllTypesUtil.class);
		
		this.mojo = new MultipleXmlToJavaGeneratorMojo() {
			@Override
			IntermediateToJavaGenerator createGenerator() {return generator;}
			@Override
			MessageSetMarshaller createMarshaller() {return marshaller;}
			@Override
			MergeAllTypesUtil createMergeUtil(MessageSetMarshaller marshaller, IntermediateToJavaGenerator generator) {
				return mergeUtil; 
			}
		};
		
		this.mojo.setChronologicalMessageSetsToBeMerged(VALID_FILES);
		this.mojo.setJavaSourceFolder(new File(VALID_DIRECTORY));
		
		this.jmock.checking(new Expectations() {{
			one(mergeUtil).generate(FILES);
		}});
		
		this.mojo.execute();
	}
	
}
