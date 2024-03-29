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
package ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.lab.polb_mt310000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.RawListWrapper;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.ObservationOrderableLabType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.domainvalue.ObservationResultableLabType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Allows the user and/or point-of-service application to 
 * constrain what EHR information to be retrieved.</p>
 * 
 * <p>Identifies the various parameters that act as filters on 
 * the records to be retrieved.</p>
 */
@Hl7PartTypeMapping({"POLB_MT310000CA.ParameterList"})
@Hl7RootType
public class ParameterListBean extends MessagePartBean {

    private static final long serialVersionUID = 20190801L;
    private II batteryIdentifierValue = new IIImpl();
    private BL includeHistoryIndicatorValue = new BLImpl();
    private BL includeNullifiedIndicatorValue = new BLImpl();
    private IVL<TS, Interval<Date>> observationAvailabilityDateTimeRangeValue = new IVLImpl<TS, Interval<Date>>();
    private List<CD> observationCodeValue = new ArrayList<CD>();
    private IVL<TS, Interval<Date>> observationDateTimeRangeValue = new IVLImpl<TS, Interval<Date>>();
    private II observationIdentifierValue = new IIImpl();
    private II observationReportIdentifierValue = new IIImpl();
    private List<CD> orderTestCodeValue = new ArrayList<CD>();
    private TS patientDateofBirthValue = new TSImpl();
    private CV patientGenderValue = new CVImpl();
    private II patientIDValue = new IIImpl();
    private PN patientNameValue = new PNImpl();
    private IVL<TS, Interval<Date>> specimenCollectedDateTimeRangeValue = new IVLImpl<TS, Interval<Date>>();
    private IVL<TS, Interval<Date>> specimenReceivedDateTimeRangeValue = new IVLImpl<TS, Interval<Date>>();


    /**
     * <p>Business Name: Battery Identifier</p>
     * 
     * <p>Relationship: POLB_MT310000CA.BatteryIdentifier.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows constraining the retrieved records by 
     * identifier.</p>
     * 
     * <p>Contains an identifier assigned by a lab filling 
     * organization that uniquely identifies the battery event 
     * (result component) for query selection.</p>
     */
    @Hl7XmlMapping({"batteryIdentifier/value"})
    public Identifier getBatteryIdentifierValue() {
        return this.batteryIdentifierValue.getValue();
    }

    /**
     * <p>Business Name: Battery Identifier</p>
     * 
     * <p>Relationship: POLB_MT310000CA.BatteryIdentifier.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows constraining the retrieved records by 
     * identifier.</p>
     * 
     * <p>Contains an identifier assigned by a lab filling 
     * organization that uniquely identifies the battery event 
     * (result component) for query selection.</p>
     */
    public void setBatteryIdentifierValue(Identifier batteryIdentifierValue) {
        this.batteryIdentifierValue.setValue(batteryIdentifierValue);
    }


    /**
     * <p>Business Name: Include History Indicator</p>
     * 
     * <p>Relationship: 
     * POLB_MT310000CA.IncludeHistoryIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Historical (version) records are usable for audit, 
     * quality assurance, etc.</p>
     * 
     * <p>Indicates whether or not to include historical records 
     * (so, all the changes made to each return record).</p>
     */
    @Hl7XmlMapping({"includeHistoryIndicator/value"})
    public Boolean getIncludeHistoryIndicatorValue() {
        return this.includeHistoryIndicatorValue.getValue();
    }

    /**
     * <p>Business Name: Include History Indicator</p>
     * 
     * <p>Relationship: 
     * POLB_MT310000CA.IncludeHistoryIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Historical (version) records are usable for audit, 
     * quality assurance, etc.</p>
     * 
     * <p>Indicates whether or not to include historical records 
     * (so, all the changes made to each return record).</p>
     */
    public void setIncludeHistoryIndicatorValue(Boolean includeHistoryIndicatorValue) {
        this.includeHistoryIndicatorValue.setValue(includeHistoryIndicatorValue);
    }


    /**
     * <p>Business Name: Include Nullified Results Indicator</p>
     * 
     * <p>Relationship: 
     * POLB_MT310000CA.IncludeNullifiedIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Historical (version) records including nullified records 
     * are usable for audit, quality assurance, etc.</p>
     * 
     * <p>Indicates whether or not to include nullified orders. 
     * True=include records, the default is false</p>
     */
    @Hl7XmlMapping({"includeNullifiedIndicator/value"})
    public Boolean getIncludeNullifiedIndicatorValue() {
        return this.includeNullifiedIndicatorValue.getValue();
    }

    /**
     * <p>Business Name: Include Nullified Results Indicator</p>
     * 
     * <p>Relationship: 
     * POLB_MT310000CA.IncludeNullifiedIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Historical (version) records including nullified records 
     * are usable for audit, quality assurance, etc.</p>
     * 
     * <p>Indicates whether or not to include nullified orders. 
     * True=include records, the default is false</p>
     */
    public void setIncludeNullifiedIndicatorValue(Boolean includeNullifiedIndicatorValue) {
        this.includeNullifiedIndicatorValue.setValue(includeNullifiedIndicatorValue);
    }


