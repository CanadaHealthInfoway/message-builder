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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.iehr.repc_mt000010ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.DiagnosisValue;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.coct_mt090107ca.ProviderBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.merged.PatientBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.iehr.merged.ReportedByBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.merged.CommentBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.merged.RecordedAtBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.merged.RefusedByBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.merged.VersionInformationBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Hl7PartTypeMapping({"REPC_MT000010CA.MedicalCondition"})
@Hl7RootType
public class MedicalConditionBean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private II medicalConditionRecordId = new IIImpl();
    private CD conditionType = new CDImpl();
    private CS conditionStatus = new CSImpl();
    private IVL<TS, Interval<Date>> conditionTimePeriod = new IVLImpl<TS, Interval<Date>>();
    private CV conditionMaskingIndicator = new CVImpl();
    private CV condition = new CVImpl();
    private PatientBean subjectPatient;
    private ProviderBean responsiblePartyAssignedPerson;
    private RefusedByBean author;
    private ReportedByBean informant;
    private RecordedAtBean location;
    private MedicalConditionBean replacementOfMedicalCondition;
    private List<VersionInformationBean> subjectOf1ControlActEvent = new ArrayList<VersionInformationBean>();
    private List<CommentBean> subjectOf2Annotation = new ArrayList<CommentBean>();
    private BL subjectOf3ChronicIndicator = new BLImpl(false);


    /**
     * <p>A:Medical Condition Record Id</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getMedicalConditionRecordId() {
        return this.medicalConditionRecordId.getValue();
    }
    public void setMedicalConditionRecordId(Identifier medicalConditionRecordId) {
        this.medicalConditionRecordId.setValue(medicalConditionRecordId);
    }


    /**
     * <p>Condition Type</p>
     */
    @Hl7XmlMapping({"code"})
    public ActCode getConditionType() {
        return (ActCode) this.conditionType.getValue();
    }
    public void setConditionType(ActCode conditionType) {
        this.conditionType.setValue(conditionType);
    }


    /**
     * <p>D:Condition Status</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getConditionStatus() {
        return (ActStatus) this.conditionStatus.getValue();
    }
    public void setConditionStatus(ActStatus conditionStatus) {
        this.conditionStatus.setValue(conditionStatus);
    }


    /**
     * <p>E:Condition Time Period</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getConditionTimePeriod() {
        return this.conditionTimePeriod.getValue();
    }
    public void setConditionTimePeriod(Interval<Date> conditionTimePeriod) {
        this.conditionTimePeriod.setValue(conditionTimePeriod);
    }


    /**
     * <p>F:Condition Masking Indicator</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public x_VeryBasicConfidentialityKind getConditionMaskingIndicator() {
        return (x_VeryBasicConfidentialityKind) this.conditionMaskingIndicator.getValue();
    }
    public void setConditionMaskingIndicator(x_VeryBasicConfidentialityKind conditionMaskingIndicator) {
        this.conditionMaskingIndicator.setValue(conditionMaskingIndicator);
    }


    /**
     * <p>C:Condition</p>
     */
    @Hl7XmlMapping({"value"})
    public DiagnosisValue getCondition() {
        return (DiagnosisValue) this.condition.getValue();
    }
    public void setCondition(DiagnosisValue condition) {
        this.condition.setValue(condition);
    }


    @Hl7XmlMapping({"subject/patient"})
    public PatientBean getSubjectPatient() {
        return this.subjectPatient;
    }
    public void setSubjectPatient(PatientBean subjectPatient) {
        this.subjectPatient = subjectPatient;
    }


    @Hl7XmlMapping({"responsibleParty/assignedPerson"})
    public ProviderBean getResponsiblePartyAssignedPerson() {
        return this.responsiblePartyAssignedPerson;
    }
    public void setResponsiblePartyAssignedPerson(ProviderBean responsiblePartyAssignedPerson) {
        this.responsiblePartyAssignedPerson = responsiblePartyAssignedPerson;
    }


    @Hl7XmlMapping({"author"})
    public RefusedByBean getAuthor() {
        return this.author;
    }
    public void setAuthor(RefusedByBean author) {
        this.author = author;
    }


    @Hl7XmlMapping({"informant"})
    public ReportedByBean getInformant() {
        return this.informant;
    }
    public void setInformant(ReportedByBean informant) {
        this.informant = informant;
    }


    @Hl7XmlMapping({"location"})
    public RecordedAtBean getLocation() {
        return this.location;
    }
    public void setLocation(RecordedAtBean location) {
        this.location = location;
    }


    @Hl7XmlMapping({"replacementOf/medicalCondition"})
    public MedicalConditionBean getReplacementOfMedicalCondition() {
        return this.replacementOfMedicalCondition;
    }
    public void setReplacementOfMedicalCondition(MedicalConditionBean replacementOfMedicalCondition) {
        this.replacementOfMedicalCondition = replacementOfMedicalCondition;
    }


    @Hl7XmlMapping({"subjectOf1/controlActEvent"})
    public List<VersionInformationBean> getSubjectOf1ControlActEvent() {
        return this.subjectOf1ControlActEvent;
    }


    @Hl7XmlMapping({"subjectOf2/annotation"})
    public List<CommentBean> getSubjectOf2Annotation() {
        return this.subjectOf2Annotation;
    }


    @Hl7XmlMapping({"subjectOf3/chronicIndicator"})
    public Boolean getSubjectOf3ChronicIndicator() {
        return this.subjectOf3ChronicIndicator.getValue();
    }
    public void setSubjectOf3ChronicIndicator(Boolean subjectOf3ChronicIndicator) {
        this.subjectOf3ChronicIndicator.setValue(subjectOf3ChronicIndicator);
    }

}
