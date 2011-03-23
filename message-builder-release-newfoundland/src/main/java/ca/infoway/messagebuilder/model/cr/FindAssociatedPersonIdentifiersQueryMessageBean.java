package ca.infoway.messagebuilder.model.cr;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.NewQueryMessageBean;

@Hl7PartTypeMapping("PRPA_IN101105CA")
public class FindAssociatedPersonIdentifiersQueryMessageBean extends NewQueryMessageBean<FindAssociatedIdentifiersCriteria> {

    private static final long serialVersionUID = -6928378779657582506L;

    public FindAssociatedPersonIdentifiersQueryMessageBean() {
        super(new FindAssociatedIdentifiersCriteria());
    }

    public FindAssociatedPersonIdentifiersQueryMessageBean(FindAssociatedIdentifiersCriteria criteria) {
        super(criteria);
    }
}
