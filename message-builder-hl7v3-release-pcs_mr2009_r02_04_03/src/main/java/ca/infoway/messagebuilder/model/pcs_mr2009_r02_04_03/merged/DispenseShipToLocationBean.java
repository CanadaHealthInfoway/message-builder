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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.ServiceDeliveryLocationRoleType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



/**
 * <p>PRPM_MT303010CA.ServiceDeliveryLocation: Service Delivery 
 * Location</p>
 * 
 * <p>Roleclass required to support the identification of the 
 * physical location where healthcare services are provided</p>
 * 
 * <p>A role played by a place at which services may be 
 * provided. The RIM defines two specializations of service 
 * delivery location: 1. incidental service delivery location - 
 * A role played by a place at which health care services may 
 * be provided without prior designation or authorization and 
 * 2. dedicated service delivery location - A role played by a 
 * place that is intended to house the provision of services. 
 * Scoper is the Entity (typically Organization) that provides 
 * these services. This is not synonymous with 
 * &quot;ownership&quot;. This can be further characterized by 
 * a role code of: A)DedicatedClinicalLocationRoleType - A role 
 * of a place that further classifies the clinical setting 
 * (e.g., cardiology clinic, primary care clinic, 
 * rehabilitation hospital, skilled nursing facility) in which 
 * care is delivered during an encounter or 
 * B)DedicatedNonClinicalLocationRoleType - A role of a place 
 * that further classifies the setting in which non-clinical 
 * services are delivered. A given physical place can play 
 * multiple service delivery location roles each with its own 
 * attributes. For example, a Podiatric clinic and Research 
 * clinic may meet on alternate days in the same physical 
 * location; each clinic uses its own mailing address and 
 * telephone number.</p>
 * 
 * <p>PORX_MT060340CA.ServiceDeliveryLocation: Dispense Ship-To 
 * Location</p>
 * 
 * <p>Important as part of a claim for justifying shipping 
 * charges.</p>
 * 
 * <p>The location where the dispensed product is expected to 
 * be delivered.</p>
 * 
 * <p>PORX_MT020070CA.ServiceDeliveryLocation: Dispense Ship-To 
 * Location</p>
 * 
 * <p>Important as part of a claim for justifying shipping 
 * charges.</p>
 * 
 * <p>The location where the dispensed product is expected to 
 * be delivered.</p>
 * 
 * <p>PORX_MT020060CA.ServiceDeliveryLocation: Dispense Ship-To 
 * Location</p>
 * 
 * <p>Important as part of a claim for justifying shipping 
 * charges.</p>
 * 
 * <p>The location where the dispensed product is expected to 
 * be delivered.</p>
 * 
 * <p>PORX_MT060010CA.ServiceDeliveryLocation: Dispense Ship-To 
 * Location</p>
 * 
 * <p>Important as part of a claim for justifying shipping 
 * charges.</p>
 * 
 * <p>The location where the dispensed product is expected to 
 * be delivered.</p>
 * 
 * <p>PORX_MT060160CA.ServiceDeliveryLocation: Dispense Ship-To 
 * Location</p>
 * 
 * <p>Important as part of a claim for justifying shipping 
 * charges.</p>
 * 
 * <p>The location where the dispensed product is expected to 
 * be delivered.</p>
 * 
 * <p>PORX_MT060040CA.ServiceDeliveryLocation: Dispense Ship-To 
 * Location</p>
 * 
 * <p>Important as part of a claim for justifying shipping 
 * charges.</p>
 * 
 * <p>The location where the dispensed product is expected to 
 * be delivered.</p>
 * 
 * <p>PRPM_MT301010CA.ServiceDeliveryLocation: Service Delivery 
 * Location</p>
 * 
 * <p>Roleclass required to support the identification of the 
 * physical location where healthcare services are provided</p>
 * 
 * <p>A role played by a place at which services may be 
 * provided. The RIM defines two specializations of service 
 * delivery location: 1. incidental service delivery location - 
 * A role played by a place at which health care services may 
 * be provided without prior designation or authorization and 
 * 2. dedicated service delivery location - A role played by a 
 * place that is intended to house the provision of services. 
 * Scoper is the Entity (typically Organization) that provides 
 * these services. This is not synonymous with 
 * &quot;ownership&quot;. This can be further characterized by 
 * a role code of: A)DedicatedClinicalLocationRoleType - A role 
 * of a place that further classifies the clinical setting 
 * (e.g., cardiology clinic, primary care clinic, 
 * rehabilitation hospital, skilled nursing facility) in which 
 * care is delivered during an encounter or 
 * B)DedicatedNonClinicalLocationRoleType - A role of a place 
 * that further classifies the setting in which non-clinical 
 * services are delivered. A given physical place can play 
 * multiple service delivery location roles each with its own 
 * attributes. For example, a Podiatric clinic and Research 
 * clinic may meet on alternate days in the same physical 
 * location; each clinic uses its own mailing address and 
 * telephone number.</p>
 * 
 * <p>PORX_MT060090CA.ServiceDeliveryLocation: Dispense Ship-To 
 * Location</p>
 * 
 * <p>Important as part of a claim for justifying shipping 
 * charges.</p>
 * 
 * <p>The location where the dispensed product is expected to 
 * be delivered.</p>
 */
