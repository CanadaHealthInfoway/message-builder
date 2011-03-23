package ca.infoway.messagebuilder.model.cerx.professionalservice;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.NewQueryResponseMessageBean;
import ca.infoway.messagebuilder.model.ResponseMessageAttributesBean;

@Hl7PartTypeMapping("REPC_IN000042CA")
public class ProfessionalServicesQueryResponseMessageBean extends NewQueryResponseMessageBean<ProfessionalServicesQueryCriteria, ProfessionalServiceRecord> {

    private static final long serialVersionUID = 668078534657002500L;

    public ProfessionalServicesQueryResponseMessageBean() {
        this(new ProfessionalServicesQueryCriteria());
    }

    public ProfessionalServicesQueryResponseMessageBean(ProfessionalServicesQueryCriteria criteria) {
        this(new ResponseMessageAttributesBean(), criteria);
    }

    public ProfessionalServicesQueryResponseMessageBean(ResponseMessageAttributesBean attributes, ProfessionalServicesQueryCriteria criteria) {
        super(attributes, criteria);
    }
}
