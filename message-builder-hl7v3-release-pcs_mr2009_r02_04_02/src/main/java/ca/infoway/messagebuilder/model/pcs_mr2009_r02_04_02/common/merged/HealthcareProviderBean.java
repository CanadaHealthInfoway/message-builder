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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged;

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
import ca.infoway.messagebuilder.domainvalue.HealthcareProviderRoleType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;
import java.util.Set;



/**
 * <p>Business Name: HealthcareProvider</p>
 * 
 * <p>COCT_MT290000CA.HealthCareProvider: Healthcare Provider</p>
 * 
 * <p>Healthcare Provider</p>
 * 
 * <p>COCT_MT490000CA.HealthCareProvider: Healthcare Provider</p>
 * 
 * <p>Person providing healthcare service</p>
 */
@Hl7PartTypeMapping({"COCT_MT290000CA.HealthCareProvider","COCT_MT490000CA.HealthCareProvider"})
public class HealthcareProviderBean extends MessagePartBean {

    private static final long serialVersionUID = 20150902L;
    private SET<II, Identifier> id = new SETImpl<II, Identifier>(IIImpl.class);
    private CV code = new CVImpl();
    private PN healthCareProviderPersonName = new PNImpl();
    private TEL healthCareProviderPersonTelecom = new TELImpl();
    private CV healthCareProviderPersonAdministrativeGenderCode = new CVImpl();
    private TS healthCareProviderPersonBirthTime = new TSImpl();
    private AD healthCareProviderPersonAddr = new ADImpl();


    /**
     * <p>Un-merged Business Name: ProviderIdentifiers</p>
     * 
     * <p>Relationship: COCT_MT290000CA.HealthCareProvider.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-9)</p>
     * 
     * <p>More than provider identifier could be provided, eg. for 
     * dental claims.</p>
     * 
     * <p>Provider ID, eg. Prof. license no.</p>
     * 
     * <p>Un-merged Business Name: ProviderID</p>
     * 
     * <p>Relationship: COCT_MT490000CA.HealthCareProvider.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-9)</p>
     * 
     * <p>More than 1 Provider identifier can be provided for a 
     * particular role, e.g. some dental claims. An Id may not be 
     * available for out of jurisdiction providers and 
     * consulltants.</p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getId() {
        return this.id.rawSet();
    }


    /**
     * <p>Un-merged Business Name: ProviderType</p>
     * 
     * <p>Relationship: COCT_MT290000CA.HealthCareProvider.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Allows for crosswalks between speciality code sets</p>
     * 
     * <p>Un-merged Business Name: HealthcareProviderCode</p>
     * 
     * <p>Relationship: COCT_MT490000CA.HealthCareProvider.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>code denoting healthcare Provider Type</p>
     */
    @Hl7XmlMapping({"code"})
    public HealthcareProviderRoleType getCode() {
        return (HealthcareProviderRoleType) this.code.getValue();
    }

