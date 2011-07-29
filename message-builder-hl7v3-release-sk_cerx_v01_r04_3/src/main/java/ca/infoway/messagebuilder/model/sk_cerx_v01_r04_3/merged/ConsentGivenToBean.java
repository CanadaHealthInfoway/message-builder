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

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.coct_mt090107ca.ProviderBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.coct_mt240003ca.ServiceLocationBean;



@Hl7PartTypeMapping({"COCT_MT470000CA.Receiver","RCMR_MT010001CA.Receiver"})
public class ConsentGivenToBean extends MessagePartBean {

    private static final long serialVersionUID = 20110729L;
    private Recipient recipient;


    @Hl7XmlMapping({"recipient"})
    public Recipient getRecipient() {
        return this.recipient;
    }
    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    public ProviderBean getRecipientAsAssignedPerson() {
        return this.recipient instanceof ProviderBean ? (ProviderBean) this.recipient : null;
    }
    public boolean hasRecipientAsAssignedPerson() {
        return (this.recipient instanceof ProviderBean);
    }

    public ServiceLocationBean getRecipientAsServiceDeliveryLocation() {
        return this.recipient instanceof ServiceLocationBean ? (ServiceLocationBean) this.recipient : null;
    }
    public boolean hasRecipientAsServiceDeliveryLocation() {
        return (this.recipient instanceof ServiceLocationBean);
    }

}
