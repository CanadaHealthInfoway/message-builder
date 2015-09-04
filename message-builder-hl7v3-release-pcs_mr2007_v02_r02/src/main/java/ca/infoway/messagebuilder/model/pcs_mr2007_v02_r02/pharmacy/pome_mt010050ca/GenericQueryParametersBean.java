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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pharmacy.pome_mt010050ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActMedicationDocumentCode;
import ca.infoway.messagebuilder.domainvalue.ClinicalDrug;
import ca.infoway.messagebuilder.domainvalue.DiagnosisValue;
import ca.infoway.messagebuilder.domainvalue.SymptomValue;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: Generic Query Parameters</p>
 * 
 * <p>One and only one of Drug Code, Prescribing Indication 
 * Code, or Medication Document ID must be specified.</p>
 * 
 * <p>Root class for query parameters.</p>
 * 
 * <p>Defines the set of parameters that may be used to filter 
 * the query response.</p>
 */
@Hl7PartTypeMapping({"POME_MT010050CA.ParameterList"})
@Hl7RootType
public class GenericQueryParametersBean extends MessagePartBean {

    private static final long serialVersionUID = 20150903L;
    private CV drugCodeValue = new CVImpl();
    private II medicationDocumentIDValue = new IIImpl();
    private CV medicationDocumentTypeValue = new CVImpl();
    private CV prescribingDiagnosisCodeValue = new CVImpl();
    private CV prescribingSymptomCodeValue = new CVImpl();


    /**
     * <p>Business Name: B:Drug Code</p>
     * 
     * <p>Relationship: POME_MT010050CA.DrugCode.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the requester to retrieve drugs of certain 
     * abstraction only. These drug abstractions include: 
     * Manufactured drug, generic formulation, generic, therapeutic 
     * class, etc.</p>
     * 
     * <p>An identifier for a type of drug. Types of drugs include: 
     * Manufactured drug, generic formulation, generic, therapeutic 
     * class, etc.</p>
     */
    @Hl7XmlMapping({"drugCode/value"})
    public ClinicalDrug getDrugCodeValue() {
        return (ClinicalDrug) this.drugCodeValue.getValue();
    }

    /**
     * <p>Business Name: B:Drug Code</p>
     * 
     * <p>Relationship: POME_MT010050CA.DrugCode.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the requester to retrieve drugs of certain 
     * abstraction only. These drug abstractions include: 
     * Manufactured drug, generic formulation, generic, therapeutic 
     * class, etc.</p>
     * 
     * <p>An identifier for a type of drug. Types of drugs include: 
     * Manufactured drug, generic formulation, generic, therapeutic 
     * class, etc.</p>
     */
    public void setDrugCodeValue(ClinicalDrug drugCodeValue) {
        this.drugCodeValue.setValue(drugCodeValue);
    }


    /**
     * <p>Business Name: E:Medication Document ID</p>
     * 
     * <p>Relationship: POME_MT010050CA.MedicationDocumentID.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Use of an identifier allows for a quick retrieval of the 
     * information of interest.</p>
     * 
     * <p>Unique identifier for a particular medication document. 
     * This will reference a specific kind of documentation (e.g. 
     * DDI Monograph, Patient Education Monograph, Allergy 
     * Monograph, etc) created by a specific author organization 
     * (e.g. Health Canada, FDB, WHO, etc).</p>
     */
    @Hl7XmlMapping({"medicationDocumentID/value"})
    public Identifier getMedicationDocumentIDValue() {
        return this.medicationDocumentIDValue.getValue();
    }

    /**
     * <p>Business Name: E:Medication Document ID</p>
     * 
     * <p>Relationship: POME_MT010050CA.MedicationDocumentID.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Use of an identifier allows for a quick retrieval of the 
     * information of interest.</p>
     * 
     * <p>Unique identifier for a particular medication document. 
     * This will reference a specific kind of documentation (e.g. 
     * DDI Monograph, Patient Education Monograph, Allergy 
     * Monograph, etc) created by a specific author organization 
     * (e.g. Health Canada, FDB, WHO, etc).</p>
     */
    public void setMedicationDocumentIDValue(Identifier medicationDocumentIDValue) {
        this.medicationDocumentIDValue.setValue(medicationDocumentIDValue);
    }


