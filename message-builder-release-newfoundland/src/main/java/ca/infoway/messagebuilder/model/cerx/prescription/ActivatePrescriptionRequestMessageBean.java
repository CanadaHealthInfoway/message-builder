package ca.infoway.messagebuilder.model.cerx.prescription;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.marker.HasTargetReference;
import ca.infoway.messagebuilder.model.RecordRequestMessageBean;
import ca.infoway.messagebuilder.model.cerx.medicationprofile.CombinedMedication1Bean;

@Hl7PartTypeMapping("PORX_IN010380CA")
public class ActivatePrescriptionRequestMessageBean extends RecordRequestMessageBean<CombinedMedication1Bean> implements HasTargetReference<ActivatePrescriptionRequestMessageBean> {

    private static final long serialVersionUID = -7173172616406134937L;

    public ActivatePrescriptionRequestMessageBean getTargetReference() {
        return this;
    }
}
