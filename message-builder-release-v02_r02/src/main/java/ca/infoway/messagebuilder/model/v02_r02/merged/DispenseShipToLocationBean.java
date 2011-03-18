/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r02.merged;

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
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
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
 * <p><p>A role played by a place at which services may be 
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
 * telephone number.</p></p>
 * 
 * <p><p>Roleclass required to support the identification of 
 * the physical location where healthcare services are 
 * provided</p></p>
 * 
 * <p>PORX_MT060340CA.ServiceDeliveryLocation: Dispense Ship-To 
 * Location</p>
 * 
 * <p><p>The location where the dispensed product is expected 
 * to be delivered.</p></p>
 * 
 * <p><p>Important as part of a claim for justifying shipping 
 * charges.</p></p>
 * 
 * <p>PORX_MT020070CA.ServiceDeliveryLocation: Dispense Ship-To 
 * Location</p>
 * 
 * <p><p>The location where the dispensed product is expected 
 * to be delivered.</p></p>
 * 
 * <p><p>Important as part of a claim for justifying shipping 
 * charges.</p></p>
 * 
 * <p>PORX_MT020060CA.ServiceDeliveryLocation: Dispense Ship-To 
 * Location</p>
 * 
 * <p><p>The location where the dispensed product is expected 
 * to be delivered.</p></p>
 * 
 * <p><p>Important as part of a claim for justifying shipping 
 * charges.</p></p>
 * 
 * <p>PORX_MT060010CA.ServiceDeliveryLocation: Dispense Ship-To 
 * Location</p>
 * 
 * <p><p>The location where the dispensed product is expected 
 * to be delivered.</p></p>
 * 
 * <p><p>Important as part of a claim for justifying shipping 
 * charges.</p></p>
 * 
 * <p>PORX_MT060160CA.ServiceDeliveryLocation: Dispense Ship-To 
 * Location</p>
 * 
 * <p><p>The location where the dispensed product is expected 
 * to be delivered.</p></p>
 * 
 * <p><p>Important as part of a claim for justifying shipping 
 * charges.</p></p>
 * 
 * <p>PORX_MT060040CA.ServiceDeliveryLocation: Dispense Ship-To 
 * Location</p>
 * 
 * <p><p>The location where the dispensed product is expected 
 * to be delivered.</p></p>
 * 
 * <p><p>Important as part of a claim for justifying shipping 
 * charges.</p></p>
 * 
 * <p>PRPM_MT301010CA.ServiceDeliveryLocation: Service Delivery 
 * Location</p>
 * 
 * <p><p>A role played by a place at which services may be 
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
 * telephone number.</p></p>
 * 
 * <p><p>Roleclass required to support the identification of 
 * the physical location where healthcare services are 
 * provided</p></p>
 * 
 * <p>PORX_MT060090CA.ServiceDeliveryLocation: Dispense Ship-To 
 * Location</p>
 * 
 * <p><p>The location where the dispensed product is expected 
 * to be delivered.</p></p>
 * 
 * <p><p>Important as part of a claim for justifying shipping 
 * charges.</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT010110CA.ServiceDeliveryLocation","PORX_MT010120CA.ServiceDeliveryLocation","PORX_MT020060CA.ServiceDeliveryLocation","PORX_MT020070CA.ServiceDeliveryLocation","PORX_MT060010CA.ServiceDeliveryLocation","PORX_MT060040CA.ServiceDeliveryLocation","PORX_MT060040CA.ServiceDeliveryLocation2","PORX_MT060090CA.ServiceDeliveryLocation","PORX_MT060160CA.ServiceDeliveryLocation","PORX_MT060160CA.ServiceDeliveryLocation2","PORX_MT060340CA.ServiceDeliveryLocation","PORX_MT060340CA.ServiceDeliveryLocation2","PRPM_MT301010CA.ServiceDeliveryLocation","PRPM_MT303010CA.ServiceDeliveryLocation"})
public class DispenseShipToLocationBean extends MessagePartBean implements Choice {

    private static final long serialVersionUID = 20110318L;
    private II serviceDeliveryLocationIdentifier = new IIImpl();
    private IVL<TS, Interval<Date>> serviceDeliveryLocationEffectiveDate = new IVLImpl<TS, Interval<Date>>();
    private CV serviceDeliveryLocationType = new CVImpl();
    private AD addr = new ADImpl();
    private ST serviceDeliveryLocationName = new STImpl();
    private TEL serviceDeliveryLocationTelecom = new TELImpl();


