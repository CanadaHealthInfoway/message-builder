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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.AdministrativeContactRoleType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Set;



/**
 * <p>Business Name: ContactPoints</p>
 * 
 * <p>PRPA_MT202302CA.ContactParty: Contact Points</p>
 * 
 * <p>At least one of addr or telecom must be supplied.</p>
 * 
 * <p>One of the most common reasons for looking up a service 
 * delivery location is to find contact information for the 
 * location.</p>
 * 
 * <p>Administrative contacts within a location, allowing for 
 * communication with various departments or areas.</p>
 * 
 * <p>PRPA_MT202301CA.ContactParty: Contact Points</p>
 * 
 * <p>At least one of addr or telecom must be supplied.</p>
 * 
 * <p>One of the most common reasons for looking up a service 
 * delivery location is to find contact information for the 
 * location.</p>
 * 
 * <p>Administrative contacts within a location, allowing for 
 * communication with various departments or areas.</p>
 * 
 * <p>PRPA_MT202303CA.ContactParty: Contact Points</p>
 * 
 * <p>At least one of addr or telecom must be supplied.</p>
 * 
 * <p>One of the most common reasons for looking up a service 
 * delivery location is to find contact information for the 
 * location.</p>
 * 
 * <p>Administrative contacts within a location, allowing for 
 * communication with various departments or areas.</p>
 */
@Hl7PartTypeMapping({"PRPA_MT202301CA.ContactParty","PRPA_MT202302CA.ContactParty","PRPA_MT202303CA.ContactParty"})
public class ContactPointsBean extends MessagePartBean {

    private static final long serialVersionUID = 20130613L;
    private CV code = new CVImpl();
    private AD addr = new ADImpl();
    private SET<TEL, TelecommunicationAddress> telecom = new SETImpl<TEL, TelecommunicationAddress>(TELImpl.class);


    /**
     * <p>Business Name: ContactType</p>
     * 
     * <p>Un-merged Business Name: ContactType</p>
     * 
     * <p>Relationship: PRPA_MT202302CA.ContactParty.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Helps the user to know which set of contact information 
     * should be used in a particular circumstance. This is a key 
     * differentiator of each contact point, and is therefore 
     * mandatory.</p>
     * 
     * <p>Identifies the general purpose for which this contact 
     * information is appropriate. E.g. Admitting, billing, 
     * after-hours, etc.</p>
     * 
     * <p>Un-merged Business Name: ContactType</p>
     * 
     * <p>Relationship: PRPA_MT202301CA.ContactParty.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Helps the user to know which set of contact information 
     * should be used in a particular circumstance. This is a key 
     * differentiator of each contact point, and is therefore 
     * mandatory.</p>
     * 
     * <p>Identifies the general purpose for which this contact 
     * information is appropriate. E.g. Admitting, billing, 
     * after-hours, etc.</p>
     * 
     * <p>Un-merged Business Name: ContactType</p>
     * 
     * <p>Relationship: PRPA_MT202303CA.ContactParty.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Helps the user to know which set of contact information 
     * should be used in a particular circumstance. This is a key 
     * differentiator of each contact point, and is therefore 
     * mandatory.</p>
     * 
     * <p>Identifies the general purpose for which this contact 
     * information is appropriate. E.g. Admitting, billing, 
     * after-hours, etc.</p>
     */
    @Hl7XmlMapping({"code"})
    public AdministrativeContactRoleType getCode() {
        return (AdministrativeContactRoleType) this.code.getValue();
    }

