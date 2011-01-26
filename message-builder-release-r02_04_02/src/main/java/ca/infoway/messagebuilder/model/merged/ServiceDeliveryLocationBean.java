/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
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
 * <p>PORX_MT020050CA.ServiceDeliveryLocation: (no business 
 * name)</p>
 * 
 * <p><p>The location where the supply is expected to be 
 * delivered.</p></p>
 * 
 * <p><p>Allows tracking what drugs are dispensed to a 
 * facility.</p></p>
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
 * <p>COCT_MT240012CA.ServiceDeliveryLocation: Service Location</p>
 * 
 * <p><p>An identification of a service location (or facility) 
 * that can be found in the service delivery location. E.g. 
 * Pharmacy, Medical Clinic, Hospital</p></p>
 * 
 * <p><p>Used for tracking service delivery responsibility, to 
 * provide contact information for follow-up and for 
 * statistical analysis. Also important for indicating where 
 * paper records can be located.</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT240012CA.ServiceDeliveryLocation","PORX_MT020050CA.ServiceDeliveryLocation","PRPM_MT301010CA.ServiceDeliveryLocation","PRPM_MT303010CA.ServiceDeliveryLocation","REPC_MT500001CA.ServiceDeliveryLocation","REPC_MT500002CA.ServiceDeliveryLocation","REPC_MT500004CA.ServiceDeliveryLocation"})
@Hl7RootType
public class ServiceDeliveryLocationBean extends MessagePartBean implements Recipient, Choice {

    private static final long serialVersionUID = 20110126L;
    private II id = new IIImpl();
    private ST locationName = new STImpl();
    private CV serviceDeliveryLocationType = new CVImpl();
    private IVL<TS, Interval<Date>> serviceDeliveryLocationEffectiveDate = new IVLImpl<TS, Interval<Date>>();
    private TEL serviceDeliveryLocationTelecom = new TELImpl();
    private AD serviceDeliveryLocationAddress = new ADImpl();


    /**
     * <p>Location Id Reference</p>
     * 
     * <p><p>References the location for which the participants are 
     * being identified. This will be a location already associated 
     * with the care composition.</p></p>
     * 
     * <p><p>Allows linking participants to locations.</p></p>
     * 
     * <p>C:Service Location Identifier</p>
     * 
     * <p><p>Unique identifier for a healthcare service 
     * location.</p></p>
     * 
     * <p><p>PVD.020-01 (extension)</p><p>PVD.020-02 
     * (root)</p><p>Dispensing Pharmacy number</p><p>Pharmacy 
     * Identifier</p><p>Facility.facilityKey</p><p>DispensedItem.facilityKey</p></p>
     * 
     * <p><p>PVD.020-01 (extension)</p><p>PVD.020-02 
     * (root)</p><p>Dispensing Pharmacy number</p><p>Pharmacy 
     * Identifier</p><p>Facility.facilityKey</p><p>DispensedItem.facilityKey</p></p>
     * 
     * <p><p>PVD.020-01 (extension)</p><p>PVD.020-02 
     * (root)</p><p>Dispensing Pharmacy number</p><p>Pharmacy 
     * Identifier</p><p>Facility.facilityKey</p><p>DispensedItem.facilityKey</p></p>
     * 
     * <p><p>PVD.020-01 (extension)</p><p>PVD.020-02 
     * (root)</p><p>Dispensing Pharmacy number</p><p>Pharmacy 
     * Identifier</p><p>Facility.facilityKey</p><p>DispensedItem.facilityKey</p></p>
     * 
     * <p><p>PVD.020-01 (extension)</p><p>PVD.020-02 
     * (root)</p><p>Dispensing Pharmacy number</p><p>Pharmacy 
     * Identifier</p><p>Facility.facilityKey</p><p>DispensedItem.facilityKey</p></p>
     * 
     * <p><p>PVD.020-01 (extension)</p><p>PVD.020-02 
     * (root)</p><p>Dispensing Pharmacy number</p><p>Pharmacy 
     * Identifier</p><p>Facility.facilityKey</p><p>DispensedItem.facilityKey</p></p>
     * 
     * <p><p>Allows for lookup and retrieval of detailed 
     * information about a specific service location. Also ensures 
     * unique identification of service location and is therefore 
     * mandatory.</p><p>The identifier is mandatory because it is 
     * the principal mechanism for uniquely identifying the 
     * facility.</p></p>
     * 
     * <p><p>Allows for lookup and retrieval of detailed 
     * information about a specific service location. Also ensures 
     * unique identification of service location and is therefore 
     * mandatory.</p><p>The identifier is mandatory because it is 
     * the principal mechanism for uniquely identifying the 
     * facility.</p></p>
     * 
     * <p>Service Delivery Location Identifier</p>
     * 
     * <p><p>A unique identifier for the service delivery 
     * location.</p></p>
     * 
     * <p><p>Required attribute supports the validation and 
     * identification of the service delivery location</p></p>
     * 
     * <p>C:Ship-to Facility Id</p>
     * 
     * <p><p>Identifier of the facility where the dispensed 
     * medication was shipped.</p></p>
     * 
     * <p><p>Allows tracking what drugs are dispensed to a 
     * facility. The attribute is mandatory because identification 
     * of the facility must be known.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>B:Service Location Name</p>
     * 
     * <p><p>The name assigned to the service location.</p></p>
     * 
     * <p><p>PVD.070</p><p>Dispensing Pharmacy 
     * Name</p><p>Facility.name</p></p>
     * 
     * <p><p>PVD.070</p><p>Dispensing Pharmacy 
     * Name</p><p>Facility.name</p></p>
     * 
     * <p><p>PVD.070</p><p>Dispensing Pharmacy 
     * Name</p><p>Facility.name</p></p>
     * 
     * <p><p>Used for human communication, and for cross-checking 
     * of location Id and is therefore mandatory</p></p>
     * 
     * <p>Service Delivery Location Name</p>
     * 
     * <p><p>The name of the service delivery location</p></p>
     * 
     * <p><p>Mandatory attribute supports the validation and 
     * identification of the service delivery location</p></p>
     */
    @Hl7XmlMapping({"location/name"})
    public String getLocationName() {
        return this.locationName.getValue();
    }
    public void setLocationName(String locationName) {
        this.locationName.setValue(locationName);
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


    /**
     * <p>ServiceDeliveryLocationAddress</p>
     * 
     * <p>Service Delivery Location Address</p>
     * 
     * <p><p>Address of the specific service delivery location</p></p>
     * 
     * <p><p>Populated attribute supports the validation and 
     * identification of the service delivery location</p></p>
     * 
     * <p>Service Delivery Location Address</p>
     * 
     * <p><p>Address of the specific service delivery location</p></p>
     * 
     * <p><p>Required attribute supports the validation and 
     * identification of the service delivery location</p></p>
     */
    @Hl7XmlMapping({"addr"})
    public PostalAddress getServiceDeliveryLocationAddress() {
        return this.serviceDeliveryLocationAddress.getValue();
    }
    public void setServiceDeliveryLocationAddress(PostalAddress serviceDeliveryLocationAddress) {
        this.serviceDeliveryLocationAddress.setValue(serviceDeliveryLocationAddress);
    }

}
