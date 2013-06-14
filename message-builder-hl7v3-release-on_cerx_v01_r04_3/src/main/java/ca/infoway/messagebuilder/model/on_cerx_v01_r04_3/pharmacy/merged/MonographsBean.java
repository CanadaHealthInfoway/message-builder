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
package ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7MapByPartType;
import ca.infoway.messagebuilder.annotation.Hl7MapByPartTypes;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedData;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActMedicationDocumentCode;
import ca.infoway.messagebuilder.domainvalue.HumanLanguage;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



/**
 * <p>POME_MT010040ON.Document: Monographs</p>
 * 
 * <p>Guides providers for specifying optimum use of drugs by 
 * patients. May also guide patients in appropriately using 
 * their medication.</p>
 * 
 * <p>Information on the composition and use of a drug.</p>
 * 
 * <p>PORR_MT050016ON.Document: Medication Documents</p>
 * 
 * <p>Guides providers for specifying optimum use of drugs by 
 * patients. May also guide patients in appropriately using 
 * their medication.</p>
 * 
 * <p>Information on the composition and use of a drug.</p>
 */
@Hl7PartTypeMapping({"POME_MT010040ON.Document","PORR_MT050016ON.Document"})
@Hl7RootType
public class MonographsBean extends MessagePartBean {

    private static final long serialVersionUID = 20130613L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private ED<EncapsulatedData> text = new EDImpl<EncapsulatedData>();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private CV languageCode = new CVImpl();
    private ST authorAssignedEntityRepresentedOrganizationName = new STImpl();
    private ED<EncapsulatedData> componentDocumentBodyEventText = new EDImpl<EncapsulatedData>();


    /**
     * <p>Un-merged Business Name: MonographId</p>
     * 
     * <p>Relationship: POME_MT010040ON.Document.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Monograph.monographId</p>
     * 
     * <p>Allows matching and replacing of locally-stored 
     * monographs.</p><p>This attribute is marked as 'mandatory', 
     * as it is always available.</p>
     * 
     * <p>Unique identifier assigned to a monograph record.</p>
     * 
     * <p>Un-merged Business Name: MedicationDocumentId</p>
     * 
     * <p>Relationship: PORR_MT050016ON.Document.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Monograph.monographId</p>
     * 
     * <p>Allows matching and replacing of locally-stored 
     * medication documents.</p><p>This attribute is marked as 
     * 'mandatory', as it is always available.</p>
     * 
     * <p>Unique identifier assigned to a medication document 
     * record.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Un-merged Business Name: MonographId</p>
     * 
     * <p>Relationship: POME_MT010040ON.Document.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Monograph.monographId</p>
     * 
     * <p>Allows matching and replacing of locally-stored 
     * monographs.</p><p>This attribute is marked as 'mandatory', 
     * as it is always available.</p>
     * 
     * <p>Unique identifier assigned to a monograph record.</p>
     * 
     * <p>Un-merged Business Name: MedicationDocumentId</p>
     * 
     * <p>Relationship: PORR_MT050016ON.Document.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Monograph.monographId</p>
     * 
     * <p>Allows matching and replacing of locally-stored 
     * medication documents.</p><p>This attribute is marked as 
     * 'mandatory', as it is always available.</p>
     * 
     * <p>Unique identifier assigned to a medication document 
     * record.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Un-merged Business Name: MonographType</p>
     * 
     * <p>Relationship: POME_MT010040ON.Document.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows distinction between Drug Monograph and Patient 
     * Monograph.</p>
     * 
     * <p>ZPC1.2</p>
     * 
     * <p>ZPD2.2</p>
     * 
     * <p>Allows monograph types to be distinguished for display, 
     * printing, etc.</p><p>Code is mandatory because an 
     * application can't know what to do with a monograph without 
     * knowing its type.</p>
     * 
     * <p>Distinguishes between different kinds of documents and 
     * monographs. Kinds of monographs include: Clinical Monograph, 
     * Patient Education Monograph, etc.</p>
     * 
     * <p>Un-merged Business Name: MedicationDocumentType</p>
     * 
     * <p>Relationship: PORR_MT050016ON.Document.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows distinction between Drug Monograph and Patient 
     * Monograph.</p>
     * 
     * <p>ZPC1.2</p>
     * 
     * <p>ZPD2.2</p>
     * 
     * <p>Allows medication document types to be distinguished for 
     * display, printing, etc. Code is mandatory because an 
     * application can't know what to do with a medication document 
     * without knowing its type.</p>
     * 
     * <p>Distinguishes between different kinds of documents and 
     * medication documents. Kinds of medication documents include: 
     * Clinical Medication document, Patient Education Medication 
     * document, Indication Protocol, etc</p>
     */
    @Hl7XmlMapping({"code"})
    public ActMedicationDocumentCode getCode() {
        return (ActMedicationDocumentCode) this.code.getValue();
    }

