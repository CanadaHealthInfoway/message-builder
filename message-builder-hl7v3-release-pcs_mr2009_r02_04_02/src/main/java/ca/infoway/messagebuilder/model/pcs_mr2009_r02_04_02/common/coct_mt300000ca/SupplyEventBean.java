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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt300000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.ActPharmacySupplyType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt240003ca.ServiceLocationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.PatientEncounterBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.DispensedInBean;
import java.util.Date;



/**
 * <p>Patient classes are not referenced in the billable acts, 
 * as they are noted in the parent model (e.g. Invoice message) 
 * as the CoveredPartyAsPatient</p>
 */
@Hl7PartTypeMapping({"COCT_MT300000CA.SupplyEvent"})
@Hl7RootType
public class SupplyEventBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt280001ca.A_BillableActChoice {

    private static final long serialVersionUID = 20150326L;
    private CV code = new CVImpl();
    private TS effectiveTime = new TSImpl();
    private PQ quantity = new PQImpl();
    private IVL<TS, Interval<Date>> expectedUseTime = new IVLImpl<TS, Interval<Date>>();
    private DispensedInBean productContent;
    private PharmacistRoleBean performerPharmacistRole;
    private ServiceLocationBean originServiceDeliveryLocation;
    private ServiceLocationBean destinationServiceDeliveryLocation;
    private DispenseInstructionsBean pertinentInformation;
    private PatientEncounterBean componentOfPatientEncounter;


    /**
     * <p>Business Name: Type of Dispense</p>
     * 
     * <p>Relationship: COCT_MT300000CA.SupplyEvent.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"code"})
    public ActPharmacySupplyType getCode() {
        return (ActPharmacySupplyType) this.code.getValue();
    }

    /**
     * <p>Business Name: Type of Dispense</p>
     * 
     * <p>Relationship: COCT_MT300000CA.SupplyEvent.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setCode(ActPharmacySupplyType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: Dispense Time</p>
     * 
     * <p>Relationship: COCT_MT300000CA.SupplyEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Date getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: Dispense Time</p>
     * 
     * <p>Relationship: COCT_MT300000CA.SupplyEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: Total Dispensed</p>
     * 
     * <p>Relationship: COCT_MT300000CA.SupplyEvent.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"quantity"})
    public PhysicalQuantity getQuantity() {
        return this.quantity.getValue();
    }

    /**
     * <p>Business Name: Total Dispensed</p>
     * 
     * <p>Relationship: COCT_MT300000CA.SupplyEvent.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setQuantity(PhysicalQuantity quantity) {
        this.quantity.setValue(quantity);
    }


    /**
     * <p>Business Name: Dispensed Days Supply</p>
     * 
     * <p>Relationship: COCT_MT300000CA.SupplyEvent.expectedUseTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"expectedUseTime"})
    public Interval<Date> getExpectedUseTime() {
        return this.expectedUseTime.getValue();
    }

    /**
     * <p>Business Name: Dispensed Days Supply</p>
     * 
     * <p>Relationship: COCT_MT300000CA.SupplyEvent.expectedUseTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setExpectedUseTime(Interval<Date> expectedUseTime) {
        this.expectedUseTime.setValue(expectedUseTime);
    }


    /**
     * <p>Relationship: COCT_MT300000CA.Product.content</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"product/content"})
    public DispensedInBean getProductContent() {
        return this.productContent;
    }

    /**
     * <p>Relationship: COCT_MT300000CA.Product.content</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setProductContent(DispensedInBean productContent) {
        this.productContent = productContent;
    }


    /**
     * <p>Relationship: 
     * COCT_MT300000CA.ResponsibleProvider.pharmacistRole</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"performer/pharmacistRole"})
    public PharmacistRoleBean getPerformerPharmacistRole() {
        return this.performerPharmacistRole;
    }

    /**
     * <p>Relationship: 
     * COCT_MT300000CA.ResponsibleProvider.pharmacistRole</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setPerformerPharmacistRole(PharmacistRoleBean performerPharmacistRole) {
        this.performerPharmacistRole = performerPharmacistRole;
    }


    /**
     * <p>Relationship: 
     * COCT_MT300000CA.Origin.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"origin/serviceDeliveryLocation"})
    public ServiceLocationBean getOriginServiceDeliveryLocation() {
        return this.originServiceDeliveryLocation;
    }

    /**
     * <p>Relationship: 
     * COCT_MT300000CA.Origin.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setOriginServiceDeliveryLocation(ServiceLocationBean originServiceDeliveryLocation) {
        this.originServiceDeliveryLocation = originServiceDeliveryLocation;
    }


    /**
     * <p>Relationship: 
     * COCT_MT300000CA.Destination.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"destination/serviceDeliveryLocation"})
    public ServiceLocationBean getDestinationServiceDeliveryLocation() {
        return this.destinationServiceDeliveryLocation;
    }

    /**
     * <p>Relationship: 
     * COCT_MT300000CA.Destination.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setDestinationServiceDeliveryLocation(ServiceLocationBean destinationServiceDeliveryLocation) {
        this.destinationServiceDeliveryLocation = destinationServiceDeliveryLocation;
    }


    /**
     * <p>Relationship: 
     * COCT_MT300000CA.SupplyEvent.pertinentInformation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"pertinentInformation"})
    public DispenseInstructionsBean getPertinentInformation() {
        return this.pertinentInformation;
    }

    /**
     * <p>Relationship: 
     * COCT_MT300000CA.SupplyEvent.pertinentInformation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setPertinentInformation(DispenseInstructionsBean pertinentInformation) {
        this.pertinentInformation = pertinentInformation;
    }


    /**
     * <p>Relationship: 
     * COCT_MT300000CA.EncounterInformation.patientEncounter</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"componentOf/patientEncounter"})
    public PatientEncounterBean getComponentOfPatientEncounter() {
        return this.componentOfPatientEncounter;
    }

    /**
     * <p>Relationship: 
     * COCT_MT300000CA.EncounterInformation.patientEncounter</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setComponentOfPatientEncounter(PatientEncounterBean componentOfPatientEncounter) {
        this.componentOfPatientEncounter = componentOfPatientEncounter;
    }

}
