package ca.infoway.messagebuilder.model.cr;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.IdentifiedPersonBean;
import ca.infoway.messagebuilder.model.NewQueryResponseMessageBean;
import ca.infoway.messagebuilder.model.ResponseMessageAttributesBean;

@Hl7PartTypeMapping("PRPA_IN101104CA")
public class FindCandidatesQueryResponseMessageBean extends NewQueryResponseMessageBean<FindCandidatesCriteria, IdentifiedPersonBean> {

    private static final long serialVersionUID = -501893110095343570L;

    public FindCandidatesQueryResponseMessageBean(ResponseMessageAttributesBean attributes, FindCandidatesCriteria criteria) {
        super(attributes, criteria);
    }

    public FindCandidatesQueryResponseMessageBean(FindCandidatesCriteria criteria) {
        super(criteria);
    }

    public FindCandidatesQueryResponseMessageBean() {
        this(new FindCandidatesCriteria());
    }
}
