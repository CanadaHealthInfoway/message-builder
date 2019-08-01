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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: ConsentGivenTo</p>
 * 
 * <p>RCMR_MT010001ON.Receiver: *consent given to</p>
 * 
 * <p>Indicates who is being authorized to receive the 
 * information, and is therefore populated.</p>
 * 
 * <p>Identifies the beneficiary of the consent as being a 
 * Provider or Service Location.</p>
 * 
 * <p>COCT_MT470000ON.Receiver: *consent given to</p>
 * 
 * <p>Indicates who is receiving consent to view 
 * information.</p><p>This participation is marked as 
 * &quot;populated&quot; as receiver must be specified when 
 * keyword is involved.</p>
 * 
 * <p>Identifies the beneficiary of the consent as being a 
 * Provider or Service Location.</p>
 */
@Hl7PartTypeMapping({"COCT_MT470000ON.Receiver","RCMR_MT010001ON.Receiver"})
public class ConsentGivenToBean extends MessagePartBean {

    private static final long serialVersionUID = 20190731L;
    private Recipient recipient;


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: RCMR_MT010001ON.Receiver.recipient</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT470000ON.Receiver.recipient</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"recipient"})
    public Recipient getRecipient() {
        return this.recipient;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: RCMR_MT010001ON.Receiver.recipient</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT470000ON.Receiver.recipient</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

}
