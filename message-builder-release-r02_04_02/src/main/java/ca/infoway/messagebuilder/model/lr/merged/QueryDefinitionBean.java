/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.lr.merged;

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
import java.util.Date;



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

    private static final long serialVersionUID = 20110126L;
    private TS updatedSinceDateTime = new TSImpl();
    private II eHRRepositoryId = new IIImpl();
    private II responsibleOrganizationId = new IIImpl();
    private ST nameContains = new STImpl();
    private BL locationMobileIndicator = new BLImpl();
    private CV locationPlaceType = new CVImpl();
    private PQ searchRadius = new PQImpl();
    private CV locationServiceTypes = new CVImpl();
    private II regionIds = new IIImpl();
    private II protocolIds = new IIImpl();
    private AD address = new ADImpl();
    private AD nearAddress = new ADImpl();
    private CS recordStatuses = new CSImpl();
    private CD recordTypes = new CDImpl();
    private II recordIds = new IIImpl();


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
    public Date getUpdatedSinceDateTime() {
        return this.updatedSinceDateTime.getValue();
    }
    public void setUpdatedSinceDateTime(Date updatedSinceDateTime) {
        this.updatedSinceDateTime.setValue(updatedSinceDateTime);
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
    public Identifier getEHRRepositoryId() {
        return this.eHRRepositoryId.getValue();
    }
    public void setEHRRepositoryId(Identifier eHRRepositoryId) {
        this.eHRRepositoryId.setValue(eHRRepositoryId);
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
    public Identifier getResponsibleOrganizationId() {
        return this.responsibleOrganizationId.getValue();
    }
    public void setResponsibleOrganizationId(Identifier responsibleOrganizationId) {
        this.responsibleOrganizationId.setValue(responsibleOrganizationId);
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
    public String getNameContains() {
        return this.nameContains.getValue();
    }
    public void setNameContains(String nameContains) {
        this.nameContains.setValue(nameContains);
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
    public Boolean getLocationMobileIndicator() {
        return this.locationMobileIndicator.getValue();
    }
    public void setLocationMobileIndicator(Boolean locationMobileIndicator) {
        this.locationMobileIndicator.setValue(locationMobileIndicator);
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
    public ServiceDeliveryLocationPlaceType getLocationPlaceType() {
        return (ServiceDeliveryLocationPlaceType) this.locationPlaceType.getValue();
    }
    public void setLocationPlaceType(ServiceDeliveryLocationPlaceType locationPlaceType) {
        this.locationPlaceType.setValue(locationPlaceType);
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
    public PhysicalQuantity getSearchRadius() {
        return this.searchRadius.getValue();
    }
    public void setSearchRadius(PhysicalQuantity searchRadius) {
        this.searchRadius.setValue(searchRadius);
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
    public ActServiceDeliveryLocationService getLocationServiceTypes() {
        return (ActServiceDeliveryLocationService) this.locationServiceTypes.getValue();
    }
    public void setLocationServiceTypes(ActServiceDeliveryLocationService locationServiceTypes) {
        this.locationServiceTypes.setValue(locationServiceTypes);
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
    public Identifier getRegionIds() {
        return this.regionIds.getValue();
    }
    public void setRegionIds(Identifier regionIds) {
        this.regionIds.setValue(regionIds);
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
    public Identifier getProtocolIds() {
        return this.protocolIds.getValue();
    }
    public void setProtocolIds(Identifier protocolIds) {
        this.protocolIds.setValue(protocolIds);
    }


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
    public PostalAddress getAddress() {
        return this.address.getValue();
    }
    public void setAddress(PostalAddress address) {
        this.address.setValue(address);
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
    public PostalAddress getNearAddress() {
        return this.nearAddress.getValue();
    }
    public void setNearAddress(PostalAddress nearAddress) {
        this.nearAddress.setValue(nearAddress);
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
    public ServiceDeliveryRoleStatus getRecordStatuses() {
        return (ServiceDeliveryRoleStatus) this.recordStatuses.getValue();
    }
    public void setRecordStatuses(ServiceDeliveryRoleStatus recordStatuses) {
        this.recordStatuses.setValue(recordStatuses);
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
    public ServiceDeliveryLocationRoleType getRecordTypes() {
        return (ServiceDeliveryLocationRoleType) this.recordTypes.getValue();
    }
    public void setRecordTypes(ServiceDeliveryLocationRoleType recordTypes) {
        this.recordTypes.setValue(recordTypes);
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
    public Identifier getRecordIds() {
        return this.recordIds.getValue();
    }
    public void setRecordIds(Identifier recordIds) {
        this.recordIds.setValue(recordIds);
    }

}
