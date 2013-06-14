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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActMedicationDocumentCode;
import ca.infoway.messagebuilder.domainvalue.ClinicalDrug;
import ca.infoway.messagebuilder.domainvalue.DiagnosisValue;
import ca.infoway.messagebuilder.domainvalue.OrderableDrugForm;
import ca.infoway.messagebuilder.domainvalue.RouteOfAdministration;
import ca.infoway.messagebuilder.domainvalue.SymptomValue;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.pome_mt010090ca.HasCharacteristicBean;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>POME_MT010050CA.ParameterList: Generic Query Parameters</p>
 * 
 * <p>One and only one of Drug Code, Prescribing Indication 
 * Code, or Medication Document ID must be specified.</p>
 * 
 * <p>Root class for query parameters.</p>
 * 
 * <p>Defines the set of parameters that may be used to filter 
 * the query response.</p>
 * 
 * <p>POME_MT010030CA.ParameterList: Drug Query Parameters</p>
 * 
 * <p>Root class for query parameters</p>
 * 
 * <p>Defines the set of parameters that may be used to filter 
 * the query response.</p>
 * 
 * <p>POME_MT010090CA.ParameterList: Drug Query Parameters</p>
 * 
 * <p>At least one of drug code or drug name must be 
 * specified</p>
 * 
 * <p>Root class for query parameters</p>
 * 
 * <p>Defines the set of parameters that may be used to filter 
 * the query response.</p>
 */
@Hl7PartTypeMapping({"POME_MT010030CA.ParameterList","POME_MT010050CA.ParameterList","POME_MT010090CA.ParameterList"})
@Hl7RootType
public class DrugQueryParametersBean extends MessagePartBean {

    private static final long serialVersionUID = 20130614L;
    private CV drugCodeValue = new CVImpl();
    private II medicationDocumentIDValue = new IIImpl();
    private CV medicationDocumentTypeValue = new CVImpl();
    private CV prescribingDiagnosisCodeValue = new CVImpl();
    private CV prescribingSymptomCodeValue = new CVImpl();
    private List<HasCharacteristicBean> drugCharacteristics = new ArrayList<HasCharacteristicBean>();
    private CV drugFormValue = new CVImpl();
    private ST drugManufacturerNameValue = new STImpl();
    private ST drugNameValue = new STImpl();
    private CV drugRouteValue = new CVImpl();


    /**
     * <p>Business Name: DrugCode</p>
     * 
     * <p>Un-merged Business Name: DrugCode</p>
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
     * 
     * <p>Un-merged Business Name: DrugCode</p>
     * 
     * <p>Relationship: POME_MT010030CA.DrugCode.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the requester to retrieve detail information about 
     * a specific drug product.</p>
     * 
     * <p>An identifier for a specific drug product. Types of drugs 
     * identified by drug code include: Manufactured drug, generic 
     * formulation, generic, therapeutic class, etc.</p>
     * 
     * <p>Un-merged Business Name: DrugCode</p>
     * 
     * <p>Relationship: POME_MT010090CA.DrugCode.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the requester to retrieve drugs of certain 
     * abstraction only. These drug abstractions include: 
     * Manufactured drug, generic formulation, generic, therapeutic 
     * class, etc.</p>
     * 
     * <p>An identifier that describes a drug at any level of the 
     * clinical drug hierarchy. The code may describe (point to) a 
     * Manufactured drug, generic drug formulation, generic drug, 
     * therapeutic classification, etc.</p><p>For example, using a 
     * therapeutic class code in the DrugCode parameter would 
     * return a list of all drugs that are within that class. 
     * Sending a drug name in the DrugName parameter would return a 
     * list of all drugs that have that name e.g. sending 
     * acetaminophen would return all of the acetaminophen products 
     * in the drug data base. By including the DoseForm, DoseRoute, 
     * DrugManufacturerName or DrugCharacteristic, the list could 
     * be further constrained.</p>
     */
    @Hl7XmlMapping({"drugCode/value"})
    public ClinicalDrug getDrugCodeValue() {
        return (ClinicalDrug) this.drugCodeValue.getValue();
    }

