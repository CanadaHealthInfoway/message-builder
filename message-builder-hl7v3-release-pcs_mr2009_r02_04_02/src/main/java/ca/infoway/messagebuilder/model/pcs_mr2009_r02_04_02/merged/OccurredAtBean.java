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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ContextControl;
import ca.infoway.messagebuilder.domainvalue.x_SubstitutionConditionNoneOrUnconditional;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.ServiceLocationBean;
import java.util.Date;



/**
 * <p>COMT_MT300003CA.Location: *c:recorded at</p>
 * 
 * <p><p>Indicates the facility/location where the patient note 
 * was recorded.</p></p>
 * 
 * <p><p>Important for performing follow-up and is therefore 
 * mandatory.</p></p>
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
 * <p>REPC_MT230001CA.Location: i:occurred at</p>
 * 
 * <p><p>This identifies the location where the actual clinical 
 * event (observation or discharge/care) occurred. E.g. 
 * Patient's residence, clinic, work site, etc. It only needs 
 * to be specified when the occurrence location differs from 
 * the official record location. For referral report, it 
 * indicates the location where the referred service is to be 
 * performed.</p></p>
 * 
 * <p><p>The site of the actual event provides context for 
 * interpreting the record. In some cases, it may also provide 
 * follow-up information</p></p>
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
 * <p>REPC_MT500003CA.Location: h:occurred at</p>
 * 
 * <p><p>Must not be specified when Care Composition Type is 
 * 'Condition-based'</p></p>
 * 
 * <p></p><p>In circumstances where number of locations 
 * involved is greater than the limit supported by the message, 
 * multiple encounters should be used.</p></p>
 * 
 * <p></p><p>In circumstances where number of locations 
 * involved is greater than the limit supported by the message, 
 * multiple encounters should be used.</p></p>
 * 
 * <p></p><p>Multiple repetitions are allowed for telehealth 
 * and other remote encounters.</p></p>
 * 
 * <p></p><p>Multiple repetitions are allowed for telehealth 
 * and other remote encounters.</p></p>
 * 
 * <p>REPC_MT230003CA.Location: i:occurred at</p>
 * 
 * <p><p>This identifies the location where the actual clinical 
 * event (observation or discharge/care) occurred. E.g. 
 * Patient's residence, clinic, work site, etc. It only needs 
 * to be specified when the occurrence location differs from 
 * the official record location. For referral report, it 
 * indicates the location where the referred service is to be 
 * performed.</p></p>
 * 
 * <p><p>The site of the actual event provides context for 
 * interpreting the record. In some cases, it may also provide 
 * follow-up information</p></p>
 * 
 * <p>REPC_MT220002CA.Location2: i:occurred at</p>
 * 
 * <p><p>This identifies the location where the actual 
 * discharge/care event occurred. E.g. Patient's residence, 
 * clinic, work site, hospital, etc. It only needs to be 
 * specified when the occurrence location differs from the 
 * official record location.</p><p>The site of the actual event 
 * provides context for interpreting the record. In some cases, 
 * it may also provide follow-up information</p></p>
 * 
 * <p><p>This identifies the location where the actual 
 * discharge/care event occurred. E.g. Patient's residence, 
 * clinic, work site, hospital, etc. It only needs to be 
 * specified when the occurrence location differs from the 
 * official record location.</p><p>The site of the actual event 
 * provides context for interpreting the record. In some cases, 
 * it may also provide follow-up information</p></p>
 * 
 * <p><p>The site of the actual event provides context for 
 * interpreting the record. In some cases, it may also provide 
 * follow-up information</p></p>
 * 
 * <p>PORX_MT060160CA.Location: *d:dispensed from</p>
 * 
 * <p><p>Indicates the facility/location where the dispensing 
 * was performed.</p></p>
 * 
 * <p><p>Important for performing follow-up and therefore 
 * mandatory.</p></p>
 * 
 * <p>REPC_MT230002CA.Location: i:occurred at</p>
 * 
 * <p><p>This identifies the location where the actual clinical 
 * event (observation or discharge/care) occurred. E.g. 
 * Patient's residence, clinic, work site, etc. It only needs 
 * to be specified when the occurrence location differs from 
 * the official record location. For referral report, it 
 * indicates the location where the referred service is to be 
 * performed.</p></p>
 * 
 * <p><p>The site of the actual event provides context for 
 * interpreting the record. In some cases, it may also provide 
 * follow-up information</p></p>
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
 * <p>REPC_MT210003CA.Location3: v:referred to</p>
 * 
 * <p><p>Indicates the service Delivery Location where the 
 * referral service is targeted to be preformed.</p><p>The 
 * target site of the referral service provides context for 
 * interpreting the record. In some cases, it may also provide 
 * follow-up information</p></p>
 * 
 * <p><p>Indicates the service Delivery Location where the 
 * referral service is targeted to be preformed.</p><p>The 
 * target site of the referral service provides context for 
 * interpreting the record. In some cases, it may also provide 
 * follow-up information</p></p>
 * 
 * <p><p>If the referral was targeted to a service delivery 
 * location then the identity of the location must be 
 * known.</p></p>
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
 *
 * ... [rest of documentation truncated due to excessive length]
 */
