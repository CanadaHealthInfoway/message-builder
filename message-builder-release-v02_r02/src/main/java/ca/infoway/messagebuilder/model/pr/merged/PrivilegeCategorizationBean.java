/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.domainvalue.ActPrivilegeCategorization;
import ca.infoway.messagebuilder.domainvalue.ObservationValue;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>PrivilegeCategorization</p>
 * 
 * <p>PRPM_MT306011CA.PrivilegeCategorization: Privilege 
 * Categorization</p>
 * 
 * <p><p>An act that is intended to result in new information 
 * about a subject. In this instance, regarding restrictions to 
 * practice for a specified healthcare provider.</p></p>
 * 
 * <p><p>Supports the business requirement to provide 
 * information about a healthcare provider where privileges 
 * have been restricted.</p></p>
 * 
 * <p>PRPM_MT309000CA.PrivilegeCategorization: Privilege 
 * Categorization</p>
 * 
 * <p><p>An act that is intended to result in new information 
 * about a subject. In this instance, regarding restrictions to 
 * practice for a specified healthcare provider.</p></p>
 * 
 * <p><p>Supports the business requirement to provide 
 * information about a healthcare provider where privileges 
 * have been restricted.</p></p>
 * 
 * <p>PRPM_MT303010CA.PrivilegeCategorization: Privilege 
 * Categorization</p>
 * 
 * <p><p>An act that is intended to result in new information 
 * about a subject. In this instance, regarding restrictions to 
 * practice for a specified healthcare provider.</p></p>
 * 
 * <p><p>Supports the business requirement to provide 
 * information about a healthcare provider where privileges 
 * have been restricted.</p></p>
 * 
 * <p>PRPM_MT301010CA.PrivilegeCategorization: Privilege 
 * Categorization</p>
 * 
 * <p><p>An act that is intended to result in new information 
 * about a subject. In this instance, regarding restrictions to 
 * practice for a specified healthcare provider.</p></p>
 * 
 * <p><p>Supports the business requirement to provide 
 * information about a healthcare provider where privileges 
 * have been restricted.</p></p>
 */
@Hl7PartTypeMapping({"PRPM_MT301010CA.PrivilegeCategorization","PRPM_MT303010CA.PrivilegeCategorization","PRPM_MT306011CA.PrivilegeCategorization","PRPM_MT309000CA.PrivilegeCategorization"})
public class PrivilegeCategorizationBean extends MessagePartBean {

    private static final long serialVersionUID = 20110127L;
    private CV restrictionsCategorizationValue = new CVImpl();
    private CV restrictionsCategorizationType = new CVImpl();


    /**
     * <p>RestrictionsCategorizationValue</p>
     * 
     * <p>Restrictions Categorization Value</p>
     * 
     * <p><p>The value identifying the specific privilege and/or 
     * restrictions on those privileges</p></p>
     * 
     * <p><p>Populated attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p></p>
     * 
     * <p>Restrictions Categorization Value</p>
     * 
     * <p><p>The value identifying the specific privilege and/or 
     * restrictions on those privileges</p></p>
     * 
     * <p><p>Required attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p></p>
     */
    @Hl7XmlMapping({"value"})
    public ObservationValue getRestrictionsCategorizationValue() {
        return (ObservationValue) this.restrictionsCategorizationValue.getValue();
    }
    public void setRestrictionsCategorizationValue(ObservationValue restrictionsCategorizationValue) {
        this.restrictionsCategorizationValue.setValue(restrictionsCategorizationValue);
    }


    /**
     * <p>RestrictionsCategorizationType</p>
     * 
     * <p>Restrictions Categorization Type</p>
     * 
     * <p><p>The code identifying the specific privilege and/or 
     * restrictions on those privileges</p></p>
     * 
     * <p><p>Mandatory attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p></p>
     * 
     * <p>Restrictions Categorization Type</p>
     * 
     * <p><p>The code identifying the specific privilege and/or 
     * restrictions on those privileges</p></p>
     * 
     * <p><p>Required attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p></p>
     * 
     * <p>Restrictions Categorization Type</p>
     * 
     * <p><p>Mandatory attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p></p>
     * 
     * <p>Restrictions Categorization Type</p>
     * 
     * <p><p>The code identifying the specific privilege and/or 
     * restrictions on those privileges</p></p>
     * 
     * <p><p>Populated attribute supports the validation and 
     * identification of the healthcare provider and his/her given 
     * privileges</p></p>
     */
    @Hl7XmlMapping({"code"})
    public ActPrivilegeCategorization getRestrictionsCategorizationType() {
        return (ActPrivilegeCategorization) this.restrictionsCategorizationType.getValue();
    }
    public void setRestrictionsCategorizationType(ActPrivilegeCategorization restrictionsCategorizationType) {
        this.restrictionsCategorizationType.setValue(restrictionsCategorizationType);
    }

}