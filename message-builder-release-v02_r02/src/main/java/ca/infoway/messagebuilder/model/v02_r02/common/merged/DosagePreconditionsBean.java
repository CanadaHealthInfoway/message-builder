/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r02.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.URG;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.impl.URGImpl;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.UncertainRange;
import ca.infoway.messagebuilder.domainvalue.ObservationDosageDefinitionPreconditionType;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>DosagePreconditions</p>
 * 
 * <p>COCT_MT260030CA.ObservationEventCriterion: Dosage 
 * Preconditions</p>
 * 
 * <p><p>A condition that must be true for the patient in order 
 * for the specified recommended dosage range to apply.</p></p>
 * 
 * <p><p>Allows recommended dosage instructions to be bound to 
 * a particular characteristic of the patient.</p></p>
 * 
 * <p>COCT_MT260010CA.ObservationEventCriterion: Dosage 
 * Preconditions</p>
 * 
 * <p><p>A condition that must be true for the patient in order 
 * for the specified recommended dosage range to apply.</p></p>
 * 
 * <p><p>Allows recommended dosage instructions to be bound to 
 * a particular characteristic of the patient.</p></p>
 * 
 * <p>COCT_MT260020CA.ObservationEventCriterion: Dosage 
 * Preconditions</p>
 * 
 * <p><p>A condition that must be true for the patient in order 
 * for the specified recommended dosage range to apply.</p></p>
 * 
 * <p><p>Allows recommended dosage instructions to be bound to 
 * a particular characteristic of the patient.</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT260010CA.ObservationEventCriterion","COCT_MT260020CA.ObservationEventCriterion","COCT_MT260030CA.ObservationEventCriterion"})
