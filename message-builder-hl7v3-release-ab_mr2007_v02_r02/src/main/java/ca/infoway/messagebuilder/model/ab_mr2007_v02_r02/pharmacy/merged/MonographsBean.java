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
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedData;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActMedicationDocumentCode;
import ca.infoway.messagebuilder.domainvalue.HumanLanguage;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



/**
 * <p>POME_MT010040CA.Document: Monographs</p>
 * 
 * <p>Information on the composition and use of a drug.</p>
 * 
 * <p>Guides providers for specifying optimum use of drugs by 
 * patients. May also guide patients in appropriately using 
 * their medication.</p>
 * 
 * <p>PORR_MT050016CA.Document: Medication Documents</p>
 * 
 * <p>Information on the composition and use of a drug.</p>
 * 
 * <p>Guides providers for specifying optimum use of drugs by 
 * patients. May also guide patients in appropriately using 
 * their medication.</p>
 */
@Hl7PartTypeMapping({"POME_MT010040CA.Document","PORR_MT050016CA.Document"})
@Hl7RootType
public class MonographsBean extends MessagePartBean {

    private static final long serialVersionUID = 20121204L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private ED<EncapsulatedData> text = new EDImpl<EncapsulatedData>();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private CV languageCode = new CVImpl();
    private AssignedEntity3Bean authorAssignedEntity;
    private ED<EncapsulatedData> componentDocumentBodyEventText = new EDImpl<EncapsulatedData>();


    /**
     * <p>Other Business Name: MonographId</p>
     * 
     * <p>Relationship: POME_MT010040CA.Document.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Unique identifier assigned to a monograph record.</p>
     * 
     * <p>Allows matching and replacing of locally-stored 
     * monographs.</p><p>This attribute is marked as 'mandatory', 
     * as it is always available.</p>
     * 
     * <p>Allows matching and replacing of locally-stored 
     * monographs.</p><p>This attribute is marked as 'mandatory', 
     * as it is always available.</p>
     * 
     * <p>Other Business Name: MedicationDocumentId</p>
     * 
     * <p>Relationship: PORR_MT050016CA.Document.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Unique identifier assigned to a medication document 
     * record.</p>
     * 
     * <p>Allows matching and replacing of locally-stored 
     * medication documents.</p><p>This attribute is marked as 
     * 'mandatory', as it is always available.</p>
     * 
     * <p>Allows matching and replacing of locally-stored 
     * medication documents.</p><p>This attribute is marked as 
     * 'mandatory', as it is always available.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Other Business Name: MonographId</p>
     * 
     * <p>Relationship: POME_MT010040CA.Document.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Unique identifier assigned to a monograph record.</p>
     * 
     * <p>Allows matching and replacing of locally-stored 
     * monographs.</p><p>This attribute is marked as 'mandatory', 
     * as it is always available.</p>
     * 
     * <p>Allows matching and replacing of locally-stored 
     * monographs.</p><p>This attribute is marked as 'mandatory', 
     * as it is always available.</p>
     * 
     * <p>Other Business Name: MedicationDocumentId</p>
     * 
     * <p>Relationship: PORR_MT050016CA.Document.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Unique identifier assigned to a medication document 
     * record.</p>
     * 
     * <p>Allows matching and replacing of locally-stored 
     * medication documents.</p><p>This attribute is marked as 
     * 'mandatory', as it is always available.</p>
     * 
     * <p>Allows matching and replacing of locally-stored 
     * medication documents.</p><p>This attribute is marked as 
     * 'mandatory', as it is always available.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Other Business Name: MonographType</p>
     * 
     * <p>Relationship: POME_MT010040CA.Document.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Distinguishes between different kinds of documents and 
     * monographs. Kinds of monographs include: Clinical Monograph, 
     * Patient Education Monograph, etc.</p>
     * 
     * <p>Allows monograph types to be distinguished for display, 
     * printing, etc.</p><p>Code is mandatory because an 
     * application can't know what to do with a monograph without 
     * knowing its type.</p>
     * 
     * <p>Allows monograph types to be distinguished for display, 
     * printing, etc.</p><p>Code is mandatory because an 
     * application can't know what to do with a monograph without 
     * knowing its type.</p>
     * 
     * <p>Other Business Name: MedicationDocumentType</p>
     * 
     * <p>Relationship: PORR_MT050016CA.Document.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Distinguishes between different kinds of documents and 
     * medication documents. Kinds of medication documents include: 
     * Clinical Medication document, Patient Education Medication 
     * document, Indication Protocol, etc</p>
     * 
     * <p>Allows medication document types to be distinguished for 
     * display, printing, etc. Code is mandatory because an 
     * application can't know what to do with a medication document 
     * without knowing its type.</p>
     */
    @Hl7XmlMapping({"code"})
    public ActMedicationDocumentCode getCode() {
        return (ActMedicationDocumentCode) this.code.getValue();
    }

