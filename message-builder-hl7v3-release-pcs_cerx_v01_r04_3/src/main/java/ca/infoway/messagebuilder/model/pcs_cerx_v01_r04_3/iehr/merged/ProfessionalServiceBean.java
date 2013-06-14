/**
 * Copyright 2013 Canada Health, Inc.
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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.iehr.merged;

import ca.infoway.messagebuilder.annotation.Hl7MapByPartType;
import ca.infoway.messagebuilder.annotation.Hl7MapByPartTypes;
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
import ca.infoway.messagebuilder.domainvalue.ActProfessionalServiceCode;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.coct_mt090107ca.ProviderBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.coct_mt240003ca.ServiceLocationBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.merged.PatientBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.merged.CommentBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.merged.RefusedByBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Business Name: ProfessionalService</p>
 * 
 * <p>REPC_MT000017CA.ProcedureEvent: Professional Service</p>
 * 
 * <p>A_BillableClinicalService</p>
 * 
 * <p>May be pertinent information with respect to a patient's 
 * drug therapy regime.</p>
 * 
 * <p>This is the information that is recorded and maintained 
 * on a consultative service provided to a patient. This 
 * service may or may not be related to a prescribed, dispensed 
 * or administered drug.</p>
 * 
 * <p>REPC_MT100001CA.ProcedureEvent: Professional Service</p>
 * 
 * <p>Annotation is only permitted if Annotation Indicator is 
 * not present and vice versa</p>
 * 
 * <p>A_BillableClinicalService</p>
 * 
 * <p>May be pertinent information with respect to a patient's 
 * drug therapy regime.</p>
 * 
 * <p>This is the information that is recorded and maintained 
 * on a consultative service provided to a patient. This 
 * service may or may not be related to a prescribed, dispensed 
 * or administered drug.</p>
 */
@Hl7PartTypeMapping({"REPC_MT000017CA.ProcedureEvent","REPC_MT100001CA.ProcedureEvent"})
@Hl7RootType
public class ProfessionalServiceBean extends MessagePartBean {

    private static final long serialVersionUID = 20130613L;
    private CV code = new CVImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private CV confidentialityCode = new CVImpl();
    private PatientBean subjectPatient;
    private RefusedByBean inFulfillmentOfActRequestAuthor;
    private List<CommentBean> subjectOf2Annotation = new ArrayList<CommentBean>();
    private II id = new IIImpl();
    private ProviderBean responsiblePartyAssignedPerson;
    private ProviderBean performerAssignedPerson;
    private ServiceLocationBean locationServiceDeliveryLocation;
    private BL subjectOf1AnnotationIndicator = new BLImpl(false);


    /**
     * <p>Business Name: ServiceCode</p>
     * 
     * <p>Un-merged Business Name: ServiceCode</p>
     * 
     * <p>Relationship: REPC_MT000017CA.ProcedureEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>PatientConsultation.category</p>
     * 
     * <p>D57</p>
     * 
     * <p>ZPS.5.1</p>
     * 
     * <p>ZPS.5.2 (experience handled as qualifier)</p>
     * 
     * <p>Claim.436-E1 (code system)</p>
     * 
     * <p>Claim.407-D7 (mnemonic)</p>
     * 
     * <p>Claim.459-ER (modifier)</p>
     * 
     * <p>Claim.418-DI (modifier)</p>
     * 
     * <p>DUR/PPS.474-8E (modifier)</p>
     * 
     * <p>A_BillableClinicalService</p>
     * 
     * <p>Allows the service to be sorted and filtered. Ensures 
     * consistency for analysis and reporting purposes and is 
     * therefore mandatory</p>
     * 
     * <p>Identifies the specific service that has been performed. 
     * This is obtained from the professional service catalog 
     * pertaining to the discipline of the health service 
     * provider.</p>
     * 
     * <p>Un-merged Business Name: ServiceCode</p>
     * 
     * <p>Relationship: REPC_MT100001CA.ProcedureEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>PatientConsultation.category</p>
     * 
     * <p>D57</p>
     * 
     * <p>ZPS.5.1</p>
     * 
     * <p>ZPS.5.2 (experience handled as qualifier)</p>
     * 
     * <p>Claim.436-E1 (code system)</p>
     * 
     * <p>Claim.407-D7 (mnemonic)</p>
     * 
     * <p>Claim.459-ER (modifier)</p>
     * 
     * <p>Claim.418-DI (modifier)</p>
     * 
     * <p>DUR/PPS.474-8E (modifier)</p>
     * 
     * <p>A_BillableClinicalService</p>
     * 
     * <p>Allows the service to be sorted and filtered. Ensures 
     * consistency for analysis and reporting purposes and is 
     * therefore mandatory</p>
     * 
     * <p>Identifies the specific service that has been performed. 
     * This is obtained from the professional service catalog 
     * pertaining to the discipline of the health service 
     * provider.</p>
     */
    @Hl7XmlMapping({"code"})
    public ActProfessionalServiceCode getCode() {
        return (ActProfessionalServiceCode) this.code.getValue();
    }

