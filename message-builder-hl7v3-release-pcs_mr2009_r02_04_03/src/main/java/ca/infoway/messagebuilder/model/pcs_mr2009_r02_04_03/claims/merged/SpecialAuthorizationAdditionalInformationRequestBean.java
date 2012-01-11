/**
 * Copyright 2012 Canada Health Infoway, Inc.
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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
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

    private static final long serialVersionUID = 20120106L;
    private II id = new IIImpl();
    private ST text = new STImpl();
    private SpecialAuthorizationRequestBean referenceSpecialAuthorizationRequest;


    /**
     * <p>AdditionalInformationRequestID</p>
     * 
     * <p>Additional Information Request ID</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>AdditionalInformationQuestion</p>
     * 
     * <p>Additional Information Question</p>
     */
    @Hl7XmlMapping({"text"})
    public String getText() {
        return this.text.getValue();
    }
    public void setText(String text) {
        this.text.setValue(text);
    }


    @Hl7XmlMapping({"reference/specialAuthorizationRequest"})
    public SpecialAuthorizationRequestBean getReferenceSpecialAuthorizationRequest() {
        return this.referenceSpecialAuthorizationRequest;
    }
    public void setReferenceSpecialAuthorizationRequest(SpecialAuthorizationRequestBean referenceSpecialAuthorizationRequest) {
        this.referenceSpecialAuthorizationRequest = referenceSpecialAuthorizationRequest;
    }

}
