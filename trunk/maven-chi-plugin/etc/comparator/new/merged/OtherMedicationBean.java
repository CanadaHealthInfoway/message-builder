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
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.RouteOfAdministration;
import ca.infoway.messagebuilder.domainvalue.x_NormalRestrictedTabooConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.common.coct_mt120600ca.NotesBean;
import ca.infoway.messagebuilder.model.common.coct_mt270010ca.AdministrationInstructionsBean;
import ca.infoway.messagebuilder.model.common.porx_mt060160ca.MedicationRecordBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;



@Hl7PartTypeMapping({"PORX_MT040010CA.OtherMedication","PORX_MT040020CA.OtherMedication","PORX_MT060160CA.OtherMedication","PORX_MT060190CA.OtherMedication","PORX_MT060210CA.OtherMedication"})
@Hl7RootType
public class OtherMedicationBean extends MessagePartBean implements MedicationRecordBean, ca.infoway.messagebuilder.model.common.porx_mt060190ca.MedicationRecordBean {

    private II administrationRecordId = new IIImpl();
    private CD<ActCode> otherMedicationType = new CDImpl<ActCode>();
    private CS<ActStatus> otherMedicationStatus = new CSImpl<ActStatus>();
    private IVL<TS, Interval<Date>> drugActivePeriod = new IVLImpl<TS, Interval<Date>>();
    private SET<CV<x_NormalRestrictedTabooConfidentialityKind>, x_NormalRestrictedTabooConfidentialityKind> otherMedicationMaskingIndicators = new SETImpl<CV<x_NormalRestrictedTabooConfidentialityKind>, x_NormalRestrictedTabooConfidentialityKind>(CVImpl.class);
    private CV<RouteOfAdministration> routeOfAdministration = new CVImpl<RouteOfAdministration>();
    private DrugProductBean consumableMedication = new DrugProductBean();
    private AssignedEntityBean responsiblePartyAssignedEntity;
    private RefusedByBean author = new RefusedByBean();
    private CreatedAtBean location = new CreatedAtBean();
    private List<AdministrationInstructionsBean> componentDosageInstruction = new ArrayList<AdministrationInstructionsBean>();
    private List<TriggerEventBean> subjectOf1ControlActEvent = new ArrayList<TriggerEventBean>();
    private IssueIndicatorBean subjectOf2;
    private List<NotesBean> subjectOf3Annotation = new ArrayList<NotesBean>();
    private NotesIndicatorBean subjectOf4;
    private List<IssuesBean> subjectOf5DetectedIssueEvent = new ArrayList<IssuesBean>();
    private List<IsPartOfBean> componentOf = new ArrayList<IsPartOfBean>();
    private NotesBean subjectOfAnnotation;

    @Hl7XmlMapping({"id"})
    public Identifier getAdministrationRecordId() {
        return this.administrationRecordId.getValue();
    }
    public void setAdministrationRecordId(Identifier administrationRecordId) {
        this.administrationRecordId.setValue(administrationRecordId);
    }

    @Hl7XmlMapping({"code"})
    public ActCode getOtherMedicationType() {
        return this.otherMedicationType.getValue();
    }
    public void setOtherMedicationType(ActCode otherMedicationType) {
        this.otherMedicationType.setValue(otherMedicationType);
    }

    @Hl7XmlMapping({"statusCode"})
    public ActStatus getOtherMedicationStatus() {
        return this.otherMedicationStatus.getValue();
    }
    public void setOtherMedicationStatus(ActStatus otherMedicationStatus) {
        this.otherMedicationStatus.setValue(otherMedicationStatus);
    }

    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getDrugActivePeriod() {
        return this.drugActivePeriod.getValue();
    }
    public void setDrugActivePeriod(Interval<Date> drugActivePeriod) {
        this.drugActivePeriod.setValue(drugActivePeriod);
    }

    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_NormalRestrictedTabooConfidentialityKind> getOtherMedicationMaskingIndicators() {
        return this.otherMedicationMaskingIndicators.rawSet();
    }

    @Hl7XmlMapping({"routeCode"})
    public RouteOfAdministration getRouteOfAdministration() {
        return this.routeOfAdministration.getValue();
    }
    public void setRouteOfAdministration(RouteOfAdministration routeOfAdministration) {
        this.routeOfAdministration.setValue(routeOfAdministration);
    }

    @Hl7XmlMapping({"consumable/medication"})
    public DrugProductBean getConsumableMedication() {
        return this.consumableMedication;
    }
    public void setConsumableMedication(DrugProductBean consumableMedication) {
        this.consumableMedication = consumableMedication;
    }

    @Hl7XmlMapping({"responsibleParty/assignedEntity"})
    public AssignedEntityBean getResponsiblePartyAssignedEntity() {
        return this.responsiblePartyAssignedEntity;
    }
    public void setResponsiblePartyAssignedEntity(AssignedEntityBean responsiblePartyAssignedEntity) {
        this.responsiblePartyAssignedEntity = responsiblePartyAssignedEntity;
    }

    @Hl7XmlMapping({"author"})
    public RefusedByBean getAuthor() {
        return this.author;
    }
    public void setAuthor(RefusedByBean author) {
        this.author = author;
    }

    @Hl7XmlMapping({"location"})
    public CreatedAtBean getLocation() {
        return this.location;
    }
    public void setLocation(CreatedAtBean location) {
        this.location = location;
    }

    @Hl7XmlMapping({"component/dosageInstruction"})
    public List<AdministrationInstructionsBean> getComponentDosageInstruction() {
        return this.componentDosageInstruction;
    }

    @Hl7XmlMapping({"subjectOf1/controlActEvent"})
    public List<TriggerEventBean> getSubjectOf1ControlActEvent() {
        return this.subjectOf1ControlActEvent;
    }

    @Hl7XmlMapping({"subjectOf2"})
    public IssueIndicatorBean getSubjectOf2() {
        return this.subjectOf2;
    }
    public void setSubjectOf2(IssueIndicatorBean subjectOf2) {
        this.subjectOf2 = subjectOf2;
    }

    @Hl7XmlMapping({"subjectOf3/annotation"})
    public List<NotesBean> getSubjectOf3Annotation() {
        return this.subjectOf3Annotation;
    }

    @Hl7XmlMapping({"subjectOf4"})
    public NotesIndicatorBean getSubjectOf4() {
        return this.subjectOf4;
    }
    public void setSubjectOf4(NotesIndicatorBean subjectOf4) {
        this.subjectOf4 = subjectOf4;
    }

    @Hl7XmlMapping({"subjectOf5/detectedIssueEvent"})
    public List<IssuesBean> getSubjectOf5DetectedIssueEvent() {
        return this.subjectOf5DetectedIssueEvent;
    }

    @Hl7XmlMapping({"componentOf"})
    public List<IsPartOfBean> getComponentOf() {
        return this.componentOf;
    }

    @Hl7XmlMapping({"subjectOf/annotation"})
    public NotesBean getSubjectOfAnnotation() {
        return this.subjectOfAnnotation;
    }
    public void setSubjectOfAnnotation(NotesBean subjectOfAnnotation) {
        this.subjectOfAnnotation = subjectOfAnnotation;
    }

}
