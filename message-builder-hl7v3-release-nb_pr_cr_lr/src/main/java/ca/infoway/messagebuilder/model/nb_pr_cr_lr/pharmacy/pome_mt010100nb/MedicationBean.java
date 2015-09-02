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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.nb_pr_cr_lr.pharmacy.pome_mt010100nb;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
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
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.pharmacy.merged.AppearanceCharacteristicsBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.pharmacy.merged.DispensedInBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.pharmacy.merged.DrugCostBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.pharmacy.merged.GroupedWithinBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



/**
 * <p>Business Name: Medication</p>
 * 
 * <p>Allows retrieval of summary about one or more products 
 * when searching for a medication</p>
 * 
 * <p>Represents a particular medicine or herbal product which 
 * might be prescribed or administered.</p>
 */
@Hl7PartTypeMapping({"POME_MT010100NB.AdministerableMaterial"})
@Hl7RootType
public class MedicationBean extends MessagePartBean {

    private static final long serialVersionUID = 20150902L;
    private CV administerableMedicineCode = new CVImpl();
    private SET<TN, TrivialName> administerableMedicineName = new SETImpl<TN, TrivialName>(TNImpl.class);
    private ST administerableMedicineDesc = new STImpl();
    private CV administerableMedicineFormCode = new CVImpl();
    private ManufacturerBean administerableMedicineAsManufacturedProductManufacturer;
    private CS administerableMedicineAsRegulatedProductStatusCode = new CSImpl();
    private DispensedInBean administerableMedicineAsContent;
    private List<GroupedWithinBean> administerableMedicineAsSpecializedKind = new ArrayList<GroupedWithinBean>();
    private List<DrugContainsBean> administerableMedicineIngredient = new ArrayList<DrugContainsBean>();
    private DrugCostBean subjectOf1PotentialCharge;
    private List<AppearanceCharacteristicsBean> subjectOf2Characteristic = new ArrayList<AppearanceCharacteristicsBean>();


    /**
     * <p>Business Name: A:Drug Code</p>
     * 
     * <p>Relationship: POME_MT010100NB.Medicine.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Used to ensure clear communication by uniquely 
     * identifying a particular drug product when prescribing or 
     * dispensing. This attribute is only constrained to 'required' 
     * because some custom compounds will not have unique 
     * identifiers.</p>
     * 
     * <p>An identifier for a type of drug. Depending on where the 
     * drug is being referenced, the drug may be identified at 
     * different levels of abstraction. E.g. Manufactured drug 
     * (including vaccines), generic formulation, generic, 
     * therapeutic class, etc.</p>
     */
    @Hl7XmlMapping({"administerableMedicine/code"})
    public ClinicalDrug getAdministerableMedicineCode() {
        return (ClinicalDrug) this.administerableMedicineCode.getValue();
    }

    /**
     * <p>Business Name: A:Drug Code</p>
     * 
     * <p>Relationship: POME_MT010100NB.Medicine.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Used to ensure clear communication by uniquely 
     * identifying a particular drug product when prescribing or 
     * dispensing. This attribute is only constrained to 'required' 
     * because some custom compounds will not have unique 
     * identifiers.</p>
     * 
     * <p>An identifier for a type of drug. Depending on where the 
     * drug is being referenced, the drug may be identified at 
     * different levels of abstraction. E.g. Manufactured drug 
     * (including vaccines), generic formulation, generic, 
     * therapeutic class, etc.</p>
     */
    public void setAdministerableMedicineCode(ClinicalDrug administerableMedicineCode) {
        this.administerableMedicineCode.setValue(administerableMedicineCode);
    }


    /**
     * <p>Business Name: B:Drug Names</p>
     * 
     * <p>Relationship: POME_MT010100NB.Medicine.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1-2)</p>
     * 
     * <p>Names are used for human reference communication, to 
     * allow selection from dropdowns and for local searching. Up 
     * to two names are supported: a 'search name' which is fully 
     * formed with no abbreviations, and a 'display name' which may 
     * contain abbreviations to fit within a smaller area on the 
     * screen. Because names are the one attribute that exist for 
     * all attributes, this element is mandatory.</p>
     * 
     * <p>The name assigned to a drug.</p>
     */
    @Hl7XmlMapping({"administerableMedicine/name"})
    public Set<TrivialName> getAdministerableMedicineName() {
        return this.administerableMedicineName.rawSet();
    }


    /**
     * <p>Business Name: Description</p>
     * 
     * <p>Relationship: POME_MT010100NB.Medicine.desc</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows description of compound ingredients and/or recipe 
     * in free text form.</p>
     * 
     * <p>A free form textual description of a drug. This usually 
     * is only recorded for custom compounds, providing 
     * instructions on the composition and creation of the 
     * compound.</p>
     */
    @Hl7XmlMapping({"administerableMedicine/desc"})
    public String getAdministerableMedicineDesc() {
        return this.administerableMedicineDesc.getValue();
    }

