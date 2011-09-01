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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.ficr_mt490102ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.ClinicalDrug;
import ca.infoway.messagebuilder.domainvalue.OrderableDrugForm;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.DrugContainsBean;



@Hl7PartTypeMapping({"FICR_MT490102CA.Medication"})
public class MedicationBean extends MessagePartBean {

    private static final long serialVersionUID = 20110901L;
    private CV drugCode = new CVImpl();
    private ST drugName = new STImpl();
    private ST drugDescription = new STImpl();
    private CV drugForm = new CVImpl();
    private DrugContainsBean administerableMedicineIngredient;


    /**
     * <p>Drug Code</p>
     */
    @Hl7XmlMapping({"administerableMedicine/code"})
    public ClinicalDrug getDrugCode() {
        return (ClinicalDrug) this.drugCode.getValue();
    }
    public void setDrugCode(ClinicalDrug drugCode) {
        this.drugCode.setValue(drugCode);
    }


    /**
     * <p>Drug Name</p>
     */
    @Hl7XmlMapping({"administerableMedicine/name"})
    public String getDrugName() {
        return this.drugName.getValue();
    }
    public void setDrugName(String drugName) {
        this.drugName.setValue(drugName);
    }


    /**
     * <p>Drug Description</p>
     */
    @Hl7XmlMapping({"administerableMedicine/desc"})
    public String getDrugDescription() {
        return this.drugDescription.getValue();
    }
    public void setDrugDescription(String drugDescription) {
        this.drugDescription.setValue(drugDescription);
    }


    /**
     * <p>Drug Form</p>
     * 
     * <p><p>Indicates the form in which the drug product must be, 
     * or has been manufactured or custom prepared. Examples 
     * include: tablet, suspension, liquid, injectable, capsule, 
     * etc.</p></p>
     */
    @Hl7XmlMapping({"administerableMedicine/formCode"})
    public OrderableDrugForm getDrugForm() {
        return (OrderableDrugForm) this.drugForm.getValue();
    }
    public void setDrugForm(OrderableDrugForm drugForm) {
        this.drugForm.setValue(drugForm);
    }


    @Hl7XmlMapping({"administerableMedicine/ingredient"})
    public DrugContainsBean getAdministerableMedicineIngredient() {
        return this.administerableMedicineIngredient;
    }
    public void setAdministerableMedicineIngredient(DrugContainsBean administerableMedicineIngredient) {
        this.administerableMedicineIngredient = administerableMedicineIngredient;
    }

}
