package ca.infoway.messagebuilder.model.cerx;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.domainvalue.ActSupplyFulfillmentRefusalReason;
import ca.infoway.messagebuilder.model.AuthorBean;
import ca.infoway.messagebuilder.model.DetectedIssueBean;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ServiceDeliveryLocationBean;

@Hl7PartTypeMapping({ "PORX_MT030040CA.RefusalToFill", "PORX_MT060040CA.RefusalToFill", "PORX_MT060060CA.RefusalToFill", "PORX_MT060160CA.RefusalToFill", "PORX_MT060190CA.RefusalToFill" })
public class RefusalToFillBean extends MessagePartBean implements Serializable {

    private static final long serialVersionUID = -8780226956132545899L;

    private TS effectiveTime = new TSImpl();

    private CD reasonCode = new CDImpl();

    private AuthorBean author;

    private final List<DetectedIssueBean> detectedIssue = Collections.synchronizedList(new ArrayList<DetectedIssueBean>());

    private ServiceDeliveryLocationBean location;

    @Hl7XmlMapping("effectiveTime")
    public Date getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }

    @Hl7XmlMapping("reasonCode")
    public ActSupplyFulfillmentRefusalReason getReasonCode() {
        return (ActSupplyFulfillmentRefusalReason) this.reasonCode.getValue();
    }

    public void setReasonCode(ActSupplyFulfillmentRefusalReason reasonCode) {
        this.reasonCode.setValue(reasonCode);
    }

    @Hl7XmlMapping("author")
    public AuthorBean getAuthor() {
        return author;
    }

    public void setAuthor(AuthorBean author) {
        this.author = author;
    }

    @Hl7XmlMapping("reason/detectedIssueEvent")
    public List<DetectedIssueBean> getDetectedIssues() {
        return detectedIssue;
    }

    @Hl7XmlMapping("location/serviceDeliveryLocation")
    public ServiceDeliveryLocationBean getLocation() {
        return location;
    }

    public void setLocation(ServiceDeliveryLocationBean location) {
        this.location = location;
    }
}
