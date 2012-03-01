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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pharmacy.porx_mt060030ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.IssueFilterCode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



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

    private static final long serialVersionUID = 20120301L;
    private CV issueFilterCodeValue = new CVImpl();
    private BL mostRecentByDeviceIndicatorValue = new BLImpl();
    private BL mostRecentDispenseForEachRxIndicatorValue = new BLImpl();
    private TS patientBirthDateValue = new TSImpl();
    private CV patientGenderValue = new CVImpl();
    private II patientIDValue = new IIImpl();
    private PN patientNameValue = new PNImpl();
    private IVL<TS, Interval<Date>> usageEffectivePeriodValue = new IVLImpl<TS, Interval<Date>>();


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
    public IssueFilterCode getIssueFilterCodeValue() {
        return (IssueFilterCode) this.issueFilterCodeValue.getValue();
    }
    public void setIssueFilterCodeValue(IssueFilterCode issueFilterCodeValue) {
        this.issueFilterCodeValue.setValue(issueFilterCodeValue);
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
    public Boolean getMostRecentByDeviceIndicatorValue() {
        return this.mostRecentByDeviceIndicatorValue.getValue();
    }
    public void setMostRecentByDeviceIndicatorValue(Boolean mostRecentByDeviceIndicatorValue) {
        this.mostRecentByDeviceIndicatorValue.setValue(mostRecentByDeviceIndicatorValue);
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
    public Boolean getMostRecentDispenseForEachRxIndicatorValue() {
        return this.mostRecentDispenseForEachRxIndicatorValue.getValue();
    }
    public void setMostRecentDispenseForEachRxIndicatorValue(Boolean mostRecentDispenseForEachRxIndicatorValue) {
        this.mostRecentDispenseForEachRxIndicatorValue.setValue(mostRecentDispenseForEachRxIndicatorValue);
    }


    /**
     * <p>Patient Birth Date</p>
     * 
     * <p><p>Indicates the date on which the patient was born.</p></p>
     * 
     * <p><p>Used to confirm the identity of the patient for the 
     * query and is therefore mandatory.</p></p>
     */
    @Hl7XmlMapping({"patientBirthDate/value"})
    public Date getPatientBirthDateValue() {
        return this.patientBirthDateValue.getValue();
    }
    public void setPatientBirthDateValue(Date patientBirthDateValue) {
        this.patientBirthDateValue.setValue(patientBirthDateValue);
    }


    /**
     * <p>Patient Gender</p>
     * 
     * <p><p>Indicates the gender (sex) of the patient.</p></p>
     * 
     * <p><p>Used to confirm the identity of the patient for the 
     * query and is therefore mandatory.</p></p>
     */
    @Hl7XmlMapping({"patientGender/value"})
    public AdministrativeGender getPatientGenderValue() {
        return (AdministrativeGender) this.patientGenderValue.getValue();
    }
    public void setPatientGenderValue(AdministrativeGender patientGenderValue) {
        this.patientGenderValue.setValue(patientGenderValue);
    }


    /**
     * <p>B:Patient ID</p>
     * 
     * <p><p>Identifier of the patient who is the subject of the 
     * query. Filter the result set to include only those records 
     * pertaining to the patient with this Id.</p></p>
     * 
     * <p><p>Allows filtering of result set by patient Id. This is 
     * a mandatory field because a patient must be specified for 
     * the query to be valid</p></p>
     */
    @Hl7XmlMapping({"patientID/value"})
    public Identifier getPatientIDValue() {
        return this.patientIDValue.getValue();
    }
    public void setPatientIDValue(Identifier patientIDValue) {
        this.patientIDValue.setValue(patientIDValue);
    }


    /**
     * <p>C:Patient Name</p>
     * 
     * <p><p>The name of the patient who is the subject of the 
     * query.</p><p>Filter the result set to include only those 
     * records pertaining to the patient with this name.</p></p>
     * 
     * <p><p>The name of the patient who is the subject of the 
     * query.</p><p>Filter the result set to include only those 
     * records pertaining to the patient with this name.</p></p>
     * 
     * <p><p>Allows filtering of result set by patient name. This 
     * is a mandatory field because a patient name must match the 
     * patient Id for the query to be valid.</p></p>
     */
    @Hl7XmlMapping({"patientName/value"})
    public PersonName getPatientNameValue() {
        return this.patientNameValue.getValue();
    }
    public void setPatientNameValue(PersonName patientNameValue) {
        this.patientNameValue.setValue(patientNameValue);
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
    public Interval<Date> getUsageEffectivePeriodValue() {
        return this.usageEffectivePeriodValue.getValue();
    }
    public void setUsageEffectivePeriodValue(Interval<Date> usageEffectivePeriodValue) {
        this.usageEffectivePeriodValue.setValue(usageEffectivePeriodValue);
    }

}
