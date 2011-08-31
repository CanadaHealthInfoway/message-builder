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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Hl7PartTypeMapping({"COCT_MT050202CA.Patient","COCT_MT050203CA.Patient"})
@Hl7RootType
public class PatientBean extends MessagePartBean implements ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.merged.Consenter, ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.iehr.repc_mt000012ca.Choice, ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pharmacy.merged.Patient, ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.iehr.merged.Party {

    private static final long serialVersionUID = 20110831L;
    private II patientID = new IIImpl();
    private AD patientContactAddress = new ADImpl();
    private LIST<TEL, TelecommunicationAddress> patientContactPhoneAndEMails = new LISTImpl<TEL, TelecommunicationAddress>(TELImpl.class);
    private PN patientName = new PNImpl();
    private CV patientGender = new CVImpl();
    private TS patientBirthDate = new TSImpl();


    /**
     * <p>PatientID</p>
     * 
     * <p>A:Patient ID</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getPatientID() {
        return this.patientID.getValue();
    }
    public void setPatientID(Identifier patientID) {
        this.patientID.setValue(patientID);
    }


    /**
     * <p>PatientContactAddress</p>
     * 
     * <p>C:Patient Contact Address</p>
     */
    @Hl7XmlMapping({"addr"})
    public PostalAddress getPatientContactAddress() {
        return this.patientContactAddress.getValue();
    }
    public void setPatientContactAddress(PostalAddress patientContactAddress) {
        this.patientContactAddress.setValue(patientContactAddress);
    }


    /**
     * <p>PatientContactPhoneAndEMails</p>
     * 
     * <p>D:Patient Contact Phone and E-mails</p>
     */
    @Hl7XmlMapping({"telecom"})
    public List<TelecommunicationAddress> getPatientContactPhoneAndEMails() {
        return this.patientContactPhoneAndEMails.rawList();
    }


    /**
     * <p>PatientName</p>
     * 
     * <p>B:Patient Name</p>
     */
    @Hl7XmlMapping({"patientPerson/name"})
    public PersonName getPatientName() {
        return this.patientName.getValue();
    }
    public void setPatientName(PersonName patientName) {
        this.patientName.setValue(patientName);
    }


    /**
     * <p>PatientGender</p>
     * 
     * <p>F:Patient Gender</p>
     */
    @Hl7XmlMapping({"patientPerson/administrativeGenderCode"})
    public AdministrativeGender getPatientGender() {
        return (AdministrativeGender) this.patientGender.getValue();
    }
    public void setPatientGender(AdministrativeGender patientGender) {
        this.patientGender.setValue(patientGender);
    }


    /**
     * <p>PatientBirthDate</p>
     * 
     * <p>E:Patient Birth Date</p>
     */
    @Hl7XmlMapping({"patientPerson/birthTime"})
    public Date getPatientBirthDate() {
        return this.patientBirthDate.getValue();
    }
    public void setPatientBirthDate(Date patientBirthDate) {
        this.patientBirthDate.setValue(patientBirthDate);
    }

}
