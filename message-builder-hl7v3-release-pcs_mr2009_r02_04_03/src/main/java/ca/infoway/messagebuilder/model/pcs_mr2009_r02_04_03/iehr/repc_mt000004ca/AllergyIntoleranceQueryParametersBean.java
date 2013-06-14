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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.iehr.repc_mt000004ca;

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
 * <p>Business Name: Allergy/Intolerance Query Parameters</p>
 * 
 * <p>Root class for query definition</p>
 * 
 * <p>Defines the set of parameters that may be used to filter 
 * the query response</p>
 */
@Hl7PartTypeMapping({"REPC_MT000004CA.ParameterList"})
@Hl7RootType
public class AllergyIntoleranceQueryParametersBean extends MessagePartBean {

    private static final long serialVersionUID = 20130613L;
    private CV allergyIntoleranceStatusValue = new CVImpl();
    private CD allergyIntoleranceTypeValue = new CDImpl();
    private IVL<TS, Interval<Date>> alllergyIntoleranceChangePeriodValue = new IVLImpl<TS, Interval<Date>>();
    private List<II> careCompositionIDValue = new ArrayList<II>();
    private List<CV> careCompositionTypeValue = new ArrayList<CV>();
    private BL includeNotesIndicatorValue = new BLImpl();
    private CV reactionTypeValue = new CVImpl();


    /**
     * <p>Business Name: G:Allergy/Intolerance Status</p>
     * 
     * <p>Relationship: 
     * REPC_MT000004CA.AllergyIntoleranceStatus.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the selective retrieval of allergy/intolerance 
     * records based on the status of the record.</p>
     * 
     * <p>Indicates that the result set should be filtered to 
     * include only those allergy/intolerance records for the 
     * specified status. Valid statuses include: ACTIVE or 
     * COMPLETE.</p>
     */
    @Hl7XmlMapping({"allergyIntoleranceStatus/value"})
    public ActStatus getAllergyIntoleranceStatusValue() {
        return (ActStatus) this.allergyIntoleranceStatusValue.getValue();
    }

    /**
     * <p>Business Name: G:Allergy/Intolerance Status</p>
     * 
     * <p>Relationship: 
     * REPC_MT000004CA.AllergyIntoleranceStatus.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the selective retrieval of allergy/intolerance 
     * records based on the status of the record.</p>
     * 
     * <p>Indicates that the result set should be filtered to 
     * include only those allergy/intolerance records for the 
     * specified status. Valid statuses include: ACTIVE or 
     * COMPLETE.</p>
     */
    public void setAllergyIntoleranceStatusValue(ActStatus allergyIntoleranceStatusValue) {
        this.allergyIntoleranceStatusValue.setValue(allergyIntoleranceStatusValue);
    }


    /**
     * <p>Business Name: H:Allergy/Intolerance Type</p>
     * 
     * <p>Relationship: 
     * REPC_MT000004CA.AllergyIntoleranceType.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows allergy/intolerance records to be selectively 
     * searched and retrieved.</p>
     * 
     * <p>A coded value indicating whether to return an allergy 
     * record or an intolerance record. The result set will be 
     * filtered to include only allergy records or intolerance 
     * records accordingly.</p>
     */
    @Hl7XmlMapping({"allergyIntoleranceType/value"})
    public ObservationIntoleranceType getAllergyIntoleranceTypeValue() {
        return (ObservationIntoleranceType) this.allergyIntoleranceTypeValue.getValue();
    }

    /**
     * <p>Business Name: H:Allergy/Intolerance Type</p>
     * 
     * <p>Relationship: 
     * REPC_MT000004CA.AllergyIntoleranceType.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows allergy/intolerance records to be selectively 
     * searched and retrieved.</p>
     * 
     * <p>A coded value indicating whether to return an allergy 
     * record or an intolerance record. The result set will be 
     * filtered to include only allergy records or intolerance 
     * records accordingly.</p>
     */
    public void setAllergyIntoleranceTypeValue(ObservationIntoleranceType allergyIntoleranceTypeValue) {
        this.allergyIntoleranceTypeValue.setValue(allergyIntoleranceTypeValue);
    }


