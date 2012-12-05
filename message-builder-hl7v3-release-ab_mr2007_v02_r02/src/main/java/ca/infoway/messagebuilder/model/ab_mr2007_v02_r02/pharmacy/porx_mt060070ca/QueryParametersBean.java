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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.pharmacy.porx_mt060070ca;

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
import ca.infoway.messagebuilder.domainvalue.IssueFilterCode;
import ca.infoway.messagebuilder.domainvalue.PrescriptionDispenseFilterCode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Business Name: Query Parameters</p>
 * 
 * <p>Defines the set of parameters that may be used to filter 
 * the query response.</p>
 * 
 * <p>Root class for query definition</p>
 */
@Hl7PartTypeMapping({"PORX_MT060070CA.ParameterList"})
@Hl7RootType
public class QueryParametersBean extends MessagePartBean {

    private static final long serialVersionUID = 20121204L;
    private IVL<TS, Interval<Date>> amendedInTimeRangeValue = new IVLImpl<TS, Interval<Date>>();
    private List<II> careCompositionIDValue = new ArrayList<II>();
    private List<CV> careCompositionTypeValue = new ArrayList<CV>();
    private CV issueFilterCodeValue = new CVImpl();
    private BL mostRecentByDeviceIndicatorValue = new BLImpl();
    private List<CV> rxDispenseIndicatorValue = new ArrayList<CV>();
    private IVL<TS, Interval<Date>> usageEffectivePeriodValue = new IVLImpl<TS, Interval<Date>>();


    /**
     * <p>Business Name: Amended in Time Range</p>
     * 
     * <p>Relationship: PORX_MT060070CA.AmendedInTimeRange.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates that the returned records should be filtered to 
     * only include those which have been amended in some way (had 
     * status changed, been annotated, prescription was dispensed, 
     * etc.) within the indicated time-period. This will commonly 
     * be used to 'retrieve everything that has been amended since 
     * xxx'.</p>
     * 
     * <p>Allows the requester to specify the event period of 
     * interest for the retrieval of medication 
     * records.</p><p>Useful for constraining run-away queries.</p>
     * 
     * <p>Allows the requester to specify the event period of 
     * interest for the retrieval of medication 
     * records.</p><p>Useful for constraining run-away queries.</p>
     */
    @Hl7XmlMapping({"amendedInTimeRange/value"})
    public Interval<Date> getAmendedInTimeRangeValue() {
        return this.amendedInTimeRangeValue.getValue();
    }

    /**
     * <p>Business Name: Amended in Time Range</p>
     * 
     * <p>Relationship: PORX_MT060070CA.AmendedInTimeRange.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates that the returned records should be filtered to 
     * only include those which have been amended in some way (had 
     * status changed, been annotated, prescription was dispensed, 
     * etc.) within the indicated time-period. This will commonly 
     * be used to 'retrieve everything that has been amended since 
     * xxx'.</p>
     * 
     * <p>Allows the requester to specify the event period of 
     * interest for the retrieval of medication 
     * records.</p><p>Useful for constraining run-away queries.</p>
     * 
     * <p>Allows the requester to specify the event period of 
     * interest for the retrieval of medication 
     * records.</p><p>Useful for constraining run-away queries.</p>
     */
    public void setAmendedInTimeRangeValue(Interval<Date> amendedInTimeRangeValue) {
        this.amendedInTimeRangeValue.setValue(amendedInTimeRangeValue);
    }


    /**
     * <p>Business Name: Care Composition IDs</p>
     * 
     * <p>Relationship: PORX_MT060070CA.CareCompositionID.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
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
     * 
     * <p>Allows retrieving all records associated with an 
     * encounter, episode or care event.</p>
     */
    @Hl7XmlMapping({"careCompositionID/value"})
    public List<Identifier> getCareCompositionIDValue() {
        return new RawListWrapper<II, Identifier>(careCompositionIDValue, IIImpl.class);
    }