    /**
     * <p>Un-merged Business Name: MonographType</p>
     * 
     * <p>Relationship: POME_MT010040ON.Document.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows distinction between Drug Monograph and Patient 
     * Monograph.</p>
     * 
     * <p>ZPC1.2</p>
     * 
     * <p>ZPD2.2</p>
     * 
     * <p>Allows monograph types to be distinguished for display, 
     * printing, etc.</p><p>Code is mandatory because an 
     * application can't know what to do with a monograph without 
     * knowing its type.</p>
     * 
     * <p>Distinguishes between different kinds of documents and 
     * monographs. Kinds of monographs include: Clinical Monograph, 
     * Patient Education Monograph, etc.</p>
     * 
     * <p>Un-merged Business Name: MedicationDocumentType</p>
     * 
     * <p>Relationship: PORR_MT050016ON.Document.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows distinction between Drug Monograph and Patient 
     * Monograph.</p>
     * 
     * <p>ZPC1.2</p>
     * 
     * <p>ZPD2.2</p>
     * 
     * <p>Allows medication document types to be distinguished for 
     * display, printing, etc. Code is mandatory because an 
     * application can't know what to do with a medication document 
     * without knowing its type.</p>
     * 
     * <p>Distinguishes between different kinds of documents and 
     * medication documents. Kinds of medication documents include: 
     * Clinical Medication document, Patient Education Medication 
     * document, Indication Protocol, etc</p>
     */
    public void setCode(ActMedicationDocumentCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: MonographContent</p>
     * 
     * <p>Un-merged Business Name: MonographContent</p>
     * 
     * <p>Relationship: POME_MT010040ON.Document.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>DrugMonograph.DrugMomographLines</p>
     * 
     * <p>PatientMonograph.PatientMonographLines</p>
     * 
     * <p>ZPD3.1</p>
     * 
     * <p>Allows delivery of the monograph information to the 
     * provider either embedded or by reference</p>
     * 
     * <p>Includes either the full-blown content of the monograph 
     * (as a PDF, HTML or HL7 CDA document), or provides a 
     * reference to where the monograph can be accessed on the 
     * network via HTTP or FTP</p>
     */
    @Hl7XmlMapping({"text"})
    public EncapsulatedData getText() {
        return this.text.getValue();
    }

    /**
     * <p>Business Name: MonographContent</p>
     * 
     * <p>Un-merged Business Name: MonographContent</p>
     * 
     * <p>Relationship: POME_MT010040ON.Document.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>DrugMonograph.DrugMomographLines</p>
     * 
     * <p>PatientMonograph.PatientMonographLines</p>
     * 
     * <p>ZPD3.1</p>
     * 
     * <p>Allows delivery of the monograph information to the 
     * provider either embedded or by reference</p>
     * 
     * <p>Includes either the full-blown content of the monograph 
     * (as a PDF, HTML or HL7 CDA document), or provides a 
     * reference to where the monograph can be accessed on the 
     * network via HTTP or FTP</p>
     */
    public void setText(EncapsulatedData text) {
        this.text.setValue(text);
    }


    /**
     * <p>Un-merged Business Name: MonographEffectiveExpiryDate</p>
     * 
     * <p>Relationship: POME_MT010040ON.Document.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Monograph.EffectiveDate</p>
     * 
     * <p>Monograph.EndDate</p>
     * 
     * <p>Indicates currency of information or when monograph no 
     * longer applies. Different systems may update their 
     * monographs at different times, and it is important to know 
     * what version contains the most current 
     * information.</p><p>Monograph effective and/or expiry date 
     * should be available in most situations and is clinically 
     * relevant; thus attribute is marked as 'populated'.</p>
     * 
     * <p>The date on which the information in the monograph became 
     * effective, and/or the date on which the information in the 
     * monograph was superseded</p>
     * 
     * <p>Un-merged Business Name: 
     * MedicationDocumentEffectiveExpiryDate</p>
     * 
     * <p>Relationship: PORR_MT050016ON.Document.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Monograph.EffectiveDate</p>
     * 
     * <p>Monograph.EndDate</p>
     * 
     * <p>Indicates currency of information or when monograph no 
     * longer applies. Different systems may update their 
     * monographs at different times, and it is important to know 
     * what version contains the most current 
     * information</p><p>Monograph effective and/or expiry date 
     * should be available in most situations and is clinically 
     * relevant; thus attribute is marked as 'populated'.</p>
     * 
     * <p>The date on which the information in the medication 
     * document became effective, and/or the date on which the 
     * information in the medication document was superseded.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Un-merged Business Name: MonographEffectiveExpiryDate</p>
     * 
     * <p>Relationship: POME_MT010040ON.Document.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Monograph.EffectiveDate</p>
     * 
     * <p>Monograph.EndDate</p>
     * 
     * <p>Indicates currency of information or when monograph no 
     * longer applies. Different systems may update their 
     * monographs at different times, and it is important to know 
     * what version contains the most current 
     * information.</p><p>Monograph effective and/or expiry date 
     * should be available in most situations and is clinically 
     * relevant; thus attribute is marked as 'populated'.</p>
     * 
     * <p>The date on which the information in the monograph became 
     * effective, and/or the date on which the information in the 
     * monograph was superseded</p>
     * 
     * <p>Un-merged Business Name: 
     * MedicationDocumentEffectiveExpiryDate</p>
     * 
     * <p>Relationship: PORR_MT050016ON.Document.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Monograph.EffectiveDate</p>
     * 
     * <p>Monograph.EndDate</p>
     * 
     * <p>Indicates currency of information or when monograph no 
     * longer applies. Different systems may update their 
     * monographs at different times, and it is important to know 
     * what version contains the most current 
     * information</p><p>Monograph effective and/or expiry date 
     * should be available in most situations and is clinically 
     * relevant; thus attribute is marked as 'populated'.</p>
     * 
     * <p>The date on which the information in the medication 
     * document became effective, and/or the date on which the 
     * information in the medication document was superseded.</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: WrittenIn</p>
     * 
     * <p>Un-merged Business Name: WrittenIn</p>
     * 
     * <p>Relationship: POME_MT010040ON.Document.languageCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Allows providers to request or display monographs in the 
     * language of their choice.</p><p>This attribute is marked as 
     * 'populated' because the language of the monograph must 
     * always be known/available or a null flavor must be 
     * specified.</p>
     * 
     * <p>A coded value denoting the language in which the 
     * monograph is written.</p>
     */
    @Hl7XmlMapping({"languageCode"})
    public HumanLanguage getLanguageCode() {
        return (HumanLanguage) this.languageCode.getValue();
    }

    /**
     * <p>Business Name: WrittenIn</p>
     * 
     * <p>Un-merged Business Name: WrittenIn</p>
     * 
     * <p>Relationship: POME_MT010040ON.Document.languageCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Allows providers to request or display monographs in the 
     * language of their choice.</p><p>This attribute is marked as 
     * 'populated' because the language of the monograph must 
     * always be known/available or a null flavor must be 
     * specified.</p>
     * 
     * <p>A coded value denoting the language in which the 
     * monograph is written.</p>
     */
    public void setLanguageCode(HumanLanguage languageCode) {
        this.languageCode.setValue(languageCode);
    }


    /**
     * <p>Un-merged Business Name: MonographAuthorName</p>
     * 
     * <p>Relationship: POME_MT010040ON.Organization1.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Helps the receiver evaluate the supplied information.</p>
     * 
     * <p>The name of the organization responsible for creating the 
     * monograph</p>
     * 
     * <p>Un-merged Business Name: MedicationDocumentAuthorName</p>
     * 
     * <p>Relationship: PORR_MT050016ON.Organization4.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Helps the receiver evaluate the supplied information.</p>
     * 
     * <p>The name of the organization responsible for creating the 
     * medication document.</p>
     */
    @Hl7XmlMapping({"author/assignedEntity/assignedOrganization/name","author/assignedEntity/representedOrganization/name"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="author", type="POME_MT010040ON.Author"),
        @Hl7MapByPartType(name="author", type="PORR_MT050016ON.Author"),
        @Hl7MapByPartType(name="author/assignedEntity", type="POME_MT010040ON.AssignedEntity1"),
        @Hl7MapByPartType(name="author/assignedEntity", type="PORR_MT050016ON.AssignedEntity"),
        @Hl7MapByPartType(name="author/assignedEntity/assignedOrganization", type="POME_MT010040ON.Organization1"),
        @Hl7MapByPartType(name="author/assignedEntity/representedOrganization", type="PORR_MT050016ON.Organization4")})
    public String getAuthorAssignedEntityRepresentedOrganizationName() {
        return this.authorAssignedEntityRepresentedOrganizationName.getValue();
    }