    /**
     * <p>Business Name: F:Allergy/Intolerance Change Period</p>
     * 
     * <p>Relationship: 
     * REPC_MT000004CA.AlllergyIntoleranceChangePeriod.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Useful in retrieving incremental changes to the patient's 
     * record.</p>
     * 
     * <p>Filters the query response to only include 
     * allergy/intolerance records which have been created or 
     * modified within the date-range specified.</p>
     */
    @Hl7XmlMapping({"alllergyIntoleranceChangePeriod/value"})
    public Interval<Date> getAlllergyIntoleranceChangePeriodValue() {
        return this.alllergyIntoleranceChangePeriodValue.getValue();
    }

    /**
     * <p>Business Name: F:Allergy/Intolerance Change Period</p>
     * 
     * <p>Relationship: 
     * REPC_MT000004CA.AlllergyIntoleranceChangePeriod.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Useful in retrieving incremental changes to the patient's 
     * record.</p>
     * 
     * <p>Filters the query response to only include 
     * allergy/intolerance records which have been created or 
     * modified within the date-range specified.</p>
     */
    public void setAlllergyIntoleranceChangePeriodValue(Interval<Date> alllergyIntoleranceChangePeriodValue) {
        this.alllergyIntoleranceChangePeriodValue.setValue(alllergyIntoleranceChangePeriodValue);
    }


    /**
     * <p>Business Name: Care Composition IDs</p>
     * 
     * <p>Relationship: REPC_MT000004CA.CareCompositionID.value</p>
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
     * <p>Relationship: REPC_MT000004CA.CareCompositionType.value</p>
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
     * <p>Relationship: REPC_MT000004CA.IncludeNotesIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the flexibility of omitting/including notes in 
     * the retrieval of information for allergy/intolerance 
     * data.</p><p>Because the attribute is boolean, it must 
     * explicitly indicate a 'TRUE' or 'FALSE', and thus it is 
     * mandatory.</p>
     * 
     * <p>Indicates whether or not notes attached to the 
     * allergy/intolerance records are to be returned along with 
     * the detailed information.</p>
     */
    @Hl7XmlMapping({"includeNotesIndicator/value"})
    public Boolean getIncludeNotesIndicatorValue() {
        return this.includeNotesIndicatorValue.getValue();
    }

    /**
     * <p>Business Name: Include Notes Indicator</p>
     * 
     * <p>Relationship: REPC_MT000004CA.IncludeNotesIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the flexibility of omitting/including notes in 
     * the retrieval of information for allergy/intolerance 
     * data.</p><p>Because the attribute is boolean, it must 
     * explicitly indicate a 'TRUE' or 'FALSE', and thus it is 
     * mandatory.</p>
     * 
     * <p>Indicates whether or not notes attached to the 
     * allergy/intolerance records are to be returned along with 
     * the detailed information.</p>
     */
    public void setIncludeNotesIndicatorValue(Boolean includeNotesIndicatorValue) {
        this.includeNotesIndicatorValue.setValue(includeNotesIndicatorValue);
    }


    /**
     * <p>Business Name: I:Reaction</p>
     * 
     * <p>Relationship: REPC_MT000004CA.ReactionType.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows allergy/intolerance records to be selectively 
     * searched and retrieved.</p>
     * 
     * <p>A coded value denoting a specific reaction. E.g. Code for 
     * 'rash'. The result set will be filtered to include only 
     * those allergy records or intolerance records pertaining to 
     * the specified reaction.</p>
     */
    @Hl7XmlMapping({"reactionType/value"})
    public SubjectReaction getReactionTypeValue() {
        return (SubjectReaction) this.reactionTypeValue.getValue();
    }

    /**
     * <p>Business Name: I:Reaction</p>
     * 
     * <p>Relationship: REPC_MT000004CA.ReactionType.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows allergy/intolerance records to be selectively 
     * searched and retrieved.</p>
     * 
     * <p>A coded value denoting a specific reaction. E.g. Code for 
     * 'rash'. The result set will be filtered to include only 
     * those allergy records or intolerance records pertaining to 
     * the specified reaction.</p>
     */
    public void setReactionTypeValue(SubjectReaction reactionTypeValue) {
        this.reactionTypeValue.setValue(reactionTypeValue);
    }

}
