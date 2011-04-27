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

package ca.infoway.messagebuilder.model.newfoundland.cerx.allergy;

import java.io.Serializable;
import java.util.Date;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.AllergyTestValue;
import ca.infoway.messagebuilder.domainvalue.ObservationAllergyTestType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.AllergyRecord;

@Hl7PartTypeMapping({ "REPC_MT000001CA.AllergyTestEvent", "REPC_MT000013CA.AllergyTestEvent", "REPC_MT000005CA.AllergyTestEvent", "REPC_MT000009CA.AllergyTestEvent" })
public class AllergyTestEventBean extends MessagePartBean implements Serializable, AllergyRecord {

    private static final long serialVersionUID = 1843667065991430793L;

    private II id = new IIImpl();

    private CD code = new CDImpl();

    private TS effectiveTime = new TSImpl();

    private CD value = new CDImpl();

    public AllergyTestEventBean() {
    }

    @Hl7XmlMapping("id")
    public Identifier getId() {
        return this.id.getValue();
    }

    public void setId(Identifier id) {
        this.id.setValue(id);
    }

    @Hl7XmlMapping("code")
    public ObservationAllergyTestType getCode() {
        return (ObservationAllergyTestType) this.code.getValue();
    }

    public void setCode(ObservationAllergyTestType code) {
        this.code.setValue(code);
    }

    @Hl7XmlMapping("effectiveTime")
    public Date getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }

    @Hl7XmlMapping("value")
    public AllergyTestValue getValue() {
        return (AllergyTestValue) this.value.getValue();
    }

    public void setValue(AllergyTestValue value) {
        this.value.setValue(value);
    }
}
