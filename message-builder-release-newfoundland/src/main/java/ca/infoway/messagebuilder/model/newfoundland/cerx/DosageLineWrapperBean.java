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

@Hl7PartTypeMapping({ "PORX_MT980040CA.Component17" })
public class DosageLineWrapperBean extends MessagePartBean implements Serializable {

    private static final long serialVersionUID = -7923957589582260848L;

    private final INT sequenceNumber = new INTImpl();

    private DosageLineBean dosageLine;

    @Hl7XmlMapping("sequenceNumber")
    public int getSequenceNumber() {
        return sequenceNumber.getValue();
    }

    public void setSequenceNumber(int sequenceNumber) {
        this.sequenceNumber.setValue(sequenceNumber);
    }

    @Hl7XmlMapping("dosageLine")
    public DosageLineBean getDosageLine() {
        return dosageLine;
    }

    public void setDosageLine(DosageLineBean dosageLine) {
        this.dosageLine = dosageLine;
    }
}
