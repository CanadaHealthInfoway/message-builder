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
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.ActPharmacySupplyType;
import ca.infoway.messagebuilder.domainvalue.ServiceDeliveryLocationRoleType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.common.coct_mt141007ca.DeviceProductBean;
import java.util.Date;



@Hl7PartTypeMapping({"PORX_MT020060CA.Component","PORX_MT060010CA.Component","PORX_MT060020CA.Component2","PORX_MT060040CA.Component"})
public class Component2_1Bean extends MessagePartBean {

    private CV<ActPharmacySupplyType> dispenseType = new CVImpl<ActPharmacySupplyType>();
    private IVL<TS, Interval<Date>> dispenseProcessingAndPickupDate = new IVLImpl<TS, Interval<Date>>();
    private INT dispensedQuantity = new INTImpl();
    private IVL<TS, Interval<Date>> dispensedDaysSupply = new IVLImpl<TS, Interval<Date>>();
    private RelatedPersonBean supplyEventReceiverPersonalRelationship;
    private DeviceProductBean supplyEventProductManufacturedProduct = new DeviceProductBean();
    private II serviceDeliveryLocationIdentifier = new IIImpl();
    private CV<ServiceDeliveryLocationRoleType> serviceDeliveryLocationType = new CVImpl<ServiceDeliveryLocationRoleType>();
    private AD serviceDeliveryLocationAddress = new ADImpl();
    private TEL serviceDeliveryLocationTelecom = new TELImpl();
    private IVL<TS, Interval<Date>> serviceDeliveryLocationEffectiveDate = new IVLImpl<TS, Interval<Date>>();
    private ST serviceLocationName = new STImpl();

    @Hl7XmlMapping({"supplyEvent/code"})
    public ActPharmacySupplyType getDispenseType() {
        return this.dispenseType.getValue();
    }
    public void setDispenseType(ActPharmacySupplyType dispenseType) {
        this.dispenseType.setValue(dispenseType);
    }

    @Hl7XmlMapping({"supplyEvent/effectiveTime"})
    public Interval<Date> getDispenseProcessingAndPickupDate() {
        return this.dispenseProcessingAndPickupDate.getValue();
    }
    public void setDispenseProcessingAndPickupDate(Interval<Date> dispenseProcessingAndPickupDate) {
        this.dispenseProcessingAndPickupDate.setValue(dispenseProcessingAndPickupDate);
    }

    @Hl7XmlMapping({"supplyEvent/quantity"})
    public java.lang.Integer getDispensedQuantity() {
        return this.dispensedQuantity.getValue();
    }
    public void setDispensedQuantity(java.lang.Integer dispensedQuantity) {
        this.dispensedQuantity.setValue(dispensedQuantity);
    }

    @Hl7XmlMapping({"supplyEvent/expectedUseTime"})
    public Interval<Date> getDispensedDaysSupply() {
        return this.dispensedDaysSupply.getValue();
    }
    public void setDispensedDaysSupply(Interval<Date> dispensedDaysSupply) {
        this.dispensedDaysSupply.setValue(dispensedDaysSupply);
    }

    @Hl7XmlMapping({"supplyEvent/receiver/personalRelationship"})
    public RelatedPersonBean getSupplyEventReceiverPersonalRelationship() {
        return this.supplyEventReceiverPersonalRelationship;
    }
    public void setSupplyEventReceiverPersonalRelationship(RelatedPersonBean supplyEventReceiverPersonalRelationship) {
        this.supplyEventReceiverPersonalRelationship = supplyEventReceiverPersonalRelationship;
    }

    @Hl7XmlMapping({"supplyEvent/product/manufacturedProduct"})
    public DeviceProductBean getSupplyEventProductManufacturedProduct() {
        return this.supplyEventProductManufacturedProduct;
    }
    public void setSupplyEventProductManufacturedProduct(DeviceProductBean supplyEventProductManufacturedProduct) {
        this.supplyEventProductManufacturedProduct = supplyEventProductManufacturedProduct;
    }

    @Hl7XmlMapping({"supplyEvent/destination/serviceDeliveryLocation/id"})
    public Identifier getServiceDeliveryLocationIdentifier() {
        return this.serviceDeliveryLocationIdentifier.getValue();
    }
    public void setServiceDeliveryLocationIdentifier(Identifier serviceDeliveryLocationIdentifier) {
        this.serviceDeliveryLocationIdentifier.setValue(serviceDeliveryLocationIdentifier);
    }

    @Hl7XmlMapping({"supplyEvent/destination/serviceDeliveryLocation/code"})
    public ServiceDeliveryLocationRoleType getServiceDeliveryLocationType() {
        return this.serviceDeliveryLocationType.getValue();
    }
    public void setServiceDeliveryLocationType(ServiceDeliveryLocationRoleType serviceDeliveryLocationType) {
        this.serviceDeliveryLocationType.setValue(serviceDeliveryLocationType);
    }

    @Hl7XmlMapping({"supplyEvent/destination/serviceDeliveryLocation/addr"})
    public PostalAddress getServiceDeliveryLocationAddress() {
        return this.serviceDeliveryLocationAddress.getValue();
    }
    public void setServiceDeliveryLocationAddress(PostalAddress serviceDeliveryLocationAddress) {
        this.serviceDeliveryLocationAddress.setValue(serviceDeliveryLocationAddress);
    }

    @Hl7XmlMapping({"supplyEvent/destination/serviceDeliveryLocation/telecom"})
    public TelecommunicationAddress getServiceDeliveryLocationTelecom() {
        return this.serviceDeliveryLocationTelecom.getValue();
    }
    public void setServiceDeliveryLocationTelecom(TelecommunicationAddress serviceDeliveryLocationTelecom) {
        this.serviceDeliveryLocationTelecom.setValue(serviceDeliveryLocationTelecom);
    }

    @Hl7XmlMapping({"supplyEvent/destination/serviceDeliveryLocation/effectiveTime"})
    public Interval<Date> getServiceDeliveryLocationEffectiveDate() {
        return this.serviceDeliveryLocationEffectiveDate.getValue();
    }
    public void setServiceDeliveryLocationEffectiveDate(Interval<Date> serviceDeliveryLocationEffectiveDate) {
        this.serviceDeliveryLocationEffectiveDate.setValue(serviceDeliveryLocationEffectiveDate);
    }

    @Hl7XmlMapping({"supplyEvent/destination/serviceDeliveryLocation/location/name"})
    public java.lang.String getServiceLocationName() {
        return this.serviceLocationName.getValue();
    }
    public void setServiceLocationName(java.lang.String serviceLocationName) {
        this.serviceLocationName.setValue(serviceLocationName);
    }

}