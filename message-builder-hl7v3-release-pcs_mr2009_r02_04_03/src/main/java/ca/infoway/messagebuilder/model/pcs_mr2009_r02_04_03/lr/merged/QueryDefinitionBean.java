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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lr.merged;

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
 * <p>QueryDefinition</p>
 * 
 * <p>PRPA_MT202306CA.ParameterList: Query Definition</p>
 * 
 * <p><p>Search Radius may only be specified if Near Address is 
 * specified</p></p>
 * 
 * <p><p>Identifies the various parameters that act as filters 
 * on the records to be retrieved.</p></p>
 * 
 * <p><p>Allows the user and/or the point-of-service 
 * application to constrain what EHR information they wish to 
 * retrieve.</p></p>
 * 
 * <p>PRPA_MT202307CA.ParameterList: Query Definition</p>
 * 
 * <p><p>Identifies the various parameters that act as filters 
 * on the records to be retrieved.</p></p>
 * 
 * <p><p>Allows the user and/or the point-of-service 
 * application to constrain what EHR information they wish to 
 * retrieve.</p></p>
 */
@Hl7PartTypeMapping({"PRPA_MT202306CA.ParameterList","PRPA_MT202307CA.ParameterList"})
@Hl7RootType
public class QueryDefinitionBean extends MessagePartBean {

    private static final long serialVersionUID = 20120106L;
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
    private List<II> recordIdValue = new ArrayList<II>();


    /**
     * <p>Address</p>
     * 
     * <p>ZE: Address</p>
     * 
     * <p><p>If specified, filters the returned location records to 
     * those in the specified province/territory or 
     * municipality.</p></p>
     * 
     * <p><p>Allows filtering the physical location of the 
     * facility.</p></p>
     */
    @Hl7XmlMapping({"address/value"})
    public PostalAddress getAddressValue() {
        return this.addressValue.getValue();
    }
    public void setAddressValue(PostalAddress addressValue) {
        this.addressValue.setValue(addressValue);
    }


    /**
     * <p>UpdatedSinceDateTime</p>
     * 
     * <p>K: Updated Since DateTime</p>
     * 
     * <p><p>Filters the records retrieved to only include those 
     * which have been created or revised since the specified date 
     * and time. If unspecified, no filter is applied.</p></p>
     * 
     * <p><p>Useful to retrieve information &quot;since you last 
     * checked&quot;.</p></p>
     */
    @Hl7XmlMapping({"amendedSinceDateTime/value"})
    public Date getAmendedSinceDateTimeValue() {
        return this.amendedSinceDateTimeValue.getValue();
    }
    public void setAmendedSinceDateTimeValue(Date amendedSinceDateTimeValue) {
        this.amendedSinceDateTimeValue.setValue(amendedSinceDateTimeValue);
    }


    /**
     * <p>EHRRepositoryId</p>
     * 
     * <p>Q: EHR Repository Id</p>
     * 
     * <p><p>Filters the records retrieved to only include those 
     * records from a specific EHR repository. If unspecified, all 
     * &quot;connected&quot; EHR repositories will be searched.</p></p>
     * 
     * <p><p>Primarily intended to allow filtering an initial 
     * search to a local EHR repository for performance 
     * reasons.</p></p>
     */
    @Hl7XmlMapping({"eHRRepositoryId/value"})
    public Identifier getEHRRepositoryIdValue() {
        return this.eHRRepositoryIdValue.getValue();
    }
    public void setEHRRepositoryIdValue(Identifier eHRRepositoryIdValue) {
        this.eHRRepositoryIdValue.setValue(eHRRepositoryIdValue);
    }


    /**
     * <p>LocationMobileIndicator</p>
     * 
     * <p>ZC: Location Mobile Indicator</p>
     * 
     * <p><p>If specified, filters the returned location records to 
     * either those which are mobile or non-mobile. If unspecified, 
     * no filter is applied.</p></p>
     * 
     * <p><p>Allows restricting to either mobile or non-mobile 
     * locations.</p></p>
     */
    @Hl7XmlMapping({"locationMobileIndicator/value"})
    public Boolean getLocationMobileIndicatorValue() {
        return this.locationMobileIndicatorValue.getValue();
    }
    public void setLocationMobileIndicatorValue(Boolean locationMobileIndicatorValue) {
        this.locationMobileIndicatorValue.setValue(locationMobileIndicatorValue);
    }


