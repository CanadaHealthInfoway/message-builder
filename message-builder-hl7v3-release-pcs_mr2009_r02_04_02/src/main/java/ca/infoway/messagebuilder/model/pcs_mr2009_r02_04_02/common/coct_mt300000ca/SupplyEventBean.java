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
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.PatientEncounterBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.ServiceLocationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.DispensedInBean;
import java.util.Date;



/**
 * <p><p>Patient classes are not referenced in the billable 
 * acts, as they are noted in the parent model (e.g. Invoice 
 * message) as the CoveredPartyAsPatient</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT300000CA.SupplyEvent"})
@Hl7RootType
public class SupplyEventBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt280001ca.A_BillableActChoice {

    private static final long serialVersionUID = 20110901L;
    private CV typeOfDispense = new CVImpl();
    private TS dispenseTime = new TSImpl();
    private PQ totalDispensed = new PQImpl();
    private IVL<TS, Interval<Date>> dispensedDaysSupply = new IVLImpl<TS, Interval<Date>>();
    private DispensedInBean productContent;
    private PharmacistRoleBean performerPharmacistRole;
    private ServiceLocationBean originServiceDeliveryLocation;
    private ServiceLocationBean destinationServiceDeliveryLocation;
    private DispenseInstructionsBean pertinentInformation;
    private PatientEncounterBean componentOfPatientEncounter;


    /**
     * <p>Type of Dispense</p>
     */
    @Hl7XmlMapping({"code"})
    public ActPharmacySupplyType getTypeOfDispense() {
        return (ActPharmacySupplyType) this.typeOfDispense.getValue();
    }
    public void setTypeOfDispense(ActPharmacySupplyType typeOfDispense) {
        this.typeOfDispense.setValue(typeOfDispense);
    }


    /**
     * <p>Dispense Time</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Date getDispenseTime() {
        return this.dispenseTime.getValue();
    }
    public void setDispenseTime(Date dispenseTime) {
        this.dispenseTime.setValue(dispenseTime);
    }


    /**
     * <p>Total Dispensed</p>
     */
    @Hl7XmlMapping({"quantity"})
    public PhysicalQuantity getTotalDispensed() {
        return this.totalDispensed.getValue();
    }
    public void setTotalDispensed(PhysicalQuantity totalDispensed) {
        this.totalDispensed.setValue(totalDispensed);
    }


    /**
     * <p>Dispensed Days Supply</p>
     */
    @Hl7XmlMapping({"expectedUseTime"})
    public Interval<Date> getDispensedDaysSupply() {
        return this.dispensedDaysSupply.getValue();
    }
    public void setDispensedDaysSupply(Interval<Date> dispensedDaysSupply) {
        this.dispensedDaysSupply.setValue(dispensedDaysSupply);
    }


    @Hl7XmlMapping({"product/content"})
    public DispensedInBean getProductContent() {
        return this.productContent;
    }
    public void setProductContent(DispensedInBean productContent) {
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
