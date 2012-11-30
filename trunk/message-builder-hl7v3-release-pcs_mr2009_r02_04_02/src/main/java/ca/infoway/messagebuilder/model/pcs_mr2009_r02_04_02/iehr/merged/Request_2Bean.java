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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.iehr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.x_ActClassCareProvisionObservation;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Request</p>
 * 
 * <p>REPC_MT230003CA.ActRequest: Request</p>
 * 
 * <p> <i>A particular request (referral or specific request) 
 * that resulted in the creation of the Clinical Observation 
 * Document.</i> </p>
 * 
 * <p> <i>There are several pieces of information about a 
 * request that may influence understanding of the record 
 * including when requested, by whom, why, etc.</i> </p>
 * 
 * <p>REPC_MT230001CA.ActRequest: Request</p>
 * 
 * <p> <i>A particular request (referral or specific request) 
 * that resulted in the creation of the Clinical Observation 
 * Document.</i> </p>
 * 
 * <p> <i>There are several pieces of information about a 
 * request that may influence understanding of the record 
 * including when requested, by whom, why, etc.</i> </p>
 * 
 * <p>REPC_MT410001CA.ActRequest: Request</p>
 * 
 * <p> <i>A particular request (referral or specific request) 
 * that resulted in the creation of the Measured 
 * Observation.</i> </p>
 * 
 * <p> <i>There are several pieces of information about a 
 * request that may influence understanding of the record 
 * including when requested, by whom, why, etc.</i> </p>
 * 
 * <p>REPC_MT420001CA.ActRequest: Request</p>
 * 
 * <p> <i>A particular request (referral or specific request) 
 * that resulted in the creation of the Coded Observation.</i> 
 * </p>
 * 
 * <p> <i>There are several pieces of information about a 
 * request that may influence understanding of the record 
 * including when requested, by whom, why, etc.</i> </p>
 * 
 * <p>REPC_MT230002CA.ActRequest: Request</p>
 * 
 * <p> <i>A particular request (referral or specific request) 
 * that resulted in the creation of the Clinical Observation 
 * Document.</i> </p>
 * 
 * <p> <i>There are several pieces of information about a 
 * request that may influence understanding of the record 
 * including when requested, by whom, why, etc.</i> </p>
 * 
 * <p>REPC_MT420003CA.ActRequest: Request</p>
 * 
 * <p> <i>A particular request (referral or specific request) 
 * that resulted in the creation of the Coded Observation.</i> 
 * </p>
 * 
 * <p> <i>There are several pieces of information about a 
 * request that may influence understanding of the record 
 * including when requested, by whom, why, etc.</i> </p>
 */
@Hl7PartTypeMapping({"REPC_MT230001CA.ActRequest","REPC_MT230002CA.ActRequest","REPC_MT230003CA.ActRequest","REPC_MT410001CA.ActRequest","REPC_MT410003CA.ActRequest","REPC_MT420001CA.ActRequest","REPC_MT420003CA.ActRequest"})
public class Request_2Bean extends MessagePartBean {

    private static final long serialVersionUID = 20121122L;
    private CS classCode = new CSImpl();
    private II id = new IIImpl();
    private RequestedByBean author;


    /**
     * <p>RequestType</p>
     * 
     * <p>Request Type</p>
     * 
     * <p>Request Type</p>
     * 
     * <p> <i>This distinguishes between &quot;referral&quot; 
     * requests and specific orders.</i> </p>
     * 
     * <p> <i>Needed to know what query to execute to retrieve 
     * details about the request. (I.e. Get Patient Referral vs. 
     * Get Measured Observation Order.)</i> </p>
     * 
     * <p>B: Request Type</p>
     * 
     * <p> <i>This distinguishes between &quot;referral&quot; 
     * requests and specific orders.</i> </p>
     * 
     * <p> <i>Needed to know what query to execute to retrieve 
     * details about the request. (I.e. Get Patient Referral vs. 
     * Get Clinical Observation Document Order.)</i> </p>
     * 
     * <p>Request Type</p>
     * 
     * <p> <i>This distinguishes between &quot;referral&quot; 
     * requests and specific orders.</i> </p>
     * 
     * <p> <i>Needed to know what query to execute to retrieve 
     * details about the request. (I.e. Get Patient Referral vs. 
     * Get Coded Observation Order.)</i> </p>
     */
    @Hl7XmlMapping({"classCode"})
    public x_ActClassCareProvisionObservation getClassCode() {
        return (x_ActClassCareProvisionObservation) this.classCode.getValue();
    }

