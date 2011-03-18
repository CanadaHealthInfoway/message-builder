/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.claims.ficr_mt490103ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.r02_04_02.claims.merged.HealthDocumentAttachment_1Bean;
import ca.infoway.messagebuilder.model.r02_04_02.claims.merged.SpecialAuthorizationAdditionalInformationRequestBean;
import ca.infoway.messagebuilder.model.r02_04_02.claims.merged.SpecialAuthorizationCriteriaBean;
import java.util.ArrayList;
import java.util.List;



@Hl7PartTypeMapping({"FICR_MT490103CA.SpecialAuthorizationAdditionalInformationResponse"})
@Hl7RootType
public class SpecialAuthorizationAdditionalInformationResponseBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private SpecialAuthorizationAdditionalInformationRequestBean inFulfillmentOfSpecialAuthorizationAdditionalInformationRequest;
    private List<HealthDocumentAttachment_1Bean> pertinentInformationHealthDocumentAttachment = new ArrayList<HealthDocumentAttachment_1Bean>();
    private List<SpecialAuthorizationCriteriaBean> supportSpecialAuthorizationCriteria = new ArrayList<SpecialAuthorizationCriteriaBean>();
    private ST additionalInformationAnswer = new STImpl();
    private II additionalInformationResponseID = new IIImpl();


    @Hl7XmlMapping({"inFulfillmentOf/specialAuthorizationAdditionalInformationRequest"})
    public SpecialAuthorizationAdditionalInformationRequestBean getInFulfillmentOfSpecialAuthorizationAdditionalInformationRequest() {
        return this.inFulfillmentOfSpecialAuthorizationAdditionalInformationRequest;
    }
    public void setInFulfillmentOfSpecialAuthorizationAdditionalInformationRequest(SpecialAuthorizationAdditionalInformationRequestBean inFulfillmentOfSpecialAuthorizationAdditionalInformationRequest) {
        this.inFulfillmentOfSpecialAuthorizationAdditionalInformationRequest = inFulfillmentOfSpecialAuthorizationAdditionalInformationRequest;
    }


    @Hl7XmlMapping({"pertinentInformation/healthDocumentAttachment"})
    public List<HealthDocumentAttachment_1Bean> getPertinentInformationHealthDocumentAttachment() {
        return this.pertinentInformationHealthDocumentAttachment;
    }


    @Hl7XmlMapping({"support/specialAuthorizationCriteria"})
    public List<SpecialAuthorizationCriteriaBean> getSupportSpecialAuthorizationCriteria() {
        return this.supportSpecialAuthorizationCriteria;
    }


    /**
     * <p>Additional Information Answer</p>
     */
    @Hl7XmlMapping({"text"})
    public String getAdditionalInformationAnswer() {
        return this.additionalInformationAnswer.getValue();
    }
    public void setAdditionalInformationAnswer(String additionalInformationAnswer) {
        this.additionalInformationAnswer.setValue(additionalInformationAnswer);
    }


    /**
     * <p>Additional Information Response ID</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getAdditionalInformationResponseID() {
        return this.additionalInformationResponseID.getValue();
    }
    public void setAdditionalInformationResponseID(Identifier additionalInformationResponseID) {
        this.additionalInformationResponseID.setValue(additionalInformationResponseID);
    }

}
