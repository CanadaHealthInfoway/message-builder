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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.coct_mt220110ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.ClinicalDrug;
import ca.infoway.messagebuilder.domainvalue.OrderableDrugForm;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.merged.DispensedInBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.merged.DrugContainsBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.merged.ManufacturerBean;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>Business Name: Drug Product</p>
 * 
 * <p>A_BillablePharmacyDispense</p>
 * 
 * <p>Allows drugs to be clearly described and referenced. Also 
 * allows searching for and examining information about 
 * medications that can be or are being used by a patient.</p>
 * 
 * <p>A pharmaceutical product intended to be supplied and/or 
 * administered to a patient. Encompasses manufactured drug 
 * products, generic classifications, prescription medications, 
 * over-the-counter medications and recreational drugs.</p>
 */
@Hl7PartTypeMapping({"COCT_MT220110CA.Medication"})
@Hl7RootType
public class DrugProductBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.porx_mt980040ca.Medication {

    private static final long serialVersionUID = 20130613L;
    private CD playerCode = new CDImpl();
    private ST playerName = new STImpl();
    private ST playerDesc = new STImpl();
    private CV playerFormCode = new CVImpl();
    private ManufacturerBean playerAsManufacturedProductManufacturer;
    private DispensedInBean playerAsContent;
    private List<DrugContainsBean> playerIngredient = new ArrayList<DrugContainsBean>();


