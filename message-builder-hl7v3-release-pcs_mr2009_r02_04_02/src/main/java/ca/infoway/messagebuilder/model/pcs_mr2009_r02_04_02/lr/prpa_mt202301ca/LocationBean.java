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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lr.prpa_mt202301ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.domainvalue.ServiceDeliveryLocationRoleType;
import ca.infoway.messagebuilder.domainvalue.ServiceDeliveryRoleStatus;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt960002ca.GeographicCoordinatesBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lr.merged.AvailableServicesBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lr.merged.IndirectAuthorithyOverBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lr.merged.PlaceBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lr.merged.ResponsibleOrganizationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lr.merged.SubLocationsBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.ContactPointsBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



/**
 * <p>Location</p>
 * 
 * <p><p>At least one of address or coordinate must be 
 * specified unless the place is mobile.</p></p>
 * 
 * <p><p>Any location where health-related services may be 
 * provided. Note that a single physical place can play 
 * multiple service delivery location roles e.g. a Podiatry 
 * clinic and Research clinic may meet on alternate days in the 
 * same physical location; each clinic uses its own mailing 
 * address and telephone number.</p></p>
 * 
 * <p><p>Provides location information which uniquely 
 * identifies where health services are provided. This includes 
 * details and other supporting information on locations e.g. 
 * name, address, organization and contact parties. Needed when 
 * looking up facilities to link to patient records. Also 
 * useful when trying to find facilities to meet particular 
 * patient needs, as well as looking up how to contact the 
 * location.</p></p>
 */
