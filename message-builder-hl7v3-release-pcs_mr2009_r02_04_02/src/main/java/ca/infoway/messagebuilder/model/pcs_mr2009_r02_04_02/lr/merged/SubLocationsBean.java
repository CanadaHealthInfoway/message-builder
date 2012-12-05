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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ServiceDeliveryLocationPlaceType;
import ca.infoway.messagebuilder.domainvalue.ServiceDeliveryLocationRoleType;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: SubLocations</p>
 * 
 * <p>PRPA_MT202301CA.SubLocation: Sub-Locations</p>
 * 
 * <p>Allows a more thorough understanding of the capabilities 
 * of the service delivery location, as well as drill-down to 
 * component parts.</p>
 * 
 * <p>Identifies service delivery locations contained within 
 * the described &quot;parent&quot; service delivery 
 * location.</p>
 * 
 * <p>PRPA_MT202302CA.SubLocation: Sub-Locations</p>
 * 
 * <p>Allows a more thorough understanding of the capabilities 
 * of the service delivery location, as well as drill-down to 
 * component parts.</p>
 * 
 * <p>Identifies service delivery locations contained within 
 * the described &quot;parent&quot; service delivery 
 * location.</p>
 * 
 * <p>PRPA_MT202303CA.SubLocation: Sub-Locations</p>
 * 
 * <p>Allows a more thorough understanding of the capabilities 
 * of the service delivery location, as well as drill-down to 
 * component parts.</p>
 * 
 * <p>Identifies service delivery locations contained within 
 * the described &quot;parent&quot; service delivery 
 * location.</p>
 */
@Hl7PartTypeMapping({"PRPA_MT202301CA.SubLocation","PRPA_MT202302CA.SubLocation","PRPA_MT202303CA.SubLocation"})
public class SubLocationsBean extends MessagePartBean {

    private static final long serialVersionUID = 20121204L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private ST name = new STImpl();
    private CV locationCode = new CVImpl();


    /**
     * <p>Business Name: SubLocationIdentifier</p>
     * 
     * <p>Other Business Name: SubLocationIdentifier</p>
     * 
     * <p>Relationship: PRPA_MT202301CA.SubLocation.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows subsequent queries to drill down to detail 
     * information about this specific sub location and is 
     * therefore mandatory.</p>
     * 
     * <p>Unique identifier for the contained service delivery 
     * location</p>
     * 
     * <p>Other Business Name: SubLocationIdentifier</p>
     * 
     * <p>Relationship: PRPA_MT202302CA.SubLocation.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows subsequent queries to drill down to detail 
     * information about this specific sub location and is 
     * therefore mandatory.</p>
     * 
     * <p>Unique identifier for the contained service delivery 
     * location</p>
     * 
     * <p>Other Business Name: SubLocationIdentifier</p>
     * 
     * <p>Relationship: PRPA_MT202303CA.SubLocation.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows subsequent queries to drill down to detail 
     * information about this specific sub location and is 
     * therefore mandatory.</p>
     * 
     * <p>Unique identifier for the contained service delivery 
     * location</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: SubLocationIdentifier</p>
     * 
     * <p>Other Business Name: SubLocationIdentifier</p>
     * 
     * <p>Relationship: PRPA_MT202301CA.SubLocation.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows subsequent queries to drill down to detail 
     * information about this specific sub location and is 
     * therefore mandatory.</p>
     * 
     * <p>Unique identifier for the contained service delivery 
     * location</p>
     * 
     * <p>Other Business Name: SubLocationIdentifier</p>
     * 
     * <p>Relationship: PRPA_MT202302CA.SubLocation.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows subsequent queries to drill down to detail 
     * information about this specific sub location and is 
     * therefore mandatory.</p>
     * 
     * <p>Unique identifier for the contained service delivery 
     * location</p>
     * 
     * <p>Other Business Name: SubLocationIdentifier</p>
     * 
     * <p>Relationship: PRPA_MT202303CA.SubLocation.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows subsequent queries to drill down to detail 
     * information about this specific sub location and is 
     * therefore mandatory.</p>
     * 
     * <p>Unique identifier for the contained service delivery 
     * location</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: SubLocationType</p>
     * 
     * <p>Other Business Name: SubLocationType</p>
     * 
     * <p>Relationship: PRPA_MT202301CA.SubLocation.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides context about what the capabilities of the 
     * component service delivery location are. Allows for unique 
     * identification of a sub-location and is therefore 
     * mandatory.</p>
     * 
     * <p>Describes the 'type' of component service delivery 
     * location. For example, a hospital might contain a laboratory 
     * or a community clinic.</p>
     * 
     * <p>Other Business Name: SubLocationType</p>
     * 
     * <p>Relationship: PRPA_MT202302CA.SubLocation.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides context about what the capabilities of the 
     * component service delivery location are. Allows for unique 
     * identification of a sub-location and is therefore 
     * mandatory.</p>
     * 
     * <p>Describes the 'type' of component service delivery 
     * location. For example, a hospital might contain a laboratory 
     * or a community clinic.</p>
     * 
     * <p>Other Business Name: SubLocationType</p>
     * 
     * <p>Relationship: PRPA_MT202303CA.SubLocation.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides context about what the capabilities of the 
     * component service delivery location are. Allows for unique 
     * identification of a sub-location and is therefore 
     * mandatory.</p>
     * 
     * <p>Describes the 'type' of component service delivery 
     * location. For example, a hospital might contain a laboratory 
     * or a community clinic.</p>
     */
    @Hl7XmlMapping({"code"})
    public ServiceDeliveryLocationRoleType getCode() {
        return (ServiceDeliveryLocationRoleType) this.code.getValue();
    }

