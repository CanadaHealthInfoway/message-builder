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

import org.w3c.dom.Document;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.marshalling.ClinicalDocumentTransformer;
import ca.infoway.messagebuilder.marshalling.XmlToCdaModelResult;
import ca.infoway.messagebuilder.resolver.GenericCodeResolverRegistry;

public class ClinicalDocumentValidator {
	
	private final ClinicalDocumentTransformer documentTransformer;
	
	public ClinicalDocumentValidator() {
		this.documentTransformer = new ClinicalDocumentTransformer();
	}
	public ClinicalDocumentValidator(ClinicalDocumentTransformer documentTransformer) {
		this.documentTransformer = documentTransformer;
	}

	public CdaValidatorResult validate(Document xmlDocument, VersionNumber version) {
		return this.validate(xmlDocument, version, null);
	}
	
	public CdaValidatorResult validate(Document xmlDocument, VersionNumber version, GenericCodeResolverRegistry codeResolverRegistryOverride) {
		XmlToCdaModelResult transformResults = this.documentTransformer.transformFromDocument(version, xmlDocument, codeResolverRegistryOverride);
		return new CdaValidatorResult(transformResults.getErrors());
	}

}
