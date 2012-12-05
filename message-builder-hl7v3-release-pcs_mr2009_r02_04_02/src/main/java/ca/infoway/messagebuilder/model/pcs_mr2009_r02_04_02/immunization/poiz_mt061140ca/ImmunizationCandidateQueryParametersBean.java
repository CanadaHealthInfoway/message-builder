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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.immunization.poiz_mt061140ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.RawListWrapper;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.ClinicalDrug;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Business Name: Immunization Candidate Query Parameters</p>
 * 
 * <p>Root class for the query.</p>
 * 
 * <p>Defines the set of parameters that may be used to filter 
 * the query response.</p>
 */
@Hl7PartTypeMapping({"POIZ_MT061140CA.ParameterList"})
@Hl7RootType
public class ImmunizationCandidateQueryParametersBean extends MessagePartBean {

    private static final long serialVersionUID = 20121204L;
    private IVL<TS, Interval<Date>> immunizationPeriodValue = new IVLImpl<TS, Interval<Date>>();
    private IVL<TS, Interval<Date>> patientBirthDateValue = new IVLImpl<TS, Interval<Date>>();
    private CV patientGenderValue = new CVImpl();
    private List<PatientIDBean> patientID = new ArrayList<PatientIDBean>();
    private PN patientNameValue = new PNImpl();
    private ST postalCodeValue = new STImpl();
    private List<II> serviceDeliveryLocationValue = new ArrayList<II>();
    private CV vaccineCodeValue = new CVImpl();


    /**
     * <p>Business Name: G:Immunization Period</p>
     * 
     * <p>Relationship: POIZ_MT061140CA.ImmunizationPeriod.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the requester to specify the period of interest 
     * for the retrieval of immunization records.</p><p>Useful for 
     * constraining run-away queries. As a result, this parameter 
     * is required.</p>
     * 
     * <p>Indicates that the returned records should be filtered to 
     * only include those immunizations that occurred within the 
     * indicated time-period. This will commonly be used to 
     * retrieve 'all immunizations since xxx'.</p>
     */
    @Hl7XmlMapping({"immunizationPeriod/value"})
    public Interval<Date> getImmunizationPeriodValue() {
        return this.immunizationPeriodValue.getValue();
    }

    /**
     * <p>Business Name: G:Immunization Period</p>
     * 
     * <p>Relationship: POIZ_MT061140CA.ImmunizationPeriod.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the requester to specify the period of interest 
     * for the retrieval of immunization records.</p><p>Useful for 
     * constraining run-away queries. As a result, this parameter 
     * is required.</p>
     * 
     * <p>Indicates that the returned records should be filtered to 
     * only include those immunizations that occurred within the 
     * indicated time-period. This will commonly be used to 
     * retrieve 'all immunizations since xxx'.</p>
     */
    public void setImmunizationPeriodValue(Interval<Date> immunizationPeriodValue) {
        this.immunizationPeriodValue.setValue(immunizationPeriodValue);
    }


    /**
     * <p>Business Name: D:Patient Birth Date Range</p>
     * 
     * <p>Relationship: POIZ_MT061140CA.PatientBirthDate.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Use to confirm identity of the patient for the query. As 
     * a result, this parameter is required.</p>
     * 
     * <p>Indicates the range of on which the patient was born.</p>
     */
    @Hl7XmlMapping({"patientBirthDate/value"})
    public Interval<Date> getPatientBirthDateValue() {
        return this.patientBirthDateValue.getValue();
    }

    /**
     * <p>Business Name: D:Patient Birth Date Range</p>
     * 
     * <p>Relationship: POIZ_MT061140CA.PatientBirthDate.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Use to confirm identity of the patient for the query. As 
     * a result, this parameter is required.</p>
     * 
     * <p>Indicates the range of on which the patient was born.</p>
     */
    public void setPatientBirthDateValue(Interval<Date> patientBirthDateValue) {
        this.patientBirthDateValue.setValue(patientBirthDateValue);
    }


    /**
     * <p>Business Name: C:Patient Gender</p>
     * 
     * <p>Relationship: POIZ_MT061140CA.PatientGender.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used to confirm the identity of the patient for the 
     * query. As a result, this parameter is required.</p>
     * 
     * <p>Indicates the gender (sex) of the patient.</p>
     */
    @Hl7XmlMapping({"patientGender/value"})
    public AdministrativeGender getPatientGenderValue() {
        return (AdministrativeGender) this.patientGenderValue.getValue();
    }

    /**
     * <p>Business Name: C:Patient Gender</p>
     * 
     * <p>Relationship: POIZ_MT061140CA.PatientGender.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used to confirm the identity of the patient for the 
     * query. As a result, this parameter is required.</p>
     * 
     * <p>Indicates the gender (sex) of the patient.</p>
     */
    public void setPatientGenderValue(AdministrativeGender patientGenderValue) {
        this.patientGenderValue.setValue(patientGenderValue);
    }


