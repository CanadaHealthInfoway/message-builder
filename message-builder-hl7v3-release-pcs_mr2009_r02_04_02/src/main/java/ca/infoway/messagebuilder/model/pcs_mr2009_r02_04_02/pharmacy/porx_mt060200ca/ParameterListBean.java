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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pharmacy.porx_mt060200ca;

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
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Root class for query definition</p>
 * 
 * <p>Defines the set of parameters that may be used to filter 
 * the query response.</p>
 */
@Hl7PartTypeMapping({"PORX_MT060200CA.ParameterList"})
@Hl7RootType
public class ParameterListBean extends MessagePartBean {

    private static final long serialVersionUID = 20130103L;
    private IVL<TS, Interval<Date>> administrationEffectivePeriodValue = new IVLImpl<TS, Interval<Date>>();
    private IVL<TS, Interval<Date>> amendedInTimeRangeValue = new IVLImpl<TS, Interval<Date>>();
    private List<II> careCompositionIDValue = new ArrayList<II>();
    private List<CV> careCompositionTypeValue = new ArrayList<CV>();
    private CV issueFilterCodeValue = new CVImpl();
    private BL mostRecentByDrugIndicatorValue = new BLImpl();


    /**
     * <p>Business Name: Administration Effective Period</p>
     * 
     * <p>Relationship: 
     * PORX_MT060200CA.AdministrationEffectivePeriod.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the requester to specify the administration period 
     * of interest for the retrieval. Useful for constraining 
     * run-away queries.</p>
     * 
     * <p>The determination for applicability for inclusion in the 
     * query response should be considered to be the 'Pick up date 
     * plus the days supply'</p>
     * 
     * <p>Indicates the administration period for which the 
     * request/query applies.</p><p>Filter the result set to 
     * include only those medication records (prescription order, 
     * prescription dispense and other active medication) for which 
     * the patient was deemed to be taking the drug within the 
     * specified period.</p>
     */
    @Hl7XmlMapping({"administrationEffectivePeriod/value"})
    public Interval<Date> getAdministrationEffectivePeriodValue() {
        return this.administrationEffectivePeriodValue.getValue();
    }

    /**
     * <p>Business Name: Administration Effective Period</p>
     * 
     * <p>Relationship: 
     * PORX_MT060200CA.AdministrationEffectivePeriod.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the requester to specify the administration period 
     * of interest for the retrieval. Useful for constraining 
     * run-away queries.</p>
     * 
     * <p>The determination for applicability for inclusion in the 
     * query response should be considered to be the 'Pick up date 
     * plus the days supply'</p>
     * 
     * <p>Indicates the administration period for which the 
     * request/query applies.</p><p>Filter the result set to 
     * include only those medication records (prescription order, 
     * prescription dispense and other active medication) for which 
     * the patient was deemed to be taking the drug within the 
     * specified period.</p>
     */
    public void setAdministrationEffectivePeriodValue(Interval<Date> administrationEffectivePeriodValue) {
        this.administrationEffectivePeriodValue.setValue(administrationEffectivePeriodValue);
    }


    /**
     * <p>Business Name: Amended in Time Range</p>
     * 
     * <p>Relationship: PORX_MT060200CA.AmendedInTimeRange.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the requester to specify the event period of 
     * interest for the retrieval of medication 
     * records.</p><p>Useful for constraining run-away queries.</p>
     * 
     * <p>Indicates that the returned records should be filtered to 
     * only include those which have been amended in some way (had 
     * status changed, been annotated, prescription was dispensed, 
     * etc.) within the indicated time-period. This will commonly 
     * be used to &quot;retrieve everything that has been amended 
     * since xxx&quot;.</p>
     */
    @Hl7XmlMapping({"amendedInTimeRange/value"})
    public Interval<Date> getAmendedInTimeRangeValue() {
        return this.amendedInTimeRangeValue.getValue();
    }

    /**
     * <p>Business Name: Amended in Time Range</p>
     * 
     * <p>Relationship: PORX_MT060200CA.AmendedInTimeRange.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the requester to specify the event period of 
     * interest for the retrieval of medication 
     * records.</p><p>Useful for constraining run-away queries.</p>
     * 
     * <p>Indicates that the returned records should be filtered to 
     * only include those which have been amended in some way (had 
     * status changed, been annotated, prescription was dispensed, 
     * etc.) within the indicated time-period. This will commonly 
     * be used to &quot;retrieve everything that has been amended 
     * since xxx&quot;.</p>
     */
    public void setAmendedInTimeRangeValue(Interval<Date> amendedInTimeRangeValue) {
        this.amendedInTimeRangeValue.setValue(amendedInTimeRangeValue);
    }


