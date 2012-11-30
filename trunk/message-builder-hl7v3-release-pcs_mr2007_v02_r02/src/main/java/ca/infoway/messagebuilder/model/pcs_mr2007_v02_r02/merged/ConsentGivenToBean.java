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
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>ConsentGivenTo</p>
 * 
 * <p>RCMR_MT010001CA.Receiver: *consent given to</p>
 * 
 * <p>Identifies the beneficiary of the consent as being a 
 * Provider or Service Location.</p>
 * 
 * <p>Indicates who is being authorized to receive the 
 * information, and is therefore populated.</p>
 * 
 * <p>COCT_MT470012CA.Receiver: *consent given to</p>
 * 
 * <p>Identifies the beneficiary of the consent as being a 
 * Provider or Service Location.</p>
 * 
 * <p>Indicates who is receiving consent to view 
 * information.</p><p>This participation is marked as 
 * &quot;populated&quot; as receiver must be specified when 
 * keyword is involved.</p>
 * 
 * <p>Indicates who is receiving consent to view 
 * information.</p><p>This participation is marked as 
 * &quot;populated&quot; as receiver must be specified when 
 * keyword is involved.</p>
 * 
 * <p>COCT_MT470002CA.Receiver: *consent given to</p>
 * 
 * <p>Identifies the beneficiary of the consent as being a 
 * Provider or Service Location.</p>
 * 
 * <p>Indicates who is receiving consent to view 
 * information.</p><p>This participation is marked as 
 * &quot;populated&quot; as receiver must be specified when 
 * keyword is involved.</p>
 * 
 * <p>Indicates who is receiving consent to view 
 * information.</p><p>This participation is marked as 
 * &quot;populated&quot; as receiver must be specified when 
 * keyword is involved.</p>
 */
@Hl7PartTypeMapping({"COCT_MT470002CA.Receiver","COCT_MT470012CA.Receiver","RCMR_MT010001CA.Receiver"})
public class ConsentGivenToBean extends MessagePartBean {

    private static final long serialVersionUID = 20121122L;
    private Recipient recipient;


    @Hl7XmlMapping({"recipient"})
    public Recipient getRecipient() {
        return this.recipient;
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

}
