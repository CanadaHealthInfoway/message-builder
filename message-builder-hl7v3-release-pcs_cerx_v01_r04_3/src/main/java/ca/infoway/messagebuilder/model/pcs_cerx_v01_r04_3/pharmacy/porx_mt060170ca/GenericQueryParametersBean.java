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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.porx_mt060170ca;

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
import ca.infoway.messagebuilder.domainvalue.ActNonConditionIndicationCode;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.ClinicalDrug;
import ca.infoway.messagebuilder.domainvalue.DiagnosisValue;
import ca.infoway.messagebuilder.domainvalue.SymptomValue;
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
@Hl7PartTypeMapping({"PORX_MT060170CA.ParameterList"})
@Hl7RootType
public class GenericQueryParametersBean extends MessagePartBean {

    private static final long serialVersionUID = 20190730L;
    private IVL<TS, Interval<Date>> administrationEffectivePeriodValue = new IVLImpl<TS, Interval<Date>>();
    private IVL<TS, Interval<Date>> amendedInTimeRangeValue = new IVLImpl<TS, Interval<Date>>();
    private CV diagnosisCodeValue = new CVImpl();
    private CV drugCodeValue = new CVImpl();
    private BL includeEventHistoryIndicatorValue = new BLImpl();
    private BL includeIssuesIndicatorValue = new BLImpl();
    private BL includeNotesIndicatorValue = new BLImpl();
    private BL includePendingChangesIndicatorValue = new BLImpl();
    private BL mostRecentDispenseForEachRxIndicatorValue = new BLImpl();
    private CV otherIndicationCodeValue = new CVImpl();
    private TS patientBirthDateValue = new TSImpl();
    private CV patientGenderValue = new CVImpl();
    private II patientIDValue = new IIImpl();
    private PN patientNameValue = new PNImpl();
    private CV symptomCodeValue = new CVImpl();


    /**
     * <p>Business Name: Administration Effective Period</p>
     * 
     * <p>Relationship: 
     * PORX_MT060170CA.AdministrationEffectivePeriod.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the requester to specify the administration period 
     * of interest for the retrieval. Useful for constraining 
     * run-away queries.</p>
     * 
     * <p>For a prescription indicates the period for which the 
     * patient was deemed to be taking the drug.</p><p>Filter the 
     * result set to include only those medication records 
     * (prescription order, prescription dispense and other 
     * medication) for which the patient was deemed to be taking 
     * the drug.</p>
     */
    @Hl7XmlMapping({"administrationEffectivePeriod/value"})
    public Interval<Date> getAdministrationEffectivePeriodValue() {
        return this.administrationEffectivePeriodValue.getValue();
    }

    /**
     * <p>Business Name: Administration Effective Period</p>
     * 
     * <p>Relationship: 
     * PORX_MT060170CA.AdministrationEffectivePeriod.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the requester to specify the administration period 
     * of interest for the retrieval. Useful for constraining 
     * run-away queries.</p>
     * 
     * <p>For a prescription indicates the period for which the 
     * patient was deemed to be taking the drug.</p><p>Filter the 
     * result set to include only those medication records 
     * (prescription order, prescription dispense and other 
     * medication) for which the patient was deemed to be taking 
     * the drug.</p>
     */
    public void setAdministrationEffectivePeriodValue(Interval<Date> administrationEffectivePeriodValue) {
        this.administrationEffectivePeriodValue.setValue(administrationEffectivePeriodValue);
    }


    /**
     * <p>Business Name: Amended In Time Range</p>
     * 
     * <p>Relationship: PORX_MT060170CA.AmendedInTimeRange.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the requester to specify the event period of 
     * interest for the retrieval of medication 
     * records.</p><p>Useful for constraining run-away queries.</p>
     * 
     * <p>Indicates that the returned records should be filtered to 
     * only include those which have been amended in some way (had 
     * status changed, been annotated, prescription was dispensed, 
     * etc.) within the indicated time-period. This will commonly 
     * be used to 'retrieve everything that has been amended since 
     * xxx'.</p>
     */
    @Hl7XmlMapping({"amendedInTimeRange/value"})
    public Interval<Date> getAmendedInTimeRangeValue() {
        return this.amendedInTimeRangeValue.getValue();
    }

