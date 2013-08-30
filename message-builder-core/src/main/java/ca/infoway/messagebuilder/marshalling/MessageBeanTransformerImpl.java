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

package ca.infoway.messagebuilder.marshalling;

import java.util.TimeZone;

import org.w3c.dom.Document;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.marshalling.hl7.ModelToXmlResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.GenericCodeResolverRegistry;
import ca.infoway.messagebuilder.xml.service.MessageDefinitionService;
import ca.infoway.messagebuilder.xml.service.MessageDefinitionServiceFactory;

public class MessageBeanTransformerImpl {
	
	private final MessageDefinitionService service;
	private final RenderMode renderMode;
	private final TimeZone dateTimeZone;
	private final TimeZone dateTimeTimeZone;

	public MessageBeanTransformerImpl() {
		this(new MessageDefinitionServiceFactory().create(), RenderMode.STRICT);
	}
	public MessageBeanTransformerImpl(RenderMode renderMode) {
		this(new MessageDefinitionServiceFactory().create(), renderMode);
	}
	public MessageBeanTransformerImpl(MessageDefinitionService service, RenderMode renderMode) {
		this(service, renderMode, null, null);
	}
	public MessageBeanTransformerImpl(MessageDefinitionService service, RenderMode renderMode, TimeZone dateTimeZone, TimeZone dateTimeTimeZone) {
		this.service = service;
		this.renderMode = renderMode;
		this.dateTimeZone = dateTimeZone;
		this.dateTimeTimeZone = dateTimeTimeZone;
	}
	
	public XmlToModelResult transformFromHl7(VersionNumber version, Document hl7Message) {
		return transformFromHl7(version, hl7Message, this.dateTimeZone, this.dateTimeTimeZone, null);
	}
	
	public XmlToModelResult transformFromHl7(VersionNumber version, Document hl7Message, GenericCodeResolverRegistry codeResolverRegistryOverride) {
		return transformFromHl7(version, hl7Message, this.dateTimeZone, this.dateTimeTimeZone, codeResolverRegistryOverride);
	}
	
	public XmlToModelResult transformFromHl7(VersionNumber version, Document hl7Message, TimeZone dateTimeZone, TimeZone dateTimeTimeZone, GenericCodeResolverRegistry codeResolverRegistryOverride) {
		CodeResolverRegistry.setThreadLocalVersion(version);
		CodeResolverRegistry.setThreadLocalCodeResolverRegistryOverride(codeResolverRegistryOverride);
		
		XmlToModelResult results = new Hl7SourceMapper().mapToTeal(new Hl7MessageSource(version, hl7Message, dateTimeZone, dateTimeTimeZone, this.service));
		
		CodeResolverRegistry.clearThreadLocalVersion();
		CodeResolverRegistry.clearThreadLocalCodeResolverRegistryOverride();
		
		return results;
	}

	// FIXME - TM - should return ModelToXmlResult (every transformation test will require changing)
	public String transformToHl7(VersionNumber version, InteractionBean messageBean) {
		return transformToHl7AndReturnResult(version, messageBean).getXmlMessage();
	}
	
	public String transformToHl7(VersionNumber version, InteractionBean messageBean, TimeZone dateTimeZone, TimeZone dateTimeTimeZone) {
		return transformToHl7AndReturnResult(version, messageBean, dateTimeZone, dateTimeTimeZone, null).getXmlMessage();
	}

	public ModelToXmlResult transformToHl7AndReturnResult(VersionNumber version, InteractionBean messageBean) {
		return transformToHl7AndReturnResult(version, messageBean, this.dateTimeZone, this.dateTimeTimeZone, null);
	}
	
	public ModelToXmlResult transformToHl7AndReturnResult(VersionNumber version, InteractionBean messageBean, GenericCodeResolverRegistry codeResolverRegistryOverride) {
		return transformToHl7AndReturnResult(version, messageBean, this.dateTimeZone, this.dateTimeTimeZone, codeResolverRegistryOverride);
	}
	
	public ModelToXmlResult transformToHl7AndReturnResult(VersionNumber version, InteractionBean messageBean, TimeZone dateTimeZone, TimeZone dateTimeTimeZone, GenericCodeResolverRegistry codeResolverRegistryOverride) {
		CodeResolverRegistry.setThreadLocalVersion(version);
		CodeResolverRegistry.setThreadLocalCodeResolverRegistryOverride(codeResolverRegistryOverride);

		XmlRenderingVisitor visitor = new XmlRenderingVisitor();
		new TealBeanRenderWalker(messageBean, version, dateTimeZone, dateTimeTimeZone, this.service).accept(visitor);

		CodeResolverRegistry.clearThreadLocalVersion();
		CodeResolverRegistry.clearThreadLocalCodeResolverRegistryOverride();
		
		ModelToXmlResult result = visitor.toXml();
		if (!result.isValid() && isStrict()) {
			throw new InvalidRenderInputException(result.getHl7Errors());
		}
		
		return result;
	}
	
	private boolean isStrict() {
		return this.renderMode == RenderMode.STRICT;
	}
}
