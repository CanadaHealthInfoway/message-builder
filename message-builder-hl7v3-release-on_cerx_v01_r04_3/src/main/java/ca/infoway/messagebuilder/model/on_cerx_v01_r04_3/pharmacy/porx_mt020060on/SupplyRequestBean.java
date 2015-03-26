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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.pharmacy.porx_mt020060on;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



/**
 * <p>AT least one of Total Prescribed Quantity or Total Days 
 * Supply must be specified</p>
 */
@Hl7PartTypeMapping({"PORX_MT020060ON.SupplyRequest"})
public class SupplyRequestBean extends MessagePartBean {

    private static final long serialVersionUID = 20150326L;
    private INT quantity = new INTImpl();
    private IVL<TS, Interval<Date>> expectedUseTime = new IVLImpl<TS, Interval<Date>>();


    /**
     * <p>Business Name: Total Prescribed Quantity</p>
     * 
     * <p>Relationship: PORX_MT020060ON.SupplyRequest.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows determination of the amount that remains to be 
     * dispensed against the prescription.</p>
     * 
     * <p>The overall amount of device to be dispensed under this 
     * prescription.</p>
     */
    @Hl7XmlMapping({"quantity"})
    public Integer getQuantity() {
        return this.quantity.getValue();
    }

    /**
     * <p>Business Name: Total Prescribed Quantity</p>
     * 
     * <p>Relationship: PORX_MT020060ON.SupplyRequest.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows determination of the amount that remains to be 
     * dispensed against the prescription.</p>
     * 
     * <p>The overall amount of device to be dispensed under this 
     * prescription.</p>
     */
    public void setQuantity(Integer quantity) {
        this.quantity.setValue(quantity);
    }


    /**
     * <p>Business Name: Total Days Supply</p>
     * 
     * <p>Relationship: 
     * PORX_MT020060ON.SupplyRequest.expectedUseTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Useful in monitoring patient compliance. May also be 
     * useful in determining and managing certain contraindications 
     * ('Fill-Too-Soon', 'Fill-Too-Late').</p>
     * 
     * <p>The number of days that the overall prescribed item is 
     * expected to last, if the patient is compliant with the 
     * dispensing and use of the prescription</p>
     */
    @Hl7XmlMapping({"expectedUseTime"})
    public Interval<Date> getExpectedUseTime() {
        return this.expectedUseTime.getValue();
    }

    /**
     * <p>Business Name: Total Days Supply</p>
     * 
     * <p>Relationship: 
     * PORX_MT020060ON.SupplyRequest.expectedUseTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Useful in monitoring patient compliance. May also be 
     * useful in determining and managing certain contraindications 
     * ('Fill-Too-Soon', 'Fill-Too-Late').</p>
     * 
     * <p>The number of days that the overall prescribed item is 
     * expected to last, if the patient is compliant with the 
     * dispensing and use of the prescription</p>
     */
    public void setExpectedUseTime(Interval<Date> expectedUseTime) {
        this.expectedUseTime.setValue(expectedUseTime);
    }

}
