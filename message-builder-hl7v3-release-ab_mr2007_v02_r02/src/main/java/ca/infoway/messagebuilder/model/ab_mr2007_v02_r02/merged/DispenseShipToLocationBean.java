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
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: DispenseShipToLocation</p>
 * 
 * <p>PORX_MT060160CA.ServiceDeliveryLocation: Dispense Ship-To 
 * Location</p>
 * 
 * <p>The location where the dispensed product is expected to 
 * be delivered.</p>
 * 
 * <p>Important as part of a claim for justifying shipping 
 * charges.</p>
 * 
 * <p>PORX_MT060040CA.ServiceDeliveryLocation: Dispense Ship-To 
 * Location</p>
 * 
 * <p>The location where the dispensed product is expected to 
 * be delivered.</p>
 * 
 * <p>Important as part of a claim for justifying shipping 
 * charges.</p>
 * 
 * <p>PORX_MT060340CA.ServiceDeliveryLocation: Dispense Ship-To 
 * Location</p>
 * 
 * <p>The location where the dispensed product is expected to 
 * be delivered.</p>
 * 
 * <p>Important as part of a claim for justifying shipping 
 * charges.</p>
 * 
 * <p>PORX_MT020070CA.ServiceDeliveryLocation: Dispense Ship-To 
 * Location</p>
 * 
 * <p>The location where the dispensed product is expected to 
 * be delivered.</p>
 * 
 * <p>Important as part of a claim for justifying shipping 
 * charges.</p>
 * 
 * <p>PORX_MT020060CA.ServiceDeliveryLocation: Dispense Ship-To 
 * Location</p>
 * 
 * <p>The location where the dispensed product is expected to 
 * be delivered.</p>
 * 
 * <p>Important as part of a claim for justifying shipping 
 * charges.</p>
 * 
 * <p>PORX_MT060090CA.ServiceDeliveryLocation: Dispense Ship-To 
 * Location</p>
 * 
 * <p>The location where the dispensed product is expected to 
 * be delivered.</p>
 * 
 * <p>Important as part of a claim for justifying shipping 
 * charges.</p>
 * 
 * <p>PORX_MT060010CA.ServiceDeliveryLocation: Dispense Ship-To 
 * Location</p>
 * 
 * <p>The location where the dispensed product is expected to 
 * be delivered.</p>
 * 
 * <p>Important as part of a claim for justifying shipping 
 * charges.</p>
 */
@Hl7PartTypeMapping({"PORX_MT010110CA.ServiceDeliveryLocation","PORX_MT010120CA.ServiceDeliveryLocation","PORX_MT020060CA.ServiceDeliveryLocation","PORX_MT020070CA.ServiceDeliveryLocation","PORX_MT060010CA.ServiceDeliveryLocation","PORX_MT060040CA.ServiceDeliveryLocation","PORX_MT060040CA.ServiceDeliveryLocation2","PORX_MT060090CA.ServiceDeliveryLocation","PORX_MT060160CA.ServiceDeliveryLocation","PORX_MT060160CA.ServiceDeliveryLocation2","PORX_MT060340CA.ServiceDeliveryLocation","PORX_MT060340CA.ServiceDeliveryLocation2"})
public class DispenseShipToLocationBean extends MessagePartBean {

    private static final long serialVersionUID = 20150326L;
    private AD addr = new ADImpl();


