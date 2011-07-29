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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.claims.coct_mt300000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.List;



@Hl7PartTypeMapping({"COCT_MT300000CA.PrescriberPerson"})
public class PersonPrescribingBean extends MessagePartBean {

    private static final long serialVersionUID = 20110729L;
    private PN prescriberName = new PNImpl();
    private LIST<TEL, TelecommunicationAddress> prescriberTelephoneNumber = new LISTImpl<TEL, TelecommunicationAddress>(TELImpl.class);


    /**
     * <p>Prescriber Name</p>
     */
    @Hl7XmlMapping({"name"})
    public PersonName getPrescriberName() {
        return this.prescriberName.getValue();
    }
    public void setPrescriberName(PersonName prescriberName) {
        this.prescriberName.setValue(prescriberName);
    }


    /**
     * <p>Prescriber Telephone Number</p>
     */
    @Hl7XmlMapping({"telecom"})
    public List<TelecommunicationAddress> getPrescriberTelephoneNumber() {
        return this.prescriberTelephoneNumber.rawList();
    }

}
