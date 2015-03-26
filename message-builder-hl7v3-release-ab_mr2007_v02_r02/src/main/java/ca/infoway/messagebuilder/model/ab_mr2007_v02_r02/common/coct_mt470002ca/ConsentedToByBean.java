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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.coct_mt470002ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.domainvalue.x_PhysicalVerbalParticipationMode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.coct_mt910107ca.RelatedPersonBean;



/**
 * <p>Business Name: b:consented to by</p>
 * 
 * <p>Indicates that the consent was provided by the patient or 
 * representative.</p>
 * 
 * <p>Authorization.Person</p><p>Authorization.signatory(PT)</p>
 * 
 * <p>Authorization.Person</p><p>Authorization.signatory(PT)</p>
 * 
 * <p>Consent can be provided by the patient or representative 
 * or the provider.</p>
 */
@Hl7PartTypeMapping({"COCT_MT470002CA.Author"})
public class ConsentedToByBean extends MessagePartBean {

    private static final long serialVersionUID = 20150326L;
    private CV modeCode = new CVImpl();
    private ED<String> signatureText = new EDImpl<String>();
    private RelatedPersonBean personalRelationship;


    /**
     * <p>Business Name: Patient Consent Mechanism</p>
     * 
     * <p>Relationship: COCT_MT470002CA.Author.modeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates whether the patient's consent is written or 
     * verbal.</p>
     * 
     * <p>Verbal consents may trigger a higher level of 
     * auditing.</p>
     */
    @Hl7XmlMapping({"modeCode"})
    public x_PhysicalVerbalParticipationMode getModeCode() {
        return (x_PhysicalVerbalParticipationMode) this.modeCode.getValue();
    }

    /**
     * <p>Business Name: Patient Consent Mechanism</p>
     * 
     * <p>Relationship: COCT_MT470002CA.Author.modeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates whether the patient's consent is written or 
     * verbal.</p>
     * 
     * <p>Verbal consents may trigger a higher level of 
     * auditing.</p>
     */
    public void setModeCode(x_PhysicalVerbalParticipationMode modeCode) {
        this.modeCode.setValue(modeCode);
    }


    /**
     * <p>Business Name: Keyword</p>
     * 
     * <p>Relationship: COCT_MT470002CA.Author.signatureText</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates the keyword appropriate to the action being 
     * performed by the message.</p>
     * 
     * <p>Allows providers who know the keyword to access 
     * information protected by patient keywords.</p>
     */
    @Hl7XmlMapping({"signatureText"})
    public String getSignatureText() {
        return this.signatureText.getValue();
    }

    /**
     * <p>Business Name: Keyword</p>
     * 
     * <p>Relationship: COCT_MT470002CA.Author.signatureText</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates the keyword appropriate to the action being 
     * performed by the message.</p>
     * 
     * <p>Allows providers who know the keyword to access 
     * information protected by patient keywords.</p>
     */
    public void setSignatureText(String signatureText) {
        this.signatureText.setValue(signatureText);
    }


    /**
     * <p>Relationship: COCT_MT470002CA.Author.personalRelationship</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"personalRelationship"})
    public RelatedPersonBean getPersonalRelationship() {
        return this.personalRelationship;
    }

    /**
     * <p>Relationship: COCT_MT470002CA.Author.personalRelationship</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setPersonalRelationship(RelatedPersonBean personalRelationship) {
        this.personalRelationship = personalRelationship;
    }

}
