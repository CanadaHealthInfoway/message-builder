/**
 * Copyright 2013 Canada Health Infoway, Inc.
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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.claims.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"FICR_MT400004CA.SpecialAuthorizationAdditionalInformationRequest","FICR_MT490003CA.SpecialAuthorizationAdditionalInformationRequest","FICR_MT490103CA.SpecialAuthorizationAdditionalInformationRequest"})
@Hl7RootType
public class SpecialAuthorizationAdditionalInformationRequestBean extends MessagePartBean {

    private static final long serialVersionUID = 20130613L;
    private II id = new IIImpl();
    private ST text = new STImpl();
    private SpecialAuthorizationRequestBean referenceSpecialAuthorizationRequest;


    /**
     * <p>Business Name: AdditionalInformationRequestID</p>
     * 
     * <p>Un-merged Business Name: AdditionalInformationRequestID</p>
     * 
     * <p>Relationship: 
     * FICR_MT400004CA.SpecialAuthorizationAdditionalInformationRequest.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: AdditionalInformationRequestID</p>
     * 
     * <p>Relationship: 
     * FICR_MT490003CA.SpecialAuthorizationAdditionalInformationRequest.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: AdditionalInformationRequestID</p>
     * 
     * <p>Relationship: 
     * FICR_MT490103CA.SpecialAuthorizationAdditionalInformationRequest.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: AdditionalInformationRequestID</p>
     * 
     * <p>Un-merged Business Name: AdditionalInformationRequestID</p>
     * 
     * <p>Relationship: 
     * FICR_MT400004CA.SpecialAuthorizationAdditionalInformationRequest.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: AdditionalInformationRequestID</p>
     * 
     * <p>Relationship: 
     * FICR_MT490003CA.SpecialAuthorizationAdditionalInformationRequest.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: AdditionalInformationRequestID</p>
     * 
     * <p>Relationship: 
     * FICR_MT490103CA.SpecialAuthorizationAdditionalInformationRequest.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: AdditionalInformationQuestion</p>
     * 
     * <p>Un-merged Business Name: AdditionalInformationQuestion</p>
     * 
     * <p>Relationship: 
     * FICR_MT400004CA.SpecialAuthorizationAdditionalInformationRequest.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: AdditionalInformationQuestion</p>
     * 
     * <p>Relationship: 
     * FICR_MT490003CA.SpecialAuthorizationAdditionalInformationRequest.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: AdditionalInformationQuestion</p>
     * 
     * <p>Relationship: 
     * FICR_MT490103CA.SpecialAuthorizationAdditionalInformationRequest.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"text"})
    public String getText() {
        return this.text.getValue();
    }

    /**
     * <p>Business Name: AdditionalInformationQuestion</p>
     * 
     * <p>Un-merged Business Name: AdditionalInformationQuestion</p>
     * 
     * <p>Relationship: 
     * FICR_MT400004CA.SpecialAuthorizationAdditionalInformationRequest.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: AdditionalInformationQuestion</p>
     * 
     * <p>Relationship: 
     * FICR_MT490003CA.SpecialAuthorizationAdditionalInformationRequest.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: AdditionalInformationQuestion</p>
     * 
     * <p>Relationship: 
     * FICR_MT490103CA.SpecialAuthorizationAdditionalInformationRequest.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setText(String text) {
        this.text.setValue(text);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT490003CA.Reference.specialAuthorizationRequest</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"reference/specialAuthorizationRequest"})
    public SpecialAuthorizationRequestBean getReferenceSpecialAuthorizationRequest() {
        return this.referenceSpecialAuthorizationRequest;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT490003CA.Reference.specialAuthorizationRequest</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setReferenceSpecialAuthorizationRequest(SpecialAuthorizationRequestBean referenceSpecialAuthorizationRequest) {
        this.referenceSpecialAuthorizationRequest = referenceSpecialAuthorizationRequest;
    }

}
