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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.immunization.poiz_mt060150ca;

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
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.common.coct_mt090107ca.ProviderBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.common.coct_mt220210ca.DrugProductBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.common.merged.PatientBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.immunization.merged.InformationSourceRoleBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.immunization.merged.PartOfBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.merged.CommentBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.merged.RecordedAtBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.merged.RefusedByBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.pharmacy.merged.IssuesBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Immunizations</p>
 * 
 * <p>approachSite must be required if not using 
 * SNOMED</p><p>Route must be requires if not using 
 * SNOMED</p><p>If immunization was not refused, then refusal 
 * reason must not be specified otherwise field should be 
 * treated as populated.</p>
 * 
 * <p>approachSite must be required if not using 
 * SNOMED</p><p>Route must be requires if not using 
 * SNOMED</p><p>If immunization was not refused, then refusal 
 * reason must not be specified otherwise field should be 
 * treated as populated.</p>
 * 
 * <p>approachSite must be required if not using 
 * SNOMED</p><p>Route must be requires if not using 
 * SNOMED</p><p>If immunization was not refused, then refusal 
 * reason must not be specified otherwise field should be 
 * treated as populated.</p>
 * 
 * <p>A record of a patient's immunizations.</p>
 * 
 * <p>Necessary component of a person's overall medication 
 * profile. Helps deal with outbreaks and also drug 
 * contraindication checking.</p>
 */
@Hl7PartTypeMapping({"POIZ_MT060150CA.Immunization"})
@Hl7RootType
public class ImmunizationsBean extends MessagePartBean {

    private static final long serialVersionUID = 20121122L;
    private II id = new IIImpl();
    private CD code = new CDImpl();
    private BL negationInd = new BLImpl();
    private TS effectiveTime = new TSImpl();
    private CV confidentialityCode = new CVImpl();
    private CV reasonCode = new CVImpl();
    private CV routeCode = new CVImpl();
    private CV approachSiteCode = new CVImpl();
    private PQ doseQuantity = new PQImpl();
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
     * 
     * <p>This is an identifier assigned to a unique instance of an 
     * immunization record.</p>
     * 
     * <p>Allows for the unique referencing of a specific 
     * immunization record. Thus the mandatory requirement.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>A:Immunization Record Id</p>
     * 
     * <p>This is an identifier assigned to a unique instance of an 
     * immunization record.</p>
     * 
     * <p>Allows for the unique referencing of a specific 
     * immunization record. Thus the mandatory requirement.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Immunization Type</p>
     * 
     * <p>Indicates what type of administration is being 
     * performed.</p>
     * 
     * <p>Indicates that the type of administration is an 
     * administration, and for SNOMED, also indicates the specific 
     * type of administration. Therefore, the attribute is 
     * mandatory. The attribute is CD to allow for SNOMED 
     * post-coordination</p>
     */
    @Hl7XmlMapping({"code"})
    public ActCode getCode() {
        return (ActCode) this.code.getValue();
    }

