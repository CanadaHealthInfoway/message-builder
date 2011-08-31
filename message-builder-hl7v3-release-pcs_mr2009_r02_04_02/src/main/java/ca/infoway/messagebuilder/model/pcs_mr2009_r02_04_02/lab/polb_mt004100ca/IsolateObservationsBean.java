/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.polb_mt004100ca;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.merged.ResultStatusProcessStepBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.IncludesBean;



/**
 * <p>Isolate Observations</p>
 * 
 * <p><p>Allows for further observations to be documentation at 
 * the isolate level, e.g. growth, colony count, etc.</p></p>
 */
@Hl7PartTypeMapping({"POLB_MT004100CA.IsolateObservationEvent"})
public class IsolateObservationsBean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private CD isolateObservationType = new CDImpl();
    private CS isolateObservationStatus = new CSImpl();
    private IVL<TS, Interval<Date>> isolateObservationEffectiveTime = new IVLImpl<TS, Interval<Date>>();
    private ST isolateObservationValue = new STImpl();
    private List<IncludesBean> subjectOf1 = new ArrayList<IncludesBean>();
    private ResultStatusProcessStepBean subjectOf2ResultStatusProcessStep;


    /**
     * <p>Isolate Observation Type</p>
     * 
     * <p><p>Describes the type of isolate observation and is bound 
     * to the LOINC code domain.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public Code getIsolateObservationType() {
        return (Code) this.isolateObservationType.getValue();
    }
    public void setIsolateObservationType(Code isolateObservationType) {
        this.isolateObservationType.setValue(isolateObservationType);
    }


    /**
     * <p>Isolate Observation Status</p>
     * 
     * <p><p>Status associated with the Isolate Observation.</p></p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getIsolateObservationStatus() {
        return (ActStatus) this.isolateObservationStatus.getValue();
    }
    public void setIsolateObservationStatus(ActStatus isolateObservationStatus) {
        this.isolateObservationStatus.setValue(isolateObservationStatus);
    }


    /**
     * <p>Isolate Observation Effective Time</p>
     * 
     * <p><p>Effective time of the Isolate Observation.</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getIsolateObservationEffectiveTime() {
        return this.isolateObservationEffectiveTime.getValue();
    }
    public void setIsolateObservationEffectiveTime(Interval<Date> isolateObservationEffectiveTime) {
        this.isolateObservationEffectiveTime.setValue(isolateObservationEffectiveTime);
    }


    /**
     * <p>Isolate Observation Value</p>
     * 
     * <p><p>The value of the isolate observation.</p></p>
     */
    @Hl7XmlMapping({"value"})
    public String getIsolateObservationValue() {
        return this.isolateObservationValue.getValue();
    }
    public void setIsolateObservationValue(String isolateObservationValue) {
        this.isolateObservationValue.setValue(isolateObservationValue);
    }


    @Hl7XmlMapping({"subjectOf1"})
    public List<IncludesBean> getSubjectOf1() {
        return this.subjectOf1;
    }


    @Hl7XmlMapping({"subjectOf2/resultStatusProcessStep"})
    public ResultStatusProcessStepBean getSubjectOf2ResultStatusProcessStep() {
        return this.subjectOf2ResultStatusProcessStep;
    }
    public void setSubjectOf2ResultStatusProcessStep(ResultStatusProcessStepBean subjectOf2ResultStatusProcessStep) {
        this.subjectOf2ResultStatusProcessStep = subjectOf2ResultStatusProcessStep;
    }

}
