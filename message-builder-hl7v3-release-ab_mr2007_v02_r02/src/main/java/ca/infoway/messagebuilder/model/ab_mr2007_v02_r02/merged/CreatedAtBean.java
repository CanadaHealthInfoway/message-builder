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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.x_SubstitutionConditionNoneOrUnconditional;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



/**
 * <p>PORX_MT980030CA.Location: *b:dispensed at</p>
 * 
 * <p><p>Indicates the facility where the dispense event was 
 * performed</p></p>
 * 
 * <p><p>A_DetectedMedicationIssue</p></p>
 * 
 * <p><p>Used for contacting the pharmacy or pharmacist 
 * involved in the dispense.</p><p>The association is marked as 
 * populated because it may be masked.</p></p>
 * 
 * <p><p>Used for contacting the pharmacy or pharmacist 
 * involved in the dispense.</p><p>The association is marked as 
 * populated because it may be masked.</p></p>
 * 
 * <p>COMT_MT300003CA.Location: *c:recorded at</p>
 * 
 * <p><p>Indicates the facility/location where the patient note 
 * was recorded.</p></p>
 * 
 * <p><p>Important for performing follow-up and is therefore 
 * mandatory.</p></p>
 * 
 * <p>MCAI_MT700211CA.Location: *a1:created at</p>
 * 
 * <p><p>Indicates the service delivery location where the 
 * event occurred.</p></p>
 * 
 * <p><p>Indicates where paper records may be located, and may 
 * be important to determining authorization.</p><p>The 
 * association is optional because in some jurisdictions this 
 * information will be conveyed as part of the authentication 
 * token.</p></p>
 * 
 * <p><p>Indicates where paper records may be located, and may 
 * be important to determining authorization.</p><p>The 
 * association is optional because in some jurisdictions this 
 * information will be conveyed as part of the authentication 
 * token.</p></p>
 * 
 * <p>PORX_MT060060CA.Location2: *c:targeted to pharmacy</p>
 * 
 * <p><p>Indicates the pharmacy to which the prescription has 
 * been directed or which has currently assumed responsibility 
 * for dispensing the prescription.</p></p>
 * 
 * <p><p>Allows prescriptions to be directed on the request of 
 * the patient or by legal requirement. Also allows indication 
 * of which pharmacy is the current 'custodian' of the 
 * prescription.</p><p>This should always be known or should 
 * have an explicit null flavor of 'NA' (non-assigned) or 'UNK' 
 * (paper prescription). Thus the association is 
 * 'populated'.</p></p>
 * 
 * <p><p>Allows prescriptions to be directed on the request of 
 * the patient or by legal requirement. Also allows indication 
 * of which pharmacy is the current 'custodian' of the 
 * prescription.</p><p>This should always be known or should 
 * have an explicit null flavor of 'NA' (non-assigned) or 'UNK' 
 * (paper prescription). Thus the association is 
 * 'populated'.</p></p>
 * 
 * <p>PORX_MT030040CA.Location2: *c:targeted to pharmacy</p>
 * 
 * <p><p>Indicates the pharmacy to which the prescription has 
 * been directed or which has currently assumed responsibility 
 * for dispensing the prescription.</p></p>
 * 
 * <p><p>Allows prescriptions to be directed on the request of 
 * the patient or by legal requirement. Also allows indication 
 * of which pharmacy is the current 'custodian' of the 
 * prescription.</p><p>This should always be known or should 
 * have an explicit null flavor of 'NA' (non-assigned) or 'UNK' 
 * (paper prescription). Thus the association is 
 * 'populated'.</p></p>
 * 
 * <p><p>Allows prescriptions to be directed on the request of 
 * the patient or by legal requirement. Also allows indication 
 * of which pharmacy is the current 'custodian' of the 
 * prescription.</p><p>This should always be known or should 
 * have an explicit null flavor of 'NA' (non-assigned) or 'UNK' 
 * (paper prescription). Thus the association is 
 * 'populated'.</p></p>
 * 
 * <p>COCT_MT260020CA.Location: *b:dispensed at</p>
 * 
 * <p><p>Indicates the facility where the implicated dispense 
 * event was performed</p></p>
 * 
 * <p><p>A_DetectedMedicationIssue</p></p>
 * 
 * <p><p>Used for contacting the pharmacy or pharmacist 
 * involved in the dispense.</p><p>The association is only 
 * marked as 'populated' because it may be masked.</p></p>
 * 
 * <p><p>Used for contacting the pharmacy or pharmacist 
 * involved in the dispense.</p><p>The association is only 
 * marked as 'populated' because it may be masked.</p></p>
 * 
 * <p>MCAI_MT700231CA.Location: *a1:created at</p>
 * 
 * <p><p>If AuthorizationToken not specified, association is 
 * required. If AuthorizationToken specified, association is 
 * required if authorization does not cover this 
 * participation.</p></p>
 * 
 * <p><p>Indicates the service delivery location where the 
 * event occurred.</p></p>
 * 
 * <p><p>Indicates where paper records may be located, and may 
 * be important to determining authorization.</p><p>The 
 * association is optional because in some jurisdictions this 
 * information will be conveyed as part of the authentication 
 * token.</p></p>
 * 
 * <p><p>Indicates where paper records may be located, and may 
 * be important to determining authorization.</p><p>The 
 * association is optional because in some jurisdictions this 
 * information will be conveyed as part of the authentication 
 * token.</p></p>
 * 
 * <p>PORX_MT060160CA.Location: *d:dispensed from</p>
 * 
 * <p><p>Indicates the facility/location where the dispensing 
 * was performed.</p></p>
 * 
 * <p><p>Important for performing follow-up and therefore 
 * mandatory.</p></p>
 * 
 * <p>REPC_MT000005CA.Location: *i:recorded at</p>
 * 
 * <p><p>Indicates the service delivery location where the 
 * allergy was recorded.</p></p>
 * 
 * <p><p>Indicates where records are likely kept for follow-up. 
 * May also be useful in understanding the context in which the 
 * allergy/intolerance was recorded. The location of entry 
 * should always be known, and is therefore mandatory.</p></p>
 * 
 * <p>PORX_MT010110CA.Location2: *c:targeted to pharmacy</p>
 * 
 * <p><p>Indicates the pharmacy to which the prescription has 
 * been directed or which has currently assumed responsibility 
 * for dispensing the prescription.</p></p>
 * 
 * <p><p>Allows prescriptions to be directed on the request of 
 * the patient or by legal requirement. Also allows indication 
 * of which pharmacy is the current 'custodian' of the 
 * prescription.</p><p>This should always be known or should 
 * have an explicit null flavor of 'NA' (non-assigned) or 'UNK' 
 * (paper prescription). Thus the association is 
 * 'populated'.</p></p>
 * 
 * <p><p>Allows prescriptions to be directed on the request of 
 * the patient or by legal requirement. Also allows indication 
 * of which pharmacy is the current 'custodian' of the 
 * prescription.</p><p>This should always be known or should 
 * have an explicit null flavor of 'NA' (non-assigned) or 'UNK' 
 * (paper prescription). Thus the association is 
 * 'populated'.</p></p>
 * 
 * <p>REPC_MT000006CA.Location: *i:recorded at</p>
 * 
 * <p><p>Indicates the service delivery location where the 
 * adverse reaction was recorded.</p></p>
 * 
 * <p><p>Indicates where records are likely kept for follow-up. 
 * May also be useful in understanding the context in which the 
 * adverse reaction was recorded. The location of entry should 
 * always be known, and is therefore mandatory.</p></p>
 * 
 * <p>PORX_MT060100CA.Location: *dispensed from</p>
 * 
 * <p><p>Identification of the service delivery location where 
 * the medication was dispensed.</p></p>
 * 
 * <p><p>Used for follow-up communication on the dispensed 
 * product, and therefore mandatory.</p></p>
 * 
 * <p>PORX_MT060160CA.Location5: *c:targeted to pharmacy</p>
 * 
 * <p><p>Indicates the pharmacy to which the prescription has 
 * been directed or which has currently assumed responsibility 
 * for dispensing the prescription.</p></p>
 * 
 * <p><p>Prescription.facility</p></p>
 * 
 * <p><p>Allows prescriptions to be directed on the request of 
 * the patient or by legal requirement. Also allows indication 
 * of which pharmacy is the current 'custodian' of the 
 * prescription.</p><p>This should always be known or should 
 * have an explicit null flavor of 'NA' (non-assigned) or 'UNK' 
 * (paper prescription). Thus the association is 
 * 'populated'.</p></p>
 * 
 * <p><p>Allows prescriptions to be directed on the request of 
 * the patient or by legal requirement. Also allows indication 
 * of which pharmacy is the current 'custodian' of the 
 * prescription.</p><p>This should always be known or should 
 * have an explicit null flavor of 'NA' (non-assigned) or 'UNK' 
 * (paper prescription). Thus the association is 
 * 'populated'.</p></p>
 * 
 * <p>PORX_MT060160CA.Location4: *refused at</p>
 * 
 * <p><p>Identifies the location where the refusal occurred</p></p>
 * 
 * <p><p>Allows follow-up and traceability of the 
 * refusal.</p><p>Association is mandatory as the dispensing 
 * facility refusing the fill must be known.</p></p>
 * 
 * <p><p>Allows follow-up and traceability of the 
 * refusal.</p><p>Association is mandatory as the dispensing 
 * facility refusing the fill must be known.</p></p>
 * 
 * <p>PORX_MT060010CA.Location: *d:dispensed from</p>
 * 
 * <p><p>Indicates the facility/location where the dispensing 
 * was performed.</p></p>
 * 
 * <p><p>Important for performing follow-up and therefore 
 * mandatory.</p></p>
 * 
 * <p>PORX_MT060160CA.Location3: *prescribed at</p>
 * 
 * <p><p>Indicates the clinic or facility which originally 
 * issued the prescription.</p></p>
 * 
 * <p><p>Identifies where paper records are likely located for 
 * follow-up. This is marked as 'populated' because it won't 
 * always be known for 'inferred prescriptions.</p></p>
 * 
 * <p>PORX_MT060160CA.Location2: *recorded at</p>
 * 
 * <p><p>Indicates the facility/location where the other active 
 * medication was recorded.</p></p>
 * 
 * <p><p>Important for performing follow-up and is therefore 
 * mandatory.</p></p>
 * 
 * <p>MFMI_MT700711CA.Location: *a1:created at</p>
 * 
 * <p><p>If AuthorizationToken not specified, associa
 * ... [rest of documentation truncated due to excessive length]
 */
