/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pharmacy.porx_mt020070ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"PORX_MT020070CA.Component2"})
public class Component2Bean extends MessagePartBean {

    private static final long serialVersionUID = 20100614L;
    private BL contextConductionInd = new BLImpl();
    private SupplyRequestBean supplyRequest;

    @Hl7XmlMapping({"contextConductionInd"})
    public Boolean getContextConductionInd() {
        return this.contextConductionInd.getValue();
    }
    public void setContextConductionInd(Boolean contextConductionInd) {
        this.contextConductionInd.setValue(contextConductionInd);
    }

    @Hl7XmlMapping({"supplyRequest"})
    public SupplyRequestBean getSupplyRequest() {
        return this.supplyRequest;
    }
    public void setSupplyRequest(SupplyRequestBean supplyRequest) {
        this.supplyRequest = supplyRequest;
    }

}
