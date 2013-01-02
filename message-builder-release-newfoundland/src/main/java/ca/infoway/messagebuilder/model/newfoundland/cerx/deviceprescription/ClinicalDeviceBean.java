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

package ca.infoway.messagebuilder.model.newfoundland.cerx.deviceprescription;

import java.io.Serializable;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.ClinicalDeviceEntity;
import ca.infoway.messagebuilder.model.MessagePartBean;

@Hl7PartTypeMapping({ "COCT_MT141007CA.ClinicalDevice" })
public class ClinicalDeviceBean extends MessagePartBean implements Serializable {

    private static final long serialVersionUID = 2572165519408535630L;

    private CD code = new CDImpl();

    private ST name = new STImpl();

    private ST desc = new STImpl();

    private INT quantity = new INTImpl();

    /**
     * <p>An identifier for a type of device. 
     * 
     * <p>Used to ensure clear communication by uniquely 
     * identifying a particular device product when prescribing or 
     * dispensing. This attribute is only marked as 'populated' 
     * because some devices will not have codes associated with 
     * them. 
     */
    @Hl7XmlMapping("code")
    public ClinicalDeviceEntity getCode() {
        return (ClinicalDeviceEntity) this.code.getValue();
    }

    public void setCode(ClinicalDeviceEntity code) {
        this.code.setValue(code);
    }

    /**
     * <p>The name assigned to a type of device. 
     * 
     * <p>First occurrence is preferred for display. 
     * 
     * <p>Names are used for human reference communication, to 
     * allow selection from dropdowns and for local searching. If a 
     * code is available, the name acts as a cross-check. If the 
     * code is not available the name acts as the primary 
     * identifier. The attribute is therefore mandatory. 
     */
    @Hl7XmlMapping("name")
    public String getName() {
        return this.name.getValue();
    }

    public void setName(String name) {
        this.name.setValue(name);
    }

    /**
     * <p>A free form textual description of a device and its 
     * characteristics (e.g. size, shape, etc.). This is used when 
     * additional information must be conveyed that is not apparent 
     * by just specifying code and name. 
     * 
     * <p>Allows description of characteristics of the device not 
     * necessarily conveyed by the code or name. 
     */
    @Hl7XmlMapping("desc")
    public String getDesc() {
        return this.desc.getValue();
    }

    public void setDesc(String desc) {
        this.desc.setValue(desc);
    }

    @Hl7XmlMapping("asContent/quantity")
    public Integer getQuantity() {
        return this.quantity.getValue();
    }

    public void setQuantity(Integer quantity) {
        this.quantity.setValue(quantity);
    }
}
