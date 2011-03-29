/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.r02_04_02.merged.DiagnosisBean;



@Hl7PartTypeMapping({"COCT_MT290000CA.DiagnosisInformation","COCT_MT490000CA.DiagnosisInformation"})
public class DiagnosisInformationBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private INT diagnosisPriority = new INTImpl();
    private DiagnosisBean diagnosis;


    /**
     * <p>DiagnosisPriority</p>
     * 
     * <p>Diagnosis Priority</p>
     * 
     * <p><p>1 = Primary, 2 = Secondary, etc.</p></p>
     * 
     * <p><p>1=Primary, 2=Secondary, etc.</p></p>
     * 
     * <p>Diagnosis Priority</p>
     * 
     * <p><p>1=Primary, 2=Secondary, etc.</p></p>
     */
    @Hl7XmlMapping({"sequenceNumber"})
    public Integer getDiagnosisPriority() {
        return this.diagnosisPriority.getValue();
    }
    public void setDiagnosisPriority(Integer diagnosisPriority) {
        this.diagnosisPriority.setValue(diagnosisPriority);
    }


    @Hl7XmlMapping({"diagnosis"})
    public DiagnosisBean getDiagnosis() {
        return this.diagnosis;
    }
    public void setDiagnosis(DiagnosisBean diagnosis) {
        this.diagnosis = diagnosis;
    }

}