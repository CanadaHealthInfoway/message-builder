package ca.infoway.messagebuilder.model.cerx.consent;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.marker.HasTargetReference;
import ca.infoway.messagebuilder.model.RecordRequestMessageBean;

@Hl7PartTypeMapping("COMT_IN400001CA")
public class ChangeItemMaskingMessageBean extends RecordRequestMessageBean<MaskableActTypeBean> implements HasTargetReference<MaskableActTypeBean> {

    private static final long serialVersionUID = 742123649399653362L;

    public MaskableActTypeBean getTargetReference() {
        return this.getControlActEvent().getRecord();
    }
}