    /**
     * <p>Business Name: Amended In Time Range</p>
     * 
     * <p>Relationship: PORX_MT060170CA.AmendedInTimeRange.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the requester to specify the event period of 
     * interest for the retrieval of medication 
     * records.</p><p>Useful for constraining run-away queries.</p>
     * 
     * <p>Indicates that the returned records should be filtered to 
     * only include those which have been amended in some way (had 
     * status changed, been annotated, prescription was dispensed, 
     * etc.) within the indicated time-period. This will commonly 
     * be used to 'retrieve everything that has been amended since 
     * xxx'.</p>
     */
    public void setAmendedInTimeRangeValue(Interval<Date> amendedInTimeRangeValue) {
        this.amendedInTimeRangeValue.setValue(amendedInTimeRangeValue);
    }


    /**
     * <p>Business Name: Diagnosis Code</p>
     * 
     * <p>Relationship: PORX_MT060170CA.DiagnosisCode.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the retrieval of patient's prescriptions 
     * and/or dispenses based on prescribing indications.</p>
     * 
     * <p>Indicates that the result set is to be filtered to 
     * include only those records pertaining to the specified 
     * diagnosis indication code.</p>
     */
    @Hl7XmlMapping({"diagnosisCode/value"})
    public DiagnosisValue getDiagnosisCodeValue() {
        return (DiagnosisValue) this.diagnosisCodeValue.getValue();
    }

    /**
     * <p>Business Name: Diagnosis Code</p>
     * 
     * <p>Relationship: PORX_MT060170CA.DiagnosisCode.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the retrieval of patient's prescriptions 
     * and/or dispenses based on prescribing indications.</p>
     * 
     * <p>Indicates that the result set is to be filtered to 
     * include only those records pertaining to the specified 
     * diagnosis indication code.</p>
     */
    public void setDiagnosisCodeValue(DiagnosisValue diagnosisCodeValue) {
        this.diagnosisCodeValue.setValue(diagnosisCodeValue);
    }


    /**
     * <p>Business Name: Drug Code</p>
     * 
     * <p>Relationship: PORX_MT060170CA.DrugCode.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the retrieval of patient prescriptions and/or 
     * dispenses based on a specific medication that was ordered 
     * and/or dispensed. This will most commonly be used to filter 
     * for therapeutic classifications such as 
     * &quot;Anti-hypertensives&quot;.</p>
     * 
     * <p>Indicates that the result set is to be filtered to 
     * include only those records pertaining to the specified drug. 
     * The code may refer to an orderable medication or a higher 
     * level drug classification.</p>
     */
    @Hl7XmlMapping({"drugCode/value"})
    public ClinicalDrug getDrugCodeValue() {
        return (ClinicalDrug) this.drugCodeValue.getValue();
    }

    /**
     * <p>Business Name: Drug Code</p>
     * 
     * <p>Relationship: PORX_MT060170CA.DrugCode.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the retrieval of patient prescriptions and/or 
     * dispenses based on a specific medication that was ordered 
     * and/or dispensed. This will most commonly be used to filter 
     * for therapeutic classifications such as 
     * &quot;Anti-hypertensives&quot;.</p>
     * 
     * <p>Indicates that the result set is to be filtered to 
     * include only those records pertaining to the specified drug. 
     * The code may refer to an orderable medication or a higher 
     * level drug classification.</p>
     */
    public void setDrugCodeValue(ClinicalDrug drugCodeValue) {
        this.drugCodeValue.setValue(drugCodeValue);
    }


    /**
     * <p>Business Name: Include Event History Indicator</p>
     * 
     * <p>Relationship: 
     * PORX_MT060170CA.IncludeEventHistoryIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the flexibility of omitting/including history 
     * in the retrieval of the requested information.</p><p>Because 
     * the attribute is boolean, it must explicitly indicate a 
     * 'TRUE' or 'FALSE', and thus it is mandatory.</p>
     * 
     * <p>Indicates whether or not history events associated with a 
     * prescription order, prescription dispense and/or active 
     * medications are to be returned along with the detailed 
     * information.</p><p>&quot;Pending&quot; changes will be 
     * returned regardless of the setting of this flag.</p>
     */
    @Hl7XmlMapping({"includeEventHistoryIndicator/value"})
    public Boolean getIncludeEventHistoryIndicatorValue() {
        return this.includeEventHistoryIndicatorValue.getValue();
    }

