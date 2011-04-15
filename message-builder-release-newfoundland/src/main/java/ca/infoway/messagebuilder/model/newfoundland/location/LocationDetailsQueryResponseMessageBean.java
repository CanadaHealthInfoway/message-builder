package ca.infoway.messagebuilder.model.newfoundland.location;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.NewQueryResponseMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.ResponseMessageAttributesBean;

@Hl7PartTypeMapping("PRLO_IN202013CA")
public class LocationDetailsQueryResponseMessageBean extends NewQueryResponseMessageBean<LocationDetailsQueryCriteriaBean, LocationDetailsBean> {

    private static final long serialVersionUID = 8860656351279097751L;

    public LocationDetailsQueryResponseMessageBean(ResponseMessageAttributesBean attributes, LocationDetailsQueryCriteriaBean criteria) {
        super(attributes, criteria);
    }

    public LocationDetailsQueryResponseMessageBean(LocationDetailsQueryCriteriaBean criteria) {
        super(criteria);
    }

    public LocationDetailsQueryResponseMessageBean() {
        this(new LocationDetailsQueryCriteriaBean());
    }
}
