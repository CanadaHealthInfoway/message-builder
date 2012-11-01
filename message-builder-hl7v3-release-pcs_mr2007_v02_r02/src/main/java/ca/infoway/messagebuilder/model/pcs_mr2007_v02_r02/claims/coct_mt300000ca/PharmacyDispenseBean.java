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
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.merged.DrugDispensedInBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.merged.ServiceLocationBean;
import java.util.Date;



/**
 * <p>Pharmacy Dispense</p>
 * 
 * <p><p>Patient classes are not referenced in the billable 
 * acts, as they are noted in the parent model (e.g. Invoice 
 * message) as the CoveredPartyAsPatient</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT300000CA.SupplyEvent"})
@Hl7RootType
public class PharmacyDispenseBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.claims.coct_mt280001ca.A_BillableActChoice {

    private static final long serialVersionUID = 20120215L;
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


    @Hl7XmlMapping({"moodCode"})
    public x_ActMoodIntentEvent getMoodCode() {
        return (x_ActMoodIntentEvent) this.moodCode.getValue();
    }
    public void setMoodCode(x_ActMoodIntentEvent moodCode) {
        this.moodCode.setValue(moodCode);
    }


    /**
     * <p>Type of Dispense</p>
     * 
     * <p><p>partial fill/trial/completion of trial, etc.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public ActPharmacySupplyType getCode() {
        return (ActPharmacySupplyType) this.code.getValue();
    }
    public void setCode(ActPharmacySupplyType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Dispense Time</p>
     * 
     * <p><p>Dispense Time</p></p>
     * 
     * <p><p>Date and Time to support multiple dispense per day of 
     * the same product. E.g. methadone</p></p>
     * 
     * <p><p>Must support hour/minute to handle multi-dispense/day 
     * of same product - e.g. methadone</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Date getEffectiveTime() {
        return this.effectiveTime.getValue();
    }
    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Total Dispensed</p>
     * 
     * <p><p>Generally defaults to 'quantity billed'</p></p>
     * 
     * <p><p>Either Total Dispensed or Dispensed Days Supply must 
     * be specified for billing.</p></p>
     */
    @Hl7XmlMapping({"quantity"})
    public PhysicalQuantity getQuantity() {
        return this.quantity.getValue();
    }
    public void setQuantity(PhysicalQuantity quantity) {
        this.quantity.setValue(quantity);
    }


    /**
     * <p>Dispensed Days Supply</p>
     * 
     * <p><p>Either Total Dispensed or Dispensed Days Supply must 
     * be specified for billing.</p></p>
     */
    @Hl7XmlMapping({"expectedUseTime"})
    public Interval<Date> getExpectedUseTime() {
        return this.expectedUseTime.getValue();
    }
    public void setExpectedUseTime(Interval<Date> expectedUseTime) {
        this.expectedUseTime.setValue(expectedUseTime);
    }


    @Hl7XmlMapping({"product/content"})
    public DrugDispensedInBean getProductContent() {
        return this.productContent;
    }
    public void setProductContent(DrugDispensedInBean productContent) {
        this.productContent = productContent;
    }


    @Hl7XmlMapping({"performer/pharmacistRole"})
    public PharmacistRoleBean getPerformerPharmacistRole() {
        return this.performerPharmacistRole;
    }
    public void setPerformerPharmacistRole(PharmacistRoleBean performerPharmacistRole) {
        this.performerPharmacistRole = performerPharmacistRole;
    }


    @Hl7XmlMapping({"origin/serviceDeliveryLocation"})
    public ServiceLocationBean getOriginServiceDeliveryLocation() {
        return this.originServiceDeliveryLocation;
    }
    public void setOriginServiceDeliveryLocation(ServiceLocationBean originServiceDeliveryLocation) {
        this.originServiceDeliveryLocation = originServiceDeliveryLocation;
    }


    @Hl7XmlMapping({"destination/serviceDeliveryLocation"})
    public ServiceLocationBean getDestinationServiceDeliveryLocation() {
        return this.destinationServiceDeliveryLocation;
    }
    public void setDestinationServiceDeliveryLocation(ServiceLocationBean destinationServiceDeliveryLocation) {
        this.destinationServiceDeliveryLocation = destinationServiceDeliveryLocation;
    }


    @Hl7XmlMapping({"pertinentInformation"})
    public DispenseInstructionsBean getPertinentInformation() {
        return this.pertinentInformation;
    }
    public void setPertinentInformation(DispenseInstructionsBean pertinentInformation) {
        this.pertinentInformation = pertinentInformation;
    }


    @Hl7XmlMapping({"componentOf/patientEncounter"})
    public PatientEncounterBean getComponentOfPatientEncounter() {
        return this.componentOfPatientEncounter;
    }
    public void setComponentOfPatientEncounter(PatientEncounterBean componentOfPatientEncounter) {
        this.componentOfPatientEncounter = componentOfPatientEncounter;
    }

}