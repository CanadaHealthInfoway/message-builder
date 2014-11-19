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
 * Last modified: $LastChangedDate: 2013-01-02 17:05:34 -0500 (Wed, 02 Jan 2013) $
 * Revision:      $LastChangedRevision: 6471 $
 */
package ca.infoway.messagebuilder.marshalling.hl7.constraints;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.datatype.lang.EncapsulatedDataR2;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.x_DocumentMediaType;
import ca.infoway.messagebuilder.domainvalue.basic.X_DocumentMediaType;
import ca.infoway.messagebuilder.marshalling.ErrorLogger;
import ca.infoway.messagebuilder.xml.ConstrainedDatatype;

public class EdConstraintsHandler {

	private final ConstraintsHandler constraintsHandler = new ConstraintsHandler();

	public EdConstraintsHandler() {
	}
	
	public void handleConstraints(ConstrainedDatatype constraints, EncapsulatedDataR2 ed, ErrorLogger logger) {
		
		if (ed == null || constraints == null) {
			return;
		}
		
		TelecommunicationAddress reference = ed.getReference();
		// ignoring any fixed value returned from reference constraints checking
		this.constraintsHandler.validateConstraint("reference", reference == null ? null : "reference", true, constraints, logger);  // just checks if reference provided
		if (reference != null) {
			// only check this constraint if a reference has been provided (whether the reference was mandatory or not)
			String referenceValue = reference.toString();
			this.constraintsHandler.validateConstraint("reference.value", referenceValue, true, constraints, logger); // checks for actual value
		}
		
		String mediaType = ed.getMediaType() == null ? null : ed.getMediaType().getCodeValue();
		String newMediaType = this.constraintsHandler.validateConstraint("mediaType", mediaType, true, constraints, logger);
		if (!StringUtils.equals(mediaType, newMediaType)) {
			x_DocumentMediaType newMediaTypeEnum = X_DocumentMediaType.get(newMediaType);
			if (newMediaTypeEnum != null) {
				ed.setMediaType(newMediaTypeEnum);
			}
		}
	}

}
