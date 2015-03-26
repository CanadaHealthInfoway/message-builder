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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.iehr.repc_mt210004ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.RawListWrapper;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActCareEventType;
import ca.infoway.messagebuilder.domainvalue.ActCareProvisionRequestType;
import ca.infoway.messagebuilder.domainvalue.ActHealthConditionType;
import ca.infoway.messagebuilder.domainvalue.ActIndicationType;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.HealthcareProviderRoleType;
import ca.infoway.messagebuilder.domainvalue.ReferralDocumentType;
import ca.infoway.messagebuilder.domainvalue.ServiceDeliveryLocationRoleType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Business Name: Query Definition</p>
 * 
 * <p>Allows the user and/or the point-of-service application 
 * to constrain what EHR information they wish to retrieve.</p>
 * 
 * <p>Identifies the various parameters that act as filters on 
 * the records to be retrieved.</p>
 */
@Hl7PartTypeMapping({"REPC_MT210004CA.ParameterList"})
@Hl7RootType
public class QueryDefinitionBean extends MessagePartBean {

    private static final long serialVersionUID = 20150326L;
    private TS amendedSinceDateTimeValue = new TSImpl();
    private BL attestedIndicatorValue = new BLImpl();
    private List<II> careCompositionIdValue = new ArrayList<II>();
    private List<CV> careCompositionTypeValue = new ArrayList<CV>();
    private II eHRRepositoryIdValue = new IIImpl();
    private IVL<TS, Interval<Date>> effectiveTimeRangeValue = new IVLImpl<TS, Interval<Date>>();
    private List<CV> eventCategoryValue = new ArrayList<CV>();
    private II eventLocationIdValue = new IIImpl();
    private CV eventLocationTypeValue = new CVImpl();
    private List<CD> healthConditionValue = new ArrayList<CD>();
    private CD indicationValue = new CDImpl();
    private BL mostRecentByTypeIndicatorValue = new BLImpl();
    private List<II> protocolIdValue = new ArrayList<II>();
    private II recipientLocationIdValue = new IIImpl();
    private II recipientProviderIdValue = new IIImpl();
    private List<CS> recordStatusValue = new ArrayList<CS>();
    private List<CD> recordTypeValue = new ArrayList<CD>();
    private II requestingProviderIdValue = new IIImpl();
    private II responsibleProviderIdValue = new IIImpl();
    private CV responsibleProviderTypeValue = new CVImpl();


    /**
     * <p>Business Name: K: Updated Since DateTime</p>
     * 
     * <p>Relationship: REPC_MT210004CA.AmendedSinceDateTime.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Useful to retrieve information &quot;since you last 
     * checked&quot;.</p>
     * 
     * <p>Filters the records retrieved to only include those which 
     * have been created or revised since the specified date and 
     * time. If unspecified, no filter is applied.</p>
     */
    @Hl7XmlMapping({"amendedSinceDateTime/value"})
    public Date getAmendedSinceDateTimeValue() {
        return this.amendedSinceDateTimeValue.getValue();
    }

    /**
     * <p>Business Name: K: Updated Since DateTime</p>
     * 
     * <p>Relationship: REPC_MT210004CA.AmendedSinceDateTime.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Useful to retrieve information &quot;since you last 
     * checked&quot;.</p>
     * 
     * <p>Filters the records retrieved to only include those which 
     * have been created or revised since the specified date and 
     * time. If unspecified, no filter is applied.</p>
     */
    public void setAmendedSinceDateTimeValue(Date amendedSinceDateTimeValue) {
        this.amendedSinceDateTimeValue.setValue(amendedSinceDateTimeValue);
    }


    /**
     * <p>Business Name: ZM: Attested Indicator</p>
     * 
     * <p>Relationship: REPC_MT210004CA.AttestedIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows filtering to only see those documents which are 
     * &quot;known&quot; to be accurate. May also be used to 
     * retrieve documents associated with a provider which are 
     * unauthenticated.</p>
     * 
     * <p>If specified, filters the returned documents to only 
     * include those which have been attested as correct by the 
     * document author or which have not been authenticated. If not 
     * specified, both attested and non-attested documents will be 
     * returned. Relevant for transcribed reports (e.g. the data 
     * enterer is different than the 'author'). Records where 
     * &quot;attestation&quot; is marked as &quot;Not 
     * applicable&quot; will be treated as attested.</p>
     */
    @Hl7XmlMapping({"attestedIndicator/value"})
    public Boolean getAttestedIndicatorValue() {
        return this.attestedIndicatorValue.getValue();
    }