@Hl7PartTypeMapping({"PRPA_MT202301CA.ServiceDeliveryLocation"})
@Hl7RootType
public class LocationBean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private CV locationType = new CVImpl();
    private SET<ST, String> locationNames = new SETImpl<ST, String>(STImpl.class);
    private AD locationAddress = new ADImpl();
    private CS locationStatus = new CSImpl();
    private PlaceBean location;
    private ResponsibleOrganizationBean serviceProviderOrganization;
    private List<GeographicCoordinatesBean> subjectOfPosition = new ArrayList<GeographicCoordinatesBean>();
    private List<AvailableServicesBean> locationOfServiceDefinition = new ArrayList<AvailableServicesBean>();
    private List<ContactPointsBean> directAuthorityOverContactParty = new ArrayList<ContactPointsBean>();
    private List<SubLocationsBean> partSubLocation = new ArrayList<SubLocationsBean>();
    private IndirectAuthorithyOverBean indirectAuthority;
    private LocationBean partOfServiceDeliveryLocation;


    /**
     * <p>B: Location Type</p>
     * 
     * <p></p><p>For example, a service delivery location may be 
     * either an incidental service delivery location (a place at 
     * which health-related services may be provided without prior 
     * designation or authorization such as a church or school) or 
     * a dedicated service delivery location (a place that is 
     * intended to house the provision of health-related services 
     * such as a clinic or hospital). Dedicated service delivery 
     * locations can be further characterized as either clinical or 
     * non-clinical.</p></p>
     * 
     * <p></p><p>For example, a service delivery location may be 
     * either an incidental service delivery location (a place at 
     * which health-related services may be provided without prior 
     * designation or authorization such as a church or school) or 
     * a dedicated service delivery location (a place that is 
     * intended to house the provision of health-related services 
     * such as a clinic or hospital). Dedicated service delivery 
     * locations can be further characterized as either clinical or 
     * non-clinical.</p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     */
    @Hl7XmlMapping({"code"})
    public ServiceDeliveryLocationRoleType getLocationType() {
        return (ServiceDeliveryLocationRoleType) this.locationType.getValue();
    }
    public void setLocationType(ServiceDeliveryLocationRoleType locationType) {
        this.locationType.setValue(locationType);
    }


    /**
     * <p>D:Location Names</p>
     * 
     * <p><p>A textual name for the place where the service is 
     * provided e.g. Ottawa General Hospital.</p></p>
     * 
     * <p><p>Provides a human-readable label for the location. The 
     * location name is not intended to be parsed or analyzed by 
     * when processing the record. (E.g. To determine if a location 
     * is a hospital, look at the location type, don't check the 
     * name for the word &quot;hospital&quot;.)</p><p>Multiple 
     * repetitions are allowed to capture historical names</p></p>
     * 
     * <p><p>Provides a human-readable label for the location. The 
     * location name is not intended to be parsed or analyzed by 
     * when processing the record. (E.g. To determine if a location 
     * is a hospital, look at the location type, don't check the 
     * name for the word &quot;hospital&quot;.)</p><p>Multiple 
     * repetitions are allowed to capture historical names</p></p>
     */
    @Hl7XmlMapping({"name"})
    public Set<String> getLocationNames() {
        return this.locationNames.rawSet();
    }


    /**
     * <p>G:Location Address</p>
     * 
     * <p><p>Restricted to physical address only</p></p>
     * 
     * <p><p>Identifies the physical address for this service 
     * delivery location, I.e. What is the geographic location of 
     * the building.</p></p>
     * 
     * <p><p>Allows location to be visited. May also be used for 
     * geographic profiling (e.g. a dispatcher may be looking for 
     * the closest hospital or ambulance that can help a patient in 
     * need of emergency care).</p><p>Because a physical address 
     * may not exist for mobile locations, and may not be 
     * expressible for non-dedicated locations such as water 
     * resevoirs, this element is only 'populated'. When no address 
     * exists, the null flavor should be set to NA.</p></p>
     * 
     * <p><p>Allows location to be visited. May also be used for 
     * geographic profiling (e.g. a dispatcher may be looking for 
     * the closest hospital or ambulance that can help a patient in 
     * need of emergency care).</p><p>Because a physical address 
     * may not exist for mobile locations, and may not be 
     * expressible for non-dedicated locations such as water 
     * resevoirs, this element is only 'populated'. When no address 
     * exists, the null flavor should be set to NA.</p></p>
     * 
     * <p><p>For mobile service delivery location, this can either 
     * be set to the address of the &quot;home&quot; site for the 
     * mobile unit or can be set to a null flavor of N/A.</p></p>
     */
    @Hl7XmlMapping({"addr"})
    public PostalAddress getLocationAddress() {
        return this.locationAddress.getValue();
    }
    public void setLocationAddress(PostalAddress locationAddress) {
        this.locationAddress.setValue(locationAddress);
    }


    /**
     * <p>C: Location Status</p>
     * 
     * <p></p><p>Allowed status values are 'active' (the location 
     * is actively used to deliver healthcare-related services), 
     * 'suspended' (the location has temporarily ceased delivering 
     * healthcare-related services) and 'terminated' (the location 
     * has permanently ceased delivering healthcare-related 
     * services and may no longer physically exist.)</p></p>
     * 
     * <p></p><p>Allowed status values are 'active' (the location 
     * is actively used to deliver healthcare-related services), 
     * 'suspended' (the location has temporarily ceased delivering 
     * healthcare-related services) and 'terminated' (the location 
     * has permanently ceased delivering healthcare-related 
     * services and may no longer physically exist.)</p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ServiceDeliveryRoleStatus getLocationStatus() {
        return (ServiceDeliveryRoleStatus) this.locationStatus.getValue();
    }
    public void setLocationStatus(ServiceDeliveryRoleStatus locationStatus) {
        this.locationStatus.setValue(locationStatus);
    }


    @Hl7XmlMapping({"location"})
    public PlaceBean getLocation() {
        return this.location;
    }
    public void setLocation(PlaceBean location) {
        this.location = location;
    }


    @Hl7XmlMapping({"serviceProviderOrganization"})
    public ResponsibleOrganizationBean getServiceProviderOrganization() {
        return this.serviceProviderOrganization;
    }
    public void setServiceProviderOrganization(ResponsibleOrganizationBean serviceProviderOrganization) {
        this.serviceProviderOrganization = serviceProviderOrganization;
    }


    @Hl7XmlMapping({"subjectOf/position"})
    public List<GeographicCoordinatesBean> getSubjectOfPosition() {
        return this.subjectOfPosition;
    }


    @Hl7XmlMapping({"locationOf/serviceDefinition"})
    public List<AvailableServicesBean> getLocationOfServiceDefinition() {
        return this.locationOfServiceDefinition;
    }


    @Hl7XmlMapping({"directAuthorityOver/contactParty"})
    public List<ContactPointsBean> getDirectAuthorityOverContactParty() {
        return this.directAuthorityOverContactParty;
    }


    @Hl7XmlMapping({"part/subLocation"})
    public List<SubLocationsBean> getPartSubLocation() {
        return this.partSubLocation;
    }


    @Hl7XmlMapping({"indirectAuthority"})
    public IndirectAuthorithyOverBean getIndirectAuthority() {
        return this.indirectAuthority;
    }
    public void setIndirectAuthority(IndirectAuthorithyOverBean indirectAuthority) {
        this.indirectAuthority = indirectAuthority;
    }


    @Hl7XmlMapping({"partOf/serviceDeliveryLocation"})
    public LocationBean getPartOfServiceDeliveryLocation() {
        return this.partOfServiceDeliveryLocation;
    }
    public void setPartOfServiceDeliveryLocation(LocationBean partOfServiceDeliveryLocation) {
        this.partOfServiceDeliveryLocation = partOfServiceDeliveryLocation;
    }

}
