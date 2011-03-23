package ca.infoway.messagebuilder.model.cerx.unfilledprescription;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.NewQueryMessageBean;

@Hl7PartTypeMapping("PORX_IN060490CA")
public class UnfilledPrescriptionQueryMessageBean extends NewQueryMessageBean<UnfilledPrescriptionQueryCriteriaBean> {

    private static final long serialVersionUID = -4287703702840509011L;

    public UnfilledPrescriptionQueryMessageBean() {
        this(new UnfilledPrescriptionQueryCriteriaBean());
    }

    public UnfilledPrescriptionQueryMessageBean(UnfilledPrescriptionQueryCriteriaBean criteria) {
        super(criteria);
    }
}
