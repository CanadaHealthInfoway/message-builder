/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r01.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"MFMI_MT700711CA.Subject4","MFMI_MT700716CA.Subject4","MFMI_MT700726CA.Subject4","MFMI_MT700746CA.Subject4"})
public class RegisteredItemBean<RR> extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private RR registeredRole;


    @Hl7XmlMapping({"registeredRole"})
    public RR getRegisteredRole() {
        return this.registeredRole;
    }
    public void setRegisteredRole(RR registeredRole) {
        this.registeredRole = registeredRole;
    }

}