    /**
     * <p>Business Name: Care Composition Types</p>
     * 
     * <p>Relationship: PORX_MT060070CA.CareCompositionType.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Filters the records retrieved to only include those 
     * associated with the specified 'kind' of encounter, episode 
     * or care event. If unspecified, no filter is applied.</p>
     * 
     * <p>Allows retrieving all records associated with a 
     * particular type of encounter, episode or care event. 
     * E.g.Orthopedic Clinic Encounter, ER encounter, Walk-in 
     * encounter, etc.</p>
     */
    @Hl7XmlMapping({"careCompositionType/value"})
    public List<ActCareEventType> getCareCompositionTypeValue() {
        return new RawListWrapper<CV, ActCareEventType>(careCompositionTypeValue, CVImpl.class);
    }


    /**
     * <p>Business Name: Issue Filter Code</p>
     * 
     * <p>Relationship: PORX_MT060070CA.IssueFilterCode.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates whether records to be returned (e.g. 
     * prescription order, prescription dispense and/or other 
     * medication) should be filtered to those with at least one 
     * persistent un-managed issue (against the record), with at 
     * least one persistent issues or should return all records, 
     * independent of the presence of persistent issues.</p>
     * 
     * <p>By filtering returned records to include only those which 
     * have unmanaged issues or any issues at all, allows a 
     * provider to focus on those aspects of care where extra 
     * attention is needed. Because the attribute must be known, it 
     * is mandatory.</p>
     */
    @Hl7XmlMapping({"issueFilterCode/value"})
    public IssueFilterCode getIssueFilterCodeValue() {
        return (IssueFilterCode) this.issueFilterCodeValue.getValue();
    }

    /**
     * <p>Business Name: Issue Filter Code</p>
     * 
     * <p>Relationship: PORX_MT060070CA.IssueFilterCode.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates whether records to be returned (e.g. 
     * prescription order, prescription dispense and/or other 
     * medication) should be filtered to those with at least one 
     * persistent un-managed issue (against the record), with at 
     * least one persistent issues or should return all records, 
     * independent of the presence of persistent issues.</p>
     * 
     * <p>By filtering returned records to include only those which 
     * have unmanaged issues or any issues at all, allows a 
     * provider to focus on those aspects of care where extra 
     * attention is needed. Because the attribute must be known, it 
     * is mandatory.</p>
     */
    public void setIssueFilterCodeValue(IssueFilterCode issueFilterCodeValue) {
        this.issueFilterCodeValue.setValue(issueFilterCodeValue);
    }


    /**
     * <p>Business Name: Most Recent By Device Indicator</p>
     * 
     * <p>Relationship: 
     * PORX_MT060070CA.MostRecentByDeviceIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates whether or not the records are to be retrieved 
     * based on the most recent by Device Code. If true, only the 
     * most recent prescription or dispense for a particular device 
     * type will be returned. The default is 'FALSE' indicating 
     * that retrieval of prescription or dispense records should 
     * not be limited to one per device type.</p>
     * 
     * <p>Helps decrease the volume of records returned, while 
     * still maintaining information on all devices that the 
     * patient is using.</p><p>Because this is a boolean attribute 
     * whose value must be known to evaluate the query, the 
     * attribute is mandatory.</p>
     * 
     * <p>Helps decrease the volume of records returned, while 
     * still maintaining information on all devices that the 
     * patient is using.</p><p>Because this is a boolean attribute 
     * whose value must be known to evaluate the query, the 
     * attribute is mandatory.</p>
     */
    @Hl7XmlMapping({"mostRecentByDeviceIndicator/value"})
    public Boolean getMostRecentByDeviceIndicatorValue() {
        return this.mostRecentByDeviceIndicatorValue.getValue();
    }

