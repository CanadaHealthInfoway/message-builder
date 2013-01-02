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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.ClinicalDrug;
import ca.infoway.messagebuilder.domainvalue.MedicationGeneralizationRoleType;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: GroupedWithin</p>
 * 
 * <p>POME_MT010040CA.SpecializedKind: grouped within</p>
 * 
 * <p>Indicates the location of a medication in a particular 
 * abstract hierarchy. For example, what generic, generic 
 * formulation, or therapeutic class does the medication fall 
 * into.</p>
 * 
 * <p>Shows relationship between GenericDrugproduct, Generic 
 * FormulationDrugProduct and 
 * ManufacturedDrugProduct</p><p>ZPC.7(query will reference the 
 * generic equivalency relationship in defining the boolean 
 * query parameter)</p>
 * 
 * <p>Shows relationship between GenericDrugproduct, Generic 
 * FormulationDrugProduct and 
 * ManufacturedDrugProduct</p><p>ZPC.7(query will reference the 
 * generic equivalency relationship in defining the boolean 
 * query parameter)</p>
 * 
 * <p>Exposes the drug hierarchy, allowing drill-down when 
 * prescribing and dispensing. Also indicates possibilities for 
 * substitution and can be important for detecting interactions 
 * such as allergies or duplicate therapy between 
 * closely-related drugs.</p>
 * 
 * <p>POME_MT010100CA.SpecializedKind: grouped within</p>
 * 
 * <p>Indicates the location of a medication in a particular 
 * abstract hierarchy. For example, what generic, generic 
 * formulation, or therapeutic class does the medication fall 
 * into.</p>
 * 
 * <p>Shows relationship between GenericDrugproduct, Generic 
 * FormulationDrugProduct and 
 * ManufacturedDrugProduct</p><p>ZPC.7(query will reference the 
 * generic equivalency relationship in defining the boolean 
 * query parameter)</p>
 * 
 * <p>Shows relationship between GenericDrugproduct, Generic 
 * FormulationDrugProduct and 
 * ManufacturedDrugProduct</p><p>ZPC.7(query will reference the 
 * generic equivalency relationship in defining the boolean 
 * query parameter)</p>
 * 
 * <p>Exposes the drug hierarchy, allowing drill-down when 
 * prescribing and dispensing. Also indicates possibilities for 
 * substitution and can be important for detecting interactions 
 * such as allergies or duplicate therapy between 
 * closely-related drugs.</p>
 */
@Hl7PartTypeMapping({"POME_MT010040CA.SpecializedKind","POME_MT010100CA.SpecializedKind"})
public class GroupedWithinBean extends MessagePartBean {

    private static final long serialVersionUID = 20121204L;
    private CV code = new CVImpl();
    private CV generalizedMedicineClassCode = new CVImpl();
    private ST generalizedMedicineClassName = new STImpl();


    /**
     * <p>Business Name: DrugCategoryCode</p>
     * 
     * <p>Un-merged Business Name: DrugCategoryCode</p>
     * 
     * <p>Relationship: POME_MT010040CA.SpecializedKind.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>A coded value denoting a specific level in the 
     * hierarchical definition of drugs.</p>
     * 
     * <p>Describes the relationship between two levels of drug 
     * products (e.g. Drug A is the generic for Drug B)</p>
     * 
     * <p>Un-merged Business Name: DrugCategoryCode</p>
     * 
     * <p>Relationship: POME_MT010100CA.SpecializedKind.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>A coded value denoting a specific level in the 
     * hierarchical definition of drugs.</p>
     * 
     * <p>Describes the relationship between two levels of drug 
     * products (e.g. Drug A is the generic for Drug B)</p>
     */
    @Hl7XmlMapping({"code"})
    public MedicationGeneralizationRoleType getCode() {
        return (MedicationGeneralizationRoleType) this.code.getValue();
    }

