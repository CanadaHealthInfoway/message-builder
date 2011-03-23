package ca.infoway.messagebuilder.model.location;

import java.io.Serializable;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifiable;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;

@Hl7PartTypeMapping({ "PRLO_MT000002CA.IndirectAuthorithyOver", "PRLO_MT000001CA.IndirectAuthorithyOver" })
public class IndirectAuthorityBean extends MessagePartBean implements Identifiable, Serializable {

    private static final long serialVersionUID = -390445368800547660L;

    private II id = new IIImpl();

    @Hl7XmlMapping("territorialAuthority/id")
    public Identifier getId() {
        return this.id.getValue();
    }

    public void setId(Identifier id) {
        this.id.setValue(id);
    }
}
