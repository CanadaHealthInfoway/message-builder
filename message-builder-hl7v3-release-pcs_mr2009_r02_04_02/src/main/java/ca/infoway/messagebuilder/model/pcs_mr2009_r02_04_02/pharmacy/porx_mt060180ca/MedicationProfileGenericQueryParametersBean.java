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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pharmacy.porx_mt060180ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.RawListWrapper;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActCareEventType;
import ca.infoway.messagebuilder.domainvalue.ActNonConditionIndicationCode;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.ActTherapyDurationWorkingListCode;
import ca.infoway.messagebuilder.domainvalue.ClinicalDrug;
import ca.infoway.messagebuilder.domainvalue.DiagnosisValue;
import ca.infoway.messagebuilder.domainvalue.IssueFilterCode;
import ca.infoway.messagebuilder.domainvalue.PrescriptionDispenseFilterCode;
import ca.infoway.messagebuilder.domainvalue.SymptomValue;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Business Name: Medication Profile Generic Query 
 * Parameters</p>
 * 
 * <p>Root class for query definition</p>
 * 
 * <p>Defines the set of parameters that may be used to filter 
 * the query response.</p>
 */
@Hl7PartTypeMapping({"PORX_MT060180CA.ParameterList"})
@Hl7RootType
public class MedicationProfileGenericQueryParametersBean extends MessagePartBean {

    private static final long serialVersionUID = 20150902L;
    private IVL<TS, Interval<Date>> administrationEffectivePeriodValue = new IVLImpl<TS, Interval<Date>>();
    private IVL<TS, Interval<Date>> amendedInTimeRangeValue = new IVLImpl<TS, Interval<Date>>();
    private List<II> careCompositionIDValue = new ArrayList<II>();
    private List<CV> careCompositionTypeValue = new ArrayList<CV>();
    private CV diagnosisCodeValue = new CVImpl();
    private CV drugCodeValue = new CVImpl();
    private BL includeEventHistoryIndicatorValue = new BLImpl();
    private BL includeIssuesIndicatorValue = new BLImpl();
    private BL includeNotesIndicatorValue = new BLImpl();
    private BL includePendingChangesIndicatorValue = new BLImpl();
    private CV issueFilterCodeValue = new CVImpl();
    private BL mostRecentByDrugIndicatorValue = new BLImpl();
    private BL mostRecentDispenseForEachRxIndicatorValue = new BLImpl();
    private CV otherIndicationCodeValue = new CVImpl();
    private II otherMedicationRecordIdValue = new IIImpl();
    private II prescriberProviderIDValue = new IIImpl();
    private II prescriptionDispenseNumberValue = new IIImpl();
    private II prescriptionOrderNumberValue = new IIImpl();
    private List<CV> prescriptionStatusValue = new ArrayList<CV>();
    private List<CV> rxDispenseIndicatorValue = new ArrayList<CV>();
    private CV symptomCodeValue = new CVImpl();
    private List<CV> treatmentTypeValue = new ArrayList<CV>();


    /**
     * <p>Business Name: Administration Effective Period</p>
     * 
     * <p>Relationship: 
     * PORX_MT060180CA.AdministrationEffectivePeriod.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the requester to specify the administration period 
     * of interest for the retrieval. Useful for constraining 
     * run-away queries.</p>
     * 
     * <p>The determination for applicability for inclusion in the 
     * query response should be considered to be the 'Pick up date 
     * plus the days supply'</p>
     * 
     * <p>Indicates the administration period for which the 
     * request/query applies.</p><p>Filter the result set to 
     * include only those medication records (prescription order, 
     * prescription dispense and other active medication) for which 
     * the patient was deemed to be taking the drug within the 
     * specified period.</p>
     */
    @Hl7XmlMapping({"administrationEffectivePeriod/value"})
    public Interval<Date> getAdministrationEffectivePeriodValue() {
        return this.administrationEffectivePeriodValue.getValue();
    }

    /**
     * <p>Business Name: Administration Effective Period</p>
     * 
     * <p>Relationship: 
     * PORX_MT060180CA.AdministrationEffectivePeriod.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the requester to specify the administration period 
     * of interest for the retrieval. Useful for constraining 
     * run-away queries.</p>
     * 
     * <p>The determination for applicability for inclusion in the 
     * query response should be considered to be the 'Pick up date 
     * plus the days supply'</p>
     * 
     * <p>Indicates the administration period for which the 
     * request/query applies.</p><p>Filter the result set to 
     * include only those medication records (prescription order, 
     * prescription dispense and other active medication) for which 
     * the patient was deemed to be taking the drug within the 
     * specified period.</p>
     */
    public void setAdministrationEffectivePeriodValue(Interval<Date> administrationEffectivePeriodValue) {
        this.administrationEffectivePeriodValue.setValue(administrationEffectivePeriodValue);
    }