    /**
     * <p>Business Name: ZM: Attested Indicator</p>
     * 
     * <p>Relationship: REPC_MT210004CA.AttestedIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows filtering to only see those documents which are 
     * &quot;known&quot; to be accurate. May also be used to 
     * retrieve documents associated with a provider which are 
     * unauthenticated.</p>
     * 
     * <p>If specified, filters the returned documents to only 
     * include those which have been attested as correct by the 
     * document author or which have not been authenticated. If not 
     * specified, both attested and non-attested documents will be 
     * returned. Relevant for transcribed reports (e.g. the data 
     * enterer is different than the 'author'). Records where 
     * &quot;attestation&quot; is marked as &quot;Not 
     * applicable&quot; will be treated as attested.</p>
     */
    public void setAttestedIndicatorValue(Boolean attestedIndicatorValue) {
        this.attestedIndicatorValue.setValue(attestedIndicatorValue);
    }


    /**
     * <p>Business Name: R: Care Composition Ids</p>
     * 
     * <p>Relationship: REPC_MT210004CA.CareCompositionId.value</p>
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
    @Hl7XmlMapping({"careCompositionId/value"})
    public List<Identifier> getCareCompositionIdValue() {
        return new RawListWrapper<II, Identifier>(careCompositionIdValue, IIImpl.class);
    }


    /**
     * <p>Business Name: S: Care Composition Types</p>
     * 
     * <p>Relationship: REPC_MT210004CA.CareCompositionType.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows retrieving all records associated with a 
     * particular type of encounter, episode or care event. E.g. 
     * Orthopedic Clinic Encounter, ER encounter, Walk-in 
     * encounter, etc.</p>
     * 
     * <p>Filters the records retrieved to only include those 
     * associated with the specified 'kind' of encounter, episode 
     * or care event. If unspecified, no filter is applied.</p><p> 
     * <i>Query results should include those with an match of this 
     * code, as well those matching any specializations of the 
     * coded parameter.</i> </p>
     */
    @Hl7XmlMapping({"careCompositionType/value"})
    public List<ActCareEventType> getCareCompositionTypeValue() {
        return new RawListWrapper<CV, ActCareEventType>(careCompositionTypeValue, CVImpl.class);
    }


    /**
     * <p>Business Name: Q: EHR Repository Id</p>
     * 
     * <p>Relationship: REPC_MT210004CA.EHRRepositoryId.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Primarily intended to allow filtering an initial search 
     * to a local EHR repository for performance reasons.</p>
     * 
     * <p>Filters the records retrieved to only include those 
     * records from a specific EHR repository. If unspecified, all 
     * &quot;connected&quot; EHR repositories will be searched.</p>
     */
    @Hl7XmlMapping({"eHRRepositoryId/value"})
    public Identifier getEHRRepositoryIdValue() {
        return this.eHRRepositoryIdValue.getValue();
    }

    /**
     * <p>Business Name: Q: EHR Repository Id</p>
     * 
     * <p>Relationship: REPC_MT210004CA.EHRRepositoryId.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Primarily intended to allow filtering an initial search 
     * to a local EHR repository for performance reasons.</p>
     * 
     * <p>Filters the records retrieved to only include those 
     * records from a specific EHR repository. If unspecified, all 
     * &quot;connected&quot; EHR repositories will be searched.</p>
     */
    public void setEHRRepositoryIdValue(Identifier eHRRepositoryIdValue) {
        this.eHRRepositoryIdValue.setValue(eHRRepositoryIdValue);
    }


