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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.lr.prpa_mt202303ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.domainvalue.ServiceDeliveryLocationRoleType;
import ca.infoway.messagebuilder.domainvalue.ServiceDeliveryRoleStatus;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.common.coct_mt960002ca.GeographicCoordinatesBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.lr.merged.AvailableServicesBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.lr.merged.IndirectAuthorithyOverBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.lr.merged.PlaceBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.lr.merged.ResponsibleOrganizationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.lr.merged.SubLocationsBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.merged.ContactPointsBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



/**
 * <p>Business Name: Location</p>
 * 
 * <p>At least one of address or coordinate must be specified 
 * unless the place is mobile.</p>
 * 
 * <p>Provides location information which uniquely identifies 
 * where health services are provided. This includes details 
 * and other supporting information on locations e.g. name, 
 * address, organization and contact parties. Needed when 
 * looking up facilities to link to patient records. Also 
 * useful when trying to find facilities to meet particular 
 * patient needs, as well as looking up how to contact the 
 * location.</p>
 * 
 * <p>Any location where health-related services may be 
 * provided. Note that a single physical place can play 
 * multiple service delivery location roles e.g. a Podiatry 
 * clinic and Research clinic may meet on alternate days in the 
 * same physical location; each clinic uses its own mailing 
 * address and telephone number.</p>
 */
@Hl7PartTypeMapping({"PRPA_MT202303CA.ServiceDeliveryLocation"})
@Hl7RootType
public class LocationBean extends MessagePartBean {

    private static final long serialVersionUID = 20150904L;
    private SET<II, Identifier> id = new SETImpl<II, Identifier>(IIImpl.class);
    private CV code = new CVImpl();
    private SET<ST, String> name = new SETImpl<ST, String>(STImpl.class);
    private AD addr = new ADImpl();
    private CS statusCode = new CSImpl();
    private PlaceBean location;
    private ResponsibleOrganizationBean serviceProviderOrganization;
    private List<GeographicCoordinatesBean> subjectOfPosition = new ArrayList<GeographicCoordinatesBean>();
    private List<AvailableServicesBean> locationOfServiceDefinition = new ArrayList<AvailableServicesBean>();
    private List<ContactPointsBean> directAuthorityOverContactParty = new ArrayList<ContactPointsBean>();
    private List<SubLocationsBean> partSubLocation = new ArrayList<SubLocationsBean>();
    private IndirectAuthorithyOverBean indirectAuthority;
    private LocationBean partOfServiceDeliveryLocation;


    /**
     * <p>Business Name: A:Location Identifiers</p>
     * 
     * <p>Relationship: PRPA_MT202303CA.ServiceDeliveryLocation.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (2)</p>
     * 
     * <p> <i>Allows for unique identification of the Location and 
     * is therefore mandatory. Supports drill-down queries, linking 
     * of this record to other records, matching of EHR records to 
     * locally-stored PoS records and is necessary when identifying 
     * records for amending (revising)/directional linking 
     * (superseding).</i> </p>
     * 
     * <p> <i>A globally unique identifier assigned by the EHR to 
     * the Location record.</i> </p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getId() {
        return this.id.rawSet();
    }


    /**
     * <p>Business Name: B: Location Type</p>
     * 
     * <p>Relationship: 
     * PRPA_MT202303CA.ServiceDeliveryLocation.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Location Type is used for searching and for 
     * organizing Location records as well as sorting them for 
     * presentation.</i> </p><p> <i>This is a key attribute for 
     * understanding the type of record and is therefore 
     * mandatory.</i> </p>
     * 
     * <p> <i>Identifies the type of Location represented by this 
     * record.</i> </p><p>For example, a service delivery location 
     * may be either an incidental service delivery location (a 
     * place at which health-related services may be provided 
     * without prior designation or authorization such as a church 
     * or school) or a dedicated service delivery location (a place 
     * that is intended to house the provision of health-related 
     * services such as a clinic or hospital). Dedicated service 
     * delivery locations can be further characterized as either 
     * clinical or non-clinical.</p>
     */
    @Hl7XmlMapping({"code"})
    public ServiceDeliveryLocationRoleType getCode() {
        return (ServiceDeliveryLocationRoleType) this.code.getValue();
    }

