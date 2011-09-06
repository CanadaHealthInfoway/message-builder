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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.iehr.merged;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7MapByPartType;
import ca.infoway.messagebuilder.annotation.Hl7MapByPartTypes;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CE;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CEImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.ObservationInterpretationNormality;
import ca.infoway.messagebuilder.domainvalue.SimpleMeasurableClinicalObservationType;
import ca.infoway.messagebuilder.domainvalue.x_BasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt911108ca.ActingPerson;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.EHRRepositoryBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.ServiceLocationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.BecauseOfBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.CareCompositionsBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.IncludesBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.OccurredAtBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;



/**
 * <p>MeasuredObservation</p>
 * 
 * <p>REPC_MT410003CA.CommonObservationEvent: Measured 
 * Observation</p>
 * 
 * <p><p>Annotation is only permitted if Annotation Indicator 
 * is not present and vice versa</p></p>
 * 
 * <p><p>&lt;p&gt;This record expresses a single point-in-time 
 * measured observation made about a patient.&lt;/p&gt; 
 * &lt;p&gt;E.g. height, weight, blood pressure, mole diameter, 
 * gum depth, etc.&lt;/p&gt; &lt;p&gt;Note: This transaction is 
 * not intended to deal with numeric 'scores'. Those are not 
 * considered measurements and should be handled using Coded 
 * Observation.&lt;/p&gt;</p></p>
 * 
 * <p><p>Observations are a key mechanism for capturing the 
 * state of a patient. Observations provide context for 
 * interventions subsequently taken. Observations can also be 
 * tracked over time to look for changes that may help in 
 * assessing a patient's health.</p></p>
 * 
 * <p>REPC_MT410001CA.CommonObservationEvent: Measured 
 * Observation</p>
 * 
 * <p><p>&lt;p&gt;This record expresses a single point-in-time 
 * measured observation made about a patient.&lt;/p&gt; 
 * &lt;p&gt;E.g. height, weight, blood pressure, mole diameter, 
 * gum depth, etc.&lt;/p&gt; &lt;p&gt;Note: This transaction is 
 * not intended to deal with numeric 'scores'. Those are not 
 * considered measurements and should be handled using Coded 
 * Observation.&lt;/p&gt;</p></p>
 * 
 * <p><p>Observations are a key mechanism for capturing the 
 * state of a patient. Observations provide context for 
 * interventions subsequently taken. Observations can also be 
 * tracked over time to look for changes that may help in 
 * assessing a patient's health.</p></p>
 */
@Hl7PartTypeMapping({"REPC_MT410001CA.CommonObservationEvent","REPC_MT410003CA.CommonObservationEvent"})
@Hl7RootType
public class MeasuredObservationBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.iehr.comt_mt111111ca.SHR {

    private static final long serialVersionUID = 20110906L;
    private II observationRecordId = new IIImpl();
    private CD observationType = new CDImpl();
    private BL refutedIndicator = new BLImpl();
    private IVL<TS, Interval<Date>> observationPeriod = new IVLImpl<TS, Interval<Date>>();
    private SET<CV, Code> observationMaskingIndicators = new SETImpl<CV, Code>(CVImpl.class);
    private PQ observationValue = new PQImpl();
    private CE observationNormalityInterpretation = new CEImpl();
    private ServiceLocationBean indirectTargetServiceDeliveryLocation;
    private ActingPerson responsiblePartyActingPerson;
    private List<ActingPerson> performerActingPerson = new ArrayList<ActingPerson>();
    private RequestedByBean author;
    private ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.ActingPerson informantActingPerson;
    private EHRRepositoryBean custodian1AssignedDevice;
    private ServiceLocationBean custodian2ServiceDeliveryLocation;
    private OccurredAtBean location;
    private Request_2Bean inFulfillmentOfActRequest;
    private List<ActDefinitionBean> definitionActDefinition = new ArrayList<ActDefinitionBean>();
    private List<OldCommonObservationEventBean> predecessorOldCommonObservationEvent = new ArrayList<OldCommonObservationEventBean>();
    private List<BecauseOfBean> reason = new ArrayList<BecauseOfBean>();
    private List<ComponentObservations_1Bean> componentSubObservationEvent = new ArrayList<ComponentObservations_1Bean>();
    private NewCommonObservationEventBean successorNewCommonObservationEvent;
    private IncludesBean subjectOf;
    private BL subjectOf2AnnotationIndicator = new BLImpl(false);
    private List<CareCompositionsBean> componentOfPatientCareProvisionEvent = new ArrayList<CareCompositionsBean>();
    private List<Component2Bean> componentOf2 = new ArrayList<Component2Bean>();


