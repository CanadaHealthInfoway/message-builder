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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.polb_mt330000ca;

import ca.infoway.messagebuilder.annotation.Hl7MapByPartType;
import ca.infoway.messagebuilder.annotation.Hl7MapByPartTypes;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.ObservationOrderableLabType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



/**
 * <p>Allows the user and/or point-of-service application to 
 * constrain what EHR information to be retrieved.</p>
 * 
 * <p>Identifies the various parameters that act as filters on 
 * the records to be retrieved.</p>
 */
@Hl7PartTypeMapping({"POLB_MT330000CA.ParameterList"})
@Hl7RootType
public class ParameterListBean extends MessagePartBean {

    private static final long serialVersionUID = 20131209L;
    private CS batteryRequestStatusValue = new CSImpl();
    private BL includeHistoryIndicatorValue = new BLImpl();
    private BL includeNullifiedIndicatorValue = new BLImpl();
    private BL includeResultsIndicatorValue = new BLImpl();
    private IVL<TS, Interval<Date>> observationAvailabilityDateTimeRangeValue = new IVLImpl<TS, Interval<Date>>();
    private IVL<TS, Interval<Date>> orderEnteredDateTimeRangeValue = new IVLImpl<TS, Interval<Date>>();
    private CD orderTestCodeValue = new CDImpl();
    private II orderingProviderValue = new IIImpl();
    private TS patientDateofBirthValue = new TSImpl();
    private CV patientGenderValue = new CVImpl();
    private II patientIDValue = new IIImpl();
    private PN patientNameValue = new PNImpl();
    private II placerOrderNumberValue = new IIImpl();


