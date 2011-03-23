package ca.infoway.messagebuilder.model.mock;

import java.io.Serializable;

import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.SeverityObservation;
import ca.infoway.messagebuilder.model.MessagePartBean;

public class SeverityObservationBean extends MessagePartBean implements Serializable {

    private static final long serialVersionUID = 3635762510647290962L;

    private CD code = new CDImpl();

    private CD statusCode = new CDImpl();

    private CD severityObservation = new CDImpl();

    public SeverityObservationBean() {
        super();
    }

    @Hl7XmlMapping("code")
    public ActCode getCode() {
        return (ActCode) this.code.getValue();
    }

    public void setCode(ActCode code) {
        this.code.setValue(code);
    }

    @Hl7XmlMapping("statusCode")
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }

    @Hl7XmlMapping("value")
    public SeverityObservation getSeverityObservation() {
        return (SeverityObservation) this.severityObservation.getValue();
    }

    public void setSeverityObservation(SeverityObservation severityObservation) {
        this.severityObservation.setValue(severityObservation);
    }
}