    /**
     * <p>Business Name: Observation Availability Effective Time 
     * Range</p>
     * 
     * <p>Relationship: 
     * POLB_MT310000CA.ObservationAvailabilityDateTimeRange.value</p>
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
     * POLB_MT310000CA.ObservationAvailabilityDateTimeRange.value</p>
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
     * <p>Business Name: Result Code</p>
     * 
     * <p>Relationship: POLB_MT310000CA.ObservationCode.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifies the specific test peformed.</p>
     * 
     * <p>The code to describe the type of lab test (analyte) 
     * performed.</p>
     */
    @Hl7XmlMapping({"observationCode/value"})
    public List<ObservationResultableLabType> getObservationCodeValue() {
        return new RawListWrapper<CD, ObservationResultableLabType>(observationCodeValue, CDImpl.class);
    }


    /**
     * <p>Business Name: Observation Effective Time Range</p>
     * 
     * <p>Relationship: 
     * POLB_MT310000CA.ObservationDateTimeRange.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows constraining the retrieved records to those 
     * applicable at a particular time.</p>
     * 
     * <p>Filters the set of records to be retrieved to those which 
     * the observation or result date/time for the patient within 
     * the time boundaries specified. Either the lower bound or 
     * upper bound or both would be specified. If no value is 
     * specified, no filter will be applied. If there is any 
     * overlap between the specified time-range and the observation 
     * or result date/time, the record will be returned.</p>
     */
    @Hl7XmlMapping({"observationDateTimeRange/value"})
    public Interval<Date> getObservationDateTimeRangeValue() {
        return this.observationDateTimeRangeValue.getValue();
    }

    /**
     * <p>Business Name: Observation Effective Time Range</p>
     * 
     * <p>Relationship: 
     * POLB_MT310000CA.ObservationDateTimeRange.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows constraining the retrieved records to those 
     * applicable at a particular time.</p>
     * 
     * <p>Filters the set of records to be retrieved to those which 
     * the observation or result date/time for the patient within 
     * the time boundaries specified. Either the lower bound or 
     * upper bound or both would be specified. If no value is 
     * specified, no filter will be applied. If there is any 
     * overlap between the specified time-range and the observation 
     * or result date/time, the record will be returned.</p>
     */
    public void setObservationDateTimeRangeValue(Interval<Date> observationDateTimeRangeValue) {
        this.observationDateTimeRangeValue.setValue(observationDateTimeRangeValue);
    }


    /**
     * <p>Business Name: Observation Identifier</p>
     * 
     * <p>Relationship: POLB_MT310000CA.ObservationIdentifier.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows constraining the retrieved records by 
     * identifier.</p>
     * 
     * <p>Contains an identifier assigned by a lab filling 
     * organization that uniquely identifies the observation event 
     * (result component) for query selection.</p>
     */
    @Hl7XmlMapping({"observationIdentifier/value"})
    public Identifier getObservationIdentifierValue() {
        return this.observationIdentifierValue.getValue();
    }

    /**
     * <p>Business Name: Observation Identifier</p>
     * 
     * <p>Relationship: POLB_MT310000CA.ObservationIdentifier.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows constraining the retrieved records by 
     * identifier.</p>
     * 
     * <p>Contains an identifier assigned by a lab filling 
     * organization that uniquely identifies the observation event 
     * (result component) for query selection.</p>
     */
    public void setObservationIdentifierValue(Identifier observationIdentifierValue) {
        this.observationIdentifierValue.setValue(observationIdentifierValue);
    }


    /**
     * <p>Business Name: Observation Report Identifier</p>
     * 
     * <p>Relationship: 
     * POLB_MT310000CA.ObservationReportIdentifier.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows constraining the retrieved records by 
     * identifier.</p>
     * 
     * <p>Contains an identifier for the Observation Report for 
     * query selection.</p>
     */
    @Hl7XmlMapping({"observationReportIdentifier/value"})
    public Identifier getObservationReportIdentifierValue() {
        return this.observationReportIdentifierValue.getValue();
    }

    /**
     * <p>Business Name: Observation Report Identifier</p>
     * 
     * <p>Relationship: 
     * POLB_MT310000CA.ObservationReportIdentifier.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows constraining the retrieved records by 
     * identifier.</p>
     * 
     * <p>Contains an identifier for the Observation Report for 
     * query selection.</p>
     */
    public void setObservationReportIdentifierValue(Identifier observationReportIdentifierValue) {
        this.observationReportIdentifierValue.setValue(observationReportIdentifierValue);
    }


    /**
     * <p>Business Name: Order Test Code</p>
     * 
     * <p>Relationship: POLB_MT310000CA.OrderTestCode.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifies the specific test to perform.</p>
     * 
     * <p>The code to describe the type of test requested to be 
     * performed.</p>
     */
    @Hl7XmlMapping({"orderTestCode/value"})
    public List<ObservationOrderableLabType> getOrderTestCodeValue() {
        return new RawListWrapper<CD, ObservationOrderableLabType>(orderTestCodeValue, CDImpl.class);
    }