    /**
     * <p>Un-merged Business Name: MonographAuthorName</p>
     * 
     * <p>Relationship: POME_MT010040ON.Organization1.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Helps the receiver evaluate the supplied information.</p>
     * 
     * <p>The name of the organization responsible for creating the 
     * monograph</p>
     * 
     * <p>Un-merged Business Name: MedicationDocumentAuthorName</p>
     * 
     * <p>Relationship: PORR_MT050016ON.Organization4.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Helps the receiver evaluate the supplied information.</p>
     * 
     * <p>The name of the organization responsible for creating the 
     * medication document.</p>
     */
    public void setAuthorAssignedEntityRepresentedOrganizationName(String authorAssignedEntityRepresentedOrganizationName) {
        this.authorAssignedEntityRepresentedOrganizationName.setValue(authorAssignedEntityRepresentedOrganizationName);
    }


    /**
     * <p>Business Name: MedicationDocumentContentLanguage</p>
     * 
     * <p>Un-merged Business Name: 
     * MedicationDocumentContentLanguage</p>
     * 
     * <p>Relationship: PORR_MT050016ON.DocumentBodyEvent.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows delivery of the medication document information to 
     * the provider either embedded or by reference.</p><p>The 
     * inclusion of document language allows providers to determine 
     * what language the medication document is written 
     * in.</p><p>The attribute is mandatory because there is no 
     * point in having a medication document with no content.</p>
     * 
     * <p>Includes either the full-blown content of the medication 
     * document (as a PDF, HTML or HL7 CDA document), or provides a 
     * reference to where the medication document can be accessed 
     * on the network via HTTP or FTP.</p><p>This attribute will 
     * also include a coded value denoting the language in which 
     * the medication document is written.</p>
     */
    @Hl7XmlMapping({"component/documentBodyEvent/text"})
    public EncapsulatedData getComponentDocumentBodyEventText() {
        return this.componentDocumentBodyEventText.getValue();
    }

    /**
     * <p>Business Name: MedicationDocumentContentLanguage</p>
     * 
     * <p>Un-merged Business Name: 
     * MedicationDocumentContentLanguage</p>
     * 
     * <p>Relationship: PORR_MT050016ON.DocumentBodyEvent.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows delivery of the medication document information to 
     * the provider either embedded or by reference.</p><p>The 
     * inclusion of document language allows providers to determine 
     * what language the medication document is written 
     * in.</p><p>The attribute is mandatory because there is no 
     * point in having a medication document with no content.</p>
     * 
     * <p>Includes either the full-blown content of the medication 
     * document (as a PDF, HTML or HL7 CDA document), or provides a 
     * reference to where the medication document can be accessed 
     * on the network via HTTP or FTP.</p><p>This attribute will 
     * also include a coded value denoting the language in which 
     * the medication document is written.</p>
     */
    public void setComponentDocumentBodyEventText(EncapsulatedData componentDocumentBodyEventText) {
        this.componentDocumentBodyEventText.setValue(componentDocumentBodyEventText);
    }

}
