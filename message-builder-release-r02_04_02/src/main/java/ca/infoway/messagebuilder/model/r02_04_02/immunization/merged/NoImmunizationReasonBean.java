/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.immunization.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.ActNoImmunizationReason;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>POIZ_MT030060CA.NoImmunizationReason: (no business name)</p>
 * 
 * <p><p>Identifies the reason why an immunization event did 
 * not occur.</p></p>
 * 
 * <p><p>Needed for explicitly communicating the reason why a 
 * patient was not administered as vaccine.</p></p>
 */
@Hl7PartTypeMapping({"POIZ_MT030050CA.NoImmunizationReason","POIZ_MT030060CA.NoImmunizationReason","POIZ_MT060150CA.NoImmunizationReason"})
public class NoImmunizationReasonBean extends MessagePartBean implements ca.infoway.messagebuilder.model.r02_04_02.merged.Choice {

    private static final long serialVersionUID = 20110318L;
    private CV immunizationRefusalReason = new CVImpl();
    private ST immunizationRefusalReasonText = new STImpl();


    /**
     * <p>ImmunizationRefusalReason</p>
     * 
     * <p>Immunization Refusal Reason</p>
     * 
     * <p><p>A coded value denoting a patient's reason for refusing 
     * to be immunized.</p><p>Typical reasons include: Parental 
     * decision, Religious exemption, Patient decision, previous 
     * adverse event etc.</p></p>
     * 
     * <p><p>A coded value denoting a patient's reason for refusing 
     * to be immunized.</p><p>Typical reasons include: Parental 
     * decision, Religious exemption, Patient decision, previous 
     * adverse event etc.</p></p>
     * 
     * <p><p>Allows sorting and categorizing different kinds of 
     * refusal reasons. Ensures that reasons are gathered in a 
     * consistent analyzable manner. As a result, this attribute is 
     * mandatory.</p></p>
     * 
     * <p>Immunization Refusal Reason</p>
     */
    @Hl7XmlMapping({"reasonCode"})
    public ActNoImmunizationReason getImmunizationRefusalReason() {
        return (ActNoImmunizationReason) this.immunizationRefusalReason.getValue();
    }
    public void setImmunizationRefusalReason(ActNoImmunizationReason immunizationRefusalReason) {
        this.immunizationRefusalReason.setValue(immunizationRefusalReason);
    }


    /**
     * <p>ImmunizationRefusalReasonText</p>
     * 
     * <p>Immunization Refusal Reason Text</p>
     * 
     * <p>Immunization Refusal Reason Text</p>
     * 
     * <p><p>A textual or multimedia description (or reference to a 
     * description) of the reason.</p></p>
     * 
     * <p><p>Provides additional context and description relating 
     * to the reason for not immunizing. Not all implementations 
     * will support text. As a result, this attribute is 
     * optional.</p></p>
     */
    @Hl7XmlMapping({"text"})
    public String getImmunizationRefusalReasonText() {
        return this.immunizationRefusalReasonText.getValue();
    }
    public void setImmunizationRefusalReasonText(String immunizationRefusalReasonText) {
        this.immunizationRefusalReasonText.setValue(immunizationRefusalReasonText);
    }

}