@Hl7PartTypeMapping({"PORX_MT010110CA.ServiceDeliveryLocation","PORX_MT010120CA.ServiceDeliveryLocation","PORX_MT020060CA.ServiceDeliveryLocation","PORX_MT020070CA.ServiceDeliveryLocation","PORX_MT060010CA.ServiceDeliveryLocation","PORX_MT060040CA.ServiceDeliveryLocation","PORX_MT060040CA.ServiceDeliveryLocation2","PORX_MT060090CA.ServiceDeliveryLocation","PORX_MT060160CA.ServiceDeliveryLocation","PORX_MT060160CA.ServiceDeliveryLocation2","PORX_MT060340CA.ServiceDeliveryLocation","PORX_MT060340CA.ServiceDeliveryLocation2","PRPM_MT301010CA.ServiceDeliveryLocation","PRPM_MT303010CA.ServiceDeliveryLocation"})
public class DispenseShipToLocationBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.pr.prpm_mt301010ca.Choice, ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.pr.prpm_mt303010ca.Choice {

    private static final long serialVersionUID = 20150326L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private AD addr = new ADImpl();
    private TEL telecom = new TELImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private ST locationName = new STImpl();


    /**
     * <p>Business Name: ServiceDeliveryLocationIdentifier</p>
     * 
     * <p>Un-merged Business Name: 
     * ServiceDeliveryLocationIdentifier</p>
     * 
     * <p>Relationship: PRPM_MT303010CA.ServiceDeliveryLocation.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the validation and 
     * identification of the service delivery location</p>
     * 
     * <p>A unique identifier for the service delivery 
     * location.</p>
     * 
     * <p>Un-merged Business Name: 
     * ServiceDeliveryLocationIdentifier</p>
     * 
     * <p>Relationship: PRPM_MT301010CA.ServiceDeliveryLocation.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the validation and 
     * identification of the service delivery location</p>
     * 
     * <p>A unique identifier for the service delivery 
     * location.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: ServiceDeliveryLocationIdentifier</p>
     * 
     * <p>Un-merged Business Name: 
     * ServiceDeliveryLocationIdentifier</p>
     * 
     * <p>Relationship: PRPM_MT303010CA.ServiceDeliveryLocation.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the validation and 
     * identification of the service delivery location</p>
     * 
     * <p>A unique identifier for the service delivery 
     * location.</p>
     * 
     * <p>Un-merged Business Name: 
     * ServiceDeliveryLocationIdentifier</p>
     * 
     * <p>Relationship: PRPM_MT301010CA.ServiceDeliveryLocation.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the validation and 
     * identification of the service delivery location</p>
     * 
     * <p>A unique identifier for the service delivery 
     * location.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: ServiceDeliveryLocationType</p>
     * 
     * <p>Un-merged Business Name: ServiceDeliveryLocationType</p>
     * 
     * <p>Relationship: 
     * PRPM_MT303010CA.ServiceDeliveryLocation.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the validation and 
     * identification of the service delivery location</p>
     * 
     * <p>The code identifying the specific service delivery 
     * location</p>
     * 
     * <p>Un-merged Business Name: ServiceDeliveryLocationType</p>
     * 
     * <p>Relationship: 
     * PRPM_MT301010CA.ServiceDeliveryLocation.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the validation and 
     * identification of the service delivery location</p>
     * 
     * <p>The code identifying the specific service delivery 
     * location</p>
     */
    @Hl7XmlMapping({"code"})
    public ServiceDeliveryLocationRoleType getCode() {
        return (ServiceDeliveryLocationRoleType) this.code.getValue();
    }

