package ca.infoway.messagebuilder.model.newfoundland;

import java.io.Serializable;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.domainvalue.ParticipationType;
import ca.infoway.messagebuilder.model.MessagePartBean;

@Hl7PartTypeMapping({ "RecordTarget", "QUQI_MT020000CA.RecordTarget" })
public class RecordTargetBean extends MessagePartBean implements Serializable {

    private static final long serialVersionUID = 7340908216739493271L;

    private CD participationType = new CDImpl();

    private Patient patient;

    @Hl7XmlMapping("typeCode")
    public ParticipationType getParticipationType() {
        return (ParticipationType) this.participationType.getValue();
    }

    public void setParticipationType(ParticipationType participationType) {
        this.participationType.setValue(participationType);
    }

    @Hl7XmlMapping("patient1")
    public Patient getPatient() {
        return this.patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
