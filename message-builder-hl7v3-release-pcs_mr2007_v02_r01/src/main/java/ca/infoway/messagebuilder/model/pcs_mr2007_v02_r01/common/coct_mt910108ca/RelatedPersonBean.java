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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.common.coct_mt910108ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.x_SimplePersonalRelationship;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



@Hl7PartTypeMapping({"COCT_MT910108CA.PersonalRelationship"})
@Hl7RootType
public class RelatedPersonBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.common.coct_mt911108ca.ActingPerson {

    private static final long serialVersionUID = 20110729L;
    private II relatedPersonIdentifier = new IIImpl();
    private CV responsiblePersonType = new CVImpl();
    private PN relatedPersonName = new PNImpl();
    private SET<TEL, TelecommunicationAddress> relatedPersonPhonesAndEmails = new SETImpl<TEL, TelecommunicationAddress>(TELImpl.class);
    private AD relatedPersonAddress = new ADImpl();


    /**
     * <p>B:Related Person Identifier</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getRelatedPersonIdentifier() {
        return this.relatedPersonIdentifier.getValue();
    }
    public void setRelatedPersonIdentifier(Identifier relatedPersonIdentifier) {
        this.relatedPersonIdentifier.setValue(relatedPersonIdentifier);
    }


    /**
     * <p>C:Responsible Person Type</p>
     */
    @Hl7XmlMapping({"code"})
    public x_SimplePersonalRelationship getResponsiblePersonType() {
        return (x_SimplePersonalRelationship) this.responsiblePersonType.getValue();
    }
    public void setResponsiblePersonType(x_SimplePersonalRelationship responsiblePersonType) {
        this.responsiblePersonType.setValue(responsiblePersonType);
    }


    /**
     * <p>A:Related Person Name</p>
     */
    @Hl7XmlMapping({"relationshipHolder/name"})
    public PersonName getRelatedPersonName() {
        return this.relatedPersonName.getValue();
    }
    public void setRelatedPersonName(PersonName relatedPersonName) {
        this.relatedPersonName.setValue(relatedPersonName);
    }


    /**
     * <p>E:Related Person Phones and Emails</p>
     */
    @Hl7XmlMapping({"relationshipHolder/telecom"})
    public Set<TelecommunicationAddress> getRelatedPersonPhonesAndEmails() {
        return this.relatedPersonPhonesAndEmails.rawSet();
    }


    /**
     * <p>D:Related Person Address</p>
     */
    @Hl7XmlMapping({"relationshipHolder/addr"})
    public PostalAddress getRelatedPersonAddress() {
        return this.relatedPersonAddress.getValue();
    }
    public void setRelatedPersonAddress(PostalAddress relatedPersonAddress) {
        this.relatedPersonAddress.setValue(relatedPersonAddress);
    }

}
