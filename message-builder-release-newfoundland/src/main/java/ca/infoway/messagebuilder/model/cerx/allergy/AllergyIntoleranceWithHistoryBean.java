package ca.infoway.messagebuilder.model.cerx.allergy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.cerx.HistoricalControlActEventBean;

@Hl7PartTypeMapping({ "REPC_MT000009CA.IntoleranceCondition" })
public class AllergyIntoleranceWithHistoryBean extends AllergyIntoleranceBean {

    private static final long serialVersionUID = -5346462291556239889L;

    private AllergyIntoleranceWithHistoryBean replacementOf;

    private final List<HistoricalControlActEventBean> controlActEvent = Collections.synchronizedList(new ArrayList<HistoricalControlActEventBean>());

    @Hl7XmlMapping("replacementOf/intoleranceCondition")
    public AllergyIntoleranceWithHistoryBean getReplacementOf() {
        return replacementOf;
    }

    public void setReplacementOf(AllergyIntoleranceWithHistoryBean replacementOf) {
        this.replacementOf = replacementOf;
    }

    @Hl7XmlMapping("subjectOf1/controlActEvent")
    public List<HistoricalControlActEventBean> getControlActEvent() {
        return controlActEvent;
    }
}
