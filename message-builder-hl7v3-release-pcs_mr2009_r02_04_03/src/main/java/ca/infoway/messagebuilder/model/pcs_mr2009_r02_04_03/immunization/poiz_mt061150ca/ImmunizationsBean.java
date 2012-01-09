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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.immunization.poiz_mt061150ca;

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
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.immunization.merged.AdministeredToBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.immunization.merged.InvestigationEventBean;
import java.util.Date;



/**
 * <p>Immunizations</p>
 * 
 * <p><p>A record of products administered to a patient 
 * specific to immunization.</p></p>
 * 
 * <p><p>Necessary component of a person's overall vaccine 
 * profile. Helps deal with outbreaks and also vaccine 
 * contraindication checking.</p></p>
 */
@Hl7PartTypeMapping({"POIZ_MT061150CA.Immunization"})
@Hl7RootType
public class ImmunizationsBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.iehr.comt_mt111111ca.Summary {

    private static final long serialVersionUID = 20120106L;
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
     * <p>A:Immunization Record Id</p>
     * 
     * <p><p>This is an identifier assigned to a unique instance of 
     * an immunization record.</p></p>
     * 
     * <p><p>Allows for the unique referencing of a specific 
     * immunization record. This should be known for query 
     * responses and is, therefore, mandatory.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Not Immunized?</p>
     * 
     * <p><p>An explicit indication that a person has not been 
     * immunized with the specified vaccine at the time 
     * indicated.</p></p>
     * 
     * <p><p>Tracking failures to be immunized is also important in 
     * immunization reporting. Marked as mandatory because it is 
     * not meaningful for this flag to be 'unknown'.</p></p>
     */
    @Hl7XmlMapping({"negationInd"})
    public Boolean getNegationInd() {
        return this.negationInd.getValue();
    }
    public void setNegationInd(Boolean negationInd) {
        this.negationInd.setValue(negationInd);
    }


    /**
     * <p>Immunization Event Status</p>
     * 
     * <p><p>Status of the immunization event</p></p>
     * 
     * <p><p>Needed to differentiate between valid, obsolete and 
     * invalid immunization events (e.g. immunization event has 
     * been retracted or nullified) and is therefore mandatory.</p></p>
     * 
     * <p><p>Nullified=Retracted</p></p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Immunization Date</p>
     * 
     * <p><p>The date the vaccine was administered to the 
     * patient.</p></p>
     * 
     * <p><p>Important information for establishing the validity of 
     * the immunization records, and therefore mandatory. Also used 
     * in the scheduling of subsequent immunizations.</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Date getEffectiveTime() {
        return this.effectiveTime.getValue();
    }
    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Uncertainty Code</p>
     * 
     * <p><p>An indication of uncertainty regarding an immunization 
     * event</p></p>
     * 
     * <p><p>Allows for users of information to determine the 
     * degree of uncertainty regarding the details of an 
     * immunization event and is therefore populated.</p></p>
     */
    @Hl7XmlMapping({"uncertaintyCode"})
    public ActUncertainty getUncertaintyCode() {
        return (ActUncertainty) this.uncertaintyCode.getValue();
    }
    public void setUncertaintyCode(ActUncertainty uncertaintyCode) {
        this.uncertaintyCode.setValue(uncertaintyCode);
    }


    @Hl7XmlMapping({"subject"})
    public AdministeredToBean getSubject() {
        return this.subject;
    }
    public void setSubject(AdministeredToBean subject) {
        this.subject = subject;
    }


    @Hl7XmlMapping({"consumable/administerableMedicine/administerableVaccine"})
    public VaccineBean getConsumableAdministerableMedicineAdministerableVaccine() {
        return this.consumableAdministerableMedicineAdministerableVaccine;
    }
    public void setConsumableAdministerableMedicineAdministerableVaccine(VaccineBean consumableAdministerableMedicineAdministerableVaccine) {
        this.consumableAdministerableMedicineAdministerableVaccine = consumableAdministerableMedicineAdministerableVaccine;
    }


    @Hl7XmlMapping({"subjectOf1/detectedIssuesIndicator"})
    public Boolean getSubjectOf1DetectedIssuesIndicator() {
        return this.subjectOf1DetectedIssuesIndicator.getValue();
    }
    public void setSubjectOf1DetectedIssuesIndicator(Boolean subjectOf1DetectedIssuesIndicator) {
        this.subjectOf1DetectedIssuesIndicator.setValue(subjectOf1DetectedIssuesIndicator);
    }


    @Hl7XmlMapping({"subjectOf2/annotationIndicator"})
    public Boolean getSubjectOf2AnnotationIndicator() {
        return this.subjectOf2AnnotationIndicator.getValue();
    }
    public void setSubjectOf2AnnotationIndicator(Boolean subjectOf2AnnotationIndicator) {
        this.subjectOf2AnnotationIndicator.setValue(subjectOf2AnnotationIndicator);
    }


    @Hl7XmlMapping({"cause/investigationEvent"})
    public InvestigationEventBean getCauseInvestigationEvent() {
        return this.causeInvestigationEvent;
    }
    public void setCauseInvestigationEvent(InvestigationEventBean causeInvestigationEvent) {
        this.causeInvestigationEvent = causeInvestigationEvent;
    }

}