    /**
     * <p>Business Name: J: Effective Date Range</p>
     * 
     * <p>Relationship: REPC_MT210004CA.EffectiveTimeRange.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows constraining the retrieved records to those 
     * applicable at a particular time. Useful in retrieving those 
     * records &quot;currently in effect&quot; as well as 
     * retrieving views of what information was in effect at some 
     * date in the past.</p>
     * 
     * <p>Filters the set of records to be retrieved to those which 
     * occurred or were effective for the patient within the date 
     * boundaries specified. Either the lower bound or upper bound 
     * or both would be specified. If no value is specified, no 
     * filter will be applied. If there is any overlap between the 
     * specified date-range and the effective date of the record, 
     * the record will be returned.</p>
     */
    @Hl7XmlMapping({"effectiveTimeRange/value"})
    public Interval<Date> getEffectiveTimeRangeValue() {
        return this.effectiveTimeRangeValue.getValue();
    }

    /**
     * <p>Business Name: J: Effective Date Range</p>
     * 
     * <p>Relationship: REPC_MT210004CA.EffectiveTimeRange.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows constraining the retrieved records to those 
     * applicable at a particular time. Useful in retrieving those 
     * records &quot;currently in effect&quot; as well as 
     * retrieving views of what information was in effect at some 
     * date in the past.</p>
     * 
     * <p>Filters the set of records to be retrieved to those which 
     * occurred or were effective for the patient within the date 
     * boundaries specified. Either the lower bound or upper bound 
     * or both would be specified. If no value is specified, no 
     * filter will be applied. If there is any overlap between the 
     * specified date-range and the effective date of the record, 
     * the record will be returned.</p>
     */
    public void setEffectiveTimeRangeValue(Interval<Date> effectiveTimeRangeValue) {
        this.effectiveTimeRangeValue.setValue(effectiveTimeRangeValue);
    }


    /**
     * <p>Business Name: ZJ: Event Categories</p>
     * 
     * <p>Relationship: REPC_MT210004CA.EventCategory.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows filtering responses based on higher level 
     * categorization. Multiple repetitions are supported to allow 
     * for multiple categories to be returned.</p>
     * 
     * <p>If specified, filters the returned records to those 
     * having the specified category. E.g. 
     * &quot;Allergy/Intolerance&quot;, &quot;Measured 
     * Observation&quot;, &quot;Cognitive Procedure&quot;. 
     * (Contrast this with &quot;Type&quot; which would allow 
     * searching for &quot;Drug Allergies&quot;, &quot;Patient 
     * Weight&quot; and &quot;Smoking Cessation 
     * Counseling&quot;.)</p>
     */
    @Hl7XmlMapping({"eventCategory/value"})
    public List<ReferralDocumentType> getEventCategoryValue() {
        return new RawListWrapper<CV, ReferralDocumentType>(eventCategoryValue, CVImpl.class);
    }


    /**
     * <p>Business Name: O: Event Location Id</p>
     * 
     * <p>Relationship: REPC_MT210004CA.EventLocationId.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows retrieving those records associated with a 
     * particular facility.</p>
     * 
     * <p>Filters the records retrieved to only include those 
     * records which are officially associated with and/or were 
     * performed by a particular facility. I.e. It will return 
     * records where either the &quot;Service Location&quot; or the 
     * &quot;Record Location&quot; has the specified location id. 
     * Records associated with &quot;sub-locations&quot; (e.g. 
     * departments, wards) will be returned when searching by the 
     * larger location (e.g. hospital).</p>
     */
    @Hl7XmlMapping({"eventLocationId/value"})
    public Identifier getEventLocationIdValue() {
        return this.eventLocationIdValue.getValue();
    }

    /**
     * <p>Business Name: O: Event Location Id</p>
     * 
     * <p>Relationship: REPC_MT210004CA.EventLocationId.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows retrieving those records associated with a 
     * particular facility.</p>
     * 
     * <p>Filters the records retrieved to only include those 
     * records which are officially associated with and/or were 
     * performed by a particular facility. I.e. It will return 
     * records where either the &quot;Service Location&quot; or the 
     * &quot;Record Location&quot; has the specified location id. 
     * Records associated with &quot;sub-locations&quot; (e.g. 
     * departments, wards) will be returned when searching by the 
     * larger location (e.g. hospital).</p>
     */
    public void setEventLocationIdValue(Identifier eventLocationIdValue) {
        this.eventLocationIdValue.setValue(eventLocationIdValue);
    }


