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
package ca.infoway.messagebuilder.model.ccda_r1_1.policyactivity;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"PolicyActivity.GuarantorPerformerAssignedEntity"})
public class GuarantorPerformerAssignedEntityBean extends MessagePartBean {

    private static final long serialVersionUID = 20150220L;
    private AD addr = new ADImpl();
    private TEL telecom = new TELImpl();


    /**
     * <p>Relationship: 
     * PolicyActivity.GuarantorPerformerAssignedEntity.addr</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"addr"})
    public PostalAddress getAddr() {
        return this.addr.getValue();
    }

    /**
     * <p>Relationship: 
     * PolicyActivity.GuarantorPerformerAssignedEntity.addr</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setAddr(PostalAddress addr) {
        this.addr.setValue(addr);
    }


    /**
     * <p>Relationship: 
     * PolicyActivity.GuarantorPerformerAssignedEntity.telecom</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"telecom"})
    public TelecommunicationAddress getTelecom() {
        return this.telecom.getValue();
    }

    /**
     * <p>Relationship: 
     * PolicyActivity.GuarantorPerformerAssignedEntity.telecom</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setTelecom(TelecommunicationAddress telecom) {
        this.telecom.setValue(telecom);
    }

}