    /**
     * <p>Un-merged Business Name: ShipToAddress</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.ServiceDeliveryLocation.addr</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates where the dispensed product was sent.</p>
     * 
     * <p>Important as part of a claim for justifying shipping 
     * charges.</p>
     * 
     * <p>Un-merged Business Name: ShipToAddress</p>
     * 
     * <p>Relationship: 
     * PORX_MT060040CA.ServiceDeliveryLocation.addr</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates where the dispensed product was sent.</p>
     * 
     * <p>Important as part of a claim for justifying shipping 
     * charges.</p>
     * 
     * <p>Un-merged Business Name: PrescriptionShipToAddress</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120CA.ServiceDeliveryLocation.addr</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the location the dispensed medication should be 
     * shipped to, at the request of the patient or provider.</p>
     * 
     * <p>In some cases drugs need to be delivered to the patient 
     * instead of being picked up. In other cases, drugs need to be 
     * shipped to the physician's office to replace stock used for 
     * the patient.</p>
     * 
     * <p>Un-merged Business Name: PrescriptionShipToAddress</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.ServiceDeliveryLocation2.addr</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the location the dispensed medication should be 
     * shipped to, at the request of the patient or provider.</p>
     * 
     * <p>In some cases drugs need to be delivered to the patient 
     * instead of being picked up. In other cases, drugs need to be 
     * shipped to the physician's office to replace stock used for 
     * the patient.</p>
     * 
     * <p>Un-merged Business Name: PrescriptionShipToAddress</p>
     * 
     * <p>Relationship: 
     * PORX_MT060040CA.ServiceDeliveryLocation2.addr</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the location the dispensed device should be 
     * shipped to, at the request of the patient or provider.</p>
     * 
     * <p>In some cases devices need to be delivered to the patient 
     * instead of being picked up. In other cases, devices need to 
     * be shipped to the physician's office to replace stock used 
     * for the patient.</p>
     * 
     * <p>Un-merged Business Name: ShipToAddress</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.ServiceDeliveryLocation.addr</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates where the dispensed product was sent.</p>
     * 
     * <p>Important as part of a claim for justifying shipping 
     * charges.</p>
     * 
     * <p>Un-merged Business Name: ShipToAddress</p>
     * 
     * <p>Relationship: 
     * PORX_MT020070CA.ServiceDeliveryLocation.addr</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates where the dispensed product was sent.</p>
     * 
     * <p>Important as part of a claim for justifying shipping 
     * charges.</p>
     * 
     * <p>Un-merged Business Name: ShipToAddress</p>
     * 
     * <p>Relationship: 
     * PORX_MT020060CA.ServiceDeliveryLocation.addr</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates where the dispensed product was sent.</p>
     * 
     * <p>Important as part of a claim for justifying shipping 
     * charges.</p>
     * 
     * <p>Un-merged Business Name: PrescriptionShipToAddress</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.ServiceDeliveryLocation2.addr</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the location the dispensed medication should be 
     * shipped to, at the request of the patient or provider.</p>
     * 
     * <p>In some cases drugs need to be delivered to the patient 
     * instead of being picked up. In other cases, drugs need to be 
     * shipped to the physician's office to replace stock used for 
     * the patient.</p>
     * 
     * <p>Un-merged Business Name: ShipToAddress</p>
     * 
     * <p>Relationship: 
     * PORX_MT060090CA.ServiceDeliveryLocation.addr</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates where the dispensed product was sent.</p>
     * 
     * <p>Important as part of a claim for justifying shipping 
     * charges.</p>
     * 
     * <p>Un-merged Business Name: ShipToAddress</p>
     * 
     * <p>Relationship: 
     * PORX_MT060010CA.ServiceDeliveryLocation.addr</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates where the dispensed product was sent.</p>
     * 
     * <p>Important as part of a claim for justifying shipping 
     * charges.</p>
     * 
     * <p>Un-merged Business Name: PrescriptionShipToAddress</p>
     * 
     * <p>Relationship: 
     * PORX_MT010110CA.ServiceDeliveryLocation.addr</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the location the dispensed device should be 
     * shipped to, at the request of the patient or provider.</p>
     * 
     * <p>In some cases devices need to be delivered to the patient 
     * instead of being picked up. In other cases, devices need to 
     * be shipped to the physician's office to replace stock used 
     * for the patient.</p>
     */
    @Hl7XmlMapping({"addr"})
    public PostalAddress getAddr() {
        return this.addr.getValue();
    }

