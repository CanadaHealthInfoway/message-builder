package ca.infoway.messagebuilder.model.cerx;

import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode;
import ca.infoway.messagebuilder.model.BaseBeanBuilder;
import ca.infoway.messagebuilder.model.MessageBeanBuilderSupport;
import ca.infoway.messagebuilder.model.newfoundland.DetectedIssueBean;
import ca.infoway.messagebuilder.model.newfoundland.RecordBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.issuemanagement.AddIssueManagementRequestMessageBean;

public class AddIssueManagementRequestMessageBeanBuilder extends BaseBeanBuilder<AddIssueManagementRequestMessageBean> {

	public AddIssueManagementRequestMessageBeanBuilder() {
		super(new AddIssueManagementRequestMessageBean());
	}

	public AddIssueManagementRequestMessageBeanBuilder populate() {
		this.bean.getControlActEvent().setCode(HL7TriggerEventCode.ADD_ISSUE_MANAGEMENT_REQUEST);
		MessageBeanBuilderSupport.populateStandardValuesV02(this.bean.getMessageAttributes());
		this.bean.setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValues(this.bean.getControlActEvent());
		
		RecordBean<DetectedIssueBean> recordBean = new RecordBean<DetectedIssueBean>();
		recordBean.setRecord(new DetectedIssueBeanBuilder().populate().create());
		this.bean.getControlActEvent().setRecordBean(recordBean);
		
		return this;
	}
}
