/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Set;



@Hl7PartTypeMapping({"PORX_MT060040CA.PriorSupplyRequest","PORX_MT060160CA.PriorCombinedMedicationRequest","PORX_MT060340CA.PriorCombinedMedicationRequest"})
public class ParentPrescriptionBean extends MessagePartBean {

    private static final long serialVersionUID = 20100603L;
    private SET<II, Identifier> previousPrescriptionOrderNumber = new SETImpl<II, Identifier>(IIImpl.class);
    private CV prescriptionType = new CVImpl();

    @Hl7XmlMapping({"id"})
    public Set<Identifier> getPreviousPrescriptionOrderNumber() {
        return this.previousPrescriptionOrderNumber.rawSet();
    }

    @Hl7XmlMapping({"code"})
    public Code getPrescriptionType() {
        return (Code) this.prescriptionType.getValue();
    }
    public void setPrescriptionType(Code prescriptionType) {
        this.prescriptionType.setValue(prescriptionType);
    }

}
