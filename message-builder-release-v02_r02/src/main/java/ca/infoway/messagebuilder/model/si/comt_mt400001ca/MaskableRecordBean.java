/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.si.comt_mt400001ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActInformationCategoryCode;
import ca.infoway.messagebuilder.domainvalue.x_NormalRestrictedTabooConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Set;



/**
 * <p>Maskable Record</p>
 * 
 * <p><p>A particular record or type of record for which 
 * masking is supported.</p></p>
 * 
 * <p><p>The root construct for masking and unmasking specific 
 * record or type of record.</p></p>
 */
@Hl7PartTypeMapping({"COMT_MT400001CA.MaskableActType"})
@Hl7RootType
public class MaskableRecordBean extends MessagePartBean {

    private static final long serialVersionUID = 20110127L;
    private RoleBean directTargetRole;
    private II recordIdentifier = new IIImpl();
    private SET<CV, Code> maskedIndicator = new SETImpl<CV, Code>(CVImpl.class);
    private CV recordType = new CVImpl();
    private DiagnosisBean reasonDiagnosis;


    @Hl7XmlMapping({"directTarget/role"})
    public RoleBean getDirectTargetRole() {
        return this.directTargetRole;
    }
    public void setDirectTargetRole(RoleBean directTargetRole) {
        this.directTargetRole = directTargetRole;
    }


    /**
     * <p>C:Record Identifier</p>
     * 
     * <p><p>The identifier of the prescription, dispense, allergy, 
     * lab test result or other record for which the masking status 
     * is being changed.</p></p>
     * 
     * <p><p>Allows unique reference to a particular record to be 
     * masked or unmasked.</p></p>
     * 
     * <p><p>In many systems, masking a 'child' may result in 
     * automatic masking of the parent. For example, masking a 
     * dispense record may cause the prescription to become masked 
     * as well.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getRecordIdentifier() {
        return this.recordIdentifier.getValue();
    }
    public void setRecordIdentifier(Identifier recordIdentifier) {
        this.recordIdentifier.setValue(recordIdentifier);
    }


    /**
     * <p>A:Masked Indicator</p>
     * 
     * <p><p>Indicates the new value for the masking status of the 
     * item.</p></p>
     * 
     * <p><p>Forces the sender of the message to assert what the 
     * new value should be, rather than performing a 'toggle' and 
     * potentially ending up in the wrong state. Therefore, the 
     * attribute is mandatory.</p></p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_NormalRestrictedTabooConfidentialityKind> getMaskedIndicator() {
        return this.maskedIndicator.rawSet(x_NormalRestrictedTabooConfidentialityKind.class);
    }


    /**
     * <p>B:Record Type</p>
     * 
     * <p><p>Indicates a detailed type of record to be masked. E.g. 
     * All lab tests of a given type.</p></p>
     * 
     * <p><p>Allows automatic masking of a particular type of 
     * record rather than requiring each occurrence to be masked 
     * individually.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public ActInformationCategoryCode getRecordType() {
        return (ActInformationCategoryCode) this.recordType.getValue();
    }
    public void setRecordType(ActInformationCategoryCode recordType) {
        this.recordType.setValue(recordType);
    }


    @Hl7XmlMapping({"reason/diagnosis"})
    public DiagnosisBean getReasonDiagnosis() {
        return this.reasonDiagnosis;
    }
    public void setReasonDiagnosis(DiagnosisBean reasonDiagnosis) {
        this.reasonDiagnosis = reasonDiagnosis;
    }

}
