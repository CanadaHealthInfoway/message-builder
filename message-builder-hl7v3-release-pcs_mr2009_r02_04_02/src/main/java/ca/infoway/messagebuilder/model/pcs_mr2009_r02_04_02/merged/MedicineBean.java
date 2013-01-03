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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.ClinicalDrug;
import ca.infoway.messagebuilder.domainvalue.OrderableDrugForm;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"FICR_MT400001CA.Medicine","FICR_MT400003CA.Medicine","FICR_MT400004CA.Medicine","FICR_MT490101CA.Medicine"})
public class MedicineBean extends MessagePartBean {

    private static final long serialVersionUID = 20130103L;
    private CV code = new CVImpl();
    private ST name = new STImpl();
    private ST desc = new STImpl();
    private CV formCode = new CVImpl();
    private DrugContainsBean ingredient;


    /**
     * <p>Business Name: DrugCode</p>
     * 
     * <p>Un-merged Business Name: DrugCode</p>
     * 
     * <p>Relationship: FICR_MT400001CA.Medicine.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: DrugCode</p>
     * 
     * <p>Relationship: FICR_MT490101CA.Medicine.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: DrugCode</p>
     * 
     * <p>Relationship: FICR_MT400004CA.Medicine.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: DrugCode</p>
     * 
     * <p>Relationship: FICR_MT400003CA.Medicine.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"code"})
    public ClinicalDrug getCode() {
        return (ClinicalDrug) this.code.getValue();
    }

    /**
     * <p>Business Name: DrugCode</p>
     * 
     * <p>Un-merged Business Name: DrugCode</p>
     * 
     * <p>Relationship: FICR_MT400001CA.Medicine.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: DrugCode</p>
     * 
     * <p>Relationship: FICR_MT490101CA.Medicine.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: DrugCode</p>
     * 
     * <p>Relationship: FICR_MT400004CA.Medicine.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: DrugCode</p>
     * 
     * <p>Relationship: FICR_MT400003CA.Medicine.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setCode(ClinicalDrug code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: DrugName</p>
     * 
     * <p>Un-merged Business Name: DrugName</p>
     * 
     * <p>Relationship: FICR_MT400001CA.Medicine.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: DrugName</p>
     * 
     * <p>Relationship: FICR_MT490101CA.Medicine.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: DrugName</p>
     * 
     * <p>Relationship: FICR_MT400004CA.Medicine.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: DrugName</p>
     * 
     * <p>Relationship: FICR_MT400003CA.Medicine.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"name"})
    public String getName() {
        return this.name.getValue();
    }

    /**
     * <p>Business Name: DrugName</p>
     * 
     * <p>Un-merged Business Name: DrugName</p>
     * 
     * <p>Relationship: FICR_MT400001CA.Medicine.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: DrugName</p>
     * 
     * <p>Relationship: FICR_MT490101CA.Medicine.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: DrugName</p>
     * 
     * <p>Relationship: FICR_MT400004CA.Medicine.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: DrugName</p>
     * 
     * <p>Relationship: FICR_MT400003CA.Medicine.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setName(String name) {
        this.name.setValue(name);
    }


    /**
     * <p>Business Name: DrugDescription</p>
     * 
     * <p>Un-merged Business Name: DrugDescription</p>
     * 
     * <p>Relationship: FICR_MT400001CA.Medicine.desc</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: DrugDescription</p>
     * 
     * <p>Relationship: FICR_MT490101CA.Medicine.desc</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: DrugDescription</p>
     * 
     * <p>Relationship: FICR_MT400004CA.Medicine.desc</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: DrugDescription</p>
     * 
     * <p>Relationship: FICR_MT400003CA.Medicine.desc</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"desc"})
    public String getDesc() {
        return this.desc.getValue();
    }

    /**
     * <p>Business Name: DrugDescription</p>
     * 
     * <p>Un-merged Business Name: DrugDescription</p>
     * 
     * <p>Relationship: FICR_MT400001CA.Medicine.desc</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: DrugDescription</p>
     * 
     * <p>Relationship: FICR_MT490101CA.Medicine.desc</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: DrugDescription</p>
     * 
     * <p>Relationship: FICR_MT400004CA.Medicine.desc</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: DrugDescription</p>
     * 
     * <p>Relationship: FICR_MT400003CA.Medicine.desc</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setDesc(String desc) {
        this.desc.setValue(desc);
    }


    /**
     * <p>Business Name: DrugForm</p>
     * 
     * <p>Un-merged Business Name: DrugForm</p>
     * 
     * <p>Relationship: FICR_MT400001CA.Medicine.formCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates the form in which the drug product must be, or 
     * has been manufactured or custom prepared. Examples include: 
     * tablet, suspension, liquid, injectable, capsule, etc.</p>
     * 
     * <p>Un-merged Business Name: DrugForm</p>
     * 
     * <p>Relationship: FICR_MT490101CA.Medicine.formCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates the form in which the drug product must be, or 
     * has been manufactured or custom prepared. Examples include: 
     * tablet, suspension, liquid, injectable, capsule, etc.</p>
     * 
     * <p>Un-merged Business Name: DrugForm</p>
     * 
     * <p>Relationship: FICR_MT400004CA.Medicine.formCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates the form in which the drug product must be, or 
     * has been manufactured or custom prepared. Examples include: 
     * tablet, suspension, liquid, injectable, capsule, etc.</p>
     * 
     * <p>Un-merged Business Name: DrugForm</p>
     * 
     * <p>Relationship: FICR_MT400003CA.Medicine.formCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates the form in which the drug product must be, or 
     * has been manufactured or custom prepared. Examples include: 
     * tablet, suspension, liquid, injectable, capsule, etc.</p>
     */
    @Hl7XmlMapping({"formCode"})
    public OrderableDrugForm getFormCode() {
        return (OrderableDrugForm) this.formCode.getValue();
    }

