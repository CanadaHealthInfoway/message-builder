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
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.nb_pr_cr_lr.iehr.repc_mt410003nb;

import ca.infoway.messagebuilder.Code;
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
import ca.infoway.messagebuilder.datatype.impl.RawListWrapper;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.ActNonLabDIMeasuredObservationCategoryList;
import ca.infoway.messagebuilder.domainvalue.ObservationInterpretationNormality;
import ca.infoway.messagebuilder.domainvalue.SimpleMeasurableClinicalObservationType;
import ca.infoway.messagebuilder.domainvalue.x_BasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.coct_mt011001nb.CareCompositionsBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.coct_mt050207nb.PatientBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.coct_mt090108nb.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.coct_mt090310nb.EHRRepositoryBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.coct_mt090508nb.HealthcareOrganizationBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.coct_mt240007nb.ServiceLocationBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.coct_mt910108nb.RelatedPersonBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.coct_mt911107nb.ActingPerson;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.iehr.merged.ActDefinitionBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.iehr.merged.ComponentObservations_1Bean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.iehr.merged.NewCommonObservationEventBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.iehr.merged.ObservationRequest_1Bean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.iehr.merged.OldCommonObservationEventBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.iehr.merged.RequestedByBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.merged.BecauseOfIndicationsBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.merged.IncludesBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;



/**
 * <p>Business Name: Measured Observation</p>
 * 
 * <p>Annotation is only permitted if Annotation Indicator is 
 * not present and vice versa</p>
 * 
 * <p>Observations are a key mechanism for capturing the state 
 * of a patient. Observations provide context for interventions 
 * subsequently taken. Observations can also be tracked over 
 * time to look for changes that may help in assessing a 
 * patient's health.</p>
 * 
 * <p>&lt;p&gt;This record expresses a single point-in-time 
 * measured observation made about a patient.&lt;/p&gt; 
 * &lt;p&gt;E.g. height, weight, blood pressure, mole diameter, 
 * gum depth, etc.&lt;/p&gt; &lt;p&gt;Note: This transaction is 
 * not intended to deal with numeric 'scores'. Those are not 
 * considered measurements and should be handled using Coded 
 * Observation.&lt;/p&gt;</p>
 */
@Hl7PartTypeMapping({"REPC_MT410003NB.CommonObservationEvent"})
@Hl7RootType
public class MeasuredObservationBean extends MessagePartBean implements ca.infoway.messagebuilder.model.nb_pr_cr_lr.iehr.comt_mt111111nb.SHR {

    private static final long serialVersionUID = 20150902L;
    private II id = new IIImpl();
    private CD code = new CDImpl();
    private BL negationInd = new BLImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private SET<CV, Code> confidentialityCode = new SETImpl<CV, Code>(CVImpl.class);
    private PQ value = new PQImpl();
    private SET<CE, Code> interpretationCode = new SETImpl<CE, Code>(CEImpl.class);
    private ServiceLocationBean indirectTargetServiceDeliveryLocation;
    private ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.coct_mt911108nb.ActingPerson responsiblePartyActingPerson;
    private List<ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.coct_mt911108nb.ActingPerson> performerActingPerson = new ArrayList<ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.coct_mt911108nb.ActingPerson>();
    private RequestedByBean author;
    private ActingPerson informantActingPerson;
    private EHRRepositoryBean custodian1AssignedDevice;
    private ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.coct_mt240003nb.ServiceLocationBean custodian2ServiceDeliveryLocation;
    private ServiceLocationBean locationServiceDeliveryLocation;
    private ObservationRequest_1Bean inFulfillmentOfActRequest;
    private List<ActDefinitionBean> definitionActDefinition = new ArrayList<ActDefinitionBean>();
    private List<OldCommonObservationEventBean> predecessorOldCommonObservationEvent = new ArrayList<OldCommonObservationEventBean>();
    private List<BecauseOfIndicationsBean> reason = new ArrayList<BecauseOfIndicationsBean>();
    private List<ComponentObservations_1Bean> componentSubObservationEvent = new ArrayList<ComponentObservations_1Bean>();
    private NewCommonObservationEventBean successorNewCommonObservationEvent;
    private List<IncludesBean> subjectOf1 = new ArrayList<IncludesBean>();
    private BL subjectOf2AnnotationIndicator = new BLImpl(false);
    private List<CareCompositionsBean> componentOf1PatientCareProvisionEvent = new ArrayList<CareCompositionsBean>();
    private List<CV> componentOf2WorkingListEventCode = new ArrayList<CV>();


