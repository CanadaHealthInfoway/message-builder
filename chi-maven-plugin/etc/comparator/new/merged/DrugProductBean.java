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
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ManufacturedDrug;
import ca.infoway.messagebuilder.domainvalue.OrderableDrugForm;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.common.coct_mt270010ca.MedicationBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;



@Hl7PartTypeMapping({"COCT_MT220100CA.Medication","COCT_MT220110CA.Medication","COCT_MT220200CA.Medication","COCT_MT220210CA.Medication"})
@Hl7RootType
public class DrugProductBean extends MessagePartBean implements MedicationBean {

    private CV<ManufacturedDrug> drugCode = new CVImpl<ManufacturedDrug>();
    private ST drugName = new STImpl();
    private ST drugDescription = new STImpl();
    private CV<OrderableDrugForm> drugForm = new CVImpl<OrderableDrugForm>();
    private ST drugLotNumber = new STImpl();
    private IVL<TS, Interval<Date>> drugExpiryDate = new IVLImpl<TS, Interval<Date>>();
    private DrugDispensedInBean administerableMedicineAsContent;
    private List<DrugContainsBean> administerableMedicineIngredient = new ArrayList<DrugContainsBean>();
    private ManufacturedByBean administerableMedicineAsManufacturedProduct;

    @Hl7XmlMapping({"administerableMedicine/code"})
    public ManufacturedDrug getDrugCode() {
        return this.drugCode.getValue();
    }
    public void setDrugCode(ManufacturedDrug drugCode) {
        this.drugCode.setValue(drugCode);
    }

    @Hl7XmlMapping({"administerableMedicine/name"})
    public java.lang.String getDrugName() {
        return this.drugName.getValue();
    }
    public void setDrugName(java.lang.String drugName) {
        this.drugName.setValue(drugName);
    }

    @Hl7XmlMapping({"administerableMedicine/desc"})
    public java.lang.String getDrugDescription() {
        return this.drugDescription.getValue();
    }
    public void setDrugDescription(java.lang.String drugDescription) {
        this.drugDescription.setValue(drugDescription);
    }

    @Hl7XmlMapping({"administerableMedicine/formCode"})
    public OrderableDrugForm getDrugForm() {
        return this.drugForm.getValue();
    }
    public void setDrugForm(OrderableDrugForm drugForm) {
        this.drugForm.setValue(drugForm);
    }

    @Hl7XmlMapping({"administerableMedicine/lotNumberText"})
    public java.lang.String getDrugLotNumber() {
        return this.drugLotNumber.getValue();
    }
    public void setDrugLotNumber(java.lang.String drugLotNumber) {
        this.drugLotNumber.setValue(drugLotNumber);
    }

    @Hl7XmlMapping({"administerableMedicine/expirationTime"})
    public Interval<Date> getDrugExpiryDate() {
        return this.drugExpiryDate.getValue();
    }
    public void setDrugExpiryDate(Interval<Date> drugExpiryDate) {
        this.drugExpiryDate.setValue(drugExpiryDate);
    }

    @Hl7XmlMapping({"administerableMedicine/asContent"})
    public DrugDispensedInBean getAdministerableMedicineAsContent() {
        return this.administerableMedicineAsContent;
    }
    public void setAdministerableMedicineAsContent(DrugDispensedInBean administerableMedicineAsContent) {
        this.administerableMedicineAsContent = administerableMedicineAsContent;
    }

    @Hl7XmlMapping({"administerableMedicine/ingredient"})
    public List<DrugContainsBean> getAdministerableMedicineIngredient() {
        return this.administerableMedicineIngredient;
    }

    @Hl7XmlMapping({"administerableMedicine/asManufacturedProduct"})
    public ManufacturedByBean getAdministerableMedicineAsManufacturedProduct() {
        return this.administerableMedicineAsManufacturedProduct;
    }
    public void setAdministerableMedicineAsManufacturedProduct(ManufacturedByBean administerableMedicineAsManufacturedProduct) {
        this.administerableMedicineAsManufacturedProduct = administerableMedicineAsManufacturedProduct;
    }

}
