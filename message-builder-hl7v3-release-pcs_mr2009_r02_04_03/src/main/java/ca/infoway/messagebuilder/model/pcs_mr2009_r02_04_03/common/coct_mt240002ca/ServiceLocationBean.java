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
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt240002ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt960002ca.GeographicCoordinatesBean;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>Business Name: Service Location</p>
 * 
 * <p>Used for tracking service delivery responsibility, to 
 * provide contact information for follow-up and for 
 * statistical analysis. Also important for indicating where 
 * paper records can be located.</p>
 * 
 * <p>An identification of a service location (or facility) 
 * that can be found in the service delivery location. E.g. 
 * Pharmacy, Medical Clinic, Hospital</p>
 */
@Hl7PartTypeMapping({"COCT_MT240002CA.ServiceDeliveryLocation"})
@Hl7RootType
public class ServiceLocationBean extends MessagePartBean {

    private static final long serialVersionUID = 20130103L;
    private II id = new IIImpl();
    private ST locationName = new STImpl();
    private List<GeographicCoordinatesBean> subjectOfPosition = new ArrayList<GeographicCoordinatesBean>();


    /**
     * <p>Business Name: C:Service Location Identifier</p>
     * 
     * <p>Relationship: COCT_MT240002CA.ServiceDeliveryLocation.id</p>
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
     * <p>Business Name: C:Service Location Identifier</p>
     * 
     * <p>Relationship: COCT_MT240002CA.ServiceDeliveryLocation.id</p>
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
     * <p>Business Name: B:Service Location Name</p>
     * 
     * <p>Relationship: COCT_MT240002CA.Place.name</p>
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
     * <p>Business Name: B:Service Location Name</p>
     * 
     * <p>Relationship: COCT_MT240002CA.Place.name</p>
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
     * <p>Relationship: COCT_MT240002CA.Subject.position</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf/position"})
    public List<GeographicCoordinatesBean> getSubjectOfPosition() {
        return this.subjectOfPosition;
    }

}
