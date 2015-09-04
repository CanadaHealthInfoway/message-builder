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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.lr.prpa_mt202306ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.impl.RawListWrapper;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.domainvalue.ActServiceDeliveryLocationService;
import ca.infoway.messagebuilder.domainvalue.ServiceDeliveryLocationPlaceType;
import ca.infoway.messagebuilder.domainvalue.ServiceDeliveryLocationRoleType;
import ca.infoway.messagebuilder.domainvalue.ServiceDeliveryRoleStatus;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Business Name: Query Definition</p>
 * 
 * <p>Search Radius may only be specified if Near Address is 
 * specified</p>
 * 
 * <p>Allows the user and/or the point-of-service application 
 * to constrain what EHR information they wish to retrieve.</p>
 * 
 * <p>Identifies the various parameters that act as filters on 
 * the records to be retrieved.</p>
 */
@Hl7PartTypeMapping({"PRPA_MT202306CA.ParameterList"})
@Hl7RootType
public class QueryDefinitionBean extends MessagePartBean {

    private static final long serialVersionUID = 20150904L;
    private AD addressValue = new ADImpl();
    private TS amendedSinceDateTimeValue = new TSImpl();
    private II eHRRepositoryIdValue = new IIImpl();
    private BL locationMobileIndicatorValue = new BLImpl();
    private CV locationPlaceTypeValue = new CVImpl();
    private List<CV> locationServiceTypeValue = new ArrayList<CV>();
    private ST nameContainsValue = new STImpl();
    private AD nearAddressValue = new ADImpl();
    private List<II> protocolIdValue = new ArrayList<II>();
    private List<CS> recordStatusValue = new ArrayList<CS>();
    private List<CD> recordTypeValue = new ArrayList<CD>();
    private List<II> regionIdValue = new ArrayList<II>();
    private II responsibleOrganizationIdValue = new IIImpl();
    private PQ searchRadiusValue = new PQImpl();


    /**
     * <p>Business Name: ZE: Address</p>
     * 
     * <p>Relationship: PRPA_MT202306CA.Address.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows filtering the physical location of the 
     * facility.</p>
     * 
     * <p>If specified, filters the returned location records to 
     * those in the specified province/territory or 
     * municipality.</p>
     */
    @Hl7XmlMapping({"address/value"})
    public PostalAddress getAddressValue() {
        return this.addressValue.getValue();
    }

    /**
     * <p>Business Name: ZE: Address</p>
     * 
     * <p>Relationship: PRPA_MT202306CA.Address.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows filtering the physical location of the 
     * facility.</p>
     * 
     * <p>If specified, filters the returned location records to 
     * those in the specified province/territory or 
     * municipality.</p>
     */
    public void setAddressValue(PostalAddress addressValue) {
        this.addressValue.setValue(addressValue);
    }


    /**
     * <p>Business Name: K: Updated Since DateTime</p>
     * 
     * <p>Relationship: PRPA_MT202306CA.AmendedSinceDateTime.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Useful to retrieve information &quot;since you last 
     * checked&quot;.</p>
     * 
     * <p>Filters the records retrieved to only include those which 
     * have been created or revised since the specified date and 
     * time. If unspecified, no filter is applied.</p>
     */
    @Hl7XmlMapping({"amendedSinceDateTime/value"})
    public Date getAmendedSinceDateTimeValue() {
        return this.amendedSinceDateTimeValue.getValue();
    }

    /**
     * <p>Business Name: K: Updated Since DateTime</p>
     * 
     * <p>Relationship: PRPA_MT202306CA.AmendedSinceDateTime.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Useful to retrieve information &quot;since you last 
     * checked&quot;.</p>
     * 
     * <p>Filters the records retrieved to only include those which 
     * have been created or revised since the specified date and 
     * time. If unspecified, no filter is applied.</p>
     */
    public void setAmendedSinceDateTimeValue(Date amendedSinceDateTimeValue) {
        this.amendedSinceDateTimeValue.setValue(amendedSinceDateTimeValue);
    }


