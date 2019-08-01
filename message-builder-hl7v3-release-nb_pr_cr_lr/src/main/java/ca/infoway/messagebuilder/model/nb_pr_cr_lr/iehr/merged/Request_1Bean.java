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
package ca.infoway.messagebuilder.model.nb_pr_cr_lr.iehr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.x_ActClassCareProvisionEncounter;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: Request</p>
 * 
 * <p>REPC_MT500003CA.ActRequest: Request</p>
 * 
 * <p>Must have at least one of Request Id and Requesting 
 * Provider</p>
 * 
 * <p>Request Type is mandatory when Request Id is present</p>
 * 
 * <p> <i>There are several pieces of information about a 
 * request that may influence understanding of the record 
 * including when requested, by whom, why, etc.</i> </p>
 * 
 * <p> <i>A particular request (referral or specific request) 
 * that resulted in the creation of the Care Composition.</i> 
 * </p>
 * 
 * <p>REPC_MT220003CA.ActRequest: Request</p>
 * 
 * <p> <i>There are several pieces of information about a 
 * request that may influence understanding of the record 
 * including when requested, by whom, why, etc.</i> </p>
 * 
 * <p> <i>A particular request (referral or specific request) 
 * that resulted in the creation of the Discharge-Care 
 * Summary.</i> </p>
 * 
 * <p>REPC_MT500004CA.ActRequest: Request</p>
 * 
 * <p>Must have at least one of Request Id and Requesting 
 * Provider</p>
 * 
 * <p>Request Type is mandatory when Request Id is present</p>
 * 
 * <p> <i>There are several pieces of information about a 
 * request that may influence understanding of the record 
 * including when requested, by whom, why, etc.</i> </p>
 * 
 * <p> <i>A particular request (referral or specific request) 
 * that resulted in the creation of the Care Composition.</i> 
 * </p>
 * 
 * <p>REPC_MT000083CA.ActRequest: Request</p>
 * 
 * <p> <i>There are several pieces of information about a 
 * request that may influence understanding of the record 
 * including when requested, by whom, why, etc.</i> </p>
 * 
 * <p> <i>A particular request (referral or specific request) 
 * that resulted in the creation of the Discharge-Care 
 * Summary.</i> </p>
 * 
 * <p>REPC_MT500002CA.ActRequest: Request</p>
 * 
 * <p>Must have at least one of Request Id and Requesting 
 * Provider</p>
 * 
 * <p>Request Type is mandatory when Request Id is present</p>
 * 
 * <p> <i>There are several pieces of information about a 
 * request that may influence understanding of the record 
 * including when requested, by whom, why, etc.</i> </p>
 * 
 * <p> <i>A particular request (referral or specific request) 
 * that resulted in the creation of the Care Composition.</i> 
 * </p>
 * 
 * <p>REPC_MT220002CA.ActRequest: Request</p>
 * 
 * <p> <i>There are several pieces of information about a 
 * request that may influence understanding of the record 
 * including when requested, by whom, why, etc.</i> </p>
 * 
 * <p> <i>A particular request (referral or specific request) 
 * that resulted in the creation of the Discharge-Care 
 * Summary.</i> </p>
 * 
 * <p>REPC_MT500001CA.ActRequest: Request</p>
 * 
 * <p>Must have at least one of Request Id and Requesting 
 * Provider</p>
 * 
 * <p>Request Type is mandatory when Request Id is present</p>
 * 
 * <p> <i>There are several pieces of information about a 
 * request that may influence understanding of the record 
 * including when requested, by whom, why, etc.</i> </p>
 * 
 * <p> <i>A particular request (referral or specific request) 
 * that resulted in the creation of the Care Composition.</i> 
 * </p>
 * 
 * <p>REPC_MT220001CA.ActRequest: Request</p>
 * 
 * <p> <i>There are several pieces of information about a 
 * request that may influence understanding of the record 
 * including when requested, by whom, why, etc.</i> </p>
 * 
 * <p> <i>A particular request (referral or specific request) 
 * that resulted in the creation of the Discharge-Care 
 * Summary.</i> </p>
 */
@Hl7PartTypeMapping({"REPC_MT000083CA.ActRequest","REPC_MT220001CA.ActRequest","REPC_MT220002CA.ActRequest","REPC_MT220003CA.ActRequest","REPC_MT500001CA.ActRequest","REPC_MT500002CA.ActRequest","REPC_MT500003CA.ActRequest","REPC_MT500004CA.ActRequest"})
public class Request_1Bean extends MessagePartBean {

