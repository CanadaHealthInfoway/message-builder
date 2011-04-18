package ca.infoway.messagebuilder.model.newfoundland.cerx.annotation;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.ActEventBean;
import ca.infoway.messagebuilder.model.newfoundland.RecordRequestMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.marker.HasTargetReference;

@Hl7PartTypeMapping("COMT_IN300101CA")
public class DeprecatePatientNoteMessageBean extends RecordRequestMessageBean<ActEventBean> implements HasTargetReference<ActEventBean> {

    private static final long serialVersionUID = 8292898501823857922L;

    public ActEventBean getTargetReference() {
        return this.getRecord();
    }
}