    /**
     * <p>ObservationRecordId</p>
     * 
     * <p>A:Observation Record Id</p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getObservationRecordId() {
        return this.observationRecordId.getValue();
    }
    public void setObservationRecordId(Identifier observationRecordId) {
        this.observationRecordId.setValue(observationRecordId);
    }


    /**
     * <p>ObservationType</p>
     * 
     * <p>B:Observation Type</p>
     * 
     * <p><p>Only 'nullFlavor' value of OTH is available.</p></p>
     * 
     * <p></p><p>Observation types include: height, weight, blood 
     * pressure, etc.</p></p>
     * 
     * <p></p><p>Observation types include: height, weight, blood 
     * pressure, etc.</p></p>
     * 
     * <p><p>EPHS: new vocab concepts needed. See implementation 
     * notes</p><p>EPHS: vocab code needed for immunization 
     * interpretation</p><p>EPHS: vocab domain needed for medical 
     * history</p><p>EPHS: vocab domain needed for 
     * Assessment</p><p>EPHS: vocab domain needed for encounter 
     * complication</p><p>EPHS: concept code needed for Outbreak 
     * Complication</p></p>
     * 
     * <p><p>EPHS: new vocab concepts needed. See implementation 
     * notes</p><p>EPHS: vocab code needed for immunization 
     * interpretation</p><p>EPHS: vocab domain needed for medical 
     * history</p><p>EPHS: vocab domain needed for 
     * Assessment</p><p>EPHS: vocab domain needed for encounter 
     * complication</p><p>EPHS: concept code needed for Outbreak 
     * Complication</p></p>
     * 
     * <p><p>EPHS: new vocab concepts needed. See implementation 
     * notes</p><p>EPHS: vocab code needed for immunization 
     * interpretation</p><p>EPHS: vocab domain needed for medical 
     * history</p><p>EPHS: vocab domain needed for 
     * Assessment</p><p>EPHS: vocab domain needed for encounter 
     * complication</p><p>EPHS: concept code needed for Outbreak 
     * Complication</p></p>
     * 
     * <p><p>EPHS: new vocab concepts needed. See implementation 
     * notes</p><p>EPHS: vocab code needed for immunization 
     * interpretation</p><p>EPHS: vocab domain needed for medical 
     * history</p><p>EPHS: vocab domain needed for 
     * Assessment</p><p>EPHS: vocab domain needed for encounter 
     * complication</p><p>EPHS: concept code needed for Outbreak 
     * Complication</p></p>
     * 
     * <p><p>EPHS: new vocab concepts needed. See implementation 
     * notes</p><p>EPHS: vocab code needed for immunization 
     * interpretation</p><p>EPHS: vocab domain needed for medical 
     * history</p><p>EPHS: vocab domain needed for 
     * Assessment</p><p>EPHS: vocab domain needed for encounter 
     * complication</p><p>EPHS: concept code needed for Outbreak 
     * Complication</p></p>
     * 
     * <p><p>EPHS: new vocab concepts needed. See implementation 
     * notes</p><p>EPHS: vocab code needed for immunization 
     * interpretation</p><p>EPHS: vocab domain needed for medical 
     * history</p><p>EPHS: vocab domain needed for 
     * Assessment</p><p>EPHS: vocab domain needed for encounter 
     * complication</p><p>EPHS: concept code needed for Outbreak 
     * Complication</p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     * 
     * <p><p>EPHS:Observation.code fixed to &quot;OUTCOME&quot; at 
     * runtime</p><p>EPHS: observation.code fixed to &quot;DIRECTLY 
     * OBSERVED DOSES TAKEN&quot; at runtime</p></p>
     * 
     * <p><p>EPHS:Observation.code fixed to &quot;OUTCOME&quot; at 
     * runtime</p><p>EPHS: observation.code fixed to &quot;DIRECTLY 
     * OBSERVED DOSES TAKEN&quot; at runtime</p></p>
     */
    @Hl7XmlMapping({"code"})
    public SimpleMeasurableClinicalObservationType getObservationType() {
        return (SimpleMeasurableClinicalObservationType) this.observationType.getValue();
    }
    public void setObservationType(SimpleMeasurableClinicalObservationType observationType) {
        this.observationType.setValue(observationType);
    }


