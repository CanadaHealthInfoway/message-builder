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

package ca.infoway.messagebuilder.model.newfoundland.cerx;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.ActiveIngredientDrugEntityType;
import ca.infoway.messagebuilder.model.MessagePartBean;

@Hl7PartTypeMapping({ "COCT_MT220100CA.Ingredient", "COCT_MT220110CA.Ingredient", "COCT_MT220200CA.Ingredient", "COCT_MT220210CA.Ingredient", "POME_MT010040CA.Ingredient" })
public class DrugIngredientBean extends MessagePartBean implements Serializable {

    private static final long serialVersionUID = -2811747574165380382L;

    private PQ quantity = new PQImpl();

    private ST name = new STImpl();

    private BL negationInd = new BLImpl();

    private CD code = new CDImpl();

    @Hl7XmlMapping("ingredient/name")
    public String getName() {
        return this.name.getValue();
    }

    public void setName(String name) {
        this.name.setValue(name);
    }

    @Hl7XmlMapping("quantity")
    public PhysicalQuantity getQuantity() {
        return this.quantity.getValue();
    }

    public void setQuantity(PhysicalQuantity quantity) {
        this.quantity.setValue(quantity);
    }

    @Hl7XmlMapping("negationInd")
    public Boolean getNegationInd() {
        return this.negationInd.getValue();
    }

    public void setNegationInd(Boolean negationInd) {
        this.negationInd.setValue(negationInd);
    }

    @Hl7XmlMapping("ingredient/code")
    public ActiveIngredientDrugEntityType getCode() {
        return (ActiveIngredientDrugEntityType) this.code.getValue();
    }

    public void setCode(ActiveIngredientDrugEntityType code) {
        this.code.setValue(code);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (getClass() != obj.getClass()) {
            return false;
        } else {
            DrugIngredientBean that = (DrugIngredientBean) obj;
            return new EqualsBuilder().append(this.quantity, that.quantity).append(this.negationInd, that.negationInd).append(this.name, that.name).append(this.code, that.code).isEquals();
        }
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.quantity).append(this.negationInd).append(this.name).append(this.code).toHashCode();
    }
}
