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
 * <p>Business Name: ServiceLocation</p>
 * 
 * <p>COCT_MT240007CA.ServiceDeliveryLocation: Service Location</p>
 * 
 * <p>Used for tracking service delivery responsibility, to 
 * provide contact information for follow-up and for 
 * statistical analysis. Also important for indicating where 
 * paper records can be located.</p>
 * 
 * <p>Information other than the id is expected to be extracted 
 * from the service delivery location registry.</p>
 * 
 * <p>An identification of a service location (or facility) 
 * where health service has been or can be delivered. E.g. 
 * Pharmacy, Medical Clinic, Hospital</p><p>Also used to 
 * capture non-dedicated facilities such as &quot;side of the 
 * road&quot;. This CMET is intended for circumstances that the 
 * desired service delivery location is not in the registry</p>
 * 
 * <p>COCT_MT240003CA.ServiceDeliveryLocation: Service Location</p>
 * 
 * <p>Used for tracking service delivery responsibility, to 
 * provide contact information for follow-up and for 
 * statistical analysis. Also important for indicating where 
 * paper records can be located.</p>
 * 
 * <p>Information other than the id is expected to be extracted 
 * from the service delivery location registry.</p>
 * 
 * <p>An identification of a service location (or facility) 
 * where health service has been or can be delivered. E.g. 
 * Pharmacy, Medical Clinic, Hospital</p>
 */
@Hl7PartTypeMapping({"COCT_MT011001CA.ServiceDeliveryLocation","COCT_MT240003CA.ServiceDeliveryLocation","COCT_MT240007CA.ServiceDeliveryLocation"})
@Hl7RootType
public class ServiceLocationBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.iehr.merged.Recipients, ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.Recipient {

    private static final long serialVersionUID = 20121204L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private AD addr = new ADImpl();
    private SET<TEL, TelecommunicationAddress> telecom = new SETImpl<TEL, TelecommunicationAddress>(TELImpl.class);
    private ST locationName = new STImpl();
    private List<GeographicCoordinatesBean> subjectOfPosition = new ArrayList<GeographicCoordinatesBean>();


