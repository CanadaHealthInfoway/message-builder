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

package ca.infoway.messagebuilder.model.newfoundland;

import java.io.Serializable;
import java.util.Set;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.ServiceDeliveryLocationRoleType;
import ca.infoway.messagebuilder.model.MessagePartBean;

@Hl7PartTypeMapping({ "COCT_MT240002CA.ServiceDeliveryLocation", "COCT_MT240003CA.ServiceDeliveryLocation_V01R04_3_HOTFIX2", "COCT_MT240003CA.ServiceDeliveryLocation", "COCT_MT240007CA.ServiceDeliveryLocation", "COCT_MT240012CA.ServiceDeliveryLocation_V02R02", "PORX_MT010120CA.ServiceDeliveryLocation", "PORX_MT020060CA.ServiceDeliveryLocation", "PORX_MT020070CA.ServiceDeliveryLocation", "PORX_MT060010CA.ServiceDeliveryLocation", "PORX_MT060040CA.ServiceDeliveryLocation", "PORX_MT060040CA.ServiceDeliveryLocation2" })
public class ServiceDeliveryLocationBean extends MessagePartBean implements Recipient, Serializable {

    private static final long serialVersionUID = -1966956136012726201L;

    private II identifier = new IIImpl();

    private ST name = new STImpl();

    private AD addr = new ADImpl();

    private final SET<TEL, TelecommunicationAddress> telecom = new SETImpl<TEL, TelecommunicationAddress>(TELImpl.class);

    private CD code = new CDImpl();

    @Hl7XmlMapping("id")
    public Identifier getIdentifier() {
        return this.identifier.getValue();
    }

    public void setIdentifier(Identifier identifier) {
        this.identifier.setValue(identifier);
    }

    @Hl7XmlMapping("location/name")
    public String getName() {
        return this.name.getValue();
    }

    public void setName(String name) {
        this.name.setValue(name);
    }

    @Hl7XmlMapping("addr")
    public PostalAddress getAddr() {
        return this.addr.getValue();
    }

    public void setAddr(PostalAddress addr) {
        this.addr.setValue(addr);
    }

    @Hl7XmlMapping("telecom")
    public Set<TelecommunicationAddress> getTelecom() {
        return this.telecom.rawSet();
    }

    @Hl7XmlMapping("code")
    public ServiceDeliveryLocationRoleType getCode() {
        return (ServiceDeliveryLocationRoleType) this.code.getValue();
    }

    public void setCode(ServiceDeliveryLocationRoleType code) {
        this.code.setValue(code);
    }
}
