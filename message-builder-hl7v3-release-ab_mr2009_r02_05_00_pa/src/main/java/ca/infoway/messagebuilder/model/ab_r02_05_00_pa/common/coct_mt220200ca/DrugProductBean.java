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
package ca.infoway.messagebuilder.model.ab_r02_05_00_pa.common.coct_mt220200ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ManufacturedDrug;
import ca.infoway.messagebuilder.domainvalue.OrderableDrugForm;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.merged.DispensedInBean;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.merged.DrugContainsBean;
import java.util.ArrayList;
import java.util.Date;
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
 * <p>A pharmaceutical product to be supplied and/or 
 * administered to a patient. Encompasses manufactured drug 
 * products, generic classifications, prescription medications, 
 * over-the-counter medications and recreational drugs.</p>
 */
@Hl7PartTypeMapping({"COCT_MT220200CA.Medication"})
@Hl7RootType
public class DrugProductBean extends MessagePartBean implements ca.infoway.messagebuilder.model.ab_r02_05_00_pa.common.coct_mt270010ca.Medication {

    private static final long serialVersionUID = 20140501L;
    private CD administerableMedicineCode = new CDImpl();
    private ST administerableMedicineName = new STImpl();
    private ST administerableMedicineDesc = new STImpl();
    private CV administerableMedicineFormCode = new CVImpl();
    private ST administerableMedicineLotNumberText = new STImpl();
    private IVL<TS, Interval<Date>> administerableMedicineExpirationTime = new IVLImpl<TS, Interval<Date>>();
    private DispensedInBean administerableMedicineAsContent;
    private List<DrugContainsBean> administerableMedicineIngredient = new ArrayList<DrugContainsBean>();


    /**
     * <p>Business Name: A:Drug Code</p>
     * 
     * <p>Relationship: COCT_MT220200CA.Medicine.code</p>
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
     * identifiers. Datatype is CD to support SNOMED CT.</p>
     * 
     * <p>An identifier for a type of drug. Depending on where the 
     * drug is being referenced, the drug may be identified at 
     * different levels of abstraction. E.g. Manufactured drug 
     * (including vaccine).</p>
     */
    @Hl7XmlMapping({"administerableMedicine/code"})
    public ManufacturedDrug getAdministerableMedicineCode() {
        return (ManufacturedDrug) this.administerableMedicineCode.getValue();
    }

    /**
     * <p>Business Name: A:Drug Code</p>
     * 
     * <p>Relationship: COCT_MT220200CA.Medicine.code</p>
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
     * identifiers. Datatype is CD to support SNOMED CT.</p>
     * 
     * <p>An identifier for a type of drug. Depending on where the 
     * drug is being referenced, the drug may be identified at 
     * different levels of abstraction. E.g. Manufactured drug 
     * (including vaccine).</p>
     */
    public void setAdministerableMedicineCode(ManufacturedDrug administerableMedicineCode) {
        this.administerableMedicineCode.setValue(administerableMedicineCode);
    }


    /**
     * <p>Business Name: B:Drug Name</p>
     * 
     * <p>Relationship: COCT_MT220200CA.Medicine.name</p>
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
    @Hl7XmlMapping({"administerableMedicine/name"})
    public String getAdministerableMedicineName() {
        return this.administerableMedicineName.getValue();
    }

    /**
     * <p>Business Name: B:Drug Name</p>
     * 
     * <p>Relationship: COCT_MT220200CA.Medicine.name</p>
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
    public void setAdministerableMedicineName(String administerableMedicineName) {
        this.administerableMedicineName.setValue(administerableMedicineName);
    }


    /**
     * <p>Business Name: C:Drug Description</p>
     * 
     * <p>Relationship: COCT_MT220200CA.Medicine.desc</p>
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
    @Hl7XmlMapping({"administerableMedicine/desc"})
    public String getAdministerableMedicineDesc() {
        return this.administerableMedicineDesc.getValue();
    }

    /**
     * <p>Business Name: C:Drug Description</p>
     * 
     * <p>Relationship: COCT_MT220200CA.Medicine.desc</p>
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
    public void setAdministerableMedicineDesc(String administerableMedicineDesc) {
        this.administerableMedicineDesc.setValue(administerableMedicineDesc);
    }


    /**
     * <p>Business Name: D:Drug Form</p>
     * 
     * <p>Relationship: COCT_MT220200CA.Medicine.formCode</p>
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
     * <p>Must be populated if the Drug Id does not specify the 
     * Drug Form.</p>
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
     * <p>Relationship: COCT_MT220200CA.Medicine.formCode</p>
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
     * <p>Must be populated if the Drug Id does not specify the 
     * Drug Form.</p>
     * 
     * <p>Indicates the form in which the drug product must be, or 
     * has been manufactured or custom prepared.</p>
     */
    public void setAdministerableMedicineFormCode(OrderableDrugForm administerableMedicineFormCode) {
        this.administerableMedicineFormCode.setValue(administerableMedicineFormCode);
    }


