package ca.infoway.messagebuilder.model.newfoundland;

import java.io.Serializable;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;

@Hl7PartTypeMapping({ "NLPN_MT100000CA.ActEvent", "PORX_MT990010CA.ActEvent", "NLPN_MT100000CA.ActEvent" })
public class ActEventBean extends MessagePartBean implements OfPatient, Serializable {

    private static final long serialVersionUID = 5179092601632206911L;

    private II id = new IIImpl();

    private IdentifiedPersonBean patient;

    @Hl7XmlMapping("id")
    public Identifier getId() {
        return this.id.getValue();
    }

    public void setId(Identifier id) {
        this.id.setValue(id);
    }

    @Hl7XmlMapping("recordTarget/patient")
    public IdentifiedPersonBean getPatient() {
        return this.patient;
    }

    public void setPatient(IdentifiedPersonBean patient) {
        this.patient = patient;
    }
}
