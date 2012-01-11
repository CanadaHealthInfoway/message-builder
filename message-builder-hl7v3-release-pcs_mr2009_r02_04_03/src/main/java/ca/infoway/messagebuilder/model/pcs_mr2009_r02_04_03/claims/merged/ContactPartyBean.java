/**
 * Copyright 2012 Canada Health Infoway, Inc.
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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.claims.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.AdministrativeContactRoleType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.ContactPersonBean;
import java.util.Set;



@Hl7PartTypeMapping({"FICR_MT400001CA.ContactParty","FICR_MT500201CA.ContactParty","FICR_MT600201CA.ContactParty"})
public class ContactPartyBean extends MessagePartBean {

    private static final long serialVersionUID = 20120106L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private ContactPersonBean contactPerson;
    private PN contactCallBackPersonName = new PNImpl();
    private SET<TEL, TelecommunicationAddress> contactCallBackPersonTelecom = new SETImpl<TEL, TelecommunicationAddress>(TELImpl.class);


    /**
     * <p>AdministrativeContactID</p>
     * 
     * <p>Administrative Contact ID</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Call Back Contact Type</p>
     * 
     * <p>Administrative Contact Type</p>
     */
    @Hl7XmlMapping({"code"})
    public AdministrativeContactRoleType getCode() {
        return (AdministrativeContactRoleType) this.code.getValue();
    }
    public void setCode(AdministrativeContactRoleType code) {
        this.code.setValue(code);
    }


    @Hl7XmlMapping({"contactPerson"})
    public ContactPersonBean getContactPerson() {
        return this.contactPerson;
    }
    public void setContactPerson(ContactPersonBean contactPerson) {
        this.contactPerson = contactPerson;
    }


    /**
     * <p>CallBackContactPersonName</p>
     * 
     * <p>Call Back Contact Person Name</p>
     */
    @Hl7XmlMapping({"contactCallBackPerson/name"})
    public PersonName getContactCallBackPersonName() {
        return this.contactCallBackPersonName.getValue();
    }
    public void setContactCallBackPersonName(PersonName contactCallBackPersonName) {
        this.contactCallBackPersonName.setValue(contactCallBackPersonName);
    }


    /**
     * <p>CallBackContactPersonTelecom</p>
     * 
     * <p>Call Back Contact Person Telecom</p>
     */
    @Hl7XmlMapping({"contactCallBackPerson/telecom"})
    public Set<TelecommunicationAddress> getContactCallBackPersonTelecom() {
        return this.contactCallBackPersonTelecom.rawSet();
    }

}
