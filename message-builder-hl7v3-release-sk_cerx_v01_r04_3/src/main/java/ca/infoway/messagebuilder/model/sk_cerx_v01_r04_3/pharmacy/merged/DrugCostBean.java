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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.MO;
import ca.infoway.messagebuilder.datatype.impl.MOImpl;
import ca.infoway.messagebuilder.datatype.lang.Money;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"POME_MT010040CA.PotentialCharge","POME_MT010100CA.PotentialCharge"})
public class DrugCostBean extends MessagePartBean {

    private static final long serialVersionUID = 20120130L;
    private MO unitPriceAmt = new MOImpl();


    /**
     * <p>DrugCost</p>
     * 
     * <p>Drug Cost</p>
     * 
     * <p>I:Drug Cost</p>
     */
    @Hl7XmlMapping({"unitPriceAmt"})
    public Money getUnitPriceAmt() {
        return this.unitPriceAmt.getValue();
    }
    public void setUnitPriceAmt(Money unitPriceAmt) {
        this.unitPriceAmt.setValue(unitPriceAmt);
    }

}