    /**
     * <p>Business Name: DrugForm</p>
     * 
     * <p>Un-merged Business Name: DrugForm</p>
     * 
     * <p>Relationship: FICR_MT400001CA.Medicine.formCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates the form in which the drug product must be, or 
     * has been manufactured or custom prepared. Examples include: 
     * tablet, suspension, liquid, injectable, capsule, etc.</p>
     * 
     * <p>Un-merged Business Name: DrugForm</p>
     * 
     * <p>Relationship: FICR_MT490101CA.Medicine.formCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates the form in which the drug product must be, or 
     * has been manufactured or custom prepared. Examples include: 
     * tablet, suspension, liquid, injectable, capsule, etc.</p>
     * 
     * <p>Un-merged Business Name: DrugForm</p>
     * 
     * <p>Relationship: FICR_MT400004CA.Medicine.formCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates the form in which the drug product must be, or 
     * has been manufactured or custom prepared. Examples include: 
     * tablet, suspension, liquid, injectable, capsule, etc.</p>
     * 
     * <p>Un-merged Business Name: DrugForm</p>
     * 
     * <p>Relationship: FICR_MT400003CA.Medicine.formCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates the form in which the drug product must be, or 
     * has been manufactured or custom prepared. Examples include: 
     * tablet, suspension, liquid, injectable, capsule, etc.</p>
     */
    public void setFormCode(OrderableDrugForm formCode) {
        this.formCode.setValue(formCode);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: FICR_MT400004CA.Medicine.ingredient</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: FICR_MT400003CA.Medicine.ingredient</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"ingredient"})
    public DrugContainsBean getIngredient() {
        return this.ingredient;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: FICR_MT400004CA.Medicine.ingredient</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: FICR_MT400003CA.Medicine.ingredient</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setIngredient(DrugContainsBean ingredient) {
        this.ingredient = ingredient;
    }

}
