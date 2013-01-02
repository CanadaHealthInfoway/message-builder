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

package ca.infoway.messagebuilder.model.newfoundland.cerx.observation;

import java.io.Serializable;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.CommonClinicalObservationType;
import ca.infoway.messagebuilder.model.MessagePartBean;

@Hl7PartTypeMapping({ "REPC_MT000018CA.SubObservationEvent", "REPC_MT100002CA.SubObservationEvent" })
public class ObservationValueBean extends MessagePartBean implements Serializable {

    private static final long serialVersionUID = -2133731163905048498L;

    private CD type = new CDImpl();

    private PQ value = new PQImpl();

    @Hl7XmlMapping("code")
    public CommonClinicalObservationType getType() {
        return (CommonClinicalObservationType) this.type.getValue();
    }

    public void setType(CommonClinicalObservationType type) {
        this.type.setValue(type);
    }

    @Hl7XmlMapping("value")
    public PhysicalQuantity getValue() {
        return this.value.getValue();
    }

    public void setValue(PhysicalQuantity value) {
        this.value.setValue(value);
    }
}
