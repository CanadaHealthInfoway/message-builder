package ca.infoway.messagebuilder.model.cerx.immunization;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.marker.HasTargetReference;
import ca.infoway.messagebuilder.model.ActEventBean;
import ca.infoway.messagebuilder.model.RecordRequestMessageBean;

@Hl7PartTypeMapping("POIZ_IN010100CA")
public class RetractImmunizationMessageBean extends RecordRequestMessageBean<ActEventBean> implements HasTargetReference<ActEventBean> {

    private static final long serialVersionUID = 742123649399653362L;

    public ActEventBean getTargetReference() {
        return this.getControlActEvent().getRecord();
    }
}
