/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v01_r04_3.pharmacy.pome_mt010040ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.ObservationDosageDefinitionPreconditionType;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"POME_MT010040CA.ObservationEventCriterion"})
public class PatientCharacteristicsBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private CV patientCharacteristicType = new CVImpl();
    private BL excludeCharacteristic = new BLImpl();
    private IVL<PQ, Interval<PhysicalQuantity>> patientCharacteristicValue = new IVLImpl<PQ, Interval<PhysicalQuantity>>();


    /**
     * <p>Patient Characteristic Type</p>
     */
    @Hl7XmlMapping({"code"})
    public ObservationDosageDefinitionPreconditionType getPatientCharacteristicType() {
        return (ObservationDosageDefinitionPreconditionType) this.patientCharacteristicType.getValue();
    }
    public void setPatientCharacteristicType(ObservationDosageDefinitionPreconditionType patientCharacteristicType) {
        this.patientCharacteristicType.setValue(patientCharacteristicType);
    }


    /**
     * <p>Exclude characteristic?</p>
     */
    @Hl7XmlMapping({"negationInd"})
    public Boolean getExcludeCharacteristic() {
        return this.excludeCharacteristic.getValue();
    }
    public void setExcludeCharacteristic(Boolean excludeCharacteristic) {
        this.excludeCharacteristic.setValue(excludeCharacteristic);
    }


    /**
     * <p>Patient Characteristic Value</p>
     */
    @Hl7XmlMapping({"value"})
    public Interval<PhysicalQuantity> getPatientCharacteristicValue() {
        return this.patientCharacteristicValue.getValue();
    }
    public void setPatientCharacteristicValue(Interval<PhysicalQuantity> patientCharacteristicValue) {
        this.patientCharacteristicValue.setValue(patientCharacteristicValue);
    }

}
