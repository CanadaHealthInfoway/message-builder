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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.si.comt_mt300002ca;

import java.util.Date;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.ActPatientAnnotationCode;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"COMT_MT300002CA.ParameterList"})
@Hl7RootType
public class GenericQueryParametersBean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private TS patientBirthDate = new TSImpl();
    private CV patientGender = new CVImpl();
    private II patientID = new IIImpl();
    private PN patientName = new PNImpl();
    private CV patientNoteCategoryCode = new CVImpl();


    /**
     * <p>Patient Birth Date</p>
     */
    @Hl7XmlMapping({"patientBirthDate/value"})
    public Date getPatientBirthDate() {
        return this.patientBirthDate.getValue();
    }
    public void setPatientBirthDate(Date patientBirthDate) {
        this.patientBirthDate.setValue(patientBirthDate);
    }


    /**
     * <p>Patient Gender</p>
     */
    @Hl7XmlMapping({"patientGender/value"})
    public AdministrativeGender getPatientGender() {
        return (AdministrativeGender) this.patientGender.getValue();
    }
    public void setPatientGender(AdministrativeGender patientGender) {
        this.patientGender.setValue(patientGender);
    }


    /**
     * <p>B:Patient ID</p>
     */
    @Hl7XmlMapping({"patientID/value"})
    public Identifier getPatientID() {
        return this.patientID.getValue();
    }
    public void setPatientID(Identifier patientID) {
        this.patientID.setValue(patientID);
    }


    /**
     * <p>C:Patient Name</p>
     */
    @Hl7XmlMapping({"patientName/value"})
    public PersonName getPatientName() {
        return this.patientName.getValue();
    }
    public void setPatientName(PersonName patientName) {
        this.patientName.setValue(patientName);
    }


    /**
     * <p>Patient Note Category Code</p>
     */
    @Hl7XmlMapping({"patientNoteCategoryCode/value"})
    public ActPatientAnnotationCode getPatientNoteCategoryCode() {
        return (ActPatientAnnotationCode) this.patientNoteCategoryCode.getValue();
    }
    public void setPatientNoteCategoryCode(ActPatientAnnotationCode patientNoteCategoryCode) {
        this.patientNoteCategoryCode.setValue(patientNoteCategoryCode);
    }

}
