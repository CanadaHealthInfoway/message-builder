/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.lab.polb_mt004100ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ANY;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.ANYImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.r02_04_02.lab.merged.ResultStatusProcessStepBean;
import ca.infoway.messagebuilder.model.r02_04_02.merged.IncludesBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Culture Observations</p>
 * 
 * <p><p>Act for describing any observations about the culture 
 * e.g. Protein measurements, gram stains, culture-level 
 * supporting clinical information observations use this act 
 * and are associated using the pertinentInformation act 
 * relationship. Those test (result) components which are not 
 * supporting but are observation which are &quot;part of&quot; 
 * the resulted values should be associated using this act and 
 * the component act relationship.</p></p>
 */
@Hl7PartTypeMapping({"POLB_MT004100CA.CultureObservationEvent"})
public class CultureObservationsBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private CD cultureObservationType = new CDImpl();
    private ResultStatusProcessStepBean subjectOf2ResultStatusProcessStep;
    private List<IncludesBean> subjectOf1 = new ArrayList<IncludesBean>();
    private ANY<Object> cultureObservationValue = new ANYImpl<Object>();
    private ST cultureObservationComment = new STImpl();
    private CS cultureObservationStatus = new CSImpl();
    private IVL<TS, Interval<Date>> cultureObservationDateTime = new IVLImpl<TS, Interval<Date>>();


    /**
     * <p>Culture Observation Type</p>
     * 
     * <p><p>Act for describing the type of observations about the 
     * culture e.g. gram stain, etc.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public Code getCultureObservationType() {
        return (Code) this.cultureObservationType.getValue();
    }
    public void setCultureObservationType(Code cultureObservationType) {
        this.cultureObservationType.setValue(cultureObservationType);
    }


    @Hl7XmlMapping({"subjectOf2/resultStatusProcessStep"})
    public ResultStatusProcessStepBean getSubjectOf2ResultStatusProcessStep() {
        return this.subjectOf2ResultStatusProcessStep;
    }
    public void setSubjectOf2ResultStatusProcessStep(ResultStatusProcessStepBean subjectOf2ResultStatusProcessStep) {
        this.subjectOf2ResultStatusProcessStep = subjectOf2ResultStatusProcessStep;
    }


    @Hl7XmlMapping({"subjectOf1"})
    public List<IncludesBean> getSubjectOf1() {
        return this.subjectOf1;
    }


    /**
     * <p>Culture Observation Value</p>
     * 
     * <p><p>The result value of this culture observation e.g. the 
     * number value associated with a protein measurement, etc. 
     * When a coded value applies, values must be selected from the 
     * CultureObservationValue Concept Domain.</p></p>
     */
    @Hl7XmlMapping({"value"})
    public Object getCultureObservationValue() {
        return this.cultureObservationValue.getValue();
    }
    public void setCultureObservationValue(Object cultureObservationValue) {
        this.cultureObservationValue.setValue(cultureObservationValue);
    }


    /**
     * <p>Culture Observation Comment</p>
     * 
     * <p><p>Comments associated with the Culture Observation.</p></p>
     */
    @Hl7XmlMapping({"text"})
    public String getCultureObservationComment() {
        return this.cultureObservationComment.getValue();
    }
    public void setCultureObservationComment(String cultureObservationComment) {
        this.cultureObservationComment.setValue(cultureObservationComment);
    }


    /**
     * <p>Culture Observation Status</p>
     * 
     * <p><p>Status associated with the Culture Observation.</p></p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getCultureObservationStatus() {
        return (ActStatus) this.cultureObservationStatus.getValue();
    }
    public void setCultureObservationStatus(ActStatus cultureObservationStatus) {
        this.cultureObservationStatus.setValue(cultureObservationStatus);
    }


    /**
     * <p>Culture Observation Date/Time</p>
     * 
     * <p><p>The date/time interval when this culture observation 
     * took place.</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getCultureObservationDateTime() {
        return this.cultureObservationDateTime.getValue();
    }
    public void setCultureObservationDateTime(Interval<Date> cultureObservationDateTime) {
        this.cultureObservationDateTime.setValue(cultureObservationDateTime);
    }

}