    /**
     * <p>Business Name: Q: EHR Repository Id</p>
     * 
     * <p>Relationship: PRPA_MT202306CA.EHRRepositoryId.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Primarily intended to allow filtering an initial search 
     * to a local EHR repository for performance reasons.</p>
     * 
     * <p>Filters the records retrieved to only include those 
     * records from a specific EHR repository. If unspecified, all 
     * &quot;connected&quot; EHR repositories will be searched.</p>
     */
    @Hl7XmlMapping({"eHRRepositoryId/value"})
    public Identifier getEHRRepositoryIdValue() {
        return this.eHRRepositoryIdValue.getValue();
    }

    /**
     * <p>Business Name: Q: EHR Repository Id</p>
     * 
     * <p>Relationship: PRPA_MT202306CA.EHRRepositoryId.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Primarily intended to allow filtering an initial search 
     * to a local EHR repository for performance reasons.</p>
     * 
     * <p>Filters the records retrieved to only include those 
     * records from a specific EHR repository. If unspecified, all 
     * &quot;connected&quot; EHR repositories will be searched.</p>
     */
    public void setEHRRepositoryIdValue(Identifier eHRRepositoryIdValue) {
        this.eHRRepositoryIdValue.setValue(eHRRepositoryIdValue);
    }


    /**
     * <p>Business Name: ZC: Location Mobile Indicator</p>
     * 
     * <p>Relationship: 
     * PRPA_MT202306CA.LocationMobileIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows restricting to either mobile or non-mobile 
     * locations.</p>
     * 
     * <p>If specified, filters the returned location records to 
     * either those which are mobile or non-mobile. If unspecified, 
     * no filter is applied.</p>
     */
    @Hl7XmlMapping({"locationMobileIndicator/value"})
    public Boolean getLocationMobileIndicatorValue() {
        return this.locationMobileIndicatorValue.getValue();
    }

    /**
     * <p>Business Name: ZC: Location Mobile Indicator</p>
     * 
     * <p>Relationship: 
     * PRPA_MT202306CA.LocationMobileIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows restricting to either mobile or non-mobile 
     * locations.</p>
     * 
     * <p>If specified, filters the returned location records to 
     * either those which are mobile or non-mobile. If unspecified, 
     * no filter is applied.</p>
     */
    public void setLocationMobileIndicatorValue(Boolean locationMobileIndicatorValue) {
        this.locationMobileIndicatorValue.setValue(locationMobileIndicatorValue);
    }


    /**
     * <p>Business Name: ZA: Location Place Type</p>
     * 
     * <p>Relationship: PRPA_MT202306CA.LocationPlaceType.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows constraining the types of records to retrieve. 
     * Multiple repetitions are provided to allow more than one 
     * type to be included.</p>
     * 
     * <p>Filters the returned location records to only include 
     * specific types of places such as facilities, departments, 
     * buildings, wards, etc.</p>
     */
    @Hl7XmlMapping({"locationPlaceType/value"})
    public ServiceDeliveryLocationPlaceType getLocationPlaceTypeValue() {
        return (ServiceDeliveryLocationPlaceType) this.locationPlaceTypeValue.getValue();
    }

    /**
     * <p>Business Name: ZA: Location Place Type</p>
     * 
     * <p>Relationship: PRPA_MT202306CA.LocationPlaceType.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows constraining the types of records to retrieve. 
     * Multiple repetitions are provided to allow more than one 
     * type to be included.</p>
     * 
     * <p>Filters the returned location records to only include 
     * specific types of places such as facilities, departments, 
     * buildings, wards, etc.</p>
     */
    public void setLocationPlaceTypeValue(ServiceDeliveryLocationPlaceType locationPlaceTypeValue) {
        this.locationPlaceTypeValue.setValue(locationPlaceTypeValue);
    }


