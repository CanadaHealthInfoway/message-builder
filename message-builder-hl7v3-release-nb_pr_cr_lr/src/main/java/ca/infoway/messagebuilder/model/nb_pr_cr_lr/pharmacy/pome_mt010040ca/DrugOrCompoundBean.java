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
package ca.infoway.messagebuilder.model.nb_pr_cr_lr.pharmacy.pome_mt010040ca;

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
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.merged.DrugContainsBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.merged.ManufacturerBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.pharmacy.merged.DispensedInBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.pharmacy.merged.GroupedWithinBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



/**
 * <p>Business Name: Drug or Compound</p>
 * 
 * <p>Provides a list of drugs available for 
 * prescribing/dispensing.</p>
 * 
 * <p>A catalog of drugs (manufactured material) from which 
 * drugs may be selected for prescribing/dispensing. This 
 * includes: TC - Therapeutic Class; GD - Generic Drug; GF - 
 * Generic Formulation; MD - Manufactured Drug; and CMP - 
 * Compound</p>
 */
@Hl7PartTypeMapping({"POME_MT010040CA.Medicine"})
public class DrugOrCompoundBean extends MessagePartBean {

    private static final long serialVersionUID = 20190801L;
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
     * <p>Business Name: Drug Code</p>
     * 
     * <p>Relationship: POME_MT010040CA.Medicine.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used to ensure clear communication by uniquely 
     * identifying a particular drug product when prescribing or 
     * dispensing. This attribute is mandatory because querying by 
     * drug code can only return drug codes.</p>
     * 
     * <p>An identifier for a type of drug. Depending on where the 
     * drug is being referenced, the drug may be identified at 
     * different levels of abstraction. E.g. Manufactured drug 
     * (including vaccines), generic formulation, generic, 
     * therapeutic class, etc.</p>
     */
    @Hl7XmlMapping({"code"})
    public ClinicalDrug getCode() {
        return (ClinicalDrug) this.code.getValue();
    }

    /**
     * <p>Business Name: Drug Code</p>
     * 
     * <p>Relationship: POME_MT010040CA.Medicine.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used to ensure clear communication by uniquely 
     * identifying a particular drug product when prescribing or 
     * dispensing. This attribute is mandatory because querying by 
     * drug code can only return drug codes.</p>
     * 
     * <p>An identifier for a type of drug. Depending on where the 
     * drug is being referenced, the drug may be identified at 
     * different levels of abstraction. E.g. Manufactured drug 
     * (including vaccines), generic formulation, generic, 
     * therapeutic class, etc.</p>
     */
    public void setCode(ClinicalDrug code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: Drug Names</p>
     * 
     * <p>Relationship: POME_MT010040CA.Medicine.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1-2)</p>
     * 
     * <p>Names are used for human reference communication, to 
     * allow selection from dropdowns and for local searching. Up 
     * to two names are supported: a 'search name' which is fully 
     * formed with no abbreviations, and a 'display name' which may 
     * contain abbreviations to fit within a smaller area on the 
     * screen.</p><p>This attribute is marked as 'mandatory' as 
     * drugs at any level of the drug hierarchy is supposed to have 
     * a name.</p>
     * 
     * <p>The name assigned to a drug.</p>
     */
    @Hl7XmlMapping({"name"})
    public Set<TrivialName> getName() {
        return this.name.rawSet();
    }


    /**
     * <p>Business Name: Description</p>
     * 
     * <p>Relationship: POME_MT010040CA.Medicine.desc</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows description of compound ingredients and/or recipe 
     * in free text form.</p>
     * 
     * <p>A free form textual description of a drug. This usually 
     * is only populated for custom compounds, providing 
     * instructions on the composition and creation of the 
     * compound.</p>
     */
    @Hl7XmlMapping({"desc"})
    public String getDesc() {
        return this.desc.getValue();
    }