    /**
     * <p>Business Name: ServiceLocationIdentifier</p>
     * 
     * <p>Un-merged Business Name: ServiceLocationIdentifier</p>
     * 
     * <p>Relationship: COCT_MT240007CA.ServiceDeliveryLocation.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>PVD.020-01 (extension)</p>
     * 
     * <p>PVD.020-02 (root)</p>
     * 
     * <p>Dispensing Pharmacy number</p>
     * 
     * <p>Pharmacy Identifier</p>
     * 
     * <p>Facility.facilityKey</p>
     * 
     * <p>DispensedItem.facilityKey</p>
     * 
     * <p>Allows for a location to be uniquely referenced. However, 
     * because this CMET is used for locations not necessarily 
     * found in a registry, the attribute is only 'required'.</p>
     * 
     * <p>Unique identifier for a healthcare service location.</p>
     * 
     * <p>Un-merged Business Name: ServiceLocationIdentifier</p>
     * 
     * <p>Relationship: COCT_MT240003CA.ServiceDeliveryLocation.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>PVD.020-01 (extension)</p>
     * 
     * <p>PVD.020-02 (root)</p>
     * 
     * <p>Dispensing Pharmacy number</p>
     * 
     * <p>Pharmacy Identifier</p>
     * 
     * <p>Facility.facilityKey</p>
     * 
     * <p>DispensedItem.facilityKey</p>
     * 
     * <p>Allows for lookup and retrieval of detailed information 
     * about a specific service location. Also ensures unique 
     * identification of service location and is therefore 
     * mandatory.</p><p>The identifier is mandatory because it is 
     * the principal mechanism for uniquely identifying the 
     * facility.</p>
     * 
     * <p>Unique identifier for a healthcare service location.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: ServiceLocationIdentifier</p>
     * 
     * <p>Un-merged Business Name: ServiceLocationIdentifier</p>
     * 
     * <p>Relationship: COCT_MT240007CA.ServiceDeliveryLocation.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>PVD.020-01 (extension)</p>
     * 
     * <p>PVD.020-02 (root)</p>
     * 
     * <p>Dispensing Pharmacy number</p>
     * 
     * <p>Pharmacy Identifier</p>
     * 
     * <p>Facility.facilityKey</p>
     * 
     * <p>DispensedItem.facilityKey</p>
     * 
     * <p>Allows for a location to be uniquely referenced. However, 
     * because this CMET is used for locations not necessarily 
     * found in a registry, the attribute is only 'required'.</p>
     * 
     * <p>Unique identifier for a healthcare service location.</p>
     * 
     * <p>Un-merged Business Name: ServiceLocationIdentifier</p>
     * 
     * <p>Relationship: COCT_MT240003CA.ServiceDeliveryLocation.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>PVD.020-01 (extension)</p>
     * 
     * <p>PVD.020-02 (root)</p>
     * 
     * <p>Dispensing Pharmacy number</p>
     * 
     * <p>Pharmacy Identifier</p>
     * 
     * <p>Facility.facilityKey</p>
     * 
     * <p>DispensedItem.facilityKey</p>
     * 
     * <p>Allows for lookup and retrieval of detailed information 
     * about a specific service location. Also ensures unique 
     * identification of service location and is therefore 
     * mandatory.</p><p>The identifier is mandatory because it is 
     * the principal mechanism for uniquely identifying the 
     * facility.</p>
     * 
     * <p>Unique identifier for a healthcare service location.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: ServiceLocationType</p>
     * 
     * <p>Un-merged Business Name: ServiceLocationType</p>
     * 
     * <p>Relationship: 
     * COCT_MT240007CA.ServiceDeliveryLocation.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Useful in providing context. May also be used for 
     * grouping and organizing data. Because this is a key element 
     * in understanding the location, it is mandatory.</p>
     * 
     * <p>Describes the basic type or category of the service 
     * delivery location.</p>
     * 
     * <p>Un-merged Business Name: ServiceLocationType</p>
     * 
     * <p>Relationship: 
     * COCT_MT240003CA.ServiceDeliveryLocation.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Useful in providing context. May also be used for 
     * grouping and organizing data. Because this is a key element 
     * in understanding the location, it is mandatory.</p>
     * 
     * <p>Describes the basic type or category of the service 
     * delivery location.</p>
     * 
     * <p>Un-merged Business Name: ServiceLocationType</p>
     * 
     * <p>Relationship: 
     * COCT_MT011001CA.ServiceDeliveryLocation.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"code"})
    public ServiceDeliveryLocationRoleType getCode() {
        return (ServiceDeliveryLocationRoleType) this.code.getValue();
    }

    /**
     * <p>Business Name: ServiceLocationType</p>
     * 
     * <p>Un-merged Business Name: ServiceLocationType</p>
     * 
     * <p>Relationship: 
     * COCT_MT240007CA.ServiceDeliveryLocation.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Useful in providing context. May also be used for 
     * grouping and organizing data. Because this is a key element 
     * in understanding the location, it is mandatory.</p>
     * 
     * <p>Describes the basic type or category of the service 
     * delivery location.</p>
     * 
     * <p>Un-merged Business Name: ServiceLocationType</p>
     * 
     * <p>Relationship: 
     * COCT_MT240003CA.ServiceDeliveryLocation.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Useful in providing context. May also be used for 
     * grouping and organizing data. Because this is a key element 
     * in understanding the location, it is mandatory.</p>
     * 
     * <p>Describes the basic type or category of the service 
     * delivery location.</p>
     * 
     * <p>Un-merged Business Name: ServiceLocationType</p>
     * 
     * <p>Relationship: 
     * COCT_MT011001CA.ServiceDeliveryLocation.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setCode(ServiceDeliveryLocationRoleType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: ServiceLocationAddress</p>
     * 
     * <p>Un-merged Business Name: ServiceLocationAddress</p>
     * 
     * <p>Relationship: 
     * COCT_MT240007CA.ServiceDeliveryLocation.addr</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Identifies the physical location of a service location 
     * and also allows for the location to be contacted.</p><p>The 
     * address is marked as 'populated' because it is considered a 
     * critical piece of information about the facility, but may 
     * not always be available or meaningful.</p>
     * 
     * <p>The information by which a service location may be 
     * contacted either physically or by mail.</p>
     * 
     * <p>Un-merged Business Name: ServiceLocationAddress</p>
     * 
     * <p>Relationship: 
     * COCT_MT240003CA.ServiceDeliveryLocation.addr</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Identifies the physical location of a service location 
     * and also allows for the location to be contacted.</p><p>The 
     * address is marked as 'populated' because it is considered a 
     * critical piece of information about the facility, but may 
     * not always be available or meaningful.</p>
     * 
     * <p>The information by which a service location may be 
     * contacted either physically or by mail.</p>
     */
    @Hl7XmlMapping({"addr"})
    public PostalAddress getAddr() {
        return this.addr.getValue();
    }

