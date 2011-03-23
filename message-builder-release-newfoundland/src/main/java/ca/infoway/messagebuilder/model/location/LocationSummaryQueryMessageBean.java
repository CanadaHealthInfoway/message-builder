package ca.infoway.messagebuilder.model.location;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.NewQueryMessageBean;

@Hl7PartTypeMapping("PRLO_IN202010CA")
public class LocationSummaryQueryMessageBean extends NewQueryMessageBean<LocationSummaryQueryCriteriaBean> {

    private static final long serialVersionUID = 7463147958612882144L;

    public LocationSummaryQueryMessageBean() {
        this(new LocationSummaryQueryCriteriaBean());
    }

    public LocationSummaryQueryMessageBean(LocationSummaryQueryCriteriaBean criteria) {
        super(criteria);
    }
}