    /**
     * <p>Other Business Name: MonographType</p>
     * 
     * <p>Relationship: POME_MT010040CA.Document.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Distinguishes between different kinds of documents and 
     * monographs. Kinds of monographs include: Clinical Monograph, 
     * Patient Education Monograph, etc.</p>
     * 
     * <p>Allows monograph types to be distinguished for display, 
     * printing, etc.</p><p>Code is mandatory because an 
     * application can't know what to do with a monograph without 
     * knowing its type.</p>
     * 
     * <p>Allows monograph types to be distinguished for display, 
     * printing, etc.</p><p>Code is mandatory because an 
     * application can't know what to do with a monograph without 
     * knowing its type.</p>
     * 
     * <p>Other Business Name: MedicationDocumentType</p>
     * 
     * <p>Relationship: PORR_MT050016CA.Document.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Distinguishes between different kinds of documents and 
     * medication documents. Kinds of medication documents include: 
     * Clinical Medication document, Patient Education Medication 
     * document, Indication Protocol, etc</p>
     * 
     * <p>Allows medication document types to be distinguished for 
     * display, printing, etc. Code is mandatory because an 
     * application can't know what to do with a medication document 
     * without knowing its type.</p>
     */
    public void setCode(ActMedicationDocumentCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: MonographContent</p>
     * 
     * <p>Other Business Name: MonographContent</p>
     * 
     * <p>Relationship: POME_MT010040CA.Document.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Includes either the full-blown content of the monograph 
     * (as a PDF, HTML or HL7 CDA document), or provides a 
     * reference to where the monograph can be accessed on the 
     * network via HTTP or FTP</p>
     * 
     * <p>Allows delivery of the monograph information to the 
     * provider either embedded or by reference</p>
     */
    @Hl7XmlMapping({"text"})
    public EncapsulatedData getText() {
        return this.text.getValue();
    }

    /**
     * <p>Business Name: MonographContent</p>
     * 
     * <p>Other Business Name: MonographContent</p>
     * 
     * <p>Relationship: POME_MT010040CA.Document.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Includes either the full-blown content of the monograph 
     * (as a PDF, HTML or HL7 CDA document), or provides a 
     * reference to where the monograph can be accessed on the 
     * network via HTTP or FTP</p>
     * 
     * <p>Allows delivery of the monograph information to the 
     * provider either embedded or by reference</p>
     */
    public void setText(EncapsulatedData text) {
        this.text.setValue(text);
    }


    /**
     * <p>Other Business Name: MonographEffectiveExpiryDate</p>
     * 
     * <p>Relationship: POME_MT010040CA.Document.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>The date on which the information in the monograph became 
     * effective, and/or the date on which the information in the 
     * monograph was superseded</p>
     * 
     * <p>Indicates currency of information or when monograph no 
     * longer applies. Different systems may update their 
     * monographs at different times, and it is important to know 
     * what version contains the most current 
     * information.</p><p>Monograph effective and/or expiry date 
     * should be available in most situations and is clinically 
     * relevant; thus attribute is marked as 'populated'.</p>
     * 
     * <p>Indicates currency of information or when monograph no 
     * longer applies. Different systems may update their 
     * monographs at different times, and it is important to know 
     * what version contains the most current 
     * information.</p><p>Monograph effective and/or expiry date 
     * should be available in most situations and is clinically 
     * relevant; thus attribute is marked as 'populated'.</p>
     * 
     * <p>Other Business Name: 
     * MedicationDocumentEffectiveExpiryDate</p>
     * 
     * <p>Relationship: PORR_MT050016CA.Document.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>The date on which the information in the medication 
     * document became effective, and/or the date on which the 
     * information in the medication document was superseded.</p>
     * 
     * <p>Indicates currency of information or when monograph no 
     * longer applies. Different systems may update their 
     * monographs at different times, and it is important to know 
     * what version contains the most current 
     * information</p><p>Monograph effective and/or expiry date 
     * should be available in most situations and is clinically 
     * relevant; thus attribute is marked as 'populated'.</p>
     * 
     * <p>Indicates currency of information or when monograph no 
     * longer applies. Different systems may update their 
     * monographs at different times, and it is important to know 
     * what version contains the most current 
     * information</p><p>Monograph effective and/or expiry date 
     * should be available in most situations and is clinically 
     * relevant; thus attribute is marked as 'populated'.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Other Business Name: MonographEffectiveExpiryDate</p>
     * 
     * <p>Relationship: POME_MT010040CA.Document.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>The date on which the information in the monograph became 
     * effective, and/or the date on which the information in the 
     * monograph was superseded</p>
     * 
     * <p>Indicates currency of information or when monograph no 
     * longer applies. Different systems may update their 
     * monographs at different times, and it is important to know 
     * what version contains the most current 
     * information.</p><p>Monograph effective and/or expiry date 
     * should be available in most situations and is clinically 
     * relevant; thus attribute is marked as 'populated'.</p>
     * 
     * <p>Indicates currency of information or when monograph no 
     * longer applies. Different systems may update their 
     * monographs at different times, and it is important to know 
     * what version contains the most current 
     * information.</p><p>Monograph effective and/or expiry date 
     * should be available in most situations and is clinically 
     * relevant; thus attribute is marked as 'populated'.</p>
     * 
     * <p>Other Business Name: 
     * MedicationDocumentEffectiveExpiryDate</p>
     * 
     * <p>Relationship: PORR_MT050016CA.Document.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>The date on which the information in the medication 
     * document became effective, and/or the date on which the 
     * information in the medication document was superseded.</p>
     * 
     * <p>Indicates currency of information or when monograph no 
     * longer applies. Different systems may update their 
     * monographs at different times, and it is important to know 
     * what version contains the most current 
     * information</p><p>Monograph effective and/or expiry date 
     * should be available in most situations and is clinically 
     * relevant; thus attribute is marked as 'populated'.</p>
     * 
     * <p>Indicates currency of information or when monograph no 
     * longer applies. Different systems may update their 
     * monographs at different times, and it is important to know 
     * what version contains the most current 
     * information</p><p>Monograph effective and/or expiry date 
     * should be available in most situations and is clinically 
     * relevant; thus attribute is marked as 'populated'.</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: WrittenIn</p>
     * 
     * <p>Other Business Name: WrittenIn</p>
     * 
     * <p>Relationship: POME_MT010040CA.Document.languageCode</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>A coded value denoting the language in which the 
     * monograph is written.</p>
     * 
     * <p>Allows providers to request or display monographs in the 
     * language of their choice.</p><p>This attribute is marked as 
     * 'populated' because the language of the monograph must 
     * always be known/available or a null flavor must be 
     * specified.</p>
     * 
     * <p>Allows providers to request or display monographs in the 
     * language of their choice.</p><p>This attribute is marked as 
     * 'populated' because the language of the monograph must 
     * always be known/available or a null flavor must be 
     * specified.</p>
     */
    @Hl7XmlMapping({"languageCode"})
    public HumanLanguage getLanguageCode() {
        return (HumanLanguage) this.languageCode.getValue();
    }

    /**
     * <p>Business Name: WrittenIn</p>
     * 
     * <p>Other Business Name: WrittenIn</p>
     * 
     * <p>Relationship: POME_MT010040CA.Document.languageCode</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>A coded value denoting the language in which the 
     * monograph is written.</p>
     * 
     * <p>Allows providers to request or display monographs in the 
     * language of their choice.</p><p>This attribute is marked as 
     * 'populated' because the language of the monograph must 
     * always be known/available or a null flavor must be 
     * specified.</p>
     * 
     * <p>Allows providers to request or display monographs in the 
     * language of their choice.</p><p>This attribute is marked as 
     * 'populated' because the language of the monograph must 
     * always be known/available or a null flavor must be 
     * specified.</p>
     */
    public void setLanguageCode(HumanLanguage languageCode) {
        this.languageCode.setValue(languageCode);
    }


    /**
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POME_MT010040CA.Author.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORR_MT050016CA.Author.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"author/assignedEntity"})
    public AssignedEntity3Bean getAuthorAssignedEntity() {
        return this.authorAssignedEntity;
    }

    /**
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POME_MT010040CA.Author.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORR_MT050016CA.Author.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setAuthorAssignedEntity(AssignedEntity3Bean authorAssignedEntity) {
        this.authorAssignedEntity = authorAssignedEntity;
    }


    /**
     * <p>Business Name: MedicationDocumentContentLanguage</p>
     * 
     * <p>Other Business Name: MedicationDocumentContentLanguage</p>
     * 
     * <p>Relationship: PORR_MT050016CA.DocumentBodyEvent.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Includes either the full-blown content of the medication 
     * document (as a PDF, HTML or HL7 CDA document), or provides a 
     * reference to where the medication document can be accessed 
     * on the network via HTTP or FTP.</p><p>This attribute will 
     * also include a coded value denoting the language in which 
     * the medication document is written.</p>
     * 
     * <p>Includes either the full-blown content of the medication 
     * document (as a PDF, HTML or HL7 CDA document), or provides a 
     * reference to where the medication document can be accessed 
     * on the network via HTTP or FTP.</p><p>This attribute will 
     * also include a coded value denoting the language in which 
     * the medication document is written.</p>
     * 
     * <p>Allows delivery of the medication document information to 
     * the provider either embedded or by reference.</p><p>The 
     * inclusion of document language allows providers to determine 
     * what language the medication document is written 
     * in.</p><p>The attribute is mandatory because there is no 
     * point in having a medication document with no content.</p>
     * 
     * <p>Allows delivery of the medication document information to 
     * the provider either embedded or by reference.</p><p>The 
     * inclusion of document language allows providers to determine 
     * what language the medication document is written 
     * in.</p><p>The attribute is mandatory because there is no 
     * point in having a medication document with no content.</p>
     * 
     * <p>Allows delivery of the medication document information to 
     * the provider either embedded or by reference.</p><p>The 
     * inclusion of document language allows providers to determine 
     * what language the medication document is written 
     * in.</p><p>The attribute is mandatory because there is no 
     * point in having a medication document with no content.</p>
     */
    @Hl7XmlMapping({"component/documentBodyEvent/text"})
    public EncapsulatedData getComponentDocumentBodyEventText() {
        return this.componentDocumentBodyEventText.getValue();
    }

    /**
     * <p>Business Name: MedicationDocumentContentLanguage</p>
     * 
     * <p>Other Business Name: MedicationDocumentContentLanguage</p>
     * 
     * <p>Relationship: PORR_MT050016CA.DocumentBodyEvent.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Includes either the full-blown content of the medication 
     * document (as a PDF, HTML or HL7 CDA document), or provides a 
     * reference to where the medication document can be accessed 
     * on the network via HTTP or FTP.</p><p>This attribute will 
     * also include a coded value denoting the language in which 
     * the medication document is written.</p>
     * 
     * <p>Includes either the full-blown content of the medication 
     * document (as a PDF, HTML or HL7 CDA document), or provides a 
     * reference to where the medication document can be accessed 
     * on the network via HTTP or FTP.</p><p>This attribute will 
     * also include a coded value denoting the language in which 
     * the medication document is written.</p>
     * 
     * <p>Allows delivery of the medication document information to 
     * the provider either embedded or by reference.</p><p>The 
     * inclusion of document language allows providers to determine 
     * what language the medication document is written 
     * in.</p><p>The attribute is mandatory because there is no 
     * point in having a medication document with no content.</p>
     * 
     * <p>Allows delivery of the medication document information to 
     * the provider either embedded or by reference.</p><p>The 
     * inclusion of document language allows providers to determine 
     * what language the medication document is written 
     * in.</p><p>The attribute is mandatory because there is no 
     * point in having a medication document with no content.</p>
     * 
     * <p>Allows delivery of the medication document information to 
     * the provider either embedded or by reference.</p><p>The 
     * inclusion of document language allows providers to determine 
     * what language the medication document is written 
     * in.</p><p>The attribute is mandatory because there is no 
     * point in having a medication document with no content.</p>
     */
    public void setComponentDocumentBodyEventText(EncapsulatedData componentDocumentBodyEventText) {
        this.componentDocumentBodyEventText.setValue(componentDocumentBodyEventText);
    }

}
