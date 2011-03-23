package ca.infoway.messagebuilder.model.cerx.immunization;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.NewQueryResponseMessageBean;
import ca.infoway.messagebuilder.model.ResponseMessageAttributesBean;

@Hl7PartTypeMapping("POIZ_IN020020CA")
public class ImmunizationQueryResponseMessageBean extends NewQueryResponseMessageBean<ImmunizationQueryCriteriaBean, ImmunizationBean> {

    private static final long serialVersionUID = 7165135264265155338L;

    public ImmunizationQueryResponseMessageBean(ResponseMessageAttributesBean attributes, ImmunizationQueryCriteriaBean criteria) {
        super(attributes, criteria);
    }

    public ImmunizationQueryResponseMessageBean(ImmunizationQueryCriteriaBean criteria) {
        super(criteria);
    }

    public ImmunizationQueryResponseMessageBean() {
        this(new ImmunizationQueryCriteriaBean());
    }
}