    /**
     * <p>Business Name: Amended in Time Range</p>
     * 
     * <p>Relationship: PORX_MT060180CA.AmendedInTimeRange.value</p>
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
     * be used to '''retrieve everything that has been amended 
     * since xxx'''.</p>
     */
    @Hl7XmlMapping({"amendedInTimeRange/value"})
    public Interval<Date> getAmendedInTimeRangeValue() {
        return this.amendedInTimeRangeValue.getValue();
    }

    /**
     * <p>Business Name: Amended in Time Range</p>
     * 
     * <p>Relationship: PORX_MT060180CA.AmendedInTimeRange.value</p>
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
     * be used to '''retrieve everything that has been amended 
     * since xxx'''.</p>
     */
    public void setAmendedInTimeRangeValue(Interval<Date> amendedInTimeRangeValue) {
        this.amendedInTimeRangeValue.setValue(amendedInTimeRangeValue);
    }


    /**
     * <p>Business Name: Care Composition IDs</p>
     * 
     * <p>Relationship: PORX_MT060180CA.CareCompositionID.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows retrieving all records associated with an 
     * encounter, episode or care event.</p>
     * 
     * <p>Filters the records retrieved to only include those 
     * associated with the specified encounter, episode or care 
     * event. If unspecified, no filter is applied.</p><p>Note: 
     * When matching on care composition id, systems should also 
     * retrieve records with a fulfillment id to requisitions 
     * associated with the care composition. E.g. When retrieving 
     * records associated with an encounter which includes a 
     * referral, the retrieved records should also include the care 
     * summary created in fulfillment of the referral.</p>
     */
    @Hl7XmlMapping({"careCompositionID/value"})
    public List<Identifier> getCareCompositionIDValue() {
        return new RawListWrapper<II, Identifier>(careCompositionIDValue, IIImpl.class);
    }


    /**
     * <p>Business Name: Care Composition Types</p>
     * 
     * <p>Relationship: PORX_MT060180CA.CareCompositionType.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows retrieving all records associated with a 
     * particular type of encounter, episode or care event. 
     * E.g.Orthopedic Clinic Encounter, ER encounter, Walk-in 
     * encounter, etc.</p>
     * 
     * <p>Filters the records retrieved to only include those 
     * associated with the specified 'kind' of encounter, episode 
     * or care event. If unspecified, no filter is applied.</p>
     */
    @Hl7XmlMapping({"careCompositionType/value"})
    public List<ActCareEventType> getCareCompositionTypeValue() {
        return new RawListWrapper<CV, ActCareEventType>(careCompositionTypeValue, CVImpl.class);
    }


    /**
     * <p>Business Name: Diagnosis Code</p>
     * 
     * <p>Relationship: PORX_MT060180CA.DiagnosisCode.value</p>
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
     * <p>Relationship: PORX_MT060180CA.DiagnosisCode.value</p>
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
     * <p>Relationship: PORX_MT060180CA.DrugCode.value</p>
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
     * <p>Relationship: PORX_MT060180CA.DrugCode.value</p>
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
     * PORX_MT060180CA.IncludeEventHistoryIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the flexibility of omitting/including history 
     * in the retrieval of the requested information.</p><p>Because 
     * the attribute is boolean, it must explicitly indicate a 
     * 'TRUE' or 'FALSE', and thus it is mandatory.</p>
     * 
     * <p>Indicates whether or not history events associated with a 
     * prescription order, prescription dispense and/or other 
     * active medications are to be returned along with the 
     * detailed information.</p><p>&quot;Pending&quot; changes will 
     * be returned regardless of the setting of this flag.</p>
     */
    @Hl7XmlMapping({"includeEventHistoryIndicator/value"})
    public Boolean getIncludeEventHistoryIndicatorValue() {
        return this.includeEventHistoryIndicatorValue.getValue();
    }

