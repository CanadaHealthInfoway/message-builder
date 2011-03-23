package ca.infoway.messagebuilder.model.cerx.prescription;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.NoPayloadResponseMessageBean;

@Hl7PartTypeMapping("PORX_IN010400CA")
public class ActivatePrescriptionRequestRefusedMessageBean extends NoPayloadResponseMessageBean {

    private static final long serialVersionUID = -3084874682004107335L;
}
