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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.common.coct_mt220210ca;

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
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ManufacturedDrug;
import ca.infoway.messagebuilder.domainvalue.OrderableDrugForm;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.merged.DrugContainsBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.merged.DrugDispensedInBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.merged.ManufacturerBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Hl7PartTypeMapping({"COCT_MT220210CA.Medication"})
@Hl7RootType
public class DrugProductBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.common.coct_mt270010ca.Medication {

    private static final long serialVersionUID = 20111117L;
    private CV administerableMedicineCode = new CVImpl();
    private ST administerableMedicineName = new STImpl();
    private ST administerableMedicineDesc = new STImpl();
    private CV administerableMedicineFormCode = new CVImpl();
    private ST administerableMedicineLotNumberText = new STImpl();
    private IVL<TS, Interval<Date>> administerableMedicineExpirationTime = new IVLImpl<TS, Interval<Date>>();
    private ManufacturerBean administerableMedicineAsManufacturedProductManufacturer;
    private DrugDispensedInBean administerableMedicineAsContent;
    private List<DrugContainsBean> administerableMedicineIngredient = new ArrayList<DrugContainsBean>();


    /**
     * <p>A:Drug Code</p>
     */
    @Hl7XmlMapping({"administerableMedicine/code"})
    public ManufacturedDrug getAdministerableMedicineCode() {
        return (ManufacturedDrug) this.administerableMedicineCode.getValue();
    }
    public void setAdministerableMedicineCode(ManufacturedDrug administerableMedicineCode) {
        this.administerableMedicineCode.setValue(administerableMedicineCode);
    }


    /**
     * <p>B:Drug Name</p>
     */
    @Hl7XmlMapping({"administerableMedicine/name"})
    public String getAdministerableMedicineName() {
        return this.administerableMedicineName.getValue();
    }
    public void setAdministerableMedicineName(String administerableMedicineName) {
        this.administerableMedicineName.setValue(administerableMedicineName);
    }


    /**
     * <p>C:Drug Description</p>
     */
    @Hl7XmlMapping({"administerableMedicine/desc"})
    public String getAdministerableMedicineDesc() {
        return this.administerableMedicineDesc.getValue();
    }
    public void setAdministerableMedicineDesc(String administerableMedicineDesc) {
        this.administerableMedicineDesc.setValue(administerableMedicineDesc);
    }


    /**
     * <p>D:Drug Form</p>
     */
    @Hl7XmlMapping({"administerableMedicine/formCode"})
    public OrderableDrugForm getAdministerableMedicineFormCode() {
        return (OrderableDrugForm) this.administerableMedicineFormCode.getValue();
    }
    public void setAdministerableMedicineFormCode(OrderableDrugForm administerableMedicineFormCode) {
        this.administerableMedicineFormCode.setValue(administerableMedicineFormCode);
    }


    /**
     * <p>E:Drug Lot Number</p>
     */
    @Hl7XmlMapping({"administerableMedicine/lotNumberText"})
    public String getAdministerableMedicineLotNumberText() {
        return this.administerableMedicineLotNumberText.getValue();
    }
    public void setAdministerableMedicineLotNumberText(String administerableMedicineLotNumberText) {
        this.administerableMedicineLotNumberText.setValue(administerableMedicineLotNumberText);
    }


    /**
     * <p>F:Drug Expiry Date</p>
     */
    @Hl7XmlMapping({"administerableMedicine/expirationTime"})
    public Interval<Date> getAdministerableMedicineExpirationTime() {
        return this.administerableMedicineExpirationTime.getValue();
    }
    public void setAdministerableMedicineExpirationTime(Interval<Date> administerableMedicineExpirationTime) {
        this.administerableMedicineExpirationTime.setValue(administerableMedicineExpirationTime);
    }


    @Hl7XmlMapping({"administerableMedicine/asManufacturedProduct/manufacturer"})
    public ManufacturerBean getAdministerableMedicineAsManufacturedProductManufacturer() {
        return this.administerableMedicineAsManufacturedProductManufacturer;
    }
    public void setAdministerableMedicineAsManufacturedProductManufacturer(ManufacturerBean administerableMedicineAsManufacturedProductManufacturer) {
        this.administerableMedicineAsManufacturedProductManufacturer = administerableMedicineAsManufacturedProductManufacturer;
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

}