    /**
     * <p>Business Name: Care Composition IDs</p>
     * 
     * <p>Relationship: PORX_MT060200CA.CareCompositionID.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows retrieving all records associated with an 
     * encounter, episode or care event.</p>
     * 
     * <p>Desc: Filters the records retrieved to only include those 
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
     * <p>Relationship: PORX_MT060200CA.CareCompositionType.value</p>
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
     * <p>Business Name: Issue Filter Code</p>
     * 
     * <p>Relationship: PORX_MT060200CA.IssueFilterCode.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>By filtering returned records to include only those which 
     * have unmanaged issues or any issues at all, allows a 
     * provider to focus on those aspects of care where extra 
     * attention is needed. Because the attribute must be known, it 
     * is mandatory.</p>
     * 
     * <p>Indicates whether records to be returned (e.g. 
     * prescription order, prescription dispense and/or other 
     * medication) should be filtered to those with at least one 
     * persistent un-managed issue (against the record), with at 
     * least one persistent issues or should return all records, 
     * independent of the presence of persistent issues.</p>
     */
    @Hl7XmlMapping({"issueFilterCode/value"})
    public IssueFilterCode getIssueFilterCodeValue() {
        return (IssueFilterCode) this.issueFilterCodeValue.getValue();
    }

    /**
     * <p>Business Name: Issue Filter Code</p>
     * 
     * <p>Relationship: PORX_MT060200CA.IssueFilterCode.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>By filtering returned records to include only those which 
     * have unmanaged issues or any issues at all, allows a 
     * provider to focus on those aspects of care where extra 
     * attention is needed. Because the attribute must be known, it 
     * is mandatory.</p>
     * 
     * <p>Indicates whether records to be returned (e.g. 
     * prescription order, prescription dispense and/or other 
     * medication) should be filtered to those with at least one 
     * persistent un-managed issue (against the record), with at 
     * least one persistent issues or should return all records, 
     * independent of the presence of persistent issues.</p>
     */
    public void setIssueFilterCodeValue(IssueFilterCode issueFilterCodeValue) {
        this.issueFilterCodeValue.setValue(issueFilterCodeValue);
    }


    /**
     * <p>Business Name: Most Recent By Drug Indicator</p>
     * 
     * <p>Relationship: 
     * PORX_MT060200CA.MostRecentByDrugIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Helps decrease the volume of records returned, while 
     * still maintaining information on all drugs that the patient 
     * is on.</p><p>Because this is a boolean attribute whose value 
     * must be known to evaluate the query, the attribute is 
     * mandatory.</p>
     * 
     * <p>Indicates whether or not the medication records are to be 
     * retrieved based on the most recent by Drug Code. If true, 
     * only the most recent prescription, dispense or other active 
     * medication for a particular drug generic classification will 
     * be returned. The default is 'FALSE' indicating that 
     * retrieval of prescription, dispense and other active 
     * medication records should not be limited to one per 
     * drug.</p>
     */
    @Hl7XmlMapping({"mostRecentByDrugIndicator/value"})
    public Boolean getMostRecentByDrugIndicatorValue() {
        return this.mostRecentByDrugIndicatorValue.getValue();
    }

    /**
     * <p>Business Name: Most Recent By Drug Indicator</p>
     * 
     * <p>Relationship: 
     * PORX_MT060200CA.MostRecentByDrugIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Helps decrease the volume of records returned, while 
     * still maintaining information on all drugs that the patient 
     * is on.</p><p>Because this is a boolean attribute whose value 
     * must be known to evaluate the query, the attribute is 
     * mandatory.</p>
     * 
     * <p>Indicates whether or not the medication records are to be 
     * retrieved based on the most recent by Drug Code. If true, 
     * only the most recent prescription, dispense or other active 
     * medication for a particular drug generic classification will 
     * be returned. The default is 'FALSE' indicating that 
     * retrieval of prescription, dispense and other active 
     * medication records should not be limited to one per 
     * drug.</p>
     */
    public void setMostRecentByDrugIndicatorValue(Boolean mostRecentByDrugIndicatorValue) {
        this.mostRecentByDrugIndicatorValue.setValue(mostRecentByDrugIndicatorValue);
    }

}
