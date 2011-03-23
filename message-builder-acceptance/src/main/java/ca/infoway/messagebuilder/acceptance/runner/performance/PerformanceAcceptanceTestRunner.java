package ca.infoway.messagebuilder.acceptance.runner.performance;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.commons.lang.time.StopWatch;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.io.Resource;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.acceptance.runner.AcceptanceTestResultCallback;
import ca.infoway.messagebuilder.acceptance.runner.AcceptanceTestRunner;
import ca.infoway.messagebuilder.marshalling.MessageBeanTransformerImpl;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.model.NewBaseMessageBean;
import ca.infoway.messagebuilder.resolver.configurator.DefaultCodeResolutionConfigurator;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;
import ca.infoway.messagebuilder.util.xml.InputStreamResource;


public class PerformanceAcceptanceTestRunner implements AcceptanceTestRunner {
	
	private static final int NUM_REPEATS = 1000;
	
	private static final SpecificationVersion VERSION = SpecificationVersion.NEWFOUNDLAND; // R02_04_00;
	private final Log log = LogFactory.getLog(getClass());
	private final StopWatch timer = new StopWatch();
	private final List<Long> timeChecks = Arrays.asList(1000L, 500L, 250L, 100L, 50L, 25L, 20L, 15L, 10L);
	
	private final List<Resource> messageResources;
	private final String name;

	public PerformanceAcceptanceTestRunner(String name, List<Resource> messageResources) {
		this.name = name;
		this.messageResources = messageResources;
	}
	
	private MessageBeanTransformerImpl transformer;
	private DocumentFactory factory;

	private void initializeMarshaller() throws Exception {
		this.transformer = new MessageBeanTransformerImpl();
		this.factory = new DocumentFactory();
		
		DefaultCodeResolutionConfigurator.configureCodeResolversWithTrivialDefault();
	}
	
	public void run(AcceptanceTestResultCallback resultCallback) {
		try {
			initializeMarshaller();
		} catch (Exception e) {
			this.log.error("Marshalling acceptance test could not initialize marshaller", e);
		}
			
		Map<String, Long> timings = new HashMap<String, Long>();
		Set<String> failedTransforms = new HashSet<String>();
		
		performBenchmarkTests(timings, failedTransforms);
		
		calculateResults(resultCallback, timings, failedTransforms);
		
	}

	private void performBenchmarkTests(Map<String, Long> timings, Set<String> failedTransforms) {
		int i = 0;
		for (Resource resource : this.messageResources) {
			String fileName = resource.getFilename();
			System.out.println((i++) + " " + fileName);
			
			long elapsedTime = runAcceptanceTest(resource);
			
			if (elapsedTime == -1) {
				failedTransforms.add(fileName + " could not be processed due to errors");
			} else {
				timings.put(fileName, elapsedTime);
			}
		}
	}

	private void calculateResults(AcceptanceTestResultCallback resultCallback, Map<String, Long> timings, Set<String> failedTransforms) {
		for (Long benchmark : this.timeChecks) {
			List<String> errors = new ArrayList<String>();
			for (Entry<String, Long> entry : timings.entrySet()) {
				if (entry.getValue() > benchmark) {
					errors.add(entry.getKey() + " did not meet benchmark (took " + entry.getValue() + " milliseconds)");
				}
			}
			
			String title = MessageFormat.format(this.name, ""+benchmark);
			int numTotal = timings.size();
			int numSuccessful = numTotal - errors.size();
			
			// keep these errors separate from benchmark "error" numbers above
			errors.addAll(failedTransforms);
			
			resultCallback.done(title, numSuccessful, numTotal, errors);
		}
	}

	private long runAcceptanceTest(Resource resource) {
		Document message;
		try {
			message = createDocument(resource);
			
			this.timer.reset();
			this.timer.start();
			for (int i = 0; i < NUM_REPEATS; i++) {
				doRun(message);
			}
			this.timer.stop();
			
			return this.timer.getTime() / NUM_REPEATS;
			
		} catch (Exception e) {
			this.log.error("Performance acceptance test failed for " + resource.getFilename() + " with exception", e);
			return -1;
		}
		
	}

	private Document createDocument(Resource resource) throws IOException, SAXException {
		final InputStream inputStream = resource.getInputStream();
		Document message = this.factory.createFromResource(new InputStreamResource() {
			public InputStream getInputStream() {
				return inputStream;
			}
		});
		return message;
	}

	@SuppressWarnings("unused")
	private void doRun(Document message) {
		// would be ideal to ensure the initial xml and final xml were the same, but this acceptance test isn't worried about correctness
		XmlToModelResult xmlToJavaResult = this.transformer.transformFromHl7(VERSION, message);
		String xmlString = this.transformer.transformToHl7(VERSION, (NewBaseMessageBean) xmlToJavaResult.getMessageObject());
	}
	
}
