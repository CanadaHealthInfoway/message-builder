/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r01.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.x_ActMoodOrderEvent;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.v02_r01.merged.CarrierRoleBean;



@Hl7PartTypeMapping({"PORX_MT060160CA.Coverage","PORX_MT060340CA.Coverage"})
public class CoverageExtensions_2Bean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private CarrierRoleBean authorCarrierRole;
    private II coverageExtensionId = new IIImpl();
    private CS extensionGrantedIndicator = new CSImpl();


    @Hl7XmlMapping({"author/carrierRole"})
    public CarrierRoleBean getAuthorCarrierRole() {
        return this.authorCarrierRole;
    }
    public void setAuthorCarrierRole(CarrierRoleBean authorCarrierRole) {
        this.authorCarrierRole = authorCarrierRole;
    }


    /**
     * <p>CoverageExtensionId</p>
     * 
     * <p>A:Coverage Extension Id</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getCoverageExtensionId() {
        return this.coverageExtensionId.getValue();
    }
    public void setCoverageExtensionId(Identifier coverageExtensionId) {
        this.coverageExtensionId.setValue(coverageExtensionId);
    }


    /**
     * <p>ExtensionGrantedIndicator</p>
     * 
     * <p>Extension Granted Indicator</p>
     */
    @Hl7XmlMapping({"moodCode"})
    public x_ActMoodOrderEvent getExtensionGrantedIndicator() {
        return (x_ActMoodOrderEvent) this.extensionGrantedIndicator.getValue();
    }
    public void setExtensionGrantedIndicator(x_ActMoodOrderEvent extensionGrantedIndicator) {
        this.extensionGrantedIndicator.setValue(extensionGrantedIndicator);
    }

}
