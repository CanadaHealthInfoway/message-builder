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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pharmacy.pome_mt010090ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.MedicationObservationType;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"POME_MT010090CA.DrugCharacteristics"})
public class HasCharacteristicBean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private ST drugCharacteristic = new STImpl();
    private CV drugCharacteristicTypeCode = new CVImpl();


    /**
     * <p>G:Drug Characteristic</p>
     */
    @Hl7XmlMapping({"drugCharacteristic/value"})
    public String getDrugCharacteristic() {
        return this.drugCharacteristic.getValue();
    }
    public void setDrugCharacteristic(String drugCharacteristic) {
        this.drugCharacteristic.setValue(drugCharacteristic);
    }


    /**
     * <p>H:Drug Characteristic Type Code</p>
     */
    @Hl7XmlMapping({"drugCharacteristicType/value"})
    public MedicationObservationType getDrugCharacteristicTypeCode() {
        return (MedicationObservationType) this.drugCharacteristicTypeCode.getValue();
    }
    public void setDrugCharacteristicTypeCode(MedicationObservationType drugCharacteristicTypeCode) {
        this.drugCharacteristicTypeCode.setValue(drugCharacteristicTypeCode);
    }

}
