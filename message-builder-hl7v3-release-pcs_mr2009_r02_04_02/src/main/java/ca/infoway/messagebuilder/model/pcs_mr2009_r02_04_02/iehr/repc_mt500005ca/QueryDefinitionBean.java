/**
 * Copyright 2012 Canada Health Infoway, Inc.
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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.iehr.repc_mt500005ca;

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
import ca.infoway.messagebuilder.domainvalue.ActHealthConditionType;
import ca.infoway.messagebuilder.domainvalue.ActIndicationType;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.HealthcareProviderRoleType;
import ca.infoway.messagebuilder.domainvalue.ServiceDeliveryLocationRoleType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Query Definition</p>
 * 
 * <p><p>Identifies the various parameters that act as filters 
 * on the records to be retrieved.</p></p>
 * 
 * <p><p>Allows the user and/or the point-of-service 
 * application to constrain what EHR information they wish to 
 * retrieve.</p></p>
 */
@Hl7PartTypeMapping({"REPC_MT500005CA.ParameterList"})
@Hl7RootType
public class QueryDefinitionBean extends MessagePartBean {

    private static final long serialVersionUID = 20111117L;
    private TS amendedSinceDateTimeValue = new TSImpl();
    private List<II> careCompositionIdValue = new ArrayList<II>();
    private List<CV> careCompositionTypeValue = new ArrayList<CV>();
    private II eHRRepositoryIdValue = new IIImpl();
    private IVL<TS, Interval<Date>> effectiveTimeRangeValue = new IVLImpl<TS, Interval<Date>>();
    private II eventLocationIdValue = new IIImpl();
    private CV eventLocationTypeValue = new CVImpl();
    private List<CD> healthConditionValue = new ArrayList<CD>();
    private CD indicationValue = new CDImpl();
    private BL mostRecentByTypeIndicatorValue = new BLImpl();
    private List<II> protocolIdValue = new ArrayList<II>();
    private List<CS> recordStatusValue = new ArrayList<CS>();
    private List<CD> recordTypeValue = new ArrayList<CD>();
    private II requestingProviderIdValue = new IIImpl();
    private II responsibleProviderIdValue = new IIImpl();
    private CV responsibleProviderTypeValue = new CVImpl();


    /**
     * <p>K: Updated Since DateTime</p>
     * 
     * <p><p>Filters the records retrieved to only include those 
     * which have been created or revised since the specified date 
     * and time. If unspecified, no filter is applied.</p></p>
     * 
     * <p><p>Useful to retrieve information &quot;since you last 
     * checked&quot;.</p></p>
     */
    @Hl7XmlMapping({"amendedSinceDateTime/value"})
    public Date getAmendedSinceDateTimeValue() {
        return this.amendedSinceDateTimeValue.getValue();
    }
    public void setAmendedSinceDateTimeValue(Date amendedSinceDateTimeValue) {
        this.amendedSinceDateTimeValue.setValue(amendedSinceDateTimeValue);
    }


    /**
     * <p>R: Care Composition Ids</p>
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
    @Hl7XmlMapping({"careCompositionId/value"})
    public List<Identifier> getCareCompositionIdValue() {
        return new RawListWrapper<II, Identifier>(careCompositionIdValue, IIImpl.class);
    }


    /**
     * <p>S: Care Composition Types</p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     * 
     * <p><p>Allows retrieving all records associated with a 
     * particular type of encounter, episode or care event. E.g. 
     * Orthopedic Clinic Encounter, ER encounter, Walk-in 
     * encounter, etc.</p></p>
     */
    @Hl7XmlMapping({"careCompositionType/value"})
    public List<ActCareEventType> getCareCompositionTypeValue() {
        return new RawListWrapper<CV, ActCareEventType>(careCompositionTypeValue, CVImpl.class);
    }


    /**
     * <p>Q: EHR Repository Id</p>
     * 
     * <p><p>Filters the records retrieved to only include those 
     * records from a specific EHR repository. If unspecified, all 
     * &quot;connected&quot; EHR repositories will be searched.</p></p>
     * 
     * <p><p>Primarily intended to allow filtering an initial 
     * search to a local EHR repository for performance 
     * reasons.</p></p>
     */
    @Hl7XmlMapping({"eHRRepositoryId/value"})
    public Identifier getEHRRepositoryIdValue() {
        return this.eHRRepositoryIdValue.getValue();
    }
    public void setEHRRepositoryIdValue(Identifier eHRRepositoryIdValue) {
        this.eHRRepositoryIdValue.setValue(eHRRepositoryIdValue);
    }


