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

package ca.infoway.messagebuilder.model.newfoundland;

import java.util.Date;

import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;

public abstract class PatientDetailsQueryCriteria extends QueryCriteria {

    private static final long serialVersionUID = 6857921380193549575L;

    private final II patientId = new IIImpl();

    private final TS patientBirthDate = new TSImpl();

    private final CD patientGender = new CDImpl();

    private final PN name = new PNImpl();

    @Hl7XmlMapping("patientID/value")
    public Identifier getPatientId() {
        return this.patientId.getValue();
    }

    public void setPatientId(Identifier patientId) {
        this.patientId.setValue(patientId);
    }

    @Hl7XmlMapping("patientBirthDate/value")
    public Date getPatientBirthDate() {
        return this.patientBirthDate.getValue();
    }

    public void setPatientBirthDate(Date patientBirthDate) {
        this.patientBirthDate.setValue(patientBirthDate);
    }

    @Hl7XmlMapping("patientGender/value")
    public AdministrativeGender getPatientGender() {
        return (AdministrativeGender) this.patientGender.getValue();
    }

    public void setPatientGender(AdministrativeGender patientGender) {
        this.patientGender.setValue(patientGender);
    }

    @Hl7XmlMapping("patientName/value")
    public PersonName getName() {
        return this.name.getValue();
    }

    public void setName(PersonName patientName) {
        this.name.setValue(patientName);
    }
}
