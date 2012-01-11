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
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TN;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TNImpl;
import ca.infoway.messagebuilder.datatype.lang.TrivialName;
import ca.infoway.messagebuilder.domainvalue.ClinicalDrug;
import ca.infoway.messagebuilder.domainvalue.OrderableDrugForm;
import ca.infoway.messagebuilder.domainvalue.RoleStatusNormal;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;



@Hl7PartTypeMapping({"POME_MT010040CA.Medicine","POME_MT010100CA.Medicine"})
public class DrugOrCompoundBean extends MessagePartBean {

    private CV<ClinicalDrug> drugCode = new CVImpl<ClinicalDrug>();
    private SET<TN, TrivialName> drugNames = new SETImpl<TN, TrivialName>(TNImpl.class);
    private ST description = new STImpl();
    private CV<OrderableDrugForm> drugForm = new CVImpl<OrderableDrugForm>();
    private ManufacturedByBean asManufacturedProduct;
    private CS<RoleStatusNormal> regulatoryStatusCode = new CSImpl<RoleStatusNormal>();
    private DispensedInBean asContent;
    private List<GroupedWithinBean> asSpecializedKind = new ArrayList<GroupedWithinBean>();
    private List<DrugContainsBean> ingredient = new ArrayList<DrugContainsBean>();

    @Hl7XmlMapping({"code"})
    public ClinicalDrug getDrugCode() {
        return this.drugCode.getValue();
    }
    public void setDrugCode(ClinicalDrug drugCode) {
        this.drugCode.setValue(drugCode);
    }

    @Hl7XmlMapping({"name"})
    public Set<TrivialName> getDrugNames() {
        return this.drugNames.rawSet();
    }

    @Hl7XmlMapping({"desc"})
    public java.lang.String getDescription() {
        return this.description.getValue();
    }
    public void setDescription(java.lang.String description) {
        this.description.setValue(description);
    }

    @Hl7XmlMapping({"formCode"})
    public OrderableDrugForm getDrugForm() {
        return this.drugForm.getValue();
    }
    public void setDrugForm(OrderableDrugForm drugForm) {
        this.drugForm.setValue(drugForm);
    }

    @Hl7XmlMapping({"asManufacturedProduct"})
    public ManufacturedByBean getAsManufacturedProduct() {
        return this.asManufacturedProduct;
    }
    public void setAsManufacturedProduct(ManufacturedByBean asManufacturedProduct) {
        this.asManufacturedProduct = asManufacturedProduct;
    }

    @Hl7XmlMapping({"asRegulatedProduct/statusCode"})
    public RoleStatusNormal getRegulatoryStatusCode() {
        return this.regulatoryStatusCode.getValue();
    }
    public void setRegulatoryStatusCode(RoleStatusNormal regulatoryStatusCode) {
        this.regulatoryStatusCode.setValue(regulatoryStatusCode);
    }

    @Hl7XmlMapping({"asContent"})
    public DispensedInBean getAsContent() {
        return this.asContent;
    }
    public void setAsContent(DispensedInBean asContent) {
        this.asContent = asContent;
    }

    @Hl7XmlMapping({"asSpecializedKind"})
    public List<GroupedWithinBean> getAsSpecializedKind() {
        return this.asSpecializedKind;
    }

    @Hl7XmlMapping({"ingredient"})
    public List<DrugContainsBean> getIngredient() {
        return this.ingredient;
    }

}
