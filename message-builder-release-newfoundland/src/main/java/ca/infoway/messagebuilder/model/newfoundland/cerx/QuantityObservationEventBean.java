package ca.infoway.messagebuilder.model.newfoundland.cerx;

import java.io.Serializable;
import java.util.Date;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.x_ActObservationHeightOrWeight;
import ca.infoway.messagebuilder.model.MessagePartBean;

@Hl7PartTypeMapping({ "PORX_MT010120CA.QuantityObservationEvent" })
public class QuantityObservationEventBean extends MessagePartBean implements Serializable {

    private static final long serialVersionUID = 4825026708205805716L;

    private TS patientMeasurementTime = new TSImpl();

    private PQ patientMeasuredValue = new PQImpl();

    private CD patientMeasurementType = new CDImpl();

    @Hl7XmlMapping("effectiveTime")
    public Date getPatientMeasurementTime() {
        return this.patientMeasurementTime.getValue();
    }

    public void setPatientMeasurementTime(Date patientMeasurementTime) {
        this.patientMeasurementTime.setValue(patientMeasurementTime);
    }

    @Hl7XmlMapping("value")
    public PhysicalQuantity getPatientMeasuredValue() {
        return this.patientMeasuredValue.getValue();
    }

    public void setPatientMeasuredValue(PhysicalQuantity patientMeasuredValue) {
        this.patientMeasuredValue.setValue(patientMeasuredValue);
    }

    @Hl7XmlMapping("code")
    public x_ActObservationHeightOrWeight getPatientMeasurementType() {
        return (x_ActObservationHeightOrWeight) this.patientMeasurementType.getValue();
    }

    public void setPatientMeasurementType(x_ActObservationHeightOrWeight patientMeasurementType) {
        this.patientMeasurementType.setValue(patientMeasurementType);
    }
}