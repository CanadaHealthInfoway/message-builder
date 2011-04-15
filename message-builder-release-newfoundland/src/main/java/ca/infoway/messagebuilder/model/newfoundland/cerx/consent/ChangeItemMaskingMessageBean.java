package ca.infoway.messagebuilder.model.newfoundland.cerx.consent;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.RecordRequestMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.marker.HasTargetReference;

@Hl7PartTypeMapping("COMT_IN400001CA")
public class ChangeItemMaskingMessageBean extends RecordRequestMessageBean<MaskableActTypeBean> implements HasTargetReference<MaskableActTypeBean> {

    private static final long serialVersionUID = 742123649399653362L;

    public MaskableActTypeBean getTargetReference() {
        return this.getControlActEvent().getRecord();
    }
}
