package ca.infoway.messagebuilder.model.newfoundland.cerx.abort;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.ActEventBean;
import ca.infoway.messagebuilder.model.newfoundland.RecordResponseMessageBean;

@Hl7PartTypeMapping("PORX_IN020380CA")
public class RecordDispenseReversalAcceptedMessageBean extends RecordResponseMessageBean<ActEventBean> {

    private static final long serialVersionUID = -2560235225191013715L;
}