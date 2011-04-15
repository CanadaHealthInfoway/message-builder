package ca.infoway.messagebuilder.model.newfoundland.cerx.professionalservice;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.RecordRequestMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.marker.HasTargetReference;

@Hl7PartTypeMapping("REPC_IN000044CA")
public class RecordProfessionalServiceRequestMessageBean extends RecordRequestMessageBean<ProfessionalServiceRecord> implements HasTargetReference<ProfessionalServiceRecord> {

    private static final long serialVersionUID = 6981709898582446047L;

    public ProfessionalServiceRecord getTargetReference() {
        return getControlActEvent().getRecord();
    }
}
