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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.iehr.repc_mt000005ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.ActUncertainty;
import ca.infoway.messagebuilder.domainvalue.IntoleranceValue;
import ca.infoway.messagebuilder.domainvalue.ObservationIntoleranceType;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.coct_mt090107ca.ProviderBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.merged.PatientBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.iehr.merged.Records;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.iehr.merged.ReportedByBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.merged.AllergyIntoleranceSeverityLevelBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.merged.CommentBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.merged.RecordedAtBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.merged.RefusedByBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Hl7PartTypeMapping({"REPC_MT000005CA.IntoleranceCondition"})
@Hl7RootType
public class AllergyIntoleranceBean extends MessagePartBean {

    private static final long serialVersionUID = 20111121L;
    private II id = new IIImpl();
    private CD code = new CDImpl();
    private BL negationInd = new BLImpl();
    private CS statusCode = new CSImpl();
    private TS effectiveTime = new TSImpl();
    private CV confidentialityCode = new CVImpl();
    private CV uncertaintyCode = new CVImpl();
    private CV value = new CVImpl();
    private PatientBean subjectPatient;
    private ProviderBean responsiblePartyAssignedPerson;
    private RefusedByBean author;
    private ReportedByBean informant;
    private RecordedAtBean location;
    private List<Records> supportRecords = new ArrayList<Records>();
    private List<CommentBean> subjectOf1Annotation = new ArrayList<CommentBean>();
    private AllergyIntoleranceSeverityLevelBean subjectOf2SeverityObservation;
    private BL subjectOf3AnnotationIndicator = new BLImpl(false);


    /**
     * <p><p>This is the identifier of the allergy/intolerance 
     * record.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p><p><strong>This will indicate whether this is a drug 
     * allergy, a non- drug allergy, a drug intolerance, or a 
     * non-drug intolerance.</strong></p></p>
     */
    @Hl7XmlMapping({"code"})
    public ObservationIntoleranceType getCode() {
        return (ObservationIntoleranceType) this.code.getValue();
    }
    public void setCode(ObservationIntoleranceType code) {
        this.code.setValue(code);
    }


    /**
     * <p>G:Allergy/Intolerance Refuted</p>
     */
    @Hl7XmlMapping({"negationInd"})
    public Boolean getNegationInd() {
        return this.negationInd.getValue();
    }
    public void setNegationInd(Boolean negationInd) {
        this.negationInd.setValue(negationInd);
    }


    /**
     * <p>E:Allergy/Intolerance Status</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>I:Allergy/Intolerance Date</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Date getEffectiveTime() {
        return this.effectiveTime.getValue();
    }
    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>H:Allergy/Intolerance Masking Indicator</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public x_VeryBasicConfidentialityKind getConfidentialityCode() {
        return (x_VeryBasicConfidentialityKind) this.confidentialityCode.getValue();
    }
    public void setConfidentialityCode(x_VeryBasicConfidentialityKind confidentialityCode) {
        this.confidentialityCode.setValue(confidentialityCode);
    }


    /**
     * <p>F:Confirmed Indicator</p>
     */
    @Hl7XmlMapping({"uncertaintyCode"})
    public ActUncertainty getUncertaintyCode() {
        return (ActUncertainty) this.uncertaintyCode.getValue();
    }
    public void setUncertaintyCode(ActUncertainty uncertaintyCode) {
        this.uncertaintyCode.setValue(uncertaintyCode);
    }


    /**
     * <p>B:Agent</p>
     */
    @Hl7XmlMapping({"value"})
    public IntoleranceValue getValue() {
        return (IntoleranceValue) this.value.getValue();
    }
    public void setValue(IntoleranceValue value) {
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


    @Hl7XmlMapping({"support/records"})
    public List<Records> getSupportRecords() {
        return this.supportRecords;
    }


    @Hl7XmlMapping({"subjectOf1/annotation"})
    public List<CommentBean> getSubjectOf1Annotation() {
        return this.subjectOf1Annotation;
    }


    @Hl7XmlMapping({"subjectOf2/severityObservation"})
    public AllergyIntoleranceSeverityLevelBean getSubjectOf2SeverityObservation() {
        return this.subjectOf2SeverityObservation;
    }
    public void setSubjectOf2SeverityObservation(AllergyIntoleranceSeverityLevelBean subjectOf2SeverityObservation) {
        this.subjectOf2SeverityObservation = subjectOf2SeverityObservation;
    }


    @Hl7XmlMapping({"subjectOf3/annotationIndicator"})
    public Boolean getSubjectOf3AnnotationIndicator() {
        return this.subjectOf3AnnotationIndicator.getValue();
    }
    public void setSubjectOf3AnnotationIndicator(Boolean subjectOf3AnnotationIndicator) {
        this.subjectOf3AnnotationIndicator.setValue(subjectOf3AnnotationIndicator);
    }

}
