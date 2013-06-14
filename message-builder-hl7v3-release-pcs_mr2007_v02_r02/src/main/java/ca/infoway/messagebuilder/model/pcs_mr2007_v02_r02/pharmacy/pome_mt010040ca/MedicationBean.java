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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pharmacy.pome_mt010040ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.MO;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.impl.MOImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.lang.Money;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pharmacy.merged.AppearanceCharacteristicsBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pharmacy.merged.MonographsBean;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>Business Name: Medication</p>
 * 
 * <p>Allows retrieval of details about a product at a 
 * particular level of granularity (therapeutic class, generic, 
 * manufactured, etc.)</p>
 * 
 * <p>Represents a particular medicine or herbal product which 
 * might be prescribed or administered.</p>
 */
@Hl7PartTypeMapping({"POME_MT010040CA.Medication"})
@Hl7RootType
public class MedicationBean extends MessagePartBean {

    private static final long serialVersionUID = 20130614L;
    private DrugOrCompoundBean player;
    private List<MonographsBean> subjectOf1Document = new ArrayList<MonographsBean>();
    private PQ subjectOf2HalfLifeValue = new PQImpl();
    private List<AppearanceCharacteristicsBean> subjectOf3Characteristic = new ArrayList<AppearanceCharacteristicsBean>();
    private List<MonitoringProgramsBean> subjectOf4MonitoringProgram = new ArrayList<MonitoringProgramsBean>();
    private MO subjectOf5PotentialChargeUnitPriceAmt = new MOImpl();
    private List<RecommendedAdministrationInstructionsBean> consumedInAdministrationGuideline = new ArrayList<RecommendedAdministrationInstructionsBean>();
    private DispenseInformationBean productOf1DispenseGuidelines;
    private List<FormulariesBean> productOf2PotentialSupply = new ArrayList<FormulariesBean>();


    /**
     * <p>Relationship: POME_MT010040CA.Medication.player</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"player"})
    public DrugOrCompoundBean getPlayer() {
        return this.player;
    }

    /**
     * <p>Relationship: POME_MT010040CA.Medication.player</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setPlayer(DrugOrCompoundBean player) {
        this.player = player;
    }


    /**
     * <p>Relationship: POME_MT010040CA.Subject9.document</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf1/document"})
    public List<MonographsBean> getSubjectOf1Document() {
        return this.subjectOf1Document;
    }


    /**
     * <p>Business Name: Half-Life Period</p>
     * 
     * <p>Relationship: POME_MT010040CA.HalfLife.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Depending on the half-life, a drug may remain present and 
     * active in a patient's system long after they cease taking 
     * it. Understanding this time period is essential to 
     * appropriate dosing, and also to identifying when to include 
     * medications in drug-drug interaction checking.</p>
     * 
     * <p>Different drugs are absorbed and degraded by the body at 
     * different rates. The half-life indicates the length of time 
     * necessary for a human body to degrade the drug to half its 
     * original potency. The actual time-period will vary from 
     * person to person based on mass, renal function, liver 
     * function, route of administration and other factors</p>
     */
    @Hl7XmlMapping({"subjectOf2/halfLife/value"})
    public PhysicalQuantity getSubjectOf2HalfLifeValue() {
        return this.subjectOf2HalfLifeValue.getValue();
    }

    /**
     * <p>Business Name: Half-Life Period</p>
     * 
     * <p>Relationship: POME_MT010040CA.HalfLife.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Depending on the half-life, a drug may remain present and 
     * active in a patient's system long after they cease taking 
     * it. Understanding this time period is essential to 
     * appropriate dosing, and also to identifying when to include 
     * medications in drug-drug interaction checking.</p>
     * 
     * <p>Different drugs are absorbed and degraded by the body at 
     * different rates. The half-life indicates the length of time 
     * necessary for a human body to degrade the drug to half its 
     * original potency. The actual time-period will vary from 
     * person to person based on mass, renal function, liver 
     * function, route of administration and other factors</p>
     */
    public void setSubjectOf2HalfLifeValue(PhysicalQuantity subjectOf2HalfLifeValue) {
        this.subjectOf2HalfLifeValue.setValue(subjectOf2HalfLifeValue);
    }


    /**
     * <p>Relationship: POME_MT010040CA.Subject10.characteristic</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf3/characteristic"})
    public List<AppearanceCharacteristicsBean> getSubjectOf3Characteristic() {
        return this.subjectOf3Characteristic;
    }


    /**
     * <p>Relationship: POME_MT010040CA.Subject8.monitoringProgram</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf4/monitoringProgram"})
    public List<MonitoringProgramsBean> getSubjectOf4MonitoringProgram() {
        return this.subjectOf4MonitoringProgram;
    }


    /**
     * <p>Business Name: Drug Cost</p>
     * 
     * <p>Relationship: 
     * POME_MT010040CA.PotentialCharge.unitPriceAmt</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>May influence prescriber and pharmacists decisions as 
     * cost can impact compliance.</p>
     * 
     * <p>The average unit dose cost of the drug.</p>
     */
    @Hl7XmlMapping({"subjectOf5/potentialCharge/unitPriceAmt"})
    public Money getSubjectOf5PotentialChargeUnitPriceAmt() {
        return this.subjectOf5PotentialChargeUnitPriceAmt.getValue();
    }

    /**
     * <p>Business Name: Drug Cost</p>
     * 
     * <p>Relationship: 
     * POME_MT010040CA.PotentialCharge.unitPriceAmt</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>May influence prescriber and pharmacists decisions as 
     * cost can impact compliance.</p>
     * 
     * <p>The average unit dose cost of the drug.</p>
     */
    public void setSubjectOf5PotentialChargeUnitPriceAmt(Money subjectOf5PotentialChargeUnitPriceAmt) {
        this.subjectOf5PotentialChargeUnitPriceAmt.setValue(subjectOf5PotentialChargeUnitPriceAmt);
    }


    /**
     * <p>Relationship: 
     * POME_MT010040CA.Consumable2.administrationGuideline</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"consumedIn/administrationGuideline"})
    public List<RecommendedAdministrationInstructionsBean> getConsumedInAdministrationGuideline() {
        return this.consumedInAdministrationGuideline;
    }


    /**
     * <p>Relationship: POME_MT010040CA.Product2.dispenseGuidelines</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"productOf1/dispenseGuidelines"})
    public DispenseInformationBean getProductOf1DispenseGuidelines() {
        return this.productOf1DispenseGuidelines;
    }

    /**
     * <p>Relationship: POME_MT010040CA.Product2.dispenseGuidelines</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setProductOf1DispenseGuidelines(DispenseInformationBean productOf1DispenseGuidelines) {
        this.productOf1DispenseGuidelines = productOf1DispenseGuidelines;
    }


    /**
     * <p>Relationship: POME_MT010040CA.Product.potentialSupply</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"productOf2/potentialSupply"})
    public List<FormulariesBean> getProductOf2PotentialSupply() {
        return this.productOf2PotentialSupply;
    }

}
