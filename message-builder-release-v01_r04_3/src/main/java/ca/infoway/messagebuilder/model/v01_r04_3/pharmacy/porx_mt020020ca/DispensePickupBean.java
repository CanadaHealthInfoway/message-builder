/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v01_r04_3.pharmacy.porx_mt020020ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.v01_r04_3.common.coct_mt040205ca.ResponsiblePersonBean;
import ca.infoway.messagebuilder.model.v01_r04_3.common.merged.PatientBean;



@Hl7PartTypeMapping({"PORX_MT020020CA.SupplyEvent"})
@Hl7RootType
public class DispensePickupBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private ResponsiblePersonBean receiverResponsibleParty;
    private PatientBean subjectPatient;
    private II dispenseId = new IIImpl();


    @Hl7XmlMapping({"receiver/responsibleParty"})
    public ResponsiblePersonBean getReceiverResponsibleParty() {
        return this.receiverResponsibleParty;
    }
    public void setReceiverResponsibleParty(ResponsiblePersonBean receiverResponsibleParty) {
        this.receiverResponsibleParty = receiverResponsibleParty;
    }


    @Hl7XmlMapping({"subject/patient"})
    public PatientBean getSubjectPatient() {
        return this.subjectPatient;
    }
    public void setSubjectPatient(PatientBean subjectPatient) {
        this.subjectPatient = subjectPatient;
    }


    /**
     * <p>Dispense Id</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getDispenseId() {
        return this.dispenseId.getValue();
    }
    public void setDispenseId(Identifier dispenseId) {
        this.dispenseId.setValue(dispenseId);
    }

}