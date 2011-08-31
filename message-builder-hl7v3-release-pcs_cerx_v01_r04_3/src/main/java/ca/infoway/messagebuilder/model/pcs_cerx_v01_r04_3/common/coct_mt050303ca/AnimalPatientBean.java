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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.coct_mt050303ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



@Hl7PartTypeMapping({"COCT_MT050303CA.Patient"})
@Hl7RootType
public class AnimalPatientBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.merged.Patient {

    private static final long serialVersionUID = 20110831L;
    private ST animalName = new STImpl();
    private AD ownerAddress = new ADImpl();
    private SET<TEL, TelecommunicationAddress> ownerPhonesAndEmails = new SETImpl<TEL, TelecommunicationAddress>(TELImpl.class);
    private PN ownerName = new PNImpl();


    /**
     * <p>B:Animal name</p>
     */
    @Hl7XmlMapping({"patientAnimal/name"})
    public String getAnimalName() {
        return this.animalName.getValue();
    }
    public void setAnimalName(String animalName) {
        this.animalName.setValue(animalName);
    }


    /**
     * <p>Owner address</p>
     */
    @Hl7XmlMapping({"patientAnimal/contactParty/addr"})
    public PostalAddress getOwnerAddress() {
        return this.ownerAddress.getValue();
    }
    public void setOwnerAddress(PostalAddress ownerAddress) {
        this.ownerAddress.setValue(ownerAddress);
    }


    /**
     * <p>Owner Phones and Emails</p>
     */
    @Hl7XmlMapping({"patientAnimal/contactParty/telecom"})
    public Set<TelecommunicationAddress> getOwnerPhonesAndEmails() {
        return this.ownerPhonesAndEmails.rawSet();
    }


    /**
     * <p>Owner Name</p>
     */
    @Hl7XmlMapping({"patientAnimal/contactParty/contactPerson/name"})
    public PersonName getOwnerName() {
        return this.ownerName.getValue();
    }
    public void setOwnerName(PersonName ownerName) {
        this.ownerName.setValue(ownerName);
    }

}