    /**
     * <p>Business Name: B: Location Type</p>
     * 
     * <p>Relationship: 
     * PRPA_MT202303CA.ServiceDeliveryLocation.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Location Type is used for searching and for 
     * organizing Location records as well as sorting them for 
     * presentation.</i> </p><p> <i>This is a key attribute for 
     * understanding the type of record and is therefore 
     * mandatory.</i> </p>
     * 
     * <p> <i>Identifies the type of Location represented by this 
     * record.</i> </p><p>For example, a service delivery location 
     * may be either an incidental service delivery location (a 
     * place at which health-related services may be provided 
     * without prior designation or authorization such as a church 
     * or school) or a dedicated service delivery location (a place 
     * that is intended to house the provision of health-related 
     * services such as a clinic or hospital). Dedicated service 
     * delivery locations can be further characterized as either 
     * clinical or non-clinical.</p>
     */
    public void setCode(ServiceDeliveryLocationRoleType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: D:Location Names</p>
     * 
     * <p>Relationship: 
     * PRPA_MT202303CA.ServiceDeliveryLocation.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-5)</p>
     * 
     * <p>Provides a human-readable label for the location. The 
     * location name is not intended to be parsed or analyzed by 
     * when processing the record. (E.g. To determine if a location 
     * is a hospital, look at the location type, don't check the 
     * name for the word &quot;hospital&quot;.)</p><p>Multiple 
     * repetitions are allowed to capture historical names</p>
     * 
     * <p>A textual name for the place where the service is 
     * provided e.g. Ottawa General Hospital.</p>
     */
    @Hl7XmlMapping({"name"})
    public Set<String> getName() {
        return this.name.rawSet();
    }


    /**
     * <p>Business Name: G:Location Address</p>
     * 
     * <p>Relationship: 
     * PRPA_MT202303CA.ServiceDeliveryLocation.addr</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Restricted to physical address only</p>
     * 
     * <p>Allows location to be visited. May also be used for 
     * geographic profiling (e.g. a dispatcher may be looking for 
     * the closest hospital or ambulance that can help a patient in 
     * need of emergency care).</p><p>Because a physical address 
     * may not exist for mobile locations, and may not be 
     * expressible for non-dedicated locations such as water 
     * resevoirs, this element is only 'populated'. When no address 
     * exists, the null flavor should be set to NA.</p>
     * 
     * <p>For mobile service delivery location, this can either be 
     * set to the address of the &quot;home&quot; site for the 
     * mobile unit or can be set to a null flavor of N/A.</p>
     * 
     * <p>Identifies the physical address for this service delivery 
     * location, I.e. What is the geographic location of the 
     * building.</p>
     */
    @Hl7XmlMapping({"addr"})
    public PostalAddress getAddr() {
        return this.addr.getValue();
    }

    /**
     * <p>Business Name: G:Location Address</p>
     * 
     * <p>Relationship: 
     * PRPA_MT202303CA.ServiceDeliveryLocation.addr</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Restricted to physical address only</p>
     * 
     * <p>Allows location to be visited. May also be used for 
     * geographic profiling (e.g. a dispatcher may be looking for 
     * the closest hospital or ambulance that can help a patient in 
     * need of emergency care).</p><p>Because a physical address 
     * may not exist for mobile locations, and may not be 
     * expressible for non-dedicated locations such as water 
     * resevoirs, this element is only 'populated'. When no address 
     * exists, the null flavor should be set to NA.</p>
     * 
     * <p>For mobile service delivery location, this can either be 
     * set to the address of the &quot;home&quot; site for the 
     * mobile unit or can be set to a null flavor of N/A.</p>
     * 
     * <p>Identifies the physical address for this service delivery 
     * location, I.e. What is the geographic location of the 
     * building.</p>
     */
    public void setAddr(PostalAddress addr) {
        this.addr.setValue(addr);
    }


