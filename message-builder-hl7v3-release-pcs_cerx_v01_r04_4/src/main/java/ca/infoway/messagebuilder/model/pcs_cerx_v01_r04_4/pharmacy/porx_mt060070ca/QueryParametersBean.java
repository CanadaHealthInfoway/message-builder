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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_4.pharmacy.porx_mt060070ca;

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
import ca.infoway.messagebuilder.datatype.impl.RawListWrapper;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.IssueFilterCode;
import ca.infoway.messagebuilder.domainvalue.PrescriptionDispenseFilterCode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Business Name: Query Parameters</p>
 * 
 * <p>Root class for query definition</p>
 * 
 * <p>Defines the set of parameters that may be used to filter 
 * the query response.</p>
 */
@Hl7PartTypeMapping({"PORX_MT060070CA.ParameterList"})
@Hl7RootType
public class QueryParametersBean extends MessagePartBean {

    private static final long serialVersionUID = 20150904L;
    private IVL<TS, Interval<Date>> amendedInTimeRangeValue = new IVLImpl<TS, Interval<Date>>();
    private CV issueFilterCodeValue = new CVImpl();
    private BL mostRecentByDeviceIndicatorValue = new BLImpl();
    private TS patientBirthDateValue = new TSImpl();
    private CV patientGenderValue = new CVImpl();
    private II patientIDValue = new IIImpl();
    private PN patientNameValue = new PNImpl();
    private List<CV> rxDispenseIndicatorValue = new ArrayList<CV>();
    private IVL<TS, Interval<Date>> usageEffectivePeriodValue = new IVLImpl<TS, Interval<Date>>();


    /**
     * <p>Business Name: Amended in Time Range</p>
     * 
     * <p>Relationship: PORX_MT060070CA.AmendedInTimeRange.value</p>
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
     * <p>Business Name: Amended in Time Range</p>
     * 
     * <p>Relationship: PORX_MT060070CA.AmendedInTimeRange.value</p>
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
     * <p>Business Name: Issue Filter Code</p>
     * 
     * <p>Relationship: PORX_MT060070CA.IssueFilterCode.value</p>
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
     * <p>Relationship: PORX_MT060070CA.IssueFilterCode.value</p>
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
     * <p>Business Name: Most Recent By Device Indicator</p>
     * 
     * <p>Relationship: 
     * PORX_MT060070CA.MostRecentByDeviceIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Helps decrease the volume of records returned, while 
     * still maintaining information on all devices that the 
     * patient is using.</p><p>Because this is a boolean attribute 
     * whose value must be known to evaluate the query, the 
     * attribute is mandatory.</p>
     * 
     * <p>Indicates whether or not the records are to be retrieved 
     * based on the most recent by Device Code. If true, only the 
     * most recent prescription or dispense for a particular device 
     * type will be returned. The default is 'FALSE' indicating 
     * that retrieval of prescription or dispense records should 
     * not be limited to one per device type.</p>
     */
    @Hl7XmlMapping({"mostRecentByDeviceIndicator/value"})
    public Boolean getMostRecentByDeviceIndicatorValue() {
        return this.mostRecentByDeviceIndicatorValue.getValue();
    }

    /**
     * <p>Business Name: Most Recent By Device Indicator</p>
     * 
     * <p>Relationship: 
     * PORX_MT060070CA.MostRecentByDeviceIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Helps decrease the volume of records returned, while 
     * still maintaining information on all devices that the 
     * patient is using.</p><p>Because this is a boolean attribute 
     * whose value must be known to evaluate the query, the 
     * attribute is mandatory.</p>
     * 
     * <p>Indicates whether or not the records are to be retrieved 
     * based on the most recent by Device Code. If true, only the 
     * most recent prescription or dispense for a particular device 
     * type will be returned. The default is 'FALSE' indicating 
     * that retrieval of prescription or dispense records should 
     * not be limited to one per device type.</p>
     */
    public void setMostRecentByDeviceIndicatorValue(Boolean mostRecentByDeviceIndicatorValue) {
        this.mostRecentByDeviceIndicatorValue.setValue(mostRecentByDeviceIndicatorValue);
    }


    /**
     * <p>Business Name: Patient Birth Date</p>
     * 
     * <p>Relationship: PORX_MT060070CA.PatientBirthDate.value</p>
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
     * <p>Relationship: PORX_MT060070CA.PatientBirthDate.value</p>
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
     * <p>Relationship: PORX_MT060070CA.PatientGender.value</p>
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
     * <p>Relationship: PORX_MT060070CA.PatientGender.value</p>
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
     * <p>Relationship: PORX_MT060070CA.PatientID.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows filtering of result set by patient Id. This is a 
     * mandatory field because a patient must be specified for the 
     * query to be valid</p>
     * 
     * <p>Identifier of the patient who is the subject of the 
     * query. Filter the result set to include only those records 
     * pertaining to the patient with this Id.</p>
     */
    @Hl7XmlMapping({"patientID/value"})
    public Identifier getPatientIDValue() {
        return this.patientIDValue.getValue();
    }

    /**
     * <p>Business Name: B:Patient ID</p>
     * 
     * <p>Relationship: PORX_MT060070CA.PatientID.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows filtering of result set by patient Id. This is a 
     * mandatory field because a patient must be specified for the 
     * query to be valid</p>
     * 
     * <p>Identifier of the patient who is the subject of the 
     * query. Filter the result set to include only those records 
     * pertaining to the patient with this Id.</p>
     */
    public void setPatientIDValue(Identifier patientIDValue) {
        this.patientIDValue.setValue(patientIDValue);
    }


    /**
     * <p>Business Name: C:Patient Name</p>
     * 
     * <p>Relationship: PORX_MT060070CA.PatientName.value</p>
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
     * <p>Relationship: PORX_MT060070CA.PatientName.value</p>
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
     * <p>Business Name: Rx Dispenser Indicators</p>
     * 
     * <p>Relationship: PORX_MT060070CA.RxDispenseIndicator.value</p>
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
     * <p>Business Name: Usage Effective Period</p>
     * 
     * <p>Relationship: PORX_MT060070CA.UsageEffectivePeriod.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the requester to specify the usage period of 
     * interest for the retrieval. Useful for constraining run-away 
     * queries.</p>
     * 
     * <p>Indicates the usage period for which the request/query 
     * applies.</p><p>Filter the result set to include only those 
     * device records (device order and device dispense) for which 
     * the patient was deemed to be using the device within the 
     * specified period.</p>
     */
    @Hl7XmlMapping({"usageEffectivePeriod/value"})
    public Interval<Date> getUsageEffectivePeriodValue() {
        return this.usageEffectivePeriodValue.getValue();
    }

    /**
     * <p>Business Name: Usage Effective Period</p>
     * 
     * <p>Relationship: PORX_MT060070CA.UsageEffectivePeriod.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the requester to specify the usage period of 
     * interest for the retrieval. Useful for constraining run-away 
     * queries.</p>
     * 
     * <p>Indicates the usage period for which the request/query 
     * applies.</p><p>Filter the result set to include only those 
     * device records (device order and device dispense) for which 
     * the patient was deemed to be using the device within the 
     * specified period.</p>
     */
    public void setUsageEffectivePeriodValue(Interval<Date> usageEffectivePeriodValue) {
        this.usageEffectivePeriodValue.setValue(usageEffectivePeriodValue);
    }

}
