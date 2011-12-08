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
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.pharmacy.porx_mt020070ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.x_NormalRestrictedTabooConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.coct_mt120600ca.NotesBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.coct_mt270010ca.AdministrationInstructionsBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.pharmacy.merged.PrescriptionReferenceBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.pharmacy.merged.SubstitutionBean;
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

    private static final long serialVersionUID = 20111208L;
    private II id = new IIImpl();
    private SET<CV, Code> confidentialityCode = new SETImpl<CV, Code>(CVImpl.class);
    private BL subject = new BLImpl(false);
    private PrescriptionReferenceBean inFulfillmentOfSubstanceAdministrationRequest;
    private SubstitutionBean component1SubstitutionMade;
    private List<AdministrationInstructionsBean> component2DosageInstruction = new ArrayList<AdministrationInstructionsBean>();
    private SupplyEventBean component3SupplyEvent;
    private NotesBean subjectOfAnnotation;


    /**
     * <p>A:Local Dispense Id</p>
     * 
     * <p><p>Identifier assigned by the dispensing facility.</p></p>
     * 
     * <p><p>Allows formal tracking of centrally recorded dispenses 
     * to local records for audit and related purposes.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>E:Prescription Masking Indicators</p>
     * 
     * <p><p>Communicates the intent that the dispense should be 
     * masked if it is created; If the dispense is masked, this 
     * makes the complete prescription and all dispenses 
     * masked.</p></p>
     * 
     * <p><p>Can be used to set a mask for a new dispense, if 
     * present in a new dispense request.</p><p>Allows the patient 
     * to have discrete control over access to their prescription 
     * data.</p><p>Taboo allows the provider to request restricted 
     * access to patient or their care giver.</p><p>Constraint: 
     * Can&#226;&#128;&#153;t have both normal and one of the other 
     * codes simultaneously.</p><p>The attribute is optional 
     * because not all systems will support masking.</p></p>
     * 
     * <p><p>Can be used to set a mask for a new dispense, if 
     * present in a new dispense request.</p><p>Allows the patient 
     * to have discrete control over access to their prescription 
     * data.</p><p>Taboo allows the provider to request restricted 
     * access to patient or their care giver.</p><p>Constraint: 
     * Can&#226;&#128;&#153;t have both normal and one of the other 
     * codes simultaneously.</p><p>The attribute is optional 
     * because not all systems will support masking.</p></p>
     * 
     * <p><p>Can be used to set a mask for a new dispense, if 
     * present in a new dispense request.</p><p>Allows the patient 
     * to have discrete control over access to their prescription 
     * data.</p><p>Taboo allows the provider to request restricted 
     * access to patient or their care giver.</p><p>Constraint: 
     * Can&#226;&#128;&#153;t have both normal and one of the other 
     * codes simultaneously.</p><p>The attribute is optional 
     * because not all systems will support masking.</p></p>
     * 
     * <p><p>Can be used to set a mask for a new dispense, if 
     * present in a new dispense request.</p><p>Allows the patient 
     * to have discrete control over access to their prescription 
     * data.</p><p>Taboo allows the provider to request restricted 
     * access to patient or their care giver.</p><p>Constraint: 
     * Can&#226;&#128;&#153;t have both normal and one of the other 
     * codes simultaneously.</p><p>The attribute is optional 
     * because not all systems will support masking.</p></p>
     * 
     * <p><p>Can be used to set a mask for a new dispense, if 
     * present in a new dispense request.</p><p>Allows the patient 
     * to have discrete control over access to their prescription 
     * data.</p><p>Taboo allows the provider to request restricted 
     * access to patient or their care giver.</p><p>Constraint: 
     * Can&#226;&#128;&#153;t have both normal and one of the other 
     * codes simultaneously.</p><p>The attribute is optional 
     * because not all systems will support masking.</p></p>
     * 
     * <p><p>If a dispense is masked, it implicitly masks the 
     * prescription being dispensed. (There's no point in masking a 
     * dispense if the prescription is unmasked.)</p></p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_NormalRestrictedTabooConfidentialityKind> getConfidentialityCode() {
        return this.confidentialityCode.rawSet(x_NormalRestrictedTabooConfidentialityKind.class);
    }


    @Hl7XmlMapping({"subject"})
    public Boolean getSubject() {
        return this.subject.getValue();
    }
    public void setSubject(Boolean subject) {
        this.subject.setValue(subject);
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


    @Hl7XmlMapping({"subjectOf/annotation"})
    public NotesBean getSubjectOfAnnotation() {
        return this.subjectOfAnnotation;
    }
    public void setSubjectOfAnnotation(NotesBean subjectOfAnnotation) {
        this.subjectOfAnnotation = subjectOfAnnotation;
    }

}
