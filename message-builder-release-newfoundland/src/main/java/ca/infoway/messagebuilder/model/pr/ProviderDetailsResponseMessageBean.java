package ca.infoway.messagebuilder.model.pr;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.NewQueryResponseMessageBean;
import ca.infoway.messagebuilder.model.ResponseMessageAttributesBean;

@Hl7PartTypeMapping("PRPM_IN306011CA")
public class ProviderDetailsResponseMessageBean extends NewQueryResponseMessageBean<ProviderDetailsCriteria, RoleChoice> {

    private static final long serialVersionUID = -5668060081228034285L;

    public ProviderDetailsResponseMessageBean() {
        this(new ProviderDetailsCriteria());
    }

    public ProviderDetailsResponseMessageBean(ProviderDetailsCriteria criteria) {
        super(criteria);
    }

    public ProviderDetailsResponseMessageBean(ResponseMessageAttributesBean attributes, ProviderDetailsCriteria criteria) {
        super(attributes, criteria);
    }
}
