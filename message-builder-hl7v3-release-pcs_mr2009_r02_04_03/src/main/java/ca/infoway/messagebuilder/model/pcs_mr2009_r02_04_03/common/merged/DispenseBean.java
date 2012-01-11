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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.merged;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.x_BasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.DispensedBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.OccurredAtBean;
import java.util.Date;
import java.util.Set;



/**
 * <p>Dispense</p>
 * 
 * <p>COCT_MT260010CA.SupplyEvent: Dispense</p>
 * 
 * <p><p>Indicates a particular dispense event that resulted in 
 * the issue.</p></p>
 * 
 * <p><p>Used when the issue pertains to the supply of the drug 
 * rather than the drug itself. E.g. Duplicate pharmacy, refill 
 * too soon, etc.</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT260010CA.SupplyEvent","COCT_MT260020CA.SupplyEvent"})
public class DispenseBean extends MessagePartBean implements CausalActs {

    private static final long serialVersionUID = 20120106L;
    private II id = new IIImpl();
    private CS statusCode = new CSImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private SET<CV, Code> confidentialityCode = new SETImpl<CV, Code>(CVImpl.class);
    private DispensedBean product;
    private OccurredAtBean location;
    private SET<II, Identifier> inFulfillmentOfSubstanceAdministrationEventId = new SETImpl<II, Identifier>(IIImpl.class);


    /**
     * <p>PrescriptionDispenseNumber</p>
     * 
     * <p>A:Prescription Dispense Number</p>
     * 
     * <p><p>Unique identifier of the dispensed event that 
     * triggered the issue.</p></p>
     * 
     * <p><p>Allows provider to drill down and retrieve additional 
     * information about the dispense event for consideration in 
     * their issue management decision.</p></p>
     * 
     * <p>A:Prescription Dispense Number</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>DispenseStatus</p>
     * 
     * <p>B:Dispense Status</p>
     * 
     * <p><p>Indicates the status of the dispense record created on 
     * the EHR/DIS. If 'Active' it means that the dispense has been 
     * processed but not yet given to the patient. If 'Complete', 
     * it indicates that the medication has been delivered to the 
     * patient.</p></p>
     * 
     * <p><p>Important in understanding what medication the patient 
     * actually has on hand, thus the attribute is mandatory. May 
     * also influence the ability of a different pharmacy to 
     * dispense the medication.</p></p>
     * 
     * <p>B:Dispense Status</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>DispensedDate</p>
     * 
     * <p>B:Dispensed Date</p>
     * 
     * <p>B:Dispensed Date</p>
     * 
     * <p><p>The date and time on which the product was issued to 
     * the patient.</p></p>
     * 
     * <p><p>ZDU.4.5</p></p>
     * 
     * <p><p>Allows evaluation of 'refill too soon' and similar 
     * issues.</p><p>Attribute is marked as 'populated' as a 
     * dispense record may not exist without processing date.</p></p>
     * 
     * <p><p>Allows evaluation of 'refill too soon' and similar 
     * issues.</p><p>Attribute is marked as 'populated' as a 
     * dispense record may not exist without processing date.</p></p>
     * 
     * <p><p>Applications should specify a null flavor of &quot;Not 
     * Applicable&quot; for dispenses that have not yet been picked 
     * up.</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>C:Dispense Masked Indicator</p>
     * 
     * <p>C:Dispense Masking Indicator</p>
     * 
     * <p><p>An indication of sensitivity surrounding the related 
     * drug, and thus defines the required sensitivity for the 
     * detected issue.</p></p>
     * 
     * <p><p>Conveys the patient's wishes relating to the 
     * sensitivity of the drug information.</p><p>The attribute is 
     * optional because not all systems will support masking.</p></p>
     * 
     * <p><p>Conveys the patient's wishes relating to the 
     * sensitivity of the drug information.</p><p>The attribute is 
     * optional because not all systems will support masking.</p></p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_BasicConfidentialityKind> getConfidentialityCode() {
        return this.confidentialityCode.rawSet(x_BasicConfidentialityKind.class);
    }


    @Hl7XmlMapping({"product"})
    public DispensedBean getProduct() {
        return this.product;
    }
    public void setProduct(DispensedBean product) {
        this.product = product;
    }


    @Hl7XmlMapping({"location"})
    public OccurredAtBean getLocation() {
        return this.location;
    }
    public void setLocation(OccurredAtBean location) {
        this.location = location;
    }


    /**
     * <p>PrescriptionOrderNumber</p>
     * 
     * <p>Prescription Order Number</p>
     * 
     * <p><p>The identifier for the prescription that the dispense 
     * fulfilled.</p></p>
     */
    @Hl7XmlMapping({"inFulfillmentOf/substanceAdministrationEvent/id"})
    public Set<Identifier> getInFulfillmentOfSubstanceAdministrationEventId() {
        return this.inFulfillmentOfSubstanceAdministrationEventId.rawSet();
    }

}
