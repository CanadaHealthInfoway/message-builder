package ca.infoway.messagebuilder.model.cerx.issuemanagement;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.marker.HasTargetReference;
import ca.infoway.messagebuilder.model.DetectedIssueBean;
import ca.infoway.messagebuilder.model.RecordRequestMessageBean;

@Hl7PartTypeMapping("COMT_IN700001CA")
public class AddIssueManagementRequestMessageBean extends RecordRequestMessageBean<DetectedIssueBean> implements HasTargetReference<DetectedIssueBean> {

    private static final long serialVersionUID = -2870047123230999648L;

    public DetectedIssueBean getTargetReference() {
        return this.getRecord();
    }
}
