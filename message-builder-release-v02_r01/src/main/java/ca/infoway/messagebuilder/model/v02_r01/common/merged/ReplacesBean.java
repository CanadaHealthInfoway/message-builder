/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r01.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"MFMI_MT700711CA.ReplacementOf","MFMI_MT700716CA.ReplacementOf","MFMI_MT700726CA.ReplacementOf","MFMI_MT700746CA.ReplacementOf"})
public class ReplacesBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private BL contextConductionInd = new BLImpl();
    private PriorRegistrationEventBean priorRegistration;


    @Hl7XmlMapping({"contextConductionInd"})
    public Boolean getContextConductionInd() {
        return this.contextConductionInd.getValue();
    }
    public void setContextConductionInd(Boolean contextConductionInd) {
        this.contextConductionInd.setValue(contextConductionInd);
    }


    @Hl7XmlMapping({"priorRegistration"})
    public PriorRegistrationEventBean getPriorRegistration() {
        return this.priorRegistration;
    }
    public void setPriorRegistration(PriorRegistrationEventBean priorRegistration) {
        this.priorRegistration = priorRegistration;
    }

}
