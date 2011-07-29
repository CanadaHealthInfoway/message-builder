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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.coct_mt040205ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
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
import ca.infoway.messagebuilder.domainvalue.x_SimplePersonalRelationship;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



@Hl7PartTypeMapping({"COCT_MT040205CA.ResponsibleParty"})
@Hl7RootType
public class ResponsiblePersonBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.iehr.repc_mt000012ca.Choice, ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.merged.Consenter, ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.iehr.merged.Party {

    private static final long serialVersionUID = 20110729L;
    private II responsiblePersonID = new IIImpl();
    private CV responsiblePersonType = new CVImpl();
    private AD responsiblePersonAddress = new ADImpl();
    private SET<TEL, TelecommunicationAddress> responsiblePersonPhonesAndEmails = new SETImpl<TEL, TelecommunicationAddress>(TELImpl.class);
    private PN responsiblePersonName = new PNImpl();


    /**
     * <p>B:Responsible Person ID</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getResponsiblePersonID() {
        return this.responsiblePersonID.getValue();
    }
    public void setResponsiblePersonID(Identifier responsiblePersonID) {
        this.responsiblePersonID.setValue(responsiblePersonID);
    }


    /**
     * <p>C:Responsible Person Type</p>
     */
    @Hl7XmlMapping({"code"})
    public x_SimplePersonalRelationship getResponsiblePersonType() {
        return (x_SimplePersonalRelationship) this.responsiblePersonType.getValue();
    }
    public void setResponsiblePersonType(x_SimplePersonalRelationship responsiblePersonType) {
        this.responsiblePersonType.setValue(responsiblePersonType);
    }


    /**
     * <p>D:Responsible Person Address</p>
     */
    @Hl7XmlMapping({"addr"})
    public PostalAddress getResponsiblePersonAddress() {
        return this.responsiblePersonAddress.getValue();
    }
    public void setResponsiblePersonAddress(PostalAddress responsiblePersonAddress) {
        this.responsiblePersonAddress.setValue(responsiblePersonAddress);
    }


    /**
     * <p>E:Responsible Person Phones and Emails</p>
     */
    @Hl7XmlMapping({"telecom"})
    public Set<TelecommunicationAddress> getResponsiblePersonPhonesAndEmails() {
        return this.responsiblePersonPhonesAndEmails.rawSet();
    }


    /**
     * <p>A:Responsible Person Name</p>
     */
    @Hl7XmlMapping({"agentPerson/name"})
    public PersonName getResponsiblePersonName() {
        return this.responsiblePersonName.getValue();
    }
    public void setResponsiblePersonName(PersonName responsiblePersonName) {
        this.responsiblePersonName.setValue(responsiblePersonName);
    }

}
