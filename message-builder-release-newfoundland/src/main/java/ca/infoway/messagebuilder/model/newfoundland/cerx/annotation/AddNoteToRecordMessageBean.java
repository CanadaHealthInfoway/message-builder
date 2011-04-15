package ca.infoway.messagebuilder.model.newfoundland.cerx.annotation;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.NoteBean;
import ca.infoway.messagebuilder.model.newfoundland.RecordRequestMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.marker.HasTargetReference;

@Hl7PartTypeMapping("COMT_IN301001CA")
public class AddNoteToRecordMessageBean extends RecordRequestMessageBean<NoteBean> implements HasTargetReference<NoteBean> {

    private static final long serialVersionUID = 8292898501823857922L;

    public NoteBean getTargetReference() {
        return this.getRecord();
    }
}
