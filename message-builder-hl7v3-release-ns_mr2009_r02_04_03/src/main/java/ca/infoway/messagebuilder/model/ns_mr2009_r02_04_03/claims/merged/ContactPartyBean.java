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
package ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.claims.merged;

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
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.merged.OwnerPersonBean;
import java.util.Set;



@Hl7PartTypeMapping({"FICR_MT400001CA.ContactParty","FICR_MT500201CA.ContactParty","FICR_MT600201CA.ContactParty"})
public class ContactPartyBean extends MessagePartBean {

    private static final long serialVersionUID = 20190801L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private OwnerPersonBean contactPerson;
    private PN contactCallBackPersonName = new PNImpl();
    private SET<TEL, TelecommunicationAddress> contactCallBackPersonTelecom = new SETImpl<TEL, TelecommunicationAddress>(TELImpl.class);


    /**
     * <p>Business Name: AdministrativeContactID</p>
     * 
     * <p>Un-merged Business Name: AdministrativeContactID</p>
     * 
     * <p>Relationship: FICR_MT500201CA.ContactParty.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: AdministrativeContactID</p>
     * 
     * <p>Relationship: FICR_MT600201CA.ContactParty.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: AdministrativeContactID</p>
     * 
     * <p>Un-merged Business Name: AdministrativeContactID</p>
     * 
     * <p>Relationship: FICR_MT500201CA.ContactParty.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: AdministrativeContactID</p>
     * 
     * <p>Relationship: FICR_MT600201CA.ContactParty.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Un-merged Business Name: AdministrativeContactType</p>
     * 
     * <p>Relationship: FICR_MT500201CA.ContactParty.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: CallBackContactType</p>
     * 
     * <p>Relationship: FICR_MT400001CA.ContactParty.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: AdministrativeContactType</p>
     * 
     * <p>Relationship: FICR_MT600201CA.ContactParty.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"code"})
    public AdministrativeContactRoleType getCode() {
        return (AdministrativeContactRoleType) this.code.getValue();
    }

    /**
     * <p>Un-merged Business Name: AdministrativeContactType</p>
     * 
     * <p>Relationship: FICR_MT500201CA.ContactParty.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: CallBackContactType</p>
     * 
     * <p>Relationship: FICR_MT400001CA.ContactParty.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: AdministrativeContactType</p>
     * 
     * <p>Relationship: FICR_MT600201CA.ContactParty.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setCode(AdministrativeContactRoleType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: FICR_MT500201CA.ContactParty.contactPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: FICR_MT600201CA.ContactParty.contactPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"contactPerson"})
    public OwnerPersonBean getContactPerson() {
        return this.contactPerson;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: FICR_MT500201CA.ContactParty.contactPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: FICR_MT600201CA.ContactParty.contactPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setContactPerson(OwnerPersonBean contactPerson) {
        this.contactPerson = contactPerson;
    }


    /**
     * <p>Business Name: CallBackContactPersonName</p>
     * 
     * <p>Un-merged Business Name: CallBackContactPersonName</p>
     * 
     * <p>Relationship: FICR_MT400001CA.CallBackPerson.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"contactCallBackPerson/name"})
    public PersonName getContactCallBackPersonName() {
        return this.contactCallBackPersonName.getValue();
    }

    /**
     * <p>Business Name: CallBackContactPersonName</p>
     * 
     * <p>Un-merged Business Name: CallBackContactPersonName</p>
     * 
     * <p>Relationship: FICR_MT400001CA.CallBackPerson.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setContactCallBackPersonName(PersonName contactCallBackPersonName) {
        this.contactCallBackPersonName.setValue(contactCallBackPersonName);
    }


    /**
     * <p>Business Name: CallBackContactPersonTelecom</p>
     * 
     * <p>Un-merged Business Name: CallBackContactPersonTelecom</p>
     * 
     * <p>Relationship: FICR_MT400001CA.CallBackPerson.telecom</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-5)</p>
     */
    @Hl7XmlMapping({"contactCallBackPerson/telecom"})
    public Set<TelecommunicationAddress> getContactCallBackPersonTelecom() {
        return this.contactCallBackPersonTelecom.rawSet();
    }

}