    /**
     * <p>Immunization Type</p>
     * 
     * <p>Indicates what type of administration is being 
     * performed.</p>
     * 
     * <p>Indicates that the type of administration is an 
     * administration, and for SNOMED, also indicates the specific 
     * type of administration. Therefore, the attribute is 
     * mandatory. The attribute is CD to allow for SNOMED 
     * post-coordination</p>
     */
    public void setCode(ActCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Not Immunized?</p>
     * 
     * <p>An explicit indication that a person has not been 
     * immunized with the specified vaccine at the time 
     * indicated.</p>
     * 
     * <p>NotImmunized</p><p>CompletionStstus (true = Not 
     * administered)</p>
     * 
     * <p>NotImmunized</p><p>CompletionStstus (true = Not 
     * administered)</p>
     * 
     * <p>Tracking failures to be immunized is also important in 
     * immunization reporting. Marked as mandatory because it is 
     * not meaningful for this flag to be 'unknown'.</p>
     */
    @Hl7XmlMapping({"negationInd"})
    public Boolean getNegationInd() {
        return this.negationInd.getValue();
    }

    /**
     * <p>Not Immunized?</p>
     * 
     * <p>An explicit indication that a person has not been 
     * immunized with the specified vaccine at the time 
     * indicated.</p>
     * 
     * <p>NotImmunized</p><p>CompletionStstus (true = Not 
     * administered)</p>
     * 
     * <p>NotImmunized</p><p>CompletionStstus (true = Not 
     * administered)</p>
     * 
     * <p>Tracking failures to be immunized is also important in 
     * immunization reporting. Marked as mandatory because it is 
     * not meaningful for this flag to be 'unknown'.</p>
     */
    public void setNegationInd(Boolean negationInd) {
        this.negationInd.setValue(negationInd);
    }


    /**
     * <p>C:Immunization Date</p>
     * 
     * <p>The date vaccination(s) was administered to the 
     * patient.</p>
     * 
     * <p>ZDP.13.2.2</p><p>ZDP.13.3</p><p>ZDP.13.4</p><p>ZDP.13.5</p>
     * 
     * <p>ZDP.13.2.2</p><p>ZDP.13.3</p><p>ZDP.13.4</p><p>ZDP.13.5</p>
     * 
     * <p>ZDP.13.2.2</p><p>ZDP.13.3</p><p>ZDP.13.4</p><p>ZDP.13.5</p>
     * 
     * <p>ZDP.13.2.2</p><p>ZDP.13.3</p><p>ZDP.13.4</p><p>ZDP.13.5</p>
     * 
     * <p>Important information for establishing the validity of 
     * the immunization records, and therefore mandatory. Also used 
     * in the scheduling of subsequent immunizations.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Date getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>C:Immunization Date</p>
     * 
     * <p>The date vaccination(s) was administered to the 
     * patient.</p>
     * 
     * <p>ZDP.13.2.2</p><p>ZDP.13.3</p><p>ZDP.13.4</p><p>ZDP.13.5</p>
     * 
     * <p>ZDP.13.2.2</p><p>ZDP.13.3</p><p>ZDP.13.4</p><p>ZDP.13.5</p>
     * 
     * <p>ZDP.13.2.2</p><p>ZDP.13.3</p><p>ZDP.13.4</p><p>ZDP.13.5</p>
     * 
     * <p>ZDP.13.2.2</p><p>ZDP.13.3</p><p>ZDP.13.4</p><p>ZDP.13.5</p>
     * 
     * <p>Important information for establishing the validity of 
     * the immunization records, and therefore mandatory. Also used 
     * in the scheduling of subsequent immunizations.</p>
     */
    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>D:Immunization Masking Indicator</p>
     * 
     * <p>Denotes access restriction place on the immunization 
     * record.</p>
     * 
     * <p>Provides support for additional confidentiality 
     * constraint to reflect the wishes of the patient.</p><p>The 
     * attribute is optional because not all systems will support 
     * masking.</p>
     * 
     * <p>Provides support for additional confidentiality 
     * constraint to reflect the wishes of the patient.</p><p>The 
     * attribute is optional because not all systems will support 
     * masking.</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public x_VeryBasicConfidentialityKind getConfidentialityCode() {
        return (x_VeryBasicConfidentialityKind) this.confidentialityCode.getValue();
    }

    /**
     * <p>D:Immunization Masking Indicator</p>
     * 
     * <p>Denotes access restriction place on the immunization 
     * record.</p>
     * 
     * <p>Provides support for additional confidentiality 
     * constraint to reflect the wishes of the patient.</p><p>The 
     * attribute is optional because not all systems will support 
     * masking.</p>
     * 
     * <p>Provides support for additional confidentiality 
     * constraint to reflect the wishes of the patient.</p><p>The 
     * attribute is optional because not all systems will support 
     * masking.</p>
     */
    public void setConfidentialityCode(x_VeryBasicConfidentialityKind confidentialityCode) {
        this.confidentialityCode.setValue(confidentialityCode);
    }


    /**
     * <p>Immunization Refusal Reason</p>
     * 
     * <p>A coded value denoting a patient's reason for refusing to 
     * be immunized.</p><p>Typical reasons include: Parental 
     * decision, Religious exemption, Patient decision, etc</p>
     * 
     * <p>A coded value denoting a patient's reason for refusing to 
     * be immunized.</p><p>Typical reasons include: Parental 
     * decision, Religious exemption, Patient decision, etc</p>
     * 
     * <p>CompletionStatus (Refused)</p>
     * 
     * <p>Allows sorting and categorizing different kinds of 
     * refusal reasons. Ensures that reasons are gathered in a 
     * consistent analyzable manner.</p>
     */
    @Hl7XmlMapping({"reasonCode"})
    public ActNoImmunizationReason getReasonCode() {
        return (ActNoImmunizationReason) this.reasonCode.getValue();
    }

    /**
     * <p>Immunization Refusal Reason</p>
     * 
     * <p>A coded value denoting a patient's reason for refusing to 
     * be immunized.</p><p>Typical reasons include: Parental 
     * decision, Religious exemption, Patient decision, etc</p>
     * 
     * <p>A coded value denoting a patient's reason for refusing to 
     * be immunized.</p><p>Typical reasons include: Parental 
     * decision, Religious exemption, Patient decision, etc</p>
     * 
     * <p>CompletionStatus (Refused)</p>
     * 
     * <p>Allows sorting and categorizing different kinds of 
     * refusal reasons. Ensures that reasons are gathered in a 
     * consistent analyzable manner.</p>
     */
    public void setReasonCode(ActNoImmunizationReason reasonCode) {
        this.reasonCode.setValue(reasonCode);
    }


    /**
     * <p>E:Route of Administration</p>
     * 
     * <p>This is the means by which the drug was administered to 
     * the patient.</p>
     * 
     * <p>Route of administration</p>
     * 
     * <p>Ensures consistency in description of 
     * routes.</p><p>Attribute is marked 'optional' to allow for 
     * use of pre-coordinated SNOMED Codes.</p>
     * 
     * <p>Ensures consistency in description of 
     * routes.</p><p>Attribute is marked 'optional' to allow for 
     * use of pre-coordinated SNOMED Codes.</p>
     */
    @Hl7XmlMapping({"routeCode"})
    public RouteOfAdministration getRouteCode() {
        return (RouteOfAdministration) this.routeCode.getValue();
    }

    /**
     * <p>E:Route of Administration</p>
     * 
     * <p>This is the means by which the drug was administered to 
     * the patient.</p>
     * 
     * <p>Route of administration</p>
     * 
     * <p>Ensures consistency in description of 
     * routes.</p><p>Attribute is marked 'optional' to allow for 
     * use of pre-coordinated SNOMED Codes.</p>
     * 
     * <p>Ensures consistency in description of 
     * routes.</p><p>Attribute is marked 'optional' to allow for 
     * use of pre-coordinated SNOMED Codes.</p>
     */
    public void setRouteCode(RouteOfAdministration routeCode) {
        this.routeCode.setValue(routeCode);
    }


    /**
     * <p>Administration Site</p>
     * 
     * <p>A coded value denoting the body area where the 
     * immunization was administered.</p>
     * 
     * <p>RXR.2</p>
     * 
     * <p>Some immunizations are intended to adjust from site to 
     * site. (E.g. if first injection is given in right deltoid, 
     * first booster should be given in left 
     * deltoid.)</p><p>Attribute is marked &quot;optional&quot; to 
     * allow for use of pre-coordinated SNOMED Codes.</p>
     * 
     * <p>Some immunizations are intended to adjust from site to 
     * site. (E.g. if first injection is given in right deltoid, 
     * first booster should be given in left 
     * deltoid.)</p><p>Attribute is marked &quot;optional&quot; to 
     * allow for use of pre-coordinated SNOMED Codes.</p>
     */
    @Hl7XmlMapping({"approachSiteCode"})
    public HumanSubstanceAdministrationSite getApproachSiteCode() {
        return (HumanSubstanceAdministrationSite) this.approachSiteCode.getValue();
    }

    /**
     * <p>Administration Site</p>
     * 
     * <p>A coded value denoting the body area where the 
     * immunization was administered.</p>
     * 
     * <p>RXR.2</p>
     * 
     * <p>Some immunizations are intended to adjust from site to 
     * site. (E.g. if first injection is given in right deltoid, 
     * first booster should be given in left 
     * deltoid.)</p><p>Attribute is marked &quot;optional&quot; to 
     * allow for use of pre-coordinated SNOMED Codes.</p>
     * 
     * <p>Some immunizations are intended to adjust from site to 
     * site. (E.g. if first injection is given in right deltoid, 
     * first booster should be given in left 
     * deltoid.)</p><p>Attribute is marked &quot;optional&quot; to 
     * allow for use of pre-coordinated SNOMED Codes.</p>
     */
    public void setApproachSiteCode(HumanSubstanceAdministrationSite approachSiteCode) {
        this.approachSiteCode.setValue(approachSiteCode);
    }


    /**
     * <p>Quantity Administered</p>
     * 
     * <p>The amount of the vaccine administered to/by the 
     * patient.</p>
     * 
     * <p>Useful for evaluating reaction and for checking 
     * contraindication.</p><p>Attribute is populated to allow for 
     * situations where quantity may not be known and thus null 
     * flavor must be specified.</p>
     * 
     * <p>Useful for evaluating reaction and for checking 
     * contraindication.</p><p>Attribute is populated to allow for 
     * situations where quantity may not be known and thus null 
     * flavor must be specified.</p>
     */
    @Hl7XmlMapping({"doseQuantity"})
    public PhysicalQuantity getDoseQuantity() {
        return this.doseQuantity.getValue();
    }

    /**
     * <p>Quantity Administered</p>
     * 
     * <p>The amount of the vaccine administered to/by the 
     * patient.</p>
     * 
     * <p>Useful for evaluating reaction and for checking 
     * contraindication.</p><p>Attribute is populated to allow for 
     * situations where quantity may not be known and thus null 
     * flavor must be specified.</p>
     * 
     * <p>Useful for evaluating reaction and for checking 
     * contraindication.</p><p>Attribute is populated to allow for 
     * situations where quantity may not be known and thus null 
     * flavor must be specified.</p>
     */
    public void setDoseQuantity(PhysicalQuantity doseQuantity) {
        this.doseQuantity.setValue(doseQuantity);
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
