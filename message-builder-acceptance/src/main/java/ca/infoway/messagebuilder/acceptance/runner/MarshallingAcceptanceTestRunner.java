package ca.infoway.messagebuilder.acceptance.runner;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.io.Resource;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.junit.XmlAssert;
import ca.infoway.messagebuilder.marshalling.MessageBeanTransformerImpl;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.model.NewBaseMessageBean;
import ca.infoway.messagebuilder.resolver.configurator.DefaultCodeResolutionConfigurator;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;
import ca.infoway.messagebuilder.util.xml.InputStreamResource;


public class MarshallingAcceptanceTestRunner implements AcceptanceTestRunner {
	
	private static final SpecificationVersion VERSION = SpecificationVersion.NEWFOUNDLAND; // R02_04_00;
	
	private final Log log = LogFactory.getLog(getClass());
	
	private final List<Resource> messageResources;

	public MarshallingAcceptanceTestRunner(List<Resource> messageResources) {
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
			for (Resource resource : this.messageResources) {
				doRun(resource, resultCallback);
			}
		} catch (Exception e) {
			this.log.error("Marshalling acceptance test could not initialize marshaller", e);
		}
	}

	private void doRun(Resource resource, AcceptanceTestResultCallback resultCallback) {
		try {
			final InputStream inputStream = resource.getInputStream();
			
			Document message = this.factory.createFromResource(new InputStreamResource() {
				public InputStream getInputStream() {
					return inputStream;
				}
			});
			
			XmlToModelResult xmlToJavaResult = this.transformer.transformFromHl7(VERSION, message);
			
			String xmlString = this.transformer.transformToHl7(VERSION, (NewBaseMessageBean) xmlToJavaResult.getMessageObject());
			XmlAssert.assertTreeEquals(message, this.factory.createFromString(xmlString));
			
			resultCallback.done(resource.getFilename(),	1, 1, Collections.<String>emptyList());
			this.log.debug("Test passed for " + resource.getFilename());
		} catch (AssertionError e) {
			this.log.debug("Assertion failed", e);
			resultCallback.done(resource.getFilename(), 0, 1, Arrays.asList(resource.getFilename()));
		} catch (Exception e) {
			this.log.debug("Acceptance test failed with exception", e);
			resultCallback.done(resource.getFilename(), 0, 1, Arrays.<String>asList(resource.getFilename() +"("+e.getMessage()+")"));
		}
	}
	
	enum MockActCode implements ActCode {
		SEV, DRUG, G, PORX_TE010210UV;

		public String getCodeSystem() {
			return CodeSystem.VOCABULARY_ACT_CODE.getRoot();
		}

		public String getCodeValue() {
			return name();
		}
		
	}
	
	enum QueryRequestLimitEnum implements Code {
		RD;
		public String getCodeSystem() {
			return CodeSystem.VOCABULARY_QUERY_REQUEST_LIMIT.getRoot();
		}

		public String getCodeValue() {
			return name();
		}
	}	
	

}