    /**
     * <p>RefutedIndicator</p>
     * 
     * <p>D:Refuted Indicator</p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     */
    @Hl7XmlMapping({"negationInd"})
    public Boolean getRefutedIndicator() {
        return this.refutedIndicator.getValue();
    }
    public void setRefutedIndicator(Boolean refutedIndicator) {
        this.refutedIndicator.setValue(refutedIndicator);
    }


    /**
     * <p>ObservationPeriod</p>
     * 
     * <p>E:Observation Period</p>
     * 
     * <p><p>Identifies the time at which the observation applies. 
     * Usually, this will be conveyed as a single point in time 
     * (center with a width of 0). However, some observations may 
     * cover a time-period with in which case start and end or 
     * start and duration may be specified.</p><p>Note that the 
     * date the observation applies is not always the same as the 
     * time the observation is actually made. A lab example: if 
     * blood was drawn two days ago and White Blood Count (WBC) was 
     * done today, then WBC observation date should reflect the 
     * date of two days ago because that is the time the 
     * observation actually applies to.</p></p>
     * 
     * <p><p>Identifies the time at which the observation applies. 
     * Usually, this will be conveyed as a single point in time 
     * (center with a width of 0). However, some observations may 
     * cover a time-period with in which case start and end or 
     * start and duration may be specified.</p><p>Note that the 
     * date the observation applies is not always the same as the 
     * time the observation is actually made. A lab example: if 
     * blood was drawn two days ago and White Blood Count (WBC) was 
     * done today, then WBC observation date should reflect the 
     * date of two days ago because that is the time the 
     * observation actually applies to.</p></p>
     * 
     * <p></p></p>
     * 
     * <p><p>EPHS: signs and symptoms onset date maps to beginning 
     * of time interval, recovery date to end of interval</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getObservationPeriod() {
        return this.observationPeriod.getValue();
    }
    public void setObservationPeriod(Interval<Date> observationPeriod) {
        this.observationPeriod.setValue(observationPeriod);
    }


    /**
     * <p>ObservationMaskingIndicators</p>
     * 
     * <p>D:Observation Masking Indicators</p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_BasicConfidentialityKind> getObservationMaskingIndicators() {
        return this.observationMaskingIndicators.rawSet(x_BasicConfidentialityKind.class);
    }


    /**
     * <p>ObservationValue</p>
     * 
     * <p>L:Observation Value</p>
     * 
     * <p><p>Observation Value must be specified and may only be 
     * specified when no sub-observations are present.</p></p>
     * 
     * <p><p>Indicates what was actually observed when the 
     * observation was made.</p><p>&lt;p&gt;E.g. height in 
     * centimeters, weight in kilograms, etc.&lt;/p&gt;</p></p>
     * 
     * <p><p>Indicates what was actually observed when the 
     * observation was made.</p><p>&lt;p&gt;E.g. height in 
     * centimeters, weight in kilograms, etc.&lt;/p&gt;</p></p>
     * 
     * <p><p>Conveys the clinical information resulting from the 
     * observation in a standardized representation.</p></p>
     */
    @Hl7XmlMapping({"value"})
    public PhysicalQuantity getObservationValue() {
        return this.observationValue.getValue();
    }
    public void setObservationValue(PhysicalQuantity observationValue) {
        this.observationValue.setValue(observationValue);
    }