    /**
     * <p>Business Name: P: Event Location Type</p>
     * 
     * <p>Relationship: REPC_MT210004CA.EventLocationType.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows retrieving those records associated with a 
     * particular kind of facility. E.g. Hospital, clinic, 
     * pharmacy, patient residence, etc.</p>
     * 
     * <p>Filters the records retrieved to only include those 
     * records which are officially associated with and/or were 
     * performed by facilities with the specified type. I.e. It 
     * will return records where either the &quot;Service 
     * Location&quot; or the &quot;Record Location&quot; has the 
     * specified location type.</p><p> <i>Query results should 
     * include those with an match of this code, as well those 
     * matching any specializations of the coded parameter.</i> 
     * </p>
     */
    @Hl7XmlMapping({"eventLocationType/value"})
    public ServiceDeliveryLocationRoleType getEventLocationTypeValue() {
        return (ServiceDeliveryLocationRoleType) this.eventLocationTypeValue.getValue();
    }

    /**
     * <p>Business Name: P: Event Location Type</p>
     * 
     * <p>Relationship: REPC_MT210004CA.EventLocationType.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows retrieving those records associated with a 
     * particular kind of facility. E.g. Hospital, clinic, 
     * pharmacy, patient residence, etc.</p>
     * 
     * <p>Filters the records retrieved to only include those 
     * records which are officially associated with and/or were 
     * performed by facilities with the specified type. I.e. It 
     * will return records where either the &quot;Service 
     * Location&quot; or the &quot;Record Location&quot; has the 
     * specified location type.</p><p> <i>Query results should 
     * include those with an match of this code, as well those 
     * matching any specializations of the coded parameter.</i> 
     * </p>
     */
    public void setEventLocationTypeValue(ServiceDeliveryLocationRoleType eventLocationTypeValue) {
        this.eventLocationTypeValue.setValue(eventLocationTypeValue);
    }


    /**
     * <p>Business Name: T: Health Conditions</p>
     * 
     * <p>Relationship: REPC_MT210004CA.HealthCondition.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows retrieving all records associated with a 
     * particular health condition or problem.</p><p> <i>This 
     * element makes use of the CD datatype to allow for use of the 
     * SNOMED code system that in some circumstances requires the 
     * use of post-coordination. Post-coordination is only 
     * supported by the CD datatype.</i> </p>
     * 
     * <p>Filters the records retrieved to only include those 
     * associated with the specified health condition (e.g. has 
     * indication, discharge diagnosis, condition type, etc. 
     * Specifically, any record having an &quot;indication&quot; 
     * which matches the specified code, any Care composition or 
     * Discharge-Care Summary with a discharge disposition which 
     * matches the specified code, or any Coded Observation which 
     * matches the specified code and any Health Condition which 
     * matches the specified code). If there are episodes 
     * associated with the condition, the query will also return 
     * records associated with that episode. (I.e. Any record tied 
     * to an episode with an associated health condition has an 
     * implicit relationship to that health condition.) If 
     * unspecified, no filter is applied.</p><p> <i>Query results 
     * should include those with an match of this code, as well 
     * those matching any specializations of the coded 
     * parameter.</i> </p>
     */
    @Hl7XmlMapping({"healthCondition/value"})
    public List<ActHealthConditionType> getHealthConditionValue() {
        return new RawListWrapper<CD, ActHealthConditionType>(healthConditionValue, CDImpl.class);
    }


