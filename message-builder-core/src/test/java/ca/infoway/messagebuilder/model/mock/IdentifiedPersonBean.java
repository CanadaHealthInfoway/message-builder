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

package ca.infoway.messagebuilder.model.mock;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.RoleStatus;
import ca.infoway.messagebuilder.domainvalue.x_NormalRestrictedTabooConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;

@Hl7PartTypeMapping({ "COCT_MT050202CA.Patient", "COCT_MT050203CA.Patient", "COCT_MT050207CA.Patient", "PRPA_MT101001CA.IdentifiedEntity", "PRPA_MT101002CA.IdentifiedEntity", "PRPA_MT101003CA.IdentifiedEntity", "PRPA_MT101102CA.IdentifiedEntity", "PRPA_MT101104CA.IdentifiedEntity", "PRPA_MT101106CA.IdentifiedEntity" })
public class IdentifiedPersonBean extends MessagePartBean implements Serializable {

    private static final long serialVersionUID = 6526376510028522480L;

    private final SET<II, Identifier> ids = new SETImpl<II, Identifier>(IIImpl.class);

    private final AD address = new ADImpl();

    private final LIST<TEL, TelecommunicationAddress> telecom = new LISTImpl<TEL, TelecommunicationAddress>(TELImpl.class);

    private IndeterminatePersonBean indeterminatePerson = new IndeterminatePersonBean();

    private final CD statusCode = new CDImpl();

    private final IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();

    private final CD confidentialityCode = new CDImpl();

    private ObservationEventMatchBean observationEventBean;

    @Hl7XmlMapping("id")
    public Set<Identifier> getIds() {
        return this.ids.rawSet();
    }

    public Identifier getId() {
        return this.getIds().isEmpty() ? null : new ArrayList<Identifier>(this.getIds()).get(0);
    }

    public void setId(Identifier id) {
        this.getIds().clear();
        this.getIds().add(id);
    }

    @Hl7XmlMapping("addr")
    public PostalAddress getAddress() {
        return this.address.getValue();
    }

    public void setAddress(PostalAddress address) {
        this.address.setValue(address);
    }

    @Hl7XmlMapping("telecom")
    public List<TelecommunicationAddress> getTelecom() {
        return this.telecom.rawList();
    }

    @Hl7XmlMapping({ "patientPerson", "agentPerson", "identifiedPerson" })
    public IndeterminatePersonBean getIndeterminatePerson() {
        return indeterminatePerson;
    }

    public void setIndeterminatePerson(IndeterminatePersonBean indeterminatePerson) {
        this.indeterminatePerson = indeterminatePerson;
    }

    @Hl7XmlMapping("statusCode")
    public RoleStatus getStatusCode() {
        return (RoleStatus) this.statusCode.getValue();
    }

    public void setStatusCode(RoleStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }

    @Hl7XmlMapping("effectiveTime")
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }

    @Hl7XmlMapping("confidentialityCode")
    public x_NormalRestrictedTabooConfidentialityKind getConfidentialityCode() {
        return (x_NormalRestrictedTabooConfidentialityKind) this.confidentialityCode.getValue();
    }

    public void setConfidentialityCode(x_NormalRestrictedTabooConfidentialityKind confidentialityCode) {
        this.confidentialityCode.setValue(confidentialityCode);
    }

    @Hl7XmlMapping("subjectOf/observationEvent")
    public ObservationEventMatchBean getObservationEventBean() {
        return observationEventBean;
    }

    public void setObservationEventBean(ObservationEventMatchBean observationEventBean) {
        this.observationEventBean = observationEventBean;
    }
}