@Hl7PartTypeMapping({"COCT_MT260010CA.Location","COCT_MT260020CA.Location","COCT_MT260030CA.Location","COMT_MT300003CA.Location","COMT_MT900001AB.Location","MCAI_MT700210CA.Location","MCAI_MT700211CA.Location","MCAI_MT700212CA.Location","MCAI_MT700221CA.Location","MCAI_MT700230CA.Location","MCAI_MT700231CA.Location","MCAI_MT700232CA.Location","MFMI_MT700711CA.Location","MFMI_MT700751CA.Location","PORX_MT010110CA.Location2","PORX_MT010120CA.Location2","PORX_MT010140CA.Location","PORX_MT030040CA.Location","PORX_MT030040CA.Location2","PORX_MT060010CA.Location","PORX_MT060020CA.Location","PORX_MT060040CA.Location","PORX_MT060040CA.Location2","PORX_MT060040CA.Location3","PORX_MT060040CA.Location4","PORX_MT060060CA.Location2","PORX_MT060090CA.Location","PORX_MT060100CA.Location","PORX_MT060160CA.Location","PORX_MT060160CA.Location2","PORX_MT060160CA.Location3","PORX_MT060160CA.Location4","PORX_MT060160CA.Location5","PORX_MT060190CA.Location2","PORX_MT060190CA.Location3","PORX_MT060190CA.Location4","PORX_MT060210CA.Location2","PORX_MT060340CA.Location","PORX_MT060340CA.Location2","PORX_MT060340CA.Location3","PORX_MT060340CA.Location4","PORX_MT980010CA.Location","PORX_MT980020CA.Location","PORX_MT980030CA.Location","QUQI_MT020000CA.Location","QUQI_MT020002CA.Location","REPC_MT000005CA.Location","REPC_MT000006CA.Location","REPC_MT000009CA.Location"})
public class CreatedAtBean extends MessagePartBean {