    /**
     * <p>Business Name: Include Event History Indicator</p>
     * 
     * <p>Relationship: 
     * PORX_MT060170CA.IncludeEventHistoryIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the flexibility of omitting/including history 
     * in the retrieval of the requested information.</p><p>Because 
     * the attribute is boolean, it must explicitly indicate a 
     * 'TRUE' or 'FALSE', and thus it is mandatory.</p>
     * 
     * <p>Indicates whether or not history events associated with a 
     * prescription order, prescription dispense and/or active 
     * medications are to be returned along with the detailed 
     * information.</p><p>&quot;Pending&quot; changes will be 
     * returned regardless of the setting of this flag.</p>
     */
    public void setIncludeEventHistoryIndicatorValue(Boolean includeEventHistoryIndicatorValue) {
        this.includeEventHistoryIndicatorValue.setValue(includeEventHistoryIndicatorValue);
    }


    /**
     * <p>Business Name: Include Issues Indicator</p>
     * 
     * <p>Relationship: 
     * PORX_MT060170CA.IncludeIssuesIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the flexibility of omitting/including issues 
     * in the retrieval of medication detail profile 
     * data.</p><p>Because the attribute is boolean, it must 
     * explicitly indicate a 'TRUE' or 'FALSE', and thus it is 
     * mandatory.</p>
     * 
     * <p>Indicates whether or not Issues (detected and/or managed) 
     * attached to the prescriptions, dispenses and other active 
     * medication records are to be returned along with the 
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
     * PORX_MT060170CA.IncludeIssuesIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the flexibility of omitting/including issues 
     * in the retrieval of medication detail profile 
     * data.</p><p>Because the attribute is boolean, it must 
     * explicitly indicate a 'TRUE' or 'FALSE', and thus it is 
     * mandatory.</p>
     * 
     * <p>Indicates whether or not Issues (detected and/or managed) 
     * attached to the prescriptions, dispenses and other active 
     * medication records are to be returned along with the 
     * detailed information.</p>
     */
    public void setIncludeIssuesIndicatorValue(Boolean includeIssuesIndicatorValue) {
        this.includeIssuesIndicatorValue.setValue(includeIssuesIndicatorValue);
    }


    /**
     * <p>Business Name: Include Notes Indicator</p>
     * 
     * <p>Relationship: PORX_MT060170CA.IncludeNotesIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the flexibility of omitting/including notes in 
     * the retrieval of information for medication profile detail 
     * data.</p><p>Because the attribute is boolean, it must 
     * explicitly indicate a 'TRUE' or 'FALSE', and thus it is 
     * mandatory.</p>
     * 
     * <p>Indicates whether or not notes attached to the 
     * prescription, dispenses and other active medication records 
     * are to be returned along with the detailed information.</p>
     */
    @Hl7XmlMapping({"includeNotesIndicator/value"})
    public Boolean getIncludeNotesIndicatorValue() {
        return this.includeNotesIndicatorValue.getValue();
    }

    /**
     * <p>Business Name: Include Notes Indicator</p>
     * 
     * <p>Relationship: PORX_MT060170CA.IncludeNotesIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the flexibility of omitting/including notes in 
     * the retrieval of information for medication profile detail 
     * data.</p><p>Because the attribute is boolean, it must 
     * explicitly indicate a 'TRUE' or 'FALSE', and thus it is 
     * mandatory.</p>
     * 
     * <p>Indicates whether or not notes attached to the 
     * prescription, dispenses and other active medication records 
     * are to be returned along with the detailed information.</p>
     */
    public void setIncludeNotesIndicatorValue(Boolean includeNotesIndicatorValue) {
        this.includeNotesIndicatorValue.setValue(includeNotesIndicatorValue);
    }


    /**
     * <p>Business Name: Include Pending Changes Indicator</p>
     * 
     * <p>Relationship: 
     * PORX_MT060170CA.IncludePendingChangesIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the flexibility of omitting/including future 
     * events in the retrieval of the requested 
     * information.</p><p>Because the attribute is boolean, it must 
     * explicitly indicate a 'TRUE' or 'FALSE', and thus it is 
     * mandatory.</p>
     * 
     * <p>Indicates whether to include future changes (e.g. status 
     * changes that aren't effective yet) associated with a 
     * prescription order, prescription dispense and/or active 
     * medications are to be returned along with the detailed 
     * information.</p>
     */
    @Hl7XmlMapping({"includePendingChangesIndicator/value"})
    public Boolean getIncludePendingChangesIndicatorValue() {
        return this.includePendingChangesIndicatorValue.getValue();
    }

