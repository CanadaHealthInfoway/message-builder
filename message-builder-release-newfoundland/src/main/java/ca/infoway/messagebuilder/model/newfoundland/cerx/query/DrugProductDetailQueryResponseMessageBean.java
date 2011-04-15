package ca.infoway.messagebuilder.model.newfoundland.cerx.query;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.NewQueryResponseMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.ResponseMessageAttributesBean;

@Hl7PartTypeMapping("POME_IN010060CA")
public class DrugProductDetailQueryResponseMessageBean extends NewQueryResponseMessageBean<DrugProductDetailQueryCriteriaBean, DrugProductDetailRecord> {

    private static final long serialVersionUID = 7463459016103343983L;

    public DrugProductDetailQueryResponseMessageBean() {
        this(new DrugProductDetailQueryCriteriaBean());
    }

    public DrugProductDetailQueryResponseMessageBean(DrugProductDetailQueryCriteriaBean criteria) {
        super(criteria);
    }

    public DrugProductDetailQueryResponseMessageBean(ResponseMessageAttributesBean attributes, DrugProductDetailQueryCriteriaBean criteria) {
        super(attributes, criteria);
    }
}
