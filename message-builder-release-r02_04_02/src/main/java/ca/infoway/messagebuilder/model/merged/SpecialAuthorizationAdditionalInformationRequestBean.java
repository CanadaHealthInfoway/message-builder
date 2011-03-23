/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.claims.ficr_mt490003ca.SpecialAuthorizationRequestBean;



@Hl7PartTypeMapping({"FICR_MT400004CA.SpecialAuthorizationAdditionalInformationRequest","FICR_MT490003CA.SpecialAuthorizationAdditionalInformationRequest","FICR_MT490103CA.SpecialAuthorizationAdditionalInformationRequest"})
@Hl7RootType
public class SpecialAuthorizationAdditionalInformationRequestBean extends MessagePartBean {

    private static final long serialVersionUID = 20100603L;
    private II additionalInformationRequestID = new IIImpl();
    private ST additionalInformationQuestion = new STImpl();
    private SpecialAuthorizationRequestBean referenceSpecialAuthorizationRequest;

    @Hl7XmlMapping({"id"})
    public Identifier getAdditionalInformationRequestID() {
        return this.additionalInformationRequestID.getValue();
    }
    public void setAdditionalInformationRequestID(Identifier additionalInformationRequestID) {
        this.additionalInformationRequestID.setValue(additionalInformationRequestID);
    }

    @Hl7XmlMapping({"text"})
    public String getAdditionalInformationQuestion() {
        return this.additionalInformationQuestion.getValue();
    }
    public void setAdditionalInformationQuestion(String additionalInformationQuestion) {
        this.additionalInformationQuestion.setValue(additionalInformationQuestion);
    }

    @Hl7XmlMapping({"reference/specialAuthorizationRequest"})
    public SpecialAuthorizationRequestBean getReferenceSpecialAuthorizationRequest() {
        return this.referenceSpecialAuthorizationRequest;
    }
    public void setReferenceSpecialAuthorizationRequest(SpecialAuthorizationRequestBean referenceSpecialAuthorizationRequest) {
        this.referenceSpecialAuthorizationRequest = referenceSpecialAuthorizationRequest;
    }

}
