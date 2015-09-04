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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.pharmacy.porx_mt060240ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.RawListWrapper;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.PrescriptionDispenseFilterCode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Business Name: Unfilled Prescription Query Parameters</p>
 * 
 * <p>Defines the set of parameters that may be used to filter 
 * the query response.</p>
 * 
 * <p>Root class for query definition</p>
 */
@Hl7PartTypeMapping({"PORX_MT060240CA.ParameterList"})
@Hl7RootType
public class UnfilledPrescriptionQueryParametersBean extends MessagePartBean {

    private static final long serialVersionUID = 20150902L;
    private IVL<TS, Interval<Date>> administrationEffectivePeriodValue = new IVLImpl<TS, Interval<Date>>();
    private TS patientBirthDateValue = new TSImpl();
    private CV patientGenderValue = new CVImpl();
    private II patientIDValue = new IIImpl();
    private PN patientNameValue = new PNImpl();
    private List<CV> prescriptionStatusValue = new ArrayList<CV>();
    private CV rxDispenseIndicatorValue = new CVImpl();


    /**
     * <p>Business Name: D:Administration Effective Period</p>
     * 
     * <p>Relationship: 
     * PORX_MT060240CA.AdministrationEffectivePeriod.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the administration period for which the 
     * request/query applies.</p><p>Filter the result set to 
     * include only those medication records (prescription order, 
     * prescription dispense and other active medication) for which 
     * the patient was deemed to be taking the drug within the 
     * specified period.</p>
     * 
     * <p>Indicates the administration period for which the 
     * request/query applies.</p><p>Filter the result set to 
     * include only those medication records (prescription order, 
     * prescription dispense and other active medication) for which 
     * the patient was deemed to be taking the drug within the 
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
     * <p>Business Name: D:Administration Effective Period</p>
     * 
     * <p>Relationship: 
     * PORX_MT060240CA.AdministrationEffectivePeriod.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the administration period for which the 
     * request/query applies.</p><p>Filter the result set to 
     * include only those medication records (prescription order, 
     * prescription dispense and other active medication) for which 
     * the patient was deemed to be taking the drug within the 
     * specified period.</p>
     * 
     * <p>Indicates the administration period for which the 
     * request/query applies.</p><p>Filter the result set to 
     * include only those medication records (prescription order, 
     * prescription dispense and other active medication) for which 
     * the patient was deemed to be taking the drug within the 
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
     * <p>Business Name: Patient Birth Date</p>
     * 
     * <p>Relationship: PORX_MT060240CA.PatientBirthDate.value</p>
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
     * <p>Relationship: PORX_MT060240CA.PatientBirthDate.value</p>
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
     * <p>Relationship: PORX_MT060240CA.PatientGender.value</p>
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
     * <p>Relationship: PORX_MT060240CA.PatientGender.value</p>
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
     * <p>Relationship: PORX_MT060240CA.PatientID.value</p>
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
     * <p>Relationship: PORX_MT060240CA.PatientID.value</p>
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
     * <p>Relationship: PORX_MT060240CA.PatientName.value</p>
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
     * <p>Relationship: PORX_MT060240CA.PatientName.value</p>
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


    /**
     * <p>Business Name: E:Prescription Statuses</p>
     * 
     * <p>Relationship: PORX_MT060240CA.PrescriptionStatus.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates that prescriptions of a specific statuses are 
     * to be included in the result set. Allowable prescription 
     * status codes are: 'ABORTED, ACTIVE', 'COMPLETED', and 
     * 'SUSPENDED'.</p>
     * 
     * <p>Allows for the retrieval of patient prescriptions and 
     * dispenses based on the lifecycle state of the 
     * prescription.</p>
     */
    @Hl7XmlMapping({"prescriptionStatus/value"})
    public List<ActStatus> getPrescriptionStatusValue() {
        return new RawListWrapper<CV, ActStatus>(prescriptionStatusValue, CVImpl.class);
    }


    /**
     * <p>Business Name: Rx Dispense Indicator</p>
     * 
     * <p>Relationship: PORX_MT060240CA.RxDispenseIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>A coded value indicating the dispensing (fill) status of 
     * the prescription to be included in the result set. The only 
     * allowable Rx Dispense Indicators is ND (Never 
     * Dispensed).</p>
     * 
     * <p>Allows for finer sub-set of prescriptions to be retrieved 
     * based on the fill status of the prescription.</p>
     */
    @Hl7XmlMapping({"rxDispenseIndicator/value"})
    public PrescriptionDispenseFilterCode getRxDispenseIndicatorValue() {
        return (PrescriptionDispenseFilterCode) this.rxDispenseIndicatorValue.getValue();
    }

    /**
     * <p>Business Name: Rx Dispense Indicator</p>
     * 
     * <p>Relationship: PORX_MT060240CA.RxDispenseIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>A coded value indicating the dispensing (fill) status of 
     * the prescription to be included in the result set. The only 
     * allowable Rx Dispense Indicators is ND (Never 
     * Dispensed).</p>
     * 
     * <p>Allows for finer sub-set of prescriptions to be retrieved 
     * based on the fill status of the prescription.</p>
     */
    public void setRxDispenseIndicatorValue(PrescriptionDispenseFilterCode rxDispenseIndicatorValue) {
        this.rxDispenseIndicatorValue.setValue(rxDispenseIndicatorValue);
    }

}
