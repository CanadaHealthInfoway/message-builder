/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.claims.ficr_mt490003ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"FICR_MT490003CA.SpecialAuthorizationRequest"})
public class SpecialAuthorizationRequestBean extends MessagePartBean {

    private static final long serialVersionUID = 20100603L;
    private II specialAuthorizationRequestID = new IIImpl();
    private CV specialAuthorizationRequestType = new CVImpl();
    private CS requestStatus = new CSImpl();

    @Hl7XmlMapping({"id"})
    public Identifier getSpecialAuthorizationRequestID() {
        return this.specialAuthorizationRequestID.getValue();
    }
    public void setSpecialAuthorizationRequestID(Identifier specialAuthorizationRequestID) {
        this.specialAuthorizationRequestID.setValue(specialAuthorizationRequestID);
    }

    @Hl7XmlMapping({"code"})
    public Code getSpecialAuthorizationRequestType() {
        return (Code) this.specialAuthorizationRequestType.getValue();
    }
    public void setSpecialAuthorizationRequestType(Code specialAuthorizationRequestType) {
        this.specialAuthorizationRequestType.setValue(specialAuthorizationRequestType);
    }

    @Hl7XmlMapping({"statusCode"})
    public ActStatus getRequestStatus() {
        return (ActStatus) this.requestStatus.getValue();
    }
    public void setRequestStatus(ActStatus requestStatus) {
        this.requestStatus.setValue(requestStatus);
    }

}
