/**
 * Copyright 2013 Canada Health Infoway, Inc.
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
package ca.infoway.messagebuilder.model.ab_r02_05_00_pa.immunization.poiz_mt061150ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.ActUncertainty;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.immunization.merged.AdministeredToBean;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.immunization.merged.InvestigationEventBean;
import java.util.Date;



/**
 * <p>Business Name: Immunizations</p>
 * 
 * <p>Necessary component of a person's overall vaccine 
 * profile. Helps deal with outbreaks and also vaccine 
 * contraindication checking.</p>
 * 
 * <p>A record of products administered to a patient specific 
 * to immunization.</p>
 */
@Hl7PartTypeMapping({"POIZ_MT061150CA.Immunization"})
@Hl7RootType
public class ImmunizationsBean extends MessagePartBean implements ca.infoway.messagebuilder.model.ab_r02_05_00_pa.iehr.comt_mt111111ca.Summary {

    private static final long serialVersionUID = 20140501L;
    private II id = new IIImpl();
    private BL negationInd = new BLImpl();
    private CS statusCode = new CSImpl();
    private TS effectiveTime = new TSImpl();
    private CV uncertaintyCode = new CVImpl();
    private AdministeredToBean subject;
    private VaccineBean consumableAdministerableMedicineAdministerableVaccine;
    private BL subjectOf1DetectedIssuesIndicator = new BLImpl(false);
    private BL subjectOf2AnnotationIndicator = new BLImpl(false);
    private InvestigationEventBean causeInvestigationEvent;


    /**
     * <p>Business Name: A:Immunization Record Id</p>
     * 
     * <p>Relationship: POIZ_MT061150CA.Immunization.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the unique referencing of a specific 
     * immunization record. This should be known for query 
     * responses and is, therefore, mandatory.</p>
     * 
     * <p>This is an identifier assigned to a unique instance of an 
     * immunization record.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: A:Immunization Record Id</p>
     * 
     * <p>Relationship: POIZ_MT061150CA.Immunization.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the unique referencing of a specific 
     * immunization record. This should be known for query 
     * responses and is, therefore, mandatory.</p>
     * 
     * <p>This is an identifier assigned to a unique instance of an 
     * immunization record.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: Not Immunized?</p>
     * 
     * <p>Relationship: POIZ_MT061150CA.Immunization.negationInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Tracking failures to be immunized is also important in 
     * immunization reporting. Marked as mandatory because it is 
     * not meaningful for this flag to be 'unknown'.</p>
     * 
     * <p>An explicit indication that a person has not been 
     * immunized with the specified vaccine at the time 
     * indicated.</p>
     */
    @Hl7XmlMapping({"negationInd"})
    public Boolean getNegationInd() {
        return this.negationInd.getValue();
    }

    /**
     * <p>Business Name: Not Immunized?</p>
     * 
     * <p>Relationship: POIZ_MT061150CA.Immunization.negationInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Tracking failures to be immunized is also important in 
     * immunization reporting. Marked as mandatory because it is 
     * not meaningful for this flag to be 'unknown'.</p>
     * 
     * <p>An explicit indication that a person has not been 
     * immunized with the specified vaccine at the time 
     * indicated.</p>
     */
    public void setNegationInd(Boolean negationInd) {
        this.negationInd.setValue(negationInd);
    }


    /**
     * <p>Business Name: Immunization Event Status</p>
     * 
     * <p>Relationship: POIZ_MT061150CA.Immunization.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Needed to differentiate between valid, obsolete and 
     * invalid immunization events (e.g. immunization event has 
     * been retracted or nullified) and is therefore mandatory.</p>
     * 
     * <p>Nullified=Retracted</p>
     * 
     * <p>Status of the immunization event</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    /**
     * <p>Business Name: Immunization Event Status</p>
     * 
     * <p>Relationship: POIZ_MT061150CA.Immunization.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Needed to differentiate between valid, obsolete and 
     * invalid immunization events (e.g. immunization event has 
     * been retracted or nullified) and is therefore mandatory.</p>
     * 
     * <p>Nullified=Retracted</p>
     * 
     * <p>Status of the immunization event</p>
     */
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Business Name: Immunization Date</p>
     * 
     * <p>Relationship: POIZ_MT061150CA.Immunization.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Important information for establishing the validity of 
     * the immunization records, and therefore mandatory. Also used 
     * in the scheduling of subsequent immunizations.</p>
     * 
     * <p>The date the vaccine was administered to the patient.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Date getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: Immunization Date</p>
     * 
     * <p>Relationship: POIZ_MT061150CA.Immunization.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Important information for establishing the validity of 
     * the immunization records, and therefore mandatory. Also used 
     * in the scheduling of subsequent immunizations.</p>
     * 
     * <p>The date the vaccine was administered to the patient.</p>
     */
    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: Uncertainty Code</p>
     * 
     * <p>Relationship: 
     * POIZ_MT061150CA.Immunization.uncertaintyCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Allows for users of information to determine the degree 
     * of uncertainty regarding the details of an immunization 
     * event and is therefore populated.</p>
     * 
     * <p>An indication of uncertainty regarding an immunization 
     * event</p>
     */
    @Hl7XmlMapping({"uncertaintyCode"})
    public ActUncertainty getUncertaintyCode() {
        return (ActUncertainty) this.uncertaintyCode.getValue();
    }

