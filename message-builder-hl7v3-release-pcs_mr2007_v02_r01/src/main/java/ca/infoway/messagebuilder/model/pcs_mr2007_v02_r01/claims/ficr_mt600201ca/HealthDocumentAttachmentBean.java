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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.claims.ficr_mt600201ca;

import ca.infoway.messagebuilder.Code;
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
import java.util.Set;



/**
 * <p>Health Document Attachment</p>
 * 
 * <p><p>Used to attach documents, image, etc.</p><p>required 
 * to support a health claim.</p><p>Value is not mandatory to 
 * allow for case where just a reference to an existing 
 * attachment is required.</p></p>
 * 
 * <p><p>Used to attach documents, image, etc.</p><p>required 
 * to support a health claim.</p><p>Value is not mandatory to 
 * allow for case where just a reference to an existing 
 * attachment is required.</p></p>
 * 
 * <p><p>Used to attach documents, image, etc.</p><p>required 
 * to support a health claim.</p><p>Value is not mandatory to 
 * allow for case where just a reference to an existing 
 * attachment is required.</p></p>
 */
@Hl7PartTypeMapping({"FICR_MT600201CA.HealthDocumentAttachment"})
public class HealthDocumentAttachmentBean extends MessagePartBean {

    private static final long serialVersionUID = 20120215L;
    private SET<II, Identifier> id = new SETImpl<II, Identifier>(IIImpl.class);
    private CV code = new CVImpl();
    private ED<EncapsulatedData> value = new EDImpl<EncapsulatedData>();


    /**
     * <p>Attachment identifier</p>
     * 
     * <p><p>Set of identifiers that uniquely identify the 
     * Attachment.</p></p>
     * 
     * <p><p>RxS1: Not permitted, as attachments are not included 
     * in this scenario</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getId() {
        return this.id.rawSet();
    }


    /**
     * <p>Attachment Type</p>
     * 
     * <p><p>The type of attachment. I.e.. Health document type, 
     * image type.</p></p>
     * 
     * <p><p>Domain has not been defined for attachment types. 
     * RxS1: Not permitted, as attachments are not included in this 
     * scenario.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public Code getCode() {
        return (Code) this.code.getValue();
    }
    public void setCode(Code code) {
        this.code.setValue(code);
    }


    /**
     * <p>Attachment content</p>
     * 
     * <p><p>The content of the attachment that is intended either 
     * for human interpretation or further machine processing. i.e. 
     * The image. This includes unformatted or formatted written 
     * language, multimedia data, or structured information in as 
     * defined by a different standard i.e.. Health document 
     * content. Instead of the attachment content this may contain 
     * only a reference to the information that may be located 
     * inline or remote.</p></p>
     * 
     * <p><p>To reference a previously submitted attachment, only 
     * require the identifier of the attachment</p></p>
     * 
     * <p><p>RxS1: Not permitted, as attachments are not included 
     * in this scenario.</p></p>
     */
    @Hl7XmlMapping({"value"})
    public EncapsulatedData getValue() {
        return this.value.getValue();
    }
    public void setValue(EncapsulatedData value) {
        this.value.setValue(value);
    }

}
