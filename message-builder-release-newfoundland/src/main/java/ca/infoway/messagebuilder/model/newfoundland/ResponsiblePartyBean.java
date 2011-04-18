package ca.infoway.messagebuilder.model.newfoundland;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.RoleStatus;
import ca.infoway.messagebuilder.domainvalue.x_NormalRestrictedTabooConfidentialityKind;
import ca.infoway.messagebuilder.domainvalue.x_SimplePersonalRelationship;
import ca.infoway.messagebuilder.model.MessagePartBean;

@Hl7PartTypeMapping("COCT_MT040205CA.ResponsibleParty")
public class ResponsiblePartyBean extends MessagePartBean implements Serializable, IdentifiedEntity, InformantParty, Patient, Consenter {

    private static final long serialVersionUID = -519417548662271561L;

    private final SET<II, Identifier> ids = new SETImpl<II, Identifier>(IIImpl.class);

    private final AD address = new ADImpl();

    private final SET<TEL, TelecommunicationAddress> telecom = new SETImpl<TEL, TelecommunicationAddress>(TELImpl.class);

    private IndeterminatePersonBean indeterminatePerson = new IndeterminatePersonBean();

    private final CD statusCode = new CDImpl();

    private final IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();

    private final CD confidentialityCode = new CDImpl();

    private ObservationEventMatchBean observationEventBean;

    private CD code = new CDImpl();

    @Hl7XmlMapping("id")
    public Set<Identifier> getIds() {
        return this.ids.rawSet();
    }

    public Identifier getId() {
        return this.getIds().isEmpty() ? null : new ArrayList<Identifier>(this.getIds()).get(0);
    }

    public void setId(Identifier id) {
        this.getIds().clear();
        this.getIds().add(id);
    }

    @Hl7XmlMapping("addr")
    public PostalAddress getAddress() {
        return this.address.getValue();
    }

    public void setAddress(PostalAddress address) {
        this.address.setValue(address);
    }

    @Hl7XmlMapping("telecom")
    public Set<TelecommunicationAddress> getTelecom() {
        return this.telecom.rawSet();
    }

    @Hl7XmlMapping({ "patientPerson", "agentPerson", "identifiedPerson" })
    public IndeterminatePersonBean getIndeterminatePerson() {
        return indeterminatePerson;
    }

    public void setIndeterminatePerson(IndeterminatePersonBean indeterminatePerson) {
        this.indeterminatePerson = indeterminatePerson;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(null).append("identifier", getId()).toString();
    }

    @Hl7XmlMapping("statusCode")
    public RoleStatus getStatusCode() {
        return (RoleStatus) this.statusCode.getValue();
    }

    public void setStatusCode(RoleStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }

    @Hl7XmlMapping("effectiveTime")
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }

    @Hl7XmlMapping("confidentialityCode")
    public x_NormalRestrictedTabooConfidentialityKind getConfidentialityCode() {
        return (x_NormalRestrictedTabooConfidentialityKind) this.confidentialityCode.getValue();
    }

    public void setConfidentialityCode(x_NormalRestrictedTabooConfidentialityKind confidentialityCode) {
        this.confidentialityCode.setValue(confidentialityCode);
    }

    @Hl7XmlMapping("subjectOf/observationEvent")
    public ObservationEventMatchBean getObservationEventBean() {
        return observationEventBean;
    }

    public void setObservationEventBean(ObservationEventMatchBean observationEventBean) {
        this.observationEventBean = observationEventBean;
    }

    @Hl7XmlMapping("code")
    public x_SimplePersonalRelationship getCode() {
        return (x_SimplePersonalRelationship) this.code.getValue();
    }

    public void setCode(x_SimplePersonalRelationship code) {
        this.code.setValue(code);
    }
    
}