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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.pharmacy.porx_mt060220ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.IssueFilterCode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



/**
 * <p>Defines the set of parameters that may be used to filter 
 * the query response.</p>
 * 
 * <p>Root class for query definition</p>
 */
@Hl7PartTypeMapping({"PORX_MT060220CA.ParameterList"})
@Hl7RootType
public class ParameterListBean extends MessagePartBean {

    private static final long serialVersionUID = 20150902L;
    private IVL<TS, Interval<Date>> administrationEffectivePeriodValue = new IVLImpl<TS, Interval<Date>>();
    private IVL<TS, Interval<Date>> amendedInTimeRangeValue = new IVLImpl<TS, Interval<Date>>();
    private BL includeIssuesIndicatorValue = new BLImpl();
    private BL includeNotesIndicatorValue = new BLImpl();
    private CV issueFilterCodeValue = new CVImpl();
    private II otherMedicationRecordIdValue = new IIImpl();
    private TS patientBirthDateValue = new TSImpl();
    private CV patientGenderValue = new CVImpl();
    private II patientIDValue = new IIImpl();
    private PN patientNameValue = new PNImpl();


    /**
     * <p>Business Name: Administration Effective Period</p>
     * 
     * <p>Relationship: 
     * PORX_MT060220CA.AdministrationEffectivePeriod.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the administration period for which the 
     * request/query applies.</p><p>Filter the result set to 
     * include only those other medication records for which the 
     * patient was deemed to be taking the drug within the 
     * specified period.</p>
     * 
     * <p>Indicates the administration period for which the 
     * request/query applies.</p><p>Filter the result set to 
     * include only those other medication records for which the 
     * patient was deemed to be taking the drug within the 
     * specified period.</p>
     * 
     * <p>Allows the requester to specify the administration period 
     * of interest for the retrieval. Useful for constraining 
     * run-away queries.</p>
     */
    @Hl7XmlMapping({"administrationEffectivePeriod/value"})
    public Interval<Date> getAdministrationEffectivePeriodValue() {
        return this.administrationEffectivePeriodValue.getValue();
    }

    /**
     * <p>Business Name: Administration Effective Period</p>
     * 
     * <p>Relationship: 
     * PORX_MT060220CA.AdministrationEffectivePeriod.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the administration period for which the 
     * request/query applies.</p><p>Filter the result set to 
     * include only those other medication records for which the 
     * patient was deemed to be taking the drug within the 
     * specified period.</p>
     * 
     * <p>Indicates the administration period for which the 
     * request/query applies.</p><p>Filter the result set to 
     * include only those other medication records for which the 
     * patient was deemed to be taking the drug within the 
     * specified period.</p>
     * 
     * <p>Allows the requester to specify the administration period 
     * of interest for the retrieval. Useful for constraining 
     * run-away queries.</p>
     */
    public void setAdministrationEffectivePeriodValue(Interval<Date> administrationEffectivePeriodValue) {
        this.administrationEffectivePeriodValue.setValue(administrationEffectivePeriodValue);
    }


    /**
     * <p>Business Name: Amended in Time Range</p>
     * 
     * <p>Relationship: PORX_MT060220CA.AmendedInTimeRange.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates that the returned records should be filtered to 
     * only include those which have been amended in some way (had 
     * status changed, been annotated, prescription was dispensed, 
     * etc.) within the indicated time-period. This will commonly 
     * be used to 'retrieve everything that has been amended since 
     * xxx'.</p>
     * 
     * <p>Allows the requester to specify the event period of 
     * interest for the retrieval of medication 
     * records.</p><p>Useful for constraining run-away queries</p>
     * 
     * <p>Allows the requester to specify the event period of 
     * interest for the retrieval of medication 
     * records.</p><p>Useful for constraining run-away queries</p>
     */
    @Hl7XmlMapping({"amendedInTimeRange/value"})
    public Interval<Date> getAmendedInTimeRangeValue() {
        return this.amendedInTimeRangeValue.getValue();
    }

