package ca.infoway.messagebuilder.model.newfoundland.pr;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.NewQueryMessageBean;

@Hl7PartTypeMapping("PRPM_IN306010CA")
public class ProviderDetailsQueryMessageBean extends NewQueryMessageBean<ProviderDetailsCriteria> {

    private static final long serialVersionUID = -3564072122851826585L;

    public ProviderDetailsQueryMessageBean() {
        this(new ProviderDetailsCriteria());
    }

    public ProviderDetailsQueryMessageBean(ProviderDetailsCriteria criteria) {
        super(criteria);
    }
}
