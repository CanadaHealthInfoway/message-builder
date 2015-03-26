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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.pharmacy.porx_mt020070ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.ActPharmacySupplyType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.common.coct_mt220200ca.DrugProductBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.pharmacy.merged.DispenseShipToLocationBean;
import java.util.Date;



@Hl7PartTypeMapping({"PORX_MT020070CA.SupplyEvent"})
public class SupplyEventBean extends MessagePartBean {

    private static final long serialVersionUID = 20150326L;
    private CV code = new CVImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private PQ quantity = new PQImpl();
    private IVL<TS, Interval<Date>> expectedUseTime = new IVLImpl<TS, Interval<Date>>();
    private DrugProductBean productMedication;
    private DispenseShipToLocationBean destinationServiceDeliveryLocation;


    /**
     * <p>Business Name: Dispense Type</p>
     * 
     * <p>Relationship: PORX_MT020070CA.SupplyEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the type of dispensing event that is performed. 
     * Examples include: Trial Fill, Completion of Trial, Partial 
     * Fill, Emergency Fill, Samples, etc.</p>
     * 
     * <p>DispensedItem.activityType</p><p>D52</p><p>ZDP.2</p><p>Claim.403-D3</p><p>Claim.343-HD</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>DispensedItem.activityType</p><p>D52</p><p>ZDP.2</p><p>Claim.403-D3</p><p>Claim.343-HD</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>DispensedItem.activityType</p><p>D52</p><p>ZDP.2</p><p>Claim.403-D3</p><p>Claim.343-HD</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>DispensedItem.activityType</p><p>D52</p><p>ZDP.2</p><p>Claim.403-D3</p><p>Claim.343-HD</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>DispensedItem.activityType</p><p>D52</p><p>ZDP.2</p><p>Claim.403-D3</p><p>Claim.343-HD</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>DispensedItem.activityType</p><p>D52</p><p>ZDP.2</p><p>Claim.403-D3</p><p>Claim.343-HD</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>Indicates reason for the size of dispense. Because it 
     * defines what type of dispense is occurring, the attribute is 
     * mandatory.</p>
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
     * <p>Indicates the type of dispensing event that is performed. 
     * Examples include: Trial Fill, Completion of Trial, Partial 
     * Fill, Emergency Fill, Samples, etc.</p>
     * 
     * <p>DispensedItem.activityType</p><p>D52</p><p>ZDP.2</p><p>Claim.403-D3</p><p>Claim.343-HD</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>DispensedItem.activityType</p><p>D52</p><p>ZDP.2</p><p>Claim.403-D3</p><p>Claim.343-HD</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>DispensedItem.activityType</p><p>D52</p><p>ZDP.2</p><p>Claim.403-D3</p><p>Claim.343-HD</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>DispensedItem.activityType</p><p>D52</p><p>ZDP.2</p><p>Claim.403-D3</p><p>Claim.343-HD</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>DispensedItem.activityType</p><p>D52</p><p>ZDP.2</p><p>Claim.403-D3</p><p>Claim.343-HD</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>DispensedItem.activityType</p><p>D52</p><p>ZDP.2</p><p>Claim.403-D3</p><p>Claim.343-HD</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>Indicates reason for the size of dispense. Because it 
     * defines what type of dispense is occurring, the attribute is 
     * mandatory.</p>
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
     * <p>Represents the date the dispense product was prepared and 
     * when the product was picked up by or delivered to the 
     * patient. The dispense processing date and pickup date can be 
     * back dated to reflect when the actual processing and pickup 
     * occurred. The lower-bound of the period signifies the 
     * dispense-processing date whereas the upper-bound signifies 
     * the dispense-pickup date.</p>
     * 
     * <p>ZPB3.9</p><p>ZDP.17 (high)</p><p>DRU.040-02 (low, 
     * qualifier=07, format=102)</p><p>DRU.040-02 (low, 
     * qualifier=36, 
     * format=102)</p><p>A_BillablePharmacyDispense</p><p>Dispense 
     * Date</p><p>Dispense 
     * Date</p><p>DispensedItem.dispenseDate</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>ZPB3.9</p><p>ZDP.17 (high)</p><p>DRU.040-02 (low, 
     * qualifier=07, format=102)</p><p>DRU.040-02 (low, 
     * qualifier=36, 
     * format=102)</p><p>A_BillablePharmacyDispense</p><p>Dispense 
     * Date</p><p>Dispense 
     * Date</p><p>DispensedItem.dispenseDate</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>ZPB3.9</p><p>ZDP.17 (high)</p><p>DRU.040-02 (low, 
     * qualifier=07, format=102)</p><p>DRU.040-02 (low, 
     * qualifier=36, 
     * format=102)</p><p>A_BillablePharmacyDispense</p><p>Dispense 
     * Date</p><p>Dispense 
     * Date</p><p>DispensedItem.dispenseDate</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>ZPB3.9</p><p>ZDP.17 (high)</p><p>DRU.040-02 (low, 
     * qualifier=07, format=102)</p><p>DRU.040-02 (low, 
     * qualifier=36, 
     * format=102)</p><p>A_BillablePharmacyDispense</p><p>Dispense 
     * Date</p><p>Dispense 
     * Date</p><p>DispensedItem.dispenseDate</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>ZPB3.9</p><p>ZDP.17 (high)</p><p>DRU.040-02 (low, 
     * qualifier=07, format=102)</p><p>DRU.040-02 (low, 
     * qualifier=36, 
     * format=102)</p><p>A_BillablePharmacyDispense</p><p>Dispense 
     * Date</p><p>Dispense 
     * Date</p><p>DispensedItem.dispenseDate</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>ZPB3.9</p><p>ZDP.17 (high)</p><p>DRU.040-02 (low, 
     * qualifier=07, format=102)</p><p>DRU.040-02 (low, 
     * qualifier=36, 
     * format=102)</p><p>A_BillablePharmacyDispense</p><p>Dispense 
     * Date</p><p>Dispense 
     * Date</p><p>DispensedItem.dispenseDate</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>ZPB3.9</p><p>ZDP.17 (high)</p><p>DRU.040-02 (low, 
     * qualifier=07, format=102)</p><p>DRU.040-02 (low, 
     * qualifier=36, 
     * format=102)</p><p>A_BillablePharmacyDispense</p><p>Dispense 
     * Date</p><p>Dispense 
     * Date</p><p>DispensedItem.dispenseDate</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>ZPB3.9</p><p>ZDP.17 (high)</p><p>DRU.040-02 (low, 
     * qualifier=07, format=102)</p><p>DRU.040-02 (low, 
     * qualifier=36, 
     * format=102)</p><p>A_BillablePharmacyDispense</p><p>Dispense 
     * Date</p><p>Dispense 
     * Date</p><p>DispensedItem.dispenseDate</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>ZPB3.9</p><p>ZDP.17 (high)</p><p>DRU.040-02 (low, 
     * qualifier=07, format=102)</p><p>DRU.040-02 (low, 
     * qualifier=36, 
     * format=102)</p><p>A_BillablePharmacyDispense</p><p>Dispense 
     * Date</p><p>Dispense 
     * Date</p><p>DispensedItem.dispenseDate</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>Used by the system in calculating expected exhaustion 
     * time. Valuable in compliance checking. This attribute is 
     * mandatory because an existing dispense record must at least 
     * indicate the date it was processed.</p>
     * 
     * <p>Must be able to post-date a dispense (enter 
     * retroactively) e.g. system failure.</p>
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
     * <p>Represents the date the dispense product was prepared and 
     * when the product was picked up by or delivered to the 
     * patient. The dispense processing date and pickup date can be 
     * back dated to reflect when the actual processing and pickup 
     * occurred. The lower-bound of the period signifies the 
     * dispense-processing date whereas the upper-bound signifies 
     * the dispense-pickup date.</p>
     * 
     * <p>ZPB3.9</p><p>ZDP.17 (high)</p><p>DRU.040-02 (low, 
     * qualifier=07, format=102)</p><p>DRU.040-02 (low, 
     * qualifier=36, 
     * format=102)</p><p>A_BillablePharmacyDispense</p><p>Dispense 
     * Date</p><p>Dispense 
     * Date</p><p>DispensedItem.dispenseDate</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>ZPB3.9</p><p>ZDP.17 (high)</p><p>DRU.040-02 (low, 
     * qualifier=07, format=102)</p><p>DRU.040-02 (low, 
     * qualifier=36, 
     * format=102)</p><p>A_BillablePharmacyDispense</p><p>Dispense 
     * Date</p><p>Dispense 
     * Date</p><p>DispensedItem.dispenseDate</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>ZPB3.9</p><p>ZDP.17 (high)</p><p>DRU.040-02 (low, 
     * qualifier=07, format=102)</p><p>DRU.040-02 (low, 
     * qualifier=36, 
     * format=102)</p><p>A_BillablePharmacyDispense</p><p>Dispense 
     * Date</p><p>Dispense 
     * Date</p><p>DispensedItem.dispenseDate</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>ZPB3.9</p><p>ZDP.17 (high)</p><p>DRU.040-02 (low, 
     * qualifier=07, format=102)</p><p>DRU.040-02 (low, 
     * qualifier=36, 
     * format=102)</p><p>A_BillablePharmacyDispense</p><p>Dispense 
     * Date</p><p>Dispense 
     * Date</p><p>DispensedItem.dispenseDate</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>ZPB3.9</p><p>ZDP.17 (high)</p><p>DRU.040-02 (low, 
     * qualifier=07, format=102)</p><p>DRU.040-02 (low, 
     * qualifier=36, 
     * format=102)</p><p>A_BillablePharmacyDispense</p><p>Dispense 
     * Date</p><p>Dispense 
     * Date</p><p>DispensedItem.dispenseDate</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>ZPB3.9</p><p>ZDP.17 (high)</p><p>DRU.040-02 (low, 
     * qualifier=07, format=102)</p><p>DRU.040-02 (low, 
     * qualifier=36, 
     * format=102)</p><p>A_BillablePharmacyDispense</p><p>Dispense 
     * Date</p><p>Dispense 
     * Date</p><p>DispensedItem.dispenseDate</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>ZPB3.9</p><p>ZDP.17 (high)</p><p>DRU.040-02 (low, 
     * qualifier=07, format=102)</p><p>DRU.040-02 (low, 
     * qualifier=36, 
     * format=102)</p><p>A_BillablePharmacyDispense</p><p>Dispense 
     * Date</p><p>Dispense 
     * Date</p><p>DispensedItem.dispenseDate</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>ZPB3.9</p><p>ZDP.17 (high)</p><p>DRU.040-02 (low, 
     * qualifier=07, format=102)</p><p>DRU.040-02 (low, 
     * qualifier=36, 
     * format=102)</p><p>A_BillablePharmacyDispense</p><p>Dispense 
     * Date</p><p>Dispense 
     * Date</p><p>DispensedItem.dispenseDate</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>ZPB3.9</p><p>ZDP.17 (high)</p><p>DRU.040-02 (low, 
     * qualifier=07, format=102)</p><p>DRU.040-02 (low, 
     * qualifier=36, 
     * format=102)</p><p>A_BillablePharmacyDispense</p><p>Dispense 
     * Date</p><p>Dispense 
     * Date</p><p>DispensedItem.dispenseDate</p><p>A_BillablePharmacyDispense</p>
     * 
     * <p>Used by the system in calculating expected exhaustion 
     * time. Valuable in compliance checking. This attribute is 
     * mandatory because an existing dispense record must at least 
     * indicate the date it was processed.</p>
     * 
     * <p>Must be able to post-date a dispense (enter 
     * retroactively) e.g. system failure.</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: Dispensed Quantity</p>
     * 
     * <p>Relationship: PORX_MT020070CA.SupplyEvent.quantity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The amount of medication that has been dispensed. 
     * Includes unit of measure.</p>
     * 
     * <p>D58</p><p>ZPB3.4</p><p>ZDP.10.1</p><p>ZDP.10.2.1 (the 
     * fact that it is package is determined by a playing 
     * entity)</p><p>ZDP.9.1</p><p>ZDP.9.2.1 (the fact that it is 
     * package is determined by a playing entity)</p><p>DRU.020-01 
     * (Unit, qualifier=38 0r 87)</p><p>DRU.020-02 (Quantity, 
     * qualifier=38 0r 87)</p><p>DRU.020-03 (qualifier=38 0r 
     * 87)</p><p>Claim.442-E7</p><p>Claim.460-ET</p><p>Claim.600-28</p><p>A_BillablePharmacyDispense</p><p>Quantity</p><p>DispensedItem.dispensedAmount</p>
     * 
     * <p>D58</p><p>ZPB3.4</p><p>ZDP.10.1</p><p>ZDP.10.2.1 (the 
     * fact that it is package is determined by a playing 
     * entity)</p><p>ZDP.9.1</p><p>ZDP.9.2.1 (the fact that it is 
     * package is determined by a playing entity)</p><p>DRU.020-01 
     * (Unit, qualifier=38 0r 87)</p><p>DRU.020-02 (Quantity, 
     * qualifier=38 0r 87)</p><p>DRU.020-03 (qualifier=38 0r 
     * 87)</p><p>Claim.442-E7</p><p>Claim.460-ET</p><p>Claim.600-28</p><p>A_BillablePharmacyDispense</p><p>Quantity</p><p>DispensedItem.dispensedAmount</p>
     * 
     * <p>D58</p><p>ZPB3.4</p><p>ZDP.10.1</p><p>ZDP.10.2.1 (the 
     * fact that it is package is determined by a playing 
     * entity)</p><p>ZDP.9.1</p><p>ZDP.9.2.1 (the fact that it is 
     * package is determined by a playing entity)</p><p>DRU.020-01 
     * (Unit, qualifier=38 0r 87)</p><p>DRU.020-02 (Quantity, 
     * qualifier=38 0r 87)</p><p>DRU.020-03 (qualifier=38 0r 
     * 87)</p><p>Claim.442-E7</p><p>Claim.460-ET</p><p>Claim.600-28</p><p>A_BillablePharmacyDispense</p><p>Quantity</p><p>DispensedItem.dispensedAmount</p>
     * 
     * <p>D58</p><p>ZPB3.4</p><p>ZDP.10.1</p><p>ZDP.10.2.1 (the 
     * fact that it is package is determined by a playing 
     * entity)</p><p>ZDP.9.1</p><p>ZDP.9.2.1 (the fact that it is 
     * package is determined by a playing entity)</p><p>DRU.020-01 
     * (Unit, qualifier=38 0r 87)</p><p>DRU.020-02 (Quantity, 
     * qualifier=38 0r 87)</p><p>DRU.020-03 (qualifier=38 0r 
     * 87)</p><p>Claim.442-E7</p><p>Claim.460-ET</p><p>Claim.600-28</p><p>A_BillablePharmacyDispense</p><p>Quantity</p><p>DispensedItem.dispensedAmount</p>
     * 
     * <p>D58</p><p>ZPB3.4</p><p>ZDP.10.1</p><p>ZDP.10.2.1 (the 
     * fact that it is package is determined by a playing 
     * entity)</p><p>ZDP.9.1</p><p>ZDP.9.2.1 (the fact that it is 
     * package is determined by a playing entity)</p><p>DRU.020-01 
     * (Unit, qualifier=38 0r 87)</p><p>DRU.020-02 (Quantity, 
     * qualifier=38 0r 87)</p><p>DRU.020-03 (qualifier=38 0r 
     * 87)</p><p>Claim.442-E7</p><p>Claim.460-ET</p><p>Claim.600-28</p><p>A_BillablePharmacyDispense</p><p>Quantity</p><p>DispensedItem.dispensedAmount</p>
     * 
     * <p>D58</p><p>ZPB3.4</p><p>ZDP.10.1</p><p>ZDP.10.2.1 (the 
     * fact that it is package is determined by a playing 
     * entity)</p><p>ZDP.9.1</p><p>ZDP.9.2.1 (the fact that it is 
     * package is determined by a playing entity)</p><p>DRU.020-01 
     * (Unit, qualifier=38 0r 87)</p><p>DRU.020-02 (Quantity, 
     * qualifier=38 0r 87)</p><p>DRU.020-03 (qualifier=38 0r 
     * 87)</p><p>Claim.442-E7</p><p>Claim.460-ET</p><p>Claim.600-28</p><p>A_BillablePharmacyDispense</p><p>Quantity</p><p>DispensedItem.dispensedAmount</p>
     * 
     * <p>D58</p><p>ZPB3.4</p><p>ZDP.10.1</p><p>ZDP.10.2.1 (the 
     * fact that it is package is determined by a playing 
     * entity)</p><p>ZDP.9.1</p><p>ZDP.9.2.1 (the fact that it is 
     * package is determined by a playing entity)</p><p>DRU.020-01 
     * (Unit, qualifier=38 0r 87)</p><p>DRU.020-02 (Quantity, 
     * qualifier=38 0r 87)</p><p>DRU.020-03 (qualifier=38 0r 
     * 87)</p><p>Claim.442-E7</p><p>Claim.460-ET</p><p>Claim.600-28</p><p>A_BillablePharmacyDispense</p><p>Quantity</p><p>DispensedItem.dispensedAmount</p>
     * 
     * <p>D58</p><p>ZPB3.4</p><p>ZDP.10.1</p><p>ZDP.10.2.1 (the 
     * fact that it is package is determined by a playing 
     * entity)</p><p>ZDP.9.1</p><p>ZDP.9.2.1 (the fact that it is 
     * package is determined by a playing entity)</p><p>DRU.020-01 
     * (Unit, qualifier=38 0r 87)</p><p>DRU.020-02 (Quantity, 
     * qualifier=38 0r 87)</p><p>DRU.020-03 (qualifier=38 0r 
     * 87)</p><p>Claim.442-E7</p><p>Claim.460-ET</p><p>Claim.600-28</p><p>A_BillablePharmacyDispense</p><p>Quantity</p><p>DispensedItem.dispensedAmount</p>
     * 
     * <p>D58</p><p>ZPB3.4</p><p>ZDP.10.1</p><p>ZDP.10.2.1 (the 
     * fact that it is package is determined by a playing 
     * entity)</p><p>ZDP.9.1</p><p>ZDP.9.2.1 (the fact that it is 
     * package is determined by a playing entity)</p><p>DRU.020-01 
     * (Unit, qualifier=38 0r 87)</p><p>DRU.020-02 (Quantity, 
     * qualifier=38 0r 87)</p><p>DRU.020-03 (qualifier=38 0r 
     * 87)</p><p>Claim.442-E7</p><p>Claim.460-ET</p><p>Claim.600-28</p><p>A_BillablePharmacyDispense</p><p>Quantity</p><p>DispensedItem.dispensedAmount</p>
     * 
     * <p>D58</p><p>ZPB3.4</p><p>ZDP.10.1</p><p>ZDP.10.2.1 (the 
     * fact that it is package is determined by a playing 
     * entity)</p><p>ZDP.9.1</p><p>ZDP.9.2.1 (the fact that it is 
     * package is determined by a playing entity)</p><p>DRU.020-01 
     * (Unit, qualifier=38 0r 87)</p><p>DRU.020-02 (Quantity, 
     * qualifier=38 0r 87)</p><p>DRU.020-03 (qualifier=38 0r 
     * 87)</p><p>Claim.442-E7</p><p>Claim.460-ET</p><p>Claim.600-28</p><p>A_BillablePharmacyDispense</p><p>Quantity</p><p>DispensedItem.dispensedAmount</p>
     * 
     * <p>D58</p><p>ZPB3.4</p><p>ZDP.10.1</p><p>ZDP.10.2.1 (the 
     * fact that it is package is determined by a playing 
     * entity)</p><p>ZDP.9.1</p><p>ZDP.9.2.1 (the fact that it is 
     * package is determined by a playing entity)</p><p>DRU.020-01 
     * (Unit, qualifier=38 0r 87)</p><p>DRU.020-02 (Quantity, 
     * qualifier=38 0r 87)</p><p>DRU.020-03 (qualifier=38 0r 
     * 87)</p><p>Claim.442-E7</p><p>Claim.460-ET</p><p>Claim.600-28</p><p>A_BillablePharmacyDispense</p><p>Quantity</p><p>DispensedItem.dispensedAmount</p>
     * 
     * <p>D58</p><p>ZPB3.4</p><p>ZDP.10.1</p><p>ZDP.10.2.1 (the 
     * fact that it is package is determined by a playing 
     * entity)</p><p>ZDP.9.1</p><p>ZDP.9.2.1 (the fact that it is 
     * package is determined by a playing entity)</p><p>DRU.020-01 
     * (Unit, qualifier=38 0r 87)</p><p>DRU.020-02 (Quantity, 
     * qualifier=38 0r 87)</p><p>DRU.020-03 (qualifier=38 0r 
     * 87)</p><p>Claim.442-E7</p><p>Claim.460-ET</p><p>Claim.600-28</p><p>A_BillablePharmacyDispense</p><p>Quantity</p><p>DispensedItem.dispensedAmount</p>
     * 
     * <p>D58</p><p>ZPB3.4</p><p>ZDP.10.1</p><p>ZDP.10.2.1 (the 
     * fact that it is package is determined by a playing 
     * entity)</p><p>ZDP.9.1</p><p>ZDP.9.2.1 (the fact that it is 
     * package is determined by a playing entity)</p><p>DRU.020-01 
     * (Unit, qualifier=38 0r 87)</p><p>DRU.020-02 (Quantity, 
     * qualifier=38 0r 87)</p><p>DRU.020-03 (qualifier=38 0r 
     * 87)</p><p>Claim.442-E7</p><p>Claim.460-ET</p><p>Claim.600-28</p><p>A_BillablePharmacyDispense</p><p>Quantity</p><p>DispensedItem.dispensedAmount</p>
     * 
     * <p>D58</p><p>ZPB3.4</p><p>ZDP.10.1</p><p>ZDP.10.2.1 (the 
     * fact that it is package is determined by a playing 
     * entity)</p><p>ZDP.9.1</p><p>ZDP.9.2.1 (the fact that it is 
     * package is determined by a playing entity)</p><p>DRU.020-01 
     * (Unit, qualifier=38 0r 87)</p><p>DRU.020-02 (Quantity, 
     * qualifier=38 0r 87)</p><p>DRU.020-03 (qualifier=38 0r 
     * 87)</p><p>Claim.442-E7</p><p>Claim.460-ET</p><p>Claim.600-28</p><p>A_BillablePharmacyDispense</p><p>Quantity</p><p>DispensedItem.dispensedAmount</p>
     * 
     * <p>D58</p><p>ZPB3.4</p><p>ZDP.10.1</p><p>ZDP.10.2.1 (the 
     * fact that it is package is determined by a playing 
     * entity)</p><p>ZDP.9.1</p><p>ZDP.9.2.1 (the fact that it is 
     * package is determined by a playing entity)</p><p>DRU.020-01 
     * (Unit, qualifier=38 0r 87)</p><p>DRU.020-02 (Quantity, 
     * qualifier=38 0r 87)</p><p>DRU.020-03 (qualifier=38 0r 
     * 87)</p><p>Claim.442-E7</p><p>Claim.460-ET</p><p>Claim.600-28</p><p>A_BillablePharmacyDispense</p><p>Quantity</p><p>DispensedItem.dispensedAmount</p>
     * 
     * <p>Critical in understanding the patient's medication 
     * profile, both past and current, This is also mandatory to 
     * allow determination of the amount that remains to be 
     * dispensed against the prescription.</p>
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
     * <p>The amount of medication that has been dispensed. 
     * Includes unit of measure.</p>
     * 
     * <p>D58</p><p>ZPB3.4</p><p>ZDP.10.1</p><p>ZDP.10.2.1 (the 
     * fact that it is package is determined by a playing 
     * entity)</p><p>ZDP.9.1</p><p>ZDP.9.2.1 (the fact that it is 
     * package is determined by a playing entity)</p><p>DRU.020-01 
     * (Unit, qualifier=38 0r 87)</p><p>DRU.020-02 (Quantity, 
     * qualifier=38 0r 87)</p><p>DRU.020-03 (qualifier=38 0r 
     * 87)</p><p>Claim.442-E7</p><p>Claim.460-ET</p><p>Claim.600-28</p><p>A_BillablePharmacyDispense</p><p>Quantity</p><p>DispensedItem.dispensedAmount</p>
     * 
     * <p>D58</p><p>ZPB3.4</p><p>ZDP.10.1</p><p>ZDP.10.2.1 (the 
     * fact that it is package is determined by a playing 
     * entity)</p><p>ZDP.9.1</p><p>ZDP.9.2.1 (the fact that it is 
     * package is determined by a playing entity)</p><p>DRU.020-01 
     * (Unit, qualifier=38 0r 87)</p><p>DRU.020-02 (Quantity, 
     * qualifier=38 0r 87)</p><p>DRU.020-03 (qualifier=38 0r 
     * 87)</p><p>Claim.442-E7</p><p>Claim.460-ET</p><p>Claim.600-28</p><p>A_BillablePharmacyDispense</p><p>Quantity</p><p>DispensedItem.dispensedAmount</p>
     * 
     * <p>D58</p><p>ZPB3.4</p><p>ZDP.10.1</p><p>ZDP.10.2.1 (the 
     * fact that it is package is determined by a playing 
     * entity)</p><p>ZDP.9.1</p><p>ZDP.9.2.1 (the fact that it is 
     * package is determined by a playing entity)</p><p>DRU.020-01 
     * (Unit, qualifier=38 0r 87)</p><p>DRU.020-02 (Quantity, 
     * qualifier=38 0r 87)</p><p>DRU.020-03 (qualifier=38 0r 
     * 87)</p><p>Claim.442-E7</p><p>Claim.460-ET</p><p>Claim.600-28</p><p>A_BillablePharmacyDispense</p><p>Quantity</p><p>DispensedItem.dispensedAmount</p>
     * 
     * <p>D58</p><p>ZPB3.4</p><p>ZDP.10.1</p><p>ZDP.10.2.1 (the 
     * fact that it is package is determined by a playing 
     * entity)</p><p>ZDP.9.1</p><p>ZDP.9.2.1 (the fact that it is 
     * package is determined by a playing entity)</p><p>DRU.020-01 
     * (Unit, qualifier=38 0r 87)</p><p>DRU.020-02 (Quantity, 
     * qualifier=38 0r 87)</p><p>DRU.020-03 (qualifier=38 0r 
     * 87)</p><p>Claim.442-E7</p><p>Claim.460-ET</p><p>Claim.600-28</p><p>A_BillablePharmacyDispense</p><p>Quantity</p><p>DispensedItem.dispensedAmount</p>
     * 
     * <p>D58</p><p>ZPB3.4</p><p>ZDP.10.1</p><p>ZDP.10.2.1 (the 
     * fact that it is package is determined by a playing 
     * entity)</p><p>ZDP.9.1</p><p>ZDP.9.2.1 (the fact that it is 
     * package is determined by a playing entity)</p><p>DRU.020-01 
     * (Unit, qualifier=38 0r 87)</p><p>DRU.020-02 (Quantity, 
     * qualifier=38 0r 87)</p><p>DRU.020-03 (qualifier=38 0r 
     * 87)</p><p>Claim.442-E7</p><p>Claim.460-ET</p><p>Claim.600-28</p><p>A_BillablePharmacyDispense</p><p>Quantity</p><p>DispensedItem.dispensedAmount</p>
     * 
     * <p>D58</p><p>ZPB3.4</p><p>ZDP.10.1</p><p>ZDP.10.2.1 (the 
     * fact that it is package is determined by a playing 
     * entity)</p><p>ZDP.9.1</p><p>ZDP.9.2.1 (the fact that it is 
     * package is determined by a playing entity)</p><p>DRU.020-01 
     * (Unit, qualifier=38 0r 87)</p><p>DRU.020-02 (Quantity, 
     * qualifier=38 0r 87)</p><p>DRU.020-03 (qualifier=38 0r 
     * 87)</p><p>Claim.442-E7</p><p>Claim.460-ET</p><p>Claim.600-28</p><p>A_BillablePharmacyDispense</p><p>Quantity</p><p>DispensedItem.dispensedAmount</p>
     * 
     * <p>D58</p><p>ZPB3.4</p><p>ZDP.10.1</p><p>ZDP.10.2.1 (the 
     * fact that it is package is determined by a playing 
     * entity)</p><p>ZDP.9.1</p><p>ZDP.9.2.1 (the fact that it is 
     * package is determined by a playing entity)</p><p>DRU.020-01 
     * (Unit, qualifier=38 0r 87)</p><p>DRU.020-02 (Quantity, 
     * qualifier=38 0r 87)</p><p>DRU.020-03 (qualifier=38 0r 
     * 87)</p><p>Claim.442-E7</p><p>Claim.460-ET</p><p>Claim.600-28</p><p>A_BillablePharmacyDispense</p><p>Quantity</p><p>DispensedItem.dispensedAmount</p>
     * 
     * <p>D58</p><p>ZPB3.4</p><p>ZDP.10.1</p><p>ZDP.10.2.1 (the 
     * fact that it is package is determined by a playing 
     * entity)</p><p>ZDP.9.1</p><p>ZDP.9.2.1 (the fact that it is 
     * package is determined by a playing entity)</p><p>DRU.020-01 
     * (Unit, qualifier=38 0r 87)</p><p>DRU.020-02 (Quantity, 
     * qualifier=38 0r 87)</p><p>DRU.020-03 (qualifier=38 0r 
     * 87)</p><p>Claim.442-E7</p><p>Claim.460-ET</p><p>Claim.600-28</p><p>A_BillablePharmacyDispense</p><p>Quantity</p><p>DispensedItem.dispensedAmount</p>
     * 
     * <p>D58</p><p>ZPB3.4</p><p>ZDP.10.1</p><p>ZDP.10.2.1 (the 
     * fact that it is package is determined by a playing 
     * entity)</p><p>ZDP.9.1</p><p>ZDP.9.2.1 (the fact that it is 
     * package is determined by a playing entity)</p><p>DRU.020-01 
     * (Unit, qualifier=38 0r 87)</p><p>DRU.020-02 (Quantity, 
     * qualifier=38 0r 87)</p><p>DRU.020-03 (qualifier=38 0r 
     * 87)</p><p>Claim.442-E7</p><p>Claim.460-ET</p><p>Claim.600-28</p><p>A_BillablePharmacyDispense</p><p>Quantity</p><p>DispensedItem.dispensedAmount</p>
     * 
     * <p>D58</p><p>ZPB3.4</p><p>ZDP.10.1</p><p>ZDP.10.2.1 (the 
     * fact that it is package is determined by a playing 
     * entity)</p><p>ZDP.9.1</p><p>ZDP.9.2.1 (the fact that it is 
     * package is determined by a playing entity)</p><p>DRU.020-01 
     * (Unit, qualifier=38 0r 87)</p><p>DRU.020-02 (Quantity, 
     * qualifier=38 0r 87)</p><p>DRU.020-03 (qualifier=38 0r 
     * 87)</p><p>Claim.442-E7</p><p>Claim.460-ET</p><p>Claim.600-28</p><p>A_BillablePharmacyDispense</p><p>Quantity</p><p>DispensedItem.dispensedAmount</p>
     * 
     * <p>D58</p><p>ZPB3.4</p><p>ZDP.10.1</p><p>ZDP.10.2.1 (the 
     * fact that it is package is determined by a playing 
     * entity)</p><p>ZDP.9.1</p><p>ZDP.9.2.1 (the fact that it is 
     * package is determined by a playing entity)</p><p>DRU.020-01 
     * (Unit, qualifier=38 0r 87)</p><p>DRU.020-02 (Quantity, 
     * qualifier=38 0r 87)</p><p>DRU.020-03 (qualifier=38 0r 
     * 87)</p><p>Claim.442-E7</p><p>Claim.460-ET</p><p>Claim.600-28</p><p>A_BillablePharmacyDispense</p><p>Quantity</p><p>DispensedItem.dispensedAmount</p>
     * 
     * <p>D58</p><p>ZPB3.4</p><p>ZDP.10.1</p><p>ZDP.10.2.1 (the 
     * fact that it is package is determined by a playing 
     * entity)</p><p>ZDP.9.1</p><p>ZDP.9.2.1 (the fact that it is 
     * package is determined by a playing entity)</p><p>DRU.020-01 
     * (Unit, qualifier=38 0r 87)</p><p>DRU.020-02 (Quantity, 
     * qualifier=38 0r 87)</p><p>DRU.020-03 (qualifier=38 0r 
     * 87)</p><p>Claim.442-E7</p><p>Claim.460-ET</p><p>Claim.600-28</p><p>A_BillablePharmacyDispense</p><p>Quantity</p><p>DispensedItem.dispensedAmount</p>
     * 
     * <p>D58</p><p>ZPB3.4</p><p>ZDP.10.1</p><p>ZDP.10.2.1 (the 
     * fact that it is package is determined by a playing 
     * entity)</p><p>ZDP.9.1</p><p>ZDP.9.2.1 (the fact that it is 
     * package is determined by a playing entity)</p><p>DRU.020-01 
     * (Unit, qualifier=38 0r 87)</p><p>DRU.020-02 (Quantity, 
     * qualifier=38 0r 87)</p><p>DRU.020-03 (qualifier=38 0r 
     * 87)</p><p>Claim.442-E7</p><p>Claim.460-ET</p><p>Claim.600-28</p><p>A_BillablePharmacyDispense</p><p>Quantity</p><p>DispensedItem.dispensedAmount</p>
     * 
     * <p>D58</p><p>ZPB3.4</p><p>ZDP.10.1</p><p>ZDP.10.2.1 (the 
     * fact that it is package is determined by a playing 
     * entity)</p><p>ZDP.9.1</p><p>ZDP.9.2.1 (the fact that it is 
     * package is determined by a playing entity)</p><p>DRU.020-01 
     * (Unit, qualifier=38 0r 87)</p><p>DRU.020-02 (Quantity, 
     * qualifier=38 0r 87)</p><p>DRU.020-03 (qualifier=38 0r 
     * 87)</p><p>Claim.442-E7</p><p>Claim.460-ET</p><p>Claim.600-28</p><p>A_BillablePharmacyDispense</p><p>Quantity</p><p>DispensedItem.dispensedAmount</p>
     * 
     * <p>D58</p><p>ZPB3.4</p><p>ZDP.10.1</p><p>ZDP.10.2.1 (the 
     * fact that it is package is determined by a playing 
     * entity)</p><p>ZDP.9.1</p><p>ZDP.9.2.1 (the fact that it is 
     * package is determined by a playing entity)</p><p>DRU.020-01 
     * (Unit, qualifier=38 0r 87)</p><p>DRU.020-02 (Quantity, 
     * qualifier=38 0r 87)</p><p>DRU.020-03 (qualifier=38 0r 
     * 87)</p><p>Claim.442-E7</p><p>Claim.460-ET</p><p>Claim.600-28</p><p>A_BillablePharmacyDispense</p><p>Quantity</p><p>DispensedItem.dispensedAmount</p>
     * 
     * <p>Critical in understanding the patient's medication 
     * profile, both past and current, This is also mandatory to 
     * allow determination of the amount that remains to be 
     * dispensed against the prescription.</p>
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
     * <p>The number of days that the dispensed quantity is 
     * expected to last.</p>
     * 
     * <p>D59(width)</p><p>ZDP.11</p><p>DRU.040-02 (low, 
     * qualifier=ZDS, 
     * format=804)</p><p>Claim.405-D5</p><p>A_BillablePharmacyDispense</p><p>Days 
     * Supply</p><p>DispensedItem.daysSupply</p>
     * 
     * <p>D59(width)</p><p>ZDP.11</p><p>DRU.040-02 (low, 
     * qualifier=ZDS, 
     * format=804)</p><p>Claim.405-D5</p><p>A_BillablePharmacyDispense</p><p>Days 
     * Supply</p><p>DispensedItem.daysSupply</p>
     * 
     * <p>D59(width)</p><p>ZDP.11</p><p>DRU.040-02 (low, 
     * qualifier=ZDS, 
     * format=804)</p><p>Claim.405-D5</p><p>A_BillablePharmacyDispense</p><p>Days 
     * Supply</p><p>DispensedItem.daysSupply</p>
     * 
     * <p>D59(width)</p><p>ZDP.11</p><p>DRU.040-02 (low, 
     * qualifier=ZDS, 
     * format=804)</p><p>Claim.405-D5</p><p>A_BillablePharmacyDispense</p><p>Days 
     * Supply</p><p>DispensedItem.daysSupply</p>
     * 
     * <p>D59(width)</p><p>ZDP.11</p><p>DRU.040-02 (low, 
     * qualifier=ZDS, 
     * format=804)</p><p>Claim.405-D5</p><p>A_BillablePharmacyDispense</p><p>Days 
     * Supply</p><p>DispensedItem.daysSupply</p>
     * 
     * <p>D59(width)</p><p>ZDP.11</p><p>DRU.040-02 (low, 
     * qualifier=ZDS, 
     * format=804)</p><p>Claim.405-D5</p><p>A_BillablePharmacyDispense</p><p>Days 
     * Supply</p><p>DispensedItem.daysSupply</p>
     * 
     * <p>D59(width)</p><p>ZDP.11</p><p>DRU.040-02 (low, 
     * qualifier=ZDS, 
     * format=804)</p><p>Claim.405-D5</p><p>A_BillablePharmacyDispense</p><p>Days 
     * Supply</p><p>DispensedItem.daysSupply</p>
     * 
     * <p>Useful in monitoring patient compliance. May also be 
     * useful in determining and managing certain contraindications 
     * ('Fill-Too-Soon', 'Fill-Too-Late', and 'Duration of 
     * Therapy'). Because 'Days Supply' may be necessary to compute 
     * total dispensed quantity, it is made a 'populated' 
     * field.</p>
     * 
     * <p><div>NOTE: This will be set to &lsquo;UNK&rsquo; if the 
     * days supply</div> <p>is unknown, eg. for PRN 
     * dispenses.&nbsp;</p></p>
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
     * <p>The number of days that the dispensed quantity is 
     * expected to last.</p>
     * 
     * <p>D59(width)</p><p>ZDP.11</p><p>DRU.040-02 (low, 
     * qualifier=ZDS, 
     * format=804)</p><p>Claim.405-D5</p><p>A_BillablePharmacyDispense</p><p>Days 
     * Supply</p><p>DispensedItem.daysSupply</p>
     * 
     * <p>D59(width)</p><p>ZDP.11</p><p>DRU.040-02 (low, 
     * qualifier=ZDS, 
     * format=804)</p><p>Claim.405-D5</p><p>A_BillablePharmacyDispense</p><p>Days 
     * Supply</p><p>DispensedItem.daysSupply</p>
     * 
     * <p>D59(width)</p><p>ZDP.11</p><p>DRU.040-02 (low, 
     * qualifier=ZDS, 
     * format=804)</p><p>Claim.405-D5</p><p>A_BillablePharmacyDispense</p><p>Days 
     * Supply</p><p>DispensedItem.daysSupply</p>
     * 
     * <p>D59(width)</p><p>ZDP.11</p><p>DRU.040-02 (low, 
     * qualifier=ZDS, 
     * format=804)</p><p>Claim.405-D5</p><p>A_BillablePharmacyDispense</p><p>Days 
     * Supply</p><p>DispensedItem.daysSupply</p>
     * 
     * <p>D59(width)</p><p>ZDP.11</p><p>DRU.040-02 (low, 
     * qualifier=ZDS, 
     * format=804)</p><p>Claim.405-D5</p><p>A_BillablePharmacyDispense</p><p>Days 
     * Supply</p><p>DispensedItem.daysSupply</p>
     * 
     * <p>D59(width)</p><p>ZDP.11</p><p>DRU.040-02 (low, 
     * qualifier=ZDS, 
     * format=804)</p><p>Claim.405-D5</p><p>A_BillablePharmacyDispense</p><p>Days 
     * Supply</p><p>DispensedItem.daysSupply</p>
     * 
     * <p>D59(width)</p><p>ZDP.11</p><p>DRU.040-02 (low, 
     * qualifier=ZDS, 
     * format=804)</p><p>Claim.405-D5</p><p>A_BillablePharmacyDispense</p><p>Days 
     * Supply</p><p>DispensedItem.daysSupply</p>
     * 
     * <p>Useful in monitoring patient compliance. May also be 
     * useful in determining and managing certain contraindications 
     * ('Fill-Too-Soon', 'Fill-Too-Late', and 'Duration of 
     * Therapy'). Because 'Days Supply' may be necessary to compute 
     * total dispensed quantity, it is made a 'populated' 
     * field.</p>
     * 
     * <p><div>NOTE: This will be set to &lsquo;UNK&rsquo; if the 
     * days supply</div> <p>is unknown, eg. for PRN 
     * dispenses.&nbsp;</p></p>
     */
    public void setExpectedUseTime(Interval<Date> expectedUseTime) {
        this.expectedUseTime.setValue(expectedUseTime);
    }


    /**
     * <p>Relationship: PORX_MT020070CA.Product2.medication</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"product/medication"})
    public DrugProductBean getProductMedication() {
        return this.productMedication;
    }

    /**
     * <p>Relationship: PORX_MT020070CA.Product2.medication</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setProductMedication(DrugProductBean productMedication) {
        this.productMedication = productMedication;
    }


    /**
     * <p>Relationship: 
     * PORX_MT020070CA.Destination2.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"destination/serviceDeliveryLocation"})
    public DispenseShipToLocationBean getDestinationServiceDeliveryLocation() {
        return this.destinationServiceDeliveryLocation;
    }

    /**
     * <p>Relationship: 
     * PORX_MT020070CA.Destination2.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setDestinationServiceDeliveryLocation(DispenseShipToLocationBean destinationServiceDeliveryLocation) {
        this.destinationServiceDeliveryLocation = destinationServiceDeliveryLocation;
    }

}