    /**
     * <p>Business Name: U: Indication</p>
     * 
     * <p>Relationship: REPC_MT210004CA.Indication.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows retrieving all records associated with a 
     * particular indication.</p><p> <i>This element makes use of 
     * the CD datatype to allow for use of the SNOMED code system 
     * that in some circumstances requires the use of 
     * post-coordination. Post-coordination is only supported by 
     * the CD datatype.</i> </p>
     * 
     * <p>Filters the records retrieved to only include those where 
     * the &quot;indication&quot; (reason) for the record was the 
     * specified code.</p><p>This is distinct from the Health 
     * Condition query parameter in that it will only return 
     * records with an explicit indication match (it will not match 
     * on discharge diagnosis, part of related episode, etc.) It 
     * also allows searching on indications such as prophylaxis, 
     * surgery prep, etc.</p>
     */
    @Hl7XmlMapping({"indication/value"})
    public ActIndicationType getIndicationValue() {
        return (ActIndicationType) this.indicationValue.getValue();
    }

    /**
     * <p>Business Name: U: Indication</p>
     * 
     * <p>Relationship: REPC_MT210004CA.Indication.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows retrieving all records associated with a 
     * particular indication.</p><p> <i>This element makes use of 
     * the CD datatype to allow for use of the SNOMED code system 
     * that in some circumstances requires the use of 
     * post-coordination. Post-coordination is only supported by 
     * the CD datatype.</i> </p>
     * 
     * <p>Filters the records retrieved to only include those where 
     * the &quot;indication&quot; (reason) for the record was the 
     * specified code.</p><p>This is distinct from the Health 
     * Condition query parameter in that it will only return 
     * records with an explicit indication match (it will not match 
     * on discharge diagnosis, part of related episode, etc.) It 
     * also allows searching on indications such as prophylaxis, 
     * surgery prep, etc.</p>
     */
    public void setIndicationValue(ActIndicationType indicationValue) {
        this.indicationValue.setValue(indicationValue);
    }


    /**
     * <p>Business Name: V: Most Recent By Type Indicator</p>
     * 
     * <p>Relationship: 
     * REPC_MT210004CA.MostRecentByTypeIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides a mechanism of getting a quick overview of the 
     * types of events that have occurred without needing to look 
     * at all occurrences. The attribute is mandatory because it 
     * must be known whether to return the most recent or all 
     * records.</p>
     * 
     * <p>If true, indicates that only the most recent records of a 
     * given type or category should be retrieved. I.e. If there 
     * are 10 records of the same kind, only the most recent one 
     * would be returned. If false, all occurrences will be 
     * returned.</p>
     */
    @Hl7XmlMapping({"mostRecentByTypeIndicator/value"})
    public Boolean getMostRecentByTypeIndicatorValue() {
        return this.mostRecentByTypeIndicatorValue.getValue();
    }

    /**
     * <p>Business Name: V: Most Recent By Type Indicator</p>
     * 
     * <p>Relationship: 
     * REPC_MT210004CA.MostRecentByTypeIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides a mechanism of getting a quick overview of the 
     * types of events that have occurred without needing to look 
     * at all occurrences. The attribute is mandatory because it 
     * must be known whether to return the most recent or all 
     * records.</p>
     * 
     * <p>If true, indicates that only the most recent records of a 
     * given type or category should be retrieved. I.e. If there 
     * are 10 records of the same kind, only the most recent one 
     * would be returned. If false, all occurrences will be 
     * returned.</p>
     */
    public void setMostRecentByTypeIndicatorValue(Boolean mostRecentByTypeIndicatorValue) {
        this.mostRecentByTypeIndicatorValue.setValue(mostRecentByTypeIndicatorValue);
    }


    /**
     * <p>Business Name: ZI: Protocol Ids</p>
     * 
     * <p>Relationship: REPC_MT210004CA.ProtocolId.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows retrieving records associated with a particular 
     * protocol. Useful in clinical studies and other 
     * research.</p><p>The element is optional because support for 
     * protocols is not deemed a necessity for many healthcare 
     * providers.</p>
     * 
     * <p>Filters the records retrieved to only include those 
     * associated with the specified protocols. If unspecified, no 
     * filter is applied.</p>
     */
    @Hl7XmlMapping({"protocolId/value"})
    public List<Identifier> getProtocolIdValue() {
        return new RawListWrapper<II, Identifier>(protocolIdValue, IIImpl.class);
    }


