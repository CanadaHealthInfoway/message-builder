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

import java.util.List;

import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorLevel;

/**
 * <p>An exception indicating that the application tried to marshall a message
 * part that did not follow the rules of marshalling.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
public class InvalidRenderInputException extends RenderingException {

	private final List<Hl7Error> hl7Errors;

	private static final long serialVersionUID = -1049387329590610715L;

	public InvalidRenderInputException(List<Hl7Error> hl7Errors) {
		this.hl7Errors = hl7Errors;
	}

	public List<Hl7Error> getHl7Errors() {
		return this.hl7Errors;
	}
	
	@Override
	public String getMessage() {
		Hl7Error firstError = null;
		for (Hl7Error hl7Error : this.hl7Errors) {
			if (hl7Error.getHl7ErrorLevel() == Hl7ErrorLevel.ERROR) {
				firstError = hl7Error;
				break;
			}
		}
		return firstError == null ? "" : firstError.toString();
	}
}
