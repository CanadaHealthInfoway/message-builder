/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt290000ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Accident Injury coding</p>
 * 
 * <p><p>Accident Information</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT290000CA.AccidentInjuryCoding"})
public class AccidentInjuryCodingBean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private CV observationInjuryType = new CVImpl();
    private CV injuryCode = new CVImpl();
    private CV actInjurySite = new CVImpl();


    /**
     * <p>Observation Injury type</p>
     * 
     * <p><p>Injury Type</p></p>
     */
    @Hl7XmlMapping({"code"})
    public Code getObservationInjuryType() {
        return (Code) this.observationInjuryType.getValue();
    }
    public void setObservationInjuryType(Code observationInjuryType) {
        this.observationInjuryType.setValue(observationInjuryType);
    }


    /**
     * <p>Injury code</p>
     * 
     * <p><p>Nature of Injury</p></p>
     */
    @Hl7XmlMapping({"value"})
    public Code getInjuryCode() {
        return (Code) this.injuryCode.getValue();
    }
    public void setInjuryCode(Code injuryCode) {
        this.injuryCode.setValue(injuryCode);
    }


    /**
     * <p>Act Injury Site</p>
     * 
     * <p><p>Body Part + modifier = Side of Body</p></p>
     */
    @Hl7XmlMapping({"targetSiteCode"})
    public Code getActInjurySite() {
        return (Code) this.actInjurySite.getValue();
    }
    public void setActInjurySite(Code actInjurySite) {
        this.actInjurySite.setValue(actInjurySite);
    }

}