    /**
     * <p>Business Name: Include Event History Indicator</p>
     * 
     * <p>Relationship: 
     * PORX_MT060180CA.IncludeEventHistoryIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the flexibility of omitting/including history 
     * in the retrieval of the requested information.</p><p>Because 
     * the attribute is boolean, it must explicitly indicate a 
     * 'TRUE' or 'FALSE', and thus it is mandatory.</p>
     * 
     * <p>Indicates whether or not history events associated with a 
     * prescription order, prescription dispense and/or other 
     * active medications are to be returned along with the 
     * detailed information.</p><p>&quot;Pending&quot; changes will 
     * be returned regardless of the setting of this flag.</p>
     */
    public void setIncludeEventHistoryIndicatorValue(Boolean includeEventHistoryIndicatorValue) {
        this.includeEventHistoryIndicatorValue.setValue(includeEventHistoryIndicatorValue);
    }


    /**
     * <p>Business Name: Include Issues Indicator</p>
     * 
     * <p>Relationship: 
     * PORX_MT060180CA.IncludeIssuesIndicator.value</p>
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
     * PORX_MT060180CA.IncludeIssuesIndicator.value</p>
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
     * <p>Relationship: PORX_MT060180CA.IncludeNotesIndicator.value</p>
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
     * <p>Relationship: PORX_MT060180CA.IncludeNotesIndicator.value</p>
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
     * PORX_MT060180CA.IncludePendingChangesIndicator.value</p>
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
     * PORX_MT060180CA.IncludePendingChangesIndicator.value</p>
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
     * <p>Business Name: Issue Filter Code</p>
     * 
     * <p>Relationship: PORX_MT060180CA.IssueFilterCode.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>By filtering returned records to include only those which 
     * have unmanaged issues or any issues at all, allows a 
     * provider to focus on those aspects of care where extra 
     * attention is needed. Because the attribute must be known, it 
     * is mandatory.</p>
     * 
     * <p>Indicates whether records to be returned (e.g. 
     * prescription order, prescription dispense and/or other 
     * medication) should be filtered to those with at least one 
     * persistent un-managed issue (against the record), with at 
     * least one persistent issues or should return all records, 
     * independent of the presence of persistent issues.</p>
     */
    @Hl7XmlMapping({"issueFilterCode/value"})
    public IssueFilterCode getIssueFilterCodeValue() {
        return (IssueFilterCode) this.issueFilterCodeValue.getValue();
    }

    /**
     * <p>Business Name: Issue Filter Code</p>
     * 
     * <p>Relationship: PORX_MT060180CA.IssueFilterCode.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>By filtering returned records to include only those which 
     * have unmanaged issues or any issues at all, allows a 
     * provider to focus on those aspects of care where extra 
     * attention is needed. Because the attribute must be known, it 
     * is mandatory.</p>
     * 
     * <p>Indicates whether records to be returned (e.g. 
     * prescription order, prescription dispense and/or other 
     * medication) should be filtered to those with at least one 
     * persistent un-managed issue (against the record), with at 
     * least one persistent issues or should return all records, 
     * independent of the presence of persistent issues.</p>
     */
    public void setIssueFilterCodeValue(IssueFilterCode issueFilterCodeValue) {
        this.issueFilterCodeValue.setValue(issueFilterCodeValue);
    }


    /**
     * <p>Business Name: Most Recent By Drug Indicator</p>
     * 
     * <p>Relationship: 
     * PORX_MT060180CA.MostRecentByDrugIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Helps decrease the volume of records returned, while 
     * still maintaining information on all drugs that the patient 
     * is on.</p><p>Because this is a boolean attribute whose value 
     * must be known to evaluate the query, the attribute is 
     * mandatory.</p>
     * 
     * <p>Indicates whether or not the medication records are to be 
     * retrieved based on the most recent by Drug Code. If true, 
     * only the most recent prescription, dispense or other active 
     * medication for a particular drug generic classification will 
     * be returned. The default is 'FALSE' indicating that 
     * retrieval of prescription, dispense and other active 
     * medication records should not be limited to one per 
     * drug.</p>
     */
    @Hl7XmlMapping({"mostRecentByDrugIndicator/value"})
    public Boolean getMostRecentByDrugIndicatorValue() {
        return this.mostRecentByDrugIndicatorValue.getValue();
    }

