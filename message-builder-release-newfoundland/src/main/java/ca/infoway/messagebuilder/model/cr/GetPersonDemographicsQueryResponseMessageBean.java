package ca.infoway.messagebuilder.model.cr;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.IdentifiedPersonBean;
import ca.infoway.messagebuilder.model.NewQueryResponseMessageBean;
import ca.infoway.messagebuilder.model.ResponseMessageAttributesBean;

@Hl7PartTypeMapping("PRPA_IN101102CA")
public class GetPersonDemographicsQueryResponseMessageBean extends NewQueryResponseMessageBean<DemographicsQueryCriteria, IdentifiedPersonBean> {

    private static final long serialVersionUID = -7044950494682468781L;

    public GetPersonDemographicsQueryResponseMessageBean(ResponseMessageAttributesBean attributes, DemographicsQueryCriteria criteria) {
        super(attributes, criteria);
    }

    public GetPersonDemographicsQueryResponseMessageBean(DemographicsQueryCriteria criteria) {
        super(criteria);
    }

    public GetPersonDemographicsQueryResponseMessageBean() {
        super(new DemographicsQueryCriteria());
    }
}