    /**
     * <p>ServiceDeliveryLocationIdentifier</p>
     * 
     * <p>Service Delivery Location Identifier</p>
     * 
     * <p><p>A unique identifier for the service delivery 
     * location.</p></p>
     * 
     * <p><p>Required attribute supports the validation and 
     * identification of the service delivery location</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getServiceDeliveryLocationIdentifier() {
        return this.serviceDeliveryLocationIdentifier.getValue();
    }
    public void setServiceDeliveryLocationIdentifier(Identifier serviceDeliveryLocationIdentifier) {
        this.serviceDeliveryLocationIdentifier.setValue(serviceDeliveryLocationIdentifier);
    }


    /**
     * <p>ServiceDeliveryLocationEffectiveDate</p>
     * 
     * <p>Service Delivery Location Effective Date</p>
     * 
     * <p><p>Effective date of the specific service delivery 
     * location</p></p>
     * 
     * <p><p>Required attribute supports the validation and 
     * identification of the service delivery location</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getServiceDeliveryLocationEffectiveDate() {
        return this.serviceDeliveryLocationEffectiveDate.getValue();
    }
    public void setServiceDeliveryLocationEffectiveDate(Interval<Date> serviceDeliveryLocationEffectiveDate) {
        this.serviceDeliveryLocationEffectiveDate.setValue(serviceDeliveryLocationEffectiveDate);
    }


    /**
     * <p>ServiceDeliveryLocationType</p>
     * 
     * <p>Service Delivery Location Type</p>
     * 
     * <p><p>The code identifying the specific service delivery 
     * location</p></p>
     * 
     * <p><p>Mandatory attribute supports the validation and 
     * identification of the service delivery location</p></p>
     */
    @Hl7XmlMapping({"code"})
    public ServiceDeliveryLocationRoleType getServiceDeliveryLocationType() {
        return (ServiceDeliveryLocationRoleType) this.serviceDeliveryLocationType.getValue();
    }
    public void setServiceDeliveryLocationType(ServiceDeliveryLocationRoleType serviceDeliveryLocationType) {
        this.serviceDeliveryLocationType.setValue(serviceDeliveryLocationType);
    }


    /**
     * <p>Service Delivery Location Address</p>
     * 
     * <p><p>Address of the specific service delivery location</p></p>
     * 
     * <p><p>Populated attribute supports the validation and 
     * identification of the service delivery location</p></p>
     * 
     * <p>Ship To Address</p>
     * 
     * <p><p>Indicates where the dispensed product was sent.</p></p>
     * 
     * <p><p>Important as part of a claim for justifying shipping 
     * charges.</p></p>
     * 
     * <p>H:Prescription Ship to Address</p>
     * 
     * <p><p>Indicates the location the dispensed device should be 
     * shipped to, at the request of the patient or provider.</p></p>
     * 
     * <p><p>In some cases devices need to be delivered to the 
     * patient instead of being picked up. In other cases, devices 
     * need to be shipped to the physician's office to replace 
     * stock used for the patient.</p></p>
     * 
     * <p>I:Ship-To Address</p>
     * 
     * <p><p>Indicates where the dispensed product was sent.</p></p>
     * 
     * <p><p>Important as part of a claim for justifying shipping 
     * charges.</p></p>
     * 
     * <p>H:Prescription Ship to Address</p>
     * 
     * <p><p>Indicates the location the dispensed medication should 
     * be shipped to, at the request of the patient or 
     * provider.</p></p>
     * 
     * <p><p>In some cases drugs need to be delivered to the 
     * patient instead of being picked up. In other cases, drugs 
     * need to be shipped to the physician's office to replace 
     * stock used for the patient.</p></p>
     * 
     * <p>Service Delivery Location Address</p>
     * 
     * <p><p>Address of the specific service delivery location</p></p>
     * 
     * <p><p>Required attribute supports the validation and 
     * identification of the service delivery location</p></p>
     */
    @Hl7XmlMapping({"addr"})
    public PostalAddress getAddr() {
        return this.addr.getValue();
    }
    public void setAddr(PostalAddress addr) {
        this.addr.setValue(addr);
    }


    /**
     * <p>ServiceDeliveryLocationName</p>
     * 
     * <p>Service Delivery Location Name</p>
     * 
     * <p><p>The name of the service delivery location</p></p>
     * 
     * <p><p>Mandatory attribute supports the validation and 
     * identification of the service delivery location</p></p>
     */
    @Hl7XmlMapping({"location/name"})
    public String getServiceDeliveryLocationName() {
        return this.serviceDeliveryLocationName.getValue();
    }
    public void setServiceDeliveryLocationName(String serviceDeliveryLocationName) {
        this.serviceDeliveryLocationName.setValue(serviceDeliveryLocationName);
    }


    /**
     * <p>ServiceDeliveryLocationTelecom</p>
     * 
     * <p>Service Delivery Location Telecom</p>
     * 
     * <p><p>The telecom for the specific service delivery 
     * location</p></p>
     * 
     * <p><p>Required attribute supports the validation and 
     * identification of the service delivery location</p></p>
     */
    @Hl7XmlMapping({"telecom"})
    public TelecommunicationAddress getServiceDeliveryLocationTelecom() {
        return this.serviceDeliveryLocationTelecom.getValue();
    }
    public void setServiceDeliveryLocationTelecom(TelecommunicationAddress serviceDeliveryLocationTelecom) {
        this.serviceDeliveryLocationTelecom.setValue(serviceDeliveryLocationTelecom);
    }

}
