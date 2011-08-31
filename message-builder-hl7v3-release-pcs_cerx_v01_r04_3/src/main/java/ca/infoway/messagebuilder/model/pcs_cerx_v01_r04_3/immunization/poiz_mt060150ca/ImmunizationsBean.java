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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.immunization.poiz_mt060150ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.ActNoImmunizationReason;
import ca.infoway.messagebuilder.domainvalue.HumanSubstanceAdministrationSite;
import ca.infoway.messagebuilder.domainvalue.RouteOfAdministration;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.coct_mt090107ca.ProviderBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.coct_mt220210ca.DrugProductBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.merged.PatientBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.immunization.merged.InformationSourceRoleBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.immunization.merged.PartOfBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.merged.CommentBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.merged.RecordedAtBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.merged.RefusedByBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.merged.IssuesBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Hl7PartTypeMapping({"POIZ_MT060150CA.Immunization"})
@Hl7RootType
public class ImmunizationsBean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private II immunizationRecordId = new IIImpl();
    private CD immunizationType = new CDImpl();
    private BL notImmunized = new BLImpl();
    private TS immunizationDate = new TSImpl();
    private CV immunizationMaskingIndicator = new CVImpl();
    private CV immunizationRefusalReason = new CVImpl();
    private CV routeOfAdministration = new CVImpl();
    private CV administrationSite = new CVImpl();
    private PQ quantityAdministered = new PQImpl();
    private PatientBean subjectPatient;
    private DrugProductBean consumableMedication;
    private ProviderBean responsiblePartyAssignedPerson;
    private RefusedByBean author;
    private InformationSourceRoleBean informantInformationSourceRole;
    private RecordedAtBean location;
    private PartOfBean inFulfillmentOf;
    private List<IssuesBean> subjectOf1DetectedIssueEvent = new ArrayList<IssuesBean>();
    private List<CommentBean> subjectOf2Annotation = new ArrayList<CommentBean>();
    private BL subjectOf3DetectedIssueIndicator = new BLImpl(false);
    private BL subjectOf4AnnotationIndicator = new BLImpl(false);
    private BL causeAdverseReactionObservationEvent = new BLImpl(false);


    /**
     * <p>A:Immunization Record Id</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getImmunizationRecordId() {
        return this.immunizationRecordId.getValue();
    }
    public void setImmunizationRecordId(Identifier immunizationRecordId) {
        this.immunizationRecordId.setValue(immunizationRecordId);
    }


    /**
     * <p>Immunization Type</p>
     */
    @Hl7XmlMapping({"code"})
    public ActCode getImmunizationType() {
        return (ActCode) this.immunizationType.getValue();
    }
    public void setImmunizationType(ActCode immunizationType) {
        this.immunizationType.setValue(immunizationType);
    }


    /**
     * <p>Not Immunized?</p>
     */
    @Hl7XmlMapping({"negationInd"})
    public Boolean getNotImmunized() {
        return this.notImmunized.getValue();
    }
    public void setNotImmunized(Boolean notImmunized) {
        this.notImmunized.setValue(notImmunized);
    }


    /**
     * <p>C:Immunization Date</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Date getImmunizationDate() {
        return this.immunizationDate.getValue();
    }
    public void setImmunizationDate(Date immunizationDate) {
        this.immunizationDate.setValue(immunizationDate);
    }


    /**
     * <p>D:Immunization Masking Indicator</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public x_VeryBasicConfidentialityKind getImmunizationMaskingIndicator() {
        return (x_VeryBasicConfidentialityKind) this.immunizationMaskingIndicator.getValue();
    }
    public void setImmunizationMaskingIndicator(x_VeryBasicConfidentialityKind immunizationMaskingIndicator) {
        this.immunizationMaskingIndicator.setValue(immunizationMaskingIndicator);
    }


    /**
     * <p>Immunization Refusal Reason</p>
     */
    @Hl7XmlMapping({"reasonCode"})
    public ActNoImmunizationReason getImmunizationRefusalReason() {
        return (ActNoImmunizationReason) this.immunizationRefusalReason.getValue();
    }
    public void setImmunizationRefusalReason(ActNoImmunizationReason immunizationRefusalReason) {
        this.immunizationRefusalReason.setValue(immunizationRefusalReason);
    }


    /**
     * <p>E:Route of Administration</p>
     */
    @Hl7XmlMapping({"routeCode"})
    public RouteOfAdministration getRouteOfAdministration() {
        return (RouteOfAdministration) this.routeOfAdministration.getValue();
    }
    public void setRouteOfAdministration(RouteOfAdministration routeOfAdministration) {
        this.routeOfAdministration.setValue(routeOfAdministration);
    }


    /**
     * <p>Administration Site</p>
     */
    @Hl7XmlMapping({"approachSiteCode"})
    public HumanSubstanceAdministrationSite getAdministrationSite() {
        return (HumanSubstanceAdministrationSite) this.administrationSite.getValue();
    }
    public void setAdministrationSite(HumanSubstanceAdministrationSite administrationSite) {
        this.administrationSite.setValue(administrationSite);
    }


    /**
     * <p>Quantity Administered</p>
     */
    @Hl7XmlMapping({"doseQuantity"})
    public PhysicalQuantity getQuantityAdministered() {
        return this.quantityAdministered.getValue();
    }
    public void setQuantityAdministered(PhysicalQuantity quantityAdministered) {
        this.quantityAdministered.setValue(quantityAdministered);
    }


    @Hl7XmlMapping({"subject/patient"})
    public PatientBean getSubjectPatient() {
        return this.subjectPatient;
    }
    public void setSubjectPatient(PatientBean subjectPatient) {
        this.subjectPatient = subjectPatient;
    }


    @Hl7XmlMapping({"consumable/medication"})
    public DrugProductBean getConsumableMedication() {
        return this.consumableMedication;
    }
    public void setConsumableMedication(DrugProductBean consumableMedication) {
        this.consumableMedication = consumableMedication;
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


    @Hl7XmlMapping({"informant/informationSourceRole"})
    public InformationSourceRoleBean getInformantInformationSourceRole() {
        return this.informantInformationSourceRole;
    }
    public void setInformantInformationSourceRole(InformationSourceRoleBean informantInformationSourceRole) {
        this.informantInformationSourceRole = informantInformationSourceRole;
    }


    @Hl7XmlMapping({"location"})
    public RecordedAtBean getLocation() {
        return this.location;
    }
    public void setLocation(RecordedAtBean location) {
        this.location = location;
    }


    @Hl7XmlMapping({"inFulfillmentOf"})
    public PartOfBean getInFulfillmentOf() {
        return this.inFulfillmentOf;
    }
    public void setInFulfillmentOf(PartOfBean inFulfillmentOf) {
        this.inFulfillmentOf = inFulfillmentOf;
    }


    @Hl7XmlMapping({"subjectOf1/detectedIssueEvent"})
    public List<IssuesBean> getSubjectOf1DetectedIssueEvent() {
        return this.subjectOf1DetectedIssueEvent;
    }


    @Hl7XmlMapping({"subjectOf2/annotation"})
    public List<CommentBean> getSubjectOf2Annotation() {
        return this.subjectOf2Annotation;
    }


    @Hl7XmlMapping({"subjectOf3/detectedIssueIndicator"})
    public Boolean getSubjectOf3DetectedIssueIndicator() {
        return this.subjectOf3DetectedIssueIndicator.getValue();
    }
    public void setSubjectOf3DetectedIssueIndicator(Boolean subjectOf3DetectedIssueIndicator) {
        this.subjectOf3DetectedIssueIndicator.setValue(subjectOf3DetectedIssueIndicator);
    }


    @Hl7XmlMapping({"subjectOf4/annotationIndicator"})
    public Boolean getSubjectOf4AnnotationIndicator() {
        return this.subjectOf4AnnotationIndicator.getValue();
    }
    public void setSubjectOf4AnnotationIndicator(Boolean subjectOf4AnnotationIndicator) {
        this.subjectOf4AnnotationIndicator.setValue(subjectOf4AnnotationIndicator);
    }


    @Hl7XmlMapping({"cause/adverseReactionObservationEvent"})
    public Boolean getCauseAdverseReactionObservationEvent() {
        return this.causeAdverseReactionObservationEvent.getValue();
    }
    public void setCauseAdverseReactionObservationEvent(Boolean causeAdverseReactionObservationEvent) {
        this.causeAdverseReactionObservationEvent.setValue(causeAdverseReactionObservationEvent);
    }

}