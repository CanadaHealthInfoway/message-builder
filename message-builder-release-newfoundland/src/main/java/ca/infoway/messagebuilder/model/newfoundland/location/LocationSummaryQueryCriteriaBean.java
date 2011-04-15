package ca.infoway.messagebuilder.model.newfoundland.location;

import java.util.Date;
import java.util.List;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
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
import ca.infoway.messagebuilder.model.newfoundland.QueryCriteria;

@Hl7PartTypeMapping({ "PRLO_MT000003CA.ParameterList" })
public class LocationSummaryQueryCriteriaBean extends QueryCriteria {

    private static final long serialVersionUID = 1606105642371807028L;

    private final AD address = new ADImpl();

    private final TS amendedSinceDateTime = new TSImpl();

    private final II eHRRepositoryId = new IIImpl();

    private final BL locationMobileIndicator = new BLImpl();

    private final CD locationPlaceType = new CDImpl();

    private final LIST<CD, Code> locationServiceType = new LISTImpl<CD, Code>(CDImpl.class);

    private final ST nameContains = new STImpl();

    private final AD nearAddress = new ADImpl();

    private final LIST<II, Identifier> protocolId = new LISTImpl<II, Identifier>(IIImpl.class);

    private final LIST<CD, Code> recordType = new LISTImpl<CD, Code>(CDImpl.class);

    private final LIST<CD, Code> recordStatus = new LISTImpl<CD, Code>(CDImpl.class);

    private final LIST<II, Identifier> regionId = new LISTImpl<II, Identifier>(IIImpl.class);

    private final II responsibleOrganizationId = new IIImpl();

    private final PQ searchRadius = new PQImpl();

    @Hl7XmlMapping("amendedSinceDateTime/value")
    public Date getAmendedSinceDateTime() {
        return this.amendedSinceDateTime.getValue();
    }

    public void setAmendedSinceDateTime(Date amendedSinceDateTime) {
        this.amendedSinceDateTime.setValue(amendedSinceDateTime);
    }

    @Hl7XmlMapping("eHRRepositoryId/value")
    public Identifier getEHRRepositoryId() {
        return this.eHRRepositoryId.getValue();
    }

    public void setEHRRepositoryId(Identifier repositoryId) {
        this.eHRRepositoryId.setValue(repositoryId);
    }

    @Hl7XmlMapping("recordType/value")
    public List<ServiceDeliveryLocationRoleType> getRecordType() {
        return this.recordType.rawList(ServiceDeliveryLocationRoleType.class);
    }

    @Hl7XmlMapping("recordStatus/value")
    public List<ServiceDeliveryRoleStatus> getRecordStatus() {
        return this.recordStatus.rawList(ServiceDeliveryRoleStatus.class);
    }

    @Hl7XmlMapping("locationMobileIndicator/value")
    public Boolean getLocationMobileIndicator() {
        return this.locationMobileIndicator.getValue();
    }

    public void setLocationMobileIndicator(Boolean locationMobileIndicator) {
        this.locationMobileIndicator.setValue(locationMobileIndicator);
    }

    @Hl7XmlMapping("nameContains/value")
    public String getNameContains() {
        return this.nameContains.getValue();
    }

    public void setNameContains(String nameContains) {
        this.nameContains.setValue(nameContains);
    }

    @Hl7XmlMapping("address/value")
    public PostalAddress getAddress() {
        return this.address.getValue();
    }

    public void setAddress(PostalAddress address) {
        this.address.setValue(address);
    }

    @Hl7XmlMapping("locationPlaceType/value")
    public ServiceDeliveryLocationPlaceType getLocationPlaceType() {
        return (ServiceDeliveryLocationPlaceType) this.locationPlaceType.getValue();
    }

    public void setLocationPlaceType(ServiceDeliveryLocationPlaceType locationPlaceType) {
        this.locationPlaceType.setValue(locationPlaceType);
    }

    @Hl7XmlMapping("locationServiceType/value")
    public List<ActServiceDeliveryLocationService> getLocationServiceType() {
        return this.locationServiceType.rawList(ActServiceDeliveryLocationService.class);
    }

    @Hl7XmlMapping("nearAddress/value")
    public PostalAddress getNearAddress() {
        return this.nearAddress.getValue();
    }

    public void setNearAddress(PostalAddress nearAddress) {
        this.nearAddress.setValue(nearAddress);
    }

    @Hl7XmlMapping("protocolId/value")
    public List<Identifier> getProtocolId() {
        return this.protocolId.rawList();
    }

    public void setProtocolId(List<Identifier> protocolId) {
    }

    @Hl7XmlMapping("regionId/value")
    public List<Identifier> getRegionId() {
        return this.regionId.rawList();
    }

    public void setRegionId(List<Identifier> regionId) {
    }

    @Hl7XmlMapping("responsibleOrganizationId/value")
    public Identifier getResponsibleOrganizationId() {
        return this.responsibleOrganizationId.getValue();
    }

    public void setResponsibleOrganizationId(Identifier responsibleOrganizationId) {
        this.responsibleOrganizationId.setValue(responsibleOrganizationId);
    }

    @Hl7XmlMapping("searchRadius/value")
    public PhysicalQuantity getSearchRadius() {
        return this.searchRadius.getValue();
    }

    public void setSearchRadius(PhysicalQuantity searchRadius) {
        this.searchRadius.setValue(searchRadius);
    }
}
