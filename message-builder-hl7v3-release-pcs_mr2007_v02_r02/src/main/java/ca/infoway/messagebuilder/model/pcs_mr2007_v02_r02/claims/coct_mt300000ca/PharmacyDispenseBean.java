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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.claims.coct_mt300000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.ActPharmacySupplyType;
import ca.infoway.messagebuilder.domainvalue.x_ActMoodIntentEvent;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.claims.merged.PatientEncounterBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.coct_mt240003ca.ServiceLocationBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.merged.DrugDispensedInBean;
import java.util.Date;



/**
 * <p>Business Name: Pharmacy Dispense</p>
 * 
 * <p>Patient classes are not referenced in the billable acts, 
 * as they are noted in the parent model (e.g. Invoice message) 
 * as the CoveredPartyAsPatient</p>
 */
@Hl7PartTypeMapping({"COCT_MT300000CA.SupplyEvent"})
@Hl7RootType
public class PharmacyDispenseBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.claims.coct_mt280001ca.A_BillableActChoice {

    private static final long serialVersionUID = 20150326L;
    private CS moodCode = new CSImpl();
    private CV code = new CVImpl();
    private TS effectiveTime = new TSImpl();
    private PQ quantity = new PQImpl();
    private IVL<TS, Interval<Date>> expectedUseTime = new IVLImpl<TS, Interval<Date>>();
    private DrugDispensedInBean productContent;
    private PharmacistRoleBean performerPharmacistRole;
    private ServiceLocationBean originServiceDeliveryLocation;
    private ServiceLocationBean destinationServiceDeliveryLocation;
    private DispenseInstructionsBean pertinentInformation;
    private PatientEncounterBean componentOfPatientEncounter;


    /**
     * <p>Relationship: COCT_MT300000CA.SupplyEvent.moodCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"moodCode"})
    public x_ActMoodIntentEvent getMoodCode() {
        return (x_ActMoodIntentEvent) this.moodCode.getValue();
    }

    /**
     * <p>Relationship: COCT_MT300000CA.SupplyEvent.moodCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setMoodCode(x_ActMoodIntentEvent moodCode) {
        this.moodCode.setValue(moodCode);
    }


    /**
     * <p>Business Name: Type of Dispense</p>
     * 
     * <p>Relationship: COCT_MT300000CA.SupplyEvent.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>partial fill/trial/completion of trial, etc.</p>
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
     * 
     * <p>partial fill/trial/completion of trial, etc.</p>
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
     * 
     * <p>Date and Time to support multiple dispense per day of the 
     * same product. E.g. methadone</p>
     * 
     * <p>Must support hour/minute to handle multi-dispense/day of 
     * same product - e.g. methadone</p>
     * 
     * <p>Dispense Time</p>
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
     * 
     * <p>Date and Time to support multiple dispense per day of the 
     * same product. E.g. methadone</p>
     * 
     * <p>Must support hour/minute to handle multi-dispense/day of 
     * same product - e.g. methadone</p>
     * 
     * <p>Dispense Time</p>
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
     * 
     * <p>Either Total Dispensed or Dispensed Days Supply must be 
     * specified for billing.</p>
     * 
     * <p>Generally defaults to 'quantity billed'</p>
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
     * 
     * <p>Either Total Dispensed or Dispensed Days Supply must be 
     * specified for billing.</p>
     * 
     * <p>Generally defaults to 'quantity billed'</p>
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
     * 
     * <p>Either Total Dispensed or Dispensed Days Supply must be 
     * specified for billing.</p>
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
     * 
     * <p>Either Total Dispensed or Dispensed Days Supply must be 
     * specified for billing.</p>
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
    public DrugDispensedInBean getProductContent() {
        return this.productContent;
    }

    /**
     * <p>Relationship: COCT_MT300000CA.Product.content</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setProductContent(DrugDispensedInBean productContent) {
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
