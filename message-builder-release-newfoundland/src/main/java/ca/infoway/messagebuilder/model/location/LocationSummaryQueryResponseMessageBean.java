package ca.infoway.messagebuilder.model.location;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.NewQueryResponseMessageBean;
import ca.infoway.messagebuilder.model.ResponseMessageAttributesBean;

@Hl7PartTypeMapping("PRLO_IN202011CA")
public class LocationSummaryQueryResponseMessageBean extends NewQueryResponseMessageBean<LocationSummaryQueryCriteriaBean, LocationSummaryBean> {

    private static final long serialVersionUID = 8860656351279097751L;

    public LocationSummaryQueryResponseMessageBean(ResponseMessageAttributesBean attributes, LocationSummaryQueryCriteriaBean criteria) {
        super(attributes, criteria);
    }

    public LocationSummaryQueryResponseMessageBean(LocationSummaryQueryCriteriaBean criteria) {
        super(criteria);
    }

    public LocationSummaryQueryResponseMessageBean() {
        this(new LocationSummaryQueryCriteriaBean());
    }
}
