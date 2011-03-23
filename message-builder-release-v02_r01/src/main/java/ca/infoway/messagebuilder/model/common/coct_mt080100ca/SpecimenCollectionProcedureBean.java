/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.common.coct_mt080100ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.common.coct_mt120600ca.NotesBean;
import ca.infoway.messagebuilder.model.merged.HealthcareWorkerBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Specimen Collection Procedure</p>
 * 
 * <p>This is the procedure act which describes the 
 * process/procedure used to collect the associated specimen.</p>
 * 
 * <p>For certain laboratory tests, the specimen collection 
 * procedure information is relevant in determining the result 
 * value.</p>
 */
@Hl7PartTypeMapping({"COCT_MT080100CA.SpecimenCollectionProcedureEvent"})
public class SpecimenCollectionProcedureBean extends MessagePartBean {

    private static final long serialVersionUID = 20100615L;
    private ST specimenCollectionText = new STImpl();
    private IVL<TS, Interval<Date>> specimenCollectionDateTime = new IVLImpl<TS, Interval<Date>>();
    private List<NotesBean> subjectOfAnnotation = new ArrayList<NotesBean>();
    private HealthcareWorkerBean performerAssignedEntity;

    @Hl7XmlMapping({"text"})
    public String getSpecimenCollectionText() {
        return this.specimenCollectionText.getValue();
    }
    public void setSpecimenCollectionText(String specimenCollectionText) {
        this.specimenCollectionText.setValue(specimenCollectionText);
    }

    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getSpecimenCollectionDateTime() {
        return this.specimenCollectionDateTime.getValue();
    }
    public void setSpecimenCollectionDateTime(Interval<Date> specimenCollectionDateTime) {
        this.specimenCollectionDateTime.setValue(specimenCollectionDateTime);
    }

    @Hl7XmlMapping({"subjectOf/annotation"})
    public List<NotesBean> getSubjectOfAnnotation() {
        return this.subjectOfAnnotation;
    }

    @Hl7XmlMapping({"performer/assignedEntity"})
    public HealthcareWorkerBean getPerformerAssignedEntity() {
        return this.performerAssignedEntity;
    }
    public void setPerformerAssignedEntity(HealthcareWorkerBean performerAssignedEntity) {
        this.performerAssignedEntity = performerAssignedEntity;
    }

}