    /**
     * <p>Business Name: ServiceCode</p>
     * 
     * <p>Un-merged Business Name: ServiceCode</p>
     * 
     * <p>Relationship: REPC_MT000017CA.ProcedureEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>PatientConsultation.category</p>
     * 
     * <p>D57</p>
     * 
     * <p>ZPS.5.1</p>
     * 
     * <p>ZPS.5.2 (experience handled as qualifier)</p>
     * 
     * <p>Claim.436-E1 (code system)</p>
     * 
     * <p>Claim.407-D7 (mnemonic)</p>
     * 
     * <p>Claim.459-ER (modifier)</p>
     * 
     * <p>Claim.418-DI (modifier)</p>
     * 
     * <p>DUR/PPS.474-8E (modifier)</p>
     * 
     * <p>A_BillableClinicalService</p>
     * 
     * <p>Allows the service to be sorted and filtered. Ensures 
     * consistency for analysis and reporting purposes and is 
     * therefore mandatory</p>
     * 
     * <p>Identifies the specific service that has been performed. 
     * This is obtained from the professional service catalog 
     * pertaining to the discipline of the health service 
     * provider.</p>
     * 
     * <p>Un-merged Business Name: ServiceCode</p>
     * 
     * <p>Relationship: REPC_MT100001CA.ProcedureEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>PatientConsultation.category</p>
     * 
     * <p>D57</p>
     * 
     * <p>ZPS.5.1</p>
     * 
     * <p>ZPS.5.2 (experience handled as qualifier)</p>
     * 
     * <p>Claim.436-E1 (code system)</p>
     * 
     * <p>Claim.407-D7 (mnemonic)</p>
     * 
     * <p>Claim.459-ER (modifier)</p>
     * 
     * <p>Claim.418-DI (modifier)</p>
     * 
     * <p>DUR/PPS.474-8E (modifier)</p>
     * 
     * <p>A_BillableClinicalService</p>
     * 
     * <p>Allows the service to be sorted and filtered. Ensures 
     * consistency for analysis and reporting purposes and is 
     * therefore mandatory</p>
     * 
     * <p>Identifies the specific service that has been performed. 
     * This is obtained from the professional service catalog 
     * pertaining to the discipline of the health service 
     * provider.</p>
     */
    public void setCode(ActProfessionalServiceCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: ConsultationTimeAndLength</p>
     * 
     * <p>Un-merged Business Name: ConsultationTimeAndLength</p>
     * 
     * <p>Relationship: 
     * REPC_MT000017CA.ProcedureEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Center date cannot be null But duration can be left 
     * unspecified if not known.</p>
     * 
     * <p>PatientConsultation.eventTime(Low)</p>
     * 
     * <p>patientConsultation.eventDuration(Width)</p>
     * 
     * <p>ZPS.4 (center)</p>
     * 
     * <p>ZPS.5.2(timing portion of code set)</p>
     * 
     * <p>Claim.457-EP</p>
     * 
     * <p>A_BillableClinicalService</p>
     * 
     * <p>Allows the service-event to be located in a particular 
     * time. Because a time won't always be known, the attribute is 
     * only marked as &quot;populated&quot;. The duration of the 
     * consultation may also be of clinical interest.</p>
     * 
     * <p>The date and time on which the professional service was 
     * performed, as well as the duration of the service.</p>
     * 
     * <p>Un-merged Business Name: ConsultationTimeAndLength</p>
     * 
     * <p>Relationship: 
     * REPC_MT100001CA.ProcedureEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Center date cannot be null But duration can be left 
     * unspecified if not known.</p>
     * 
     * <p>PatientConsultation.eventTime(Low)</p>
     * 
     * <p>patientConsultation.eventDuration(Width)</p>
     * 
     * <p>ZPS.4 (center)</p>
     * 
     * <p>ZPS.5.2(timing portion of code set)</p>
     * 
     * <p>Claim.457-EP</p>
     * 
     * <p>A_BillableClinicalService</p>
     * 
     * <p>Allows the service-event to be located in a particular 
     * time. Because a time won't always be known, the attribute is 
     * only marked as &quot;populated&quot;. The duration of the 
     * consultation may also be of clinical interest.</p>
     * 
     * <p>The date and time on which the professional service was 
     * performed, as well as the duration of the service.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: ConsultationTimeAndLength</p>
     * 
     * <p>Un-merged Business Name: ConsultationTimeAndLength</p>
     * 
     * <p>Relationship: 
     * REPC_MT000017CA.ProcedureEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Center date cannot be null But duration can be left 
     * unspecified if not known.</p>
     * 
     * <p>PatientConsultation.eventTime(Low)</p>
     * 
     * <p>patientConsultation.eventDuration(Width)</p>
     * 
     * <p>ZPS.4 (center)</p>
     * 
     * <p>ZPS.5.2(timing portion of code set)</p>
     * 
     * <p>Claim.457-EP</p>
     * 
     * <p>A_BillableClinicalService</p>
     * 
     * <p>Allows the service-event to be located in a particular 
     * time. Because a time won't always be known, the attribute is 
     * only marked as &quot;populated&quot;. The duration of the 
     * consultation may also be of clinical interest.</p>
     * 
     * <p>The date and time on which the professional service was 
     * performed, as well as the duration of the service.</p>
     * 
     * <p>Un-merged Business Name: ConsultationTimeAndLength</p>
     * 
     * <p>Relationship: 
     * REPC_MT100001CA.ProcedureEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Center date cannot be null But duration can be left 
     * unspecified if not known.</p>
     * 
     * <p>PatientConsultation.eventTime(Low)</p>
     * 
     * <p>patientConsultation.eventDuration(Width)</p>
     * 
     * <p>ZPS.4 (center)</p>
     * 
     * <p>ZPS.5.2(timing portion of code set)</p>
     * 
     * <p>Claim.457-EP</p>
     * 
     * <p>A_BillableClinicalService</p>
     * 
     * <p>Allows the service-event to be located in a particular 
     * time. Because a time won't always be known, the attribute is 
     * only marked as &quot;populated&quot;. The duration of the 
     * consultation may also be of clinical interest.</p>
     * 
     * <p>The date and time on which the professional service was 
     * performed, as well as the duration of the service.</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: ProfessionalServiceMaskingIndicator</p>
     * 
     * <p>Un-merged Business Name: 
     * ProfessionalServiceMaskingIndicator</p>
     * 
     * <p>Relationship: 
     * REPC_MT000017CA.ProcedureEvent.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Allows the patient to have discrete control over access 
     * to their medication data.</p><p>The attribute is optional 
     * because not all systems will support masking.</p>
     * 
     * <p>Communicates the intent of the patient to restrict access 
     * to their professional service record. Provides support for 
     * additional confidentiality constraint, giving patients a 
     * level of control over their information. Valid values are: 
     * 'NORMAL' (denotes 'Not Masked'); and 'RESTRICTED' (denotes 
     * 'Masked'). The default is 'NORMAL' signifying 'Not 
     * Masked'.</p>
     * 
     * <p>Un-merged Business Name: 
     * ProfessionalServiceMaskingIndicator</p>
     * 
     * <p>Relationship: 
     * REPC_MT100001CA.ProcedureEvent.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Allows the patient to have discrete control over access 
     * to their medication data.</p><p>The attribute is optional 
     * because not all systems will support masking.</p>
     * 
     * <p>Communicates the intent of the patient to restrict access 
     * to their professional service records. Provides support for 
     * additional confidentiality constraint, giving patients a 
     * level of control over their information. Valid values are: 
     * 'NORMAL' (denotes 'Not Masked'); and 'RESTRICTED' (denotes 
     * 'Masked'). The default is 'NORMAL' signifying 'Not 
     * Masked'.</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public x_VeryBasicConfidentialityKind getConfidentialityCode() {
        return (x_VeryBasicConfidentialityKind) this.confidentialityCode.getValue();
    }

