/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.iehr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.domainvalue.ActProfessionalServiceCode;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"REPC_MT210001CA.ActRequest2","REPC_MT210002CA.ActRequest2","REPC_MT210003CA.ActRequest2"})
public class ActRequest2Bean extends MessagePartBean {

    private static final long serialVersionUID = 20110127L;
    private CD requestedService = new CDImpl();


    /**
     * <p>RequestedService</p>
     * 
     * <p>H:Requested Service</p>
     * 
     * <p>H:Requested Service</p>
     * 
     * <p><p>A coded value denoting the specific service that has 
     * been ordered through the referral.</p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     */
    @Hl7XmlMapping({"code"})
    public ActProfessionalServiceCode getRequestedService() {
        return (ActProfessionalServiceCode) this.requestedService.getValue();
    }
    public void setRequestedService(ActProfessionalServiceCode requestedService) {
        this.requestedService.setValue(requestedService);
    }

}
