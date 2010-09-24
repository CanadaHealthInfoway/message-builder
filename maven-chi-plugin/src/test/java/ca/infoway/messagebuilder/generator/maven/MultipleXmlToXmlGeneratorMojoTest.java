package ca.infoway.messagebuilder.generator.maven;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.maven.plugin.Mojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.infoway.messagebuilder.generator.MessageSetGenerator;

@RunWith(JMock.class)
public class MultipleXmlToXmlGeneratorMojoTest {
	
	private Mockery jmock = new Mockery();
	private MessageSetGeneratorFactory factory;
	private MultipleXmlToXmlGeneratorMojo mojo;
	private MessageSetGenerator generator;
	
	@Before
	public void setUp() {
		this.factory = this.jmock.mock(MessageSetGeneratorFactory.class);
		this.mojo = new MultipleXmlToXmlGeneratorMojo(this.factory);
		this.generator = this.jmock.mock(MessageSetGenerator.class);
	}
	
	@Test(expected=MojoExecutionException.class)
	public void shouldRejectIfNoInputProvided() throws Exception {
		this.mojo.execute();
	}
	
	@Test(expected=MojoExecutionException.class)
	public void shouldRejectIfInputMessageSetsAreEmpty() throws Exception {
		this.mojo.setInputMessageSets(new ArrayList<FileSet>());
		this.mojo.setVersion("version");
		this.mojo.execute();
	}

	@Test(expected=MojoExecutionException.class)
	public void shouldRejectIfTooManyInputMessageSets() throws Exception {
		List<FileSet> input = new ArrayList<FileSet>();
		input.add(new FileSet("name1", new File("1")));
		input.add(new FileSet("name1", new File("2")));
		input.add(new FileSet("name1", new File("3")));
		this.mojo.setInputMessageSets(input);
		this.mojo.setVersion("version");
		this.mojo.execute();
	}

	@Test(expected=MojoExecutionException.class)
	public void shouldRejectIfNoVersionProvided() throws Exception {
		List<FileSet> input = new ArrayList<FileSet>();
		input.add(new FileSet("name1", new File("1")));
		input.add(new FileSet("name2", new File("2")));
		this.mojo.setInputMessageSets(input);
		this.mojo.execute();
	}

	@Test(expected=MojoExecutionException.class)
	public void shouldRejectIfOnlyOneInputMessageSets() throws Exception {
		List<FileSet> input = new ArrayList<FileSet>();
		input.add(new FileSet("name", new File("1")));
		this.mojo.setInputMessageSets(input);
		this.mojo.setVersion("version");
		this.mojo.execute();
	}

	@Test
	public void shouldProcessSuccessfully() throws Exception {
		this.jmock.checking(new Expectations() {{
			one(factory).create((Mojo) with(anything()), (String) with(anything())); will(returnValue(generator));
			allowing(generator);
		}});
		this.mojo.setInputMessageSets(Arrays.asList(new FileSet("name1", new File("1")), new FileSet("name2", new File("2"))));
		this.mojo.setVersion("merged version");
		this.mojo.execute();
	}
}
