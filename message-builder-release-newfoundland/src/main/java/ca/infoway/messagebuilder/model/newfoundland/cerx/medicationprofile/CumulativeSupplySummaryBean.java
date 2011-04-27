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

package ca.infoway.messagebuilder.model.newfoundland.cerx.medicationprofile;

import java.io.Serializable;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.model.MessagePartBean;

@Hl7PartTypeMapping({ "PORX_MT060060CA.SupplyEventFutureSummary", "PORX_MT060060CA.SupplyEventPastSummary", "PORX_MT030040CA.SupplyEventFutureSummary", "PORX_MT030040CA.SupplyEventPastSummary", "PORX_MT060040CA.SupplyEventFutureSummary", "PORX_MT060040CA.SupplyEventPastSummary", "PORX_MT060190CA.SupplyEventFutureSummary", "PORX_MT060190CA.SupplyEventPastSummary" })
public class CumulativeSupplySummaryBean extends MessagePartBean implements Serializable {

    private static final long serialVersionUID = -4559114561527175893L;

    private final PQ quantity = new PQImpl();

    private final INT repeatNumber = new INTImpl();

    @Hl7XmlMapping("quantity")
    public PhysicalQuantity getQuantity() {
        return this.quantity.getValue();
    }

    public void setQuantity(PhysicalQuantity quantity) {
        this.quantity.setValue(quantity);
    }

    @Hl7XmlMapping("repeatNumber")
    public int getRepeatNumber() {
        return this.repeatNumber.getValue();
    }

    public void setRepeatNumber(int repeatNumber) {
        this.repeatNumber.setValue(repeatNumber);
    }
}
