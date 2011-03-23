/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.lr.prpa_mt202306ca;

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
 * <p>Query Definition</p>
 * 
 * <p>Identifies the various parameters that act as filters on 
 * the records to be retrieved.</p>
 * 
 * <p>Allows the user and/or the point-of-service application 
 * to constrain what EHR information they wish to retrieve.</p>
 * 
 * <p>Search Radius may only be specified if Near Address is 
 * specified</p>
 */
@Hl7PartTypeMapping({"PRPA_MT202306CA.ParameterList"})
@Hl7RootType
public class QueryDefinitionBean extends MessagePartBean {

    private static final long serialVersionUID = 20100603L;
    private AD address = new ADImpl();
    private TS updatedSinceDateTime = new TSImpl();
    private II eHRRepositoryId = new IIImpl();
    private BL locationMobileIndicator = new BLImpl();
    private CV locationPlaceType = new CVImpl();
    private List<CV> locationServiceTypes = new ArrayList<CV>();
    private ST nameContains = new STImpl();
    private AD nearAddress = new ADImpl();
    private List<II> protocolIds = new ArrayList<II>();
    private List<CS> recordStatuses = new ArrayList<CS>();
    private List<CD> recordTypes = new ArrayList<CD>();
    private List<II> regionIds = new ArrayList<II>();
    private II responsibleOrganizationId = new IIImpl();
    private PQ searchRadius = new PQImpl();

    @Hl7XmlMapping({"address/value"})
    public PostalAddress getAddress() {
        return this.address.getValue();
    }
    public void setAddress(PostalAddress address) {
        this.address.setValue(address);
    }

    @Hl7XmlMapping({"amendedSinceDateTime/value"})
    public Date getUpdatedSinceDateTime() {
        return this.updatedSinceDateTime.getValue();
    }
    public void setUpdatedSinceDateTime(Date updatedSinceDateTime) {
        this.updatedSinceDateTime.setValue(updatedSinceDateTime);
    }

    @Hl7XmlMapping({"eHRRepositoryId/value"})
    public Identifier getEHRRepositoryId() {
        return this.eHRRepositoryId.getValue();
    }
    public void setEHRRepositoryId(Identifier eHRRepositoryId) {
        this.eHRRepositoryId.setValue(eHRRepositoryId);
    }

    @Hl7XmlMapping({"locationMobileIndicator/value"})
    public Boolean getLocationMobileIndicator() {
        return this.locationMobileIndicator.getValue();
    }
    public void setLocationMobileIndicator(Boolean locationMobileIndicator) {
        this.locationMobileIndicator.setValue(locationMobileIndicator);
    }

    @Hl7XmlMapping({"locationPlaceType/value"})
    public ServiceDeliveryLocationPlaceType getLocationPlaceType() {
        return (ServiceDeliveryLocationPlaceType) this.locationPlaceType.getValue();
    }
    public void setLocationPlaceType(ServiceDeliveryLocationPlaceType locationPlaceType) {
        this.locationPlaceType.setValue(locationPlaceType);
    }

    @Hl7XmlMapping({"locationServiceType/value"})
    public List<ActServiceDeliveryLocationService> getLocationServiceTypes() {
        return new RawListWrapper<CV, ActServiceDeliveryLocationService>(locationServiceTypes, CVImpl.class);
    }

    @Hl7XmlMapping({"nameContains/value"})
    public String getNameContains() {
        return this.nameContains.getValue();
    }
    public void setNameContains(String nameContains) {
        this.nameContains.setValue(nameContains);
    }

    @Hl7XmlMapping({"nearAddress/value"})
    public PostalAddress getNearAddress() {
        return this.nearAddress.getValue();
    }
    public void setNearAddress(PostalAddress nearAddress) {
        this.nearAddress.setValue(nearAddress);
    }

    @Hl7XmlMapping({"protocolId/value"})
    public List<Identifier> getProtocolIds() {
        return new RawListWrapper<II, Identifier>(protocolIds, IIImpl.class);
    }

    @Hl7XmlMapping({"recordStatus/value"})
    public List<ServiceDeliveryRoleStatus> getRecordStatuses() {
        return new RawListWrapper<CS, ServiceDeliveryRoleStatus>(recordStatuses, CSImpl.class);
    }

    @Hl7XmlMapping({"recordType/value"})
    public List<ServiceDeliveryLocationRoleType> getRecordTypes() {
        return new RawListWrapper<CD, ServiceDeliveryLocationRoleType>(recordTypes, CDImpl.class);
    }

    @Hl7XmlMapping({"regionId/value"})
    public List<Identifier> getRegionIds() {
        return new RawListWrapper<II, Identifier>(regionIds, IIImpl.class);
    }

    @Hl7XmlMapping({"responsibleOrganizationId/value"})
    public Identifier getResponsibleOrganizationId() {
        return this.responsibleOrganizationId.getValue();
    }
    public void setResponsibleOrganizationId(Identifier responsibleOrganizationId) {
        this.responsibleOrganizationId.setValue(responsibleOrganizationId);
    }

    @Hl7XmlMapping({"searchRadius/value"})
    public PhysicalQuantity getSearchRadius() {
        return this.searchRadius.getValue();
    }
    public void setSearchRadius(PhysicalQuantity searchRadius) {
        this.searchRadius.setValue(searchRadius);
    }

}