    /**
     * <p>ObservationNormalityInterpretation</p>
     * 
     * <p>M:Observation Normality Interpretation</p>
     * 
     * <p><p>Identifies the level of variation of the observed 
     * state from what would be considered normal for a patient of 
     * similar age and gender. E.g. &quot;Normal&quot;, 
     * &quot;High&quot;, &quot;Critically High&quot;, etc.</p></p>
     * 
     * <p><p>Provides an ability to quickly flag observations that 
     * are outside the norm. These are generally the records which 
     * are of most interest from a clinical perspective.</p></p>
     * 
     * <p>M:Observation Normality Interpretation</p>
     * 
     * <p><p>Identifies the level of variation of the observed 
     * state from what would be considered normal for a patient of 
     * similar age and gender. E.g. &quot;Normal&quot;, 
     * &quot;High&quot;, etc.</p></p>
     * 
     * <p><p>Provides an ability to quickly flag observations that 
     * are outside the norm. These are generally the records which 
     * are of most interest from a clinical perspective.</p></p>
     */
    @Hl7XmlMapping({"interpretationCode"})
    public ObservationInterpretationNormality getObservationNormalityInterpretation() {
        return (ObservationInterpretationNormality) this.observationNormalityInterpretation.getValue();
    }
    public void setObservationNormalityInterpretation(ObservationInterpretationNormality observationNormalityInterpretation) {
        this.observationNormalityInterpretation.setValue(observationNormalityInterpretation);
    }


    @Hl7XmlMapping({"indirectTarget/serviceDeliveryLocation"})
    public ServiceLocationBean getIndirectTargetServiceDeliveryLocation() {
        return this.indirectTargetServiceDeliveryLocation;
    }
    public void setIndirectTargetServiceDeliveryLocation(ServiceLocationBean indirectTargetServiceDeliveryLocation) {
        this.indirectTargetServiceDeliveryLocation = indirectTargetServiceDeliveryLocation;
    }


    @Hl7XmlMapping({"responsibleParty/actingPerson"})
    public ActingPerson getResponsiblePartyActingPerson() {
        return this.responsiblePartyActingPerson;
    }
    public void setResponsiblePartyActingPerson(ActingPerson responsiblePartyActingPerson) {
        this.responsiblePartyActingPerson = responsiblePartyActingPerson;
    }


    @Hl7XmlMapping({"performer/actingPerson"})
    public List<ActingPerson> getPerformerActingPerson() {
        return this.performerActingPerson;
    }


    @Hl7XmlMapping({"author"})
    public RequestedByBean getAuthor() {
        return this.author;
    }
    public void setAuthor(RequestedByBean author) {
        this.author = author;
    }


    @Hl7XmlMapping({"informant/actingPerson"})
    public ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.ActingPerson getInformantActingPerson() {
        return this.informantActingPerson;
    }
    public void setInformantActingPerson(ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.ActingPerson informantActingPerson) {
        this.informantActingPerson = informantActingPerson;
    }


    @Hl7XmlMapping({"custodian1/assignedDevice"})
    public EHRRepositoryBean getCustodian1AssignedDevice() {
        return this.custodian1AssignedDevice;
    }
    public void setCustodian1AssignedDevice(EHRRepositoryBean custodian1AssignedDevice) {
        this.custodian1AssignedDevice = custodian1AssignedDevice;
    }


