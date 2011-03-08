package ca.infoway.messagebuilder.generator.maven;

import java.io.File;

import org.apache.maven.plugin.Mojo;

import ca.infoway.messagebuilder.generator.GeneratorException;
import ca.infoway.messagebuilder.generator.MessageSetGenerator;

interface MessageSetGeneratorFactory {
	public MessageSetGenerator create(Mojo mojo, String version, File mifTransformer, File reportDir) throws GeneratorException;
	public MessageSetGenerator create(Mojo mojo, String version, File reportDir) throws GeneratorException;
}