    /**
     * <p>Business Name: D:Medication Document Type</p>
     * 
     * <p>Relationship: 
     * POME_MT010050CA.MedicationDocumentType.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the retrieval of all medication documents 
     * pertaining to a specific document category.</p>
     * 
     * <p>Indicates that the result set is to be filtered to 
     * include only those medication documents pertaining to the 
     * specified document category.</p><p>Valid medication document 
     * categories include: Drug Monograph, Contraindication 
     * Monograph, Indication Protocol, etc.</p>
     */
    @Hl7XmlMapping({"medicationDocumentType/value"})
    public ActMedicationDocumentCode getMedicationDocumentTypeValue() {
        return (ActMedicationDocumentCode) this.medicationDocumentTypeValue.getValue();
    }

    /**
     * <p>Business Name: D:Medication Document Type</p>
     * 
     * <p>Relationship: 
     * POME_MT010050CA.MedicationDocumentType.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the retrieval of all medication documents 
     * pertaining to a specific document category.</p>
     * 
     * <p>Indicates that the result set is to be filtered to 
     * include only those medication documents pertaining to the 
     * specified document category.</p><p>Valid medication document 
     * categories include: Drug Monograph, Contraindication 
     * Monograph, Indication Protocol, etc.</p>
     */
    public void setMedicationDocumentTypeValue(ActMedicationDocumentCode medicationDocumentTypeValue) {
        this.medicationDocumentTypeValue.setValue(medicationDocumentTypeValue);
    }


    /**
     * <p>Business Name: C:Prescribing Indication Diagnosis Code</p>
     * 
     * <p>Relationship: 
     * POME_MT010050CA.PrescribingDiagnosisCode.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Useful for finding protocols and drug monographs 
     * associated with an indication</p>
     * 
     * <p>Returns documents which relate to a particular 
     * diagnosis</p>
     */
    @Hl7XmlMapping({"prescribingDiagnosisCode/value"})
    public DiagnosisValue getPrescribingDiagnosisCodeValue() {
        return (DiagnosisValue) this.prescribingDiagnosisCodeValue.getValue();
    }

    /**
     * <p>Business Name: C:Prescribing Indication Diagnosis Code</p>
     * 
     * <p>Relationship: 
     * POME_MT010050CA.PrescribingDiagnosisCode.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Useful for finding protocols and drug monographs 
     * associated with an indication</p>
     * 
     * <p>Returns documents which relate to a particular 
     * diagnosis</p>
     */
    public void setPrescribingDiagnosisCodeValue(DiagnosisValue prescribingDiagnosisCodeValue) {
        this.prescribingDiagnosisCodeValue.setValue(prescribingDiagnosisCodeValue);
    }


    /**
     * <p>Business Name: Prescribing Indication Symptom Code</p>
     * 
     * <p>Relationship: 
     * POME_MT010050CA.PrescribingSymptomCode.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Useful for finding protocols and drug monographs 
     * associated with an indication</p>
     * 
     * <p>Returns documents which relate to a particular 
     * symptom</p>
     */
    @Hl7XmlMapping({"prescribingSymptomCode/value"})
    public SymptomValue getPrescribingSymptomCodeValue() {
        return (SymptomValue) this.prescribingSymptomCodeValue.getValue();
    }

    /**
     * <p>Business Name: Prescribing Indication Symptom Code</p>
     * 
     * <p>Relationship: 
     * POME_MT010050CA.PrescribingSymptomCode.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Useful for finding protocols and drug monographs 
     * associated with an indication</p>
     * 
     * <p>Returns documents which relate to a particular 
     * symptom</p>
     */
    public void setPrescribingSymptomCodeValue(SymptomValue prescribingSymptomCodeValue) {
        this.prescribingSymptomCodeValue.setValue(prescribingSymptomCodeValue);
    }

}