    /**
     * <p>Business Name: Patient DOB</p>
     * 
     * <p>Relationship: POLB_MT310000CA.PatientDateofBirth.value</p>
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
     * <p>Relationship: POLB_MT310000CA.PatientDateofBirth.value</p>
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
     * <p>Relationship: POLB_MT310000CA.PatientGender.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used to verify patient identity (a check against the 
     * patient id parameter).</p>
     * 
     * <p>Administrative gender of the patient.</p>
     */
    @Hl7XmlMapping({"patientGender/value"})
    public AdministrativeGender getPatientGenderValue() {
        return (AdministrativeGender) this.patientGenderValue.getValue();
    }

    /**
     * <p>Business Name: Patient Gender</p>
     * 
     * <p>Relationship: POLB_MT310000CA.PatientGender.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used to verify patient identity (a check against the 
     * patient id parameter).</p>
     * 
     * <p>Administrative gender of the patient.</p>
     */
    public void setPatientGenderValue(AdministrativeGender patientGenderValue) {
        this.patientGenderValue.setValue(patientGenderValue);
    }


    /**
     * <p>Business Name: Patient Id</p>
     * 
     * <p>Relationship: POLB_MT310000CA.PatientID.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
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
     * <p>Business Name: Patient Id</p>
     * 
     * <p>Relationship: POLB_MT310000CA.PatientID.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
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
     * <p>Relationship: POLB_MT310000CA.PatientName.value</p>
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
     * <p>Relationship: POLB_MT310000CA.PatientName.value</p>
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
     * <p>Business Name: Specimen Collection Effective Time Range</p>
     * 
     * <p>Relationship: 
     * POLB_MT310000CA.SpecimenCollectedDateTimeRange.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows constraining the retrieved records to those 
     * applicable at a particular time.</p>
     * 
     * <p>Filters the set of records to be retrieved to those which 
     * the specimen collection date/time for the patient within the 
     * time boundaries specified. Either the lower bound or upper 
     * bound or both would be specified. If no value is specified, 
     * no filter will be applied. If there is any overlap between 
     * the specified time-range and the specimen collection 
     * date/time, the record will be returned.</p>
     */
    @Hl7XmlMapping({"specimenCollectedDateTimeRange/value"})
    public Interval<Date> getSpecimenCollectedDateTimeRangeValue() {
        return this.specimenCollectedDateTimeRangeValue.getValue();
    }

    /**
     * <p>Business Name: Specimen Collection Effective Time Range</p>
     * 
     * <p>Relationship: 
     * POLB_MT310000CA.SpecimenCollectedDateTimeRange.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows constraining the retrieved records to those 
     * applicable at a particular time.</p>
     * 
     * <p>Filters the set of records to be retrieved to those which 
     * the specimen collection date/time for the patient within the 
     * time boundaries specified. Either the lower bound or upper 
     * bound or both would be specified. If no value is specified, 
     * no filter will be applied. If there is any overlap between 
     * the specified time-range and the specimen collection 
     * date/time, the record will be returned.</p>
     */
    public void setSpecimenCollectedDateTimeRangeValue(Interval<Date> specimenCollectedDateTimeRangeValue) {
        this.specimenCollectedDateTimeRangeValue.setValue(specimenCollectedDateTimeRangeValue);
    }


    /**
     * <p>Business Name: Specimen Received Effective Time Range</p>
     * 
     * <p>Relationship: 
     * POLB_MT310000CA.SpecimenReceivedDateTimeRange.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows constraining the retrieved records to those 
     * applicable at a particular time.</p>
     * 
     * <p>Filters the set of records to be retrieved to those which 
     * the specimen received date/time for the patient within the 
     * time boundaries specified. Either the lower bound or upper 
     * bound or both would be specified. If no value is specified, 
     * no filter will be applied. If there is any overlap between 
     * the specified time-range and the specimen received 
     * date/time, the record will be returned.</p>
     */
    @Hl7XmlMapping({"specimenReceivedDateTimeRange/value"})
    public Interval<Date> getSpecimenReceivedDateTimeRangeValue() {
        return this.specimenReceivedDateTimeRangeValue.getValue();
    }

    /**
     * <p>Business Name: Specimen Received Effective Time Range</p>
     * 
     * <p>Relationship: 
     * POLB_MT310000CA.SpecimenReceivedDateTimeRange.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows constraining the retrieved records to those 
     * applicable at a particular time.</p>
     * 
     * <p>Filters the set of records to be retrieved to those which 
     * the specimen received date/time for the patient within the 
     * time boundaries specified. Either the lower bound or upper 
     * bound or both would be specified. If no value is specified, 
     * no filter will be applied. If there is any overlap between 
     * the specified time-range and the specimen received 
     * date/time, the record will be returned.</p>
     */
    public void setSpecimenReceivedDateTimeRangeValue(Interval<Date> specimenReceivedDateTimeRangeValue) {
        this.specimenReceivedDateTimeRangeValue.setValue(specimenReceivedDateTimeRangeValue);
    }

}