    /**
     * <p>Business Name: ContactType</p>
     * 
     * <p>Un-merged Business Name: ContactType</p>
     * 
     * <p>Relationship: PRPA_MT202302CA.ContactParty.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Helps the user to know which set of contact information 
     * should be used in a particular circumstance. This is a key 
     * differentiator of each contact point, and is therefore 
     * mandatory.</p>
     * 
     * <p>Identifies the general purpose for which this contact 
     * information is appropriate. E.g. Admitting, billing, 
     * after-hours, etc.</p>
     * 
     * <p>Un-merged Business Name: ContactType</p>
     * 
     * <p>Relationship: PRPA_MT202301CA.ContactParty.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Helps the user to know which set of contact information 
     * should be used in a particular circumstance. This is a key 
     * differentiator of each contact point, and is therefore 
     * mandatory.</p>
     * 
     * <p>Identifies the general purpose for which this contact 
     * information is appropriate. E.g. Admitting, billing, 
     * after-hours, etc.</p>
     * 
     * <p>Un-merged Business Name: ContactType</p>
     * 
     * <p>Relationship: PRPA_MT202303CA.ContactParty.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Helps the user to know which set of contact information 
     * should be used in a particular circumstance. This is a key 
     * differentiator of each contact point, and is therefore 
     * mandatory.</p>
     * 
     * <p>Identifies the general purpose for which this contact 
     * information is appropriate. E.g. Admitting, billing, 
     * after-hours, etc.</p>
     */
    public void setCode(AdministrativeContactRoleType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: ContactAddress</p>
     * 
     * <p>Un-merged Business Name: ContactAddress</p>
     * 
     * <p>Relationship: PRPA_MT202302CA.ContactParty.addr</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Used when communicating by post. Physical addresses may 
     * also be used for courier-type deliveries.</p>
     * 
     * <p>Provides a mailing address for the location</p>
     * 
     * <p>Un-merged Business Name: ContactAddress</p>
     * 
     * <p>Relationship: PRPA_MT202301CA.ContactParty.addr</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Used when communicating by post. Physical addresses may 
     * also be used for courier-type deliveries.</p>
     * 
     * <p>Provides a mailing address for the location</p>
     * 
     * <p>Un-merged Business Name: ContactAddress</p>
     * 
     * <p>Relationship: PRPA_MT202303CA.ContactParty.addr</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Used when communicating by post. Physical addresses may 
     * also be used for courier-type deliveries.</p>
     * 
     * <p>Provides a mailing address for the location</p>
     */
    @Hl7XmlMapping({"addr"})
    public PostalAddress getAddr() {
        return this.addr.getValue();
    }

    /**
     * <p>Business Name: ContactAddress</p>
     * 
     * <p>Un-merged Business Name: ContactAddress</p>
     * 
     * <p>Relationship: PRPA_MT202302CA.ContactParty.addr</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Used when communicating by post. Physical addresses may 
     * also be used for courier-type deliveries.</p>
     * 
     * <p>Provides a mailing address for the location</p>
     * 
     * <p>Un-merged Business Name: ContactAddress</p>
     * 
     * <p>Relationship: PRPA_MT202301CA.ContactParty.addr</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Used when communicating by post. Physical addresses may 
     * also be used for courier-type deliveries.</p>
     * 
     * <p>Provides a mailing address for the location</p>
     * 
     * <p>Un-merged Business Name: ContactAddress</p>
     * 
     * <p>Relationship: PRPA_MT202303CA.ContactParty.addr</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Used when communicating by post. Physical addresses may 
     * also be used for courier-type deliveries.</p>
     * 
     * <p>Provides a mailing address for the location</p>
     */
    public void setAddr(PostalAddress addr) {
        this.addr.setValue(addr);
    }


    /**
     * <p>Business Name: ContactPhoneNumberAndEmails</p>
     * 
     * <p>Un-merged Business Name: ContactPhoneNumberAndEmails</p>
     * 
     * <p>Relationship: PRPA_MT202302CA.ContactParty.telecom</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-3)</p>
     * 
     * <p>Used for more immediate contact requirements</p>
     * 
     * <p>Information used to communicate with the location by 
     * phone, fax or e-mail.</p>
     * 
     * <p>Un-merged Business Name: ContactPhoneNumberAndEmails</p>
     * 
     * <p>Relationship: PRPA_MT202301CA.ContactParty.telecom</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-3)</p>
     * 
     * <p>Used for more immediate contact requirements</p>
     * 
     * <p>Information used to communicate with the location by 
     * phone, fax or e-mail.</p>
     * 
     * <p>Un-merged Business Name: ContactPhoneNumberAndEmails</p>
     * 
     * <p>Relationship: PRPA_MT202303CA.ContactParty.telecom</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-3)</p>
     * 
     * <p>Used for more immediate contact requirements</p>
     * 
     * <p>Information used to communicate with the location by 
     * phone, fax or e-mail.</p>
     */
    @Hl7XmlMapping({"telecom"})
    public Set<TelecommunicationAddress> getTelecom() {
        return this.telecom.rawSet();
    }

}
