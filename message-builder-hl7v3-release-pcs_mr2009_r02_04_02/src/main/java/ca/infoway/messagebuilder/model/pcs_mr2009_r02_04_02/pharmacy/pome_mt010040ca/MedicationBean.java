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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pharmacy.pome_mt010040ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pharmacy.merged.AppearanceCharacteristicsBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pharmacy.merged.DrugCostBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pharmacy.merged.MonographsBean;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>Medication</p>
 * 
 * <p>Represents a particular medicine or herbal product which 
 * might be prescribed or administered.</p>
 * 
 * <p>Allows retrieval of details about a product at a 
 * particular level of granularity (therapeutic class, generic, 
 * manufactured, etc.)</p>
 */
@Hl7PartTypeMapping({"POME_MT010040CA.AdministerableMaterial"})
@Hl7RootType
public class MedicationBean extends MessagePartBean {

    private static final long serialVersionUID = 20121122L;
    private DrugOrCompoundBean administerableMedicine;
    private List<MonographsBean> subjectOf1Document = new ArrayList<MonographsBean>();
    private List<MonitoringProgramsBean> subjectOf2MonitoringProgram = new ArrayList<MonitoringProgramsBean>();
    private List<AppearanceCharacteristicsBean> subjectOf3Characteristic = new ArrayList<AppearanceCharacteristicsBean>();
    private DrugCostBean subjectOf4PotentialCharge;
    private DrugHalfLifeBean subjectOf5HalfLife;
    private List<RecommendedAdministrationInstructionsBean> consumedInAdministrationGuideline = new ArrayList<RecommendedAdministrationInstructionsBean>();
    private DispenseInformationBean productOf1DispenseGuidelines;
    private List<FormulariesBean> productOf2PotentialSupply = new ArrayList<FormulariesBean>();


    @Hl7XmlMapping({"administerableMedicine"})
    public DrugOrCompoundBean getAdministerableMedicine() {
        return this.administerableMedicine;
    }

    public void setAdministerableMedicine(DrugOrCompoundBean administerableMedicine) {
        this.administerableMedicine = administerableMedicine;
    }


    @Hl7XmlMapping({"subjectOf1/document"})
    public List<MonographsBean> getSubjectOf1Document() {
        return this.subjectOf1Document;
    }


    @Hl7XmlMapping({"subjectOf2/monitoringProgram"})
    public List<MonitoringProgramsBean> getSubjectOf2MonitoringProgram() {
        return this.subjectOf2MonitoringProgram;
    }


    @Hl7XmlMapping({"subjectOf3/characteristic"})
    public List<AppearanceCharacteristicsBean> getSubjectOf3Characteristic() {
        return this.subjectOf3Characteristic;
    }


    @Hl7XmlMapping({"subjectOf4/potentialCharge"})
    public DrugCostBean getSubjectOf4PotentialCharge() {
        return this.subjectOf4PotentialCharge;
    }

    public void setSubjectOf4PotentialCharge(DrugCostBean subjectOf4PotentialCharge) {
        this.subjectOf4PotentialCharge = subjectOf4PotentialCharge;
    }


    @Hl7XmlMapping({"subjectOf5/halfLife"})
    public DrugHalfLifeBean getSubjectOf5HalfLife() {
        return this.subjectOf5HalfLife;
    }

    public void setSubjectOf5HalfLife(DrugHalfLifeBean subjectOf5HalfLife) {
        this.subjectOf5HalfLife = subjectOf5HalfLife;
    }


    @Hl7XmlMapping({"consumedIn/administrationGuideline"})
    public List<RecommendedAdministrationInstructionsBean> getConsumedInAdministrationGuideline() {
        return this.consumedInAdministrationGuideline;
    }


    @Hl7XmlMapping({"productOf1/dispenseGuidelines"})
    public DispenseInformationBean getProductOf1DispenseGuidelines() {
        return this.productOf1DispenseGuidelines;
    }

    public void setProductOf1DispenseGuidelines(DispenseInformationBean productOf1DispenseGuidelines) {
        this.productOf1DispenseGuidelines = productOf1DispenseGuidelines;
    }


    @Hl7XmlMapping({"productOf2/potentialSupply"})
    public List<FormulariesBean> getProductOf2PotentialSupply() {
        return this.productOf2PotentialSupply;
    }

}
