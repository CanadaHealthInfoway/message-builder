package ca.infoway.messagebuilder.model.cerx.supply;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.marker.HasTargetReference;
import ca.infoway.messagebuilder.model.RecordRequestMessageBean;

@Hl7PartTypeMapping("PORX_IN020210CA")
public class RecordSupplyEventMessageBean extends RecordRequestMessageBean<NonPrescribedSupplyEventBean> implements HasTargetReference<RecordSupplyEventMessageBean> {

    private static final long serialVersionUID = 3043177403712593048L;

    public RecordSupplyEventMessageBean getTargetReference() {
        return this;
    }
}