    /**
     * <p>Business Name: A:Observation Record Id</p>
     * 
     * <p>Relationship: REPC_MT410003NB.CommonObservationEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Allows for unique identification of the Measured 
     * Observation and is therefore mandatory. Supports drill-down 
     * queries, linking of this record to other records, matching 
     * of EHR records to locally-stored PoS records and is 
     * necessary when identifying records for amending 
     * (revising)/directional linking (superseding).</i> </p>
     * 
     * <p> <i>A globally unique identifier assigned by the EHR to 
     * the Measured Observation record.</i> </p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: A:Observation Record Id</p>
     * 
     * <p>Relationship: REPC_MT410003NB.CommonObservationEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Allows for unique identification of the Measured 
     * Observation and is therefore mandatory. Supports drill-down 
     * queries, linking of this record to other records, matching 
     * of EHR records to locally-stored PoS records and is 
     * necessary when identifying records for amending 
     * (revising)/directional linking (superseding).</i> </p>
     * 
     * <p> <i>A globally unique identifier assigned by the EHR to 
     * the Measured Observation record.</i> </p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: B:Observation Type</p>
     * 
     * <p>Relationship: REPC_MT410003NB.CommonObservationEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Only 'nullFlavor' value of OTH is available.</p>
     * 
     * <p>EPHS: new vocab concepts needed. See implementation 
     * notes</p><p>EPHS: vocab code needed for immunization 
     * interpretation</p><p>EPHS: vocab domain needed for medical 
     * history</p><p>EPHS: vocab domain needed for 
     * Assessment</p><p>EPHS: vocab domain needed for encounter 
     * complication</p><p>EPHS: concept code needed for Outbreak 
     * Complication</p>
     * 
     * <p> <i>Observation Type is used for searching and for 
     * organizing Measured Observation records as well as sorting 
     * them for presentation.</i> </p><p> <i>This is a key 
     * attribute for understanding the type of record and is 
     * therefore mandatory.</i> </p><p> <i>This element makes use 
     * of the CD datatype to allow for use of the SNOMED code 
     * system that in some circumstances requires the use of 
     * post-coordination. Post-coordination is only supported by 
     * the CD datatype.</i> </p><p> <i>The element uses CWE to 
     * allow for the capture of Observation Type concepts not 
     * presently supported by the approved code system(s). In this 
     * case, the human-to-human benefit of capturing additional 
     * non-coded values outweighs the penalties of capturing some 
     * information that will not be amenable to searching or 
     * categorizing.</i> </p>
     * 
     * <p>EPHS:Observation.code fixed to &quot;OUTCOME&quot; at 
     * runtime</p><p>EPHS: observation.code fixed to &quot;DIRECTLY 
     * OBSERVED DOSES TAKEN&quot; at runtime</p>
     * 
     * <p> <i>Identifies the type of Measured Observation 
     * represented by this record.</i> </p><p>Observation types 
     * include: height, weight, blood pressure, etc.</p>
     */
    @Hl7XmlMapping({"code"})
    public SimpleMeasurableClinicalObservationType getCode() {
        return (SimpleMeasurableClinicalObservationType) this.code.getValue();
    }

