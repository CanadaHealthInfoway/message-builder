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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.immunization.poiz_mt060140ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.VaccineEntityType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



/**
 * <p>Business Name: Generic Query Parameters</p>
 * 
 * <p>Root class for query definition</p>
 * 
 * <p>Defines the set of parameters that may be used to filter 
 * the query response.</p>
 */
@Hl7PartTypeMapping({"POIZ_MT060140CA.ParameterList"})
@Hl7RootType
public class GenericQueryParametersBean extends MessagePartBean {

    private static final long serialVersionUID = 20130613L;
    private IVL<TS, Interval<Date>> immunizationPeriodValue = new IVLImpl<TS, Interval<Date>>();
    private BL includeIssuesIndicatorValue = new BLImpl();
    private BL includeNotesIndicatorValue = new BLImpl();
    private IVL<TS, Interval<Date>> nextPlannedDosePeriodValue = new IVLImpl<TS, Interval<Date>>();
    private TS patientBirthDateValue = new TSImpl();
    private CV patientGenderValue = new CVImpl();
    private II patientIDValue = new IIImpl();
    private PN patientNameValue = new PNImpl();
    private IVL<TS, Interval<Date>> renewalPeriodValue = new IVLImpl<TS, Interval<Date>>();
    private CV vaccineCodeValue = new CVImpl();
    private INT vaccineDoseNumberValue = new INTImpl();


    /**
     * <p>Business Name: G:Immunization Period</p>
     * 
     * <p>Relationship: POIZ_MT060140CA.ImmunizationPeriod.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the requester to specify the period of interest 
     * for the retrieval of immunization records.</p><p>Useful for 
     * constraining run-away queries.</p>
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
     * <p>Relationship: POIZ_MT060140CA.ImmunizationPeriod.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the requester to specify the period of interest 
     * for the retrieval of immunization records.</p><p>Useful for 
     * constraining run-away queries.</p>
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
     * <p>Business Name: Include Issues Indicator</p>
     * 
     * <p>Relationship: 
     * POIZ_MT060140CA.IncludeIssuesIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the flexibility of omitting/including issues 
     * in the retrieval of information for immunization 
     * data.</p><p>Because the attribute is boolean, it must 
     * explicitly indicate a 'TRUE' or 'FALSE', and thus it is 
     * mandatory.</p>
     * 
     * <p>Indicates whether or not issues attached to the 
     * immunization record are to be returned along with the 
     * detailed information.</p>
     */
    @Hl7XmlMapping({"includeIssuesIndicator/value"})
    public Boolean getIncludeIssuesIndicatorValue() {
        return this.includeIssuesIndicatorValue.getValue();
    }

    /**
     * <p>Business Name: Include Issues Indicator</p>
     * 
     * <p>Relationship: 
     * POIZ_MT060140CA.IncludeIssuesIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the flexibility of omitting/including issues 
     * in the retrieval of information for immunization 
     * data.</p><p>Because the attribute is boolean, it must 
     * explicitly indicate a 'TRUE' or 'FALSE', and thus it is 
     * mandatory.</p>
     * 
     * <p>Indicates whether or not issues attached to the 
     * immunization record are to be returned along with the 
     * detailed information.</p>
     */
    public void setIncludeIssuesIndicatorValue(Boolean includeIssuesIndicatorValue) {
        this.includeIssuesIndicatorValue.setValue(includeIssuesIndicatorValue);
    }


    /**
     * <p>Business Name: Include Notes Indicator</p>
     * 
     * <p>Relationship: POIZ_MT060140CA.IncludeNotesIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the flexibility of omitting/including notes in 
     * the retrieval of information for immunization data. The 
     * value of this parameter must be known to return a response, 
     * so it is marked as mandatory.</p>
     * 
     * <p>Indicates whether or not notes attached to the 
     * immunization record are to be returned along with the 
     * detailed information.</p>
     */
    @Hl7XmlMapping({"includeNotesIndicator/value"})
    public Boolean getIncludeNotesIndicatorValue() {
        return this.includeNotesIndicatorValue.getValue();
    }

    /**
     * <p>Business Name: Include Notes Indicator</p>
     * 
     * <p>Relationship: POIZ_MT060140CA.IncludeNotesIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the flexibility of omitting/including notes in 
     * the retrieval of information for immunization data. The 
     * value of this parameter must be known to return a response, 
     * so it is marked as mandatory.</p>
     * 
     * <p>Indicates whether or not notes attached to the 
     * immunization record are to be returned along with the 
     * detailed information.</p>
     */
    public void setIncludeNotesIndicatorValue(Boolean includeNotesIndicatorValue) {
        this.includeNotesIndicatorValue.setValue(includeNotesIndicatorValue);
    }


