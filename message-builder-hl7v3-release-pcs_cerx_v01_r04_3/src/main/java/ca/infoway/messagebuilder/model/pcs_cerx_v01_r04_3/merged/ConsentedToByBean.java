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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.x_PhysicalVerbalParticipationMode;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: ConsentedToBy</p>
 * 
 * <p>COCT_MT470000CA.Author: b:consented to by</p>
 * 
 * <p>Authorization.Person</p>
 * 
 * <p>Authorization.signatory(PT)</p>
 * 
 * <p>Consent can be provided by the patient or representative 
 * or the provider.</p>
 * 
 * <p>Indicates that the consent was provided by the patient or 
 * representative.</p>
 * 
 * <p>RCMR_MT010001CA.Author: b:consented to by</p>
 * 
 * <p>Authorization.Person</p>
 * 
 * <p>Authorization.signatory(PT)</p>
 * 
 * <p>Consent can be provided by the patient or representative 
 * or be overridden by a provider. It is important to know 
 * which occurred for audit purposes.</p>
 * 
 * <p>Indicates that the consent was provided by the patient or 
 * representative.</p>
 */
@Hl7PartTypeMapping({"COCT_MT470000CA.Author","RCMR_MT010001CA.Author"})
public class ConsentedToByBean extends MessagePartBean {

    private static final long serialVersionUID = 20121204L;
    private CV modeCode = new CVImpl();
    private ST signatureText = new STImpl();
    private Consenter consenter;


    /**
     * <p>Business Name: PatientConsentMechanism</p>
     * 
     * <p>Un-merged Business Name: PatientConsentMechanism</p>
     * 
     * <p>Relationship: COCT_MT470000CA.Author.modeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Verbal consents may trigger a higher level of 
     * auditing.</p>
     * 
     * <p>Indicates whether the patient's consent is written or 
     * verbal.</p>
     * 
     * <p>Un-merged Business Name: PatientConsentMechanism</p>
     * 
     * <p>Relationship: RCMR_MT010001CA.Author.modeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Verbal consents may trigger a higher level of 
     * auditing.</p>
     * 
     * <p>Indicates whether the patient's consent is written or 
     * verbal.</p>
     */
    @Hl7XmlMapping({"modeCode"})
    public x_PhysicalVerbalParticipationMode getModeCode() {
        return (x_PhysicalVerbalParticipationMode) this.modeCode.getValue();
    }

    /**
     * <p>Business Name: PatientConsentMechanism</p>
     * 
     * <p>Un-merged Business Name: PatientConsentMechanism</p>
     * 
     * <p>Relationship: COCT_MT470000CA.Author.modeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Verbal consents may trigger a higher level of 
     * auditing.</p>
     * 
     * <p>Indicates whether the patient's consent is written or 
     * verbal.</p>
     * 
     * <p>Un-merged Business Name: PatientConsentMechanism</p>
     * 
     * <p>Relationship: RCMR_MT010001CA.Author.modeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Verbal consents may trigger a higher level of 
     * auditing.</p>
     * 
     * <p>Indicates whether the patient's consent is written or 
     * verbal.</p>
     */
    public void setModeCode(x_PhysicalVerbalParticipationMode modeCode) {
        this.modeCode.setValue(modeCode);
    }


    /**
     * <p>Business Name: Keyword</p>
     * 
     * <p>Un-merged Business Name: Keyword</p>
     * 
     * <p>Relationship: COCT_MT470000CA.Author.signatureText</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows providers who know the keyword to access 
     * information protected by patient keywords.</p>
     * 
     * <p>Indicates the keyword appropriate to the action being 
     * performed by the message.</p>
     */
    @Hl7XmlMapping({"signatureText"})
    public String getSignatureText() {
        return this.signatureText.getValue();
    }

    /**
     * <p>Business Name: Keyword</p>
     * 
     * <p>Un-merged Business Name: Keyword</p>
     * 
     * <p>Relationship: COCT_MT470000CA.Author.signatureText</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows providers who know the keyword to access 
     * information protected by patient keywords.</p>
     * 
     * <p>Indicates the keyword appropriate to the action being 
     * performed by the message.</p>
     */
    public void setSignatureText(String signatureText) {
        this.signatureText.setValue(signatureText);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT470000CA.Author.consenter</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: RCMR_MT010001CA.Author.consenter</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"consenter"})
    public Consenter getConsenter() {
        return this.consenter;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT470000CA.Author.consenter</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: RCMR_MT010001CA.Author.consenter</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setConsenter(Consenter consenter) {
        this.consenter = consenter;
    }

}
