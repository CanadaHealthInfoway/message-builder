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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.pharmacy.pome_mt010100ca;

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
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.merged.DrugContainsBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.merged.ManufacturerBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.pharmacy.merged.AppearanceCharacteristicsBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.pharmacy.merged.DispensedInBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.pharmacy.merged.DrugCostBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.pharmacy.merged.GroupedWithinBean;
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
@Hl7PartTypeMapping({"POME_MT010100CA.Medication"})
@Hl7RootType
public class MedicationBean extends MessagePartBean {

    private static final long serialVersionUID = 20121204L;
    private CV playerCode = new CVImpl();
    private SET<TN, TrivialName> playerName = new SETImpl<TN, TrivialName>(TNImpl.class);
    private ST playerDesc = new STImpl();
    private CV playerFormCode = new CVImpl();
    private ManufacturerBean playerAsManufacturedProductManufacturer;
    private CS playerAsRegulatedProductStatusCode = new CSImpl();
    private DispensedInBean playerAsContent;
    private List<GroupedWithinBean> playerAsSpecializedKind = new ArrayList<GroupedWithinBean>();
    private List<DrugContainsBean> playerIngredient = new ArrayList<DrugContainsBean>();
    private DrugCostBean subjectOf1PotentialCharge;
    private List<AppearanceCharacteristicsBean> subjectOf2Characteristic = new ArrayList<AppearanceCharacteristicsBean>();


    /**
     * <p>Business Name: A:Drug Code</p>
     * 
     * <p>Relationship: POME_MT010100CA.Medicine.code</p>
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
    @Hl7XmlMapping({"player/code"})
    public ClinicalDrug getPlayerCode() {
        return (ClinicalDrug) this.playerCode.getValue();
    }

    /**
     * <p>Business Name: A:Drug Code</p>
     * 
     * <p>Relationship: POME_MT010100CA.Medicine.code</p>
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
    public void setPlayerCode(ClinicalDrug playerCode) {
        this.playerCode.setValue(playerCode);
    }


    /**
     * <p>Business Name: B:Drug Names</p>
     * 
     * <p>Relationship: POME_MT010100CA.Medicine.name</p>
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
    @Hl7XmlMapping({"player/name"})
    public Set<TrivialName> getPlayerName() {
        return this.playerName.rawSet();
    }


    /**
     * <p>Business Name: Description</p>
     * 
     * <p>Relationship: POME_MT010100CA.Medicine.desc</p>
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
    @Hl7XmlMapping({"player/desc"})
    public String getPlayerDesc() {
        return this.playerDesc.getValue();
    }

    /**
     * <p>Business Name: Description</p>
     * 
     * <p>Relationship: POME_MT010100CA.Medicine.desc</p>
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
    public void setPlayerDesc(String playerDesc) {
        this.playerDesc.setValue(playerDesc);
    }


    /**
     * <p>Business Name: D:Drug Form</p>
     * 
     * <p>Relationship: POME_MT010100CA.Medicine.formCode</p>
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
    @Hl7XmlMapping({"player/formCode"})
    public OrderableDrugForm getPlayerFormCode() {
        return (OrderableDrugForm) this.playerFormCode.getValue();
    }

    /**
     * <p>Business Name: D:Drug Form</p>
     * 
     * <p>Relationship: POME_MT010100CA.Medicine.formCode</p>
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
    public void setPlayerFormCode(OrderableDrugForm playerFormCode) {
        this.playerFormCode.setValue(playerFormCode);
    }


    @Hl7XmlMapping({"player/asManufacturedProduct/manufacturer"})
    public ManufacturerBean getPlayerAsManufacturedProductManufacturer() {
        return this.playerAsManufacturedProductManufacturer;
    }

    public void setPlayerAsManufacturedProductManufacturer(ManufacturerBean playerAsManufacturedProductManufacturer) {
        this.playerAsManufacturedProductManufacturer = playerAsManufacturedProductManufacturer;
    }


    /**
     * <p>Business Name: Regulatory Status Code</p>
     * 
     * <p>Relationship: POME_MT010100CA.RegulatedProduct.statusCode</p>
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
    @Hl7XmlMapping({"player/asRegulatedProduct/statusCode"})
    public RoleStatusNormal getPlayerAsRegulatedProductStatusCode() {
        return (RoleStatusNormal) this.playerAsRegulatedProductStatusCode.getValue();
    }

    /**
     * <p>Business Name: Regulatory Status Code</p>
     * 
     * <p>Relationship: POME_MT010100CA.RegulatedProduct.statusCode</p>
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
    public void setPlayerAsRegulatedProductStatusCode(RoleStatusNormal playerAsRegulatedProductStatusCode) {
        this.playerAsRegulatedProductStatusCode.setValue(playerAsRegulatedProductStatusCode);
    }


    @Hl7XmlMapping({"player/asContent"})
    public DispensedInBean getPlayerAsContent() {
        return this.playerAsContent;
    }

    public void setPlayerAsContent(DispensedInBean playerAsContent) {
        this.playerAsContent = playerAsContent;
    }


    @Hl7XmlMapping({"player/asSpecializedKind"})
    public List<GroupedWithinBean> getPlayerAsSpecializedKind() {
        return this.playerAsSpecializedKind;
    }


    @Hl7XmlMapping({"player/ingredient"})
    public List<DrugContainsBean> getPlayerIngredient() {
        return this.playerIngredient;
    }


    @Hl7XmlMapping({"subjectOf1/potentialCharge"})
    public DrugCostBean getSubjectOf1PotentialCharge() {
        return this.subjectOf1PotentialCharge;
    }

    public void setSubjectOf1PotentialCharge(DrugCostBean subjectOf1PotentialCharge) {
        this.subjectOf1PotentialCharge = subjectOf1PotentialCharge;
    }


    @Hl7XmlMapping({"subjectOf2/characteristic"})
    public List<AppearanceCharacteristicsBean> getSubjectOf2Characteristic() {
        return this.subjectOf2Characteristic;
    }

}