    /**
     * <p>Business Name: H:Next Planned Dose Period</p>
     * 
     * <p>Relationship: POIZ_MT060140CA.NextPlannedDosePeriod.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the requester to specify the period of interest 
     * for the retrieval of immunization records.</p><p>Useful for 
     * constraining run-away queries.</p>
     * 
     * <p>Indicates that the returned records should be filtered to 
     * only include those immunization records for which the next 
     * planned dose date falls within the indicated 
     * time-period.</p>
     */
    @Hl7XmlMapping({"nextPlannedDosePeriod/value"})
    public Interval<Date> getNextPlannedDosePeriodValue() {
        return this.nextPlannedDosePeriodValue.getValue();
    }

    /**
     * <p>Business Name: H:Next Planned Dose Period</p>
     * 
     * <p>Relationship: POIZ_MT060140CA.NextPlannedDosePeriod.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the requester to specify the period of interest 
     * for the retrieval of immunization records.</p><p>Useful for 
     * constraining run-away queries.</p>
     * 
     * <p>Indicates that the returned records should be filtered to 
     * only include those immunization records for which the next 
     * planned dose date falls within the indicated 
     * time-period.</p>
     */
    public void setNextPlannedDosePeriodValue(Interval<Date> nextPlannedDosePeriodValue) {
        this.nextPlannedDosePeriodValue.setValue(nextPlannedDosePeriodValue);
    }


    /**
     * <p>Business Name: D:Patient Birth Date</p>
     * 
     * <p>Relationship: POIZ_MT060140CA.PatientBirthDate.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Use to confirm identity of the patient for the query and 
     * is therefore mandatory.</p>
     * 
     * <p>Indicates the date on whic the patient was born.</p>
     */
    @Hl7XmlMapping({"patientBirthDate/value"})
    public Date getPatientBirthDateValue() {
        return this.patientBirthDateValue.getValue();
    }

    /**
     * <p>Business Name: D:Patient Birth Date</p>
     * 
     * <p>Relationship: POIZ_MT060140CA.PatientBirthDate.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Use to confirm identity of the patient for the query and 
     * is therefore mandatory.</p>
     * 
     * <p>Indicates the date on whic the patient was born.</p>
     */
    public void setPatientBirthDateValue(Date patientBirthDateValue) {
        this.patientBirthDateValue.setValue(patientBirthDateValue);
    }


    /**
     * <p>Business Name: C:Patient Gender</p>
     * 
     * <p>Relationship: POIZ_MT060140CA.PatientGender.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used to confirm the identity of the patient for the query 
     * and is therefore mandatory.</p>
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
     * <p>Relationship: POIZ_MT060140CA.PatientGender.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used to confirm the identity of the patient for the query 
     * and is therefore mandatory.</p>
     * 
     * <p>Indicates the gender (sex) of the patient.</p>
     */
    public void setPatientGenderValue(AdministrativeGender patientGenderValue) {
        this.patientGenderValue.setValue(patientGenderValue);
    }


    /**
     * <p>Business Name: B:Patient ID</p>
     * 
     * <p>Relationship: POIZ_MT060140CA.PatientID.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows filtering of result set by patient Id. This is a 
     * mandatory field because a patient must be specified for the 
     * query to be valid</p>
     * 
     * <p>Identifier of the patient who is the subject of the 
     * patient immunization query. Filter the result set to include 
     * only those records pertaining to the patient with this 
     * Id.</p>
     */
    @Hl7XmlMapping({"patientID/value"})
    public Identifier getPatientIDValue() {
        return this.patientIDValue.getValue();
    }

    /**
     * <p>Business Name: B:Patient ID</p>
     * 
     * <p>Relationship: POIZ_MT060140CA.PatientID.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows filtering of result set by patient Id. This is a 
     * mandatory field because a patient must be specified for the 
     * query to be valid</p>
     * 
     * <p>Identifier of the patient who is the subject of the 
     * patient immunization query. Filter the result set to include 
     * only those records pertaining to the patient with this 
     * Id.</p>
     */
    public void setPatientIDValue(Identifier patientIDValue) {
        this.patientIDValue.setValue(patientIDValue);
    }


    /**
     * <p>Business Name: C:Patient Name</p>
     * 
     * <p>Relationship: POIZ_MT060140CA.PatientName.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows filtering of result set by patient name. This is a 
     * mandatory field because a patient name must match the 
     * patient Id for the query to be valid.</p>
     * 
     * <p>The name of the patient who is the subject of the patient 
     * immunization query.</p><p>Filter the result set to include 
     * only those records pertaining to the patient with this 
     * name.</p>
     */
    @Hl7XmlMapping({"patientName/value"})
    public PersonName getPatientNameValue() {
        return this.patientNameValue.getValue();
    }