    /**
     * <p>Business Name: A:Drug Code</p>
     * 
     * <p>Relationship: COCT_MT220110CA.Medicine.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>DrugProduct.activeIngredientId</p>
     * 
     * <p>DrugProduct.ActiveIngredientGroupNumber</p>
     * 
     * <p>DrugProduct.DIN</p>
     * 
     * <p>DrugProduct.StandardProductId (Mnemonic)</p>
     * 
     * <p>DrugProduct.StandardIDType(Code System)</p>
     * 
     * <p>D56(use code system to distinguish different types)</p>
     * 
     * <p>ZPB2.1</p>
     * 
     * <p>ZPB3.1</p>
     * 
     * <p>ZPC.1</p>
     * 
     * <p>ZPC1.3</p>
     * 
     * <p>ZPD.1</p>
     * 
     * <p>ZPD1.1</p>
     * 
     * <p>ZPD.6(scoping a specialized kind of therapeutic 
     * equivalent)</p>
     * 
     * <p>MB.05.03B</p>
     * 
     * <p>ZPS.11</p>
     * 
     * <p>ZDP.3a(code system)</p>
     * 
     * <p>ZDU.4.1</p>
     * 
     * <p>ZDP.7</p>
     * 
     * <p>DRU.010-03(mnemonic)</p>
     * 
     * <p>DRU.010-04(code system)</p>
     * 
     * <p>DRU.010-08(mnemonic)</p>
     * 
     * <p>DRU.010-09(code system)</p>
     * 
     * <p>DRU.100-04 (mnemonic)</p>
     * 
     * <p>DRU.100-05 (code system)</p>
     * 
     * <p>Compound.488-RE (code system)</p>
     * 
     * <p>Compound.489-TE (mnemonic)</p>
     * 
     * <p>DUR/PPS.475-J9 (code system)</p>
     * 
     * <p>DUR/PPS.476-H6 (mnemonic)</p>
     * 
     * <p>Claim.436-E1 (code system)</p>
     * 
     * <p>Claim.407-D7 (mnemonic)</p>
     * 
     * <p>Claim.453-EJ (code system)</p>
     * 
     * <p>Claim.445-EA (mnemonic)</p>
     * 
     * <p>Claim.406-D6 (determined from code system)</p>
     * 
     * <p>RXA.5</p>
     * 
     * <p>A_BillablePharmacyDispense</p>
     * 
     * <p>Used to ensure clear communication by uniquely 
     * identifying a particular drug product when prescribing or 
     * dispensing. This attribute is only marked as 'populated' 
     * because some custom compounds will not have unique 
     * identifiers Datatype is CD to support SNOMED CT(R) as well 
     * as translation between multiple code sets for drugs (e.g. 
     * DIN, GTIN, UPC).</p>
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
     * <p>Relationship: COCT_MT220110CA.Medicine.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>DrugProduct.activeIngredientId</p>
     * 
     * <p>DrugProduct.ActiveIngredientGroupNumber</p>
     * 
     * <p>DrugProduct.DIN</p>
     * 
     * <p>DrugProduct.StandardProductId (Mnemonic)</p>
     * 
     * <p>DrugProduct.StandardIDType(Code System)</p>
     * 
     * <p>D56(use code system to distinguish different types)</p>
     * 
     * <p>ZPB2.1</p>
     * 
     * <p>ZPB3.1</p>
     * 
     * <p>ZPC.1</p>
     * 
     * <p>ZPC1.3</p>
     * 
     * <p>ZPD.1</p>
     * 
     * <p>ZPD1.1</p>
     * 
     * <p>ZPD.6(scoping a specialized kind of therapeutic 
     * equivalent)</p>
     * 
     * <p>MB.05.03B</p>
     * 
     * <p>ZPS.11</p>
     * 
     * <p>ZDP.3a(code system)</p>
     * 
     * <p>ZDU.4.1</p>
     * 
     * <p>ZDP.7</p>
     * 
     * <p>DRU.010-03(mnemonic)</p>
     * 
     * <p>DRU.010-04(code system)</p>
     * 
     * <p>DRU.010-08(mnemonic)</p>
     * 
     * <p>DRU.010-09(code system)</p>
     * 
     * <p>DRU.100-04 (mnemonic)</p>
     * 
     * <p>DRU.100-05 (code system)</p>
     * 
     * <p>Compound.488-RE (code system)</p>
     * 
     * <p>Compound.489-TE (mnemonic)</p>
     * 
     * <p>DUR/PPS.475-J9 (code system)</p>
     * 
     * <p>DUR/PPS.476-H6 (mnemonic)</p>
     * 
     * <p>Claim.436-E1 (code system)</p>
     * 
     * <p>Claim.407-D7 (mnemonic)</p>
     * 
     * <p>Claim.453-EJ (code system)</p>
     * 
     * <p>Claim.445-EA (mnemonic)</p>
     * 
     * <p>Claim.406-D6 (determined from code system)</p>
     * 
     * <p>RXA.5</p>
     * 
     * <p>A_BillablePharmacyDispense</p>
     * 
     * <p>Used to ensure clear communication by uniquely 
     * identifying a particular drug product when prescribing or 
     * dispensing. This attribute is only marked as 'populated' 
     * because some custom compounds will not have unique 
     * identifiers Datatype is CD to support SNOMED CT(R) as well 
     * as translation between multiple code sets for drugs (e.g. 
     * DIN, GTIN, UPC).</p>
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
     * <p>Business Name: B:Drug Name</p>
     * 
     * <p>Relationship: COCT_MT220110CA.Medicine.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>DrugProduct.Name (Search)</p>
     * 
     * <p>CoumpoundDrugProduct.name</p>
     * 
     * <p>Contraindication.interactingDrugName</p>
     * 
     * <p>DrugProduct.labelName(useCode=L)</p>
     * 
     * <p>ZPB2.2</p>
     * 
     * <p>ZPB3.2</p>
     * 
     * <p>ZPC.2</p>
     * 
     * <p>ZPD.2</p>
     * 
     * <p>ZPD1.2</p>
     * 
     * <p>ZPD.5</p>
     * 
     * <p>MB.01.03</p>
     * 
     * <p>Drug Name</p>
     * 
     * <p>ZDU.4.2</p>
     * 
     * <p>ZDU.6.1.1</p>
     * 
     * <p>DRU.010-02</p>
     * 
     * <p>RXA.TradeName</p>
     * 
     * <p>DRU.010-10-&gt;12</p>
     * 
     * <p>Brand Name</p>
     * 
     * <p>C.1a</p>
     * 
     * <p>Trade Name</p>
     * 
     * <p>Other Name</p>
     * 
     * <p>Names are used for human reference communication, to 
     * allow selection from dropdowns and for local searching. If a 
     * code is available, the name acts as a cross-check. If the 
     * code is not available the name acts as the primary 
     * identifier. The attribute is therefore mandatory.</p>
     * 
     * <p>First occurrence is preferred for display.</p>
     * 
     * <p>The name assigned to a drug.</p>
     */
    @Hl7XmlMapping({"player/name"})
    public String getPlayerName() {
        return this.playerName.getValue();
    }

