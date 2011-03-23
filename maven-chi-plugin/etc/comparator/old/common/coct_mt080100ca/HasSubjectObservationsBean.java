/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.common.coct_mt080100ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ANY;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.ANYImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



/**
 * <p>has subject observations 
 * 
 * <p>Associates a specimen (role) with observations about that 
 * specimen 
 * 
 * <p>Used to communicate specimen characteristics such as 
 * color, adequacy, etc. 
 */
@Hl7PartTypeMapping({"COCT_MT080100CA.Subject4"})
public class HasSubjectObservationsBean extends MessagePartBean {

    private CV<Code> specimenObservationType = new CVImpl<Code>();
    private IVL<TS, Interval<Date>> specimenObservationDateTime = new IVLImpl<TS, Interval<Date>>();
    private ANY specimenObservationValue = new ANYImpl();

    @Hl7XmlMapping({"specimenObservationEvent/code"})
    public Code getSpecimenObservationType() {
        return this.specimenObservationType.getValue();
    }
    public void setSpecimenObservationType(Code specimenObservationType) {
        this.specimenObservationType.setValue(specimenObservationType);
    }

    @Hl7XmlMapping({"specimenObservationEvent/effectiveTime"})
    public Interval<Date> getSpecimenObservationDateTime() {
        return this.specimenObservationDateTime.getValue();
    }
    public void setSpecimenObservationDateTime(Interval<Date> specimenObservationDateTime) {
        this.specimenObservationDateTime.setValue(specimenObservationDateTime);
    }

    @Hl7XmlMapping({"specimenObservationEvent/value"})
    public java.lang.Object getSpecimenObservationValue() {
        return this.specimenObservationValue.getValue();
    }
    public void setSpecimenObservationValue(java.lang.Object specimenObservationValue) {
        this.specimenObservationValue.setValue(specimenObservationValue);
    }

}
