package ca.infoway.messagebuilder.model.newfoundland.cerx.issuemanagement;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.DetectedIssueBean;
import ca.infoway.messagebuilder.model.newfoundland.RecordRequestMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.marker.HasTargetReference;

@Hl7PartTypeMapping("COMT_IN700001CA")
public class AddIssueManagementRequestMessageBean extends RecordRequestMessageBean<DetectedIssueBean> implements HasTargetReference<DetectedIssueBean> {

    private static final long serialVersionUID = -2870047123230999648L;

    public DetectedIssueBean getTargetReference() {
        return this.getRecord();
    }
}
