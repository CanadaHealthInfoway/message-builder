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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.claims.ficr_mt600201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedData;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActRelationshipType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.domainvalue.ActClaimAttachmentCode;
import java.util.Set;



/**
 * <p>Business Name: Attachments</p>
 * 
 * <p>If this relationship is required, it may only be 
 * specified for the Root Invoice Element Group and is not 
 * permitted for all other Invoice Element Groups.</p><p>Look 
 * into what HL7 is currently doing, as well as timing. Each 
 * SIG to revisit based on HL7's work. Want the ability to send 
 * attachments with the invoice as well as sending it upon 
 * request. Need to ensure that the vocab in the info codes for 
 * inv adj response supports the needed attachments.</p>
 * 
 * <p>Use of attachments must be pre-approved by the NeCST 
 * Pharmacy SIG.</p><p>RxS1: Not permitted, as attachments are 
 * not included in this scenario.</p>
 * 
 * <p>Could be used to attach a Limited Use Form or a Consent 
 * Form.</p>
 */
@Hl7PartTypeMapping({"FICR_MT600201CA.InvoiceElementGroupAttachment"})
public class AttachmentsBean extends MessagePartBean {

    private static final long serialVersionUID = 20130613L;
    private CS typeCode = new CSImpl();
    private SET<II, Identifier> healthDocumentAttachmentId = new SETImpl<II, Identifier>(IIImpl.class);
    private CV healthDocumentAttachmentCode = new CVImpl();
    private ED<EncapsulatedData> healthDocumentAttachmentValue = new EDImpl<EncapsulatedData>();


    /**
     * <p>Relationship: 
     * FICR_MT600201CA.InvoiceElementGroupAttachment.typeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"typeCode"})
    public ActRelationshipType getTypeCode() {
        return (ActRelationshipType) this.typeCode.getValue();
    }

    /**
     * <p>Relationship: 
     * FICR_MT600201CA.InvoiceElementGroupAttachment.typeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setTypeCode(ActRelationshipType typeCode) {
        this.typeCode.setValue(typeCode);
    }


    /**
     * <p>Business Name: Attachment identifier</p>
     * 
     * <p>Relationship: FICR_MT600201CA.HealthDocumentAttachment.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1-5)</p>
     * 
     * <p>RxS1: Not permitted, as attachments are not included in 
     * this scenario</p>
     * 
     * <p>Set of identifiers that uniquely identify the 
     * Attachment.</p>
     */
    @Hl7XmlMapping({"healthDocumentAttachment/id"})
    public Set<Identifier> getHealthDocumentAttachmentId() {
        return this.healthDocumentAttachmentId.rawSet();
    }


    /**
     * <p>Business Name: Attachment Type</p>
     * 
     * <p>Relationship: 
     * FICR_MT600201CA.HealthDocumentAttachment.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Domain has not been defined for attachment types. RxS1: 
     * Not permitted, as attachments are not included in this 
     * scenario.</p>
     * 
     * <p>The type of attachment. I.e.. Health document type, image 
     * type.</p>
     */
    @Hl7XmlMapping({"healthDocumentAttachment/code"})
    public ActClaimAttachmentCode getHealthDocumentAttachmentCode() {
        return (ActClaimAttachmentCode) this.healthDocumentAttachmentCode.getValue();
    }

    /**
     * <p>Business Name: Attachment Type</p>
     * 
     * <p>Relationship: 
     * FICR_MT600201CA.HealthDocumentAttachment.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Domain has not been defined for attachment types. RxS1: 
     * Not permitted, as attachments are not included in this 
     * scenario.</p>
     * 
     * <p>The type of attachment. I.e.. Health document type, image 
     * type.</p>
     */
    public void setHealthDocumentAttachmentCode(ActClaimAttachmentCode healthDocumentAttachmentCode) {
        this.healthDocumentAttachmentCode.setValue(healthDocumentAttachmentCode);
    }


    /**
     * <p>Business Name: Attachment content</p>
     * 
     * <p>Relationship: 
     * FICR_MT600201CA.HealthDocumentAttachment.value</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>To reference a previously submitted attachment, only 
     * require the identifier of the attachment</p>
     * 
     * <p>RxS1: Not permitted, as attachments are not included in 
     * this scenario.</p>
     * 
     * <p>The content of the attachment that is intended either for 
     * human interpretation or further machine processing. i.e. The 
     * image. This includes unformatted or formatted written 
     * language, multimedia data, or structured information in as 
     * defined by a different standard i.e.. Health document 
     * content. Instead of the attachment content this may contain 
     * only a reference to the information that may be located 
     * inline or remote.</p>
     */
    @Hl7XmlMapping({"healthDocumentAttachment/value"})
    public EncapsulatedData getHealthDocumentAttachmentValue() {
        return this.healthDocumentAttachmentValue.getValue();
    }

    /**
     * <p>Business Name: Attachment content</p>
     * 
     * <p>Relationship: 
     * FICR_MT600201CA.HealthDocumentAttachment.value</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>To reference a previously submitted attachment, only 
     * require the identifier of the attachment</p>
     * 
     * <p>RxS1: Not permitted, as attachments are not included in 
     * this scenario.</p>
     * 
     * <p>The content of the attachment that is intended either for 
     * human interpretation or further machine processing. i.e. The 
     * image. This includes unformatted or formatted written 
     * language, multimedia data, or structured information in as 
     * defined by a different standard i.e.. Health document 
     * content. Instead of the attachment content this may contain 
     * only a reference to the information that may be located 
     * inline or remote.</p>
     */
    public void setHealthDocumentAttachmentValue(EncapsulatedData healthDocumentAttachmentValue) {
        this.healthDocumentAttachmentValue.setValue(healthDocumentAttachmentValue);
    }

}