    /**
     * <p>Business Name: B:Drug Name</p>
     * 
     * <p>Relationship: COCT_MT220110CA.Medicine.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>DrugProduct.Name (Search)</p>
     * 
     * <p>CoumpoundDrugProduct.name</p>
     * 
     * <p>Contraindication.interactingDrugName</p>
     * 
     * <p>DrugProduct.labelName(useCode=L)</p>
     * 
     * <p>ZPB2.2</p>
     * 
     * <p>ZPB3.2</p>
     * 
     * <p>ZPC.2</p>
     * 
     * <p>ZPD.2</p>
     * 
     * <p>ZPD1.2</p>
     * 
     * <p>ZPD.5</p>
     * 
     * <p>MB.01.03</p>
     * 
     * <p>Drug Name</p>
     * 
     * <p>ZDU.4.2</p>
     * 
     * <p>ZDU.6.1.1</p>
     * 
     * <p>DRU.010-02</p>
     * 
     * <p>RXA.TradeName</p>
     * 
     * <p>DRU.010-10-&gt;12</p>
     * 
     * <p>Brand Name</p>
     * 
     * <p>C.1a</p>
     * 
     * <p>Trade Name</p>
     * 
     * <p>Other Name</p>
     * 
     * <p>Names are used for human reference communication, to 
     * allow selection from dropdowns and for local searching. If a 
     * code is available, the name acts as a cross-check. If the 
     * code is not available the name acts as the primary 
     * identifier. The attribute is therefore mandatory.</p>
     * 
     * <p>First occurrence is preferred for display.</p>
     * 
     * <p>The name assigned to a drug.</p>
     */
    public void setPlayerName(String playerName) {
        this.playerName.setValue(playerName);
    }


    /**
     * <p>Business Name: C:Drug Description</p>
     * 
     * <p>Relationship: COCT_MT220110CA.Medicine.desc</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>DrugProduct.description</p>
     * 
     * <p>CompoundedDrugProduct.adhocSpecification</p>
     * 
     * <p>DRU.010-06</p>
     * 
     * <p>DIN Description</p>
     * 
     * <p>Allows description of compound ingredients and/or recipe 
     * in free text form.</p>
     * 
     * <p>A free form textual description of a drug. This usually 
     * is only populated for custom compounds, providing 
     * instructions on the composition and creation of the 
     * compound.</p>
     */
    @Hl7XmlMapping({"player/desc"})
    public String getPlayerDesc() {
        return this.playerDesc.getValue();
    }

    /**
     * <p>Business Name: C:Drug Description</p>
     * 
     * <p>Relationship: COCT_MT220110CA.Medicine.desc</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>DrugProduct.description</p>
     * 
     * <p>CompoundedDrugProduct.adhocSpecification</p>
     * 
     * <p>DRU.010-06</p>
     * 
     * <p>DIN Description</p>
     * 
     * <p>Allows description of compound ingredients and/or recipe 
     * in free text form.</p>
     * 
     * <p>A free form textual description of a drug. This usually 
     * is only populated for custom compounds, providing 
     * instructions on the composition and creation of the 
     * compound.</p>
     */
    public void setPlayerDesc(String playerDesc) {
        this.playerDesc.setValue(playerDesc);
    }