    /**
     * <p>Business Name: Amended in Time Range</p>
     * 
     * <p>Relationship: PORX_MT060220CA.AmendedInTimeRange.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates that the returned records should be filtered to 
     * only include those which have been amended in some way (had 
     * status changed, been annotated, prescription was dispensed, 
     * etc.) within the indicated time-period. This will commonly 
     * be used to 'retrieve everything that has been amended since 
     * xxx'.</p>
     * 
     * <p>Allows the requester to specify the event period of 
     * interest for the retrieval of medication 
     * records.</p><p>Useful for constraining run-away queries</p>
     * 
     * <p>Allows the requester to specify the event period of 
     * interest for the retrieval of medication 
     * records.</p><p>Useful for constraining run-away queries</p>
     */
    public void setAmendedInTimeRangeValue(Interval<Date> amendedInTimeRangeValue) {
        this.amendedInTimeRangeValue.setValue(amendedInTimeRangeValue);
    }


    /**
     * <p>Business Name: Include Issues Indicator</p>
     * 
     * <p>Relationship: 
     * PORX_MT060220CA.IncludeIssuesIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates whether or not Issues (detected and/or managed) 
     * attached to the other medication records are to be returned 
     * along with the detailed information.</p>
     * 
     * <p>Allows for the flexibility of omitting/including issues 
     * in the retrieval of medication data.</p><p>Because the 
     * attribute is boolean, it must explicitly indicate a 'TRUE' 
     * or 'FALSE', and thus it is mandatory.</p>
     * 
     * <p>Allows for the flexibility of omitting/including issues 
     * in the retrieval of medication data.</p><p>Because the 
     * attribute is boolean, it must explicitly indicate a 'TRUE' 
     * or 'FALSE', and thus it is mandatory.</p>
     */
    @Hl7XmlMapping({"includeIssuesIndicator/value"})
    public Boolean getIncludeIssuesIndicatorValue() {
        return this.includeIssuesIndicatorValue.getValue();
    }

    /**
     * <p>Business Name: Include Issues Indicator</p>
     * 
     * <p>Relationship: 
     * PORX_MT060220CA.IncludeIssuesIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates whether or not Issues (detected and/or managed) 
     * attached to the other medication records are to be returned 
     * along with the detailed information.</p>
     * 
     * <p>Allows for the flexibility of omitting/including issues 
     * in the retrieval of medication data.</p><p>Because the 
     * attribute is boolean, it must explicitly indicate a 'TRUE' 
     * or 'FALSE', and thus it is mandatory.</p>
     * 
     * <p>Allows for the flexibility of omitting/including issues 
     * in the retrieval of medication data.</p><p>Because the 
     * attribute is boolean, it must explicitly indicate a 'TRUE' 
     * or 'FALSE', and thus it is mandatory.</p>
     */
    public void setIncludeIssuesIndicatorValue(Boolean includeIssuesIndicatorValue) {
        this.includeIssuesIndicatorValue.setValue(includeIssuesIndicatorValue);
    }


    /**
     * <p>Business Name: Include Notes Indicator</p>
     * 
     * <p>Relationship: PORX_MT060220CA.IncludeNotesIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates whether or not notes attached to the other 
     * medication records are to be returned along with the 
     * detailed information.</p>
     * 
     * <p>Allows for the flexibility of omitting/including notes in 
     * the retrieval of information for medication 
     * data.</p><p>Because the attribute is boolean, it must 
     * explicitly indicate a 'TRUE' or 'FALSE', and thus it is 
     * mandatory.</p>
     * 
     * <p>Allows for the flexibility of omitting/including notes in 
     * the retrieval of information for medication 
     * data.</p><p>Because the attribute is boolean, it must 
     * explicitly indicate a 'TRUE' or 'FALSE', and thus it is 
     * mandatory.</p>
     */
    @Hl7XmlMapping({"includeNotesIndicator/value"})
    public Boolean getIncludeNotesIndicatorValue() {
        return this.includeNotesIndicatorValue.getValue();
    }