    /**
     * <p>Un-merged Business Name: ProviderType</p>
     * 
     * <p>Relationship: COCT_MT290000CA.HealthCareProvider.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Allows for crosswalks between speciality code sets</p>
     * 
     * <p>Un-merged Business Name: HealthcareProviderCode</p>
     * 
     * <p>Relationship: COCT_MT490000CA.HealthCareProvider.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>code denoting healthcare Provider Type</p>
     */
    public void setCode(HealthcareProviderRoleType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Un-merged Business Name: NameOfProvider</p>
     * 
     * <p>Relationship: COCT_MT290000CA.ProviderPerson.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Name of person providing service or drug</p>
     * 
     * <p>Un-merged Business Name: ProviderName</p>
     * 
     * <p>Relationship: COCT_MT490000CA.ProviderPerson.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Name of Provider</p>
     */
    @Hl7XmlMapping({"healthCareProviderPerson/name"})
    public PersonName getHealthCareProviderPersonName() {
        return this.healthCareProviderPersonName.getValue();
    }

    /**
     * <p>Un-merged Business Name: NameOfProvider</p>
     * 
     * <p>Relationship: COCT_MT290000CA.ProviderPerson.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Name of person providing service or drug</p>
     * 
     * <p>Un-merged Business Name: ProviderName</p>
     * 
     * <p>Relationship: COCT_MT490000CA.ProviderPerson.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Name of Provider</p>
     */
    public void setHealthCareProviderPersonName(PersonName healthCareProviderPersonName) {
        this.healthCareProviderPersonName.setValue(healthCareProviderPersonName);
    }


    /**
     * <p>Un-merged Business Name: ContactNo</p>
     * 
     * <p>Relationship: COCT_MT290000CA.ProviderPerson.telecom</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>contact info. for Provider</p>
     * 
     * <p>Un-merged Business Name: ProviderTelecom</p>
     * 
     * <p>Relationship: COCT_MT490000CA.ProviderPerson.telecom</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>only required if provider is not known to the Payor</p>
     * 
     * <p>Telephone no. of provider</p>
     */
    @Hl7XmlMapping({"healthCareProviderPerson/telecom"})
    public TelecommunicationAddress getHealthCareProviderPersonTelecom() {
        return this.healthCareProviderPersonTelecom.getValue();
    }

    /**
     * <p>Un-merged Business Name: ContactNo</p>
     * 
     * <p>Relationship: COCT_MT290000CA.ProviderPerson.telecom</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>contact info. for Provider</p>
     * 
     * <p>Un-merged Business Name: ProviderTelecom</p>
     * 
     * <p>Relationship: COCT_MT490000CA.ProviderPerson.telecom</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>only required if provider is not known to the Payor</p>
     * 
     * <p>Telephone no. of provider</p>
     */
    public void setHealthCareProviderPersonTelecom(TelecommunicationAddress healthCareProviderPersonTelecom) {
        this.healthCareProviderPersonTelecom.setValue(healthCareProviderPersonTelecom);
    }


    /**
     * <p>Business Name: ProviderGender</p>
     * 
     * <p>Un-merged Business Name: ProviderGender</p>
     * 
     * <p>Relationship: 
     * COCT_MT290000CA.ProviderPerson.administrativeGenderCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Telecom, gender, birth time, addr are only required if 
     * provider is not known to the Payor</p>
     * 
     * <p>Un-merged Business Name: ProviderGender</p>
     * 
     * <p>Relationship: 
     * COCT_MT490000CA.ProviderPerson.administrativeGenderCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>only required if provider is not known to the Payor</p>
     */
    @Hl7XmlMapping({"healthCareProviderPerson/administrativeGenderCode"})
    public AdministrativeGender getHealthCareProviderPersonAdministrativeGenderCode() {
        return (AdministrativeGender) this.healthCareProviderPersonAdministrativeGenderCode.getValue();
    }

    /**
     * <p>Business Name: ProviderGender</p>
     * 
     * <p>Un-merged Business Name: ProviderGender</p>
     * 
     * <p>Relationship: 
     * COCT_MT290000CA.ProviderPerson.administrativeGenderCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Telecom, gender, birth time, addr are only required if 
     * provider is not known to the Payor</p>
     * 
     * <p>Un-merged Business Name: ProviderGender</p>
     * 
     * <p>Relationship: 
     * COCT_MT490000CA.ProviderPerson.administrativeGenderCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>only required if provider is not known to the Payor</p>
     */
    public void setHealthCareProviderPersonAdministrativeGenderCode(AdministrativeGender healthCareProviderPersonAdministrativeGenderCode) {
        this.healthCareProviderPersonAdministrativeGenderCode.setValue(healthCareProviderPersonAdministrativeGenderCode);
    }


    /**
     * <p>Un-merged Business Name: ProviderDateOfBirth</p>
     * 
     * <p>Relationship: COCT_MT290000CA.ProviderPerson.birthTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Telecom, gender, birth time, addr are only required if 
     * provider is not known to the Payor</p>
     * 
     * <p>Un-merged Business Name: ProviderBirthDate</p>
     * 
     * <p>Relationship: COCT_MT490000CA.ProviderPerson.birthTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>only required if provider is not known to the Payor</p>
     */
    @Hl7XmlMapping({"healthCareProviderPerson/birthTime"})
    public Date getHealthCareProviderPersonBirthTime() {
        return this.healthCareProviderPersonBirthTime.getValue();
    }

    /**
     * <p>Un-merged Business Name: ProviderDateOfBirth</p>
     * 
     * <p>Relationship: COCT_MT290000CA.ProviderPerson.birthTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Telecom, gender, birth time, addr are only required if 
     * provider is not known to the Payor</p>
     * 
     * <p>Un-merged Business Name: ProviderBirthDate</p>
     * 
     * <p>Relationship: COCT_MT490000CA.ProviderPerson.birthTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>only required if provider is not known to the Payor</p>
     */
    public void setHealthCareProviderPersonBirthTime(Date healthCareProviderPersonBirthTime) {
        this.healthCareProviderPersonBirthTime.setValue(healthCareProviderPersonBirthTime);
    }


    /**
     * <p>Business Name: ProviderAddress</p>
     * 
     * <p>Un-merged Business Name: ProviderAddress</p>
     * 
     * <p>Relationship: COCT_MT290000CA.ProviderPerson.addr</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Can be used to specify jurisdiction for OOJ providers</p>
     * 
     * <p>Telecom, gender, birth time, addr are only required if 
     * provider is not known to the Payor</p>
     * 
     * <p>Un-merged Business Name: ProviderAddress</p>
     * 
     * <p>Relationship: COCT_MT490000CA.ProviderPerson.addr</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Can be used to specify jurisdiction for OOJ providers</p>
     */
    @Hl7XmlMapping({"healthCareProviderPerson/addr"})
    public PostalAddress getHealthCareProviderPersonAddr() {
        return this.healthCareProviderPersonAddr.getValue();
    }

    /**
     * <p>Business Name: ProviderAddress</p>
     * 
     * <p>Un-merged Business Name: ProviderAddress</p>
     * 
     * <p>Relationship: COCT_MT290000CA.ProviderPerson.addr</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Can be used to specify jurisdiction for OOJ providers</p>
     * 
     * <p>Telecom, gender, birth time, addr are only required if 
     * provider is not known to the Payor</p>
     * 
     * <p>Un-merged Business Name: ProviderAddress</p>
     * 
     * <p>Relationship: COCT_MT490000CA.ProviderPerson.addr</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Can be used to specify jurisdiction for OOJ providers</p>
     */
    public void setHealthCareProviderPersonAddr(PostalAddress healthCareProviderPersonAddr) {
        this.healthCareProviderPersonAddr.setValue(healthCareProviderPersonAddr);
    }

}
