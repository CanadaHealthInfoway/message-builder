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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.iehr.repc_mt000007ca;

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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Hl7PartTypeMapping({"REPC_MT000007CA.MedicalCondition"})
@Hl7RootType
public class MedicalConditionBean extends MessagePartBean {

    private static final long serialVersionUID = 20111117L;
    private II id = new IIImpl();
    private CD code = new CDImpl();
    private CS statusCode = new CSImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private CV confidentialityCode = new CVImpl();
    private CV value = new CVImpl();
    private PatientBean subjectPatient;
    private ProviderBean responsiblePartyAssignedPerson;
    private RefusedByBean author;
    private ReportedByBean informant;
    private RecordedAtBean location;
    private BL subjectOf1AnnotationIndicator = new BLImpl(false);
    private List<CommentBean> subjectOf2Annotation = new ArrayList<CommentBean>();
    private BL subjectOf3ChronicIndicator = new BLImpl(false);


    /**
     * <p>A:Medical Condition Record Id</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Condition Type</p>
     */
    @Hl7XmlMapping({"code"})
    public ActCode getCode() {
        return (ActCode) this.code.getValue();
    }
    public void setCode(ActCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>D:Condition Status</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>E:Condition Time Period</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>F:Condition Masking Indicator</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public x_VeryBasicConfidentialityKind getConfidentialityCode() {
        return (x_VeryBasicConfidentialityKind) this.confidentialityCode.getValue();
    }
    public void setConfidentialityCode(x_VeryBasicConfidentialityKind confidentialityCode) {
        this.confidentialityCode.setValue(confidentialityCode);
    }


    /**
     * <p>C:Condition</p>
     */
    @Hl7XmlMapping({"value"})
    public DiagnosisValue getValue() {
        return (DiagnosisValue) this.value.getValue();
    }
    public void setValue(DiagnosisValue value) {
        this.value.setValue(value);
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


    @Hl7XmlMapping({"subjectOf1/annotationIndicator"})
    public Boolean getSubjectOf1AnnotationIndicator() {
        return this.subjectOf1AnnotationIndicator.getValue();
    }
    public void setSubjectOf1AnnotationIndicator(Boolean subjectOf1AnnotationIndicator) {
        this.subjectOf1AnnotationIndicator.setValue(subjectOf1AnnotationIndicator);
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
