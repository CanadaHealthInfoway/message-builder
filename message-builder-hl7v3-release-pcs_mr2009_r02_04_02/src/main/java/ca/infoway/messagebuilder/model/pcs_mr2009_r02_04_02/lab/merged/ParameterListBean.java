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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.merged;

import ca.infoway.messagebuilder.Code;
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
import ca.infoway.messagebuilder.domainvalue.ServiceDeliveryLocationRoleType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>POLB_MT320000CA.ParameterList: (no business name)</p>
 * 
 * <p><p>Identifies the various parameters that act as filters 
 * on the records to be retrieved.</p></p>
 * 
 * <p><p>Allows the user and/or point-of-service application to 
 * constrain what EHR information to be retrieved.</p></p>
 * 
 * <p>POLB_MT310000CA.ParameterList: (no business name)</p>
 * 
 * <p><p>Identifies the various parameters that act as filters 
 * on the records to be retrieved.</p></p>
 * 
 * <p><p>Allows the user and/or point-of-service application to 
 * constrain what EHR information to be retrieved.</p></p>
 */
@Hl7PartTypeMapping({"POLB_MT310000CA.ParameterList","POLB_MT320000CA.ParameterList"})
@Hl7RootType
public class ParameterListBean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private CV assignedPatientLocationType = new CVImpl();
    private BL includeHistoryIndicator = new BLImpl();
    private IVL<TS, Interval<Date>> jLISReceivedEffectiveTimeRange = new IVLImpl<TS, Interval<Date>>();
    private IVL<TS, Interval<Date>> observationAvailabilityDateTimeRangeValue = new IVLImpl<TS, Interval<Date>>();
    private II orderingProviderIdentfier = new IIImpl();
    private II resultCopiesToIdentfier = new IIImpl();
    private II batteryIdentifier = new IIImpl();
    private BL includeNullifiedResultsIndicator = new BLImpl();
    private List<CD> resultCode = new ArrayList<CD>();
    private IVL<TS, Interval<Date>> observationEffectiveTimeRange = new IVLImpl<TS, Interval<Date>>();
    private II observationIdentifier = new IIImpl();
    private II observationReportIdentifier = new IIImpl();
    private List<CD> orderTestCode = new ArrayList<CD>();
    private TS patientDOB = new TSImpl();
    private CV patientGender = new CVImpl();
    private II patientId = new IIImpl();
    private PN patientName = new PNImpl();
    private IVL<TS, Interval<Date>> specimenCollectionEffectiveTimeRange = new IVLImpl<TS, Interval<Date>>();
    private IVL<TS, Interval<Date>> specimenReceivedEffectiveTimeRange = new IVLImpl<TS, Interval<Date>>();


    /**
     * <p>AssignedPatientLocationType</p>
     * 
     * <p>Assigned Patient Location Type</p>
     * 
     * <p><p>Filters the set of records to be retrieved to those 
     * patients seen at a particular location type e.g. nursing 
     * home, nurse station, clinic department, etc.</p></p>
     * 
     * <p><p>Allows constraining the retrieved records to those 
     * patients seen at a location type (nursing station, clinic 
     * department, etc).</p></p>
     */
    @Hl7XmlMapping({"assignedPatientLocation/value"})
    public ServiceDeliveryLocationRoleType getAssignedPatientLocationType() {
        return (ServiceDeliveryLocationRoleType) this.assignedPatientLocationType.getValue();
    }
    public void setAssignedPatientLocationType(ServiceDeliveryLocationRoleType assignedPatientLocationType) {
        this.assignedPatientLocationType.setValue(assignedPatientLocationType);
    }


    /**
     * <p>IncludeHistoryIndicator</p>
     * 
     * <p>Include History Indicator</p>
     * 
     * <p><p>Indicates whether or not to include historical records 
     * (so, all the changes made to each return record).</p></p>
     * 
     * <p><p>Historical (version) records are usable for audit, 
     * quality assurance, etc.</p></p>
     * 
     * <p>Include History Indicator</p>
     * 
     * <p><p>Indicates whether or not to include historical records 
     * (each change to a record, revisions, state changes, each 
     * trigger event). True=include records, the default is 
     * false.</p></p>
     * 
     * <p><p>Historical (version) records are usable for audit, 
     * quality assurance, etc.</p></p>
     */
    @Hl7XmlMapping({"includeHistoryIndicator/value"})
    public Boolean getIncludeHistoryIndicator() {
        return this.includeHistoryIndicator.getValue();
    }
    public void setIncludeHistoryIndicator(Boolean includeHistoryIndicator) {
        this.includeHistoryIndicator.setValue(includeHistoryIndicator);
    }


    /**
     * <p>JLISReceivedEffectiveTimeRange</p>
     * 
     * <p>JLIS Received Effective Time Range</p>
     * 
     * <p><p>Filters the set of records to be retrieved to those 
     * which the JLIS received date/time within the time boundaries 
     * specified. Either the lower bound or upper bound or both 
     * would be specified. If no value is specified, no filter will 
     * be applied. If there is any overlap between the specified 
     * time-range and the JLIS received date/time, the record will 
     * be returned.</p></p>
     * 
     * <p><p>Allows constraining the retrieved records to those 
     * applicable at a particular time.</p></p>
     */
    @Hl7XmlMapping({"jLISReceivedDateTime/value"})
    public Interval<Date> getJLISReceivedEffectiveTimeRange() {
        return this.jLISReceivedEffectiveTimeRange.getValue();
    }
    public void setJLISReceivedEffectiveTimeRange(Interval<Date> jLISReceivedEffectiveTimeRange) {
        this.jLISReceivedEffectiveTimeRange.setValue(jLISReceivedEffectiveTimeRange);
    }


    /**
     * <p>Observation Availability Time Range</p>
     * 
     * <p><p>Filters the set of records to be retrieved to those 
     * which the observation availability date/time for the patient 
     * within the time boundaries specified. Either the lower bound 
     * or upper bound or both would be specified. If no value is 
     * specified, no filter will be applied. If there is any 
     * overlap between the specified time-range and the order entry 
     * date/time, the record will be returned.</p></p>
     * 
     * <p><p>Allows constraining the retrieved records to those 
     * applicable at a particular time.</p></p>
     * 
     * <p>Observation Availability Effective Time Range</p>
     * 
     * <p><p>Filters the set of records to be retrieved to those 
     * which the observation availability date/time for the patient 
     * within the time boundaries specified. Either the lower bound 
     * or upper bound or both would be specified. If no value is 
     * specified, no filter will be applied. If there is any 
     * overlap between the specified time-range and the order entry 
     * date/time, the record will be returned.</p></p>
     * 
     * <p><p>Allows constraining the retrieved records to those 
     * applicable at a particular time.</p></p>
     */
    @Hl7XmlMapping({"observationAvailabilityDateTimeRange/value"})
    public Interval<Date> getObservationAvailabilityDateTimeRangeValue() {
        return this.observationAvailabilityDateTimeRangeValue.getValue();
    }
    public void setObservationAvailabilityDateTimeRangeValue(Interval<Date> observationAvailabilityDateTimeRangeValue) {
        this.observationAvailabilityDateTimeRangeValue.setValue(observationAvailabilityDateTimeRangeValue);
    }


    /**
     * <p>OrderingProviderIdentfier</p>
     * 
     * <p>Ordering Provider Identfier</p>
     * 
     * <p><p>Filters the set of records to be retrieved to those 
     * ordered by a specific provider.</p></p>
     * 
     * <p><p>Allows constraining the retrieved records to those 
     * applicable for a particular provider.</p></p>
     */
    @Hl7XmlMapping({"orderingProvider/value"})
    public Identifier getOrderingProviderIdentfier() {
        return this.orderingProviderIdentfier.getValue();
    }
    public void setOrderingProviderIdentfier(Identifier orderingProviderIdentfier) {
        this.orderingProviderIdentfier.setValue(orderingProviderIdentfier);
    }


    /**
     * <p>ResultCopiesToIdentfier</p>
     * 
     * <p>Result Copies To Identfier</p>
     * 
     * <p><p>Filters the set of records to be retrieved to those 
     * copied to an identified party.</p></p>
     * 
     * <p><p>Allows constraining the retrieved records to those 
     * applicable for a particular party to whom the result was 
     * copied.</p></p>
     */
    @Hl7XmlMapping({"resultCopiesTo/value"})
    public Identifier getResultCopiesToIdentfier() {
        return this.resultCopiesToIdentfier.getValue();
    }
    public void setResultCopiesToIdentfier(Identifier resultCopiesToIdentfier) {
        this.resultCopiesToIdentfier.setValue(resultCopiesToIdentfier);
    }


    /**
     * <p>BatteryIdentifier</p>
     * 
     * <p>Battery Identifier</p>
     * 
     * <p><p>Contains an identifier assigned by a lab filling 
     * organization that uniquely identifies the battery event 
     * (result component) for query selection.</p></p>
     * 
     * <p><p>Allows constraining the retrieved records by 
     * identifier.</p></p>
     */
    @Hl7XmlMapping({"batteryIdentifier/value"})
    public Identifier getBatteryIdentifier() {
        return this.batteryIdentifier.getValue();
    }
    public void setBatteryIdentifier(Identifier batteryIdentifier) {
        this.batteryIdentifier.setValue(batteryIdentifier);
    }


    /**
     * <p>IncludeNullifiedResultsIndicator</p>
     * 
     * <p>Include Nullified Results Indicator</p>
     * 
     * <p><p>Indicates whether or not to include nullified orders. 
     * True=include records, the default is false</p></p>
     * 
     * <p><p>Historical (version) records including nullified 
     * records are usable for audit, quality assurance, etc.</p></p>
     */
    @Hl7XmlMapping({"includeNullifiedIndicator/value"})
    public Boolean getIncludeNullifiedResultsIndicator() {
        return this.includeNullifiedResultsIndicator.getValue();
    }
    public void setIncludeNullifiedResultsIndicator(Boolean includeNullifiedResultsIndicator) {
        this.includeNullifiedResultsIndicator.setValue(includeNullifiedResultsIndicator);
    }


    /**
     * <p>ResultCode</p>
     * 
     * <p>Result Code</p>
     * 
     * <p><p>The code to describe the type of lab test (analyte) 
     * performed.</p></p>
     * 
     * <p><p>Identifies the specific test peformed.</p></p>
     */
    @Hl7XmlMapping({"observationCode/value"})
    public List<Code> getResultCode() {
        return new RawListWrapper<CD, Code>(resultCode, CDImpl.class);
    }


    /**
     * <p>ObservationEffectiveTimeRange</p>
     * 
     * <p>Observation Effective Time Range</p>
     * 
     * <p><p>Filters the set of records to be retrieved to those 
     * which the observation or result date/time for the patient 
     * within the time boundaries specified. Either the lower bound 
     * or upper bound or both would be specified. If no value is 
     * specified, no filter will be applied. If there is any 
     * overlap between the specified time-range and the observation 
     * or result date/time, the record will be returned.</p></p>
     * 
     * <p><p>Allows constraining the retrieved records to those 
     * applicable at a particular time.</p></p>
     */
    @Hl7XmlMapping({"observationDateTimeRange/value"})
    public Interval<Date> getObservationEffectiveTimeRange() {
        return this.observationEffectiveTimeRange.getValue();
    }
    public void setObservationEffectiveTimeRange(Interval<Date> observationEffectiveTimeRange) {
        this.observationEffectiveTimeRange.setValue(observationEffectiveTimeRange);
    }


    /**
     * <p>ObservationIdentifier</p>
     * 
     * <p>Observation Identifier</p>
     * 
     * <p><p>Contains an identifier assigned by a lab filling 
     * organization that uniquely identifies the observation event 
     * (result component) for query selection.</p></p>
     * 
     * <p><p>Allows constraining the retrieved records by 
     * identifier.</p></p>
     */
    @Hl7XmlMapping({"observationIdentifier/value"})
    public Identifier getObservationIdentifier() {
        return this.observationIdentifier.getValue();
    }
    public void setObservationIdentifier(Identifier observationIdentifier) {
        this.observationIdentifier.setValue(observationIdentifier);
    }


    /**
     * <p>ObservationReportIdentifier</p>
     * 
     * <p>Observation Report Identifier</p>
     * 
     * <p><p>Contains an identifier for the Observation Report for 
     * query selection.</p></p>
     * 
     * <p><p>Allows constraining the retrieved records by 
     * identifier.</p></p>
     */
    @Hl7XmlMapping({"observationReportIdentifier/value"})
    public Identifier getObservationReportIdentifier() {
        return this.observationReportIdentifier.getValue();
    }
    public void setObservationReportIdentifier(Identifier observationReportIdentifier) {
        this.observationReportIdentifier.setValue(observationReportIdentifier);
    }


    /**
     * <p>OrderTestCode</p>
     * 
     * <p>Order Test Code</p>
     * 
     * <p><p>The code to describe the type of test requested to be 
     * performed.</p></p>
     * 
     * <p><p>Identifies the specific test to perform.</p></p>
     */
    @Hl7XmlMapping({"orderTestCode/value"})
    public List<ObservationOrderableLabType> getOrderTestCode() {
        return new RawListWrapper<CD, ObservationOrderableLabType>(orderTestCode, CDImpl.class);
    }


    /**
     * <p>PatientDOB</p>
     * 
     * <p>Patient DOB</p>
     * 
     * <p><p>Patient's date of birth.</p></p>
     * 
     * <p><p>Used to verify patient identity (a check against the 
     * patient id parameter).</p></p>
     */
    @Hl7XmlMapping({"patientDateofBirth/value"})
    public Date getPatientDOB() {
        return this.patientDOB.getValue();
    }
    public void setPatientDOB(Date patientDOB) {
        this.patientDOB.setValue(patientDOB);
    }


    /**
     * <p>PatientGender</p>
     * 
     * <p>Patient Gender</p>
     * 
     * <p><p>Administrative gender of the patient.</p></p>
     * 
     * <p><p>Used to verify patient identity (a check against the 
     * patient id parameter).</p></p>
     */
    @Hl7XmlMapping({"patientGender/value"})
    public AdministrativeGender getPatientGender() {
        return (AdministrativeGender) this.patientGender.getValue();
    }
    public void setPatientGender(AdministrativeGender patientGender) {
        this.patientGender.setValue(patientGender);
    }


    /**
     * <p>PatientId</p>
     * 
     * <p>Patient Id</p>
     * 
     * <p><p>A globally unique identifier for the patient whose 
     * information is to be retrieved.</p></p>
     * 
     * <p><p>Identifies the patient whose information is to be 
     * retrieved.</p></p>
     */
    @Hl7XmlMapping({"patientID/value"})
    public Identifier getPatientId() {
        return this.patientId.getValue();
    }
    public void setPatientId(Identifier patientId) {
        this.patientId.setValue(patientId);
    }


    /**
     * <p>PatientName</p>
     * 
     * <p>Patient Name</p>
     * 
     * <p><p>Name for the patient.</p></p>
     * 
     * <p><p>Used to verify patient identity (a check against the 
     * patient id parameter).</p></p>
     */
    @Hl7XmlMapping({"patientName/value"})
    public PersonName getPatientName() {
        return this.patientName.getValue();
    }
    public void setPatientName(PersonName patientName) {
        this.patientName.setValue(patientName);
    }


    /**
     * <p>SpecimenCollectionEffectiveTimeRange</p>
     * 
     * <p>Specimen Collection Effective Time Range</p>
     * 
     * <p><p>Filters the set of records to be retrieved to those 
     * which the specimen collection date/time for the patient 
     * within the time boundaries specified. Either the lower bound 
     * or upper bound or both would be specified. If no value is 
     * specified, no filter will be applied. If there is any 
     * overlap between the specified time-range and the specimen 
     * collection date/time, the record will be returned.</p></p>
     * 
     * <p><p>Allows constraining the retrieved records to those 
     * applicable at a particular time.</p></p>
     */
    @Hl7XmlMapping({"specimenCollectedDateTimeRange/value"})
    public Interval<Date> getSpecimenCollectionEffectiveTimeRange() {
        return this.specimenCollectionEffectiveTimeRange.getValue();
    }
    public void setSpecimenCollectionEffectiveTimeRange(Interval<Date> specimenCollectionEffectiveTimeRange) {
        this.specimenCollectionEffectiveTimeRange.setValue(specimenCollectionEffectiveTimeRange);
    }


    /**
     * <p>SpecimenReceivedEffectiveTimeRange</p>
     * 
     * <p>Specimen Received Effective Time Range</p>
     * 
     * <p><p>Filters the set of records to be retrieved to those 
     * which the specimen received date/time for the patient within 
     * the time boundaries specified. Either the lower bound or 
     * upper bound or both would be specified. If no value is 
     * specified, no filter will be applied. If there is any 
     * overlap between the specified time-range and the specimen 
     * received date/time, the record will be returned.</p></p>
     * 
     * <p><p>Allows constraining the retrieved records to those 
     * applicable at a particular time.</p></p>
     */
    @Hl7XmlMapping({"specimenReceivedDateTimeRange/value"})
    public Interval<Date> getSpecimenReceivedEffectiveTimeRange() {
        return this.specimenReceivedEffectiveTimeRange.getValue();
    }
    public void setSpecimenReceivedEffectiveTimeRange(Interval<Date> specimenReceivedEffectiveTimeRange) {
        this.specimenReceivedEffectiveTimeRange.setValue(specimenReceivedEffectiveTimeRange);
    }

}
