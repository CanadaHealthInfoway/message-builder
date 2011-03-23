package ca.infoway.messagebuilder.generator.maven;

import java.io.File;

import org.apache.maven.plugin.Mojo;

import ca.infoway.messagebuilder.generator.GeneratorException;
import ca.infoway.messagebuilder.generator.MessageSetGenerator;
import ca.infoway.messagebuilder.generator.MifToXmlGenerator;
import ca.infoway.messagebuilder.maven.util.OutputUIImpl;

/**
 * <p>The standard implementation of the generator factory.
 * 
 * @author administrator
 */
class MessageSetGeneratorFactoryImpl implements MessageSetGeneratorFactory {
	
	public MessageSetGenerator create(Mojo mojo, String version, File mifTransform) throws GeneratorException {
		return new MifToXmlGenerator(new OutputUIImpl(mojo), version, mifTransform);
	}

}