    /**
     * <p>Business Name: D:Drug Form</p>
     * 
     * <p>Relationship: COCT_MT220110CA.Medicine.formCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Prescription.dosageForm</p>
     * 
     * <p>DrugProduct.dosageForm</p>
     * 
     * <p>CompoundedDrugProduct.dosageForm</p>
     * 
     * <p>DispensedItem.dosageForm</p>
     * 
     * <p>D63</p>
     * 
     * <p>ZPC.3</p>
     * 
     * <p>ZPD.3</p>
     * 
     * <p>Drug form</p>
     * 
     * <p>ZDP.14.1</p>
     * 
     * <p>ZDP.3b</p>
     * 
     * <p>DRU.010-05</p>
     * 
     * <p>Compound.450-EF</p>
     * 
     * <p>A_BillablePharmacyDispense</p>
     * 
     * <p>Dosage Form</p>
     * 
     * <p>Dosage Form</p>
     * 
     * <p>Provides a constrained vocabulary for describing dose 
     * forms. The form of the drug influences how it can be used by 
     * the patient.</p>
     * 
     * <p>Must be recorded if the Drug Id does not specify the Drug 
     * Form.</p>
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
     * <p>Relationship: COCT_MT220110CA.Medicine.formCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Prescription.dosageForm</p>
     * 
     * <p>DrugProduct.dosageForm</p>
     * 
     * <p>CompoundedDrugProduct.dosageForm</p>
     * 
     * <p>DispensedItem.dosageForm</p>
     * 
     * <p>D63</p>
     * 
     * <p>ZPC.3</p>
     * 
     * <p>ZPD.3</p>
     * 
     * <p>Drug form</p>
     * 
     * <p>ZDP.14.1</p>
     * 
     * <p>ZDP.3b</p>
     * 
     * <p>DRU.010-05</p>
     * 
     * <p>Compound.450-EF</p>
     * 
     * <p>A_BillablePharmacyDispense</p>
     * 
     * <p>Dosage Form</p>
     * 
     * <p>Dosage Form</p>
     * 
     * <p>Provides a constrained vocabulary for describing dose 
     * forms. The form of the drug influences how it can be used by 
     * the patient.</p>
     * 
     * <p>Must be recorded if the Drug Id does not specify the Drug 
     * Form.</p>
     * 
     * <p>Indicates the form in which the drug product must be, or 
     * has been manufactured or custom prepared.</p>
     */
    public void setPlayerFormCode(OrderableDrugForm playerFormCode) {
        this.playerFormCode.setValue(playerFormCode);
    }


    /**
     * <p>Relationship: 
     * COCT_MT220110CA.ManufacturedProduct.manufacturer</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"player/asManufacturedProduct/manufacturer"})
    public ManufacturerBean getPlayerAsManufacturedProductManufacturer() {
        return this.playerAsManufacturedProductManufacturer;
    }

    /**
     * <p>Relationship: 
     * COCT_MT220110CA.ManufacturedProduct.manufacturer</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setPlayerAsManufacturedProductManufacturer(ManufacturerBean playerAsManufacturedProductManufacturer) {
        this.playerAsManufacturedProductManufacturer = playerAsManufacturedProductManufacturer;
    }


    /**
     * <p>Relationship: COCT_MT220110CA.Medicine.asContent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"player/asContent"})
    public DispensedInBean getPlayerAsContent() {
        return this.playerAsContent;
    }

    /**
     * <p>Relationship: COCT_MT220110CA.Medicine.asContent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setPlayerAsContent(DispensedInBean playerAsContent) {
        this.playerAsContent = playerAsContent;
    }


    /**
     * <p>Relationship: COCT_MT220110CA.Medicine.ingredient</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-50)</p>
     */
    @Hl7XmlMapping({"player/ingredient"})
    public List<DrugContainsBean> getPlayerIngredient() {
        return this.playerIngredient;
    }

}
