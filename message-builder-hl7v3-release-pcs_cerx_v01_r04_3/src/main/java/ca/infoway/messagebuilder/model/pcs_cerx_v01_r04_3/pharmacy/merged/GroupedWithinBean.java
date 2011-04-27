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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.ClinicalDrug;
import ca.infoway.messagebuilder.domainvalue.MedicationGeneralizationRoleType;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"POME_MT010040CA.SpecializedKind","POME_MT010100CA.SpecializedKind"})
public class GroupedWithinBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private CV drugCategoryCode = new CVImpl();
    private CV drugCode = new CVImpl();
    private ST drugName = new STImpl();


    /**
     * <p>DrugCategoryCode</p>
     * 
     * <p>Drug Category Code</p>
     */
    @Hl7XmlMapping({"code"})
    public MedicationGeneralizationRoleType getDrugCategoryCode() {
        return (MedicationGeneralizationRoleType) this.drugCategoryCode.getValue();
    }
    public void setDrugCategoryCode(MedicationGeneralizationRoleType drugCategoryCode) {
        this.drugCategoryCode.setValue(drugCategoryCode);
    }


    /**
     * <p>DrugCode</p>
     * 
     * <p>Drug Code</p>
     */
    @Hl7XmlMapping({"generalizedMedicineClass/code"})
    public ClinicalDrug getDrugCode() {
        return (ClinicalDrug) this.drugCode.getValue();
    }
    public void setDrugCode(ClinicalDrug drugCode) {
        this.drugCode.setValue(drugCode);
    }


    /**
     * <p>DrugName</p>
     * 
     * <p>Drug Name</p>
     */
    @Hl7XmlMapping({"generalizedMedicineClass/name"})
    public String getDrugName() {
        return this.drugName.getValue();
    }
    public void setDrugName(String drugName) {
        this.drugName.setValue(drugName);
    }

}
