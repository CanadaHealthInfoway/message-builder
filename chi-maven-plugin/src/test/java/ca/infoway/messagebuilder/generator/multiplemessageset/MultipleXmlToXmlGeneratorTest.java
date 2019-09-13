/**
 * Copyright 2013 Canada Health Infoway, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

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

import ca.infoway.messagebuilder.generator.FileSet;
import ca.infoway.messagebuilder.generator.LogLevel;
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
	private TemplateParameterNameRenamer templateParameterNameRenamer;
	
	@Before
	public void setUp() {
		this.outputUI = this.jmock.mock(OutputUI.class);
		this.messageSetWriter = this.jmock.mock(MessageSetWriter.class);
		this.messageSetMarshaller = this.jmock.mock(MessageSetMarshaller.class);
		this.templateParameterNameRenamer = this.jmock.mock(TemplateParameterNameRenamer.class); 
		this.generator = new MultipleXmlToXmlGenerator(this.outputUI, "a_version", this.messageSetMarshaller, this.messageSetWriter, this.templateParameterNameRenamer, null); 
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void shouldFailCallingIncorrectMethod() throws Exception {
		this.generator.processAllMifs(null);
	}
	
	@Test
	public void shouldProcessSuccessfully() throws Exception {
		final File inputMessageSet1 = new File("inputFile1");
		final FileSet fileSet1 = new FileSet("1", inputMessageSet1);
		final File inputMessageSet2 = new File("inputFile2");
		final FileSet fileSet2 = new FileSet("2", inputMessageSet2);
		final List<FileSet> inputFileSets = Arrays.asList(fileSet1, fileSet2);
		
		 final MessageSet messageSet1 = new MessageSet();
		 final MessageSet messageSet2 = new MessageSet();
		
		this.jmock.checking(new Expectations() {{
			one(messageSetMarshaller).unmarshall(inputMessageSet1); will(returnValue(messageSet1));
			one(messageSetMarshaller).unmarshall(inputMessageSet2); will(returnValue(messageSet2));
			one(templateParameterNameRenamer).renameTemplateParameterNames(with(new MessageSet[]{messageSet1, messageSet2}));
			one(outputUI).log(LogLevel.INFO, MultipleXmlToXmlGenerator.MESSAGE_SET_MERGE_COMPLETED);
		}});
		
		this.generator.processAllMessageSets(inputFileSets);

		
		final File outputMessageSet = new File("outputFile");
		
		this.jmock.checking(new Expectations() {{
			one(messageSetWriter).writeToMessageSet(outputMessageSet);
		}});

		this.generator.writeToMessageSet(outputMessageSet);
		
	}

}