    /**
     * <p>Business Name: ZO: Recipient Location Id</p>
     * 
     * <p>Relationship: REPC_MT210004CA.RecipientLocationId.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows retrieval of all documents sent to a particular 
     * location. E.g. &quot;Find all documents targeted to my 
     * location&quot;</p>
     * 
     * <p>If specified, filters the returned documents to only 
     * include those which were targeted to the specified location. 
     * If not specified, no filter is applied</p>
     */
    @Hl7XmlMapping({"recipientLocationId/value"})
    public Identifier getRecipientLocationIdValue() {
        return this.recipientLocationIdValue.getValue();
    }

    /**
     * <p>Business Name: ZO: Recipient Location Id</p>
     * 
     * <p>Relationship: REPC_MT210004CA.RecipientLocationId.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows retrieval of all documents sent to a particular 
     * location. E.g. &quot;Find all documents targeted to my 
     * location&quot;</p>
     * 
     * <p>If specified, filters the returned documents to only 
     * include those which were targeted to the specified location. 
     * If not specified, no filter is applied</p>
     */
    public void setRecipientLocationIdValue(Identifier recipientLocationIdValue) {
        this.recipientLocationIdValue.setValue(recipientLocationIdValue);
    }


    /**
     * <p>Business Name: ZN: Recipient Provider Id</p>
     * 
     * <p>Relationship: REPC_MT210004CA.RecipientProviderId.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows retrieval of all documents sent to a particular 
     * provider. E.g. &quot;Find all documents targeted to 
     * me&quot;</p>
     * 
     * <p>If specified, filters the returned documents to only 
     * include those which were targeted to the specified provider. 
     * If not specified, no filter is applied</p>
     */
    @Hl7XmlMapping({"recipientProviderId/value"})
    public Identifier getRecipientProviderIdValue() {
        return this.recipientProviderIdValue.getValue();
    }

    /**
     * <p>Business Name: ZN: Recipient Provider Id</p>
     * 
     * <p>Relationship: REPC_MT210004CA.RecipientProviderId.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows retrieval of all documents sent to a particular 
     * provider. E.g. &quot;Find all documents targeted to 
     * me&quot;</p>
     * 
     * <p>If specified, filters the returned documents to only 
     * include those which were targeted to the specified provider. 
     * If not specified, no filter is applied</p>
     */
    public void setRecipientProviderIdValue(Identifier recipientProviderIdValue) {
        this.recipientProviderIdValue.setValue(recipientProviderIdValue);
    }


    /**
     * <p>Business Name: I: Record Statuses</p>
     * 
     * <p>Relationship: REPC_MT210004CA.RecordStatus.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows constraining the status of records to be 
     * retrieved. Multiple repetitions are present to allow 
     * selection of multiple statuses with a single query.</p>
     * 
     * <p>Filters the set of records to be retrieved to only 
     * include those with the identified status(s). If no values 
     * are specified, no filter will be applied.</p>
     */
    @Hl7XmlMapping({"recordStatus/value"})
    public List<ActStatus> getRecordStatusValue() {
        return new RawListWrapper<CS, ActStatus>(recordStatusValue, CSImpl.class);
    }


    /**
     * <p>Business Name: H:Record Types</p>
     * 
     * <p>Relationship: REPC_MT210004CA.RecordType.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows constraining the type of records to be retrieved. 
     * Multiple repetitions are present to allow selection of 
     * multiple types with a single query.</p><p> <i>This element 
     * makes use of the CD datatype to allow for use of the SNOMED 
     * code system that in some circumstances requires the use of 
     * post-coordination. Post-coordination is only supported by 
     * the CD datatype.</i> </p>
     * 
     * <p>Filters the type(s) or category(ies) of the records to be 
     * retrieved. The query will return both those records whose 
     * type exactly matches, as well as those whose types are 
     * subsets of the specified parameter. If no Types are 
     * specified, no restriction will be placed on the types to be 
     * returned.</p><p> <i>Query results should include those with 
     * an match of this code, as well those matching any 
     * specializations of the coded parameter.</i> </p>
     */
    @Hl7XmlMapping({"recordType/value"})
    public List<ActCareProvisionRequestType> getRecordTypeValue() {
        return new RawListWrapper<CD, ActCareProvisionRequestType>(recordTypeValue, CDImpl.class);
    }


