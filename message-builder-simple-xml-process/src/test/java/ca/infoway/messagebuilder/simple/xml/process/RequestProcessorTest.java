package ca.infoway.messagebuilder.simple.xml.process;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.TrivialCodeResolver;


public class RequestProcessorTest {
	
	@Test
	public void shouldTransform() throws Exception {
		CodeResolverRegistry.register(new TrivialCodeResolver());
		
		String message = readMessage();
		RequestProcessor processor = new RequestProcessor(SpecificationVersion.R02_04_02);
		String hl7 = processor.process(message);
		
		System.out.println(hl7);
		
	}

	private String readMessage() throws IOException {
		InputStream input = getClass().getResourceAsStream("/findCandidates.xml");
		try {
			return IOUtils.toString(input);
		} finally {
			IOUtils.closeQuietly(input);
		}
	}

}