    /**
     * <p>Business Name: DrugCategoryCode</p>
     * 
     * <p>Un-merged Business Name: DrugCategoryCode</p>
     * 
     * <p>Relationship: POME_MT010040CA.SpecializedKind.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>A coded value denoting a specific level in the 
     * hierarchical definition of drugs.</p>
     * 
     * <p>Describes the relationship between two levels of drug 
     * products (e.g. Drug A is the generic for Drug B)</p>
     * 
     * <p>Un-merged Business Name: DrugCategoryCode</p>
     * 
     * <p>Relationship: POME_MT010100CA.SpecializedKind.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>A coded value denoting a specific level in the 
     * hierarchical definition of drugs.</p>
     * 
     * <p>Describes the relationship between two levels of drug 
     * products (e.g. Drug A is the generic for Drug B)</p>
     */
    public void setCode(MedicationGeneralizationRoleType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: DrugCode</p>
     * 
     * <p>Un-merged Business Name: DrugCode</p>
     * 
     * <p>Relationship: POME_MT010040CA.MedicineClass.code</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>A code that uniquely identifiers a drug within a specific 
     * drug identification scheme.</p>
     * 
     * <p>HICL</p><p>Therapeutic Class</p><p>Therapeutic Sub 
     * Classification</p><p>DrugProduct.activeIngredientId</p><p>DrugProduct.ActiveIngredientGroupNumber</p><p>DrugProduct.StandardProductId 
     * (Mnemonic)</p><p>DrugProduct.StandardIDType(Code System)</p>
     * 
     * <p>HICL</p><p>Therapeutic Class</p><p>Therapeutic Sub 
     * Classification</p><p>DrugProduct.activeIngredientId</p><p>DrugProduct.ActiveIngredientGroupNumber</p><p>DrugProduct.StandardProductId 
     * (Mnemonic)</p><p>DrugProduct.StandardIDType(Code System)</p>
     * 
     * <p>HICL</p><p>Therapeutic Class</p><p>Therapeutic Sub 
     * Classification</p><p>DrugProduct.activeIngredientId</p><p>DrugProduct.ActiveIngredientGroupNumber</p><p>DrugProduct.StandardProductId 
     * (Mnemonic)</p><p>DrugProduct.StandardIDType(Code System)</p>
     * 
     * <p>HICL</p><p>Therapeutic Class</p><p>Therapeutic Sub 
     * Classification</p><p>DrugProduct.activeIngredientId</p><p>DrugProduct.ActiveIngredientGroupNumber</p><p>DrugProduct.StandardProductId 
     * (Mnemonic)</p><p>DrugProduct.StandardIDType(Code System)</p>
     * 
     * <p>HICL</p><p>Therapeutic Class</p><p>Therapeutic Sub 
     * Classification</p><p>DrugProduct.activeIngredientId</p><p>DrugProduct.ActiveIngredientGroupNumber</p><p>DrugProduct.StandardProductId 
     * (Mnemonic)</p><p>DrugProduct.StandardIDType(Code System)</p>
     * 
     * <p>HICL</p><p>Therapeutic Class</p><p>Therapeutic Sub 
     * Classification</p><p>DrugProduct.activeIngredientId</p><p>DrugProduct.ActiveIngredientGroupNumber</p><p>DrugProduct.StandardProductId 
     * (Mnemonic)</p><p>DrugProduct.StandardIDType(Code System)</p>
     * 
     * <p>HICL</p><p>Therapeutic Class</p><p>Therapeutic Sub 
     * Classification</p><p>DrugProduct.activeIngredientId</p><p>DrugProduct.ActiveIngredientGroupNumber</p><p>DrugProduct.StandardProductId 
     * (Mnemonic)</p><p>DrugProduct.StandardIDType(Code System)</p>
     * 
     * <p>Used to uniquely identify a particular drug product when 
     * prescribing/dispensing at a higher level of abstraction 
     * (e.g. generic drug, generic formulation).</p><p>This 
     * attribute is marked as &quot;populated&quot; as drug code 
     * should be available in most cases.</p>
     * 
     * <p>Used to uniquely identify a particular drug product when 
     * prescribing/dispensing at a higher level of abstraction 
     * (e.g. generic drug, generic formulation).</p><p>This 
     * attribute is marked as &quot;populated&quot; as drug code 
     * should be available in most cases.</p>
     * 
     * <p>Un-merged Business Name: DrugCode</p>
     * 
     * <p>Relationship: POME_MT010100CA.MedicineClass.code</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>An identifier for a drug at a higher level of 
     * abstraction.</p>
     * 
     * <p>HICL</p><p>Therapeutic Class</p><p>Therapeutic Sub 
     * Classification</p><p>DrugProduct.activeIngredientId</p><p>DrugProduct.ActiveIngredientGroupNumber</p><p>DrugProduct.StandardProductId 
     * (Mnemonic)</p><p>DrugProduct.StandardIDType(Code System)</p>
     * 
     * <p>HICL</p><p>Therapeutic Class</p><p>Therapeutic Sub 
     * Classification</p><p>DrugProduct.activeIngredientId</p><p>DrugProduct.ActiveIngredientGroupNumber</p><p>DrugProduct.StandardProductId 
     * (Mnemonic)</p><p>DrugProduct.StandardIDType(Code System)</p>
     * 
     * <p>HICL</p><p>Therapeutic Class</p><p>Therapeutic Sub 
     * Classification</p><p>DrugProduct.activeIngredientId</p><p>DrugProduct.ActiveIngredientGroupNumber</p><p>DrugProduct.StandardProductId 
     * (Mnemonic)</p><p>DrugProduct.StandardIDType(Code System)</p>
     * 
     * <p>HICL</p><p>Therapeutic Class</p><p>Therapeutic Sub 
     * Classification</p><p>DrugProduct.activeIngredientId</p><p>DrugProduct.ActiveIngredientGroupNumber</p><p>DrugProduct.StandardProductId 
     * (Mnemonic)</p><p>DrugProduct.StandardIDType(Code System)</p>
     * 
     * <p>HICL</p><p>Therapeutic Class</p><p>Therapeutic Sub 
     * Classification</p><p>DrugProduct.activeIngredientId</p><p>DrugProduct.ActiveIngredientGroupNumber</p><p>DrugProduct.StandardProductId 
     * (Mnemonic)</p><p>DrugProduct.StandardIDType(Code System)</p>
     * 
     * <p>HICL</p><p>Therapeutic Class</p><p>Therapeutic Sub 
     * Classification</p><p>DrugProduct.activeIngredientId</p><p>DrugProduct.ActiveIngredientGroupNumber</p><p>DrugProduct.StandardProductId 
     * (Mnemonic)</p><p>DrugProduct.StandardIDType(Code System)</p>
     * 
     * <p>HICL</p><p>Therapeutic Class</p><p>Therapeutic Sub 
     * Classification</p><p>DrugProduct.activeIngredientId</p><p>DrugProduct.ActiveIngredientGroupNumber</p><p>DrugProduct.StandardProductId 
     * (Mnemonic)</p><p>DrugProduct.StandardIDType(Code System)</p>
     * 
     * <p>Used to uniquely identify a particular drug product when 
     * prescribing/dispensing at a higher level of abstraction 
     * (e.g. generic drug, generic formulation).</p><p>This 
     * attribute is marked as &quot;populated&quot; as a drug code 
     * should be available in most cases.</p>
     * 
     * <p>Used to uniquely identify a particular drug product when 
     * prescribing/dispensing at a higher level of abstraction 
     * (e.g. generic drug, generic formulation).</p><p>This 
     * attribute is marked as &quot;populated&quot; as a drug code 
     * should be available in most cases.</p>
     */
    @Hl7XmlMapping({"generalizedMedicineClass/code"})
    public ClinicalDrug getGeneralizedMedicineClassCode() {
        return (ClinicalDrug) this.generalizedMedicineClassCode.getValue();
    }

    /**
     * <p>Business Name: DrugCode</p>
     * 
     * <p>Un-merged Business Name: DrugCode</p>
     * 
     * <p>Relationship: POME_MT010040CA.MedicineClass.code</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>A code that uniquely identifiers a drug within a specific 
     * drug identification scheme.</p>
     * 
     * <p>HICL</p><p>Therapeutic Class</p><p>Therapeutic Sub 
     * Classification</p><p>DrugProduct.activeIngredientId</p><p>DrugProduct.ActiveIngredientGroupNumber</p><p>DrugProduct.StandardProductId 
     * (Mnemonic)</p><p>DrugProduct.StandardIDType(Code System)</p>
     * 
     * <p>HICL</p><p>Therapeutic Class</p><p>Therapeutic Sub 
     * Classification</p><p>DrugProduct.activeIngredientId</p><p>DrugProduct.ActiveIngredientGroupNumber</p><p>DrugProduct.StandardProductId 
     * (Mnemonic)</p><p>DrugProduct.StandardIDType(Code System)</p>
     * 
     * <p>HICL</p><p>Therapeutic Class</p><p>Therapeutic Sub 
     * Classification</p><p>DrugProduct.activeIngredientId</p><p>DrugProduct.ActiveIngredientGroupNumber</p><p>DrugProduct.StandardProductId 
     * (Mnemonic)</p><p>DrugProduct.StandardIDType(Code System)</p>
     * 
     * <p>HICL</p><p>Therapeutic Class</p><p>Therapeutic Sub 
     * Classification</p><p>DrugProduct.activeIngredientId</p><p>DrugProduct.ActiveIngredientGroupNumber</p><p>DrugProduct.StandardProductId 
     * (Mnemonic)</p><p>DrugProduct.StandardIDType(Code System)</p>
     * 
     * <p>HICL</p><p>Therapeutic Class</p><p>Therapeutic Sub 
     * Classification</p><p>DrugProduct.activeIngredientId</p><p>DrugProduct.ActiveIngredientGroupNumber</p><p>DrugProduct.StandardProductId 
     * (Mnemonic)</p><p>DrugProduct.StandardIDType(Code System)</p>
     * 
     * <p>HICL</p><p>Therapeutic Class</p><p>Therapeutic Sub 
     * Classification</p><p>DrugProduct.activeIngredientId</p><p>DrugProduct.ActiveIngredientGroupNumber</p><p>DrugProduct.StandardProductId 
     * (Mnemonic)</p><p>DrugProduct.StandardIDType(Code System)</p>
     * 
     * <p>HICL</p><p>Therapeutic Class</p><p>Therapeutic Sub 
     * Classification</p><p>DrugProduct.activeIngredientId</p><p>DrugProduct.ActiveIngredientGroupNumber</p><p>DrugProduct.StandardProductId 
     * (Mnemonic)</p><p>DrugProduct.StandardIDType(Code System)</p>
     * 
     * <p>Used to uniquely identify a particular drug product when 
     * prescribing/dispensing at a higher level of abstraction 
     * (e.g. generic drug, generic formulation).</p><p>This 
     * attribute is marked as &quot;populated&quot; as drug code 
     * should be available in most cases.</p>
     * 
     * <p>Used to uniquely identify a particular drug product when 
     * prescribing/dispensing at a higher level of abstraction 
     * (e.g. generic drug, generic formulation).</p><p>This 
     * attribute is marked as &quot;populated&quot; as drug code 
     * should be available in most cases.</p>
     * 
     * <p>Un-merged Business Name: DrugCode</p>
     * 
     * <p>Relationship: POME_MT010100CA.MedicineClass.code</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>An identifier for a drug at a higher level of 
     * abstraction.</p>
     * 
     * <p>HICL</p><p>Therapeutic Class</p><p>Therapeutic Sub 
     * Classification</p><p>DrugProduct.activeIngredientId</p><p>DrugProduct.ActiveIngredientGroupNumber</p><p>DrugProduct.StandardProductId 
     * (Mnemonic)</p><p>DrugProduct.StandardIDType(Code System)</p>
     * 
     * <p>HICL</p><p>Therapeutic Class</p><p>Therapeutic Sub 
     * Classification</p><p>DrugProduct.activeIngredientId</p><p>DrugProduct.ActiveIngredientGroupNumber</p><p>DrugProduct.StandardProductId 
     * (Mnemonic)</p><p>DrugProduct.StandardIDType(Code System)</p>
     * 
     * <p>HICL</p><p>Therapeutic Class</p><p>Therapeutic Sub 
     * Classification</p><p>DrugProduct.activeIngredientId</p><p>DrugProduct.ActiveIngredientGroupNumber</p><p>DrugProduct.StandardProductId 
     * (Mnemonic)</p><p>DrugProduct.StandardIDType(Code System)</p>
     * 
     * <p>HICL</p><p>Therapeutic Class</p><p>Therapeutic Sub 
     * Classification</p><p>DrugProduct.activeIngredientId</p><p>DrugProduct.ActiveIngredientGroupNumber</p><p>DrugProduct.StandardProductId 
     * (Mnemonic)</p><p>DrugProduct.StandardIDType(Code System)</p>
     * 
     * <p>HICL</p><p>Therapeutic Class</p><p>Therapeutic Sub 
     * Classification</p><p>DrugProduct.activeIngredientId</p><p>DrugProduct.ActiveIngredientGroupNumber</p><p>DrugProduct.StandardProductId 
     * (Mnemonic)</p><p>DrugProduct.StandardIDType(Code System)</p>
     * 
     * <p>HICL</p><p>Therapeutic Class</p><p>Therapeutic Sub 
     * Classification</p><p>DrugProduct.activeIngredientId</p><p>DrugProduct.ActiveIngredientGroupNumber</p><p>DrugProduct.StandardProductId 
     * (Mnemonic)</p><p>DrugProduct.StandardIDType(Code System)</p>
     * 
     * <p>HICL</p><p>Therapeutic Class</p><p>Therapeutic Sub 
     * Classification</p><p>DrugProduct.activeIngredientId</p><p>DrugProduct.ActiveIngredientGroupNumber</p><p>DrugProduct.StandardProductId 
     * (Mnemonic)</p><p>DrugProduct.StandardIDType(Code System)</p>
     * 
     * <p>Used to uniquely identify a particular drug product when 
     * prescribing/dispensing at a higher level of abstraction 
     * (e.g. generic drug, generic formulation).</p><p>This 
     * attribute is marked as &quot;populated&quot; as a drug code 
     * should be available in most cases.</p>
     * 
     * <p>Used to uniquely identify a particular drug product when 
     * prescribing/dispensing at a higher level of abstraction 
     * (e.g. generic drug, generic formulation).</p><p>This 
     * attribute is marked as &quot;populated&quot; as a drug code 
     * should be available in most cases.</p>
     */
    public void setGeneralizedMedicineClassCode(ClinicalDrug generalizedMedicineClassCode) {
        this.generalizedMedicineClassCode.setValue(generalizedMedicineClassCode);
    }


    /**
     * <p>Business Name: DrugName</p>
     * 
     * <p>Un-merged Business Name: DrugName</p>
     * 
     * <p>Relationship: POME_MT010040CA.MedicineClass.name</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>The name assigned to a drug within a specific drug 
     * identification scheme.</p>
     * 
     * <p>Generic Name</p>
     * 
     * <p>To display in dropdowns and for local 
     * searching.</p><p>This attribute is marked as 
     * &quot;populated&quot; as a drug name should be available in 
     * most cases.</p>
     * 
     * <p>To display in dropdowns and for local 
     * searching.</p><p>This attribute is marked as 
     * &quot;populated&quot; as a drug name should be available in 
     * most cases.</p>
     * 
     * <p>Un-merged Business Name: DrugName</p>
     * 
     * <p>Relationship: POME_MT010100CA.MedicineClass.name</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>The name assigned to the drug at the higher level of 
     * abstraction.</p>
     * 
     * <p>Generic Name</p>
     * 
     * <p>To display in dropdowns and for local 
     * searching.</p><p>This attribute is marked as 
     * &quot;populated&quot; as drug name should be available in 
     * most cases.</p>
     * 
     * <p>To display in dropdowns and for local 
     * searching.</p><p>This attribute is marked as 
     * &quot;populated&quot; as drug name should be available in 
     * most cases.</p>
     */
    @Hl7XmlMapping({"generalizedMedicineClass/name"})
    public String getGeneralizedMedicineClassName() {
        return this.generalizedMedicineClassName.getValue();
    }

    /**
     * <p>Business Name: DrugName</p>
     * 
     * <p>Un-merged Business Name: DrugName</p>
     * 
     * <p>Relationship: POME_MT010040CA.MedicineClass.name</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>The name assigned to a drug within a specific drug 
     * identification scheme.</p>
     * 
     * <p>Generic Name</p>
     * 
     * <p>To display in dropdowns and for local 
     * searching.</p><p>This attribute is marked as 
     * &quot;populated&quot; as a drug name should be available in 
     * most cases.</p>
     * 
     * <p>To display in dropdowns and for local 
     * searching.</p><p>This attribute is marked as 
     * &quot;populated&quot; as a drug name should be available in 
     * most cases.</p>
     * 
     * <p>Un-merged Business Name: DrugName</p>
     * 
     * <p>Relationship: POME_MT010100CA.MedicineClass.name</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>The name assigned to the drug at the higher level of 
     * abstraction.</p>
     * 
     * <p>Generic Name</p>
     * 
     * <p>To display in dropdowns and for local 
     * searching.</p><p>This attribute is marked as 
     * &quot;populated&quot; as drug name should be available in 
     * most cases.</p>
     * 
     * <p>To display in dropdowns and for local 
     * searching.</p><p>This attribute is marked as 
     * &quot;populated&quot; as drug name should be available in 
     * most cases.</p>
     */
    public void setGeneralizedMedicineClassName(String generalizedMedicineClassName) {
        this.generalizedMedicineClassName.setValue(generalizedMedicineClassName);
    }

}
