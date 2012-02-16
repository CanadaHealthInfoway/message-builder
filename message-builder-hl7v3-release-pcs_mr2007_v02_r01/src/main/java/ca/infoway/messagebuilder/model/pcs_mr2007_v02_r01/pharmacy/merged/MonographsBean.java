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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.pharmacy.merged;

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
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.merged.RefusedByBean;
import java.util.Date;



/**
 * <p>POME_MT010040CA.Document: Monographs</p>
 * 
 * <p><p>Information on the composition and use of a drug.</p></p>
 * 
 * <p><p>Guides providers for specifying optimum use of drugs 
 * by patients. May also guide patients in appropriately using 
 * their medication.</p></p>
 * 
 * <p>PORR_MT050016CA.Document: Medication Documents</p>
 * 
 * <p><p>Information on the composition and use of a drug.</p></p>
 * 
 * <p><p>Guides providers for specifying optimum use of drugs 
 * by patients. May also guide patients in appropriately using 
 * their medication.</p></p>
 */
@Hl7PartTypeMapping({"POME_MT010040CA.Document","PORR_MT050016CA.Document"})
@Hl7RootType
public class MonographsBean extends MessagePartBean {

    private static final long serialVersionUID = 20120215L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private ED<EncapsulatedData> text = new EDImpl<EncapsulatedData>();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private CV languageCode = new CVImpl();
    private RefusedByBean author;
    private ED<EncapsulatedData> componentDocumentBodyEventText = new EDImpl<EncapsulatedData>();


    /**
     * <p>B:Medication Document Id</p>
     * 
     * <p><p>Unique identifier assigned to a medication document 
     * record.</p></p>
     * 
     * <p><p>Allows matching and replacing of locally-stored 
     * medication documents.</p><p>This attribute is marked as 
     * 'mandatory', as it is always available.</p></p>
     * 
     * <p><p>Allows matching and replacing of locally-stored 
     * medication documents.</p><p>This attribute is marked as 
     * 'mandatory', as it is always available.</p></p>
     * 
     * <p>Monograph Id</p>
     * 
     * <p><p>Unique identifier assigned to a monograph record.</p></p>
     * 
     * <p><p>Allows matching and replacing of locally-stored 
     * monographs.</p><p>This attribute is marked as 'mandatory', 
     * as it is always available.</p></p>
     * 
     * <p><p>Allows matching and replacing of locally-stored 
     * monographs.</p><p>This attribute is marked as 'mandatory', 
     * as it is always available.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Monograph Type</p>
     * 
     * <p><p>Distinguishes between different kinds of documents and 
     * monographs. Kinds of monographs include: Clinical Monograph, 
     * Patient Education Monograph, etc.</p></p>
     * 
     * <p><p>Allows monograph types to be distinguished for 
     * display, printing, etc.</p><p>Code is mandatory because an 
     * application can't know what to do with a monograph without 
     * knowing its type.</p></p>
     * 
     * <p><p>Allows monograph types to be distinguished for 
     * display, printing, etc.</p><p>Code is mandatory because an 
     * application can't know what to do with a monograph without 
     * knowing its type.</p></p>
     * 
     * <p>A:Medication Document Type</p>
     * 
     * <p><p>Distinguishes between different kinds of documents and 
     * medication documents. Kinds of medication documents include: 
     * Clinical Medication document, Patient Education Medication 
     * document, Indication Protocol, etc</p></p>
     * 
     * <p><p>Allows medication document types to be distinguished 
     * for display, printing, etc. Code is mandatory because an 
     * application can't know what to do with a medication document 
     * without knowing its type.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public ActMedicationDocumentCode getCode() {
        return (ActMedicationDocumentCode) this.code.getValue();
    }
    public void setCode(ActMedicationDocumentCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>MonographContent</p>
     * 
     * <p>Monograph Content</p>
     * 
     * <p><p>Includes either the full-blown content of the 
     * monograph (as a PDF, HTML or HL7 CDA document), or provides 
     * a reference to where the monograph can be accessed on the 
     * network via HTTP or FTP</p></p>
     * 
     * <p><p>Allows delivery of the monograph information to the 
     * provider either embedded or by reference</p></p>
     */
    @Hl7XmlMapping({"text"})
    public EncapsulatedData getText() {
        return this.text.getValue();
    }
    public void setText(EncapsulatedData text) {
        this.text.setValue(text);
    }


