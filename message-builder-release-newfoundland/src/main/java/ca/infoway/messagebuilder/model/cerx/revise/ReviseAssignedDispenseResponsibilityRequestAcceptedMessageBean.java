package ca.infoway.messagebuilder.model.cerx.revise;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.RecordResponseMessageBean;
import ca.infoway.messagebuilder.model.cerx.Prescription;

@Hl7PartTypeMapping("PORX_IN010110CA")
public class ReviseAssignedDispenseResponsibilityRequestAcceptedMessageBean extends RecordResponseMessageBean<Prescription> {

    private static final long serialVersionUID = -3907807567405801885L;
}
