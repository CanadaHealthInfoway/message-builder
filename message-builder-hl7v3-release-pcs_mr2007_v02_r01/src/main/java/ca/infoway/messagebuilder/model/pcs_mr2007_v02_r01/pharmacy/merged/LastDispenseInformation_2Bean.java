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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



@Hl7PartTypeMapping({"PORX_MT060040CA.SupplyEventLastSummary","PORX_MT060060CA.SupplyEventLastSummary"})
public class LastDispenseInformation_2Bean extends MessagePartBean {

    private static final long serialVersionUID = 20110729L;
    private IVL<TS, Interval<Date>> lastDispensePickupDate = new IVLImpl<TS, Interval<Date>>();
    private INT lastQuantityDispensed = new INTImpl();


    /**
     * <p>LastDispensePickupDate</p>
     * 
     * <p>Last Dispense Pickup Date</p>
     * 
     * <p>A:Last Dispense Pickup Date</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getLastDispensePickupDate() {
        return this.lastDispensePickupDate.getValue();
    }
    public void setLastDispensePickupDate(Interval<Date> lastDispensePickupDate) {
        this.lastDispensePickupDate.setValue(lastDispensePickupDate);
    }


    /**
     * <p>LastQuantityDispensed</p>
     * 
     * <p>B:Last Quantity Dispensed</p>
     * 
     * <p>Last Quantity Dispensed</p>
     */
    @Hl7XmlMapping({"quantity"})
    public Integer getLastQuantityDispensed() {
        return this.lastQuantityDispensed.getValue();
    }
    public void setLastQuantityDispensed(Integer lastQuantityDispensed) {
        this.lastQuantityDispensed.setValue(lastQuantityDispensed);
    }

}
