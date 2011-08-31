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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.immunization.poiz_mt030050ca;

import java.util.Date;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.ActNoImmunizationReason;
import ca.infoway.messagebuilder.domainvalue.HumanSubstanceAdministrationSite;
import ca.infoway.messagebuilder.domainvalue.RouteOfAdministration;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.coct_mt220200ca.DrugProductBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.merged.PatientBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.immunization.merged.PartOfBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.merged.CommentBean;



@Hl7PartTypeMapping({"POIZ_MT030050CA.Immunization"})
@Hl7RootType
public class ImmunizationBean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
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
    private InformantionSourceRoleBean informantInformantionSourceRole;
    private PartOfBean inFulfillmentOf;
    private CommentBean subjectOfAnnotation;
    private BL causeAdverseReactionObservationEvent = new BLImpl(false);


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


    @Hl7XmlMapping({"informant/informantionSourceRole"})
    public InformantionSourceRoleBean getInformantInformantionSourceRole() {
        return this.informantInformantionSourceRole;
    }
    public void setInformantInformantionSourceRole(InformantionSourceRoleBean informantInformantionSourceRole) {
        this.informantInformantionSourceRole = informantInformantionSourceRole;
    }


    @Hl7XmlMapping({"inFulfillmentOf"})
    public PartOfBean getInFulfillmentOf() {
        return this.inFulfillmentOf;
    }
    public void setInFulfillmentOf(PartOfBean inFulfillmentOf) {
        this.inFulfillmentOf = inFulfillmentOf;
    }


    @Hl7XmlMapping({"subjectOf/annotation"})
    public CommentBean getSubjectOfAnnotation() {
        return this.subjectOfAnnotation;
    }
    public void setSubjectOfAnnotation(CommentBean subjectOfAnnotation) {
        this.subjectOfAnnotation = subjectOfAnnotation;
    }


    @Hl7XmlMapping({"cause/adverseReactionObservationEvent"})
    public Boolean getCauseAdverseReactionObservationEvent() {
        return this.causeAdverseReactionObservationEvent.getValue();
    }
    public void setCauseAdverseReactionObservationEvent(Boolean causeAdverseReactionObservationEvent) {
        this.causeAdverseReactionObservationEvent.setValue(causeAdverseReactionObservationEvent);
    }

}