    /**
     * <p>Business Name: E:Drug Lot Number</p>
     * 
     * <p>Relationship: COCT_MT220200CA.Medicine.lotNumberText</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>X0301</p>
     * 
     * <p>RXA.15</p>
     * 
     * <p>C.6</p>
     * 
     * <p>Useful in tracking for recalls but may not always 
     * exist.</p>
     * 
     * <p>Identification of a batch in which a specific 
     * manufactured drug belongs.</p>
     */
    @Hl7XmlMapping({"administerableMedicine/lotNumberText"})
    public String getAdministerableMedicineLotNumberText() {
        return this.administerableMedicineLotNumberText.getValue();
    }

    /**
     * <p>Business Name: E:Drug Lot Number</p>
     * 
     * <p>Relationship: COCT_MT220200CA.Medicine.lotNumberText</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>X0301</p>
     * 
     * <p>RXA.15</p>
     * 
     * <p>C.6</p>
     * 
     * <p>Useful in tracking for recalls but may not always 
     * exist.</p>
     * 
     * <p>Identification of a batch in which a specific 
     * manufactured drug belongs.</p>
     */
    public void setAdministerableMedicineLotNumberText(String administerableMedicineLotNumberText) {
        this.administerableMedicineLotNumberText.setValue(administerableMedicineLotNumberText);
    }


    /**
     * <p>Business Name: F:Drug Expiry Date</p>
     * 
     * <p>Relationship: COCT_MT220200CA.Medicine.expirationTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>DispensedItem.expiryDate</p>
     * 
     * <p>Drug Expiry Date</p>
     * 
     * <p>C7</p>
     * 
     * <p>The potency, effectiveness and safety of drug products 
     * changes over time. When determining quantities to be 
     * supplied to a patient, one of the considerations is how long 
     * the drug will remain viable.</p>
     * 
     * <p>To indicate the length of time after opening a product 
     * remains viable, specify the 'Width' property. To indicate a 
     * specific end date for an actual dispensed product, specify 
     * the 'High' property</p>
     * 
     * <p>Indicates either the length of time a drug product can 
     * remain viable (when talking about a drug in general terms), 
     * or the date on which the drug product is no longer 
     * considered viable (when talking about a specific medication 
     * that has been dispensed).</p>
     */
    @Hl7XmlMapping({"administerableMedicine/expirationTime"})
    public Interval<Date> getAdministerableMedicineExpirationTime() {
        return this.administerableMedicineExpirationTime.getValue();
    }

    /**
     * <p>Business Name: F:Drug Expiry Date</p>
     * 
     * <p>Relationship: COCT_MT220200CA.Medicine.expirationTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>DispensedItem.expiryDate</p>
     * 
     * <p>Drug Expiry Date</p>
     * 
     * <p>C7</p>
     * 
     * <p>The potency, effectiveness and safety of drug products 
     * changes over time. When determining quantities to be 
     * supplied to a patient, one of the considerations is how long 
     * the drug will remain viable.</p>
     * 
     * <p>To indicate the length of time after opening a product 
     * remains viable, specify the 'Width' property. To indicate a 
     * specific end date for an actual dispensed product, specify 
     * the 'High' property</p>
     * 
     * <p>Indicates either the length of time a drug product can 
     * remain viable (when talking about a drug in general terms), 
     * or the date on which the drug product is no longer 
     * considered viable (when talking about a specific medication 
     * that has been dispensed).</p>
     */
    public void setAdministerableMedicineExpirationTime(Interval<Date> administerableMedicineExpirationTime) {
        this.administerableMedicineExpirationTime.setValue(administerableMedicineExpirationTime);
    }


    /**
     * <p>Relationship: COCT_MT220200CA.Medicine.asContent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"administerableMedicine/asContent"})
    public DispensedInBean getAdministerableMedicineAsContent() {
        return this.administerableMedicineAsContent;
    }

    /**
     * <p>Relationship: COCT_MT220200CA.Medicine.asContent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setAdministerableMedicineAsContent(DispensedInBean administerableMedicineAsContent) {
        this.administerableMedicineAsContent = administerableMedicineAsContent;
    }


    /**
     * <p>Relationship: COCT_MT220200CA.Medicine.ingredient</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-50)</p>
     */
    @Hl7XmlMapping({"administerableMedicine/ingredient"})
    public List<DrugContainsBean> getAdministerableMedicineIngredient() {
        return this.administerableMedicineIngredient;
    }

}
