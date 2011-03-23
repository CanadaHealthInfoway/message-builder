package ca.infoway.messagebuilder.model.cerx.deviceprescription;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.NewQueryMessageBean;

@Hl7PartTypeMapping("PORX_IN060010CA")
public class DevicePrescriptionWithHistoryAndDispenseQueryMessageBean extends NewQueryMessageBean<DevicePrescriptionDetailQueryCriteriaBean> {

    private static final long serialVersionUID = -2898310369793541311L;

    public DevicePrescriptionWithHistoryAndDispenseQueryMessageBean() {
        this(new DevicePrescriptionDetailQueryCriteriaBean());
    }

    public DevicePrescriptionWithHistoryAndDispenseQueryMessageBean(DevicePrescriptionDetailQueryCriteriaBean criteria) {
        super(criteria);
    }
}
