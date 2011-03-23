package ca.infoway.messagebuilder.model.cerx.annotation;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.NewQueryResponseMessageBean;
import ca.infoway.messagebuilder.model.NoteBean;
import ca.infoway.messagebuilder.model.ResponseMessageAttributesBean;

@Hl7PartTypeMapping("COMT_IN300202CA")
public class PatientNoteQueryResponseMessageBean extends NewQueryResponseMessageBean<PatientNoteQueryCriteriaBean, NoteBean> {

    private static final long serialVersionUID = 2123487827104945848L;

    public PatientNoteQueryResponseMessageBean(ResponseMessageAttributesBean attributes, PatientNoteQueryCriteriaBean criteria) {
        super(attributes, criteria);
    }

    public PatientNoteQueryResponseMessageBean(PatientNoteQueryCriteriaBean criteria) {
        super(criteria);
    }

    public PatientNoteQueryResponseMessageBean() {
        this(new PatientNoteQueryCriteriaBean());
    }
}