    private static final long serialVersionUID = 20120122L;
    private ServiceLocationBean serviceDeliveryLocation;
    private CV substitutionConditionCode = new CVImpl();
    private IVL<TS, Interval<Date>> time = new IVLImpl<TS, Interval<Date>>();


    @Hl7XmlMapping({"serviceDeliveryLocation"})
    public ServiceLocationBean getServiceDeliveryLocation() {
        return this.serviceDeliveryLocation;
    }
    public void setServiceDeliveryLocation(ServiceLocationBean serviceDeliveryLocation) {
        this.serviceDeliveryLocation = serviceDeliveryLocation;
    }


    /**
     * <p>Dispense Facility Not Assignable Indicator</p>
     * 
     * <p><p>Indicates a 'hard' or 'soft' assignment of dispensing 
     * priviledged to the targetted facility.</p><p>'Hard' 
     * assignment (mandated facility) indicates that the 
     * prescription can be dispensed only at that 
     * facility.</p><p>'Soft' assignment (usually as a patient 
     * directive) indicates that the prescription may be dispensed 
     * at facilities other than the targeted facility.</p></p>
     * 
     * <p><p>Indicates a 'hard' or 'soft' assignment of dispensing 
     * priviledged to the targetted facility.</p><p>'Hard' 
     * assignment (mandated facility) indicates that the 
     * prescription can be dispensed only at that 
     * facility.</p><p>'Soft' assignment (usually as a patient 
     * directive) indicates that the prescription may be dispensed 
     * at facilities other than the targeted facility.</p></p>
     * 
     * <p><p>Indicates a 'hard' or 'soft' assignment of dispensing 
     * priviledged to the targetted facility.</p><p>'Hard' 
     * assignment (mandated facility) indicates that the 
     * prescription can be dispensed only at that 
     * facility.</p><p>'Soft' assignment (usually as a patient 
     * directive) indicates that the prescription may be dispensed 
     * at facilities other than the targeted facility.</p></p>
     * 
     * <p><p>Influences whether the prescription may be transferred 
     * to a service delivery location other than the targeted 
     * dispenser.</p></p>
     * 
     * <p>Dispense Facility Not Assignable Indicator</p>
     * 
     * <p><p>Indicates whether a dispenser to whom the prescription 
     * is targeted is a mandated or patient-preferred pharmacy.</p></p>
     * 
     * <p><p>Influences whether the prescription may be transferred 
     * to a service delivery location other than the targeted 
     * dispenser.</p></p>
     * 
     * <p>Assigned Facility Not Reassignable Indicator</p>
     * 
     * <p><p>Indicates whether a dispenser to whom the prescription 
     * is targeted is a mandated or patient-preferred pharmacy.</p></p>
     * 
     * <p><p>Influences whether the prescription may be transferred 
     * to a service delivery location other than the targeted 
     * dispenser.</p></p>
     * 
     * <p>Dispense Facility Not Assignable Indicator</p>
     * 
     * <p><p>Indicates a 'hard' or 'soft' assignment of dispensing 
     * priviledged to the targeted facility.</p><p>'Hard' 
     * assignment (mandated facility) indicates that the 
     * prescription can be dispensed only at that 
     * facility.</p><p>'Soft' assignment (usually as a patient 
     * directive) indicates that the prescription may be dispensed 
     * at facilities other than the targeted facility.</p></p>
     * 
     * <p><p>Indicates a 'hard' or 'soft' assignment of dispensing 
     * priviledged to the targeted facility.</p><p>'Hard' 
     * assignment (mandated facility) indicates that the 
     * prescription can be dispensed only at that 
     * facility.</p><p>'Soft' assignment (usually as a patient 
     * directive) indicates that the prescription may be dispensed 
     * at facilities other than the targeted facility.</p></p>
     * 
     * <p><p>Indicates a 'hard' or 'soft' assignment of dispensing 
     * priviledged to the targeted facility.</p><p>'Hard' 
     * assignment (mandated facility) indicates that the 
     * prescription can be dispensed only at that 
     * facility.</p><p>'Soft' assignment (usually as a patient 
     * directive) indicates that the prescription may be dispensed 
     * at facilities other than the targeted facility.</p></p>
     * 
     * <p><p>Influences whether the prescription may be transferred 
     * to a service delivery location other than the targeted 
     * dispenser.</p></p>
     * 
     * <p>Dispense Facility Not Reassignable</p>
     * 
     * <p><p>Indicates a 'hard' or 'soft' assignment of dispensing 
     * priviledged to the targetted facility.</p><p>'Hard' 
     * assignment (mandated facility) indicates that the 
     * prescription can be dispensed only at that 
     * facility.</p><p>'Soft' assignment (usually as a patient 
     * directive) indicates that the prescription may be dispensed 
     * at facilities other than the targeted facility.</p></p>
     * 
     * <p><p>Indicates a 'hard' or 'soft' assignment of dispensing 
     * priviledged to the targetted facility.</p><p>'Hard' 
     * assignment (mandated facility) indicates that the 
     * prescription can be dispensed only at that 
     * facility.</p><p>'Soft' assignment (usually as a patient 
     * directive) indicates that the prescription may be dispensed 
     * at facilities other than the targeted facility.</p></p>
     * 
     * <p><p>Indicates a 'hard' or 'soft' assignment of dispensing 
     * priviledged to the targetted facility.</p><p>'Hard' 
     * assignment (mandated facility) indicates that the 
     * prescription can be dispensed only at that 
     * facility.</p><p>'Soft' assignment (usually as a patient 
     * directive) indicates that the prescription may be dispensed 
     * at facilities other than the targeted facility.</p></p>
     * 
     * <p><p>Influences whether the prescription may be transferred 
     * to a service delivery location other than the targeted 
     * dispenser.</p></p>
     */
    @Hl7XmlMapping({"substitutionConditionCode"})
    public x_SubstitutionConditionNoneOrUnconditional getSubstitutionConditionCode() {
        return (x_SubstitutionConditionNoneOrUnconditional) this.substitutionConditionCode.getValue();
    }
    public void setSubstitutionConditionCode(x_SubstitutionConditionNoneOrUnconditional substitutionConditionCode) {
        this.substitutionConditionCode.setValue(substitutionConditionCode);
    }


