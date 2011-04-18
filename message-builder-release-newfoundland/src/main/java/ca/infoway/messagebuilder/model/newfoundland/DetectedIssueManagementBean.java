package ca.infoway.messagebuilder.model.newfoundland;

import java.io.Serializable;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.ActDetectedIssueManagementCode;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.model.MessagePartBean;

@Hl7PartTypeMapping({ "PORX_MT980010CA.DetectedIssueManagement", "PORX_MT980030CA.DetectedIssueManagement" })
public class DetectedIssueManagementBean extends MessagePartBean implements Serializable {

    private static final long serialVersionUID = 5300042834504076009L;

    private CD code = new CDImpl();

    private CD statusCode = new CDImpl();

    private AuthorBean author = new AuthorBean();

    private ST text = new STImpl();

    public DetectedIssueManagementBean() {
        super();
    }

    @Hl7XmlMapping({ "code" })
    public ActDetectedIssueManagementCode getCode() {
        return (ActDetectedIssueManagementCode) this.code.getValue();
    }

    public void setCode(ActDetectedIssueManagementCode code) {
        this.code.setValue(code);
    }

    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }

    @Hl7XmlMapping({ "author" })
    public AuthorBean getAuthor() {
        return author;
    }

    public void setAuthor(AuthorBean author) {
        this.author = author;
    }

    @Hl7XmlMapping({ "text" })
    public String getText() {
        return this.text.getValue();
    }

    public void setText(String text) {
        this.text.setValue(text);
    }
}