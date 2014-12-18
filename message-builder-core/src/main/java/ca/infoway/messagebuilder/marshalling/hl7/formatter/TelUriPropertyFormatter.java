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

package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.error.Hl7Errors;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.TelValidationUtils;

/**
 * Represents a TEL.URI String as an element:
 *
 * &lt;element-name value="mailto://me@me.com"&gt;&lt;/element-name&gt;
 *
 * If an object is null, value is replaced by a nullFlavor. So the element would look
 * like this:
 *
 * &lt;element-name nullFlavor="something" /&gt;
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-TEL
 *
 * The TEL.URI variant defined by CeRx is for computer system addreses only. The only valid
 * URLSchemes are FILE, FTP, HTTP, HTTPS, MAILTO and NFS.
 */
@DataTypeHandler("TEL.URI")
public class TelUriPropertyFormatter extends AbstractValueNullFlavorPropertyFormatter<TelecommunicationAddress> {

	private static final TelValidationUtils TEL_VALIDATION_UTILS = new TelValidationUtils();

    @Override
    protected final String getValue(TelecommunicationAddress uri, FormatContext context, BareANY bareAny) {
    	String type = context.getType();
    	StandardDataType specializationType = bareAny.getDataType();
    	VersionNumber version = context.getVersion();
    	Hl7Errors errors = context.getModelToXmlResult();
    	
    	TEL_VALIDATION_UTILS.validateTelecommunicationAddress(uri, type, specializationType.getType(), version, null, context.getPropertyPath(), errors);
    	
        return uri.toString();
    }

}
