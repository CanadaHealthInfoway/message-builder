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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.model.newfoundland.cerx;

import java.io.Serializable;
import java.util.Date;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.ActPharmacySupplyType;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.newfoundland.CausalActs;
import ca.infoway.messagebuilder.model.newfoundland.IdentifiedPersonBean;
import ca.infoway.messagebuilder.model.newfoundland.OfPatient;
import ca.infoway.messagebuilder.model.newfoundland.ResponsiblePartyBean;
import ca.infoway.messagebuilder.model.newfoundland.ServiceDeliveryLocationBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.deviceprescription.ClinicalDeviceBean;
import ca.infoway.messagebuilder.model.newfoundland.confidentiality.VeryBasicConfidentiality;

@Hl7PartTypeMapping({ "PORX_MT020070CA.SupplyEvent", "PORX_MT060040CA.SupplyEvent", "PORX_MT060090CA.SupplyEvent", "PORX_MT060010CA.SupplyEvent", "PORX_MT980010CA.SupplyEvent", "PORX_MT980020CA.SupplyEvent", "PORX_MT980030CA.SupplyEvent", "PORX_MT020020CA.SupplyEvent", "PORX_MT020060CA.SupplyEvent" })
public class SupplyEventBean extends MessagePartBean implements Serializable, CausalActs, VeryBasicConfidentiality, OfPatient {

    private static final long serialVersionUID = -6439877205910231083L;

    private final II dispenseId = new IIImpl();

    private final CD statusCode = new CDImpl();

    private final CD code = new CDImpl();

    private final IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();

    private final PQ quantity = new PQImpl();

    private final IVL<TS, Interval<Date>> expectedUseTime = new IVLImpl<TS, Interval<Date>>();

    private MedicineBean medication;

    private ClinicalDeviceBean clinicalDevice;

    private ResponsiblePartyBean responsibleParty;

    private ServiceDeliveryLocationBean destination;

    private final CD confidentialityCode = new CDImpl();

    private ServiceDeliveryLocationBean location;

    private IdentifiedPersonBean patient;

    @Hl7XmlMapping("id")
    public Identifier getDispenseId() {
        return this.dispenseId.getValue();
    }

    public void setDispenseId(Identifier dispenseId) {
        this.dispenseId.setValue(dispenseId);
    }

    @Hl7XmlMapping("code")
    public ActPharmacySupplyType getCode() {
        return (ActPharmacySupplyType) this.code.getValue();
    }

    public void setCode(ActPharmacySupplyType code) {
        this.code.setValue(code);
    }

    @Hl7XmlMapping("statusCode")
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }

    @Hl7XmlMapping("effectiveTime")
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }

    @Hl7XmlMapping("quantity")
    public PhysicalQuantity getQuantity() {
        return this.quantity.getValue();
    }

    public void setQuantity(PhysicalQuantity quantity) {
        this.quantity.setValue(quantity);
    }

    @Hl7XmlMapping("expectedUseTime")
    public Interval<Date> getExpectedUseTime() {
        return this.expectedUseTime.getValue();
    }

    public void setExpectedUseTime(Interval<Date> expectedUseTime) {
        this.expectedUseTime.setValue(expectedUseTime);
    }

    @Hl7XmlMapping("product/medication/player")
    public MedicineBean getMedication() {
        return medication;
    }

    public void setMedication(MedicineBean medication) {
        this.medication = medication;
    }

    @Hl7XmlMapping("destination/serviceDeliveryLocation")
    public ServiceDeliveryLocationBean getDestination() {
        return destination;
    }

    public void setDestination(ServiceDeliveryLocationBean destination) {
        this.destination = destination;
    }

    @Hl7XmlMapping("product/manufacturedProduct/manufacturedClinicalDevice")
    public ClinicalDeviceBean getClinicalDevice() {
        return clinicalDevice;
    }

    public void setClinicalDevice(ClinicalDeviceBean clinicalDevice) {
        this.clinicalDevice = clinicalDevice;
    }

    @Hl7XmlMapping("receiver/responsibleParty")
    public ResponsiblePartyBean getResponsibleParty() {
        return responsibleParty;
    }

    public void setResponsibleParty(ResponsiblePartyBean responsibleParty) {
        this.responsibleParty = responsibleParty;
    }

    @Hl7XmlMapping("confidentialityCode")
    public x_VeryBasicConfidentialityKind getConfidentialityCode() {
        return (x_VeryBasicConfidentialityKind) this.confidentialityCode.getValue();
    }

    public void setConfidentialityCode(x_VeryBasicConfidentialityKind confidentialityCode) {
        this.confidentialityCode.setValue(confidentialityCode);
    }

    @Hl7XmlMapping("location/serviceDeliveryLocation")
    public ServiceDeliveryLocationBean getLocation() {
        return location;
    }

    public void setLocation(ServiceDeliveryLocationBean location) {
        this.location = location;
    }

    @Hl7XmlMapping("subject/patient")
    public IdentifiedPersonBean getPatient() {
        return this.patient;
    }

    public void setPatient(IdentifiedPersonBean patient) {
        this.patient = patient;
    }

    public Identifier getId() {
        return this.getDispenseId();
    }

    public void setId(Identifier id) {
        this.setDispenseId(id);
    }
}
