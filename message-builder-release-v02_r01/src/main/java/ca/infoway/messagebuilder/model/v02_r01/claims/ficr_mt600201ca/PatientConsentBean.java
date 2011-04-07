/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r01.claims.ficr_mt600201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"FICR_MT600201CA.Subject"})
public class PatientConsentBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private ST patientKeyword = new STImpl();
    private BL patientConsent = new BLImpl(false);


    /**
     * <p>Patient Keyword</p>
     */
    @Hl7XmlMapping({"signatureText"})
    public String getPatientKeyword() {
        return this.patientKeyword.getValue();
    }
    public void setPatientKeyword(String patientKeyword) {
        this.patientKeyword.setValue(patientKeyword);
    }


    @Hl7XmlMapping({"patientConsent"})
    public Boolean getPatientConsent() {
        return this.patientConsent.getValue();
    }
    public void setPatientConsent(Boolean patientConsent) {
        this.patientConsent.setValue(patientConsent);
    }

}
