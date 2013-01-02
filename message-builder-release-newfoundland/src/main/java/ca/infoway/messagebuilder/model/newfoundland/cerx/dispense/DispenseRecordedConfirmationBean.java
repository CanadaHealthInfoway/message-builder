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

package ca.infoway.messagebuilder.model.newfoundland.cerx.dispense;

import java.io.Serializable;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;

@Hl7PartTypeMapping({ "PORX_MT020030CA.SupplyEvent" })
public class DispenseRecordedConfirmationBean extends MessagePartBean implements Serializable {

    private static final long serialVersionUID = 3761320389995371050L;

    private II dispenseId = new IIImpl();

    private II prescriptionId = new IIImpl();

    @Hl7XmlMapping("id")
    public Identifier getDispenseId() {
        return this.dispenseId.getValue();
    }

    public void setDispenseId(Identifier dispenseId) {
        this.dispenseId.setValue(dispenseId);
    }

    @Hl7XmlMapping("inFulfillmentOf/actRequest/id")
    public Identifier getPrescriptionId() {
        return this.prescriptionId.getValue();
    }

    public void setPrescriptionId(Identifier prescriptionId) {
        this.prescriptionId.setValue(prescriptionId);
    }
}
