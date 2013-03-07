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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lr.merged;

import java.util.ArrayList;
import java.util.List;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.domainvalue.ServiceDeliveryLocationPlaceType;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"PRPA_MT202301CA.Place","PRPA_MT202302CA.Place","PRPA_MT202303CA.Place"})
public class PlaceBean extends MessagePartBean {

    private static final long serialVersionUID = 20130307L;
    private List<HasBean> asIdentifiedLocation = new ArrayList<HasBean>();
    private CV code = new CVImpl();
    private BL mobileInd = new BLImpl();


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PRPA_MT202302CA.Place.asIdentifiedLocation</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1-5)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PRPA_MT202303CA.Place.asIdentifiedLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-5)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PRPA_MT202301CA.Place.asIdentifiedLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-5)</p>
     */
    @Hl7XmlMapping({"asIdentifiedLocation"})
    public List<HasBean> getAsIdentifiedLocation() {
        return this.asIdentifiedLocation;
    }


    /**
     * <p>Business Name: LocationPlaceType</p>
     * 
     * <p>Un-merged Business Name: LocationPlaceType</p>
     * 
     * <p>Relationship: PRPA_MT202303CA.Place.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used for searching, as well as for understanding what is 
     * meant by a particular location and is therefore 
     * mandatory.</p>
     * 
     * <p>Distinguishes different levels of location granularity. 
     * E.g. Campus, building, floor, ward, room, bed.</p>
     * 
     * <p>Un-merged Business Name: LocationPlaceType</p>
     * 
     * <p>Relationship: PRPA_MT202301CA.Place.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used for searching, as well as for understanding what is 
     * meant by a particular location and is therefore 
     * mandatory.</p>
     * 
     * <p>Distinguishes different levels of location granularity. 
     * E.g. Campus, building, floor, ward, room, bed.</p>
     */
    @Hl7XmlMapping({"code"})
    public ServiceDeliveryLocationPlaceType getCode() {
        return (ServiceDeliveryLocationPlaceType) this.code.getValue();
    }

    /**
     * <p>Business Name: LocationPlaceType</p>
     * 
     * <p>Un-merged Business Name: LocationPlaceType</p>
     * 
     * <p>Relationship: PRPA_MT202303CA.Place.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used for searching, as well as for understanding what is 
     * meant by a particular location and is therefore 
     * mandatory.</p>
     * 
     * <p>Distinguishes different levels of location granularity. 
     * E.g. Campus, building, floor, ward, room, bed.</p>
     * 
     * <p>Un-merged Business Name: LocationPlaceType</p>
     * 
     * <p>Relationship: PRPA_MT202301CA.Place.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used for searching, as well as for understanding what is 
     * meant by a particular location and is therefore 
     * mandatory.</p>
     * 
     * <p>Distinguishes different levels of location granularity. 
     * E.g. Campus, building, floor, ward, room, bed.</p>
     */
    public void setCode(ServiceDeliveryLocationPlaceType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: LocationMobileIndicator</p>
     * 
     * <p>Un-merged Business Name: LocationMobileIndicator</p>
     * 
     * <p>Relationship: PRPA_MT202303CA.Place.mobileInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows flagging that the location does not have a fixed 
     * physical location.</p><p>This element must always be known 
     * and is therefore mandatory.</p>
     * 
     * <p>An indication of whether a place has the capability to 
     * move from one location to another. Example: air and ground 
     * ambulances, mobile clinics.</p>
     * 
     * <p>Un-merged Business Name: LocationMobileIndicator</p>
     * 
     * <p>Relationship: PRPA_MT202301CA.Place.mobileInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows flagging that the location does not have a fixed 
     * physical location.</p><p>This element must always be known 
     * and is therefore mandatory.</p>
     * 
     * <p>An indication of whether a place has the capability to 
     * move from one location to another. Example: air and ground 
     * ambulances, mobile clinics.</p>
     */
    @Hl7XmlMapping({"mobileInd"})
    public Boolean getMobileInd() {
        return this.mobileInd.getValue();
    }

    /**
     * <p>Business Name: LocationMobileIndicator</p>
     * 
     * <p>Un-merged Business Name: LocationMobileIndicator</p>
     * 
     * <p>Relationship: PRPA_MT202303CA.Place.mobileInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows flagging that the location does not have a fixed 
     * physical location.</p><p>This element must always be known 
     * and is therefore mandatory.</p>
     * 
     * <p>An indication of whether a place has the capability to 
     * move from one location to another. Example: air and ground 
     * ambulances, mobile clinics.</p>
     * 
     * <p>Un-merged Business Name: LocationMobileIndicator</p>
     * 
     * <p>Relationship: PRPA_MT202301CA.Place.mobileInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows flagging that the location does not have a fixed 
     * physical location.</p><p>This element must always be known 
     * and is therefore mandatory.</p>
     * 
     * <p>An indication of whether a place has the capability to 
     * move from one location to another. Example: air and ground 
     * ambulances, mobile clinics.</p>
     */
    public void setMobileInd(Boolean mobileInd) {
        this.mobileInd.setValue(mobileInd);
    }

}
