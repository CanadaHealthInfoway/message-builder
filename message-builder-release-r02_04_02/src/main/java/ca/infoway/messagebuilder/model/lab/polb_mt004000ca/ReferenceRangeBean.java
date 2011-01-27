/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.lab.polb_mt004000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ANY;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.ANYImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.domainvalue.ObservationInterpretation;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>Reference Range</p>
 * 
 * <p><p>Reference ranges are generally presented as a pair of 
 * values (Lo - Hi) of the same datatype as the observation to 
 * which they apply (carried as an IVL). In some cases there 
 * may only be a Lo or a Hi rather than a pair of values.</p></p>
 */
@Hl7PartTypeMapping({"POLB_MT004000CA.InterpretationRange"})
public class ReferenceRangeBean extends MessagePartBean {

    private static final long serialVersionUID = 20110127L;
    private ANY<Object> referenceRangeValue = new ANYImpl<Object>();
    private CV referenceRangeInterpretationType = new CVImpl();
    private List<ReferenceRangeCriteriaBean> preconditionObservationEventCriterion = new ArrayList<ReferenceRangeCriteriaBean>();


    /**
     * <p>Reference Range Value</p>
     * 
     * <p><p>Reference ranges are generally presented as a pair of 
     * values (Lo - Hi) of the same datatype as the observation to 
     * which they apply (carried as an IVL). In some cases there 
     * may only be a single value (not a range or interval). If a 
     * coded value applies, the value must be selected from the 
     * LaboratoryResultCodeValue Concept Domain.</p></p>
     */
    @Hl7XmlMapping({"value"})
    public Object getReferenceRangeValue() {
        return this.referenceRangeValue.getValue();
    }
    public void setReferenceRangeValue(Object referenceRangeValue) {
        this.referenceRangeValue.setValue(referenceRangeValue);
    }


    /**
     * <p>Reference Range Interpretation Type</p>
     * 
     * <p><p>Describes the type of range e.g. normal, high, 
     * etc.</p></p>
     */
    @Hl7XmlMapping({"interpretationCode"})
    public ObservationInterpretation getReferenceRangeInterpretationType() {
        return (ObservationInterpretation) this.referenceRangeInterpretationType.getValue();
    }
    public void setReferenceRangeInterpretationType(ObservationInterpretation referenceRangeInterpretationType) {
        this.referenceRangeInterpretationType.setValue(referenceRangeInterpretationType);
    }


    @Hl7XmlMapping({"precondition/observationEventCriterion"})
    public List<ReferenceRangeCriteriaBean> getPreconditionObservationEventCriterion() {
        return this.preconditionObservationEventCriterion;
    }

}
