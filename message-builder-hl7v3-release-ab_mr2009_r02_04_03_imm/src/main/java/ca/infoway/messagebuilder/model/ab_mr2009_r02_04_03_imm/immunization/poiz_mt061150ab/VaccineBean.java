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
package ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03_imm.immunization.poiz_mt061150ab;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.ClinicalDrug;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03_imm.merged.ManufacturerBean;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>Business Name: Vaccine</p>
 * 
 * <p>Allows vaccines to be clearly described and referenced. 
 * Also allows searching for and examining information about 
 * vaccines that have been administered to a patient.</p>
 * 
 * <p>A pharmaceutical product to be supplied and/or 
 * administered to a patient. Encompasses manufactured vaccines 
 * and generic classifications.</p>
 */
@Hl7PartTypeMapping({"POIZ_MT061150AB.Vaccine"})
public class VaccineBean extends MessagePartBean {

    private static final long serialVersionUID = 20190731L;
    private CV code = new CVImpl();
    private ST lotNumberText = new STImpl();
    private ManufacturerBean asManufacturedProductManufacturer;
    private List<AntigenBean> ingredientsIngredientAntigen = new ArrayList<AntigenBean>();


    /**
     * <p>Business Name: Vaccine Code</p>
     * 
     * <p>Relationship: POIZ_MT061150AB.Vaccine.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used to ensure clear communication by uniquely 
     * identifying a particular drug product when prescribing or 
     * dispensing. This attribute is mandatory because it is 
     * expected that vaccine codes will always be specified.</p>
     * 
     * <p>An identifier for a type of drug. Depending on where the 
     * drug is being referenced, the drug may be identified at 
     * different levels of abstraction. E.g. Manufactured drug 
     * (including vaccine).</p>
     */
    @Hl7XmlMapping({"code"})
    public ClinicalDrug getCode() {
        return (ClinicalDrug) this.code.getValue();
    }

    /**
     * <p>Business Name: Vaccine Code</p>
     * 
     * <p>Relationship: POIZ_MT061150AB.Vaccine.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used to ensure clear communication by uniquely 
     * identifying a particular drug product when prescribing or 
     * dispensing. This attribute is mandatory because it is 
     * expected that vaccine codes will always be specified.</p>
     * 
     * <p>An identifier for a type of drug. Depending on where the 
     * drug is being referenced, the drug may be identified at 
     * different levels of abstraction. E.g. Manufactured drug 
     * (including vaccine).</p>
     */
    public void setCode(ClinicalDrug code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: Vaccine Lot Number</p>
     * 
     * <p>Relationship: POIZ_MT061150AB.Vaccine.lotNumberText</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Useful in tracking for recalls but may not always be 
     * known (e.g. historical immunization records).</p>
     * 
     * <p>Identification of a batch in which a specific 
     * manufactured drug belongs.</p>
     */
    @Hl7XmlMapping({"lotNumberText"})
    public String getLotNumberText() {
        return this.lotNumberText.getValue();
    }

    /**
     * <p>Business Name: Vaccine Lot Number</p>
     * 
     * <p>Relationship: POIZ_MT061150AB.Vaccine.lotNumberText</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Useful in tracking for recalls but may not always be 
     * known (e.g. historical immunization records).</p>
     * 
     * <p>Identification of a batch in which a specific 
     * manufactured drug belongs.</p>
     */
    public void setLotNumberText(String lotNumberText) {
        this.lotNumberText.setValue(lotNumberText);
    }


    /**
     * <p>Relationship: 
     * POIZ_MT061150AB.ManufacturedProduct.manufacturer</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"asManufacturedProduct/manufacturer"})
    public ManufacturerBean getAsManufacturedProductManufacturer() {
        return this.asManufacturedProductManufacturer;
    }

    /**
     * <p>Relationship: 
     * POIZ_MT061150AB.ManufacturedProduct.manufacturer</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAsManufacturedProductManufacturer(ManufacturerBean asManufacturedProductManufacturer) {
        this.asManufacturedProductManufacturer = asManufacturedProductManufacturer;
    }


    /**
     * <p>Relationship: 
     * POIZ_MT061150AB.Ingredients.ingredientAntigen</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"ingredients/ingredientAntigen"})
    public List<AntigenBean> getIngredientsIngredientAntigen() {
        return this.ingredientsIngredientAntigen;
    }

}