    @Hl7XmlMapping({"custodian2/serviceDeliveryLocation"})
    public ServiceLocationBean getCustodian2ServiceDeliveryLocation() {
        return this.custodian2ServiceDeliveryLocation;
    }
    public void setCustodian2ServiceDeliveryLocation(ServiceLocationBean custodian2ServiceDeliveryLocation) {
        this.custodian2ServiceDeliveryLocation = custodian2ServiceDeliveryLocation;
    }


    @Hl7XmlMapping({"location"})
    public OccurredAtBean getLocation() {
        return this.location;
    }
    public void setLocation(OccurredAtBean location) {
        this.location = location;
    }


    @Hl7XmlMapping({"inFulfillmentOf/actRequest"})
    public Request_2Bean getInFulfillmentOfActRequest() {
        return this.inFulfillmentOfActRequest;
    }
    public void setInFulfillmentOfActRequest(Request_2Bean inFulfillmentOfActRequest) {
        this.inFulfillmentOfActRequest = inFulfillmentOfActRequest;
    }


    @Hl7XmlMapping({"definition/actDefinition"})
    public List<ActDefinitionBean> getDefinitionActDefinition() {
        return this.definitionActDefinition;
    }


    @Hl7XmlMapping({"predecessor/oldCommonObservationEvent"})
    public List<OldCommonObservationEventBean> getPredecessorOldCommonObservationEvent() {
        return this.predecessorOldCommonObservationEvent;
    }


    @Hl7XmlMapping({"reason"})
    public List<BecauseOfBean> getReason() {
        return this.reason;
    }


    @Hl7XmlMapping({"component/subObservationEvent"})
    public List<ComponentObservations_1Bean> getComponentSubObservationEvent() {
        return this.componentSubObservationEvent;
    }


    @Hl7XmlMapping({"successor/newCommonObservationEvent"})
    public NewCommonObservationEventBean getSuccessorNewCommonObservationEvent() {
        return this.successorNewCommonObservationEvent;
    }
    public void setSuccessorNewCommonObservationEvent(NewCommonObservationEventBean successorNewCommonObservationEvent) {
        this.successorNewCommonObservationEvent = successorNewCommonObservationEvent;
    }


    @Hl7XmlMapping({"subjectOf","subjectOf1"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="subjectOf", type="REPC_MT410001CA.Subject"),
        @Hl7MapByPartType(name="subjectOf1", type="REPC_MT410003CA.Subject")})
    public IncludesBean getSubjectOf() {
        return this.subjectOf;
    }
    public void setSubjectOf(IncludesBean subjectOf) {
        this.subjectOf = subjectOf;
    }


    @Hl7XmlMapping({"subjectOf2/annotationIndicator"})
    public Boolean getSubjectOf2AnnotationIndicator() {
        return this.subjectOf2AnnotationIndicator.getValue();
    }
    public void setSubjectOf2AnnotationIndicator(Boolean subjectOf2AnnotationIndicator) {
        this.subjectOf2AnnotationIndicator.setValue(subjectOf2AnnotationIndicator);
    }


    @Hl7XmlMapping({"componentOf/patientCareProvisionEvent","componentOf1/patientCareProvisionEvent"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="componentOf", type="REPC_MT410001CA.Component3"),
        @Hl7MapByPartType(name="componentOf/patientCareProvisionEvent", type="COCT_MT011001CA.PatientCareProvisionEvent"),
        @Hl7MapByPartType(name="componentOf1", type="REPC_MT410003CA.Component3"),
        @Hl7MapByPartType(name="componentOf1/patientCareProvisionEvent", type="COCT_MT011001CA.PatientCareProvisionEvent")})
    public List<CareCompositionsBean> getComponentOfPatientCareProvisionEvent() {
        return this.componentOfPatientCareProvisionEvent;
    }


    @Hl7XmlMapping({"componentOf2"})
    public List<Component2Bean> getComponentOf2() {
        return this.componentOf2;
    }

}
