package ca.infoway.messagebuilder.model.newfoundland.broadcast;

import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.model.newfoundland.QueryCriteria;

public class BroadcastTopicsQueryCriteriaBean extends QueryCriteria {

    private static final long serialVersionUID = 2015306038028268909L;

    private ST userId = new STImpl();

    @Hl7XmlMapping("userId/value")
    public String getUserId() {
        return this.userId.getValue();
    }

    public void setUserId(String userId) {
        this.userId.setValue(userId);
    }
}
