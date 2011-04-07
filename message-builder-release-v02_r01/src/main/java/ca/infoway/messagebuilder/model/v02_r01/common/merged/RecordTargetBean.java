/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r01.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.domainvalue.ParticipationType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.v02_r01.common.coct_mt050202ca.PatientBean;



@Hl7PartTypeMapping({"MCAI_MT700210CA.RecordTarget","MCAI_MT700211CA.RecordTarget","MCAI_MT700216CA.RecordTarget","MCAI_MT700217CA.RecordTarget","MCAI_MT700220CA.RecordTarget","MCAI_MT700221CA.RecordTarget","MCAI_MT700226CA.RecordTarget","MCAI_MT700227CA.RecordTarget","MCAI_MT700230CA.RecordTarget","MCAI_MT700231CA.RecordTarget","MCAI_MT700236CA.RecordTarget","MCAI_MT700237CA.RecordTarget","QUQI_MT020000CA.RecordTarget","QUQI_MT120006CA.RecordTarget"})
public class RecordTargetBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private CS typeCode = new CSImpl();
    private Patient_2 patient1;


    @Hl7XmlMapping({"typeCode"})
    public ParticipationType getTypeCode() {
        return (ParticipationType) this.typeCode.getValue();
    }
    public void setTypeCode(ParticipationType typeCode) {
        this.typeCode.setValue(typeCode);
    }


    @Hl7XmlMapping({"patient1"})
    public Patient_2 getPatient1() {
        return this.patient1;
    }
    public void setPatient1(Patient_2 patient1) {
        this.patient1 = patient1;
    }

    public PatientBean getPatient1AsPatient1() {
        return this.patient1 instanceof PatientBean ? (PatientBean) this.patient1 : null;
    }
    public boolean hasPatient1AsPatient1() {
        return (this.patient1 instanceof PatientBean);
    }

    public Patient_1Bean getPatient1AsPatient2() {
        return this.patient1 instanceof Patient_1Bean ? (Patient_1Bean) this.patient1 : null;
    }
    public boolean hasPatient1AsPatient2() {
        return (this.patient1 instanceof Patient_1Bean);
    }

    public ca.infoway.messagebuilder.model.v02_r01.common.coct_mt050201ca.PatientBean getPatient1AsPatient3() {
        return this.patient1 instanceof ca.infoway.messagebuilder.model.v02_r01.common.coct_mt050201ca.PatientBean ? (ca.infoway.messagebuilder.model.v02_r01.common.coct_mt050201ca.PatientBean) this.patient1 : null;
    }
    public boolean hasPatient1AsPatient3() {
        return (this.patient1 instanceof ca.infoway.messagebuilder.model.v02_r01.common.coct_mt050201ca.PatientBean);
    }

}
