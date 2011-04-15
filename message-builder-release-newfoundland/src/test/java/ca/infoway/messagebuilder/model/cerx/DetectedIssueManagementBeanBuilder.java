package ca.infoway.messagebuilder.model.cerx;

import static ca.infoway.messagebuilder.resolver.CodeResolverRegistry.lookup;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.domainvalue.ActDetectedIssueManagementCode;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.model.AuthorBeanBuilder;
import ca.infoway.messagebuilder.model.BaseBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.DetectedIssueManagementBean;

public class DetectedIssueManagementBeanBuilder extends BaseBeanBuilder<DetectedIssueManagementBean> {

	public DetectedIssueManagementBeanBuilder() {
		super(new DetectedIssueManagementBean());
	}

	public DetectedIssueManagementBeanBuilder populate() {
		this.bean.setAuthor(new AuthorBeanBuilder().populate().create());
		this.bean.setCode(lookup(ActDetectedIssueManagementCode.class, "1", CodeSystem.VOCABULARY_ACT_CODE.getRoot()));
		this.bean.setStatusCode(lookup(ActStatus.class, "active", CodeSystem.VOCABULARY_ACT_CODE.getRoot()));
		this.bean.setText("text");
		return this;
	}

}