    /**
     * <p>Business Name: Most Recent By Device Indicator</p>
     * 
     * <p>Relationship: 
     * PORX_MT060070CA.MostRecentByDeviceIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates whether or not the records are to be retrieved 
     * based on the most recent by Device Code. If true, only the 
     * most recent prescription or dispense for a particular device 
     * type will be returned. The default is 'FALSE' indicating 
     * that retrieval of prescription or dispense records should 
     * not be limited to one per device type.</p>
     * 
     * <p>Helps decrease the volume of records returned, while 
     * still maintaining information on all devices that the 
     * patient is using.</p><p>Because this is a boolean attribute 
     * whose value must be known to evaluate the query, the 
     * attribute is mandatory.</p>
     * 
     * <p>Helps decrease the volume of records returned, while 
     * still maintaining information on all devices that the 
     * patient is using.</p><p>Because this is a boolean attribute 
     * whose value must be known to evaluate the query, the 
     * attribute is mandatory.</p>
     */
    public void setMostRecentByDeviceIndicatorValue(Boolean mostRecentByDeviceIndicatorValue) {
        this.mostRecentByDeviceIndicatorValue.setValue(mostRecentByDeviceIndicatorValue);
    }


    /**
     * <p>Business Name: Rx Dispenser Indicators</p>
     * 
     * <p>Relationship: PORX_MT060070CA.RxDispenseIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>A coded value indicating the dispensing (fill) status of 
     * the prescription to be included in the result set. Rx 
     * Dispense Indicators include: ND (Never Dispensed), DRR 
     * (Dispensed with Refills Remaining), etc.</p><p>The 
     * repetition of 3 allows for retrieval based on all three Rx 
     * Dispense Indicators.</p>
     * 
     * <p>A coded value indicating the dispensing (fill) status of 
     * the prescription to be included in the result set. Rx 
     * Dispense Indicators include: ND (Never Dispensed), DRR 
     * (Dispensed with Refills Remaining), etc.</p><p>The 
     * repetition of 3 allows for retrieval based on all three Rx 
     * Dispense Indicators.</p>
     * 
     * <p>Allows for finer sub-set of prescriptions to be retrieved 
     * based on the fill status of the prescription.</p>
     */
    @Hl7XmlMapping({"rxDispenseIndicator/value"})
    public List<PrescriptionDispenseFilterCode> getRxDispenseIndicatorValue() {
        return new RawListWrapper<CV, PrescriptionDispenseFilterCode>(rxDispenseIndicatorValue, CVImpl.class);
    }


    /**
     * <p>Business Name: Usage Effective Period</p>
     * 
     * <p>Relationship: PORX_MT060070CA.UsageEffectivePeriod.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the usage period for which the request/query 
     * applies.</p><p>Filter the result set to include only those 
     * device records (device order and device dispense) for which 
     * the patient was deemed to be using the device within the 
     * specified period.</p>
     * 
     * <p>Indicates the usage period for which the request/query 
     * applies.</p><p>Filter the result set to include only those 
     * device records (device order and device dispense) for which 
     * the patient was deemed to be using the device within the 
     * specified period.</p>
     * 
     * <p>Allows the requester to specify the usage period of 
     * interest for the retrieval. Useful for constraining run-away 
     * queries.</p>
     */
    @Hl7XmlMapping({"usageEffectivePeriod/value"})
    public Interval<Date> getUsageEffectivePeriodValue() {
        return this.usageEffectivePeriodValue.getValue();
    }

    /**
     * <p>Business Name: Usage Effective Period</p>
     * 
     * <p>Relationship: PORX_MT060070CA.UsageEffectivePeriod.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the usage period for which the request/query 
     * applies.</p><p>Filter the result set to include only those 
     * device records (device order and device dispense) for which 
     * the patient was deemed to be using the device within the 
     * specified period.</p>
     * 
     * <p>Indicates the usage period for which the request/query 
     * applies.</p><p>Filter the result set to include only those 
     * device records (device order and device dispense) for which 
     * the patient was deemed to be using the device within the 
     * specified period.</p>
     * 
     * <p>Allows the requester to specify the usage period of 
     * interest for the retrieval. Useful for constraining run-away 
     * queries.</p>
     */
    public void setUsageEffectivePeriodValue(Interval<Date> usageEffectivePeriodValue) {
        this.usageEffectivePeriodValue.setValue(usageEffectivePeriodValue);
    }

}
