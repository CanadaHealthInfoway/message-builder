/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r02.common.coct_mt120402ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.DiagnosisValue;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Diagnosis Indications</p>
 * 
 * <p><p>Describes diagnosis-related indications</p></p>
 * 
 * <p><p>Allows separation of conditions from symptoms from 
 * other forms of indication.</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT120402CA.ObservationCondition"})
public class DiagnosisIndicationsBean extends MessagePartBean implements Indications {

    private static final long serialVersionUID = 20110407L;
    private CV diagnosisType = new CVImpl();
    private CD diagnosisCode = new CDImpl();


    /**
     * <p>Diagnosis Type</p>
     * 
     * <p><p>Identifies the type of condition described (diagnosis 
     * or indication)</p></p>
     * 
     * <p><p>Identifies this measurement as a type of diagnosis and 
     * is therefore mandatory.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public ActCode getDiagnosisType() {
        return (ActCode) this.diagnosisType.getValue();
    }
    public void setDiagnosisType(ActCode diagnosisType) {
        this.diagnosisType.setValue(diagnosisType);
    }


    /**
     * <p>A:Diagnosis Code</p>
     * 
     * <p><p>A coded form of the diagnosis that is the reason for 
     * the current action.</p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     */
    @Hl7XmlMapping({"value"})
    public DiagnosisValue getDiagnosisCode() {
        return (DiagnosisValue) this.diagnosisCode.getValue();
    }
    public void setDiagnosisCode(DiagnosisValue diagnosisCode) {
        this.diagnosisCode.setValue(diagnosisCode);
    }

}
