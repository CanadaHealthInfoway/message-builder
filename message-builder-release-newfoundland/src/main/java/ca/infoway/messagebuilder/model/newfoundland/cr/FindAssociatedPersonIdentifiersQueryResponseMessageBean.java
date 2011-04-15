package ca.infoway.messagebuilder.model.newfoundland.cr;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.NewQueryResponseMessageBean;

@Hl7PartTypeMapping("PRPA_IN101106CA")
public class FindAssociatedPersonIdentifiersQueryResponseMessageBean extends NewQueryResponseMessageBean<FindAssociatedIdentifiersCriteria, Object> {

    private static final long serialVersionUID = -8911016992898675200L;

    public FindAssociatedPersonIdentifiersQueryResponseMessageBean() {
        super(new FindAssociatedIdentifiersCriteria());
    }

    public FindAssociatedPersonIdentifiersQueryResponseMessageBean(FindAssociatedIdentifiersCriteria criteria) {
        super(criteria);
    }
}
