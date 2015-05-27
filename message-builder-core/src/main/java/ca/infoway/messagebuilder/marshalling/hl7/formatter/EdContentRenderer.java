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
 * Last modified: $LastChangedDate: 2013-03-11 18:38:50 -0400 (Mon, 11 Mar 2013) $
 * Revision:      $LastChangedRevision: 6702 $
 */
package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import static org.apache.commons.lang.SystemUtils.LINE_SEPARATOR;

import ca.infoway.messagebuilder.datatype.lang.EncapsulatedData;
import ca.infoway.messagebuilder.datatype.lang.util.EdRepresentation;
import ca.infoway.messagebuilder.error.Hl7Error;
import ca.infoway.messagebuilder.error.Hl7ErrorCode;
import ca.infoway.messagebuilder.platform.Base64;
import ca.infoway.messagebuilder.util.text.Indenter;

public class EdContentRenderer {
	
	public void renderContent(EncapsulatedData encapsulatedData, StringBuffer buffer, int indentLevel, FormatContext context, boolean hasReferenceOrThumbnailOrDocument) {
		boolean hasContent = (encapsulatedData.getContent() != null);
		
		if (hasReferenceOrThumbnailOrDocument && hasContent) {
			Indenter.indentBuffer(buffer, indentLevel);
		}
		if (hasContent) {
			String textContent = encapsulatedData.getContent();
			if (EdRepresentation.B64.equals(encapsulatedData.getRepresentation())) {
				validateBase64Encoded("content", textContent, context);
			}
			buffer.append(textContent);
		}
		if (hasReferenceOrThumbnailOrDocument && hasContent) {
			buffer.append(LINE_SEPARATOR);
		}
	}

	public void validateBase64Encoded(String property, String stringToCheck, FormatContext context) {
		try {
			Base64.decodeBase64String(stringToCheck);
		} catch (Exception e) {
			recordError("The ED property '" + property + "' does not appear to be Base64 encoded.", context);
		}
	}
	
	private void recordError(String message, FormatContext context) {
		context.getModelToXmlResult().addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, message, context.getPropertyPath()));
	}

}
