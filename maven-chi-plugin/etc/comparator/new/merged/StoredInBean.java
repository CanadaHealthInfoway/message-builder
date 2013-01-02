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

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.domainvalue.ParticipationType;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"MCAI_MT700210CA.RecordTarget","MCAI_MT700211CA.RecordTarget","MCAI_MT700216CA.RecordTarget","MCAI_MT700217CA.RecordTarget","MCAI_MT700220CA.RecordTarget","MCAI_MT700221CA.RecordTarget","MCAI_MT700226CA.RecordTarget","MCAI_MT700227CA.RecordTarget","MCAI_MT700230CA.RecordTarget","MCAI_MT700231CA.RecordTarget","MCAI_MT700236CA.RecordTarget","MCAI_MT700237CA.RecordTarget","QUQI_MT020000CA.RecordTarget","QUQI_MT120006CA.RecordTarget"})
public class StoredInBean extends MessagePartBean {

    private CS<ParticipationType> typeCode = new CSImpl<ParticipationType>();
    private Patient_2Bean patient1;

    @Hl7XmlMapping({"typeCode"})
    public ParticipationType getTypeCode() {
        return this.typeCode.getValue();
    }
    public void setTypeCode(ParticipationType typeCode) {
        this.typeCode.setValue(typeCode);
    }

    @Hl7XmlMapping({"patient1"})
    public Patient_2Bean getPatient1() {
        return this.patient1;
    }
    public void setPatient1(Patient_2Bean patient1) {
        this.patient1 = patient1;
    }

}
