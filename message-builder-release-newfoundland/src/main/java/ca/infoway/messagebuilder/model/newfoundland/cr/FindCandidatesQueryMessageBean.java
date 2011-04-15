package ca.infoway.messagebuilder.model.newfoundland.cr;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.cr.FindCandidatesCriteria;
import ca.infoway.messagebuilder.model.newfoundland.NewQueryMessageBean;

/**
 * <p>Find Candidates Query</p>
 * 
 * <p>This interaction sends a query to a Person Registry requesting a list of 
 * candidates that match a particular set of person demographics.</p>
 * 
 * @author administrator
 */
@Hl7PartTypeMapping("PRPA_IN101103CA")
public class FindCandidatesQueryMessageBean extends NewQueryMessageBean<FindCandidatesCriteria> {

    private static final long serialVersionUID = 8365557396616384144L;

    public FindCandidatesQueryMessageBean() {
        super(new FindCandidatesCriteria());
    }

    public FindCandidatesQueryMessageBean(FindCandidatesCriteria criteria) {
        super(criteria);
    }
}