    /**
     * <p>Business Name: Description</p>
     * 
     * <p>Relationship: POME_MT010100NB.Medicine.desc</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows description of compound ingredients and/or recipe 
     * in free text form.</p>
     * 
     * <p>A free form textual description of a drug. This usually 
     * is only recorded for custom compounds, providing 
     * instructions on the composition and creation of the 
     * compound.</p>
     */
    public void setAdministerableMedicineDesc(String administerableMedicineDesc) {
        this.administerableMedicineDesc.setValue(administerableMedicineDesc);
    }


    /**
     * <p>Business Name: D:Drug Form</p>
     * 
     * <p>Relationship: POME_MT010100NB.Medicine.formCode</p>
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
    @Hl7XmlMapping({"administerableMedicine/formCode"})
    public OrderableDrugForm getAdministerableMedicineFormCode() {
        return (OrderableDrugForm) this.administerableMedicineFormCode.getValue();
    }

    /**
     * <p>Business Name: D:Drug Form</p>
     * 
     * <p>Relationship: POME_MT010100NB.Medicine.formCode</p>
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
    public void setAdministerableMedicineFormCode(OrderableDrugForm administerableMedicineFormCode) {
        this.administerableMedicineFormCode.setValue(administerableMedicineFormCode);
    }


    /**
     * <p>Relationship: 
     * POME_MT010100NB.ManufacturedProduct.manufacturer</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"administerableMedicine/asManufacturedProduct/manufacturer"})
    public ManufacturerBean getAdministerableMedicineAsManufacturedProductManufacturer() {
        return this.administerableMedicineAsManufacturedProductManufacturer;
    }

    /**
     * <p>Relationship: 
     * POME_MT010100NB.ManufacturedProduct.manufacturer</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAdministerableMedicineAsManufacturedProductManufacturer(ManufacturerBean administerableMedicineAsManufacturedProductManufacturer) {
        this.administerableMedicineAsManufacturedProductManufacturer = administerableMedicineAsManufacturedProductManufacturer;
    }


    /**
     * <p>Business Name: Regulatory Status Code</p>
     * 
     * <p>Relationship: POME_MT010100NB.RegulatedProduct.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows providers to evaluate the validity of the 
     * medication for use in Canada.</p>
     * 
     * <p>Indicates whether the drug is approved for use in Canada 
     * or not. (active = approved for use; pending or terminated = 
     * not approved for use)</p>
     */
    @Hl7XmlMapping({"administerableMedicine/asRegulatedProduct/statusCode"})
    public RoleStatusNormal getAdministerableMedicineAsRegulatedProductStatusCode() {
        return (RoleStatusNormal) this.administerableMedicineAsRegulatedProductStatusCode.getValue();
    }

    /**
     * <p>Business Name: Regulatory Status Code</p>
     * 
     * <p>Relationship: POME_MT010100NB.RegulatedProduct.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows providers to evaluate the validity of the 
     * medication for use in Canada.</p>
     * 
     * <p>Indicates whether the drug is approved for use in Canada 
     * or not. (active = approved for use; pending or terminated = 
     * not approved for use)</p>
     */
    public void setAdministerableMedicineAsRegulatedProductStatusCode(RoleStatusNormal administerableMedicineAsRegulatedProductStatusCode) {
        this.administerableMedicineAsRegulatedProductStatusCode.setValue(administerableMedicineAsRegulatedProductStatusCode);
    }


    /**
     * <p>Relationship: POME_MT010100NB.Medicine.asContent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"administerableMedicine/asContent"})
    public DispensedInBean getAdministerableMedicineAsContent() {
        return this.administerableMedicineAsContent;
    }

    /**
     * <p>Relationship: POME_MT010100NB.Medicine.asContent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setAdministerableMedicineAsContent(DispensedInBean administerableMedicineAsContent) {
        this.administerableMedicineAsContent = administerableMedicineAsContent;
    }


    /**
     * <p>Relationship: POME_MT010100NB.Medicine.asSpecializedKind</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-5)</p>
     */
    @Hl7XmlMapping({"administerableMedicine/asSpecializedKind"})
    public List<GroupedWithinBean> getAdministerableMedicineAsSpecializedKind() {
        return this.administerableMedicineAsSpecializedKind;
    }


    /**
     * <p>Relationship: POME_MT010100NB.Medicine.ingredient</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-100)</p>
     */
    @Hl7XmlMapping({"administerableMedicine/ingredient"})
    public List<DrugContainsBean> getAdministerableMedicineIngredient() {
        return this.administerableMedicineIngredient;
    }


    /**
     * <p>Relationship: POME_MT010100NB.Subject7.potentialCharge</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf1/potentialCharge"})
    public DrugCostBean getSubjectOf1PotentialCharge() {
        return this.subjectOf1PotentialCharge;
    }

    /**
     * <p>Relationship: POME_MT010100NB.Subject7.potentialCharge</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSubjectOf1PotentialCharge(DrugCostBean subjectOf1PotentialCharge) {
        this.subjectOf1PotentialCharge = subjectOf1PotentialCharge;
    }


    /**
     * <p>Relationship: POME_MT010100NB.Subject10.characteristic</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf2/characteristic"})
    public List<AppearanceCharacteristicsBean> getSubjectOf2Characteristic() {
        return this.subjectOf2Characteristic;
    }

}