    /**
     * <p>Business Name: Description</p>
     * 
     * <p>Relationship: POME_MT010040CA.Medicine.desc</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows description of compound ingredients and/or recipe 
     * in free text form.</p>
     * 
     * <p>A free form textual description of a drug. This usually 
     * is only populated for custom compounds, providing 
     * instructions on the composition and creation of the 
     * compound.</p>
     */
    public void setDesc(String desc) {
        this.desc.setValue(desc);
    }


    /**
     * <p>Business Name: Drug Form</p>
     * 
     * <p>Relationship: POME_MT010040CA.Medicine.formCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Provides a constrained vocabulary for describing dose 
     * forms. The form of the drug influences how it can be used by 
     * the patient.</p>
     * 
     * <p>Indicates the form in which the drug product must be, or 
     * has been manufactured or custom prepared.</p>
     */
    @Hl7XmlMapping({"formCode"})
    public OrderableDrugForm getFormCode() {
        return (OrderableDrugForm) this.formCode.getValue();
    }

    /**
     * <p>Business Name: Drug Form</p>
     * 
     * <p>Relationship: POME_MT010040CA.Medicine.formCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Provides a constrained vocabulary for describing dose 
     * forms. The form of the drug influences how it can be used by 
     * the patient.</p>
     * 
     * <p>Indicates the form in which the drug product must be, or 
     * has been manufactured or custom prepared.</p>
     */
    public void setFormCode(OrderableDrugForm formCode) {
        this.formCode.setValue(formCode);
    }


    /**
     * <p>Relationship: 
     * POME_MT010040CA.ManufacturedProduct.manufacturer</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"asManufacturedProduct/manufacturer"})
    public ManufacturerBean getAsManufacturedProductManufacturer() {
        return this.asManufacturedProductManufacturer;
    }

    /**
     * <p>Relationship: 
     * POME_MT010040CA.ManufacturedProduct.manufacturer</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAsManufacturedProductManufacturer(ManufacturerBean asManufacturedProductManufacturer) {
        this.asManufacturedProductManufacturer = asManufacturedProductManufacturer;
    }


    /**
     * <p>Business Name: Regulatory Status Code</p>
     * 
     * <p>Relationship: POME_MT010040CA.RegulatedProduct.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows providers to evaluate the validity of the 
     * medication for use in Canada.</p>
     * 
     * <p>Indicates whether the drug is approved for use in Canada 
     * or not. (active = currently approved, terminated or pending 
     * = not approved)</p>
     */
    @Hl7XmlMapping({"asRegulatedProduct/statusCode"})
    public RoleStatusNormal getAsRegulatedProductStatusCode() {
        return (RoleStatusNormal) this.asRegulatedProductStatusCode.getValue();
    }

    /**
     * <p>Business Name: Regulatory Status Code</p>
     * 
     * <p>Relationship: POME_MT010040CA.RegulatedProduct.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows providers to evaluate the validity of the 
     * medication for use in Canada.</p>
     * 
     * <p>Indicates whether the drug is approved for use in Canada 
     * or not. (active = currently approved, terminated or pending 
     * = not approved)</p>
     */
    public void setAsRegulatedProductStatusCode(RoleStatusNormal asRegulatedProductStatusCode) {
        this.asRegulatedProductStatusCode.setValue(asRegulatedProductStatusCode);
    }


    /**
     * <p>Relationship: POME_MT010040CA.Medicine.asContent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"asContent"})
    public DispensedInBean getAsContent() {
        return this.asContent;
    }

    /**
     * <p>Relationship: POME_MT010040CA.Medicine.asContent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setAsContent(DispensedInBean asContent) {
        this.asContent = asContent;
    }


    /**
     * <p>Relationship: POME_MT010040CA.Medicine.asSpecializedKind</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-5)</p>
     */
    @Hl7XmlMapping({"asSpecializedKind"})
    public List<GroupedWithinBean> getAsSpecializedKind() {
        return this.asSpecializedKind;
    }


    /**
     * <p>Relationship: POME_MT010040CA.Medicine.ingredient</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-100)</p>
     */
    @Hl7XmlMapping({"ingredient"})
    public List<DrugContainsBean> getIngredient() {
        return this.ingredient;
    }

}