    /**
     * <p>ToBePickedUpWhen</p>
     * 
     * <p>to be picked up when</p>
     * 
     * <p><p>The date and time on which the dispense is expected to 
     * be picked up.</p></p>
     * 
     * <p><p>Allows a prescriber to indicate to the targeted 
     * pharmacy, when patient will be expecting to pick up the 
     * dispensed device.</p></p>
     * 
     * <p>to be picked up when</p>
     * 
     * <p><p>The date and time on which the dispense is expected to 
     * be picked up.</p></p>
     * 
     * <p><p>Allows a prescriber to indicate to the targeted 
     * pharmacy, when patient will be expecting to pick up the 
     * dispensed medication.</p></p>
     * 
     * <p>To be picked up when</p>
     * 
     * <p><p>The date and time on which the dispense is expected to 
     * be picked up.</p></p>
     * 
     * <p><p>Allows a prescriber to indicate to the targeted 
     * pharmacy, when patient will be expecting to pick up the 
     * dispensed medication.</p></p>
     * 
     * <p>To be picked up when</p>
     * 
     * <p><p>The date and time on which the dispense is expected to 
     * be picked up.</p></p>
     * 
     * <p><p>Allows a prescriber to indicate to the targeted 
     * pharmacy, when patient will be expecting to pick up the 
     * dispensed device.</p></p>
     */
    @Hl7XmlMapping({"time"})
    public Interval<Date> getTime() {
        return this.time.getValue();
    }
    public void setTime(Interval<Date> time) {
        this.time.setValue(time);
    }

}
