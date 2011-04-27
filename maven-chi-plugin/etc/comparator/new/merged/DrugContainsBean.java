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
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.ActiveIngredientDrugEntityType;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"COCT_MT220100CA.Ingredient","COCT_MT220110CA.Ingredient","COCT_MT220200CA.Ingredient","COCT_MT220210CA.Ingredient","POME_MT010040CA.Ingredient","POME_MT010100CA.Ingredient"})
public class DrugContainsBean extends MessagePartBean {

    private BL doesNotContainIndicator = new BLImpl();
    private PQ ingredientQuantity = new PQImpl();
    private CV<ActiveIngredientDrugEntityType> drugIngredientIdentifier = new CVImpl<ActiveIngredientDrugEntityType>();
    private ST drugIngredientName = new STImpl();

    @Hl7XmlMapping({"negationInd"})
    public java.lang.Boolean getDoesNotContainIndicator() {
        return this.doesNotContainIndicator.getValue();
    }
    public void setDoesNotContainIndicator(java.lang.Boolean doesNotContainIndicator) {
        this.doesNotContainIndicator.setValue(doesNotContainIndicator);
    }

    @Hl7XmlMapping({"quantity"})
    public PhysicalQuantity getIngredientQuantity() {
        return this.ingredientQuantity.getValue();
    }
    public void setIngredientQuantity(PhysicalQuantity ingredientQuantity) {
        this.ingredientQuantity.setValue(ingredientQuantity);
    }

    @Hl7XmlMapping({"ingredient/code"})
    public ActiveIngredientDrugEntityType getDrugIngredientIdentifier() {
        return this.drugIngredientIdentifier.getValue();
    }
    public void setDrugIngredientIdentifier(ActiveIngredientDrugEntityType drugIngredientIdentifier) {
        this.drugIngredientIdentifier.setValue(drugIngredientIdentifier);
    }

    @Hl7XmlMapping({"ingredient/name"})
    public java.lang.String getDrugIngredientName() {
        return this.drugIngredientName.getValue();
    }
    public void setDrugIngredientName(java.lang.String drugIngredientName) {
        this.drugIngredientName.setValue(drugIngredientName);
    }

}
