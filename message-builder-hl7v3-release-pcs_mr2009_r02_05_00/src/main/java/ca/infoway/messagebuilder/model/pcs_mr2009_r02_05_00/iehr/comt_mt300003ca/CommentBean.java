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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.iehr.comt_mt300003ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActPatientAnnotationCode;
import ca.infoway.messagebuilder.domainvalue.x_BasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.merged.SupervisedByBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.merged.TargetedToPharmacyBean;
import java.util.Set;



/**
 * <p>Business Name: Comment</p>
 * 
 * <p>Allows comments to be attached to a Patient record. A 
 * Patient record can pertain to demographic or clinical (Drug, 
 * Condition, Lab, DI, etc) information.</p>
 * 
 * <p>Identifies the comments to be recorded against a 
 * Patient's record.</p>
 */
@Hl7PartTypeMapping({"COMT_MT300003CA.Annotation"})
@Hl7RootType
public class CommentBean extends MessagePartBean {

    private static final long serialVersionUID = 20190731L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private ST text = new STImpl();
    private SET<CV, Code> confidentialityCode = new SETImpl<CV, Code>(CVImpl.class);
    private SupervisedByBean responsibleParty;
    private AnnotatedByBean author;
    private TargetedToPharmacyBean location;


    /**
     * <p>Business Name: B:Patient Note Id</p>
     * 
     * <p>Relationship: COMT_MT300003CA.Annotation.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the unique reference of a patient note and is 
     * therefore mandatory.</p><p>Allows for referencing of a 
     * particular patient note and thus allows for the removal of 
     * the note.</p>
     * 
     * <p>Identifier of the patient note record.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: B:Patient Note Id</p>
     * 
     * <p>Relationship: COMT_MT300003CA.Annotation.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the unique reference of a patient note and is 
     * therefore mandatory.</p><p>Allows for referencing of a 
     * particular patient note and thus allows for the removal of 
     * the note.</p>
     * 
     * <p>Identifier of the patient note record.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: A:Patient Note Category</p>
     * 
     * <p>Relationship: COMT_MT300003CA.Annotation.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows patient notes of different purposes and use, to be 
     * attached to a patient. Attribute is mandatory to ensure that 
     * patient notes are categorized accordingly. This attribute 
     * may also be used by DISs to enforce different access control 
     * to different types of notes.</p>
     * 
     * <p>A coded value denoting the category of note being 
     * attached to a Patient's record. Categories of note include: 
     * General, Medication, Lab, DI, etc.</p>
     */
    @Hl7XmlMapping({"code"})
    public ActPatientAnnotationCode getCode() {
        return (ActPatientAnnotationCode) this.code.getValue();
    }

    /**
     * <p>Business Name: A:Patient Note Category</p>
     * 
     * <p>Relationship: COMT_MT300003CA.Annotation.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows patient notes of different purposes and use, to be 
     * attached to a patient. Attribute is mandatory to ensure that 
     * patient notes are categorized accordingly. This attribute 
     * may also be used by DISs to enforce different access control 
     * to different types of notes.</p>
     * 
     * <p>A coded value denoting the category of note being 
     * attached to a Patient's record. Categories of note include: 
     * General, Medication, Lab, DI, etc.</p>
     */
    public void setCode(ActPatientAnnotationCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: C:Patient Note Text</p>
     * 
     * <p>Relationship: COMT_MT300003CA.Annotation.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows a provider to attach comments to a patient as a 
     * whole or to the patient's profile (such as medication, lab. 
     * DI, etc). This attribute is mandatory because there's no 
     * point in having a patient note unless there's actually 
     * content in the note.</p>
     * 
     * <p>Free textual description of the patient note.</p>
     */
    @Hl7XmlMapping({"text"})
    public String getText() {
        return this.text.getValue();
    }

    /**
     * <p>Business Name: C:Patient Note Text</p>
     * 
     * <p>Relationship: COMT_MT300003CA.Annotation.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows a provider to attach comments to a patient as a 
     * whole or to the patient's profile (such as medication, lab. 
     * DI, etc). This attribute is mandatory because there's no 
     * point in having a patient note unless there's actually 
     * content in the note.</p>
     * 
     * <p>Free textual description of the patient note.</p>
     */
    public void setText(String text) {
        this.text.setValue(text);
    }


    /**
     * <p>Business Name: D:Restricted Patient Access</p>
     * 
     * <p>Relationship: 
     * COMT_MT300003CA.Annotation.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-2)</p>
     * 
     * <p>Taboo allows the provider to request restricted access to 
     * patient or their care giver.</p><p>Constraint: Can't have 
     * both normal and one of the other codes 
     * simultaneously.</p><p>The attribute is required because even 
     * if a jurisdiction doesn't support masking on the way in, it 
     * will need to need to communicate masked data returned from 
     * other jurisdictions.</p>
     * 
     * <p>Communicates the desire of the patient to restrict access 
     * to this Health Condition record. Provides support for 
     * additional confidentiality constraint, giving patients a 
     * level of control over their information. Methods for 
     * accessing masked event records will be governed by each 
     * jurisdiction (e.g. court orders, shared secret/consent, 
     * etc.). Can also be used to communicate that the information 
     * is deemed to be sensitive and should not be communicated or 
     * exposed to the patient (at least without the guidance of the 
     * authoring or other responsible healthcare provider). Valid 
     * values are: 'normal' (denotes 'Not Masked'); 'restricted' 
     * (denotes 'Masked'); 'very restricted' (denotes 'Masked by 
     * Regulation'); and 'taboo' (denotes 'patient restricted'). 
     * The default is 'normal' signifying 'Not Masked'. Either or 
     * both of the other codes can be asserted to indicate masking 
     * by the patient from providers or masking by a provider from 
     * the patient, respectively. 'normal' should never be asserted 
     * with one of the other codes.</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_BasicConfidentialityKind> getConfidentialityCode() {
        return this.confidentialityCode.rawSet(x_BasicConfidentialityKind.class);
    }


    /**
     * <p>Relationship: COMT_MT300003CA.Annotation.responsibleParty</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"responsibleParty"})
    public SupervisedByBean getResponsibleParty() {
        return this.responsibleParty;
    }

    /**
     * <p>Relationship: COMT_MT300003CA.Annotation.responsibleParty</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setResponsibleParty(SupervisedByBean responsibleParty) {
        this.responsibleParty = responsibleParty;
    }


    /**
     * <p>Relationship: COMT_MT300003CA.Annotation.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"author"})
    public AnnotatedByBean getAuthor() {
        return this.author;
    }

    /**
     * <p>Relationship: COMT_MT300003CA.Annotation.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAuthor(AnnotatedByBean author) {
        this.author = author;
    }


    /**
     * <p>Relationship: COMT_MT300003CA.Annotation.location</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"location"})
    public TargetedToPharmacyBean getLocation() {
        return this.location;
    }

    /**
     * <p>Relationship: COMT_MT300003CA.Annotation.location</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setLocation(TargetedToPharmacyBean location) {
        this.location = location;
    }

}