    /**
     * <p>Business Name: SubLocationType</p>
     * 
     * <p>Other Business Name: SubLocationType</p>
     * 
     * <p>Relationship: PRPA_MT202301CA.SubLocation.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides context about what the capabilities of the 
     * component service delivery location are. Allows for unique 
     * identification of a sub-location and is therefore 
     * mandatory.</p>
     * 
     * <p>Describes the 'type' of component service delivery 
     * location. For example, a hospital might contain a laboratory 
     * or a community clinic.</p>
     * 
     * <p>Other Business Name: SubLocationType</p>
     * 
     * <p>Relationship: PRPA_MT202302CA.SubLocation.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides context about what the capabilities of the 
     * component service delivery location are. Allows for unique 
     * identification of a sub-location and is therefore 
     * mandatory.</p>
     * 
     * <p>Describes the 'type' of component service delivery 
     * location. For example, a hospital might contain a laboratory 
     * or a community clinic.</p>
     * 
     * <p>Other Business Name: SubLocationType</p>
     * 
     * <p>Relationship: PRPA_MT202303CA.SubLocation.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides context about what the capabilities of the 
     * component service delivery location are. Allows for unique 
     * identification of a sub-location and is therefore 
     * mandatory.</p>
     * 
     * <p>Describes the 'type' of component service delivery 
     * location. For example, a hospital might contain a laboratory 
     * or a community clinic.</p>
     */
    public void setCode(ServiceDeliveryLocationRoleType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: LocationName</p>
     * 
     * <p>Other Business Name: LocationName</p>
     * 
     * <p>Relationship: PRPA_MT202301CA.SubLocation.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides a human-readable label for the location and is 
     * therefore mandatory. In general, names of sub-locations will 
     * be unique within their containing location.</p>
     * 
     * <p>A descriptive name for the sub-location.</p>
     * 
     * <p>Other Business Name: LocationName</p>
     * 
     * <p>Relationship: PRPA_MT202302CA.SubLocation.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides a human-readable label for the location and is 
     * therefore mandatory. In general, names of sub-locations will 
     * be unique within their containing location.</p>
     * 
     * <p>A descriptive name for the sub-location.</p>
     * 
     * <p>Other Business Name: LocationName</p>
     * 
     * <p>Relationship: PRPA_MT202303CA.SubLocation.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides a human-readable label for the location and is 
     * therefore mandatory. In general, names of sub-locations will 
     * be unique within their containing location.</p>
     * 
     * <p>A descriptive name for the sub-location.</p>
     */
    @Hl7XmlMapping({"name"})
    public String getName() {
        return this.name.getValue();
    }

    /**
     * <p>Business Name: LocationName</p>
     * 
     * <p>Other Business Name: LocationName</p>
     * 
     * <p>Relationship: PRPA_MT202301CA.SubLocation.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides a human-readable label for the location and is 
     * therefore mandatory. In general, names of sub-locations will 
     * be unique within their containing location.</p>
     * 
     * <p>A descriptive name for the sub-location.</p>
     * 
     * <p>Other Business Name: LocationName</p>
     * 
     * <p>Relationship: PRPA_MT202302CA.SubLocation.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides a human-readable label for the location and is 
     * therefore mandatory. In general, names of sub-locations will 
     * be unique within their containing location.</p>
     * 
     * <p>A descriptive name for the sub-location.</p>
     * 
     * <p>Other Business Name: LocationName</p>
     * 
     * <p>Relationship: PRPA_MT202303CA.SubLocation.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides a human-readable label for the location and is 
     * therefore mandatory. In general, names of sub-locations will 
     * be unique within their containing location.</p>
     * 
     * <p>A descriptive name for the sub-location.</p>
     */
    public void setName(String name) {
        this.name.setValue(name);
    }


    /**
     * <p>Business Name: SubLocationPlaceType</p>
     * 
     * <p>Other Business Name: SubLocationPlaceType</p>
     * 
     * <p>Relationship: PRPA_MT202301CA.SubPlace.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides context about the type of 
     * sub-location.</p><p>Used for searching, as well as for 
     * understanding what is meant by a particular sub-location and 
     * is therefore mandatory.</p>
     * 
     * <p>Identifies the physical type of the component location. 
     * For example, a campus may contain a building, a building may 
     * contain a ward, etc.</p>
     * 
     * <p>Other Business Name: SubLocationPlaceType</p>
     * 
     * <p>Relationship: PRPA_MT202302CA.SubPlace.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides context about the type of 
     * sub-location.</p><p>Used for searching, as well as for 
     * understanding what is meant by a particular sub-location and 
     * is therefore mandatory.</p>
     * 
     * <p>Identifies the physical type of the component location. 
     * For example, a campus may contain a building, a building may 
     * contain a ward, etc.</p>
     * 
     * <p>Other Business Name: SubLocationPlaceType</p>
     * 
     * <p>Relationship: PRPA_MT202303CA.SubPlace.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides context about the type of 
     * sub-location.</p><p>Used for searching, as well as for 
     * understanding what is meant by a particular sub-location and 
     * is therefore mandatory.</p>
     * 
     * <p>Identifies the physical type of the component location. 
     * For example, a campus may contain a building, a building may 
     * contain a ward, etc.</p>
     */
    @Hl7XmlMapping({"location/code"})
    public ServiceDeliveryLocationPlaceType getLocationCode() {
        return (ServiceDeliveryLocationPlaceType) this.locationCode.getValue();
    }

    /**
     * <p>Business Name: SubLocationPlaceType</p>
     * 
     * <p>Other Business Name: SubLocationPlaceType</p>
     * 
     * <p>Relationship: PRPA_MT202301CA.SubPlace.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides context about the type of 
     * sub-location.</p><p>Used for searching, as well as for 
     * understanding what is meant by a particular sub-location and 
     * is therefore mandatory.</p>
     * 
     * <p>Identifies the physical type of the component location. 
     * For example, a campus may contain a building, a building may 
     * contain a ward, etc.</p>
     * 
     * <p>Other Business Name: SubLocationPlaceType</p>
     * 
     * <p>Relationship: PRPA_MT202302CA.SubPlace.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides context about the type of 
     * sub-location.</p><p>Used for searching, as well as for 
     * understanding what is meant by a particular sub-location and 
     * is therefore mandatory.</p>
     * 
     * <p>Identifies the physical type of the component location. 
     * For example, a campus may contain a building, a building may 
     * contain a ward, etc.</p>
     * 
     * <p>Other Business Name: SubLocationPlaceType</p>
     * 
     * <p>Relationship: PRPA_MT202303CA.SubPlace.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides context about the type of 
     * sub-location.</p><p>Used for searching, as well as for 
     * understanding what is meant by a particular sub-location and 
     * is therefore mandatory.</p>
     * 
     * <p>Identifies the physical type of the component location. 
     * For example, a campus may contain a building, a building may 
     * contain a ward, etc.</p>
     */
    public void setLocationCode(ServiceDeliveryLocationPlaceType locationCode) {
        this.locationCode.setValue(locationCode);
    }

}
