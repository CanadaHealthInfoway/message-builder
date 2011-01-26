/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pr.prpm_mt306011ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"PRPM_MT306011CA.SequelTo"})
public class SequelToBean extends MessagePartBean {

    private static final long serialVersionUID = 20110126L;
    private InformRequestBean informRequest;
    private INT orderOfInformRequests = new INTImpl();


    @Hl7XmlMapping({"informRequest"})
    public InformRequestBean getInformRequest() {
        return this.informRequest;
    }
    public void setInformRequest(InformRequestBean informRequest) {
        this.informRequest = informRequest;
    }


    /**
     * <p>Order of Inform Requests</p>
     * 
     * <p><p>Allows each Inform Request to be sequentially 
     * listed.</p></p>
     */
    @Hl7XmlMapping({"sequenceNumber"})
    public Integer getOrderOfInformRequests() {
        return this.orderOfInformRequests.getValue();
    }
    public void setOrderOfInformRequests(Integer orderOfInformRequests) {
        this.orderOfInformRequests.setValue(orderOfInformRequests);
    }

}
