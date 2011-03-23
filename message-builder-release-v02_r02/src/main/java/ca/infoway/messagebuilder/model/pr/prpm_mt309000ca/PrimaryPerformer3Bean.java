/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pr.prpm_mt309000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.domainvalue.ParticipationType;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"PRPM_MT309000CA.PrimaryPerformer3"})
public class PrimaryPerformer3Bean extends MessagePartBean {

    private static final long serialVersionUID = 20100614L;
    private CS typeCode = new CSImpl();
    private ActDefinitionOrEventNameBean actDefinitionOrEvent;

    @Hl7XmlMapping({"typeCode"})
    public ParticipationType getTypeCode() {
        return (ParticipationType) this.typeCode.getValue();
    }
    public void setTypeCode(ParticipationType typeCode) {
        this.typeCode.setValue(typeCode);
    }

    @Hl7XmlMapping({"actDefinitionOrEvent"})
    public ActDefinitionOrEventNameBean getActDefinitionOrEvent() {
        return this.actDefinitionOrEvent;
    }
    public void setActDefinitionOrEvent(ActDefinitionOrEventNameBean actDefinitionOrEvent) {
        this.actDefinitionOrEvent = actDefinitionOrEvent;
    }

}