    /**
     * <p>Business Name: Uncertainty Code</p>
     * 
     * <p>Relationship: 
     * POIZ_MT061150CA.Immunization.uncertaintyCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Allows for users of information to determine the degree 
     * of uncertainty regarding the details of an immunization 
     * event and is therefore populated.</p>
     * 
     * <p>An indication of uncertainty regarding an immunization 
     * event</p>
     */
    public void setUncertaintyCode(ActUncertainty uncertaintyCode) {
        this.uncertaintyCode.setValue(uncertaintyCode);
    }


    /**
     * <p>Relationship: POIZ_MT061150CA.Immunization.subject</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"subject"})
    public AdministeredToBean getSubject() {
        return this.subject;
    }

    /**
     * <p>Relationship: POIZ_MT061150CA.Immunization.subject</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setSubject(AdministeredToBean subject) {
        this.subject = subject;
    }


    /**
     * <p>Relationship: 
     * POIZ_MT061150CA.AdministerableMedicine.administerableVaccine</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"consumable/administerableMedicine/administerableVaccine"})
    public VaccineBean getConsumableAdministerableMedicineAdministerableVaccine() {
        return this.consumableAdministerableMedicineAdministerableVaccine;
    }

    /**
     * <p>Relationship: 
     * POIZ_MT061150CA.AdministerableMedicine.administerableVaccine</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setConsumableAdministerableMedicineAdministerableVaccine(VaccineBean consumableAdministerableMedicineAdministerableVaccine) {
        this.consumableAdministerableMedicineAdministerableVaccine = consumableAdministerableMedicineAdministerableVaccine;
    }


    /**
     * <p>Relationship: 
     * POIZ_MT061150CA.Subject5.detectedIssuesIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf1/detectedIssuesIndicator"})
    public Boolean getSubjectOf1DetectedIssuesIndicator() {
        return this.subjectOf1DetectedIssuesIndicator.getValue();
    }

    /**
     * <p>Relationship: 
     * POIZ_MT061150CA.Subject5.detectedIssuesIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSubjectOf1DetectedIssuesIndicator(Boolean subjectOf1DetectedIssuesIndicator) {
        this.subjectOf1DetectedIssuesIndicator.setValue(subjectOf1DetectedIssuesIndicator);
    }


    /**
     * <p>Relationship: 
     * POIZ_MT061150CA.Subject2.annotationIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf2/annotationIndicator"})
    public Boolean getSubjectOf2AnnotationIndicator() {
        return this.subjectOf2AnnotationIndicator.getValue();
    }

    /**
     * <p>Relationship: 
     * POIZ_MT061150CA.Subject2.annotationIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSubjectOf2AnnotationIndicator(Boolean subjectOf2AnnotationIndicator) {
        this.subjectOf2AnnotationIndicator.setValue(subjectOf2AnnotationIndicator);
    }


    /**
     * <p>Relationship: POIZ_MT061150CA.CauseOf.investigationEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"cause/investigationEvent"})
    public InvestigationEventBean getCauseInvestigationEvent() {
        return this.causeInvestigationEvent;
    }

    /**
     * <p>Relationship: POIZ_MT061150CA.CauseOf.investigationEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setCauseInvestigationEvent(InvestigationEventBean causeInvestigationEvent) {
        this.causeInvestigationEvent = causeInvestigationEvent;
    }

}