    /**
     * <p>Business Name: N: Requesting Provider Id</p>
     * 
     * <p>Relationship: REPC_MT210004CA.RequestingProviderId.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows a provider to see the results of any requests they 
     * may have made.</p>
     * 
     * <p>Filters the records retrieved to only include those whose 
     * creation/performance were requested by the identified 
     * provider. If unspecified, no filter is applied.</p>
     */
    @Hl7XmlMapping({"requestingProviderId/value"})
    public Identifier getRequestingProviderIdValue() {
        return this.requestingProviderIdValue.getValue();
    }

    /**
     * <p>Business Name: N: Requesting Provider Id</p>
     * 
     * <p>Relationship: REPC_MT210004CA.RequestingProviderId.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows a provider to see the results of any requests they 
     * may have made.</p>
     * 
     * <p>Filters the records retrieved to only include those whose 
     * creation/performance were requested by the identified 
     * provider. If unspecified, no filter is applied.</p>
     */
    public void setRequestingProviderIdValue(Identifier requestingProviderIdValue) {
        this.requestingProviderIdValue.setValue(requestingProviderIdValue);
    }


    /**
     * <p>Business Name: L: Responsible Provider Id</p>
     * 
     * <p>Relationship: REPC_MT210004CA.ResponsibleProviderId.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows retrieving those records in which a particular 
     * provider has a vested interest.</p>
     * 
     * <p>Filters the records retrieved to only include those where 
     * the identified provider was the author, supervisor or 
     * performer. If unspecified, no filter is applied.</p>
     */
    @Hl7XmlMapping({"responsibleProviderId/value"})
    public Identifier getResponsibleProviderIdValue() {
        return this.responsibleProviderIdValue.getValue();
    }

    /**
     * <p>Business Name: L: Responsible Provider Id</p>
     * 
     * <p>Relationship: REPC_MT210004CA.ResponsibleProviderId.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows retrieving those records in which a particular 
     * provider has a vested interest.</p>
     * 
     * <p>Filters the records retrieved to only include those where 
     * the identified provider was the author, supervisor or 
     * performer. If unspecified, no filter is applied.</p>
     */
    public void setResponsibleProviderIdValue(Identifier responsibleProviderIdValue) {
        this.responsibleProviderIdValue.setValue(responsibleProviderIdValue);
    }


    /**
     * <p>Business Name: M: Responsible Provider Type</p>
     * 
     * <p>Relationship: 
     * REPC_MT210004CA.ResponsibleProviderType.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows retrieving those records in which a particular 
     * kind of provider has a vested interest.</p>
     * 
     * <p>Filters the records retrieved to only include those where 
     * the author, supervisor or performer was of the specified 
     * provider type. If unspecified, no filter is applied.</p><p> 
     * <i>Query results should include those with an match of this 
     * code, as well those matching any specializations of the 
     * coded parameter.</i> </p>
     */
    @Hl7XmlMapping({"responsibleProviderType/value"})
    public HealthcareProviderRoleType getResponsibleProviderTypeValue() {
        return (HealthcareProviderRoleType) this.responsibleProviderTypeValue.getValue();
    }

    /**
     * <p>Business Name: M: Responsible Provider Type</p>
     * 
     * <p>Relationship: 
     * REPC_MT210004CA.ResponsibleProviderType.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows retrieving those records in which a particular 
     * kind of provider has a vested interest.</p>
     * 
     * <p>Filters the records retrieved to only include those where 
     * the author, supervisor or performer was of the specified 
     * provider type. If unspecified, no filter is applied.</p><p> 
     * <i>Query results should include those with an match of this 
     * code, as well those matching any specializations of the 
     * coded parameter.</i> </p>
     */
    public void setResponsibleProviderTypeValue(HealthcareProviderRoleType responsibleProviderTypeValue) {
        this.responsibleProviderTypeValue.setValue(responsibleProviderTypeValue);
    }

}
