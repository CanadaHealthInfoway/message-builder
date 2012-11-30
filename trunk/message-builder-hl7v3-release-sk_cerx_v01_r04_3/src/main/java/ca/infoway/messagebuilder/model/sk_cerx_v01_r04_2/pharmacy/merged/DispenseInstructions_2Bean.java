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
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.merged.RecordedAtBean;
import java.util.Date;



/**
 * <p>DispenseInstructions</p>
 * 
 * <p>PORX_MT030040CA.SupplyRequest: Dispense Instructions</p>
 * 
 * <p>Specification of how the prescribed medication is to be 
 * dispensed to the patient. Dispensed instruction information 
 * includes the quantity to be dispensed, how often the 
 * quantity is to be dispensed, etc.</p>
 * 
 * <p>A_BillablePharmacyDispense</p>
 * 
 * <p>Sets the parameters within which the dispenser must 
 * operate in dispensing the medication to the patient.</p>
 */
@Hl7PartTypeMapping({"PORX_MT020070CA.SupplyRequest","PORX_MT030040CA.SupplyRequest","PORX_MT060190CA.SupplyRequest"})
public class DispenseInstructions_2Bean extends MessagePartBean {

    private static final long serialVersionUID = 20121122L;
    private CS statusCode = new CSImpl();
    private PQ quantity = new PQImpl();
    private RecordedAtBean location;
    private IVL<TS, Interval<Date>> expectedUseTime = new IVLImpl<TS, Interval<Date>>();


    /**
     * <p>A:Prescription Dispensable Indicator</p>
     * 
     * <p>This generally mirrors the status for the prescription, 
     * but in some circumstances may be changed to 'aborted' while 
     * the prescription is still active. When this occurs, it means 
     * the prescription may no longer be dispensed, though it may 
     * still be administered.</p>
     * 
     * <p>Allows the dispensing authorization of the prescription 
     * to be controlled/manipulates as needed.</p><p>Attribute is 
     * marked as &quot;mandatory&quot; as the dispensing authority 
     * of the prescription will always be known.</p>
     * 
     * <p>Allows the dispensing authorization of the prescription 
     * to be controlled/manipulates as needed.</p><p>Attribute is 
     * marked as &quot;mandatory&quot; as the dispensing authority 
     * of the prescription will always be known.</p>
     * 
     * <p>A:Prescription Dispense Indicator</p>
     * 
     * <p>This generally mirrors the status for the prescription, 
     * but in some circumstances may be changed to 'aborted' while 
     * the prescription is still active. When this occurs, it means 
     * the prescription may no longer be dispensed, though it may 
     * still be administered.</p>
     * 
     * <p>Allows a prescriber to say &quot;Finish what you have on 
     * hand, but don't get any more.&quot;</p><p>Because the status 
     * should always be known, this element is mandatory.</p>
     * 
     * <p>Allows a prescriber to say &quot;Finish what you have on 
     * hand, but don't get any more.&quot;</p><p>Because the status 
     * should always be known, this element is mandatory.</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    /**
     * <p>A:Prescription Dispensable Indicator</p>
     * 
     * <p>This generally mirrors the status for the prescription, 
     * but in some circumstances may be changed to 'aborted' while 
     * the prescription is still active. When this occurs, it means 
     * the prescription may no longer be dispensed, though it may 
     * still be administered.</p>
     * 
     * <p>Allows the dispensing authorization of the prescription 
     * to be controlled/manipulates as needed.</p><p>Attribute is 
     * marked as &quot;mandatory&quot; as the dispensing authority 
     * of the prescription will always be known.</p>
     * 
     * <p>Allows the dispensing authorization of the prescription 
     * to be controlled/manipulates as needed.</p><p>Attribute is 
     * marked as &quot;mandatory&quot; as the dispensing authority 
     * of the prescription will always be known.</p>
     * 
     * <p>A:Prescription Dispense Indicator</p>
     * 
     * <p>This generally mirrors the status for the prescription, 
     * but in some circumstances may be changed to 'aborted' while 
     * the prescription is still active. When this occurs, it means 
     * the prescription may no longer be dispensed, though it may 
     * still be administered.</p>
     * 
     * <p>Allows a prescriber to say &quot;Finish what you have on 
     * hand, but don't get any more.&quot;</p><p>Because the status 
     * should always be known, this element is mandatory.</p>
     * 
     * <p>Allows a prescriber to say &quot;Finish what you have on 
     * hand, but don't get any more.&quot;</p><p>Because the status 
     * should always be known, this element is mandatory.</p>
     */
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>TotalPrescribedQuantity</p>
     * 
     * <p>B:Total Prescribed Quantity</p>
     * 
     * <p>The overall amount of amount medication to be dispensed 
     * under this prescription. Includes any first fills (trials, 
     * aligning quantities), the initial standard fill plus all 
     * refills.</p>
     * 
     * <p>Sets upper limit for medication to be dispensed. Can be 
     * used to verify the intention of the prescriber with respect 
     * to the overall medication. Used for comparison when 
     * determining whether additional quantity may be dispensed in 
     * the context of a part-fill prescription.</p><p>Narcotics 
     * must always be specified as a total quantity.</p>
     * 
     * <p>Sets upper limit for medication to be dispensed. Can be 
     * used to verify the intention of the prescriber with respect 
     * to the overall medication. Used for comparison when 
     * determining whether additional quantity may be dispensed in 
     * the context of a part-fill prescription.</p><p>Narcotics 
     * must always be specified as a total quantity.</p>
     * 
     * <p>B:Total Prescribed Quantity</p>
     * 
     * <p>The overall amount of amount medication to be dispensed 
     * under this prescription. Includes any first fills (trials, 
     * aligning quantities), the initial standard fill plus all 
     * refills.</p>
     * 
     * <p>Sets upper limit for medication to be dispensed. Can be 
     * used to verify the intention of the prescriber with respect 
     * to the overall medication. Used for comparison when 
     * determining whether additional quantity may be dispensed in 
     * the context of a part-fill prescription.</p>
     * 
     * <p>Total Prescribed Quantity</p>
     * 
     * <p>The overall amount of amount medication to be dispensed 
     * under this prescription. Includes any first fills (trials, 
     * aligning quantities), the initial standard fill plus all 
     * refills.</p>
     * 
     * <p>Critical in understanding the patient's medication 
     * profile, both past and current. This also allows 
     * determination of the amount that remains to be dispensed 
     * against the prescription.</p>
     */
    @Hl7XmlMapping({"quantity"})
    public PhysicalQuantity getQuantity() {
        return this.quantity.getValue();
    }

