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

package ca.infoway.messagebuilder.model.newfoundland.cerx;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.ClinicalDrug;
import ca.infoway.messagebuilder.domainvalue.CompliancePackageEntityType;
import ca.infoway.messagebuilder.domainvalue.OrderableDrugForm;
import ca.infoway.messagebuilder.model.MessagePartBean;

@Hl7PartTypeMapping({ "COCT_MT220100CA.Medicine", "COCT_MT220110CA.Medicine", "COCT_MT220200CA.Medicine", "COCT_MT220210CA.Medicine", "POME_MT010040CA.Medicine" })
public class MedicineBean extends MessagePartBean implements Serializable {

    private static final long serialVersionUID = 1997534738973357234L;

    private final CD code = new CDImpl();

    private final ST lotNumberText = new STImpl();

    private final IVL<TS, Interval<Date>> expirationTime = new IVLImpl<TS, Interval<Date>>();

    private final II manufacturerId = new IIImpl();

    private final ST manufacturerName = new STImpl();

    private final ST desc = new STImpl();

    private final CD formCode = new CDImpl();

    private final PQ quantity = new PQImpl();

    private final CD containerPackagedMedicine = new CDImpl();

    private final LIST<ST, String> names = new LISTImpl<ST, String>(STImpl.class);

    private List<DrugIngredientBean> ingredients = new ArrayList<DrugIngredientBean>();

    @Hl7XmlMapping("code")
    public ClinicalDrug getCode() {
        return (ClinicalDrug) this.code.getValue();
    }

    public void setCode(ClinicalDrug code) {
        this.code.setValue(code);
    }

    public ClinicalDrug getClinicalDrugCode() {
        return (ClinicalDrug) this.code.getValue();
    }

    @Hl7XmlMapping("lotNumberText")
    public String getLotNumberText() {
        return this.lotNumberText.getValue();
    }

    public void setLotNumberText(String lotNumberText) {
        this.lotNumberText.setValue(lotNumberText);
    }

    @Hl7XmlMapping("expirationTime")
    public Interval<Date> getExpirationTime() {
        return this.expirationTime.getValue();
    }

    public void setExpirationTime(Interval<Date> expirationTime) {
        this.expirationTime.setValue(expirationTime);
    }

    @Hl7XmlMapping("asManufacturedProduct/manufacturer/id")
    public Identifier getManufacturerId() {
        return this.manufacturerId.getValue();
    }

    public void setManufacturerId(Identifier manufacturerId) {
        this.manufacturerId.setValue(manufacturerId);
    }

    @Hl7XmlMapping("asManufacturedProduct/manufacturer/name")
    public String getManufacturerName() {
        return this.manufacturerName.getValue();
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName.setValue(manufacturerName);
    }

    @Hl7XmlMapping("name")
    public List<String> getNames() {
        return this.names.rawList();
    }

    public String getName() {
        return this.getNames().isEmpty() ? null : this.getNames().get(0);
    }

    public void setName(String name) {
        this.getNames().clear();
        this.getNames().add(name);
    }

    @Hl7XmlMapping("desc")
    public String getDesc() {
        return this.desc.getValue();
    }

    public void setDesc(String desc) {
        this.desc.setValue(desc);
    }

    @Hl7XmlMapping("formCode")
    public OrderableDrugForm getFormCode() {
        return (OrderableDrugForm) this.formCode.getValue();
    }

    public void setFormCode(OrderableDrugForm formCode) {
        this.formCode.setValue(formCode);
    }

    @Hl7XmlMapping("asContent/quantity")
    public PhysicalQuantity getQuantity() {
        return this.quantity.getValue();
    }

    public void setQuantity(PhysicalQuantity quantity) {
        this.quantity.setValue(quantity);
    }

    @Hl7XmlMapping("asContent/containerPackagedMedicine/formCode")
    public CompliancePackageEntityType getContainerPackagedMedicine() {
        return (CompliancePackageEntityType) this.containerPackagedMedicine.getValue();
    }

    public void setContainerPackagedMedicine(CompliancePackageEntityType containerPackagedMedicine) {
        this.containerPackagedMedicine.setValue(containerPackagedMedicine);
    }

    @Hl7XmlMapping("ingredient")
    public List<DrugIngredientBean> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<DrugIngredientBean> ingredients) {
        this.ingredients = ingredients;
    }
}
