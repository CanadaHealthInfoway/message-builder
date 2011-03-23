package ca.infoway.messagebuilder.model.cerx.annotation;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.NewQueryMessageBean;

@Hl7PartTypeMapping("COMT_IN300201CA")
public class PatientNoteQueryMessageBean extends NewQueryMessageBean<PatientNoteQueryCriteriaBean> {

    private static final long serialVersionUID = 3168384981366793898L;

    public PatientNoteQueryMessageBean() {
        this(new PatientNoteQueryCriteriaBean());
    }

    public PatientNoteQueryMessageBean(PatientNoteQueryCriteriaBean criteria) {
        super(criteria);
    }
}