    /**
     * <p>Business Name: Order Status Value</p>
     * 
     * <p>Relationship: POLB_MT330000CA.BatteryRequestStatus.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the selection of only &quot;active&quot; 
     * orders or &quot;completed&quot; orders.</p>
     * 
     * <p>Communicates the status of the order.</p>
     */
    @Hl7XmlMapping({"batteryRequestStatus/value","observationRequestStatus/value"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="batteryRequestStatus", type="POLB_MT330000CA.BatteryRequestStatus"),
        @Hl7MapByPartType(name="observationRequestStatus", type="POLB_MT330000CA.ObservationRequestStatus")})
    public ActStatus getBatteryRequestStatusValue() {
        return (ActStatus) this.batteryRequestStatusValue.getValue();
    }

    /**
     * <p>Business Name: Order Status Value</p>
     * 
     * <p>Relationship: POLB_MT330000CA.BatteryRequestStatus.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the selection of only &quot;active&quot; 
     * orders or &quot;completed&quot; orders.</p>
     * 
     * <p>Communicates the status of the order.</p>
     */
    public void setBatteryRequestStatusValue(ActStatus batteryRequestStatusValue) {
        this.batteryRequestStatusValue.setValue(batteryRequestStatusValue);
    }


    /**
     * <p>Business Name: Include History Indicator</p>
     * 
     * <p>Relationship: 
     * POLB_MT330000CA.IncludeHistoryIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Historical (version) records are usable for audit, 
     * quality assurance, etc.</p>
     * 
     * <p>Indicates whether or not to include historical records 
     * (each change to a record, revisions, state changes, each 
     * trigger event). True=include records, the default is 
     * false.</p>
     */
    @Hl7XmlMapping({"includeHistoryIndicator/value"})
    public Boolean getIncludeHistoryIndicatorValue() {
        return this.includeHistoryIndicatorValue.getValue();
    }

    /**
     * <p>Business Name: Include History Indicator</p>
     * 
     * <p>Relationship: 
     * POLB_MT330000CA.IncludeHistoryIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Historical (version) records are usable for audit, 
     * quality assurance, etc.</p>
     * 
     * <p>Indicates whether or not to include historical records 
     * (each change to a record, revisions, state changes, each 
     * trigger event). True=include records, the default is 
     * false.</p>
     */
    public void setIncludeHistoryIndicatorValue(Boolean includeHistoryIndicatorValue) {
        this.includeHistoryIndicatorValue.setValue(includeHistoryIndicatorValue);
    }


    /**
     * <p>Business Name: Include Nullified Orders Indicator</p>
     * 
     * <p>Relationship: 
     * POLB_MT330000CA.IncludeNullifiedIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates whether or not to include nullified orders. 
     * True=include records, the default is false</p>
     */
    @Hl7XmlMapping({"includeNullifiedIndicator/value"})
    public Boolean getIncludeNullifiedIndicatorValue() {
        return this.includeNullifiedIndicatorValue.getValue();
    }

    /**
     * <p>Business Name: Include Nullified Orders Indicator</p>
     * 
     * <p>Relationship: 
     * POLB_MT330000CA.IncludeNullifiedIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates whether or not to include nullified orders. 
     * True=include records, the default is false</p>
     */
    public void setIncludeNullifiedIndicatorValue(Boolean includeNullifiedIndicatorValue) {
        this.includeNullifiedIndicatorValue.setValue(includeNullifiedIndicatorValue);
    }


    /**
     * <p>Business Name: Include Results Indicator</p>
     * 
     * <p>Relationship: 
     * POLB_MT330000CA.IncludeResultsIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates whether or not to include results (current if 
     * present) with each order. True=include records, the default 
     * is false.</p>
     */
    @Hl7XmlMapping({"includeResultsIndicator/value"})
    public Boolean getIncludeResultsIndicatorValue() {
        return this.includeResultsIndicatorValue.getValue();
    }

    /**
     * <p>Business Name: Include Results Indicator</p>
     * 
     * <p>Relationship: 
     * POLB_MT330000CA.IncludeResultsIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates whether or not to include results (current if 
     * present) with each order. True=include records, the default 
     * is false.</p>
     */
    public void setIncludeResultsIndicatorValue(Boolean includeResultsIndicatorValue) {
        this.includeResultsIndicatorValue.setValue(includeResultsIndicatorValue);
    }


    /**
     * <p>Business Name: Observation Availability Effective Time 
     * Range</p>
     * 
     * <p>Relationship: 
     * POLB_MT330000CA.ObservationAvailabilityDateTimeRange.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows constraining the retrieved records to those 
     * applicable at a particular time.</p>
     * 
     * <p>Filters the set of records to be retrieved to those which 
     * the observation availability date/time for the patient 
     * within the time boundaries specified. Either the lower bound 
     * or upper bound or both would be specified. If no value is 
     * specified, no filter will be applied. If there is any 
     * overlap between the specified time-range and the order entry 
     * date/time, the record will be returned.</p>
     */
    @Hl7XmlMapping({"observationAvailabilityDateTimeRange/value"})
    public Interval<Date> getObservationAvailabilityDateTimeRangeValue() {
        return this.observationAvailabilityDateTimeRangeValue.getValue();
    }

    /**
     * <p>Business Name: Observation Availability Effective Time 
     * Range</p>
     * 
     * <p>Relationship: 
     * POLB_MT330000CA.ObservationAvailabilityDateTimeRange.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows constraining the retrieved records to those 
     * applicable at a particular time.</p>
     * 
     * <p>Filters the set of records to be retrieved to those which 
     * the observation availability date/time for the patient 
     * within the time boundaries specified. Either the lower bound 
     * or upper bound or both would be specified. If no value is 
     * specified, no filter will be applied. If there is any 
     * overlap between the specified time-range and the order entry 
     * date/time, the record will be returned.</p>
     */
    public void setObservationAvailabilityDateTimeRangeValue(Interval<Date> observationAvailabilityDateTimeRangeValue) {
        this.observationAvailabilityDateTimeRangeValue.setValue(observationAvailabilityDateTimeRangeValue);
    }


    /**
     * <p>Business Name: Order Entry Effective Time Range</p>
     * 
     * <p>Relationship: 
     * POLB_MT330000CA.OrderEnteredDateTimeRange.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows constraining the retrieved records to those 
     * applicable at a particular time.</p>
     * 
     * <p>Filters the set of records to be retrieved to those which 
     * the order entry date/time for the patient within the time 
     * boundaries specified. Either the lower bound or upper bound 
     * or both would be specified. If no value is specified, no 
     * filter will be applied. If there is any overlap between the 
     * specified time-range and the order entry date/time, the 
     * record will be returned.</p>
     */
    @Hl7XmlMapping({"orderEnteredDateTimeRange/value"})
    public Interval<Date> getOrderEnteredDateTimeRangeValue() {
        return this.orderEnteredDateTimeRangeValue.getValue();
    }

    /**
     * <p>Business Name: Order Entry Effective Time Range</p>
     * 
     * <p>Relationship: 
     * POLB_MT330000CA.OrderEnteredDateTimeRange.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows constraining the retrieved records to those 
     * applicable at a particular time.</p>
     * 
     * <p>Filters the set of records to be retrieved to those which 
     * the order entry date/time for the patient within the time 
     * boundaries specified. Either the lower bound or upper bound 
     * or both would be specified. If no value is specified, no 
     * filter will be applied. If there is any overlap between the 
     * specified time-range and the order entry date/time, the 
     * record will be returned.</p>
     */
    public void setOrderEnteredDateTimeRangeValue(Interval<Date> orderEnteredDateTimeRangeValue) {
        this.orderEnteredDateTimeRangeValue.setValue(orderEnteredDateTimeRangeValue);
    }


    /**
     * <p>Business Name: Order Test Code</p>
     * 
     * <p>Relationship: POLB_MT330000CA.OrderTestCode.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifies the specific test to perform.</p>
     * 
     * <p>The code to describe the type of test requested to be 
     * performed.</p>
     */
    @Hl7XmlMapping({"orderTestCode/value"})
    public ObservationOrderableLabType getOrderTestCodeValue() {
        return (ObservationOrderableLabType) this.orderTestCodeValue.getValue();
    }

    /**
     * <p>Business Name: Order Test Code</p>
     * 
     * <p>Relationship: POLB_MT330000CA.OrderTestCode.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifies the specific test to perform.</p>
     * 
     * <p>The code to describe the type of test requested to be 
     * performed.</p>
     */
    public void setOrderTestCodeValue(ObservationOrderableLabType orderTestCodeValue) {
        this.orderTestCodeValue.setValue(orderTestCodeValue);
    }


    /**
     * <p>Business Name: Ordering Provider Identifier</p>
     * 
     * <p>Relationship: POLB_MT330000CA.OrderingProvider.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows constraining the retrieved records to those 
     * applicable for a specific ordering provider.</p>
     * 
     * <p>Select only those records for this ordering provider.</p>
     */
    @Hl7XmlMapping({"orderingProvider/value"})
    public Identifier getOrderingProviderValue() {
        return this.orderingProviderValue.getValue();
    }

    /**
     * <p>Business Name: Ordering Provider Identifier</p>
     * 
     * <p>Relationship: POLB_MT330000CA.OrderingProvider.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows constraining the retrieved records to those 
     * applicable for a specific ordering provider.</p>
     * 
     * <p>Select only those records for this ordering provider.</p>
     */
    public void setOrderingProviderValue(Identifier orderingProviderValue) {
        this.orderingProviderValue.setValue(orderingProviderValue);
    }


    /**
     * <p>Business Name: Patient DOB</p>
     * 
     * <p>Relationship: POLB_MT330000CA.PatientDateofBirth.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used to verify patient identity (a check against the 
     * patient id parameter).</p>
     * 
     * <p>Patient's date of birth.</p>
     */
    @Hl7XmlMapping({"patientDateofBirth/value"})
    public Date getPatientDateofBirthValue() {
        return this.patientDateofBirthValue.getValue();
    }

    /**
     * <p>Business Name: Patient DOB</p>
     * 
     * <p>Relationship: POLB_MT330000CA.PatientDateofBirth.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used to verify patient identity (a check against the 
     * patient id parameter).</p>
     * 
     * <p>Patient's date of birth.</p>
     */
    public void setPatientDateofBirthValue(Date patientDateofBirthValue) {
        this.patientDateofBirthValue.setValue(patientDateofBirthValue);
    }


    /**
     * <p>Business Name: Patient Gender</p>
     * 
     * <p>Relationship: POLB_MT330000CA.PatientGender.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used to verify patient identity (a check against the 
     * patient id parameter).</p>
     * 
     * <p>Patient's administrative gender (sex) code.</p>
     */
    @Hl7XmlMapping({"patientGender/value"})
    public AdministrativeGender getPatientGenderValue() {
        return (AdministrativeGender) this.patientGenderValue.getValue();
    }

    /**
     * <p>Business Name: Patient Gender</p>
     * 
     * <p>Relationship: POLB_MT330000CA.PatientGender.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used to verify patient identity (a check against the 
     * patient id parameter).</p>
     * 
     * <p>Patient's administrative gender (sex) code.</p>
     */
    public void setPatientGenderValue(AdministrativeGender patientGenderValue) {
        this.patientGenderValue.setValue(patientGenderValue);
    }


    /**
     * <p>Business Name: Patient ID</p>
     * 
     * <p>Relationship: POLB_MT330000CA.PatientID.value</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Identifies the patient whose information is to be 
     * retrieved.</p>
     * 
     * <p>A globally unique identifier for the patient whose 
     * information is to be retrieved.</p>
     */
    @Hl7XmlMapping({"patientID/value"})
    public Identifier getPatientIDValue() {
        return this.patientIDValue.getValue();
    }

    /**
     * <p>Business Name: Patient ID</p>
     * 
     * <p>Relationship: POLB_MT330000CA.PatientID.value</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Identifies the patient whose information is to be 
     * retrieved.</p>
     * 
     * <p>A globally unique identifier for the patient whose 
     * information is to be retrieved.</p>
     */
    public void setPatientIDValue(Identifier patientIDValue) {
        this.patientIDValue.setValue(patientIDValue);
    }


    /**
     * <p>Business Name: Patient Name</p>
     * 
     * <p>Relationship: POLB_MT330000CA.PatientName.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used to verify patient identity (a check against the 
     * patient id parameter).</p>
     * 
     * <p>Name for the patient.</p>
     */
    @Hl7XmlMapping({"patientName/value"})
    public PersonName getPatientNameValue() {
        return this.patientNameValue.getValue();
    }

    /**
     * <p>Business Name: Patient Name</p>
     * 
     * <p>Relationship: POLB_MT330000CA.PatientName.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used to verify patient identity (a check against the 
     * patient id parameter).</p>
     * 
     * <p>Name for the patient.</p>
     */
    public void setPatientNameValue(PersonName patientNameValue) {
        this.patientNameValue.setValue(patientNameValue);
    }


    /**
     * <p>Business Name: Placer Order Number</p>
     * 
     * <p>Relationship: POLB_MT330000CA.PlacerOrderNumber.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows constraining the retrieved records by 
     * identifier.</p>
     * 
     * <p>Must contain a value assigned by the order-placing 
     * organization that uniquely identifies the test for query 
     * selection.</p>
     */
    @Hl7XmlMapping({"placerOrderNumber/value"})
    public Identifier getPlacerOrderNumberValue() {
        return this.placerOrderNumberValue.getValue();
    }

    /**
     * <p>Business Name: Placer Order Number</p>
     * 
     * <p>Relationship: POLB_MT330000CA.PlacerOrderNumber.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows constraining the retrieved records by 
     * identifier.</p>
     * 
     * <p>Must contain a value assigned by the order-placing 
     * organization that uniquely identifies the test for query 
     * selection.</p>
     */
    public void setPlacerOrderNumberValue(Identifier placerOrderNumberValue) {
        this.placerOrderNumberValue.setValue(placerOrderNumberValue);
    }

}
