/**
 * Copyright 2011 Canada Health Infoway, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.ficr_mt490103ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.merged.HealthDocumentAttachment_1Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.merged.SpecialAuthorizationAdditionalInformationRequestBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.merged.SpecialAuthorizationCriteriaBean;
import java.util.ArrayList;
import java.util.List;



@Hl7PartTypeMapping({"FICR_MT490103CA.SpecialAuthorizationAdditionalInformationResponse"})
@Hl7RootType
public class SpecialAuthorizationAdditionalInformationResponseBean extends MessagePartBean {

    private static final long serialVersionUID = 20110906L;
    private II additionalInformationResponseID = new IIImpl();
    private ST additionalInformationAnswer = new STImpl();
    private SpecialAuthorizationAdditionalInformationRequestBean inFulfillmentOfSpecialAuthorizationAdditionalInformationRequest;
    private List<SpecialAuthorizationCriteriaBean> supportSpecialAuthorizationCriteria = new ArrayList<SpecialAuthorizationCriteriaBean>();
    private List<HealthDocumentAttachment_1Bean> pertinentInformationHealthDocumentAttachment = new ArrayList<HealthDocumentAttachment_1Bean>();


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


    @Hl7XmlMapping({"inFulfillmentOf/specialAuthorizationAdditionalInformationRequest"})
    public SpecialAuthorizationAdditionalInformationRequestBean getInFulfillmentOfSpecialAuthorizationAdditionalInformationRequest() {
        return this.inFulfillmentOfSpecialAuthorizationAdditionalInformationRequest;
    }
    public void setInFulfillmentOfSpecialAuthorizationAdditionalInformationRequest(SpecialAuthorizationAdditionalInformationRequestBean inFulfillmentOfSpecialAuthorizationAdditionalInformationRequest) {
        this.inFulfillmentOfSpecialAuthorizationAdditionalInformationRequest = inFulfillmentOfSpecialAuthorizationAdditionalInformationRequest;
    }


    @Hl7XmlMapping({"support/specialAuthorizationCriteria"})
    public List<SpecialAuthorizationCriteriaBean> getSupportSpecialAuthorizationCriteria() {
        return this.supportSpecialAuthorizationCriteria;
    }


    @Hl7XmlMapping({"pertinentInformation/healthDocumentAttachment"})
    public List<HealthDocumentAttachment_1Bean> getPertinentInformationHealthDocumentAttachment() {
        return this.pertinentInformationHealthDocumentAttachment;
    }

}