    private static final long serialVersionUID = 20190801L;
    private CS classCode = new CSImpl();
    private II id = new IIImpl();
    private RequestedByBean author;


    /**
     * <p>Business Name: RequestType</p>
     * 
     * <p>Un-merged Business Name: RequestType</p>
     * 
     * <p>Relationship: REPC_MT500003CA.ActRequest.classCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Needed to know what query to execute to retrieve 
     * details about the request. (I.e. Get Patient Referral vs. 
     * Get Care Composition Order.)</i> </p>
     * 
     * <p>In the near term, the only way to request delivery of 
     * care is via a referral (PCPR). However, in the future, 
     * specific encounter sheduling messages may be defined. 
     * References to those new types of records would use ENC.</p>
     * 
     * <p> <i>This distinguishes between &quot;referral&quot; 
     * requests and specific orders.</i> </p>
     * 
     * <p>Un-merged Business Name: RequestType</p>
     * 
     * <p>Relationship: REPC_MT220003CA.ActRequest.classCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Needed to know what query to execute to retrieve 
     * details about the request. (I.e. Get Patient Referral vs. 
     * Get Discharge-Care Summary Order.)</i> </p>
     * 
     * <p> <i>This distinguishes between &quot;referral&quot; 
     * requests and specific orders.</i> </p>
     * 
     * <p>Un-merged Business Name: RequestType</p>
     * 
     * <p>Relationship: REPC_MT500004CA.ActRequest.classCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Needed to know what query to execute to retrieve 
     * details about the request. (I.e. Get Patient Referral vs. 
     * Get Care Composition Order.)</i> </p>
     * 
     * <p>In the near term, the only way to request delivery of 
     * care is via a referral (PCPR). However, in the future, 
     * specific encounter sheduling messages may be defined. 
     * References to those new types of records would use ENC.</p>
     * 
     * <p> <i>This distinguishes between &quot;referral&quot; 
     * requests and specific orders.</i> </p>
     * 
     * <p>Un-merged Business Name: RequestType</p>
     * 
     * <p>Relationship: REPC_MT000083CA.ActRequest.classCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Needed to know what query to execute to retrieve 
     * details about the request. (I.e. Get Patient Referral vs. 
     * Get Discharge-Care Summary Order.)</i> </p>
     * 
     * <p> <i>This distinguishes between &quot;referral&quot; 
     * requests and specific orders.</i> </p>
     * 
     * <p>Un-merged Business Name: RequestType</p>
     * 
     * <p>Relationship: REPC_MT500002CA.ActRequest.classCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Needed to know what query to execute to retrieve 
     * details about the request. (I.e. Get Patient Referral vs. 
     * Get Care Composition Order.)</i> </p>
     * 
     * <p>In the near term, the only way to request delivery of 
     * care is via a referral (PCPR). However, in the future, 
     * specific encounter sheduling messages may be defined. 
     * References to those new types of records would use ENC.</p>
     * 
     * <p> <i>This distinguishes between &quot;referral&quot; 
     * requests and specific orders.</i> </p>
     * 
     * <p>Un-merged Business Name: RequestType</p>
     * 
     * <p>Relationship: REPC_MT220002CA.ActRequest.classCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Needed to know what query to execute to retrieve 
     * details about the request. (I.e. Get Patient Referral vs. 
     * Get Discharge-Care Summary Order.)</i> </p>
     * 
     * <p> <i>This distinguishes between &quot;referral&quot; 
     * requests and specific orders.</i> </p>
     * 
     * <p>Un-merged Business Name: RequestType</p>
     * 
     * <p>Relationship: REPC_MT500001CA.ActRequest.classCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Needed to know what query to execute to retrieve 
     * details about the request. (I.e. Get Patient Referral vs. 
     * Get Care Composition Order.)</i> </p>
     * 
     * <p>In the near term, the only way to request delivery of 
     * care is via a referral (PCPR). However, in the future, 
     * specific encounter sheduling messages may be defined. 
     * References to those new types of records would use ENC.</p>
     * 
     * <p> <i>This distinguishes between &quot;referral&quot; 
     * requests and specific orders.</i> </p>
     * 
     * <p>Un-merged Business Name: RequestType</p>
     * 
     * <p>Relationship: REPC_MT220001CA.ActRequest.classCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Needed to know what query to execute to retrieve 
     * details about the request. (I.e. Get Patient Referral vs. 
     * Get Discharge-Care Summary Order.)</i> </p>
     * 
     * <p> <i>This distinguishes between &quot;referral&quot; 
     * requests and specific orders.</i> </p>
     */
    @Hl7XmlMapping({"classCode"})
    public x_ActClassCareProvisionEncounter getClassCode() {
        return (x_ActClassCareProvisionEncounter) this.classCode.getValue();
    }

