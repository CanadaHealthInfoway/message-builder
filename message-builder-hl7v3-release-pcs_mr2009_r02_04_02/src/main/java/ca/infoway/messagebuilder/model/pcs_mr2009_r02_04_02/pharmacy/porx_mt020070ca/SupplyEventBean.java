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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pharmacy.porx_mt020070ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.ActPharmacySupplyType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.DispensedBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pharmacy.merged.DispenseShipToLocationBean;
import java.util.Date;



@Hl7PartTypeMapping({"PORX_MT020070CA.SupplyEvent"})
public class SupplyEventBean extends MessagePartBean {

    private static final long serialVersionUID = 20121204L;
    private CV code = new CVImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private INT repeatNumber = new INTImpl();
    private PQ quantity = new PQImpl();
    private IVL<TS, Interval<Date>> expectedUseTime = new IVLImpl<TS, Interval<Date>>();
    private DispensedBean product;
    private DispenseShipToLocationBean destinationServiceDeliveryLocation;


    /**
     * <p>Business Name: Dispense Type</p>
     * 
     * <p>Relationship: PORX_MT020070CA.SupplyEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates reason for the size of dispense. Because it 
     * defines what type of dispense is occurring, the attribute is 
     * mandatory.</p>
     * 
     * <p>Indicates the type of dispensing event that is performed. 
     * Examples include: Trial Fill, Completion of Trial, Partial 
     * Fill, Emergency Fill, Samples, etc.</p>
     */
    @Hl7XmlMapping({"code"})
    public ActPharmacySupplyType getCode() {
        return (ActPharmacySupplyType) this.code.getValue();
    }

