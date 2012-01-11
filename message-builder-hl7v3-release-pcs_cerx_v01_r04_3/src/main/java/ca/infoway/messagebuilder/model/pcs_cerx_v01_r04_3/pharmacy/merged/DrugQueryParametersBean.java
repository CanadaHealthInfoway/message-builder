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



@Hl7PartTypeMapping({"POME_MT010030CA.ParameterList","POME_MT010050CA.ParameterList","POME_MT010090CA.ParameterList"})
@Hl7RootType
public class DrugQueryParametersBean extends MessagePartBean {

    private static final long serialVersionUID = 20111117L;
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
     * <p>DrugCode</p>
     * 
     * <p>B:Drug Code</p>
     */
    @Hl7XmlMapping({"drugCode/value"})
    public ClinicalDrug getDrugCodeValue() {
        return (ClinicalDrug) this.drugCodeValue.getValue();
    }
    public void setDrugCodeValue(ClinicalDrug drugCodeValue) {
        this.drugCodeValue.setValue(drugCodeValue);
    }


    /**
     * <p>MedicationDocumentID</p>
     * 
     * <p>E:Medication Document ID</p>
     */
    @Hl7XmlMapping({"medicationDocumentID/value"})
    public Identifier getMedicationDocumentIDValue() {
        return this.medicationDocumentIDValue.getValue();
    }
    public void setMedicationDocumentIDValue(Identifier medicationDocumentIDValue) {
        this.medicationDocumentIDValue.setValue(medicationDocumentIDValue);
    }


    /**
     * <p>MedicationDocumentType</p>
     * 
     * <p>D:Medication Document Type</p>
     */
    @Hl7XmlMapping({"medicationDocumentType/value"})
    public ActMedicationDocumentCode getMedicationDocumentTypeValue() {
        return (ActMedicationDocumentCode) this.medicationDocumentTypeValue.getValue();
    }
    public void setMedicationDocumentTypeValue(ActMedicationDocumentCode medicationDocumentTypeValue) {
        this.medicationDocumentTypeValue.setValue(medicationDocumentTypeValue);
    }


    /**
     * <p>PrescribingIndicationDiagnosisCode</p>
     * 
     * <p>C:Prescribing Indication Diagnosis Code</p>
     */
    @Hl7XmlMapping({"prescribingDiagnosisCode/value"})
    public DiagnosisValue getPrescribingDiagnosisCodeValue() {
        return (DiagnosisValue) this.prescribingDiagnosisCodeValue.getValue();
    }
    public void setPrescribingDiagnosisCodeValue(DiagnosisValue prescribingDiagnosisCodeValue) {
        this.prescribingDiagnosisCodeValue.setValue(prescribingDiagnosisCodeValue);
    }


    /**
     * <p>PrescribingIndicationSymptomCode</p>
     * 
     * <p>Prescribing Indication Symptom Code</p>
     */
    @Hl7XmlMapping({"prescribingSymptomCode/value"})
    public SymptomValue getPrescribingSymptomCodeValue() {
        return (SymptomValue) this.prescribingSymptomCodeValue.getValue();
    }
    public void setPrescribingSymptomCodeValue(SymptomValue prescribingSymptomCodeValue) {
        this.prescribingSymptomCodeValue.setValue(prescribingSymptomCodeValue);
    }


    @Hl7XmlMapping({"drugCharacteristics"})
    public List<HasCharacteristicBean> getDrugCharacteristics() {
        return this.drugCharacteristics;
    }


    /**
     * <p>OrderableDrugForm</p>
     * 
     * <p>D:Orderable Drug Form</p>
     */
    @Hl7XmlMapping({"drugForm/value"})
    public OrderableDrugForm getDrugFormValue() {
        return (OrderableDrugForm) this.drugFormValue.getValue();
    }
    public void setDrugFormValue(OrderableDrugForm drugFormValue) {
        this.drugFormValue.setValue(drugFormValue);
    }


    /**
     * <p>DrugManufacturerName</p>
     * 
     * <p>F:Drug Manufacturer Name</p>
     */
    @Hl7XmlMapping({"drugManufacturerName/value"})
    public String getDrugManufacturerNameValue() {
        return this.drugManufacturerNameValue.getValue();
    }
    public void setDrugManufacturerNameValue(String drugManufacturerNameValue) {
        this.drugManufacturerNameValue.setValue(drugManufacturerNameValue);
    }


    /**
     * <p>DrugName</p>
     * 
     * <p>C:Drug Name</p>
     */
    @Hl7XmlMapping({"drugName/value"})
    public String getDrugNameValue() {
        return this.drugNameValue.getValue();
    }
    public void setDrugNameValue(String drugNameValue) {
        this.drugNameValue.setValue(drugNameValue);
    }


    /**
     * <p>DrugRouteCode</p>
     * 
     * <p>E:Drug Route Code</p>
     */
    @Hl7XmlMapping({"drugRoute/value"})
    public RouteOfAdministration getDrugRouteValue() {
        return (RouteOfAdministration) this.drugRouteValue.getValue();
    }
    public void setDrugRouteValue(RouteOfAdministration drugRouteValue) {
        this.drugRouteValue.setValue(drugRouteValue);
    }

}
