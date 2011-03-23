package ca.infoway.messagebuilder.model.cerx.professionalservice;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.marker.HasTargetReference;
import ca.infoway.messagebuilder.model.RecordRequestMessageBean;

@Hl7PartTypeMapping("REPC_IN000044CA")
public class RecordProfessionalServiceRequestMessageBean extends RecordRequestMessageBean<ProfessionalServiceRecord> implements HasTargetReference<ProfessionalServiceRecord> {

    private static final long serialVersionUID = 6981709898582446047L;

    public ProfessionalServiceRecord getTargetReference() {
        return getControlActEvent().getRecord();
    }
}
