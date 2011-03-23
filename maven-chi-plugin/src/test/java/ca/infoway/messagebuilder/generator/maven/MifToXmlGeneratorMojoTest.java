package ca.infoway.messagebuilder.generator.maven;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

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
public class MifToXmlGeneratorMojoTest {
	
	private Mockery jmock = new Mockery();
	private MessageSetGeneratorFactory factory;
	private MifToXmlGeneratorMojo mojo;
	private MessageSetGenerator generator;
	
	@Before
	public void setUp() {
		this.factory = this.jmock.mock(MessageSetGeneratorFactory.class);
		this.mojo = new MifToXmlGeneratorMojo(this.factory);
		this.generator = this.jmock.mock(MessageSetGenerator.class);
	}
	
	
	@Test(expected=MojoExecutionException.class)
	public void shouldRejectIfNoSourceDirectoryConfigured() throws Exception {
		this.mojo.execute();
	}
	
	@Test(expected=MojoExecutionException.class)
	public void shouldRejectIfFileSetsAreEmpty() throws Exception {
		this.mojo.setFileSets(new ArrayList<FileSet>());
		this.mojo.execute();
	}

	@Test
	public void shouldProcessSuccessfully() throws Exception {
		this.jmock.checking(new Expectations() {{
			one(factory).create((Mojo) with(anything()), (String) with(anything()), (File) with(anything())); will(returnValue(generator));
			allowing(generator);
		}});
		this.mojo.setFileSets(Arrays.asList(new FileSet("category1", new File("./src"))));
		this.mojo.setVersion("R02.04.00");
		this.mojo.execute();
	}
}