    /**
     * <p>J: Effective Time Range</p>
     * 
     * <p><p>Filters the set of records to be retrieved to those 
     * which occurred or were effective for the patient within the 
     * time boundaries specified. Either the lower bound or upper 
     * bound or both would be specified. If no value is specified, 
     * no filter will be applied. If there is any overlap between 
     * the specified time-range and the effective time of the 
     * record, the record will be returned.</p></p>
     * 
     * <p><p>Allows constraining the retrieved records to those 
     * applicable at a particular time. Useful in retrieving those 
     * records &quot;currently in effect&quot; as well as 
     * retrieving views of what information was in effect at some 
     * point in the past.</p></p>
     */
    @Hl7XmlMapping({"effectiveTimeRange/value"})
    public Interval<Date> getEffectiveTimeRangeValue() {
        return this.effectiveTimeRangeValue.getValue();
    }
    public void setEffectiveTimeRangeValue(Interval<Date> effectiveTimeRangeValue) {
        this.effectiveTimeRangeValue.setValue(effectiveTimeRangeValue);
    }


    /**
     * <p>O: Event Location Id</p>
     * 
     * <p><p>Filters the records retrieved to only include those 
     * records which are officially associated with and/or were 
     * performed by a particular facility. I.e. It will return 
     * records where either the &quot;Service Location&quot; or the 
     * &quot;Record Location&quot; has the specified location id. 
     * Records associated with &quot;sub-locations&quot; (e.g. 
     * departments, wards) will be returned when searching by the 
     * larger location (e.g. hospital).</p></p>
     * 
     * <p><p>Allows retrieving those records associated with a 
     * particular facility.</p></p>
     */
    @Hl7XmlMapping({"eventLocationId/value"})
    public Identifier getEventLocationIdValue() {
        return this.eventLocationIdValue.getValue();
    }
    public void setEventLocationIdValue(Identifier eventLocationIdValue) {
        this.eventLocationIdValue.setValue(eventLocationIdValue);
    }


    /**
     * <p>P: Event Location Type</p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     * 
     * <p><p>Allows retrieving those records associated with a 
     * particular kind of facility. E.g. Hospital, clinic, 
     * pharmacy, patient residence, etc.</p></p>
     */
    @Hl7XmlMapping({"eventLocationType/value"})
    public ServiceDeliveryLocationRoleType getEventLocationTypeValue() {
        return (ServiceDeliveryLocationRoleType) this.eventLocationTypeValue.getValue();
    }
    public void setEventLocationTypeValue(ServiceDeliveryLocationRoleType eventLocationTypeValue) {
        this.eventLocationTypeValue.setValue(eventLocationTypeValue);
    }


    /**
     * <p>T: Health Conditions</p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     */
    @Hl7XmlMapping({"healthCondition/value"})
    public List<ActHealthConditionType> getHealthConditionValue() {
        return new RawListWrapper<CD, ActHealthConditionType>(healthConditionValue, CDImpl.class);
    }


    /**
     * <p>U: Indication</p>
     * 
     * <p><p>Filters the records retrieved to only include those 
     * where the &quot;indication&quot; (reason) for the record was 
     * the specified code.</p><p>This is distinct from the Health 
     * Condition query parameter in that it will only return 
     * records with an explicit indication match (it will not match 
     * on discharge diagnosis, part of related episode, etc.) It 
     * also allows searching on indications such as prophylaxis, 
     * surgery prep, etc.</p></p>
     * 
     * <p><p>Filters the records retrieved to only include those 
     * where the &quot;indication&quot; (reason) for the record was 
     * the specified code.</p><p>This is distinct from the Health 
     * Condition query parameter in that it will only return 
     * records with an explicit indication match (it will not match 
     * on discharge diagnosis, part of related episode, etc.) It 
     * also allows searching on indications such as prophylaxis, 
     * surgery prep, etc.</p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     */
    @Hl7XmlMapping({"indication/value"})
    public ActIndicationType getIndicationValue() {
        return (ActIndicationType) this.indicationValue.getValue();
    }
    public void setIndicationValue(ActIndicationType indicationValue) {
        this.indicationValue.setValue(indicationValue);
    }