    /**
     * <p>Business Name: Include Pending Changes Indicator</p>
     * 
     * <p>Relationship: 
     * PORX_MT060170CA.IncludePendingChangesIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the flexibility of omitting/including future 
     * events in the retrieval of the requested 
     * information.</p><p>Because the attribute is boolean, it must 
     * explicitly indicate a 'TRUE' or 'FALSE', and thus it is 
     * mandatory.</p>
     * 
     * <p>Indicates whether to include future changes (e.g. status 
     * changes that aren't effective yet) associated with a 
     * prescription order, prescription dispense and/or active 
     * medications are to be returned along with the detailed 
     * information.</p>
     */
    public void setIncludePendingChangesIndicatorValue(Boolean includePendingChangesIndicatorValue) {
        this.includePendingChangesIndicatorValue.setValue(includePendingChangesIndicatorValue);
    }


    /**
     * <p>Business Name: Most Recent Dispense for each Rx Indicator</p>
     * 
     * <p>Relationship: 
     * PORX_MT060170CA.MostRecentDispenseForEachRxIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Helps to trim down volume of query response by 
     * eliminating multiple dispenses for the same 
     * prescription.</p><p>Because this is a boolean attribute 
     * whose value must be known to evaluate the query, the 
     * attribute is mandatory.</p>
     * 
     * <p>Indicates whether or not a prescription dispenses 
     * returned on a query should be limited to only the most 
     * recent dispense for a prescription.</p><p>Allows the 
     * returning of at most one prescription dispense record per a 
     * prescription.</p><p>The default is 'TRUE' indicating that 
     * retrieval should be for only the most recent dispense for a 
     * prescription is to be included in a query result.</p>
     */
    @Hl7XmlMapping({"mostRecentDispenseForEachRxIndicator/value"})
    public Boolean getMostRecentDispenseForEachRxIndicatorValue() {
        return this.mostRecentDispenseForEachRxIndicatorValue.getValue();
    }

    /**
     * <p>Business Name: Most Recent Dispense for each Rx Indicator</p>
     * 
     * <p>Relationship: 
     * PORX_MT060170CA.MostRecentDispenseForEachRxIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Helps to trim down volume of query response by 
     * eliminating multiple dispenses for the same 
     * prescription.</p><p>Because this is a boolean attribute 
     * whose value must be known to evaluate the query, the 
     * attribute is mandatory.</p>
     * 
     * <p>Indicates whether or not a prescription dispenses 
     * returned on a query should be limited to only the most 
     * recent dispense for a prescription.</p><p>Allows the 
     * returning of at most one prescription dispense record per a 
     * prescription.</p><p>The default is 'TRUE' indicating that 
     * retrieval should be for only the most recent dispense for a 
     * prescription is to be included in a query result.</p>
     */
    public void setMostRecentDispenseForEachRxIndicatorValue(Boolean mostRecentDispenseForEachRxIndicatorValue) {
        this.mostRecentDispenseForEachRxIndicatorValue.setValue(mostRecentDispenseForEachRxIndicatorValue);
    }


    /**
     * <p>Business Name: Other Indication Code</p>
     * 
     * <p>Relationship: PORX_MT060170CA.OtherIndicationCode.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the retrieval of patient's prescriptions 
     * and/or dispenses based on prescribing indications.</p>
     * 
     * <p>Indicates that the result set is to be filtered to 
     * include only those records pertaining to the specified 
     * non-condition-related indication code.</p>
     */
    @Hl7XmlMapping({"otherIndicationCode/value"})
    public ActNonConditionIndicationCode getOtherIndicationCodeValue() {
        return (ActNonConditionIndicationCode) this.otherIndicationCodeValue.getValue();
    }

    /**
     * <p>Business Name: Other Indication Code</p>
     * 
     * <p>Relationship: PORX_MT060170CA.OtherIndicationCode.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the retrieval of patient's prescriptions 
     * and/or dispenses based on prescribing indications.</p>
     * 
     * <p>Indicates that the result set is to be filtered to 
     * include only those records pertaining to the specified 
     * non-condition-related indication code.</p>
     */
    public void setOtherIndicationCodeValue(ActNonConditionIndicationCode otherIndicationCodeValue) {
        this.otherIndicationCodeValue.setValue(otherIndicationCodeValue);
    }


