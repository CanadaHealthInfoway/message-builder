/**
 * Copyright 2013 Canada Health Infoway, Inc.
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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.iehr.repc_mt000016ca;

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
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActCareEventType;
import ca.infoway.messagebuilder.domainvalue.SubjectReaction;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Business Name: Adverse Reactions Query Parameters</p>
 * 
 * <p>Root class for query definition</p>
 * 
 * <p>Defines the set of parameters that may be used to filter 
 * the query response.</p>
 */
@Hl7PartTypeMapping({"REPC_MT000016CA.ParameterList"})
@Hl7RootType
public class AdverseReactionsQueryParametersBean extends MessagePartBean {

    private static final long serialVersionUID = 20150904L;
    private List<II> careCompositionIDValue = new ArrayList<II>();
    private List<CV> careCompositionTypeValue = new ArrayList<CV>();
    private BL includeNotesIndicatorValue = new BLImpl();
    private IVL<TS, Interval<Date>> reactionPeriodValue = new IVLImpl<TS, Interval<Date>>();
    private CV reactionTypeValue = new CVImpl();


    /**
     * <p>Business Name: Care Composition IDs</p>
     * 
     * <p>Relationship: REPC_MT000016CA.CareCompositionID.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows retrieving all records associated with an 
     * encounter, episode or care event.</p>
     * 
     * <p>Filters the records retrieved to only include those 
     * associated with the specified encounter, episode or care 
     * event. If unspecified, no filter is applied.</p><p>Note: 
     * When matching on care composition id, systems should also 
     * retrieve records with a fulfillment id to requisitions 
     * associated with the care composition. E.g. When retrieving 
     * records associated with an encounter which includes a 
     * referral, the retrieved records should also include the care 
     * summary created in fulfillment of the referral.</p>
     */
    @Hl7XmlMapping({"careCompositionID/value"})
    public List<Identifier> getCareCompositionIDValue() {
        return new RawListWrapper<II, Identifier>(careCompositionIDValue, IIImpl.class);
    }


    /**
     * <p>Business Name: Care Composition Types</p>
     * 
     * <p>Relationship: REPC_MT000016CA.CareCompositionType.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows retrieving all records associated with a 
     * particular type of encounter, episode or care event. 
     * E.g.Orthopedic Clinic Encounter, ER encounter, Walk-in 
     * encounter, etc.</p>
     * 
     * <p>Filters the records retrieved to only include those 
     * associated with the specified 'kind' of encounter, episode 
     * or care event. If unspecified, no filter is applied.</p>
     */
    @Hl7XmlMapping({"careCompositionType/value"})
    public List<ActCareEventType> getCareCompositionTypeValue() {
        return new RawListWrapper<CV, ActCareEventType>(careCompositionTypeValue, CVImpl.class);
    }


    /**
     * <p>Business Name: Include Notes Indicator</p>
     * 
     * <p>Relationship: REPC_MT000016CA.IncludeNotesIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the flexibility of omitting/including notes in 
     * the retrieval of information for adverse reactions 
     * data.</p><p>Because the attribute is boolean, it must 
     * explicitly indicate a 'TRUE' or 'FALSE', and thus it is 
     * mandatory.</p>
     * 
     * <p>Indicates whether or not notes attached to the adverse 
     * reactions records are to be returned along with the detailed 
     * information.</p>
     */
    @Hl7XmlMapping({"includeNotesIndicator/value"})
    public Boolean getIncludeNotesIndicatorValue() {
        return this.includeNotesIndicatorValue.getValue();
    }

    /**
     * <p>Business Name: Include Notes Indicator</p>
     * 
     * <p>Relationship: REPC_MT000016CA.IncludeNotesIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the flexibility of omitting/including notes in 
     * the retrieval of information for adverse reactions 
     * data.</p><p>Because the attribute is boolean, it must 
     * explicitly indicate a 'TRUE' or 'FALSE', and thus it is 
     * mandatory.</p>
     * 
     * <p>Indicates whether or not notes attached to the adverse 
     * reactions records are to be returned along with the detailed 
     * information.</p>
     */
    public void setIncludeNotesIndicatorValue(Boolean includeNotesIndicatorValue) {
        this.includeNotesIndicatorValue.setValue(includeNotesIndicatorValue);
    }


    /**
     * <p>Business Name: F:Reaction Period</p>
     * 
     * <p>Relationship: REPC_MT000016CA.ReactionPeriod.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the requester to specify the adverse reaction 
     * period of interest for retrieval of adverse reaction 
     * records. Useful to avoid run-away queries.</p>
     * 
     * <p>The period in which the recorded adverse reaction 
     * occurred or was updated. I.e. Filters the result-set to 
     * those reactions whose onset occurred within the time-range 
     * specified by this parameter.</p>
     */
    @Hl7XmlMapping({"reactionPeriod/value"})
    public Interval<Date> getReactionPeriodValue() {
        return this.reactionPeriodValue.getValue();
    }

    /**
     * <p>Business Name: F:Reaction Period</p>
     * 
     * <p>Relationship: REPC_MT000016CA.ReactionPeriod.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the requester to specify the adverse reaction 
     * period of interest for retrieval of adverse reaction 
     * records. Useful to avoid run-away queries.</p>
     * 
     * <p>The period in which the recorded adverse reaction 
     * occurred or was updated. I.e. Filters the result-set to 
     * those reactions whose onset occurred within the time-range 
     * specified by this parameter.</p>
     */
    public void setReactionPeriodValue(Interval<Date> reactionPeriodValue) {
        this.reactionPeriodValue.setValue(reactionPeriodValue);
    }


    /**
     * <p>Business Name: G:Reaction Type</p>
     * 
     * <p>Relationship: REPC_MT000016CA.ReactionType.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the requester to retrieve only those 
     * allergy/intolerance records for which there was a specific 
     * type of reaction.</p>
     * 
     * <p>Indicates that the result set be filtered to include only 
     * those allergy/intolerance records for which specific type of 
     * reaction was recorded.</p><p>Reaction types include: STEVEN 
     * JOHNSON, ANAPHYLAXIS, NAUSEA, etc</p>
     */
    @Hl7XmlMapping({"reactionType/value"})
    public SubjectReaction getReactionTypeValue() {
        return (SubjectReaction) this.reactionTypeValue.getValue();
    }

    /**
     * <p>Business Name: G:Reaction Type</p>
     * 
     * <p>Relationship: REPC_MT000016CA.ReactionType.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the requester to retrieve only those 
     * allergy/intolerance records for which there was a specific 
     * type of reaction.</p>
     * 
     * <p>Indicates that the result set be filtered to include only 
     * those allergy/intolerance records for which specific type of 
     * reaction was recorded.</p><p>Reaction types include: STEVEN 
     * JOHNSON, ANAPHYLAXIS, NAUSEA, etc</p>
     */
    public void setReactionTypeValue(SubjectReaction reactionTypeValue) {
        this.reactionTypeValue.setValue(reactionTypeValue);
    }

}
