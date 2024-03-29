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
import org.xml.sax.SAXException;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.error.Hl7Error;
import ca.infoway.messagebuilder.error.Hl7ErrorCode;
import ca.infoway.messagebuilder.error.Hl7Errors;
import ca.infoway.messagebuilder.marshalling.hl7.ModelToXmlResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.GenericCodeResolverRegistry;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;
import ca.infoway.messagebuilder.xml.cdavalidator.ContainedTemplateValidator;
import ca.infoway.messagebuilder.xml.cdavalidator.SchematronValidator;
import ca.infoway.messagebuilder.xml.service.MessageDefinitionService;
import ca.infoway.messagebuilder.xml.service.MessageDefinitionServiceFactory;

public class MessageBeanTransformerImpl {
	
	private final MessageDefinitionService service;
	private final RenderMode renderMode;
	private final TimeZone dateTimeZone;
	private final TimeZone dateTimeTimeZone;
	private final boolean performAdditionalCdaValidationWhenUnmarshalling;

	public MessageBeanTransformerImpl() {
		this(new MessageDefinitionServiceFactory().create(), RenderMode.PERMISSIVE);
	}
	public MessageBeanTransformerImpl(RenderMode renderMode) {
		this(new MessageDefinitionServiceFactory().create(), renderMode);
	}
	public MessageBeanTransformerImpl(TimeZone dateTimeZone, TimeZone dateTimeTimeZone) {
		this(new MessageDefinitionServiceFactory().create(), RenderMode.PERMISSIVE, dateTimeZone, dateTimeTimeZone);
	}
	public MessageBeanTransformerImpl(MessageDefinitionService service, RenderMode renderMode) {
		this(service, renderMode, null, null);
	}
	public MessageBeanTransformerImpl(MessageDefinitionService service, RenderMode renderMode, TimeZone dateTimeZone, TimeZone dateTimeTimeZone) {
		this(service, renderMode, null, null, true);
	}
	public MessageBeanTransformerImpl(MessageDefinitionService service, RenderMode renderMode, TimeZone dateTimeZone, TimeZone dateTimeTimeZone, boolean performAdditionalCdaValidationWhenUnmarshalling) {
		this.service = service;
		this.renderMode = renderMode;
		this.dateTimeZone = dateTimeZone;
		this.dateTimeTimeZone = dateTimeTimeZone;
		this.performAdditionalCdaValidationWhenUnmarshalling = performAdditionalCdaValidationWhenUnmarshalling;
		
		if (this.service != null) {
			this.service.initialize();
		}
		MessageBeanRegistry.getInstance();	// force the registry to initialize itself
			
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
		
		XmlToModelResult result = new Hl7SourceMapper().mapToTeal(new Hl7MessageSource(version, hl7Message, dateTimeZone, dateTimeTimeZone, this.service));
		
		if (this.performAdditionalCdaValidationWhenUnmarshalling) {
			performAdditionalCdaValidation(version, hl7Message, result);
		}
		
		CodeResolverRegistry.clearThreadLocalVersion();
		CodeResolverRegistry.clearThreadLocalCodeResolverRegistryOverride();
		
		return result;
	}

	@Deprecated
	public ModelToXmlResult transformToHl7AndReturnResult(VersionNumber version, InteractionBean messageBean) {
		return transformToHl7(version, messageBean, this.dateTimeZone, this.dateTimeTimeZone, null);
	}
	
	@Deprecated
	public ModelToXmlResult transformToHl7AndReturnResult(VersionNumber version, InteractionBean messageBean, GenericCodeResolverRegistry codeResolverRegistryOverride) {
		return transformToHl7(version, messageBean, this.dateTimeZone, this.dateTimeTimeZone, codeResolverRegistryOverride);
	}
	
	@Deprecated
	public ModelToXmlResult transformToHl7AndReturnResult(VersionNumber version, InteractionBean messageBean, TimeZone dateTimeZone, TimeZone dateTimeTimeZone, GenericCodeResolverRegistry codeResolverRegistryOverride) {
		return transformToHl7(version, messageBean, dateTimeZone, dateTimeTimeZone, codeResolverRegistryOverride);
	}
	
	public ModelToXmlResult transformToHl7(VersionNumber version, InteractionBean messageBean) {
		return transformToHl7(version, messageBean, this.dateTimeZone, this.dateTimeTimeZone, null);
	}
	
	public ModelToXmlResult transformToHl7(VersionNumber version, InteractionBean messageBean, GenericCodeResolverRegistry codeResolverRegistryOverride) {
		return transformToHl7(version, messageBean, this.dateTimeZone, this.dateTimeTimeZone, codeResolverRegistryOverride);
	}
	
	public ModelToXmlResult transformToHl7(VersionNumber version, InteractionBean messageBean, TimeZone dateTimeZone, TimeZone dateTimeTimeZone, GenericCodeResolverRegistry codeResolverRegistryOverride) {
		CodeResolverRegistry.setThreadLocalVersion(version);
		CodeResolverRegistry.setThreadLocalCodeResolverRegistryOverride(codeResolverRegistryOverride);

		XmlRenderingVisitor visitor = new XmlRenderingVisitor(this.service.isR2(version), this.service.isCda(version), version);	// TODO: Since the two boolean flags are derived from the version, we chould simplify this interface 
		new TealBeanRenderWalker(messageBean, version, dateTimeZone, dateTimeTimeZone, this.service).accept(visitor);

		CodeResolverRegistry.clearThreadLocalVersion();
		CodeResolverRegistry.clearThreadLocalCodeResolverRegistryOverride();
		
		ModelToXmlResult result = visitor.toXml();
		
		if (this.service.isCda(version)) {
			performAdditionalCdaValidation(version, result.getXmlMessage(), result);
		}
		
		if (!result.isValid() && isStrict()) {
			throw new InvalidRenderInputException(result.getHl7Errors());
		}
		
		return result;
	}
	
	// this is likely to be moved to a "cda transformer" when the other renaming issue (MBG-184) is resolved
	public void performAdditionalCdaValidation(VersionNumber version, String xml, Hl7Errors errorContainer) {
		try {
			Document document = new DocumentFactory().createFromString(xml);
			performAdditionalCdaValidation(version, document, errorContainer);
		} catch (SAXException e) {
			errorContainer.addHl7Error(new Hl7Error(Hl7ErrorCode.SYNTAX_ERROR, e.getMessage(), (String) null));
		}
	}
	
	// this is likely to be moved to a "cda transformer" when the other renaming issue (MBG-184) is resolved
	public void performAdditionalCdaValidation(VersionNumber version, Document xmlDocument, Hl7Errors errorContainer) {
		SchematronValidator schematronValidator = new SchematronValidator(this.service.getAllSchematronContexts(version));
		schematronValidator.validate(xmlDocument, errorContainer);
		
		ContainedTemplateValidator containedTemplateValidator = new ContainedTemplateValidator(this.service.getAllPackageLocations(version));
		containedTemplateValidator.validate(xmlDocument, errorContainer);
	}
	
	private boolean isStrict() {
		return this.renderMode == RenderMode.STRICT;
	}
}
