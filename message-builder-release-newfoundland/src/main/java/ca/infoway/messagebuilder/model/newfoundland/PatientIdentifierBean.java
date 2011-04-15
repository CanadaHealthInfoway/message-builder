package ca.infoway.messagebuilder.model.newfoundland;

import java.io.Serializable;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.RoleClass;
import ca.infoway.messagebuilder.model.MessagePartBean;

@Hl7PartTypeMapping({ "COCT_MT050201CA.Patient", "COCT_MT470000CA.Patient", "RCMR_MT010001CA.Patient" })
public class PatientIdentifierBean extends MessagePartBean implements Patient, Consenter, Serializable {

    private static final long serialVersionUID = 5565861585958481913L;

    private final II id = new IIImpl();

    private final CD classCode = new CDImpl();

    @Hl7XmlMapping("id")
    public Identifier getId() {
        return this.id.getValue();
    }

    public void setId(Identifier identifier) {
        this.id.setValue(identifier);
    }

    @Hl7XmlMapping("classCode")
    public RoleClass getClassCode() {
        return (RoleClass) this.classCode.getValue();
    }

    public void setClassCode(RoleClass classCode) {
        this.classCode.setValue(classCode);
    }
}
