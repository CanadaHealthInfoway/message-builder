package ca.infoway.messagebuilder.model.cerx.deviceprescription;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.NewQueryMessageBean;

@Hl7PartTypeMapping("PORX_IN060090CA")
public class DevicePrescriptionDetailQueryMessageBean extends NewQueryMessageBean<DevicePrescriptionDetailQueryCriteriaBean> {

    private static final long serialVersionUID = -2898310369793541311L;

    public DevicePrescriptionDetailQueryMessageBean() {
        this(new DevicePrescriptionDetailQueryCriteriaBean());
    }

    public DevicePrescriptionDetailQueryMessageBean(DevicePrescriptionDetailQueryCriteriaBean criteria) {
        super(criteria);
    }
}
