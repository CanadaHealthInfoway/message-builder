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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.coct_mt240003ca;

import java.util.Set;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"COCT_MT240003CA.ServiceDeliveryLocation"})
@Hl7RootType
public class ServiceLocationBean extends MessagePartBean implements ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.merged.Recipient {

    private static final long serialVersionUID = 20110831L;
    private II serviceLocationId = new IIImpl();
    private AD serviceLocationAddress = new ADImpl();
    private SET<TEL, TelecommunicationAddress> serviceLocationPhonesAndEMails = new SETImpl<TEL, TelecommunicationAddress>(TELImpl.class);
    private ST serviceLocationName = new STImpl();


    /**
     * <p>C:Service Location Id</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getServiceLocationId() {
        return this.serviceLocationId.getValue();
    }
    public void setServiceLocationId(Identifier serviceLocationId) {
        this.serviceLocationId.setValue(serviceLocationId);
    }


    /**
     * <p>D:Service Location Address</p>
     */
    @Hl7XmlMapping({"addr"})
    public PostalAddress getServiceLocationAddress() {
        return this.serviceLocationAddress.getValue();
    }
    public void setServiceLocationAddress(PostalAddress serviceLocationAddress) {
        this.serviceLocationAddress.setValue(serviceLocationAddress);
    }


    /**
     * <p>E:Service Location Phones and E-mails</p>
     */
    @Hl7XmlMapping({"telecom"})
    public Set<TelecommunicationAddress> getServiceLocationPhonesAndEMails() {
        return this.serviceLocationPhonesAndEMails.rawSet();
    }


    /**
     * <p>B:Service Location Name</p>
     */
    @Hl7XmlMapping({"location/name"})
    public String getServiceLocationName() {
        return this.serviceLocationName.getValue();
    }
    public void setServiceLocationName(String serviceLocationName) {
        this.serviceLocationName.setValue(serviceLocationName);
    }

}
