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
package ca.infoway.messagebuilder.model.common.coct_mt470002ca;

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



@Hl7PartTypeMapping({"COCT_MT470002CA.Subject2"})
public class ControlsBean extends MessagePartBean {

    private List<CV<ActInformationAccessTypeCode>> consentInformationTypes = new ArrayList<CV<ActInformationAccessTypeCode>>();
    private RecipientBean informDefinitionReceiverRecipient;

    @Hl7XmlMapping({"informDefinition/subject/actDefinition/code"})
    public List<ActInformationAccessTypeCode> getConsentInformationTypes() {
        return new CollapsedToDataTypeListHelper(CVImpl.class, this.consentInformationTypes).rawList();
    }

    @Hl7XmlMapping({"informDefinition/receiver/recipient"})
    public RecipientBean getInformDefinitionReceiverRecipient() {
        return this.informDefinitionReceiverRecipient;
    }
    public void setInformDefinitionReceiverRecipient(RecipientBean informDefinitionReceiverRecipient) {
        this.informDefinitionReceiverRecipient = informDefinitionReceiverRecipient;
    }

}