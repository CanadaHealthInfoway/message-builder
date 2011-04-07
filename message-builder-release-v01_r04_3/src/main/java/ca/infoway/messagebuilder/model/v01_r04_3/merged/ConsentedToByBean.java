/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v01_r04_3.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.x_PhysicalVerbalParticipationMode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.v01_r04_3.common.coct_mt040205ca.ResponsiblePersonBean;
import ca.infoway.messagebuilder.model.v01_r04_3.si.rcmr_mt010001ca.PatientBean;



@Hl7PartTypeMapping({"COCT_MT470000CA.Author","RCMR_MT010001CA.Author"})
public class ConsentedToByBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private CV patientConsentMechanism = new CVImpl();
    private ST keyword = new STImpl();
    private Consenter consenter;


    /**
     * <p>PatientConsentMechanism</p>
     * 
     * <p>Patient Consent Mechanism</p>
     */
    @Hl7XmlMapping({"modeCode"})
    public x_PhysicalVerbalParticipationMode getPatientConsentMechanism() {
        return (x_PhysicalVerbalParticipationMode) this.patientConsentMechanism.getValue();
    }
    public void setPatientConsentMechanism(x_PhysicalVerbalParticipationMode patientConsentMechanism) {
        this.patientConsentMechanism.setValue(patientConsentMechanism);
    }


    /**
     * <p>Keyword</p>
     * 
     * <p>Keyword</p>
     */
    @Hl7XmlMapping({"signatureText"})
    public String getKeyword() {
        return this.keyword.getValue();
    }
    public void setKeyword(String keyword) {
        this.keyword.setValue(keyword);
    }


    @Hl7XmlMapping({"consenter"})
    public Consenter getConsenter() {
        return this.consenter;
    }
    public void setConsenter(Consenter consenter) {
        this.consenter = consenter;
    }

    public PatientBean getConsenterAsPatient() {
        return this.consenter instanceof PatientBean ? (PatientBean) this.consenter : null;
    }
    public boolean hasConsenterAsPatient() {
        return (this.consenter instanceof PatientBean);
    }

    public ResponsiblePersonBean getConsenterAsResponsibleParty() {
        return this.consenter instanceof ResponsiblePersonBean ? (ResponsiblePersonBean) this.consenter : null;
    }
    public boolean hasConsenterAsResponsibleParty() {
        return (this.consenter instanceof ResponsiblePersonBean);
    }

}
