package ca.infoway.messagebuilder.model.cerx.medicationprofile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.model.cerx.HistoricalControlActEventBean;
import ca.infoway.messagebuilder.model.cerx.RefusalToFillBean;

@Hl7PartTypeMapping({ "PORX_MT060160CA.CombinedMedicationRequest" })
public class CombinedMedication2Bean extends CombinedMedicationInnerBaseBean {

    private static final long serialVersionUID = -260704236035475306L;

    private BL detectedIssueIndicator = new BLImpl(false);

    private final List<HistoricalControlActEventBean> historyRecords = Collections.synchronizedList(new ArrayList<HistoricalControlActEventBean>());

    private BL annotationIndicator = new BLImpl(false);

    private final List<RefusalToFillBean> refusalToFills = Collections.synchronizedList(new ArrayList<RefusalToFillBean>());


    @Hl7XmlMapping({ "subjectOf2/detectedIssueIndicator"  })
    public Boolean getDetectedIssueIndicator() {
        return this.detectedIssueIndicator.getValue();
    }
    public void setDetectedIssueIndicator(Boolean detectedIssueIndicator) {
        this.detectedIssueIndicator.setValue(detectedIssueIndicator);
    }

    @Hl7XmlMapping({ "subjectOf4/annotationIndicator" })
    public Boolean getAnnotationIndicator() {
        return this.annotationIndicator.getValue();
    }
    public void setAnnotationIndicator(Boolean annotationIndicator) {
        this.annotationIndicator.setValue(annotationIndicator);
    }

    @Hl7XmlMapping({ "subjectOf6/controlActEvent" })
    public List<HistoricalControlActEventBean> getHistoryRecords() {
    	return historyRecords;
    }
    
    @Hl7XmlMapping("subjectOf7/refusalToFill")
    public List<RefusalToFillBean> getRefusalToFills() {
        return refusalToFills;
    }

}
