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
import ca.infoway.messagebuilder.xml.service.MessageDefinitionService;
import ca.infoway.messagebuilder.xml.visitor.MessageWalker;

/**
 * For MB testing/internal use only.
 * 
 * @deprecated
 * For general message validation, please use ca.infoway.messagebuilder.xml.validator.MessageValidatorImpl.
 * 
 */
@Deprecated
class Validator {

	private final MessageWalker messageWalker;
	private final VersionNumber version;

	public Validator(MessageDefinitionService service, Document message, VersionNumber version) {
		this.version = version;
		this.messageWalker = new MessageWalker(service, message, version);
	}

	public MessageValidatorResult validate() {
		ValidatingVisitor visitor = new ValidatingVisitor(this.version);
		this.messageWalker.accept(visitor);
		return visitor.getResult();
	}

}