    /**
     * <p>Business Name: C: Location Status</p>
     * 
     * <p>Relationship: 
     * PRPA_MT202303CA.ServiceDeliveryLocation.statusCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p> <i>Status is frequently used to filter query responses 
     * as well as to sort records for presentation. It also affects 
     * how the Location record is interpreted.</i> </p><p> 
     * <i>Because the status won't always be known, the attribute 
     * is marked as 'populated' to allow the use of null 
     * flavors.</i> </p>
     * 
     * <p> <i>This identifies the current state of the Location 
     * record.</i> </p><p>Allowed status values are 'active' (the 
     * location is actively used to deliver healthcare-related 
     * services), 'suspended' (the location has temporarily ceased 
     * delivering healthcare-related services) and 'terminated' 
     * (the location has permanently ceased delivering 
     * healthcare-related services and may no longer physically 
     * exist.)</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ServiceDeliveryRoleStatus getStatusCode() {
        return (ServiceDeliveryRoleStatus) this.statusCode.getValue();
    }

    /**
     * <p>Business Name: C: Location Status</p>
     * 
     * <p>Relationship: 
     * PRPA_MT202303CA.ServiceDeliveryLocation.statusCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p> <i>Status is frequently used to filter query responses 
     * as well as to sort records for presentation. It also affects 
     * how the Location record is interpreted.</i> </p><p> 
     * <i>Because the status won't always be known, the attribute 
     * is marked as 'populated' to allow the use of null 
     * flavors.</i> </p>
     * 
     * <p> <i>This identifies the current state of the Location 
     * record.</i> </p><p>Allowed status values are 'active' (the 
     * location is actively used to deliver healthcare-related 
     * services), 'suspended' (the location has temporarily ceased 
     * delivering healthcare-related services) and 'terminated' 
     * (the location has permanently ceased delivering 
     * healthcare-related services and may no longer physically 
     * exist.)</p>
     */
    public void setStatusCode(ServiceDeliveryRoleStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Relationship: 
     * PRPA_MT202303CA.ServiceDeliveryLocation.location</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"location"})
    public PlaceBean getLocation() {
        return this.location;
    }

    /**
     * <p>Relationship: 
     * PRPA_MT202303CA.ServiceDeliveryLocation.location</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setLocation(PlaceBean location) {
        this.location = location;
    }


    /**
     * <p>Relationship: 
     * PRPA_MT202303CA.ServiceDeliveryLocation.serviceProviderOrganization</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"serviceProviderOrganization"})
    public ResponsibleOrganizationBean getServiceProviderOrganization() {
        return this.serviceProviderOrganization;
    }

    /**
     * <p>Relationship: 
     * PRPA_MT202303CA.ServiceDeliveryLocation.serviceProviderOrganization</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setServiceProviderOrganization(ResponsibleOrganizationBean serviceProviderOrganization) {
        this.serviceProviderOrganization = serviceProviderOrganization;
    }


    /**
     * <p>Relationship: PRPA_MT202303CA.Subject.position</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf/position"})
    public List<GeographicCoordinatesBean> getSubjectOfPosition() {
        return this.subjectOfPosition;
    }


    /**
     * <p>Relationship: PRPA_MT202303CA.Location.serviceDefinition</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"locationOf/serviceDefinition"})
    public List<AvailableServicesBean> getLocationOfServiceDefinition() {
        return this.locationOfServiceDefinition;
    }


    /**
     * <p>Relationship: 
     * PRPA_MT202303CA.DirectAuthorityOver.contactParty</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"directAuthorityOver/contactParty"})
    public List<ContactPointsBean> getDirectAuthorityOverContactParty() {
        return this.directAuthorityOverContactParty;
    }


    /**
     * <p>Relationship: PRPA_MT202303CA.Part.subLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"part/subLocation"})
    public List<SubLocationsBean> getPartSubLocation() {
        return this.partSubLocation;
    }


    /**
     * <p>Relationship: 
     * PRPA_MT202303CA.ServiceDeliveryLocation.indirectAuthority</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"indirectAuthority"})
    public IndirectAuthorithyOverBean getIndirectAuthority() {
        return this.indirectAuthority;
    }

    /**
     * <p>Relationship: 
     * PRPA_MT202303CA.ServiceDeliveryLocation.indirectAuthority</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setIndirectAuthority(IndirectAuthorithyOverBean indirectAuthority) {
        this.indirectAuthority = indirectAuthority;
    }


    /**
     * <p>Relationship: 
     * PRPA_MT202303CA.Part2.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"partOf/serviceDeliveryLocation"})
    public LocationBean getPartOfServiceDeliveryLocation() {
        return this.partOfServiceDeliveryLocation;
    }

    /**
     * <p>Relationship: 
     * PRPA_MT202303CA.Part2.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setPartOfServiceDeliveryLocation(LocationBean partOfServiceDeliveryLocation) {
        this.partOfServiceDeliveryLocation = partOfServiceDeliveryLocation;
    }

}
