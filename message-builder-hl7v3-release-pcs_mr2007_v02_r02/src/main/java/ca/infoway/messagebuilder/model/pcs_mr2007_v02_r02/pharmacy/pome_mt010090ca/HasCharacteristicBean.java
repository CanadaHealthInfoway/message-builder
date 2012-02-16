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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pharmacy.pome_mt010090ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.MedicationObservationType;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>has characteristic</p>
 * 
 * <p><p>Filters medications by their appearance.</p></p>
 * 
 * <p><p>Used to hold characteristic type and value pair as one 
 * set of query parameter item.</p></p>
 */
@Hl7PartTypeMapping({"POME_MT010090CA.DrugCharacteristics"})
public class HasCharacteristicBean extends MessagePartBean {

    private static final long serialVersionUID = 20120215L;
    private ST drugCharacteristicValue = new STImpl();
    private CV drugCharacteristicTypeValue = new CVImpl();


    /**
     * <p>G:Drug Characteristic</p>
     * 
     * <p><p>Information pertaining to a specific instance of drug 
     * characteristic (color - red, shape - triangular, markings 
     * etc).</p></p>
     * 
     * <p><p>Provides the 'value' part of the name-value pair 
     * describing the characteristic of drug product to be 
     * retrieved. Example:</p><p>type: color</p><p>value: 
     * blue</p><p>type: shape</p><p>value: rectangular</p><p>The 
     * attribute is mandatory because there's no point searching 
     * for a characteristic without specifying a value.</p></p>
     * 
     * <p><p>Provides the 'value' part of the name-value pair 
     * describing the characteristic of drug product to be 
     * retrieved. Example:</p><p>type: color</p><p>value: 
     * blue</p><p>type: shape</p><p>value: rectangular</p><p>The 
     * attribute is mandatory because there's no point searching 
     * for a characteristic without specifying a value.</p></p>
     * 
     * <p><p>Provides the 'value' part of the name-value pair 
     * describing the characteristic of drug product to be 
     * retrieved. Example:</p><p>type: color</p><p>value: 
     * blue</p><p>type: shape</p><p>value: rectangular</p><p>The 
     * attribute is mandatory because there's no point searching 
     * for a characteristic without specifying a value.</p></p>
     * 
     * <p><p>Provides the 'value' part of the name-value pair 
     * describing the characteristic of drug product to be 
     * retrieved. Example:</p><p>type: color</p><p>value: 
     * blue</p><p>type: shape</p><p>value: rectangular</p><p>The 
     * attribute is mandatory because there's no point searching 
     * for a characteristic without specifying a value.</p></p>
     * 
     * <p><p>Provides the 'value' part of the name-value pair 
     * describing the characteristic of drug product to be 
     * retrieved. Example:</p><p>type: color</p><p>value: 
     * blue</p><p>type: shape</p><p>value: rectangular</p><p>The 
     * attribute is mandatory because there's no point searching 
     * for a characteristic without specifying a value.</p></p>
     * 
     * <p><p>Provides the 'value' part of the name-value pair 
     * describing the characteristic of drug product to be 
     * retrieved. Example:</p><p>type: color</p><p>value: 
     * blue</p><p>type: shape</p><p>value: rectangular</p><p>The 
     * attribute is mandatory because there's no point searching 
     * for a characteristic without specifying a value.</p></p>
     */
    @Hl7XmlMapping({"drugCharacteristic/value"})
    public String getDrugCharacteristicValue() {
        return this.drugCharacteristicValue.getValue();
    }
    public void setDrugCharacteristicValue(String drugCharacteristicValue) {
        this.drugCharacteristicValue.setValue(drugCharacteristicValue);
    }


    /**
     * <p>H:Drug Characteristic Type Code</p>
     * 
     * <p><p>A coded value denoting the type of physical 
     * characteristic of a drug. Characteristics include: Color, 
     * Shape, Markings, Size, etc.</p></p>
     * 
     * <p><p>Allows retrieval based on specific characteristic of a 
     * drug. The attribute is mandatory because there's no point 
     * searching for a characteristic without identifying what kind 
     * of characteristic is being searched by.</p></p>
     */
    @Hl7XmlMapping({"drugCharacteristicType/value"})
    public MedicationObservationType getDrugCharacteristicTypeValue() {
        return (MedicationObservationType) this.drugCharacteristicTypeValue.getValue();
    }
    public void setDrugCharacteristicTypeValue(MedicationObservationType drugCharacteristicTypeValue) {
        this.drugCharacteristicTypeValue.setValue(drugCharacteristicTypeValue);
    }

}
