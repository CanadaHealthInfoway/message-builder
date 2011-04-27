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

package ca.infoway.messagebuilder.marshalling.hl7;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>An object that represents the result of transforming an object from HL7 XML format
 * to a Java representation.  The result tends to contain two key items:
 * 
 * <ol>
 * <li>A Java representation of the HL7 message that contains all of the populated 
 * data.
 * <li>A set of errors that were encountered during parsing of the message.
 * </ol>
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
public class XmlToModelResult {
	
	private Object messageObject;
	private final List<Hl7Error> hl7Errors = new ArrayList<Hl7Error>();
	
	/**
	 * <p>The Java representation of the HL7 message.
	 * 
	 * @return - the populated Java classes that contain the message data.
	 */
	public Object getMessageObject() {
		return messageObject;
	}
	public void setMessageObject(Object messageObject) {
		this.messageObject = messageObject;
	}
	
	public boolean isValid() {
		return this.hl7Errors.size() == 0;
	}

	public void addHl7Error(Hl7Error hl7Error) {
		this.hl7Errors.add(hl7Error);
	}
	
	boolean hasCodeError() {
		return getFirstCodeError() != null;
	}
	Hl7Error getFirstCodeError() {
		Hl7Error result = null;
		for (Hl7Error error : this.hl7Errors) {
			if (error.getHl7ErrorCode() == Hl7ErrorCode.VALUE_NOT_IN_CODE_SYSTEM) {
				result = error;
				break;
			}
		}
		return result;
	}

	public List<Hl7Error> getHl7Errors() {
		return hl7Errors;
	}
}