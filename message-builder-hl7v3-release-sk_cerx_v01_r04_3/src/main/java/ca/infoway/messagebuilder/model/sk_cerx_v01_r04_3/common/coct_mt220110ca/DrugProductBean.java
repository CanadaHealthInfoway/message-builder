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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.coct_mt220110ca;

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
import ca.infoway.messagebuilder.domainvalue.FDBDosageForm;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.merged.DispensedInBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.merged.DrugContainsBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.merged.ManufacturerBean;
import java.util.ArrayList;
import java.util.List;



@Hl7PartTypeMapping({"COCT_MT220110CA.Medication"})
@Hl7RootType
public class DrugProductBean extends MessagePartBean implements ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pharmacy.porx_mt980040ca.Medication {

    private static final long serialVersionUID = 20120130L;
    private CD playerCode = new CDImpl();
    private ST playerName = new STImpl();
    private ST playerDesc = new STImpl();
    private CV playerFormCode = new CVImpl();
    private ManufacturerBean playerAsManufacturedProductManufacturer;
    private DispensedInBean playerAsContent;
    private List<DrugContainsBean> playerIngredient = new ArrayList<DrugContainsBean>();


    /**
     * <p>A:Drug Code</p>
     */
    @Hl7XmlMapping({"player/code"})
    public ClinicalDrug getPlayerCode() {
        return (ClinicalDrug) this.playerCode.getValue();
    }
    public void setPlayerCode(ClinicalDrug playerCode) {
        this.playerCode.setValue(playerCode);
    }


    /**
     * <p>B:Drug Name</p>
     * 
     * <p></font></font></font></b></p></p>
     */
    @Hl7XmlMapping({"player/name"})
    public String getPlayerName() {
        return this.playerName.getValue();
    }
    public void setPlayerName(String playerName) {
        this.playerName.setValue(playerName);
    }


    /**
     * <p>C:Drug Description</p>
     * 
     * <p></font></font></font></b></p></p>
     */
    @Hl7XmlMapping({"player/desc"})
    public String getPlayerDesc() {
        return this.playerDesc.getValue();
    }
    public void setPlayerDesc(String playerDesc) {
        this.playerDesc.setValue(playerDesc);
    }


    /**
     * <p>D:Drug Form</p>
     */
    @Hl7XmlMapping({"player/formCode"})
    public FDBDosageForm getPlayerFormCode() {
        return (FDBDosageForm) this.playerFormCode.getValue();
    }
    public void setPlayerFormCode(FDBDosageForm playerFormCode) {
        this.playerFormCode.setValue(playerFormCode);
    }


    @Hl7XmlMapping({"player/asManufacturedProduct/manufacturer"})
    public ManufacturerBean getPlayerAsManufacturedProductManufacturer() {
        return this.playerAsManufacturedProductManufacturer;
    }
    public void setPlayerAsManufacturedProductManufacturer(ManufacturerBean playerAsManufacturedProductManufacturer) {
        this.playerAsManufacturedProductManufacturer = playerAsManufacturedProductManufacturer;
    }


    @Hl7XmlMapping({"player/asContent"})
    public DispensedInBean getPlayerAsContent() {
        return this.playerAsContent;
    }
    public void setPlayerAsContent(DispensedInBean playerAsContent) {
        this.playerAsContent = playerAsContent;
    }


    @Hl7XmlMapping({"player/ingredient"})
    public List<DrugContainsBean> getPlayerIngredient() {
        return this.playerIngredient;
    }

}
