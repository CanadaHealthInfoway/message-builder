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
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.coct_mt470002ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.domainvalue.ContextControl;
import ca.infoway.messagebuilder.domainvalue.ParticipationType;
import ca.infoway.messagebuilder.domainvalue.x_PhysicalVerbalParticipationMode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.merged.RelatedPersonBean;



/**
 * <p>b:consented to by</p>
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

    private static final long serialVersionUID = 20121122L;
    private CS typeCode = new CSImpl();
    private CS contextControlCode = new CSImpl();
    private CV modeCode = new CVImpl();
    private ED<String> signatureText = new EDImpl<String>();
    private RelatedPersonBean personalRelationship;


    @Hl7XmlMapping({"typeCode"})
    public ParticipationType getTypeCode() {
        return (ParticipationType) this.typeCode.getValue();
    }

    public void setTypeCode(ParticipationType typeCode) {
        this.typeCode.setValue(typeCode);
    }


    @Hl7XmlMapping({"contextControlCode"})
    public ContextControl getContextControlCode() {
        return (ContextControl) this.contextControlCode.getValue();
    }

    public void setContextControlCode(ContextControl contextControlCode) {
        this.contextControlCode.setValue(contextControlCode);
    }


    /**
     * <p>Patient Consent Mechanism</p>
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
     * <p>Patient Consent Mechanism</p>
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
     * <p>Keyword</p>
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
     * <p>Keyword</p>
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


    @Hl7XmlMapping({"personalRelationship"})
    public RelatedPersonBean getPersonalRelationship() {
        return this.personalRelationship;
    }

    public void setPersonalRelationship(RelatedPersonBean personalRelationship) {
        this.personalRelationship = personalRelationship;
    }

}
