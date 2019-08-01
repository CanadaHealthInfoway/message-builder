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
package ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.iehr.repc_mt410001ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CE;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CEImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.ObservationInterpretationNormality;
import ca.infoway.messagebuilder.domainvalue.SimpleMeasurableClinicalObservationType;
import ca.infoway.messagebuilder.domainvalue.x_BasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.common.coct_mt011001ca.CareCompositionsBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.common.coct_mt050207ca.PatientBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.common.coct_mt090108ca.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.common.coct_mt090508ca.HealthcareOrganizationBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.common.coct_mt240007ca.ServiceLocationBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.common.coct_mt911107ca.ActingPerson;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.iehr.merged.ActDefinitionBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.iehr.merged.ComponentObservations_1Bean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.iehr.merged.OldCommonObservationEventBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.iehr.merged.Request_2Bean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.merged.BecauseOfBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.merged.IncludesBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.merged.OccurredAtBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;



/**
 * <p>Business Name: Measured Observation</p>
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
@Hl7PartTypeMapping({"REPC_MT410001CA.CommonObservationEvent"})
@Hl7RootType
public class MeasuredObservationBean extends MessagePartBean {

    private static final long serialVersionUID = 20190801L;
    private CD code = new CDImpl();
    private BL negationInd = new BLImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private SET<CV, Code> confidentialityCode = new SETImpl<CV, Code>(CVImpl.class);
    private PQ value = new PQImpl();
    private CE interpretationCode = new CEImpl();
    private ServiceLocationBean indirectTargetServiceDeliveryLocation;
    private List<ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.common.coct_mt911108ca.ActingPerson> performerActingPerson = new ArrayList<ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.common.coct_mt911108ca.ActingPerson>();
    private ActingPerson informantActingPerson;
    private OccurredAtBean location;
    private Request_2Bean inFulfillmentOfActRequest;
    private List<ActDefinitionBean> definitionActDefinition = new ArrayList<ActDefinitionBean>();
    private List<OldCommonObservationEventBean> predecessorOldCommonObservationEvent = new ArrayList<OldCommonObservationEventBean>();
    private List<BecauseOfBean> reason = new ArrayList<BecauseOfBean>();
    private List<ComponentObservations_1Bean> componentSubObservationEvent = new ArrayList<ComponentObservations_1Bean>();
    private IncludesBean subjectOf;
    private List<CareCompositionsBean> componentOfPatientCareProvisionEvent = new ArrayList<CareCompositionsBean>();


    /**
     * <p>Business Name: B:Observation Type</p>
     * 
     * <p>Relationship: REPC_MT410001CA.CommonObservationEvent.code</p>
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
     * <p>Relationship: REPC_MT410001CA.CommonObservationEvent.code</p>
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
     * REPC_MT410001CA.CommonObservationEvent.negationInd</p>
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
     * REPC_MT410001CA.CommonObservationEvent.negationInd</p>
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
     * REPC_MT410001CA.CommonObservationEvent.effectiveTime</p>
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
     * REPC_MT410001CA.CommonObservationEvent.effectiveTime</p>
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
     * REPC_MT410001CA.CommonObservationEvent.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-2)</p>
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
     * REPC_MT410001CA.CommonObservationEvent.value</p>
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
     * REPC_MT410001CA.CommonObservationEvent.value</p>
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
     * REPC_MT410001CA.CommonObservationEvent.interpretationCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Provides an ability to quickly flag observations that are 
     * outside the norm. These are generally the records which are 
     * of most interest from a clinical perspective.</p>
     * 
     * <p>Identifies the level of variation of the observed state 
     * from what would be considered normal for a patient of 
     * similar age and gender. E.g. &quot;Normal&quot;, 
     * &quot;High&quot;, etc.</p>
     */
    @Hl7XmlMapping({"interpretationCode"})
    public ObservationInterpretationNormality getInterpretationCode() {
        return (ObservationInterpretationNormality) this.interpretationCode.getValue();
    }

    /**
     * <p>Business Name: M:Observation Normality Interpretation</p>
     * 
     * <p>Relationship: 
     * REPC_MT410001CA.CommonObservationEvent.interpretationCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Provides an ability to quickly flag observations that are 
     * outside the norm. These are generally the records which are 
     * of most interest from a clinical perspective.</p>
     * 
     * <p>Identifies the level of variation of the observed state 
     * from what would be considered normal for a patient of 
     * similar age and gender. E.g. &quot;Normal&quot;, 
     * &quot;High&quot;, etc.</p>
     */
    public void setInterpretationCode(ObservationInterpretationNormality interpretationCode) {
        this.interpretationCode.setValue(interpretationCode);
    }


    /**
     * <p>Relationship: 
     * REPC_MT410001CA.IndirectTarget.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"indirectTarget/serviceDeliveryLocation"})
    public ServiceLocationBean getIndirectTargetServiceDeliveryLocation() {
        return this.indirectTargetServiceDeliveryLocation;
    }

    /**
     * <p>Relationship: 
     * REPC_MT410001CA.IndirectTarget.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setIndirectTargetServiceDeliveryLocation(ServiceLocationBean indirectTargetServiceDeliveryLocation) {
        this.indirectTargetServiceDeliveryLocation = indirectTargetServiceDeliveryLocation;
    }


    /**
     * <p>Relationship: REPC_MT410001CA.Performer.actingPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"performer/actingPerson"})
    public List<ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.common.coct_mt911108ca.ActingPerson> getPerformerActingPerson() {
        return this.performerActingPerson;
    }


    /**
     * <p>Relationship: REPC_MT410001CA.Informant.actingPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"informant/actingPerson"})
    public ActingPerson getInformantActingPerson() {
        return this.informantActingPerson;
    }

    /**
     * <p>Relationship: REPC_MT410001CA.Informant.actingPerson</p>
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
     * <p>Relationship: 
     * REPC_MT410001CA.CommonObservationEvent.location</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"location"})
    public OccurredAtBean getLocation() {
        return this.location;
    }

    /**
     * <p>Relationship: 
     * REPC_MT410001CA.CommonObservationEvent.location</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setLocation(OccurredAtBean location) {
        this.location = location;
    }


    /**
     * <p>Relationship: REPC_MT410001CA.InFulfillmentOf.actRequest</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"inFulfillmentOf/actRequest"})
    public Request_2Bean getInFulfillmentOfActRequest() {
        return this.inFulfillmentOfActRequest;
    }

    /**
     * <p>Relationship: REPC_MT410001CA.InFulfillmentOf.actRequest</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setInFulfillmentOfActRequest(Request_2Bean inFulfillmentOfActRequest) {
        this.inFulfillmentOfActRequest = inFulfillmentOfActRequest;
    }


    /**
     * <p>Relationship: REPC_MT410001CA.Definition.actDefinition</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"definition/actDefinition"})
    public List<ActDefinitionBean> getDefinitionActDefinition() {
        return this.definitionActDefinition;
    }


    /**
     * <p>Relationship: 
     * REPC_MT410001CA.Predecessor.oldCommonObservationEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"predecessor/oldCommonObservationEvent"})
    public List<OldCommonObservationEventBean> getPredecessorOldCommonObservationEvent() {
        return this.predecessorOldCommonObservationEvent;
    }


    /**
     * <p>Relationship: 
     * REPC_MT410001CA.CommonObservationEvent.reason</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-5)</p>
     */
    @Hl7XmlMapping({"reason"})
    public List<BecauseOfBean> getReason() {
        return this.reason;
    }


    /**
     * <p>Relationship: 
     * REPC_MT410001CA.Component.subObservationEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"component/subObservationEvent"})
    public List<ComponentObservations_1Bean> getComponentSubObservationEvent() {
        return this.componentSubObservationEvent;
    }


    /**
     * <p>Relationship: 
     * REPC_MT410001CA.CommonObservationEvent.subjectOf</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"subjectOf"})
    public IncludesBean getSubjectOf() {
        return this.subjectOf;
    }

    /**
     * <p>Relationship: 
     * REPC_MT410001CA.CommonObservationEvent.subjectOf</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setSubjectOf(IncludesBean subjectOf) {
        this.subjectOf = subjectOf;
    }


    /**
     * <p>Relationship: 
     * REPC_MT410001CA.Component3.patientCareProvisionEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"componentOf/patientCareProvisionEvent"})
    public List<CareCompositionsBean> getComponentOfPatientCareProvisionEvent() {
        return this.componentOfPatientCareProvisionEvent;
    }

}