    /**
     * <p>Business Name: B:Observation Type</p>
     * 
     * <p>Relationship: REPC_MT410003NB.CommonObservationEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Only 'nullFlavor' value of OTH is available.</p>
     * 
     * <p>EPHS: new vocab concepts needed. See implementation 
     * notes</p><p>EPHS: vocab code needed for immunization 
     * interpretation</p><p>EPHS: vocab domain needed for medical 
     * history</p><p>EPHS: vocab domain needed for 
     * Assessment</p><p>EPHS: vocab domain needed for encounter 
     * complication</p><p>EPHS: concept code needed for Outbreak 
     * Complication</p>
     * 
     * <p> <i>Observation Type is used for searching and for 
     * organizing Measured Observation records as well as sorting 
     * them for presentation.</i> </p><p> <i>This is a key 
     * attribute for understanding the type of record and is 
     * therefore mandatory.</i> </p><p> <i>This element makes use 
     * of the CD datatype to allow for use of the SNOMED code 
     * system that in some circumstances requires the use of 
     * post-coordination. Post-coordination is only supported by 
     * the CD datatype.</i> </p><p> <i>The element uses CWE to 
     * allow for the capture of Observation Type concepts not 
     * presently supported by the approved code system(s). In this 
     * case, the human-to-human benefit of capturing additional 
     * non-coded values outweighs the penalties of capturing some 
     * information that will not be amenable to searching or 
     * categorizing.</i> </p>
     * 
     * <p>EPHS:Observation.code fixed to &quot;OUTCOME&quot; at 
     * runtime</p><p>EPHS: observation.code fixed to &quot;DIRECTLY 
     * OBSERVED DOSES TAKEN&quot; at runtime</p>
     * 
     * <p> <i>Identifies the type of Measured Observation 
     * represented by this record.</i> </p><p>Observation types 
     * include: height, weight, blood pressure, etc.</p>
     */
    public void setCode(SimpleMeasurableClinicalObservationType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: D:Refuted Indicator</p>
     * 
     * <p>Relationship: 
     * REPC_MT410003NB.CommonObservationEvent.negationInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>This is primarily used to supersede records where an 
     * assertion was made that is subsequently determined to be 
     * false. It is important to be able to make explicit 
     * statements that something is known to not be true.</i> 
     * </p><p> <i>This element is mandatory because it should 
     * always be known whether the record is being refuted or not. 
     * NOTE: This element should not be used to communicate 
     * negative findings, but rather circumstances where the 
     * observation itself was not actually made. E.g. &quot;I did 
     * not make a diagnosis of meningitis&quot; would be 
     * appropriate. &quot;I diagnosed that they did not have 
     * meningitis&quot; would not. (The latter would be handled as 
     * part of the code describing the diagnosis.)</i> </p>
     * 
     * <p> <i>When set to true, specifically flags the Measured 
     * Observation record as &quot;did not occur&quot;. The default 
     * is false. Additional details about the reasons for refuting 
     * the record may be conveyed in notes.</i> </p>
     */
    @Hl7XmlMapping({"negationInd"})
    public Boolean getNegationInd() {
        return this.negationInd.getValue();
    }

    /**
     * <p>Business Name: D:Refuted Indicator</p>
     * 
     * <p>Relationship: 
     * REPC_MT410003NB.CommonObservationEvent.negationInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>This is primarily used to supersede records where an 
     * assertion was made that is subsequently determined to be 
     * false. It is important to be able to make explicit 
     * statements that something is known to not be true.</i> 
     * </p><p> <i>This element is mandatory because it should 
     * always be known whether the record is being refuted or not. 
     * NOTE: This element should not be used to communicate 
     * negative findings, but rather circumstances where the 
     * observation itself was not actually made. E.g. &quot;I did 
     * not make a diagnosis of meningitis&quot; would be 
     * appropriate. &quot;I diagnosed that they did not have 
     * meningitis&quot; would not. (The latter would be handled as 
     * part of the code describing the diagnosis.)</i> </p>
     * 
     * <p> <i>When set to true, specifically flags the Measured 
     * Observation record as &quot;did not occur&quot;. The default 
     * is false. Additional details about the reasons for refuting 
     * the record may be conveyed in notes.</i> </p>
     */
    public void setNegationInd(Boolean negationInd) {
        this.negationInd.setValue(negationInd);
    }


    /**
     * <p>Business Name: E:Observation Period</p>
     * 
     * <p>Relationship: 
     * REPC_MT410003NB.CommonObservationEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p> <i>Identifies the time-period of relevance to the record 
     * that is useful in filtering and organizing 
     * &quot;time-view&quot; presentations of data. Because the 
     * timing information won't always be known, this attribute is 
     * marked as 'populated'.</i> </p>
     * 
     * <p>EPHS: signs and symptoms onset date maps to beginning of 
     * time interval, recovery date to end of interval</p>
     * 
     * <p>Identifies the time at which the observation applies. 
     * Usually, this will be conveyed as a single point in time 
     * (center with a width of 0). However, some observations may 
     * cover a time-period with in which case start and end or 
     * start and duration may be specified.</p><p>Note that the 
     * date the observation applies is not always the same as the 
     * time the observation is actually made. A lab example: if 
     * blood was drawn two days ago and White Blood Count (WBC) was 
     * done today, then WBC observation date should reflect the 
     * date of two days ago because that is the time the 
     * observation actually applies to.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: E:Observation Period</p>
     * 
     * <p>Relationship: 
     * REPC_MT410003NB.CommonObservationEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p> <i>Identifies the time-period of relevance to the record 
     * that is useful in filtering and organizing 
     * &quot;time-view&quot; presentations of data. Because the 
     * timing information won't always be known, this attribute is 
     * marked as 'populated'.</i> </p>
     * 
     * <p>EPHS: signs and symptoms onset date maps to beginning of 
     * time interval, recovery date to end of interval</p>
     * 
     * <p>Identifies the time at which the observation applies. 
     * Usually, this will be conveyed as a single point in time 
     * (center with a width of 0). However, some observations may 
     * cover a time-period with in which case start and end or 
     * start and duration may be specified.</p><p>Note that the 
     * date the observation applies is not always the same as the 
     * time the observation is actually made. A lab example: if 
     * blood was drawn two days ago and White Blood Count (WBC) was 
     * done today, then WBC observation date should reflect the 
     * date of two days ago because that is the time the 
     * observation actually applies to.</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: D:Observation Masking Indicators</p>
     * 
     * <p>Relationship: 
     * REPC_MT410003NB.CommonObservationEvent.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-2)</p>
     * 
     * <p></p>
     * 
     * <p> <i>The value specified for a particular record may be 
     * overridden by a higher level masking applied to an 
     * indication, a care composition, a type of record or even all 
     * patient records.</i> </p>
     * 
     * <p> <i>Communicates the desire of the patient to restrict 
     * access to this Measured Observation record. Provides support 
     * for additional confidentiality constraint, giving patients a 
     * level of control over their information. Methods for 
     * accessing masked event records will be governed by each 
     * jurisdiction (e.g. court orders, shared secret/consent, 
     * etc.).</i> </p><p> <i>Can also be used to communicate that 
     * the information is deemed to be sensitive and should not be 
     * communicated or exposed to the patient (at least without the 
     * guidance of the authoring or other responsible healthcare 
     * provider).</i> </p><p> <i>Valid values are: 'normal' 
     * (denotes 'Not Masked'); 'restricted' (denotes 'Masked') and 
     * 'taboo' (denotes 'patient restricted'). The default is 
     * 'normal' signifying 'Not Masked'. Either or both of the 
     * other codes can be asserted to indicate masking by the 
     * patient from providers or masking by a provider from the 
     * patient, respectively. 'normal' should never be asserted 
     * with one of the other codes.</i> </p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_BasicConfidentialityKind> getConfidentialityCode() {
        return this.confidentialityCode.rawSet(x_BasicConfidentialityKind.class);
    }


    /**
     * <p>Business Name: L:Observation Value</p>
     * 
     * <p>Relationship: 
     * REPC_MT410003NB.CommonObservationEvent.value</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Observation Value must be specified and may only be 
     * specified when no sub-observations are present.</p>
     * 
     * <p>Conveys the clinical information resulting from the 
     * observation in a standardized representation.</p>
     * 
     * <p>Indicates what was actually observed when the observation 
     * was made.</p><p>&lt;p&gt;E.g. height in centimeters, weight 
     * in kilograms, etc.&lt;/p&gt;</p>
     */
    @Hl7XmlMapping({"value"})
    public PhysicalQuantity getValue() {
        return this.value.getValue();
    }

    /**
     * <p>Business Name: L:Observation Value</p>
     * 
     * <p>Relationship: 
     * REPC_MT410003NB.CommonObservationEvent.value</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Observation Value must be specified and may only be 
     * specified when no sub-observations are present.</p>
     * 
     * <p>Conveys the clinical information resulting from the 
     * observation in a standardized representation.</p>
     * 
     * <p>Indicates what was actually observed when the observation 
     * was made.</p><p>&lt;p&gt;E.g. height in centimeters, weight 
     * in kilograms, etc.&lt;/p&gt;</p>
     */
    public void setValue(PhysicalQuantity value) {
        this.value.setValue(value);
    }


    /**
     * <p>Business Name: M:Observation Normality Interpretation</p>
     * 
     * <p>Relationship: 
     * REPC_MT410003NB.CommonObservationEvent.interpretationCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-*)</p>
     * 
     * <p>Provides an ability to quickly flag observations that are 
     * outside the norm. These are generally the records which are 
     * of most interest from a clinical perspective.</p>
     * 
     * <p>Identifies the level of variation of the observed state 
     * from what would be considered normal for a patient of 
     * similar age and gender. E.g. &quot;Normal&quot;, 
     * &quot;High&quot;, &quot;Critically High&quot;, etc.</p>
     */
    @Hl7XmlMapping({"interpretationCode"})
    public Set<ObservationInterpretationNormality> getInterpretationCode() {
        return this.interpretationCode.rawSet(ObservationInterpretationNormality.class);
    }


    /**
     * <p>Relationship: 
     * REPC_MT410003NB.IndirectTarget.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"indirectTarget/serviceDeliveryLocation"})
    public ServiceLocationBean getIndirectTargetServiceDeliveryLocation() {
        return this.indirectTargetServiceDeliveryLocation;
    }

    /**
     * <p>Relationship: 
     * REPC_MT410003NB.IndirectTarget.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setIndirectTargetServiceDeliveryLocation(ServiceLocationBean indirectTargetServiceDeliveryLocation) {
        this.indirectTargetServiceDeliveryLocation = indirectTargetServiceDeliveryLocation;
    }


    /**
     * <p>Relationship: 
     * REPC_MT410003NB.ResponsibleParty.actingPerson</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"responsibleParty/actingPerson"})
    public ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.coct_mt911108nb.ActingPerson getResponsiblePartyActingPerson() {
        return this.responsiblePartyActingPerson;
    }

    /**
     * <p>Relationship: 
     * REPC_MT410003NB.ResponsibleParty.actingPerson</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setResponsiblePartyActingPerson(ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.coct_mt911108nb.ActingPerson responsiblePartyActingPerson) {
        this.responsiblePartyActingPerson = responsiblePartyActingPerson;
    }

    public HealthcareWorkerBean getResponsiblePartyActingPersonAsAssignedEntity1() {
        return this.responsiblePartyActingPerson instanceof HealthcareWorkerBean ? (HealthcareWorkerBean) this.responsiblePartyActingPerson : null;
    }
    public boolean hasResponsiblePartyActingPersonAsAssignedEntity1() {
        return (this.responsiblePartyActingPerson instanceof HealthcareWorkerBean);
    }

    public HealthcareOrganizationBean getResponsiblePartyActingPersonAsAssignedEntity2() {
        return this.responsiblePartyActingPerson instanceof HealthcareOrganizationBean ? (HealthcareOrganizationBean) this.responsiblePartyActingPerson : null;
    }
    public boolean hasResponsiblePartyActingPersonAsAssignedEntity2() {
        return (this.responsiblePartyActingPerson instanceof HealthcareOrganizationBean);
    }

    public RelatedPersonBean getResponsiblePartyActingPersonAsPersonalRelationship() {
        return this.responsiblePartyActingPerson instanceof RelatedPersonBean ? (RelatedPersonBean) this.responsiblePartyActingPerson : null;
    }
    public boolean hasResponsiblePartyActingPersonAsPersonalRelationship() {
        return (this.responsiblePartyActingPerson instanceof RelatedPersonBean);
    }


    /**
     * <p>Relationship: REPC_MT410003NB.Performer.actingPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"performer/actingPerson"})
    public List<ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.coct_mt911108nb.ActingPerson> getPerformerActingPerson() {
        return this.performerActingPerson;
    }


    /**
     * <p>Relationship: 
     * REPC_MT410003NB.CommonObservationEvent.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"author"})
    public RequestedByBean getAuthor() {
        return this.author;
    }

    /**
     * <p>Relationship: 
     * REPC_MT410003NB.CommonObservationEvent.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAuthor(RequestedByBean author) {
        this.author = author;
    }


    /**
     * <p>Relationship: REPC_MT410003NB.Informant.actingPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"informant/actingPerson"})
    public ActingPerson getInformantActingPerson() {
        return this.informantActingPerson;
    }

    /**
     * <p>Relationship: REPC_MT410003NB.Informant.actingPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setInformantActingPerson(ActingPerson informantActingPerson) {
        this.informantActingPerson = informantActingPerson;
    }

    public HealthcareWorkerBean getInformantActingPersonAsAssignedEntity1() {
        return this.informantActingPerson instanceof HealthcareWorkerBean ? (HealthcareWorkerBean) this.informantActingPerson : null;
    }
    public boolean hasInformantActingPersonAsAssignedEntity1() {
        return (this.informantActingPerson instanceof HealthcareWorkerBean);
    }

    public HealthcareOrganizationBean getInformantActingPersonAsAssignedEntity2() {
        return this.informantActingPerson instanceof HealthcareOrganizationBean ? (HealthcareOrganizationBean) this.informantActingPerson : null;
    }
    public boolean hasInformantActingPersonAsAssignedEntity2() {
        return (this.informantActingPerson instanceof HealthcareOrganizationBean);
    }

    public PatientBean getInformantActingPersonAsPatient() {
        return this.informantActingPerson instanceof PatientBean ? (PatientBean) this.informantActingPerson : null;
    }
    public boolean hasInformantActingPersonAsPatient() {
        return (this.informantActingPerson instanceof PatientBean);
    }


    /**
     * <p>Relationship: REPC_MT410003NB.Custodian.assignedDevice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"custodian1/assignedDevice"})
    public EHRRepositoryBean getCustodian1AssignedDevice() {
        return this.custodian1AssignedDevice;
    }

    /**
     * <p>Relationship: REPC_MT410003NB.Custodian.assignedDevice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setCustodian1AssignedDevice(EHRRepositoryBean custodian1AssignedDevice) {
        this.custodian1AssignedDevice = custodian1AssignedDevice;
    }


    /**
     * <p>Relationship: 
     * REPC_MT410003NB.Custodian2.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"custodian2/serviceDeliveryLocation"})
    public ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.coct_mt240003nb.ServiceLocationBean getCustodian2ServiceDeliveryLocation() {
        return this.custodian2ServiceDeliveryLocation;
    }

    /**
     * <p>Relationship: 
     * REPC_MT410003NB.Custodian2.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setCustodian2ServiceDeliveryLocation(ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.coct_mt240003nb.ServiceLocationBean custodian2ServiceDeliveryLocation) {
        this.custodian2ServiceDeliveryLocation = custodian2ServiceDeliveryLocation;
    }


    /**
     * <p>Relationship: 
     * REPC_MT410003NB.Location.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"location/serviceDeliveryLocation"})
    public ServiceLocationBean getLocationServiceDeliveryLocation() {
        return this.locationServiceDeliveryLocation;
    }

    /**
     * <p>Relationship: 
     * REPC_MT410003NB.Location.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setLocationServiceDeliveryLocation(ServiceLocationBean locationServiceDeliveryLocation) {
        this.locationServiceDeliveryLocation = locationServiceDeliveryLocation;
    }


    /**
     * <p>Relationship: REPC_MT410003NB.InFulfillmentOf.actRequest</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"inFulfillmentOf/actRequest"})
    public ObservationRequest_1Bean getInFulfillmentOfActRequest() {
        return this.inFulfillmentOfActRequest;
    }

    /**
     * <p>Relationship: REPC_MT410003NB.InFulfillmentOf.actRequest</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setInFulfillmentOfActRequest(ObservationRequest_1Bean inFulfillmentOfActRequest) {
        this.inFulfillmentOfActRequest = inFulfillmentOfActRequest;
    }


    /**
     * <p>Relationship: REPC_MT410003NB.Definition.actDefinition</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"definition/actDefinition"})
    public List<ActDefinitionBean> getDefinitionActDefinition() {
        return this.definitionActDefinition;
    }


    /**
     * <p>Relationship: 
     * REPC_MT410003NB.Predecessor.oldCommonObservationEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"predecessor/oldCommonObservationEvent"})
    public List<OldCommonObservationEventBean> getPredecessorOldCommonObservationEvent() {
        return this.predecessorOldCommonObservationEvent;
    }


    /**
     * <p>Relationship: 
     * REPC_MT410003NB.CommonObservationEvent.reason</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-5)</p>
     */
    @Hl7XmlMapping({"reason"})
    public List<BecauseOfIndicationsBean> getReason() {
        return this.reason;
    }


    /**
     * <p>Relationship: 
     * REPC_MT410003NB.Component.subObservationEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"component/subObservationEvent"})
    public List<ComponentObservations_1Bean> getComponentSubObservationEvent() {
        return this.componentSubObservationEvent;
    }


    /**
     * <p>Relationship: 
     * REPC_MT410003NB.Predecessor2.newCommonObservationEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"successor/newCommonObservationEvent"})
    public NewCommonObservationEventBean getSuccessorNewCommonObservationEvent() {
        return this.successorNewCommonObservationEvent;
    }

    /**
     * <p>Relationship: 
     * REPC_MT410003NB.Predecessor2.newCommonObservationEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSuccessorNewCommonObservationEvent(NewCommonObservationEventBean successorNewCommonObservationEvent) {
        this.successorNewCommonObservationEvent = successorNewCommonObservationEvent;
    }


    /**
     * <p>Relationship: 
     * REPC_MT410003NB.CommonObservationEvent.subjectOf1</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-100)</p>
     */
    @Hl7XmlMapping({"subjectOf1"})
    public List<IncludesBean> getSubjectOf1() {
        return this.subjectOf1;
    }


    /**
     * <p>Relationship: 
     * REPC_MT410003NB.Subject2.annotationIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf2/annotationIndicator"})
    public Boolean getSubjectOf2AnnotationIndicator() {
        return this.subjectOf2AnnotationIndicator.getValue();
    }

    /**
     * <p>Relationship: 
     * REPC_MT410003NB.Subject2.annotationIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSubjectOf2AnnotationIndicator(Boolean subjectOf2AnnotationIndicator) {
        this.subjectOf2AnnotationIndicator.setValue(subjectOf2AnnotationIndicator);
    }


    /**
     * <p>Relationship: 
     * REPC_MT410003NB.Component3.patientCareProvisionEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"componentOf1/patientCareProvisionEvent"})
    public List<CareCompositionsBean> getComponentOf1PatientCareProvisionEvent() {
        return this.componentOf1PatientCareProvisionEvent;
    }


    /**
     * <p>Business Name: J:Observation Categories</p>
     * 
     * <p>Relationship: REPC_MT410003NB.WorkingListEvent.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"componentOf2/workingListEvent/code"})
    public List<ActNonLabDIMeasuredObservationCategoryList> getComponentOf2WorkingListEventCode() {
        return new RawListWrapper<CV, ActNonLabDIMeasuredObservationCategoryList>(componentOf2WorkingListEventCode, CVImpl.class);
    }

}
