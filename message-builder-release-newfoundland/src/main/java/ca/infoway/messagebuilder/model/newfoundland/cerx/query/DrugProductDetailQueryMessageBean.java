package ca.infoway.messagebuilder.model.newfoundland.cerx.query;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.NewQueryMessageBean;

@Hl7PartTypeMapping("POME_IN010050CA")
public class DrugProductDetailQueryMessageBean extends NewQueryMessageBean<DrugProductDetailQueryCriteriaBean> {

    private static final long serialVersionUID = -7308182724728624555L;

    public DrugProductDetailQueryMessageBean() {
        this(new DrugProductDetailQueryCriteriaBean());
    }

    public DrugProductDetailQueryMessageBean(DrugProductDetailQueryCriteriaBean criteria) {
        super(criteria);
    }
}
