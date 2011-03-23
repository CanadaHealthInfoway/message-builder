package ca.infoway.messagebuilder.model.cerx.professionalservice;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.NewQueryMessageBean;

@Hl7PartTypeMapping("REPC_IN000041CA")
public class ProfessionalServicesQueryMessageBean extends NewQueryMessageBean<ProfessionalServicesQueryCriteria> {

    private static final long serialVersionUID = 4599431154479372660L;

    public ProfessionalServicesQueryMessageBean() {
        this(new ProfessionalServicesQueryCriteria());
    }

    public ProfessionalServicesQueryMessageBean(ProfessionalServicesQueryCriteria criteria) {
        super(criteria);
    }
}
