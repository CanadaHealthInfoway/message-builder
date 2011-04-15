package ca.infoway.messagebuilder.model.newfoundland.cerx.consent;

import java.io.Serializable;
import java.util.Date;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifiable;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActConsentInformationAccessReason;
import ca.infoway.messagebuilder.domainvalue.ActConsentType;
import ca.infoway.messagebuilder.domainvalue.x_PhysicalVerbalParticipationMode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.newfoundland.AssignedPersonBean;
import ca.infoway.messagebuilder.model.newfoundland.Consenter;
import ca.infoway.messagebuilder.model.newfoundland.IdentifiedPersonBean;
import ca.infoway.messagebuilder.model.newfoundland.OfPatient;

@Hl7PartTypeMapping({ "RCMR_MT010001CA.ConsentEvent" })
public class ConsentBean extends MessagePartBean implements Identifiable, OfPatient, Serializable {

    private static final long serialVersionUID = -8564175067252320860L;

    private II id = new IIImpl();

    private CD code = new CDImpl();

    private BL negationInd = new BLImpl();

    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();

    private CD reasonCode = new CDImpl();

    private IdentifiedPersonBean patient;

    private CD modeCode = new CDImpl();

    private Consenter consenter;

    private AssignedPersonBean provider;

    private InformationAccessBean informationAccess;

    @Hl7XmlMapping("id")
    public Identifier getId() {
        return this.id.getValue();
    }

    public void setId(Identifier id) {
        this.id.setValue(id);
    }

    @Hl7XmlMapping("code")
    public ActConsentType getCode() {
        return (ActConsentType) this.code.getValue();
    }

    public void setCode(ActConsentType code) {
        this.code.setValue(code);
    }

    @Hl7XmlMapping("negationInd")
    public Boolean getNegationInd() {
        return this.negationInd.getValue();
    }

    public void setNegationInd(Boolean negationInd) {
        this.negationInd.setValue(negationInd);
    }

    @Hl7XmlMapping("effectiveTime")
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }

    @Hl7XmlMapping("subject/patient")
    public IdentifiedPersonBean getPatient() {
        return patient;
    }

    public void setPatient(IdentifiedPersonBean patient) {
        this.patient = patient;
    }

    @Hl7XmlMapping("reasonCode")
    public ActConsentInformationAccessReason getReasonCode() {
        return (ActConsentInformationAccessReason) this.reasonCode.getValue();
    }

    public void setReasonCode(ActConsentInformationAccessReason reasonCode) {
        this.reasonCode.setValue(reasonCode);
    }

    @Hl7XmlMapping("author1/modeCode")
    public x_PhysicalVerbalParticipationMode getModeCode() {
        return (x_PhysicalVerbalParticipationMode) this.modeCode.getValue();
    }

    public void setModeCode(x_PhysicalVerbalParticipationMode modeCode) {
        this.modeCode.setValue(modeCode);
    }

    @Hl7XmlMapping("author1/consenter")
    public Consenter getConsenter() {
        return consenter;
    }

    public void setConsenter(Consenter consenter) {
        this.consenter = consenter;
    }

    @Hl7XmlMapping("author2/assignedPerson")
    public AssignedPersonBean getProvider() {
        return provider;
    }

    public void setProvider(AssignedPersonBean provider) {
        this.provider = provider;
    }

    @Hl7XmlMapping("component/permissionToInform")
    public InformationAccessBean getInformationAccess() {
        return informationAccess;
    }

    public void setInformationAccess(InformationAccessBean informationAccess) {
        this.informationAccess = informationAccess;
    }
}
