package ca.infoway.messagebuilder.model.newfoundland.location;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.NewQueryMessageBean;

@Hl7PartTypeMapping("PRLO_IN202012CA")
public class LocationDetailsQueryMessageBean extends NewQueryMessageBean<LocationDetailsQueryCriteriaBean> {

    private static final long serialVersionUID = 7463147958612882144L;

    public LocationDetailsQueryMessageBean() {
        this(new LocationDetailsQueryCriteriaBean());
    }

    public LocationDetailsQueryMessageBean(LocationDetailsQueryCriteriaBean criteria) {
        super(criteria);
    }
}