@Hl7PartTypeMapping({"COCT_MT011001CA.Location","COCT_MT260010CA.Location","COCT_MT260020CA.Location","COCT_MT260030CA.Location","COMT_MT300003CA.Location","POIZ_MT030050CA.Location","POIZ_MT030060CA.Location","POIZ_MT060150CA.Location","PORX_MT010110CA.Location2","PORX_MT010120CA.Location2","PORX_MT010140CA.Location","PORX_MT030040CA.Location","PORX_MT030040CA.Location2","PORX_MT060010CA.Location","PORX_MT060020CA.Location","PORX_MT060040CA.Location","PORX_MT060040CA.Location2","PORX_MT060040CA.Location3","PORX_MT060040CA.Location4","PORX_MT060060CA.Location","PORX_MT060060CA.Location2","PORX_MT060090CA.Location","PORX_MT060100CA.Location","PORX_MT060160CA.Location","PORX_MT060160CA.Location2","PORX_MT060160CA.Location3","PORX_MT060160CA.Location4","PORX_MT060160CA.Location5","PORX_MT060190CA.Location","PORX_MT060190CA.Location2","PORX_MT060190CA.Location3","PORX_MT060190CA.Location4","PORX_MT060210CA.Location2","PORX_MT060340CA.Location","PORX_MT060340CA.Location2","PORX_MT060340CA.Location3","PORX_MT060340CA.Location4","REPC_MT000005CA.Location","REPC_MT000006CA.Location","REPC_MT000009CA.Location","REPC_MT210001CA.Location3","REPC_MT210002CA.Location3","REPC_MT210003CA.Location3","REPC_MT220001CA.Location2","REPC_MT220002CA.Location2","REPC_MT220003CA.Location2","REPC_MT230001CA.Location","REPC_MT230002CA.Location","REPC_MT230003CA.Location","REPC_MT410001CA.Location","REPC_MT410003CA.Location","REPC_MT420001CA.Location","REPC_MT420003CA.Location","REPC_MT500001CA.Location","REPC_MT500002CA.Location","REPC_MT500003CA.Location","REPC_MT500004CA.Location","REPC_MT610001CA.Location","REPC_MT610002CA.Location"})
public class OccurredAtBean extends MessagePartBean {

    private static final long serialVersionUID = 20110901L;
    private ServiceLocationBean serviceDeliveryLocation;
    private IVL<TS, Interval<Date>> toBePickedUpWhen = new IVLImpl<TS, Interval<Date>>();
    private CV substitutionConditionCode = new CVImpl();
    private CS contextControlCode = new CSImpl();


    @Hl7XmlMapping({"serviceDeliveryLocation"})
    public ServiceLocationBean getServiceDeliveryLocation() {
        return this.serviceDeliveryLocation;
    }
    public void setServiceDeliveryLocation(ServiceLocationBean serviceDeliveryLocation) {
        this.serviceDeliveryLocation = serviceDeliveryLocation;
    }


    /**
     * <p>ToBePickedUpWhen</p>
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
     * dispensed device.</p></p>
     */
    @Hl7XmlMapping({"time"})
    public Interval<Date> getToBePickedUpWhen() {
        return this.toBePickedUpWhen.getValue();
    }
    public void setToBePickedUpWhen(Interval<Date> toBePickedUpWhen) {
        this.toBePickedUpWhen.setValue(toBePickedUpWhen);
    }


    /**
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


    @Hl7XmlMapping({"contextControlCode"})
    public ContextControl getContextControlCode() {
        return (ContextControl) this.contextControlCode.getValue();
    }
    public void setContextControlCode(ContextControl contextControlCode) {
        this.contextControlCode.setValue(contextControlCode);
    }

}
