package ca.infoway.messagebuilder.model.newfoundland.cerx.condition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.newfoundland.cerx.HistoricalControlActEventBean;

@Hl7PartTypeMapping({ "REPC_MT000010CA.MedicalCondition" })
public class MedicalConditionWithHistoryBean extends MedicalConditionBean {

    private static final long serialVersionUID = -3601665311855492662L;

    private MedicalConditionWithHistoryBean replacementOf;

    private final List<HistoricalControlActEventBean> controlActEvent = Collections.synchronizedList(new ArrayList<HistoricalControlActEventBean>());

    @Hl7XmlMapping("replacementOf/medicalCondition")
    public MedicalConditionWithHistoryBean getReplacementOf() {
        return this.replacementOf;
    }

    public void setReplacementOf(MedicalConditionWithHistoryBean replacementOf) {
        this.replacementOf = replacementOf;
    }

    @Hl7XmlMapping("subjectOf1/controlActEvent")
    public List<HistoricalControlActEventBean> getControlActEvent() {
        return this.controlActEvent;
    }
}