    /**
     * <p>Business Name: Patient Birth Date</p>
     * 
     * <p>Relationship: PORX_MT060170CA.PatientBirthDate.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used to confirm the identity of the patient for the query 
     * and is therefore mandatory.</p>
     * 
     * <p>Indicates the date on which the patient was born.</p>
     */
    @Hl7XmlMapping({"patientBirthDate/value"})
    public Date getPatientBirthDateValue() {
        return this.patientBirthDateValue.getValue();
    }

    /**
     * <p>Business Name: Patient Birth Date</p>
     * 
     * <p>Relationship: PORX_MT060170CA.PatientBirthDate.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used to confirm the identity of the patient for the query 
     * and is therefore mandatory.</p>
     * 
     * <p>Indicates the date on which the patient was born.</p>
     */
    public void setPatientBirthDateValue(Date patientBirthDateValue) {
        this.patientBirthDateValue.setValue(patientBirthDateValue);
    }


    /**
     * <p>Business Name: Patient Gender</p>
     * 
     * <p>Relationship: PORX_MT060170CA.PatientGender.value</p>
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
     * <p>Business Name: Patient Gender</p>
     * 
     * <p>Relationship: PORX_MT060170CA.PatientGender.value</p>
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
     * <p>Relationship: PORX_MT060170CA.PatientID.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows filtering of result set by patient Id. This is a 
     * mandatory field because a patient must be specified for the 
     * query to be valid</p>
     * 
     * <p>Identifier of the patient who is the subject of the 
     * patient medication query. Filter the result set to include 
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
     * <p>Relationship: PORX_MT060170CA.PatientID.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows filtering of result set by patient Id. This is a 
     * mandatory field because a patient must be specified for the 
     * query to be valid</p>
     * 
     * <p>Identifier of the patient who is the subject of the 
     * patient medication query. Filter the result set to include 
     * only those records pertaining to the patient with this 
     * Id.</p>
     */
    public void setPatientIDValue(Identifier patientIDValue) {
        this.patientIDValue.setValue(patientIDValue);
    }


    /**
     * <p>Business Name: C:Patient Name</p>
     * 
     * <p>Relationship: PORX_MT060170CA.PatientName.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used to confirm the identity of the patient for the query 
     * and is therefore mandatory.</p>
     * 
     * <p>The name by which the patient is known.</p>
     */
    @Hl7XmlMapping({"patientName/value"})
    public PersonName getPatientNameValue() {
        return this.patientNameValue.getValue();
    }

    /**
     * <p>Business Name: C:Patient Name</p>
     * 
     * <p>Relationship: PORX_MT060170CA.PatientName.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used to confirm the identity of the patient for the query 
     * and is therefore mandatory.</p>
     * 
     * <p>The name by which the patient is known.</p>
     */
    public void setPatientNameValue(PersonName patientNameValue) {
        this.patientNameValue.setValue(patientNameValue);
    }


    /**
     * <p>Business Name: Symptom Code</p>
     * 
     * <p>Relationship: PORX_MT060170CA.SymptomCode.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the retrieval of patient's prescriptions 
     * and/or dispenses based on prescribing indications.</p>
     * 
     * <p>Indicates that the result set is to be filtered to 
     * include only those records pertaining to the specified 
     * symptom indication code.</p>
     */
    @Hl7XmlMapping({"symptomCode/value"})
    public SymptomValue getSymptomCodeValue() {
        return (SymptomValue) this.symptomCodeValue.getValue();
    }

    /**
     * <p>Business Name: Symptom Code</p>
     * 
     * <p>Relationship: PORX_MT060170CA.SymptomCode.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the retrieval of patient's prescriptions 
     * and/or dispenses based on prescribing indications.</p>
     * 
     * <p>Indicates that the result set is to be filtered to 
     * include only those records pertaining to the specified 
     * symptom indication code.</p>
     */
    public void setSymptomCodeValue(SymptomValue symptomCodeValue) {
        this.symptomCodeValue.setValue(symptomCodeValue);
    }

}
