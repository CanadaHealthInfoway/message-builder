/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pharmacy.porx_mt060200ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.RawListWrapper;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActCareEventType;
import ca.infoway.messagebuilder.domainvalue.IssueFilterCode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p><p>Defines the set of parameters that may be used to 
 * filter the query response.</p></p>
 * 
 * <p><p>Root class for query definition</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT060200CA.ParameterList"})
@Hl7RootType
public class ParameterListBean extends MessagePartBean {

    private static final long serialVersionUID = 20110127L;
    private IVL<TS, Interval<Date>> administrationEffectivePeriod = new IVLImpl<TS, Interval<Date>>();
    private BL mostRecentByDrugIndicator = new BLImpl();
    private CV issueFilterCode = new CVImpl();
    private IVL<TS, Interval<Date>> amendedInTimeRange = new IVLImpl<TS, Interval<Date>>();
    private List<II> careCompositionIDs = new ArrayList<II>();
    private List<CV> careCompositionTypes = new ArrayList<CV>();


    /**
     * <p>Administration Effective Period</p>
     * 
     * <p><p>Indicates the administration period for which the 
     * request/query applies.</p><p>Filter the result set to 
     * include only those medication records (prescription order, 
     * prescription dispense and other active medication) for which 
     * the patient was deemed to be taking the drug within the 
     * specified period.</p></p>
     * 
     * <p><p>Indicates the administration period for which the 
     * request/query applies.</p><p>Filter the result set to 
     * include only those medication records (prescription order, 
     * prescription dispense and other active medication) for which 
     * the patient was deemed to be taking the drug within the 
     * specified period.</p></p>
     * 
     * <p><p>Allows the requester to specify the administration 
     * period of interest for the retrieval. Useful for 
     * constraining run-away queries.</p></p>
     * 
     * <p><p>The determination for applicability for inclusion in 
     * the query response should be considered to be the 'Pick up 
     * date plus the days supply'</p></p>
     */
    @Hl7XmlMapping({"administrationEffectivePeriod/value"})
    public Interval<Date> getAdministrationEffectivePeriod() {
        return this.administrationEffectivePeriod.getValue();
    }
    public void setAdministrationEffectivePeriod(Interval<Date> administrationEffectivePeriod) {
        this.administrationEffectivePeriod.setValue(administrationEffectivePeriod);
    }


    /**
     * <p>Most Recent By Drug Indicator</p>
     * 
     * <p><p>Indicates whether or not the medication records are to 
     * be retrieved based on the most recent by Drug Code. If true, 
     * only the most recent prescription, dispense or other active 
     * medication for a particular drug generic classification will 
     * be returned. The default is 'FALSE' indicating that 
     * retrieval of prescription, dispense and other active 
     * medication records should not be limited to one per 
     * drug.</p></p>
     * 
     * <p><p>Helps decrease the volume of records returned, while 
     * still maintaining information on all drugs that the patient 
     * is on.</p><p>Because this is a boolean attribute whose value 
     * must be known to evaluate the query, the attribute is 
     * mandatory.</p></p>
     * 
     * <p><p>Helps decrease the volume of records returned, while 
     * still maintaining information on all drugs that the patient 
     * is on.</p><p>Because this is a boolean attribute whose value 
     * must be known to evaluate the query, the attribute is 
     * mandatory.</p></p>
     */
    @Hl7XmlMapping({"mostRecentByDrugIndicator/value"})
    public Boolean getMostRecentByDrugIndicator() {
        return this.mostRecentByDrugIndicator.getValue();
    }
    public void setMostRecentByDrugIndicator(Boolean mostRecentByDrugIndicator) {
        this.mostRecentByDrugIndicator.setValue(mostRecentByDrugIndicator);
    }


