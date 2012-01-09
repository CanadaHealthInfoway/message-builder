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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.immunization.poiz_mt060140ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;
import java.util.Set;



/**
 * <p>Immunization Query Parameters</p>
 * 
 * <p><p>Defines the set of parameters that may be used to 
 * filter the query response.</p></p>
 * 
 * <p><p>Root class for query.</p></p>
 */
@Hl7PartTypeMapping({"POIZ_MT060140CA.ParameterList"})
@Hl7RootType
public class ImmunizationQueryParametersBean extends MessagePartBean {

    private static final long serialVersionUID = 20120106L;
    private II immunizationEventIDValue = new IIImpl();
    private TS patientBirthDateValue = new TSImpl();
    private CV patientGenderValue = new CVImpl();
    private SET<II, Identifier> patientIDValue = new SETImpl<II, Identifier>(IIImpl.class);
    private PN patientNameValue = new PNImpl();


    /**
     * <p>A:Immunization Event ID</p>
     * 
     * <p><p>Specifies the identifier of the immunization event</p></p>
     * 
     * <p><p>Allows for filtering of queries by immuniation event 
     * ID. As a result, this attribute is mandatory.</p></p>
     */
    @Hl7XmlMapping({"immunizationEventID/value"})
    public Identifier getImmunizationEventIDValue() {
        return this.immunizationEventIDValue.getValue();
    }
    public void setImmunizationEventIDValue(Identifier immunizationEventIDValue) {
        this.immunizationEventIDValue.setValue(immunizationEventIDValue);
    }


    /**
     * <p>E:Patient Birth Date</p>
     * 
     * <p><p>Indicates the date on which the patient was born.</p></p>
     * 
     * <p><p>Use to confirm identity of the patient for the query. 
     * As a result, this attribute is required.</p></p>
     */
    @Hl7XmlMapping({"patientBirthDate/value"})
    public Date getPatientBirthDateValue() {
        return this.patientBirthDateValue.getValue();
    }
    public void setPatientBirthDateValue(Date patientBirthDateValue) {
        this.patientBirthDateValue.setValue(patientBirthDateValue);
    }


    /**
     * <p>D:Patient Gender</p>
     * 
     * <p><p>Indicates the gender (sex) of the patient.</p></p>
     * 
     * <p><p>Used to confirm the identity of the patient for the 
     * query. As a result, this attribute is required.</p></p>
     */
    @Hl7XmlMapping({"patientGender/value"})
    public AdministrativeGender getPatientGenderValue() {
        return (AdministrativeGender) this.patientGenderValue.getValue();
    }
    public void setPatientGenderValue(AdministrativeGender patientGenderValue) {
        this.patientGenderValue.setValue(patientGenderValue);
    }


    /**
     * <p>B:Patient Identifiers</p>
     * 
     * <p><p>Identifier of the patient who is the subject of the 
     * patient immunization query. Filter the result set to include 
     * only those records pertaining to the patient with this 
     * Id.</p></p>
     * 
     * <p><p>Allows filtering of result set by patient ID. This 
     * information is used to verify the record. As a result, this 
     * attribute is required.</p></p>
     */
    @Hl7XmlMapping({"patientID/value"})
    public Set<Identifier> getPatientIDValue() {
        return this.patientIDValue.rawSet();
    }


    /**
     * <p>C:Patient Name</p>
     * 
     * <p><p>The name of the patient who is the subject of the 
     * patient immunization query.</p><p>Filter the result set to 
     * include only those records pertaining to the patient with 
     * this name.</p></p>
     * 
     * <p><p>The name of the patient who is the subject of the 
     * patient immunization query.</p><p>Filter the result set to 
     * include only those records pertaining to the patient with 
     * this name.</p></p>
     * 
     * <p><p>Allows filtering of result set by patient name. This 
     * information is used to verify the record. As a result, this 
     * attribute is required.</p></p>
     * 
     * <p><p>Names are messaged as iterations of the PN datatype, 
     * with specific name parts identified as a type declaration in 
     * addition to the text string.</p></p>
     */
    @Hl7XmlMapping({"patientName/value"})
    public PersonName getPatientNameValue() {
        return this.patientNameValue.getValue();
    }
    public void setPatientNameValue(PersonName patientNameValue) {
        this.patientNameValue.setValue(patientNameValue);
    }

}
