/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.polb_mt004100ca;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.merged.ResultStatusProcessStepBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.IncludesBean;



/**
 * <p>Organism Identificaton Observations</p>
 * 
 * <p><p>Describes the observation associated with the 
 * identification of the organism.</p></p>
 */
@Hl7PartTypeMapping({"POLB_MT004100CA.OrganismIdentificationEvent"})
public class OrganismIdentificatonObservationsBean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private CD organismIdentificationType = new CDImpl();
    private CS organsimIdentificationObservationStatus = new CSImpl();
    private IVL<TS, Interval<Date>> organismObservationEffectiveTime = new IVLImpl<TS, Interval<Date>>();
    private IsolateParticipationBean specimen;
    private List<IncludesBean> subjectOf1 = new ArrayList<IncludesBean>();
    private ResultStatusProcessStepBean subjectOf2ResultStatusProcessStep;


    /**
     * <p>Organism Identification Type</p>
     * 
     * <p><p>Describes the type of organism identification 
     * observation and is bound to the LOINC code domain (e.g. 
     * 612-2).</p></p>
     */
    @Hl7XmlMapping({"code"})
    public Code getOrganismIdentificationType() {
        return (Code) this.organismIdentificationType.getValue();
    }
    public void setOrganismIdentificationType(Code organismIdentificationType) {
        this.organismIdentificationType.setValue(organismIdentificationType);
    }


    /**
     * <p>Organsim Identification Observation Status</p>
     * 
     * <p><p>Status associated with the organism identification 
     * observation.</p></p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getOrgansimIdentificationObservationStatus() {
        return (ActStatus) this.organsimIdentificationObservationStatus.getValue();
    }
    public void setOrgansimIdentificationObservationStatus(ActStatus organsimIdentificationObservationStatus) {
        this.organsimIdentificationObservationStatus.setValue(organsimIdentificationObservationStatus);
    }


    /**
     * <p>Organism Observation Effective Time</p>
     * 
     * <p><p>Effective time of the Organism Observation.</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getOrganismObservationEffectiveTime() {
        return this.organismObservationEffectiveTime.getValue();
    }
    public void setOrganismObservationEffectiveTime(Interval<Date> organismObservationEffectiveTime) {
        this.organismObservationEffectiveTime.setValue(organismObservationEffectiveTime);
    }


    @Hl7XmlMapping({"specimen"})
    public IsolateParticipationBean getSpecimen() {
        return this.specimen;
    }
    public void setSpecimen(IsolateParticipationBean specimen) {
        this.specimen = specimen;
    }


    @Hl7XmlMapping({"subjectOf1"})
    public List<IncludesBean> getSubjectOf1() {
        return this.subjectOf1;
    }


    @Hl7XmlMapping({"subjectOf2/resultStatusProcessStep"})
    public ResultStatusProcessStepBean getSubjectOf2ResultStatusProcessStep() {
        return this.subjectOf2ResultStatusProcessStep;
    }
    public void setSubjectOf2ResultStatusProcessStep(ResultStatusProcessStepBean subjectOf2ResultStatusProcessStep) {
        this.subjectOf2ResultStatusProcessStep = subjectOf2ResultStatusProcessStep;
    }

}
