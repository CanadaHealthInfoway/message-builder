package ca.infoway.messagebuilder.model.mock;

import java.io.Serializable;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;

@Hl7PartTypeMapping({ "COCT_MT090310CA.AssignedDevice" })
public class AssignedDeviceBean extends MessagePartBean implements Serializable {

    private static final long serialVersionUID = 5659630456107426952L;

    private II id = new IIImpl();

    private ST assignedRepository = new STImpl();

    private ST representedRepositoryJurisdiction = new STImpl();

    @Hl7XmlMapping("id")
    public Identifier getId() {
        return this.id.getValue();
    }

    public void setId(Identifier id) {
        this.id.setValue(id);
    }

    @Hl7XmlMapping("assignedRepository/name")
    public String getAssignedRepository() {
        return this.assignedRepository.getValue();
    }

    public void setAssignedRepository(String assignedRepository) {
        this.assignedRepository.setValue(assignedRepository);
    }

    @Hl7XmlMapping("representedRepositoryJurisdiction/name")
    public String getRepresentedRepositoryJurisdiction() {
        return this.representedRepositoryJurisdiction.getValue();
    }

    public void setRepresentedRepositoryJurisdiction(String representedRepositoryJurisdiction) {
        this.representedRepositoryJurisdiction.setValue(representedRepositoryJurisdiction);
    }
}
