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
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



@Hl7PartTypeMapping({"PORX_MT030040CA.InFulfillmentOf5","PORX_MT060160CA.InFulfillmentOf4","PORX_MT060190CA.InFulfillmentOf5","PORX_MT060340CA.InFulfillmentOf4"})
public class InFulfillmentOf4_1Bean extends MessagePartBean {

    private IVL<TS, Interval<Date>> firstDispensePickupDate = new IVLImpl<TS, Interval<Date>>();
    private PQ firstQuantityDispense = new PQImpl();

    @Hl7XmlMapping({"supplyEventFirstSummary/effectiveTime"})
    public Interval<Date> getFirstDispensePickupDate() {
        return this.firstDispensePickupDate.getValue();
    }
    public void setFirstDispensePickupDate(Interval<Date> firstDispensePickupDate) {
        this.firstDispensePickupDate.setValue(firstDispensePickupDate);
    }

    @Hl7XmlMapping({"supplyEventFirstSummary/quantity"})
    public PhysicalQuantity getFirstQuantityDispense() {
        return this.firstQuantityDispense.getValue();
    }
    public void setFirstQuantityDispense(PhysicalQuantity firstQuantityDispense) {
        this.firstQuantityDispense.setValue(firstQuantityDispense);
    }

}
