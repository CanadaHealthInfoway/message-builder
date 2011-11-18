/**
 * Copyright 2011 Canada Health Infoway, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.merged;

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
 * <p>REPC_MT000016CA.ParameterList: Adverse Reactions Query 
 * Parameters</p>
 * 
 * <p><p>Defines the set of parameters that may be used to 
 * filter the query response.</p></p>
 * 
 * <p><p>Root class for query definition</p></p>
 * 
 * <p>PORX_MT060280CA.ParameterList: Drug Prescription Detail 
 * Query Parameters</p>
 * 
 * <p><p>Defines the set of parameters that may be used to 
 * filter the query response.</p></p>
 * 
 * <p><p>Root class for query definition.</p></p>
 * 
 * <p>REPC_MT000004CA.ParameterList: Allergy/Intolerance Query 
 * Parameters</p>
 * 
 * <p><p>Defines the set of parameters that may be used to 
 * filter the query response</p></p>
 * 
 * <p><p>Root class for query definition</p></p>
 * 
 * <p>PORX_MT060360CA.ParameterList: Generic Query Parameters</p>
 * 
 * <p><p>Defines the set of parameters that may be used to 
 * filter the query response.</p></p>
 * 
 * <p><p>Root class for query definition</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT060280CA.ParameterList","PORX_MT060360CA.ParameterList","REPC_MT000004CA.ParameterList","REPC_MT000016CA.ParameterList"})
@Hl7RootType
public class GenericQueryParametersBean extends MessagePartBean {

    private static final long serialVersionUID = 20111117L;
    private List<II> careCompositionIDValue = new ArrayList<II>();
    private List<CV> careCompositionTypeValue = new ArrayList<CV>();
    private BL includeNotesIndicatorValue = new BLImpl();
    private IVL<TS, Interval<Date>> reactionPeriodValue = new IVLImpl<TS, Interval<Date>>();
    private CV reactionTypeValue = new CVImpl();
    private IVL<TS, Interval<Date>> amendedInTimeRangeValue = new IVLImpl<TS, Interval<Date>>();
    private BL includeEventHistoryIndicatorValue = new BLImpl();
    private BL includeIssuesIndicatorValue = new BLImpl();
    private BL includePendingChangesIndicatorValue = new BLImpl();
    private II prescriptionOrderNumberValue = new IIImpl();
    private CV allergyIntoleranceStatusValue = new CVImpl();
    private CD allergyIntoleranceTypeValue = new CDImpl();
    private IVL<TS, Interval<Date>> alllergyIntoleranceChangePeriodValue = new IVLImpl<TS, Interval<Date>>();
    private II prescriptionDispenseNumberValue = new IIImpl();


    /**
     * <p>CareCompositionIDs</p>
     * 
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
     * 
     * <p>Care Composition IDs</p>
     * 
     * <p><p>Filters the records retrieved to only include those 
     * associated with the specified encounter, episode or care 
     * event. If unspecified, no filter is applied.</p><p>Note: 
     * When matching on care composition id, systems should also 
     * retrieve records with a fulfillment id to requisitions 
     * associated with the care composition. E.g. When retrieving 
     * records associated with an encounter which includes a 
     * referral, the retrieved records should also include the care 
     * summary created in fulfillment of the referral.</p></p>
     * 
     * <p><p>Filters the records retrieved to only include those 
     * associated with the specified encounter, episode or care 
     * event. If unspecified, no filter is applied.</p><p>Note: 
     * When matching on care composition id, systems should also 
     * retrieve records with a fulfillment id to requisitions 
     * associated with the care composition. E.g. When retrieving 
     * records associated with an encounter which includes a 
     * referral, the retrieved records should also include the care 
     * summary created in fulfillment of the referral.</p></p>
     * 
     * <p><p>Allows retrieving all records associated with an 
     * encounter, episode or care event.</p></p>
     */
    @Hl7XmlMapping({"careCompositionID/value"})
    public List<Identifier> getCareCompositionIDValue() {
        return new RawListWrapper<II, Identifier>(careCompositionIDValue, IIImpl.class);
    }


    /**
     * <p>CareCompositionTypes</p>
     * 
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
    public List<ActCareEventType> getCareCompositionTypeValue() {
        return new RawListWrapper<CV, ActCareEventType>(careCompositionTypeValue, CVImpl.class);
    }


    /**
     * <p>IncludeNotesIndicator</p>
     * 
     * <p>Include Notes Indicator</p>
     * 
     * <p><p>Indicates whether or not notes attached to the 
     * allergy/intolerance records are to be returned along with 
     * the detailed information.</p></p>
     * 
     * <p><p>Allows for the flexibility of omitting/including notes 
     * in the retrieval of information for allergy/intolerance 
     * data.</p><p>Because the attribute is boolean, it must 
     * explicitly indicate a 'TRUE' or 'FALSE', and thus it is 
     * mandatory.</p></p>
     * 
     * <p><p>Allows for the flexibility of omitting/including notes 
     * in the retrieval of information for allergy/intolerance 
     * data.</p><p>Because the attribute is boolean, it must 
     * explicitly indicate a 'TRUE' or 'FALSE', and thus it is 
     * mandatory.</p></p>
     * 
     * <p>Include Notes Indicator</p>
     * 
     * <p><p>Indicates whether or not notes attached to the 
     * prescription dispense record are to be returned along with 
     * the detailed information.</p></p>
     * 
     * <p><p>Allows for the flexibility of omitting/including notes 
     * in the retrieval of information for medication detail 
     * data.</p><p>Because the attribute is boolean, it must 
     * explicitly indicate a 'TRUE' or 'FALSE', and thus it is 
     * mandatory.</p></p>
     * 
     * <p><p>Allows for the flexibility of omitting/including notes 
     * in the retrieval of information for medication detail 
     * data.</p><p>Because the attribute is boolean, it must 
     * explicitly indicate a 'TRUE' or 'FALSE', and thus it is 
     * mandatory.</p></p>
     * 
     * <p>Include Notes Indicator</p>
     * 
     * <p><p>Indicates whether or not notes attached to the 
     * selected medication records are to be returned along with 
     * the detailed information.</p></p>
     * 
     * <p><p>Allows for the flexibility of omitting/including notes 
     * in the retrieval of information for medication 
     * data.</p><p>Because the attribute is boolean, it must 
     * explicitly indicate a 'TRUE' or 'FALSE', and thus it is 
     * mandatory.</p></p>
     * 
     * <p><p>Allows for the flexibility of omitting/including notes 
     * in the retrieval of information for medication 
     * data.</p><p>Because the attribute is boolean, it must 
     * explicitly indicate a 'TRUE' or 'FALSE', and thus it is 
     * mandatory.</p></p>
     * 
     * <p>Include Notes Indicator</p>
     * 
     * <p><p>Indicates whether or not notes attached to the adverse 
     * reactions records are to be returned along with the detailed 
     * information.</p></p>
     * 
     * <p><p>Allows for the flexibility of omitting/including notes 
     * in the retrieval of information for adverse reactions 
     * data.</p><p>Because the attribute is boolean, it must 
     * explicitly indicate a 'TRUE' or 'FALSE', and thus it is 
     * mandatory.</p></p>
     * 
     * <p><p>Allows for the flexibility of omitting/including notes 
     * in the retrieval of information for adverse reactions 
     * data.</p><p>Because the attribute is boolean, it must 
     * explicitly indicate a 'TRUE' or 'FALSE', and thus it is 
     * mandatory.</p></p>
     */
    @Hl7XmlMapping({"includeNotesIndicator/value"})
    public Boolean getIncludeNotesIndicatorValue() {
        return this.includeNotesIndicatorValue.getValue();
    }
    public void setIncludeNotesIndicatorValue(Boolean includeNotesIndicatorValue) {
        this.includeNotesIndicatorValue.setValue(includeNotesIndicatorValue);
    }


    /**
     * <p>ReactionPeriod</p>
     * 
     * <p>F:Reaction Period</p>
     * 
     * <p><p>The period in which the recorded adverse reaction 
     * occurred or was updated. I.e. Filters the result-set to 
     * those reactions whose onset occurred within the time-range 
     * specified by this parameter.</p></p>
     * 
     * <p><p>Allows the requester to specify the adverse reaction 
     * period of interest for retrieval of adverse reaction 
     * records. Useful to avoid run-away queries.</p></p>
     */
    @Hl7XmlMapping({"reactionPeriod/value"})
    public Interval<Date> getReactionPeriodValue() {
        return this.reactionPeriodValue.getValue();
    }
    public void setReactionPeriodValue(Interval<Date> reactionPeriodValue) {
        this.reactionPeriodValue.setValue(reactionPeriodValue);
    }


    /**
     * <p>G:Reaction Type</p>
     * 
     * <p><p>Indicates that the result set be filtered to include 
     * only those allergy/intolerance records for which specific 
     * type of reaction was recorded.</p><p>Reaction types include: 
     * STEVEN JOHNSON, ANAPHYLAXIS, NAUSEA, etc</p></p>
     * 
     * <p><p>Indicates that the result set be filtered to include 
     * only those allergy/intolerance records for which specific 
     * type of reaction was recorded.</p><p>Reaction types include: 
     * STEVEN JOHNSON, ANAPHYLAXIS, NAUSEA, etc</p></p>
     * 
     * <p><p>Allows the requester to retrieve only those 
     * allergy/intolerance records for which there was a specific 
     * type of reaction.</p></p>
     * 
     * <p>I:Reaction</p>
     * 
     * <p><p>A coded value denoting a specific reaction. E.g. Code 
     * for 'rash'. The result set will be filtered to include only 
     * those allergy records or intolerance records pertaining to 
     * the specified reaction.</p></p>
     * 
     * <p><p>Allows allergy/intolerance records to be selectively 
     * searched and retrieved.</p></p>
     */
    @Hl7XmlMapping({"reactionType/value"})
    public SubjectReaction getReactionTypeValue() {
        return (SubjectReaction) this.reactionTypeValue.getValue();
    }
    public void setReactionTypeValue(SubjectReaction reactionTypeValue) {
        this.reactionTypeValue.setValue(reactionTypeValue);
    }


    /**
     * <p>AmendedInTimeRange</p>
     * 
     * <p>Amended in Time Range</p>
     * 
     * <p><p>Indicates that the returned records should be filtered 
     * to only include those which have been amended in some way 
     * (had status changed, been annotated, prescription was 
     * dispensed, etc.) within the indicated time-period. This will 
     * commonly be used to 'retrieve everything that has been 
     * amended since xxx'.</p></p>
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
    public Interval<Date> getAmendedInTimeRangeValue() {
        return this.amendedInTimeRangeValue.getValue();
    }
    public void setAmendedInTimeRangeValue(Interval<Date> amendedInTimeRangeValue) {
        this.amendedInTimeRangeValue.setValue(amendedInTimeRangeValue);
    }


    /**
     * <p>IncludeEventHistoryIndicator</p>
     * 
     * <p>Include Event History Indicator</p>
     * 
     * <p><p>Indicates whether or not history of selected 
     * medication records are to be returned along with the 
     * detailed information.</p><p>&quot;Pending&quot; changes will 
     * be returned regardless of the setting of this flag.</p></p>
     * 
     * <p><p>Indicates whether or not history of selected 
     * medication records are to be returned along with the 
     * detailed information.</p><p>&quot;Pending&quot; changes will 
     * be returned regardless of the setting of this flag.</p></p>
     * 
     * <p><p>Allows for the flexibility of omitting/including 
     * history in the retrieval of the requested 
     * information.</p><p>Because the attribute is always either 
     * 'TRUE' or 'FALSE' it is mandatory.</p></p>
     * 
     * <p><p>Allows for the flexibility of omitting/including 
     * history in the retrieval of the requested 
     * information.</p><p>Because the attribute is always either 
     * 'TRUE' or 'FALSE' it is mandatory.</p></p>
     */
    @Hl7XmlMapping({"includeEventHistoryIndicator/value"})
    public Boolean getIncludeEventHistoryIndicatorValue() {
        return this.includeEventHistoryIndicatorValue.getValue();
    }
    public void setIncludeEventHistoryIndicatorValue(Boolean includeEventHistoryIndicatorValue) {
        this.includeEventHistoryIndicatorValue.setValue(includeEventHistoryIndicatorValue);
    }


    /**
     * <p>IncludeIssuesIndicator</p>
     * 
     * <p>Include Issues Indicator</p>
     * 
     * <p><p>Indicates whether or not issues (detected and/or 
     * managed) attached to the prescriptions, dispenses and other 
     * active medication records are to be returned along with the 
     * detailed information.</p></p>
     * 
     * <p><p>Allows for the flexibility of omitting/including 
     * issues in the retrieval of medication detail profile 
     * data.</p><p>Because the attribute is boolean, it must 
     * explicitly indicate a 'TRUE' or 'FALSE', and thus it is 
     * mandatory.</p></p>
     * 
     * <p><p>Allows for the flexibility of omitting/including 
     * issues in the retrieval of medication detail profile 
     * data.</p><p>Because the attribute is boolean, it must 
     * explicitly indicate a 'TRUE' or 'FALSE', and thus it is 
     * mandatory.</p></p>
     * 
     * <p>Include Issues Indicator</p>
     * 
     * <p><p>Indicates whether or not Issues (detected and/or 
     * managed) attached to the prescription dispense record to be 
     * returned along with the detailed information.</p></p>
     * 
     * <p><p>Allows for the flexibility of omitting/including 
     * issues in the retrieval of patient medication 
     * data.</p><p>Because the attribute is boolean, it must 
     * explicitly indicate a 'TRUE' or 'FALSE', and thus it is 
     * mandatory.</p></p>
     * 
     * <p><p>Allows for the flexibility of omitting/including 
     * issues in the retrieval of patient medication 
     * data.</p><p>Because the attribute is boolean, it must 
     * explicitly indicate a 'TRUE' or 'FALSE', and thus it is 
     * mandatory.</p></p>
     */
    @Hl7XmlMapping({"includeIssuesIndicator/value"})
    public Boolean getIncludeIssuesIndicatorValue() {
        return this.includeIssuesIndicatorValue.getValue();
    }
    public void setIncludeIssuesIndicatorValue(Boolean includeIssuesIndicatorValue) {
        this.includeIssuesIndicatorValue.setValue(includeIssuesIndicatorValue);
    }


    /**
     * <p>IncludePendingChangesIndicator</p>
     * 
     * <p>Include Pending Changes Indicator</p>
     * 
     * <p><p>Indicates whether to include future changes (e.g. 
     * status changes that aren't effective yet) associated with a 
     * prescription order and/or prescription dispense are to be 
     * returned along with the detailed information.</p></p>
     * 
     * <p><p>Allows for the flexibility of omitting/including 
     * future events in the retrieval of the requested 
     * information.</p><p>Because the attribute is boolean, it must 
     * explicitly indicate a 'TRUE' or 'FALSE', and thus it is 
     * mandatory.</p></p>
     * 
     * <p><p>Allows for the flexibility of omitting/including 
     * future events in the retrieval of the requested 
     * information.</p><p>Because the attribute is boolean, it must 
     * explicitly indicate a 'TRUE' or 'FALSE', and thus it is 
     * mandatory.</p></p>
     */
    @Hl7XmlMapping({"includePendingChangesIndicator/value"})
    public Boolean getIncludePendingChangesIndicatorValue() {
        return this.includePendingChangesIndicatorValue.getValue();
    }
    public void setIncludePendingChangesIndicatorValue(Boolean includePendingChangesIndicatorValue) {
        this.includePendingChangesIndicatorValue.setValue(includePendingChangesIndicatorValue);
    }


    /**
     * <p>PrescriptionOrderNumber</p>
     * 
     * <p>Prescription order Number</p>
     * 
     * <p><p>Identifier of the prescription for which detailed 
     * information is required.</p><p>The result set will be 
     * filtered to only the specific prescription.</p></p>
     * 
     * <p><p>Identifier of the prescription for which detailed 
     * information is required.</p><p>The result set will be 
     * filtered to only the specific prescription.</p></p>
     * 
     * <p><p>Identifies the prescription that is to be retrieved, 
     * and is therefore mandatory.</p></p>
     */
    @Hl7XmlMapping({"prescriptionOrderNumber/value"})
    public Identifier getPrescriptionOrderNumberValue() {
        return this.prescriptionOrderNumberValue.getValue();
    }
    public void setPrescriptionOrderNumberValue(Identifier prescriptionOrderNumberValue) {
        this.prescriptionOrderNumberValue.setValue(prescriptionOrderNumberValue);
    }


    /**
     * <p>AllergyIntoleranceStatus</p>
     * 
     * <p>G:Allergy/Intolerance Status</p>
     * 
     * <p><p>Indicates that the result set should be filtered to 
     * include only those allergy/intolerance records for the 
     * specified status. Valid statuses include: ACTIVE or 
     * COMPLETE.</p></p>
     * 
     * <p><p>Allows for the selective retrieval of 
     * allergy/intolerance records based on the status of the 
     * record.</p></p>
     */
    @Hl7XmlMapping({"allergyIntoleranceStatus/value"})
    public ActStatus getAllergyIntoleranceStatusValue() {
        return (ActStatus) this.allergyIntoleranceStatusValue.getValue();
    }
    public void setAllergyIntoleranceStatusValue(ActStatus allergyIntoleranceStatusValue) {
        this.allergyIntoleranceStatusValue.setValue(allergyIntoleranceStatusValue);
    }


    /**
     * <p>AllergyIntoleranceType</p>
     * 
     * <p>H:Allergy/Intolerance Type</p>
     * 
     * <p><p>A coded value indicating whether to return an allergy 
     * record or an intolerance record. The result set will be 
     * filtered to include only allergy records or intolerance 
     * records accordingly.</p></p>
     * 
     * <p><p>Allows allergy/intolerance records to be selectively 
     * searched and retrieved.</p></p>
     */
    @Hl7XmlMapping({"allergyIntoleranceType/value"})
    public ObservationIntoleranceType getAllergyIntoleranceTypeValue() {
        return (ObservationIntoleranceType) this.allergyIntoleranceTypeValue.getValue();
    }
    public void setAllergyIntoleranceTypeValue(ObservationIntoleranceType allergyIntoleranceTypeValue) {
        this.allergyIntoleranceTypeValue.setValue(allergyIntoleranceTypeValue);
    }


    /**
     * <p>AllergyIntoleranceChangePeriod</p>
     * 
     * <p>F:Allergy/Intolerance Change Period</p>
     * 
     * <p><p>Filters the query response to only include 
     * allergy/intolerance records which have been created or 
     * modified within the date-range specified.</p></p>
     * 
     * <p><p>Useful in retrieving incremental changes to the 
     * patient's record.</p></p>
     */
    @Hl7XmlMapping({"alllergyIntoleranceChangePeriod/value"})
    public Interval<Date> getAlllergyIntoleranceChangePeriodValue() {
        return this.alllergyIntoleranceChangePeriodValue.getValue();
    }
    public void setAlllergyIntoleranceChangePeriodValue(Interval<Date> alllergyIntoleranceChangePeriodValue) {
        this.alllergyIntoleranceChangePeriodValue.setValue(alllergyIntoleranceChangePeriodValue);
    }


    /**
     * <p>PrescriptionDispenseNumber</p>
     * 
     * <p>D:Prescription Dispense Number</p>
     * 
     * <p><p>Identifies which prescription dispense record should 
     * be retrieved.</p></p>
     * 
     * <p><p>Allows for the retrieval of medication records 
     * relating to a specific dispense record. A dispense cannot be 
     * retrieved without the identifier of the record, and the 
     * attribute is therefore mandatory.</p></p>
     */
    @Hl7XmlMapping({"prescriptionDispenseNumber/value"})
    public Identifier getPrescriptionDispenseNumberValue() {
        return this.prescriptionDispenseNumberValue.getValue();
    }
    public void setPrescriptionDispenseNumberValue(Identifier prescriptionDispenseNumberValue) {
        this.prescriptionDispenseNumberValue.setValue(prescriptionDispenseNumberValue);
    }

}
