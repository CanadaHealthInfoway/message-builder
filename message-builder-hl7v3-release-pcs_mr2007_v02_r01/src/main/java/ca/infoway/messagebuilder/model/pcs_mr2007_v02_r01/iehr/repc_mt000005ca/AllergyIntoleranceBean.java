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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.iehr.repc_mt000005ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.ActUncertainty;
import ca.infoway.messagebuilder.domainvalue.IntoleranceValue;
import ca.infoway.messagebuilder.domainvalue.ObservationIntoleranceType;
import ca.infoway.messagebuilder.domainvalue.x_NormalRestrictedTabooConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.common.coct_mt011001ca.CareCompositionsBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.common.coct_mt120600ca.NotesBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.iehr.merged.AllergyTestsBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.iehr.merged.Records;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.iehr.merged.ReportedByBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.iehr.merged.ReportedReactionsBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.merged.AllergyIntoleranceSeverityLevelBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.merged.CreatedAtBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.merged.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.merged.RefusedByBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;



@Hl7PartTypeMapping({"REPC_MT000005CA.IntoleranceCondition"})
@Hl7RootType
public class AllergyIntoleranceBean extends MessagePartBean {

    private static final long serialVersionUID = 20110729L;
    private II allergyIntoleranceRecordId = new IIImpl();
    private CD allergyIntoleranceType = new CDImpl();
    private BL allergyIntoleranceRefuted = new BLImpl();
    private CS allergyIntoleranceStatus = new CSImpl();
    private TS allergyIntoleranceDate = new TSImpl();
    private SET<CV, Code> allergyIntoleranceMaskingIndicators = new SETImpl<CV, Code>(CVImpl.class);
    private CV confirmedIndicator = new CVImpl();
    private CV agent = new CVImpl();
    private HealthcareWorkerBean responsiblePartyAssignedEntity;
    private RefusedByBean author;
    private ReportedByBean informant;
    private CreatedAtBean location;
    private List<Records> supportRecords = new ArrayList<Records>();
    private List<NotesBean> subjectOf1Annotation = new ArrayList<NotesBean>();
    private AllergyIntoleranceSeverityLevelBean subjectOf2SeverityObservation;
    private BL subjectOf3AnnotationIndicator = new BLImpl(false);
    private List<CareCompositionsBean> componentOfPatientCareProvisionEvent = new ArrayList<CareCompositionsBean>();


    /**
     * <p>D:Allergy/Intolerance Record Id</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getAllergyIntoleranceRecordId() {
        return this.allergyIntoleranceRecordId.getValue();
    }
    public void setAllergyIntoleranceRecordId(Identifier allergyIntoleranceRecordId) {
        this.allergyIntoleranceRecordId.setValue(allergyIntoleranceRecordId);
    }


    /**
     * <p>A:Allergy/Intolerance Type</p>
     */
    @Hl7XmlMapping({"code"})
    public ObservationIntoleranceType getAllergyIntoleranceType() {
        return (ObservationIntoleranceType) this.allergyIntoleranceType.getValue();
    }
    public void setAllergyIntoleranceType(ObservationIntoleranceType allergyIntoleranceType) {
        this.allergyIntoleranceType.setValue(allergyIntoleranceType);
    }


    /**
     * <p>G:Allergy/Intolerance Refuted</p>
     */
    @Hl7XmlMapping({"negationInd"})
    public Boolean getAllergyIntoleranceRefuted() {
        return this.allergyIntoleranceRefuted.getValue();
    }
    public void setAllergyIntoleranceRefuted(Boolean allergyIntoleranceRefuted) {
        this.allergyIntoleranceRefuted.setValue(allergyIntoleranceRefuted);
    }


    /**
     * <p>E:Allergy/Intolerance Status</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getAllergyIntoleranceStatus() {
        return (ActStatus) this.allergyIntoleranceStatus.getValue();
    }
    public void setAllergyIntoleranceStatus(ActStatus allergyIntoleranceStatus) {
        this.allergyIntoleranceStatus.setValue(allergyIntoleranceStatus);
    }


    /**
     * <p>I:Allergy/Intolerance Date</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Date getAllergyIntoleranceDate() {
        return this.allergyIntoleranceDate.getValue();
    }
    public void setAllergyIntoleranceDate(Date allergyIntoleranceDate) {
        this.allergyIntoleranceDate.setValue(allergyIntoleranceDate);
    }


    /**
     * <p>H:Allergy/Intolerance Masking Indicators</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_NormalRestrictedTabooConfidentialityKind> getAllergyIntoleranceMaskingIndicators() {
        return this.allergyIntoleranceMaskingIndicators.rawSet(x_NormalRestrictedTabooConfidentialityKind.class);
    }


    /**
     * <p>F:Confirmed Indicator</p>
     */
    @Hl7XmlMapping({"uncertaintyCode"})
    public ActUncertainty getConfirmedIndicator() {
        return (ActUncertainty) this.confirmedIndicator.getValue();
    }
    public void setConfirmedIndicator(ActUncertainty confirmedIndicator) {
        this.confirmedIndicator.setValue(confirmedIndicator);
    }


    /**
     * <p>B:Agent</p>
     */
    @Hl7XmlMapping({"value"})
    public IntoleranceValue getAgent() {
        return (IntoleranceValue) this.agent.getValue();
    }
    public void setAgent(IntoleranceValue agent) {
        this.agent.setValue(agent);
    }


    @Hl7XmlMapping({"responsibleParty/assignedEntity"})
    public HealthcareWorkerBean getResponsiblePartyAssignedEntity() {
        return this.responsiblePartyAssignedEntity;
    }
    public void setResponsiblePartyAssignedEntity(HealthcareWorkerBean responsiblePartyAssignedEntity) {
        this.responsiblePartyAssignedEntity = responsiblePartyAssignedEntity;
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
    public CreatedAtBean getLocation() {
        return this.location;
    }
    public void setLocation(CreatedAtBean location) {
        this.location = location;
    }


    @Hl7XmlMapping({"support/records"})
    public List<Records> getSupportRecords() {
        return this.supportRecords;
    }


    @Hl7XmlMapping({"subjectOf1/annotation"})
    public List<NotesBean> getSubjectOf1Annotation() {
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


    @Hl7XmlMapping({"componentOf/patientCareProvisionEvent"})
    public List<CareCompositionsBean> getComponentOfPatientCareProvisionEvent() {
        return this.componentOfPatientCareProvisionEvent;
    }

}
