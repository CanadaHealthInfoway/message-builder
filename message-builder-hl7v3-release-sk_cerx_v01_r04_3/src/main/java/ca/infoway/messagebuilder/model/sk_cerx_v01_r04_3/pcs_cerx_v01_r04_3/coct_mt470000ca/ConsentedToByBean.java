/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.coct_mt470000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.domainvalue.x_PhysicalVerbalParticipationMode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.coct_mt040205ca.ResponsiblePersonBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.merged.Consenter;



/**
 * <p>b:consented to by</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
 * that the consent was provided by the patient or 
 * representative.</p></p>
 * 
 * <p><p 
 * xmlns:html="http://www.w3.org/1999/xhtml">Authorization.Person</p><p 
 * xmlns:html="http://www.w3.org/1999/xhtml">Authorization.signatory(PT)</p></p>
 * 
 * <p><p 
 * xmlns:html="http://www.w3.org/1999/xhtml">Authorization.Person</p><p 
 * xmlns:html="http://www.w3.org/1999/xhtml">Authorization.signatory(PT)</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Consent can 
 * be provided by the patient or representative or the 
 * provider.</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT470000CA.Author"})
public class ConsentedToByBean extends MessagePartBean {

    private static final long serialVersionUID = 20110621L;
    private CV patientConsentMechanism = new CVImpl();
    private ED<String> keyword = new EDImpl<String>();
    private Consenter consenter;


    /**
     * <p>Patient Consent Mechanism</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * whether the patient's consent is written or verbal.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Verbal 
     * consents may trigger a higher level of auditing.</p></p>
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
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * the keyword appropriate to the action being performed by the 
     * message.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows 
     * providers who know the keyword to access information 
     * protected by patient keywords.</p></p>
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

    public ConsentByPatientBean getConsenterAsPatient() {
        return this.consenter instanceof ConsentByPatientBean ? (ConsentByPatientBean) this.consenter : null;
    }
    public boolean hasConsenterAsPatient() {
        return (this.consenter instanceof ConsentByPatientBean);
    }

    public ResponsiblePersonBean getConsenterAsResponsibleParty() {
        return this.consenter instanceof ResponsiblePersonBean ? (ResponsiblePersonBean) this.consenter : null;
    }
    public boolean hasConsenterAsResponsibleParty() {
        return (this.consenter instanceof ResponsiblePersonBean);
    }

}
