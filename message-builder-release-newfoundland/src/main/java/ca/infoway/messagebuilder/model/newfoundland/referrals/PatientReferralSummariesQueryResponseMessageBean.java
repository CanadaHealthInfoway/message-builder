package ca.infoway.messagebuilder.model.newfoundland.referrals;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.NewQueryResponseMessageBean;

@Hl7PartTypeMapping("REPC_IN000085CA")
public class PatientReferralSummariesQueryResponseMessageBean extends NewQueryResponseMessageBean<PatientReferralSummariesQueryCriteria, ReferralDocumentSummaryBean> {

    private static final long serialVersionUID = 668078534657002500L;

    public PatientReferralSummariesQueryResponseMessageBean() {
        this(new PatientReferralSummariesQueryCriteria());
    }

    public PatientReferralSummariesQueryResponseMessageBean(PatientReferralSummariesQueryCriteria criteria) {
        super(criteria);
    }
}
