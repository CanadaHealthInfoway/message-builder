package ca.infoway.messagebuilder.model.cerx.immunization;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.marker.HasTargetReference;
import ca.infoway.messagebuilder.model.RecordRequestMessageBean;

@Hl7PartTypeMapping("POIZ_IN010020CA")
public class RecordImmunizationMessageBean extends RecordRequestMessageBean<ImmunizationBean> implements HasTargetReference<ImmunizationBean> {

    private static final long serialVersionUID = 742123649399653362L;

    public ImmunizationBean getTargetReference() {
        return this.getControlActEvent().getRecord();
    }
}
