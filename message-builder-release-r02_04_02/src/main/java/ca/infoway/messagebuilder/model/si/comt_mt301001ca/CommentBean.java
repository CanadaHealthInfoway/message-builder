/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.si.comt_mt301001ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.HumanLanguage;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Comment</p>
 * 
 * <p>Identifies the comments to be recorded against a 
 * Patient's record.</p>
 * 
 * <p>Allows comments to be attached to a Patient record. A 
 * Patient record can pertain to demographic or clinical (Drug, 
 * Condition, Lab, DI, etc) information.</p>
 */
@Hl7PartTypeMapping({"COMT_MT301001CA.Annotation"})
@Hl7RootType
public class CommentBean extends MessagePartBean {

    private static final long serialVersionUID = 20100603L;
    private ST annotationText = new STImpl();
    private CV writtenIn = new CVImpl();
    private II recordId = new IIImpl();

    @Hl7XmlMapping({"text"})
    public String getAnnotationText() {
        return this.annotationText.getValue();
    }
    public void setAnnotationText(String annotationText) {
        this.annotationText.setValue(annotationText);
    }

    @Hl7XmlMapping({"languageCode"})
    public HumanLanguage getWrittenIn() {
        return (HumanLanguage) this.writtenIn.getValue();
    }
    public void setWrittenIn(HumanLanguage writtenIn) {
        this.writtenIn.setValue(writtenIn);
    }

    @Hl7XmlMapping({"subject/annotatedAct/id"})
    public Identifier getRecordId() {
        return this.recordId.getValue();
    }
    public void setRecordId(Identifier recordId) {
        this.recordId.setValue(recordId);
    }

}
