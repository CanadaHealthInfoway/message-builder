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
package ca.infoway.messagebuilder.model.common.ficr_mt600201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.AdministrativeContactRoleType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;



/**
 * <p>Attention to contacts 
 * 
 * <p>Invoice Recipient Contact person 
 * 
 * <p>If specified for the Payor contact, will always result in 
 * manual review by said individual - use with caution. 
 * 
 * <p>For Pharmacy dispense Invoices (RXDINV, RXCINV), this is 
 * NOT permitted to facilitate real-time processing. 
 * 
 * <p>For Pharmacy clinical product (CPINV) and clinical 
 * services (CSINV) Invoices, this is permitted to indicate who 
 * the Invoice is directed to with the Adjudicator, likely for 
 * manual review. 
 */
@Hl7PartTypeMapping({"FICR_MT600201CA.PaymentRequestAttention"})
public class AttentionToContactsBean extends MessagePartBean {

    private AD ownerAddress = new ADImpl();
    private SET<TEL, TelecommunicationAddress> ownerPhonesAndEmails = new SETImpl<TEL, TelecommunicationAddress>(TELImpl.class);
    private II administrativeContactID = new IIImpl();
    private CV<AdministrativeContactRoleType> administrativeContactType = new CVImpl<AdministrativeContactRoleType>();
    private PN ownerName = new PNImpl();
    private TEL contactPersonTelephoneOrEmailDetails = new TELImpl();

    @Hl7XmlMapping({"contactParty/addr"})
    public PostalAddress getOwnerAddress() {
        return this.ownerAddress.getValue();
    }
    public void setOwnerAddress(PostalAddress ownerAddress) {
        this.ownerAddress.setValue(ownerAddress);
    }

    @Hl7XmlMapping({"contactParty/telecom"})
    public Set<TelecommunicationAddress> getOwnerPhonesAndEmails() {
        return this.ownerPhonesAndEmails.rawSet();
    }

    @Hl7XmlMapping({"contactParty/id"})
    public Identifier getAdministrativeContactID() {
        return this.administrativeContactID.getValue();
    }
    public void setAdministrativeContactID(Identifier administrativeContactID) {
        this.administrativeContactID.setValue(administrativeContactID);
    }

    @Hl7XmlMapping({"contactParty/code"})
    public AdministrativeContactRoleType getAdministrativeContactType() {
        return this.administrativeContactType.getValue();
    }
    public void setAdministrativeContactType(AdministrativeContactRoleType administrativeContactType) {
        this.administrativeContactType.setValue(administrativeContactType);
    }

    @Hl7XmlMapping({"contactParty/contactPerson/name"})
    public PersonName getOwnerName() {
        return this.ownerName.getValue();
    }
    public void setOwnerName(PersonName ownerName) {
        this.ownerName.setValue(ownerName);
    }

    @Hl7XmlMapping({"contactParty/contactPerson/telecom"})
    public TelecommunicationAddress getContactPersonTelephoneOrEmailDetails() {
        return this.contactPersonTelephoneOrEmailDetails.getValue();
    }
    public void setContactPersonTelephoneOrEmailDetails(TelecommunicationAddress contactPersonTelephoneOrEmailDetails) {
        this.contactPersonTelephoneOrEmailDetails.setValue(contactPersonTelephoneOrEmailDetails);
    }

}
