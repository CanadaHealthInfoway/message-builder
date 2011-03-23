package ca.infoway.messagebuilder.model.cerx.professionalservice;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.ActEventBean;
import ca.infoway.messagebuilder.model.RecordResponseMessageBean;

@Hl7PartTypeMapping("REPC_IN000045CA")
public class RecordProfessionalServiceRequestAcceptedMessageBean extends RecordResponseMessageBean<ActEventBean> {

    private static final long serialVersionUID = 6981709898582446047L;

    public RecordProfessionalServiceRequestAcceptedMessageBean() {
    }
}
