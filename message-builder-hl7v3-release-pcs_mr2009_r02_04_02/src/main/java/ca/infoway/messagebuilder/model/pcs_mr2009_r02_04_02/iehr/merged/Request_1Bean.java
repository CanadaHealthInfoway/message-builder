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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.iehr.merged;

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
 * <p>Request</p>
 * 
 * <p>REPC_MT220003CA.ActRequest: Request</p>
 * 
 * <p></p></p>
 * 
 * <p></p></p>
 * 
 * <p>REPC_MT500003CA.ActRequest: Request</p>
 * 
 * <p><p>Must have at least one of Request Id and Requesting 
 * Provider</p><p>Request Type is mandatory when Request Id is 
 * present</p></p>
 * 
 * <p><p>Must have at least one of Request Id and Requesting 
 * Provider</p><p>Request Type is mandatory when Request Id is 
 * present</p></p>
 * 
 * <p></p></p>
 * 
 * <p></p></p>
 * 
 * <p>REPC_MT500004CA.ActRequest: Request</p>
 * 
 * <p><p>Must have at least one of Request Id and Requesting 
 * Provider</p><p>Request Type is mandatory when Request Id is 
 * present</p></p>
 * 
 * <p><p>Must have at least one of Request Id and Requesting 
 * Provider</p><p>Request Type is mandatory when Request Id is 
 * present</p></p>
 * 
 * <p></p></p>
 * 
 * <p></p></p>
 * 
 * <p>REPC_MT500002CA.ActRequest: Request</p>
 * 
 * <p><p>Must have at least one of Request Id and Requesting 
 * Provider</p><p>Request Type is mandatory when Request Id is 
 * present</p></p>
 * 
 * <p><p>Must have at least one of Request Id and Requesting 
 * Provider</p><p>Request Type is mandatory when Request Id is 
 * present</p></p>
 * 
 * <p></p></p>
 * 
 * <p></p></p>
 * 
 * <p>REPC_MT220002CA.ActRequest: Request</p>
 * 
 * <p></p></p>
 * 
 * <p></p></p>
 * 
 * <p>REPC_MT220001CA.ActRequest: Request</p>
 * 
 * <p></p></p>
 * 
 * <p></p></p>
 * 
 * <p>REPC_MT500001CA.ActRequest: Request</p>
 * 
 * <p><p>Must have at least one of Request Id and Requesting 
 * Provider</p><p>Request Type is mandatory when Request Id is 
 * present</p></p>
 * 
 * <p><p>Must have at least one of Request Id and Requesting 
 * Provider</p><p>Request Type is mandatory when Request Id is 
 * present</p></p>
 * 
 * <p></p></p>
 * 
 * <p></p></p>
 */
@Hl7PartTypeMapping({"REPC_MT220001CA.ActRequest","REPC_MT220002CA.ActRequest","REPC_MT220003CA.ActRequest","REPC_MT500001CA.ActRequest","REPC_MT500002CA.ActRequest","REPC_MT500003CA.ActRequest","REPC_MT500004CA.ActRequest"})
public class Request_1Bean extends MessagePartBean {

    private static final long serialVersionUID = 20110906L;
    private CS requestType = new CSImpl();
    private II requestId = new IIImpl();
    private RequestedByBean author;


    /**
     * <p>RequestType</p>
     * 
     * <p>Request Type</p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     * 
     * <p><p>In the near term, the only way to request delivery of 
     * care is via a referral (PCPR). However, in the future, 
     * specific encounter scheduling messages may be defined. 
     * References to those new types of records would use ENC.</p></p>
     * 
     * <p>B: Request Type</p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     */
    @Hl7XmlMapping({"classCode"})
    public x_ActClassCareProvisionEncounter getRequestType() {
        return (x_ActClassCareProvisionEncounter) this.requestType.getValue();
    }
    public void setRequestType(x_ActClassCareProvisionEncounter requestType) {
        this.requestType.setValue(requestType);
    }


    /**
     * <p>RequestId</p>
     * 
     * <p>A:Request id</p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     * 
     * <p>Request Id</p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getRequestId() {
        return this.requestId.getValue();
    }
    public void setRequestId(Identifier requestId) {
        this.requestId.setValue(requestId);
    }


    @Hl7XmlMapping({"author"})
    public RequestedByBean getAuthor() {
        return this.author;
    }
    public void setAuthor(RequestedByBean author) {
        this.author = author;
    }

}
