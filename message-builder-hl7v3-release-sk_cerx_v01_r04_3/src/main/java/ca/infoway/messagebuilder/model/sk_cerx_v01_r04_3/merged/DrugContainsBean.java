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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"COCT_MT220100CA.Ingredient","COCT_MT220110CA.Ingredient","COCT_MT220200CA.Ingredient","COCT_MT220210CA.Ingredient","POME_MT010040CA.Ingredient","POME_MT010100CA.Ingredient"})
public class DrugContainsBean extends MessagePartBean {

    private static final long serialVersionUID = 20110901L;
    private BL negationInd = new BLImpl();
    private PQ quantity = new PQImpl();
    private DrugIngredientsBean ingredient;


    /**
     * <p>L:Does Not Contain Indicator</p>
     * 
     * <p>D:Drug Does Not Contain Indicator</p>
     * 
     * <p>Does Not Contain Indicator</p>
     */
    @Hl7XmlMapping({"negationInd"})
    public Boolean getNegationInd() {
        return this.negationInd.getValue();
    }
    public void setNegationInd(Boolean negationInd) {
        this.negationInd.setValue(negationInd);
    }


    /**
     * <p>Ingredient Quantity</p>
     * 
     * <p>C:Drug Ingredient Quantity</p>
     * 
     * <p>M:Ingredient Quantity</p>
     */
    @Hl7XmlMapping({"quantity"})
    public PhysicalQuantity getQuantity() {
        return this.quantity.getValue();
    }
    public void setQuantity(PhysicalQuantity quantity) {
        this.quantity.setValue(quantity);
    }


    @Hl7XmlMapping({"ingredient"})
    public DrugIngredientsBean getIngredient() {
        return this.ingredient;
    }
    public void setIngredient(DrugIngredientsBean ingredient) {
        this.ingredient = ingredient;
    }

}
