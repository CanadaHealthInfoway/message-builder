/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.si.comt_mt301001ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.merged.Patient_1Bean;



/**
 * <p>annotates</p>
 * 
 * <p>Indicates the particular record to which the annotation 
 * applies.</p>
 * 
 * <p>Ensures the annotation is connected to the correct 
 * record, and therefore mandatory.</p>
 */
@Hl7PartTypeMapping({"COMT_MT301001CA.Subject"})
public class AnnotatesBean extends MessagePartBean {

    private static final long serialVersionUID = 20100614L;
    private II recordId = new IIImpl();
    private Patient_1Bean annotatedActSubjectPatient;

    @Hl7XmlMapping({"annotatedAct/id"})
    public Identifier getRecordId() {
        return this.recordId.getValue();
    }
    public void setRecordId(Identifier recordId) {
        this.recordId.setValue(recordId);
    }

    @Hl7XmlMapping({"annotatedAct/subject/patient"})
    public Patient_1Bean getAnnotatedActSubjectPatient() {
        return this.annotatedActSubjectPatient;
    }
    public void setAnnotatedActSubjectPatient(Patient_1Bean annotatedActSubjectPatient) {
        this.annotatedActSubjectPatient = annotatedActSubjectPatient;
    }

}
