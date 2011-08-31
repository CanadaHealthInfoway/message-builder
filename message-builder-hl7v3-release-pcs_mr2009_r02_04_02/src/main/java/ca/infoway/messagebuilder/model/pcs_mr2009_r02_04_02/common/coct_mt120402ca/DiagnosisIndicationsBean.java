/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt120402ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Diagnosis Indications</p>
 * 
 * <p><p>Describes diagnosis-related indications</p></p>
 * 
 * <p><p>Allows separation of conditions from symptoms from 
 * other forms of indication.</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT120402CA.ObservationProblem"})
public class DiagnosisIndicationsBean extends MessagePartBean implements Indications {

    private static final long serialVersionUID = 20110831L;
    private CV problemType = new CVImpl();
    private CD problemCode = new CDImpl();


    /**
     * <p>Problem Type</p>
     * 
     * <p><p>Identifies the type of problem described.</p></p>
     * 
     * <p><p>Identifies this measurement as a type of diagnosis and 
     * is therefore mandatory.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public Code getProblemType() {
        return (Code) this.problemType.getValue();
    }
    public void setProblemType(Code problemType) {
        this.problemType.setValue(problemType);
    }


    /**
     * <p>A:Problem Code</p>
     * 
     * <p><p>A coded form of the problem that is the reason for the 
     * current action.</p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     */
    @Hl7XmlMapping({"value"})
    public Code getProblemCode() {
        return (Code) this.problemCode.getValue();
    }
    public void setProblemCode(Code problemCode) {
        this.problemCode.setValue(problemCode);
    }

}
