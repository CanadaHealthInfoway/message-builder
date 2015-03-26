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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.common.coct_mt240003ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Set;



/**
 * <p>Business Name: Service Location</p>
 * 
 * <p>An identification of a service location (or facility) 
 * where health service has been or can be delivered. E.g. 
 * Pharmacy, Medical Clinic, Hospital</p>
 * 
 * <p>Used for tracking service delivery responsibility, to 
 * provide contact information for follow-up and for 
 * statistical analysis. Also important for indicating where 
 * paper records can be located.</p>
 */
@Hl7PartTypeMapping({"COCT_MT240003CA.ServiceDeliveryLocation"})
@Hl7RootType
public class ServiceLocationBean extends MessagePartBean implements ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.merged.Recipient {

    private static final long serialVersionUID = 20150326L;
    private II id = new IIImpl();
    private AD addr = new ADImpl();
    private SET<TEL, TelecommunicationAddress> telecom = new SETImpl<TEL, TelecommunicationAddress>(TELImpl.class);
    private ST locationName = new STImpl();


    /**
     * <p>Business Name: C:Service Location Id</p>
     * 
     * <p>Relationship: COCT_MT240003CA.ServiceDeliveryLocation.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Unique identifier for a healthcare service location.</p>
     * 
     * <p>PVD.020-01 (extension)</p><p>PVD.020-02 
     * (root)</p><p>Dispensing Pharmacy number</p><p>Pharmacy 
     * Identifier</p><p>Facility.facilityKey</p><p>DispensedItem.facilityKey</p>
     * 
     * <p>PVD.020-01 (extension)</p><p>PVD.020-02 
     * (root)</p><p>Dispensing Pharmacy number</p><p>Pharmacy 
     * Identifier</p><p>Facility.facilityKey</p><p>DispensedItem.facilityKey</p>
     * 
     * <p>PVD.020-01 (extension)</p><p>PVD.020-02 
     * (root)</p><p>Dispensing Pharmacy number</p><p>Pharmacy 
     * Identifier</p><p>Facility.facilityKey</p><p>DispensedItem.facilityKey</p>
     * 
     * <p>PVD.020-01 (extension)</p><p>PVD.020-02 
     * (root)</p><p>Dispensing Pharmacy number</p><p>Pharmacy 
     * Identifier</p><p>Facility.facilityKey</p><p>DispensedItem.facilityKey</p>
     * 
     * <p>PVD.020-01 (extension)</p><p>PVD.020-02 
     * (root)</p><p>Dispensing Pharmacy number</p><p>Pharmacy 
     * Identifier</p><p>Facility.facilityKey</p><p>DispensedItem.facilityKey</p>
     * 
     * <p>PVD.020-01 (extension)</p><p>PVD.020-02 
     * (root)</p><p>Dispensing Pharmacy number</p><p>Pharmacy 
     * Identifier</p><p>Facility.facilityKey</p><p>DispensedItem.facilityKey</p>
     * 
     * <p>Allows for lookup and retrieval of detailed information 
     * about a specific service location. Also ensures unique 
     * identification of service location and is therefore 
     * mandatory.</p><p>The identifier is mandatory because it is 
     * the principal mechanism for uniquely identifying the 
     * facility.</p>
     * 
     * <p>Allows for lookup and retrieval of detailed information 
     * about a specific service location. Also ensures unique 
     * identification of service location and is therefore 
     * mandatory.</p><p>The identifier is mandatory because it is 
     * the principal mechanism for uniquely identifying the 
     * facility.</p>
     * 
     * <p>&nbsp;If this identifier does not exist in the</p> 
     * <div>jurisidiction&rsquo;s location registry, then a 
     * KEY204</div> <div>error issue will be returned.</div>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: C:Service Location Id</p>
     * 
     * <p>Relationship: COCT_MT240003CA.ServiceDeliveryLocation.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Unique identifier for a healthcare service location.</p>
     * 
     * <p>PVD.020-01 (extension)</p><p>PVD.020-02 
     * (root)</p><p>Dispensing Pharmacy number</p><p>Pharmacy 
     * Identifier</p><p>Facility.facilityKey</p><p>DispensedItem.facilityKey</p>
     * 
     * <p>PVD.020-01 (extension)</p><p>PVD.020-02 
     * (root)</p><p>Dispensing Pharmacy number</p><p>Pharmacy 
     * Identifier</p><p>Facility.facilityKey</p><p>DispensedItem.facilityKey</p>
     * 
     * <p>PVD.020-01 (extension)</p><p>PVD.020-02 
     * (root)</p><p>Dispensing Pharmacy number</p><p>Pharmacy 
     * Identifier</p><p>Facility.facilityKey</p><p>DispensedItem.facilityKey</p>
     * 
     * <p>PVD.020-01 (extension)</p><p>PVD.020-02 
     * (root)</p><p>Dispensing Pharmacy number</p><p>Pharmacy 
     * Identifier</p><p>Facility.facilityKey</p><p>DispensedItem.facilityKey</p>
     * 
     * <p>PVD.020-01 (extension)</p><p>PVD.020-02 
     * (root)</p><p>Dispensing Pharmacy number</p><p>Pharmacy 
     * Identifier</p><p>Facility.facilityKey</p><p>DispensedItem.facilityKey</p>
     * 
     * <p>PVD.020-01 (extension)</p><p>PVD.020-02 
     * (root)</p><p>Dispensing Pharmacy number</p><p>Pharmacy 
     * Identifier</p><p>Facility.facilityKey</p><p>DispensedItem.facilityKey</p>
     * 
     * <p>Allows for lookup and retrieval of detailed information 
     * about a specific service location. Also ensures unique 
     * identification of service location and is therefore 
     * mandatory.</p><p>The identifier is mandatory because it is 
     * the principal mechanism for uniquely identifying the 
     * facility.</p>
     * 
     * <p>Allows for lookup and retrieval of detailed information 
     * about a specific service location. Also ensures unique 
     * identification of service location and is therefore 
     * mandatory.</p><p>The identifier is mandatory because it is 
     * the principal mechanism for uniquely identifying the 
     * facility.</p>
     * 
     * <p>&nbsp;If this identifier does not exist in the</p> 
     * <div>jurisidiction&rsquo;s location registry, then a 
     * KEY204</div> <div>error issue will be returned.</div>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: D:Service Location Address</p>
     * 
     * <p>Relationship: 
     * COCT_MT240003CA.ServiceDeliveryLocation.addr</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>The information by which a service location may be 
     * contacted either physically or by mail.</p>
     * 
     * <p>Identifies the physical location of a service location 
     * and also allows for the location to be contacted.</p><p>The 
     * address is marked as 'populated' because it is considered a 
     * critical piece of information about the facility, but may 
     * not always be available or meaningful.</p>
     * 
     * <p>Identifies the physical location of a service location 
     * and also allows for the location to be contacted.</p><p>The 
     * address is marked as 'populated' because it is considered a 
     * critical piece of information about the facility, but may 
     * not always be available or meaningful.</p>
     */
    @Hl7XmlMapping({"addr"})
    public PostalAddress getAddr() {
        return this.addr.getValue();
    }

