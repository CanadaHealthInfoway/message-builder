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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pharmacy.porx_mt060240ca;

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
 * <p>Unfilled Prescription Query Parameters</p>
 * 
 * <p><p>Defines the set of parameters that may be used to 
 * filter the query response.</p></p>
 * 
 * <p><p>Root class for query definition</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT060240CA.ParameterList"})
@Hl7RootType
public class UnfilledPrescriptionQueryParametersBean extends MessagePartBean {

    private static final long serialVersionUID = 20120320L;
    private IVL<TS, Interval<Date>> administrationEffectivePeriodValue = new IVLImpl<TS, Interval<Date>>();
    private TS patientBirthDateValue = new TSImpl();
    private CV patientGenderValue = new CVImpl();
    private II patientIDValue = new IIImpl();
    private PN patientNameValue = new PNImpl();
    private List<CV> prescriptionStatusValue = new ArrayList<CV>();
    private CV rxDispenseIndicatorValue = new CVImpl();


    /**
     * <p>D:Administration Effective Period</p>
     * 
     * <p><p>Indicates the administration period for which the 
     * request/query applies.</p><p>Filter the result set to 
     * include only those medication records (prescription order, 
     * prescription dispense and other active medication) for which 
     * the patient was deemed to be taking the drug within the 
     * specified period.</p></p>
     * 
     * <p><p>Indicates the administration period for which the 
     * request/query applies.</p><p>Filter the result set to 
     * include only those medication records (prescription order, 
     * prescription dispense and other active medication) for which 
     * the patient was deemed to be taking the drug within the 
     * specified period.</p></p>
     * 
     * <p><p>Allows the requester to specify the administration 
     * period of interest for the retrieval. Useful for 
     * constraining run-away queries.</p></p>
     */
    @Hl7XmlMapping({"administrationEffectivePeriod/value"})
    public Interval<Date> getAdministrationEffectivePeriodValue() {
        return this.administrationEffectivePeriodValue.getValue();
    }
    public void setAdministrationEffectivePeriodValue(Interval<Date> administrationEffectivePeriodValue) {
        this.administrationEffectivePeriodValue.setValue(administrationEffectivePeriodValue);
    }


    /**
     * <p>Patient Birth Date</p>
     * 
     * <p><p>Indicates the date on which the patient was born.</p></p>
     * 
     * <p><p>Used to confirm the identity of the patient for the 
     * query and is therefore mandatory.</p></p>
     */
    @Hl7XmlMapping({"patientBirthDate/value"})
    public Date getPatientBirthDateValue() {
        return this.patientBirthDateValue.getValue();
    }
    public void setPatientBirthDateValue(Date patientBirthDateValue) {
        this.patientBirthDateValue.setValue(patientBirthDateValue);
    }


    /**
     * <p>Patient Gender</p>
     * 
     * <p><p>Indicates the gender (sex) of the patient.</p></p>
     * 
     * <p><p>Used to confirm the identity of the patient for the 
     * query and is therefore mandatory.</p></p>
     */
    @Hl7XmlMapping({"patientGender/value"})
    public AdministrativeGender getPatientGenderValue() {
        return (AdministrativeGender) this.patientGenderValue.getValue();
    }
    public void setPatientGenderValue(AdministrativeGender patientGenderValue) {
        this.patientGenderValue.setValue(patientGenderValue);
    }


    /**
     * <p>B:Patient ID</p>
     * 
     * <p><p>Identifier of the patient who is the subject of the 
     * patient medication query. Filter the result set to include 
     * only those records pertaining to the patient with this 
     * Id.</p></p>
     * 
     * <p><p>Allows filtering of result set by patient Id. This is 
     * a mandatory field because a patient must be specified for 
     * the query to be valid</p></p>
     */
    @Hl7XmlMapping({"patientID/value"})
    public Identifier getPatientIDValue() {
        return this.patientIDValue.getValue();
    }
    public void setPatientIDValue(Identifier patientIDValue) {
        this.patientIDValue.setValue(patientIDValue);
    }


    /**
     * <p>C:Patient Name</p>
     * 
     * <p><p>The name of the patient who is the subject of the 
     * patient medication query.</p><p>Filter the result set to 
     * include only those records pertaining to the patient with 
     * this name.</p></p>
     * 
     * <p><p>The name of the patient who is the subject of the 
     * patient medication query.</p><p>Filter the result set to 
     * include only those records pertaining to the patient with 
     * this name.</p></p>
     * 
     * <p><p>Allows filtering of result set by patient name. This 
     * is a mandatory field because a patient name must match the 
     * patient Id for the query to be valid.</p></p>
     */
    @Hl7XmlMapping({"patientName/value"})
    public PersonName getPatientNameValue() {
        return this.patientNameValue.getValue();
    }
    public void setPatientNameValue(PersonName patientNameValue) {
        this.patientNameValue.setValue(patientNameValue);
    }


    /**
     * <p>E:Prescription Statuses</p>
     * 
     * <p><p>Indicates that prescriptions of a specific statuses 
     * are to be included in the result set. Allowable prescription 
     * status codes are: 'ABORTED, ACTIVE', 'COMPLETED', and 
     * 'SUSPENDED'.</p></p>
     * 
     * <p><p>Allows for the retrieval of patient prescriptions and 
     * dispenses based on the lifecycle state of the 
     * prescription.</p></p>
     */
    @Hl7XmlMapping({"prescriptionStatus/value"})
    public List<ActStatus> getPrescriptionStatusValue() {
        return new RawListWrapper<CV, ActStatus>(prescriptionStatusValue, CVImpl.class);
    }


    /**
     * <p>Rx Dispense Indicator</p>
     * 
     * <p><p>A coded value indicating the dispensing (fill) status 
     * of the prescription to be included in the result set. The 
     * only allowable Rx Dispense Indicators is ND (Never 
     * Dispensed).</p></p>
     * 
     * <p><p>Allows for finer sub-set of prescriptions to be 
     * retrieved based on the fill status of the prescription.</p></p>
     */
    @Hl7XmlMapping({"rxDispenseIndicator/value"})
    public PrescriptionDispenseFilterCode getRxDispenseIndicatorValue() {
        return (PrescriptionDispenseFilterCode) this.rxDispenseIndicatorValue.getValue();
    }
    public void setRxDispenseIndicatorValue(PrescriptionDispenseFilterCode rxDispenseIndicatorValue) {
        this.rxDispenseIndicatorValue.setValue(rxDispenseIndicatorValue);
    }

}
