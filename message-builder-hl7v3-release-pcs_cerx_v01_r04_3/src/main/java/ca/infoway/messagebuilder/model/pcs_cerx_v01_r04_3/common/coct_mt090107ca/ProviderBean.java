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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.coct_mt090107ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.HealthcareProviderRoleType;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"COCT_MT090107CA.AssignedPerson"})
@Hl7RootType
public class ProviderBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.merged.ChangedBy, ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.iehr.repc_mt000012ca.Choice, ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.merged.Recipient, ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.merged.Consenter, ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.iehr.merged.Party {

    private static final long serialVersionUID = 20111117L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private PN representedPersonName = new PNImpl();
    private II representedPersonAsLicensedEntityId = new IIImpl();


    /**
     * <p>A:Provider Id</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Provider Type</p>
     */
    @Hl7XmlMapping({"code"})
    public HealthcareProviderRoleType getCode() {
        return (HealthcareProviderRoleType) this.code.getValue();
    }
    public void setCode(HealthcareProviderRoleType code) {
        this.code.setValue(code);
    }


    /**
     * <p>B:Provider Name</p>
     */
    @Hl7XmlMapping({"representedPerson/name"})
    public PersonName getRepresentedPersonName() {
        return this.representedPersonName.getValue();
    }
    public void setRepresentedPersonName(PersonName representedPersonName) {
        this.representedPersonName.setValue(representedPersonName);
    }


    /**
     * <p>D:Provider License Number</p>
     */
    @Hl7XmlMapping({"representedPerson/asLicensedEntity/id"})
    public Identifier getRepresentedPersonAsLicensedEntityId() {
        return this.representedPersonAsLicensedEntityId.getValue();
    }
    public void setRepresentedPersonAsLicensedEntityId(Identifier representedPersonAsLicensedEntityId) {
        this.representedPersonAsLicensedEntityId.setValue(representedPersonAsLicensedEntityId);
    }

}
