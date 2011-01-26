/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.immunization.merged;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>AntigenValidity</p>
 * 
 * <p>POIZ_MT030050CA.AntigenValidity: Antigen Validity</p>
 * 
 * <p><p>Indicates whether an antigen administered to a patient 
 * is considered valid according to an immunization 
 * schedule.</p></p>
 * 
 * <p><p>Allows for an immunization registry to tell providers 
 * that a particular antigen administration was or was not a 
 * valid administration.</p></p>
 * 
 * <p>POIZ_MT061150CA.AntigenValidity: Antigen Validity</p>
 * 
 * <p><p>Indicates whether an antigen administered to a patient 
 * is considered valid according to an immunization 
 * schedule.</p></p>
 * 
 * <p><p>Allows for an immunization registry to tell providers 
 * that a particular antigen administration was or was not a 
 * valid administration.</p></p>
 * 
 * <p>POIZ_MT030060CA.AntigenValidity: Antigen Validity</p>
 * 
 * <p><p>Indicates whether an antigen administered to a patient 
 * is considered valid according to an immunization 
 * schedule.</p></p>
 * 
 * <p><p>Allows for an immunization registry to tell providers 
 * that a particular antigen administration was or was not a 
 * valid administration.</p></p>
 * 
 * <p>POIZ_MT060150CA.AntigenValidity: Antigen Validity</p>
 * 
 * <p><p>Indicates whether an antigen administered to a patient 
 * is considered valid according to an immunization 
 * schedule.</p></p>
 * 
 * <p><p>Allows for an immunization registry to tell providers 
 * that a particular antigen administration was or was not a 
 * valid administration.</p></p>
 */
@Hl7PartTypeMapping({"POIZ_MT030050CA.AntigenValidity","POIZ_MT030060CA.AntigenValidity","POIZ_MT060150CA.AntigenValidity","POIZ_MT061150CA.AntigenValidity"})
public class AntigenValidityBean extends MessagePartBean {

    private static final long serialVersionUID = 20110126L;
    private CV invalidAntigenReasonCode = new CVImpl();
    private BL antigenValidityIndicator = new BLImpl();


    /**
     * <p>InvalidAntigenReasonCode</p>
     * 
     * <p>Invalid Antigen Reason Code</p>
     * 
     * <p><p>reasonCode only populated if value is 
     * &quot;false&quot;</p></p>
     * 
     * <p><p>A coded value to describe why an antigen is considered 
     * to be invalid.</p></p>
     * 
     * <p><p>Provides additional context around an antigen's 
     * invalidity. This is not expected to be present when an 
     * antigen is valid and as such is considered a required 
     * attribute.</p></p>
     */
    @Hl7XmlMapping({"reasonCode"})
    public Code getInvalidAntigenReasonCode() {
        return (Code) this.invalidAntigenReasonCode.getValue();
    }
    public void setInvalidAntigenReasonCode(Code invalidAntigenReasonCode) {
        this.invalidAntigenReasonCode.setValue(invalidAntigenReasonCode);
    }


    /**
     * <p>AntigenValidityIndicator</p>
     * 
     * <p>Antigen Validity Indicator</p>
     * 
     * <p><p>Represents the validity (i.e. valid/not valid) of a 
     * particular administration of an antigen.</p></p>
     * 
     * <p><p>Allows for an immunization registry to tell providers 
     * that a particular antigen administration was or was not a 
     * valid administration.</p></p>
     */
    @Hl7XmlMapping({"value"})
    public Boolean getAntigenValidityIndicator() {
        return this.antigenValidityIndicator.getValue();
    }
    public void setAntigenValidityIndicator(Boolean antigenValidityIndicator) {
        this.antigenValidityIndicator.setValue(antigenValidityIndicator);
    }

}
