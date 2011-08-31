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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pharmacy.merged;

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
 * <p>GroupedWithin</p>
 * 
 * <p>POME_MT010040CA.SpecializedKind: grouped within</p>
 * 
 * <p><p>Indicates the location of a medication in a particular 
 * abstract hierarchy. For example, what generic, generic 
 * formulation, or therapeutic class does the medication fall 
 * into.</p></p>
 * 
 * <p><p>Exposes the drug hierarchy, allowing drill-down when 
 * prescribing and dispensing. Also indicates possibilities for 
 * substitution and can be important for detecting interactions 
 * such as allergies or duplicate therapy between 
 * closely-related drugs.</p></p>
 * 
 * <p>POME_MT010100CA.SpecializedKind: grouped within</p>
 * 
 * <p><p>Indicates the location of a medication in a particular 
 * abstract hierarchy. For example, what generic, generic 
 * formulation, or therapeutic class does the medication fall 
 * into.</p></p>
 * 
 * <p><p>Exposes the drug hierarchy, allowing drill-down when 
 * prescribing and dispensing. Also indicates possibilities for 
 * substitution and can be important for detecting interactions 
 * such as allergies or duplicate therapy between 
 * closely-related drugs.</p></p>
 */
@Hl7PartTypeMapping({"POME_MT010040CA.SpecializedKind","POME_MT010100CA.SpecializedKind"})
public class GroupedWithinBean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private CV drugCategoryCode = new CVImpl();
    private CV drugCode = new CVImpl();
    private ST drugName = new STImpl();


    /**
     * <p>DrugCategoryCode</p>
     * 
     * <p>Drug Category Code</p>
     * 
     * <p><p>A coded value denoting a specific level in the 
     * hierarchical definition of drugs.</p></p>
     * 
     * <p><p>Describes the relationship between two levels of drug 
     * products (e.g. Drug A is the generic for Drug B)</p></p>
     */
    @Hl7XmlMapping({"code"})
    public MedicationGeneralizationRoleType getDrugCategoryCode() {
        return (MedicationGeneralizationRoleType) this.drugCategoryCode.getValue();
    }
    public void setDrugCategoryCode(MedicationGeneralizationRoleType drugCategoryCode) {
        this.drugCategoryCode.setValue(drugCategoryCode);
    }


    /**
     * <p>DrugCode</p>
     * 
     * <p>Drug Code</p>
     * 
     * <p><p>A code that uniquely identifiers a drug within a 
     * specific drug identification scheme.</p></p>
     * 
     * <p><p>Used to uniquely identify a particular drug product 
     * when prescribing/dispensing at a higher level of abstraction 
     * (e.g. generic drug, generic formulation).</p><p>This 
     * attribute is marked as &quot;populated&quot; as drug code 
     * should be available in most cases.</p></p>
     * 
     * <p><p>Used to uniquely identify a particular drug product 
     * when prescribing/dispensing at a higher level of abstraction 
     * (e.g. generic drug, generic formulation).</p><p>This 
     * attribute is marked as &quot;populated&quot; as drug code 
     * should be available in most cases.</p></p>
     * 
     * <p>Drug Code</p>
     * 
     * <p><p>An identifier for a drug at a higher level of 
     * abstraction.</p></p>
     * 
     * <p><p>Used to uniquely identify a particular drug product 
     * when prescribing/dispensing at a higher level of abstraction 
     * (e.g. generic drug, generic formulation).</p><p>This 
     * attribute is marked as &quot;populated&quot; as a drug code 
     * should be available in most cases.</p></p>
     * 
     * <p><p>Used to uniquely identify a particular drug product 
     * when prescribing/dispensing at a higher level of abstraction 
     * (e.g. generic drug, generic formulation).</p><p>This 
     * attribute is marked as &quot;populated&quot; as a drug code 
     * should be available in most cases.</p></p>
     */
    @Hl7XmlMapping({"generalizedMedicineClass/code"})
    public ClinicalDrug getDrugCode() {
        return (ClinicalDrug) this.drugCode.getValue();
    }
    public void setDrugCode(ClinicalDrug drugCode) {
        this.drugCode.setValue(drugCode);
    }


    /**
     * <p>DrugName</p>
     * 
     * <p>Drug Name</p>
     * 
     * <p><p>The name assigned to the drug at the higher level of 
     * abstraction.</p></p>
     * 
     * <p><p>To display in dropdowns and for local 
     * searching.</p><p>This attribute is marked as 
     * &quot;populated&quot; as drug name should be available in 
     * most cases.</p></p>
     * 
     * <p><p>To display in dropdowns and for local 
     * searching.</p><p>This attribute is marked as 
     * &quot;populated&quot; as drug name should be available in 
     * most cases.</p></p>
     * 
     * <p>Drug Name</p>
     * 
     * <p><p>The name assigned to a drug within a specific drug 
     * identification scheme.</p></p>
     * 
     * <p><p>To display in dropdowns and for local 
     * searching.</p><p>This attribute is marked as 
     * &quot;populated&quot; as a drug name should be available in 
     * most cases.</p></p>
     * 
     * <p><p>To display in dropdowns and for local 
     * searching.</p><p>This attribute is marked as 
     * &quot;populated&quot; as a drug name should be available in 
     * most cases.</p></p>
     */
    @Hl7XmlMapping({"generalizedMedicineClass/name"})
    public String getDrugName() {
        return this.drugName.getValue();
    }
    public void setDrugName(String drugName) {
        this.drugName.setValue(drugName);
    }

}