    /**
     * <p>Business Name: RequestType</p>
     * 
     * <p>Un-merged Business Name: RequestType</p>
     * 
     * <p>Relationship: REPC_MT500003CA.ActRequest.classCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Needed to know what query to execute to retrieve 
     * details about the request. (I.e. Get Patient Referral vs. 
     * Get Care Composition Order.)</i> </p>
     * 
     * <p>In the near term, the only way to request delivery of 
     * care is via a referral (PCPR). However, in the future, 
     * specific encounter sheduling messages may be defined. 
     * References to those new types of records would use ENC.</p>
     * 
     * <p> <i>This distinguishes between &quot;referral&quot; 
     * requests and specific orders.</i> </p>
     * 
     * <p>Un-merged Business Name: RequestType</p>
     * 
     * <p>Relationship: REPC_MT220003CA.ActRequest.classCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Needed to know what query to execute to retrieve 
     * details about the request. (I.e. Get Patient Referral vs. 
     * Get Discharge-Care Summary Order.)</i> </p>
     * 
     * <p> <i>This distinguishes between &quot;referral&quot; 
     * requests and specific orders.</i> </p>
     * 
     * <p>Un-merged Business Name: RequestType</p>
     * 
     * <p>Relationship: REPC_MT500004CA.ActRequest.classCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Needed to know what query to execute to retrieve 
     * details about the request. (I.e. Get Patient Referral vs. 
     * Get Care Composition Order.)</i> </p>
     * 
     * <p>In the near term, the only way to request delivery of 
     * care is via a referral (PCPR). However, in the future, 
     * specific encounter sheduling messages may be defined. 
     * References to those new types of records would use ENC.</p>
     * 
     * <p> <i>This distinguishes between &quot;referral&quot; 
     * requests and specific orders.</i> </p>
     * 
     * <p>Un-merged Business Name: RequestType</p>
     * 
     * <p>Relationship: REPC_MT000083CA.ActRequest.classCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Needed to know what query to execute to retrieve 
     * details about the request. (I.e. Get Patient Referral vs. 
     * Get Discharge-Care Summary Order.)</i> </p>
     * 
     * <p> <i>This distinguishes between &quot;referral&quot; 
     * requests and specific orders.</i> </p>
     * 
     * <p>Un-merged Business Name: RequestType</p>
     * 
     * <p>Relationship: REPC_MT500002CA.ActRequest.classCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Needed to know what query to execute to retrieve 
     * details about the request. (I.e. Get Patient Referral vs. 
     * Get Care Composition Order.)</i> </p>
     * 
     * <p>In the near term, the only way to request delivery of 
     * care is via a referral (PCPR). However, in the future, 
     * specific encounter sheduling messages may be defined. 
     * References to those new types of records would use ENC.</p>
     * 
     * <p> <i>This distinguishes between &quot;referral&quot; 
     * requests and specific orders.</i> </p>
     * 
     * <p>Un-merged Business Name: RequestType</p>
     * 
     * <p>Relationship: REPC_MT220002CA.ActRequest.classCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Needed to know what query to execute to retrieve 
     * details about the request. (I.e. Get Patient Referral vs. 
     * Get Discharge-Care Summary Order.)</i> </p>
     * 
     * <p> <i>This distinguishes between &quot;referral&quot; 
     * requests and specific orders.</i> </p>
     * 
     * <p>Un-merged Business Name: RequestType</p>
     * 
     * <p>Relationship: REPC_MT500001CA.ActRequest.classCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Needed to know what query to execute to retrieve 
     * details about the request. (I.e. Get Patient Referral vs. 
     * Get Care Composition Order.)</i> </p>
     * 
     * <p>In the near term, the only way to request delivery of 
     * care is via a referral (PCPR). However, in the future, 
     * specific encounter sheduling messages may be defined. 
     * References to those new types of records would use ENC.</p>
     * 
     * <p> <i>This distinguishes between &quot;referral&quot; 
     * requests and specific orders.</i> </p>
     * 
     * <p>Un-merged Business Name: RequestType</p>
     * 
     * <p>Relationship: REPC_MT220001CA.ActRequest.classCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Needed to know what query to execute to retrieve 
     * details about the request. (I.e. Get Patient Referral vs. 
     * Get Discharge-Care Summary Order.)</i> </p>
     * 
     * <p> <i>This distinguishes between &quot;referral&quot; 
     * requests and specific orders.</i> </p>
     */
    public void setClassCode(x_ActClassCareProvisionEncounter classCode) {
        this.classCode.setValue(classCode);
    }