    /**
     * <p>Issue Filter Code</p>
     * 
     * <p><p>Indicates whether records to be returned (e.g. 
     * prescription order, prescription dispense and/or other 
     * medication) should be filtered to those with at least one 
     * persistent un-managed issue (against the record), with at 
     * least one persistent issues or should return all records, 
     * independent of the presence of persistent issues.</p></p>
     * 
     * <p><p>By filtering returned records to include only those 
     * which have unmanaged issues or any issues at all, allows a 
     * provider to focus on those aspects of care where extra 
     * attention is needed. Because the attribute must be known, it 
     * is mandatory.</p></p>
     */
    @Hl7XmlMapping({"issueFilterCode/value"})
    public IssueFilterCode getIssueFilterCode() {
        return (IssueFilterCode) this.issueFilterCode.getValue();
    }
    public void setIssueFilterCode(IssueFilterCode issueFilterCode) {
        this.issueFilterCode.setValue(issueFilterCode);
    }


    /**
     * <p>Amended in Time Range</p>
     * 
     * <p><p>Indicates that the returned records should be filtered 
     * to only include those which have been amended in some way 
     * (had status changed, been annotated, prescription was 
     * dispensed, etc.) within the indicated time-period. This will 
     * commonly be used to &quot;retrieve everything that has been 
     * amended since xxx&quot;.</p></p>
     * 
     * <p><p>Allows the requester to specify the event period of 
     * interest for the retrieval of medication 
     * records.</p><p>Useful for constraining run-away queries.</p></p>
     * 
     * <p><p>Allows the requester to specify the event period of 
     * interest for the retrieval of medication 
     * records.</p><p>Useful for constraining run-away queries.</p></p>
     */
    @Hl7XmlMapping({"amendedInTimeRange/value"})
    public Interval<Date> getAmendedInTimeRange() {
        return this.amendedInTimeRange.getValue();
    }
    public void setAmendedInTimeRange(Interval<Date> amendedInTimeRange) {
        this.amendedInTimeRange.setValue(amendedInTimeRange);
    }


    /**
     * <p>Care Composition IDs</p>
     * 
     * <p><p>Desc: Filters the records retrieved to only include 
     * those associated with the specified encounter, episode or 
     * care event. If unspecified, no filter is 
     * applied.</p><p>Note: When matching on care composition id, 
     * systems should also retrieve records with a fulfillment id 
     * to requisitions associated with the care composition. E.g. 
     * When retrieving records associated with an encounter which 
     * includes a referral, the retrieved records should also 
     * include the care summary created in fulfillment of the 
     * referral.</p></p>
     * 
     * <p><p>Desc: Filters the records retrieved to only include 
     * those associated with the specified encounter, episode or 
     * care event. If unspecified, no filter is 
     * applied.</p><p>Note: When matching on care composition id, 
     * systems should also retrieve records with a fulfillment id 
     * to requisitions associated with the care composition. E.g. 
     * When retrieving records associated with an encounter which 
     * includes a referral, the retrieved records should also 
     * include the care summary created in fulfillment of the 
     * referral.</p></p>
     * 
     * <p><p>Allows retrieving all records associated with an 
     * encounter, episode or care event.</p></p>
     */
    @Hl7XmlMapping({"careCompositionID/value"})
    public List<Identifier> getCareCompositionIDs() {
        return new RawListWrapper<II, Identifier>(careCompositionIDs, IIImpl.class);
    }


    /**
     * <p>Care Composition Types</p>
     * 
     * <p><p>Filters the records retrieved to only include those 
     * associated with the specified 'kind' of encounter, episode 
     * or care event. If unspecified, no filter is applied.</p></p>
     * 
     * <p><p>Allows retrieving all records associated with a 
     * particular type of encounter, episode or care event. 
     * E.g.Orthopedic Clinic Encounter, ER encounter, Walk-in 
     * encounter, etc.</p></p>
     */
    @Hl7XmlMapping({"careCompositionType/value"})
    public List<ActCareEventType> getCareCompositionTypes() {
        return new RawListWrapper<CV, ActCareEventType>(careCompositionTypes, CVImpl.class);
    }

}