    /**
     * <p>Business Name: Most Recent By Drug Indicator</p>
     * 
     * <p>Relationship: 
     * PORX_MT060180CA.MostRecentByDrugIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Helps decrease the volume of records returned, while 
     * still maintaining information on all drugs that the patient 
     * is on.</p><p>Because this is a boolean attribute whose value 
     * must be known to evaluate the query, the attribute is 
     * mandatory.</p>
     * 
     * <p>Indicates whether or not the medication records are to be 
     * retrieved based on the most recent by Drug Code. If true, 
     * only the most recent prescription, dispense or other active 
     * medication for a particular drug generic classification will 
     * be returned. The default is 'FALSE' indicating that 
     * retrieval of prescription, dispense and other active 
     * medication records should not be limited to one per 
     * drug.</p>
     */
    public void setMostRecentByDrugIndicatorValue(Boolean mostRecentByDrugIndicatorValue) {
        this.mostRecentByDrugIndicatorValue.setValue(mostRecentByDrugIndicatorValue);
    }


    /**
     * <p>Business Name: Most Recent Dispense for each Rx Indicator</p>
     * 
     * <p>Relationship: 
     * PORX_MT060180CA.MostRecentDispenseForEachRxIndicator.value</p>
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
     * PORX_MT060180CA.MostRecentDispenseForEachRxIndicator.value</p>
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
     * <p>Relationship: PORX_MT060180CA.OtherIndicationCode.value</p>
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
     * <p>Relationship: PORX_MT060180CA.OtherIndicationCode.value</p>
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
     * <p>Business Name: E:Other Medication Record Id</p>
     * 
     * <p>Relationship: 
     * PORX_MT060180CA.OtherMedicationRecordId.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the retrieval of medication records based on a 
     * specific active medication record.</p>
     * 
     * <p>Identifier of the other active medication record for 
     * which detailed information is to be retrieved.</p>
     */
    @Hl7XmlMapping({"otherMedicationRecordId/value"})
    public Identifier getOtherMedicationRecordIdValue() {
        return this.otherMedicationRecordIdValue.getValue();
    }

    /**
     * <p>Business Name: E:Other Medication Record Id</p>
     * 
     * <p>Relationship: 
     * PORX_MT060180CA.OtherMedicationRecordId.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the retrieval of medication records based on a 
     * specific active medication record.</p>
     * 
     * <p>Identifier of the other active medication record for 
     * which detailed information is to be retrieved.</p>
     */
    public void setOtherMedicationRecordIdValue(Identifier otherMedicationRecordIdValue) {
        this.otherMedicationRecordIdValue.setValue(otherMedicationRecordIdValue);
    }


    /**
     * <p>Business Name: Prescriber Provider ID</p>
     * 
     * <p>Relationship: PORX_MT060180CA.PrescriberProviderID.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the retrieval of prescriptions based on the 
     * specific prescribers.</p>
     * 
     * <p>Identifier of the prescriber who created and/or 
     * supervised the prescriptions being retrieved.</p><p>The 
     * result set will be filtered to only include records which 
     * were either directly created by this provider, or were 
     * created 'under the supervision' of this provider.</p>
     */
    @Hl7XmlMapping({"prescriberProviderID/value"})
    public Identifier getPrescriberProviderIDValue() {
        return this.prescriberProviderIDValue.getValue();
    }

    /**
     * <p>Business Name: Prescriber Provider ID</p>
     * 
     * <p>Relationship: PORX_MT060180CA.PrescriberProviderID.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the retrieval of prescriptions based on the 
     * specific prescribers.</p>
     * 
     * <p>Identifier of the prescriber who created and/or 
     * supervised the prescriptions being retrieved.</p><p>The 
     * result set will be filtered to only include records which 
     * were either directly created by this provider, or were 
     * created 'under the supervision' of this provider.</p>
     */
    public void setPrescriberProviderIDValue(Identifier prescriberProviderIDValue) {
        this.prescriberProviderIDValue.setValue(prescriberProviderIDValue);
    }


    /**
     * <p>Business Name: E:Prescription Dispense Number</p>
     * 
     * <p>Relationship: 
     * PORX_MT060180CA.PrescriptionDispenseNumber.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the retrieval of medication records relating 
     * to a specific dispense record.</p>
     * 
     * <p>Identifies which prescription dispense record should be 
     * retrieved.</p>
     */
    @Hl7XmlMapping({"prescriptionDispenseNumber/value"})
    public Identifier getPrescriptionDispenseNumberValue() {
        return this.prescriptionDispenseNumberValue.getValue();
    }

