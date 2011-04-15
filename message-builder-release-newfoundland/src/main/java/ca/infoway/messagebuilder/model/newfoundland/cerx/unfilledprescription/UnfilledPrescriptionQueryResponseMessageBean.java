package ca.infoway.messagebuilder.model.newfoundland.cerx.unfilledprescription;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.NewQueryResponseMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.ResponseMessageAttributesBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.deviceprescription.BasePrescriptionBean;

@Hl7PartTypeMapping("PORX_IN060500CA")
public class UnfilledPrescriptionQueryResponseMessageBean extends NewQueryResponseMessageBean<UnfilledPrescriptionQueryCriteriaBean, BasePrescriptionBean> {

    private static final long serialVersionUID = 3611260208598786095L;

    public UnfilledPrescriptionQueryResponseMessageBean(ResponseMessageAttributesBean attributes, UnfilledPrescriptionQueryCriteriaBean criteria) {
        super(attributes, criteria);
    }

    public UnfilledPrescriptionQueryResponseMessageBean(UnfilledPrescriptionQueryCriteriaBean criteria) {
        super(criteria);
    }

    public UnfilledPrescriptionQueryResponseMessageBean() {
        this(new UnfilledPrescriptionQueryCriteriaBean());
    }
}
