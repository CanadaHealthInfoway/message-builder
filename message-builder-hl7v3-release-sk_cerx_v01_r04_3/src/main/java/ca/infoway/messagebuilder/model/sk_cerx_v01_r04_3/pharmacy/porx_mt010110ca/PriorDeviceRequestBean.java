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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pharmacy.porx_mt010110ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"PORX_MT010110CA.PriorDeviceRequest"})
public class PriorDeviceRequestBean extends MessagePartBean {

    private static final long serialVersionUID = 20110901L;
    private II previousPrescriptionOrderNumber = new IIImpl();


    /**
     * <p>B:Previous Prescription Order Number</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getPreviousPrescriptionOrderNumber() {
        return this.previousPrescriptionOrderNumber.getValue();
    }
    public void setPreviousPrescriptionOrderNumber(Identifier previousPrescriptionOrderNumber) {
        this.previousPrescriptionOrderNumber.setValue(previousPrescriptionOrderNumber);
    }

}
