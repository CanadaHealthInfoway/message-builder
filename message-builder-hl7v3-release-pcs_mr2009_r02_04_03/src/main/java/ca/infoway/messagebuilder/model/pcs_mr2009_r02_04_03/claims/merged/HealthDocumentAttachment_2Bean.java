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
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedData;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.domainvalue.ActClaimAttachmentCode;
import java.util.Set;



/**
 * <p>FICR_MT600201CA.HealthDocumentAttachment: (no business 
 * name)</p>
 * 
 * <p>Used to attach documents, image, etc.</p><p>required to 
 * support a health claim.</p><p>Value is not mandatory to 
 * allow for case where just a reference to an existing 
 * attachment is required.</p>
 * 
 * <p>FICR_MT500201CA.HealthDocumentAttachment: (no business 
 * name)</p>
 * 
 * <p>Used to attach documents, image, etc.</p><p>required to 
 * support a health claim.</p><p>Value is not mandatory to 
 * allow for case where just a reference to an existing 
 * attachment is required.</p>
 */
@Hl7PartTypeMapping({"FICR_MT500201CA.HealthDocumentAttachment","FICR_MT600201CA.HealthDocumentAttachment"})
public class HealthDocumentAttachment_2Bean extends MessagePartBean {

    private static final long serialVersionUID = 20130613L;
    private SET<II, Identifier> id = new SETImpl<II, Identifier>(IIImpl.class);
    private CV code = new CVImpl();
    private ED<EncapsulatedData> value = new EDImpl<EncapsulatedData>();


    /**
     * <p>Business Name: AttachmentIdentifier</p>
     * 
     * <p>Un-merged Business Name: AttachmentIdentifier</p>
     * 
     * <p>Relationship: FICR_MT600201CA.HealthDocumentAttachment.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1-5)</p>
     * 
     * <p>Un-merged Business Name: AttachmentIdentifier</p>
     * 
     * <p>Relationship: FICR_MT500201CA.HealthDocumentAttachment.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1-5)</p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getId() {
        return this.id.rawSet();
    }


    /**
     * <p>Business Name: AttachmentType</p>
     * 
     * <p>Un-merged Business Name: AttachmentType</p>
     * 
     * <p>Relationship: 
     * FICR_MT600201CA.HealthDocumentAttachment.code</p>
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
     * FICR_MT500201CA.HealthDocumentAttachment.code</p>
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
     * FICR_MT600201CA.HealthDocumentAttachment.code</p>
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
     * FICR_MT500201CA.HealthDocumentAttachment.code</p>
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
     * FICR_MT600201CA.HealthDocumentAttachment.value</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: AttachmentContent</p>
     * 
     * <p>Relationship: 
     * FICR_MT500201CA.HealthDocumentAttachment.value</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"value"})
    public EncapsulatedData getValue() {
        return this.value.getValue();
    }

    /**
     * <p>Business Name: AttachmentContent</p>
     * 
     * <p>Un-merged Business Name: AttachmentContent</p>
     * 
     * <p>Relationship: 
     * FICR_MT600201CA.HealthDocumentAttachment.value</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: AttachmentContent</p>
     * 
     * <p>Relationship: 
     * FICR_MT500201CA.HealthDocumentAttachment.value</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setValue(EncapsulatedData value) {
        this.value.setValue(value);
    }

}