    /**
     * <p>Business Name: ZB: Location Service Types</p>
     * 
     * <p>Relationship: PRPA_MT202306CA.LocationServiceType.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows searching for facilities able to deliver certain 
     * services or groups of services.</p>
     * 
     * <p>Filters the returned location records to only include 
     * locations that provide the specified type of service(s), 
     * etc. Multiple repetitions will be treated as 
     * &quot;AND&quot;. I.e. Locations that provide A and B. If 
     * this criterion is used, it will only match on services that 
     * are marked as &quot;available&quot;.</p><p> <i>Query results 
     * should include those with an match of this code, as well 
     * those matching any specializations of the coded 
     * parameter.</i> </p>
     */
    @Hl7XmlMapping({"locationServiceType/value"})
    public List<ActServiceDeliveryLocationService> getLocationServiceTypeValue() {
        return new RawListWrapper<CV, ActServiceDeliveryLocationService>(locationServiceTypeValue, CVImpl.class);
    }


    /**
     * <p>Business Name: Z: Name Contains</p>
     * 
     * <p>Relationship: PRPA_MT202306CA.NameContains.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows searching by name.</p><p>Note: Searches should be 
     * case-insensitive and should ignore punctuation and spacing. 
     * Some implementations may perform &quot;sounds-like&quot; 
     * searches.</p>
     * 
     * <p>Filters the returned location records to only include 
     * those whose name includes the specified string. If 
     * unspecified, no filter is applied.</p>
     */
    @Hl7XmlMapping({"nameContains/value"})
    public String getNameContainsValue() {
        return this.nameContainsValue.getValue();
    }

    /**
     * <p>Business Name: Z: Name Contains</p>
     * 
     * <p>Relationship: PRPA_MT202306CA.NameContains.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows searching by name.</p><p>Note: Searches should be 
     * case-insensitive and should ignore punctuation and spacing. 
     * Some implementations may perform &quot;sounds-like&quot; 
     * searches.</p>
     * 
     * <p>Filters the returned location records to only include 
     * those whose name includes the specified string. If 
     * unspecified, no filter is applied.</p>
     */
    public void setNameContainsValue(String nameContainsValue) {
        this.nameContainsValue.setValue(nameContainsValue);
    }


    /**
     * <p>Business Name: ZF: Near Address</p>
     * 
     * <p>Relationship: PRPA_MT202306CA.NearAddress.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows retrieving facilities near to a particular 
     * location.</p>
     * 
     * <p>Identifies an address that returned locations should be 
     * near to. Results will be filtered to those appearing within 
     * the specified radius from the identified address.</p>
     */
    @Hl7XmlMapping({"nearAddress/value"})
    public PostalAddress getNearAddressValue() {
        return this.nearAddressValue.getValue();
    }

    /**
     * <p>Business Name: ZF: Near Address</p>
     * 
     * <p>Relationship: PRPA_MT202306CA.NearAddress.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows retrieving facilities near to a particular 
     * location.</p>
     * 
     * <p>Identifies an address that returned locations should be 
     * near to. Results will be filtered to those appearing within 
     * the specified radius from the identified address.</p>
     */
    public void setNearAddressValue(PostalAddress nearAddressValue) {
        this.nearAddressValue.setValue(nearAddressValue);
    }


    /**
     * <p>Business Name: ZI: Protocol Ids</p>
     * 
     * <p>Relationship: PRPA_MT202306CA.ProtocolId.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows retrieving records associated with a particular 
     * protocol. Useful in clinical studies and other 
     * research.</p><p>The element is optional because support for 
     * protocols is not deemed a neccesity for many healthcare 
     * providers.</p>
     * 
     * <p>Filters the records retrieved to only include those 
     * associated with the specified protocols. If unspecified, no 
     * filter is applied.</p>
     */
    @Hl7XmlMapping({"protocolId/value"})
    public List<Identifier> getProtocolIdValue() {
        return new RawListWrapper<II, Identifier>(protocolIdValue, IIImpl.class);
    }


    /**
     * <p>Business Name: I: Record Statuses</p>
     * 
     * <p>Relationship: PRPA_MT202306CA.RecordStatus.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows constraining the status of records to be 
     * retrieved. Multiple repetitions are present to allow 
     * selection of multiple statuses with a single query.</p>
     * 
     * <p>Filters the set of records to be retrieved to only 
     * include those with the identified status(s). If no values 
     * are specified, no filter will be applied.</p>
     */
    @Hl7XmlMapping({"recordStatus/value"})
    public List<ServiceDeliveryRoleStatus> getRecordStatusValue() {
        return new RawListWrapper<CS, ServiceDeliveryRoleStatus>(recordStatusValue, CSImpl.class);
    }