    /**
     * <p>Business Name: DrugCode</p>
     * 
     * <p>Un-merged Business Name: DrugCode</p>
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
     * 
     * <p>Un-merged Business Name: DrugCode</p>
     * 
     * <p>Relationship: POME_MT010030CA.DrugCode.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the requester to retrieve detail information about 
     * a specific drug product.</p>
     * 
     * <p>An identifier for a specific drug product. Types of drugs 
     * identified by drug code include: Manufactured drug, generic 
     * formulation, generic, therapeutic class, etc.</p>
     * 
     * <p>Un-merged Business Name: DrugCode</p>
     * 
     * <p>Relationship: POME_MT010090CA.DrugCode.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the requester to retrieve drugs of certain 
     * abstraction only. These drug abstractions include: 
     * Manufactured drug, generic formulation, generic, therapeutic 
     * class, etc.</p>
     * 
     * <p>An identifier that describes a drug at any level of the 
     * clinical drug hierarchy. The code may describe (point to) a 
     * Manufactured drug, generic drug formulation, generic drug, 
     * therapeutic classification, etc.</p><p>For example, using a 
     * therapeutic class code in the DrugCode parameter would 
     * return a list of all drugs that are within that class. 
     * Sending a drug name in the DrugName parameter would return a 
     * list of all drugs that have that name e.g. sending 
     * acetaminophen would return all of the acetaminophen products 
     * in the drug data base. By including the DoseForm, DoseRoute, 
     * DrugManufacturerName or DrugCharacteristic, the list could 
     * be further constrained.</p>
     */
    public void setDrugCodeValue(ClinicalDrug drugCodeValue) {
        this.drugCodeValue.setValue(drugCodeValue);
    }


    /**
     * <p>Business Name: MedicationDocumentID</p>
     * 
     * <p>Un-merged Business Name: MedicationDocumentID</p>
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
     * <p>Business Name: MedicationDocumentID</p>
     * 
     * <p>Un-merged Business Name: MedicationDocumentID</p>
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
     * <p>Business Name: MedicationDocumentType</p>
     * 
     * <p>Un-merged Business Name: MedicationDocumentType</p>
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
     * <p>Business Name: MedicationDocumentType</p>
     * 
     * <p>Un-merged Business Name: MedicationDocumentType</p>
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
     * <p>Business Name: PrescribingIndicationDiagnosisCode</p>
     * 
     * <p>Un-merged Business Name: 
     * PrescribingIndicationDiagnosisCode</p>
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
     * <p>Business Name: PrescribingIndicationDiagnosisCode</p>
     * 
     * <p>Un-merged Business Name: 
     * PrescribingIndicationDiagnosisCode</p>
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
     * <p>Business Name: PrescribingIndicationSymptomCode</p>
     * 
     * <p>Un-merged Business Name: PrescribingIndicationSymptomCode</p>
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
     * <p>Business Name: PrescribingIndicationSymptomCode</p>
     * 
     * <p>Un-merged Business Name: PrescribingIndicationSymptomCode</p>
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


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * POME_MT010090CA.ParameterList.drugCharacteristics</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-5)</p>
     */
    @Hl7XmlMapping({"drugCharacteristics"})
    public List<HasCharacteristicBean> getDrugCharacteristics() {
        return this.drugCharacteristics;
    }


    /**
     * <p>Business Name: OrderableDrugForm</p>
     * 
     * <p>Un-merged Business Name: OrderableDrugForm</p>
     * 
     * <p>Relationship: POME_MT010090CA.DrugForm.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Useful filter for searching drugs. Allows the requester 
     * to specify the drug form of interest for the retrieval.</p>
     * 
     * <p>Indicates the form in which the drug product must is 
     * manufactured.</p>
     */
    @Hl7XmlMapping({"drugForm/value"})
    public OrderableDrugForm getDrugFormValue() {
        return (OrderableDrugForm) this.drugFormValue.getValue();
    }

