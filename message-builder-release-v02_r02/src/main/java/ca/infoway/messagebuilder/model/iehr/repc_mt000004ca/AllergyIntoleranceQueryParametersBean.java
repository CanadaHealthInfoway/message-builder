/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.iehr.repc_mt000004ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.RawListWrapper;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActCareEventType;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.ObservationIntoleranceType;
import ca.infoway.messagebuilder.domainvalue.SubjectReaction;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Allergy/Intolerance Query Parameters</p>
 * 
 * <p>Defines the set of parameters that may be used to filter 
 * the query response</p>
 * 
 * <p>Root class for query definition</p>
 */
@Hl7PartTypeMapping({"REPC_MT000004CA.ParameterList"})
@Hl7RootType
public class AllergyIntoleranceQueryParametersBean extends MessagePartBean {

    private static final long serialVersionUID = 20100614L;
    private CV allergyIntoleranceStatus = new CVImpl();
    private CD allergyIntoleranceType = new CDImpl();
    private IVL<TS, Interval<Date>> allergyIntoleranceChangePeriod = new IVLImpl<TS, Interval<Date>>();
    private List<II> careCompositionIDs = new ArrayList<II>();
    private List<CV> careCompositionTypes = new ArrayList<CV>();
    private BL includeNotesIndicator = new BLImpl();
    private CV reaction = new CVImpl();

    @Hl7XmlMapping({"allergyIntoleranceStatus/value"})
    public ActStatus getAllergyIntoleranceStatus() {
        return (ActStatus) this.allergyIntoleranceStatus.getValue();
    }
    public void setAllergyIntoleranceStatus(ActStatus allergyIntoleranceStatus) {
        this.allergyIntoleranceStatus.setValue(allergyIntoleranceStatus);
    }

    @Hl7XmlMapping({"allergyIntoleranceType/value"})
    public ObservationIntoleranceType getAllergyIntoleranceType() {
        return (ObservationIntoleranceType) this.allergyIntoleranceType.getValue();
    }
    public void setAllergyIntoleranceType(ObservationIntoleranceType allergyIntoleranceType) {
        this.allergyIntoleranceType.setValue(allergyIntoleranceType);
    }

    @Hl7XmlMapping({"alllergyIntoleranceChangePeriod/value"})
    public Interval<Date> getAllergyIntoleranceChangePeriod() {
        return this.allergyIntoleranceChangePeriod.getValue();
    }
    public void setAllergyIntoleranceChangePeriod(Interval<Date> allergyIntoleranceChangePeriod) {
        this.allergyIntoleranceChangePeriod.setValue(allergyIntoleranceChangePeriod);
    }

    @Hl7XmlMapping({"careCompositionID/value"})
    public List<Identifier> getCareCompositionIDs() {
        return new RawListWrapper<II, Identifier>(careCompositionIDs, IIImpl.class);
    }

    @Hl7XmlMapping({"careCompositionType/value"})
    public List<ActCareEventType> getCareCompositionTypes() {
        return new RawListWrapper<CV, ActCareEventType>(careCompositionTypes, CVImpl.class);
    }

    @Hl7XmlMapping({"includeNotesIndicator/value"})
    public Boolean getIncludeNotesIndicator() {
        return this.includeNotesIndicator.getValue();
    }
    public void setIncludeNotesIndicator(Boolean includeNotesIndicator) {
        this.includeNotesIndicator.setValue(includeNotesIndicator);
    }

    @Hl7XmlMapping({"reactionType/value"})
    public SubjectReaction getReaction() {
        return (SubjectReaction) this.reaction.getValue();
    }
    public void setReaction(SubjectReaction reaction) {
        this.reaction.setValue(reaction);
    }

}
