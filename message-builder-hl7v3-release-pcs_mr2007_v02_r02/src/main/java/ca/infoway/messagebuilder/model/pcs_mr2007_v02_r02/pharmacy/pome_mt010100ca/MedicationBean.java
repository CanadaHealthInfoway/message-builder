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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pharmacy.pome_mt010100ca;

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
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.merged.DrugContainsBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.merged.ManufacturerBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pharmacy.merged.AppearanceCharacteristicsBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pharmacy.merged.DispensedInBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pharmacy.merged.DrugCostBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pharmacy.merged.GroupedWithinBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



/**
 * <p>Medication</p>
 * 
 * <p><p>Represents a particular medicine or herbal product 
 * which might be prescribed or administered.</p></p>
 * 
 * <p><p>Allows retrieval of summary about one or more products 
 * when searching for a medication</p></p>
 */
@Hl7PartTypeMapping({"POME_MT010100CA.Medication"})
@Hl7RootType
public class MedicationBean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private CV drugCode = new CVImpl();
    private SET<TN, TrivialName> drugNames = new SETImpl<TN, TrivialName>(TNImpl.class);
    private ST description = new STImpl();
    private CV drugForm = new CVImpl();
    private ManufacturerBean playerAsManufacturedProductManufacturer;
    private CS regulatoryStatusCode = new CSImpl();
    private DispensedInBean playerAsContent;
    private List<GroupedWithinBean> playerAsSpecializedKind = new ArrayList<GroupedWithinBean>();
    private List<DrugContainsBean> playerIngredient = new ArrayList<DrugContainsBean>();
    private DrugCostBean subjectOf1PotentialCharge;
    private List<AppearanceCharacteristicsBean> subjectOf2Characteristic = new ArrayList<AppearanceCharacteristicsBean>();


    /**
     * <p>A:Drug Code</p>
     * 
     * <p><p>An identifier for a type of drug. Depending on where 
     * the drug is being referenced, the drug may be identified at 
     * different levels of abstraction. E.g. Manufactured drug 
     * (including vaccines), generic formulation, generic, 
     * therapeutic class, etc.</p></p>
     * 
     * <p><p>Used to ensure clear communication by uniquely 
     * identifying a particular drug product when prescribing or 
     * dispensing. This attribute is only constrained to 'required' 
     * because some custom compounds will not have unique 
     * identifiers.</p></p>
     */
    @Hl7XmlMapping({"player/code"})
    public ClinicalDrug getDrugCode() {
        return (ClinicalDrug) this.drugCode.getValue();
    }
    public void setDrugCode(ClinicalDrug drugCode) {
        this.drugCode.setValue(drugCode);
    }


    /**
     * <p>B:Drug Names</p>
     * 
     * <p><p>The name assigned to a drug.</p></p>
     * 
     * <p><p>Names are used for human reference communication, to 
     * allow selection from dropdowns and for local searching. Up 
     * to two names are supported: a 'search name' which is fully 
     * formed with no abbreviations, and a 'display name' which may 
     * contain abbreviations to fit within a smaller area on the 
     * screen. Because names are the one attribute that exist for 
     * all attributes, this element is mandatory.</p></p>
     */
    @Hl7XmlMapping({"player/name"})
    public Set<TrivialName> getDrugNames() {
        return this.drugNames.rawSet();
    }


    /**
     * <p>Description</p>
     * 
     * <p><p>A free form textual description of a drug. This 
     * usually is only recorded for custom compounds, providing 
     * instructions on the composition and creation of the 
     * compound.</p></p>
     * 
     * <p><p>Allows description of compound ingredients and/or 
     * recipe in free text form.</p></p>
     */
    @Hl7XmlMapping({"player/desc"})
    public String getDescription() {
        return this.description.getValue();
    }
    public void setDescription(String description) {
        this.description.setValue(description);
    }


    /**
     * <p>D:Drug Form</p>
     * 
     * <p><p>Indicates the form in which the drug product must be, 
     * or has been manufactured or custom prepared.</p></p>
     * 
     * <p><p>Provides a constrained vocabulary for describing dose 
     * forms. The form of the drug influences how it can be used by 
     * the patient.</p></p>
     */
    @Hl7XmlMapping({"player/formCode"})
    public OrderableDrugForm getDrugForm() {
        return (OrderableDrugForm) this.drugForm.getValue();
    }
    public void setDrugForm(OrderableDrugForm drugForm) {
        this.drugForm.setValue(drugForm);
    }


    @Hl7XmlMapping({"player/asManufacturedProduct/manufacturer"})
    public ManufacturerBean getPlayerAsManufacturedProductManufacturer() {
        return this.playerAsManufacturedProductManufacturer;
    }
    public void setPlayerAsManufacturedProductManufacturer(ManufacturerBean playerAsManufacturedProductManufacturer) {
        this.playerAsManufacturedProductManufacturer = playerAsManufacturedProductManufacturer;
    }


    /**
     * <p>Regulatory Status Code</p>
     * 
     * <p><p>Indicates whether the drug is approved for use in 
     * Canada or not. (active = approved for use; pending or 
     * terminated = not approved for use)</p></p>
     * 
     * <p><p>Allows providers to evaluate the validity of the 
     * medication for use in Canada.</p></p>
     */
    @Hl7XmlMapping({"player/asRegulatedProduct/statusCode"})
    public RoleStatusNormal getRegulatoryStatusCode() {
        return (RoleStatusNormal) this.regulatoryStatusCode.getValue();
    }
    public void setRegulatoryStatusCode(RoleStatusNormal regulatoryStatusCode) {
        this.regulatoryStatusCode.setValue(regulatoryStatusCode);
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
