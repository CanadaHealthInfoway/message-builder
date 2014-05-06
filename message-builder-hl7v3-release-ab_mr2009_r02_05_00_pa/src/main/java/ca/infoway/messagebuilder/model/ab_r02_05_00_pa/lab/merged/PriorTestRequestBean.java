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
package ca.infoway.messagebuilder.model.ab_r02_05_00_pa.lab.merged;

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
 * <p>Business Name: PriorTestRequest</p>
 * 
 * <p>POLB_MT001999CA.PriorActRequest: Prior Test Request</p>
 * 
 * <p>This is used primarily for Order referrals.</p>
 * 
 * <p>Must contain a value assigned by the order-placing 
 * organization that uniquely identifies this test request 
 * among all test requests in the receiving application.</p>
 * 
 * <p>POLB_MT001010CA.PriorActRequest: Prior Test Request</p>
 * 
 * <p>The classCode shall carry one of '''ACT''', '''BATTERY''' 
 * or '''OBS''' according to the parent order classCode.</p>
 * 
 * <p>This is used primarily for Order referrals.</p>
 * 
 * <p>Must contain a value assigned by the order-placing 
 * organization that uniquely identifies this test request 
 * among all test requests in the receiving application.</p>
 * 
 * <p>POLB_MT001001CA.PriorActRequest: Prior Test Request</p>
 * 
 * <p>The classCode shall carry one of '''ACT''', '''BATTERY''' 
 * or '''OBS''' according to the parent order classCode.</p>
 * 
 * <p>This is used primarily for Order referrals.</p>
 * 
 * <p>Must contain a value assigned by the order-placing 
 * organization that uniquely identifies this test request 
 * among all test requests in the receiving application.</p>
 */
@Hl7PartTypeMapping({"POLB_MT001000CA.PriorActRequest","POLB_MT001001CA.PriorActRequest","POLB_MT001010CA.PriorActRequest","POLB_MT001999CA.PriorActRequest"})
public class PriorTestRequestBean extends MessagePartBean {

    private static final long serialVersionUID = 20140501L;
    private II id = new IIImpl();
    private CS statusCode = new CSImpl();


    /**
     * <p>Business Name: PriorTestIdentifier</p>
     * 
     * <p>Un-merged Business Name: PriorTestIdentifier</p>
     * 
     * <p>Relationship: POLB_MT001000CA.PriorActRequest.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: PriorTestIdentifier</p>
     * 
     * <p>Relationship: POLB_MT001999CA.PriorActRequest.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used for order referrals. This attribute communicates the 
     * identifier of the original test request (target) from which 
     * the (source) referral request originated.</p>
     * 
     * <p>Uniquely identifies this test request among all test 
     * requests in the receiving application.</p>
     * 
     * <p>Un-merged Business Name: PriorTestIdentifier</p>
     * 
     * <p>Relationship: POLB_MT001001CA.PriorActRequest.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used for order referrals. This attribute communicates the 
     * identifier of the original test request (target) from which 
     * the (source) referral request originated.</p>
     * 
     * <p>Uniquely identifies this test request among all test 
     * requests in the receiving application.</p>
     * 
     * <p>Un-merged Business Name: PriorTestIdentifier</p>
     * 
     * <p>Relationship: POLB_MT001010CA.PriorActRequest.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used for order referrals. This attribute communicates the 
     * identifier of the original test request (target) from which 
     * the (source) referral request originated.</p>
     * 
     * <p>Uniquely identifies this test request among all test 
     * requests in the receiving application.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: PriorTestIdentifier</p>
     * 
     * <p>Un-merged Business Name: PriorTestIdentifier</p>
     * 
     * <p>Relationship: POLB_MT001000CA.PriorActRequest.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: PriorTestIdentifier</p>
     * 
     * <p>Relationship: POLB_MT001999CA.PriorActRequest.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used for order referrals. This attribute communicates the 
     * identifier of the original test request (target) from which 
     * the (source) referral request originated.</p>
     * 
     * <p>Uniquely identifies this test request among all test 
     * requests in the receiving application.</p>
     * 
     * <p>Un-merged Business Name: PriorTestIdentifier</p>
     * 
     * <p>Relationship: POLB_MT001001CA.PriorActRequest.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used for order referrals. This attribute communicates the 
     * identifier of the original test request (target) from which 
     * the (source) referral request originated.</p>
     * 
     * <p>Uniquely identifies this test request among all test 
     * requests in the receiving application.</p>
     * 
     * <p>Un-merged Business Name: PriorTestIdentifier</p>
     * 
     * <p>Relationship: POLB_MT001010CA.PriorActRequest.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used for order referrals. This attribute communicates the 
     * identifier of the original test request (target) from which 
     * the (source) referral request originated.</p>
     * 
     * <p>Uniquely identifies this test request among all test 
     * requests in the receiving application.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: PriorTestStatus</p>
     * 
     * <p>Un-merged Business Name: PriorTestStatus</p>
     * 
     * <p>Relationship: POLB_MT001000CA.PriorActRequest.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: PriorTestStatus</p>
     * 
     * <p>Relationship: POLB_MT001999CA.PriorActRequest.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used for order referrals.</p>
     * 
     * <p>The status of the prior test request.</p>
     * 
     * <p>Un-merged Business Name: PriorTestStatus</p>
     * 
     * <p>Relationship: POLB_MT001001CA.PriorActRequest.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used for order referrals.</p>
     * 
     * <p>The status of the prior test request.</p>
     * 
     * <p>Un-merged Business Name: PriorTestStatus</p>
     * 
     * <p>Relationship: POLB_MT001010CA.PriorActRequest.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used for order referrals.</p>
     * 
     * <p>The status of the prior test request.</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    /**
     * <p>Business Name: PriorTestStatus</p>
     * 
     * <p>Un-merged Business Name: PriorTestStatus</p>
     * 
     * <p>Relationship: POLB_MT001000CA.PriorActRequest.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: PriorTestStatus</p>
     * 
     * <p>Relationship: POLB_MT001999CA.PriorActRequest.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used for order referrals.</p>
     * 
     * <p>The status of the prior test request.</p>
     * 
     * <p>Un-merged Business Name: PriorTestStatus</p>
     * 
     * <p>Relationship: POLB_MT001001CA.PriorActRequest.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used for order referrals.</p>
     * 
     * <p>The status of the prior test request.</p>
     * 
     * <p>Un-merged Business Name: PriorTestStatus</p>
     * 
     * <p>Relationship: POLB_MT001010CA.PriorActRequest.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used for order referrals.</p>
     * 
     * <p>The status of the prior test request.</p>
     */
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }

}