    /**
     * <p>Un-merged Business Name: ShipToAddress</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.ServiceDeliveryLocation.addr</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates where the dispensed product was sent.</p>
     * 
     * <p>Important as part of a claim for justifying shipping 
     * charges.</p>
     * 
     * <p>Un-merged Business Name: ShipToAddress</p>
     * 
     * <p>Relationship: 
     * PORX_MT060040CA.ServiceDeliveryLocation.addr</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates where the dispensed product was sent.</p>
     * 
     * <p>Important as part of a claim for justifying shipping 
     * charges.</p>
     * 
     * <p>Un-merged Business Name: PrescriptionShipToAddress</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120CA.ServiceDeliveryLocation.addr</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the location the dispensed medication should be 
     * shipped to, at the request of the patient or provider.</p>
     * 
     * <p>In some cases drugs need to be delivered to the patient 
     * instead of being picked up. In other cases, drugs need to be 
     * shipped to the physician's office to replace stock used for 
     * the patient.</p>
     * 
     * <p>Un-merged Business Name: PrescriptionShipToAddress</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.ServiceDeliveryLocation2.addr</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the location the dispensed medication should be 
     * shipped to, at the request of the patient or provider.</p>
     * 
     * <p>In some cases drugs need to be delivered to the patient 
     * instead of being picked up. In other cases, drugs need to be 
     * shipped to the physician's office to replace stock used for 
     * the patient.</p>
     * 
     * <p>Un-merged Business Name: PrescriptionShipToAddress</p>
     * 
     * <p>Relationship: 
     * PORX_MT060040CA.ServiceDeliveryLocation2.addr</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the location the dispensed device should be 
     * shipped to, at the request of the patient or provider.</p>
     * 
     * <p>In some cases devices need to be delivered to the patient 
     * instead of being picked up. In other cases, devices need to 
     * be shipped to the physician's office to replace stock used 
     * for the patient.</p>
     * 
     * <p>Un-merged Business Name: ShipToAddress</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.ServiceDeliveryLocation.addr</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates where the dispensed product was sent.</p>
     * 
     * <p>Important as part of a claim for justifying shipping 
     * charges.</p>
     * 
     * <p>Un-merged Business Name: ShipToAddress</p>
     * 
     * <p>Relationship: 
     * PORX_MT020070CA.ServiceDeliveryLocation.addr</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates where the dispensed product was sent.</p>
     * 
     * <p>Important as part of a claim for justifying shipping 
     * charges.</p>
     * 
     * <p>Un-merged Business Name: ShipToAddress</p>
     * 
     * <p>Relationship: 
     * PORX_MT020060CA.ServiceDeliveryLocation.addr</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates where the dispensed product was sent.</p>
     * 
     * <p>Important as part of a claim for justifying shipping 
     * charges.</p>
     * 
     * <p>Un-merged Business Name: PrescriptionShipToAddress</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.ServiceDeliveryLocation2.addr</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the location the dispensed medication should be 
     * shipped to, at the request of the patient or provider.</p>
     * 
     * <p>In some cases drugs need to be delivered to the patient 
     * instead of being picked up. In other cases, drugs need to be 
     * shipped to the physician's office to replace stock used for 
     * the patient.</p>
     * 
     * <p>Un-merged Business Name: ShipToAddress</p>
     * 
     * <p>Relationship: 
     * PORX_MT060090CA.ServiceDeliveryLocation.addr</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates where the dispensed product was sent.</p>
     * 
     * <p>Important as part of a claim for justifying shipping 
     * charges.</p>
     * 
     * <p>Un-merged Business Name: ShipToAddress</p>
     * 
     * <p>Relationship: 
     * PORX_MT060010CA.ServiceDeliveryLocation.addr</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates where the dispensed product was sent.</p>
     * 
     * <p>Important as part of a claim for justifying shipping 
     * charges.</p>
     * 
     * <p>Un-merged Business Name: PrescriptionShipToAddress</p>
     * 
     * <p>Relationship: 
     * PORX_MT010110CA.ServiceDeliveryLocation.addr</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the location the dispensed device should be 
     * shipped to, at the request of the patient or provider.</p>
     * 
     * <p>In some cases devices need to be delivered to the patient 
     * instead of being picked up. In other cases, devices need to 
     * be shipped to the physician's office to replace stock used 
     * for the patient.</p>
     */
    public void setAddr(PostalAddress addr) {
        this.addr.setValue(addr);
    }

}
