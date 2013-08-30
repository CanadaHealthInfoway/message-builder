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
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.junit.XmlAssert;
import ca.infoway.messagebuilder.marshalling.MessageBeanTransformerImpl;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.model.newfoundland.NewBaseMessageBean;
import ca.infoway.messagebuilder.resolver.configurator.DefaultCodeResolutionConfigurator;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;
import ca.infoway.messagebuilder.util.xml.InputStreamResource;


public class MarshallingAcceptanceTestRunner implements AcceptanceTestRunner {
	
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
			
			XmlToModelResult xmlToJavaResult = this.transformer.transformFromHl7(NEWFOUNDLAND_LEGACY_VERSION_HACK, message);
			
			String xmlString = this.transformer.transformToHl7(NEWFOUNDLAND_LEGACY_VERSION_HACK, (NewBaseMessageBean) xmlToJavaResult.getMessageObject()).getXmlMessage();
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