    /**
     * <p>Business Name: C:Patient Name</p>
     * 
     * <p>Relationship: POIZ_MT060140CA.PatientName.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows filtering of result set by patient name. This is a 
     * mandatory field because a patient name must match the 
     * patient Id for the query to be valid.</p>
     * 
     * <p>The name of the patient who is the subject of the patient 
     * immunization query.</p><p>Filter the result set to include 
     * only those records pertaining to the patient with this 
     * name.</p>
     */
    public void setPatientNameValue(PersonName patientNameValue) {
        this.patientNameValue.setValue(patientNameValue);
    }


    /**
     * <p>Business Name: I:Renewal Period</p>
     * 
     * <p>Relationship: POIZ_MT060140CA.RenewalPeriod.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the requester to specify the period of interest 
     * for the retrieval of immunization records.</p><p>Useful for 
     * constraining run-away queries.</p>
     * 
     * <p>Indicates that the returned records should be filtered to 
     * only include those immunization records for which the 
     * renewal date falls within the indicated time-period.</p>
     */
    @Hl7XmlMapping({"renewalPeriod/value"})
    public Interval<Date> getRenewalPeriodValue() {
        return this.renewalPeriodValue.getValue();
    }

    /**
     * <p>Business Name: I:Renewal Period</p>
     * 
     * <p>Relationship: POIZ_MT060140CA.RenewalPeriod.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the requester to specify the period of interest 
     * for the retrieval of immunization records.</p><p>Useful for 
     * constraining run-away queries.</p>
     * 
     * <p>Indicates that the returned records should be filtered to 
     * only include those immunization records for which the 
     * renewal date falls within the indicated time-period.</p>
     */
    public void setRenewalPeriodValue(Interval<Date> renewalPeriodValue) {
        this.renewalPeriodValue.setValue(renewalPeriodValue);
    }


    /**
     * <p>Business Name: E:Vaccine Code</p>
     * 
     * <p>Relationship: POIZ_MT060140CA.VaccineCode.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for finer sub-set of immunization records to be 
     * retrieved based on the vaccine code used in the 
     * immunization.</p>
     * 
     * <p>A coded value indicating a specific vaccine to be used in 
     * searching for patient immunization record.</p><p>The result 
     * set will be filtered to only include immunization records 
     * involving the specific vaccine code</p>
     */
    @Hl7XmlMapping({"vaccineCode/value"})
    public VaccineEntityType getVaccineCodeValue() {
        return (VaccineEntityType) this.vaccineCodeValue.getValue();
    }

    /**
     * <p>Business Name: E:Vaccine Code</p>
     * 
     * <p>Relationship: POIZ_MT060140CA.VaccineCode.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for finer sub-set of immunization records to be 
     * retrieved based on the vaccine code used in the 
     * immunization.</p>
     * 
     * <p>A coded value indicating a specific vaccine to be used in 
     * searching for patient immunization record.</p><p>The result 
     * set will be filtered to only include immunization records 
     * involving the specific vaccine code</p>
     */
    public void setVaccineCodeValue(VaccineEntityType vaccineCodeValue) {
        this.vaccineCodeValue.setValue(vaccineCodeValue);
    }


    /**
     * <p>Business Name: F:Vaccine Dose Number</p>
     * 
     * <p>Relationship: POIZ_MT060140CA.VaccineDoseNumber.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for finer sub-set of immunization records to be 
     * retrieved based on the sequence of the vaccine booster.</p>
     * 
     * <p>A number representing the vaccine booster order that must 
     * be used in searching for patient immunization 
     * record.</p><p>The result set will be filtered to only 
     * include immunization records pertaining to specific booster 
     * number.</p>
     */
    @Hl7XmlMapping({"vaccineDoseNumber/value"})
    public Integer getVaccineDoseNumberValue() {
        return this.vaccineDoseNumberValue.getValue();
    }

    /**
     * <p>Business Name: F:Vaccine Dose Number</p>
     * 
     * <p>Relationship: POIZ_MT060140CA.VaccineDoseNumber.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for finer sub-set of immunization records to be 
     * retrieved based on the sequence of the vaccine booster.</p>
     * 
     * <p>A number representing the vaccine booster order that must 
     * be used in searching for patient immunization 
     * record.</p><p>The result set will be filtered to only 
     * include immunization records pertaining to specific booster 
     * number.</p>
     */
    public void setVaccineDoseNumberValue(Integer vaccineDoseNumberValue) {
        this.vaccineDoseNumberValue.setValue(vaccineDoseNumberValue);
    }

}
