package ca.infoway.messagebuilder.model.newfoundland.cerx;

import java.io.Serializable;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.newfoundland.AssignedPersonBean;
import ca.infoway.messagebuilder.model.newfoundland.AuthorBean;

@Hl7PartTypeMapping({ "PORX_MT020060CA.DeviceRequest_V01R04_3_HOTFIX3" })
public class SimpleDeviceRequestBean extends MessagePartBean implements Serializable {

    private static final long serialVersionUID = 6188600457425087366L;

    private final II id = new IIImpl();

    private AssignedPersonBean responsibleParty;

    private AuthorBean author;

    private DeviceDispenseInstructionsBean supplyRequest;

    @Hl7XmlMapping("id")
    public Identifier getId() {
        return this.id.getValue();
    }

    public void setId(Identifier idAssignedByEhr) {
        this.id.setValue(idAssignedByEhr);
    }

    @Hl7XmlMapping("responsibleParty/assignedPerson")
    public AssignedPersonBean getResponsibleParty() {
        return responsibleParty;
    }

    public void setResponsibleParty(AssignedPersonBean responsibleParty) {
        this.responsibleParty = responsibleParty;
    }

    @Hl7XmlMapping("author")
    public AuthorBean getAuthor() {
        return author;
    }

    public void setAuthor(AuthorBean author) {
        this.author = author;
    }

    @Hl7XmlMapping("component/supplyRequest")
    public DeviceDispenseInstructionsBean getSupplyRequest() {
        return supplyRequest;
    }

    public void setSupplyRequest(DeviceDispenseInstructionsBean supplyRequest) {
        this.supplyRequest = supplyRequest;
    }
}
