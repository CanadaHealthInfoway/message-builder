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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
package ca.infoway.messagebuilder.marshalling;

import java.util.TimeZone;

import org.w3c.dom.Document;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.model.ClinicalDocumentBean;
import ca.infoway.messagebuilder.resolver.GenericCodeResolverRegistry;
import ca.infoway.messagebuilder.xml.service.MessageDefinitionService;

/**
 * A facade providing a CDA-friendly interface for transformation.
 * 
 * @author robertsj
 *
 */
public class ClinicalDocumentTransformer {
	
	private MessageBeanTransformerImpl delegate;
	
	public ClinicalDocumentTransformer() {
		this.delegate = new MessageBeanTransformerImpl();
	}
	public ClinicalDocumentTransformer(RenderMode renderMode) {
		this.delegate = new MessageBeanTransformerImpl(renderMode);
	}
	public ClinicalDocumentTransformer(TimeZone dateTimeZone, TimeZone dateTimeTimeZone) {
		this.delegate = new MessageBeanTransformerImpl(dateTimeZone, dateTimeTimeZone);
	}
	public ClinicalDocumentTransformer(MessageDefinitionService service, RenderMode renderMode) {
		this.delegate = new MessageBeanTransformerImpl(service, renderMode);
	}
	public ClinicalDocumentTransformer(MessageDefinitionService service, RenderMode renderMode, TimeZone dateTimeZone, TimeZone dateTimeTimeZone) {
		this.delegate = new MessageBeanTransformerImpl(service, renderMode, dateTimeZone, dateTimeTimeZone);
	}

	public XmlToCdaModelResult transformFromDocument(VersionNumber version, Document xmlDocument) {
		return new XmlToCdaModelResult(this.delegate.transformFromHl7(version, xmlDocument));
	}
	
	public XmlToCdaModelResult transformFromDocument(VersionNumber version, Document xmlDocument, GenericCodeResolverRegistry codeResolverRegistryOverride) {
		return new XmlToCdaModelResult(this.delegate.transformFromHl7(version, xmlDocument, codeResolverRegistryOverride));
	}
	
	public XmlToCdaModelResult transformFromDocument(VersionNumber version, Document xmlDocument, TimeZone dateTimeZone, TimeZone dateTimeTimeZone, GenericCodeResolverRegistry codeResolverRegistryOverride) {
		return new XmlToCdaModelResult(this.delegate.transformFromHl7(version, xmlDocument, dateTimeZone, dateTimeTimeZone, codeResolverRegistryOverride));
	}

	public CdaModelToXmlResult transformToDocument(VersionNumber version, ClinicalDocumentBean clinicalDocumentBean) {
		return new CdaModelToXmlResult(this.delegate.transformToHl7(version, clinicalDocumentBean));
	}
	
	public CdaModelToXmlResult transformToDocument(VersionNumber version, ClinicalDocumentBean clinicalDocumentBean, GenericCodeResolverRegistry codeResolverRegistryOverride) {
		return new CdaModelToXmlResult(this.delegate.transformToHl7(version, clinicalDocumentBean, codeResolverRegistryOverride));
	}
	
	public CdaModelToXmlResult transformToDocument(VersionNumber version, ClinicalDocumentBean clinicalDocumentBean, TimeZone dateTimeZone, TimeZone dateTimeTimeZone, GenericCodeResolverRegistry codeResolverRegistryOverride) {
		return new CdaModelToXmlResult(this.delegate.transformToHl7(version, clinicalDocumentBean, dateTimeZone, dateTimeTimeZone, codeResolverRegistryOverride));
	
	}
}
