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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged;

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

    private static final long serialVersionUID = 20121122L;
    private CV code = new CVImpl();
    private ST name = new STImpl();
    private ST desc = new STImpl();
    private CV formCode = new CVImpl();
    private DrugContainsBean ingredient;


    /**
     * <p>DrugCode</p>
     * 
     * <p>Drug Code</p>
     */
    @Hl7XmlMapping({"code"})
    public ClinicalDrug getCode() {
        return (ClinicalDrug) this.code.getValue();
    }

    /**
     * <p>DrugCode</p>
     * 
     * <p>Drug Code</p>
     */
    public void setCode(ClinicalDrug code) {
        this.code.setValue(code);
    }


    /**
     * <p>DrugName</p>
     * 
     * <p>Drug Name</p>
     */
    @Hl7XmlMapping({"name"})
    public String getName() {
        return this.name.getValue();
    }

    /**
     * <p>DrugName</p>
     * 
     * <p>Drug Name</p>
     */
    public void setName(String name) {
        this.name.setValue(name);
    }


    /**
     * <p>DrugDescription</p>
     * 
     * <p>Drug Description</p>
     */
    @Hl7XmlMapping({"desc"})
    public String getDesc() {
        return this.desc.getValue();
    }

    /**
     * <p>DrugDescription</p>
     * 
     * <p>Drug Description</p>
     */
    public void setDesc(String desc) {
        this.desc.setValue(desc);
    }


    /**
     * <p>DrugForm</p>
     * 
     * <p>Drug Form</p>
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
     * <p>DrugForm</p>
     * 
     * <p>Drug Form</p>
     * 
     * <p>Indicates the form in which the drug product must be, or 
     * has been manufactured or custom prepared. Examples include: 
     * tablet, suspension, liquid, injectable, capsule, etc.</p>
     */
    public void setFormCode(OrderableDrugForm formCode) {
        this.formCode.setValue(formCode);
    }


    @Hl7XmlMapping({"ingredient"})
    public DrugContainsBean getIngredient() {
        return this.ingredient;
    }

    public void setIngredient(DrugContainsBean ingredient) {
        this.ingredient = ingredient;
    }

}
