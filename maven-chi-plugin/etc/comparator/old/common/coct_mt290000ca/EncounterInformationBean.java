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
package ca.infoway.messagebuilder.model.common.coct_mt290000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



@Hl7PartTypeMapping({"COCT_MT290000CA.EncounterInformation"})
public class EncounterInformationBean extends MessagePartBean {

    private II patientEncounterId = new IIImpl();
    private TS patientEncounterEffectiveTime = new TSImpl();

    @Hl7XmlMapping({"patientEncounter/id"})
    public Identifier getPatientEncounterId() {
        return this.patientEncounterId.getValue();
    }
    public void setPatientEncounterId(Identifier patientEncounterId) {
        this.patientEncounterId.setValue(patientEncounterId);
    }

    @Hl7XmlMapping({"patientEncounter/effectiveTime"})
    public Date getPatientEncounterEffectiveTime() {
        return this.patientEncounterEffectiveTime.getValue();
    }
    public void setPatientEncounterEffectiveTime(Date patientEncounterEffectiveTime) {
        this.patientEncounterEffectiveTime.setValue(patientEncounterEffectiveTime);
    }

}
