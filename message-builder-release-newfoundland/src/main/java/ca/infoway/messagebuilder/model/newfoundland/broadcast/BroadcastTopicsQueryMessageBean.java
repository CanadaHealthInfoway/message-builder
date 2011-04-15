package ca.infoway.messagebuilder.model.newfoundland.broadcast;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.NewQueryMessageBean;

@Hl7PartTypeMapping("NLPN_IN100120CA")
public class BroadcastTopicsQueryMessageBean extends NewQueryMessageBean<BroadcastTopicsQueryCriteriaBean> {

    private static final long serialVersionUID = 6497963430539278472L;

    public BroadcastTopicsQueryMessageBean() {
        this(new BroadcastTopicsQueryCriteriaBean());
    }

    public BroadcastTopicsQueryMessageBean(BroadcastTopicsQueryCriteriaBean criteria) {
        super(criteria);
    }
}
