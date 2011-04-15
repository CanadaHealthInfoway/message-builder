package ca.infoway.messagebuilder.model.newfoundland.cerx.immunization;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.NewQueryMessageBean;

@Hl7PartTypeMapping("POIZ_IN020010CA")
public class ImmunizationQueryMessageBean extends NewQueryMessageBean<ImmunizationQueryCriteriaBean> {

    private static final long serialVersionUID = -2868748571293401596L;

    public ImmunizationQueryMessageBean() {
        this(new ImmunizationQueryCriteriaBean());
    }

    public ImmunizationQueryMessageBean(ImmunizationQueryCriteriaBean immunizationQueryCriteriaBean) {
        super(immunizationQueryCriteriaBean);
    }
}
