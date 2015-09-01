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
package ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.pharmacy.merged;

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
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.common.coct_mt220210ca.DrugProductBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.common.coct_mt910107ca.RelatedPersonBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.merged.DispenseShipToLocationBean;
import java.util.Date;



@Hl7PartTypeMapping({"PORX_MT060090CA.SupplyEvent","PORX_MT060100CA.SupplyEvent","PORX_MT060160CA.SupplyEvent","PORX_MT060340CA.SupplyEvent"})
public class SupplyEventBean extends MessagePartBean {

    private static final long serialVersionUID = 20150901L;
    private CV code = new CVImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private PQ quantity = new PQImpl();
    private IVL<TS, Interval<Date>> expectedUseTime = new IVLImpl<TS, Interval<Date>>();
    private DrugProductBean productMedication;
    private RelatedPersonBean receiverPersonalRelationship;
    private DispenseShipToLocationBean destinationServiceDeliveryLocation;


    /**
     * <p>Business Name: DispenseType</p>
     * 
     * <p>Un-merged Business Name: DispenseType</p>
     * 
     * <p>Relationship: PORX_MT060340CA.SupplyEvent.code</p>
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
     * 
     * <p>Un-merged Business Name: DispenseType</p>
     * 
     * <p>Relationship: PORX_MT060160CA.SupplyEvent.code</p>
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
     * 
     * <p>Un-merged Business Name: DispenseType</p>
     * 
     * <p>Relationship: PORX_MT060090CA.SupplyEvent.code</p>
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
     * <p>Business Name: DispenseType</p>
     * 
     * <p>Un-merged Business Name: DispenseType</p>
     * 
     * <p>Relationship: PORX_MT060340CA.SupplyEvent.code</p>
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
     * 
     * <p>Un-merged Business Name: DispenseType</p>
     * 
     * <p>Relationship: PORX_MT060160CA.SupplyEvent.code</p>
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
     * 
     * <p>Un-merged Business Name: DispenseType</p>
     * 
     * <p>Relationship: PORX_MT060090CA.SupplyEvent.code</p>
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
     * <p>Un-merged Business Name: DispenseProcessingAndPickupDate</p>
     * 
     * <p>Relationship: PORX_MT060340CA.SupplyEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used by the system in calculating expected exhaustion 
     * time. Valuable in compliance checking. This attribute is 
     * mandatory because an existing dispense record must at least 
     * indicate the date it was processed.</p>
     * 
     * <p>Represents the date the dispense product was prepared and 
     * when the product was picked up by or delivered to the 
     * patient. The dispense processing date and pickup date can be 
     * back dated to reflect when the actual processing and pickup 
     * occurred. The lower-bound of the period signifies the 
     * dispense-processing date whereas the upper-bound signifies 
     * the dispense-pickup date.</p>
     * 
     * <p>Un-merged Business Name: DispensedProcessingAndPickupDate</p>
     * 
     * <p>Relationship: PORX_MT060160CA.SupplyEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used by the system in calculating expected exhaustion 
     * time. Valuable in compliance checking.</p><p>This attribute 
     * is mandatory because an existing dispense record must at 
     * least indicate the date it was processed.</p>
     * 
     * <p>Represents the date the dispense product was prepared and 
     * when the product was picked up by or delivered to the 
     * patient. The dispense processing date and pickup date can be 
     * back dated to reflect when the actual processing and pickup 
     * occurred. The lower-bound of the period signifies the 
     * dispense-processing date whereas the upper-bound signifies 
     * the dispense-pickup date.</p>
     * 
     * <p>Un-merged Business Name: DispenseProcessingAndPickupDate</p>
     * 
     * <p>Relationship: PORX_MT060090CA.SupplyEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used by the system in calculating expected exhaustion 
     * time. Valuable in compliance checking. This attribute is 
     * mandatory because an existing dispense record must at least 
     * indicate the date it was processed.</p>
     * 
     * <p>Represents the date the dispense product was prepared and 
     * when the product was picked up by or delivered to the 
     * patient. The dispense processing date and pickup date can be 
     * back dated to reflect when the actual processing and pickup 
     * occurred. The lower-bound of the period signifies the 
     * dispense-processing date whereas the upper-bound signifies 
     * the dispense-pickup date.</p>
     * 
     * <p>Un-merged Business Name: DispenseProcessingAndPickupDate</p>
     * 
     * <p>Relationship: PORX_MT060100CA.SupplyEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used by the system in calculating expected exhaustion 
     * time. Valuable in compliance checking.</p><p>This attribute 
     * is mandatory because an existing dispense record must at 
     * least indicate the date it was processed.</p>
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
     * <p>Un-merged Business Name: DispenseProcessingAndPickupDate</p>
     * 
     * <p>Relationship: PORX_MT060340CA.SupplyEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used by the system in calculating expected exhaustion 
     * time. Valuable in compliance checking. This attribute is 
     * mandatory because an existing dispense record must at least 
     * indicate the date it was processed.</p>
     * 
     * <p>Represents the date the dispense product was prepared and 
     * when the product was picked up by or delivered to the 
     * patient. The dispense processing date and pickup date can be 
     * back dated to reflect when the actual processing and pickup 
     * occurred. The lower-bound of the period signifies the 
     * dispense-processing date whereas the upper-bound signifies 
     * the dispense-pickup date.</p>
     * 
     * <p>Un-merged Business Name: DispensedProcessingAndPickupDate</p>
     * 
     * <p>Relationship: PORX_MT060160CA.SupplyEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used by the system in calculating expected exhaustion 
     * time. Valuable in compliance checking.</p><p>This attribute 
     * is mandatory because an existing dispense record must at 
     * least indicate the date it was processed.</p>
     * 
     * <p>Represents the date the dispense product was prepared and 
     * when the product was picked up by or delivered to the 
     * patient. The dispense processing date and pickup date can be 
     * back dated to reflect when the actual processing and pickup 
     * occurred. The lower-bound of the period signifies the 
     * dispense-processing date whereas the upper-bound signifies 
     * the dispense-pickup date.</p>
     * 
     * <p>Un-merged Business Name: DispenseProcessingAndPickupDate</p>
     * 
     * <p>Relationship: PORX_MT060090CA.SupplyEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used by the system in calculating expected exhaustion 
     * time. Valuable in compliance checking. This attribute is 
     * mandatory because an existing dispense record must at least 
     * indicate the date it was processed.</p>
     * 
     * <p>Represents the date the dispense product was prepared and 
     * when the product was picked up by or delivered to the 
     * patient. The dispense processing date and pickup date can be 
     * back dated to reflect when the actual processing and pickup 
     * occurred. The lower-bound of the period signifies the 
     * dispense-processing date whereas the upper-bound signifies 
     * the dispense-pickup date.</p>
     * 
     * <p>Un-merged Business Name: DispenseProcessingAndPickupDate</p>
     * 
     * <p>Relationship: PORX_MT060100CA.SupplyEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used by the system in calculating expected exhaustion 
     * time. Valuable in compliance checking.</p><p>This attribute 
     * is mandatory because an existing dispense record must at 
     * least indicate the date it was processed.</p>
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
     * <p>Business Name: DispensedQuantity</p>
     * 
     * <p>Un-merged Business Name: DispensedQuantity</p>
     * 
     * <p>Relationship: PORX_MT060340CA.SupplyEvent.quantity</p>
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
     * 
     * <p>Un-merged Business Name: DispensedQuantity</p>
     * 
     * <p>Relationship: PORX_MT060160CA.SupplyEvent.quantity</p>
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
     * 
     * <p>Un-merged Business Name: DispensedQuantity</p>
     * 
     * <p>Relationship: PORX_MT060090CA.SupplyEvent.quantity</p>
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
     * 
     * <p>Un-merged Business Name: DispensedQuantity</p>
     * 
     * <p>Relationship: PORX_MT060100CA.SupplyEvent.quantity</p>
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
     * <p>Business Name: DispensedQuantity</p>
     * 
     * <p>Un-merged Business Name: DispensedQuantity</p>
     * 
     * <p>Relationship: PORX_MT060340CA.SupplyEvent.quantity</p>
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
     * 
     * <p>Un-merged Business Name: DispensedQuantity</p>
     * 
     * <p>Relationship: PORX_MT060160CA.SupplyEvent.quantity</p>
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
     * 
     * <p>Un-merged Business Name: DispensedQuantity</p>
     * 
     * <p>Relationship: PORX_MT060090CA.SupplyEvent.quantity</p>
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
     * 
     * <p>Un-merged Business Name: DispensedQuantity</p>
     * 
     * <p>Relationship: PORX_MT060100CA.SupplyEvent.quantity</p>
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
     * <p>Un-merged Business Name: DispenseDaysSupply</p>
     * 
     * <p>Relationship: PORX_MT060340CA.SupplyEvent.expectedUseTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Useful in monitoring patient compliance. May also be 
     * useful in determining and managing certain contraindications 
     * ('Fill-Too-Soon', 'Fill-Too-Late', and 'Duration of 
     * Therapy'). Because 'Days Supply' may be necessary to compute 
     * total dispensed quantity, it is made a 'populated' 
     * field.</p>
     * 
     * <p>The number of days that the dispensed quantity is 
     * expected to last.</p><p>Cannot be mandatory as there are 
     * some situations where 'as needed' cannot be used to 
     * determine days supply.</p>
     * 
     * <p>Un-merged Business Name: DispensedDaysSupply</p>
     * 
     * <p>Relationship: PORX_MT060160CA.SupplyEvent.expectedUseTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Useful in monitoring patient compliance. May also be 
     * useful in determining and managing certain contraindications 
     * ('Fill-Too-Soon', 'Fill-Too-Late', and 'Duration of 
     * Therapy'). Thus the attribute is marked as 'populated'.</p>
     * 
     * <p>The number of days that the dispensed quantity is 
     * expected to last.</p>
     * 
     * <p>Un-merged Business Name: DispensedDaysSupply</p>
     * 
     * <p>Relationship: PORX_MT060090CA.SupplyEvent.expectedUseTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Useful in monitoring patient compliance. May also be 
     * useful in determining and managing certain contraindications 
     * ('Fill-Too-Soon', 'Fill-Too-Late', and 'Duration of 
     * Therapy'). Because 'Days Supply' may be necessary to compute 
     * total dispensed quantity, it is made a 'populated' 
     * field.</p>
     * 
     * <p>The number of days that the dispensed quantity is 
     * expected to last. Cannot be mandatory as there are some 
     * situations where 'as needed' cannot be used to determine 
     * days supply.</p>
     * 
     * <p>Un-merged Business Name: DispensedDaysSupply</p>
     * 
     * <p>Relationship: PORX_MT060100CA.SupplyEvent.expectedUseTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Useful in monitoring patient compliance. May also be 
     * useful in determining and managing certain contraindications 
     * ('Fill-Too-Soon', 'Fill-Too-Late', and 'Duration of 
     * Therapy'). Because 'Days Supply' may be necessary to compute 
     * total dispensed quantity, it is made a 'populated' 
     * field.</p>
     * 
     * <p>The number of days that the dispensed quantity is 
     * expected to last. Cannot be mandatory as there are some 
     * situations where 'as needed' cannot be used to determine 
     * days supply.</p>
     */
    @Hl7XmlMapping({"expectedUseTime"})
    public Interval<Date> getExpectedUseTime() {
        return this.expectedUseTime.getValue();
    }

