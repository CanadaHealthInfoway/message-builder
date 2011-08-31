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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pharmacy.porx_mt020070ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.x_BasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt050303ca.AnimalPatientBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt270010ca.AdministrationInstructionsBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.IncludesBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pharmacy.merged.PrescriptionReferenceBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pharmacy.merged.SubstitutionBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



/**
 * <p>Prescription Dispense</p>
 * 
 * <p><p>This is the detailed information about a medication 
 * dispense that has been performed on behalf a patient.</p></p>
 * 
 * <p><p>Dispensing is an integral part of the overall 
 * medication process.</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT020070CA.MedicationDispense"})
@Hl7RootType
public class PrescriptionDispenseBean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private II localDispenseId = new IIImpl();
    private SET<CV, Code> prescriptionMaskingIndicators = new SETImpl<CV, Code>(CVImpl.class);
    private AnimalPatientBean subjectPatient;
    private PrescriptionReferenceBean inFulfillmentOfSubstanceAdministrationRequest;
    private SubstitutionBean component1SubstitutionMade;
    private List<AdministrationInstructionsBean> component2DosageInstruction = new ArrayList<AdministrationInstructionsBean>();
    private SupplyEventBean component3SupplyEvent;
    private IncludesBean subjectOf;


    /**
     * <p>A:Local Dispense Id</p>
     * 
     * <p><p>Identifier assigned by the dispensing facility.</p></p>
     * 
     * <p><p>Allows formal tracking of centrally recorded dispenses 
     * to local records for audit and related purposes.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getLocalDispenseId() {
        return this.localDispenseId.getValue();
    }
    public void setLocalDispenseId(Identifier localDispenseId) {
        this.localDispenseId.setValue(localDispenseId);
    }


    /**
     * <p>E:Prescription Masking Indicators</p>
     * 
     * <p><p>Communicates the intent that the dispense should be 
     * masked if it is created; If the dispense is masked, this 
     * makes the complete prescription and all dispenses 
     * masked.</p><p>Provides support for additional 
     * confidentiality constraint, giving patients a level of 
     * control over their information.</p><p>Valid values are: 'N' 
     * (normal - denotes 'Not Masked'); 'R' (restricted - denotes 
     * 'Masked'); 'V' (very restricted - denotes very restricted 
     * access as declared by the Privacy Officer of the record 
     * holder) and 'T' (taboo - denotes 'Patient Access 
     * Restricted').</p><p>The default is 'normal' signifying 'Not 
     * Masked'.</p></p>
     * 
     * <p><p>Communicates the intent that the dispense should be 
     * masked if it is created; If the dispense is masked, this 
     * makes the complete prescription and all dispenses 
     * masked.</p><p>Provides support for additional 
     * confidentiality constraint, giving patients a level of 
     * control over their information.</p><p>Valid values are: 'N' 
     * (normal - denotes 'Not Masked'); 'R' (restricted - denotes 
     * 'Masked'); 'V' (very restricted - denotes very restricted 
     * access as declared by the Privacy Officer of the record 
     * holder) and 'T' (taboo - denotes 'Patient Access 
     * Restricted').</p><p>The default is 'normal' signifying 'Not 
     * Masked'.</p></p>
     * 
     * <p><p>Communicates the intent that the dispense should be 
     * masked if it is created; If the dispense is masked, this 
     * makes the complete prescription and all dispenses 
     * masked.</p><p>Provides support for additional 
     * confidentiality constraint, giving patients a level of 
     * control over their information.</p><p>Valid values are: 'N' 
     * (normal - denotes 'Not Masked'); 'R' (restricted - denotes 
     * 'Masked'); 'V' (very restricted - denotes very restricted 
     * access as declared by the Privacy Officer of the record 
     * holder) and 'T' (taboo - denotes 'Patient Access 
     * Restricted').</p><p>The default is 'normal' signifying 'Not 
     * Masked'.</p></p>
     * 
     * <p><p>Communicates the intent that the dispense should be 
     * masked if it is created; If the dispense is masked, this 
     * makes the complete prescription and all dispenses 
     * masked.</p><p>Provides support for additional 
     * confidentiality constraint, giving patients a level of 
     * control over their information.</p><p>Valid values are: 'N' 
     * (normal - denotes 'Not Masked'); 'R' (restricted - denotes 
     * 'Masked'); 'V' (very restricted - denotes very restricted 
     * access as declared by the Privacy Officer of the record 
     * holder) and 'T' (taboo - denotes 'Patient Access 
     * Restricted').</p><p>The default is 'normal' signifying 'Not 
     * Masked'.</p></p>
     * 
     * <p><p>Can be used to set a mask for a new dispense, if 
     * present in a new dispense request.</p><p>Allows the patient 
     * to have discrete control over access to their prescription 
     * data.</p><p>Taboo allows the provider to request restricted 
     * access to patient or their care giver.</p><p>Constraint: 
     * Can't have both normal and one of the other codes 
     * simultaneously.</p><p>The attribute is optional because not 
     * all systems will support masking.</p></p>
     * 
     * <p><p>Can be used to set a mask for a new dispense, if 
     * present in a new dispense request.</p><p>Allows the patient 
     * to have discrete control over access to their prescription 
     * data.</p><p>Taboo allows the provider to request restricted 
     * access to patient or their care giver.</p><p>Constraint: 
     * Can't have both normal and one of the other codes 
     * simultaneously.</p><p>The attribute is optional because not 
     * all systems will support masking.</p></p>
     * 
     * <p><p>Can be used to set a mask for a new dispense, if 
     * present in a new dispense request.</p><p>Allows the patient 
     * to have discrete control over access to their prescription 
     * data.</p><p>Taboo allows the provider to request restricted 
     * access to patient or their care giver.</p><p>Constraint: 
     * Can't have both normal and one of the other codes 
     * simultaneously.</p><p>The attribute is optional because not 
     * all systems will support masking.</p></p>
     * 
     * <p><p>Can be used to set a mask for a new dispense, if 
     * present in a new dispense request.</p><p>Allows the patient 
     * to have discrete control over access to their prescription 
     * data.</p><p>Taboo allows the provider to request restricted 
     * access to patient or their care giver.</p><p>Constraint: 
     * Can't have both normal and one of the other codes 
     * simultaneously.</p><p>The attribute is optional because not 
     * all systems will support masking.</p></p>
     * 
     * <p><p>Can be used to set a mask for a new dispense, if 
     * present in a new dispense request.</p><p>Allows the patient 
     * to have discrete control over access to their prescription 
     * data.</p><p>Taboo allows the provider to request restricted 
     * access to patient or their care giver.</p><p>Constraint: 
     * Can't have both normal and one of the other codes 
     * simultaneously.</p><p>The attribute is optional because not 
     * all systems will support masking.</p></p>
     * 
     * <p><p>If a dispense is masked, it implicitly masks the 
     * prescription being dispensed. (There's no point in masking a 
     * dispense if the prescription is unmasked.)</p></p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_BasicConfidentialityKind> getPrescriptionMaskingIndicators() {
        return this.prescriptionMaskingIndicators.rawSet(x_BasicConfidentialityKind.class);
    }


    @Hl7XmlMapping({"subject/patient"})
    public AnimalPatientBean getSubjectPatient() {
        return this.subjectPatient;
    }
    public void setSubjectPatient(AnimalPatientBean subjectPatient) {
        this.subjectPatient = subjectPatient;
    }


    @Hl7XmlMapping({"inFulfillmentOf/substanceAdministrationRequest"})
    public PrescriptionReferenceBean getInFulfillmentOfSubstanceAdministrationRequest() {
        return this.inFulfillmentOfSubstanceAdministrationRequest;
    }
    public void setInFulfillmentOfSubstanceAdministrationRequest(PrescriptionReferenceBean inFulfillmentOfSubstanceAdministrationRequest) {
        this.inFulfillmentOfSubstanceAdministrationRequest = inFulfillmentOfSubstanceAdministrationRequest;
    }


    @Hl7XmlMapping({"component1/substitutionMade"})
    public SubstitutionBean getComponent1SubstitutionMade() {
        return this.component1SubstitutionMade;
    }
    public void setComponent1SubstitutionMade(SubstitutionBean component1SubstitutionMade) {
        this.component1SubstitutionMade = component1SubstitutionMade;
    }


    @Hl7XmlMapping({"component2/dosageInstruction"})
    public List<AdministrationInstructionsBean> getComponent2DosageInstruction() {
        return this.component2DosageInstruction;
    }


    @Hl7XmlMapping({"component3/supplyEvent"})
    public SupplyEventBean getComponent3SupplyEvent() {
        return this.component3SupplyEvent;
    }
    public void setComponent3SupplyEvent(SupplyEventBean component3SupplyEvent) {
        this.component3SupplyEvent = component3SupplyEvent;
    }


    @Hl7XmlMapping({"subjectOf"})
    public IncludesBean getSubjectOf() {
        return this.subjectOf;
    }
    public void setSubjectOf(IncludesBean subjectOf) {
        this.subjectOf = subjectOf;
    }

}
