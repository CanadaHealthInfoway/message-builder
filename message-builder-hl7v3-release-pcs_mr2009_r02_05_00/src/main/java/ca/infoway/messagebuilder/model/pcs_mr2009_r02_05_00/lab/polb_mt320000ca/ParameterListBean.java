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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.lab.polb_mt320000ca;

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
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ServiceDeliveryLocationRoleType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



/**
 * <p>Allows the user and/or point-of-service application to 
 * constrain what EHR information to be retrieved.</p>
 * 
 * <p>Identifies the various parameters that act as filters on 
 * the records to be retrieved.</p>
 */
@Hl7PartTypeMapping({"POLB_MT320000CA.ParameterList"})
@Hl7RootType
public class ParameterListBean extends MessagePartBean {

    private static final long serialVersionUID = 20150326L;
    private CV assignedPatientLocationValue = new CVImpl();
    private BL includeHistoryIndicatorValue = new BLImpl();
    private IVL<TS, Interval<Date>> jLISReceivedDateTimeValue = new IVLImpl<TS, Interval<Date>>();
    private IVL<TS, Interval<Date>> observationAvailabilityDateTimeRangeValue = new IVLImpl<TS, Interval<Date>>();
    private II orderingProviderValue = new IIImpl();
    private II resultCopiesToValue = new IIImpl();


    /**
     * <p>Business Name: Assigned Patient Location Type</p>
     * 
     * <p>Relationship: 
     * POLB_MT320000CA.AssignedPatientLocation.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows constraining the retrieved records to those 
     * patients seen at a location type (nursing station, clinic 
     * department, etc).</p>
     * 
     * <p>Filters the set of records to be retrieved to those 
     * patients seen at a particular location type e.g. nursing 
     * home, nurse station, clinic department, etc.</p>
     */
    @Hl7XmlMapping({"assignedPatientLocation/value"})
    public ServiceDeliveryLocationRoleType getAssignedPatientLocationValue() {
        return (ServiceDeliveryLocationRoleType) this.assignedPatientLocationValue.getValue();
    }

    /**
     * <p>Business Name: Assigned Patient Location Type</p>
     * 
     * <p>Relationship: 
     * POLB_MT320000CA.AssignedPatientLocation.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows constraining the retrieved records to those 
     * patients seen at a location type (nursing station, clinic 
     * department, etc).</p>
     * 
     * <p>Filters the set of records to be retrieved to those 
     * patients seen at a particular location type e.g. nursing 
     * home, nurse station, clinic department, etc.</p>
     */
    public void setAssignedPatientLocationValue(ServiceDeliveryLocationRoleType assignedPatientLocationValue) {
        this.assignedPatientLocationValue.setValue(assignedPatientLocationValue);
    }


    /**
     * <p>Business Name: Include History Indicator</p>
     * 
     * <p>Relationship: 
     * POLB_MT320000CA.IncludeHistoryIndicator.value</p>
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
     * POLB_MT320000CA.IncludeHistoryIndicator.value</p>
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
     * <p>Business Name: JLIS Received Effective Time Range</p>
     * 
     * <p>Relationship: POLB_MT320000CA.JLISReceivedDateTime.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows constraining the retrieved records to those 
     * applicable at a particular time.</p>
     * 
     * <p>Filters the set of records to be retrieved to those which 
     * the JLIS received date/time within the time boundaries 
     * specified. Either the lower bound or upper bound or both 
     * would be specified. If no value is specified, no filter will 
     * be applied. If there is any overlap between the specified 
     * time-range and the JLIS received date/time, the record will 
     * be returned.</p>
     */
    @Hl7XmlMapping({"jLISReceivedDateTime/value"})
    public Interval<Date> getJLISReceivedDateTimeValue() {
        return this.jLISReceivedDateTimeValue.getValue();
    }

    /**
     * <p>Business Name: JLIS Received Effective Time Range</p>
     * 
     * <p>Relationship: POLB_MT320000CA.JLISReceivedDateTime.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows constraining the retrieved records to those 
     * applicable at a particular time.</p>
     * 
     * <p>Filters the set of records to be retrieved to those which 
     * the JLIS received date/time within the time boundaries 
     * specified. Either the lower bound or upper bound or both 
     * would be specified. If no value is specified, no filter will 
     * be applied. If there is any overlap between the specified 
     * time-range and the JLIS received date/time, the record will 
     * be returned.</p>
     */
    public void setJLISReceivedDateTimeValue(Interval<Date> jLISReceivedDateTimeValue) {
        this.jLISReceivedDateTimeValue.setValue(jLISReceivedDateTimeValue);
    }


    /**
     * <p>Business Name: Observation Availability Time Range</p>
     * 
     * <p>Relationship: 
     * POLB_MT320000CA.ObservationAvailabilityDateTimeRange.value</p>
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
     * <p>Business Name: Observation Availability Time Range</p>
     * 
     * <p>Relationship: 
     * POLB_MT320000CA.ObservationAvailabilityDateTimeRange.value</p>
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
     * <p>Business Name: Ordering Provider Identfier</p>
     * 
     * <p>Relationship: POLB_MT320000CA.OrderingProvider.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows constraining the retrieved records to those 
     * applicable for a particular provider.</p>
     * 
     * <p>Filters the set of records to be retrieved to those 
     * ordered by a specific provider.</p>
     */
    @Hl7XmlMapping({"orderingProvider/value"})
    public Identifier getOrderingProviderValue() {
        return this.orderingProviderValue.getValue();
    }

    /**
     * <p>Business Name: Ordering Provider Identfier</p>
     * 
     * <p>Relationship: POLB_MT320000CA.OrderingProvider.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows constraining the retrieved records to those 
     * applicable for a particular provider.</p>
     * 
     * <p>Filters the set of records to be retrieved to those 
     * ordered by a specific provider.</p>
     */
    public void setOrderingProviderValue(Identifier orderingProviderValue) {
        this.orderingProviderValue.setValue(orderingProviderValue);
    }


    /**
     * <p>Business Name: Result Copies To Identfier</p>
     * 
     * <p>Relationship: POLB_MT320000CA.ResultCopiesTo.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows constraining the retrieved records to those 
     * applicable for a particular party to whom the result was 
     * copied.</p>
     * 
     * <p>Filters the set of records to be retrieved to those 
     * copied to an identified party.</p>
     */
    @Hl7XmlMapping({"resultCopiesTo/value"})
    public Identifier getResultCopiesToValue() {
        return this.resultCopiesToValue.getValue();
    }

    /**
     * <p>Business Name: Result Copies To Identfier</p>
     * 
     * <p>Relationship: POLB_MT320000CA.ResultCopiesTo.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows constraining the retrieved records to those 
     * applicable for a particular party to whom the result was 
     * copied.</p>
     * 
     * <p>Filters the set of records to be retrieved to those 
     * copied to an identified party.</p>
     */
    public void setResultCopiesToValue(Identifier resultCopiesToValue) {
        this.resultCopiesToValue.setValue(resultCopiesToValue);
    }

}