    /**
     * <p>Relationship: POIZ_MT061140CA.ParameterList.patientID</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-10000)</p>
     */
    @Hl7XmlMapping({"patientID"})
    public List<PatientIDBean> getPatientID() {
        return this.patientID;
    }


    /**
     * <p>Business Name: B:Patient Name</p>
     * 
     * <p>Relationship: POIZ_MT061140CA.PatientName.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows filtering of result set by patient name. As a 
     * result, this parameter is required.</p>
     * 
     * <p>names are messaged as iterations of the PN datatype, with 
     * specific name parts identified as a type declaration in 
     * addition to the text string.</p>
     * 
     * <p>The name of the patient who is the subject of the 
     * immunization candidate query.</p><p>Filter the result set to 
     * include only those records pertaining to the patient with 
     * this name.</p>
     */
    @Hl7XmlMapping({"patientName/value"})
    public PersonName getPatientNameValue() {
        return this.patientNameValue.getValue();
    }

    /**
     * <p>Business Name: B:Patient Name</p>
     * 
     * <p>Relationship: POIZ_MT061140CA.PatientName.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows filtering of result set by patient name. As a 
     * result, this parameter is required.</p>
     * 
     * <p>names are messaged as iterations of the PN datatype, with 
     * specific name parts identified as a type declaration in 
     * addition to the text string.</p>
     * 
     * <p>The name of the patient who is the subject of the 
     * immunization candidate query.</p><p>Filter the result set to 
     * include only those records pertaining to the patient with 
     * this name.</p>
     */
    public void setPatientNameValue(PersonName patientNameValue) {
        this.patientNameValue.setValue(patientNameValue);
    }


    /**
     * <p>Business Name: I:Postal Code</p>
     * 
     * <p>Relationship: POIZ_MT061140CA.PostalCode.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the requester to specify the postal code area of 
     * interest for the retrieval of immunization 
     * records.</p><p>Useful for constraining run-away queries. As 
     * a result, this parameter is required.</p>
     * 
     * <p>Indicates that the returned records should be filtered to 
     * only include those immunizations that occurred within a 
     * specified postal code area</p>
     */
    @Hl7XmlMapping({"postalCode/value"})
    public String getPostalCodeValue() {
        return this.postalCodeValue.getValue();
    }

    /**
     * <p>Business Name: I:Postal Code</p>
     * 
     * <p>Relationship: POIZ_MT061140CA.PostalCode.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the requester to specify the postal code area of 
     * interest for the retrieval of immunization 
     * records.</p><p>Useful for constraining run-away queries. As 
     * a result, this parameter is required.</p>
     * 
     * <p>Indicates that the returned records should be filtered to 
     * only include those immunizations that occurred within a 
     * specified postal code area</p>
     */
    public void setPostalCodeValue(String postalCodeValue) {
        this.postalCodeValue.setValue(postalCodeValue);
    }


    /**
     * <p>Business Name: H:Service Delivery Locations</p>
     * 
     * <p>Relationship: 
     * POIZ_MT061140CA.ServiceDeliveryLocation.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the requester to specify the service delivery 
     * location of interest for the retrieval of immunization 
     * records.</p><p>Useful for constraining run-away queries. As 
     * a result, this parameter is required.</p>
     * 
     * <p>Indicates that the returned records should be filtered to 
     * only include those immunizations that occurred at an 
     * identified service delivery location</p>
     */
    @Hl7XmlMapping({"serviceDeliveryLocation/value"})
    public List<Identifier> getServiceDeliveryLocationValue() {
        return new RawListWrapper<II, Identifier>(serviceDeliveryLocationValue, IIImpl.class);
    }


    /**
     * <p>Business Name: E:Vaccine Code</p>
     * 
     * <p>Relationship: POIZ_MT061140CA.VaccineCode.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for finer sub-set of immunization records to be 
     * retrieved based on the vaccine code used in the 
     * immunization. As a result, this parameter is required.</p>
     * 
     * <p>A coded value indicating a specific vaccine to be used in 
     * searching for patient immunization record.</p><p>The result 
     * set will be filtered to only include immunization records 
     * involving the specific vaccine code</p>
     */
    @Hl7XmlMapping({"vaccineCode/value"})
    public ClinicalDrug getVaccineCodeValue() {
        return (ClinicalDrug) this.vaccineCodeValue.getValue();
    }

    /**
     * <p>Business Name: E:Vaccine Code</p>
     * 
     * <p>Relationship: POIZ_MT061140CA.VaccineCode.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for finer sub-set of immunization records to be 
     * retrieved based on the vaccine code used in the 
     * immunization. As a result, this parameter is required.</p>
     * 
     * <p>A coded value indicating a specific vaccine to be used in 
     * searching for patient immunization record.</p><p>The result 
     * set will be filtered to only include immunization records 
     * involving the specific vaccine code</p>
     */
    public void setVaccineCodeValue(ClinicalDrug vaccineCodeValue) {
        this.vaccineCodeValue.setValue(vaccineCodeValue);
    }

}