    /**
     * <p>RequestType</p>
     * 
     * <p>Request Type</p>
     * 
     * <p>Request Type</p>
     * 
     * <p> <i>This distinguishes between &quot;referral&quot; 
     * requests and specific orders.</i> </p>
     * 
     * <p> <i>Needed to know what query to execute to retrieve 
     * details about the request. (I.e. Get Patient Referral vs. 
     * Get Measured Observation Order.)</i> </p>
     * 
     * <p>B: Request Type</p>
     * 
     * <p> <i>This distinguishes between &quot;referral&quot; 
     * requests and specific orders.</i> </p>
     * 
     * <p> <i>Needed to know what query to execute to retrieve 
     * details about the request. (I.e. Get Patient Referral vs. 
     * Get Clinical Observation Document Order.)</i> </p>
     * 
     * <p>Request Type</p>
     * 
     * <p> <i>This distinguishes between &quot;referral&quot; 
     * requests and specific orders.</i> </p>
     * 
     * <p> <i>Needed to know what query to execute to retrieve 
     * details about the request. (I.e. Get Patient Referral vs. 
     * Get Coded Observation Order.)</i> </p>
     */
    public void setClassCode(x_ActClassCareProvisionObservation classCode) {
        this.classCode.setValue(classCode);
    }


    /**
     * <p>RequestId</p>
     * 
     * <p>Request Id</p>
     * 
     * <p>Request Id</p>
     * 
     * <p> <i>This identifies the specific request record (referral 
     * or order) that this Coded Observation is fulfilling. The 
     * type of request is identified by the Request Type.</i> </p>
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
     * <p>A: Request Id</p>
     * 
     * <p> <i>This identifies the specific request record (referral 
     * or order) that this Clinical Observation Document is 
     * fulfilling. The type of request is identified by the Request 
     * Type.</i> </p>
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
     * <p>Request Id</p>
     * 
     * <p> <i>This identifies the specific request record (referral 
     * or order) that this Measured Observation is fulfilling. The 
     * type of request is identified by the Request Type.</i> </p>
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
     * <p> <i>Associates a request to its results. Allows querying 
     * for results associated by a request. Also, authors of 
     * requests are generally authorized to view associated 
     * results, even if masked. Result records may also be 
     * automatically retrieved when retrieving the request 
     * record.</i> </p><p> <i>This attributes is only 
     * &quot;required&quot; because in some cases there might not 
     * be a formal electronic request. However, the requesting 
     * provider may still be known.</i> </p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>RequestId</p>
     * 
     * <p>Request Id</p>
     * 
     * <p>Request Id</p>
     * 
     * <p> <i>This identifies the specific request record (referral 
     * or order) that this Coded Observation is fulfilling. The 
     * type of request is identified by the Request Type.</i> </p>
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
     * <p>A: Request Id</p>
     * 
     * <p> <i>This identifies the specific request record (referral 
     * or order) that this Clinical Observation Document is 
     * fulfilling. The type of request is identified by the Request 
     * Type.</i> </p>
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
     * <p>Request Id</p>
     * 
     * <p> <i>This identifies the specific request record (referral 
     * or order) that this Measured Observation is fulfilling. The 
     * type of request is identified by the Request Type.</i> </p>
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
     * <p> <i>Associates a request to its results. Allows querying 
     * for results associated by a request. Also, authors of 
     * requests are generally authorized to view associated 
     * results, even if masked. Result records may also be 
     * automatically retrieved when retrieving the request 
     * record.</i> </p><p> <i>This attributes is only 
     * &quot;required&quot; because in some cases there might not 
     * be a formal electronic request. However, the requesting 
     * provider may still be known.</i> </p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    @Hl7XmlMapping({"author"})
    public RequestedByBean getAuthor() {
        return this.author;
    }

    public void setAuthor(RequestedByBean author) {
        this.author = author;
    }

}
