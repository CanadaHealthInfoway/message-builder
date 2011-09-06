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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>PriorTestRequest</p>
 * 
 * <p>POLB_MT001999CA.PriorActRequest: Prior Test Request</p>
 * 
 * <p><p>Must contain a value assigned by the order-placing 
 * organization that uniquely identifies this test request 
 * among all test requests in the receiving application.</p></p>
 * 
 * <p><p>This is used primarily for Order referrals.</p></p>
 * 
 * <p>POLB_MT001010CA.PriorActRequest: Prior Test Request</p>
 * 
 * <p><p>The classCode shall carry one of '''ACT''', 
 * '''BATTERY''' or '''OBS''' according to the parent order 
 * classCode.</p></p>
 * 
 * <p><p>Must contain a value assigned by the order-placing 
 * organization that uniquely identifies this test request 
 * among all test requests in the receiving application.</p></p>
 * 
 * <p><p>This is used primarily for Order referrals.</p></p>
 * 
 * <p>POLB_MT001001CA.PriorActRequest: Prior Test Request</p>
 * 
 * <p><p>The classCode shall carry one of '''ACT''', 
 * '''BATTERY''' or '''OBS''' according to the parent order 
 * classCode.</p></p>
 * 
 * <p><p>Must contain a value assigned by the order-placing 
 * organization that uniquely identifies this test request 
 * among all test requests in the receiving application.</p></p>
 * 
 * <p><p>This is used primarily for Order referrals.</p></p>
 */
@Hl7PartTypeMapping({"POLB_MT001000CA.PriorActRequest","POLB_MT001001CA.PriorActRequest","POLB_MT001010CA.PriorActRequest","POLB_MT001999CA.PriorActRequest"})
public class PriorTestRequestBean extends MessagePartBean {

    private static final long serialVersionUID = 20110906L;
    private II priorTestIdentifier = new IIImpl();
    private CS priorTestStatus = new CSImpl();


    /**
     * <p>PriorTestIdentifier</p>
     * 
     * <p>Prior Test Identifier</p>
     * 
     * <p><p>Uniquely identifies this test request among all test 
     * requests in the receiving application.</p></p>
     * 
     * <p><p>Used for order referrals. This attribute communicates 
     * the identifier of the original test request (target) from 
     * which the (source) referral request originated.</p></p>
     * 
     * <p>Prior Test Identifier</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getPriorTestIdentifier() {
        return this.priorTestIdentifier.getValue();
    }
    public void setPriorTestIdentifier(Identifier priorTestIdentifier) {
        this.priorTestIdentifier.setValue(priorTestIdentifier);
    }


    /**
     * <p>PriorTestStatus</p>
     * 
     * <p>Prior Test Status</p>
     * 
     * <p><p>The status of the prior test request.</p></p>
     * 
     * <p><p>Used for order referrals.</p></p>
     * 
     * <p>Prior Test Status</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getPriorTestStatus() {
        return (ActStatus) this.priorTestStatus.getValue();
    }
    public void setPriorTestStatus(ActStatus priorTestStatus) {
        this.priorTestStatus.setValue(priorTestStatus);
    }

}
