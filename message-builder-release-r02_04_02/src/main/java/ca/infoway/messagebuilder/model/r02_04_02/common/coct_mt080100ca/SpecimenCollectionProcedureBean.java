/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.common.coct_mt080100ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.r02_04_02.common.coct_mt090502ca.HealthcareOrganizationBean;
import ca.infoway.messagebuilder.model.r02_04_02.common.merged.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.r02_04_02.merged.IncludesBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Specimen Collection Procedure</p>
 * 
 * <p><p>This is the procedure act which describes the 
 * process/procedure used to collect the associated 
 * specimen.</p></p>
 * 
 * <p><p>For certain laboratory tests, the specimen collection 
 * procedure information is relevant in determining the result 
 * value.</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT080100CA.SpecimenCollectionProcedureEvent"})
public class SpecimenCollectionProcedureBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private ST specimenCollectionText = new STImpl();
    private IVL<TS, Interval<Date>> specimenCollectionDateTime = new IVLImpl<TS, Interval<Date>>();
    private CV specimenCollectionProcedureMethod = new CVImpl();
    private List<PerformerChoice> performerPerformerChoice = new ArrayList<PerformerChoice>();
    private List<IncludesBean> subjectOf = new ArrayList<IncludesBean>();


    /**
     * <p>G:Specimen Collection Text</p>
     * 
     * <p><p>Used to describe any additional information regarding 
     * the specimen collection procedure or the collected material, 
     * e.g. left ear; where &quot;ear&quot; is atomically 
     * represented by the Natural entity code but the 
     * &quot;left&quot; is not able, at this time, to also be 
     * communicated within the Natural entity. This attribute is 
     * not used for notes or comments regarding the specimen 
     * collection process. Notes and annotations are documented 
     * using the Annotation CMET.</p></p>
     * 
     * <p><p>The text attribute documents any additional 
     * information regarding this specimen collection procedure 
     * event that is not able to be communicated using the other 
     * attribution of this act e.g. for granularity of coding 
     * reasons.</p></p>
     */
    @Hl7XmlMapping({"text"})
    public String getSpecimenCollectionText() {
        return this.specimenCollectionText.getValue();
    }
    public void setSpecimenCollectionText(String specimenCollectionText) {
        this.specimenCollectionText.setValue(specimenCollectionText);
    }


    /**
     * <p>E:Specimen Collection Date/Time</p>
     * 
     * <p><p>The date/time the specimen was collected. This can be 
     * a date/time interval (start - stop).</p><p>The time may not 
     * always be known, but a date should always be entered.</p></p>
     * 
     * <p><p>The date/time the specimen was collected. This can be 
     * a date/time interval (start - stop).</p><p>The time may not 
     * always be known, but a date should always be entered.</p></p>
     * 
     * <p><p>The specimen collection date/time is relevant to the 
     * testing and resulting outcome of that specimen for some 
     * laboratory tests.</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getSpecimenCollectionDateTime() {
        return this.specimenCollectionDateTime.getValue();
    }
    public void setSpecimenCollectionDateTime(Interval<Date> specimenCollectionDateTime) {
        this.specimenCollectionDateTime.setValue(specimenCollectionDateTime);
    }


    /**
     * <p>Specimen Collection Procedure Method</p>
     * 
     * <p><p>Method of specimen collection used primariy for 
     * Surgical Pathology.</p></p>
     */
    @Hl7XmlMapping({"methodCode"})
    public Code getSpecimenCollectionProcedureMethod() {
        return (Code) this.specimenCollectionProcedureMethod.getValue();
    }
    public void setSpecimenCollectionProcedureMethod(Code specimenCollectionProcedureMethod) {
        this.specimenCollectionProcedureMethod.setValue(specimenCollectionProcedureMethod);
    }


    @Hl7XmlMapping({"performer/performerChoice"})
    public List<PerformerChoice> getPerformerPerformerChoice() {
        return this.performerPerformerChoice;
    }


    @Hl7XmlMapping({"subjectOf"})
    public List<IncludesBean> getSubjectOf() {
        return this.subjectOf;
    }

}
