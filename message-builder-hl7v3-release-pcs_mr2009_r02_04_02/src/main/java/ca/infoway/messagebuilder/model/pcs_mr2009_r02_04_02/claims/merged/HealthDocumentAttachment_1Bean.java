/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.merged;

import ca.infoway.messagebuilder.Code;
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



@Hl7PartTypeMapping({"FICR_MT400001CA.HealthDocumentAttachment","FICR_MT490102CA.HealthDocumentAttachment","FICR_MT490103CA.HealthDocumentAttachment"})
public class HealthDocumentAttachment_1Bean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private II attachmentIdentifier = new IIImpl();
    private CV attachmentType = new CVImpl();
    private ED<EncapsulatedData> attachmentContent = new EDImpl<EncapsulatedData>();


    /**
     * <p>AttachmentIdentifier</p>
     * 
     * <p>Attachment Identifier</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getAttachmentIdentifier() {
        return this.attachmentIdentifier.getValue();
    }
    public void setAttachmentIdentifier(Identifier attachmentIdentifier) {
        this.attachmentIdentifier.setValue(attachmentIdentifier);
    }


    /**
     * <p>AttachmentType</p>
     * 
     * <p>Attachment Type</p>
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
     * <p>Attachment Content</p>
     */
    @Hl7XmlMapping({"text"})
    public EncapsulatedData getAttachmentContent() {
        return this.attachmentContent.getValue();
    }
    public void setAttachmentContent(EncapsulatedData attachmentContent) {
        this.attachmentContent.setValue(attachmentContent);
    }

}
