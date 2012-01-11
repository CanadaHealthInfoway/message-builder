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
package ca.infoway.messagebuilder.model.common.repc_mt000006ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.SeverityObservation;
import ca.infoway.messagebuilder.domainvalue.SubjectReaction;
import ca.infoway.messagebuilder.domainvalue.x_NormalRestrictedTabooConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.common.coct_mt120600ca.NotesBean;
import ca.infoway.messagebuilder.model.merged.AssignedEntityBean;
import ca.infoway.messagebuilder.model.merged.AuthoredByBean;
import ca.infoway.messagebuilder.model.merged.CreatedAtBean;
import ca.infoway.messagebuilder.model.merged.IsPartOfBean;
import ca.infoway.messagebuilder.model.merged.NotesIndicatorBean;
import ca.infoway.messagebuilder.model.merged.ReportedByBean;
import ca.infoway.messagebuilder.model.merged.Subject6_2Bean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;



/**
 * <p>Reported Reaction 
 * 
 * <p>This is a record of an adverse reaction considered 
 * relevant to the patient's clinical record. 
 * 
 * <p>Useful in tracking reactions when it is not known 
 * precisely what product they are associated with and whether 
 * the reaction is due to an allergy or intolerance, a drug 
 * interaction or some other cause. Effectively gives a 'heads 
 * up' to clinicians using the drug or combination of drugs. 
 * 
 * <p>Value is mandatory if not using SNOMED 
 * 
 * <p>Code is fixed to DX if not using SNOMED 
 */
@Hl7PartTypeMapping({"REPC_MT000006CA.ReactionObservationEvent"})
@Hl7RootType
public class ReportedReactionBean extends MessagePartBean {

    private II reactionRecordId = new IIImpl();
    private CD<ActCode> diagnosisType = new CDImpl<ActCode>();
    private ST description = new STImpl();
    private IVL<TS, Interval<Date>> reactionOnsetDate = new IVLImpl<TS, Interval<Date>>();
    private SET<CV<x_NormalRestrictedTabooConfidentialityKind>, x_NormalRestrictedTabooConfidentialityKind> adverseReactionMaskingIndicators = new SETImpl<CV<x_NormalRestrictedTabooConfidentialityKind>, x_NormalRestrictedTabooConfidentialityKind>(CVImpl.class);
    private CV<SubjectReaction> reaction = new CVImpl<SubjectReaction>();
    private AssignedEntityBean responsiblePartyAssignedEntity;
    private AuthoredByBean author = new AuthoredByBean();
    private ReportedByBean informant;
    private CreatedAtBean location = new CreatedAtBean();
    private List<NotesBean> subjectOf1Annotation = new ArrayList<NotesBean>();
    private NotesIndicatorBean subjectOf2;
    private List<Subject6_2Bean> subjectOf3 = new ArrayList<Subject6_2Bean>();
    private CV<SeverityObservation> severityLevel = new CVImpl<SeverityObservation>();
    private List<IsPartOfBean> componentOf = new ArrayList<IsPartOfBean>();

    @Hl7XmlMapping({"id"})
    public Identifier getReactionRecordId() {
        return this.reactionRecordId.getValue();
    }
    public void setReactionRecordId(Identifier reactionRecordId) {
        this.reactionRecordId.setValue(reactionRecordId);
    }

    @Hl7XmlMapping({"code"})
    public ActCode getDiagnosisType() {
        return this.diagnosisType.getValue();
    }
    public void setDiagnosisType(ActCode diagnosisType) {
        this.diagnosisType.setValue(diagnosisType);
    }

    @Hl7XmlMapping({"text"})
    public java.lang.String getDescription() {
        return this.description.getValue();
    }
    public void setDescription(java.lang.String description) {
        this.description.setValue(description);
    }

    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getReactionOnsetDate() {
        return this.reactionOnsetDate.getValue();
    }
    public void setReactionOnsetDate(Interval<Date> reactionOnsetDate) {
        this.reactionOnsetDate.setValue(reactionOnsetDate);
    }

    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_NormalRestrictedTabooConfidentialityKind> getAdverseReactionMaskingIndicators() {
        return this.adverseReactionMaskingIndicators.rawSet();
    }

    @Hl7XmlMapping({"value"})
    public SubjectReaction getReaction() {
        return this.reaction.getValue();
    }
    public void setReaction(SubjectReaction reaction) {
        this.reaction.setValue(reaction);
    }

    @Hl7XmlMapping({"responsibleParty/assignedEntity"})
    public AssignedEntityBean getResponsiblePartyAssignedEntity() {
        return this.responsiblePartyAssignedEntity;
    }
    public void setResponsiblePartyAssignedEntity(AssignedEntityBean responsiblePartyAssignedEntity) {
        this.responsiblePartyAssignedEntity = responsiblePartyAssignedEntity;
    }

    @Hl7XmlMapping({"author"})
    public AuthoredByBean getAuthor() {
        return this.author;
    }
    public void setAuthor(AuthoredByBean author) {
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

    @Hl7XmlMapping({"subjectOf1/annotation"})
    public List<NotesBean> getSubjectOf1Annotation() {
        return this.subjectOf1Annotation;
    }

    @Hl7XmlMapping({"subjectOf2"})
    public NotesIndicatorBean getSubjectOf2() {
        return this.subjectOf2;
    }
    public void setSubjectOf2(NotesIndicatorBean subjectOf2) {
        this.subjectOf2 = subjectOf2;
    }

    @Hl7XmlMapping({"subjectOf3"})
    public List<Subject6_2Bean> getSubjectOf3() {
        return this.subjectOf3;
    }

    @Hl7XmlMapping({"subjectOf4/severityObservation/value"})
    public SeverityObservation getSeverityLevel() {
        return this.severityLevel.getValue();
    }
    public void setSeverityLevel(SeverityObservation severityLevel) {
        this.severityLevel.setValue(severityLevel);
    }

    @Hl7XmlMapping({"componentOf"})
    public List<IsPartOfBean> getComponentOf() {
        return this.componentOf;
    }

}
