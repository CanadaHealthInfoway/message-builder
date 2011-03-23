package ca.infoway.messagebuilder.simple.xml.process;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.TrivialCodeResolver;


public class ResponseProcessorTest {
	
	@Before
	public void setUp() throws Exception {
		CodeResolverRegistry.register(new TrivialCodeResolver());
	}
	
	@Test
	public void shouldProcessResponse() throws Exception {
		String responseDocument = loadResponseDocument();
		String string = new ResponseProcessor(SpecificationVersion.R02_04_02).process(responseDocument);
		System.out.println(string);
	}

	private String loadResponseDocument() throws IOException {
		InputStream input = getClass().getResourceAsStream("/findCandidatesResponse.xml");
		try {
			return IOUtils.toString(input);
		} finally {
			IOUtils.closeQuietly(input);
		}
	}

}