    /**
     * <p>Un-merged Business Name: DispenseDaysSupply</p>
     * 
     * <p>Relationship: PORX_MT060340CA.SupplyEvent.expectedUseTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Useful in monitoring patient compliance. May also be 
     * useful in determining and managing certain contraindications 
     * ('Fill-Too-Soon', 'Fill-Too-Late', and 'Duration of 
     * Therapy'). Because 'Days Supply' may be necessary to compute 
     * total dispensed quantity, it is made a 'populated' 
     * field.</p>
     * 
     * <p>The number of days that the dispensed quantity is 
     * expected to last.</p><p>Cannot be mandatory as there are 
     * some situations where 'as needed' cannot be used to 
     * determine days supply.</p>
     * 
     * <p>Un-merged Business Name: DispensedDaysSupply</p>
     * 
     * <p>Relationship: PORX_MT060160CA.SupplyEvent.expectedUseTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Useful in monitoring patient compliance. May also be 
     * useful in determining and managing certain contraindications 
     * ('Fill-Too-Soon', 'Fill-Too-Late', and 'Duration of 
     * Therapy'). Thus the attribute is marked as 'populated'.</p>
     * 
     * <p>The number of days that the dispensed quantity is 
     * expected to last.</p>
     * 
     * <p>Un-merged Business Name: DispensedDaysSupply</p>
     * 
     * <p>Relationship: PORX_MT060090CA.SupplyEvent.expectedUseTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Useful in monitoring patient compliance. May also be 
     * useful in determining and managing certain contraindications 
     * ('Fill-Too-Soon', 'Fill-Too-Late', and 'Duration of 
     * Therapy'). Because 'Days Supply' may be necessary to compute 
     * total dispensed quantity, it is made a 'populated' 
     * field.</p>
     * 
     * <p>The number of days that the dispensed quantity is 
     * expected to last. Cannot be mandatory as there are some 
     * situations where 'as needed' cannot be used to determine 
     * days supply.</p>
     * 
     * <p>Un-merged Business Name: DispensedDaysSupply</p>
     * 
     * <p>Relationship: PORX_MT060100CA.SupplyEvent.expectedUseTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Useful in monitoring patient compliance. May also be 
     * useful in determining and managing certain contraindications 
     * ('Fill-Too-Soon', 'Fill-Too-Late', and 'Duration of 
     * Therapy'). Because 'Days Supply' may be necessary to compute 
     * total dispensed quantity, it is made a 'populated' 
     * field.</p>
     * 
     * <p>The number of days that the dispensed quantity is 
     * expected to last. Cannot be mandatory as there are some 
     * situations where 'as needed' cannot be used to determine 
     * days supply.</p>
     */
    public void setExpectedUseTime(Interval<Date> expectedUseTime) {
        this.expectedUseTime.setValue(expectedUseTime);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060340CA.Product2.medication</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060160CA.Product2.medication</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060090CA.Product2.medication</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060100CA.Product2.medication</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"product/medication"})
    public DrugProductBean getProductMedication() {
        return this.productMedication;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060340CA.Product2.medication</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060160CA.Product2.medication</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060090CA.Product2.medication</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060100CA.Product2.medication</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setProductMedication(DrugProductBean productMedication) {
        this.productMedication = productMedication;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.Receiver2.personalRelationship</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.Receiver2.personalRelationship</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060090CA.Receiver2.personalRelationship</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"receiver/personalRelationship"})
    public RelatedPersonBean getReceiverPersonalRelationship() {
        return this.receiverPersonalRelationship;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.Receiver2.personalRelationship</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.Receiver2.personalRelationship</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060090CA.Receiver2.personalRelationship</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setReceiverPersonalRelationship(RelatedPersonBean receiverPersonalRelationship) {
        this.receiverPersonalRelationship = receiverPersonalRelationship;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.Destination2.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.Destination2.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060090CA.Destination2.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"destination/serviceDeliveryLocation"})
    public DispenseShipToLocationBean getDestinationServiceDeliveryLocation() {
        return this.destinationServiceDeliveryLocation;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.Destination2.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.Destination2.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060090CA.Destination2.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setDestinationServiceDeliveryLocation(DispenseShipToLocationBean destinationServiceDeliveryLocation) {
        this.destinationServiceDeliveryLocation = destinationServiceDeliveryLocation;
    }

}