    /**
     * <p>Business Name: Include Notes Indicator</p>
     * 
     * <p>Relationship: PORX_MT060220CA.IncludeNotesIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates whether or not notes attached to the other 
     * medication records are to be returned along with the 
     * detailed information.</p>
     * 
     * <p>Allows for the flexibility of omitting/including notes in 
     * the retrieval of information for medication 
     * data.</p><p>Because the attribute is boolean, it must 
     * explicitly indicate a 'TRUE' or 'FALSE', and thus it is 
     * mandatory.</p>
     * 
     * <p>Allows for the flexibility of omitting/including notes in 
     * the retrieval of information for medication 
     * data.</p><p>Because the attribute is boolean, it must 
     * explicitly indicate a 'TRUE' or 'FALSE', and thus it is 
     * mandatory.</p>
     */
    public void setIncludeNotesIndicatorValue(Boolean includeNotesIndicatorValue) {
        this.includeNotesIndicatorValue.setValue(includeNotesIndicatorValue);
    }


    /**
     * <p>Business Name: Issue Filter Code</p>
     * 
     * <p>Relationship: PORX_MT060220CA.IssueFilterCode.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates whether records to be returned (e.g. 
     * prescription order, prescription dispense and/or other 
     * medication) should be filtered to those with at least one 
     * persistent un-managed issue (against the record), with at 
     * least one persistent issues or should return all records, 
     * independent of the presence of persistent issues.</p>
     * 
     * <p>By filtering returned records to include only those which 
     * have unmanaged issues or any issues at all, allows a 
     * provider to focus on those aspects of care where extra 
     * attention is needed. Because the attribute must be known, it 
     * is mandatory.</p>
     */
    @Hl7XmlMapping({"issueFilterCode/value"})
    public IssueFilterCode getIssueFilterCodeValue() {
        return (IssueFilterCode) this.issueFilterCodeValue.getValue();
    }

    /**
     * <p>Business Name: Issue Filter Code</p>
     * 
     * <p>Relationship: PORX_MT060220CA.IssueFilterCode.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates whether records to be returned (e.g. 
     * prescription order, prescription dispense and/or other 
     * medication) should be filtered to those with at least one 
     * persistent un-managed issue (against the record), with at 
     * least one persistent issues or should return all records, 
     * independent of the presence of persistent issues.</p>
     * 
     * <p>By filtering returned records to include only those which 
     * have unmanaged issues or any issues at all, allows a 
     * provider to focus on those aspects of care where extra 
     * attention is needed. Because the attribute must be known, it 
     * is mandatory.</p>
     */
    public void setIssueFilterCodeValue(IssueFilterCode issueFilterCodeValue) {
        this.issueFilterCodeValue.setValue(issueFilterCodeValue);
    }


    /**
     * <p>Business Name: E:Other Medication Record Id</p>
     * 
     * <p>Relationship: 
     * PORX_MT060220CA.OtherMedicationRecordId.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifier of the other medication record for which 
     * detailed information is to be retrieved.</p>
     * 
     * <p>Allows for the retrieval of medication records based on a 
     * specific active medication record.</p>
     */
    @Hl7XmlMapping({"otherMedicationRecordId/value"})
    public Identifier getOtherMedicationRecordIdValue() {
        return this.otherMedicationRecordIdValue.getValue();
    }

    /**
     * <p>Business Name: E:Other Medication Record Id</p>
     * 
     * <p>Relationship: 
     * PORX_MT060220CA.OtherMedicationRecordId.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifier of the other medication record for which 
     * detailed information is to be retrieved.</p>
     * 
     * <p>Allows for the retrieval of medication records based on a 
     * specific active medication record.</p>
     */
    public void setOtherMedicationRecordIdValue(Identifier otherMedicationRecordIdValue) {
        this.otherMedicationRecordIdValue.setValue(otherMedicationRecordIdValue);
    }


    /**
     * <p>Business Name: Patient Birth Date</p>
     * 
     * <p>Relationship: PORX_MT060220CA.PatientBirthDate.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the date on which the patient was born.</p>
     * 
     * <p>Used to confirm the identity of the patient for the query 
     * and is therefore mandatory.</p>
     */
    @Hl7XmlMapping({"patientBirthDate/value"})
    public Date getPatientBirthDateValue() {
        return this.patientBirthDateValue.getValue();
    }

