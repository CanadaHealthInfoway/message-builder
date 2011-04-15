package ca.infoway.messagebuilder.model.newfoundland.location;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifiable;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.domainvalue.ServiceDeliveryLocationPlaceType;
import ca.infoway.messagebuilder.domainvalue.ServiceDeliveryLocationRoleType;
import ca.infoway.messagebuilder.domainvalue.ServiceDeliveryRoleStatus;

@Hl7PartTypeMapping({ "PRLO_MT000002CA.ServiceDeliveryLocation" })
public class LocationDetailsBean extends BaseLocationBean implements Serializable, Identifiable, Location {

    private static final long serialVersionUID = -3396146035262969266L;

    private final SET<II, Identifier> ids = new SETImpl<II, Identifier>(IIImpl.class);

    private final CD code = new CDImpl();

    private final LIST<ST, String> name = new LISTImpl<ST, String>(STImpl.class);

    private final AD addr = new ADImpl();

    private final CD statusCode = new CDImpl();

    private final CD placeCode = new CDImpl();

    private final BL mobileInd = new BLImpl();

    public Identifier getId() {
        return (Identifier) (this.getIds().isEmpty() ? null : CollectionUtils.get(this.getIds(), 0));
    }

    public void setId(Identifier id) {
        this.getIds().clear();
        this.getIds().add(id);
    }

    @Hl7XmlMapping("code")
    public ServiceDeliveryLocationRoleType getCode() {
        return (ServiceDeliveryLocationRoleType) this.code.getValue();
    }

    public void setCode(ServiceDeliveryLocationRoleType code) {
        this.code.setValue(code);
    }

    @Hl7XmlMapping("name")
    public List<String> getName() {
        return this.name.rawList();
    }

    @Hl7XmlMapping("addr")
    public PostalAddress getAddr() {
        return this.addr.getValue();
    }

    public void setAddr(PostalAddress addr) {
        this.addr.setValue(addr);
    }

    @Hl7XmlMapping("statusCode")
    public ServiceDeliveryRoleStatus getStatusCode() {
        return (ServiceDeliveryRoleStatus) this.statusCode.getValue();
    }

    public void setStatusCode(ServiceDeliveryRoleStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }

    @Hl7XmlMapping("location/code")
    public ServiceDeliveryLocationPlaceType getPlaceCode() {
        return (ServiceDeliveryLocationPlaceType) this.placeCode.getValue();
        
    }

    public void setPlaceCode(ServiceDeliveryLocationPlaceType placeCode) {
        this.placeCode.setValue(placeCode);
    }

    @Hl7XmlMapping("location/mobileInd")
    public Boolean getMobileInd() {
        return this.mobileInd.getValue();
    }

    public void setMobileInd(Boolean mobileInd) {
        this.mobileInd.setValue(mobileInd);
    }

    @Hl7XmlMapping("id")
    public Set<Identifier> getIds() {
        return this.ids.rawSet();
    }
}
