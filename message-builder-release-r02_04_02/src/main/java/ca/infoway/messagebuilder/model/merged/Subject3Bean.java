/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"FICR_MT400003CA.Subject","FICR_MT400003CA.Subject3","FICR_MT400004CA.Subject","FICR_MT400004CA.Subject3","FICR_MT490102CA.Subject3","FICR_MT490102CA.Subject4"})
public class Subject3Bean extends MessagePartBean {

    private static final long serialVersionUID = 20100603L;
    private BL includesExcludesProduct = new BLImpl();
    private SpecialAuthorizationChoice_2Bean specialAuthorizationChoice;

    @Hl7XmlMapping({"negationInd"})
    public Boolean getIncludesExcludesProduct() {
        return this.includesExcludesProduct.getValue();
    }
    public void setIncludesExcludesProduct(Boolean includesExcludesProduct) {
        this.includesExcludesProduct.setValue(includesExcludesProduct);
    }

    @Hl7XmlMapping({"specialAuthorizationChoice"})
    public SpecialAuthorizationChoice_2Bean getSpecialAuthorizationChoice() {
        return this.specialAuthorizationChoice;
    }
    public void setSpecialAuthorizationChoice(SpecialAuthorizationChoice_2Bean specialAuthorizationChoice) {
        this.specialAuthorizationChoice = specialAuthorizationChoice;
    }

    public SubstanceAdministrationBean getSpecialAuthorizationChoiceAsSubstanceAdministration() {
        return this.specialAuthorizationChoice instanceof SubstanceAdministrationBean ? (SubstanceAdministrationBean) this.specialAuthorizationChoice : null;
    }
    public boolean hasSpecialAuthorizationChoiceAsSubstanceAdministration() {
        return (this.specialAuthorizationChoice instanceof SubstanceAdministrationBean);
    }

    public DevicePassThruBean getSpecialAuthorizationChoiceAsDevicePassThru() {
        return this.specialAuthorizationChoice instanceof DevicePassThruBean ? (DevicePassThruBean) this.specialAuthorizationChoice : null;
    }
    public boolean hasSpecialAuthorizationChoiceAsDevicePassThru() {
        return (this.specialAuthorizationChoice instanceof DevicePassThruBean);
    }

}
