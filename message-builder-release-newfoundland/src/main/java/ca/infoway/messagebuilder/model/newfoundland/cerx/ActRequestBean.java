package ca.infoway.messagebuilder.model.newfoundland.cerx;

import java.io.Serializable;
import java.util.List;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.newfoundland.IdentifiedPersonBean;
import ca.infoway.messagebuilder.model.newfoundland.OfPatient;

@Hl7PartTypeMapping({ "PORX_MT990020CA.ActRequest", "COMT_MT001101CA.ActRequest" })
public class ActRequestBean extends MessagePartBean implements OfPatient, Serializable {

    private static final long serialVersionUID = -5894567220982928298L;

    private final LIST<II, Identifier> ids = new LISTImpl<II, Identifier>(IIImpl.class);

    private IdentifiedPersonBean patient;

    @Hl7XmlMapping("id")
    public List<Identifier> getIds() {
        return this.ids.rawList();
    }

    public Identifier getId() {
        return this.getIds().isEmpty() ? null : this.getIds().get(0);
    }

    public void setId(Identifier id) {
        this.getIds().clear();
        this.getIds().add(id);
    }

    @Hl7XmlMapping("subject/patient")
    public IdentifiedPersonBean getPatient() {
        return patient;
    }

    public void setPatient(IdentifiedPersonBean identifiedPerson) {
        this.patient = identifiedPerson;
    }
}
