/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActCareEventType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt011001ca.Assignees;



/**
 * <p>CareCompositions</p>
 * 
 * <p>COCT_MT011001CA.PatientCareProvisionEvent: Care 
 * Compositions</p>
 * 
 * <p><p>A care composition is a record with two purposes. It 
 * indicates that care of a given type has occurred or is 
 * occurring. It also acts as a collector for the events that 
 * happened during care, including who is responsible for the 
 * care provided.</p></p>
 * 
 * <p><p>Allows linking records to encounters, condition and 
 * care-based compositions. Useful for searching and navigation 
 * of the patient's record.</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT011001CA.PatientCareProvisionEvent","REPC_MT210001CA.PatientCareProvisionEvent2","REPC_MT210002CA.PatientCareProvisionEvent2","REPC_MT210003CA.PatientCareProvisionEvent2"})
@Hl7RootType
public class CareCompositionsBean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private II id = new IIImpl();
    private CV careCompositionType = new CVImpl();
    private IVL<TS, Interval<Date>> careCompositionEffectiveDate = new IVLImpl<TS, Interval<Date>>();
    private List<Assignees> admitterAssignees = new ArrayList<Assignees>();
    private List<Assignees> attenderAssignees = new ArrayList<Assignees>();
    private OccurredAtBean location;


    /**
     * <p>N: Referral Report Link</p>
     * 
     * <p><p>A unique identifier for the report resulting from the 
     * action requested by this referral.</p></p>
     * 
     * <p><p>Provides a direct link between the referral and the 
     * resulting report.</p></p>
     * 
     * <p><p>This linkage may be established after the document has 
     * been created if the report provides a direct link to the 
     * referral.</p></p>
     * 
     * <p>N: Referral Report Link</p>
     * 
     * <p>B: Care Composition Identifier</p>
     * 
     * <p><p>Unique identifier of an encounter, condition or 
     * care-based collection.</p></p>
     * 
     * <p><p>IMMUNIZATION INTERPRETATION.REFERENCED DATA</p></p>
     * 
     * <p><p>Allows care compositions to be uniquely identified and 
     * referenced.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>CareCompositionType</p>
     * 
     * <p>A: Care Composition Type</p>
     * 
     * <p><p>Identifies the kind of composition represented. 
     * Examples include encounters (&quot;Emergency 
     * Encounter&quot;, &quot;Long Term Care Encounter&quot;, etc), 
     * health condition (episode)-based collections (e.g. 
     * &quot;Diabetes&quot;, &quot;Hypertension&quot;, etc) and 
     * general care-based collections such as &quot;gynecological 
     * care&quot;.</p></p>
     * 
     * <p><p>IMMUNIZATION INTERPRETATION.REFERENCED DATA</p></p>
     * 
     * <p><p>EPHS: vocab concepts needed for LAB ID, Special 
     * Considerations ID etc.</p></p>
     * 
     * <p><p>Allows care compositions to be captured and 
     * categorized at different levels of abstraction, and is 
     * therefore mandatory.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public ActCareEventType getCareCompositionType() {
        return (ActCareEventType) this.careCompositionType.getValue();
    }
    public void setCareCompositionType(ActCareEventType careCompositionType) {
        this.careCompositionType.setValue(careCompositionType);
    }


    /**
     * <p>CareCompositionEffectiveDate</p>
     * 
     * <p>Care Composition Effective Date</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getCareCompositionEffectiveDate() {
        return this.careCompositionEffectiveDate.getValue();
    }
    public void setCareCompositionEffectiveDate(Interval<Date> careCompositionEffectiveDate) {
        this.careCompositionEffectiveDate.setValue(careCompositionEffectiveDate);
    }


    @Hl7XmlMapping({"admitter/assignees"})
    public List<Assignees> getAdmitterAssignees() {
        return this.admitterAssignees;
    }


    @Hl7XmlMapping({"attender/assignees"})
    public List<Assignees> getAttenderAssignees() {
        return this.attenderAssignees;
    }


    @Hl7XmlMapping({"location"})
    public OccurredAtBean getLocation() {
        return this.location;
    }
    public void setLocation(OccurredAtBean location) {
        this.location = location;
    }

}
