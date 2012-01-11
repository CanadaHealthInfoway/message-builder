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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pharmacy.pome_mt010040ca;

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
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.merged.DispensedInBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.merged.DrugContainsBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.merged.ManufacturerBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pharmacy.merged.GroupedWithinBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



@Hl7PartTypeMapping({"POME_MT010040CA.Medicine"})
public class DrugOrCompoundBean extends MessagePartBean {

    private static final long serialVersionUID = 20111121L;
    private CV code = new CVImpl();
    private SET<TN, TrivialName> name = new SETImpl<TN, TrivialName>(TNImpl.class);
    private ST desc = new STImpl();
    private CV formCode = new CVImpl();
    private ManufacturerBean asManufacturedProductManufacturer;
    private CS asRegulatedProductStatusCode = new CSImpl();
    private DispensedInBean asContent;
    private List<GroupedWithinBean> asSpecializedKind = new ArrayList<GroupedWithinBean>();
    private List<DrugContainsBean> ingredient = new ArrayList<DrugContainsBean>();


    /**
     * <p>Drug Code</p>
     */
    @Hl7XmlMapping({"code"})
    public ClinicalDrug getCode() {
        return (ClinicalDrug) this.code.getValue();
    }
    public void setCode(ClinicalDrug code) {
        this.code.setValue(code);
    }


    /**
     * <p>Drug Names</p>
     */
    @Hl7XmlMapping({"name"})
    public Set<TrivialName> getName() {
        return this.name.rawSet();
    }


    /**
     * <p>Description</p>
     */
    @Hl7XmlMapping({"desc"})
    public String getDesc() {
        return this.desc.getValue();
    }
    public void setDesc(String desc) {
        this.desc.setValue(desc);
    }


    /**
     * <p>Drug Form</p>
     */
    @Hl7XmlMapping({"formCode"})
    public OrderableDrugForm getFormCode() {
        return (OrderableDrugForm) this.formCode.getValue();
    }
    public void setFormCode(OrderableDrugForm formCode) {
        this.formCode.setValue(formCode);
    }


    @Hl7XmlMapping({"asManufacturedProduct/manufacturer"})
    public ManufacturerBean getAsManufacturedProductManufacturer() {
        return this.asManufacturedProductManufacturer;
    }
    public void setAsManufacturedProductManufacturer(ManufacturerBean asManufacturedProductManufacturer) {
        this.asManufacturedProductManufacturer = asManufacturedProductManufacturer;
    }


    /**
     * <p>Regulatory Status Code</p>
     */
    @Hl7XmlMapping({"asRegulatedProduct/statusCode"})
    public RoleStatusNormal getAsRegulatedProductStatusCode() {
        return (RoleStatusNormal) this.asRegulatedProductStatusCode.getValue();
    }
    public void setAsRegulatedProductStatusCode(RoleStatusNormal asRegulatedProductStatusCode) {
        this.asRegulatedProductStatusCode.setValue(asRegulatedProductStatusCode);
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
