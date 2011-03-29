/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



/**
 * <p>PatientEncounter</p>
 * 
 * <p>COCT_MT300000CA.PatientEncounter: Patient Encounter</p>
 * 
 * <p><p>Patient Encounter details</p></p>
 * 
 * <p><p>Can be used to reference discharge and admit dates for 
 * an encounter in a hospital.</p></p>
 * 
 * <p>COCT_MT290000CA.PatientEncounter: Patient Encounter</p>
 * 
 * <p><p>Details of patient Encounter</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT290000CA.PatientEncounter","COCT_MT300000CA.PatientEncounter"})
public class PatientEncounterBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private II encounterID = new IIImpl();
    private TS effectiveTime = new TSImpl();


    /**
     * <p>EncounterID</p>
     * 
     * <p>Encounter ID</p>
     * 
     * <p><p>Encounter id</p></p>
     * 
     * <p>Encounter ID</p>
     * 
     * <p><p>A unique identifier that refers to the interaction 
     * with the patient.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getEncounterID() {
        return this.encounterID.getValue();
    }
    public void setEncounterID(Identifier encounterID) {
        this.encounterID.setValue(encounterID);
    }


    /**
     * <p>Admit/Discharge Date</p>
     * 
     * <p><p>Time of encounter</p></p>
     * 
     * <p>Encounter Date</p>
     * 
     * <p><p>The start and end dates of the interaction with the 
     * patient, eg. for dispensing, the interval would be when the 
     * patient handed the prescription to the pharmacy to when the 
     * patient picked up the medication.</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Date getEffectiveTime() {
        return this.effectiveTime.getValue();
    }
    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }

}