    /**
     * <p>Business Name: D:Service Location Address</p>
     * 
     * <p>Relationship: 
     * COCT_MT240003CA.ServiceDeliveryLocation.addr</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>The information by which a service location may be 
     * contacted either physically or by mail.</p>
     * 
     * <p>Identifies the physical location of a service location 
     * and also allows for the location to be contacted.</p><p>The 
     * address is marked as 'populated' because it is considered a 
     * critical piece of information about the facility, but may 
     * not always be available or meaningful.</p>
     * 
     * <p>Identifies the physical location of a service location 
     * and also allows for the location to be contacted.</p><p>The 
     * address is marked as 'populated' because it is considered a 
     * critical piece of information about the facility, but may 
     * not always be available or meaningful.</p>
     */
    public void setAddr(PostalAddress addr) {
        this.addr.setValue(addr);
    }


    /**
     * <p>Business Name: E:Service Location Phones and E-mails</p>
     * 
     * <p>Relationship: 
     * COCT_MT240003CA.ServiceDeliveryLocation.telecom</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1-5)</p>
     * 
     * <p>The phone numbers and/or electronic mail addresses by 
     * which a service location may be contacted.</p>
     * 
     * <p>Allows a service location to be communicated with and is 
     * therefore important. Because a contact number won't always 
     * exist, the field is marked 'populated'.</p>
     */
    @Hl7XmlMapping({"telecom"})
    public Set<TelecommunicationAddress> getTelecom() {
        return this.telecom.rawSet();
    }


    /**
     * <p>Business Name: B:Service Location Name</p>
     * 
     * <p>Relationship: COCT_MT240003CA.Place.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The name assigned to the service location.</p>
     * 
     * <p>PVD.070</p><p>Dispensing Pharmacy 
     * Name</p><p>Facility.name</p>
     * 
     * <p>PVD.070</p><p>Dispensing Pharmacy 
     * Name</p><p>Facility.name</p>
     * 
     * <p>PVD.070</p><p>Dispensing Pharmacy 
     * Name</p><p>Facility.name</p>
     * 
     * <p>Used for human communication, and for cross-checking of 
     * location Id and is therefore mandatory</p>
     */
    @Hl7XmlMapping({"location/name"})
    public String getLocationName() {
        return this.locationName.getValue();
    }

    /**
     * <p>Business Name: B:Service Location Name</p>
     * 
     * <p>Relationship: COCT_MT240003CA.Place.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The name assigned to the service location.</p>
     * 
     * <p>PVD.070</p><p>Dispensing Pharmacy 
     * Name</p><p>Facility.name</p>
     * 
     * <p>PVD.070</p><p>Dispensing Pharmacy 
     * Name</p><p>Facility.name</p>
     * 
     * <p>PVD.070</p><p>Dispensing Pharmacy 
     * Name</p><p>Facility.name</p>
     * 
     * <p>Used for human communication, and for cross-checking of 
     * location Id and is therefore mandatory</p>
     */
    public void setLocationName(String locationName) {
        this.locationName.setValue(locationName);
    }

}
