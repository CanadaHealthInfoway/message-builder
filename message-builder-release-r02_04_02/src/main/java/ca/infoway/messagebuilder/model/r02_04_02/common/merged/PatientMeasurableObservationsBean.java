/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.common.merged;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.SimpleMeasurableClinicalObservationType;
import ca.infoway.messagebuilder.domainvalue.x_BasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



/**
 * <p>PatientMeasurableObservations</p>
 * 
 * <p>COCT_MT260010CA.ObservationMeasurableEvent: Patient 
 * Measurable Observations</p>
 * 
 * <p><p>This is the recorded observation (e.g. height, weight, 
 * lab result, etc.) of the patient that contributed to the 
 * issue being raised.</p></p>
 * 
 * <p><p>Useful for determining appropriate management and for 
 * drilling down for more information.</p></p>
 * 
 * <p>COCT_MT260030CA.ObservationMeasurableEvent: Patient 
 * Measurable Observations</p>
 * 
 * <p><p>This is the recorded observation (e.g. height, weight, 
 * lab result, etc.) of the patient that contributed to the 
 * issue being raised.</p></p>
 * 
 * <p><p>Useful for determining appropriate management and for 
 * drilling down for more information.</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT260010CA.ObservationMeasurableEvent","COCT_MT260020CA.ObservationMeasurableEvent","COCT_MT260030CA.ObservationMeasurableEvent"})
public class PatientMeasurableObservationsBean extends MessagePartBean implements CausalActs {

    private static final long serialVersionUID = 20110318L;
    private CD observationType = new CDImpl();
    private PQ observationValue = new PQImpl();
    private SET<CV, Code> confidentialityCode = new SETImpl<CV, Code>(CVImpl.class);
    private II observationIdentifier = new IIImpl();


    /**
     * <p>ObservationType</p>
     * 
     * <p>B:Observation Type</p>
     * 
     * <p>B:Observation Type</p>
     * 
     * <p><p>Distinguishes between the kinds of measurable 
     * observation that could be the trigger for clinical issue 
     * detection. Measurable observation types include: Lab Result, 
     * Height, Weight, and other measurable information about a 
     * person that may be deemed as a possible trigger for clinical 
     * issue detection.</p></p>
     * 
     * <p><p>Indicates the type of observation record being 
     * referenced. The attribute is mandatory because it is 
     * essential to interpreting the rest of the information on the 
     * class.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public SimpleMeasurableClinicalObservationType getObservationType() {
        return (SimpleMeasurableClinicalObservationType) this.observationType.getValue();
    }
    public void setObservationType(SimpleMeasurableClinicalObservationType observationType) {
        this.observationType.setValue(observationType);
    }


    /**
     * <p>ObservationValue</p>
     * 
     * <p>C:Observation Value</p>
     * 
     * <p><p>Denotes a specific measurable observation made about a 
     * person that might have trigger the clinical issue 
     * detection.</p></p>
     * 
     * <p><p>Provides unambiguous reference to the related 
     * measurable observation.</p></p>
     * 
     * <p>C:Observation Value</p>
     */
    @Hl7XmlMapping({"value"})
    public PhysicalQuantity getObservationValue() {
        return this.observationValue.getValue();
    }
    public void setObservationValue(PhysicalQuantity observationValue) {
        this.observationValue.setValue(observationValue);
    }


    /**
     * <p>D:Observation Masked Indicator</p>
     * 
     * <p>D:Observation Masking Indicator</p>
     * 
     * <p><p>An indication of sensitivity surrounding the related 
     * measurable observation, and thus defines the required 
     * sensitivity for the detected issue.</p></p>
     * 
     * <p><p>Contraindication.intractingSourceMasked (Normal=false; 
     * Restricted or Very Restricted = True); (Information is 
     * withheld because the prescription is masked will be given a 
     * NULL flavour of 'Masked')</p></p>
     * 
     * <p><p>Conveys the patient'''s wishes relating to the 
     * sensitivity of the observation information.</p><p>The 
     * attribute is optional because not all systems will support 
     * masking.</p></p>
     * 
     * <p><p>Conveys the patient'''s wishes relating to the 
     * sensitivity of the observation information.</p><p>The 
     * attribute is optional because not all systems will support 
     * masking.</p></p>
     * 
     * <p>D:Observation Masking Indicator</p>
     * 
     * <p><p>An indication of sensitivity surrounding the related 
     * measurable observation, and thus defines the required 
     * sensitivity for the detected issue.</p></p>
     * 
     * <p><p>Contraindication.intractingSourceMasked (Normal=false; 
     * Restricted or Very Restricted = True); (Information is 
     * withheld because the prescription is masked will be given a 
     * NULL flavour of 'Masked')</p></p>
     * 
     * <p><p>Conveys the patient's wishes relating to the 
     * sensitivity of the observation information.</p><p>The 
     * attribute is optional because not all systems will support 
     * masking.</p></p>
     * 
     * <p><p>Conveys the patient's wishes relating to the 
     * sensitivity of the observation information.</p><p>The 
     * attribute is optional because not all systems will support 
     * masking.</p></p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_BasicConfidentialityKind> getConfidentialityCode() {
        return this.confidentialityCode.rawSet(x_BasicConfidentialityKind.class);
    }


    /**
     * <p>ObservationIdentifier</p>
     * 
     * <p>A:Observation Identifier</p>
     * 
     * <p><p>Unique identifier for the record of the observation 
     * (e.g. height, weight or lab test/result) that contributed to 
     * the issue.</p></p>
     * 
     * <p><p>Allows lookup of the specific observation (e.g. 
     * height, weight, or lab record) for additional details when 
     * evaluating appropriateness of issue management.</p></p>
     * 
     * <p>A:Observation Identifier</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getObservationIdentifier() {
        return this.observationIdentifier.getValue();
    }
    public void setObservationIdentifier(Identifier observationIdentifier) {
        this.observationIdentifier.setValue(observationIdentifier);
    }

}