    /**
     * <p>Business Name: ServiceDeliveryLocationType</p>
     * 
     * <p>Un-merged Business Name: ServiceDeliveryLocationType</p>
     * 
     * <p>Relationship: 
     * PRPM_MT303010CA.ServiceDeliveryLocation.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the validation and 
     * identification of the service delivery location</p>
     * 
     * <p>The code identifying the specific service delivery 
     * location</p>
     * 
     * <p>Un-merged Business Name: ServiceDeliveryLocationType</p>
     * 
     * <p>Relationship: 
     * PRPM_MT301010CA.ServiceDeliveryLocation.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the validation and 
     * identification of the service delivery location</p>
     * 
     * <p>The code identifying the specific service delivery 
     * location</p>
     */
    public void setCode(ServiceDeliveryLocationRoleType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Un-merged Business Name: ServiceDeliveryLocationAddress</p>
     * 
     * <p>Relationship: 
     * PRPM_MT303010CA.ServiceDeliveryLocation.addr</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the validation and 
     * identification of the service delivery location</p>
     * 
     * <p>Address of the specific service delivery location</p>
     * 
     * <p>Un-merged Business Name: PrescriptionShipToAddress</p>
     * 
     * <p>Relationship: 
     * PORX_MT060040CA.ServiceDeliveryLocation2.addr</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>In some cases devices need to be delivered to the patient 
     * instead of being picked up. In other cases, devices need to 
     * be shipped to the physician's office to replace stock used 
     * for the patient.</p>
     * 
     * <p>Indicates the location the dispensed device should be 
     * shipped to, at the request of the patient or provider.</p>
     * 
     * <p>Un-merged Business Name: ShipToAddress</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.ServiceDeliveryLocation.addr</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Important as part of a claim for justifying shipping 
     * charges.</p>
     * 
     * <p>Indicates where the dispensed product was sent.</p>
     * 
     * <p>Un-merged Business Name: ShipToAddress</p>
     * 
     * <p>Relationship: 
     * PORX_MT020070CA.ServiceDeliveryLocation.addr</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Important as part of a claim for justifying shipping 
     * charges.</p>
     * 
     * <p>Indicates where the dispensed product was sent.</p>
     * 
     * <p>Un-merged Business Name: ShipToAddress</p>
     * 
     * <p>Relationship: 
     * PORX_MT020060CA.ServiceDeliveryLocation.addr</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Important as part of a claim for justifying shipping 
     * charges.</p>
     * 
     * <p>Indicates where the dispensed product was sent.</p>
     * 
     * <p>Un-merged Business Name: PrescriptionShipToAddress</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.ServiceDeliveryLocation2.addr</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>In some cases drugs need to be delivered to the patient 
     * instead of being picked up. In other cases, drugs need to be 
     * shipped to the physician's office to replace stock used for 
     * the patient.</p>
     * 
     * <p>Indicates the location the dispensed medication should be 
     * shipped to, at the request of the patient or provider.</p>
     * 
     * <p>Un-merged Business Name: ShipToAddress</p>
     * 
     * <p>Relationship: 
     * PORX_MT060010CA.ServiceDeliveryLocation.addr</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Important as part of a claim for justifying shipping 
     * charges.</p>
     * 
     * <p>Indicates where the dispensed product was sent.</p>
     * 
     * <p>Un-merged Business Name: ShipToAddress</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.ServiceDeliveryLocation.addr</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Important as part of a claim for justifying shipping 
     * charges.</p>
     * 
     * <p>Indicates where the dispensed product was sent.</p>
     * 
     * <p>Un-merged Business Name: ShipToAddress</p>
     * 
     * <p>Relationship: 
     * PORX_MT060040CA.ServiceDeliveryLocation.addr</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Important as part of a claim for justifying shipping 
     * charges.</p>
     * 
     * <p>Indicates where the dispensed product was sent.</p>
     * 
     * <p>Un-merged Business Name: PrescriptionShipToAddress</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120CA.ServiceDeliveryLocation.addr</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>In some cases drugs need to be delivered to the patient 
     * instead of being picked up. In other cases, drugs need to be 
     * shipped to the physician's office to replace stock used for 
     * the patient.</p>
     * 
     * <p>Indicates the location the dispensed medication should be 
     * shipped to, at the request of the patient or provider.</p>
     * 
     * <p>Un-merged Business Name: PrescriptionShipToAddress</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.ServiceDeliveryLocation2.addr</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>In some cases drugs need to be delivered to the patient 
     * instead of being picked up. In other cases, drugs need to be 
     * shipped to the physician's office to replace stock used for 
     * the patient.</p>
     * 
     * <p>Indicates the location the dispensed medication should be 
     * shipped to, at the request of the patient or provider.</p>
     * 
     * <p>Un-merged Business Name: ServiceDeliveryLocationAddress</p>
     * 
     * <p>Relationship: 
     * PRPM_MT301010CA.ServiceDeliveryLocation.addr</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Populated attribute supports the validation and 
     * identification of the service delivery location</p>
     * 
     * <p>Address of the specific service delivery location</p>
     * 
     * <p>Un-merged Business Name: ShipToAddress</p>
     * 
     * <p>Relationship: 
     * PORX_MT060090CA.ServiceDeliveryLocation.addr</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Important as part of a claim for justifying shipping 
     * charges.</p>
     * 
     * <p>Indicates where the dispensed product was sent.</p>
     * 
     * <p>Un-merged Business Name: PrescriptionShipToAddress</p>
     * 
     * <p>Relationship: 
     * PORX_MT010110CA.ServiceDeliveryLocation.addr</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>In some cases devices need to be delivered to the patient 
     * instead of being picked up. In other cases, devices need to 
     * be shipped to the physician's office to replace stock used 
     * for the patient.</p>
     * 
     * <p>Indicates the location the dispensed device should be 
     * shipped to, at the request of the patient or provider.</p>
     */
    @Hl7XmlMapping({"addr"})
    public PostalAddress getAddr() {
        return this.addr.getValue();
    }

    /**
     * <p>Un-merged Business Name: ServiceDeliveryLocationAddress</p>
     * 
     * <p>Relationship: 
     * PRPM_MT303010CA.ServiceDeliveryLocation.addr</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the validation and 
     * identification of the service delivery location</p>
     * 
     * <p>Address of the specific service delivery location</p>
     * 
     * <p>Un-merged Business Name: PrescriptionShipToAddress</p>
     * 
     * <p>Relationship: 
     * PORX_MT060040CA.ServiceDeliveryLocation2.addr</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>In some cases devices need to be delivered to the patient 
     * instead of being picked up. In other cases, devices need to 
     * be shipped to the physician's office to replace stock used 
     * for the patient.</p>
     * 
     * <p>Indicates the location the dispensed device should be 
     * shipped to, at the request of the patient or provider.</p>
     * 
     * <p>Un-merged Business Name: ShipToAddress</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.ServiceDeliveryLocation.addr</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Important as part of a claim for justifying shipping 
     * charges.</p>
     * 
     * <p>Indicates where the dispensed product was sent.</p>
     * 
     * <p>Un-merged Business Name: ShipToAddress</p>
     * 
     * <p>Relationship: 
     * PORX_MT020070CA.ServiceDeliveryLocation.addr</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Important as part of a claim for justifying shipping 
     * charges.</p>
     * 
     * <p>Indicates where the dispensed product was sent.</p>
     * 
     * <p>Un-merged Business Name: ShipToAddress</p>
     * 
     * <p>Relationship: 
     * PORX_MT020060CA.ServiceDeliveryLocation.addr</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Important as part of a claim for justifying shipping 
     * charges.</p>
     * 
     * <p>Indicates where the dispensed product was sent.</p>
     * 
     * <p>Un-merged Business Name: PrescriptionShipToAddress</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.ServiceDeliveryLocation2.addr</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>In some cases drugs need to be delivered to the patient 
     * instead of being picked up. In other cases, drugs need to be 
     * shipped to the physician's office to replace stock used for 
     * the patient.</p>
     * 
     * <p>Indicates the location the dispensed medication should be 
     * shipped to, at the request of the patient or provider.</p>
     * 
     * <p>Un-merged Business Name: ShipToAddress</p>
     * 
     * <p>Relationship: 
     * PORX_MT060010CA.ServiceDeliveryLocation.addr</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Important as part of a claim for justifying shipping 
     * charges.</p>
     * 
     * <p>Indicates where the dispensed product was sent.</p>
     * 
     * <p>Un-merged Business Name: ShipToAddress</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.ServiceDeliveryLocation.addr</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Important as part of a claim for justifying shipping 
     * charges.</p>
     * 
     * <p>Indicates where the dispensed product was sent.</p>
     * 
     * <p>Un-merged Business Name: ShipToAddress</p>
     * 
     * <p>Relationship: 
     * PORX_MT060040CA.ServiceDeliveryLocation.addr</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Important as part of a claim for justifying shipping 
     * charges.</p>
     * 
     * <p>Indicates where the dispensed product was sent.</p>
     * 
     * <p>Un-merged Business Name: PrescriptionShipToAddress</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120CA.ServiceDeliveryLocation.addr</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>In some cases drugs need to be delivered to the patient 
     * instead of being picked up. In other cases, drugs need to be 
     * shipped to the physician's office to replace stock used for 
     * the patient.</p>
     * 
     * <p>Indicates the location the dispensed medication should be 
     * shipped to, at the request of the patient or provider.</p>
     * 
     * <p>Un-merged Business Name: PrescriptionShipToAddress</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.ServiceDeliveryLocation2.addr</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>In some cases drugs need to be delivered to the patient 
     * instead of being picked up. In other cases, drugs need to be 
     * shipped to the physician's office to replace stock used for 
     * the patient.</p>
     * 
     * <p>Indicates the location the dispensed medication should be 
     * shipped to, at the request of the patient or provider.</p>
     * 
     * <p>Un-merged Business Name: ServiceDeliveryLocationAddress</p>
     * 
     * <p>Relationship: 
     * PRPM_MT301010CA.ServiceDeliveryLocation.addr</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Populated attribute supports the validation and 
     * identification of the service delivery location</p>
     * 
     * <p>Address of the specific service delivery location</p>
     * 
     * <p>Un-merged Business Name: ShipToAddress</p>
     * 
     * <p>Relationship: 
     * PORX_MT060090CA.ServiceDeliveryLocation.addr</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Important as part of a claim for justifying shipping 
     * charges.</p>
     * 
     * <p>Indicates where the dispensed product was sent.</p>
     * 
     * <p>Un-merged Business Name: PrescriptionShipToAddress</p>
     * 
     * <p>Relationship: 
     * PORX_MT010110CA.ServiceDeliveryLocation.addr</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>In some cases devices need to be delivered to the patient 
     * instead of being picked up. In other cases, devices need to 
     * be shipped to the physician's office to replace stock used 
     * for the patient.</p>
     * 
     * <p>Indicates the location the dispensed device should be 
     * shipped to, at the request of the patient or provider.</p>
     */
    public void setAddr(PostalAddress addr) {
        this.addr.setValue(addr);
    }


    /**
     * <p>Business Name: ServiceDeliveryLocationTelecom</p>
     * 
     * <p>Un-merged Business Name: ServiceDeliveryLocationTelecom</p>
     * 
     * <p>Relationship: 
     * PRPM_MT303010CA.ServiceDeliveryLocation.telecom</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the validation and 
     * identification of the service delivery location</p>
     * 
     * <p>The telecom for the specific service delivery 
     * location</p>
     * 
     * <p>Un-merged Business Name: ServiceDeliveryLocationTelecom</p>
     * 
     * <p>Relationship: 
     * PRPM_MT301010CA.ServiceDeliveryLocation.telecom</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the validation and 
     * identification of the service delivery location</p>
     * 
     * <p>The telecom for the specific service delivery 
     * location</p>
     */
    @Hl7XmlMapping({"telecom"})
    public TelecommunicationAddress getTelecom() {
        return this.telecom.getValue();
    }

    /**
     * <p>Business Name: ServiceDeliveryLocationTelecom</p>
     * 
     * <p>Un-merged Business Name: ServiceDeliveryLocationTelecom</p>
     * 
     * <p>Relationship: 
     * PRPM_MT303010CA.ServiceDeliveryLocation.telecom</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the validation and 
     * identification of the service delivery location</p>
     * 
     * <p>The telecom for the specific service delivery 
     * location</p>
     * 
     * <p>Un-merged Business Name: ServiceDeliveryLocationTelecom</p>
     * 
     * <p>Relationship: 
     * PRPM_MT301010CA.ServiceDeliveryLocation.telecom</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the validation and 
     * identification of the service delivery location</p>
     * 
     * <p>The telecom for the specific service delivery 
     * location</p>
     */
    public void setTelecom(TelecommunicationAddress telecom) {
        this.telecom.setValue(telecom);
    }


    /**
     * <p>Business Name: ServiceDeliveryLocationEffectiveDate</p>
     * 
     * <p>Un-merged Business Name: 
     * ServiceDeliveryLocationEffectiveDate</p>
     * 
     * <p>Relationship: 
     * PRPM_MT303010CA.ServiceDeliveryLocation.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the validation and 
     * identification of the service delivery location</p>
     * 
     * <p>Effective date of the specific service delivery 
     * location</p>
     * 
     * <p>Un-merged Business Name: 
     * ServiceDeliveryLocationEffectiveDate</p>
     * 
     * <p>Relationship: 
     * PRPM_MT301010CA.ServiceDeliveryLocation.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the validation and 
     * identification of the service delivery location</p>
     * 
     * <p>Effective date of the specific service delivery 
     * location</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: ServiceDeliveryLocationEffectiveDate</p>
     * 
     * <p>Un-merged Business Name: 
     * ServiceDeliveryLocationEffectiveDate</p>
     * 
     * <p>Relationship: 
     * PRPM_MT303010CA.ServiceDeliveryLocation.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the validation and 
     * identification of the service delivery location</p>
     * 
     * <p>Effective date of the specific service delivery 
     * location</p>
     * 
     * <p>Un-merged Business Name: 
     * ServiceDeliveryLocationEffectiveDate</p>
     * 
     * <p>Relationship: 
     * PRPM_MT301010CA.ServiceDeliveryLocation.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the validation and 
     * identification of the service delivery location</p>
     * 
     * <p>Effective date of the specific service delivery 
     * location</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: ServiceDeliveryLocationName</p>
     * 
     * <p>Un-merged Business Name: ServiceDeliveryLocationName</p>
     * 
     * <p>Relationship: PRPM_MT303010CA.Place.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the validation and 
     * identification of the service delivery location</p>
     * 
     * <p>The name of the service delivery location</p>
     * 
     * <p>Un-merged Business Name: ServiceDeliveryLocationName</p>
     * 
     * <p>Relationship: PRPM_MT301010CA.Place.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the validation and 
     * identification of the service delivery location</p>
     * 
     * <p>The name of the service delivery location</p>
     */
    @Hl7XmlMapping({"location/name"})
    public String getLocationName() {
        return this.locationName.getValue();
    }

    /**
     * <p>Business Name: ServiceDeliveryLocationName</p>
     * 
     * <p>Un-merged Business Name: ServiceDeliveryLocationName</p>
     * 
     * <p>Relationship: PRPM_MT303010CA.Place.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the validation and 
     * identification of the service delivery location</p>
     * 
     * <p>The name of the service delivery location</p>
     * 
     * <p>Un-merged Business Name: ServiceDeliveryLocationName</p>
     * 
     * <p>Relationship: PRPM_MT301010CA.Place.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the validation and 
     * identification of the service delivery location</p>
     * 
     * <p>The name of the service delivery location</p>
     */
    public void setLocationName(String locationName) {
        this.locationName.setValue(locationName);
    }

}