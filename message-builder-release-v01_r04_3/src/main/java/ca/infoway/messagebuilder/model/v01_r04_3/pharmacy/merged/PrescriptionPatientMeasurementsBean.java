/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v01_r04_3.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.x_ActObservationHeightOrWeight;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



@Hl7PartTypeMapping({"PORX_MT010120CA.QuantityObservationEvent","PORX_MT060160CA.QuantityObservationEvent","PORX_MT060340CA.QuantityObservationEvent"})
public class PrescriptionPatientMeasurementsBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private CV prescriptionPatientMeasurementType = new CVImpl();
    private TS effectiveTime = new TSImpl();
    private PQ prescriptionPatientMeasuredValue = new PQImpl();


    /**
     * <p>PrescriptionPatientMeasurementType</p>
     * 
     * <p>Prescription Patient Measurement Type</p>
     */
    @Hl7XmlMapping({"code"})
    public x_ActObservationHeightOrWeight getPrescriptionPatientMeasurementType() {
        return (x_ActObservationHeightOrWeight) this.prescriptionPatientMeasurementType.getValue();
    }
    public void setPrescriptionPatientMeasurementType(x_ActObservationHeightOrWeight prescriptionPatientMeasurementType) {
        this.prescriptionPatientMeasurementType.setValue(prescriptionPatientMeasurementType);
    }


    /**
     * <p>Prescription Patient Measurement Time</p>
     * 
     * <p>Prescription Patient Measurement Timestamp</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Date getEffectiveTime() {
        return this.effectiveTime.getValue();
    }
    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>PrescriptionPatientMeasuredValue</p>
     * 
     * <p>Prescription Patient Measured Value</p>
     */
    @Hl7XmlMapping({"value"})
    public PhysicalQuantity getPrescriptionPatientMeasuredValue() {
        return this.prescriptionPatientMeasuredValue.getValue();
    }
    public void setPrescriptionPatientMeasuredValue(PhysicalQuantity prescriptionPatientMeasuredValue) {
        this.prescriptionPatientMeasuredValue.setValue(prescriptionPatientMeasuredValue);
    }

}