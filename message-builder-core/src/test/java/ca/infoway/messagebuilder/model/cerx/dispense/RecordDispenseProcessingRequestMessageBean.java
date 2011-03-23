package ca.infoway.messagebuilder.model.cerx.dispense;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;

@Hl7PartTypeMapping("PORX_IN020190CA")
public class RecordDispenseProcessingRequestMessageBean implements InteractionBean {

    private static final long serialVersionUID = -6285495099388770893L;

    public RecordDispenseProcessingRequestMessageBean getTargetReference() {
        return this;
    }
}
