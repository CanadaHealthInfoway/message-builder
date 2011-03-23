package ca.infoway.messagebuilder.model.cerx.consent;

import java.io.Serializable;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.ActInformationCategoryCode;
import ca.infoway.messagebuilder.domainvalue.DiagnosisValue;
import ca.infoway.messagebuilder.domainvalue.MaskableMaterialEntityType;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.IdentifiedPersonBean;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.confidentiality.VeryBasicConfidentiality;

@Hl7PartTypeMapping({ "COMT_MT400001CA.MaskableActType" })
public class MaskableActTypeBean extends MessagePartBean implements Serializable, VeryBasicConfidentiality {

    private static final long serialVersionUID = 2492427712483110663L;

    private II itemToMaskId = new IIImpl();

    private CD infoCode = new CDImpl();

    private CD confidentialityCode = new CDImpl();

    private CD maskableMaterialCode = new CDImpl();

    private IdentifiedPersonBean patient = new IdentifiedPersonBean();

    private CD diagnosisCode = new CDImpl();

    private CD diagnosisValue = new CDImpl();

    @Hl7XmlMapping("id")
    public Identifier getItemToMaskId() {
        return this.itemToMaskId.getValue();
    }

    public void setItemToMaskId(Identifier itemToMaskId) {
        this.itemToMaskId.setValue(itemToMaskId);
    }

    @Hl7XmlMapping("code")
    public ActInformationCategoryCode getInfoCode() {
        return (ActInformationCategoryCode) this.infoCode.getValue();
    }

    public void setInfoCode(ActInformationCategoryCode infoCode) {
        this.infoCode.setValue(infoCode);
    }

    @Hl7XmlMapping("confidentialityCode")
    public x_VeryBasicConfidentialityKind getConfidentialityCode() {
        return (x_VeryBasicConfidentialityKind) this.confidentialityCode.getValue();
    }

    public void setConfidentialityCode(x_VeryBasicConfidentialityKind confidentialityCode) {
        this.confidentialityCode.setValue(confidentialityCode);
    }

    @Hl7XmlMapping("directTarget/role/playingEntityKind/code")
    public MaskableMaterialEntityType getMaskableMaterialCode() {
        return (MaskableMaterialEntityType) this.maskableMaterialCode.getValue();
    }

    public void setMaskableMaterialCode(MaskableMaterialEntityType maskableMaterialCode) {
        this.maskableMaterialCode.setValue(maskableMaterialCode);
    }

    @Hl7XmlMapping("recordTarget/patient")
    public IdentifiedPersonBean getPatient() {
        return patient;
    }

    public void setPatient(IdentifiedPersonBean patient) {
        this.patient = patient;
    }

    @Hl7XmlMapping("reason/diagnosis/code")
    public ActCode getDiagnosisCode() {
        return (ActCode) this.diagnosisCode.getValue();
    }

    public void setDiagnosisCode(ActCode diagnosisCode) {
        this.diagnosisCode.setValue(diagnosisCode);
    }

    @Hl7XmlMapping("reason/diagnosis/value")
    public DiagnosisValue getDiagnosisValue() {
        return (DiagnosisValue) this.diagnosisValue.getValue();
    }

    public void setDiagnosisValue(DiagnosisValue diagnosisValue) {
        this.diagnosisValue.setValue(diagnosisValue);
    }
}
