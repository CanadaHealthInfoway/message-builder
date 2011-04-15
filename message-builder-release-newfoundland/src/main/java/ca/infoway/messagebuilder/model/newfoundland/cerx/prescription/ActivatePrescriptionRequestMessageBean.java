package ca.infoway.messagebuilder.model.newfoundland.cerx.prescription;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.RecordRequestMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.medicationprofile.CombinedMedication1Bean;
import ca.infoway.messagebuilder.model.newfoundland.marker.HasTargetReference;

@Hl7PartTypeMapping("PORX_IN010380CA")
public class ActivatePrescriptionRequestMessageBean extends RecordRequestMessageBean<CombinedMedication1Bean> implements HasTargetReference<ActivatePrescriptionRequestMessageBean> {

    private static final long serialVersionUID = -7173172616406134937L;

    public ActivatePrescriptionRequestMessageBean getTargetReference() {
        return this;
    }
}
