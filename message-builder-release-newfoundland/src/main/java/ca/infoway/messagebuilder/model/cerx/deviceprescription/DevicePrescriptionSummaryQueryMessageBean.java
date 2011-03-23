package ca.infoway.messagebuilder.model.cerx.deviceprescription;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.NewQueryMessageBean;

@Hl7PartTypeMapping("PORX_IN060130CA")
public class DevicePrescriptionSummaryQueryMessageBean extends NewQueryMessageBean<DevicePrescriptionSummaryQueryCriteriaBean> {

    private static final long serialVersionUID = -2898310369793541311L;

    public DevicePrescriptionSummaryQueryMessageBean() {
        this(new DevicePrescriptionSummaryQueryCriteriaBean());
    }

    public DevicePrescriptionSummaryQueryMessageBean(DevicePrescriptionSummaryQueryCriteriaBean criteria) {
        super(criteria);
    }
}
