/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.domainvalue.ContextControl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.common.coct_mt470002ca.ConsentBean;



@Hl7PartTypeMapping({"MCAI_MT700210CA.Subject3","MCAI_MT700211CA.Subject3","MCAI_MT700212CA.Subject3","MFMI_MT700711CA.Subject3","MFMI_MT700751CA.Subject1","QUQI_MT020000CA.Subject3","QUQI_MT020002CA.Subject3","QUQI_MT120006CA.Subject3","QUQI_MT120008CA.Subject3"})
public class AuthorizedByBean extends MessagePartBean {

    private ConsentBean consentEvent;
    private CS<ContextControl> contextControlCode = new CSImpl<ContextControl>();

    @Hl7XmlMapping({"consentEvent"})
    public ConsentBean getConsentEvent() {
        return this.consentEvent;
    }
    public void setConsentEvent(ConsentBean consentEvent) {
        this.consentEvent = consentEvent;
    }

    @Hl7XmlMapping({"contextControlCode"})
    public ContextControl getContextControlCode() {
        return this.contextControlCode.getValue();
    }
    public void setContextControlCode(ContextControl contextControlCode) {
        this.contextControlCode.setValue(contextControlCode);
    }

}