    /**
     * <p>Business Name: E:Prescription Dispense Number</p>
     * 
     * <p>Relationship: 
     * PORX_MT060180CA.PrescriptionDispenseNumber.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the retrieval of medication records relating 
     * to a specific dispense record.</p>
     * 
     * <p>Identifies which prescription dispense record should be 
     * retrieved.</p>
     */
    public void setPrescriptionDispenseNumberValue(Identifier prescriptionDispenseNumberValue) {
        this.prescriptionDispenseNumberValue.setValue(prescriptionDispenseNumberValue);
    }


    /**
     * <p>Business Name: D:Prescription Order Number</p>
     * 
     * <p>Relationship: 
     * PORX_MT060180CA.PrescriptionOrderNumber.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifies the prescription that is to be retrieved.</p>
     * 
     * <p>Identifier of the prescription for which detailed 
     * information is required.</p><p>The result set will be 
     * filtered to only the specific prescription.</p>
     */
    @Hl7XmlMapping({"prescriptionOrderNumber/value"})
    public Identifier getPrescriptionOrderNumberValue() {
        return this.prescriptionOrderNumberValue.getValue();
    }

    /**
     * <p>Business Name: D:Prescription Order Number</p>
     * 
     * <p>Relationship: 
     * PORX_MT060180CA.PrescriptionOrderNumber.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifies the prescription that is to be retrieved.</p>
     * 
     * <p>Identifier of the prescription for which detailed 
     * information is required.</p><p>The result set will be 
     * filtered to only the specific prescription.</p>
     */
    public void setPrescriptionOrderNumberValue(Identifier prescriptionOrderNumberValue) {
        this.prescriptionOrderNumberValue.setValue(prescriptionOrderNumberValue);
    }


    /**
     * <p>Business Name: Prescription Statuses</p>
     * 
     * <p>Relationship: PORX_MT060180CA.PrescriptionStatus.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the retrieval of patient prescriptions and 
     * dispenses based on the lifecycle state of the 
     * prescription.</p>
     * 
     * <p>Indicates that prescriptions of a specific statuses are 
     * to be included in the result set. Specific prescription 
     * statuses are: 'active', completed', 'aborted', 
     * 'suspended'.</p>
     */
    @Hl7XmlMapping({"prescriptionStatus/value"})
    public List<ActStatus> getPrescriptionStatusValue() {
        return new RawListWrapper<CV, ActStatus>(prescriptionStatusValue, CVImpl.class);
    }


    /**
     * <p>Business Name: Rx Dispenser Indicators</p>
     * 
     * <p>Relationship: PORX_MT060180CA.RxDispenseIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for finer sub-set of prescriptions to be retrieved 
     * based on the fill status of the prescription.</p>
     * 
     * <p>A coded value indicating the dispensing (fill) status of 
     * the prescription to be included in the result set. Rx 
     * Dispense Indicators include: ND (Never Dispensed), DRR 
     * (Dispensed with Refills Remaining), etc.</p><p>The 
     * repetition of 3 allows for retrieval based on all three Rx 
     * Dispense Indicators.</p>
     */
    @Hl7XmlMapping({"rxDispenseIndicator/value"})
    public List<PrescriptionDispenseFilterCode> getRxDispenseIndicatorValue() {
        return new RawListWrapper<CV, PrescriptionDispenseFilterCode>(rxDispenseIndicatorValue, CVImpl.class);
    }


    /**
     * <p>Business Name: Symptom Code</p>
     * 
     * <p>Relationship: PORX_MT060180CA.SymptomCode.value</p>
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
     * <p>Relationship: PORX_MT060180CA.SymptomCode.value</p>
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


    /**
     * <p>Business Name: Treatment Types</p>
     * 
     * <p>Relationship: PORX_MT060180CA.TreatmentType.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the retrieval of prescriptions and dispensed 
     * based on the intended treatment type of the prescription. 
     * Repetition of 2 will allow for the result set to be filtered 
     * based on 1 or two treatment types.</p>
     * 
     * <p>Indicates that the result set is to be filtered to only 
     * include those records pertaining to the specified treatment 
     * type (categories). The specific values are 
     * &quot;Continuous/Chronic&quot;, &quot;Short-Term/Acute&quot; 
     * and &quot;As-Needed/PRN&quot;.</p>
     */
    @Hl7XmlMapping({"treatmentType/value"})
    public List<ActTherapyDurationWorkingListCode> getTreatmentTypeValue() {
        return new RawListWrapper<CV, ActTherapyDurationWorkingListCode>(treatmentTypeValue, CVImpl.class);
    }

}
