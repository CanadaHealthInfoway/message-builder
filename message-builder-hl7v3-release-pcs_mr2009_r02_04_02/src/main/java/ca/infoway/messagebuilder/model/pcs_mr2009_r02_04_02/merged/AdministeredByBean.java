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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.domainvalue.ParticipationMode;
import ca.infoway.messagebuilder.domainvalue.ParticipationSignature;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>POIZ_MT030060CA.Performer: administered by</p>
 * 
 * <p>Needed to identify who actually administered the vaccine 
 * to the patient. If the performing provider is not specified, 
 * the author is assumed to be the performing provider. This 
 * information may not always be known. As a result, this 
 * participation is required.</p>
 * 
 * <p>The provider who administered the vaccine.</p>
 * 
 * <p>POIZ_MT030050CA.Performer: administered by</p>
 * 
 * <p>Needed to identify who actually administered the vaccine 
 * to the patient. If the performing provider is not specified, 
 * the author is assumed to be the performing provider. This 
 * information may not always be known. As a result, this 
 * participation is required.</p>
 * 
 * <p>The provider who administered the vaccine.</p>
 * 
 * <p>POIZ_MT060150CA.Performer: administered by</p>
 * 
 * <p>Needed to identify who actually administered the vaccine 
 * to the patient. If the performing provider is not specified, 
 * the author is assumed to be the performing provider. This 
 * information may not always be known. As a result, this 
 * participation is required.</p>
 * 
 * <p>The provider who administered the vaccine.</p>
 * 
 * <p>REPC_MT210002CA.Performer: *u: referred to</p>
 * 
 * <p>If the referral was targeted to a specific provider then 
 * the identity of the provider must be known.</p>
 * 
 * <p>Identifies the specific provider for which the referral 
 * is to be sent.</p>
 * 
 * <p>REPC_MT210003CA.Performer: *u: referred to</p>
 * 
 * <p>If the referral was targeted to a specific provider then 
 * the identity of the provider must be known.</p>
 * 
 * <p>Identifies the specific provider for which the referral 
 * is to be sent.</p>
 */
@Hl7PartTypeMapping({"POIZ_MT030050CA.Performer","POIZ_MT030060CA.Performer","POIZ_MT060150CA.Performer","REPC_MT210001CA.Performer","REPC_MT210002CA.Performer","REPC_MT210003CA.Performer"})
public class AdministeredByBean extends MessagePartBean {

    private static final long serialVersionUID = 20130307L;
    private CV modeCode = new CVImpl();
    private CV signatureCode = new CVImpl();
    private ED<String> signatureText = new EDImpl<String>();
    private HealthcareWorkerBean assignedEntity;


    /**
     * <p>Business Name: SigningMethod</p>
     * 
     * <p>Un-merged Business Name: SigningMethod</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.Performer.modeCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Used to specify whether the information was initially 
     * provided verbally, (hand-)written, or electronically. As not 
     * all implementations will need to communication this 
     * information, this attribute is optional.</p>
     * 
     * <p>A code specifying the modality by which the original 
     * information was presented.</p>
     * 
     * <p>Un-merged Business Name: SigningMethod</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.Performer.modeCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Used to specify whether the information was initially 
     * provided verbally, (hand-)written, or electronically. As not 
     * all implementations will need to communication this 
     * information, this attribute is optional.</p>
     * 
     * <p>A code specifying the modality by which the original 
     * information was presented.</p>
     * 
     * <p>Un-merged Business Name: SigningMethod</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.Performer.modeCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Used to specify whether the information was initially 
     * provided verbally, (hand-)written, or electronically. As not 
     * all implementations will need to communication this 
     * information, this attribute is optional.</p>
     * 
     * <p>A code specifying the modality by which the original 
     * information was presented.</p>
     */
    @Hl7XmlMapping({"modeCode"})
    public ParticipationMode getModeCode() {
        return (ParticipationMode) this.modeCode.getValue();
    }

