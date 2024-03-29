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
package ca.infoway.messagebuilder.model.nb_drug.pharmacy.pome_mt010040ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.nb_drug.pharmacy.merged.AppearanceCharacteristicsBean;
import ca.infoway.messagebuilder.model.nb_drug.pharmacy.merged.DrugCostBean;
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

    private static final long serialVersionUID = 20190731L;
    private DrugOrCompoundBean player;
    private List<MonographsBean> subjectOf1Document = new ArrayList<MonographsBean>();
    private DrugHalfLifeBean subjectOf2HalfLife;
    private List<AppearanceCharacteristicsBean> subjectOf3Characteristic = new ArrayList<AppearanceCharacteristicsBean>();
    private List<MonitoringProgramsBean> subjectOf4MonitoringProgram = new ArrayList<MonitoringProgramsBean>();
    private DrugCostBean subjectOf5PotentialCharge;
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
     * <p>Relationship: POME_MT010040CA.Subject5.halfLife</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf2/halfLife"})
    public DrugHalfLifeBean getSubjectOf2HalfLife() {
        return this.subjectOf2HalfLife;
    }

    /**
     * <p>Relationship: POME_MT010040CA.Subject5.halfLife</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSubjectOf2HalfLife(DrugHalfLifeBean subjectOf2HalfLife) {
        this.subjectOf2HalfLife = subjectOf2HalfLife;
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
     * <p>Relationship: POME_MT010040CA.Subject7.potentialCharge</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf5/potentialCharge"})
    public DrugCostBean getSubjectOf5PotentialCharge() {
        return this.subjectOf5PotentialCharge;
    }

    /**
     * <p>Relationship: POME_MT010040CA.Subject7.potentialCharge</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSubjectOf5PotentialCharge(DrugCostBean subjectOf5PotentialCharge) {
        this.subjectOf5PotentialCharge = subjectOf5PotentialCharge;
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
