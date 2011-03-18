/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v01_r04_3.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.domainvalue.ParticipationMode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.v01_r04_3.common.coct_mt090107ca.ProviderBean;
import java.util.Date;



@Hl7PartTypeMapping({"PORX_MT060040CA.Author4","PORX_MT060160CA.Author4","PORX_MT060340CA.Author4"})
public class PrescribedByBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private ProviderBean assignedPerson;
    private TS prescribedDate = new TSImpl();
    private CV prescriptionTransmissionMethod = new CVImpl();
    private ED<String> signature = new EDImpl<String>();


    @Hl7XmlMapping({"assignedPerson"})
    public ProviderBean getAssignedPerson() {
        return this.assignedPerson;
    }
    public void setAssignedPerson(ProviderBean assignedPerson) {
        this.assignedPerson = assignedPerson;
    }


    /**
     * <p>PrescribedDate</p>
     * 
     * <p>Prescribed Date</p>
     */
    @Hl7XmlMapping({"time"})
    public Date getPrescribedDate() {
        return this.prescribedDate.getValue();
    }
    public void setPrescribedDate(Date prescribedDate) {
        this.prescribedDate.setValue(prescribedDate);
    }


    /**
     * <p>PrescriptionTransmissionMethod</p>
     * 
     * <p>Prescription Transmission Method</p>
     */
    @Hl7XmlMapping({"modeCode"})
    public ParticipationMode getPrescriptionTransmissionMethod() {
        return (ParticipationMode) this.prescriptionTransmissionMethod.getValue();
    }
    public void setPrescriptionTransmissionMethod(ParticipationMode prescriptionTransmissionMethod) {
        this.prescriptionTransmissionMethod.setValue(prescriptionTransmissionMethod);
    }


    /**
     * <p>Signature</p>
     * 
     * <p>Signature</p>
     */
    @Hl7XmlMapping({"signatureText"})
    public String getSignature() {
        return this.signature.getValue();
    }
    public void setSignature(String signature) {
        this.signature.setValue(signature);
    }

}
