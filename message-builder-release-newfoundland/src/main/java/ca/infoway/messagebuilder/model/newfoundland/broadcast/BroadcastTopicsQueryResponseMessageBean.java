package ca.infoway.messagebuilder.model.newfoundland.broadcast;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.NewQueryResponseMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.ResponseMessageAttributesBean;

@Hl7PartTypeMapping("NLPN_IN100130CA")
public class BroadcastTopicsQueryResponseMessageBean extends NewQueryResponseMessageBean<BroadcastTopicsQueryCriteriaBean, BroadcastTopicBean> {

    private static final long serialVersionUID = -3047913982090652119L;

    public BroadcastTopicsQueryResponseMessageBean(ResponseMessageAttributesBean attributes, BroadcastTopicsQueryCriteriaBean criteria) {
        super(attributes, criteria);
    }

    public BroadcastTopicsQueryResponseMessageBean(BroadcastTopicsQueryCriteriaBean criteria) {
        super(criteria);
    }

    public BroadcastTopicsQueryResponseMessageBean() {
        this(new BroadcastTopicsQueryCriteriaBean());
    }
}
