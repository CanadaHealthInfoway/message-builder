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
package ca.infoway.messagebuilder.model.common.coct_mt290000ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;



@Hl7PartTypeMapping({"COCT_MT290000CA.ProviderSupervisor"})
public class ProviderSupervisorBean extends MessagePartBean {

    private SET<II, Identifier> providerIdentifierS = new SETImpl<II, Identifier>(IIImpl.class);
    private CV<Code> healthCareProviderCode = new CVImpl<Code>();
    private PN nameOfProvider = new PNImpl();
    private TEL healthCareProviderHealthCareProviderPersonTelecom = new TELImpl();
    private CV<AdministrativeGender> healthCareProviderHealthCareProviderPersonAdministrativeGenderCode = new CVImpl<AdministrativeGender>();
    private TS healthCareProviderHealthCareProviderPersonBirthTime = new TSImpl();
    private AD healthCareProviderHealthCareProviderPersonAddr = new ADImpl();

    @Hl7XmlMapping({"healthCareProvider/id"})
    public Set<Identifier> getProviderIdentifierS() {
        return this.providerIdentifierS.rawSet();
    }

    @Hl7XmlMapping({"healthCareProvider/code"})
    public Code getHealthCareProviderCode() {
        return this.healthCareProviderCode.getValue();
    }
    public void setHealthCareProviderCode(Code healthCareProviderCode) {
        this.healthCareProviderCode.setValue(healthCareProviderCode);
    }

    @Hl7XmlMapping({"healthCareProvider/healthCareProviderPerson/name"})
    public PersonName getNameOfProvider() {
        return this.nameOfProvider.getValue();
    }
    public void setNameOfProvider(PersonName nameOfProvider) {
        this.nameOfProvider.setValue(nameOfProvider);
    }

    @Hl7XmlMapping({"healthCareProvider/healthCareProviderPerson/telecom"})
    public TelecommunicationAddress getHealthCareProviderHealthCareProviderPersonTelecom() {
        return this.healthCareProviderHealthCareProviderPersonTelecom.getValue();
    }
    public void setHealthCareProviderHealthCareProviderPersonTelecom(TelecommunicationAddress healthCareProviderHealthCareProviderPersonTelecom) {
        this.healthCareProviderHealthCareProviderPersonTelecom.setValue(healthCareProviderHealthCareProviderPersonTelecom);
    }

    @Hl7XmlMapping({"healthCareProvider/healthCareProviderPerson/administrativeGenderCode"})
    public AdministrativeGender getHealthCareProviderHealthCareProviderPersonAdministrativeGenderCode() {
        return this.healthCareProviderHealthCareProviderPersonAdministrativeGenderCode.getValue();
    }
    public void setHealthCareProviderHealthCareProviderPersonAdministrativeGenderCode(AdministrativeGender healthCareProviderHealthCareProviderPersonAdministrativeGenderCode) {
        this.healthCareProviderHealthCareProviderPersonAdministrativeGenderCode.setValue(healthCareProviderHealthCareProviderPersonAdministrativeGenderCode);
    }

    @Hl7XmlMapping({"healthCareProvider/healthCareProviderPerson/birthTime"})
    public Date getHealthCareProviderHealthCareProviderPersonBirthTime() {
        return this.healthCareProviderHealthCareProviderPersonBirthTime.getValue();
    }
    public void setHealthCareProviderHealthCareProviderPersonBirthTime(Date healthCareProviderHealthCareProviderPersonBirthTime) {
        this.healthCareProviderHealthCareProviderPersonBirthTime.setValue(healthCareProviderHealthCareProviderPersonBirthTime);
    }

    @Hl7XmlMapping({"healthCareProvider/healthCareProviderPerson/addr"})
    public PostalAddress getHealthCareProviderHealthCareProviderPersonAddr() {
        return this.healthCareProviderHealthCareProviderPersonAddr.getValue();
    }
    public void setHealthCareProviderHealthCareProviderPersonAddr(PostalAddress healthCareProviderHealthCareProviderPersonAddr) {
        this.healthCareProviderHealthCareProviderPersonAddr.setValue(healthCareProviderHealthCareProviderPersonAddr);
    }

}
