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
package ca.infoway.messagebuilder.model.ab_r02_05_00_pa.claims.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedData;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.domainvalue.ActClaimAttachmentCode;



@Hl7PartTypeMapping({"FICR_MT400001CA.HealthDocumentAttachment","FICR_MT490102CA.HealthDocumentAttachment","FICR_MT490103CA.HealthDocumentAttachment"})
public class HealthDocumentAttachment_1Bean extends MessagePartBean {

    private static final long serialVersionUID = 20140501L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private ED<EncapsulatedData> text = new EDImpl<EncapsulatedData>();


    /**
     * <p>Business Name: AttachmentIdentifier</p>
     * 
     * <p>Un-merged Business Name: AttachmentIdentifier</p>
     * 
     * <p>Relationship: FICR_MT490103CA.HealthDocumentAttachment.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: AttachmentIdentifier</p>
     * 
     * <p>Relationship: FICR_MT490102CA.HealthDocumentAttachment.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: AttachmentIdentifier</p>
     * 
     * <p>Relationship: FICR_MT400001CA.HealthDocumentAttachment.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: AttachmentIdentifier</p>
     * 
     * <p>Un-merged Business Name: AttachmentIdentifier</p>
     * 
     * <p>Relationship: FICR_MT490103CA.HealthDocumentAttachment.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: AttachmentIdentifier</p>
     * 
     * <p>Relationship: FICR_MT490102CA.HealthDocumentAttachment.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: AttachmentIdentifier</p>
     * 
     * <p>Relationship: FICR_MT400001CA.HealthDocumentAttachment.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: AttachmentType</p>
     * 
     * <p>Un-merged Business Name: AttachmentType</p>
     * 
     * <p>Relationship: 
     * FICR_MT490103CA.HealthDocumentAttachment.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Constrains the type of attachment (document, XRAY, bit 
     * map image, etc.) included to support a healthcare claim. 
     * Vocabulary bound to this domain should be a specification 
     * for the type of document (i.e. WCB First Report of Accident 
     * - Form 8).</p>
     * 
     * <p>Un-merged Business Name: AttachmentType</p>
     * 
     * <p>Relationship: 
     * FICR_MT490102CA.HealthDocumentAttachment.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: AttachmentType</p>
     * 
     * <p>Relationship: 
     * FICR_MT400001CA.HealthDocumentAttachment.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Constrains the type of attachment (document, XRAY, bit 
     * map image, etc.) included to support a healthcare claim. 
     * Vocabulary bound to this domain should be a specification 
     * for the type of document (i.e. WCB First Report of Accident 
     * - Form 8).</p>
     */
    @Hl7XmlMapping({"code"})
    public ActClaimAttachmentCode getCode() {
        return (ActClaimAttachmentCode) this.code.getValue();
    }

    /**
     * <p>Business Name: AttachmentType</p>
     * 
     * <p>Un-merged Business Name: AttachmentType</p>
     * 
     * <p>Relationship: 
     * FICR_MT490103CA.HealthDocumentAttachment.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Constrains the type of attachment (document, XRAY, bit 
     * map image, etc.) included to support a healthcare claim. 
     * Vocabulary bound to this domain should be a specification 
     * for the type of document (i.e. WCB First Report of Accident 
     * - Form 8).</p>
     * 
     * <p>Un-merged Business Name: AttachmentType</p>
     * 
     * <p>Relationship: 
     * FICR_MT490102CA.HealthDocumentAttachment.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: AttachmentType</p>
     * 
     * <p>Relationship: 
     * FICR_MT400001CA.HealthDocumentAttachment.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Constrains the type of attachment (document, XRAY, bit 
     * map image, etc.) included to support a healthcare claim. 
     * Vocabulary bound to this domain should be a specification 
     * for the type of document (i.e. WCB First Report of Accident 
     * - Form 8).</p>
     */
    public void setCode(ActClaimAttachmentCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: AttachmentContent</p>
     * 
     * <p>Un-merged Business Name: AttachmentContent</p>
     * 
     * <p>Relationship: 
     * FICR_MT490103CA.HealthDocumentAttachment.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: AttachmentContent</p>
     * 
     * <p>Relationship: 
     * FICR_MT490102CA.HealthDocumentAttachment.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: AttachmentContent</p>
     * 
     * <p>Relationship: 
     * FICR_MT400001CA.HealthDocumentAttachment.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"text"})
    public EncapsulatedData getText() {
        return this.text.getValue();
    }

    /**
     * <p>Business Name: AttachmentContent</p>
     * 
     * <p>Un-merged Business Name: AttachmentContent</p>
     * 
     * <p>Relationship: 
     * FICR_MT490103CA.HealthDocumentAttachment.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: AttachmentContent</p>
     * 
     * <p>Relationship: 
     * FICR_MT490102CA.HealthDocumentAttachment.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: AttachmentContent</p>
     * 
     * <p>Relationship: 
     * FICR_MT400001CA.HealthDocumentAttachment.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setText(EncapsulatedData text) {
        this.text.setValue(text);
    }

}
