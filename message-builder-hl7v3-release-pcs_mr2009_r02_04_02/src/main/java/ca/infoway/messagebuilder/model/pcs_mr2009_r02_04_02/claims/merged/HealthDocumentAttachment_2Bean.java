/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.merged;

import java.util.Set;

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



/**
 * <p>FICR_MT600201CA.HealthDocumentAttachment: (no business 
 * name)</p>
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
 * 
 * <p>FICR_MT500201CA.HealthDocumentAttachment: (no business 
 * name)</p>
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
@Hl7PartTypeMapping({"FICR_MT500201CA.HealthDocumentAttachment","FICR_MT600201CA.HealthDocumentAttachment"})
public class HealthDocumentAttachment_2Bean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private SET<II, Identifier> attachmentIdentifier = new SETImpl<II, Identifier>(IIImpl.class);
    private CV attachmentType = new CVImpl();
    private ED<EncapsulatedData> attachmentContent = new EDImpl<EncapsulatedData>();


    /**
     * <p>AttachmentIdentifier</p>
     * 
     * <p>Attachment identifier</p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getAttachmentIdentifier() {
        return this.attachmentIdentifier.rawSet();
    }


    /**
     * <p>AttachmentType</p>
     * 
     * <p>Attachment Type</p>
     * 
     * <p><p>Constrains the type of attachment (document, XRAY, bit 
     * map image, etc.) included to support a healthcare claim. 
     * Vocabulary bound to this domain should be a specification 
     * for the type of document (i.e. WCB First Report of Accident 
     * - Form 8).</p></p>
     */
    @Hl7XmlMapping({"code"})
    public Code getAttachmentType() {
        return (Code) this.attachmentType.getValue();
    }
    public void setAttachmentType(Code attachmentType) {
        this.attachmentType.setValue(attachmentType);
    }


    /**
     * <p>AttachmentContent</p>
     * 
     * <p>Attachment content</p>
     */
    @Hl7XmlMapping({"value"})
    public EncapsulatedData getAttachmentContent() {
        return this.attachmentContent.getValue();
    }
    public void setAttachmentContent(EncapsulatedData attachmentContent) {
        this.attachmentContent.setValue(attachmentContent);
    }

}
