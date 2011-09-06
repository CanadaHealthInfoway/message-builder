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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.MedicationObservationType;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>AppearanceCharacteristics</p>
 * 
 * <p>POME_MT010100CA.Characteristic: Appearance 
 * Characteristics</p>
 * 
 * <p><p>The characteristics of a manufactured product that 
 * visually distinguish it from other products.</p></p>
 * 
 * <p><p>Used for searching drugs. May be employed as means of 
 * communication between providers and patients.</p></p>
 * 
 * <p>POME_MT010040CA.Characteristic: Appearance 
 * Characteristics</p>
 * 
 * <p><p>The characteristics of a manufactured product that 
 * visually distinguish it from other products.</p></p>
 * 
 * <p><p>Used for searching drugs. May be employed as means of 
 * communication between providers and patients.</p></p>
 */
@Hl7PartTypeMapping({"POME_MT010040CA.Characteristic","POME_MT010100CA.Characteristic"})
public class AppearanceCharacteristicsBean extends MessagePartBean {

    private static final long serialVersionUID = 20110906L;
    private CV characteristicType = new CVImpl();
    private ST characteristic = new STImpl();


    /**
     * <p>CharacteristicType</p>
     * 
     * <p>A:Characteristic Type</p>
     * 
     * <p><p>A coded value denoting the type of physical 
     * characteristic being documented. Kinds of characteristics 
     * include: Color, Shape, Markings, Size, etc.</p></p>
     * 
     * <p><p>Identifies what kind of characteristic is being 
     * identified. This is mandatory as providing the 
     * characteristic alone without specifying the type can result 
     * in ambiguity.</p></p>
     * 
     * <p>Characteristic Type</p>
     * 
     * <p><p>A coded value denoting the type of physical 
     * characteristic being documented. Kinds of characteristics 
     * include: Color, Shape, Markings, Size.</p></p>
     * 
     * <p><p>Identifies what kind of characteristic is being 
     * identified. This is mandatory as providing the 
     * characteristic alone without specifying the type can result 
     * in ambiguity</p></p>
     */
    @Hl7XmlMapping({"code"})
    public MedicationObservationType getCharacteristicType() {
        return (MedicationObservationType) this.characteristicType.getValue();
    }
    public void setCharacteristicType(MedicationObservationType characteristicType) {
        this.characteristicType.setValue(characteristicType);
    }


    /**
     * <p>Characteristic</p>
     * 
     * <p>E:Characteristic</p>
     * 
     * <p><p>Information pertaining to a specific instance of drug 
     * characteristic (color, shape, markings etc).</p></p>
     * 
     * <p><p>Provides the 'value' part of the name-value pair 
     * describing the drug product appearance 
     * characteristic.</p><p>The attribute is marked as 
     * &quot;mandatory&quot; as there must be a value for a 
     * mandatory code.</p></p>
     * 
     * <p><p>Provides the 'value' part of the name-value pair 
     * describing the drug product appearance 
     * characteristic.</p><p>The attribute is marked as 
     * &quot;mandatory&quot; as there must be a value for a 
     * mandatory code.</p></p>
     * 
     * <p>Characteristic</p>
     * 
     * <p><p>Information pertaining to a specific instance of drug 
     * characteristic (color, shape, markings etc)</p></p>
     * 
     * <p><p>Provides the 'value' part of the name-value pair 
     * describing the drug product appearance 
     * characteristic.</p><p>The attribute is marked as 'mandatory' 
     * as there must be a value for a mandatory code.</p></p>
     * 
     * <p><p>Provides the 'value' part of the name-value pair 
     * describing the drug product appearance 
     * characteristic.</p><p>The attribute is marked as 'mandatory' 
     * as there must be a value for a mandatory code.</p></p>
     */
    @Hl7XmlMapping({"value"})
    public String getCharacteristic() {
        return this.characteristic.getValue();
    }
    public void setCharacteristic(String characteristic) {
        this.characteristic.setValue(characteristic);
    }

}
