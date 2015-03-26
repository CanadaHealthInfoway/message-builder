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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.pharmacy.pome_mt010090on;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.ClinicalDrug;
import ca.infoway.messagebuilder.domainvalue.OrderableDrugForm;
import ca.infoway.messagebuilder.domainvalue.RouteOfAdministration;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>Business Name: Drug Query Parameters</p>
 * 
 * <p>At least one of drug code or drug name must be 
 * specified</p>
 * 
 * <p>Root class for query parameters</p>
 * 
 * <p>Defines the set of parameters that may be used to filter 
 * the query response.</p>
 */
@Hl7PartTypeMapping({"POME_MT010090ON.ParameterList"})
@Hl7RootType
public class DrugQueryParametersBean extends MessagePartBean {

    private static final long serialVersionUID = 20150326L;
    private List<HasCharacteristicBean> drugCharacteristics = new ArrayList<HasCharacteristicBean>();
    private CV drugCodeValue = new CVImpl();
    private CV drugFormValue = new CVImpl();
    private ST drugManufacturerNameValue = new STImpl();
    private ST drugNameValue = new STImpl();
    private CV drugRouteValue = new CVImpl();


    /**
     * <p>Relationship: 
     * POME_MT010090ON.ParameterList.drugCharacteristics</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-5)</p>
     */
    @Hl7XmlMapping({"drugCharacteristics"})
    public List<HasCharacteristicBean> getDrugCharacteristics() {
        return this.drugCharacteristics;
    }


    /**
     * <p>Business Name: B:Drug Code</p>
     * 
     * <p>Relationship: POME_MT010090ON.DrugCode.value</p>
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
     * <p>Business Name: B:Drug Code</p>
     * 
     * <p>Relationship: POME_MT010090ON.DrugCode.value</p>
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
     * <p>Business Name: D:Orderable Drug Form</p>
     * 
     * <p>Relationship: POME_MT010090ON.DrugForm.value</p>
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
     * <p>Business Name: D:Orderable Drug Form</p>
     * 
     * <p>Relationship: POME_MT010090ON.DrugForm.value</p>
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
     * <p>Business Name: F:Drug Manufacturer Name</p>
     * 
     * <p>Relationship: POME_MT010090ON.DrugManufacturerName.value</p>
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
     * <p>Business Name: F:Drug Manufacturer Name</p>
     * 
     * <p>Relationship: POME_MT010090ON.DrugManufacturerName.value</p>
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
     * <p>Business Name: C:Drug Name</p>
     * 
     * <p>Relationship: POME_MT010090ON.DrugName.value</p>
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
     * <p>Business Name: C:Drug Name</p>
     * 
     * <p>Relationship: POME_MT010090ON.DrugName.value</p>
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
     * <p>Business Name: E:Drug Route Code</p>
     * 
     * <p>Relationship: POME_MT010090ON.DrugRoute.value</p>
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
     * <p>Business Name: E:Drug Route Code</p>
     * 
     * <p>Relationship: POME_MT010090ON.DrugRoute.value</p>
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
