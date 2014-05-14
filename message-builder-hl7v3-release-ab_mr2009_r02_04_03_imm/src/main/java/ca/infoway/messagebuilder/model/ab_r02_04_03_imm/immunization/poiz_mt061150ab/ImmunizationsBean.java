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
package ca.infoway.messagebuilder.model.ab_r02_04_03_imm.immunization.poiz_mt061150ab;

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
import ca.infoway.messagebuilder.model.ab_r02_04_03_imm.common.merged.Patient_2Bean;
import ca.infoway.messagebuilder.model.ab_r02_04_03_imm.immunization.merged.InvestigationEventBean;
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
@Hl7PartTypeMapping({"POIZ_MT061150AB.Immunization"})
@Hl7RootType
public class ImmunizationsBean extends MessagePartBean {

    private static final long serialVersionUID = 20140514L;
    private II id = new IIImpl();
    private BL negationInd = new BLImpl();
    private CS statusCode = new CSImpl();
    private TS effectiveTime = new TSImpl();
    private CV uncertaintyCode = new CVImpl();
    private Patient_2Bean subjectPatient;
    private VaccineBean consumableAdministerableMedicineAdministrableVaccine;
    private BL subjectOfAnnotationIndicator = new BLImpl(false);
    private InvestigationEventBean causeInvestigationEvent;


    /**
     * <p>Business Name: A:Immunization Record Id</p>
     * 
     * <p>Relationship: POIZ_MT061150AB.Immunization.id</p>
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
     * <p>Relationship: POIZ_MT061150AB.Immunization.id</p>
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
     * <p>Relationship: POIZ_MT061150AB.Immunization.negationInd</p>
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
     * <p>Relationship: POIZ_MT061150AB.Immunization.negationInd</p>
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
     * <p>Relationship: POIZ_MT061150AB.Immunization.statusCode</p>
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
     * <p>Relationship: POIZ_MT061150AB.Immunization.statusCode</p>
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
     * <p>Relationship: POIZ_MT061150AB.Immunization.effectiveTime</p>
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
     * <p>Relationship: POIZ_MT061150AB.Immunization.effectiveTime</p>
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
     * <p>Business Name: Historical Indicator</p>
     * 
     * <p>Relationship: 
     * POIZ_MT061150AB.Immunization.uncertaintyCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Allows for users of information to determine the degree 
     * of uncertainty regarding the details of an immunization 
     * event and is therefore populated.</p>
     * 
     * <p>To indicate an immunization event is historical, this 
     * should be valued 'U'.</p><p>To indicate an immunization 
     * event is not historical, this should be valued with a 
     * nullFlavor of 'NA'.</p>
     * 
     * <p>An indication of uncertainty regarding an immunization 
     * event</p>
     */
    @Hl7XmlMapping({"uncertaintyCode"})
    public ActUncertainty getUncertaintyCode() {
        return (ActUncertainty) this.uncertaintyCode.getValue();
    }

    /**
     * <p>Business Name: Historical Indicator</p>
     * 
     * <p>Relationship: 
     * POIZ_MT061150AB.Immunization.uncertaintyCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Allows for users of information to determine the degree 
     * of uncertainty regarding the details of an immunization 
     * event and is therefore populated.</p>
     * 
     * <p>To indicate an immunization event is historical, this 
     * should be valued 'U'.</p><p>To indicate an immunization 
     * event is not historical, this should be valued with a 
     * nullFlavor of 'NA'.</p>
     * 
     * <p>An indication of uncertainty regarding an immunization 
     * event</p>
     */
    public void setUncertaintyCode(ActUncertainty uncertaintyCode) {
        this.uncertaintyCode.setValue(uncertaintyCode);
    }


    /**
     * <p>Relationship: POIZ_MT061150AB.Subject10.patient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"subject/patient"})
    public Patient_2Bean getSubjectPatient() {
        return this.subjectPatient;
    }

    /**
     * <p>Relationship: POIZ_MT061150AB.Subject10.patient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setSubjectPatient(Patient_2Bean subjectPatient) {
        this.subjectPatient = subjectPatient;
    }


    /**
     * <p>Relationship: 
     * POIZ_MT061150AB.AdministerableMedicine.administrableVaccine</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"consumable/administerableMedicine/administrableVaccine"})
    public VaccineBean getConsumableAdministerableMedicineAdministrableVaccine() {
        return this.consumableAdministerableMedicineAdministrableVaccine;
    }

    /**
     * <p>Relationship: 
     * POIZ_MT061150AB.AdministerableMedicine.administrableVaccine</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setConsumableAdministerableMedicineAdministrableVaccine(VaccineBean consumableAdministerableMedicineAdministrableVaccine) {
        this.consumableAdministerableMedicineAdministrableVaccine = consumableAdministerableMedicineAdministrableVaccine;
    }


    /**
     * <p>Relationship: 
     * POIZ_MT061150AB.Subject2.annotationIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf/annotationIndicator"})
    public Boolean getSubjectOfAnnotationIndicator() {
        return this.subjectOfAnnotationIndicator.getValue();
    }

    /**
     * <p>Relationship: 
     * POIZ_MT061150AB.Subject2.annotationIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSubjectOfAnnotationIndicator(Boolean subjectOfAnnotationIndicator) {
        this.subjectOfAnnotationIndicator.setValue(subjectOfAnnotationIndicator);
    }


    /**
     * <p>Relationship: POIZ_MT061150AB.CauseOf.investigationEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"cause/investigationEvent"})
    public InvestigationEventBean getCauseInvestigationEvent() {
        return this.causeInvestigationEvent;
    }

    /**
     * <p>Relationship: POIZ_MT061150AB.CauseOf.investigationEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setCauseInvestigationEvent(InvestigationEventBean causeInvestigationEvent) {
        this.causeInvestigationEvent = causeInvestigationEvent;
    }

}
