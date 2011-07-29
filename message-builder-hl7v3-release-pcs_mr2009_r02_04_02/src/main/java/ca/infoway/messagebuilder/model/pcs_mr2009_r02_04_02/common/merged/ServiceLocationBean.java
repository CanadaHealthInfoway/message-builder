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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.ServiceDeliveryLocationRoleType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt960002ca.GeographicCoordinatesBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



/**
 * <p>ServiceLocation</p>
 * 
 * <p>COCT_MT240007CA.ServiceDeliveryLocation: Service Location</p>
 * 
 * <p><p>An identification of a service location (or facility) 
 * where health service has been or can be delivered. E.g. 
 * Pharmacy, Medical Clinic, Hospital</p><p>Also used to 
 * capture non-dedicated facilities such as &quot;side of the 
 * road&quot;. This CMET is intended for circumstances that the 
 * desired service delivery location is not in the registry</p></p>
 * 
 * <p><p>An identification of a service location (or facility) 
 * where health service has been or can be delivered. E.g. 
 * Pharmacy, Medical Clinic, Hospital</p><p>Also used to 
 * capture non-dedicated facilities such as &quot;side of the 
 * road&quot;. This CMET is intended for circumstances that the 
 * desired service delivery location is not in the registry</p></p>
 * 
 * <p><p>Used for tracking service delivery responsibility, to 
 * provide contact information for follow-up and for 
 * statistical analysis. Also important for indicating where 
 * paper records can be located.</p></p>
 * 
 * <p><p>Information other than the id is expected to be 
 * extracted from the service delivery location registry.</p></p>
 * 
 * <p>COCT_MT240003CA.ServiceDeliveryLocation: Service Location</p>
 * 
 * <p><p>An identification of a service location (or facility) 
 * where health service has been or can be delivered. E.g. 
 * Pharmacy, Medical Clinic, Hospital</p></p>
 * 
 * <p><p>Used for tracking service delivery responsibility, to 
 * provide contact information for follow-up and for 
 * statistical analysis. Also important for indicating where 
 * paper records can be located.</p></p>
 * 
 * <p><p>Information other than the id is expected to be 
 * extracted from the service delivery location registry.</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT011001CA.ServiceDeliveryLocation","COCT_MT240003CA.ServiceDeliveryLocation","COCT_MT240007CA.ServiceDeliveryLocation"})
@Hl7RootType
public class ServiceLocationBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.iehr.merged.Recipients, ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.Recipient {

    private static final long serialVersionUID = 20110729L;
    private II serviceLocationIdentifier = new IIImpl();
    private CV serviceLocationType = new CVImpl();
    private AD serviceLocationAddress = new ADImpl();
    private SET<TEL, TelecommunicationAddress> serviceLocationPhonesAndEMails = new SETImpl<TEL, TelecommunicationAddress>(TELImpl.class);
    private ST serviceLocationName = new STImpl();
    private List<GeographicCoordinatesBean> subjectOfPosition = new ArrayList<GeographicCoordinatesBean>();


    /**
     * <p>ServiceLocationIdentifier</p>
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
     * <p><p>Allows for a location to be uniquely referenced. 
     * However, because this CMET is used for locations not 
     * necessarily found in a registry, the attribute is only 
     * 'required'.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getServiceLocationIdentifier() {
        return this.serviceLocationIdentifier.getValue();
    }
    public void setServiceLocationIdentifier(Identifier serviceLocationIdentifier) {
        this.serviceLocationIdentifier.setValue(serviceLocationIdentifier);
    }


    /**
     * <p>ServiceLocationType</p>
     * 
     * <p>A: Service Location Type</p>
     * 
     * <p><p>Describes the basic type or category of the service 
     * delivery location.</p></p>
     * 
     * <p><p>Useful in providing context. May also be used for 
     * grouping and organizing data. Because this is a key element 
     * in understanding the location, it is mandatory.</p></p>
     * 
     * <p>Service Location Type</p>
     */
    @Hl7XmlMapping({"code"})
    public ServiceDeliveryLocationRoleType getServiceLocationType() {
        return (ServiceDeliveryLocationRoleType) this.serviceLocationType.getValue();
    }
    public void setServiceLocationType(ServiceDeliveryLocationRoleType serviceLocationType) {
        this.serviceLocationType.setValue(serviceLocationType);
    }


    /**
     * <p>ServiceLocationAddress</p>
     * 
     * <p>D:Service Location Address</p>
     * 
     * <p><p>The information by which a service location may be 
     * contacted either physically or by mail.</p></p>
     * 
     * <p><p>Identifies the physical location of a service location 
     * and also allows for the location to be contacted.</p><p>The 
     * address is marked as 'populated' because it is considered a 
     * critical piece of information about the facility, but may 
     * not always be available or meaningful.</p></p>
     * 
     * <p><p>Identifies the physical location of a service location 
     * and also allows for the location to be contacted.</p><p>The 
     * address is marked as 'populated' because it is considered a 
     * critical piece of information about the facility, but may 
     * not always be available or meaningful.</p></p>
     */
    @Hl7XmlMapping({"addr"})
    public PostalAddress getServiceLocationAddress() {
        return this.serviceLocationAddress.getValue();
    }
    public void setServiceLocationAddress(PostalAddress serviceLocationAddress) {
        this.serviceLocationAddress.setValue(serviceLocationAddress);
    }


    /**
     * <p>ServiceLocationPhonesAndEMails</p>
     * 
     * <p>E:Service Location Phones and E-mails</p>
     * 
     * <p><p>The phone numbers and/or electronic mail addresses by 
     * which a service location may be contacted.</p></p>
     * 
     * <p><p>Allows a service location to be communicated with and 
     * is therefore important. Because a contact number won't 
     * always exist, the field is marked 'populated'.</p></p>
     */
    @Hl7XmlMapping({"telecom"})
    public Set<TelecommunicationAddress> getServiceLocationPhonesAndEMails() {
        return this.serviceLocationPhonesAndEMails.rawSet();
    }


    /**
     * <p>ServiceLocationName</p>
     * 
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
     */
    @Hl7XmlMapping({"location/name"})
    public String getServiceLocationName() {
        return this.serviceLocationName.getValue();
    }
    public void setServiceLocationName(String serviceLocationName) {
        this.serviceLocationName.setValue(serviceLocationName);
    }


    @Hl7XmlMapping({"subjectOf/position"})
    public List<GeographicCoordinatesBean> getSubjectOfPosition() {
        return this.subjectOfPosition;
    }

}
