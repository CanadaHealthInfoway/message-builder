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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.claims.ficr_mt600201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.AdministrativeContactRoleType;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"FICR_MT600201CA.ContactParty"})
public class AdministrativeContactsSBean extends MessagePartBean {

    private static final long serialVersionUID = 20110729L;
    private II administrativeContactID = new IIImpl();
    private CV administrativeContactType = new CVImpl();
    private AdministrativeContactPersonBean contactPerson;


    /**
     * <p>Administrative Contact ID</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getAdministrativeContactID() {
        return this.administrativeContactID.getValue();
    }
    public void setAdministrativeContactID(Identifier administrativeContactID) {
        this.administrativeContactID.setValue(administrativeContactID);
    }


    /**
     * <p>Administrative Contact Type</p>
     */
    @Hl7XmlMapping({"code"})
    public AdministrativeContactRoleType getAdministrativeContactType() {
        return (AdministrativeContactRoleType) this.administrativeContactType.getValue();
    }
    public void setAdministrativeContactType(AdministrativeContactRoleType administrativeContactType) {
        this.administrativeContactType.setValue(administrativeContactType);
    }


    @Hl7XmlMapping({"contactPerson"})
    public AdministrativeContactPersonBean getContactPerson() {
        return this.contactPerson;
    }
    public void setContactPerson(AdministrativeContactPersonBean contactPerson) {
        this.contactPerson = contactPerson;
    }

}
