package ca.infoway.messagebuilder.generator.transform;

import org.w3c.dom.Document;

import ca.infoway.messagebuilder.generator.GeneratorException;

public interface MifTransform {

	public Document transform(Document documentToTransform) throws GeneratorException;
	
	public boolean shouldBeTransformed(Document documentToTransform) throws GeneratorException;
	
}