    /**
     * <p>Business Name: SigningMethod</p>
     * 
     * <p>Un-merged Business Name: SigningMethod</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.Performer.modeCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Used to specify whether the information was initially 
     * provided verbally, (hand-)written, or electronically. As not 
     * all implementations will need to communication this 
     * information, this attribute is optional.</p>
     * 
     * <p>A code specifying the modality by which the original 
     * information was presented.</p>
     * 
     * <p>Un-merged Business Name: SigningMethod</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.Performer.modeCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Used to specify whether the information was initially 
     * provided verbally, (hand-)written, or electronically. As not 
     * all implementations will need to communication this 
     * information, this attribute is optional.</p>
     * 
     * <p>A code specifying the modality by which the original 
     * information was presented.</p>
     * 
     * <p>Un-merged Business Name: SigningMethod</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.Performer.modeCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Used to specify whether the information was initially 
     * provided verbally, (hand-)written, or electronically. As not 
     * all implementations will need to communication this 
     * information, this attribute is optional.</p>
     * 
     * <p>A code specifying the modality by which the original 
     * information was presented.</p>
     */
    public void setModeCode(ParticipationMode modeCode) {
        this.modeCode.setValue(modeCode);
    }


    /**
     * <p>Business Name: SignatureCode</p>
     * 
     * <p>Un-merged Business Name: SignatureCode</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.Performer.signatureCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Allows for communicating whether a the provider has 
     * digitally signed their signature. Strong, trusted 
     * authentication of the submitting author is sufficient to 
     * remove the need for digital signatures. As a result, this 
     * attribute is optional.</p>
     * 
     * <p>A code specifying whether and how the participant has 
     * attested his participation through a signature and or 
     * whether such a signature is needed.</p>
     * 
     * <p>Un-merged Business Name: SignatureCode</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.Performer.signatureCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Allows for communicating whether a the provider has 
     * digitally signed their signature. Strong, trusted 
     * authentication of the submitting author is sufficient to 
     * remove the need for digital signatures. As a result, this 
     * attribute is optional.</p>
     * 
     * <p>A code specifying whether and how the participant has 
     * attested his participation through a signature and or 
     * whether such a signature is needed.</p>
     * 
     * <p>Un-merged Business Name: SignatureCode</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.Performer.signatureCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Allows for communicating whether a the provider has 
     * digitally signed their signature. Strong, trusted 
     * authentication of the submitting author is sufficient to 
     * remove the need for digital signatures. As a result, this 
     * attribute is optional.</p>
     * 
     * <p>A code specifying whether and how the participant has 
     * attested his participation through a signature and or 
     * whether such a signature is needed.</p>
     */
    @Hl7XmlMapping({"signatureCode"})
    public ParticipationSignature getSignatureCode() {
        return (ParticipationSignature) this.signatureCode.getValue();
    }

    /**
     * <p>Business Name: SignatureCode</p>
     * 
     * <p>Un-merged Business Name: SignatureCode</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.Performer.signatureCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Allows for communicating whether a the provider has 
     * digitally signed their signature. Strong, trusted 
     * authentication of the submitting author is sufficient to 
     * remove the need for digital signatures. As a result, this 
     * attribute is optional.</p>
     * 
     * <p>A code specifying whether and how the participant has 
     * attested his participation through a signature and or 
     * whether such a signature is needed.</p>
     * 
     * <p>Un-merged Business Name: SignatureCode</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.Performer.signatureCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Allows for communicating whether a the provider has 
     * digitally signed their signature. Strong, trusted 
     * authentication of the submitting author is sufficient to 
     * remove the need for digital signatures. As a result, this 
     * attribute is optional.</p>
     * 
     * <p>A code specifying whether and how the participant has 
     * attested his participation through a signature and or 
     * whether such a signature is needed.</p>
     * 
     * <p>Un-merged Business Name: SignatureCode</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.Performer.signatureCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Allows for communicating whether a the provider has 
     * digitally signed their signature. Strong, trusted 
     * authentication of the submitting author is sufficient to 
     * remove the need for digital signatures. As a result, this 
     * attribute is optional.</p>
     * 
     * <p>A code specifying whether and how the participant has 
     * attested his participation through a signature and or 
     * whether such a signature is needed.</p>
     */
    public void setSignatureCode(ParticipationSignature signatureCode) {
        this.signatureCode.setValue(signatureCode);
    }


