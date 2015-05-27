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
 * Last modified: $LastChangedDate: 2014-12-18 13:55:30 -0500 (Thu, 18 Dec 2014) $
 * Revision:      $LastChangedRevision: 9099 $
 */
package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import java.util.Map;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;

public class TestableTelUriPropertyFormatter extends TelUriPropertyFormatter implements TestableAbstractValueNullFlavorPropertyFormatter<TelecommunicationAddress> {
	
	public Map<String, String> getAttributeNameValuePairsForTest(FormatContext context, TelecommunicationAddress t, BareANY bareAny) {
		return super.getAttributeNameValuePairs(context, t, bareAny);
	}

}
