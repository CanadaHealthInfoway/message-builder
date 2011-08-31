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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pharmacy.merged;

import java.util.Date;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActPharmacySupplyType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.coct_mt141007ca.DeviceProductBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.merged.RelatedPersonBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.merged.DispenseShipToLocationBean;



@Hl7PartTypeMapping({"PORX_MT020060CA.SupplyEvent","PORX_MT060010CA.SupplyEvent","PORX_MT060020CA.SupplyEvent","PORX_MT060040CA.SupplyEvent"})
public class DispenseDetailsBean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private CV dispenseType = new CVImpl();
    private IVL<TS, Interval<Date>> dispenseProcessingAndPickupDate = new IVLImpl<TS, Interval<Date>>();
    private INT dispensedQuantity = new INTImpl();
    private IVL<TS, Interval<Date>> expectedUseTime = new IVLImpl<TS, Interval<Date>>();
    private DeviceProductBean productManufacturedProduct;
    private DispenseShipToLocationBean destinationServiceDeliveryLocation;
    private RelatedPersonBean receiverPersonalRelationship;


    /**
     * <p>DispenseType</p>
     * 
     * <p>Dispense Type</p>
     * 
     * <p><p>Indicates the type of dispensing event that is 
     * performed. Examples include: Trial Fill, Completion of 
     * Trial, Partial Fill, Emergency Fill, Samples, etc.</p></p>
     * 
     * <p><p>Indicates reason for the size of dispense. Because it 
     * defines what type of dispense is occurring, the attribute is 
     * mandatory.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public ActPharmacySupplyType getDispenseType() {
        return (ActPharmacySupplyType) this.dispenseType.getValue();
    }
    public void setDispenseType(ActPharmacySupplyType dispenseType) {
        this.dispenseType.setValue(dispenseType);
    }


    /**
     * <p>DispenseProcessingAndPickupDate</p>
     * 
     * <p>Dispense Processing and Pickup Date</p>
     * 
     * <p><p>Represents the date the dispense product was prepared 
     * and when the product was picked up by or delivered to the 
     * patient. The dispense processing date and pickup date can be 
     * back dated to reflect when the actual processing and pickup 
     * occurred. The lower-bound of the period signifies the 
     * dispense-processing date whereas the upper-bound signifies 
     * the dispense-pickup date.</p></p>
     * 
     * <p><p>Used by the system in calculating expected exhaustion 
     * time. Valuable in compliance checking. This attribute is 
     * mandatory because an existing dispense record must at least 
     * indicate the date it was processed.</p></p>
     * 
     * <p><p>Must be able to post-date a dispense (enter 
     * retroactively) e.g. system failure.</p></p>
     * 
     * <p>Dispense Processing and Pickup Date</p>
     * 
     * <p><p>Represents the date the dispense product was prepared 
     * and when the product was picked up by or delivered to the 
     * patient. The dispense processing date and pickup date can be 
     * back dated to reflect when the actual processing and pickup 
     * occurred. The lower-bound of the period signifies the 
     * dispense-processing date whereas the upper-bound signifies 
     * the dispense-pickup date.</p></p>
     * 
     * <p><p>Used by the system in calculating expected exhaustion 
     * time. Valuable in compliance checking.</p><p>This attribute 
     * is mandatory because an existing dispense record must at 
     * least indicate the date it was processed.</p></p>
     * 
     * <p><p>Used by the system in calculating expected exhaustion 
     * time. Valuable in compliance checking.</p><p>This attribute 
     * is mandatory because an existing dispense record must at 
     * least indicate the date it was processed.</p></p>
     * 
     * <p>Dispense Processing and Pickup Date</p>
     * 
     * <p><p>Represents the date the dispense product was prepared 
     * and when the product was picked up by or delivered to the 
     * patient. The dispense processing date and pickup date can be 
     * back dated to reflect when the actual processing and pickup 
     * occurred. The lower-bound of the period signifies the 
     * dispense-processing date whereas the upper-bound signifies 
     * the dispense-pickup date.</p></p>
     * 
     * <p><p>Used by the system in calculating expected exhaustion 
     * time. Valuable in compliance checking. This attribute is 
     * mandatory because an existing dispense record must at least 
     * indicate the date it was processed.</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getDispenseProcessingAndPickupDate() {
        return this.dispenseProcessingAndPickupDate.getValue();
    }
    public void setDispenseProcessingAndPickupDate(Interval<Date> dispenseProcessingAndPickupDate) {
        this.dispenseProcessingAndPickupDate.setValue(dispenseProcessingAndPickupDate);
    }


    /**
     * <p>DispensedQuantity</p>
     * 
     * <p>Dispensed Quantity</p>
     * 
     * <p><p>The number of devices that have been dispensed.</p></p>
     * 
     * <p><p>Critical in understanding the patient's profile, both 
     * past and current, This is also mandatory to allow 
     * determination of the amount that remains to be dispensed 
     * against the prescription.</p></p>
     * 
     * <p>Dispensed Quantity</p>
     * 
     * <p><p>The number of devices that have been dispensed.</p></p>
     * 
     * <p><p>D58</p><p>ZPB3.4</p></p>
     * 
     * <p><p>D58</p><p>ZPB3.4</p></p>
     * 
     * <p><p>Critical in understanding the patient's profile, both 
     * past and current, This is also mandatory to allow 
     * determination of the amount that remains to be dispensed 
     * against the prescription.</p></p>
     */
    @Hl7XmlMapping({"quantity"})
    public Integer getDispensedQuantity() {
        return this.dispensedQuantity.getValue();
    }
    public void setDispensedQuantity(Integer dispensedQuantity) {
        this.dispensedQuantity.setValue(dispensedQuantity);
    }


    /**
     * <p>Dispensed Days Supply</p>
     * 
     * <p><p>The number of days that the dispensed quantity is 
     * expected to last. Cannot be mandatory as there are some 
     * situations where 'as needed' cannot be used to determine 
     * days supply.</p></p>
     * 
     * <p><p>Useful in monitoring patient compliance. May also be 
     * useful in determining and managing certain contraindications 
     * ('Fill-Too-Soon', 'Fill-Too-Late', and 'Duration of 
     * Therapy'). Because 'Days Supply' may be necessary to compute 
     * total dispensed quantity, it is made a 'populated' 
     * field.</p></p>
     * 
     * <p>Dispense Days Supply</p>
     * 
     * <p><p>The number of days that the dispensed quantity is 
     * expected to last.</p><p>Cannot be mandatory as there are 
     * some situations where 'as needed' cannot be used to 
     * determine days supply.</p></p>
     * 
     * <p><p>The number of days that the dispensed quantity is 
     * expected to last.</p><p>Cannot be mandatory as there are 
     * some situations where 'as needed' cannot be used to 
     * determine days supply.</p></p>
     * 
     * <p><p>Useful in monitoring patient compliance. May also be 
     * useful in determining and managing certain contraindications 
     * ('Fill-Too-Soon', 'Fill-Too-Late', and 'Duration of 
     * Therapy'). Because 'Days Supply' may be necessary to compute 
     * total dispensed quantity, it is made a 'populated' 
     * field.</p></p>
     * 
     * <p>Dispensed Days Supply</p>
     * 
     * <p><p>The number of days that the dispensed quantity is 
     * expected to last. Cannot be mandatory as there are some 
     * situations where 'as needed' cannot be used to determine 
     * days supply.</p></p>
     * 
     * <p><p>.daysSupply</p></p>
     * 
     * <p><p>Useful in monitoring patient compliance. May also be 
     * useful in determining and managing certain contraindications 
     * ('Fill-Too-Soon', 'Fill-Too-Late', and 'Duration of 
     * Therapy'). Because 'Days Supply' may be necessary to compute 
     * total dispensed quantity, it is made a 'populated' 
     * field.</p></p>
     * 
     * <p>Dispensed Days Supply</p>
     * 
     * <p><p>The number of days that the dispensed quantity is 
     * expected to last.</p></p>
     * 
     * <p><p>Useful in monitoring patient compliance. May also be 
     * useful in determining and managing certain contraindications 
     * ('Fill-Too-Soon', 'Fill-Too-Late', and 'Duration of 
     * Therapy'). Because 'Days Supply' may be necessary to compute 
     * total dispensed quantity, it is made a 'populated' 
     * field.</p></p>
     */
    @Hl7XmlMapping({"expectedUseTime"})
    public Interval<Date> getExpectedUseTime() {
        return this.expectedUseTime.getValue();
    }
    public void setExpectedUseTime(Interval<Date> expectedUseTime) {
        this.expectedUseTime.setValue(expectedUseTime);
    }


    @Hl7XmlMapping({"product/manufacturedProduct"})
    public DeviceProductBean getProductManufacturedProduct() {
        return this.productManufacturedProduct;
    }
    public void setProductManufacturedProduct(DeviceProductBean productManufacturedProduct) {
        this.productManufacturedProduct = productManufacturedProduct;
    }


    @Hl7XmlMapping({"destination/serviceDeliveryLocation"})
    public DispenseShipToLocationBean getDestinationServiceDeliveryLocation() {
        return this.destinationServiceDeliveryLocation;
    }
    public void setDestinationServiceDeliveryLocation(DispenseShipToLocationBean destinationServiceDeliveryLocation) {
        this.destinationServiceDeliveryLocation = destinationServiceDeliveryLocation;
    }


    @Hl7XmlMapping({"receiver/personalRelationship"})
    public RelatedPersonBean getReceiverPersonalRelationship() {
        return this.receiverPersonalRelationship;
    }
    public void setReceiverPersonalRelationship(RelatedPersonBean receiverPersonalRelationship) {
        this.receiverPersonalRelationship = receiverPersonalRelationship;
    }

}
