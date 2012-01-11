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

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;

@Hl7PartTypeMapping({ "PORX_MT060040CA.SupplementalFillInformation" })
public class SupplementalFillInformationBean extends MessagePartBean implements Serializable {

    private INT numberOfFills = new INTImpl();

    private INT fillQuantity = new INTImpl();

    private static final long serialVersionUID = 567672969236440319L;

    @Hl7XmlMapping({ "repeatNumber" })
    public Integer getNumberOfFills() {
        return this.numberOfFills.getValue();
    }

    public void setNumberOfFills(Integer numberOfFills) {
        this.numberOfFills.setValue(numberOfFills);
    }

    @Hl7XmlMapping({ "quantity" })
    public Integer getFillQuantity() {
        return this.fillQuantity.getValue();
    }

    public void setFillQuantity(Integer fillQuantity) {
        this.fillQuantity.setValue(fillQuantity);
    }
}
