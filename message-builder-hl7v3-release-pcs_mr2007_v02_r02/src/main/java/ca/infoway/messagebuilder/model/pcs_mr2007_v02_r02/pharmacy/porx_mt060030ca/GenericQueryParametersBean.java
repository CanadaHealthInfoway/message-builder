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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pharmacy.porx_mt060030ca;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.RawListWrapper;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.IssueFilterCode;
import ca.infoway.messagebuilder.domainvalue.PrescriptionDispenseFilterCode;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Generic Query Parameters</p>
 * 
 * <p><p>Defines the set of parameters that may be used to 
 * filter the query response.</p></p>
 * 
 * <p><p>Root class for query definition</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT060030CA.ParameterList"})
@Hl7RootType
public class GenericQueryParametersBean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private CV issueFilterCode = new CVImpl();
    private BL mostRecentByDeviceIndicator = new BLImpl();
    private BL mostRecentDispenseForEachRxIndicator = new BLImpl();
    private List<CV> rxDispenserIndicators = new ArrayList<CV>();
    private IVL<TS, Interval<Date>> usageEffectivePeriod = new IVLImpl<TS, Interval<Date>>();


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
     * <p>Most Recent By Device Indicator</p>
     * 
     * <p><p>Indicates whether or not the records are to be 
     * retrieved based on the most recent by Device Code. If true, 
     * only the most recent prescription or dispense or for the 
     * specified device type will be returned. The default is 
     * 'FALSE' indicating that retrieval of prescription and 
     * dispense records should not be limited to one per device 
     * type.</p></p>
     * 
     * <p><p>Helps decrease the volume of records returned, while 
     * still maintaining information on all devices that the 
     * patient is using.</p><p>The element is mandatory because the 
     * query recipient must know whether the value is true or 
     * false.</p></p>
     * 
     * <p><p>Helps decrease the volume of records returned, while 
     * still maintaining information on all devices that the 
     * patient is using.</p><p>The element is mandatory because the 
     * query recipient must know whether the value is true or 
     * false.</p></p>
     */
    @Hl7XmlMapping({"mostRecentByDeviceIndicator/value"})
    public Boolean getMostRecentByDeviceIndicator() {
        return this.mostRecentByDeviceIndicator.getValue();
    }
    public void setMostRecentByDeviceIndicator(Boolean mostRecentByDeviceIndicator) {
        this.mostRecentByDeviceIndicator.setValue(mostRecentByDeviceIndicator);
    }


    /**
     * <p>Most Recent Dispense for each Rx Indicator</p>
     * 
     * <p><p>Indicates whether or not prescription dispenses 
     * returned on a query should be limited to only the most 
     * recent dispense for a prescription order.</p><p>Allows for 
     * the returning of at most one prescription dispense record 
     * per a prescription.</p><p>The default is 'TRUE' indicating 
     * that retrieval should be for only the most recent dispense 
     * for a prescription is to be included in a query result.</p></p>
     * 
     * <p><p>Indicates whether or not prescription dispenses 
     * returned on a query should be limited to only the most 
     * recent dispense for a prescription order.</p><p>Allows for 
     * the returning of at most one prescription dispense record 
     * per a prescription.</p><p>The default is 'TRUE' indicating 
     * that retrieval should be for only the most recent dispense 
     * for a prescription is to be included in a query result.</p></p>
     * 
     * <p><p>Indicates whether or not prescription dispenses 
     * returned on a query should be limited to only the most 
     * recent dispense for a prescription order.</p><p>Allows for 
     * the returning of at most one prescription dispense record 
     * per a prescription.</p><p>The default is 'TRUE' indicating 
     * that retrieval should be for only the most recent dispense 
     * for a prescription is to be included in a query result.</p></p>
     * 
     * <p><p>Helps to trim down volume of query response by 
     * eliminating multiple prescription dispenses for the same 
     * prescription order.</p><p>The element is mandatory because 
     * the query recipient must know whether the value is true or 
     * false.</p></p>
     * 
     * <p><p>Helps to trim down volume of query response by 
     * eliminating multiple prescription dispenses for the same 
     * prescription order.</p><p>The element is mandatory because 
     * the query recipient must know whether the value is true or 
     * false.</p></p>
     */
    @Hl7XmlMapping({"mostRecentDispenseForEachRxIndicator/value"})
    public Boolean getMostRecentDispenseForEachRxIndicator() {
        return this.mostRecentDispenseForEachRxIndicator.getValue();
    }
    public void setMostRecentDispenseForEachRxIndicator(Boolean mostRecentDispenseForEachRxIndicator) {
        this.mostRecentDispenseForEachRxIndicator.setValue(mostRecentDispenseForEachRxIndicator);
    }


    /**
     * <p>Rx Dispenser Indicators</p>
     * 
     * <p><p>A coded value indicating the dispensing (fill) status 
     * of the prescription to be included in the result set. The 
     * only allowable dispense indicators are: CD (Completely 
     * Dispensed) and DRR (Dispensed with Remaining 
     * Refills).</p><p>The repetition of 2 allows for retrieval 
     * based on both dispense indicators.</p></p>
     * 
     * <p><p>A coded value indicating the dispensing (fill) status 
     * of the prescription to be included in the result set. The 
     * only allowable dispense indicators are: CD (Completely 
     * Dispensed) and DRR (Dispensed with Remaining 
     * Refills).</p><p>The repetition of 2 allows for retrieval 
     * based on both dispense indicators.</p></p>
     * 
     * <p><p>A coded value indicating the dispensing (fill) status 
     * of the prescription to be included in Allows for finer 
     * sub-set of prescriptions to be retrieved based on the fill 
     * status of the prescription.</p></p>
     */
    @Hl7XmlMapping({"rxDispenseIndicator/value"})
    public List<PrescriptionDispenseFilterCode> getRxDispenserIndicators() {
        return new RawListWrapper<CV, PrescriptionDispenseFilterCode>(rxDispenserIndicators, CVImpl.class);
    }


    /**
     * <p>D:Usage Effective Period</p>
     * 
     * <p><p>Indicates the usage period for which the request/query 
     * applies.</p><p>Filter the result set to include only those 
     * records (prescription order and prescription dispense) for 
     * which the patient was deemed to be using the device within 
     * the specified period.</p></p>
     * 
     * <p><p>Indicates the usage period for which the request/query 
     * applies.</p><p>Filter the result set to include only those 
     * records (prescription order and prescription dispense) for 
     * which the patient was deemed to be using the device within 
     * the specified period.</p></p>
     * 
     * <p><p>Allows the requester to specify the usage period of 
     * interest for the retrieval. Useful to avoid run-away 
     * queries.</p></p>
     */
    @Hl7XmlMapping({"usageEffectivePeriod/value"})
    public Interval<Date> getUsageEffectivePeriod() {
        return this.usageEffectivePeriod.getValue();
    }
    public void setUsageEffectivePeriod(Interval<Date> usageEffectivePeriod) {
        this.usageEffectivePeriod.setValue(usageEffectivePeriod);
    }

}
