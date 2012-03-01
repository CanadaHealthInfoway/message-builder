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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.claims.merged;

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
import java.util.Date;
import java.util.Set;



/**
 * <p>HealthcareProvider</p>
 * 
 * <p>COCT_MT290000CA.HealthCareProvider: Healthcare Provider</p>
 * 
 * <p><p>Healthcare Provider</p></p>
 * 
 * <p>COCT_MT490000CA.HealthCareProvider: Healthcare Provider</p>
 * 
 * <p><p>Person providing healthcare service</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT290000CA.HealthCareProvider","COCT_MT490000CA.HealthCareProvider"})
public class HealthcareProviderBean extends MessagePartBean {

    private static final long serialVersionUID = 20120215L;
    private SET<II, Identifier> id = new SETImpl<II, Identifier>(IIImpl.class);
    private CV code = new CVImpl();
    private PN healthCareProviderPersonName = new PNImpl();
    private TEL healthCareProviderPersonTelecom = new TELImpl();
    private CV healthCareProviderPersonAdministrativeGenderCode = new CVImpl();
    private TS healthCareProviderPersonBirthTime = new TSImpl();
    private AD healthCareProviderPersonAddr = new ADImpl();


    /**
     * <p>ProviderIdentifierS</p>
     * 
     * <p>(no business name)</p>
     * 
     * <p><p>Provider ID</p></p>
     * 
     * <p>Provider identifier(s</p>
     * 
     * <p><p>Provider ID, eg. Prof. license no.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getId() {
        return this.id.rawSet();
    }


    /**
     * <p>Provider Type</p>
     * 
     * <p><p>Allows for crosswalks between speciality code sets</p></p>
     * 
     * <p>Healthcare Provider code</p>
     * 
     * <p><p>code denoting healthcare Provider Type</p></p>
     */
    @Hl7XmlMapping({"code"})
    public Code getCode() {
        return (Code) this.code.getValue();
    }
    public void setCode(Code code) {
        this.code.setValue(code);
    }


    /**
     * <p>Name of Provider</p>
     * 
     * <p><p>Name of person providing service or drug</p></p>
     * 
     * <p>Provider Name</p>
     * 
     * <p><p>Name of Provider</p></p>
     */
    @Hl7XmlMapping({"healthCareProviderPerson/name"})
    public PersonName getHealthCareProviderPersonName() {
        return this.healthCareProviderPersonName.getValue();
    }
    public void setHealthCareProviderPersonName(PersonName healthCareProviderPersonName) {
        this.healthCareProviderPersonName.setValue(healthCareProviderPersonName);
    }


    /**
     * <p>contact no.</p>
     * 
     * <p><p>contact info. for Provider</p></p>
     * 
     * <p>Provider Telecom</p>
     * 
     * <p><p>Telephone no. of provider</p></p>
     * 
     * <p><p>only required if provider is not known to the 
     * Payor</p></p>
     */
    @Hl7XmlMapping({"healthCareProviderPerson/telecom"})
    public TelecommunicationAddress getHealthCareProviderPersonTelecom() {
        return this.healthCareProviderPersonTelecom.getValue();
    }
    public void setHealthCareProviderPersonTelecom(TelecommunicationAddress healthCareProviderPersonTelecom) {
        this.healthCareProviderPersonTelecom.setValue(healthCareProviderPersonTelecom);
    }


    /**
     * <p>ProviderGender</p>
     * 
     * <p>Provider Gender</p>
     * 
     * <p><p>Telecom, gender, birth time, addr are only required if 
     * provider is not known to the Payor</p></p>
     * 
     * <p>Provider Gender</p>
     * 
     * <p><p>only required if provider is not known to the 
     * Payor</p></p>
     */
    @Hl7XmlMapping({"healthCareProviderPerson/administrativeGenderCode"})
    public AdministrativeGender getHealthCareProviderPersonAdministrativeGenderCode() {
        return (AdministrativeGender) this.healthCareProviderPersonAdministrativeGenderCode.getValue();
    }
    public void setHealthCareProviderPersonAdministrativeGenderCode(AdministrativeGender healthCareProviderPersonAdministrativeGenderCode) {
        this.healthCareProviderPersonAdministrativeGenderCode.setValue(healthCareProviderPersonAdministrativeGenderCode);
    }


    /**
     * <p>Provider Birth date</p>
     * 
     * <p><p>only required if provider is not known to the 
     * Payor</p></p>
     * 
     * <p>Provider Date of Birth</p>
     * 
     * <p><p>Telecom, gender, birth time, addr are only required if 
     * provider is not known to the Payor</p></p>
     */
    @Hl7XmlMapping({"healthCareProviderPerson/birthTime"})
    public Date getHealthCareProviderPersonBirthTime() {
        return this.healthCareProviderPersonBirthTime.getValue();
    }
    public void setHealthCareProviderPersonBirthTime(Date healthCareProviderPersonBirthTime) {
        this.healthCareProviderPersonBirthTime.setValue(healthCareProviderPersonBirthTime);
    }


    /**
     * <p>ProviderAddress</p>
     * 
     * <p>Provider Address</p>
     * 
     * <p><p>Can be used to specify jurisdiction for OOJ 
     * providers</p></p>
     * 
     * <p>Provider Address</p>
     * 
     * <p><p>Telecom, gender, birth time, addr are only required if 
     * provider is not known to the Payor</p></p>
     * 
     * <p><p>Can be used to specify jurisdiction for OOJ 
     * providers</p></p>
     */
    @Hl7XmlMapping({"healthCareProviderPerson/addr"})
    public PostalAddress getHealthCareProviderPersonAddr() {
        return this.healthCareProviderPersonAddr.getValue();
    }
    public void setHealthCareProviderPersonAddr(PostalAddress healthCareProviderPersonAddr) {
        this.healthCareProviderPersonAddr.setValue(healthCareProviderPersonAddr);
    }

}