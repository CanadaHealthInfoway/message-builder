/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.iehr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.x_ActClassCareProvisionProcedure;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Request</p>
 * 
 * <p>REPC_MT610002CA.ActRequest: A:Request</p>
 * 
 * <p></p></p>
 * 
 * <p></p></p>
 * 
 * <p>REPC_MT610001CA.ActRequest: A:Request</p>
 * 
 * <p></p></p>
 * 
 * <p></p></p>
 */
@Hl7PartTypeMapping({"REPC_MT610001CA.ActRequest","REPC_MT610002CA.ActRequest"})
public class Request_3Bean extends MessagePartBean {

    private static final long serialVersionUID = 20110126L;
    private RequestedByBean author;
    private II requestId = new IIImpl();
    private CS requestType = new CSImpl();


    @Hl7XmlMapping({"author"})
    public RequestedByBean getAuthor() {
        return this.author;
    }
    public void setAuthor(RequestedByBean author) {
        this.author = author;
    }


    /**
     * <p>RequestId</p>
     * 
     * <p>A: Request Id</p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getRequestId() {
        return this.requestId.getValue();
    }
    public void setRequestId(Identifier requestId) {
        this.requestId.setValue(requestId);
    }


    /**
     * <p>RequestType</p>
     * 
     * <p>B:Request Type</p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     */
    @Hl7XmlMapping({"classCode"})
    public x_ActClassCareProvisionProcedure getRequestType() {
        return (x_ActClassCareProvisionProcedure) this.requestType.getValue();
    }
    public void setRequestType(x_ActClassCareProvisionProcedure requestType) {
        this.requestType.setValue(requestType);
    }

}