    /**
     * <p>Business Name: H:Record Types</p>
     * 
     * <p>Relationship: PRPA_MT202306CA.RecordType.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows constraining the type of records to be retrieved. 
     * Multiple repetitions are present to allow selection of 
     * multiple types with a single query.</p><p> <i>This element 
     * makes use of the CD datatype to allow for use of the SNOMED 
     * code system that in some circumstances requires the use of 
     * post-coordination. Post-coordination is only supported by 
     * the CD datatype.</i> </p>
     * 
     * <p>Filters the type(s) or category(ies) of the records to be 
     * retrieved. The query will return both those records whose 
     * type exactly matches, as well as those whose types are 
     * subsets of the specified parameter. If no Types are 
     * specified, no restriction will be placed on the types to be 
     * returned.</p><p> <i>Query results should include those with 
     * an match of this code, as well those matching any 
     * specializations of the coded parameter.</i> </p>
     */
    @Hl7XmlMapping({"recordType/value"})
    public List<ServiceDeliveryLocationRoleType> getRecordTypeValue() {
        return new RawListWrapper<CD, ServiceDeliveryLocationRoleType>(recordTypeValue, CDImpl.class);
    }


    /**
     * <p>Business Name: ZD: Region Ids</p>
     * 
     * <p>Relationship: PRPA_MT202306CA.RegionId.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows restricting the retrieved locations to those 
     * associated with a particular health region.</p>
     * 
     * <p>If specified, filters the returned location records to 
     * those which are part of the specified 'region'.</p>
     */
    @Hl7XmlMapping({"regionId/value"})
    public List<Identifier> getRegionIdValue() {
        return new RawListWrapper<II, Identifier>(regionIdValue, IIImpl.class);
    }


    /**
     * <p>Business Name: ZH: Responsible Organization Id</p>
     * 
     * <p>Relationship: 
     * PRPA_MT202306CA.ResponsibleOrganizationId.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows returning all locations associated with a 
     * particular organization.</p>
     * 
     * <p>If specified, filters the returned location records to 
     * those which are under the responsibility of the specified 
     * organization.</p>
     */
    @Hl7XmlMapping({"responsibleOrganizationId/value"})
    public Identifier getResponsibleOrganizationIdValue() {
        return this.responsibleOrganizationIdValue.getValue();
    }

    /**
     * <p>Business Name: ZH: Responsible Organization Id</p>
     * 
     * <p>Relationship: 
     * PRPA_MT202306CA.ResponsibleOrganizationId.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows returning all locations associated with a 
     * particular organization.</p>
     * 
     * <p>If specified, filters the returned location records to 
     * those which are under the responsibility of the specified 
     * organization.</p>
     */
    public void setResponsibleOrganizationIdValue(Identifier responsibleOrganizationIdValue) {
        this.responsibleOrganizationIdValue.setValue(responsibleOrganizationIdValue);
    }


    /**
     * <p>Business Name: ZG: Search Radius</p>
     * 
     * <p>Relationship: PRPA_MT202306CA.SearchRadius.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows retrieving facilities near to a particular 
     * location.</p>
     * 
     * <p>Identifies the distance from the &quot;Near Address&quot; 
     * within which locations should be retrieved.</p>
     */
    @Hl7XmlMapping({"searchRadius/value"})
    public PhysicalQuantity getSearchRadiusValue() {
        return this.searchRadiusValue.getValue();
    }

    /**
     * <p>Business Name: ZG: Search Radius</p>
     * 
     * <p>Relationship: PRPA_MT202306CA.SearchRadius.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows retrieving facilities near to a particular 
     * location.</p>
     * 
     * <p>Identifies the distance from the &quot;Near Address&quot; 
     * within which locations should be retrieved.</p>
     */
    public void setSearchRadiusValue(PhysicalQuantity searchRadiusValue) {
        this.searchRadiusValue.setValue(searchRadiusValue);
    }

}