    /**
     * <p>Business Name: ProfessionalServiceMaskingIndicator</p>
     * 
     * <p>Un-merged Business Name: 
     * ProfessionalServiceMaskingIndicator</p>
     * 
     * <p>Relationship: 
     * REPC_MT000017CA.ProcedureEvent.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Allows the patient to have discrete control over access 
     * to their medication data.</p><p>The attribute is optional 
     * because not all systems will support masking.</p>
     * 
     * <p>Communicates the intent of the patient to restrict access 
     * to their professional service record. Provides support for 
     * additional confidentiality constraint, giving patients a 
     * level of control over their information. Valid values are: 
     * 'NORMAL' (denotes 'Not Masked'); and 'RESTRICTED' (denotes 
     * 'Masked'). The default is 'NORMAL' signifying 'Not 
     * Masked'.</p>
     * 
     * <p>Un-merged Business Name: 
     * ProfessionalServiceMaskingIndicator</p>
     * 
     * <p>Relationship: 
     * REPC_MT100001CA.ProcedureEvent.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Allows the patient to have discrete control over access 
     * to their medication data.</p><p>The attribute is optional 
     * because not all systems will support masking.</p>
     * 
     * <p>Communicates the intent of the patient to restrict access 
     * to their professional service records. Provides support for 
     * additional confidentiality constraint, giving patients a 
     * level of control over their information. Valid values are: 
     * 'NORMAL' (denotes 'Not Masked'); and 'RESTRICTED' (denotes 
     * 'Masked'). The default is 'NORMAL' signifying 'Not 
     * Masked'.</p>
     */
    public void setConfidentialityCode(x_VeryBasicConfidentialityKind confidentialityCode) {
        this.confidentialityCode.setValue(confidentialityCode);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000017CA.Subject.patient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT100001CA.Subject.patient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"subject/patient"})
    public PatientBean getSubjectPatient() {
        return this.subjectPatient;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000017CA.Subject.patient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT100001CA.Subject.patient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setSubjectPatient(PatientBean subjectPatient) {
        this.subjectPatient = subjectPatient;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000017CA.ActRequest.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT100001CA.ActRequest.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"inFulfillmentOf/actRequest/author"})
    public RefusedByBean getInFulfillmentOfActRequestAuthor() {
        return this.inFulfillmentOfActRequestAuthor;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000017CA.ActRequest.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT100001CA.ActRequest.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setInFulfillmentOfActRequestAuthor(RefusedByBean inFulfillmentOfActRequestAuthor) {
        this.inFulfillmentOfActRequestAuthor = inFulfillmentOfActRequestAuthor;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000017CA.Subject2.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT100001CA.Subject2.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf/annotation","subjectOf2/annotation"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="subjectOf", type="REPC_MT000017CA.Subject2"),
        @Hl7MapByPartType(name="subjectOf/annotation", type="COCT_MT120600CA.Annotation"),
        @Hl7MapByPartType(name="subjectOf2", type="REPC_MT100001CA.Subject2"),
        @Hl7MapByPartType(name="subjectOf2/annotation", type="COCT_MT120600CA.Annotation")})
    public List<CommentBean> getSubjectOf2Annotation() {
        return this.subjectOf2Annotation;
    }


    /**
     * <p>Business Name: ServiceRecordIdentifier</p>
     * 
     * <p>Un-merged Business Name: ServiceRecordIdentifier</p>
     * 
     * <p>Relationship: REPC_MT100001CA.ProcedureEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>PatientConsultation.patientConsultationkey</p>
     * 
     * <p>PatientConsultation.externalId</p>
     * 
     * <p>ZRV.5</p>
     * 
     * <p>ZPS.2</p>
     * 
     * <p>ZPS.3</p>
     * 
     * <p>Claim.455-EM (root)</p>
     * 
     * <p>Claim.402-D2 (extension)</p>
     * 
     * <p>A_BillableClinicalService</p>
     * 
     * <p>Allows cognitive services to be uniquely referenced and 
     * is therefore mandatory.</p>
     * 
     * <p>A unique identifier for a patient consultation service 
     * record.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: ServiceRecordIdentifier</p>
     * 
     * <p>Un-merged Business Name: ServiceRecordIdentifier</p>
     * 
     * <p>Relationship: REPC_MT100001CA.ProcedureEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>PatientConsultation.patientConsultationkey</p>
     * 
     * <p>PatientConsultation.externalId</p>
     * 
     * <p>ZRV.5</p>
     * 
     * <p>ZPS.2</p>
     * 
     * <p>ZPS.3</p>
     * 
     * <p>Claim.455-EM (root)</p>
     * 
     * <p>Claim.402-D2 (extension)</p>
     * 
     * <p>A_BillableClinicalService</p>
     * 
     * <p>Allows cognitive services to be uniquely referenced and 
     * is therefore mandatory.</p>
     * 
     * <p>A unique identifier for a patient consultation service 
     * record.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT100001CA.ResponsibleParty2.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"responsibleParty/assignedPerson"})
    public ProviderBean getResponsiblePartyAssignedPerson() {
        return this.responsiblePartyAssignedPerson;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT100001CA.ResponsibleParty2.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setResponsiblePartyAssignedPerson(ProviderBean responsiblePartyAssignedPerson) {
        this.responsiblePartyAssignedPerson = responsiblePartyAssignedPerson;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT100001CA.Performer.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"performer/assignedPerson"})
    public ProviderBean getPerformerAssignedPerson() {
        return this.performerAssignedPerson;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT100001CA.Performer.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setPerformerAssignedPerson(ProviderBean performerAssignedPerson) {
        this.performerAssignedPerson = performerAssignedPerson;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT100001CA.Location.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"location/serviceDeliveryLocation"})
    public ServiceLocationBean getLocationServiceDeliveryLocation() {
        return this.locationServiceDeliveryLocation;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT100001CA.Location.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setLocationServiceDeliveryLocation(ServiceLocationBean locationServiceDeliveryLocation) {
        this.locationServiceDeliveryLocation = locationServiceDeliveryLocation;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT100001CA.Subject3.annotationIndicator</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf1/annotationIndicator"})
    public Boolean getSubjectOf1AnnotationIndicator() {
        return this.subjectOf1AnnotationIndicator.getValue();
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT100001CA.Subject3.annotationIndicator</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setSubjectOf1AnnotationIndicator(Boolean subjectOf1AnnotationIndicator) {
        this.subjectOf1AnnotationIndicator.setValue(subjectOf1AnnotationIndicator);
    }

}
