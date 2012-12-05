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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.iehr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.x_ActClassCareProvisionProcedure;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: Request</p>
 * 
 * <p>REPC_MT610002CA.ActRequest: A:Request</p>
 * 
 * <p> <i>By requesting the action, a provider takes a level of 
 * responsibility for it. Also, a link between request and 
 * fulfilling record may result in differences in query 
 * responses. For example retrieving a request may also result 
 * in retrieval of fulfilling records. Requesting providers 
 * generally have authorization to view masked information as 
 * well.</i> </p>
 * 
 * <p> <i>This ties the record to the request (referral or 
 * specific request) that resulted in the creation of the 
 * Professional Service record.</i> </p>
 * 
 * <p>REPC_MT610001CA.ActRequest: A:Request</p>
 * 
 * <p> <i>By requesting the action, a provider takes a level of 
 * responsibility for it. Also, a link between request and 
 * fulfilling record may result in differences in query 
 * responses. For example retrieving a request may also result 
 * in retrieval of fulfilling records. Requesting providers 
 * generally have authorization to view masked information as 
 * well.</i> </p>
 * 
 * <p> <i>This ties the record to the request (referral or 
 * specific request) that resulted in the creation of the 
 * Professional Service record.</i> </p>
 */
@Hl7PartTypeMapping({"REPC_MT610001CA.ActRequest","REPC_MT610002CA.ActRequest"})
public class Request_3Bean extends MessagePartBean {

    private static final long serialVersionUID = 20121204L;
    private CS classCode = new CSImpl();
    private II id = new IIImpl();
    private RequestedByBean author;


    /**
     * <p>Business Name: RequestType</p>
     * 
     * <p>Un-merged Business Name: RequestType</p>
     * 
     * <p>Relationship: REPC_MT610002CA.ActRequest.classCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Needed to know what query to execute to retrieve 
     * details about the request. (I.e. Get Patient Referral vs. 
     * Get Professional Service Order.)</i> </p>
     * 
     * <p> <i>This distinguishes between &quot;referral&quot; 
     * requests and specific orders.</i> </p>
     * 
     * <p>Un-merged Business Name: RequestType</p>
     * 
     * <p>Relationship: REPC_MT610001CA.ActRequest.classCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Needed to know what query to execute to retrieve 
     * details about the request. (I.e. Get Patient Referral vs. 
     * Get Professional Service Order.)</i> </p>
     * 
     * <p> <i>This distinguishes between &quot;referral&quot; 
     * requests and specific orders.</i> </p>
     */
    @Hl7XmlMapping({"classCode"})
    public x_ActClassCareProvisionProcedure getClassCode() {
        return (x_ActClassCareProvisionProcedure) this.classCode.getValue();
    }

    /**
     * <p>Business Name: RequestType</p>
     * 
     * <p>Un-merged Business Name: RequestType</p>
     * 
     * <p>Relationship: REPC_MT610002CA.ActRequest.classCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Needed to know what query to execute to retrieve 
     * details about the request. (I.e. Get Patient Referral vs. 
     * Get Professional Service Order.)</i> </p>
     * 
     * <p> <i>This distinguishes between &quot;referral&quot; 
     * requests and specific orders.</i> </p>
     * 
     * <p>Un-merged Business Name: RequestType</p>
     * 
     * <p>Relationship: REPC_MT610001CA.ActRequest.classCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Needed to know what query to execute to retrieve 
     * details about the request. (I.e. Get Patient Referral vs. 
     * Get Professional Service Order.)</i> </p>
     * 
     * <p> <i>This distinguishes between &quot;referral&quot; 
     * requests and specific orders.</i> </p>
     */
    public void setClassCode(x_ActClassCareProvisionProcedure classCode) {
        this.classCode.setValue(classCode);
    }


    /**
     * <p>Business Name: RequestId</p>
     * 
     * <p>Un-merged Business Name: RequestId</p>
     * 
     * <p>Relationship: REPC_MT610002CA.ActRequest.id</p>
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
     * or order) that this Professional Service is fulfilling. The 
     * type of request is identified by the Request Type.</i> </p>
     * 
     * <p>Un-merged Business Name: RequestId</p>
     * 
     * <p>Relationship: REPC_MT610001CA.ActRequest.id</p>
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
     * or order) that this Professional Service is fulfilling. The 
     * type of request is identified by the Request Type.</i> </p>
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
     * <p>Relationship: REPC_MT610002CA.ActRequest.id</p>
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
     * or order) that this Professional Service is fulfilling. The 
     * type of request is identified by the Request Type.</i> </p>
     * 
     * <p>Un-merged Business Name: RequestId</p>
     * 
     * <p>Relationship: REPC_MT610001CA.ActRequest.id</p>
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
     * or order) that this Professional Service is fulfilling. The 
     * type of request is identified by the Request Type.</i> </p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT610002CA.ActRequest.author</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT610001CA.ActRequest.author</p>
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
     * <p>Relationship: REPC_MT610002CA.ActRequest.author</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT610001CA.ActRequest.author</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setAuthor(RequestedByBean author) {
        this.author = author;
    }

}