    /**
     * <p>Business Name: DigitalSignature</p>
     * 
     * <p>Un-merged Business Name: DigitalSignature</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.Performer.signatureText</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Allows for recording the signature of the performing 
     * provider. Strong, trusted authentication of the submitting 
     * author is sufficient to remove the need for digital 
     * signatures. As a result, this attribute is optional.</p>
     * 
     * <p>A textual or multimedia depiction of the signature by 
     * which the participant endorses his or her participation in 
     * the Act as specified in the Participation.typeCode and that 
     * he or she agrees to assume the associated 
     * accountability.</p>
     * 
     * <p>Un-merged Business Name: DigitalSignature</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.Performer.signatureText</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Allows for recording the signature of the performing 
     * provider. Strong, trusted authentication of the submitting 
     * author is sufficient to remove the need for digital 
     * signatures. As a result, this attribute is optional.</p>
     * 
     * <p>A textual or multimedia depiction of the signature by 
     * which the participant endorses his or her participation in 
     * the Act as specified in the Participation.typeCode and that 
     * he or she agrees to assume the associated 
     * accountability.</p>
     * 
     * <p>Un-merged Business Name: DigitalSignature</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.Performer.signatureText</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Allows for recording the signature of the performing 
     * provider. Strong, trusted authentication of the submitting 
     * author is sufficient to remove the need for digital 
     * signatures. As a result, this attribute is optional.</p>
     * 
     * <p>A textual or multimedia depiction of the signature by 
     * which the participant endorses his or her participation in 
     * the Act as specified in the Participation.typeCode and that 
     * he or she agrees to assume the associated 
     * accountability.</p>
     */
    @Hl7XmlMapping({"signatureText"})
    public String getSignatureText() {
        return this.signatureText.getValue();
    }

    /**
     * <p>Business Name: DigitalSignature</p>
     * 
     * <p>Un-merged Business Name: DigitalSignature</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.Performer.signatureText</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Allows for recording the signature of the performing 
     * provider. Strong, trusted authentication of the submitting 
     * author is sufficient to remove the need for digital 
     * signatures. As a result, this attribute is optional.</p>
     * 
     * <p>A textual or multimedia depiction of the signature by 
     * which the participant endorses his or her participation in 
     * the Act as specified in the Participation.typeCode and that 
     * he or she agrees to assume the associated 
     * accountability.</p>
     * 
     * <p>Un-merged Business Name: DigitalSignature</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.Performer.signatureText</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Allows for recording the signature of the performing 
     * provider. Strong, trusted authentication of the submitting 
     * author is sufficient to remove the need for digital 
     * signatures. As a result, this attribute is optional.</p>
     * 
     * <p>A textual or multimedia depiction of the signature by 
     * which the participant endorses his or her participation in 
     * the Act as specified in the Participation.typeCode and that 
     * he or she agrees to assume the associated 
     * accountability.</p>
     * 
     * <p>Un-merged Business Name: DigitalSignature</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.Performer.signatureText</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Allows for recording the signature of the performing 
     * provider. Strong, trusted authentication of the submitting 
     * author is sufficient to remove the need for digital 
     * signatures. As a result, this attribute is optional.</p>
     * 
     * <p>A textual or multimedia depiction of the signature by 
     * which the participant endorses his or her participation in 
     * the Act as specified in the Participation.typeCode and that 
     * he or she agrees to assume the associated 
     * accountability.</p>
     */
    public void setSignatureText(String signatureText) {
        this.signatureText.setValue(signatureText);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.Performer.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.Performer.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.Performer.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT210002CA.Performer.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT210003CA.Performer.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT210001CA.Performer.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"assignedEntity"})
    public HealthcareWorkerBean getAssignedEntity() {
        return this.assignedEntity;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.Performer.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.Performer.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.Performer.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT210002CA.Performer.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT210003CA.Performer.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT210001CA.Performer.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setAssignedEntity(HealthcareWorkerBean assignedEntity) {
        this.assignedEntity = assignedEntity;
    }

}
