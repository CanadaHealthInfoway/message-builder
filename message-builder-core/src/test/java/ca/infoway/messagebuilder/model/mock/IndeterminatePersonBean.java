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

package ca.infoway.messagebuilder.model.mock;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
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

@Hl7PartTypeMapping({ "COCT_MT050203CA.Person", "PRPA_MT101001CA.Person", "PRPA_MT101002CA.Person", "PRPA_MT101102CA.Person" })
public class IndeterminatePersonBean extends MessagePartBean implements Serializable {

    private static final long serialVersionUID = 768511136435678165L;

    private final LIST<PN, PersonName> names = new LISTImpl<PN, PersonName>(PNImpl.class);

    private final LIST<TEL, TelecommunicationAddress> telecom = new LISTImpl<TEL, TelecommunicationAddress>(TELImpl.class);

    private final CD administrativeGenderCode = new CDImpl();

    private final TS birthTime = new TSImpl();

    private final BL deceasedIndicator = new BLImpl();

    private final TS deceasedTime = new TSImpl();

    private final BL multipleBirthIndicator = new BLImpl();

    private final INT multipleBirthOrderNumber = new INTImpl();

    private final LIST<AD, PostalAddress> addresses = new LISTImpl<AD, PostalAddress>(ADImpl.class);

    private final Set<OtherIdentifiersBean> asOtherIds = new LinkedHashSet<OtherIdentifiersBean>();

    private final List<PersonalRelationshipBean> personalRelationships = new ArrayList<PersonalRelationshipBean>();

    private final SET<II, Identifier> ids = new SETImpl<II, Identifier>(IIImpl.class);

    public PersonName getName() {
        return this.getNames().isEmpty() ? null : this.getNames().get(0);
    }

    public void setName(PersonName name) {
        this.getNames().add(name);
    }

    @Hl7XmlMapping("name")
    public List<PersonName> getNames() {
        return this.names.rawList();
    }

    @Hl7XmlMapping("telecom")
    public List<TelecommunicationAddress> getTelecom() {
        return this.telecom.rawList();
    }

    @Hl7XmlMapping("administrativeGenderCode")
    public AdministrativeGender getAdministrativeGenderCode() {
        return (AdministrativeGender) this.administrativeGenderCode.getValue();
    }

    public void setAdministrativeGenderCode(AdministrativeGender administrativeGenderCode) {
        this.administrativeGenderCode.setValue(administrativeGenderCode);
    }

    @Hl7XmlMapping("birthTime")
    public Date getBirthTime() {
        return this.birthTime.getValue();
    }

    public void setBirthTime(Date birthTime) {
        this.birthTime.setValue(birthTime);
    }

    @Hl7XmlMapping("deceasedInd")
    public Boolean getDeceasedIndicator() {
        return this.deceasedIndicator.getValue();
    }

    public void setDeceasedIndicator(Boolean deceased) {
        this.deceasedIndicator.setValue(deceased);
    }

    @Hl7XmlMapping("deceasedTime")
    public Date getDeceasedTime() {
        return this.deceasedTime.getValue();
    }

    public void setDeceasedTime(Date deceasedTime) {
        this.deceasedTime.setValue(deceasedTime);
    }

    @Hl7XmlMapping("multipleBirthInd")
    public Boolean getMultipleBirthIndicator() {
        return this.multipleBirthIndicator.getValue();
    }

    public void setMultipleBirthIndicator(Boolean multipleBirthIndicator) {
        this.multipleBirthIndicator.setValue(multipleBirthIndicator);
    }

    @Hl7XmlMapping("multipleBirthOrderNumber")
    public Integer getMultipleBirthOrderNumber() {
        return this.multipleBirthOrderNumber.getValue();
    }

    public void setMultipleBirthOrderNumber(Integer multipleBirthOrderNumber) {
        this.multipleBirthOrderNumber.setValue(multipleBirthOrderNumber);
    }

    @Hl7XmlMapping("addr")
    public List<PostalAddress> getAddresses() {
        return this.addresses.rawList();
    }

    @Hl7XmlMapping("asOtherIDs")
    public Set<OtherIdentifiersBean> getAsOtherIds() {
        return asOtherIds;
    }

    @Hl7XmlMapping("personalRelationship")
    public List<PersonalRelationshipBean> getPersonalRelationships() {
        return this.personalRelationships;
    }

    @Hl7XmlMapping({ "id" })
    public Set<Identifier> getIds() {
        return this.ids.rawSet();
    }

}