    /**
     * <p>TotalPrescribedQuantity</p>
     * 
     * <p>B:Total Prescribed Quantity</p>
     * 
     * <p>The overall amount of amount medication to be dispensed 
     * under this prescription. Includes any first fills (trials, 
     * aligning quantities), the initial standard fill plus all 
     * refills.</p>
     * 
     * <p>Sets upper limit for medication to be dispensed. Can be 
     * used to verify the intention of the prescriber with respect 
     * to the overall medication. Used for comparison when 
     * determining whether additional quantity may be dispensed in 
     * the context of a part-fill prescription.</p><p>Narcotics 
     * must always be specified as a total quantity.</p>
     * 
     * <p>Sets upper limit for medication to be dispensed. Can be 
     * used to verify the intention of the prescriber with respect 
     * to the overall medication. Used for comparison when 
     * determining whether additional quantity may be dispensed in 
     * the context of a part-fill prescription.</p><p>Narcotics 
     * must always be specified as a total quantity.</p>
     * 
     * <p>B:Total Prescribed Quantity</p>
     * 
     * <p>The overall amount of amount medication to be dispensed 
     * under this prescription. Includes any first fills (trials, 
     * aligning quantities), the initial standard fill plus all 
     * refills.</p>
     * 
     * <p>Sets upper limit for medication to be dispensed. Can be 
     * used to verify the intention of the prescriber with respect 
     * to the overall medication. Used for comparison when 
     * determining whether additional quantity may be dispensed in 
     * the context of a part-fill prescription.</p>
     * 
     * <p>Total Prescribed Quantity</p>
     * 
     * <p>The overall amount of amount medication to be dispensed 
     * under this prescription. Includes any first fills (trials, 
     * aligning quantities), the initial standard fill plus all 
     * refills.</p>
     * 
     * <p>Critical in understanding the patient's medication 
     * profile, both past and current. This also allows 
     * determination of the amount that remains to be dispensed 
     * against the prescription.</p>
     */
    public void setQuantity(PhysicalQuantity quantity) {
        this.quantity.setValue(quantity);
    }


    /**
     * <p>(no business name)</p>
     * 
     * <p><div>Indicates the pharmacy to which the 
     * prescription</div> <div>has been directed or which has 
     * currently assumed</div> <p>responsibility for dispensing the 
     * prescription.&nbsp;</p></p>
     */
    @Hl7XmlMapping({"location"})
    public RecordedAtBean getLocation() {
        return this.location;
    }

    /**
     * <p>(no business name)</p>
     * 
     * <p><div>Indicates the pharmacy to which the 
     * prescription</div> <div>has been directed or which has 
     * currently assumed</div> <p>responsibility for dispensing the 
     * prescription.&nbsp;</p></p>
     */
    public void setLocation(RecordedAtBean location) {
        this.location = location;
    }


    /**
     * <p>TotalDaysSupply</p>
     * 
     * <p>Total Days Supply</p>
     * 
     * <p>The number of days that the overall prescribed item is 
     * expected to last, if the patient is compliant with the 
     * dispensing and administration of the prescription.</p>
     * 
     * <p>Useful in monitoring patient compliance. May also be 
     * useful in determining and managing certain contraindications 
     * ('Fill-Too-Soon', 'Fill-Too-Late', and 'Duration of 
     * Therapy').</p>
     */
    @Hl7XmlMapping({"expectedUseTime"})
    public Interval<Date> getExpectedUseTime() {
        return this.expectedUseTime.getValue();
    }

    /**
     * <p>TotalDaysSupply</p>
     * 
     * <p>Total Days Supply</p>
     * 
     * <p>The number of days that the overall prescribed item is 
     * expected to last, if the patient is compliant with the 
     * dispensing and administration of the prescription.</p>
     * 
     * <p>Useful in monitoring patient compliance. May also be 
     * useful in determining and managing certain contraindications 
     * ('Fill-Too-Soon', 'Fill-Too-Late', and 'Duration of 
     * Therapy').</p>
     */
    public void setExpectedUseTime(Interval<Date> expectedUseTime) {
        this.expectedUseTime.setValue(expectedUseTime);
    }

}
