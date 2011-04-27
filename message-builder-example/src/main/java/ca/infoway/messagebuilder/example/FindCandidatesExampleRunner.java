/**
 * Copyright 2011 Canada Health Infoway, Inc.
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

package ca.infoway.messagebuilder.example;

import static ca.infoway.messagebuilder.SpecificationVersion.R02_04_02;
import static ca.infoway.messagebuilder.resolver.configurator.DefaultCodeResolutionConfigurator.configureCodeResolversWithTrivialDefault;

import org.w3c.dom.Document;

import ca.infoway.messagebuilder.marshalling.MessageBeanTransformerImpl;
import ca.infoway.messagebuilder.marshalling.RenderMode;
import ca.infoway.messagebuilder.marshalling.hl7.ModelToXmlResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.interaction.FindCandidatesQueryBean;
import ca.infoway.messagebuilder.transport.Credentials;
import ca.infoway.messagebuilder.transport.CredentialsProvider;
import ca.infoway.messagebuilder.transport.SimpleRequestMessage;
import ca.infoway.messagebuilder.transport.UsernamePasswordCredentials;
import ca.infoway.messagebuilder.transport.rest.RestTransportLayer;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;

/**
 * <p>This class shows how to send a simple FindCandidates HL7 query to TL7, via the REST 
 * interface.
 */
public class FindCandidatesExampleRunner {

	private static final String URL = "http://tl7.intelliware.ca/rest";
	
	public static void main(final String[] args) throws Exception {
		if (args.length != 2) {
			System.out.println("Please enter userid and password as command-line arguments.");
		} else {
			
			configureCodeResolversWithTrivialDefault();
			
			FindCandidatesQueryBean messageBean = new FindCandidatesExampleCreator().createFindCandidatesQuery();
			
			ModelToXmlResult xmlQuery = createTransformer().transformToHl7AndReturnResult(
					R02_04_02, 
					messageBean);
			
			System.out.println("Here's the query:");
			System.out.println(xmlQuery.getXmlMessage());
			
			String xmlMessageAsString = xmlQuery.getXmlMessage();
			
			Document xml = new DocumentFactory().createFromString(xmlMessageAsString);
			XmlToModelResult result = createTransformer().transformFromHl7(
					R02_04_02, xml);
			
			Object message = result.getMessageObject();
			
			System.out.println(message.getClass());
			
			String userid = args[0];
			String password = args[1];
			
			String xmlResponse = new RestTransportLayer(URL).sendRequestAndGetResponse(
					createCredentialsProvider(userid, password), 
					SimpleRequestMessage.create(xmlQuery.getXmlMessage()));

			System.out.println("Here's the response:");
			System.out.println(xmlResponse);
		}
	}

	private static MessageBeanTransformerImpl createTransformer() {
		return new MessageBeanTransformerImpl(RenderMode.PERMISSIVE);
	}

	private static CredentialsProvider createCredentialsProvider(final String userid, final String password) {
		return new CredentialsProvider() {
			public Credentials getCredentials() {
				return new UsernamePasswordCredentials(userid, password);
			}
		};
	}		
}