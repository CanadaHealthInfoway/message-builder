package ca.infoway.messagebuilder.model.newfoundland.cerx.medicationprofile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.newfoundland.DetectedIssueBean;
import ca.infoway.messagebuilder.model.newfoundland.NoteBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.HistoricalControlActEventBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.RefusalToFillBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.SubstitutionPermissionBean;

public abstract class CombinedMedicationInnerBaseBean extends CombinedMedicationBaseBean {

    private static final long serialVersionUID = -260704236035475306L;

    private final List<DetectedIssueBean> detectedIssues = Collections.synchronizedList(new ArrayList<DetectedIssueBean>());

    private final List<NoteBean> annotations = Collections.synchronizedList(new ArrayList<NoteBean>());

    private SubstitutionPermissionBean substitutionPermission;


    @Hl7XmlMapping("subjectOf1/detectedIssueEvent")
    public List<DetectedIssueBean> getDetectedIssues() {
        return this.detectedIssues;
    }

    @Hl7XmlMapping({ "subjectOf3/annotation" })
    public List<NoteBean> getAnnotations() {
    	return this.annotations;
    }
    
    @Hl7XmlMapping({ "subjectOf5/substitutionPermission" })
    public SubstitutionPermissionBean getSubstitutionPermission() {
    	return this.substitutionPermission;
    }
    public void setSubstitutionPermission(SubstitutionPermissionBean substitutionPermission) {
    	this.substitutionPermission = substitutionPermission;
    }

    /////////////
    
    public abstract Boolean getAnnotationIndicator();
    public abstract void setAnnotationIndicator(Boolean annotationIndicator);
    
    public abstract List<HistoricalControlActEventBean> getHistoryRecords();
    
    public abstract List<RefusalToFillBean> getRefusalToFills();
    
    public abstract Boolean getDetectedIssueIndicator();
    public abstract void setDetectedIssueIndicator(Boolean detectedIssueIndicator);
    
}