    /**
     * <p>LocationPlaceType</p>
     * 
     * <p>ZA: Location Place Type</p>
     * 
     * <p><p>Filters the returned location records to only include 
     * specific types of places such as facilities, departments, 
     * buildings, wards, etc.</p></p>
     * 
     * <p><p>Allows constraining the types of records to retrieve. 
     * Multiple repetitions are provided to allow more than one 
     * type to be included.</p></p>
     */
    @Hl7XmlMapping({"locationPlaceType/value"})
    public ServiceDeliveryLocationPlaceType getLocationPlaceTypeValue() {
        return (ServiceDeliveryLocationPlaceType) this.locationPlaceTypeValue.getValue();
    }
    public void setLocationPlaceTypeValue(ServiceDeliveryLocationPlaceType locationPlaceTypeValue) {
        this.locationPlaceTypeValue.setValue(locationPlaceTypeValue);
    }


    /**
     * <p>LocationServiceTypes</p>
     * 
     * <p>ZB: Location Service Types</p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     * 
     * <p><p>Allows searching for facilities able to deliver 
     * certain services or groups of services.</p></p>
     */
    @Hl7XmlMapping({"locationServiceType/value"})
    public List<ActServiceDeliveryLocationService> getLocationServiceTypeValue() {
        return new RawListWrapper<CV, ActServiceDeliveryLocationService>(locationServiceTypeValue, CVImpl.class);
    }


    /**
     * <p>NameContains</p>
     * 
     * <p>Z: Name Contains</p>
     * 
     * <p><p>Filters the returned location records to only include 
     * those whose name includes the specified string. If 
     * unspecified, no filter is applied.</p></p>
     * 
     * <p><p>Allows searching by name.</p><p>Note: Searches should 
     * be case-insensitive and should ignore punctuation and 
     * spacing. Some implementations may perform 
     * &quot;sounds-like&quot; searches.</p></p>
     * 
     * <p><p>Allows searching by name.</p><p>Note: Searches should 
     * be case-insensitive and should ignore punctuation and 
     * spacing. Some implementations may perform 
     * &quot;sounds-like&quot; searches.</p></p>
     */
    @Hl7XmlMapping({"nameContains/value"})
    public String getNameContainsValue() {
        return this.nameContainsValue.getValue();
    }
    public void setNameContainsValue(String nameContainsValue) {
        this.nameContainsValue.setValue(nameContainsValue);
    }


    /**
     * <p>NearAddress</p>
     * 
     * <p>ZF: Near Address</p>
     * 
     * <p><p>Identifies an address that returned locations should 
     * be near to. Results will be filtered to those appearing 
     * within the specified radius from the identified address.</p></p>
     * 
     * <p><p>Allows retrieving facilities near to a particular 
     * location.</p></p>
     */
    @Hl7XmlMapping({"nearAddress/value"})
    public PostalAddress getNearAddressValue() {
        return this.nearAddressValue.getValue();
    }
    public void setNearAddressValue(PostalAddress nearAddressValue) {
        this.nearAddressValue.setValue(nearAddressValue);
    }


    /**
     * <p>ProtocolIds</p>
     * 
     * <p>ZI: Protocol Ids</p>
     * 
     * <p><p>Filters the records retrieved to only include those 
     * associated with the specified protocols. If unspecified, no 
     * filter is applied.</p></p>
     * 
     * <p><p>Allows retrieving records associated with a particular 
     * protocol. Useful in clinical studies and other 
     * research.</p><p>The element is optional because support for 
     * protocols is not deemed a neccesity for many healthcare 
     * providers.</p></p>
     * 
     * <p><p>Allows retrieving records associated with a particular 
     * protocol. Useful in clinical studies and other 
     * research.</p><p>The element is optional because support for 
     * protocols is not deemed a neccesity for many healthcare 
     * providers.</p></p>
     */
    @Hl7XmlMapping({"protocolId/value"})
    public List<Identifier> getProtocolIdValue() {
        return new RawListWrapper<II, Identifier>(protocolIdValue, IIImpl.class);
    }


