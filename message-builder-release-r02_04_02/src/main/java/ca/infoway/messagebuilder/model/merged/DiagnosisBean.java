/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.DiagnosisValue;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Diagnosis</p>
 * 
 * <p>COCT_MT290000CA.Diagnosis: Diagnosis</p>
 * 
 * <p><p>Diagnosis</p></p>
 * 
 * <p><p>More than 1 diagnosis may be specified to justify the 
 * performing of a particular service.</p><p>A specific 
 * diagnosis code must always be specified, and may be 
 * supplemented by descriptive text.</p><p>For some services 
 * (e.g. provider's review of a file), the diagnosis may not be 
 * known.</p></p>
 * 
 * <p><p>More than 1 diagnosis may be specified to justify the 
 * performing of a particular service.</p><p>A specific 
 * diagnosis code must always be specified, and may be 
 * supplemented by descriptive text.</p><p>For some services 
 * (e.g. provider's review of a file), the diagnosis may not be 
 * known.</p></p>
 * 
 * <p><p>More than 1 diagnosis may be specified to justify the 
 * performing of a particular service.</p><p>A specific 
 * diagnosis code must always be specified, and may be 
 * supplemented by descriptive text.</p><p>For some services 
 * (e.g. provider's review of a file), the diagnosis may not be 
 * known.</p></p>
 * 
 * <p>COCT_MT490000CA.Diagnosis: Diagnosis</p>
 * 
 * <p><p>Patient Diagnosis</p></p>
 * 
 * <p>COMT_MT400001CA.Diagnosis: Diagnosis</p>
 * 
 * <p><p>Conveys information about a diagnosis to be masked</p></p>
 * 
 * <p><p>Allows masking of items related to a particular 
 * medical condition.</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT290000CA.Diagnosis","COCT_MT490000CA.Diagnosis","COMT_MT400001CA.Diagnosis"})
public class DiagnosisBean extends MessagePartBean {

    private static final long serialVersionUID = 20110127L;
    private CV value = new CVImpl();
    private CV code = new CVImpl();
    private ST diagnosisDescription = new STImpl();


    /**
     * <p>Diagnosis Value</p>
     * 
     * <p><p>Diagnosis Code eg. ICD-10-CA code.</p></p>
     * 
     * <p>B:Diagnosis</p>
     * 
     * <p><p>The diagnosis whose associated records should be 
     * masked.</p></p>
     * 
     * <p><p>Allows masking of all records (prescriptions, 
     * dispenses, encounters, lab tests, etc.) associated with the 
     * specified diagnosis. This element is optional because it is 
     * not used for SNOMED.</p></p>
     * 
     * <p>Diagnosis Value</p>
     * 
     * <p><p>coded Value denoting diagnosis</p></p>
     */
    @Hl7XmlMapping({"value"})
    public DiagnosisValue getValue() {
        return (DiagnosisValue) this.value.getValue();
    }
    public void setValue(DiagnosisValue value) {
        this.value.setValue(value);
    }


    /**
     * <p>A:Diagnosis Type</p>
     * 
     * <p><p>If code is SNOMED, value must not be specified. 
     * Otherwise value is mandatory and code must be '''DX'''</p></p>
     * 
     * <p><p>Used to indicate that this observation is a diagnosis, 
     * and for SNOMED, provides details of what the diagnosis 
     * is.</p></p>
     * 
     * <p><p>Needed to convey the diagnosis information to be 
     * masked, and attribute is therefore mandatory.</p></p>
     * 
     * <p>Diagnosis type</p>
     * 
     * <p><p>admit, intermediate, discharge diagnosis</p></p>
     * 
     * <p>Diagnosis Code</p>
     * 
     * <p><p>ObservationDiagnosis Type</p></p>
     */
    @Hl7XmlMapping({"code"})
    public ActCode getCode() {
        return (ActCode) this.code.getValue();
    }
    public void setCode(ActCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>DiagnosisDescription</p>
     * 
     * <p>Diagnosis Description</p>
     * 
     * <p><p>Can be used to supplement a diagnostic code</p></p>
     * 
     * <p><p>Can be used to supplement a diagnostic code</p></p>
     */
    @Hl7XmlMapping({"text"})
    public String getDiagnosisDescription() {
        return this.diagnosisDescription.getValue();
    }
    public void setDiagnosisDescription(String diagnosisDescription) {
        this.diagnosisDescription.setValue(diagnosisDescription);
    }

}
