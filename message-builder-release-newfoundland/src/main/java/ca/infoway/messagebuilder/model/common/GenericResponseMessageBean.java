package ca.infoway.messagebuilder.model.common;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.NoPayloadResponseMessageBean;

@Hl7PartTypeMapping("MCCI_IN000002CA")
public class GenericResponseMessageBean extends NoPayloadResponseMessageBean {

    private static final long serialVersionUID = 5191719298094899922L;

    public GenericResponseMessageBean() {
        clearControlActEvent();
    }
}
