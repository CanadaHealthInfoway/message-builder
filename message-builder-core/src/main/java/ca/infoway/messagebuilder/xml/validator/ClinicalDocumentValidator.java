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
 * Author:        $LastChangedBy: jroberts $
 * Last modified: $LastChangedDate: 2014-11-19 10:34:53 -0400 (Wed, 19 Nov 2014) $
 * Revision:      $LastChangedRevision: 9080 $
 */

package ca.infoway.messagebuilder.xml.validator;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.error.Hl7Error;
import ca.infoway.messagebuilder.error.TransformError;
import ca.infoway.messagebuilder.marshalling.MessageBeanTransformerImpl;
import ca.infoway.messagebuilder.marshalling.RenderMode;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.resolver.GenericCodeResolverRegistry;
import ca.infoway.messagebuilder.xml.service.MessageDefinitionService;
import ca.infoway.messagebuilder.xml.service.MessageDefinitionServiceFactory;

public class ClinicalDocumentValidator {
	
	private final MessageBeanTransformerImpl messageTransformer;
	
	public ClinicalDocumentValidator() {
		this(new MessageDefinitionServiceFactory().create());
	}
	
	public ClinicalDocumentValidator(MessageDefinitionService service) {
		this.messageTransformer = new MessageBeanTransformerImpl(service, RenderMode.PERMISSIVE);
	}

	public CdaValidatorResult validate(Document xmlDocument, VersionNumber version) {
		return this.validate(xmlDocument, version, null);
	}
	
	public CdaValidatorResult validate(Document xmlDocument, VersionNumber version, GenericCodeResolverRegistry codeResolverRegistryOverride) {
		XmlToModelResult transformResults = this.messageTransformer.transformFromHl7(version, xmlDocument, codeResolverRegistryOverride);
		this.messageTransformer.performAdditionalCdaValidation(version, xmlDocument, transformResults);
		return new CdaValidatorResult(convertErrors(transformResults.getHl7Errors()));
	}

	private List<TransformError> convertErrors(List<Hl7Error> hl7Errors) {
		List<TransformError> errors = new ArrayList<TransformError>();
		for (Hl7Error hl7Error : hl7Errors) {
			errors.add(new TransformError(hl7Error));
		}
		return errors;
	}
}
