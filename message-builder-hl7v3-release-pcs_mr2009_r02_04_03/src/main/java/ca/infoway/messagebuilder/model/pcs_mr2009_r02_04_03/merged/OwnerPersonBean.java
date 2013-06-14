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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: OwnerPerson</p>
 * 
 * <p>COCT_MT050303CA.ContactPerson: Owner Person</p>
 * 
 * <p>Important for tracking responsibility for decision making 
 * and other actions taken on behalf of an animal patient.</p>
 * 
 * <p>Describes a person who is to be contacted regarding the 
 * delivery of healthcare to the animal.</p>
 */
@Hl7PartTypeMapping({"COCT_MT050303CA.ContactPerson","FICR_MT500201CA.ContactPerson","FICR_MT600201CA.ContactPerson"})
public class OwnerPersonBean extends MessagePartBean {

    private static final long serialVersionUID = 20130614L;
    private PN name = new PNImpl();
    private TEL telecom = new TELImpl();


    /**
     * <p>Un-merged Business Name: OwnerName</p>
     * 
     * <p>Relationship: COCT_MT050303CA.ContactPerson.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used when contacting or addressing the owner person. 
     * Because this will be the principle means of identifying the 
     * owner person, it is mandatory.</p>
     * 
     * <p>The name by which the owner person is known</p>
     * 
     * <p>Un-merged Business Name: ContactPersonName</p>
     * 
     * <p>Relationship: FICR_MT500201CA.ContactPerson.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: ContactPersonName</p>
     * 
     * <p>Relationship: FICR_MT600201CA.ContactPerson.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"name"})
    public PersonName getName() {
        return this.name.getValue();
    }

    /**
     * <p>Un-merged Business Name: OwnerName</p>
     * 
     * <p>Relationship: COCT_MT050303CA.ContactPerson.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used when contacting or addressing the owner person. 
     * Because this will be the principle means of identifying the 
     * owner person, it is mandatory.</p>
     * 
     * <p>The name by which the owner person is known</p>
     * 
     * <p>Un-merged Business Name: ContactPersonName</p>
     * 
     * <p>Relationship: FICR_MT500201CA.ContactPerson.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: ContactPersonName</p>
     * 
     * <p>Relationship: FICR_MT600201CA.ContactPerson.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setName(PersonName name) {
        this.name.setValue(name);
    }


    /**
     * <p>Business Name: ContactPersonTelephoneOrEmailDetails</p>
     * 
     * <p>Un-merged Business Name: 
     * ContactPersonTelephoneOrEmailDetails</p>
     * 
     * <p>Relationship: FICR_MT500201CA.ContactPerson.telecom</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: 
     * ContactPersonTelephoneOrEmailDetails</p>
     * 
     * <p>Relationship: FICR_MT600201CA.ContactPerson.telecom</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"telecom"})
    public TelecommunicationAddress getTelecom() {
        return this.telecom.getValue();
    }

    /**
     * <p>Business Name: ContactPersonTelephoneOrEmailDetails</p>
     * 
     * <p>Un-merged Business Name: 
     * ContactPersonTelephoneOrEmailDetails</p>
     * 
     * <p>Relationship: FICR_MT500201CA.ContactPerson.telecom</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: 
     * ContactPersonTelephoneOrEmailDetails</p>
     * 
     * <p>Relationship: FICR_MT600201CA.ContactPerson.telecom</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setTelecom(TelecommunicationAddress telecom) {
        this.telecom.setValue(telecom);
    }

}