    /**
     * <p>C:Medication Document Effective/Expiry Date</p>
     * 
     * <p><p>The date on which the information in the medication 
     * document became effective, and/or the date on which the 
     * information in the medication document was superseded.</p></p>
     * 
     * <p><p>Indicates currency of information or when monograph no 
     * longer applies. Different systems may update their 
     * monographs at different times, and it is important to know 
     * what version contains the most current 
     * information</p><p>Monograph effective and/or expiry date 
     * should be available in most situations and is clinically 
     * relevant; thus attribute is marked as 'populated'.</p></p>
     * 
     * <p><p>Indicates currency of information or when monograph no 
     * longer applies. Different systems may update their 
     * monographs at different times, and it is important to know 
     * what version contains the most current 
     * information</p><p>Monograph effective and/or expiry date 
     * should be available in most situations and is clinically 
     * relevant; thus attribute is marked as 'populated'.</p></p>
     * 
     * <p>Monograph Effective/Expiry Date</p>
     * 
     * <p><p>The date on which the information in the monograph 
     * became effective, and/or the date on which the information 
     * in the monograph was superseded</p></p>
     * 
     * <p><p>Indicates currency of information or when monograph no 
     * longer applies. Different systems may update their 
     * monographs at different times, and it is important to know 
     * what version contains the most current 
     * information.</p><p>Monograph effective and/or expiry date 
     * should be available in most situations and is clinically 
     * relevant; thus attribute is marked as 'populated'.</p></p>
     * 
     * <p><p>Indicates currency of information or when monograph no 
     * longer applies. Different systems may update their 
     * monographs at different times, and it is important to know 
     * what version contains the most current 
     * information.</p><p>Monograph effective and/or expiry date 
     * should be available in most situations and is clinically 
     * relevant; thus attribute is marked as 'populated'.</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>WrittenIn</p>
     * 
     * <p>Written in</p>
     * 
     * <p><p>A coded value denoting the language in which the 
     * monograph is written.</p></p>
     * 
     * <p><p>Allows providers to request or display monographs in 
     * the language of their choice.</p><p>This attribute is marked 
     * as 'populated' because the language of the monograph must 
     * always be known/available or a null flavor must be 
     * specified.</p></p>
     * 
     * <p><p>Allows providers to request or display monographs in 
     * the language of their choice.</p><p>This attribute is marked 
     * as 'populated' because the language of the monograph must 
     * always be known/available or a null flavor must be 
     * specified.</p></p>
     */
    @Hl7XmlMapping({"languageCode"})
    public HumanLanguage getLanguageCode() {
        return (HumanLanguage) this.languageCode.getValue();
    }
    public void setLanguageCode(HumanLanguage languageCode) {
        this.languageCode.setValue(languageCode);
    }


    @Hl7XmlMapping({"author"})
    public RefusedByBean getAuthor() {
        return this.author;
    }
    public void setAuthor(RefusedByBean author) {
        this.author = author;
    }


    /**
     * <p>MedicationDocumentContentLanguage</p>
     * 
     * <p>F:Medication Document Content + Language</p>
     * 
     * <p><p>Includes either the full-blown content of the 
     * medication document (as a PDF, HTML or HL7 CDA document), or 
     * provides a reference to where the medication document can be 
     * accessed on the network via HTTP or FTP.</p><p>This 
     * attribute will also include a coded value denoting the 
     * language in which the medication document is written.</p></p>
     * 
     * <p><p>Includes either the full-blown content of the 
     * medication document (as a PDF, HTML or HL7 CDA document), or 
     * provides a reference to where the medication document can be 
     * accessed on the network via HTTP or FTP.</p><p>This 
     * attribute will also include a coded value denoting the 
     * language in which the medication document is written.</p></p>
     * 
     * <p><p>Allows delivery of the medication document information 
     * to the provider either embedded or by reference.</p><p>The 
     * inclusion of document language allows providers to determine 
     * what language the medication document is written 
     * in.</p><p>The attribute is mandatory because there is no 
     * point in having a medication document with no content.</p></p>
     * 
     * <p><p>Allows delivery of the medication document information 
     * to the provider either embedded or by reference.</p><p>The 
     * inclusion of document language allows providers to determine 
     * what language the medication document is written 
     * in.</p><p>The attribute is mandatory because there is no 
     * point in having a medication document with no content.</p></p>
     * 
     * <p><p>Allows delivery of the medication document information 
     * to the provider either embedded or by reference.</p><p>The 
     * inclusion of document language allows providers to determine 
     * what language the medication document is written 
     * in.</p><p>The attribute is mandatory because there is no 
     * point in having a medication document with no content.</p></p>
     */
    @Hl7XmlMapping({"component/documentBodyEvent/text"})
    public EncapsulatedData getComponentDocumentBodyEventText() {
        return this.componentDocumentBodyEventText.getValue();
    }
    public void setComponentDocumentBodyEventText(EncapsulatedData componentDocumentBodyEventText) {
        this.componentDocumentBodyEventText.setValue(componentDocumentBodyEventText);
    }

}