    /**
     * <p>Business Name: ServiceLocationAddress</p>
     * 
     * <p>Un-merged Business Name: ServiceLocationAddress</p>
     * 
     * <p>Relationship: 
     * COCT_MT240007CA.ServiceDeliveryLocation.addr</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Identifies the physical location of a service location 
     * and also allows for the location to be contacted.</p><p>The 
     * address is marked as 'populated' because it is considered a 
     * critical piece of information about the facility, but may 
     * not always be available or meaningful.</p>
     * 
     * <p>The information by which a service location may be 
     * contacted either physically or by mail.</p>
     * 
     * <p>Un-merged Business Name: ServiceLocationAddress</p>
     * 
     * <p>Relationship: 
     * COCT_MT240003CA.ServiceDeliveryLocation.addr</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Identifies the physical location of a service location 
     * and also allows for the location to be contacted.</p><p>The 
     * address is marked as 'populated' because it is considered a 
     * critical piece of information about the facility, but may 
     * not always be available or meaningful.</p>
     * 
     * <p>The information by which a service location may be 
     * contacted either physically or by mail.</p>
     */
    public void setAddr(PostalAddress addr) {
        this.addr.setValue(addr);
    }


    /**
     * <p>Business Name: ServiceLocationPhonesAndEMails</p>
     * 
     * <p>Un-merged Business Name: ServiceLocationPhonesAndEMails</p>
     * 
     * <p>Relationship: 
     * COCT_MT240007CA.ServiceDeliveryLocation.telecom</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1-5)</p>
     * 
     * <p>Allows a service location to be communicated with and is 
     * therefore important. Because a contact number won't always 
     * exist, the field is marked 'populated'.</p>
     * 
     * <p>The phone numbers and/or electronic mail addresses by 
     * which a service location may be contacted.</p>
     * 
     * <p>Un-merged Business Name: ServiceLocationPhonesAndEMails</p>
     * 
     * <p>Relationship: 
     * COCT_MT240003CA.ServiceDeliveryLocation.telecom</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1-5)</p>
     * 
     * <p>Allows a service location to be communicated with and is 
     * therefore important. Because a contact number won't always 
     * exist, the field is marked 'populated'.</p>
     * 
     * <p>The phone numbers and/or electronic mail addresses by 
     * which a service location may be contacted.</p>
     */
    @Hl7XmlMapping({"telecom"})
    public Set<TelecommunicationAddress> getTelecom() {
        return this.telecom.rawSet();
    }


    /**
     * <p>Business Name: ServiceLocationName</p>
     * 
     * <p>Un-merged Business Name: ServiceLocationName</p>
     * 
     * <p>Relationship: COCT_MT240007CA.Place.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>PVD.070</p>
     * 
     * <p>Dispensing Pharmacy Name</p>
     * 
     * <p>Facility.name</p>
     * 
     * <p>Used for human communication, and for cross-checking of 
     * location Id and is therefore mandatory</p>
     * 
     * <p>The name assigned to the service location.</p>
     * 
     * <p>Un-merged Business Name: ServiceLocationName</p>
     * 
     * <p>Relationship: COCT_MT240003CA.Place.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>PVD.070</p>
     * 
     * <p>Dispensing Pharmacy Name</p>
     * 
     * <p>Facility.name</p>
     * 
     * <p>Used for human communication, and for cross-checking of 
     * location Id and is therefore mandatory</p>
     * 
     * <p>The name assigned to the service location.</p>
     */
    @Hl7XmlMapping({"location/name"})
    public String getLocationName() {
        return this.locationName.getValue();
    }

    /**
     * <p>Business Name: ServiceLocationName</p>
     * 
     * <p>Un-merged Business Name: ServiceLocationName</p>
     * 
     * <p>Relationship: COCT_MT240007CA.Place.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>PVD.070</p>
     * 
     * <p>Dispensing Pharmacy Name</p>
     * 
     * <p>Facility.name</p>
     * 
     * <p>Used for human communication, and for cross-checking of 
     * location Id and is therefore mandatory</p>
     * 
     * <p>The name assigned to the service location.</p>
     * 
     * <p>Un-merged Business Name: ServiceLocationName</p>
     * 
     * <p>Relationship: COCT_MT240003CA.Place.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>PVD.070</p>
     * 
     * <p>Dispensing Pharmacy Name</p>
     * 
     * <p>Facility.name</p>
     * 
     * <p>Used for human communication, and for cross-checking of 
     * location Id and is therefore mandatory</p>
     * 
     * <p>The name assigned to the service location.</p>
     */
    public void setLocationName(String locationName) {
        this.locationName.setValue(locationName);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT240007CA.Subject.position</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT240003CA.Subject.position</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf/position"})
    public List<GeographicCoordinatesBean> getSubjectOfPosition() {
        return this.subjectOfPosition;
    }

}
