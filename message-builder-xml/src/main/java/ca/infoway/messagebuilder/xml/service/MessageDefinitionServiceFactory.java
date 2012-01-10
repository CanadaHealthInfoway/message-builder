/**
 * Copyright 2012 Canada Health Infoway, Inc.
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

package ca.infoway.messagebuilder.xml.service;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.List;

import ca.infoway.messagebuilder.service.ServiceFactory;

/**
 * <p>The message defintion service factory provides a list of all message definitions
 * that are available from the classpath.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 * @sharpen.ignore  - xml.service - translated manually
 */
public class MessageDefinitionServiceFactory extends ServiceFactory<MessageDefinitionService> {
	
	private static MessageDefinitionService instance;

	/**
	 * <p>Standard constructor.
	 */
	public MessageDefinitionServiceFactory() {
		super(MessageDefinitionService.class);
	}

	@Override
	protected MessageDefinitionService chooseImplementationOfService(List<MessageDefinitionService> services) {
		return new CompositeMessageDefinitionService(services);
	}

	@Override
	protected MessageDefinitionService createTrivialService() {
		return new TrivialService();
	}
	
	/**
	 * <p>Create an instance of the message definition service.
	 * @return the message definition service
	 */
	@Override
	public MessageDefinitionService create() {
		synchronized (getClass()) {
			if (instance == null) {
				instance = super.create();
			}
			return instance;
		}
	}
	
	@Override
	protected List<MessageDefinitionService> getServices(Enumeration<URL> resources) throws IOException {
		List<MessageDefinitionService> result = super.getServices(resources);
		result.add(new ManifestMessageDefinitionService());
		return result;
	}
}