    /**
     * <p>Business Name: Dispense Type</p>
     * 
     * <p>Relationship: PORX_MT020070CA.SupplyEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates reason for the size of dispense. Because it 
     * defines what type of dispense is occurring, the attribute is 
     * mandatory.</p>
     * 
     * <p>Indicates the type of dispensing event that is performed. 
     * Examples include: Trial Fill, Completion of Trial, Partial 
     * Fill, Emergency Fill, Samples, etc.</p>
     */
    public void setCode(ActPharmacySupplyType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: Dispense Processing and Pickup Date</p>
     * 
     * <p>Relationship: PORX_MT020070CA.SupplyEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used by the system in calculating expected exhaustion 
     * time. Valuable in compliance checking. This attribute is 
     * mandatory because an existing dispense record must at least 
     * indicate the date it was processed.</p>
     * 
     * <p>Must be able to post-date a dispense (enter 
     * retroactively) e.g. system failure.</p>
     * 
     * <p>Represents the date the dispense product was prepared and 
     * when the product was picked up by or delivered to the 
     * patient. The dispense processing date and pickup date can be 
     * back dated to reflect when the actual processing and pickup 
     * occurred. The lower-bound of the period signifies the 
     * dispense-processing date whereas the upper-bound signifies 
     * the dispense-pickup date.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: Dispense Processing and Pickup Date</p>
     * 
     * <p>Relationship: PORX_MT020070CA.SupplyEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used by the system in calculating expected exhaustion 
     * time. Valuable in compliance checking. This attribute is 
     * mandatory because an existing dispense record must at least 
     * indicate the date it was processed.</p>
     * 
     * <p>Must be able to post-date a dispense (enter 
     * retroactively) e.g. system failure.</p>
     * 
     * <p>Represents the date the dispense product was prepared and 
     * when the product was picked up by or delivered to the 
     * patient. The dispense processing date and pickup date can be 
     * back dated to reflect when the actual processing and pickup 
     * occurred. The lower-bound of the period signifies the 
     * dispense-processing date whereas the upper-bound signifies 
     * the dispense-pickup date.</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: Number of remaining fills</p>
     * 
     * <p>Relationship: PORX_MT020070CA.SupplyEvent.repeatNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The number of remaining fills is used to evaluate the 
     * &quot;completed&quot; status of the prescription.</p>
     * 
     * <p>Indicates the number or remaining fills, if any, for this 
     * prescription.</p>
     */
    @Hl7XmlMapping({"repeatNumber"})
    public Integer getRepeatNumber() {
        return this.repeatNumber.getValue();
    }

    /**
     * <p>Business Name: Number of remaining fills</p>
     * 
     * <p>Relationship: PORX_MT020070CA.SupplyEvent.repeatNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The number of remaining fills is used to evaluate the 
     * &quot;completed&quot; status of the prescription.</p>
     * 
     * <p>Indicates the number or remaining fills, if any, for this 
     * prescription.</p>
     */
    public void setRepeatNumber(Integer repeatNumber) {
        this.repeatNumber.setValue(repeatNumber);
    }


    /**
     * <p>Business Name: Dispensed Quantity</p>
     * 
     * <p>Relationship: PORX_MT020070CA.SupplyEvent.quantity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Critical in understanding the patient's medication 
     * profile, both past and current, This is also mandatory to 
     * allow determination of the amount that remains to be 
     * dispensed against the prescription.</p>
     * 
     * <p>The amount of medication that has been dispensed. 
     * Includes unit of measure.</p>
     */
    @Hl7XmlMapping({"quantity"})
    public PhysicalQuantity getQuantity() {
        return this.quantity.getValue();
    }

    /**
     * <p>Business Name: Dispensed Quantity</p>
     * 
     * <p>Relationship: PORX_MT020070CA.SupplyEvent.quantity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Critical in understanding the patient's medication 
     * profile, both past and current, This is also mandatory to 
     * allow determination of the amount that remains to be 
     * dispensed against the prescription.</p>
     * 
     * <p>The amount of medication that has been dispensed. 
     * Includes unit of measure.</p>
     */
    public void setQuantity(PhysicalQuantity quantity) {
        this.quantity.setValue(quantity);
    }


    /**
     * <p>Business Name: Dispensed Days Supply</p>
     * 
     * <p>Relationship: PORX_MT020070CA.SupplyEvent.expectedUseTime</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Useful in monitoring patient compliance. May also be 
     * useful in determining and managing certain contraindications 
     * ('Fill-Too-Soon', 'Fill-Too-Late', and 'Duration of 
     * Therapy'). Because 'Days Supply' may be necessary to compute 
     * total dispensed quantity, it is made a 'populated' 
     * field.</p>
     * 
     * <p>The number of days that the dispensed quantity is 
     * expected to last.</p>
     */
    @Hl7XmlMapping({"expectedUseTime"})
    public Interval<Date> getExpectedUseTime() {
        return this.expectedUseTime.getValue();
    }

    /**
     * <p>Business Name: Dispensed Days Supply</p>
     * 
     * <p>Relationship: PORX_MT020070CA.SupplyEvent.expectedUseTime</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Useful in monitoring patient compliance. May also be 
     * useful in determining and managing certain contraindications 
     * ('Fill-Too-Soon', 'Fill-Too-Late', and 'Duration of 
     * Therapy'). Because 'Days Supply' may be necessary to compute 
     * total dispensed quantity, it is made a 'populated' 
     * field.</p>
     * 
     * <p>The number of days that the dispensed quantity is 
     * expected to last.</p>
     */
    public void setExpectedUseTime(Interval<Date> expectedUseTime) {
        this.expectedUseTime.setValue(expectedUseTime);
    }


    @Hl7XmlMapping({"product"})
    public DispensedBean getProduct() {
        return this.product;
    }

    public void setProduct(DispensedBean product) {
        this.product = product;
    }


    @Hl7XmlMapping({"destination/serviceDeliveryLocation"})
    public DispenseShipToLocationBean getDestinationServiceDeliveryLocation() {
        return this.destinationServiceDeliveryLocation;
    }

    public void setDestinationServiceDeliveryLocation(DispenseShipToLocationBean destinationServiceDeliveryLocation) {
        this.destinationServiceDeliveryLocation = destinationServiceDeliveryLocation;
    }

}