    /**
     * <p>Business Name: OrderableDrugForm</p>
     * 
     * <p>Un-merged Business Name: OrderableDrugForm</p>
     * 
     * <p>Relationship: POME_MT010090CA.DrugForm.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Useful filter for searching drugs. Allows the requester 
     * to specify the drug form of interest for the retrieval.</p>
     * 
     * <p>Indicates the form in which the drug product must is 
     * manufactured.</p>
     */
    public void setDrugFormValue(OrderableDrugForm drugFormValue) {
        this.drugFormValue.setValue(drugFormValue);
    }


    /**
     * <p>Business Name: DrugManufacturerName</p>
     * 
     * <p>Un-merged Business Name: DrugManufacturerName</p>
     * 
     * <p>Relationship: POME_MT010090CA.DrugManufacturerName.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the retrieval of drug products based on the 
     * manufacturer.</p>
     * 
     * <p>Manufacturer name search will be 'Starts with...' type of 
     * a search.</p>
     * 
     * <p>The name of a drug manufacturer.</p>
     */
    @Hl7XmlMapping({"drugManufacturerName/value"})
    public String getDrugManufacturerNameValue() {
        return this.drugManufacturerNameValue.getValue();
    }

    /**
     * <p>Business Name: DrugManufacturerName</p>
     * 
     * <p>Un-merged Business Name: DrugManufacturerName</p>
     * 
     * <p>Relationship: POME_MT010090CA.DrugManufacturerName.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the retrieval of drug products based on the 
     * manufacturer.</p>
     * 
     * <p>Manufacturer name search will be 'Starts with...' type of 
     * a search.</p>
     * 
     * <p>The name of a drug manufacturer.</p>
     */
    public void setDrugManufacturerNameValue(String drugManufacturerNameValue) {
        this.drugManufacturerNameValue.setValue(drugManufacturerNameValue);
    }


    /**
     * <p>Business Name: DrugName</p>
     * 
     * <p>Un-merged Business Name: DrugName</p>
     * 
     * <p>Relationship: POME_MT010090CA.DrugName.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Name may be the only identification of a drug known by 
     * many prescribers.</p>
     * 
     * <p>The name assigned to a drug.</p>
     */
    @Hl7XmlMapping({"drugName/value"})
    public String getDrugNameValue() {
        return this.drugNameValue.getValue();
    }

    /**
     * <p>Business Name: DrugName</p>
     * 
     * <p>Un-merged Business Name: DrugName</p>
     * 
     * <p>Relationship: POME_MT010090CA.DrugName.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Name may be the only identification of a drug known by 
     * many prescribers.</p>
     * 
     * <p>The name assigned to a drug.</p>
     */
    public void setDrugNameValue(String drugNameValue) {
        this.drugNameValue.setValue(drugNameValue);
    }


    /**
     * <p>Business Name: DrugRouteCode</p>
     * 
     * <p>Un-merged Business Name: DrugRouteCode</p>
     * 
     * <p>Relationship: POME_MT010090CA.DrugRoute.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows limiting the returned list of drugs to a single 
     * route.</p>
     * 
     * <p>A filter based on how the drug should be introduced into 
     * the patient's body (e.g. Oral, topical, etc.)</p>
     */
    @Hl7XmlMapping({"drugRoute/value"})
    public RouteOfAdministration getDrugRouteValue() {
        return (RouteOfAdministration) this.drugRouteValue.getValue();
    }

    /**
     * <p>Business Name: DrugRouteCode</p>
     * 
     * <p>Un-merged Business Name: DrugRouteCode</p>
     * 
     * <p>Relationship: POME_MT010090CA.DrugRoute.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows limiting the returned list of drugs to a single 
     * route.</p>
     * 
     * <p>A filter based on how the drug should be introduced into 
     * the patient's body (e.g. Oral, topical, etc.)</p>
     */
    public void setDrugRouteValue(RouteOfAdministration drugRouteValue) {
        this.drugRouteValue.setValue(drugRouteValue);
    }

}
