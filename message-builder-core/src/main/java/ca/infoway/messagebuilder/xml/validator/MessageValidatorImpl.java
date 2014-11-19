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

package ca.infoway.messagebuilder.xml.validator;

import org.w3c.dom.Document;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.marshalling.MessageBeanTransformerImpl;
import ca.infoway.messagebuilder.marshalling.RenderMode;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.resolver.GenericCodeResolverRegistry;
import ca.infoway.messagebuilder.xml.service.MessageDefinitionService;
import ca.infoway.messagebuilder.xml.service.MessageDefinitionServiceFactory;

public class MessageValidatorImpl implements MessageValidator {
	
	private final MessageBeanTransformerImpl messageTransformer;
	
	public MessageValidatorImpl() {
		this(new MessageDefinitionServiceFactory().create());
	}
	
	public MessageValidatorImpl(MessageDefinitionService service) {
		this.messageTransformer = new MessageBeanTransformerImpl(service, RenderMode.PERMISSIVE);
	}

	public MessageValidatorResult validate(Document message, VersionNumber version) {
		return this.validate(message, version, null);
	}
	
	public MessageValidatorResult validate(Document message, VersionNumber version, GenericCodeResolverRegistry codeResolverRegistryOverride) {
		XmlToModelResult transformResults = this.messageTransformer.transformFromHl7(version, message, codeResolverRegistryOverride);
		return new MessageValidatorResult(transformResults.getHl7Errors());
	}
}
