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
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"PORX_MT060040CA.InFulfillmentOf3","PORX_MT060060CA.InFulfillmentOf4"})
public class InFulfillmentOf3_2Bean extends MessagePartBean {

    private INT fillsRemaining = new INTImpl();
    private INT remainingTotalQuantity = new INTImpl();

    @Hl7XmlMapping({"supplyEventFutureSummary/repeatNumber"})
    public java.lang.Integer getFillsRemaining() {
        return this.fillsRemaining.getValue();
    }
    public void setFillsRemaining(java.lang.Integer fillsRemaining) {
        this.fillsRemaining.setValue(fillsRemaining);
    }

    @Hl7XmlMapping({"supplyEventFutureSummary/quantity"})
    public java.lang.Integer getRemainingTotalQuantity() {
        return this.remainingTotalQuantity.getValue();
    }
    public void setRemainingTotalQuantity(java.lang.Integer remainingTotalQuantity) {
        this.remainingTotalQuantity.setValue(remainingTotalQuantity);
    }

}