package ca.infoway.messagebuilder.model.newfoundland.cr;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.NewQueryMessageBean;

@Hl7PartTypeMapping("PRPA_IN101101CA")
public class GetPersonDemographicsQueryMessageBean extends NewQueryMessageBean<DemographicsQueryCriteria> {

    private static final long serialVersionUID = 4946551478799011928L;

    public GetPersonDemographicsQueryMessageBean(DemographicsQueryCriteria criteria) {
        super(criteria);
    }

    public GetPersonDemographicsQueryMessageBean() {
        this(new DemographicsQueryCriteria());
    }
}
