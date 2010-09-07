package ca.infoway.messagebuilder.generator.multiplemessageset;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.infoway.messagebuilder.generator.MessageSetWriter;
import ca.infoway.messagebuilder.generator.OutputUI;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.MessageSetMarshaller;

@RunWith(JMock.class)
public class MultipleXmlToXmlGeneratorTest {

	private final Mockery jmock = new JUnit4Mockery() {{
		setImposteriser(ClassImposteriser.INSTANCE);
	}};
	private MultipleXmlToXmlGenerator generator;
	private OutputUI outputUI;
	private MessageSetWriter messageSetWriter;
	private MessageSetMarshaller messageSetMarshaller; 
	
	@Before
	public void setUp() {
		this.outputUI = this.jmock.mock(OutputUI.class);
		this.messageSetWriter = this.jmock.mock(MessageSetWriter.class);
		this.messageSetMarshaller = this.jmock.mock(MessageSetMarshaller.class);
		this.generator = new MultipleXmlToXmlGenerator(this.outputUI, "a_version", this.messageSetMarshaller, this.messageSetWriter); 
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void shouldFailCallingIncorrectMethod() throws Exception {
		this.generator.processAllMifs(null);
	}
	
	@Test
	public void shouldProcessSuccessfully() throws Exception {
		final File inputMessageSet1 = new File("inputFile1");
		final File inputMessageSet2 = new File("inputFile2");
		final List<File> inputMessageSets = Arrays.asList(inputMessageSet1, inputMessageSet2);
		
		this.jmock.checking(new Expectations() {{
			one(messageSetMarshaller).unmarshall(inputMessageSet1); will(returnValue(new MessageSet()));
			one(messageSetMarshaller).unmarshall(inputMessageSet2); will(returnValue(new MessageSet()));
		}});
		
		this.generator.processAllMessageSets(inputMessageSets);

		
		final File outputMessageSet = new File("outputFile");
		
		this.jmock.checking(new Expectations() {{
			one(messageSetWriter).writeToMessageSet(outputMessageSet);
		}});

		this.generator.writeToMessageSet(outputMessageSet);
		
	}

}