public class DosagePreconditionsBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private URG<PQ, PhysicalQuantity> dosagePreconditionValue = new URGImpl<PQ, PhysicalQuantity>();
    private CV dosagePreconditionType = new CVImpl();


    /**
     * <p>DosagePreconditionValue</p>
     * 
     * <p>B:Dosage Precondition Value</p>
     * 
     * <p><p>A specific value or range of values of the Dosage 
     * Precondition Type, for which the recommended dosage 
     * applies.</p><p>This includes min-max age range, min-max 
     * weights, etc.</p><p>This is a mandatory attribute as the 
     * values of the measurements must be known.</p></p>
     * 
     * <p><p>A specific value or range of values of the Dosage 
     * Precondition Type, for which the recommended dosage 
     * applies.</p><p>This includes min-max age range, min-max 
     * weights, etc.</p><p>This is a mandatory attribute as the 
     * values of the measurements must be known.</p></p>
     * 
     * <p><p>A specific value or range of values of the Dosage 
     * Precondition Type, for which the recommended dosage 
     * applies.</p><p>This includes min-max age range, min-max 
     * weights, etc.</p><p>This is a mandatory attribute as the 
     * values of the measurements must be known.</p></p>
     * 
     * <p><p>Minimum Age</p><p>Maximum Age</p></p>
     * 
     * <p><p>Minimum Age</p><p>Maximum Age</p></p>
     * 
     * <p><p>Allows direct comparison of the patient's 
     * characteristics with the minimum and maximum values 
     * specified.</p><p>The element is mandatory because there's no 
     * point in identifying that the dosage range is based on 
     * criteria unless the specific criterion used is 
     * expressed.</p></p>
     * 
     * <p><p>Allows direct comparison of the patient's 
     * characteristics with the minimum and maximum values 
     * specified.</p><p>The element is mandatory because there's no 
     * point in identifying that the dosage range is based on 
     * criteria unless the specific criterion used is 
     * expressed.</p></p>
     * 
     * <p><p>If not specified, it means that the range is based on 
     * a criteria (e.g. weight), but the specific range on which 
     * the criteria is based is not known.</p></p>
     * 
     * <p>B:Dosage Precondition Value</p>
     * 
     * <p><p>A specific value or range of values of the Dosage 
     * Precondition Type, for which the recommended dosage 
     * applies.</p><p>This includes min-max age range, min-max 
     * weights, etc.</p><p>This attribute is mandatory as the 
     * specific range of values must be known.</p></p>
     * 
     * <p><p>A specific value or range of values of the Dosage 
     * Precondition Type, for which the recommended dosage 
     * applies.</p><p>This includes min-max age range, min-max 
     * weights, etc.</p><p>This attribute is mandatory as the 
     * specific range of values must be known.</p></p>
     * 
     * <p><p>A specific value or range of values of the Dosage 
     * Precondition Type, for which the recommended dosage 
     * applies.</p><p>This includes min-max age range, min-max 
     * weights, etc.</p><p>This attribute is mandatory as the 
     * specific range of values must be known.</p></p>
     * 
     * <p><p>Minimum Age</p><p>Maximum Age</p></p>
     * 
     * <p><p>Minimum Age</p><p>Maximum Age</p></p>
     * 
     * <p><p>Allows direct comparison of the patient's 
     * characteristics with the minimum and maximum values 
     * specified.</p><p>The element is mandatory because there's no 
     * point in identifying that the dosage range is based on 
     * criteria unless the specific criterion used is 
     * expressed.</p></p>
     * 
     * <p><p>Allows direct comparison of the patient's 
     * characteristics with the minimum and maximum values 
     * specified.</p><p>The element is mandatory because there's no 
     * point in identifying that the dosage range is based on 
     * criteria unless the specific criterion used is 
     * expressed.</p></p>
     * 
     * <p><p>If not specified, it means that the range is based on 
     * a criteria (e.g. weight), but the specific range on which 
     * the criteria is based is not known.</p></p>
     * 
     * <p>B:Dosage Precondition Value</p>
     * 
     * <p><p>A specific value or range of values of the Dosage 
     * Precondition Type, for which the recommended dosage 
     * applies.</p><p>This includes min-max age range, min-max 
     * weights, etc.</p><p>This is a mandatory attribute as the 
     * specific range of values must be known.</p></p>
     * 
     * <p><p>A specific value or range of values of the Dosage 
     * Precondition Type, for which the recommended dosage 
     * applies.</p><p>This includes min-max age range, min-max 
     * weights, etc.</p><p>This is a mandatory attribute as the 
     * specific range of values must be known.</p></p>
     * 
     * <p><p>A specific value or range of values of the Dosage 
     * Precondition Type, for which the recommended dosage 
     * applies.</p><p>This includes min-max age range, min-max 
     * weights, etc.</p><p>This is a mandatory attribute as the 
     * specific range of values must be known.</p></p>
     * 
     * <p><p>Minimum Age</p><p>Maximum Age</p></p>
     * 
     * <p><p>Minimum Age</p><p>Maximum Age</p></p>
     * 
     * <p><p>Allows direct comparison of the patient's 
     * characteristics with the minimum and maximum values 
     * specified.</p><p>The element is mandatory because there's no 
     * point in identifying that the dosage range is based on 
     * criteria unless the specific criterion used is 
     * expressed.</p></p>
     * 
     * <p><p>Allows direct comparison of the patient's 
     * characteristics with the minimum and maximum values 
     * specified.</p><p>The element is mandatory because there's no 
     * point in identifying that the dosage range is based on 
     * criteria unless the specific criterion used is 
     * expressed.</p></p>
     * 
     * <p><p>If not specified, it means that the range is based on 
     * a criteria (e.g. weight), but the specific range on which 
     * the criteria is based is not known.</p></p>
     */
    @Hl7XmlMapping({"value"})
    public UncertainRange<PhysicalQuantity> getDosagePreconditionValue() {
        return this.dosagePreconditionValue.getValue();
    }
    public void setDosagePreconditionValue(UncertainRange<PhysicalQuantity> dosagePreconditionValue) {
        this.dosagePreconditionValue.setValue(dosagePreconditionValue);
    }


    /**
     * <p>DosagePreconditionType</p>
     * 
     * <p>A:Dosage Precondition Type</p>
     * 
     * <p><p>Indicates the type of characteristic against which the 
     * patient is evaluated. This includes age, weight, height, 
     * etc.</p></p>
     * 
     * <p><p>Allows the specification of multiple preconditions for 
     * a dosage specification, such as Age Range, Weight Range, 
     * etc. This is mandatory because the precondition range cannot 
     * be evaluated without knowing the precondition type.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public ObservationDosageDefinitionPreconditionType getDosagePreconditionType() {
        return (ObservationDosageDefinitionPreconditionType) this.dosagePreconditionType.getValue();
    }
    public void setDosagePreconditionType(ObservationDosageDefinitionPreconditionType dosagePreconditionType) {
        this.dosagePreconditionType.setValue(dosagePreconditionType);
    }

}