    /**
     * <p>V: Most Recent By Type Indicator</p>
     * 
     * <p><p>If true, indicates that only the most recent records 
     * of a given type or category should be retrieved. I.e. If 
     * there are 10 records of the same kind, only the most recent 
     * one would be returned. If false, all occurrences will be 
     * returned.</p></p>
     * 
     * <p><p>Provides a mechanism of getting a quick overview of 
     * the types of events that have occurred without needing to 
     * look at all occurrences. The attribute is mandatory because 
     * it must be known whether to return the most recent or all 
     * records.</p></p>
     */
    @Hl7XmlMapping({"mostRecentByTypeIndicator/value"})
    public Boolean getMostRecentByTypeIndicatorValue() {
        return this.mostRecentByTypeIndicatorValue.getValue();
    }
    public void setMostRecentByTypeIndicatorValue(Boolean mostRecentByTypeIndicatorValue) {
        this.mostRecentByTypeIndicatorValue.setValue(mostRecentByTypeIndicatorValue);
    }


    /**
     * <p>ZI: Protocol Ids</p>
     * 
     * <p><p>Filters the records retrieved to only include those 
     * associated with the specified protocols. If unspecified, no 
     * filter is applied.</p></p>
     * 
     * <p><p>Allows retrieving records associated with a particular 
     * protocol. Useful in clinical studies and other 
     * research.</p><p>The element is optional because support for 
     * protocols is not deemed a necessity for many healthcare 
     * providers.</p></p>
     * 
     * <p><p>Allows retrieving records associated with a particular 
     * protocol. Useful in clinical studies and other 
     * research.</p><p>The element is optional because support for 
     * protocols is not deemed a necessity for many healthcare 
     * providers.</p></p>
     */
    @Hl7XmlMapping({"protocolId/value"})
    public List<Identifier> getProtocolIdValue() {
        return new RawListWrapper<II, Identifier>(protocolIdValue, IIImpl.class);
    }


    /**
     * <p>I: Record Statuses</p>
     * 
     * <p><p>Filters the set of records to be retrieved to only 
     * include those with the identified status(s). If no values 
     * are specified, no filter will be applied.</p></p>
     * 
     * <p><p>Allows constraining the status of records to be 
     * retrieved. Multiple repetitions are present to allow 
     * selection of multiple statuses with a single query.</p></p>
     */
    @Hl7XmlMapping({"recordStatus/value"})
    public List<ActStatus> getRecordStatusValue() {
        return new RawListWrapper<CS, ActStatus>(recordStatusValue, CSImpl.class);
    }


    /**
     * <p>H:Record Types</p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     */
    @Hl7XmlMapping({"recordType/value"})
    public List<ActCareEventType> getRecordTypeValue() {
        return new RawListWrapper<CD, ActCareEventType>(recordTypeValue, CDImpl.class);
    }


    /**
     * <p>N: Requesting Provider Id</p>
     * 
     * <p><p>Filters the records retrieved to only include those 
     * whose creation/performance were requested by the identified 
     * provider. If unspecified, no filter is applied.</p></p>
     * 
     * <p><p>Allows a provider to see the results of any requests 
     * they may have made.</p></p>
     */
    @Hl7XmlMapping({"requestingProviderId/value"})
    public Identifier getRequestingProviderIdValue() {
        return this.requestingProviderIdValue.getValue();
    }
    public void setRequestingProviderIdValue(Identifier requestingProviderIdValue) {
        this.requestingProviderIdValue.setValue(requestingProviderIdValue);
    }


    /**
     * <p>L: Responsible Provider Id</p>
     * 
     * <p><p>Filters the records retrieved to only include those 
     * where the identified provider was the author, supervisor or 
     * performer. If unspecified, no filter is applied.</p></p>
     * 
     * <p><p>Allows retrieving those records in which a particular 
     * provider has a vested interest.</p></p>
     */
    @Hl7XmlMapping({"responsibleProviderId/value"})
    public Identifier getResponsibleProviderIdValue() {
        return this.responsibleProviderIdValue.getValue();
    }
    public void setResponsibleProviderIdValue(Identifier responsibleProviderIdValue) {
        this.responsibleProviderIdValue.setValue(responsibleProviderIdValue);
    }


    /**
     * <p>M: Responsible Provider Type</p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     * 
     * <p><p>Allows retrieving those records in which a particular 
     * kind of provider has a vested interest.</p></p>
     */
    @Hl7XmlMapping({"responsibleProviderType/value"})
    public HealthcareProviderRoleType getResponsibleProviderTypeValue() {
        return (HealthcareProviderRoleType) this.responsibleProviderTypeValue.getValue();
    }
    public void setResponsibleProviderTypeValue(HealthcareProviderRoleType responsibleProviderTypeValue) {
        this.responsibleProviderTypeValue.setValue(responsibleProviderTypeValue);
    }

}
