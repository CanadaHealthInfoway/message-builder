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
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.x_ActMoodOrderEvent;
import ca.infoway.messagebuilder.model.MessagePartBean;

@Hl7PartTypeMapping({ "PORX_MT010120CA.Coverage", "PORX_MT060160CA.Coverage" })
public class CoverageBean extends MessagePartBean implements Serializable {

    private static final long serialVersionUID = -4427268897648324856L;

    private CD moodCode = new CDImpl();

    private II identifier = new IIImpl();

    private II payorIdentifier = new IIImpl();

    private ST payorName = new STImpl();

    @Hl7XmlMapping("moodCode")
    public x_ActMoodOrderEvent getMoodCode() {
        return (x_ActMoodOrderEvent) this.moodCode.getValue();
    }

    public void setMoodCode(x_ActMoodOrderEvent moodCode) {
        this.moodCode.setValue(moodCode);
    }

    @Hl7XmlMapping("id")
    public Identifier getIdentifier() {
        return this.identifier.getValue();
    }

    public void setIdentifier(Identifier identifier) {
        this.identifier.setValue(identifier);
    }

    @Hl7XmlMapping({ "author/carrierRole/id", "author/underwriter/id" })
    public Identifier getPayorIdentifier() {
        return this.payorIdentifier.getValue();
    }

    public void setPayorIdentifier(Identifier payorIdentifier) {
        this.payorIdentifier.setValue(payorIdentifier);
    }

    @Hl7XmlMapping({ "author/carrierRole/underwritingCarrierOrganization/name", "author/underwriter/underwritingOrganization/name" })
    public String getPayorName() {
        return this.payorName.getValue();
    }

    public void setPayorName(String payorName) {
        this.payorName.setValue(payorName);
    }
}
