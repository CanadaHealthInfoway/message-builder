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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.si.rcmr_mt010001ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.merged.Recipient;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>Business Name: *consent given to</p>
 * 
 * <p>Identifies the beneficiary of the consent as being a 
 * Provider or Service Location.</p>
 * 
 * <p>Indicates who is being authorized to receive the 
 * information, and is therefore populated.</p>
 */
@Hl7PartTypeMapping({"RCMR_MT010001CA.Receiver"})
public class ConsentGivenToBean extends MessagePartBean {

    private static final long serialVersionUID = 20121204L;
    private List<Recipient> recipient = new ArrayList<Recipient>();


    /**
     * <p><strong>NOTE: Although the CeRx specification allows for 
     * a Service Delivery Location to be specified, in SK, consent 
     * can only be given to a specific provider, so this has been 
     * constrained to only allow the Assigned Person.</strong></p>
     * 
     * <p>If a provider is specified here, then the consent is only 
     * being given to that provider. If a facility is specified, 
     * then the consent is being given to all providers who work at 
     * that facility.</p>
     */
    @Hl7XmlMapping({"recipient"})
    public List<Recipient> getRecipient() {
        return this.recipient;
    }

}
