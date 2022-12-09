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

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.common.rcmr_mt010001ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.util.CollapsedToDataTypeListHelper;
import ca.infoway.messagebuilder.domainvalue.ActInformationAccessTypeCode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



/**
 * <p>a:consents to 
 * 
 * <p>Indicates the type of information access consented to 
 * 
 * <p>Provides details about the consent 
 */
@Hl7PartTypeMapping({"RCMR_MT010001CA.Component"})
public class ConsentsToBean extends MessagePartBean {

    private List<CV<ActInformationAccessTypeCode>> consentInformationTypes = new ArrayList<CV<ActInformationAccessTypeCode>>();
    private RecipientBean permissionToInformReceiverRecipient;

    @Hl7XmlMapping({"permissionToInform/subject/recordType/code"})
    public List<ActInformationAccessTypeCode> getConsentInformationTypes() {
        return new CollapsedToDataTypeListHelper(CVImpl.class, this.consentInformationTypes).rawList();
    }

    @Hl7XmlMapping({"permissionToInform/receiver/recipient"})
    public RecipientBean getPermissionToInformReceiverRecipient() {
        return this.permissionToInformReceiverRecipient;
    }
    public void setPermissionToInformReceiverRecipient(RecipientBean permissionToInformReceiverRecipient) {
        this.permissionToInformReceiverRecipient = permissionToInformReceiverRecipient;
    }

}