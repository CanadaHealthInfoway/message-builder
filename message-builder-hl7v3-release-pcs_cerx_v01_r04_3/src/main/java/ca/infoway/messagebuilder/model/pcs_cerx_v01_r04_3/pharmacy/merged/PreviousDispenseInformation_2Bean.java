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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"PORX_MT060040CA.SupplyEventPastSummary","PORX_MT060060CA.SupplyEventPastSummary"})
public class PreviousDispenseInformation_2Bean extends MessagePartBean {

    private static final long serialVersionUID = 20111117L;
    private INT repeatNumber = new INTImpl();
    private INT quantity = new INTImpl();


    /**
     * <p>NumberOfFillsMadeAgainstRx</p>
     * 
     * <p>A:Number of Fills Made Against Rx</p>
     */
    @Hl7XmlMapping({"repeatNumber"})
    public Integer getRepeatNumber() {
        return this.repeatNumber.getValue();
    }
    public void setRepeatNumber(Integer repeatNumber) {
        this.repeatNumber.setValue(repeatNumber);
    }


    /**
     * <p>TotalSuppliedAmount</p>
     * 
     * <p>B:Total Supplied Amount</p>
     */
    @Hl7XmlMapping({"quantity"})
    public Integer getQuantity() {
        return this.quantity.getValue();
    }
    public void setQuantity(Integer quantity) {
        this.quantity.setValue(quantity);
    }

}
