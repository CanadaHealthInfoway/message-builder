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
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"PORX_MT030040CA.InFulfillmentOf2","PORX_MT060160CA.InFulfillmentOf2","PORX_MT060190CA.InFulfillmentOf2","PORX_MT060340CA.InFulfillmentOf2"})
public class InFulfillmentOf2_1Bean extends MessagePartBean {

    private INT numberOfFillsMadeAgainstRx = new INTImpl();
    private PQ totalSuppliedAmount = new PQImpl();

    @Hl7XmlMapping({"supplyEventPastSummary/repeatNumber"})
    public java.lang.Integer getNumberOfFillsMadeAgainstRx() {
        return this.numberOfFillsMadeAgainstRx.getValue();
    }
    public void setNumberOfFillsMadeAgainstRx(java.lang.Integer numberOfFillsMadeAgainstRx) {
        this.numberOfFillsMadeAgainstRx.setValue(numberOfFillsMadeAgainstRx);
    }

    @Hl7XmlMapping({"supplyEventPastSummary/quantity"})
    public PhysicalQuantity getTotalSuppliedAmount() {
        return this.totalSuppliedAmount.getValue();
    }
    public void setTotalSuppliedAmount(PhysicalQuantity totalSuppliedAmount) {
        this.totalSuppliedAmount.setValue(totalSuppliedAmount);
    }

}