    /**
     * <p>RecordStatuses</p>
     * 
     * <p>I: Record Statuses</p>
     * 
     * <p><p>Filters the set of records to be retrieved to only 
     * include those with the identified status(s). If no values 
     * are specified, no filter will be applied.</p></p>
     * 
     * <p><p>Allows constraining the status of records to be 
     * retrieved. Multiple repetitions are present to allow 
     * selection of multiple statuses with a single query.</p></p>
     */
    @Hl7XmlMapping({"recordStatus/value"})
    public List<ServiceDeliveryRoleStatus> getRecordStatusValue() {
        return new RawListWrapper<CS, ServiceDeliveryRoleStatus>(recordStatusValue, CSImpl.class);
    }


    /**
     * <p>RecordTypes</p>
     * 
     * <p>H:Record Types</p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     */
    @Hl7XmlMapping({"recordType/value"})
    public List<ServiceDeliveryLocationRoleType> getRecordTypeValue() {
        return new RawListWrapper<CD, ServiceDeliveryLocationRoleType>(recordTypeValue, CDImpl.class);
    }


    /**
     * <p>RegionIds</p>
     * 
     * <p>ZD: Region Ids</p>
     * 
     * <p><p>If specified, filters the returned location records to 
     * those which are part of the specified 'region'.</p></p>
     * 
     * <p><p>Allows restricting the retrieved locations to those 
     * associated with a particular health region.</p></p>
     */
    @Hl7XmlMapping({"regionId/value"})
    public List<Identifier> getRegionIdValue() {
        return new RawListWrapper<II, Identifier>(regionIdValue, IIImpl.class);
    }


    /**
     * <p>ResponsibleOrganizationId</p>
     * 
     * <p>ZH: Responsible Organization Id</p>
     * 
     * <p><p>If specified, filters the returned location records to 
     * those which are under the responsibility of the specified 
     * organization.</p></p>
     * 
     * <p><p>Allows returning all locations associated with a 
     * particular organization.</p></p>
     */
    @Hl7XmlMapping({"responsibleOrganizationId/value"})
    public Identifier getResponsibleOrganizationIdValue() {
        return this.responsibleOrganizationIdValue.getValue();
    }
    public void setResponsibleOrganizationIdValue(Identifier responsibleOrganizationIdValue) {
        this.responsibleOrganizationIdValue.setValue(responsibleOrganizationIdValue);
    }


    /**
     * <p>SearchRadius</p>
     * 
     * <p>ZG: Search Radius</p>
     * 
     * <p><p>Identifies the distance from the &quot;Near 
     * Address&quot; within which locations should be 
     * retrieved.</p></p>
     * 
     * <p><p>Allows retrieving facilities near to a particular 
     * location.</p></p>
     */
    @Hl7XmlMapping({"searchRadius/value"})
    public PhysicalQuantity getSearchRadiusValue() {
        return this.searchRadiusValue.getValue();
    }
    public void setSearchRadiusValue(PhysicalQuantity searchRadiusValue) {
        this.searchRadiusValue.setValue(searchRadiusValue);
    }


    /**
     * <p>RecordIds</p>
     * 
     * <p>E: Record Ids</p>
     * 
     * <p><p>A globally unique identifier assigned by the EHR to 
     * the record (or records) to be retrieved.</p></p>
     * 
     * <p><p>Specifically identifies the record to be 
     * returned.</p><p>Because the primary purpose of the query is 
     * to retrieve identified records, the element is 
     * mandatory.</p><p>Multiple repetitions are allowed to support 
     * multiple detail records as part of one query for efficiency 
     * reasons.</p></p>
     * 
     * <p><p>Specifically identifies the record to be 
     * returned.</p><p>Because the primary purpose of the query is 
     * to retrieve identified records, the element is 
     * mandatory.</p><p>Multiple repetitions are allowed to support 
     * multiple detail records as part of one query for efficiency 
     * reasons.</p></p>
     * 
     * <p><p>Specifically identifies the record to be 
     * returned.</p><p>Because the primary purpose of the query is 
     * to retrieve identified records, the element is 
     * mandatory.</p><p>Multiple repetitions are allowed to support 
     * multiple detail records as part of one query for efficiency 
     * reasons.</p></p>
     */
    @Hl7XmlMapping({"recordId/value"})
    public List<Identifier> getRecordIdValue() {
        return new RawListWrapper<II, Identifier>(recordIdValue, IIImpl.class);
    }

}