    /**
     * <p>Business Name: Patient Birth Date</p>
     * 
     * <p>Relationship: PORX_MT060220CA.PatientBirthDate.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the date on which the patient was born.</p>
     * 
     * <p>Used to confirm the identity of the patient for the query 
     * and is therefore mandatory.</p>
     */
    public void setPatientBirthDateValue(Date patientBirthDateValue) {
        this.patientBirthDateValue.setValue(patientBirthDateValue);
    }


    /**
     * <p>Business Name: Patient Gender</p>
     * 
     * <p>Relationship: PORX_MT060220CA.PatientGender.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the gender (sex) of the patient.</p>
     * 
     * <p>Used to confirm the identity of the patient for the query 
     * and is therefore mandatory.</p>
     */
    @Hl7XmlMapping({"patientGender/value"})
    public AdministrativeGender getPatientGenderValue() {
        return (AdministrativeGender) this.patientGenderValue.getValue();
    }

    /**
     * <p>Business Name: Patient Gender</p>
     * 
     * <p>Relationship: PORX_MT060220CA.PatientGender.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the gender (sex) of the patient.</p>
     * 
     * <p>Used to confirm the identity of the patient for the query 
     * and is therefore mandatory.</p>
     */
    public void setPatientGenderValue(AdministrativeGender patientGenderValue) {
        this.patientGenderValue.setValue(patientGenderValue);
    }


    /**
     * <p>Business Name: B:Patient ID</p>
     * 
     * <p>Relationship: PORX_MT060220CA.PatientID.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifier of the patient who is the subject of the 
     * patient medication query. Filter the result set to include 
     * only those records pertaining to the patient with this 
     * Id.</p>
     * 
     * <p>Allows filtering of result set by patient Id. This is a 
     * mandatory field because a patient must be specified for the 
     * query to be valid</p>
     */
    @Hl7XmlMapping({"patientID/value"})
    public Identifier getPatientIDValue() {
        return this.patientIDValue.getValue();
    }

    /**
     * <p>Business Name: B:Patient ID</p>
     * 
     * <p>Relationship: PORX_MT060220CA.PatientID.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifier of the patient who is the subject of the 
     * patient medication query. Filter the result set to include 
     * only those records pertaining to the patient with this 
     * Id.</p>
     * 
     * <p>Allows filtering of result set by patient Id. This is a 
     * mandatory field because a patient must be specified for the 
     * query to be valid</p>
     */
    public void setPatientIDValue(Identifier patientIDValue) {
        this.patientIDValue.setValue(patientIDValue);
    }


    /**
     * <p>Business Name: C:Patient Name</p>
     * 
     * <p>Relationship: PORX_MT060220CA.PatientName.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The name of the patient who is the subject of the patient 
     * medication query.</p><p>Filter the result set to include 
     * only those records pertaining to the patient with this 
     * name.</p>
     * 
     * <p>The name of the patient who is the subject of the patient 
     * medication query.</p><p>Filter the result set to include 
     * only those records pertaining to the patient with this 
     * name.</p>
     * 
     * <p>Allows filtering of result set by patient name. This is a 
     * mandatory field because a patient name must match the 
     * patient Id for the query to be valid.</p>
     */
    @Hl7XmlMapping({"patientName/value"})
    public PersonName getPatientNameValue() {
        return this.patientNameValue.getValue();
    }

    /**
     * <p>Business Name: C:Patient Name</p>
     * 
     * <p>Relationship: PORX_MT060220CA.PatientName.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The name of the patient who is the subject of the patient 
     * medication query.</p><p>Filter the result set to include 
     * only those records pertaining to the patient with this 
     * name.</p>
     * 
     * <p>The name of the patient who is the subject of the patient 
     * medication query.</p><p>Filter the result set to include 
     * only those records pertaining to the patient with this 
     * name.</p>
     * 
     * <p>Allows filtering of result set by patient name. This is a 
     * mandatory field because a patient name must match the 
     * patient Id for the query to be valid.</p>
     */
    public void setPatientNameValue(PersonName patientNameValue) {
        this.patientNameValue.setValue(patientNameValue);
    }

}
