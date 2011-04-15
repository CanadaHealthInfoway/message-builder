package ca.infoway.messagebuilder.model.newfoundland.cerx.dispensepickup;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.RecordRequestMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.SupplyEventBean;
import ca.infoway.messagebuilder.model.newfoundland.marker.HasTargetReference;

@Hl7PartTypeMapping("PORX_IN020080CA")
public class RecordDispensePickupMessageBean extends RecordRequestMessageBean<SupplyEventBean> implements HasTargetReference<SupplyEventBean> {

    private static final long serialVersionUID = 8292898501823857922L;

    public SupplyEventBean getTargetReference() {
        return this.getRecord();
    }
}