    /**
     * <p>Business Name: RequestId</p>
     * 
     * <p>Un-merged Business Name: RequestId</p>
     * 
     * <p>Relationship: REPC_MT500003CA.ActRequest.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p> <i>Associates a request to its results. Allows querying 
     * for results associated by a request. Also, authors of 
     * requests are generally authorized to view associated 
     * results, even if masked. Result records may also be 
     * automatically retrieved when retrieving the request 
     * record.</i> </p><p> <i>This attributes is only 
     * &quot;required&quot; because in some cases there might not 
     * be a formal electronic request. However, the requesting 
     * provider may still be known.</i> </p>
     * 
     * <p> <i>This identifies the specific request record (referral 
     * or order) that this Care Composition is fulfilling. The type 
     * of request is identified by the Request Type.</i> </p>
     * 
     * <p>Un-merged Business Name: RequestId</p>
     * 
     * <p>Relationship: REPC_MT220003CA.ActRequest.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p> <i>Associates a request to its results. Allows querying 
     * for results associated by a request. Also, authors of 
     * requests are generally authorized to view associated 
     * results, even if masked. Result records may also be 
     * automatically retrieved when retrieving the request 
     * record.</i> </p><p> <i>This attributes is only 
     * &quot;required&quot; because in some cases there might not 
     * be a formal electronic request. However, the requesting 
     * provider may still be known.</i> </p>
     * 
     * <p> <i>This identifies the specific request record (referral 
     * or order) that this Discharge-Care Summary is fulfilling. 
     * The type of request is identified by the Request Type.</i> 
     * </p>
     * 
     * <p>Un-merged Business Name: RequestId</p>
     * 
     * <p>Relationship: REPC_MT500004CA.ActRequest.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p> <i>Associates a request to its results. Allows querying 
     * for results associated by a request. Also, authors of 
     * requests are generally authorized to view associated 
     * results, even if masked. Result records may also be 
     * automatically retrieved when retrieving the request 
     * record.</i> </p><p> <i>This attributes is only 
     * &quot;required&quot; because in some cases there might not 
     * be a formal electronic request. However, the requesting 
     * provider may still be known.</i> </p>
     * 
     * <p> <i>This identifies the specific request record (referral 
     * or order) that this Care Composition is fulfilling. The type 
     * of request is identified by the Request Type.</i> </p>
     * 
     * <p>Un-merged Business Name: RequestId</p>
     * 
     * <p>Relationship: REPC_MT000083CA.ActRequest.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p> <i>Associates a request to its results. Allows querying 
     * for results associated by a request. Also, authors of 
     * requests are generally authorized to view associated 
     * results, even if masked. Result records may also be 
     * automatically retrieved when retrieving the request 
     * record.</i> </p><p> <i>This attributes is only 
     * &quot;required&quot; because in some cases there might not 
     * be a formal electronic request. However, the requesting 
     * provider may still be known.</i> </p>
     * 
     * <p> <i>This identifies the specific request record (referral 
     * or order) that this Discharge-Care Summary is fulfilling. 
     * The type of request is identified by the Request Type.</i> 
     * </p>
     * 
     * <p>Un-merged Business Name: RequestId</p>
     * 
     * <p>Relationship: REPC_MT500002CA.ActRequest.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p> <i>Associates a request to its results. Allows querying 
     * for results associated by a request. Also, authors of 
     * requests are generally authorized to view associated 
     * results, even if masked. Result records may also be 
     * automatically retrieved when retrieving the request 
     * record.</i> </p><p> <i>This attributes is only 
     * &quot;required&quot; because in some cases there might not 
     * be a formal electronic request. However, the requesting 
     * provider may still be known.</i> </p>
     * 
     * <p> <i>This identifies the specific request record (referral 
     * or order) that this Care Composition is fulfilling. The type 
     * of request is identified by the Request Type.</i> </p>
     * 
     * <p>Un-merged Business Name: RequestId</p>
     * 
     * <p>Relationship: REPC_MT220002CA.ActRequest.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p> <i>Associates a request to its results. Allows querying 
     * for results associated by a request. Also, authors of 
     * requests are generally authorized to view associated 
     * results, even if masked. Result records may also be 
     * automatically retrieved when retrieving the request 
     * record.</i> </p><p> <i>This attributes is only 
     * &quot;required&quot; because in some cases there might not 
     * be a formal electronic request. However, the requesting 
     * provider may still be known.</i> </p>
     * 
     * <p> <i>This identifies the specific request record (referral 
     * or order) that this Discharge-Care Summary is fulfilling. 
     * The type of request is identified by the Request Type.</i> 
     * </p>
     * 
     * <p>Un-merged Business Name: RequestId</p>
     * 
     * <p>Relationship: REPC_MT500001CA.ActRequest.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p> <i>Associates a request to its results. Allows querying 
     * for results associated by a request. Also, authors of 
     * requests are generally authorized to view associated 
     * results, even if masked. Result records may also be 
     * automatically retrieved when retrieving the request 
     * record.</i> </p><p> <i>This attributes is only 
     * &quot;required&quot; because in some cases there might not 
     * be a formal electronic request. However, the requesting 
     * provider may still be known.</i> </p>
     * 
     * <p> <i>This identifies the specific request record (referral 
     * or order) that this Care Composition is fulfilling. The type 
     * of request is identified by the Request Type.</i> </p>
     * 
     * <p>Un-merged Business Name: RequestId</p>
     * 
     * <p>Relationship: REPC_MT220001CA.ActRequest.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p> <i>Associates a request to its results. Allows querying 
     * for results associated by a request. Also, authors of 
     * requests are generally authorized to view associated 
     * results, even if masked. Result records may also be 
     * automatically retrieved when retrieving the request 
     * record.</i> </p><p> <i>This attributes is only 
     * &quot;required&quot; because in some cases there might not 
     * be a formal electronic request. However, the requesting 
     * provider may still be known.</i> </p>
     * 
     * <p> <i>This identifies the specific request record (referral 
     * or order) that this Discharge-Care Summary is fulfilling. 
     * The type of request is identified by the Request Type.</i> 
     * </p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: RequestId</p>
     * 
     * <p>Un-merged Business Name: RequestId</p>
     * 
     * <p>Relationship: REPC_MT500003CA.ActRequest.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p> <i>Associates a request to its results. Allows querying 
     * for results associated by a request. Also, authors of 
     * requests are generally authorized to view associated 
     * results, even if masked. Result records may also be 
     * automatically retrieved when retrieving the request 
     * record.</i> </p><p> <i>This attributes is only 
     * &quot;required&quot; because in some cases there might not 
     * be a formal electronic request. However, the requesting 
     * provider may still be known.</i> </p>
     * 
     * <p> <i>This identifies the specific request record (referral 
     * or order) that this Care Composition is fulfilling. The type 
     * of request is identified by the Request Type.</i> </p>
     * 
     * <p>Un-merged Business Name: RequestId</p>
     * 
     * <p>Relationship: REPC_MT220003CA.ActRequest.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p> <i>Associates a request to its results. Allows querying 
     * for results associated by a request. Also, authors of 
     * requests are generally authorized to view associated 
     * results, even if masked. Result records may also be 
     * automatically retrieved when retrieving the request 
     * record.</i> </p><p> <i>This attributes is only 
     * &quot;required&quot; because in some cases there might not 
     * be a formal electronic request. However, the requesting 
     * provider may still be known.</i> </p>
     * 
     * <p> <i>This identifies the specific request record (referral 
     * or order) that this Discharge-Care Summary is fulfilling. 
     * The type of request is identified by the Request Type.</i> 
     * </p>
     * 
     * <p>Un-merged Business Name: RequestId</p>
     * 
     * <p>Relationship: REPC_MT500004CA.ActRequest.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p> <i>Associates a request to its results. Allows querying 
     * for results associated by a request. Also, authors of 
     * requests are generally authorized to view associated 
     * results, even if masked. Result records may also be 
     * automatically retrieved when retrieving the request 
     * record.</i> </p><p> <i>This attributes is only 
     * &quot;required&quot; because in some cases there might not 
     * be a formal electronic request. However, the requesting 
     * provider may still be known.</i> </p>
     * 
     * <p> <i>This identifies the specific request record (referral 
     * or order) that this Care Composition is fulfilling. The type 
     * of request is identified by the Request Type.</i> </p>
     * 
     * <p>Un-merged Business Name: RequestId</p>
     * 
     * <p>Relationship: REPC_MT000083CA.ActRequest.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p> <i>Associates a request to its results. Allows querying 
     * for results associated by a request. Also, authors of 
     * requests are generally authorized to view associated 
     * results, even if masked. Result records may also be 
     * automatically retrieved when retrieving the request 
     * record.</i> </p><p> <i>This attributes is only 
     * &quot;required&quot; because in some cases there might not 
     * be a formal electronic request. However, the requesting 
     * provider may still be known.</i> </p>
     * 
     * <p> <i>This identifies the specific request record (referral 
     * or order) that this Discharge-Care Summary is fulfilling. 
     * The type of request is identified by the Request Type.</i> 
     * </p>
     * 
     * <p>Un-merged Business Name: RequestId</p>
     * 
     * <p>Relationship: REPC_MT500002CA.ActRequest.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p> <i>Associates a request to its results. Allows querying 
     * for results associated by a request. Also, authors of 
     * requests are generally authorized to view associated 
     * results, even if masked. Result records may also be 
     * automatically retrieved when retrieving the request 
     * record.</i> </p><p> <i>This attributes is only 
     * &quot;required&quot; because in some cases there might not 
     * be a formal electronic request. However, the requesting 
     * provider may still be known.</i> </p>
     * 
     * <p> <i>This identifies the specific request record (referral 
     * or order) that this Care Composition is fulfilling. The type 
     * of request is identified by the Request Type.</i> </p>
     * 
     * <p>Un-merged Business Name: RequestId</p>
     * 
     * <p>Relationship: REPC_MT220002CA.ActRequest.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p> <i>Associates a request to its results. Allows querying 
     * for results associated by a request. Also, authors of 
     * requests are generally authorized to view associated 
     * results, even if masked. Result records may also be 
     * automatically retrieved when retrieving the request 
     * record.</i> </p><p> <i>This attributes is only 
     * &quot;required&quot; because in some cases there might not 
     * be a formal electronic request. However, the requesting 
     * provider may still be known.</i> </p>
     * 
     * <p> <i>This identifies the specific request record (referral 
     * or order) that this Discharge-Care Summary is fulfilling. 
     * The type of request is identified by the Request Type.</i> 
     * </p>
     * 
     * <p>Un-merged Business Name: RequestId</p>
     * 
     * <p>Relationship: REPC_MT500001CA.ActRequest.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p> <i>Associates a request to its results. Allows querying 
     * for results associated by a request. Also, authors of 
     * requests are generally authorized to view associated 
     * results, even if masked. Result records may also be 
     * automatically retrieved when retrieving the request 
     * record.</i> </p><p> <i>This attributes is only 
     * &quot;required&quot; because in some cases there might not 
     * be a formal electronic request. However, the requesting 
     * provider may still be known.</i> </p>
     * 
     * <p> <i>This identifies the specific request record (referral 
     * or order) that this Care Composition is fulfilling. The type 
     * of request is identified by the Request Type.</i> </p>
     * 
     * <p>Un-merged Business Name: RequestId</p>
     * 
     * <p>Relationship: REPC_MT220001CA.ActRequest.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p> <i>Associates a request to its results. Allows querying 
     * for results associated by a request. Also, authors of 
     * requests are generally authorized to view associated 
     * results, even if masked. Result records may also be 
     * automatically retrieved when retrieving the request 
     * record.</i> </p><p> <i>This attributes is only 
     * &quot;required&quot; because in some cases there might not 
     * be a formal electronic request. However, the requesting 
     * provider may still be known.</i> </p>
     * 
     * <p> <i>This identifies the specific request record (referral 
     * or order) that this Discharge-Care Summary is fulfilling. 
     * The type of request is identified by the Request Type.</i> 
     * </p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT500003CA.ActRequest.author</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT220003CA.ActRequest.author</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT500004CA.ActRequest.author</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000083CA.ActRequest.author</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT500002CA.ActRequest.author</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT220002CA.ActRequest.author</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT500001CA.ActRequest.author</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT220001CA.ActRequest.author</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"author"})
    public RequestedByBean getAuthor() {
        return this.author;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT500003CA.ActRequest.author</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT220003CA.ActRequest.author</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT500004CA.ActRequest.author</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000083CA.ActRequest.author</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT500002CA.ActRequest.author</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT220002CA.ActRequest.author</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT500001CA.ActRequest.author</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT220001CA.ActRequest.author</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setAuthor(RequestedByBean author) {
        this.author = author;
    }

}
